
package pe.com.claro.transversal.dinamico.canonical.types.ftth.type;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

import pe.com.claro.transversal.dinamico.canonical.types.ftth.type.base.HeaderResponseType;
import pe.com.claro.transversal.dinamico.canonical.types.ftth.type.base.HeaderType;


/**
 * <p>Java class for HeaderBaseType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="HeaderBaseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.example.org}HeaderInicialType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="tecnologia" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="servicio" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HeaderBaseType", propOrder = { "tecnologia", "servicio" })
@XmlSeeAlso({ HeaderType.class, HeaderResponseType.class })
public class HeaderBaseType extends HeaderInicialType {

 	private static final long serialVersionUID = 7647385982769374203L;
	@XmlElement(required = true)
    protected String tecnologia;
    @XmlElement(required = true)
    protected String servicio;

    /**
     * Gets the value of the tecnologia property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getTecnologia() {
        return tecnologia;
    }

    /**
     * Sets the value of the tecnologia property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setTecnologia(String value) {
        this.tecnologia = value;
    }

    /**
     * Gets the value of the servicio property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getServicio() {
        return servicio;
    }

    /**
     * Sets the value of the servicio property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setServicio(String value) {
        this.servicio = value;
    }

}
