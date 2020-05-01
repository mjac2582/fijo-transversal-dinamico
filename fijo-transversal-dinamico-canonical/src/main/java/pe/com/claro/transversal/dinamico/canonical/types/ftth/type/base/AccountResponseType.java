
package pe.com.claro.transversal.dinamico.canonical.types.ftth.type.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import pe.com.claro.transversal.dinamico.canonical.types.ftth.type.ActivacionBaseResponseType;
import pe.com.claro.transversal.dinamico.canonical.types.ftth.type.SubscribersType;


/**
 * <p>Java class for AccountResponseType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="AccountResponseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.example.org}ActivacionBaseResponseType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="serviceProvider" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="subscribers" type="{http://www.example.org}SubscribersType" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AccountResponseType", propOrder = { "serviceProvider", "subscribers" })
public class AccountResponseType extends ActivacionBaseResponseType implements Serializable {

  private static final long serialVersionUID = -858506879706130431L;
	@XmlElement(required = true)
  protected String serviceProvider;
    @XmlElement(required = true)
  protected List<SubscribersType> subscribers;

    /**
     * Gets the value of the serviceProvider property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getServiceProvider() {
      return serviceProvider;
    }

    /**
     * Sets the value of the serviceProvider property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setServiceProvider(String value) {
        this.serviceProvider = value;
    }

    /**
     * Gets the value of the subscribers property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the subscribers property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSubscribers().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SubscribersType }
     *
     *
     */
    public List<SubscribersType> getSubscribers() {
    if (subscribers == null) {
      subscribers = new ArrayList<SubscribersType>();
    }
     return this.subscribers;
    }

}
