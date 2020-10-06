
package org.bellatrix.services.ws.virtualaccount;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 2.7.15
 * 2020-10-05T11:20:04.355+07:00
 * Generated source version: 2.7.15
 */

@WebFault(name = "Exception", targetNamespace = "http://services.bellatrix.org/")
public class Exception_Exception extends java.lang.Exception {
    
    private org.bellatrix.services.ws.virtualaccount.Exception exception;

    public Exception_Exception() {
        super();
    }
    
    public Exception_Exception(String message) {
        super(message);
    }
    
    public Exception_Exception(String message, Throwable cause) {
        super(message, cause);
    }

    public Exception_Exception(String message, org.bellatrix.services.ws.virtualaccount.Exception exception) {
        super(message);
        this.exception = exception;
    }

    public Exception_Exception(String message, org.bellatrix.services.ws.virtualaccount.Exception exception, Throwable cause) {
        super(message, cause);
        this.exception = exception;
    }

    public org.bellatrix.services.ws.virtualaccount.Exception getFaultInfo() {
        return this.exception;
    }
}
