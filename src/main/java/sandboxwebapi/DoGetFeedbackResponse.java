
package sandboxwebapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="feedbackList" type="{urn:SandboxWebApi}ArrayOfFeedbacklist" minOccurs="0"/>
 *         &lt;element name="feedbackCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "feedbackList",
    "feedbackCount"
})
@XmlRootElement(name = "doGetFeedbackResponse")
public class DoGetFeedbackResponse {

    protected ArrayOfFeedbacklist feedbackList;
    protected int feedbackCount;

    /**
     * Gets the value of the feedbackList property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfFeedbacklist }
     *     
     */
    public ArrayOfFeedbacklist getFeedbackList() {
        return feedbackList;
    }

    /**
     * Sets the value of the feedbackList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfFeedbacklist }
     *     
     */
    public void setFeedbackList(ArrayOfFeedbacklist value) {
        this.feedbackList = value;
    }

    /**
     * Gets the value of the feedbackCount property.
     * 
     */
    public int getFeedbackCount() {
        return feedbackCount;
    }

    /**
     * Sets the value of the feedbackCount property.
     * 
     */
    public void setFeedbackCount(int value) {
        this.feedbackCount = value;
    }

}
