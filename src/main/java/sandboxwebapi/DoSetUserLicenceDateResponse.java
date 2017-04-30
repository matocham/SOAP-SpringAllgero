
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
 *         &lt;element name="setDateValue" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "setDateValue"
})
@XmlRootElement(name = "doSetUserLicenceDateResponse")
public class DoSetUserLicenceDateResponse {

    protected int setDateValue;

    /**
     * Gets the value of the setDateValue property.
     * 
     */
    public int getSetDateValue() {
        return setDateValue;
    }

    /**
     * Sets the value of the setDateValue property.
     * 
     */
    public void setSetDateValue(int value) {
        this.setDateValue = value;
    }

}
