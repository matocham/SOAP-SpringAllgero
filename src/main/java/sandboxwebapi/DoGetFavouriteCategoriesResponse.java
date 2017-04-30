
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
 *         &lt;element name="sFavouriteCategoriesList" type="{urn:SandboxWebApi}ArrayOfFavouritescategoriesstruct" minOccurs="0"/>
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
    "sFavouriteCategoriesList"
})
@XmlRootElement(name = "doGetFavouriteCategoriesResponse")
public class DoGetFavouriteCategoriesResponse {

    protected ArrayOfFavouritescategoriesstruct sFavouriteCategoriesList;

    /**
     * Gets the value of the sFavouriteCategoriesList property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfFavouritescategoriesstruct }
     *     
     */
    public ArrayOfFavouritescategoriesstruct getSFavouriteCategoriesList() {
        return sFavouriteCategoriesList;
    }

    /**
     * Sets the value of the sFavouriteCategoriesList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfFavouritescategoriesstruct }
     *     
     */
    public void setSFavouriteCategoriesList(ArrayOfFavouritescategoriesstruct value) {
        this.sFavouriteCategoriesList = value;
    }

}
