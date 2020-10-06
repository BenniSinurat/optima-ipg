
package org.bellatrix.services.ws.billpayments;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for billers complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="billers">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="asyncPayment" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="billerName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="externalSystem" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="moduleURL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="openPayment" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "billers", propOrder = {
    "asyncPayment",
    "billerName",
    "description",
    "externalSystem",
    "id",
    "moduleURL",
    "openPayment"
})
public class Billers {

    protected Boolean asyncPayment;
    protected String billerName;
    protected String description;
    protected Boolean externalSystem;
    protected Integer id;
    protected String moduleURL;
    protected Boolean openPayment;

    /**
     * Gets the value of the asyncPayment property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAsyncPayment() {
        return asyncPayment;
    }

    /**
     * Sets the value of the asyncPayment property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAsyncPayment(Boolean value) {
        this.asyncPayment = value;
    }

    /**
     * Gets the value of the billerName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBillerName() {
        return billerName;
    }

    /**
     * Sets the value of the billerName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBillerName(String value) {
        this.billerName = value;
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
     * Gets the value of the externalSystem property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isExternalSystem() {
        return externalSystem;
    }

    /**
     * Sets the value of the externalSystem property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setExternalSystem(Boolean value) {
        this.externalSystem = value;
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
     * Gets the value of the moduleURL property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModuleURL() {
        return moduleURL;
    }

    /**
     * Sets the value of the moduleURL property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModuleURL(String value) {
        this.moduleURL = value;
    }

    /**
     * Gets the value of the openPayment property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isOpenPayment() {
        return openPayment;
    }

    /**
     * Sets the value of the openPayment property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setOpenPayment(Boolean value) {
        this.openPayment = value;
    }

}
