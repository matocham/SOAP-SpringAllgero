
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
 *         &lt;element name="feedbackId" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "feedbackId"
})
@XmlRootElement(name = "doFeedbackResponse")
public class DoFeedbackResponse {

    protected int feedbackId;

    /**
     * Gets the value of the feedbackId property.
     * 
     */
    public int getFeedbackId() {
        return feedbackId;
    }

    /**
     * Sets the value of the feedbackId property.
     * 
     */
    public void setFeedbackId(int value) {
        this.feedbackId = value;
    }

}
