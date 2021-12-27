
package org.bellatrix.services.ws.virtualaccount;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.bellatrix.services.ws.virtualaccount package. 
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
    private final static QName _PaymentVAResponse_QNAME = new QName("http://services.bellatrix.org/", "paymentVAResponse");
    private final static QName _CreateEventStatus_QNAME = new QName("http://services.bellatrix.org/", "createEventStatus");
    private final static QName _RegisterBankVA_QNAME = new QName("http://services.bellatrix.org/", "registerBankVA");
    private final static QName _PaymentVA_QNAME = new QName("http://services.bellatrix.org/", "paymentVA");
    private final static QName _InquiryVA_QNAME = new QName("http://services.bellatrix.org/", "inquiryVA");
    private final static QName _LoadVAEventResponse_QNAME = new QName("http://services.bellatrix.org/", "loadVAEventResponse");
    private final static QName _ReportBilling_QNAME = new QName("http://services.bellatrix.org/", "reportBilling");
    private final static QName _UpdateVA_QNAME = new QName("http://services.bellatrix.org/", "updateVA");
    private final static QName _ReportBillingResponse_QNAME = new QName("http://services.bellatrix.org/", "reportBillingResponse");
    private final static QName _LoadBankVA_QNAME = new QName("http://services.bellatrix.org/", "loadBankVA");
    private final static QName _LoadVAByID_QNAME = new QName("http://services.bellatrix.org/", "loadVAByID");
    private final static QName _DeleteVAEvent_QNAME = new QName("http://services.bellatrix.org/", "deleteVAEvent");
    private final static QName _LoadBillingStatusByMember_QNAME = new QName("http://services.bellatrix.org/", "loadBillingStatusByMember");
    private final static QName _LoadVAEvent_QNAME = new QName("http://services.bellatrix.org/", "loadVAEvent");
    private final static QName _LoadVAMemberByStatus_QNAME = new QName("http://services.bellatrix.org/", "loadVAMemberByStatus");
    private final static QName _LoadVAByMemberResponse_QNAME = new QName("http://services.bellatrix.org/", "loadVAByMemberResponse");
    private final static QName _LoadVAEventByIDResponse_QNAME = new QName("http://services.bellatrix.org/", "loadVAEventByIDResponse");
    private final static QName _RegisterBankVAResponse_QNAME = new QName("http://services.bellatrix.org/", "registerBankVAResponse");
    private final static QName _DeleteVA_QNAME = new QName("http://services.bellatrix.org/", "deleteVA");
    private final static QName _LoadBillingStatusByMemberResponse_QNAME = new QName("http://services.bellatrix.org/", "loadBillingStatusByMemberResponse");
    private final static QName _LoadVAMemberByStatusResponse_QNAME = new QName("http://services.bellatrix.org/", "loadVAMemberByStatusResponse");
    private final static QName _InquiryVAResponse_QNAME = new QName("http://services.bellatrix.org/", "inquiryVAResponse");
    private final static QName _LoadVAByIDResponse_QNAME = new QName("http://services.bellatrix.org/", "loadVAByIDResponse");
    private final static QName _CreateVAEvent_QNAME = new QName("http://services.bellatrix.org/", "createVAEvent");
    private final static QName _CreateVAEventResponse_QNAME = new QName("http://services.bellatrix.org/", "createVAEventResponse");
    private final static QName _RegisterVA_QNAME = new QName("http://services.bellatrix.org/", "registerVA");
    private final static QName _UpdateBillingStatus_QNAME = new QName("http://services.bellatrix.org/", "updateBillingStatus");
    private final static QName _LoadBankVAResponse_QNAME = new QName("http://services.bellatrix.org/", "loadBankVAResponse");
    private final static QName _HeaderAuth_QNAME = new QName("http://services.bellatrix.org/", "headerAuth");
    private final static QName _ListBankVAResponse_QNAME = new QName("http://services.bellatrix.org/", "listBankVAResponse");
    private final static QName _UpdateVAResponse_QNAME = new QName("http://services.bellatrix.org/", "updateVAResponse");
    private final static QName _LoadVAByEventResponse_QNAME = new QName("http://services.bellatrix.org/", "loadVAByEventResponse");
    private final static QName _LoadVAByMember_QNAME = new QName("http://services.bellatrix.org/", "loadVAByMember");
    private final static QName _LoadVAByEvent_QNAME = new QName("http://services.bellatrix.org/", "loadVAByEvent");
    private final static QName _RegisterVAResponse_QNAME = new QName("http://services.bellatrix.org/", "registerVAResponse");
    private final static QName _CreateEventStatusResponse_QNAME = new QName("http://services.bellatrix.org/", "createEventStatusResponse");
    private final static QName _ListBankVA_QNAME = new QName("http://services.bellatrix.org/", "listBankVA");
    private final static QName _LoadVAEventByID_QNAME = new QName("http://services.bellatrix.org/", "loadVAEventByID");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.bellatrix.services.ws.virtualaccount
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link VaBankResponse }
     * 
     */
    public VaBankResponse createVaBankResponse() {
        return new VaBankResponse();
    }

    /**
     * Create an instance of {@link BillerServiceField }
     * 
     */
    public BillerServiceField createBillerServiceField() {
        return new BillerServiceField();
    }

    /**
     * Create an instance of {@link MemberFields }
     * 
     */
    public MemberFields createMemberFields() {
        return new MemberFields();
    }

    /**
     * Create an instance of {@link LoadVAEventResponse }
     * 
     */
    public LoadVAEventResponse createLoadVAEventResponse() {
        return new LoadVAEventResponse();
    }

    /**
     * Create an instance of {@link VaInquiryRequest }
     * 
     */
    public VaInquiryRequest createVaInquiryRequest() {
        return new VaInquiryRequest();
    }

    /**
     * Create an instance of {@link Header }
     * 
     */
    public Header createHeader() {
        return new Header();
    }

    /**
     * Create an instance of {@link ExternalMemberFields }
     * 
     */
    public ExternalMemberFields createExternalMemberFields() {
        return new ExternalMemberFields();
    }

    /**
     * Create an instance of {@link LoadVAByIDResponse }
     * 
     */
    public LoadVAByIDResponse createLoadVAByIDResponse() {
        return new LoadVAByIDResponse();
    }

    /**
     * Create an instance of {@link VaBankRequest }
     * 
     */
    public VaBankRequest createVaBankRequest() {
        return new VaBankRequest();
    }

    /**
     * Create an instance of {@link VaPaymentRequest }
     * 
     */
    public VaPaymentRequest createVaPaymentRequest() {
        return new VaPaymentRequest();
    }

    /**
     * Create an instance of {@link LoadVAStatusByMemberRequest }
     * 
     */
    public LoadVAStatusByMemberRequest createLoadVAStatusByMemberRequest() {
        return new LoadVAStatusByMemberRequest();
    }

    /**
     * Create an instance of {@link VaRegisterBankRequest }
     * 
     */
    public VaRegisterBankRequest createVaRegisterBankRequest() {
        return new VaRegisterBankRequest();
    }

    /**
     * Create an instance of {@link ResponseStatus }
     * 
     */
    public ResponseStatus createResponseStatus() {
        return new ResponseStatus();
    }

    /**
     * Create an instance of {@link LoadVAByEventRequest }
     * 
     */
    public LoadVAByEventRequest createLoadVAByEventRequest() {
        return new LoadVAByEventRequest();
    }

    /**
     * Create an instance of {@link CreateEventStatusRequest }
     * 
     */
    public CreateEventStatusRequest createCreateEventStatusRequest() {
        return new CreateEventStatusRequest();
    }

    /**
     * Create an instance of {@link VaUpdateResponse }
     * 
     */
    public VaUpdateResponse createVaUpdateResponse() {
        return new VaUpdateResponse();
    }

    /**
     * Create an instance of {@link Members }
     * 
     */
    public Members createMembers() {
        return new Members();
    }

    /**
     * Create an instance of {@link LoadVAStatusByMemberResponse }
     * 
     */
    public LoadVAStatusByMemberResponse createLoadVAStatusByMemberResponse() {
        return new LoadVAStatusByMemberResponse();
    }

    /**
     * Create an instance of {@link DeleteVAEventRequest }
     * 
     */
    public DeleteVAEventRequest createDeleteVAEventRequest() {
        return new DeleteVAEventRequest();
    }

    /**
     * Create an instance of {@link VaDeleteRequest }
     * 
     */
    public VaDeleteRequest createVaDeleteRequest() {
        return new VaDeleteRequest();
    }

    /**
     * Create an instance of {@link LoadVAEventRequest }
     * 
     */
    public LoadVAEventRequest createLoadVAEventRequest() {
        return new LoadVAEventRequest();
    }

    /**
     * Create an instance of {@link VaRecordView }
     * 
     */
    public VaRecordView createVaRecordView() {
        return new VaRecordView();
    }

    /**
     * Create an instance of {@link VaRegisterRequest }
     * 
     */
    public VaRegisterRequest createVaRegisterRequest() {
        return new VaRegisterRequest();
    }

    /**
     * Create an instance of {@link CreateVAEventResponse }
     * 
     */
    public CreateVAEventResponse createCreateVAEventResponse() {
        return new CreateVAEventResponse();
    }

    /**
     * Create an instance of {@link LoadBillingStatusByMemberResponse }
     * 
     */
    public LoadBillingStatusByMemberResponse createLoadBillingStatusByMemberResponse() {
        return new LoadBillingStatusByMemberResponse();
    }

    /**
     * Create an instance of {@link CreateEventStatusResponse }
     * 
     */
    public CreateEventStatusResponse createCreateEventStatusResponse() {
        return new CreateEventStatusResponse();
    }

    /**
     * Create an instance of {@link LoadVAByMemberRequest }
     * 
     */
    public LoadVAByMemberRequest createLoadVAByMemberRequest() {
        return new LoadVAByMemberRequest();
    }

    /**
     * Create an instance of {@link LoadBillingStatusByMemberRequest }
     * 
     */
    public LoadBillingStatusByMemberRequest createLoadBillingStatusByMemberRequest() {
        return new LoadBillingStatusByMemberRequest();
    }

    /**
     * Create an instance of {@link VaRegisterBankResponse }
     * 
     */
    public VaRegisterBankResponse createVaRegisterBankResponse() {
        return new VaRegisterBankResponse();
    }

    /**
     * Create an instance of {@link CreateVAEventRequest }
     * 
     */
    public CreateVAEventRequest createCreateVAEventRequest() {
        return new CreateVAEventRequest();
    }

    /**
     * Create an instance of {@link VaEvent }
     * 
     */
    public VaEvent createVaEvent() {
        return new VaEvent();
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
    }

    /**
     * Create an instance of {@link ReportBillingRequest }
     * 
     */
    public ReportBillingRequest createReportBillingRequest() {
        return new ReportBillingRequest();
    }

    /**
     * Create an instance of {@link LoadVAByIDRequest }
     * 
     */
    public LoadVAByIDRequest createLoadVAByIDRequest() {
        return new LoadVAByIDRequest();
    }

    /**
     * Create an instance of {@link TransferTypes }
     * 
     */
    public TransferTypes createTransferTypes() {
        return new TransferTypes();
    }

    /**
     * Create an instance of {@link Billers }
     * 
     */
    public Billers createBillers() {
        return new Billers();
    }

    /**
     * Create an instance of {@link LoadVAByMemberResponse }
     * 
     */
    public LoadVAByMemberResponse createLoadVAByMemberResponse() {
        return new LoadVAByMemberResponse();
    }

    /**
     * Create an instance of {@link LoadVAByEventResponse }
     * 
     */
    public LoadVAByEventResponse createLoadVAByEventResponse() {
        return new LoadVAByEventResponse();
    }

    /**
     * Create an instance of {@link BankVA }
     * 
     */
    public BankVA createBankVA() {
        return new BankVA();
    }

    /**
     * Create an instance of {@link UpdateBillingStatusRequest }
     * 
     */
    public UpdateBillingStatusRequest createUpdateBillingStatusRequest() {
        return new UpdateBillingStatusRequest();
    }

    /**
     * Create an instance of {@link VaRegisterResponse }
     * 
     */
    public VaRegisterResponse createVaRegisterResponse() {
        return new VaRegisterResponse();
    }

    /**
     * Create an instance of {@link ReportBillingResponse }
     * 
     */
    public ReportBillingResponse createReportBillingResponse() {
        return new ReportBillingResponse();
    }

    /**
     * Create an instance of {@link VaInquiryResponse }
     * 
     */
    public VaInquiryResponse createVaInquiryResponse() {
        return new VaInquiryResponse();
    }

    /**
     * Create an instance of {@link VaUpdateRequest }
     * 
     */
    public VaUpdateRequest createVaUpdateRequest() {
        return new VaUpdateRequest();
    }

    /**
     * Create an instance of {@link VaPaymentResponse }
     * 
     */
    public VaPaymentResponse createVaPaymentResponse() {
        return new VaPaymentResponse();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link VaPaymentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "paymentVAResponse")
    public JAXBElement<VaPaymentResponse> createPaymentVAResponse(VaPaymentResponse value) {
        return new JAXBElement<VaPaymentResponse>(_PaymentVAResponse_QNAME, VaPaymentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateEventStatusRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "createEventStatus")
    public JAXBElement<CreateEventStatusRequest> createCreateEventStatus(CreateEventStatusRequest value) {
        return new JAXBElement<CreateEventStatusRequest>(_CreateEventStatus_QNAME, CreateEventStatusRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VaRegisterBankRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "registerBankVA")
    public JAXBElement<VaRegisterBankRequest> createRegisterBankVA(VaRegisterBankRequest value) {
        return new JAXBElement<VaRegisterBankRequest>(_RegisterBankVA_QNAME, VaRegisterBankRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VaPaymentRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "paymentVA")
    public JAXBElement<VaPaymentRequest> createPaymentVA(VaPaymentRequest value) {
        return new JAXBElement<VaPaymentRequest>(_PaymentVA_QNAME, VaPaymentRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VaInquiryRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "inquiryVA")
    public JAXBElement<VaInquiryRequest> createInquiryVA(VaInquiryRequest value) {
        return new JAXBElement<VaInquiryRequest>(_InquiryVA_QNAME, VaInquiryRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadVAEventResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "loadVAEventResponse")
    public JAXBElement<LoadVAEventResponse> createLoadVAEventResponse(LoadVAEventResponse value) {
        return new JAXBElement<LoadVAEventResponse>(_LoadVAEventResponse_QNAME, LoadVAEventResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReportBillingRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "reportBilling")
    public JAXBElement<ReportBillingRequest> createReportBilling(ReportBillingRequest value) {
        return new JAXBElement<ReportBillingRequest>(_ReportBilling_QNAME, ReportBillingRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VaUpdateRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "updateVA")
    public JAXBElement<VaUpdateRequest> createUpdateVA(VaUpdateRequest value) {
        return new JAXBElement<VaUpdateRequest>(_UpdateVA_QNAME, VaUpdateRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReportBillingResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "reportBillingResponse")
    public JAXBElement<ReportBillingResponse> createReportBillingResponse(ReportBillingResponse value) {
        return new JAXBElement<ReportBillingResponse>(_ReportBillingResponse_QNAME, ReportBillingResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VaBankRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "loadBankVA")
    public JAXBElement<VaBankRequest> createLoadBankVA(VaBankRequest value) {
        return new JAXBElement<VaBankRequest>(_LoadBankVA_QNAME, VaBankRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadVAByIDRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "loadVAByID")
    public JAXBElement<LoadVAByIDRequest> createLoadVAByID(LoadVAByIDRequest value) {
        return new JAXBElement<LoadVAByIDRequest>(_LoadVAByID_QNAME, LoadVAByIDRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteVAEventRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "deleteVAEvent")
    public JAXBElement<DeleteVAEventRequest> createDeleteVAEvent(DeleteVAEventRequest value) {
        return new JAXBElement<DeleteVAEventRequest>(_DeleteVAEvent_QNAME, DeleteVAEventRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadBillingStatusByMemberRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "loadBillingStatusByMember")
    public JAXBElement<LoadBillingStatusByMemberRequest> createLoadBillingStatusByMember(LoadBillingStatusByMemberRequest value) {
        return new JAXBElement<LoadBillingStatusByMemberRequest>(_LoadBillingStatusByMember_QNAME, LoadBillingStatusByMemberRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadVAEventRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "loadVAEvent")
    public JAXBElement<LoadVAEventRequest> createLoadVAEvent(LoadVAEventRequest value) {
        return new JAXBElement<LoadVAEventRequest>(_LoadVAEvent_QNAME, LoadVAEventRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadVAStatusByMemberRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "loadVAMemberByStatus")
    public JAXBElement<LoadVAStatusByMemberRequest> createLoadVAMemberByStatus(LoadVAStatusByMemberRequest value) {
        return new JAXBElement<LoadVAStatusByMemberRequest>(_LoadVAMemberByStatus_QNAME, LoadVAStatusByMemberRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadVAByMemberResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "loadVAByMemberResponse")
    public JAXBElement<LoadVAByMemberResponse> createLoadVAByMemberResponse(LoadVAByMemberResponse value) {
        return new JAXBElement<LoadVAByMemberResponse>(_LoadVAByMemberResponse_QNAME, LoadVAByMemberResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadVAEventResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "loadVAEventByIDResponse")
    public JAXBElement<LoadVAEventResponse> createLoadVAEventByIDResponse(LoadVAEventResponse value) {
        return new JAXBElement<LoadVAEventResponse>(_LoadVAEventByIDResponse_QNAME, LoadVAEventResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VaRegisterBankResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "registerBankVAResponse")
    public JAXBElement<VaRegisterBankResponse> createRegisterBankVAResponse(VaRegisterBankResponse value) {
        return new JAXBElement<VaRegisterBankResponse>(_RegisterBankVAResponse_QNAME, VaRegisterBankResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VaDeleteRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "deleteVA")
    public JAXBElement<VaDeleteRequest> createDeleteVA(VaDeleteRequest value) {
        return new JAXBElement<VaDeleteRequest>(_DeleteVA_QNAME, VaDeleteRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadBillingStatusByMemberResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "loadBillingStatusByMemberResponse")
    public JAXBElement<LoadBillingStatusByMemberResponse> createLoadBillingStatusByMemberResponse(LoadBillingStatusByMemberResponse value) {
        return new JAXBElement<LoadBillingStatusByMemberResponse>(_LoadBillingStatusByMemberResponse_QNAME, LoadBillingStatusByMemberResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadVAStatusByMemberResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "loadVAMemberByStatusResponse")
    public JAXBElement<LoadVAStatusByMemberResponse> createLoadVAMemberByStatusResponse(LoadVAStatusByMemberResponse value) {
        return new JAXBElement<LoadVAStatusByMemberResponse>(_LoadVAMemberByStatusResponse_QNAME, LoadVAStatusByMemberResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VaInquiryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "inquiryVAResponse")
    public JAXBElement<VaInquiryResponse> createInquiryVAResponse(VaInquiryResponse value) {
        return new JAXBElement<VaInquiryResponse>(_InquiryVAResponse_QNAME, VaInquiryResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadVAByIDResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "loadVAByIDResponse")
    public JAXBElement<LoadVAByIDResponse> createLoadVAByIDResponse(LoadVAByIDResponse value) {
        return new JAXBElement<LoadVAByIDResponse>(_LoadVAByIDResponse_QNAME, LoadVAByIDResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateVAEventRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "createVAEvent")
    public JAXBElement<CreateVAEventRequest> createCreateVAEvent(CreateVAEventRequest value) {
        return new JAXBElement<CreateVAEventRequest>(_CreateVAEvent_QNAME, CreateVAEventRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateVAEventResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "createVAEventResponse")
    public JAXBElement<CreateVAEventResponse> createCreateVAEventResponse(CreateVAEventResponse value) {
        return new JAXBElement<CreateVAEventResponse>(_CreateVAEventResponse_QNAME, CreateVAEventResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VaRegisterRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "registerVA")
    public JAXBElement<VaRegisterRequest> createRegisterVA(VaRegisterRequest value) {
        return new JAXBElement<VaRegisterRequest>(_RegisterVA_QNAME, VaRegisterRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateBillingStatusRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "updateBillingStatus")
    public JAXBElement<UpdateBillingStatusRequest> createUpdateBillingStatus(UpdateBillingStatusRequest value) {
        return new JAXBElement<UpdateBillingStatusRequest>(_UpdateBillingStatus_QNAME, UpdateBillingStatusRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VaBankResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "loadBankVAResponse")
    public JAXBElement<VaBankResponse> createLoadBankVAResponse(VaBankResponse value) {
        return new JAXBElement<VaBankResponse>(_LoadBankVAResponse_QNAME, VaBankResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link VaBankResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "listBankVAResponse")
    public JAXBElement<VaBankResponse> createListBankVAResponse(VaBankResponse value) {
        return new JAXBElement<VaBankResponse>(_ListBankVAResponse_QNAME, VaBankResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VaUpdateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "updateVAResponse")
    public JAXBElement<VaUpdateResponse> createUpdateVAResponse(VaUpdateResponse value) {
        return new JAXBElement<VaUpdateResponse>(_UpdateVAResponse_QNAME, VaUpdateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadVAByEventResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "loadVAByEventResponse")
    public JAXBElement<LoadVAByEventResponse> createLoadVAByEventResponse(LoadVAByEventResponse value) {
        return new JAXBElement<LoadVAByEventResponse>(_LoadVAByEventResponse_QNAME, LoadVAByEventResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadVAByMemberRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "loadVAByMember")
    public JAXBElement<LoadVAByMemberRequest> createLoadVAByMember(LoadVAByMemberRequest value) {
        return new JAXBElement<LoadVAByMemberRequest>(_LoadVAByMember_QNAME, LoadVAByMemberRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadVAByEventRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "loadVAByEvent")
    public JAXBElement<LoadVAByEventRequest> createLoadVAByEvent(LoadVAByEventRequest value) {
        return new JAXBElement<LoadVAByEventRequest>(_LoadVAByEvent_QNAME, LoadVAByEventRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VaRegisterResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "registerVAResponse")
    public JAXBElement<VaRegisterResponse> createRegisterVAResponse(VaRegisterResponse value) {
        return new JAXBElement<VaRegisterResponse>(_RegisterVAResponse_QNAME, VaRegisterResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateEventStatusResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "createEventStatusResponse")
    public JAXBElement<CreateEventStatusResponse> createCreateEventStatusResponse(CreateEventStatusResponse value) {
        return new JAXBElement<CreateEventStatusResponse>(_CreateEventStatusResponse_QNAME, CreateEventStatusResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VaBankRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "listBankVA")
    public JAXBElement<VaBankRequest> createListBankVA(VaBankRequest value) {
        return new JAXBElement<VaBankRequest>(_ListBankVA_QNAME, VaBankRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadVAEventRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "loadVAEventByID")
    public JAXBElement<LoadVAEventRequest> createLoadVAEventByID(LoadVAEventRequest value) {
        return new JAXBElement<LoadVAEventRequest>(_LoadVAEventByID_QNAME, LoadVAEventRequest.class, null, value);
    }

}
