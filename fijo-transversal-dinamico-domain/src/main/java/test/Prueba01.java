package test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPFactory;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;


import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;

public class Prueba01 {

	public static void main(String[] args) {
		
		
		
		// TODO Auto-generated method stub
		try {
			SOAPMessage nn = createSOAPRequest() ;
			
			OutputStream out2 = new ByteArrayOutputStream();
		    out2 = new ByteArrayOutputStream();
		    //nn = (SOAPMessage) object2;
		    nn.writeTo(out2);
		    String response2 = out2.toString();
		    response2 =format(response2);
		    
		    System.out.println( );
		    
		    System.out.println(response2);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static SOAPMessage createSOAPRequest() throws Exception
	{
	        MessageFactory messageFactory = MessageFactory.newInstance();
	        SOAPMessage soapMessage = messageFactory.createMessage();
	        SOAPPart soapPart = soapMessage.getSOAPPart();
	 
	        // SOAP Envelope
	        SOAPEnvelope envelope = soapPart.getEnvelope();
	        envelope.addNamespaceDeclaration("acme", "http://samples.saaj.jms");
	 
	        // SOAP Body
	        SOAPBody soapBody = envelope.getBody();
	        SOAPElement soapBodyElem = soapBody.addChildElement("employee", "acme");
	        SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("id", "acme");
	        soapBodyElem1.addTextNode("10");
	        
	        
	        
	        
	 
	        soapMessage.saveChanges();
	 
	        System.out.println("Request SOAP Message = ");
	        soapMessage.writeTo(System.out);
	        System.out.println();
	        return soapMessage;
	}

	 public static String format(String unformattedXml) {
	        try {
	            final Document document = parseXmlFile(unformattedXml);

	            OutputFormat format = new OutputFormat(document);
	            format.setLineWidth(65);
	            format.setIndenting(true);
	            format.setIndent(2);
	            Writer out = new StringWriter();
	            XMLSerializer serializer = new XMLSerializer(out, format);
	            serializer.serialize(document);

	            return out.toString();
	        } catch (IOException e) {
	            throw new RuntimeException(e);
	        }
	    }
	 
	 private static Document parseXmlFile(String in) {
	        try {
	            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	            DocumentBuilder db = dbf.newDocumentBuilder();
	            InputSource is = new InputSource(new StringReader(in));
	            return db.parse(is);
	        } catch (ParserConfigurationException e) {
	            throw new RuntimeException(e);
	        } catch (SAXException e) {
	            throw new RuntimeException(e);
	        } catch (IOException e) {
	            throw new RuntimeException(e);
	        }
	    }
	
}
