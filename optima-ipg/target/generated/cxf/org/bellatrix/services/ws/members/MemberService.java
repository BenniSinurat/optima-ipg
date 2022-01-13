package org.bellatrix.services.ws.members;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.7.15
 * 2022-01-13T16:01:27.649+07:00
 * Generated source version: 2.7.15
 * 
 */
@WebServiceClient(name = "MemberService", 
                  wsdlLocation = "http://149.129.215.223:8081/bellatrix/host/services/ws/members?wsdl",
                  targetNamespace = "http://services.bellatrix.org/") 
public class MemberService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://services.bellatrix.org/", "MemberService");
    public final static QName MemberPort = new QName("http://services.bellatrix.org/", "MemberPort");
    static {
        URL url = null;
        try {
            url = new URL("http://149.129.215.223:8081/bellatrix/host/services/ws/members?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(MemberService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "http://149.129.215.223:8081/bellatrix/host/services/ws/members?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public MemberService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public MemberService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public MemberService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public MemberService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public MemberService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public MemberService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     *
     * @return
     *     returns Member
     */
    @WebEndpoint(name = "MemberPort")
    public Member getMemberPort() {
        return super.getPort(MemberPort, Member.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns Member
     */
    @WebEndpoint(name = "MemberPort")
    public Member getMemberPort(WebServiceFeature... features) {
        return super.getPort(MemberPort, Member.class, features);
    }

}
