
package pe.com.claro.transversal.dinamico.canonical.types.ftth.type;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DeviceType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="DeviceType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.example.org}ChildType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="child" type="{http://www.example.org}ChildType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * @param <T>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DeviceType", propOrder = { "child" })
public class DeviceType<T> extends ChildType  implements Serializable  {

  private static final long serialVersionUID = -9172974085591914420L;

	@XmlElement(required = true)
    protected ChildType child;
    
    @XmlElement(required = true)
    protected List<T> attributes;
    
    public DeviceType(List<T> list) {
    	attributes = list;
    }
    
    
    public List<T> getAttributes() {
        if (attributes == null) {
            attributes = new ArrayList<>();
        }
        return this.attributes;
    }
    

    /**
     * Gets the value of the child property.
     *
     * @return
     *     possible object is
     *     {@link ChildType }
     *
     */
    public ChildType getChild() {
        return child;
    }

    /**
     * Sets the value of the child property.
     *
     * @param value
     *     allowed object is
     *     {@link ChildType }
     *
     */
    public void setChild(ChildType value) {
        this.child = value;
    }

}
