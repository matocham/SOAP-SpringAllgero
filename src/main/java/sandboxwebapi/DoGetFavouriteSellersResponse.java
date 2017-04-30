
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
 *         &lt;element name="sFavouriteSellersList" type="{urn:SandboxWebApi}ArrayOfFavouritessellersstruct" minOccurs="0"/>
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
    "sFavouriteSellersList"
})
@XmlRootElement(name = "doGetFavouriteSellersResponse")
public class DoGetFavouriteSellersResponse {

    protected ArrayOfFavouritessellersstruct sFavouriteSellersList;

    /**
     * Gets the value of the sFavouriteSellersList property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfFavouritessellersstruct }
     *     
     */
    public ArrayOfFavouritessellersstruct getSFavouriteSellersList() {
        return sFavouriteSellersList;
    }

    /**
     * Sets the value of the sFavouriteSellersList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfFavouritessellersstruct }
     *     
     */
    public void setSFavouriteSellersList(ArrayOfFavouritessellersstruct value) {
        this.sFavouriteSellersList = value;
    }

}
