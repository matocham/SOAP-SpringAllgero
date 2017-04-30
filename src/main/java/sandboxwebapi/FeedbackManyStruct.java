
package sandboxwebapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FeedbackManyStruct complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FeedbackManyStruct">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="feItemId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="feUseCommentTemplate" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="feToUserId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="feComment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="feCommentType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="feOp" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="feRating" type="{urn:SandboxWebApi}ArrayOfSellratingestimationstruct" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FeedbackManyStruct", propOrder = {

})
public class FeedbackManyStruct {

    protected long feItemId;
    protected Integer feUseCommentTemplate;
    protected int feToUserId;
    protected String feComment;
    @XmlElement(required = true)
    protected String feCommentType;
    protected int feOp;
    protected ArrayOfSellratingestimationstruct feRating;

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
     * Gets the value of the feUseCommentTemplate property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getFeUseCommentTemplate() {
        return feUseCommentTemplate;
    }

    /**
     * Sets the value of the feUseCommentTemplate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setFeUseCommentTemplate(Integer value) {
        this.feUseCommentTemplate = value;
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
     * Gets the value of the feComment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeComment() {
        return feComment;
    }

    /**
     * Sets the value of the feComment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeComment(String value) {
        this.feComment = value;
    }

    /**
     * Gets the value of the feCommentType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeCommentType() {
        return feCommentType;
    }

    /**
     * Sets the value of the feCommentType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeCommentType(String value) {
        this.feCommentType = value;
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
     * Gets the value of the feRating property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfSellratingestimationstruct }
     *     
     */
    public ArrayOfSellratingestimationstruct getFeRating() {
        return feRating;
    }

    /**
     * Sets the value of the feRating property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfSellratingestimationstruct }
     *     
     */
    public void setFeRating(ArrayOfSellratingestimationstruct value) {
        this.feRating = value;
    }

}
