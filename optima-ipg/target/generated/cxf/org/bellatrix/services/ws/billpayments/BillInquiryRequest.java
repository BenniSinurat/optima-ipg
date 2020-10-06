
package org.bellatrix.services.ws.billpayments;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for billInquiryRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="billInquiryRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="acquiringID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="billID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="channelID" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="merchantID" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "billInquiryRequest", propOrder = {
    "acquiringID",
    "billID",
    "channelID",
    "merchantID"
})
public class BillInquiryRequest {

    protected String acquiringID;
    protected String billID;
    protected Integer channelID;
    protected Integer merchantID;

    /**
     * Gets the value of the acquiringID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAcquiringID() {
        return acquiringID;
    }

    /**
     * Sets the value of the acquiringID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAcquiringID(String value) {
        this.acquiringID = value;
    }

    /**
     * Gets the value of the billID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBillID() {
        return billID;
    }

    /**
     * Sets the value of the billID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBillID(String value) {
        this.billID = value;
    }

    /**
     * Gets the value of the channelID property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getChannelID() {
        return channelID;
    }

    /**
     * Sets the value of the channelID property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setChannelID(Integer value) {
        this.channelID = value;
    }

    /**
     * Gets the value of the merchantID property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMerchantID() {
        return merchantID;
    }

    /**
     * Sets the value of the merchantID property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMerchantID(Integer value) {
        this.merchantID = value;
    }

}
