package pe.com.claro.transversal.dinamico.canonical.types.ftth.type;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

import pe.com.claro.transversal.dinamico.canonical.types.ftth.type.base.FtthServiceResponseType;


/**
 * <p>Java class for ActivaBaseServiceResponseType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="ActivaBaseServiceResponseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.example.org}ActivacionBaseResponseType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="serviceType" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ActivaBaseServiceResponseType", propOrder = { "serviceType" })
@XmlSeeAlso({ FtthServiceResponseType.class })
public class ActivaBaseServiceResponseType extends ActivacionBaseResponseType {

  private static final long serialVersionUID = 5880110944636992707L;
	@XmlElement(required = true)
    protected String serviceType;

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
