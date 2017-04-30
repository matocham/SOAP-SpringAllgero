
package sandboxwebapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WaitFeedbackStruct complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WaitFeedbackStruct">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="feItemId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="feItemName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="feToUserId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="feOp" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="feAnsCommentType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="fePossibilityToAdd" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WaitFeedbackStruct", propOrder = {

})
public class WaitFeedbackStruct {

    protected long feItemId;
    @XmlElement(required = true)
    protected String feItemName;
    protected int feToUserId;
    protected int feOp;
    @XmlElement(required = true)
    protected String feAnsCommentType;
    protected int fePossibilityToAdd;

    /**
     * Gets the value of the feItemId property.
     * 
     */
    public long getFeItemId() {
        return feItemId;
    }

    /**
     * Sets the value of the feItemId property.
     * 
     */
    public void setFeItemId(long value) {
        this.feItemId = value;
    }

    /**
     * Gets the value of the feItemName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeItemName() {
        return feItemName;
    }

    /**
     * Sets the value of the feItemName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeItemName(String value) {
        this.feItemName = value;
    }

    /**
     * Gets the value of the feToUserId property.
     * 
     */
    public int getFeToUserId() {
        return feToUserId;
    }

    /**
     * Sets the value of the feToUserId property.
     * 
     */
    public void setFeToUserId(int value) {
        this.feToUserId = value;
    }

    /**
     * Gets the value of the feOp property.
     * 
     */
    public int getFeOp() {
        return feOp;
    }

    /**
     * Sets the value of the feOp property.
     * 
     */
    public void setFeOp(int value) {
        this.feOp = value;
    }

    /**
     * Gets the value of the feAnsCommentType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeAnsCommentType() {
        return feAnsCommentType;
    }

    /**
     * Sets the value of the feAnsCommentType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeAnsCommentType(String value) {
        this.feAnsCommentType = value;
    }

    /**
     * Gets the value of the fePossibilityToAdd property.
     * 
     */
    public int getFePossibilityToAdd() {
        return fePossibilityToAdd;
    }

    /**
     * Sets the value of the fePossibilityToAdd property.
     * 
     */
    public void setFePossibilityToAdd(int value) {
        this.fePossibilityToAdd = value;
    }

}
