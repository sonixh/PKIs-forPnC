package kr.ac.hmcl.mju.Cps_2_RA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import risev2gClass.MiscUtils;

class ServerThread extends Thread {
	TCPServer server;
	SecUtils sUtils;

	public ServerThread() {
		server = new TCPServer();
		sUtils = new SecUtils();
	}

	public void run() {

		try {
			System.out.println("server thread start");
			server.serverRun(21004);
			MiscUtils.setV2gEntityConfig("./CPSConfig.properties");
			while (true) {
				byte[] getData = server.receivePacket();
				if (getData != null) {
					String type = sUtils.checkMsgType(getData);
					System.out.println("Msg Type Is " + type);
					if (type.equals("FinishConnection")) {
						byte[] sendData = sUtils.makeFinishConnectionMsg();
						server.sendPacket(sendData);
						server.stopServer();
						server.serverRun(21004);
						System.out.println("finish the connection");
						System.out.println(
								"cps-2 RA=========================================================================================================");
						System.out.println(
								"1. request to get V2G-2 root Certificate\n2. request CPS-2 leaf certificate\n3. request to get Mo root Certificate");
					} else if (type.equals("ContractData")) {
						// check MO ContractCertificate chain validation
						boolean isContractCertValid = sUtils.checkContractData(getData, Main.getMoRootCertName());
						System.out.println("Mo Contract Certificate is :" + isContractCertValid);
						// generate CertificateInstallationRes message
						byte[] certificateInstallationResBytes = null;
						byte[] crossCertificateInstallationResBytes = null;
						if (isContractCertValid) {
							System.out.println("try to make CertificateInstallationRes");
							certificateInstallationResBytes = sUtils.makeCertificateInstallationResMsg(getData,
									Main.getLeafCertList(0));
							System.out.println("CertificateInstallationResBytes size is "
									+ certificateInstallationResBytes.length);
							crossCertificateInstallationResBytes = sUtils.makeCrossCertificateInstallationResMsg(getData, Main.getLeafCertList(0), Main.getCrossRootCertName());
							System.out.println("crossCertificateInstallationResBytes size is "
									+ crossCertificateInstallationResBytes.length);
						}
						// keep the pair(PCID, CertInstRes) in file
						String pcid = sUtils.getPcidFromContractData(getData);
						Main.getCertInstResHashMap().put(pcid, certificateInstallationResBytes);
						Main.getCrossCertInstResHashMap().put(pcid, crossCertificateInstallationResBytes);
						// said "SuccessToGetContractData" to MO
						byte[] sendData = sUtils.makeSuccessToGetContractDataMsg();
						server.sendPacket(sendData);
						System.out.println("try to finish with MO RA");
					} else if (type.equals("ReqToCertInstRes")) {
						System.out.println("get Req to send CertInstRes from SECC");
						//-- get PCID from "ReqToCertInstRes" msg
						String pcid = sUtils.getPcidFromReqToCertInstRes(getData);
						System.out.println("PCID is : " + pcid);
						TCPClient client = new TCPClient();
						//connect with OEMRA
						client.clientRun(2004);
						boolean isConnected = true;
						//request oem prov cert with pcid
						byte[] sendData = sUtils.makeReqToGetOEMProvCertMsg(pcid);
						client.sendPacket(sendData);
						System.out.println("send request to OEM RA");
						while (isConnected) {
							byte[] getDataFromServer = client.receivePacket();
							if (getDataFromServer != null) {
								type = sUtils.checkMsgType(getDataFromServer);
								System.out.println("MSG type is :" + type);
								if (type.equals("ResWithCert")) {
									// save cert in pem file
									List<String> saveCertList = sUtils.saveCertFromMsg(getDataFromServer);
									// saveCertList(0) : oem prov CertName, saveCertList(1) : subCA2CertName,
									// saveCertList(2) : subCA1CertName
									Main.getProvCertList().add(new ProvCertData(pcid, saveCertList.get(0),
											saveCertList.get(1), saveCertList.get(2), Main.getOemRootCertName()));
									System.out.println("save cert in pem file");
									// finish connection
									sendData = sUtils.makeFinishConnectionMsg();
									client.sendPacket(sendData);
								} else if (type.equals("FinishConnection")) {
									client.clientStop();
									isConnected = false;
									System.out.println("finish connection with oem RA");
								}
							}
						}
						//--check OEM Prov Cert is valid
						boolean isOemProvCertValid = sUtils.CheckOemProvCertChainValidity(Main.getProvCertList().get(0), Main.getOemRootCertName());
						System.out.println("OEM Contract Certificate is :" + isOemProvCertValid);
						if(isOemProvCertValid) {
							//-- find matched v2gMessage
							byte[] v2gMessageBytes = Main.getCrossCertInstResHashMap().get(pcid);
							//-- send message to EVSE
							sendData = sUtils.makeResToCertInstRes(v2gMessageBytes);
							System.out.println("success to send ResToCertInstRes MSG");
						}else {
							sendData= null;
						}
						
						server.sendPacket(sendData);
					}
				}
			}
		} catch (Exception e) {
		}

	}
}

