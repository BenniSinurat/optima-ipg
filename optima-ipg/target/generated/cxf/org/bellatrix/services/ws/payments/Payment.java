package org.bellatrix.services.ws.payments;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 2.7.15
 * 2022-01-13T13:47:31.372+07:00
 * Generated source version: 2.7.15
 * 
 */
@WebService(targetNamespace = "http://services.bellatrix.org/", name = "Payment")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface Payment {

    @WebMethod(action = "validatePaymentTicket")
    @WebResult(name = "validatePaymentTicketResponse", targetNamespace = "http://services.bellatrix.org/", partName = "validatePaymentTicketResponse")
    public ValidatePaymentTicketResponse validatePaymentTicket(
        @WebParam(partName = "headerAuth", mode = WebParam.Mode.INOUT, name = "headerAuth", targetNamespace = "http://services.bellatrix.org/", header = true)
        javax.xml.ws.Holder<Header> headerAuth,
        @WebParam(partName = "validatePaymentTicket", name = "validatePaymentTicket", targetNamespace = "http://services.bellatrix.org/")
        ValidatePaymentTicketRequest validatePaymentTicket
    );

    @WebMethod(action = "reversePayment")
    @WebResult(name = "reversePaymentResponse", targetNamespace = "http://services.bellatrix.org/", partName = "reversePaymentResponse")
    public ReversalResponse reversePayment(
        @WebParam(partName = "headerAuth", mode = WebParam.Mode.INOUT, name = "headerAuth", targetNamespace = "http://services.bellatrix.org/", header = true)
        javax.xml.ws.Holder<Header> headerAuth,
        @WebParam(partName = "reversePayment", name = "reversePayment", targetNamespace = "http://services.bellatrix.org/")
        ReversalRequest reversePayment
    );

    @WebMethod(action = "doPayment")
    @WebResult(name = "doPaymentResponse", targetNamespace = "http://services.bellatrix.org/", partName = "doPaymentResponse")
    public PaymentResponse doPayment(
        @WebParam(partName = "headerAuth", mode = WebParam.Mode.INOUT, name = "headerAuth", targetNamespace = "http://services.bellatrix.org/", header = true)
        javax.xml.ws.Holder<Header> headerAuth,
        @WebParam(partName = "doPayment", name = "doPayment", targetNamespace = "http://services.bellatrix.org/")
        PaymentRequest doPayment
    );

    @WebMethod(action = "merchantRequestPayment")
    @WebResult(name = "merchantRequestPaymentResponse", targetNamespace = "http://services.bellatrix.org/", partName = "merchantRequestPaymentResponse")
    public RequestPaymentConfirmationResponse merchantRequestPayment(
        @WebParam(partName = "headerAuth", mode = WebParam.Mode.INOUT, name = "headerAuth", targetNamespace = "http://services.bellatrix.org/", header = true)
        javax.xml.ws.Holder<Header> headerAuth,
        @WebParam(partName = "merchantRequestPayment", name = "merchantRequestPayment", targetNamespace = "http://services.bellatrix.org/")
        PaymentRequest merchantRequestPayment
    );

    @WebMethod(action = "transactionStatus")
    @WebResult(name = "transactionStatusResponse", targetNamespace = "http://services.bellatrix.org/", partName = "transactionStatusResponse")
    public TransactionStatusResponse transactionStatus(
        @WebParam(partName = "headerAuth", mode = WebParam.Mode.INOUT, name = "headerAuth", targetNamespace = "http://services.bellatrix.org/", header = true)
        javax.xml.ws.Holder<Header> headerAuth,
        @WebParam(partName = "transactionStatus", name = "transactionStatus", targetNamespace = "http://services.bellatrix.org/")
        TransactionStatusRequest transactionStatus
    );

    @WebMethod(action = "requestPaymentConfirmation")
    @WebResult(name = "requestPaymentConfirmationResponse", targetNamespace = "http://services.bellatrix.org/", partName = "requestPaymentConfirmationResponse")
    public RequestPaymentConfirmationResponse requestPaymentConfirmation(
        @WebParam(partName = "headerAuth", mode = WebParam.Mode.INOUT, name = "headerAuth", targetNamespace = "http://services.bellatrix.org/", header = true)
        javax.xml.ws.Holder<Header> headerAuth,
        @WebParam(partName = "requestPaymentConfirmation", name = "requestPaymentConfirmation", targetNamespace = "http://services.bellatrix.org/")
        PaymentRequest requestPaymentConfirmation
    );

    @WebMethod(action = "generatePaymentTicket")
    @WebResult(name = "generatePaymentTicketResponse", targetNamespace = "http://services.bellatrix.org/", partName = "generatePaymentTicketResponse")
    public GeneratePaymentTicketResponse generatePaymentTicket(
        @WebParam(partName = "headerAuth", mode = WebParam.Mode.INOUT, name = "headerAuth", targetNamespace = "http://services.bellatrix.org/", header = true)
        javax.xml.ws.Holder<Header> headerAuth,
        @WebParam(partName = "generatePaymentTicket", name = "generatePaymentTicket", targetNamespace = "http://services.bellatrix.org/")
        GeneratePaymentTicketRequest generatePaymentTicket
    );

    @WebMethod(action = "updateTransfer")
    public void updateTransfer(
        @WebParam(partName = "headerAuth", mode = WebParam.Mode.INOUT, name = "headerAuth", targetNamespace = "http://services.bellatrix.org/", header = true)
        javax.xml.ws.Holder<Header> headerAuth,
        @WebParam(partName = "updateTransfer", name = "updateTransfer", targetNamespace = "http://services.bellatrix.org/")
        UpdateTransferRequest updateTransfer
    ) throws Exception_Exception;

    @WebMethod(action = "agentCashoutConfirmation")
    @WebResult(name = "agentCashoutConfirmationResponse", targetNamespace = "http://services.bellatrix.org/", partName = "agentCashoutConfirmationResponse")
    public AgentCashoutResponse agentCashoutConfirmation(
        @WebParam(partName = "headerAuth", mode = WebParam.Mode.INOUT, name = "headerAuth", targetNamespace = "http://services.bellatrix.org/", header = true)
        javax.xml.ws.Holder<Header> headerAuth,
        @WebParam(partName = "agentCashoutConfirmation", name = "agentCashoutConfirmation", targetNamespace = "http://services.bellatrix.org/")
        AgentCashoutRequest agentCashoutConfirmation
    );

    @WebMethod(action = "confirmPaymentTicket")
    @WebResult(name = "confirmPaymentTicketResponse", targetNamespace = "http://services.bellatrix.org/", partName = "confirmPaymentTicketResponse")
    public PaymentResponse confirmPaymentTicket(
        @WebParam(partName = "headerAuth", mode = WebParam.Mode.INOUT, name = "headerAuth", targetNamespace = "http://services.bellatrix.org/", header = true)
        javax.xml.ws.Holder<Header> headerAuth,
        @WebParam(partName = "confirmPaymentTicket", name = "confirmPaymentTicket", targetNamespace = "http://services.bellatrix.org/")
        ConfirmPaymentTicketRequest confirmPaymentTicket
    );

    @WebMethod(action = "merchantConfirmPayment")
    @WebResult(name = "merchantConfirmPaymentResponse", targetNamespace = "http://services.bellatrix.org/", partName = "merchantConfirmPaymentResponse")
    public PaymentResponse merchantConfirmPayment(
        @WebParam(partName = "headerAuth", mode = WebParam.Mode.INOUT, name = "headerAuth", targetNamespace = "http://services.bellatrix.org/", header = true)
        javax.xml.ws.Holder<Header> headerAuth,
        @WebParam(partName = "merchantConfirmPayment", name = "merchantConfirmPayment", targetNamespace = "http://services.bellatrix.org/")
        ConfirmPaymentRequest merchantConfirmPayment
    );

    @WebMethod(action = "confirmAgentCashout")
    @WebResult(name = "confirmAgentCashoutResponse", targetNamespace = "http://services.bellatrix.org/", partName = "confirmAgentCashoutResponse")
    public ConfirmAgentCashoutResponse confirmAgentCashout(
        @WebParam(partName = "headerAuth", mode = WebParam.Mode.INOUT, name = "headerAuth", targetNamespace = "http://services.bellatrix.org/", header = true)
        javax.xml.ws.Holder<Header> headerAuth,
        @WebParam(partName = "confirmAgentCashout", name = "confirmAgentCashout", targetNamespace = "http://services.bellatrix.org/")
        ConfirmAgentCashoutRequest confirmAgentCashout
    );

    @WebMethod(action = "doInquiry")
    @WebResult(name = "doInquiryResponse", targetNamespace = "http://services.bellatrix.org/", partName = "doInquiryResponse")
    public InquiryResponse doInquiry(
        @WebParam(partName = "headerAuth", mode = WebParam.Mode.INOUT, name = "headerAuth", targetNamespace = "http://services.bellatrix.org/", header = true)
        javax.xml.ws.Holder<Header> headerAuth,
        @WebParam(partName = "doInquiry", name = "doInquiry", targetNamespace = "http://services.bellatrix.org/")
        InquiryRequest doInquiry
    );

    @WebMethod(action = "confirmPayment")
    @WebResult(name = "confirmPaymentResponse", targetNamespace = "http://services.bellatrix.org/", partName = "confirmPaymentResponse")
    public PaymentResponse confirmPayment(
        @WebParam(partName = "headerAuth", mode = WebParam.Mode.INOUT, name = "headerAuth", targetNamespace = "http://services.bellatrix.org/", header = true)
        javax.xml.ws.Holder<Header> headerAuth,
        @WebParam(partName = "confirmPayment", name = "confirmPayment", targetNamespace = "http://services.bellatrix.org/")
        ConfirmPaymentRequest confirmPayment
    );
}
