
package pe.com.claro.transversal.dinamico.canonical.types.ftth.type.base;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import pe.com.claro.transversal.dinamico.canonical.types.ftth.type.ActivaBaseServiceResponseType;
import pe.com.claro.transversal.dinamico.canonical.types.ftth.type.DispositivoBaseResponseType;
import pe.com.claro.transversal.dinamico.canonical.types.ftth.type.FtthInternetAttributesType;


/**
 * <p>Java class for FtthServiceResponseType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="FtthServiceResponseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.example.org}ActivaBaseServiceResponseType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="attributes" type="{http://www.example.org}FtthInternetAttributesType" maxOccurs="unbounded"/&gt;
 *         &lt;element name="device" type="{http://www.example.org}DispositivoBaseResponseType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FtthServiceResponseType", propOrder = { "attributes", "device" })
public class FtthServiceResponseType extends ActivaBaseServiceResponseType {

 	private static final long serialVersionUID = -5232309549051034373L;
	@XmlElement(required = true)
    protected List<FtthInternetAttributesType> attributes;
    @XmlElement(required = true)
    protected DispositivoBaseResponseType device;

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
     * {@link FtthInternetAttributesType }
     *
     *
     */
    public List<FtthInternetAttributesType> getAttributes() {
        if (attributes == null) {
            attributes = new ArrayList<FtthInternetAttributesType>();
        }
        return this.attributes;
    }

    /**
     * Gets the value of the device property.
     *
     * @return
     *     possible object is
     *     {@link DispositivoBaseResponseType }
     *
     */
    public DispositivoBaseResponseType getDevice() {
        return device;
    }

    /**
     * Sets the value of the device property.
     *
     * @param value
     *     allowed object is
     *     {@link DispositivoBaseResponseType }
     *
     */
    public void setDevice(DispositivoBaseResponseType value) {
        this.device = value;
    }

}
