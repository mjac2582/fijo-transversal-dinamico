
package pe.com.claro.transversal.dinamico.canonical.types.ftth.type;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FtthTelefoniaAttributesType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="FtthTelefoniaAttributesType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="VOICE_NODE" type="{http://www.w3.org/2001/XMLSchema}anyType"/&gt;
 *         &lt;element name="PASSWORD" type="{http://www.w3.org/2001/XMLSchema}anyType"/&gt;
 *         &lt;element name="MTA_PORT" type="{http://www.w3.org/2001/XMLSchema}anyType"/&gt;
 *         &lt;element name="CALL_BARRING_TYPE" type="{http://www.w3.org/2001/XMLSchema}anyType"/&gt;
 *         &lt;element name="CALL_FEATURES" type="{http://www.w3.org/2001/XMLSchema}anyType"/&gt;
 *         &lt;element name="TELEPHONY_PHONE_NUMBER" type="{http://www.w3.org/2001/XMLSchema}anyType"/&gt;
 *         &lt;element name="OCSI" type="{http://www.w3.org/2001/XMLSchema}anyType"/&gt;
 *         &lt;element name="IS_CENTREX_ENABLED" type="{http://www.w3.org/2001/XMLSchema}anyType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FtthTelefoniaAttributesType",
         propOrder =
         { "voicenode", "password", "mtaport", "callbarringtype", "callfeatures", "telephonyphonenumber", "ocsi",
           "iscentrexenabled"
    })
public class FtthTelefoniaAttributesType {

    @XmlElement(name = "VOICE_NODE", required = true)
    protected Object voicenode;
    @XmlElement(name = "PASSWORD", required = true)
    protected Object password;
    @XmlElement(name = "MTA_PORT", required = true)
    protected Object mtaport;
    @XmlElement(name = "CALL_BARRING_TYPE", required = true)
    protected Object callbarringtype;
    @XmlElement(name = "CALL_FEATURES", required = true)
    protected Object callfeatures;
    @XmlElement(name = "TELEPHONY_PHONE_NUMBER", required = true)
    protected Object telephonyphonenumber;
    @XmlElement(name = "OCSI", required = true)
    protected Object ocsi;
    @XmlElement(name = "IS_CENTREX_ENABLED", required = true)
    protected Object iscentrexenabled;

    /**
     * Gets the value of the voicenode property.
     *
     * @return
     *     possible object is
     *     {@link Object }
     *
     */
    public Object getVOICENODE() {
        return voicenode;
    }

    /**
     * Sets the value of the voicenode property.
     *
     * @param value
     *     allowed object is
     *     {@link Object }
     *
     */
    public void setVOICENODE(Object value) {
        this.voicenode = value;
    }

    /**
     * Gets the value of the password property.
     *
     * @return
     *     possible object is
     *     {@link Object }
     *
     */
    public Object getPASSWORD() {
        return password;
    }

    /**
     * Sets the value of the password property.
     *
     * @param value
     *     allowed object is
     *     {@link Object }
     *
     */
    public void setPASSWORD(Object value) {
        this.password = value;
    }

    /**
     * Gets the value of the mtaport property.
     *
     * @return
     *     possible object is
     *     {@link Object }
     *
     */
    public Object getMTAPORT() {
        return mtaport;
    }

    /**
     * Sets the value of the mtaport property.
     *
     * @param value
     *     allowed object is
     *     {@link Object }
     *
     */
    public void setMTAPORT(Object value) {
        this.mtaport = value;
    }

    /**
     * Gets the value of the callbarringtype property.
     *
     * @return
     *     possible object is
     *     {@link Object }
     *
     */
    public Object getCALLBARRINGTYPE() {
        return callbarringtype;
    }

    /**
     * Sets the value of the callbarringtype property.
     *
     * @param value
     *     allowed object is
     *     {@link Object }
     *
     */
    public void setCALLBARRINGTYPE(Object value) {
        this.callbarringtype = value;
    }

    /**
     * Gets the value of the callfeatures property.
     *
     * @return
     *     possible object is
     *     {@link Object }
     *
     */
    public Object getCALLFEATURES() {
        return callfeatures;
    }

    /**
     * Sets the value of the callfeatures property.
     *
     * @param value
     *     allowed object is
     *     {@link Object }
     *
     */
    public void setCALLFEATURES(Object value) {
        this.callfeatures = value;
    }

    /**
     * Gets the value of the telephonyphonenumber property.
     *
     * @return
     *     possible object is
     *     {@link Object }
     *
     */
    public Object getTELEPHONYPHONENUMBER() {
        return telephonyphonenumber;
    }

    /**
     * Sets the value of the telephonyphonenumber property.
     *
     * @param value
     *     allowed object is
     *     {@link Object }
     *
     */
    public void setTELEPHONYPHONENUMBER(Object value) {
        this.telephonyphonenumber = value;
    }

    /**
     * Gets the value of the ocsi property.
     *
     * @return
     *     possible object is
     *     {@link Object }
     *
     */
    public Object getOCSI() {
        return ocsi;
    }

    /**
     * Sets the value of the ocsi property.
     *
     * @param value
     *     allowed object is
     *     {@link Object }
     *
     */
    public void setOCSI(Object value) {
        this.ocsi = value;
    }

    /**
     * Gets the value of the iscentrexenabled property.
     *
     * @return
     *     possible object is
     *     {@link Object }
     *
     */
    public Object getISCENTREXENABLED() {
        return iscentrexenabled;
    }

    /**
     * Sets the value of the iscentrexenabled property.
     *
     * @param value
     *     allowed object is
     *     {@link Object }
     *
     */
    public void setISCENTREXENABLED(Object value) {
        this.iscentrexenabled = value;
    }

}
