
package org.bellatrix.services.ws.message;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.bellatrix.services.ws.message package. 
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

    private final static QName _LoadMessageByID_QNAME = new QName("http://services.bellatrix.org/", "loadMessageByID");
    private final static QName _Exception_QNAME = new QName("http://services.bellatrix.org/", "Exception");
    private final static QName _LoadMessageByIDResponse_QNAME = new QName("http://services.bellatrix.org/", "loadMessageByIDResponse");
    private final static QName _DeleteMessage_QNAME = new QName("http://services.bellatrix.org/", "deleteMessage");
    private final static QName _SendMessage_QNAME = new QName("http://services.bellatrix.org/", "sendMessage");
    private final static QName _CountUnreadMessage_QNAME = new QName("http://services.bellatrix.org/", "countUnreadMessage");
    private final static QName _CountUnreadMessageResponse_QNAME = new QName("http://services.bellatrix.org/", "countUnreadMessageResponse");
    private final static QName _FlagMessageReadByID_QNAME = new QName("http://services.bellatrix.org/", "flagMessageReadByID");
    private final static QName _LoadMessageByUsername_QNAME = new QName("http://services.bellatrix.org/", "loadMessageByUsername");
    private final static QName _HeaderAuth_QNAME = new QName("http://services.bellatrix.org/", "headerAuth");
    private final static QName _LoadMessageByUsernameResponse_QNAME = new QName("http://services.bellatrix.org/", "loadMessageByUsernameResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.bellatrix.services.ws.message
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Header }
     * 
     */
    public Header createHeader() {
        return new Header();
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
    }

    /**
     * Create an instance of {@link SendMessageRequest }
     * 
     */
    public SendMessageRequest createSendMessageRequest() {
        return new SendMessageRequest();
    }

    /**
     * Create an instance of {@link NotificationMessage }
     * 
     */
    public NotificationMessage createNotificationMessage() {
        return new NotificationMessage();
    }

    /**
     * Create an instance of {@link LoadMessageByIDRequest }
     * 
     */
    public LoadMessageByIDRequest createLoadMessageByIDRequest() {
        return new LoadMessageByIDRequest();
    }

    /**
     * Create an instance of {@link LoadMessageResponse }
     * 
     */
    public LoadMessageResponse createLoadMessageResponse() {
        return new LoadMessageResponse();
    }

    /**
     * Create an instance of {@link MessageRequest }
     * 
     */
    public MessageRequest createMessageRequest() {
        return new MessageRequest();
    }

    /**
     * Create an instance of {@link UnreadMessage }
     * 
     */
    public UnreadMessage createUnreadMessage() {
        return new UnreadMessage();
    }

    /**
     * Create an instance of {@link ResponseStatus }
     * 
     */
    public ResponseStatus createResponseStatus() {
        return new ResponseStatus();
    }

    /**
     * Create an instance of {@link LoadMessageByUsernameRequest }
     * 
     */
    public LoadMessageByUsernameRequest createLoadMessageByUsernameRequest() {
        return new LoadMessageByUsernameRequest();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadMessageByIDRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "loadMessageByID")
    public JAXBElement<LoadMessageByIDRequest> createLoadMessageByID(LoadMessageByIDRequest value) {
        return new JAXBElement<LoadMessageByIDRequest>(_LoadMessageByID_QNAME, LoadMessageByIDRequest.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadMessageResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "loadMessageByIDResponse")
    public JAXBElement<LoadMessageResponse> createLoadMessageByIDResponse(LoadMessageResponse value) {
        return new JAXBElement<LoadMessageResponse>(_LoadMessageByIDResponse_QNAME, LoadMessageResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MessageRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "deleteMessage")
    public JAXBElement<MessageRequest> createDeleteMessage(MessageRequest value) {
        return new JAXBElement<MessageRequest>(_DeleteMessage_QNAME, MessageRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendMessageRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "sendMessage")
    public JAXBElement<SendMessageRequest> createSendMessage(SendMessageRequest value) {
        return new JAXBElement<SendMessageRequest>(_SendMessage_QNAME, SendMessageRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadMessageByUsernameRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "countUnreadMessage")
    public JAXBElement<LoadMessageByUsernameRequest> createCountUnreadMessage(LoadMessageByUsernameRequest value) {
        return new JAXBElement<LoadMessageByUsernameRequest>(_CountUnreadMessage_QNAME, LoadMessageByUsernameRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UnreadMessage }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "countUnreadMessageResponse")
    public JAXBElement<UnreadMessage> createCountUnreadMessageResponse(UnreadMessage value) {
        return new JAXBElement<UnreadMessage>(_CountUnreadMessageResponse_QNAME, UnreadMessage.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MessageRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "flagMessageReadByID")
    public JAXBElement<MessageRequest> createFlagMessageReadByID(MessageRequest value) {
        return new JAXBElement<MessageRequest>(_FlagMessageReadByID_QNAME, MessageRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadMessageByUsernameRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "loadMessageByUsername")
    public JAXBElement<LoadMessageByUsernameRequest> createLoadMessageByUsername(LoadMessageByUsernameRequest value) {
        return new JAXBElement<LoadMessageByUsernameRequest>(_LoadMessageByUsername_QNAME, LoadMessageByUsernameRequest.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadMessageResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bellatrix.org/", name = "loadMessageByUsernameResponse")
    public JAXBElement<LoadMessageResponse> createLoadMessageByUsernameResponse(LoadMessageResponse value) {
        return new JAXBElement<LoadMessageResponse>(_LoadMessageByUsernameResponse_QNAME, LoadMessageResponse.class, null, value);
    }

}
