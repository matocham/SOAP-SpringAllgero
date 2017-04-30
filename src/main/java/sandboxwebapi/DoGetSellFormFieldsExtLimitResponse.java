
package sandboxwebapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 *         &lt;element name="sellFormFields" type="{urn:SandboxWebApi}ArrayOfSellformtype" minOccurs="0"/>
 *         &lt;element name="verKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="verStr" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="formFieldsCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "sellFormFields",
    "verKey",
    "verStr",
    "formFieldsCount"
})
@XmlRootElement(name = "doGetSellFormFieldsExtLimitResponse")
public class DoGetSellFormFieldsExtLimitResponse {

    protected ArrayOfSellformtype sellFormFields;
    protected long verKey;
    @XmlElement(required = true)
    protected String verStr;
    protected int formFieldsCount;

    /**
     * Gets the value of the sellFormFields property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfSellformtype }
     *     
     */
    public ArrayOfSellformtype getSellFormFields() {
        return sellFormFields;
    }

    /**
     * Sets the value of the sellFormFields property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfSellformtype }
     *     
     */
    public void setSellFormFields(ArrayOfSellformtype value) {
        this.sellFormFields = value;
    }

    /**
     * Gets the value of the verKey property.
     * 
     */
    public long getVerKey() {
        return verKey;
    }

    /**
     * Sets the value of the verKey property.
     * 
     */
    public void setVerKey(long value) {
        this.verKey = value;
    }

    /**
     * Gets the value of the verStr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVerStr() {
        return verStr;
    }

    /**
     * Sets the value of the verStr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVerStr(String value) {
        this.verStr = value;
    }

    /**
     * Gets the value of the formFieldsCount property.
     * 
     */
    public int getFormFieldsCount() {
        return formFieldsCount;
    }

    /**
     * Sets the value of the formFieldsCount property.
     * 
     */
    public void setFormFieldsCount(int value) {
        this.formFieldsCount = value;
    }

}
