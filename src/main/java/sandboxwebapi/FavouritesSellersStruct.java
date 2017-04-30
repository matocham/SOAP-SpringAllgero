
package sandboxwebapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FavouritesSellersStruct complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FavouritesSellersStruct">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="sFavUserId" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
@XmlType(name = "FavouritesSellersStruct", propOrder = {

})
public class FavouritesSellersStruct {

    protected int sFavUserId;
    protected int sSubscriptionStatus;
    protected int sPosition;
    protected int sBuyNowOnly;

    /**
     * Gets the value of the sFavUserId property.
     * 
     */
    public int getSFavUserId() {
        return sFavUserId;
    }

    /**
     * Sets the value of the sFavUserId property.
     * 
     */
    public void setSFavUserId(int value) {
        this.sFavUserId = value;
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
