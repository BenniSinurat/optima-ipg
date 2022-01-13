
package org.bellatrix.services.ws.pos;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for terminalInquiryResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="terminalInquiryResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="status" type="{http://services.bellatrix.org/}responseStatus" minOccurs="0"/>
 *         &lt;element name="terminal" type="{http://services.bellatrix.org/}terminalView" maxOccurs="unbounded" minOccurs="0"/>
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
@XmlType(name = "terminalInquiryResponse", propOrder = {
    "status",
    "terminal",
    "toMember"
})
public class TerminalInquiryResponse {

    protected ResponseStatus status;
    @XmlElement(nillable = true)
    protected List<TerminalView> terminal;
    protected MemberView toMember;

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
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the terminal property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTerminal().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TerminalView }
     * 
     * 
     */
    public List<TerminalView> getTerminal() {
        if (terminal == null) {
            terminal = new ArrayList<TerminalView>();
        }
        return this.terminal;
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
