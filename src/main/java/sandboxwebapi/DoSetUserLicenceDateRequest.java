
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
 *         &lt;element name="adminSessionHandle" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="userLicLogin" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="userLicCountry" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="userLicDate" type="{http://www.w3.org/2001/XMLSchema}float"/>
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
    "adminSessionHandle",
    "userLicLogin",
    "userLicCountry",
    "userLicDate"
})
@XmlRootElement(name = "DoSetUserLicenceDateRequest")
public class DoSetUserLicenceDateRequest {

    @XmlElement(required = true)
    protected String adminSessionHandle;
    @XmlElement(required = true)
    protected String userLicLogin;
    protected int userLicCountry;
    protected float userLicDate;

    /**
     * Gets the value of the adminSessionHandle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdminSessionHandle() {
        return adminSessionHandle;
    }

    /**
     * Sets the value of the adminSessionHandle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdminSessionHandle(String value) {
        this.adminSessionHandle = value;
    }

    /**
     * Gets the value of the userLicLogin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserLicLogin() {
        return userLicLogin;
    }

    /**
     * Sets the value of the userLicLogin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserLicLogin(String value) {
        this.userLicLogin = value;
    }

    /**
     * Gets the value of the userLicCountry property.
     * 
     */
    public int getUserLicCountry() {
        return userLicCountry;
    }

    /**
     * Sets the value of the userLicCountry property.
     * 
     */
    public void setUserLicCountry(int value) {
        this.userLicCountry = value;
    }

    /**
     * Gets the value of the userLicDate property.
     * 
     */
    public float getUserLicDate() {
        return userLicDate;
    }

    /**
     * Sets the value of the userLicDate property.
     * 
     */
    public void setUserLicDate(float value) {
        this.userLicDate = value;
    }

}
