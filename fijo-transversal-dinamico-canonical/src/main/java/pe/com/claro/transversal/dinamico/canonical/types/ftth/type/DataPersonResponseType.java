
package pe.com.claro.transversal.dinamico.canonical.types.ftth.type;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DataPersonResponseType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="DataPersonResponseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.example.org}DataBaseResponseType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="lastName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="firstName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="title" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="middleName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="homePhoneNumber" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="workPhoneNumber" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="otherPhoneNumber" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DataPersonResponseType",
         propOrder =
         { "lastName", "firstName", "title", "type", "middleName", "homePhoneNumber", "workPhoneNumber",
           "otherPhoneNumber"
    })
@XmlSeeAlso({ SubscribersType.class })
public class DataPersonResponseType extends DataBaseResponseType  implements Serializable  {

 	private static final long serialVersionUID = -4204739109510825232L;
	@XmlElement(required = true)
    protected String lastName;
    @XmlElement(required = true)
    protected String firstName;
    @XmlElement(required = true)
    protected String title;
    @XmlElement(required = true)
    protected String type;
    @XmlElement(required = true)
    protected String middleName;
    @XmlElement(required = true)
    protected String homePhoneNumber;
    @XmlElement(required = true)
    protected String workPhoneNumber;
    @XmlElement(required = true)
    protected String otherPhoneNumber;

    /**
     * Gets the value of the lastName property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the value of the lastName property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setLastName(String value) {
        this.lastName = value;
    }

    /**
     * Gets the value of the firstName property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the value of the firstName property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setFirstName(String value) {
        this.firstName = value;
    }

    /**
     * Gets the value of the title property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setTitle(String value) {
        this.title = value;
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
     * Gets the value of the middleName property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getMiddleName() {
    return middleName;
    }

    /**
     * Sets the value of the middleName property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setMiddleName(String value) {
        this.middleName = value;
    }

    /**
     * Gets the value of the homePhoneNumber property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getHomePhoneNumber() {
        return homePhoneNumber;
    }

    /**
     * Sets the value of the homePhoneNumber property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setHomePhoneNumber(String value) {
        this.homePhoneNumber = value;
    }

    /**
     * Gets the value of the workPhoneNumber property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getWorkPhoneNumber() {
        return workPhoneNumber;
    }

    /**
     * Sets the value of the workPhoneNumber property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setWorkPhoneNumber(String value) {
        this.workPhoneNumber = value;
    }

    /**
     * Gets the value of the otherPhoneNumber property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getOtherPhoneNumber() {
        return otherPhoneNumber;
    }

    /**
     * Sets the value of the otherPhoneNumber property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setOtherPhoneNumber(String value) {
        this.otherPhoneNumber = value;
    }

}
