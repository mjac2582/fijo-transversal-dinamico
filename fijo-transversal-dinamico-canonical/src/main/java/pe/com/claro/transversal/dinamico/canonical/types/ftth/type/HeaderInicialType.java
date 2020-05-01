
package pe.com.claro.transversal.dinamico.canonical.types.ftth.type;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HeaderInicialType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="HeaderInicialType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="transaccionId" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="source" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HeaderInicialType", propOrder = { "transaccionId", "source" })
@XmlSeeAlso({ HeaderBaseType.class })
public class HeaderInicialType implements Serializable {

 	private static final long serialVersionUID = -5993324788358002957L;
	@XmlElement(required = true)
    protected String transaccionId;
    @XmlElement(required = true)
    protected String source;

    /**
     * Gets the value of the transaccionId property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getTransaccionId() {
        return transaccionId;
    }

    /**
     * Sets the value of the transaccionId property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setTransaccionId(String value) {
        this.transaccionId = value;
    }

    /**
     * Gets the value of the source property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getSource() {
        return source;
    }

    /**
     * Sets the value of the source property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setSource(String value) {
        this.source = value;
    }

}
