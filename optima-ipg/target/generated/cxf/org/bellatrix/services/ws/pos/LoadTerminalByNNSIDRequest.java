
package org.bellatrix.services.ws.pos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for loadTerminalByNNSIDRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="loadTerminalByNNSIDRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nnsID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="terminalID" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "loadTerminalByNNSIDRequest", propOrder = {
    "nnsID",
    "terminalID"
})
public class LoadTerminalByNNSIDRequest {

    protected String nnsID;
    protected Integer terminalID;

    /**
     * Gets the value of the nnsID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNnsID() {
        return nnsID;
    }

    /**
     * Sets the value of the nnsID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNnsID(String value) {
        this.nnsID = value;
    }

    /**
     * Gets the value of the terminalID property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTerminalID() {
        return terminalID;
    }

    /**
     * Sets the value of the terminalID property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTerminalID(Integer value) {
        this.terminalID = value;
    }

}
