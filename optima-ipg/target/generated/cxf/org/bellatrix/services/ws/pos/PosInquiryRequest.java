
package org.bellatrix.services.ws.pos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for posInquiryRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="posInquiryRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="fromMember" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="terminalID" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="ticketID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="toMember" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "posInquiryRequest", propOrder = {
    "fromMember",
    "terminalID",
    "ticketID",
    "toMember"
})
public class PosInquiryRequest {

    protected String fromMember;
    protected Integer terminalID;
    protected String ticketID;
    protected String toMember;

    /**
     * Gets the value of the fromMember property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFromMember() {
        return fromMember;
    }

    /**
     * Sets the value of the fromMember property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFromMember(String value) {
        this.fromMember = value;
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

    /**
     * Gets the value of the ticketID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTicketID() {
        return ticketID;
    }

    /**
     * Sets the value of the ticketID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTicketID(String value) {
        this.ticketID = value;
    }

    /**
     * Gets the value of the toMember property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToMember() {
        return toMember;
    }

    /**
     * Sets the value of the toMember property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToMember(String value) {
        this.toMember = value;
    }

}
