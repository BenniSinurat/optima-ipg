package org.bellatrix.services.ws.transfertypes;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.7.15
 * 2022-01-13T16:01:29.714+07:00
 * Generated source version: 2.7.15
 * 
 */
@WebServiceClient(name = "TransferTypeService", 
                  wsdlLocation = "http://149.129.215.223:8081/bellatrix/host/services/ws/transfertypes?wsdl",
                  targetNamespace = "http://services.bellatrix.org/") 
public class TransferTypeService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://services.bellatrix.org/", "TransferTypeService");
    public final static QName TransferTypePort = new QName("http://services.bellatrix.org/", "TransferTypePort");
    static {
        URL url = null;
        try {
            url = new URL("http://149.129.215.223:8081/bellatrix/host/services/ws/transfertypes?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(TransferTypeService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "http://149.129.215.223:8081/bellatrix/host/services/ws/transfertypes?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public TransferTypeService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public TransferTypeService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public TransferTypeService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public TransferTypeService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public TransferTypeService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public TransferTypeService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     *
     * @return
     *     returns TransferType
     */
    @WebEndpoint(name = "TransferTypePort")
    public TransferType getTransferTypePort() {
        return super.getPort(TransferTypePort, TransferType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns TransferType
     */
    @WebEndpoint(name = "TransferTypePort")
    public TransferType getTransferTypePort(WebServiceFeature... features) {
        return super.getPort(TransferTypePort, TransferType.class, features);
    }

}
