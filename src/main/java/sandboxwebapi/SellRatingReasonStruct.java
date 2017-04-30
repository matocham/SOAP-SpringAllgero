
package sandboxwebapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SellRatingReasonStruct complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SellRatingReasonStruct">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="sellRatingReasonId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="sellRatingReasonTitle" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SellRatingReasonStruct", propOrder = {

})
public class SellRatingReasonStruct {

    protected int sellRatingReasonId;
    @XmlElement(required = true)
    protected String sellRatingReasonTitle;

    /**
     * Gets the value of the sellRatingReasonId property.
     * 
     */
    public int getSellRatingReasonId() {
        return sellRatingReasonId;
    }

    /**
     * Sets the value of the sellRatingReasonId property.
     * 
     */
    public void setSellRatingReasonId(int value) {
        this.sellRatingReasonId = value;
    }

    /**
     * Gets the value of the sellRatingReasonTitle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSellRatingReasonTitle() {
        return sellRatingReasonTitle;
    }

    /**
     * Sets the value of the sellRatingReasonTitle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSellRatingReasonTitle(String value) {
        this.sellRatingReasonTitle = value;
    }

}
