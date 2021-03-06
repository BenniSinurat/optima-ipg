
package org.bellatrix.services.ws.transfertypes;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 2.7.15
 * 2022-01-13T16:01:29.702+07:00
 * Generated source version: 2.7.15
 */

@WebFault(name = "TransactionException", targetNamespace = "http://services.bellatrix.org/")
public class TransactionException_Exception extends Exception {
    
    private org.bellatrix.services.ws.transfertypes.TransactionException transactionException;

    public TransactionException_Exception() {
        super();
    }
    
    public TransactionException_Exception(String message) {
        super(message);
    }
    
    public TransactionException_Exception(String message, Throwable cause) {
        super(message, cause);
    }

    public TransactionException_Exception(String message, org.bellatrix.services.ws.transfertypes.TransactionException transactionException) {
        super(message);
        this.transactionException = transactionException;
    }

    public TransactionException_Exception(String message, org.bellatrix.services.ws.transfertypes.TransactionException transactionException, Throwable cause) {
        super(message, cause);
        this.transactionException = transactionException;
    }

    public org.bellatrix.services.ws.transfertypes.TransactionException getFaultInfo() {
        return this.transactionException;
    }
}
