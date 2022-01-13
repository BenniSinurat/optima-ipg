
package org.bellatrix.services.ws.pos;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.bellatrix.services.ws.pos package. 
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

    private final static QName _PosGenerateInvoiceResponse_QNAME = new QName("http://services.bellatrix.org/", "posGenerateInvoiceResponse");
    private final static QName _Exception_QNAME = new QName("http://services.bellatrix.org/", "Exception");
    private final static QName _PosInquiry_QNAME = new QName("http://services.bellatrix.org/", "posInquiry");
    private final static QName _DoPaymentQRIS_QNAME = new QName("http://services.bellatrix.org/", "doPaymentQRIS");
    private final static QName _RegisterPOS_QNAME = new QName("http://services.bellatrix.org/", "registerPOS");
    private final static QName _LoadTerminalByIDResponse_QNAME = new QName("http://services.bellatrix.org/", "loadTerminalByIDResponse");
    private final static QName _PosInquiryResponse_QNAME = new QName("http://services.bellatrix.org/", "posInquiryResponse");
    private final static QName _HeaderAuth_QNAME = new QName("http://services.bellatrix.org/", "headerAuth");
    private final static QName _PosPayment_QNAME = new QName("http://services.bellatrix.org/", "posPayment");
    private final static QName _DoPaymentQRISResponse_QNAME = new QName("http://services.bellatrix.org/", "doPaymentQRISResponse");
    private final static QName _PosPaymentResponse_QNAME = new QName("http://services.bellatrix.org/", "posPaymentResponse");
    private final static QName _UpdatePOS_QNAME = new QName("http://services.bellatrix.org/", "updatePOS");
    private final static QName _DeletePOS_QNAME = new QName("http://services.bellatrix.org/", "deletePOS");
    private final static QName _PosGenerateInvoice_QNAME = new QName("http://services.bellatrix.org/", "posGenerateInvoice");
    private final static QName _LoadTerminalByID_QNAME = new QName("http://services.bellatrix.org/", "loadTerminalByID");
    private final static QName _LoadTerminalByUsername_QNAME = new QName("http://services.bellatrix.org/", "loadTerminalByUsername");
    private final static QName _LoadTerminalByUsernameResponse_QNAME = new QName("http://services.bellatrix.org/", "loadTerminalByUsernameResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.bellatrix.services.ws.pos
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RegisterPOSRequest }
     * 
     */
    public RegisterPOSRequest createRegisterPOSRequest() {
        return new RegisterPOSRequest();
    }

    /**
     * Create an instance of {@link TransferTypeFields }
     * 
     */
    public TransferTypeFields createTransferTypeFields() {
        return new TransferTypeFields();
    }

    /**
     * Create an instance of {@link LoadTerminalByIDRequest }
     * 
     */
    public LoadTerminalByIDRequest createLoadTerminalByIDRequest() {
        return new LoadTerminalByIDRequest();
    }

    /**
     * Create an instance of {@link PaymentResponse }
     * 
     */
    public PaymentResponse createPaymentResponse() {
        return new PaymentResponse();
    }

    /**
     * Create an instance of {@link UpdatePOSRequest }
     * 
     */
    public UpdatePOSRequest createUpdatePOSRequest() {
        return new UpdatePOSRequest();
    }

    /**
     * Create an instance of {@link PosPaymentResponse }
     * 
     */
    public PosPaymentResponse createPosPaymentResponse() {
        return new PosPaymentResponse();
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
    }

    /**
     * Create an instance of {@link PaymentRequest }
     * 
     */
    public PaymentRequest createPaymentRequest() {
        return new PaymentRequest();
    }

    /**
     * Create an instance of {@link DeletePOSRequest }
     * 
     */
    public DeletePOSRequest createDeletePOSRequest() {
        return new DeletePOSRequest();
    }

    /**
     * Create an instance of {@link PosCreateInvoiceResponse }
     * 
     */
    public PosCreateInvoiceResponse createPosCreateInvoiceResponse() {
        return new PosCreateInvoiceResponse();
    }

    /**
     * Create an instance of {@link LoadTerminalByUsernameRequest }
     * 
     */
    public LoadTerminalByUsernameRequest createLoadTerminalByUsernameRequest() {
        return new LoadTerminalByUsernameRequest();
    }

    /**
     * Create an instance of {@link TerminalInquiryResponse }
     * 
     */
    public TerminalInquiryResponse createTerminalInquiryResponse() {
        return new TerminalInquiryResponse();
    }

    /**
     * Create an instance of {@link PosInquiryRequest }
     * 
     */
    public PosInquiryRequest createPosInquiryRequest() {
        return new PosInquiryRequest();
    }

    /**
     * Create an instance of {@link PosCreateInvoiceRequest }
     * 
     */
    public PosCreateInvoiceRequest createPosCreateInvoiceRequest() {
        return new PosCreateInvoiceRequest();
    }

    /**
     * Create an instance of {@link PosPaymentRequest }
     * 
     */
    public PosPaymentRequest createPosPaymentRequest() {
        return new PosPaymentRequest();
    }

    /**
     * Create an instance of {@link TerminalView }
     * 
     */
    public TerminalView createTerminalView() {
        return new TerminalView();
    }

    /**
     * Create an instance of {@link PosInquiryResponse }
     * 
     */
    public PosInquiryResponse createPosInquiryResponse() {
        return new PosInquiryResponse();
    }

    /**
     * Create an instance of {@link Header }
     * 
     */
    public Header createHeader() {
        return new Header();
    }

    /**
     * Create an instance of {@link ResponseStatus }
     * 
     */
    public ResponseStatus createResponseStatus() {
        return new ResponseStatus();
    }

    /**
     * Create an instance of {@link MemberView }
     * 
     */
    public MemberView createMemberView() {
        return new MemberView();
    }

    /**
     * Create an instance of {@link PaymentFields }
     * 
     */
    public PaymentFields createPaymentFields() {
        return new PaymentFields();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PosCreateInvoiceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "posGenerateInvoiceResponse")
    public JAXBElement<PosCreateInvoiceResponse> createPosGenerateInvoiceResponse(PosCreateInvoiceResponse value) {
        return new JAXBElement<PosCreateInvoiceResponse>(_PosGenerateInvoiceResponse_QNAME, PosCreateInvoiceResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link PosInquiryRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "posInquiry")
    public JAXBElement<PosInquiryRequest> createPosInquiry(PosInquiryRequest value) {
        return new JAXBElement<PosInquiryRequest>(_PosInquiry_QNAME, PosInquiryRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PaymentRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "doPaymentQRIS")
    public JAXBElement<PaymentRequest> createDoPaymentQRIS(PaymentRequest value) {
        return new JAXBElement<PaymentRequest>(_DoPaymentQRIS_QNAME, PaymentRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegisterPOSRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "registerPOS")
    public JAXBElement<RegisterPOSRequest> createRegisterPOS(RegisterPOSRequest value) {
        return new JAXBElement<RegisterPOSRequest>(_RegisterPOS_QNAME, RegisterPOSRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TerminalInquiryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "loadTerminalByIDResponse")
    public JAXBElement<TerminalInquiryResponse> createLoadTerminalByIDResponse(TerminalInquiryResponse value) {
        return new JAXBElement<TerminalInquiryResponse>(_LoadTerminalByIDResponse_QNAME, TerminalInquiryResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PosInquiryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "posInquiryResponse")
    public JAXBElement<PosInquiryResponse> createPosInquiryResponse(PosInquiryResponse value) {
        return new JAXBElement<PosInquiryResponse>(_PosInquiryResponse_QNAME, PosInquiryResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link PosPaymentRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "posPayment")
    public JAXBElement<PosPaymentRequest> createPosPayment(PosPaymentRequest value) {
        return new JAXBElement<PosPaymentRequest>(_PosPayment_QNAME, PosPaymentRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PaymentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "doPaymentQRISResponse")
    public JAXBElement<PaymentResponse> createDoPaymentQRISResponse(PaymentResponse value) {
        return new JAXBElement<PaymentResponse>(_DoPaymentQRISResponse_QNAME, PaymentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PosPaymentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "posPaymentResponse")
    public JAXBElement<PosPaymentResponse> createPosPaymentResponse(PosPaymentResponse value) {
        return new JAXBElement<PosPaymentResponse>(_PosPaymentResponse_QNAME, PosPaymentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdatePOSRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "updatePOS")
    public JAXBElement<UpdatePOSRequest> createUpdatePOS(UpdatePOSRequest value) {
        return new JAXBElement<UpdatePOSRequest>(_UpdatePOS_QNAME, UpdatePOSRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeletePOSRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "deletePOS")
    public JAXBElement<DeletePOSRequest> createDeletePOS(DeletePOSRequest value) {
        return new JAXBElement<DeletePOSRequest>(_DeletePOS_QNAME, DeletePOSRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PosCreateInvoiceRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "posGenerateInvoice")
    public JAXBElement<PosCreateInvoiceRequest> createPosGenerateInvoice(PosCreateInvoiceRequest value) {
        return new JAXBElement<PosCreateInvoiceRequest>(_PosGenerateInvoice_QNAME, PosCreateInvoiceRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadTerminalByIDRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "loadTerminalByID")
    public JAXBElement<LoadTerminalByIDRequest> createLoadTerminalByID(LoadTerminalByIDRequest value) {
        return new JAXBElement<LoadTerminalByIDRequest>(_LoadTerminalByID_QNAME, LoadTerminalByIDRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadTerminalByUsernameRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "loadTerminalByUsername")
    public JAXBElement<LoadTerminalByUsernameRequest> createLoadTerminalByUsername(LoadTerminalByUsernameRequest value) {
        return new JAXBElement<LoadTerminalByUsernameRequest>(_LoadTerminalByUsername_QNAME, LoadTerminalByUsernameRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TerminalInquiryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "loadTerminalByUsernameResponse")
    public JAXBElement<TerminalInquiryResponse> createLoadTerminalByUsernameResponse(TerminalInquiryResponse value) {
        return new JAXBElement<TerminalInquiryResponse>(_LoadTerminalByUsernameResponse_QNAME, TerminalInquiryResponse.class, null, value);
    }

}
