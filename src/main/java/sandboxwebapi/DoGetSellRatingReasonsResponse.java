
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
 *         &lt;element name="sellRatingInfo" type="{urn:SandboxWebApi}ArrayOfSellratinginfostruct" minOccurs="0"/>
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
    "sellRatingInfo"
})
@XmlRootElement(name = "doGetSellRatingReasonsResponse")
public class DoGetSellRatingReasonsResponse {

    protected ArrayOfSellratinginfostruct sellRatingInfo;

    /**
     * Gets the value of the sellRatingInfo property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfSellratinginfostruct }
     *     
     */
    public ArrayOfSellratinginfostruct getSellRatingInfo() {
        return sellRatingInfo;
    }

    /**
     * Sets the value of the sellRatingInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfSellratinginfostruct }
     *     
     */
    public void setSellRatingInfo(ArrayOfSellratinginfostruct value) {
        this.sellRatingInfo = value;
    }

}
