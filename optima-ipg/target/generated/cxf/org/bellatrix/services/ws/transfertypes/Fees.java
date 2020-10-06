
package org.bellatrix.services.ws.transfertypes;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for fees complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="fees">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="deductAmount" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="enabled" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="endDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="feeAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="fixedAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="fromAccountID" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="fromAllGroup" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="fromMember" type="{http://services.bellatrix.org/}members" minOccurs="0"/>
 *         &lt;element name="fromMemberID" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="initialRangeAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="maximumRangeAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="percentageValue" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="startDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="toAccountID" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="toAllGroup" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="toMember" type="{http://services.bellatrix.org/}members" minOccurs="0"/>
 *         &lt;element name="toMemberID" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="transactionNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="transferTypeID" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "fees", propOrder = {
    "deductAmount",
    "description",
    "enabled",
    "endDate",
    "feeAmount",
    "fixedAmount",
    "fromAccountID",
    "fromAllGroup",
    "fromMember",
    "fromMemberID",
    "id",
    "initialRangeAmount",
    "maximumRangeAmount",
    "name",
    "percentageValue",
    "startDate",
    "toAccountID",
    "toAllGroup",
    "toMember",
    "toMemberID",
    "transactionNumber",
    "transferTypeID"
})
public class Fees {

    protected boolean deductAmount;
    protected String description;
    protected boolean enabled;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar endDate;
    protected BigDecimal feeAmount;
    protected BigDecimal fixedAmount;
    protected Integer fromAccountID;
    protected boolean fromAllGroup;
    protected Members fromMember;
    protected Integer fromMemberID;
    protected Integer id;
    protected BigDecimal initialRangeAmount;
    protected BigDecimal maximumRangeAmount;
    protected String name;
    protected BigDecimal percentageValue;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar startDate;
    protected Integer toAccountID;
    protected boolean toAllGroup;
    protected Members toMember;
    protected Integer toMemberID;
    protected String transactionNumber;
    protected Integer transferTypeID;

    /**
     * Gets the value of the deductAmount property.
     * 
     */
    public boolean isDeductAmount() {
        return deductAmount;
    }

    /**
     * Sets the value of the deductAmount property.
     * 
     */
    public void setDeductAmount(boolean value) {
        this.deductAmount = value;
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
     * Gets the value of the enabled property.
     * 
     */
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * Sets the value of the enabled property.
     * 
     */
    public void setEnabled(boolean value) {
        this.enabled = value;
    }

    /**
     * Gets the value of the endDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEndDate() {
        return endDate;
    }

    /**
     * Sets the value of the endDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEndDate(XMLGregorianCalendar value) {
        this.endDate = value;
    }

    /**
     * Gets the value of the feeAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getFeeAmount() {
        return feeAmount;
    }

    /**
     * Sets the value of the feeAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setFeeAmount(BigDecimal value) {
        this.feeAmount = value;
    }

    /**
     * Gets the value of the fixedAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getFixedAmount() {
        return fixedAmount;
    }

    /**
     * Sets the value of the fixedAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setFixedAmount(BigDecimal value) {
        this.fixedAmount = value;
    }

    /**
     * Gets the value of the fromAccountID property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getFromAccountID() {
        return fromAccountID;
    }

    /**
     * Sets the value of the fromAccountID property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setFromAccountID(Integer value) {
        this.fromAccountID = value;
    }

    /**
     * Gets the value of the fromAllGroup property.
     * 
     */
    public boolean isFromAllGroup() {
        return fromAllGroup;
    }

    /**
     * Sets the value of the fromAllGroup property.
     * 
     */
    public void setFromAllGroup(boolean value) {
        this.fromAllGroup = value;
    }

    /**
     * Gets the value of the fromMember property.
     * 
     * @return
     *     possible object is
     *     {@link Members }
     *     
     */
    public Members getFromMember() {
        return fromMember;
    }

    /**
     * Sets the value of the fromMember property.
     * 
     * @param value
     *     allowed object is
     *     {@link Members }
     *     
     */
    public void setFromMember(Members value) {
        this.fromMember = value;
    }

    /**
     * Gets the value of the fromMemberID property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getFromMemberID() {
        return fromMemberID;
    }

    /**
     * Sets the value of the fromMemberID property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setFromMemberID(Integer value) {
        this.fromMemberID = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setId(Integer value) {
        this.id = value;
    }

    /**
     * Gets the value of the initialRangeAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getInitialRangeAmount() {
        return initialRangeAmount;
    }

    /**
     * Sets the value of the initialRangeAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setInitialRangeAmount(BigDecimal value) {
        this.initialRangeAmount = value;
    }

    /**
     * Gets the value of the maximumRangeAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMaximumRangeAmount() {
        return maximumRangeAmount;
    }

    /**
     * Sets the value of the maximumRangeAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMaximumRangeAmount(BigDecimal value) {
        this.maximumRangeAmount = value;
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
     * Gets the value of the percentageValue property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPercentageValue() {
        return percentageValue;
    }

    /**
     * Sets the value of the percentageValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPercentageValue(BigDecimal value) {
        this.percentageValue = value;
    }

    /**
     * Gets the value of the startDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getStartDate() {
        return startDate;
    }

    /**
     * Sets the value of the startDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setStartDate(XMLGregorianCalendar value) {
        this.startDate = value;
    }

    /**
     * Gets the value of the toAccountID property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getToAccountID() {
        return toAccountID;
    }

    /**
     * Sets the value of the toAccountID property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setToAccountID(Integer value) {
        this.toAccountID = value;
    }

    /**
     * Gets the value of the toAllGroup property.
     * 
     */
    public boolean isToAllGroup() {
        return toAllGroup;
    }

    /**
     * Sets the value of the toAllGroup property.
     * 
     */
    public void setToAllGroup(boolean value) {
        this.toAllGroup = value;
    }

    /**
     * Gets the value of the toMember property.
     * 
     * @return
     *     possible object is
     *     {@link Members }
     *     
     */
    public Members getToMember() {
        return toMember;
    }

    /**
     * Sets the value of the toMember property.
     * 
     * @param value
     *     allowed object is
     *     {@link Members }
     *     
     */
    public void setToMember(Members value) {
        this.toMember = value;
    }

    /**
     * Gets the value of the toMemberID property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getToMemberID() {
        return toMemberID;
    }

    /**
     * Sets the value of the toMemberID property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setToMemberID(Integer value) {
        this.toMemberID = value;
    }

    /**
     * Gets the value of the transactionNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransactionNumber() {
        return transactionNumber;
    }

    /**
     * Sets the value of the transactionNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransactionNumber(String value) {
        this.transactionNumber = value;
    }

    /**
     * Gets the value of the transferTypeID property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTransferTypeID() {
        return transferTypeID;
    }

    /**
     * Sets the value of the transferTypeID property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTransferTypeID(Integer value) {
        this.transferTypeID = value;
    }

}
