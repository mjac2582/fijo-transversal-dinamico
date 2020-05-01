
package pe.com.claro.transversal.dinamico.canonical.types.ftth.type.base;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import pe.com.claro.transversal.dinamico.canonical.types.ftth.type.HeaderBaseHttpResponseType;


/**
 * <p>Java class for HeaderHttpResponseType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="HeaderHttpResponseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.example.org}HeaderResponseType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="http" type="{http://www.example.org}HeaderBaseHttpResponseType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HeaderHttpResponseType", propOrder = { "http" })
public class HeaderHttpResponseType extends HeaderResponseType {

 	private static final long serialVersionUID = 3015441243427851939L;
	@XmlElement(required = true)
    protected HeaderBaseHttpResponseType http;

    /**
     * Gets the value of the http property.
     *
     * @return
     *     possible object is
     *     {@link HeaderBaseHttpResponseType }
     *
     */
    public HeaderBaseHttpResponseType getHttp() {
        return http;
    }

    /**
     * Sets the value of the http property.
     *
     * @param value
     *     allowed object is
     *     {@link HeaderBaseHttpResponseType }
     *
     */
    public void setHttp(HeaderBaseHttpResponseType value) {
        this.http = value;
    }

}
