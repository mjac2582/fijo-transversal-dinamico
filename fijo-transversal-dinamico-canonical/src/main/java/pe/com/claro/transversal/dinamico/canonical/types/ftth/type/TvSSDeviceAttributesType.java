package pe.com.claro.transversal.dinamico.canonical.types.ftth.type;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TvSSDeviceAttributesType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="TvSSDeviceAttributesType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="HOST_UNIT_ADDRESS" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TvSSDeviceAttributesType", propOrder = { "HOST_UNIT_ADDRESS", "PSA_ADDED_TO_CAS" })
public class TvSSDeviceAttributesType {

    @XmlElement(name = "HOST_UNIT_ADDRESS", required = true)
    protected String HOST_UNIT_ADDRESS;
    
    @XmlElement(name = "PSA_ADDED_TO_CAS", required = true)
    protected String PSA_ADDED_TO_CAS;

    /**
     * Gets the value of the hostunitaddress property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getHOSTUNITADDRESS() {
        return HOST_UNIT_ADDRESS;
    }

    /**
     * Sets the value of the hostunitaddress property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setHOSTUNITADDRESS(String value) {
        this.HOST_UNIT_ADDRESS = value;
    }
    
    public String getPSAADDEDTOCAS() {
        return PSA_ADDED_TO_CAS;
    }
    public void setPSAADDEDTOCAS(String value) {
        this.PSA_ADDED_TO_CAS = value;
    }

}
