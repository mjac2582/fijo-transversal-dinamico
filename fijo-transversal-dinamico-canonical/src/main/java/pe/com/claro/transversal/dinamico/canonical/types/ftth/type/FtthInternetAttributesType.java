
package pe.com.claro.transversal.dinamico.canonical.types.ftth.type;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FtthInternetAttributesType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="FtthInternetAttributesType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="GEM_PORT_ID" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="VLAN_ID" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="USER_VLAN_ID" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FtthInternetAttributesType", propOrder = { "GEM_PORT_ID", "VLAN_ID", "USER_VLAN_ID" })
public class FtthInternetAttributesType  extends FtthServiceTelefoniaType{

    @XmlElement(name = "GEM_PORT_ID", required = true)
    protected String GEM_PORT_ID;
    @XmlElement(name = "VLAN_ID", required = true)
    protected String VLAN_ID;
    @XmlElement(name = "USER_VLAN_ID", required = true)
    protected String USER_VLAN_ID;

    /**
     * Gets the value of the gemportid property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getGEMPORTID() {
        return GEM_PORT_ID;
    }

    /**
     * Sets the value of the gemportid property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setGEMPORTID(String value) {
        this.GEM_PORT_ID = value;
    }

    /**
     * Gets the value of the vlanid property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getVLANID() {
        return VLAN_ID;
    }

    /**
     * Sets the value of the vlanid property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setVLANID(String value) {
        this.VLAN_ID = value;
    }

    /**
     * Gets the value of the uservlanid property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getUSERVLANID() {
        return USER_VLAN_ID;
    }

    /**
     * Sets the value of the uservlanid property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setUSERVLANID(String value) {
        this.USER_VLAN_ID = value;
    }

}
