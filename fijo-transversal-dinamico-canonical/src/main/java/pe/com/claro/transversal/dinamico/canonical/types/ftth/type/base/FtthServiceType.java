
package pe.com.claro.transversal.dinamico.canonical.types.ftth.type.base;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import pe.com.claro.transversal.dinamico.canonical.types.ftth.type.BaseServiceType;
import pe.com.claro.transversal.dinamico.canonical.types.ftth.type.ChildType;
import pe.com.claro.transversal.dinamico.canonical.types.ftth.type.FtthServiceInternetType;


/**
 * <p>Java class for FtthServiceType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="FtthServiceType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.example.org}BaseServiceType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="attributes" type="{http://www.example.org}FtthServiceInternetType" maxOccurs="unbounded"/&gt;
 *         &lt;element name="device" type="{http://www.example.org}ChildType"/&gt;
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
@XmlType(name = "FtthServiceType", propOrder = { "attributes", "device" })
public class FtthServiceType<T> extends BaseServiceType {

    @XmlElement(required = true)
    protected List<T> attributes;  //FtthServiceInternetType
    @XmlElement(required = true)
    protected ChildType device;
    
    public FtthServiceType(List<T> list) {
    	attributes = list;
    }
    

    /**
     * Gets the value of the attributes property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the attributes property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAttributes().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FtthServiceInternetType }
     *
     *
     */
    public List<T> getAttributes() {
        if (attributes == null) {
            attributes = new ArrayList<T>();
        }
        return this.attributes;
    }

    /**
     * Gets the value of the device property.
     *
     * @return
     *     possible object is
     *     {@link ChildType }
     *
     */
    public ChildType getDevice() {
        return device;
    }

    /**
     * Sets the value of the device property.
     *
     * @param value
     *     allowed object is
     *     {@link ChildType }
     *
     */
    public void setDevice(ChildType value) {
        this.device = value;
    }

}
