
package pe.com.claro.transversal.dinamico.canonical.types.ftth.type;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DispositivoBaseResponseType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="DispositivoBaseResponseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.example.org}DataBaseResponseType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="parentId" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DispositivoBaseResponseType", propOrder = { "type", "status", "parentId", "attributes" })
public class DispositivoBaseResponseType extends DataBaseResponseType {

  private static final long serialVersionUID = -5872094841210069232L;
	@XmlElement(required = true)
    protected String type;
    @XmlElement(required = true)
  protected String status;
    @XmlElement(required = true)
    protected String parentId;
    @XmlElement(required = true)
    protected List<TvSSDeviceAttributesType> attributes;
    
    
    public List<TvSSDeviceAttributesType> getAttributes() {
        if (attributes == null) {
            attributes = new ArrayList<TvSSDeviceAttributesType>();
        }
        return this.attributes;
    }

    /**
     * Gets the value of the type property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the status property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * Gets the value of the parentId property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * Sets the value of the parentId property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setParentId(String value) {
        this.parentId = value;
    }

}
