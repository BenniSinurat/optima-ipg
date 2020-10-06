
package org.bellatrix.services.ws.transfertypes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for loadTransferTypesByIDResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="loadTransferTypesByIDResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="status" type="{http://services.bellatrix.org/}responseStatus" minOccurs="0"/>
 *         &lt;element name="transferTypes" type="{http://services.bellatrix.org/}transferTypes" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "loadTransferTypesByIDResponse", propOrder = {
    "status",
    "transferTypes"
})
public class LoadTransferTypesByIDResponse {

    protected ResponseStatus status;
    protected TransferTypes transferTypes;

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
     * Gets the value of the transferTypes property.
     * 
     * @return
     *     possible object is
     *     {@link TransferTypes }
     *     
     */
    public TransferTypes getTransferTypes() {
        return transferTypes;
    }

    /**
     * Sets the value of the transferTypes property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransferTypes }
     *     
     */
    public void setTransferTypes(TransferTypes value) {
        this.transferTypes = value;
    }

}
