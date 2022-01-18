
package org.bellatrix.services.ws.pos;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for posCreateInvoiceResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="posCreateInvoiceResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="amount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="invoiceID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="status" type="{http://services.bellatrix.org/}responseStatus" minOccurs="0"/>
 *         &lt;element name="terminal" type="{http://services.bellatrix.org/}terminalView" minOccurs="0"/>
 *         &lt;element name="ticketID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="toMember" type="{http://services.bellatrix.org/}memberView" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "posCreateInvoiceResponse", propOrder = {
    "amount",
    "invoiceID",
    "status",
    "terminal",
    "ticketID",
    "toMember"
})
public class PosCreateInvoiceResponse {

    protected BigDecimal amount;
    protected String invoiceID;
    protected ResponseStatus status;
    protected TerminalView terminal;
    protected String ticketID;
    protected MemberView toMember;

    /**
     * Gets the value of the amount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * Sets the value of the amount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAmount(BigDecimal value) {
        this.amount = value;
    }

    /**
     * Gets the value of the invoiceID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInvoiceID() {
        return invoiceID;
    }

    /**
     * Sets the value of the invoiceID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInvoiceID(String value) {
        this.invoiceID = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link ResponseStatus }
     *     
     */
    public ResponseStatus getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseStatus }
     *     
     */
    public void setStatus(ResponseStatus value) {
        this.status = value;
    }

    /**
     * Gets the value of the terminal property.
     * 
     * @return
     *     possible object is
     *     {@link TerminalView }
     *     
     */
    public TerminalView getTerminal() {
        return terminal;
    }

    /**
     * Sets the value of the terminal property.
     * 
     * @param value
     *     allowed object is
     *     {@link TerminalView }
     *     
     */
    public void setTerminal(TerminalView value) {
        this.terminal = value;
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
     *     {@link MemberView }
     *     
     */
    public MemberView getToMember() {
        return toMember;
    }

    /**
     * Sets the value of the toMember property.
     * 
     * @param value
     *     allowed object is
     *     {@link MemberView }
     *     
     */
    public void setToMember(MemberView value) {
        this.toMember = value;
    }

}
