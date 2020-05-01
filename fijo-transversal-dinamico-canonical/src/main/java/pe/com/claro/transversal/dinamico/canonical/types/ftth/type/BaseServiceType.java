
package pe.com.claro.transversal.dinamico.canonical.types.ftth.type;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

import pe.com.claro.transversal.dinamico.canonical.types.ftth.type.base.FtthServiceType;


/**
 * <p>Java class for BaseServiceType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="BaseServiceType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="identifier" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="subscriberIdentifier" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="serviceType" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BaseServiceType", propOrder = { "identifier", "subscriberIdentifier", "serviceType" })
@XmlSeeAlso({ FtthServiceType.class })
public class BaseServiceType {

    @XmlElement(required = true)
    protected String identifier;
    @XmlElement(required = true)
    protected String subscriberIdentifier;
    @XmlElement(required = true)
    protected String serviceType;

    /**
     * Gets the value of the identifier property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getIdentifier() {
        return identifier;
    }

    /**
     * Sets the value of the identifier property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setIdentifier(String value) {
        this.identifier = value;
    }

    /**
     * Gets the value of the subscriberIdentifier property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getSubscriberIdentifier() {
        return subscriberIdentifier;
    }

    /**
     * Sets the value of the subscriberIdentifier property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setSubscriberIdentifier(String value) {
        this.subscriberIdentifier = value;
    }

    /**
     * Gets the value of the serviceType property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getServiceType() {
        return serviceType;
    }

    /**
     * Sets the value of the serviceType property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setServiceType(String value) {
        this.serviceType = value;
    }

}
