//
// 이 파일은 JAXB(JavaTM Architecture for XML Binding) 참조 구현 2.2.8-b130911.1802 버전을 통해 생성되었습니다. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>를 참조하십시오. 
// 이 파일을 수정하면 소스 스키마를 재컴파일할 때 수정 사항이 손실됩니다. 
// 생성 날짜: 2019.07.03 시간 05:05:58 AM KST 
//


package msgDef;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ProfileEntryType complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="ProfileEntryType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ChargingProfileEntryStart" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="ChargingProfileEntryMaxPower" type="{urn:iso:15118:2:2013:MsgDataTypes}PhysicalValueType"/>
 *         &lt;element name="ChargingProfileEntryMaxNumberOfPhasesInUse" type="{urn:iso:15118:2:2013:MsgDataTypes}maxNumPhasesType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProfileEntryType", propOrder = {
    "chargingProfileEntryStart",
    "chargingProfileEntryMaxPower",
    "chargingProfileEntryMaxNumberOfPhasesInUse"
})
public class ProfileEntryType {

    @XmlElement(name = "ChargingProfileEntryStart")
    @XmlSchemaType(name = "unsignedInt")
    protected long chargingProfileEntryStart;
    @XmlElement(name = "ChargingProfileEntryMaxPower", required = true)
    protected PhysicalValueType chargingProfileEntryMaxPower;
    @XmlElement(name = "ChargingProfileEntryMaxNumberOfPhasesInUse")
    protected Byte chargingProfileEntryMaxNumberOfPhasesInUse;

    /**
     * chargingProfileEntryStart 속성의 값을 가져옵니다.
     * 
     */
    public long getChargingProfileEntryStart() {
        return chargingProfileEntryStart;
    }

    /**
     * chargingProfileEntryStart 속성의 값을 설정합니다.
     * 
     */
    public void setChargingProfileEntryStart(long value) {
        this.chargingProfileEntryStart = value;
    }

    /**
     * chargingProfileEntryMaxPower 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link PhysicalValueType }
     *     
     */
    public PhysicalValueType getChargingProfileEntryMaxPower() {
        return chargingProfileEntryMaxPower;
    }

    /**
     * chargingProfileEntryMaxPower 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link PhysicalValueType }
     *     
     */
    public void setChargingProfileEntryMaxPower(PhysicalValueType value) {
        this.chargingProfileEntryMaxPower = value;
    }

    /**
     * chargingProfileEntryMaxNumberOfPhasesInUse 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Byte }
     *     
     */
    public Byte getChargingProfileEntryMaxNumberOfPhasesInUse() {
        return chargingProfileEntryMaxNumberOfPhasesInUse;
    }

    /**
     * chargingProfileEntryMaxNumberOfPhasesInUse 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Byte }
     *     
     */
    public void setChargingProfileEntryMaxNumberOfPhasesInUse(Byte value) {
        this.chargingProfileEntryMaxNumberOfPhasesInUse = value;
    }

}
