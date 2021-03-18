package org.bellatrix.services.ws.access;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 2.7.15
 * 2021-03-15T15:43:28.210+07:00
 * Generated source version: 2.7.15
 * 
 */
@WebService(targetNamespace = "http://services.bellatrix.org/", name = "Access")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface Access {

    @WebMethod(action = "credentialStatus")
    @WebResult(name = "credentialStatusResponse", targetNamespace = "http://services.bellatrix.org/", partName = "credentialStatusResponse")
    public CredentialStatusResponse credentialStatus(
        @WebParam(partName = "headerAuth", mode = WebParam.Mode.INOUT, name = "headerAuth", targetNamespace = "http://services.bellatrix.org/", header = true)
        javax.xml.ws.Holder<Header> headerAuth,
        @WebParam(partName = "credentialStatus", name = "credentialStatus", targetNamespace = "http://services.bellatrix.org/")
        CredentialStatusRequest credentialStatus
    );

    @WebMethod(action = "updateAccessType")
    public void updateAccessType(
        @WebParam(partName = "headerAuth", mode = WebParam.Mode.INOUT, name = "headerAuth", targetNamespace = "http://services.bellatrix.org/", header = true)
        javax.xml.ws.Holder<Header> headerAuth,
        @WebParam(partName = "updateAccessType", name = "updateAccessType", targetNamespace = "http://services.bellatrix.org/")
        AccessTypeRequest updateAccessType
    ) throws Exception_Exception;

    @WebMethod(action = "changeCredential")
    public void changeCredential(
        @WebParam(partName = "headerAuth", mode = WebParam.Mode.INOUT, name = "headerAuth", targetNamespace = "http://services.bellatrix.org/", header = true)
        javax.xml.ws.Holder<Header> headerAuth,
        @WebParam(partName = "changeCredential", name = "changeCredential", targetNamespace = "http://services.bellatrix.org/")
        ChangeCredentialRequest changeCredential
    ) throws Exception_Exception;

    @WebMethod(action = "getCredential")
    @WebResult(name = "getCredentialResponse", targetNamespace = "http://services.bellatrix.org/", partName = "getCredentialResponse")
    public CredentialResponse getCredential(
        @WebParam(partName = "headerAuth", mode = WebParam.Mode.INOUT, name = "headerAuth", targetNamespace = "http://services.bellatrix.org/", header = true)
        javax.xml.ws.Holder<Header> headerAuth,
        @WebParam(partName = "getCredential", name = "getCredential", targetNamespace = "http://services.bellatrix.org/")
        CredentialRequest getCredential
    ) throws Exception_Exception;

    @WebMethod(action = "resetCredential")
    @WebResult(name = "resetCredentialResponse", targetNamespace = "http://services.bellatrix.org/", partName = "resetCredentialResponse")
    public ResetCredentialResponse resetCredential(
        @WebParam(partName = "headerAuth", mode = WebParam.Mode.INOUT, name = "headerAuth", targetNamespace = "http://services.bellatrix.org/", header = true)
        javax.xml.ws.Holder<Header> headerAuth,
        @WebParam(partName = "resetCredential", name = "resetCredential", targetNamespace = "http://services.bellatrix.org/")
        ResetCredentialRequest resetCredential
    );

    @WebMethod(action = "createAccessType")
    public void createAccessType(
        @WebParam(partName = "headerAuth", mode = WebParam.Mode.INOUT, name = "headerAuth", targetNamespace = "http://services.bellatrix.org/", header = true)
        javax.xml.ws.Holder<Header> headerAuth,
        @WebParam(partName = "createAccessType", name = "createAccessType", targetNamespace = "http://services.bellatrix.org/")
        AccessTypeRequest createAccessType
    ) throws Exception_Exception;

    @WebMethod(action = "validateCredential")
    @WebResult(name = "validateCredentialResponse", targetNamespace = "http://services.bellatrix.org/", partName = "validateCredentialResponse")
    public ValidateCredentialResponse validateCredential(
        @WebParam(partName = "headerAuth", mode = WebParam.Mode.INOUT, name = "headerAuth", targetNamespace = "http://services.bellatrix.org/", header = true)
        javax.xml.ws.Holder<Header> headerAuth,
        @WebParam(partName = "validateCredential", name = "validateCredential", targetNamespace = "http://services.bellatrix.org/")
        ValidateCredentialRequest validateCredential
    );

    @WebMethod(action = "unblockCredential")
    public void unblockCredential(
        @WebParam(partName = "headerAuth", mode = WebParam.Mode.INOUT, name = "headerAuth", targetNamespace = "http://services.bellatrix.org/", header = true)
        javax.xml.ws.Holder<Header> headerAuth,
        @WebParam(partName = "unblockCredential", name = "unblockCredential", targetNamespace = "http://services.bellatrix.org/")
        UnblockCredentialRequest unblockCredential
    ) throws Exception_Exception;

    @WebMethod(action = "loadAccessType")
    @WebResult(name = "loadAccessTypeResponse", targetNamespace = "http://services.bellatrix.org/", partName = "loadAccessTypeResponse")
    public LoadAccessTypeResponse loadAccessType(
        @WebParam(partName = "headerAuth", mode = WebParam.Mode.INOUT, name = "headerAuth", targetNamespace = "http://services.bellatrix.org/", header = true)
        javax.xml.ws.Holder<Header> headerAuth,
        @WebParam(partName = "loadAccessType", name = "loadAccessType", targetNamespace = "http://services.bellatrix.org/")
        LoadAccessTypeRequest loadAccessType
    ) throws Exception_Exception;

    @WebMethod(action = "createCredential")
    public void createCredential(
        @WebParam(partName = "headerAuth", mode = WebParam.Mode.INOUT, name = "headerAuth", targetNamespace = "http://services.bellatrix.org/", header = true)
        javax.xml.ws.Holder<Header> headerAuth,
        @WebParam(partName = "createCredential", name = "createCredential", targetNamespace = "http://services.bellatrix.org/")
        CreateCredentialRequest createCredential
    ) throws Exception_Exception;
}
