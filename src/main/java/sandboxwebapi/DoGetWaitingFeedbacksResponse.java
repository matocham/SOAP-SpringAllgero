
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
 *         &lt;element name="feWaitList" type="{urn:SandboxWebApi}ArrayOfWaitfeedbackstruct" minOccurs="0"/>
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
    "feWaitList"
})
@XmlRootElement(name = "doGetWaitingFeedbacksResponse")
public class DoGetWaitingFeedbacksResponse {

    protected ArrayOfWaitfeedbackstruct feWaitList;

    /**
     * Gets the value of the feWaitList property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfWaitfeedbackstruct }
     *     
     */
    public ArrayOfWaitfeedbackstruct getFeWaitList() {
        return feWaitList;
    }

    /**
     * Sets the value of the feWaitList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfWaitfeedbackstruct }
     *     
     */
    public void setFeWaitList(ArrayOfWaitfeedbackstruct value) {
        this.feWaitList = value;
    }

}
