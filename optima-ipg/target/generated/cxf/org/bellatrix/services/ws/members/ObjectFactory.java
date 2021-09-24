
package org.bellatrix.services.ws.members;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.bellatrix.services.ws.members package. 
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

    private final static QName _LoadAllMembers_QNAME = new QName("http://services.bellatrix.org/", "loadAllMembers");
    private final static QName _Exception_QNAME = new QName("http://services.bellatrix.org/", "Exception");
    private final static QName _ConfirmKYCRequest_QNAME = new QName("http://services.bellatrix.org/", "confirmKYCRequest");
    private final static QName _RegisterMembers_QNAME = new QName("http://services.bellatrix.org/", "registerMembers");
    private final static QName _LoadKYCRequest_QNAME = new QName("http://services.bellatrix.org/", "loadKYCRequest");
    private final static QName _RegisterExternalMembers_QNAME = new QName("http://services.bellatrix.org/", "registerExternalMembers");
    private final static QName _LoadMerchantRequestResponse_QNAME = new QName("http://services.bellatrix.org/", "loadMerchantRequestResponse");
    private final static QName _LoadMerchantsByUsername_QNAME = new QName("http://services.bellatrix.org/", "loadMerchantsByUsername");
    private final static QName _LoadMerchantBusinessScaleResponse_QNAME = new QName("http://services.bellatrix.org/", "loadMerchantBusinessScaleResponse");
    private final static QName _LoadMembersByGroupIDResponse_QNAME = new QName("http://services.bellatrix.org/", "loadMembersByGroupIDResponse");
    private final static QName _ValidateKYCRequestResponse_QNAME = new QName("http://services.bellatrix.org/", "validateKYCRequestResponse");
    private final static QName _LoadAllMembersResponse_QNAME = new QName("http://services.bellatrix.org/", "loadAllMembersResponse");
    private final static QName _ConfirmKYCRequestResponse_QNAME = new QName("http://services.bellatrix.org/", "confirmKYCRequestResponse");
    private final static QName _ValidateKYCRequest_QNAME = new QName("http://services.bellatrix.org/", "validateKYCRequest");
    private final static QName _LoadMerchantBusinessScale_QNAME = new QName("http://services.bellatrix.org/", "loadMerchantBusinessScale");
    private final static QName _UnregisterExternalMembers_QNAME = new QName("http://services.bellatrix.org/", "unregisterExternalMembers");
    private final static QName _LoadMembersByExternalIDResponse_QNAME = new QName("http://services.bellatrix.org/", "loadMembersByExternalIDResponse");
    private final static QName _LoadMembersByExternalID_QNAME = new QName("http://services.bellatrix.org/", "loadMembersByExternalID");
    private final static QName _LoadMembersByGroupID_QNAME = new QName("http://services.bellatrix.org/", "loadMembersByGroupID");
    private final static QName _UpdateMembers_QNAME = new QName("http://services.bellatrix.org/", "updateMembers");
    private final static QName _LoadKYCRequestResponse_QNAME = new QName("http://services.bellatrix.org/", "loadKYCRequestResponse");
    private final static QName _ConfirmMerchantRequestResponse_QNAME = new QName("http://services.bellatrix.org/", "confirmMerchantRequestResponse");
    private final static QName _RegisterMerchants_QNAME = new QName("http://services.bellatrix.org/", "registerMerchants");
    private final static QName _LoadMembersByUsernameResponse_QNAME = new QName("http://services.bellatrix.org/", "loadMembersByUsernameResponse");
    private final static QName _LoadMerchantCategoryResponse_QNAME = new QName("http://services.bellatrix.org/", "loadMerchantCategoryResponse");
    private final static QName _ConfirmMerchantRequest_QNAME = new QName("http://services.bellatrix.org/", "confirmMerchantRequest");
    private final static QName _LoadMembersByUsername_QNAME = new QName("http://services.bellatrix.org/", "loadMembersByUsername");
    private final static QName _LoadMerchantsByUsernameResponse_QNAME = new QName("http://services.bellatrix.org/", "loadMerchantsByUsernameResponse");
    private final static QName _LoadMerchantCategory_QNAME = new QName("http://services.bellatrix.org/", "loadMerchantCategory");
    private final static QName _HeaderAuth_QNAME = new QName("http://services.bellatrix.org/", "headerAuth");
    private final static QName _LoadMerchantSubCategory_QNAME = new QName("http://services.bellatrix.org/", "loadMerchantSubCategory");
    private final static QName _LoadMerchantSubCategoryResponse_QNAME = new QName("http://services.bellatrix.org/", "loadMerchantSubCategoryResponse");
    private final static QName _LoadMerchantRequest_QNAME = new QName("http://services.bellatrix.org/", "loadMerchantRequest");
    private final static QName _LoadMembersByIDResponse_QNAME = new QName("http://services.bellatrix.org/", "loadMembersByIDResponse");
    private final static QName _LoadMembersByID_QNAME = new QName("http://services.bellatrix.org/", "loadMembersByID");
    private final static QName _MembersKYCRequest_QNAME = new QName("http://services.bellatrix.org/", "membersKYCRequest");
    private final static QName _UpdateMerchants_QNAME = new QName("http://services.bellatrix.org/", "updateMerchants");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.bellatrix.services.ws.members
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link LoadMembersResponse }
     * 
     */
    public LoadMembersResponse createLoadMembersResponse() {
        return new LoadMembersResponse();
    }

    /**
     * Create an instance of {@link ConfirmMerchantResponse }
     * 
     */
    public ConfirmMerchantResponse createConfirmMerchantResponse() {
        return new ConfirmMerchantResponse();
    }

    /**
     * Create an instance of {@link MerchantCategory }
     * 
     */
    public MerchantCategory createMerchantCategory() {
        return new MerchantCategory();
    }

    /**
     * Create an instance of {@link SubscribeMemberRequest }
     * 
     */
    public SubscribeMemberRequest createSubscribeMemberRequest() {
        return new SubscribeMemberRequest();
    }

    /**
     * Create an instance of {@link MerchantOwner }
     * 
     */
    public MerchantOwner createMerchantOwner() {
        return new MerchantOwner();
    }

    /**
     * Create an instance of {@link LoadKYCResponse }
     * 
     */
    public LoadKYCResponse createLoadKYCResponse() {
        return new LoadKYCResponse();
    }

    /**
     * Create an instance of {@link RegisterMerchantRequest }
     * 
     */
    public RegisterMerchantRequest createRegisterMerchantRequest() {
        return new RegisterMerchantRequest();
    }

    /**
     * Create an instance of {@link LoadMerchantResponse }
     * 
     */
    public LoadMerchantResponse createLoadMerchantResponse() {
        return new LoadMerchantResponse();
    }

    /**
     * Create an instance of {@link Members }
     * 
     */
    public Members createMembers() {
        return new Members();
    }

    /**
     * Create an instance of {@link LoadMerchantBusinessScaleResponse }
     * 
     */
    public LoadMerchantBusinessScaleResponse createLoadMerchantBusinessScaleResponse() {
        return new LoadMerchantBusinessScaleResponse();
    }

    /**
     * Create an instance of {@link LoadMerchantCategoryRequest }
     * 
     */
    public LoadMerchantCategoryRequest createLoadMerchantCategoryRequest() {
        return new LoadMerchantCategoryRequest();
    }

    /**
     * Create an instance of {@link MerchantSubCategory }
     * 
     */
    public MerchantSubCategory createMerchantSubCategory() {
        return new MerchantSubCategory();
    }

    /**
     * Create an instance of {@link LoadMembersByUsernameRequest }
     * 
     */
    public LoadMembersByUsernameRequest createLoadMembersByUsernameRequest() {
        return new LoadMembersByUsernameRequest();
    }

    /**
     * Create an instance of {@link MerchantBusinessScale }
     * 
     */
    public MerchantBusinessScale createMerchantBusinessScale() {
        return new MerchantBusinessScale();
    }

    /**
     * Create an instance of {@link MemberView }
     * 
     */
    public MemberView createMemberView() {
        return new MemberView();
    }

    /**
     * Create an instance of {@link LoadMembersByIDRequest }
     * 
     */
    public LoadMembersByIDRequest createLoadMembersByIDRequest() {
        return new LoadMembersByIDRequest();
    }

    /**
     * Create an instance of {@link MemberKYCRequest }
     * 
     */
    public MemberKYCRequest createMemberKYCRequest() {
        return new MemberKYCRequest();
    }

    /**
     * Create an instance of {@link RegisterMemberRequest }
     * 
     */
    public RegisterMemberRequest createRegisterMemberRequest() {
        return new RegisterMemberRequest();
    }

    /**
     * Create an instance of {@link LoadMembersRequest }
     * 
     */
    public LoadMembersRequest createLoadMembersRequest() {
        return new LoadMembersRequest();
    }

    /**
     * Create an instance of {@link ValidateKYCResponse }
     * 
     */
    public ValidateKYCResponse createValidateKYCResponse() {
        return new ValidateKYCResponse();
    }

    /**
     * Create an instance of {@link Header }
     * 
     */
    public Header createHeader() {
        return new Header();
    }

    /**
     * Create an instance of {@link LoadMerchantRequest }
     * 
     */
    public LoadMerchantRequest createLoadMerchantRequest() {
        return new LoadMerchantRequest();
    }

    /**
     * Create an instance of {@link UpdateMerchantRequest }
     * 
     */
    public UpdateMerchantRequest createUpdateMerchantRequest() {
        return new UpdateMerchantRequest();
    }

    /**
     * Create an instance of {@link LoadMerchantBusinessScaleRequest }
     * 
     */
    public LoadMerchantBusinessScaleRequest createLoadMerchantBusinessScaleRequest() {
        return new LoadMerchantBusinessScaleRequest();
    }

    /**
     * Create an instance of {@link Groups }
     * 
     */
    public Groups createGroups() {
        return new Groups();
    }

    /**
     * Create an instance of {@link LoadMerchantByUsernameRequest }
     * 
     */
    public LoadMerchantByUsernameRequest createLoadMerchantByUsernameRequest() {
        return new LoadMerchantByUsernameRequest();
    }

    /**
     * Create an instance of {@link LoadMembersByExternalIDRequest }
     * 
     */
    public LoadMembersByExternalIDRequest createLoadMembersByExternalIDRequest() {
        return new LoadMembersByExternalIDRequest();
    }

    /**
     * Create an instance of {@link ValidateKYCRequest }
     * 
     */
    public ValidateKYCRequest createValidateKYCRequest() {
        return new ValidateKYCRequest();
    }

    /**
     * Create an instance of {@link ConfirmKYCRequest }
     * 
     */
    public ConfirmKYCRequest createConfirmKYCRequest() {
        return new ConfirmKYCRequest();
    }

    /**
     * Create an instance of {@link ConfirmMerchantRequest }
     * 
     */
    public ConfirmMerchantRequest createConfirmMerchantRequest() {
        return new ConfirmMerchantRequest();
    }

    /**
     * Create an instance of {@link LoadMerchantSubCategoryResponse }
     * 
     */
    public LoadMerchantSubCategoryResponse createLoadMerchantSubCategoryResponse() {
        return new LoadMerchantSubCategoryResponse();
    }

    /**
     * Create an instance of {@link Merchants }
     * 
     */
    public Merchants createMerchants() {
        return new Merchants();
    }

    /**
     * Create an instance of {@link ConfirmKYCResponse }
     * 
     */
    public ConfirmKYCResponse createConfirmKYCResponse() {
        return new ConfirmKYCResponse();
    }

    /**
     * Create an instance of {@link Billers }
     * 
     */
    public Billers createBillers() {
        return new Billers();
    }

    /**
     * Create an instance of {@link LoadMerchantByUsernameResponse }
     * 
     */
    public LoadMerchantByUsernameResponse createLoadMerchantByUsernameResponse() {
        return new LoadMerchantByUsernameResponse();
    }

    /**
     * Create an instance of {@link LoadMerchantSubCategoryRequest }
     * 
     */
    public LoadMerchantSubCategoryRequest createLoadMerchantSubCategoryRequest() {
        return new LoadMerchantSubCategoryRequest();
    }

    /**
     * Create an instance of {@link ResponseStatus }
     * 
     */
    public ResponseStatus createResponseStatus() {
        return new ResponseStatus();
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
    }

    /**
     * Create an instance of {@link LoadMembersByGroupIDRequest }
     * 
     */
    public LoadMembersByGroupIDRequest createLoadMembersByGroupIDRequest() {
        return new LoadMembersByGroupIDRequest();
    }

    /**
     * Create an instance of {@link UpdateMemberRequest }
     * 
     */
    public UpdateMemberRequest createUpdateMemberRequest() {
        return new UpdateMemberRequest();
    }

    /**
     * Create an instance of {@link MemberKYC }
     * 
     */
    public MemberKYC createMemberKYC() {
        return new MemberKYC();
    }

    /**
     * Create an instance of {@link MemberFields }
     * 
     */
    public MemberFields createMemberFields() {
        return new MemberFields();
    }

    /**
     * Create an instance of {@link ExternalMemberFields }
     * 
     */
    public ExternalMemberFields createExternalMemberFields() {
        return new ExternalMemberFields();
    }

    /**
     * Create an instance of {@link LoadKYCRequest }
     * 
     */
    public LoadKYCRequest createLoadKYCRequest() {
        return new LoadKYCRequest();
    }

    /**
     * Create an instance of {@link LoadMerchantCategoryResponse }
     * 
     */
    public LoadMerchantCategoryResponse createLoadMerchantCategoryResponse() {
        return new LoadMerchantCategoryResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadMembersRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "loadAllMembers")
    public JAXBElement<LoadMembersRequest> createLoadAllMembers(LoadMembersRequest value) {
        return new JAXBElement<LoadMembersRequest>(_LoadAllMembers_QNAME, LoadMembersRequest.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link ConfirmKYCRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "confirmKYCRequest")
    public JAXBElement<ConfirmKYCRequest> createConfirmKYCRequest(ConfirmKYCRequest value) {
        return new JAXBElement<ConfirmKYCRequest>(_ConfirmKYCRequest_QNAME, ConfirmKYCRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegisterMemberRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "registerMembers")
    public JAXBElement<RegisterMemberRequest> createRegisterMembers(RegisterMemberRequest value) {
        return new JAXBElement<RegisterMemberRequest>(_RegisterMembers_QNAME, RegisterMemberRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadKYCRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "loadKYCRequest")
    public JAXBElement<LoadKYCRequest> createLoadKYCRequest(LoadKYCRequest value) {
        return new JAXBElement<LoadKYCRequest>(_LoadKYCRequest_QNAME, LoadKYCRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SubscribeMemberRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "registerExternalMembers")
    public JAXBElement<SubscribeMemberRequest> createRegisterExternalMembers(SubscribeMemberRequest value) {
        return new JAXBElement<SubscribeMemberRequest>(_RegisterExternalMembers_QNAME, SubscribeMemberRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadMerchantResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "loadMerchantRequestResponse")
    public JAXBElement<LoadMerchantResponse> createLoadMerchantRequestResponse(LoadMerchantResponse value) {
        return new JAXBElement<LoadMerchantResponse>(_LoadMerchantRequestResponse_QNAME, LoadMerchantResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadMerchantByUsernameRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "loadMerchantsByUsername")
    public JAXBElement<LoadMerchantByUsernameRequest> createLoadMerchantsByUsername(LoadMerchantByUsernameRequest value) {
        return new JAXBElement<LoadMerchantByUsernameRequest>(_LoadMerchantsByUsername_QNAME, LoadMerchantByUsernameRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadMerchantBusinessScaleResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "loadMerchantBusinessScaleResponse")
    public JAXBElement<LoadMerchantBusinessScaleResponse> createLoadMerchantBusinessScaleResponse(LoadMerchantBusinessScaleResponse value) {
        return new JAXBElement<LoadMerchantBusinessScaleResponse>(_LoadMerchantBusinessScaleResponse_QNAME, LoadMerchantBusinessScaleResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadMembersResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "loadMembersByGroupIDResponse")
    public JAXBElement<LoadMembersResponse> createLoadMembersByGroupIDResponse(LoadMembersResponse value) {
        return new JAXBElement<LoadMembersResponse>(_LoadMembersByGroupIDResponse_QNAME, LoadMembersResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidateKYCResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "validateKYCRequestResponse")
    public JAXBElement<ValidateKYCResponse> createValidateKYCRequestResponse(ValidateKYCResponse value) {
        return new JAXBElement<ValidateKYCResponse>(_ValidateKYCRequestResponse_QNAME, ValidateKYCResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadMembersResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "loadAllMembersResponse")
    public JAXBElement<LoadMembersResponse> createLoadAllMembersResponse(LoadMembersResponse value) {
        return new JAXBElement<LoadMembersResponse>(_LoadAllMembersResponse_QNAME, LoadMembersResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConfirmKYCResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "confirmKYCRequestResponse")
    public JAXBElement<ConfirmKYCResponse> createConfirmKYCRequestResponse(ConfirmKYCResponse value) {
        return new JAXBElement<ConfirmKYCResponse>(_ConfirmKYCRequestResponse_QNAME, ConfirmKYCResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidateKYCRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "validateKYCRequest")
    public JAXBElement<ValidateKYCRequest> createValidateKYCRequest(ValidateKYCRequest value) {
        return new JAXBElement<ValidateKYCRequest>(_ValidateKYCRequest_QNAME, ValidateKYCRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadMerchantBusinessScaleRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "loadMerchantBusinessScale")
    public JAXBElement<LoadMerchantBusinessScaleRequest> createLoadMerchantBusinessScale(LoadMerchantBusinessScaleRequest value) {
        return new JAXBElement<LoadMerchantBusinessScaleRequest>(_LoadMerchantBusinessScale_QNAME, LoadMerchantBusinessScaleRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SubscribeMemberRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "unregisterExternalMembers")
    public JAXBElement<SubscribeMemberRequest> createUnregisterExternalMembers(SubscribeMemberRequest value) {
        return new JAXBElement<SubscribeMemberRequest>(_UnregisterExternalMembers_QNAME, SubscribeMemberRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadMembersResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "loadMembersByExternalIDResponse")
    public JAXBElement<LoadMembersResponse> createLoadMembersByExternalIDResponse(LoadMembersResponse value) {
        return new JAXBElement<LoadMembersResponse>(_LoadMembersByExternalIDResponse_QNAME, LoadMembersResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadMembersByExternalIDRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "loadMembersByExternalID")
    public JAXBElement<LoadMembersByExternalIDRequest> createLoadMembersByExternalID(LoadMembersByExternalIDRequest value) {
        return new JAXBElement<LoadMembersByExternalIDRequest>(_LoadMembersByExternalID_QNAME, LoadMembersByExternalIDRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadMembersByGroupIDRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "loadMembersByGroupID")
    public JAXBElement<LoadMembersByGroupIDRequest> createLoadMembersByGroupID(LoadMembersByGroupIDRequest value) {
        return new JAXBElement<LoadMembersByGroupIDRequest>(_LoadMembersByGroupID_QNAME, LoadMembersByGroupIDRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateMemberRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "updateMembers")
    public JAXBElement<UpdateMemberRequest> createUpdateMembers(UpdateMemberRequest value) {
        return new JAXBElement<UpdateMemberRequest>(_UpdateMembers_QNAME, UpdateMemberRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadKYCResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "loadKYCRequestResponse")
    public JAXBElement<LoadKYCResponse> createLoadKYCRequestResponse(LoadKYCResponse value) {
        return new JAXBElement<LoadKYCResponse>(_LoadKYCRequestResponse_QNAME, LoadKYCResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConfirmMerchantResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "confirmMerchantRequestResponse")
    public JAXBElement<ConfirmMerchantResponse> createConfirmMerchantRequestResponse(ConfirmMerchantResponse value) {
        return new JAXBElement<ConfirmMerchantResponse>(_ConfirmMerchantRequestResponse_QNAME, ConfirmMerchantResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegisterMerchantRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "registerMerchants")
    public JAXBElement<RegisterMerchantRequest> createRegisterMerchants(RegisterMerchantRequest value) {
        return new JAXBElement<RegisterMerchantRequest>(_RegisterMerchants_QNAME, RegisterMerchantRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadMembersResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "loadMembersByUsernameResponse")
    public JAXBElement<LoadMembersResponse> createLoadMembersByUsernameResponse(LoadMembersResponse value) {
        return new JAXBElement<LoadMembersResponse>(_LoadMembersByUsernameResponse_QNAME, LoadMembersResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadMerchantCategoryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "loadMerchantCategoryResponse")
    public JAXBElement<LoadMerchantCategoryResponse> createLoadMerchantCategoryResponse(LoadMerchantCategoryResponse value) {
        return new JAXBElement<LoadMerchantCategoryResponse>(_LoadMerchantCategoryResponse_QNAME, LoadMerchantCategoryResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConfirmMerchantRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "confirmMerchantRequest")
    public JAXBElement<ConfirmMerchantRequest> createConfirmMerchantRequest(ConfirmMerchantRequest value) {
        return new JAXBElement<ConfirmMerchantRequest>(_ConfirmMerchantRequest_QNAME, ConfirmMerchantRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadMembersByUsernameRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "loadMembersByUsername")
    public JAXBElement<LoadMembersByUsernameRequest> createLoadMembersByUsername(LoadMembersByUsernameRequest value) {
        return new JAXBElement<LoadMembersByUsernameRequest>(_LoadMembersByUsername_QNAME, LoadMembersByUsernameRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadMerchantByUsernameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "loadMerchantsByUsernameResponse")
    public JAXBElement<LoadMerchantByUsernameResponse> createLoadMerchantsByUsernameResponse(LoadMerchantByUsernameResponse value) {
        return new JAXBElement<LoadMerchantByUsernameResponse>(_LoadMerchantsByUsernameResponse_QNAME, LoadMerchantByUsernameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadMerchantCategoryRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "loadMerchantCategory")
    public JAXBElement<LoadMerchantCategoryRequest> createLoadMerchantCategory(LoadMerchantCategoryRequest value) {
        return new JAXBElement<LoadMerchantCategoryRequest>(_LoadMerchantCategory_QNAME, LoadMerchantCategoryRequest.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadMerchantSubCategoryRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "loadMerchantSubCategory")
    public JAXBElement<LoadMerchantSubCategoryRequest> createLoadMerchantSubCategory(LoadMerchantSubCategoryRequest value) {
        return new JAXBElement<LoadMerchantSubCategoryRequest>(_LoadMerchantSubCategory_QNAME, LoadMerchantSubCategoryRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadMerchantSubCategoryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "loadMerchantSubCategoryResponse")
    public JAXBElement<LoadMerchantSubCategoryResponse> createLoadMerchantSubCategoryResponse(LoadMerchantSubCategoryResponse value) {
        return new JAXBElement<LoadMerchantSubCategoryResponse>(_LoadMerchantSubCategoryResponse_QNAME, LoadMerchantSubCategoryResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadMerchantRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "loadMerchantRequest")
    public JAXBElement<LoadMerchantRequest> createLoadMerchantRequest(LoadMerchantRequest value) {
        return new JAXBElement<LoadMerchantRequest>(_LoadMerchantRequest_QNAME, LoadMerchantRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadMembersResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "loadMembersByIDResponse")
    public JAXBElement<LoadMembersResponse> createLoadMembersByIDResponse(LoadMembersResponse value) {
        return new JAXBElement<LoadMembersResponse>(_LoadMembersByIDResponse_QNAME, LoadMembersResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadMembersByIDRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "loadMembersByID")
    public JAXBElement<LoadMembersByIDRequest> createLoadMembersByID(LoadMembersByIDRequest value) {
        return new JAXBElement<LoadMembersByIDRequest>(_LoadMembersByID_QNAME, LoadMembersByIDRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MemberKYCRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "membersKYCRequest")
    public JAXBElement<MemberKYCRequest> createMembersKYCRequest(MemberKYCRequest value) {
        return new JAXBElement<MemberKYCRequest>(_MembersKYCRequest_QNAME, MemberKYCRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateMerchantRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "updateMerchants")
    public JAXBElement<UpdateMerchantRequest> createUpdateMerchants(UpdateMerchantRequest value) {
        return new JAXBElement<UpdateMerchantRequest>(_UpdateMerchants_QNAME, UpdateMerchantRequest.class, null, value);
    }

}
