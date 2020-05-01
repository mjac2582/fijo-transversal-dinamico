
package pe.com.claro.transversal.dinamico.canonical.types.ftth.type;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SubscribersType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="SubscribersType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.example.org}DataPersonResponseType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="attributes" type="{http://www.example.org}AtributesType"/&gt;
 *         &lt;element name="device" type="{http://www.example.org}DeviceType" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SubscribersType", propOrder = { "attributes", "device" })
public class SubscribersType extends DataPersonResponseType implements Serializable {

	private static final long serialVersionUID = 1871069821737846584L;
	@XmlElement(required = true)
    protected AtributesType attributes;
    @SuppressWarnings("rawtypes")
	@XmlElement(required = true)
    protected List<DeviceType> device;

    /**
     * Gets the value of the attributes property.
     *
     * @return
     *     possible object is
     *     {@link AtributesType }
     *
     */
    public AtributesType getAttributes() {
        return attributes;
    }

    /**
     * Sets the value of the attributes property.
     *
     * @param value
     *     allowed object is
     *     {@link AtributesType }
     *
     */
    public void setAttributes(AtributesType value) {
        this.attributes = value;
    }

    /**
     * Gets the value of the device property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the device property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDevice().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DeviceType }
     *
     *
     */
    @SuppressWarnings("rawtypes")
	public List<DeviceType> getDevice() {
        if (device == null) {
            device = new ArrayList<>();
        }
        return this.device;
    }

}
