
package org.bellatrix.services.ws.transfertypes;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.bellatrix.services.ws.transfertypes package. 
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

    private final static QName _LoadTransferTypesByAccountID_QNAME = new QName("http://services.bellatrix.org/", "loadTransferTypesByAccountID");
    private final static QName _LoadTransferTypesByAccountIDResponse_QNAME = new QName("http://services.bellatrix.org/", "loadTransferTypesByAccountIDResponse");
    private final static QName _LoadFeesByTransferType_QNAME = new QName("http://services.bellatrix.org/", "loadFeesByTransferType");
    private final static QName _UpdateTransferTypePermission_QNAME = new QName("http://services.bellatrix.org/", "updateTransferTypePermission");
    private final static QName _LoadTransferTypesByID_QNAME = new QName("http://services.bellatrix.org/", "loadTransferTypesByID");
    private final static QName _LoadTransferTypesByIDResponse_QNAME = new QName("http://services.bellatrix.org/", "loadTransferTypesByIDResponse");
    private final static QName _LoadTransferTypesByUsername_QNAME = new QName("http://services.bellatrix.org/", "loadTransferTypesByUsername");
    private final static QName _HeaderAuth_QNAME = new QName("http://services.bellatrix.org/", "headerAuth");
    private final static QName _LoadAllTransferTypesResponse_QNAME = new QName("http://services.bellatrix.org/", "loadAllTransferTypesResponse");
    private final static QName _UpdateFees_QNAME = new QName("http://services.bellatrix.org/", "updateFees");
    private final static QName _LoadTransferTypesByUsernameResponse_QNAME = new QName("http://services.bellatrix.org/", "loadTransferTypesByUsernameResponse");
    private final static QName _CreateFees_QNAME = new QName("http://services.bellatrix.org/", "createFees");
    private final static QName _DeleteFees_QNAME = new QName("http://services.bellatrix.org/", "deleteFees");
    private final static QName _UpdateTransferTypes_QNAME = new QName("http://services.bellatrix.org/", "updateTransferTypes");
    private final static QName _CreateTransferTypePermissions_QNAME = new QName("http://services.bellatrix.org/", "createTransferTypePermissions");
    private final static QName _CreateTransferTypes_QNAME = new QName("http://services.bellatrix.org/", "createTransferTypes");
    private final static QName _LoadPermissionsByTransferTypeResponse_QNAME = new QName("http://services.bellatrix.org/", "loadPermissionsByTransferTypeResponse");
    private final static QName _LoadPermissionsByTransferType_QNAME = new QName("http://services.bellatrix.org/", "loadPermissionsByTransferType");
    private final static QName _LoadAllTransferTypes_QNAME = new QName("http://services.bellatrix.org/", "loadAllTransferTypes");
    private final static QName _DeleteTransferTypePermissions_QNAME = new QName("http://services.bellatrix.org/", "deleteTransferTypePermissions");
    private final static QName _TransactionException_QNAME = new QName("http://services.bellatrix.org/", "TransactionException");
    private final static QName _LoadFeesByTransferTypeResponse_QNAME = new QName("http://services.bellatrix.org/", "loadFeesByTransferTypeResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.bellatrix.services.ws.transfertypes
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TransferTypePermissionRequest }
     * 
     */
    public TransferTypePermissionRequest createTransferTypePermissionRequest() {
        return new TransferTypePermissionRequest();
    }

    /**
     * Create an instance of {@link LoadTransferTypesByAccountIDRequest }
     * 
     */
    public LoadTransferTypesByAccountIDRequest createLoadTransferTypesByAccountIDRequest() {
        return new LoadTransferTypesByAccountIDRequest();
    }

    /**
     * Create an instance of {@link Fees }
     * 
     */
    public Fees createFees() {
        return new Fees();
    }

    /**
     * Create an instance of {@link Billers }
     * 
     */
    public Billers createBillers() {
        return new Billers();
    }

    /**
     * Create an instance of {@link TransferTypes }
     * 
     */
    public TransferTypes createTransferTypes() {
        return new TransferTypes();
    }

    /**
     * Create an instance of {@link LoadPermissionByTransferTypesResponse }
     * 
     */
    public LoadPermissionByTransferTypesResponse createLoadPermissionByTransferTypesResponse() {
        return new LoadPermissionByTransferTypesResponse();
    }

    /**
     * Create an instance of {@link LoadFeesByTransferTypeResponse }
     * 
     */
    public LoadFeesByTransferTypeResponse createLoadFeesByTransferTypeResponse() {
        return new LoadFeesByTransferTypeResponse();
    }

    /**
     * Create an instance of {@link LoadTransferTypesByIDResponse }
     * 
     */
    public LoadTransferTypesByIDResponse createLoadTransferTypesByIDResponse() {
        return new LoadTransferTypesByIDResponse();
    }

    /**
     * Create an instance of {@link MemberFields }
     * 
     */
    public MemberFields createMemberFields() {
        return new MemberFields();
    }

    /**
     * Create an instance of {@link TransferTypeView }
     * 
     */
    public TransferTypeView createTransferTypeView() {
        return new TransferTypeView();
    }

    /**
     * Create an instance of {@link Members }
     * 
     */
    public Members createMembers() {
        return new Members();
    }

    /**
     * Create an instance of {@link ResponseStatus }
     * 
     */
    public ResponseStatus createResponseStatus() {
        return new ResponseStatus();
    }

    /**
     * Create an instance of {@link LoadTransferTypesByUsernameRequest }
     * 
     */
    public LoadTransferTypesByUsernameRequest createLoadTransferTypesByUsernameRequest() {
        return new LoadTransferTypesByUsernameRequest();
    }

    /**
     * Create an instance of {@link LoadTransferTypesResponse }
     * 
     */
    public LoadTransferTypesResponse createLoadTransferTypesResponse() {
        return new LoadTransferTypesResponse();
    }

    /**
     * Create an instance of {@link ExternalMemberFields }
     * 
     */
    public ExternalMemberFields createExternalMemberFields() {
        return new ExternalMemberFields();
    }

    /**
     * Create an instance of {@link LoadTransferTypesByUsernameResponse }
     * 
     */
    public LoadTransferTypesByUsernameResponse createLoadTransferTypesByUsernameResponse() {
        return new LoadTransferTypesByUsernameResponse();
    }

    /**
     * Create an instance of {@link LoadPermissionByTransferTypesRequest }
     * 
     */
    public LoadPermissionByTransferTypesRequest createLoadPermissionByTransferTypesRequest() {
        return new LoadPermissionByTransferTypesRequest();
    }

    /**
     * Create an instance of {@link TransferTypesPermission }
     * 
     */
    public TransferTypesPermission createTransferTypesPermission() {
        return new TransferTypesPermission();
    }

    /**
     * Create an instance of {@link LoadTransferTypesByIDRequest }
     * 
     */
    public LoadTransferTypesByIDRequest createLoadTransferTypesByIDRequest() {
        return new LoadTransferTypesByIDRequest();
    }

    /**
     * Create an instance of {@link LoadFeesByTransferTypeRequest }
     * 
     */
    public LoadFeesByTransferTypeRequest createLoadFeesByTransferTypeRequest() {
        return new LoadFeesByTransferTypeRequest();
    }

    /**
     * Create an instance of {@link TransferTypeRequest }
     * 
     */
    public TransferTypeRequest createTransferTypeRequest() {
        return new TransferTypeRequest();
    }

    /**
     * Create an instance of {@link FeeRequest }
     * 
     */
    public FeeRequest createFeeRequest() {
        return new FeeRequest();
    }

    /**
     * Create an instance of {@link TransactionException }
     * 
     */
    public TransactionException createTransactionException() {
        return new TransactionException();
    }

    /**
     * Create an instance of {@link LoadTransferTypesByAccountIDResponse }
     * 
     */
    public LoadTransferTypesByAccountIDResponse createLoadTransferTypesByAccountIDResponse() {
        return new LoadTransferTypesByAccountIDResponse();
    }

    /**
     * Create an instance of {@link Header }
     * 
     */
    public Header createHeader() {
        return new Header();
    }

    /**
     * Create an instance of {@link LoadTransferTypesRequest }
     * 
     */
    public LoadTransferTypesRequest createLoadTransferTypesRequest() {
        return new LoadTransferTypesRequest();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadTransferTypesByAccountIDRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "loadTransferTypesByAccountID")
    public JAXBElement<LoadTransferTypesByAccountIDRequest> createLoadTransferTypesByAccountID(LoadTransferTypesByAccountIDRequest value) {
        return new JAXBElement<LoadTransferTypesByAccountIDRequest>(_LoadTransferTypesByAccountID_QNAME, LoadTransferTypesByAccountIDRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadTransferTypesByAccountIDResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "loadTransferTypesByAccountIDResponse")
    public JAXBElement<LoadTransferTypesByAccountIDResponse> createLoadTransferTypesByAccountIDResponse(LoadTransferTypesByAccountIDResponse value) {
        return new JAXBElement<LoadTransferTypesByAccountIDResponse>(_LoadTransferTypesByAccountIDResponse_QNAME, LoadTransferTypesByAccountIDResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadFeesByTransferTypeRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "loadFeesByTransferType")
    public JAXBElement<LoadFeesByTransferTypeRequest> createLoadFeesByTransferType(LoadFeesByTransferTypeRequest value) {
        return new JAXBElement<LoadFeesByTransferTypeRequest>(_LoadFeesByTransferType_QNAME, LoadFeesByTransferTypeRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadPermissionByTransferTypesRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "updateTransferTypePermission")
    public JAXBElement<LoadPermissionByTransferTypesRequest> createUpdateTransferTypePermission(LoadPermissionByTransferTypesRequest value) {
        return new JAXBElement<LoadPermissionByTransferTypesRequest>(_UpdateTransferTypePermission_QNAME, LoadPermissionByTransferTypesRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadTransferTypesByIDRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "loadTransferTypesByID")
    public JAXBElement<LoadTransferTypesByIDRequest> createLoadTransferTypesByID(LoadTransferTypesByIDRequest value) {
        return new JAXBElement<LoadTransferTypesByIDRequest>(_LoadTransferTypesByID_QNAME, LoadTransferTypesByIDRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadTransferTypesByIDResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "loadTransferTypesByIDResponse")
    public JAXBElement<LoadTransferTypesByIDResponse> createLoadTransferTypesByIDResponse(LoadTransferTypesByIDResponse value) {
        return new JAXBElement<LoadTransferTypesByIDResponse>(_LoadTransferTypesByIDResponse_QNAME, LoadTransferTypesByIDResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadTransferTypesByUsernameRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "loadTransferTypesByUsername")
    public JAXBElement<LoadTransferTypesByUsernameRequest> createLoadTransferTypesByUsername(LoadTransferTypesByUsernameRequest value) {
        return new JAXBElement<LoadTransferTypesByUsernameRequest>(_LoadTransferTypesByUsername_QNAME, LoadTransferTypesByUsernameRequest.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadTransferTypesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "loadAllTransferTypesResponse")
    public JAXBElement<LoadTransferTypesResponse> createLoadAllTransferTypesResponse(LoadTransferTypesResponse value) {
        return new JAXBElement<LoadTransferTypesResponse>(_LoadAllTransferTypesResponse_QNAME, LoadTransferTypesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FeeRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "updateFees")
    public JAXBElement<FeeRequest> createUpdateFees(FeeRequest value) {
        return new JAXBElement<FeeRequest>(_UpdateFees_QNAME, FeeRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadTransferTypesByUsernameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "loadTransferTypesByUsernameResponse")
    public JAXBElement<LoadTransferTypesByUsernameResponse> createLoadTransferTypesByUsernameResponse(LoadTransferTypesByUsernameResponse value) {
        return new JAXBElement<LoadTransferTypesByUsernameResponse>(_LoadTransferTypesByUsernameResponse_QNAME, LoadTransferTypesByUsernameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FeeRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "createFees")
    public JAXBElement<FeeRequest> createCreateFees(FeeRequest value) {
        return new JAXBElement<FeeRequest>(_CreateFees_QNAME, FeeRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FeeRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "deleteFees")
    public JAXBElement<FeeRequest> createDeleteFees(FeeRequest value) {
        return new JAXBElement<FeeRequest>(_DeleteFees_QNAME, FeeRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TransferTypeRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "updateTransferTypes")
    public JAXBElement<TransferTypeRequest> createUpdateTransferTypes(TransferTypeRequest value) {
        return new JAXBElement<TransferTypeRequest>(_UpdateTransferTypes_QNAME, TransferTypeRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TransferTypePermissionRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "createTransferTypePermissions")
    public JAXBElement<TransferTypePermissionRequest> createCreateTransferTypePermissions(TransferTypePermissionRequest value) {
        return new JAXBElement<TransferTypePermissionRequest>(_CreateTransferTypePermissions_QNAME, TransferTypePermissionRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TransferTypeRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "createTransferTypes")
    public JAXBElement<TransferTypeRequest> createCreateTransferTypes(TransferTypeRequest value) {
        return new JAXBElement<TransferTypeRequest>(_CreateTransferTypes_QNAME, TransferTypeRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadPermissionByTransferTypesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "loadPermissionsByTransferTypeResponse")
    public JAXBElement<LoadPermissionByTransferTypesResponse> createLoadPermissionsByTransferTypeResponse(LoadPermissionByTransferTypesResponse value) {
        return new JAXBElement<LoadPermissionByTransferTypesResponse>(_LoadPermissionsByTransferTypeResponse_QNAME, LoadPermissionByTransferTypesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadPermissionByTransferTypesRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "loadPermissionsByTransferType")
    public JAXBElement<LoadPermissionByTransferTypesRequest> createLoadPermissionsByTransferType(LoadPermissionByTransferTypesRequest value) {
        return new JAXBElement<LoadPermissionByTransferTypesRequest>(_LoadPermissionsByTransferType_QNAME, LoadPermissionByTransferTypesRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadTransferTypesRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "loadAllTransferTypes")
    public JAXBElement<LoadTransferTypesRequest> createLoadAllTransferTypes(LoadTransferTypesRequest value) {
        return new JAXBElement<LoadTransferTypesRequest>(_LoadAllTransferTypes_QNAME, LoadTransferTypesRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadPermissionByTransferTypesRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "deleteTransferTypePermissions")
    public JAXBElement<LoadPermissionByTransferTypesRequest> createDeleteTransferTypePermissions(LoadPermissionByTransferTypesRequest value) {
        return new JAXBElement<LoadPermissionByTransferTypesRequest>(_DeleteTransferTypePermissions_QNAME, LoadPermissionByTransferTypesRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TransactionException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "TransactionException")
    public JAXBElement<TransactionException> createTransactionException(TransactionException value) {
        return new JAXBElement<TransactionException>(_TransactionException_QNAME, TransactionException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadFeesByTransferTypeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "loadFeesByTransferTypeResponse")
    public JAXBElement<LoadFeesByTransferTypeResponse> createLoadFeesByTransferTypeResponse(LoadFeesByTransferTypeResponse value) {
        return new JAXBElement<LoadFeesByTransferTypeResponse>(_LoadFeesByTransferTypeResponse_QNAME, LoadFeesByTransferTypeResponse.class, null, value);
    }

}
