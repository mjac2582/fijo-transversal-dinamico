package test;

import java.io.ByteArrayOutputStream;
import java.io.File;
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
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.google.gson.Gson;
import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;

import net.sf.json.JSONSerializer;
import pe.com.claro.transversal.dinamico.canonical.comun.property.Constantes;
import pe.com.claro.transversal.dinamico.canonical.comun.ws.UtilProcedimiento;
import pe.com.claro.transversal.dinamico.canonical.comun.ws.UtilSoaps;
import pe.com.claro.transversal.dinamico.canonical.comun.ws.UtilTransformacion;
import pe.com.claro.transversal.dinamico.canonical.comun.ws.bean.ObjetoNodeString;
import pe.com.claro.transversal.dinamico.canonical.procedimiento.contenido.ContenidoSoap;
import pe.com.claro.transversal.dinamico.canonical.procedimiento.flujodinamico.ObjetoSoap;
import pe.com.claro.transversal.dinamico.canonical.procedimiento.flujodinamico.SoapProcedimiento;

public class Prueba003 {

	public static void main(String[] args) throws Exception {
		Gson gson = new Gson();
		/*ContenidoProcedimiento con = new ContenidoProcedimiento();
		con.setClase(1);
		UtilProcedimiento.conex = UtilConexion.getCon();
		con =UtilProcedimiento.execProcedimiento(con);*/
		
		
		 SoapProcedimiento objsoap = new SoapProcedimiento();
		 objsoap.setIdFlujo(202);
		 objsoap.setIpProceso(361);
		 UtilProcedimiento.conex = UtilConexion.getCon();
		 objsoap =UtilProcedimiento.execProcedimiento(objsoap);
		 
		 List<ContenidoSoap> lstContenidoSoap= new ArrayList<ContenidoSoap>();
		 Document doc = UtilTransformacion.getDocumentBuilder(new File("d:/342.xml"));
		for (ObjetoSoap procesosoap : objsoap.getLstprocesos()) {
			ContenidoSoap soapBody = new ContenidoSoap();
			ObjetoNodeString<String> objetoNode = new ObjetoNodeString<String>();
			if(procesosoap.getValor()!=null && procesosoap.getValor() != Constantes.TEXTO_VACIO) {
				objetoNode = UtilSoaps.getObjetoCompleto(doc, procesosoap.getValor());
			}
			
			soapBody.setValor(objetoNode.getDato());
			soapBody.setClase(procesosoap.getIdentificador());
			soapBody.setIdentificador(procesosoap.getIdentificador());
			soapBody.setPadre(procesosoap.getPadre());
			soapBody.setNamespace(procesosoap.getNamespace());
			soapBody.setPrefijo(procesosoap.getPrefijo());
			soapBody.setNombre(procesosoap.getNombre());
			lstContenidoSoap.add(soapBody);
		}	 
			 
			 //List<ContenidoSoap> lstCont =  con.getLstContenido();
			 //List<ContenidoSoap> lstCont2 =  con.getLstContenido();
			 
			 //List<ContenidoSoap> lstNueva =  procesa(0, lstCont);
			 List<ContenidoSoap> lstNueva =  procesa(0, lstContenidoSoap);
			 
			 System.out.println("Result="+JSONSerializer.
					 toJSON(lstNueva).toString());
			 
			 
			 
			 try {
					MessageFactory messageFactory = MessageFactory.newInstance();
			        SOAPMessage soapMessage = messageFactory.createMessage();
			        SOAPPart soapPart = soapMessage.getSOAPPart();
			 
			        // SOAP Envelope
			        SOAPEnvelope envelope = soapPart.getEnvelope();
			        envelope.addNamespaceDeclaration("acme", "http://samples.saaj.jms");
			 
			        // SOAP Body
			        SOAPBody soapBody = envelope.getBody();
			        
			        SOAPHeader head =  envelope.getHeader();
			        
			       // head.addChildElement("hhhh","acme");
			        
						
					SOAPElement w = null;
			        w = listaNva(lstNueva, "---",soapBody);
					
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
			 
			 
			 

	}
	
	 private static List<ContenidoSoap> procesa(int padre, 
			 List<ContenidoSoap> lstCont){
		 List<ContenidoSoap> lstTmp = new ArrayList<ContenidoSoap>();
		 
		 for(ContenidoSoap cont : lstCont) {
			 
			 if(cont.getPadre()==padre) {
				 List<ContenidoSoap> lstX = procesa(cont.getIdentificador(),lstCont);
				 cont.setHijo(lstX);
				 lstTmp.add(cont);
			 }
		 }
		 
		 return lstTmp;
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
