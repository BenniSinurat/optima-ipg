
package org.bellatrix.services.ws.transfertypes;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for loadPermissionByTransferTypesResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="loadPermissionByTransferTypesResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="status" type="{http://services.bellatrix.org/}responseStatus" minOccurs="0"/>
 *         &lt;element name="transferTypePermissions" type="{http://services.bellatrix.org/}transferTypesPermission" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "loadPermissionByTransferTypesResponse", propOrder = {
    "status",
    "transferTypePermissions"
})
public class LoadPermissionByTransferTypesResponse {

    protected ResponseStatus status;
    @XmlElement(nillable = true)
    protected List<TransferTypesPermission> transferTypePermissions;

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
     * Gets the value of the transferTypePermissions property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the transferTypePermissions property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTransferTypePermissions().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TransferTypesPermission }
     * 
     * 
     */
    public List<TransferTypesPermission> getTransferTypePermissions() {
        if (transferTypePermissions == null) {
            transferTypePermissions = new ArrayList<TransferTypesPermission>();
        }
        return this.transferTypePermissions;
    }

}
