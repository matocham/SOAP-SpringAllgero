
package sandboxwebapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="sessionHandle" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="feedbackFrom" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="feedbackTo" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="feedbackOffset" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="feedbackKindList" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "sessionHandle",
    "feedbackFrom",
    "feedbackTo",
    "feedbackOffset",
    "feedbackKindList"
})
@XmlRootElement(name = "DoGetFeedbackRequest")
public class DoGetFeedbackRequest {

    @XmlElement(required = true)
    protected String sessionHandle;
    protected int feedbackFrom;
    protected int feedbackTo;
    protected Integer feedbackOffset;
    protected String feedbackKindList;

    /**
     * Gets the value of the sessionHandle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSessionHandle() {
        return sessionHandle;
    }

    /**
     * Sets the value of the sessionHandle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSessionHandle(String value) {
        this.sessionHandle = value;
    }

    /**
     * Gets the value of the feedbackFrom property.
     * 
     */
    public int getFeedbackFrom() {
        return feedbackFrom;
    }

    /**
     * Sets the value of the feedbackFrom property.
     * 
     */
    public void setFeedbackFrom(int value) {
        this.feedbackFrom = value;
    }

    /**
     * Gets the value of the feedbackTo property.
     * 
     */
    public int getFeedbackTo() {
        return feedbackTo;
    }

    /**
     * Sets the value of the feedbackTo property.
     * 
     */
    public void setFeedbackTo(int value) {
        this.feedbackTo = value;
    }

    /**
     * Gets the value of the feedbackOffset property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getFeedbackOffset() {
        return feedbackOffset;
    }

    /**
     * Sets the value of the feedbackOffset property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setFeedbackOffset(Integer value) {
        this.feedbackOffset = value;
    }

    /**
     * Gets the value of the feedbackKindList property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeedbackKindList() {
        return feedbackKindList;
    }

    /**
     * Sets the value of the feedbackKindList property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeedbackKindList(String value) {
        this.feedbackKindList = value;
    }

}
