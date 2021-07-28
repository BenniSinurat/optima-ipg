package org.bellatrix.services.ws.billpayments;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 2.7.15
 * 2021-07-28T20:58:06.163+07:00
 * Generated source version: 2.7.15
 * 
 */
@WebService(targetNamespace = "http://services.bellatrix.org/", name = "BillPayment")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface BillPayment {

    @WebMethod(action = "paymentBilling")
    @WebResult(name = "paymentBillingResponse", targetNamespace = "http://services.bellatrix.org/", partName = "paymentBillingResponse")
    public BillPaymentResponse paymentBilling(
        @WebParam(partName = "headerAuth", mode = WebParam.Mode.INOUT, name = "headerAuth", targetNamespace = "http://services.bellatrix.org/", header = true)
        javax.xml.ws.Holder<Header> headerAuth,
        @WebParam(partName = "paymentBilling", name = "paymentBilling", targetNamespace = "http://services.bellatrix.org/")
        BillPaymentRequest paymentBilling
    ) throws Exception_Exception;

    @WebMethod(action = "loadPaymentChannelByMemberID")
    @WebResult(name = "loadPaymentChannelByMemberIDResponse", targetNamespace = "http://services.bellatrix.org/", partName = "loadPaymentChannelByMemberIDResponse")
    public LoadPaymentChannelByMemberIDResponse loadPaymentChannelByMemberID(
        @WebParam(partName = "headerAuth", mode = WebParam.Mode.INOUT, name = "headerAuth", targetNamespace = "http://services.bellatrix.org/", header = true)
        javax.xml.ws.Holder<Header> headerAuth,
        @WebParam(partName = "loadPaymentChannelByMemberID", name = "loadPaymentChannelByMemberID", targetNamespace = "http://services.bellatrix.org/")
        LoadPaymentChannelByMemberIDRequest loadPaymentChannelByMemberID
    );

    @WebMethod(action = "createPaymentChannelPermissions")
    public void createPaymentChannelPermissions(
        @WebParam(partName = "headerAuth", mode = WebParam.Mode.INOUT, name = "headerAuth", targetNamespace = "http://services.bellatrix.org/", header = true)
        javax.xml.ws.Holder<Header> headerAuth,
        @WebParam(partName = "createPaymentChannelPermissions", name = "createPaymentChannelPermissions", targetNamespace = "http://services.bellatrix.org/")
        PaymentChannelPermissionRequest createPaymentChannelPermissions
    ) throws Exception_Exception;

    @WebMethod(action = "loadPaymentChannel")
    @WebResult(name = "loadPaymentChannelResponse", targetNamespace = "http://services.bellatrix.org/", partName = "loadPaymentChannelResponse")
    public PaymentChannelResponse loadPaymentChannel(
        @WebParam(partName = "headerAuth", mode = WebParam.Mode.INOUT, name = "headerAuth", targetNamespace = "http://services.bellatrix.org/", header = true)
        javax.xml.ws.Holder<Header> headerAuth
    ) throws Exception_Exception;

    @WebMethod(action = "registerBiller")
    public void registerBiller(
        @WebParam(partName = "headerAuth", mode = WebParam.Mode.INOUT, name = "headerAuth", targetNamespace = "http://services.bellatrix.org/", header = true)
        javax.xml.ws.Holder<Header> headerAuth,
        @WebParam(partName = "registerBiller", name = "registerBiller", targetNamespace = "http://services.bellatrix.org/")
        BillerRegisterRequest registerBiller
    ) throws Exception_Exception;

    @WebMethod(action = "loadBillersFromUsername")
    @WebResult(name = "loadBillersFromUsernameResponse", targetNamespace = "http://services.bellatrix.org/", partName = "loadBillersFromUsernameResponse")
    public BillerListResponse loadBillersFromUsername(
        @WebParam(partName = "headerAuth", mode = WebParam.Mode.INOUT, name = "headerAuth", targetNamespace = "http://services.bellatrix.org/", header = true)
        javax.xml.ws.Holder<Header> headerAuth,
        @WebParam(partName = "loadBillersFromUsername", name = "loadBillersFromUsername", targetNamespace = "http://services.bellatrix.org/")
        BillerDetailsRequest loadBillersFromUsername
    ) throws Exception_Exception;

    @WebMethod(action = "updatePaymentChannelPermissions")
    public void updatePaymentChannelPermissions(
        @WebParam(partName = "headerAuth", mode = WebParam.Mode.INOUT, name = "headerAuth", targetNamespace = "http://services.bellatrix.org/", header = true)
        javax.xml.ws.Holder<Header> headerAuth,
        @WebParam(partName = "updatePaymentChannelPermissions", name = "updatePaymentChannelPermissions", targetNamespace = "http://services.bellatrix.org/")
        PaymentChannelPermissionRequest updatePaymentChannelPermissions
    ) throws Exception_Exception;

    @WebMethod(action = "createPaymentChannel")
    public void createPaymentChannel(
        @WebParam(partName = "headerAuth", mode = WebParam.Mode.INOUT, name = "headerAuth", targetNamespace = "http://services.bellatrix.org/", header = true)
        javax.xml.ws.Holder<Header> headerAuth,
        @WebParam(partName = "createPaymentChannel", name = "createPaymentChannel", targetNamespace = "http://services.bellatrix.org/")
        PaymentChannelRequest createPaymentChannel
    ) throws Exception_Exception;

    @WebMethod(action = "loadPermissionsByPaymentChannel")
    @WebResult(name = "loadPermissionsByPaymentChannelResponse", targetNamespace = "http://services.bellatrix.org/", partName = "loadPermissionsByPaymentChannelResponse")
    public LoadPermissionByPaymentChannelResponse loadPermissionsByPaymentChannel(
        @WebParam(partName = "headerAuth", mode = WebParam.Mode.INOUT, name = "headerAuth", targetNamespace = "http://services.bellatrix.org/", header = true)
        javax.xml.ws.Holder<Header> headerAuth,
        @WebParam(partName = "loadPermissionsByPaymentChannel", name = "loadPermissionsByPaymentChannel", targetNamespace = "http://services.bellatrix.org/")
        LoadPermissionByPaymentChannelRequest loadPermissionsByPaymentChannel
    );

    @WebMethod(action = "deletePaymentChannelPermissions")
    public void deletePaymentChannelPermissions(
        @WebParam(partName = "headerAuth", mode = WebParam.Mode.INOUT, name = "headerAuth", targetNamespace = "http://services.bellatrix.org/", header = true)
        javax.xml.ws.Holder<Header> headerAuth,
        @WebParam(partName = "deletePaymentChannelPermissions", name = "deletePaymentChannelPermissions", targetNamespace = "http://services.bellatrix.org/")
        PaymentChannelPermissionRequest deletePaymentChannelPermissions
    ) throws Exception_Exception;

    @WebMethod(action = "updatePaymentChannel")
    public void updatePaymentChannel(
        @WebParam(partName = "headerAuth", mode = WebParam.Mode.INOUT, name = "headerAuth", targetNamespace = "http://services.bellatrix.org/", header = true)
        javax.xml.ws.Holder<Header> headerAuth,
        @WebParam(partName = "updatePaymentChannel", name = "updatePaymentChannel", targetNamespace = "http://services.bellatrix.org/")
        PaymentChannelRequest updatePaymentChannel
    ) throws Exception_Exception;

    @WebMethod(action = "loadBillersFromID")
    @WebResult(name = "loadBillersFromIDResponse", targetNamespace = "http://services.bellatrix.org/", partName = "loadBillersFromIDResponse")
    public BillerListResponse loadBillersFromID(
        @WebParam(partName = "headerAuth", mode = WebParam.Mode.INOUT, name = "headerAuth", targetNamespace = "http://services.bellatrix.org/", header = true)
        javax.xml.ws.Holder<Header> headerAuth,
        @WebParam(partName = "loadBillersFromID", name = "loadBillersFromID", targetNamespace = "http://services.bellatrix.org/")
        BillerDetailsRequest loadBillersFromID
    ) throws Exception_Exception;

    @WebMethod(action = "inquiryBilling")
    @WebResult(name = "inquiryBillingResponse", targetNamespace = "http://services.bellatrix.org/", partName = "inquiryBillingResponse")
    public BillInquiryResponse inquiryBilling(
        @WebParam(partName = "headerAuth", mode = WebParam.Mode.INOUT, name = "headerAuth", targetNamespace = "http://services.bellatrix.org/", header = true)
        javax.xml.ws.Holder<Header> headerAuth,
        @WebParam(partName = "inquiryBilling", name = "inquiryBilling", targetNamespace = "http://services.bellatrix.org/")
        BillInquiryRequest inquiryBilling
    ) throws Exception_Exception;
}
