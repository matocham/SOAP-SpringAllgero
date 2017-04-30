
package sandboxwebapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SellRatingStatsStruct complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SellRatingStatsStruct">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="sellRatingGroupTitle" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sellRatingGroupStats" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SellRatingStatsStruct", propOrder = {

})
public class SellRatingStatsStruct {

    @XmlElement(required = true)
    protected String sellRatingGroupTitle;
    @XmlElement(required = true)
    protected String sellRatingGroupStats;

    /**
     * Gets the value of the sellRatingGroupTitle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSellRatingGroupTitle() {
        return sellRatingGroupTitle;
    }

    /**
     * Sets the value of the sellRatingGroupTitle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSellRatingGroupTitle(String value) {
        this.sellRatingGroupTitle = value;
    }

    /**
     * Gets the value of the sellRatingGroupStats property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSellRatingGroupStats() {
        return sellRatingGroupStats;
    }

    /**
     * Sets the value of the sellRatingGroupStats property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSellRatingGroupStats(String value) {
        this.sellRatingGroupStats = value;
    }

}
