
package org.bellatrix.services.ws.billpayments;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.bellatrix.services.ws.billpayments package. 
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

    private final static QName _Exception_QNAME = new QName("http://services.bellatrix.org/", "Exception");
    private final static QName _PaymentBilling_QNAME = new QName("http://services.bellatrix.org/", "paymentBilling");
    private final static QName _LoadBillersFromIDResponse_QNAME = new QName("http://services.bellatrix.org/", "loadBillersFromIDResponse");
    private final static QName _LoadPermissionsByPaymentChannelResponse_QNAME = new QName("http://services.bellatrix.org/", "loadPermissionsByPaymentChannelResponse");
    private final static QName _PaymentBillingResponse_QNAME = new QName("http://services.bellatrix.org/", "paymentBillingResponse");
    private final static QName _LoadPaymentChannelByMemberID_QNAME = new QName("http://services.bellatrix.org/", "loadPaymentChannelByMemberID");
    private final static QName _CreatePaymentChannelPermissions_QNAME = new QName("http://services.bellatrix.org/", "createPaymentChannelPermissions");
    private final static QName _RegisterBiller_QNAME = new QName("http://services.bellatrix.org/", "registerBiller");
    private final static QName _HeaderAuth_QNAME = new QName("http://services.bellatrix.org/", "headerAuth");
    private final static QName _LoadPaymentChannelByID_QNAME = new QName("http://services.bellatrix.org/", "loadPaymentChannelByID");
    private final static QName _LoadBillersFromUsername_QNAME = new QName("http://services.bellatrix.org/", "loadBillersFromUsername");
    private final static QName _LoadPaymentChannelByIDResponse_QNAME = new QName("http://services.bellatrix.org/", "loadPaymentChannelByIDResponse");
    private final static QName _LoadPaymentChannelByMemberIDResponse_QNAME = new QName("http://services.bellatrix.org/", "loadPaymentChannelByMemberIDResponse");
    private final static QName _LoadBillersFromUsernameResponse_QNAME = new QName("http://services.bellatrix.org/", "loadBillersFromUsernameResponse");
    private final static QName _UpdatePaymentChannelPermissions_QNAME = new QName("http://services.bellatrix.org/", "updatePaymentChannelPermissions");
    private final static QName _CreatePaymentChannel_QNAME = new QName("http://services.bellatrix.org/", "createPaymentChannel");
    private final static QName _LoadPermissionsByPaymentChannel_QNAME = new QName("http://services.bellatrix.org/", "loadPermissionsByPaymentChannel");
    private final static QName _DeletePaymentChannelPermissions_QNAME = new QName("http://services.bellatrix.org/", "deletePaymentChannelPermissions");
    private final static QName _UpdatePaymentChannel_QNAME = new QName("http://services.bellatrix.org/", "updatePaymentChannel");
    private final static QName _LoadBillersFromID_QNAME = new QName("http://services.bellatrix.org/", "loadBillersFromID");
    private final static QName _InquiryBilling_QNAME = new QName("http://services.bellatrix.org/", "inquiryBilling");
    private final static QName _LoadPaymentChannelResponse_QNAME = new QName("http://services.bellatrix.org/", "loadPaymentChannelResponse");
    private final static QName _InquiryBillingResponse_QNAME = new QName("http://services.bellatrix.org/", "inquiryBillingResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.bellatrix.services.ws.billpayments
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link PaymentChannel }
     * 
     */
    public PaymentChannel createPaymentChannel() {
        return new PaymentChannel();
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
    }

    /**
     * Create an instance of {@link LoadPermissionByPaymentChannelRequest }
     * 
     */
    public LoadPermissionByPaymentChannelRequest createLoadPermissionByPaymentChannelRequest() {
        return new LoadPermissionByPaymentChannelRequest();
    }

    /**
     * Create an instance of {@link LoadPaymentChannelByIDRequest }
     * 
     */
    public LoadPaymentChannelByIDRequest createLoadPaymentChannelByIDRequest() {
        return new LoadPaymentChannelByIDRequest();
    }

    /**
     * Create an instance of {@link LoadPermissionByPaymentChannelResponse }
     * 
     */
    public LoadPermissionByPaymentChannelResponse createLoadPermissionByPaymentChannelResponse() {
        return new LoadPermissionByPaymentChannelResponse();
    }

    /**
     * Create an instance of {@link BillInquiryRequest }
     * 
     */
    public BillInquiryRequest createBillInquiryRequest() {
        return new BillInquiryRequest();
    }

    /**
     * Create an instance of {@link BillerRegisterRequest }
     * 
     */
    public BillerRegisterRequest createBillerRegisterRequest() {
        return new BillerRegisterRequest();
    }

    /**
     * Create an instance of {@link BillerDetailsRequest }
     * 
     */
    public BillerDetailsRequest createBillerDetailsRequest() {
        return new BillerDetailsRequest();
    }

    /**
     * Create an instance of {@link PaymentChannelRequest }
     * 
     */
    public PaymentChannelRequest createPaymentChannelRequest() {
        return new PaymentChannelRequest();
    }

    /**
     * Create an instance of {@link LoadPaymentChannelByMemberIDResponse }
     * 
     */
    public LoadPaymentChannelByMemberIDResponse createLoadPaymentChannelByMemberIDResponse() {
        return new LoadPaymentChannelByMemberIDResponse();
    }

    /**
     * Create an instance of {@link BillerListResponse }
     * 
     */
    public BillerListResponse createBillerListResponse() {
        return new BillerListResponse();
    }

    /**
     * Create an instance of {@link PaymentChannelResponse }
     * 
     */
    public PaymentChannelResponse createPaymentChannelResponse() {
        return new PaymentChannelResponse();
    }

    /**
     * Create an instance of {@link Header }
     * 
     */
    public Header createHeader() {
        return new Header();
    }

    /**
     * Create an instance of {@link PaymentChannelPermissionRequest }
     * 
     */
    public PaymentChannelPermissionRequest createPaymentChannelPermissionRequest() {
        return new PaymentChannelPermissionRequest();
    }

    /**
     * Create an instance of {@link BillPaymentResponse }
     * 
     */
    public BillPaymentResponse createBillPaymentResponse() {
        return new BillPaymentResponse();
    }

    /**
     * Create an instance of {@link PaymentChannelPermissions }
     * 
     */
    public PaymentChannelPermissions createPaymentChannelPermissions() {
        return new PaymentChannelPermissions();
    }

    /**
     * Create an instance of {@link Billers }
     * 
     */
    public Billers createBillers() {
        return new Billers();
    }

    /**
     * Create an instance of {@link LoadPaymentChannelByMemberIDRequest }
     * 
     */
    public LoadPaymentChannelByMemberIDRequest createLoadPaymentChannelByMemberIDRequest() {
        return new LoadPaymentChannelByMemberIDRequest();
    }

    /**
     * Create an instance of {@link BillInquiryResponse }
     * 
     */
    public BillInquiryResponse createBillInquiryResponse() {
        return new BillInquiryResponse();
    }

    /**
     * Create an instance of {@link ResponseStatus }
     * 
     */
    public ResponseStatus createResponseStatus() {
        return new ResponseStatus();
    }

    /**
     * Create an instance of {@link BillPaymentRequest }
     * 
     */
    public BillPaymentRequest createBillPaymentRequest() {
        return new BillPaymentRequest();
    }

    /**
     * Create an instance of {@link LoadPaymentChannelByIDResponse }
     * 
     */
    public LoadPaymentChannelByIDResponse createLoadPaymentChannelByIDResponse() {
        return new LoadPaymentChannelByIDResponse();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link BillPaymentRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "paymentBilling")
    public JAXBElement<BillPaymentRequest> createPaymentBilling(BillPaymentRequest value) {
        return new JAXBElement<BillPaymentRequest>(_PaymentBilling_QNAME, BillPaymentRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BillerListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "loadBillersFromIDResponse")
    public JAXBElement<BillerListResponse> createLoadBillersFromIDResponse(BillerListResponse value) {
        return new JAXBElement<BillerListResponse>(_LoadBillersFromIDResponse_QNAME, BillerListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadPermissionByPaymentChannelResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "loadPermissionsByPaymentChannelResponse")
    public JAXBElement<LoadPermissionByPaymentChannelResponse> createLoadPermissionsByPaymentChannelResponse(LoadPermissionByPaymentChannelResponse value) {
        return new JAXBElement<LoadPermissionByPaymentChannelResponse>(_LoadPermissionsByPaymentChannelResponse_QNAME, LoadPermissionByPaymentChannelResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BillPaymentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "paymentBillingResponse")
    public JAXBElement<BillPaymentResponse> createPaymentBillingResponse(BillPaymentResponse value) {
        return new JAXBElement<BillPaymentResponse>(_PaymentBillingResponse_QNAME, BillPaymentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadPaymentChannelByMemberIDRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "loadPaymentChannelByMemberID")
    public JAXBElement<LoadPaymentChannelByMemberIDRequest> createLoadPaymentChannelByMemberID(LoadPaymentChannelByMemberIDRequest value) {
        return new JAXBElement<LoadPaymentChannelByMemberIDRequest>(_LoadPaymentChannelByMemberID_QNAME, LoadPaymentChannelByMemberIDRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PaymentChannelPermissionRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "createPaymentChannelPermissions")
    public JAXBElement<PaymentChannelPermissionRequest> createCreatePaymentChannelPermissions(PaymentChannelPermissionRequest value) {
        return new JAXBElement<PaymentChannelPermissionRequest>(_CreatePaymentChannelPermissions_QNAME, PaymentChannelPermissionRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BillerRegisterRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "registerBiller")
    public JAXBElement<BillerRegisterRequest> createRegisterBiller(BillerRegisterRequest value) {
        return new JAXBElement<BillerRegisterRequest>(_RegisterBiller_QNAME, BillerRegisterRequest.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadPaymentChannelByIDRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "loadPaymentChannelByID")
    public JAXBElement<LoadPaymentChannelByIDRequest> createLoadPaymentChannelByID(LoadPaymentChannelByIDRequest value) {
        return new JAXBElement<LoadPaymentChannelByIDRequest>(_LoadPaymentChannelByID_QNAME, LoadPaymentChannelByIDRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BillerDetailsRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "loadBillersFromUsername")
    public JAXBElement<BillerDetailsRequest> createLoadBillersFromUsername(BillerDetailsRequest value) {
        return new JAXBElement<BillerDetailsRequest>(_LoadBillersFromUsername_QNAME, BillerDetailsRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadPaymentChannelByIDResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "loadPaymentChannelByIDResponse")
    public JAXBElement<LoadPaymentChannelByIDResponse> createLoadPaymentChannelByIDResponse(LoadPaymentChannelByIDResponse value) {
        return new JAXBElement<LoadPaymentChannelByIDResponse>(_LoadPaymentChannelByIDResponse_QNAME, LoadPaymentChannelByIDResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadPaymentChannelByMemberIDResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "loadPaymentChannelByMemberIDResponse")
    public JAXBElement<LoadPaymentChannelByMemberIDResponse> createLoadPaymentChannelByMemberIDResponse(LoadPaymentChannelByMemberIDResponse value) {
        return new JAXBElement<LoadPaymentChannelByMemberIDResponse>(_LoadPaymentChannelByMemberIDResponse_QNAME, LoadPaymentChannelByMemberIDResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BillerListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "loadBillersFromUsernameResponse")
    public JAXBElement<BillerListResponse> createLoadBillersFromUsernameResponse(BillerListResponse value) {
        return new JAXBElement<BillerListResponse>(_LoadBillersFromUsernameResponse_QNAME, BillerListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PaymentChannelPermissionRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "updatePaymentChannelPermissions")
    public JAXBElement<PaymentChannelPermissionRequest> createUpdatePaymentChannelPermissions(PaymentChannelPermissionRequest value) {
        return new JAXBElement<PaymentChannelPermissionRequest>(_UpdatePaymentChannelPermissions_QNAME, PaymentChannelPermissionRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PaymentChannelRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "createPaymentChannel")
    public JAXBElement<PaymentChannelRequest> createCreatePaymentChannel(PaymentChannelRequest value) {
        return new JAXBElement<PaymentChannelRequest>(_CreatePaymentChannel_QNAME, PaymentChannelRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadPermissionByPaymentChannelRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "loadPermissionsByPaymentChannel")
    public JAXBElement<LoadPermissionByPaymentChannelRequest> createLoadPermissionsByPaymentChannel(LoadPermissionByPaymentChannelRequest value) {
        return new JAXBElement<LoadPermissionByPaymentChannelRequest>(_LoadPermissionsByPaymentChannel_QNAME, LoadPermissionByPaymentChannelRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PaymentChannelPermissionRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "deletePaymentChannelPermissions")
    public JAXBElement<PaymentChannelPermissionRequest> createDeletePaymentChannelPermissions(PaymentChannelPermissionRequest value) {
        return new JAXBElement<PaymentChannelPermissionRequest>(_DeletePaymentChannelPermissions_QNAME, PaymentChannelPermissionRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PaymentChannelRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "updatePaymentChannel")
    public JAXBElement<PaymentChannelRequest> createUpdatePaymentChannel(PaymentChannelRequest value) {
        return new JAXBElement<PaymentChannelRequest>(_UpdatePaymentChannel_QNAME, PaymentChannelRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BillerDetailsRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "loadBillersFromID")
    public JAXBElement<BillerDetailsRequest> createLoadBillersFromID(BillerDetailsRequest value) {
        return new JAXBElement<BillerDetailsRequest>(_LoadBillersFromID_QNAME, BillerDetailsRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BillInquiryRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "inquiryBilling")
    public JAXBElement<BillInquiryRequest> createInquiryBilling(BillInquiryRequest value) {
        return new JAXBElement<BillInquiryRequest>(_InquiryBilling_QNAME, BillInquiryRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PaymentChannelResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "loadPaymentChannelResponse")
    public JAXBElement<PaymentChannelResponse> createLoadPaymentChannelResponse(PaymentChannelResponse value) {
        return new JAXBElement<PaymentChannelResponse>(_LoadPaymentChannelResponse_QNAME, PaymentChannelResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BillInquiryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "inquiryBillingResponse")
    public JAXBElement<BillInquiryResponse> createInquiryBillingResponse(BillInquiryResponse value) {
        return new JAXBElement<BillInquiryResponse>(_InquiryBillingResponse_QNAME, BillInquiryResponse.class, null, value);
    }

}
