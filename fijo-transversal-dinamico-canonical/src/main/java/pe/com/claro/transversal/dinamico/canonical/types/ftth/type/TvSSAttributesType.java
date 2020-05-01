package pe.com.claro.transversal.dinamico.canonical.types.ftth.type;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TvSSAttributesType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="TvSSAttributesType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="DTV_NODE" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="DTV_CHANNEL_MAP" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="DTV_HEADEND" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TvSSAttributesType", propOrder = { "DTV_NODE", "DTV_CHANNEL_MAP", "DTV_HEADEND" })
public class TvSSAttributesType {

    @XmlElement(name = "DTV_NODE", required = true)
    protected String DTV_NODE;
    @XmlElement(name = "DTV_CHANNEL_MAP", required = true)
    protected String DTV_CHANNEL_MAP;
    @XmlElement(name = "DTV_HEADEND", required = true)
    protected String DTV_HEADEND;

    /**
     * Gets the value of the dtvnode property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getDTVNODE() {
        return DTV_NODE;
    }

    /**
     * Sets the value of the dtvnode property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDTVNODE(String value) {
        this.DTV_NODE = value;
    }

    /**
     * Gets the value of the dtvchannelmap property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getDTVCHANNELMAP() {
        return DTV_CHANNEL_MAP;
    }

    /**
     * Sets the value of the dtvchannelmap property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDTVCHANNELMAP(String value) {
        this.DTV_CHANNEL_MAP = value;
    }

    /**
     * Gets the value of the dtvheadend property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getDTVHEADEND() {
        return DTV_HEADEND;
    }

    /**
     * Sets the value of the dtvheadend property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDTVHEADEND(String value) {
        this.DTV_HEADEND = value;
    }

}
