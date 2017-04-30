
package sandboxwebapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SellRatingEstimationStruct complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SellRatingEstimationStruct">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="sellRatingGroupId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="sellRatingGroupEstimation" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="sellRatingReasonId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SellRatingEstimationStruct", propOrder = {

})
public class SellRatingEstimationStruct {

    protected int sellRatingGroupId;
    protected int sellRatingGroupEstimation;
    protected Integer sellRatingReasonId;

    /**
     * Gets the value of the sellRatingGroupId property.
     * 
     */
    public int getSellRatingGroupId() {
        return sellRatingGroupId;
    }

    /**
     * Sets the value of the sellRatingGroupId property.
     * 
     */
    public void setSellRatingGroupId(int value) {
        this.sellRatingGroupId = value;
    }

    /**
     * Gets the value of the sellRatingGroupEstimation property.
     * 
     */
    public int getSellRatingGroupEstimation() {
        return sellRatingGroupEstimation;
    }

    /**
     * Sets the value of the sellRatingGroupEstimation property.
     * 
     */
    public void setSellRatingGroupEstimation(int value) {
        this.sellRatingGroupEstimation = value;
    }

    /**
     * Gets the value of the sellRatingReasonId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSellRatingReasonId() {
        return sellRatingReasonId;
    }

    /**
     * Sets the value of the sellRatingReasonId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSellRatingReasonId(Integer value) {
        this.sellRatingReasonId = value;
    }

}
