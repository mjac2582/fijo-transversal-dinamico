
package pe.com.claro.transversal.dinamico.canonical.types.ftth.type.base;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HeaderBaseHttpType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="HeaderBaseHttpType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Connection" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="User-Agent" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Host" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Accept-Encoding" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Content-Length" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Content-Type" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HeaderBaseHttpType",
         propOrder = { "Connection", "User-Agent", "Host", "Accept-Encoding", "Content-Length", "Content-Type"
    })
public class HeaderHttpType  extends HeaderType {

	private static final long serialVersionUID = 67579020252089121L;
	@XmlElement(name = "Connection", required = true)
    protected String Connection;
    @XmlElement(name = "User-Agent", required = true)
    protected String userAgent;
    @XmlElement(name = "Host", required = true)
    protected String Host;
    @XmlElement(name = "Accept-Encoding", required = true)
    protected String acceptEncoding;
    @XmlElement(name = "Content-Length", required = true)
    protected String contentLength;
    @XmlElement(name = "Content-Type", required = true)
    protected String contentType;

    /**
     * Gets the value of the connection property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getConnection() {
        return Connection;
    }

    /**
     * Sets the value of the connection property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setConnection(String value) {
        this.Connection = value;
    }

    /**
     * Gets the value of the userAgent property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getUserAgent() {
        return userAgent;
    }

    /**
     * Sets the value of the userAgent property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setUserAgent(String value) {
        this.userAgent = value;
    }

    /**
     * Gets the value of the host property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getHost() {
        return Host;
    }

    /**
     * Sets the value of the host property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setHost(String value) {
        this.Host = value;
    }

    /**
     * Gets the value of the acceptEncoding property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getAcceptEncoding() {
        return acceptEncoding;
    }

    /**
     * Sets the value of the acceptEncoding property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setAcceptEncoding(String value) {
        this.acceptEncoding = value;
    }

    /**
     * Gets the value of the contentLength property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getContentLength() {
        return contentLength;
    }

    /**
     * Sets the value of the contentLength property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setContentLength(String value) {
        this.contentLength = value;
    }

    /**
     * Gets the value of the contentType property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getContentType() {
        return contentType;
    }

    /**
     * Sets the value of the contentType property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setContentType(String value) {
        this.contentType = value;
    }

}
