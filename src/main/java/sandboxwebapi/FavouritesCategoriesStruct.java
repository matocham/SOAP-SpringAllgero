
package sandboxwebapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FavouritesCategoriesStruct complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FavouritesCategoriesStruct">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="sCategoryId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="sSubscriptionStatus" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="sPosition" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="sBuyNowOnly" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FavouritesCategoriesStruct", propOrder = {

})
public class FavouritesCategoriesStruct {

    protected int sCategoryId;
    protected int sSubscriptionStatus;
    protected int sPosition;
    protected int sBuyNowOnly;

    /**
     * Gets the value of the sCategoryId property.
     * 
     */
    public int getSCategoryId() {
        return sCategoryId;
    }

    /**
     * Sets the value of the sCategoryId property.
     * 
     */
    public void setSCategoryId(int value) {
        this.sCategoryId = value;
    }

    /**
     * Gets the value of the sSubscriptionStatus property.
     * 
     */
    public int getSSubscriptionStatus() {
        return sSubscriptionStatus;
    }

    /**
     * Sets the value of the sSubscriptionStatus property.
     * 
     */
    public void setSSubscriptionStatus(int value) {
        this.sSubscriptionStatus = value;
    }

    /**
     * Gets the value of the sPosition property.
     * 
     */
    public int getSPosition() {
        return sPosition;
    }

    /**
     * Sets the value of the sPosition property.
     * 
     */
    public void setSPosition(int value) {
        this.sPosition = value;
    }

    /**
     * Gets the value of the sBuyNowOnly property.
     * 
     */
    public int getSBuyNowOnly() {
        return sBuyNowOnly;
    }

    /**
     * Sets the value of the sBuyNowOnly property.
     * 
     */
    public void setSBuyNowOnly(int value) {
        this.sBuyNowOnly = value;
    }

}
