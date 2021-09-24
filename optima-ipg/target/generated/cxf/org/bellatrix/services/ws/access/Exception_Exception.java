
package org.bellatrix.services.ws.access;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 2.7.15
 * 2021-09-24T09:52:51.256+07:00
 * Generated source version: 2.7.15
 */

@WebFault(name = "Exception", targetNamespace = "http://services.bellatrix.org/")
public class Exception_Exception extends java.lang.Exception {
    
    private org.bellatrix.services.ws.access.Exception exception;

    public Exception_Exception() {
        super();
    }
    
    public Exception_Exception(String message) {
        super(message);
    }
    
    public Exception_Exception(String message, Throwable cause) {
        super(message, cause);
    }

    public Exception_Exception(String message, org.bellatrix.services.ws.access.Exception exception) {
        super(message);
        this.exception = exception;
    }

    public Exception_Exception(String message, org.bellatrix.services.ws.access.Exception exception, Throwable cause) {
        super(message, cause);
        this.exception = exception;
    }

    public org.bellatrix.services.ws.access.Exception getFaultInfo() {
        return this.exception;
    }
}
