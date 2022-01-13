package org.bellatrix.services.ws.transfertypes;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 2.7.15
 * 2022-01-13T13:47:31.827+07:00
 * Generated source version: 2.7.15
 * 
 */
@WebService(targetNamespace = "http://services.bellatrix.org/", name = "TransferType")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface TransferType {

    @WebMethod(action = "loadTransferTypesByAccountID")
    @WebResult(name = "loadTransferTypesByAccountIDResponse", targetNamespace = "http://services.bellatrix.org/", partName = "loadTransferTypesByAccountIDResponse")
    public LoadTransferTypesByAccountIDResponse loadTransferTypesByAccountID(
        @WebParam(partName = "headerAuth", mode = WebParam.Mode.INOUT, name = "headerAuth", targetNamespace = "http://services.bellatrix.org/", header = true)
        javax.xml.ws.Holder<Header> headerAuth,
        @WebParam(partName = "loadTransferTypesByAccountID", name = "loadTransferTypesByAccountID", targetNamespace = "http://services.bellatrix.org/")
        LoadTransferTypesByAccountIDRequest loadTransferTypesByAccountID
    );

    @WebMethod(action = "updateTransferTypePermission")
    public void updateTransferTypePermission(
        @WebParam(partName = "headerAuth", mode = WebParam.Mode.INOUT, name = "headerAuth", targetNamespace = "http://services.bellatrix.org/", header = true)
        javax.xml.ws.Holder<Header> headerAuth,
        @WebParam(partName = "updateTransferTypePermission", name = "updateTransferTypePermission", targetNamespace = "http://services.bellatrix.org/")
        LoadPermissionByTransferTypesRequest updateTransferTypePermission
    ) throws TransactionException_Exception;

    @WebMethod(action = "loadFeesByTransferType")
    @WebResult(name = "loadFeesByTransferTypeResponse", targetNamespace = "http://services.bellatrix.org/", partName = "loadFeesByTransferTypeResponse")
    public LoadFeesByTransferTypeResponse loadFeesByTransferType(
        @WebParam(partName = "headerAuth", mode = WebParam.Mode.INOUT, name = "headerAuth", targetNamespace = "http://services.bellatrix.org/", header = true)
        javax.xml.ws.Holder<Header> headerAuth,
        @WebParam(partName = "loadFeesByTransferType", name = "loadFeesByTransferType", targetNamespace = "http://services.bellatrix.org/")
        LoadFeesByTransferTypeRequest loadFeesByTransferType
    );

    @WebMethod(action = "loadTransferTypesByID")
    @WebResult(name = "loadTransferTypesByIDResponse", targetNamespace = "http://services.bellatrix.org/", partName = "loadTransferTypesByIDResponse")
    public LoadTransferTypesByIDResponse loadTransferTypesByID(
        @WebParam(partName = "headerAuth", mode = WebParam.Mode.INOUT, name = "headerAuth", targetNamespace = "http://services.bellatrix.org/", header = true)
        javax.xml.ws.Holder<Header> headerAuth,
        @WebParam(partName = "loadTransferTypesByID", name = "loadTransferTypesByID", targetNamespace = "http://services.bellatrix.org/")
        LoadTransferTypesByIDRequest loadTransferTypesByID
    );

    @WebMethod(action = "loadTransferTypesByUsername")
    @WebResult(name = "loadTransferTypesByUsernameResponse", targetNamespace = "http://services.bellatrix.org/", partName = "loadTransferTypesByUsernameResponse")
    public LoadTransferTypesByUsernameResponse loadTransferTypesByUsername(
        @WebParam(partName = "headerAuth", mode = WebParam.Mode.INOUT, name = "headerAuth", targetNamespace = "http://services.bellatrix.org/", header = true)
        javax.xml.ws.Holder<Header> headerAuth,
        @WebParam(partName = "loadTransferTypesByUsername", name = "loadTransferTypesByUsername", targetNamespace = "http://services.bellatrix.org/")
        LoadTransferTypesByUsernameRequest loadTransferTypesByUsername
    );

    @WebMethod(action = "updateFees")
    public void updateFees(
        @WebParam(partName = "headerAuth", mode = WebParam.Mode.INOUT, name = "headerAuth", targetNamespace = "http://services.bellatrix.org/", header = true)
        javax.xml.ws.Holder<Header> headerAuth,
        @WebParam(partName = "updateFees", name = "updateFees", targetNamespace = "http://services.bellatrix.org/")
        FeeRequest updateFees
    ) throws TransactionException_Exception;

    @WebMethod(action = "createFees")
    public void createFees(
        @WebParam(partName = "headerAuth", mode = WebParam.Mode.INOUT, name = "headerAuth", targetNamespace = "http://services.bellatrix.org/", header = true)
        javax.xml.ws.Holder<Header> headerAuth,
        @WebParam(partName = "createFees", name = "createFees", targetNamespace = "http://services.bellatrix.org/")
        FeeRequest createFees
    ) throws TransactionException_Exception;

    @WebMethod(action = "deleteFees")
    public void deleteFees(
        @WebParam(partName = "headerAuth", mode = WebParam.Mode.INOUT, name = "headerAuth", targetNamespace = "http://services.bellatrix.org/", header = true)
        javax.xml.ws.Holder<Header> headerAuth,
        @WebParam(partName = "deleteFees", name = "deleteFees", targetNamespace = "http://services.bellatrix.org/")
        FeeRequest deleteFees
    ) throws TransactionException_Exception;

    @WebMethod(action = "updateTransferTypes")
    public void updateTransferTypes(
        @WebParam(partName = "headerAuth", mode = WebParam.Mode.INOUT, name = "headerAuth", targetNamespace = "http://services.bellatrix.org/", header = true)
        javax.xml.ws.Holder<Header> headerAuth,
        @WebParam(partName = "updateTransferTypes", name = "updateTransferTypes", targetNamespace = "http://services.bellatrix.org/")
        TransferTypeRequest updateTransferTypes
    ) throws TransactionException_Exception;

    @WebMethod(action = "createTransferTypePermissions")
    public void createTransferTypePermissions(
        @WebParam(partName = "headerAuth", mode = WebParam.Mode.INOUT, name = "headerAuth", targetNamespace = "http://services.bellatrix.org/", header = true)
        javax.xml.ws.Holder<Header> headerAuth,
        @WebParam(partName = "createTransferTypePermissions", name = "createTransferTypePermissions", targetNamespace = "http://services.bellatrix.org/")
        TransferTypePermissionRequest createTransferTypePermissions
    ) throws TransactionException_Exception;

    @WebMethod(action = "createTransferTypes")
    public void createTransferTypes(
        @WebParam(partName = "headerAuth", mode = WebParam.Mode.INOUT, name = "headerAuth", targetNamespace = "http://services.bellatrix.org/", header = true)
        javax.xml.ws.Holder<Header> headerAuth,
        @WebParam(partName = "createTransferTypes", name = "createTransferTypes", targetNamespace = "http://services.bellatrix.org/")
        TransferTypeRequest createTransferTypes
    ) throws TransactionException_Exception;

    @WebMethod(action = "loadPermissionsByTransferType")
    @WebResult(name = "loadPermissionsByTransferTypeResponse", targetNamespace = "http://services.bellatrix.org/", partName = "loadPermissionsByTransferTypeResponse")
    public LoadPermissionByTransferTypesResponse loadPermissionsByTransferType(
        @WebParam(partName = "headerAuth", mode = WebParam.Mode.INOUT, name = "headerAuth", targetNamespace = "http://services.bellatrix.org/", header = true)
        javax.xml.ws.Holder<Header> headerAuth,
        @WebParam(partName = "loadPermissionsByTransferType", name = "loadPermissionsByTransferType", targetNamespace = "http://services.bellatrix.org/")
        LoadPermissionByTransferTypesRequest loadPermissionsByTransferType
    );

    @WebMethod(action = "loadAllTransferTypes")
    @WebResult(name = "loadAllTransferTypesResponse", targetNamespace = "http://services.bellatrix.org/", partName = "loadAllTransferTypesResponse")
    public LoadTransferTypesResponse loadAllTransferTypes(
        @WebParam(partName = "headerAuth", mode = WebParam.Mode.INOUT, name = "headerAuth", targetNamespace = "http://services.bellatrix.org/", header = true)
        javax.xml.ws.Holder<Header> headerAuth,
        @WebParam(partName = "loadAllTransferTypes", name = "loadAllTransferTypes", targetNamespace = "http://services.bellatrix.org/")
        LoadTransferTypesRequest loadAllTransferTypes
    ) throws TransactionException_Exception;

    @WebMethod(action = "deleteTransferTypePermissions")
    public void deleteTransferTypePermissions(
        @WebParam(partName = "headerAuth", mode = WebParam.Mode.INOUT, name = "headerAuth", targetNamespace = "http://services.bellatrix.org/", header = true)
        javax.xml.ws.Holder<Header> headerAuth,
        @WebParam(partName = "deleteTransferTypePermissions", name = "deleteTransferTypePermissions", targetNamespace = "http://services.bellatrix.org/")
        LoadPermissionByTransferTypesRequest deleteTransferTypePermissions
    ) throws TransactionException_Exception;
}
