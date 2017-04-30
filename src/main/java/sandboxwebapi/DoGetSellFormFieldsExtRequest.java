
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
 *         &lt;element name="countryCode" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="localVersion" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="webapiKey" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "countryCode",
    "localVersion",
    "webapiKey"
})
@XmlRootElement(name = "DoGetSellFormFieldsExtRequest")
public class DoGetSellFormFieldsExtRequest {

    protected int countryCode;
    protected Long localVersion;
    @XmlElement(required = true)
    protected String webapiKey;

    /**
     * Gets the value of the countryCode property.
     * 
     */
    public int getCountryCode() {
        return countryCode;
    }

    /**
     * Sets the value of the countryCode property.
     * 
     */
    public void setCountryCode(int value) {
        this.countryCode = value;
    }

    /**
     * Gets the value of the localVersion property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getLocalVersion() {
        return localVersion;
    }

    /**
     * Sets the value of the localVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setLocalVersion(Long value) {
        this.localVersion = value;
    }

    /**
     * Gets the value of the webapiKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWebapiKey() {
        return webapiKey;
    }

    /**
     * Sets the value of the webapiKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWebapiKey(String value) {
        this.webapiKey = value;
    }

}
