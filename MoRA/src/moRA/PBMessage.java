package moRA;


import java.util.List;

import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;

import moRA.ContractData.ContractDataFormat;
import moRA.PkiMsg.PkiMsgFormat;
import moRA.ReqToGetOEMProvCert.ReqToGetOEMProvCertFormat;
import moRA.ReqToIssueCert.ReqToIssueCertFormat;
import moRA.ResWithCert.CertInfo;
import moRA.ResWithCert.ResWithCertFormat;


public class PBMessage {
	public PkiMsgFormat getPkiMsg(byte[] getData) {
		PkiMsgFormat pkiMsg = null;		
		try {
			pkiMsg = PkiMsgFormat.parseFrom(getData);
		} catch (InvalidProtocolBufferException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pkiMsg;
	}
	
	public byte[] setPkiMsg(String type, byte[] payload) {
		PkiMsgFormat pkiMsg;
		ByteString payloadByteString;
		payloadByteString = ByteString.copyFrom(payload);
		
		pkiMsg = PkiMsgFormat.newBuilder().setType(type)
				.setPayload(payloadByteString)
				.build();
		byte[] sendData = pkiMsg.toByteArray();
		return sendData;
	}
	
	public ReqToIssueCertFormat getReqToIssueCert(PkiMsgFormat pkiMsg) {
		ReqToIssueCertFormat reqToIssueCert = null;
		try {
			reqToIssueCert = ReqToIssueCertFormat.parseFrom(pkiMsg.getPayload().toByteArray());
		} catch (InvalidProtocolBufferException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reqToIssueCert;
	}
	
	public byte[] setReqToIssueCert(byte[] subjectCsrFile, String subjectCertName) {
		ReqToIssueCertFormat reqToIssueCert = null;
		ByteString subjectCsrFileByteString;
		subjectCsrFileByteString = ByteString.copyFrom(subjectCsrFile);
		
		reqToIssueCert = ReqToIssueCertFormat.newBuilder().setSubjectCsrFile(subjectCsrFileByteString)
				.setSubjectCertName(subjectCertName)
				.build();
		byte[] sendData = reqToIssueCert.toByteArray();
		return sendData;
	}
	
	public ResWithCertFormat getResWithCert(PkiMsgFormat pkiMsg) {
		ResWithCertFormat resWithCert = null;
		try {
			resWithCert = ResWithCertFormat.parseFrom(pkiMsg.getPayload().toByteArray());
		} catch (InvalidProtocolBufferException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resWithCert;
	}

	public byte[] setResWithCert(List<CertInfo> certInfoList) {
		ResWithCertFormat resWithCert = null;
		ResWithCertFormat.Builder builder = ResWithCertFormat.newBuilder();
		System.out.println("certInfoList.size is" + certInfoList.size());
		for (int i=0; i<certInfoList.size();i++) {
			System.out.println("index count : " + i);
			builder.addCertInfo(i, certInfoList.get(i));
		}
		resWithCert= builder.build();
		byte[] sendData = resWithCert.toByteArray();
		return sendData;
	}
	
	public CertInfo setCertInfo(byte[] certFile, String certFileName) {
		CertInfo certInfo = null;
		ByteString certFileBS;
		certFileBS = ByteString.copyFrom(certFile);
		certInfo = CertInfo.newBuilder().setCertFile(certFileBS)
				.setCertFileName(certFileName).build();
		return certInfo;
	}
	
	public ContractDataFormat getContractData(PkiMsgFormat pkiMsg) {
		ContractDataFormat contractData = null;
		try {
			contractData = ContractDataFormat.parseFrom(pkiMsg.getPayload().toByteArray());
		} catch (InvalidProtocolBufferException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return contractData;
	}

	public byte[] setContractData(String emaid, byte[]dhPublicKey, byte[] conrtactEncryptedPrivateKey, List<byte[]> contractCertChain, String pcid) {
		ContractDataFormat contractData = null;
		ContractDataFormat.Builder builder = ContractDataFormat.newBuilder();
		builder.setEmaid(emaid);
		builder.setDHPublicKey(ByteString.copyFrom(dhPublicKey));
		builder.setContractEncryptedPrivateKey(ByteString.copyFrom(conrtactEncryptedPrivateKey));
		for (int i=0; i<contractCertChain.size();i++) {
			builder.addContractCertChain(ByteString.copyFrom(contractCertChain.get(i)));
		}
		builder.setPcid(pcid);
		contractData= builder.build();
		byte[] sendData = contractData.toByteArray();
		return sendData;
	}

	public ReqToGetOEMProvCertFormat getReqToGetOEMProvCert(PkiMsgFormat pkiMsg) {
		ReqToGetOEMProvCertFormat reqToGetOEMProvCert = null;
		try {
			reqToGetOEMProvCert = ReqToGetOEMProvCertFormat.parseFrom(pkiMsg.getPayload().toByteArray());
		} catch (InvalidProtocolBufferException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reqToGetOEMProvCert;
	}

	public byte[] setReqToGetOEMProvCert(String pcid) {
		ReqToGetOEMProvCertFormat reqToGetOEMProvCert = null;
		reqToGetOEMProvCert = ReqToGetOEMProvCertFormat.newBuilder().setPcid(pcid).build();
		byte[] sendData = reqToGetOEMProvCert.toByteArray();
		return sendData;
	}
	
}
