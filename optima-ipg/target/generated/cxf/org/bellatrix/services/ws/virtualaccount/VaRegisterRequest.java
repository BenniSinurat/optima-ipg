
package org.bellatrix.services.ws.virtualaccount;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for vaRegisterRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="vaRegisterRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="amount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="bankID" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="billingCycle" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="callbackURL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="eventID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="expiredDateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="fromMember" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fullPayment" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="membership" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="minimumPayment" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="mobileNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="persistent" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="privateField" type="{http://services.bellatrix.org/}billerServiceField" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="referenceNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="subscribed" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="username" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "vaRegisterRequest", propOrder = {
    "amount",
    "bankID",
    "billingCycle",
    "callbackURL",
    "description",
    "email",
    "eventID",
    "expiredDateTime",
    "fromMember",
    "fullPayment",
    "membership",
    "minimumPayment",
    "mobileNo",
    "name",
    "persistent",
    "privateField",
    "referenceNumber",
    "subscribed",
    "username"
})
public class VaRegisterRequest {

    protected BigDecimal amount;
    protected Integer bankID;
    protected Integer billingCycle;
    protected String callbackURL;
    protected String description;
    protected String email;
    protected String eventID;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar expiredDateTime;
    protected String fromMember;
    protected boolean fullPayment;
    protected String membership;
    protected BigDecimal minimumPayment;
    protected String mobileNo;
    protected String name;
    protected boolean persistent;
    @XmlElement(nillable = true)
    protected List<BillerServiceField> privateField;
    protected String referenceNumber;
    protected boolean subscribed;
    protected String username;

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
     * Gets the value of the bankID property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getBankID() {
        return bankID;
    }

    /**
     * Sets the value of the bankID property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setBankID(Integer value) {
        this.bankID = value;
    }

    /**
     * Gets the value of the billingCycle property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getBillingCycle() {
        return billingCycle;
    }

    /**
     * Sets the value of the billingCycle property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setBillingCycle(Integer value) {
        this.billingCycle = value;
    }

    /**
     * Gets the value of the callbackURL property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCallbackURL() {
        return callbackURL;
    }

    /**
     * Sets the value of the callbackURL property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCallbackURL(String value) {
        this.callbackURL = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the email property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the value of the email property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
    }

    /**
     * Gets the value of the eventID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEventID() {
        return eventID;
    }

    /**
     * Sets the value of the eventID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEventID(String value) {
        this.eventID = value;
    }

    /**
     * Gets the value of the expiredDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getExpiredDateTime() {
        return expiredDateTime;
    }

    /**
     * Sets the value of the expiredDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setExpiredDateTime(XMLGregorianCalendar value) {
        this.expiredDateTime = value;
    }

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
     * Gets the value of the fullPayment property.
     * 
     */
    public boolean isFullPayment() {
        return fullPayment;
    }

    /**
     * Sets the value of the fullPayment property.
     * 
     */
    public void setFullPayment(boolean value) {
        this.fullPayment = value;
    }

    /**
     * Gets the value of the membership property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMembership() {
        return membership;
    }

    /**
     * Sets the value of the membership property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMembership(String value) {
        this.membership = value;
    }

    /**
     * Gets the value of the minimumPayment property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMinimumPayment() {
        return minimumPayment;
    }

    /**
     * Sets the value of the minimumPayment property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMinimumPayment(BigDecimal value) {
        this.minimumPayment = value;
    }

    /**
     * Gets the value of the mobileNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMobileNo() {
        return mobileNo;
    }

    /**
     * Sets the value of the mobileNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMobileNo(String value) {
        this.mobileNo = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the persistent property.
     * 
     */
    public boolean isPersistent() {
        return persistent;
    }

    /**
     * Sets the value of the persistent property.
     * 
     */
    public void setPersistent(boolean value) {
        this.persistent = value;
    }

    /**
     * Gets the value of the privateField property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the privateField property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPrivateField().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BillerServiceField }
     * 
     * 
     */
    public List<BillerServiceField> getPrivateField() {
        if (privateField == null) {
            privateField = new ArrayList<BillerServiceField>();
        }
        return this.privateField;
    }

    /**
     * Gets the value of the referenceNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReferenceNumber() {
        return referenceNumber;
    }

    /**
     * Sets the value of the referenceNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReferenceNumber(String value) {
        this.referenceNumber = value;
    }

    /**
     * Gets the value of the subscribed property.
     * 
     */
    public boolean isSubscribed() {
        return subscribed;
    }

    /**
     * Sets the value of the subscribed property.
     * 
     */
    public void setSubscribed(boolean value) {
        this.subscribed = value;
    }

    /**
     * Gets the value of the username property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the value of the username property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsername(String value) {
        this.username = value;
    }

}