public class Main {
	private static String moRootCertName;
	private static String oemRootCertName;
	private static String crossRootCertName;
	private static List<CertData> leafCertList = new ArrayList<CertData>();
	private static List<ProvCertData> provCertList = new ArrayList<ProvCertData>();
	private static HashMap<String, byte[]> certInstResHashMap = new HashMap<String, byte[]>();
	private static HashMap<String, byte[]> crossCertInstResHashMap = new HashMap<String, byte[]>();
	
	public static String getMoRootCertName() {
		return moRootCertName;
	}
	public static String getOemRootCertName() {
		return oemRootCertName;
	}
	public static String getCrossRootCertName() {
		return crossRootCertName;
	}

	public static CertData getLeafCertList(int index) {
		return leafCertList.get(index);
	}

	

	public static HashMap<String, byte[]> getCertInstResHashMap() {
		return certInstResHashMap;
	}

	public static void setCertInstResHashMap(HashMap<String, byte[]> cpsHashMap) {
		Main.certInstResHashMap = cpsHashMap;
	}

	public static HashMap<String, byte[]> getCrossCertInstResHashMap() {
		return crossCertInstResHashMap;
	}
	public static void setCrossCertInstResHashMap(HashMap<String, byte[]> crossCertInstResHashMap) {
		Main.crossCertInstResHashMap = crossCertInstResHashMap;
	}
	public static List<ProvCertData> getProvCertList() {
		return provCertList;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SecUtils sUtils = new SecUtils();
		TCPClient client = new TCPClient();
		ServerThread st = new ServerThread();
		st.start();

		int mainFlag = 1;
		int cpsLeafCertCount = 0;
		String rootCertName = null;

		String cpsLeafPrivateFileName = "cps-2_leaf_private" + cpsLeafCertCount + ".pem";

		while (mainFlag == 1) {
			System.out.println(
					"cps-2 RA=========================================================================================================");
			System.out.println(
					"1. request to get V2G-2 root Certificate\n2. request CPS-2 leaf certificate\n3. request to get Mo root Certificate");
			int inputValue = sc.nextInt();

			if (inputValue == 1) {
				client.clientRun(21001);
				boolean isConnected = true;
				// request to get v2g Root certificate
				byte[] sendData = sUtils.makeReqToGetV2GRootCertMsg();
				client.sendPacket(sendData);
				System.out.println("send request to v2g-2 rootCA");
				while (isConnected) {

					byte[] getData = client.receivePacket();
					if (getData != null) {
						String type = sUtils.checkMsgType(getData);
						System.out.println("MSG type is :" + type);
						if (type.equals("ResWithCert")) {
							// save cert in pem file
							List<String> saveCertList = sUtils.saveCertFromMsg(getData);
							// saveCertList(0) : v2g Root Cert Name
							rootCertName = saveCertList.get(0);
							System.out.println("save cert in pem file");
							// finish connection
							sendData = sUtils.makeFinishConnectionMsg();
							client.sendPacket(sendData);
						} else if (type.equals("FinishConnection")) {
							client.clientStop();
							isConnected = false;
							System.out.println("finish connection with v2g-2 root CA");
						}
					}
				}
				
				client.clientRun(5001);
				isConnected = true;
				// request to get mo Root certificate
				sendData = sUtils.makeReqToGetMORootCertMsg();
				client.sendPacket(sendData);
				System.out.println("send request to MOrootCA");
				while (isConnected) {
					byte[] getData = client.receivePacket();
					if (getData != null) {
						String type = sUtils.checkMsgType(getData);
						System.out.println("MSG type is :" + type);
						if (type.equals("ResWithCert")) {
							// save cert in pem file
							List<String> saveCertList = sUtils.saveCertFromMsg(getData);
							// saveCertList(0) : MO Root Cert Name
							moRootCertName = saveCertList.get(0);
							System.out.println("save cert in pem file");
							// finish connection
							sendData = sUtils.makeFinishConnectionMsg();
							client.sendPacket(sendData);
						} else if (type.equals("FinishConnection")) {
							client.clientStop();
							isConnected = false;
							System.out.println("finish connection with root CA");
						}
					}
				}
				
				//OEM root Certificate
				
				client.clientRun(2001);
				isConnected = true;
				// request to get oem Root certificate
				sendData = sUtils.makeReqToGetOEMRootCertMsg();
				client.sendPacket(sendData);
				System.out.println("send request to OEM rootCA");
				while (isConnected) {
					byte[] getData = client.receivePacket();
					if (getData != null) {
						String type = sUtils.checkMsgType(getData);
						System.out.println("MSG type is :" + type);
						if (type.equals("ResWithCert")) {
							// save cert in pem file
							List<String> saveCertList = sUtils.saveCertFromMsg(getData);
							// saveCertList(0) : OEM Root Cert Name
							oemRootCertName = saveCertList.get(0);
							System.out.println("save cert in pem file");
							// finish connection
							sendData = sUtils.makeFinishConnectionMsg();
							client.sendPacket(sendData);
						} else if (type.equals("FinishConnection")) {
							client.clientStop();
							isConnected = false;
							System.out.println("finish connection with root CA");
						}
					}
				}
				
				client.clientRun(21001);
				isConnected = true;
				// request to get v2g cross Root certificate
				sendData = sUtils.makeReqToGetV2GCrossRootCertMsg();
				client.sendPacket(sendData);
				System.out.println("send request to v2g-2 rootCA");
				while (isConnected) {

					byte[] getData = client.receivePacket();
					if (getData != null) {
						String type = sUtils.checkMsgType(getData);
						System.out.println("MSG type is :" + type);
						if (type.equals("ResWithCert")) {
							// save cert in pem file
							List<String> saveCertList = sUtils.saveCertFromMsg(getData);
							// saveCertList(0) : v2g Root Cert Name
							crossRootCertName = saveCertList.get(0);
							System.out.println("save cert in pem file");
							// finish connection
							sendData = sUtils.makeFinishConnectionMsg();
							client.sendPacket(sendData);
						} else if (type.equals("FinishConnection")) {
							client.clientStop();
							isConnected = false;
							System.out.println("finish connection with v2g-2 root CA");
						}
					}
				}
			} else if (inputValue == 2) {
				// TCP connect with CPS-2SubCA2 : 21003
				client.clientRun(21003);
				boolean isConnected = true;
				// create private key.pem
				String cpsLeafPublicFileName = "cps-2_leaf_public_" + cpsLeafCertCount + ".pem";
				sUtils.generateEcKeyPair(cpsLeafPrivateFileName, cpsLeafPublicFileName);
				// create cps_contract_csr
				String csrFileName = "cps-2_leaf_csr.pem";
				String cpsLeafDn = "C=KR, O=MJU, OU=HMCL, CN=MJU_CPS-2_LEAF, DC=CPS";
				sUtils.generateCsr(cpsLeafPrivateFileName, cpsLeafPublicFileName, cpsLeafDn, csrFileName);
				// send csr to subCA2
				String cpsLeafCertName = "cps-2_leaf_cert_" + cpsLeafCertCount + ".pem";
				byte[] sendData = sUtils.makeReqToIssueCertMsg(csrFileName, cpsLeafCertName);
				client.sendPacket(sendData);
				System.out.println("send CSR to cps-2 subCA2");
				while (isConnected) {
					byte[] getData = client.receivePacket();
					if (getData != null) {
						String type = sUtils.checkMsgType(getData);
						if (type.equals("ResWithCert")) {
							// save cert in pem file
							List<String> saveCertList = sUtils.saveCertFromMsg(getData);
							// list(0) :cps leaf cert, list(1):cps Sub2 cert, list(2):cps sub1 cert
							leafCertList.add(new CertData(cpsLeafCertName, cpsLeafPrivateFileName,
									cpsLeafPublicFileName, saveCertList.get(1), saveCertList.get(2), rootCertName));
							cpsLeafCertCount++;
							System.out.println("save cert in pem file");
							sendData = sUtils.makeFinishConnectionMsg();
							client.sendPacket(sendData);
						} else if (type.equals("FinishConnection")) {
							client.clientStop();
							isConnected = false;
							System.out.println("finish connection with cps-2 subCA2");
						}
					}
				}

			} else if (inputValue == 3) {
				
			}
		}

	}
}
