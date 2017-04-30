
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
 *         &lt;element name="arrayItemsAddId" type="{urn:SandboxWebApi}ArrayOfLong" minOccurs="0"/>
 *         &lt;element name="arrayItemsDescToLong" type="{urn:SandboxWebApi}ArrayOfLong" minOccurs="0"/>
 *         &lt;element name="arrayItemsNotFound" type="{urn:SandboxWebApi}ArrayOfLong" minOccurs="0"/>
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
    "arrayItemsAddId",
    "arrayItemsDescToLong",
    "arrayItemsNotFound"
})
@XmlRootElement(name = "doAddDescToItemsResponse")
public class DoAddDescToItemsResponse {

    protected ArrayOfLong arrayItemsAddId;
    protected ArrayOfLong arrayItemsDescToLong;
    protected ArrayOfLong arrayItemsNotFound;

    /**
     * Gets the value of the arrayItemsAddId property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfLong }
     *     
     */
    public ArrayOfLong getArrayItemsAddId() {
        return arrayItemsAddId;
    }

    /**
     * Sets the value of the arrayItemsAddId property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfLong }
     *     
     */
    public void setArrayItemsAddId(ArrayOfLong value) {
        this.arrayItemsAddId = value;
    }

    /**
     * Gets the value of the arrayItemsDescToLong property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfLong }
     *     
     */
    public ArrayOfLong getArrayItemsDescToLong() {
        return arrayItemsDescToLong;
    }

    /**
     * Sets the value of the arrayItemsDescToLong property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfLong }
     *     
     */
    public void setArrayItemsDescToLong(ArrayOfLong value) {
        this.arrayItemsDescToLong = value;
    }

    /**
     * Gets the value of the arrayItemsNotFound property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfLong }
     *     
     */
    public ArrayOfLong getArrayItemsNotFound() {
        return arrayItemsNotFound;
    }

    /**
     * Sets the value of the arrayItemsNotFound property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfLong }
     *     
     */
    public void setArrayItemsNotFound(ArrayOfLong value) {
        this.arrayItemsNotFound = value;
    }

}
