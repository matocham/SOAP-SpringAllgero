
package sandboxwebapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FeedbackList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FeedbackList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="fId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="fItemId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="fFromId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="fToId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="fDate" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="fType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="fDesc" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="fCorrectDate" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="fCorrectText" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="fReceiverType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="fUserLogin" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="fUserRating" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="fUserCountry" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="fUserBlocked" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="fUserSseller" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="fCancelled" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FeedbackList", propOrder = {

})
public class FeedbackList {

    protected int fId;
    protected long fItemId;
    protected int fFromId;
    protected int fToId;
    protected long fDate;
    @XmlElement(required = true)
    protected String fType;
    @XmlElement(required = true)
    protected String fDesc;
    protected long fCorrectDate;
    @XmlElement(required = true)
    protected String fCorrectText;
    @XmlElement(required = true)
    protected String fReceiverType;
    @XmlElement(required = true)
    protected String fUserLogin;
    @XmlElement(required = true)
    protected String fUserRating;
    @XmlElement(required = true)
    protected String fUserCountry;
    protected int fUserBlocked;
    protected int fUserSseller;
    protected long fCancelled;

    /**
     * Gets the value of the fId property.
     * 
     */
    public int getFId() {
        return fId;
    }

    /**
     * Sets the value of the fId property.
     * 
     */
    public void setFId(int value) {
        this.fId = value;
    }

    /**
     * Gets the value of the fItemId property.
     * 
     */
    public long getFItemId() {
        return fItemId;
    }

    /**
     * Sets the value of the fItemId property.
     * 
     */
    public void setFItemId(long value) {
        this.fItemId = value;
    }

    /**
     * Gets the value of the fFromId property.
     * 
     */
    public int getFFromId() {
        return fFromId;
    }

    /**
     * Sets the value of the fFromId property.
     * 
     */
    public void setFFromId(int value) {
        this.fFromId = value;
    }

    /**
     * Gets the value of the fToId property.
     * 
     */
    public int getFToId() {
        return fToId;
    }

    /**
     * Sets the value of the fToId property.
     * 
     */
    public void setFToId(int value) {
        this.fToId = value;
    }

    /**
     * Gets the value of the fDate property.
     * 
     */
    public long getFDate() {
        return fDate;
    }

    /**
     * Sets the value of the fDate property.
     * 
     */
    public void setFDate(long value) {
        this.fDate = value;
    }

    /**
     * Gets the value of the fType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFType() {
        return fType;
    }

    /**
     * Sets the value of the fType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFType(String value) {
        this.fType = value;
    }

    /**
     * Gets the value of the fDesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFDesc() {
        return fDesc;
    }

    /**
     * Sets the value of the fDesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFDesc(String value) {
        this.fDesc = value;
    }

    /**
     * Gets the value of the fCorrectDate property.
     * 
     */
    public long getFCorrectDate() {
        return fCorrectDate;
    }

    /**
     * Sets the value of the fCorrectDate property.
     * 
     */
    public void setFCorrectDate(long value) {
        this.fCorrectDate = value;
    }

    /**
     * Gets the value of the fCorrectText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFCorrectText() {
        return fCorrectText;
    }

    /**
     * Sets the value of the fCorrectText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFCorrectText(String value) {
        this.fCorrectText = value;
    }

    /**
     * Gets the value of the fReceiverType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFReceiverType() {
        return fReceiverType;
    }

    /**
     * Sets the value of the fReceiverType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFReceiverType(String value) {
        this.fReceiverType = value;
    }

    /**
     * Gets the value of the fUserLogin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFUserLogin() {
        return fUserLogin;
    }

    /**
     * Sets the value of the fUserLogin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFUserLogin(String value) {
        this.fUserLogin = value;
    }

    /**
     * Gets the value of the fUserRating property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFUserRating() {
        return fUserRating;
    }

    /**
     * Sets the value of the fUserRating property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFUserRating(String value) {
        this.fUserRating = value;
    }

    /**
     * Gets the value of the fUserCountry property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFUserCountry() {
        return fUserCountry;
    }

    /**
     * Sets the value of the fUserCountry property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFUserCountry(String value) {
        this.fUserCountry = value;
    }

    /**
     * Gets the value of the fUserBlocked property.
     * 
     */
    public int getFUserBlocked() {
        return fUserBlocked;
    }

    /**
     * Sets the value of the fUserBlocked property.
     * 
     */
    public void setFUserBlocked(int value) {
        this.fUserBlocked = value;
    }

    /**
     * Gets the value of the fUserSseller property.
     * 
     */
    public int getFUserSseller() {
        return fUserSseller;
    }

    /**
     * Sets the value of the fUserSseller property.
     * 
     */
    public void setFUserSseller(int value) {
        this.fUserSseller = value;
    }

    /**
     * Gets the value of the fCancelled property.
     * 
     */
    public long getFCancelled() {
        return fCancelled;
    }

    /**
     * Sets the value of the fCancelled property.
     * 
     */
    public void setFCancelled(long value) {
        this.fCancelled = value;
    }

}
