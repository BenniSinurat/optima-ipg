package org.bellatrix.services.ws.members;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 2.7.15
 * 2021-07-30T16:44:25.956+07:00
 * Generated source version: 2.7.15
 * 
 */
@WebService(targetNamespace = "http://services.bellatrix.org/", name = "Member")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface Member {

    @WebMethod(action = "loadAllMembers")
    @WebResult(name = "loadAllMembersResponse", targetNamespace = "http://services.bellatrix.org/", partName = "loadAllMembersResponse")
    public LoadMembersResponse loadAllMembers(
        @WebParam(partName = "headerAuth", mode = WebParam.Mode.INOUT, name = "headerAuth", targetNamespace = "http://services.bellatrix.org/", header = true)
        javax.xml.ws.Holder<Header> headerAuth,
        @WebParam(partName = "loadAllMembers", name = "loadAllMembers", targetNamespace = "http://services.bellatrix.org/")
        LoadMembersRequest loadAllMembers
    );

    @WebMethod(action = "confirmKYCRequest")
    @WebResult(name = "confirmKYCRequestResponse", targetNamespace = "http://services.bellatrix.org/", partName = "confirmKYCRequestResponse")
    public ConfirmKYCResponse confirmKYCRequest(
        @WebParam(partName = "headerAuth", mode = WebParam.Mode.INOUT, name = "headerAuth", targetNamespace = "http://services.bellatrix.org/", header = true)
        javax.xml.ws.Holder<Header> headerAuth,
        @WebParam(partName = "confirmKYCRequest", name = "confirmKYCRequest", targetNamespace = "http://services.bellatrix.org/")
        ConfirmKYCRequest confirmKYCRequest
    ) throws Exception_Exception;

    @WebMethod(action = "registerMembers")
    public void registerMembers(
        @WebParam(partName = "headerAuth", mode = WebParam.Mode.INOUT, name = "headerAuth", targetNamespace = "http://services.bellatrix.org/", header = true)
        javax.xml.ws.Holder<Header> headerAuth,
        @WebParam(partName = "registerMembers", name = "registerMembers", targetNamespace = "http://services.bellatrix.org/")
        RegisterMemberRequest registerMembers
    ) throws Exception_Exception;

    @WebMethod(action = "registerMerchants")
    public void registerMerchants(
        @WebParam(partName = "headerAuth", mode = WebParam.Mode.INOUT, name = "headerAuth", targetNamespace = "http://services.bellatrix.org/", header = true)
        javax.xml.ws.Holder<Header> headerAuth,
        @WebParam(partName = "registerMerchants", name = "registerMerchants", targetNamespace = "http://services.bellatrix.org/")
        RegisterMerchantRequest registerMerchants
    ) throws Exception_Exception;

    @WebMethod(action = "confirmMerchantRequest")
    @WebResult(name = "confirmMerchantRequestResponse", targetNamespace = "http://services.bellatrix.org/", partName = "confirmMerchantRequestResponse")
    public ConfirmMerchantResponse confirmMerchantRequest(
        @WebParam(partName = "headerAuth", mode = WebParam.Mode.INOUT, name = "headerAuth", targetNamespace = "http://services.bellatrix.org/", header = true)
        javax.xml.ws.Holder<Header> headerAuth,
        @WebParam(partName = "confirmMerchantRequest", name = "confirmMerchantRequest", targetNamespace = "http://services.bellatrix.org/")
        ConfirmMerchantRequest confirmMerchantRequest
    ) throws Exception_Exception;

    @WebMethod(action = "loadKYCRequest")
    @WebResult(name = "loadKYCRequestResponse", targetNamespace = "http://services.bellatrix.org/", partName = "loadKYCRequestResponse")
    public LoadKYCResponse loadKYCRequest(
        @WebParam(partName = "headerAuth", mode = WebParam.Mode.INOUT, name = "headerAuth", targetNamespace = "http://services.bellatrix.org/", header = true)
        javax.xml.ws.Holder<Header> headerAuth,
        @WebParam(partName = "loadKYCRequest", name = "loadKYCRequest", targetNamespace = "http://services.bellatrix.org/")
        LoadKYCRequest loadKYCRequest
    ) throws Exception_Exception;

    @WebMethod(action = "loadMembersByUsername")
    @WebResult(name = "loadMembersByUsernameResponse", targetNamespace = "http://services.bellatrix.org/", partName = "loadMembersByUsernameResponse")
    public LoadMembersResponse loadMembersByUsername(
        @WebParam(partName = "headerAuth", mode = WebParam.Mode.INOUT, name = "headerAuth", targetNamespace = "http://services.bellatrix.org/", header = true)
        javax.xml.ws.Holder<Header> headerAuth,
        @WebParam(partName = "loadMembersByUsername", name = "loadMembersByUsername", targetNamespace = "http://services.bellatrix.org/")
        LoadMembersByUsernameRequest loadMembersByUsername
    );

    @WebMethod(action = "registerExternalMembers")
    public void registerExternalMembers(
        @WebParam(partName = "headerAuth", mode = WebParam.Mode.INOUT, name = "headerAuth", targetNamespace = "http://services.bellatrix.org/", header = true)
        javax.xml.ws.Holder<Header> headerAuth,
        @WebParam(partName = "registerExternalMembers", name = "registerExternalMembers", targetNamespace = "http://services.bellatrix.org/")
        SubscribeMemberRequest registerExternalMembers
    ) throws Exception_Exception;

    @WebMethod(action = "loadMerchantCategory")
    @WebResult(name = "loadMerchantCategoryResponse", targetNamespace = "http://services.bellatrix.org/", partName = "loadMerchantCategoryResponse")
    public LoadMerchantCategoryResponse loadMerchantCategory(
        @WebParam(partName = "headerAuth", mode = WebParam.Mode.INOUT, name = "headerAuth", targetNamespace = "http://services.bellatrix.org/", header = true)
        javax.xml.ws.Holder<Header> headerAuth,
        @WebParam(partName = "loadMerchantCategory", name = "loadMerchantCategory", targetNamespace = "http://services.bellatrix.org/")
        LoadMerchantCategoryRequest loadMerchantCategory
    ) throws Exception_Exception;

    @WebMethod(action = "loadMerchantByUsername")
    @WebResult(name = "loadMerchantsByUsernameResponse", targetNamespace = "http://services.bellatrix.org/", partName = "loadMerchantsByUsernameResponse")
    public LoadMerchantByUsernameResponse loadMerchantsByUsername(
        @WebParam(partName = "headerAuth", mode = WebParam.Mode.INOUT, name = "headerAuth", targetNamespace = "http://services.bellatrix.org/", header = true)
        javax.xml.ws.Holder<Header> headerAuth,
        @WebParam(partName = "loadMerchantsByUsername", name = "loadMerchantsByUsername", targetNamespace = "http://services.bellatrix.org/")
        LoadMerchantByUsernameRequest loadMerchantsByUsername
    );

    @WebMethod(action = "loadMerchantSubCategory")
    @WebResult(name = "loadMerchantSubCategoryResponse", targetNamespace = "http://services.bellatrix.org/", partName = "loadMerchantSubCategoryResponse")
    public LoadMerchantSubCategoryResponse loadMerchantSubCategory(
        @WebParam(partName = "headerAuth", mode = WebParam.Mode.INOUT, name = "headerAuth", targetNamespace = "http://services.bellatrix.org/", header = true)
        javax.xml.ws.Holder<Header> headerAuth,
        @WebParam(partName = "loadMerchantSubCategory", name = "loadMerchantSubCategory", targetNamespace = "http://services.bellatrix.org/")
        LoadMerchantSubCategoryRequest loadMerchantSubCategory
    ) throws Exception_Exception;

    @WebMethod(action = "validateKYCRequest")
    @WebResult(name = "validateKYCRequestResponse", targetNamespace = "http://services.bellatrix.org/", partName = "validateKYCRequestResponse")
    public ValidateKYCResponse validateKYCRequest(
        @WebParam(partName = "headerAuth", mode = WebParam.Mode.INOUT, name = "headerAuth", targetNamespace = "http://services.bellatrix.org/", header = true)
        javax.xml.ws.Holder<Header> headerAuth,
        @WebParam(partName = "validateKYCRequest", name = "validateKYCRequest", targetNamespace = "http://services.bellatrix.org/")
        ValidateKYCRequest validateKYCRequest
    ) throws Exception_Exception;

    @WebMethod(action = "loadMerchantBusinessScale")
    @WebResult(name = "loadMerchantBusinessScaleResponse", targetNamespace = "http://services.bellatrix.org/", partName = "loadMerchantBusinessScaleResponse")
    public LoadMerchantBusinessScaleResponse loadMerchantBusinessScale(
        @WebParam(partName = "headerAuth", mode = WebParam.Mode.INOUT, name = "headerAuth", targetNamespace = "http://services.bellatrix.org/", header = true)
        javax.xml.ws.Holder<Header> headerAuth,
        @WebParam(partName = "loadMerchantBusinessScale", name = "loadMerchantBusinessScale", targetNamespace = "http://services.bellatrix.org/")
        LoadMerchantBusinessScaleRequest loadMerchantBusinessScale
    ) throws Exception_Exception;

    @WebMethod(action = "loadMerchantRequest")
    @WebResult(name = "loadMerchantRequestResponse", targetNamespace = "http://services.bellatrix.org/", partName = "loadMerchantRequestResponse")
    public LoadMerchantResponse loadMerchantRequest(
        @WebParam(partName = "headerAuth", mode = WebParam.Mode.INOUT, name = "headerAuth", targetNamespace = "http://services.bellatrix.org/", header = true)
        javax.xml.ws.Holder<Header> headerAuth,
        @WebParam(partName = "loadMerchantRequest", name = "loadMerchantRequest", targetNamespace = "http://services.bellatrix.org/")
        LoadMerchantRequest loadMerchantRequest
    ) throws Exception_Exception;

    @WebMethod(action = "unregisterExternalMembers")
    public void unregisterExternalMembers(
        @WebParam(partName = "headerAuth", mode = WebParam.Mode.INOUT, name = "headerAuth", targetNamespace = "http://services.bellatrix.org/", header = true)
        javax.xml.ws.Holder<Header> headerAuth,
        @WebParam(partName = "unregisterExternalMembers", name = "unregisterExternalMembers", targetNamespace = "http://services.bellatrix.org/")
        SubscribeMemberRequest unregisterExternalMembers
    ) throws Exception_Exception;

    @WebMethod(action = "loadMembersByExternalID")
    @WebResult(name = "loadMembersByExternalIDResponse", targetNamespace = "http://services.bellatrix.org/", partName = "loadMembersByExternalIDResponse")
    public LoadMembersResponse loadMembersByExternalID(
        @WebParam(partName = "headerAuth", mode = WebParam.Mode.INOUT, name = "headerAuth", targetNamespace = "http://services.bellatrix.org/", header = true)
        javax.xml.ws.Holder<Header> headerAuth,
        @WebParam(partName = "loadMembersByExternalID", name = "loadMembersByExternalID", targetNamespace = "http://services.bellatrix.org/")
        LoadMembersByExternalIDRequest loadMembersByExternalID
    );

    @WebMethod(action = "loadMembersByGroupID")
    @WebResult(name = "loadMembersByGroupIDResponse", targetNamespace = "http://services.bellatrix.org/", partName = "loadMembersByGroupIDResponse")
    public LoadMembersResponse loadMembersByGroupID(
        @WebParam(partName = "headerAuth", mode = WebParam.Mode.INOUT, name = "headerAuth", targetNamespace = "http://services.bellatrix.org/", header = true)
        javax.xml.ws.Holder<Header> headerAuth,
        @WebParam(partName = "loadMembersByGroupID", name = "loadMembersByGroupID", targetNamespace = "http://services.bellatrix.org/")
        LoadMembersByGroupIDRequest loadMembersByGroupID
    );

    @WebMethod(action = "loadMembersByID")
    @WebResult(name = "loadMembersByIDResponse", targetNamespace = "http://services.bellatrix.org/", partName = "loadMembersByIDResponse")
    public LoadMembersResponse loadMembersByID(
        @WebParam(partName = "headerAuth", mode = WebParam.Mode.INOUT, name = "headerAuth", targetNamespace = "http://services.bellatrix.org/", header = true)
        javax.xml.ws.Holder<Header> headerAuth,
        @WebParam(partName = "loadMembersByID", name = "loadMembersByID", targetNamespace = "http://services.bellatrix.org/")
        LoadMembersByIDRequest loadMembersByID
    );

    @WebMethod(action = "updateMembers")
    public void updateMembers(
        @WebParam(partName = "headerAuth", mode = WebParam.Mode.INOUT, name = "headerAuth", targetNamespace = "http://services.bellatrix.org/", header = true)
        javax.xml.ws.Holder<Header> headerAuth,
        @WebParam(partName = "updateMembers", name = "updateMembers", targetNamespace = "http://services.bellatrix.org/")
        UpdateMemberRequest updateMembers
    ) throws Exception_Exception;

    @WebMethod(action = "membersKYCRequest")
    public void membersKYCRequest(
        @WebParam(partName = "headerAuth", mode = WebParam.Mode.INOUT, name = "headerAuth", targetNamespace = "http://services.bellatrix.org/", header = true)
        javax.xml.ws.Holder<Header> headerAuth,
        @WebParam(partName = "membersKYCRequest", name = "membersKYCRequest", targetNamespace = "http://services.bellatrix.org/")
        MemberKYCRequest membersKYCRequest
    ) throws Exception_Exception;

    @WebMethod(action = "updateMerchants")
    public void updateMerchants(
        @WebParam(partName = "headerAuth", mode = WebParam.Mode.INOUT, name = "headerAuth", targetNamespace = "http://services.bellatrix.org/", header = true)
        javax.xml.ws.Holder<Header> headerAuth,
        @WebParam(partName = "updateMerchants", name = "updateMerchants", targetNamespace = "http://services.bellatrix.org/")
        UpdateMerchantRequest updateMerchants
    ) throws Exception_Exception;
}
