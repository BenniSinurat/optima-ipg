
package org.bellatrix.services.ws.billpayments;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for loadPermissionByPaymentChannelResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="loadPermissionByPaymentChannelResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="paymentChannelPermission" type="{http://services.bellatrix.org/}paymentChannelPermissions" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="status" type="{http://services.bellatrix.org/}responseStatus" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "loadPermissionByPaymentChannelResponse", propOrder = {
    "paymentChannelPermission",
    "status"
})
public class LoadPermissionByPaymentChannelResponse {

    @XmlElement(nillable = true)
    protected List<PaymentChannelPermissions> paymentChannelPermission;
    protected ResponseStatus status;

    /**
     * Gets the value of the paymentChannelPermission property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the paymentChannelPermission property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPaymentChannelPermission().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PaymentChannelPermissions }
     * 
     * 
     */
    public List<PaymentChannelPermissions> getPaymentChannelPermission() {
        if (paymentChannelPermission == null) {
            paymentChannelPermission = new ArrayList<PaymentChannelPermissions>();
        }
        return this.paymentChannelPermission;
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

}
