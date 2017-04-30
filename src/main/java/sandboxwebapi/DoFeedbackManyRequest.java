
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
 *         &lt;element name="feedbacksList" type="{urn:SandboxWebApi}ArrayOfFeedbackmanystruct" minOccurs="0"/>
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
    "feedbacksList"
})
@XmlRootElement(name = "DoFeedbackManyRequest")
public class DoFeedbackManyRequest {

    @XmlElement(required = true)
    protected String sessionHandle;
    protected ArrayOfFeedbackmanystruct feedbacksList;

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
     * Gets the value of the feedbacksList property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfFeedbackmanystruct }
     *     
     */
    public ArrayOfFeedbackmanystruct getFeedbacksList() {
        return feedbacksList;
    }

    /**
     * Sets the value of the feedbacksList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfFeedbackmanystruct }
     *     
     */
    public void setFeedbacksList(ArrayOfFeedbackmanystruct value) {
        this.feedbacksList = value;
    }

}
