
package pe.com.claro.transversal.dinamico.canonical.types.ftth.type;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DataBaseResponseType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="DataBaseResponseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="creationDate" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="lastModified" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="lastModifiedBy" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="identifier" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="entityId" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DataBaseResponseType",
         propOrder = { "creationDate", "lastModified", "lastModifiedBy", "description", "identifier", "entityId", "id"
    })
@XmlSeeAlso({ DataPersonResponseType.class, DispositivoBaseResponseType.class, ActivacionBaseResponseType.class })
public class DataBaseResponseType implements Serializable {

	private static final long serialVersionUID = -4759572310588382714L;
	@XmlElement(required = true)
    protected String creationDate;
    @XmlElement(required = true)
    protected String lastModified;
    @XmlElement(required = true)
    protected String lastModifiedBy;
    @XmlElement(required = true)
    protected String description;
    @XmlElement(required = true)
    protected String identifier;
    @XmlElement(required = true)
    protected String entityId;
    @XmlElement(required = true)
    protected String id;

    /**
     * Gets the value of the creationDate property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCreationDate() {
        return creationDate;
    }

    /**
     * Sets the value of the creationDate property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCreationDate(String value) {
        this.creationDate = value;
    }

    /**
     * Gets the value of the lastModified property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getLastModified() {
        return lastModified;
    }

    /**
     * Sets the value of the lastModified property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setLastModified(String value) {
        this.lastModified = value;
    }

    /**
     * Gets the value of the lastModifiedBy property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    /**
     * Sets the value of the lastModifiedBy property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setLastModifiedBy(String value) {
        this.lastModifiedBy = value;
    }

    /**
     * Gets the value of the description property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDescription(String value) {
        this.description = value;
    }

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
     * Gets the value of the entityId property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getEntityId() {
        return entityId;
    }

    /**
     * Sets the value of the entityId property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setEntityId(String value) {
        this.entityId = value;
    }

    /**
     * Gets the value of the id property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setId(String value) {
        this.id = value;
    }

}
