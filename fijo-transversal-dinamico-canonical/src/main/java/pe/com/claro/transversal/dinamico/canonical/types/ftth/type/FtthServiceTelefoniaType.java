
package pe.com.claro.transversal.dinamico.canonical.types.ftth.type;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FtthServiceTelefoniaType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="FtthServiceTelefoniaType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CALL_FEATURES" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="TELEPHONY_PHONE_NUMBER" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="PASSWORD" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="MTA_PORT" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="VOICE_NODE" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="IS_CENTREX_ENABLED" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="CALL_BARRING_TYPE" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="OCSI" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FtthServiceTelefoniaType",
         propOrder =
         { "CALL_FEATURES", "TELEPHONY_PHONE_NUMBER", "PASSWORD", "MTA_PORT", "VOICE_NODE", "IS_CENTREX_ENABLED",
           "CALL_BARRING_TYPE", "OCSI"
    })
public class FtthServiceTelefoniaType extends HfcInternetAttributesType {

    @XmlElement(name = "CALL_FEATURES", required = true)
    protected String CALL_FEATURES;
    @XmlElement(name = "TELEPHONY_PHONE_NUMBER", required = true)
    protected String TELEPHONY_PHONE_NUMBER;
    @XmlElement(name = "PASSWORD", required = true)
    protected String PASSWORD;
    @XmlElement(name = "MTA_PORT", required = true)
    protected String MTA_PORT;
    @XmlElement(name = "VOICE_NODE", required = true)
    protected String VOICE_NODE;
    @XmlElement(name = "IS_CENTREX_ENABLED", required = true)
    protected String IS_CENTREX_ENABLED;
    @XmlElement(name = "CALL_BARRING_TYPE", required = true)
    protected String CALL_BARRING_TYPE;
    @XmlElement(name = "OCSI", required = true)
    protected String OCSI;
   
    

    /**
     * Gets the value of the callfeatures property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCALLFEATURES() {
        return CALL_FEATURES;
    }

    /**
     * Sets the value of the callfeatures property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCALLFEATURES(String value) {
        this.CALL_FEATURES = value;
    }

    /**
     * Gets the value of the telephonyphonenumber property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getTELEPHONYPHONENUMBER() {
        return TELEPHONY_PHONE_NUMBER;
    }

    /**
     * Sets the value of the telephonyphonenumber property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setTELEPHONYPHONENUMBER(String value) {
        this.TELEPHONY_PHONE_NUMBER = value;
    }

    /**
     * Gets the value of the password property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getPASSWORD() {
        return PASSWORD;
    }

    /**
     * Sets the value of the password property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setPASSWORD(String value) {
        this.PASSWORD = value;
    }

    /**
     * Gets the value of the mtaport property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getMTAPORT() {
        return MTA_PORT;
    }

    /**
     * Sets the value of the mtaport property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setMTAPORT(String value) {
        this.MTA_PORT = value;
    }

    /**
     * Gets the value of the voicenode property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getVOICENODE() {
        return VOICE_NODE;
    }

    /**
     * Sets the value of the voicenode property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setVOICENODE(String value) {
        this.VOICE_NODE = value;
    }

    /**
     * Gets the value of the iscentrexenabled property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getISCENTREXENABLED() {
        return IS_CENTREX_ENABLED;
    }

    /**
     * Sets the value of the iscentrexenabled property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setISCENTREXENABLED(String value) {
        this.IS_CENTREX_ENABLED = value;
    }

    /**
     * Gets the value of the callbarringtype property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCALLBARRINGTYPE() {
        return CALL_BARRING_TYPE;
    }

    /**
     * Sets the value of the callbarringtype property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCALLBARRINGTYPE(String value) {
        this.CALL_BARRING_TYPE = value;
    }

    /**
     * Gets the value of the ocsi property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getOCSI() {
        return OCSI;
    }

    /**
     * Sets the value of the ocsi property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setOCSI(String value) {
        this.OCSI = value;
    }

}
