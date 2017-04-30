
package sandboxwebapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MyFeedbackListStruct2 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MyFeedbackListStruct2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="feedbackArray" type="{urn:SandboxWebApi}ArrayOfString" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MyFeedbackListStruct2", propOrder = {

})
public class MyFeedbackListStruct2 {

    protected ArrayOfString feedbackArray;

    /**
     * Gets the value of the feedbackArray property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getFeedbackArray() {
        return feedbackArray;
    }

    /**
     * Sets the value of the feedbackArray property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setFeedbackArray(ArrayOfString value) {
        this.feedbackArray = value;
    }

}
