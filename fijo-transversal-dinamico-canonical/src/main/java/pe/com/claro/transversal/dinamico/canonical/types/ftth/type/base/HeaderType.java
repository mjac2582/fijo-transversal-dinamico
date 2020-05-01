
package pe.com.claro.transversal.dinamico.canonical.types.ftth.type.base;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import pe.com.claro.transversal.dinamico.canonical.types.ftth.type.HeaderBaseType;


/**
 * <p>Java class for HeaderType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="HeaderType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.example.org}HeaderBaseType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="authorization" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="timestamp" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="msgid" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="accept" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="userId" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HeaderType", propOrder = { "authorization", "timestamp", "msgid", "userId" })// "accept",

public class HeaderType extends HeaderBaseType {

	private static final long serialVersionUID = -6382284341507560524L;
	@XmlElement(required = true)
    protected String authorization;
    @XmlElement(required = true)
    protected String timestamp;
    @XmlElement(required = true)
    protected String msgid;
    @XmlElement(required = true)
    protected String userId;

    /**
     * Gets the value of the authorization property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getAuthorization() {
        return authorization;
    }

    /**
     * Sets the value of the authorization property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setAuthorization(String value) {
        this.authorization = value;
    }

    /**
     * Gets the value of the timestamp property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getTimestamp() {
        return timestamp;
    }

    /**
     * Sets the value of the timestamp property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setTimestamp(String value) {
        this.timestamp = value;
    }

    /**
     * Gets the value of the msgid property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getMsgid() {
        return msgid;
    }

    /**
     * Sets the value of the msgid property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setMsgid(String value) {
        this.msgid = value;
    }

 

    /**
     * Gets the value of the userId property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Sets the value of the userId property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setUserId(String value) {
        this.userId = value;
    }

}
