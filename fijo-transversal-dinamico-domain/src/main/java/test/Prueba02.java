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
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFactory;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;

public class Prueba02 {

	public static void main(String[] args) {
		try {
			  MessageFactory messageFactory = MessageFactory.newInstance();
		        SOAPMessage soapMessage = messageFactory.createMessage();
		        SOAPPart soapPart = soapMessage.getSOAPPart();
		 
		        // SOAP Envelope
		        SOAPEnvelope envelope = soapPart.getEnvelope();
		        envelope.addNamespaceDeclaration("acme", "http://samples.saaj.jms");
		 
		        // SOAP Body
		        SOAPBody soapBody = envelope.getBody();
			
				SOAPFactory factory = SOAPFactory.newInstance();
		        SOAPElement x = factory.createElement("hello", "foo", "http://some2.url.com");
		       // x.addNamespaceDeclaration("foo", "http://some.url.com");
		        //x.addTextNode("This is the text of the node");
		        SOAPElement x2 = x.addChildElement("name", "foo", "http://some2.url.com");
				x2.addTextNode("Yoski");
				
				//Document dc = gen() ;
				//soapBody.addDocument(dc);
				
				
				soapBody.addChildElement(x);
				
				
				 soapMessage.saveChanges();
				 
				
				OutputStream out2 = new ByteArrayOutputStream();
			    out2 = new ByteArrayOutputStream();
			    //nn = (SOAPMessage) object2;
			    soapMessage.writeTo(out2);
			    String response2 = out2.toString();
			    response2 =format(response2);
			    
			    System.out.println(response2);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

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

	 private static Document gen() {
		 
		 DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
		 Document document = null;
		 try {
         DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();

          document = documentBuilder.newDocument();

         // root element
         Element root = document.createElement("company");
         document.appendChild(root);

         // employee element
         Element employee = document.createElement("employee");

         root.appendChild(employee);

         // set an attribute to staff element
         Attr attr = document.createAttribute("id");
         attr.setValue("10");
         employee.setAttributeNode(attr);

         //you can also use staff.setAttribute("id", "1") for this

         // firstname element
         Element firstName = document.createElement("firstname");
         firstName.appendChild(document.createTextNode("James"));
         employee.appendChild(firstName);

         // lastname element
         Element lastname = document.createElement("lastname");
         lastname.appendChild(document.createTextNode("Harley"));
         employee.appendChild(lastname);

         // email element
         Element email = document.createElement("email");
         email.appendChild(document.createTextNode("james@example.org"));
         employee.appendChild(email);

         // department elements
         Element department = document.createElement("department");
         department.appendChild(document.createTextNode("Human Resources"));
         employee.appendChild(department);
         
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		 
		 return document;
	 }
}
