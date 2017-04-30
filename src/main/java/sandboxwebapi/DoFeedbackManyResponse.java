
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
 *         &lt;element name="feResults" type="{urn:SandboxWebApi}ArrayOfFeedbackresultstruct" minOccurs="0"/>
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
    "feResults"
})
@XmlRootElement(name = "doFeedbackManyResponse")
public class DoFeedbackManyResponse {

    protected ArrayOfFeedbackresultstruct feResults;

    /**
     * Gets the value of the feResults property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfFeedbackresultstruct }
     *     
     */
    public ArrayOfFeedbackresultstruct getFeResults() {
        return feResults;
    }

    /**
     * Sets the value of the feResults property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfFeedbackresultstruct }
     *     
     */
    public void setFeResults(ArrayOfFeedbackresultstruct value) {
        this.feResults = value;
    }

}
