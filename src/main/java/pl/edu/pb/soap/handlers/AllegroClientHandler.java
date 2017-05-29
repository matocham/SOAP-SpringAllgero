package pl.edu.pb.soap.handlers;

import org.w3c.dom.Node;

import javax.xml.namespace.QName;
import javax.xml.soap.*;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import java.util.Set;

/**
 * Created by Mateusz on 06.05.2017.
 */
public class AllegroClientHandler implements SOAPHandler<SOAPMessageContext> {
    public static final String POLAND_COUNTRY_CODE = "1";
    public static final String WEBAPI_KEY = "s7bc4abb";
    public static final String WEBAPI_KEY_NODE_NAME = "webapiKey";
    public static final String COUNTRY_ID_NODE_NAME = "countryId";
    public static final String COUNTRY_CODE_NODE_NAME = "countryCode";
    @Override
    public boolean handleMessage(SOAPMessageContext context) {

        System.out.println("Client : handleMessage()......");

        Boolean isRequest = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);

        //if this is a request, true for outbound messages, false for inbound
        if (isRequest) {

            try {
                SOAPMessage soapMsg = context.getMessage();
                SOAPEnvelope soapEnv = soapMsg.getSOAPPart().getEnvelope();
                SOAPBody body = soapEnv.getBody();
                Node request = body.getFirstChild();
                for(int i=0; i<request.getChildNodes().getLength();i++){
                    Node child = request.getChildNodes().item(i);
                    if(child.getNodeName().equals(COUNTRY_ID_NODE_NAME) ||child.getNodeName().equals(COUNTRY_CODE_NODE_NAME)){
                        Node textNode = child.getFirstChild();
                        if(textNode != null){
                            textNode.setTextContent(POLAND_COUNTRY_CODE);
                        } else {
                            textNode = request.getOwnerDocument().createTextNode(POLAND_COUNTRY_CODE);
                            child.appendChild(textNode);
                        }
                    } else if(child.getNodeName().equals(WEBAPI_KEY_NODE_NAME)){
                        Node textNode = child.getFirstChild();
                        if(textNode != null){
                            textNode.setTextContent(WEBAPI_KEY);
                        }else {
                            textNode = request.getOwnerDocument().createTextNode(WEBAPI_KEY);
                            child.appendChild(textNode);
                        }
                    }
                }
                soapMsg.saveChanges();


            } catch (SOAPException e) {
                System.err.println(e);
            }
        }
        return true;
    }

    @Override
    public boolean handleFault(SOAPMessageContext context) {
        System.out.println("Client : handleFault()......");
        return true;
    }

    @Override
    public void close(MessageContext context) {
        System.out.println("Client : close()......");
    }

    @Override
    public Set<QName> getHeaders() {
        System.out.println("Client : getHeaders()......");
        return null;
    }
}