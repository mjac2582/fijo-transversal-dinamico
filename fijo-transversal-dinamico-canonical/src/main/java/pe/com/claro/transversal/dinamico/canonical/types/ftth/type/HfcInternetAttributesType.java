
package pe.com.claro.transversal.dinamico.canonical.types.ftth.type;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HfcInternetAttributesType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="HfcInternetAttributesType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="HFC_NODE" type="{http://www.w3.org/2001/XMLSchema}anyType"/&gt;
 *         &lt;element name="MAX_CPE" type="{http://www.w3.org/2001/XMLSchema}anyType"/&gt;
 *         &lt;element name="HUB" type="{http://www.w3.org/2001/XMLSchema}anyType"/&gt;
 *         &lt;element name="CPE_POOL" type="{http://www.w3.org/2001/XMLSchema}anyType"/&gt;
 *         &lt;element name="STATIC_IP_COUNT" type="{http://www.w3.org/2001/XMLSchema}anyType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HfcInternetAttributesType", propOrder = { "HFC_NODE", "MAX_CPE", "HUB", "CPE_POOL", "STATIC_IP_COUNT" })
public class HfcInternetAttributesType extends TvSSAttributesType {

    @XmlElement(name = "HFC_NODE", required = true)
    protected Object HFC_NODE;
    @XmlElement(name = "MAX_CPE", required = true)
    protected Object MAX_CPE;
    @XmlElement(name = "HUB", required = true)
    protected Object HUB;
    @XmlElement(name = "CPE_POOL", required = true)
    protected Object CPE_POOL;
    @XmlElement(name = "STATIC_IP_COUNT", required = true)
    protected Object STATIC_IP_COUNT;

    /**
     * Gets the value of the hfcnode property.
     *
     * @return
     *     possible object is
     *     {@link Object }
     *
     */
    public Object getHFCNODE() {
        return HFC_NODE;
    }

    /**
     * Sets the value of the hfcnode property.
     *
     * @param value
     *     allowed object is
     *     {@link Object }
     *
     */
    public void setHFCNODE(Object value) {
        this.HFC_NODE = value;
    }

    /**
     * Gets the value of the maxcpe property.
     *
     * @return
     *     possible object is
     *     {@link Object }
     *
     */
    public Object getMAXCPE() {
        return MAX_CPE;
    }

    /**
     * Sets the value of the maxcpe property.
     *
     * @param value
     *     allowed object is
     *     {@link Object }
     *
     */
    public void setMAXCPE(Object value) {
        this.MAX_CPE = value;
    }

    /**
     * Gets the value of the hub property.
     *
     * @return
     *     possible object is
     *     {@link Object }
     *
     */
    public Object getHUB() {
        return HUB;
    }

    /**
     * Sets the value of the hub property.
     *
     * @param value
     *     allowed object is
     *     {@link Object }
     *
     */
    public void setHUB(Object value) {
        this.HUB = value;
    }

    /**
     * Gets the value of the cpepool property.
     *
     * @return
     *     possible object is
     *     {@link Object }
     *
     */
    public Object getCPEPOOL() {
        return CPE_POOL;
    }

    /**
     * Sets the value of the cpepool property.
     *
     * @param value
     *     allowed object is
     *     {@link Object }
     *
     */
    public void setCPEPOOL(Object value) {
        this.CPE_POOL = value;
    }

    /**
     * Gets the value of the staticipcount property.
     *
     * @return
     *     possible object is
     *     {@link Object }
     *
     */
    public Object getSTATICIPCOUNT() {
        return STATIC_IP_COUNT;
    }

    /**
     * Sets the value of the staticipcount property.
     *
     * @param value
     *     allowed object is
     *     {@link Object }
     *
     */
    public void setSTATICIPCOUNT(Object value) {
        this.STATIC_IP_COUNT = value;
    }

}
