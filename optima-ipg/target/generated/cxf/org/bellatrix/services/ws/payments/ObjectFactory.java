
package org.bellatrix.services.ws.payments;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.bellatrix.services.ws.payments package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AgentCashoutConfirmationResponse_QNAME = new QName("http://services.bellatrix.org/", "agentCashoutConfirmationResponse");
    private final static QName _Exception_QNAME = new QName("http://services.bellatrix.org/", "Exception");
    private final static QName _RequestPaymentConfirmationResponse_QNAME = new QName("http://services.bellatrix.org/", "requestPaymentConfirmationResponse");
    private final static QName _ReversePayment_QNAME = new QName("http://services.bellatrix.org/", "reversePayment");
    private final static QName _ValidatePaymentTicket_QNAME = new QName("http://services.bellatrix.org/", "validatePaymentTicket");
    private final static QName _MerchantRequestPayment_QNAME = new QName("http://services.bellatrix.org/", "merchantRequestPayment");
    private final static QName _TransactionStatus_QNAME = new QName("http://services.bellatrix.org/", "transactionStatus");
    private final static QName _UpdateTransfer_QNAME = new QName("http://services.bellatrix.org/", "updateTransfer");
    private final static QName _DoPaymentResponse_QNAME = new QName("http://services.bellatrix.org/", "doPaymentResponse");
    private final static QName _MerchantConfirmPaymentResponse_QNAME = new QName("http://services.bellatrix.org/", "merchantConfirmPaymentResponse");
    private final static QName _ConfirmAgentCashoutResponse_QNAME = new QName("http://services.bellatrix.org/", "confirmAgentCashoutResponse");
    private final static QName _ReversePaymentResponse_QNAME = new QName("http://services.bellatrix.org/", "reversePaymentResponse");
    private final static QName _ConfirmPaymentTicketResponse_QNAME = new QName("http://services.bellatrix.org/", "confirmPaymentTicketResponse");
    private final static QName _TransactionStatusResponse_QNAME = new QName("http://services.bellatrix.org/", "transactionStatusResponse");
    private final static QName _ConfirmAgentCashout_QNAME = new QName("http://services.bellatrix.org/", "confirmAgentCashout");
    private final static QName _DoInquiryResponse_QNAME = new QName("http://services.bellatrix.org/", "doInquiryResponse");
    private final static QName _MerchantRequestPaymentResponse_QNAME = new QName("http://services.bellatrix.org/", "merchantRequestPaymentResponse");
    private final static QName _ConfirmPayment_QNAME = new QName("http://services.bellatrix.org/", "confirmPayment");
    private final static QName _DoPayment_QNAME = new QName("http://services.bellatrix.org/", "doPayment");
    private final static QName _HeaderAuth_QNAME = new QName("http://services.bellatrix.org/", "headerAuth");
    private final static QName _RequestPaymentConfirmation_QNAME = new QName("http://services.bellatrix.org/", "requestPaymentConfirmation");
    private final static QName _GeneratePaymentTicket_QNAME = new QName("http://services.bellatrix.org/", "generatePaymentTicket");
    private final static QName _AgentCashoutConfirmation_QNAME = new QName("http://services.bellatrix.org/", "agentCashoutConfirmation");
    private final static QName _ConfirmPaymentTicket_QNAME = new QName("http://services.bellatrix.org/", "confirmPaymentTicket");
    private final static QName _GeneratePaymentTicketResponse_QNAME = new QName("http://services.bellatrix.org/", "generatePaymentTicketResponse");
    private final static QName _MerchantConfirmPayment_QNAME = new QName("http://services.bellatrix.org/", "merchantConfirmPayment");
    private final static QName _ValidatePaymentTicketResponse_QNAME = new QName("http://services.bellatrix.org/", "validatePaymentTicketResponse");
    private final static QName _DoInquiry_QNAME = new QName("http://services.bellatrix.org/", "doInquiry");
    private final static QName _ConfirmPaymentResponse_QNAME = new QName("http://services.bellatrix.org/", "confirmPaymentResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.bellatrix.services.ws.payments
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ConfirmPaymentTicketRequest }
     * 
     */
    public ConfirmPaymentTicketRequest createConfirmPaymentTicketRequest() {
        return new ConfirmPaymentTicketRequest();
    }

    /**
     * Create an instance of {@link TransactionStatusRequest }
     * 
     */
    public TransactionStatusRequest createTransactionStatusRequest() {
        return new TransactionStatusRequest();
    }

    /**
     * Create an instance of {@link RequestPaymentConfirmationResponse }
     * 
     */
    public RequestPaymentConfirmationResponse createRequestPaymentConfirmationResponse() {
        return new RequestPaymentConfirmationResponse();
    }

    /**
     * Create an instance of {@link PaymentRequest }
     * 
     */
    public PaymentRequest createPaymentRequest() {
        return new PaymentRequest();
    }

    /**
     * Create an instance of {@link TransferTypeFields }
     * 
     */
    public TransferTypeFields createTransferTypeFields() {
        return new TransferTypeFields();
    }

    /**
     * Create an instance of {@link ReversalResponse }
     * 
     */
    public ReversalResponse createReversalResponse() {
        return new ReversalResponse();
    }

    /**
     * Create an instance of {@link ResponseStatus }
     * 
     */
    public ResponseStatus createResponseStatus() {
        return new ResponseStatus();
    }

    /**
     * Create an instance of {@link InquiryRequest }
     * 
     */
    public InquiryRequest createInquiryRequest() {
        return new InquiryRequest();
    }

    /**
     * Create an instance of {@link GeneratePaymentTicketRequest }
     * 
     */
    public GeneratePaymentTicketRequest createGeneratePaymentTicketRequest() {
        return new GeneratePaymentTicketRequest();
    }

    /**
     * Create an instance of {@link Header }
     * 
     */
    public Header createHeader() {
        return new Header();
    }

    /**
     * Create an instance of {@link UpdateTransferRequest }
     * 
     */
    public UpdateTransferRequest createUpdateTransferRequest() {
        return new UpdateTransferRequest();
    }

    /**
     * Create an instance of {@link ReversalRequest }
     * 
     */
    public ReversalRequest createReversalRequest() {
        return new ReversalRequest();
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
    }

    /**
     * Create an instance of {@link PaymentFields }
     * 
     */
    public PaymentFields createPaymentFields() {
        return new PaymentFields();
    }

    /**
     * Create an instance of {@link TransactionStatusResponse }
     * 
     */
    public TransactionStatusResponse createTransactionStatusResponse() {
        return new TransactionStatusResponse();
    }

    /**
     * Create an instance of {@link ConfirmAgentCashoutResponse }
     * 
     */
    public ConfirmAgentCashoutResponse createConfirmAgentCashoutResponse() {
        return new ConfirmAgentCashoutResponse();
    }

    /**
     * Create an instance of {@link TransferHistory }
     * 
     */
    public TransferHistory createTransferHistory() {
        return new TransferHistory();
    }

    /**
     * Create an instance of {@link ValidatePaymentTicketResponse }
     * 
     */
    public ValidatePaymentTicketResponse createValidatePaymentTicketResponse() {
        return new ValidatePaymentTicketResponse();
    }

    /**
     * Create an instance of {@link PaymentResponse }
     * 
     */
    public PaymentResponse createPaymentResponse() {
        return new PaymentResponse();
    }

    /**
     * Create an instance of {@link GeneratePaymentTicketResponse }
     * 
     */
    public GeneratePaymentTicketResponse createGeneratePaymentTicketResponse() {
        return new GeneratePaymentTicketResponse();
    }

    /**
     * Create an instance of {@link MemberView }
     * 
     */
    public MemberView createMemberView() {
        return new MemberView();
    }

    /**
     * Create an instance of {@link AgentCashoutResponse }
     * 
     */
    public AgentCashoutResponse createAgentCashoutResponse() {
        return new AgentCashoutResponse();
    }

    /**
     * Create an instance of {@link InquiryResponse }
     * 
     */
    public InquiryResponse createInquiryResponse() {
        return new InquiryResponse();
    }

    /**
     * Create an instance of {@link ConfirmPaymentRequest }
     * 
     */
    public ConfirmPaymentRequest createConfirmPaymentRequest() {
        return new ConfirmPaymentRequest();
    }

    /**
     * Create an instance of {@link ValidatePaymentTicketRequest }
     * 
     */
    public ValidatePaymentTicketRequest createValidatePaymentTicketRequest() {
        return new ValidatePaymentTicketRequest();
    }

    /**
     * Create an instance of {@link ConfirmAgentCashoutRequest }
     * 
     */
    public ConfirmAgentCashoutRequest createConfirmAgentCashoutRequest() {
        return new ConfirmAgentCashoutRequest();
    }

    /**
     * Create an instance of {@link AgentCashoutRequest }
     * 
     */
    public AgentCashoutRequest createAgentCashoutRequest() {
        return new AgentCashoutRequest();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AgentCashoutResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "agentCashoutConfirmationResponse")
    public JAXBElement<AgentCashoutResponse> createAgentCashoutConfirmationResponse(AgentCashoutResponse value) {
        return new JAXBElement<AgentCashoutResponse>(_AgentCashoutConfirmationResponse_QNAME, AgentCashoutResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Exception }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "Exception")
    public JAXBElement<Exception> createException(Exception value) {
        return new JAXBElement<Exception>(_Exception_QNAME, Exception.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RequestPaymentConfirmationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "requestPaymentConfirmationResponse")
    public JAXBElement<RequestPaymentConfirmationResponse> createRequestPaymentConfirmationResponse(RequestPaymentConfirmationResponse value) {
        return new JAXBElement<RequestPaymentConfirmationResponse>(_RequestPaymentConfirmationResponse_QNAME, RequestPaymentConfirmationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReversalRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "reversePayment")
    public JAXBElement<ReversalRequest> createReversePayment(ReversalRequest value) {
        return new JAXBElement<ReversalRequest>(_ReversePayment_QNAME, ReversalRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidatePaymentTicketRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "validatePaymentTicket")
    public JAXBElement<ValidatePaymentTicketRequest> createValidatePaymentTicket(ValidatePaymentTicketRequest value) {
        return new JAXBElement<ValidatePaymentTicketRequest>(_ValidatePaymentTicket_QNAME, ValidatePaymentTicketRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PaymentRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "merchantRequestPayment")
    public JAXBElement<PaymentRequest> createMerchantRequestPayment(PaymentRequest value) {
        return new JAXBElement<PaymentRequest>(_MerchantRequestPayment_QNAME, PaymentRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TransactionStatusRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "transactionStatus")
    public JAXBElement<TransactionStatusRequest> createTransactionStatus(TransactionStatusRequest value) {
        return new JAXBElement<TransactionStatusRequest>(_TransactionStatus_QNAME, TransactionStatusRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateTransferRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "updateTransfer")
    public JAXBElement<UpdateTransferRequest> createUpdateTransfer(UpdateTransferRequest value) {
        return new JAXBElement<UpdateTransferRequest>(_UpdateTransfer_QNAME, UpdateTransferRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PaymentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "doPaymentResponse")
    public JAXBElement<PaymentResponse> createDoPaymentResponse(PaymentResponse value) {
        return new JAXBElement<PaymentResponse>(_DoPaymentResponse_QNAME, PaymentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PaymentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "merchantConfirmPaymentResponse")
    public JAXBElement<PaymentResponse> createMerchantConfirmPaymentResponse(PaymentResponse value) {
        return new JAXBElement<PaymentResponse>(_MerchantConfirmPaymentResponse_QNAME, PaymentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConfirmAgentCashoutResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "confirmAgentCashoutResponse")
    public JAXBElement<ConfirmAgentCashoutResponse> createConfirmAgentCashoutResponse(ConfirmAgentCashoutResponse value) {
        return new JAXBElement<ConfirmAgentCashoutResponse>(_ConfirmAgentCashoutResponse_QNAME, ConfirmAgentCashoutResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReversalResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "reversePaymentResponse")
    public JAXBElement<ReversalResponse> createReversePaymentResponse(ReversalResponse value) {
        return new JAXBElement<ReversalResponse>(_ReversePaymentResponse_QNAME, ReversalResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PaymentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "confirmPaymentTicketResponse")
    public JAXBElement<PaymentResponse> createConfirmPaymentTicketResponse(PaymentResponse value) {
        return new JAXBElement<PaymentResponse>(_ConfirmPaymentTicketResponse_QNAME, PaymentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TransactionStatusResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "transactionStatusResponse")
    public JAXBElement<TransactionStatusResponse> createTransactionStatusResponse(TransactionStatusResponse value) {
        return new JAXBElement<TransactionStatusResponse>(_TransactionStatusResponse_QNAME, TransactionStatusResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConfirmAgentCashoutRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "confirmAgentCashout")
    public JAXBElement<ConfirmAgentCashoutRequest> createConfirmAgentCashout(ConfirmAgentCashoutRequest value) {
        return new JAXBElement<ConfirmAgentCashoutRequest>(_ConfirmAgentCashout_QNAME, ConfirmAgentCashoutRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InquiryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "doInquiryResponse")
    public JAXBElement<InquiryResponse> createDoInquiryResponse(InquiryResponse value) {
        return new JAXBElement<InquiryResponse>(_DoInquiryResponse_QNAME, InquiryResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RequestPaymentConfirmationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "merchantRequestPaymentResponse")
    public JAXBElement<RequestPaymentConfirmationResponse> createMerchantRequestPaymentResponse(RequestPaymentConfirmationResponse value) {
        return new JAXBElement<RequestPaymentConfirmationResponse>(_MerchantRequestPaymentResponse_QNAME, RequestPaymentConfirmationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConfirmPaymentRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "confirmPayment")
    public JAXBElement<ConfirmPaymentRequest> createConfirmPayment(ConfirmPaymentRequest value) {
        return new JAXBElement<ConfirmPaymentRequest>(_ConfirmPayment_QNAME, ConfirmPaymentRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PaymentRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "doPayment")
    public JAXBElement<PaymentRequest> createDoPayment(PaymentRequest value) {
        return new JAXBElement<PaymentRequest>(_DoPayment_QNAME, PaymentRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Header }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "headerAuth")
    public JAXBElement<Header> createHeaderAuth(Header value) {
        return new JAXBElement<Header>(_HeaderAuth_QNAME, Header.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PaymentRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "requestPaymentConfirmation")
    public JAXBElement<PaymentRequest> createRequestPaymentConfirmation(PaymentRequest value) {
        return new JAXBElement<PaymentRequest>(_RequestPaymentConfirmation_QNAME, PaymentRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GeneratePaymentTicketRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "generatePaymentTicket")
    public JAXBElement<GeneratePaymentTicketRequest> createGeneratePaymentTicket(GeneratePaymentTicketRequest value) {
        return new JAXBElement<GeneratePaymentTicketRequest>(_GeneratePaymentTicket_QNAME, GeneratePaymentTicketRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AgentCashoutRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "agentCashoutConfirmation")
    public JAXBElement<AgentCashoutRequest> createAgentCashoutConfirmation(AgentCashoutRequest value) {
        return new JAXBElement<AgentCashoutRequest>(_AgentCashoutConfirmation_QNAME, AgentCashoutRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConfirmPaymentTicketRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "confirmPaymentTicket")
    public JAXBElement<ConfirmPaymentTicketRequest> createConfirmPaymentTicket(ConfirmPaymentTicketRequest value) {
        return new JAXBElement<ConfirmPaymentTicketRequest>(_ConfirmPaymentTicket_QNAME, ConfirmPaymentTicketRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GeneratePaymentTicketResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "generatePaymentTicketResponse")
    public JAXBElement<GeneratePaymentTicketResponse> createGeneratePaymentTicketResponse(GeneratePaymentTicketResponse value) {
        return new JAXBElement<GeneratePaymentTicketResponse>(_GeneratePaymentTicketResponse_QNAME, GeneratePaymentTicketResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConfirmPaymentRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "merchantConfirmPayment")
    public JAXBElement<ConfirmPaymentRequest> createMerchantConfirmPayment(ConfirmPaymentRequest value) {
        return new JAXBElement<ConfirmPaymentRequest>(_MerchantConfirmPayment_QNAME, ConfirmPaymentRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidatePaymentTicketResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "validatePaymentTicketResponse")
    public JAXBElement<ValidatePaymentTicketResponse> createValidatePaymentTicketResponse(ValidatePaymentTicketResponse value) {
        return new JAXBElement<ValidatePaymentTicketResponse>(_ValidatePaymentTicketResponse_QNAME, ValidatePaymentTicketResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InquiryRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "doInquiry")
    public JAXBElement<InquiryRequest> createDoInquiry(InquiryRequest value) {
        return new JAXBElement<InquiryRequest>(_DoInquiry_QNAME, InquiryRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PaymentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "confirmPaymentResponse")
    public JAXBElement<PaymentResponse> createConfirmPaymentResponse(PaymentResponse value) {
        return new JAXBElement<PaymentResponse>(_ConfirmPaymentResponse_QNAME, PaymentResponse.class, null, value);
    }

}
