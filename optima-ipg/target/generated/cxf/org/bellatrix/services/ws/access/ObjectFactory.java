
package org.bellatrix.services.ws.access;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.bellatrix.services.ws.access package. 
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

    private final static QName _CredentialStatus_QNAME = new QName("http://services.bellatrix.org/", "credentialStatus");
    private final static QName _Exception_QNAME = new QName("http://services.bellatrix.org/", "Exception");
    private final static QName _UpdateAccessType_QNAME = new QName("http://services.bellatrix.org/", "updateAccessType");
    private final static QName _ChangeCredential_QNAME = new QName("http://services.bellatrix.org/", "changeCredential");
    private final static QName _GetCredential_QNAME = new QName("http://services.bellatrix.org/", "getCredential");
    private final static QName _ResetCredentialResponse_QNAME = new QName("http://services.bellatrix.org/", "resetCredentialResponse");
    private final static QName _CreateAccessType_QNAME = new QName("http://services.bellatrix.org/", "createAccessType");
    private final static QName _GetCredentialResponse_QNAME = new QName("http://services.bellatrix.org/", "getCredentialResponse");
    private final static QName _UnblockCredential_QNAME = new QName("http://services.bellatrix.org/", "unblockCredential");
    private final static QName _HeaderAuth_QNAME = new QName("http://services.bellatrix.org/", "headerAuth");
    private final static QName _ValidateCredentialResponse_QNAME = new QName("http://services.bellatrix.org/", "validateCredentialResponse");
    private final static QName _LoadAccessType_QNAME = new QName("http://services.bellatrix.org/", "loadAccessType");
    private final static QName _LoadAccessTypeResponse_QNAME = new QName("http://services.bellatrix.org/", "loadAccessTypeResponse");
    private final static QName _CreateCredential_QNAME = new QName("http://services.bellatrix.org/", "createCredential");
    private final static QName _CredentialStatusResponse_QNAME = new QName("http://services.bellatrix.org/", "credentialStatusResponse");
    private final static QName _ResetCredential_QNAME = new QName("http://services.bellatrix.org/", "resetCredential");
    private final static QName _ValidateCredential_QNAME = new QName("http://services.bellatrix.org/", "validateCredential");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.bellatrix.services.ws.access
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link UnblockCredentialRequest }
     * 
     */
    public UnblockCredentialRequest createUnblockCredentialRequest() {
        return new UnblockCredentialRequest();
    }

    /**
     * Create an instance of {@link CredentialRequest }
     * 
     */
    public CredentialRequest createCredentialRequest() {
        return new CredentialRequest();
    }

    /**
     * Create an instance of {@link AccessType }
     * 
     */
    public AccessType createAccessType() {
        return new AccessType();
    }

    /**
     * Create an instance of {@link AccessTypeRequest }
     * 
     */
    public AccessTypeRequest createAccessTypeRequest() {
        return new AccessTypeRequest();
    }

    /**
     * Create an instance of {@link ResponseStatus }
     * 
     */
    public ResponseStatus createResponseStatus() {
        return new ResponseStatus();
    }

    /**
     * Create an instance of {@link CreateCredentialRequest }
     * 
     */
    public CreateCredentialRequest createCreateCredentialRequest() {
        return new CreateCredentialRequest();
    }

    /**
     * Create an instance of {@link ChangeCredentialRequest }
     * 
     */
    public ChangeCredentialRequest createChangeCredentialRequest() {
        return new ChangeCredentialRequest();
    }

    /**
     * Create an instance of {@link ValidateCredentialRequest }
     * 
     */
    public ValidateCredentialRequest createValidateCredentialRequest() {
        return new ValidateCredentialRequest();
    }

    /**
     * Create an instance of {@link LoadAccessTypeRequest }
     * 
     */
    public LoadAccessTypeRequest createLoadAccessTypeRequest() {
        return new LoadAccessTypeRequest();
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
    }

    /**
     * Create an instance of {@link CredentialStatusRequest }
     * 
     */
    public CredentialStatusRequest createCredentialStatusRequest() {
        return new CredentialStatusRequest();
    }

    /**
     * Create an instance of {@link LoadAccessTypeResponse }
     * 
     */
    public LoadAccessTypeResponse createLoadAccessTypeResponse() {
        return new LoadAccessTypeResponse();
    }

    /**
     * Create an instance of {@link ResetCredentialResponse }
     * 
     */
    public ResetCredentialResponse createResetCredentialResponse() {
        return new ResetCredentialResponse();
    }

    /**
     * Create an instance of {@link CredentialResponse }
     * 
     */
    public CredentialResponse createCredentialResponse() {
        return new CredentialResponse();
    }

    /**
     * Create an instance of {@link CredentialStatusResponse }
     * 
     */
    public CredentialStatusResponse createCredentialStatusResponse() {
        return new CredentialStatusResponse();
    }

    /**
     * Create an instance of {@link AccessStatus }
     * 
     */
    public AccessStatus createAccessStatus() {
        return new AccessStatus();
    }

    /**
     * Create an instance of {@link ValidateCredentialResponse }
     * 
     */
    public ValidateCredentialResponse createValidateCredentialResponse() {
        return new ValidateCredentialResponse();
    }

    /**
     * Create an instance of {@link ResetCredentialRequest }
     * 
     */
    public ResetCredentialRequest createResetCredentialRequest() {
        return new ResetCredentialRequest();
    }

    /**
     * Create an instance of {@link Header }
     * 
     */
    public Header createHeader() {
        return new Header();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CredentialStatusRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "credentialStatus")
    public JAXBElement<CredentialStatusRequest> createCredentialStatus(CredentialStatusRequest value) {
        return new JAXBElement<CredentialStatusRequest>(_CredentialStatus_QNAME, CredentialStatusRequest.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link AccessTypeRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "updateAccessType")
    public JAXBElement<AccessTypeRequest> createUpdateAccessType(AccessTypeRequest value) {
        return new JAXBElement<AccessTypeRequest>(_UpdateAccessType_QNAME, AccessTypeRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ChangeCredentialRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "changeCredential")
    public JAXBElement<ChangeCredentialRequest> createChangeCredential(ChangeCredentialRequest value) {
        return new JAXBElement<ChangeCredentialRequest>(_ChangeCredential_QNAME, ChangeCredentialRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CredentialRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "getCredential")
    public JAXBElement<CredentialRequest> createGetCredential(CredentialRequest value) {
        return new JAXBElement<CredentialRequest>(_GetCredential_QNAME, CredentialRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ResetCredentialResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "resetCredentialResponse")
    public JAXBElement<ResetCredentialResponse> createResetCredentialResponse(ResetCredentialResponse value) {
        return new JAXBElement<ResetCredentialResponse>(_ResetCredentialResponse_QNAME, ResetCredentialResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AccessTypeRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "createAccessType")
    public JAXBElement<AccessTypeRequest> createCreateAccessType(AccessTypeRequest value) {
        return new JAXBElement<AccessTypeRequest>(_CreateAccessType_QNAME, AccessTypeRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CredentialResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "getCredentialResponse")
    public JAXBElement<CredentialResponse> createGetCredentialResponse(CredentialResponse value) {
        return new JAXBElement<CredentialResponse>(_GetCredentialResponse_QNAME, CredentialResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UnblockCredentialRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "unblockCredential")
    public JAXBElement<UnblockCredentialRequest> createUnblockCredential(UnblockCredentialRequest value) {
        return new JAXBElement<UnblockCredentialRequest>(_UnblockCredential_QNAME, UnblockCredentialRequest.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidateCredentialResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "validateCredentialResponse")
    public JAXBElement<ValidateCredentialResponse> createValidateCredentialResponse(ValidateCredentialResponse value) {
        return new JAXBElement<ValidateCredentialResponse>(_ValidateCredentialResponse_QNAME, ValidateCredentialResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadAccessTypeRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "loadAccessType")
    public JAXBElement<LoadAccessTypeRequest> createLoadAccessType(LoadAccessTypeRequest value) {
        return new JAXBElement<LoadAccessTypeRequest>(_LoadAccessType_QNAME, LoadAccessTypeRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadAccessTypeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "loadAccessTypeResponse")
    public JAXBElement<LoadAccessTypeResponse> createLoadAccessTypeResponse(LoadAccessTypeResponse value) {
        return new JAXBElement<LoadAccessTypeResponse>(_LoadAccessTypeResponse_QNAME, LoadAccessTypeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateCredentialRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "createCredential")
    public JAXBElement<CreateCredentialRequest> createCreateCredential(CreateCredentialRequest value) {
        return new JAXBElement<CreateCredentialRequest>(_CreateCredential_QNAME, CreateCredentialRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CredentialStatusResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "credentialStatusResponse")
    public JAXBElement<CredentialStatusResponse> createCredentialStatusResponse(CredentialStatusResponse value) {
        return new JAXBElement<CredentialStatusResponse>(_CredentialStatusResponse_QNAME, CredentialStatusResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ResetCredentialRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "resetCredential")
    public JAXBElement<ResetCredentialRequest> createResetCredential(ResetCredentialRequest value) {
        return new JAXBElement<ResetCredentialRequest>(_ResetCredential_QNAME, ResetCredentialRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidateCredentialRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "validateCredential")
    public JAXBElement<ValidateCredentialRequest> createValidateCredential(ValidateCredentialRequest value) {
        return new JAXBElement<ValidateCredentialRequest>(_ValidateCredential_QNAME, ValidateCredentialRequest.class, null, value);
    }

}
