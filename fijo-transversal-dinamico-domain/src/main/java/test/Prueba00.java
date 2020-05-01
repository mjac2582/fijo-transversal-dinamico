package test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFactory;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.google.gson.Gson;
import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;

public class Prueba00 {

	public static void main(String[] args) {
		 // env.addNamespaceDeclaration("type2", "http://claro.com.pe/consulta/type");
    	 // env.addNamespaceDeclaration("esq", "http://claro.com.pe/consulta/esquema");
		
		String ns1 = "http://claro.com.pe/consulta/type";
		String ns2 = "http://claro.com.pe/consulta/esquema";
		
		List<ContenidoSoap> lstContenido = new ArrayList<ContenidoSoap>();
		ContenidoSoap cont1 = new ContenidoSoap("consultaRequest","type2",null,ns1);
		ContenidoSoap cont1a= new ContenidoSoap("nombre","type2","David",ns1);
		cont1.getHijo().add(cont1a);
		
		ContenidoSoap cont2 = new ContenidoSoap("input","esq",null,ns2);
		ContenidoSoap cont2a= new ContenidoSoap("idTransaccion","esq","70000",ns2);
		ContenidoSoap cont2b= new ContenidoSoap("nombreAplicacion","esq","Yoski",ns2);
		cont2.getHijo().add(cont2a);
		cont2.getHijo().add(cont2b);
		
		lstContenido.add(cont1);
		lstContenido.add(cont2);
		

		Gson gson = new Gson();
		String json = gson.toJson(lstContenido);
		
		System.out.println("JSON="+json);
		
		//------------------------------------------------------------------
		try {
			MessageFactory messageFactory = MessageFactory.newInstance();
	        SOAPMessage soapMessage = messageFactory.createMessage();
	        SOAPPart soapPart = soapMessage.getSOAPPart();
	 
	        // SOAP Envelope
	        SOAPEnvelope envelope = soapPart.getEnvelope();
	       // envelope.addNamespaceDeclaration("acme", "http://samples.saaj.jms");
	 
	        // SOAP Body
	        SOAPBody soapBody = envelope.getBody();
	        
	        SOAPHeader head =  envelope.getHeader();
	        
	       // head.addChildElement("hhhh","acme");
	        
				
			SOAPElement w = null;
	        w = listaNva(lstContenido, "---",soapBody);
			
			//soapBody.addChildElement(x);
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
	    
		
//		for(ContenidoSoap cc :lstContenido) {
//			System.out.println(cc.getNombre());
//			if(cc.getHijo()!=null && !cc.getHijo().isEmpty()) {
//			}
//		}
		
		
	}
	
	public static SOAPElement listaNva(List<ContenidoSoap> lst, String linea, SOAPElement ee) throws  Exception{
		linea=linea+"--";
		
		SOAPElement ex =null;
		for(ContenidoSoap cc :lst) {
			System.out.println(""+cc.getNombre()+"-"+cc.getPrefijo()+"-"+cc.getNamespace()+"-"+cc.getValor());
			if(cc.getValor()!=null) {
				ex = ee.addChildElement(cc.getNombre(), cc.getPrefijo(), cc.getNamespace()).addTextNode(cc.getValor());
			}else {
				ex = ee.addChildElement(cc.getNombre(), cc.getPrefijo(), cc.getNamespace());
			}
				
			//System.out.println(linea+">"+cc.getNombre());
			if(cc.getHijo()!=null && !cc.getHijo().isEmpty()) {
				 ex = listaNva(cc.getHijo(),linea, ex) ;
			}
		}
		return ex;
	}
	
	/*
	SOAPFactory factory = SOAPFactory.newInstance();
    SOAPElement x = factory.createElement("hello", "foo", "http://some2.url.com");
   // x.addNamespaceDeclaration("foo", "http://some.url.com");
    //x.addTextNode("This is the text of the node");
    SOAPElement x2 = x.addChildElement("name", "foo", "http://some2.url.com");
	x2.addTextNode("Yoski");
	
	*/
	
	public static void generaObj( SOAPEnvelope env ) {
		
		SOAPBody body=null;
		try {
			//body = env.getBody();
			
			
			SOAPElement soapBodyElem = body.addChildElement("consultaRequest", "type2");
		    SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("input", "type2");
		    SOAPElement soapBodyElem2 = soapBodyElem1.addChildElement("idTransaccion", "esq").addTextNode("70000") ;
		    SOAPElement soapBodyElem21 = soapBodyElem1.addChildElement("nombreAplicacion", "esq").addTextNode("Yoski") ;
		    SOAPElement soapBodyElem3 = soapBodyElem.addChildElement("nombre", "type2").addTextNode("David") ;   //David ---> busqueda
		    
		    
		  
		    
		    
		} catch (SOAPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}
	
	
	////////////////////////////////////////////////
	
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

/*
 
 w = listaNva(lstContenido2, "---",x);
 
public static SOAPElement listaNva(List<ContenidoSoap> lst, String linea, SOAPElement ee) throws  Exception{
		linea=linea+"--";
		
		SOAPElement ex =null;
		for(ContenidoSoap cc :lst) {
			System.out.println(""+cc.getNombre()+"-"+cc.getPrefijo()+"-"+cc.getNamespace()+"-"+cc.getValor());
			if(cc.getValor()!=null) {
				ex = ee.addChildElement(cc.getNombre(), cc.getPrefijo(), cc.getNamespace()).addTextNode(cc.getValor());
			}else {
				ex = ee.addChildElement(cc.getNombre(), cc.getPrefijo(), cc.getNamespace());
			}
				
			//System.out.println(linea+">"+cc.getNombre());
			if(cc.getHijo()!=null && !cc.getHijo().isEmpty()) {
				 ex = listaNva(cc.getHijo(),linea, ex) ;
			}
		}
		return ex;
	}
*/