package pe.com.claro.transversal.dinamico.canonical.comun.ws;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.SOAPMessage;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;



public class UtilTransformacion {
	 public static final synchronized InputStream convertirStringToFileInputStream( String cadenaXML ){
		   // String cadenaTrazabilidad = cadenaTranzabilidadParam + "[convertirStringToFileInputStream] ";
		 			 
			InputStream objInputStream = null;
			byte[]      arrayBytes     = null;
			
			try{
				arrayBytes     = cadenaXML.getBytes( "UTF-8" );
				objInputStream = new ByteArrayInputStream( arrayBytes );
		    }
		    catch( Exception e ){
			       String cadenError = utilGetStackTrace( e );
				   //System.out.println( cadenaTrazabilidad + "ERROR (Exception): [" + cadenError + "]" );   
		    }
		    finally{
		           // System.out.println( cadenaTrazabilidad + "-------- convertirStringToFileInputStream: [FIN] --------" );
	     }
	 		 
	     return objInputStream;
	}
	 
	/**
	 * convertirSOAPMessageToDocument 
	 * @param  cadenaTranzabilidadParam
	 * @param  objSOAPMessage
	 * @return Document
	 * @throws Exception
	 */
	 public static final synchronized Document convertirSOAPMessageToDocument(  SOAPMessage objSOAPMessage ){
		  //  String cadenaTrazabilidad = cadenaTranzabilidadParam + "[convertirSOAPMessageToDocument] ";
 	    //System.out.println( cadenaTrazabilidad + "-------- convertirSOAPMessageToDocument: [INICIO] --------" );
 	      
			Source             objSource      = null;
			TransformerFactory objTransformerFactory = null;
			Transformer        objTransformer = null;
			DOMResult          objDOMResult   = null; 
			Document           objDocument    = null;   
			
		    try{
		  	    objSource             = objSOAPMessage.getSOAPPart().getContent();
		  	    objTransformerFactory = TransformerFactory.newInstance();
		  	    objTransformer        = objTransformerFactory.newTransformer();
		  	    objDOMResult          = new DOMResult();
		  	    
		  	    objTransformer.transform( objSource, objDOMResult );  		
             
		  	    objDocument = (Document)objDOMResult.getNode();
		    }
		    catch( Exception e ){
	   		       //String cadenError = this.utilGetStackTrace( e );
	   			  // System.out.println( cadenaTrazabilidad + "ERROR (Exception): [" + e + "]" );  
	   			 
			       objDocument = null;
		    }
		    finally{
		           // System.out.println( cadenaTrazabilidad + "-------- convertirSOAPMessageToDocument: [FIN] --------" );
	        }
		 		 
	  	    return objDocument;
	  	}
				
	/**
	 * convertirStringXmlToDocument	
	 * @param  cadenaTranzabilidadParam
	 * @param  cadenaXml
	 * @return Document
	 */
	 public static final synchronized  Document convertirStringXmlToDocument( String cadenaXml ){ 
	     // String cadenaTrazabilidad = cadenaTranzabilidadParam + "[convertirStringXmlToDocument] ";
	     // System.out.println( cadenaTrazabilidad + "-------- convertirStringXmlToDocument [INICIO] --------" );
		
		  DocumentBuilderFactory objDocumentBuilderFactory = DocumentBuilderFactory.newInstance(); 
		  DocumentBuilder        objDocumentBuilder = null;
		  Document               objDocument        = null;		
		  InputSource            objInputSource     = null;
		  StringReader           objStringReader    = null;
		
		  try{
			  objDocumentBuilder = objDocumentBuilderFactory.newDocumentBuilder();
			  objStringReader    = new StringReader( cadenaXml );
			  objInputSource     = new InputSource( objStringReader );
			  objDocument        = objDocumentBuilder.parse( objInputSource );
			  objDocument.getDocumentElement().normalize();
		  } 
		  catch( Exception e ){
	   		     String cadenError = utilGetStackTrace( e );
	   			 //System.out.println( cadenaTrazabilidad + "ERROR (Exception): [" + cadenError + "]" );  
	   			 
			     objDocument = null;
		  }
		  finally{
		         // System.out.println( cadenaTrazabilidad + "-------- convertirStringXmlToDocument [FIN] --------" );
	      }
		
		  return objDocument;
	}
	
	/**
	 * convertirDocumentToStringXml
	 * @param  cadenaTranzabilidadParam
	 * @param  objDocument
	 * @return String
	 */
	 public static final synchronized  String convertirDocumentToStringXml(  Document objDocument ){ 
		//String cadenaTrazabilidad = cadenaTranzabilidadParam + "[convertirDocumentToStringXml] ";
		//System.out.println( cadenaTrazabilidad + "-------- convertirDocumentToStringXml [INICIO] --------" );
	   
		TransformerFactory objTransformerFactory = TransformerFactory.newInstance(); 
		Transformer        objTransformer        = null; 
		StringWriter       objStringWriter       = null; 
		DOMSource          objDOMSource          = null;
		StreamResult       objStreamResult       = null;
		
		String cadenaXml = null;
		
	    try{
			objTransformer  = objTransformerFactory.newTransformer();
			objStringWriter = new StringWriter();
			objDOMSource    = new DOMSource( objDocument );
			objStreamResult = new StreamResult( objStringWriter );
			
			objTransformer.transform( objDOMSource, objStreamResult );
			cadenaXml = objStringWriter.getBuffer().toString();
		}
		catch( Exception e ){
		       String cadenError = utilGetStackTrace( e );
			   //System.out.println( cadenaTrazabilidad + "ERROR, Documento Invalido: [" + cadenError + "]" );
			   
			   cadenaXml  = null;
		}
		finally{
		        //System.out.println( cadenaTrazabilidad + "-------- convertirDocumentToStringXml [FIN] --------" );
	    }
	    
		return cadenaXml;
 }
	     
	/**
	 * validarStringXmlWithXsd 
	 * @param  cadenaTranzabilidadParam
	 * @param  cadenaXml
	 * @param  rutaXsd
	 * @return boolean
	 */
	 public static synchronized boolean validarStringXmlWithXsd( String cadenaXml, String rutaXsd ){
		//String cadenaTrazabilidad = cadenaTranzabilidadParam + "[validarStringXmlWithXsd] ";
		//System.out.println( cadenaTrazabilidad + "-------- validarStringXmlWithXsd [INICIO] --------" );

		boolean estado = false;
		
		StringReader  objStringReader  = null;
		URL           objURL           = null;
		SchemaFactory objSchemaFactory = null;
		Schema        objSchema        = null;
		Validator     objValidator     = null;
		StreamSource  objStreamSource  = null;
		     		
		try{			
		    objStringReader  = new StringReader( cadenaXml ); 			
		    objURL           = UtilTransformacion.class.getClassLoader().getResource( rutaXsd );  
			objSchemaFactory = SchemaFactory.newInstance( XMLConstants.W3C_XML_SCHEMA_NS_URI );  
		    objSchema        = objSchemaFactory.newSchema( objURL );  
			objValidator     = objSchema.newValidator();  
			objStreamSource  = new StreamSource( objStringReader );
			
			objValidator.validate( objStreamSource );  
			
			//System.out.println( cadenaTrazabilidad + "Validacion de 'XSD' = 'OK'..." );
			
			estado = true;
		}
		catch( IOException e ){
		       String cadenError = utilGetStackTrace( e );
			   //System.out.println( cadenaTrazabilidad + "ERROR (IOException) al obtener 'XSD': [" + cadenError + "]" );
			   
			   estado = false;
		} 
		catch( SAXParseException e ){
		       String cadenError = utilGetStackTrace( e );
			   //System.out.println( cadenaTrazabilidad + "ERROR (SAXParseException), Imposible convertir cadena a document 'XML': [" + cadenError + "]" );  
			   
			   estado = false;
		}
		catch( Exception e ){
		       String cadenError = utilGetStackTrace( e );
			   //System.out.println( cadenaTrazabilidad + "ERROR (Exception): [" + cadenError + "]" );  
			   
			   estado = false;
		}
	    finally{
		        //System.out.println( cadenaTrazabilidad + "-------- validarStringXmlWithXsd [FIN] --------" );
	    }
	
		return estado;
	} 
 
/**
 * utilGetStackTrace	
 * @param  objExcepcion
 * @return String
 */
	 public static final  String  utilGetStackTrace( Exception objExcepcion ){
		     
		   StringWriter objPrintError = null;
		   String       cadenaError   = null;
		   
		   try{
			   objPrintError = new StringWriter();
			   objExcepcion.printStackTrace( new PrintWriter( objPrintError ) );
			   cadenaError   = (objPrintError + ""); 
		   }
		   catch( Exception e ){
			      e.printStackTrace();
		   }
		   
		   return cadenaError;
	}

 /**
  * agregarDatosHashMap
  * @param  mapaDatosOUT
  * @param  listaDatos
  * @return Map<String, String>
  **/
	 public static final synchronized  Map<String, String> agregarDatosHashMap( Map<String, String> mapaDatosOUT, Set<String> listaDatos ){
 	     
 	     Map<String, String> mapaDatosTemp = mapaDatosOUT;
 	 
 	     try{
 	    	 String   vDato   = null;
 	    	 String[] arreglo = null;
 	    	 
				 Iterator<String> objIterator = listaDatos.iterator(); 
				 while( objIterator.hasNext() ){
					    vDato   = (String)objIterator.next();
					    arreglo = vDato.split( "\\|" );
					    
					    String vLlave = arreglo[ 0 ];
					    String vValor = arreglo[ 1 ];
					    
					    if( (vValor != null) && 
					        (vValor.trim().length() > 0) ){					    	
					    	//System.out.println( "vLlave: [" + vLlave + "] - vValor: [" + vValor + "]" );					    	
					    	mapaDatosTemp.put( vLlave, vValor );
					    }					    
				 }
 	     }
 	     catch( Exception e ){
 	    	    e.printStackTrace();
 	     }
 	     
 	     return mapaDatosTemp;   	 
  }
	 
/**
 * concatenarListas	
 * @param  lista_01
 * @param  lista_02
 * @return Set<String>
 **/
	 public static final synchronized  Set<String> concatenarListas( List<String> lista_01, List<String> lista_02 ){
		
		   Set<String> listaConcatenada = new LinkedHashSet<String>();
		   String vConcatenado = null;
		   
		   try{
			  String vElemento = null;
			  for( int i=0; i<lista_01.size(); i++ ){
				   vElemento = lista_01.get( i );
				   
				   String vElementoIN = null;
				   for( int j=0; j<lista_02.size(); j++ ){
					    vElementoIN = lista_02.get( j ); 
					    
					    if( i == j ){
					    	vConcatenado = (vElemento + "|" + vElementoIN); 
					    	listaConcatenada.add( vConcatenado ); 
					    }
				   }
			  }
		  }
		  catch( Exception e ){
				 e.printStackTrace();
		  }
		   
		  return listaConcatenada;		
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
	    	
		private static JSONObject extractData(NodeList nodeList, String tagName) throws TransformerConfigurationException,
	    TransformerException, TransformerFactoryConfigurationError, JSONException {
			JSONObject resultObject = new JSONObject();
			for (int i = 0; i < nodeList.getLength(); i++) {
			    Node node = nodeList.item(i);
			    if (!node.getNodeName().equals(tagName) && node.hasChildNodes()) {
			        return extractData(node.getChildNodes(), tagName);
			    } else if (node.getNodeName().equals(tagName)) {
			        DOMSource source = new DOMSource(node);
			        StringWriter stringResult = new StringWriter();
			        System.out.println("stringResult==="+stringResult.toString());
			        TransformerFactory.newInstance().newTransformer().transform(source, new StreamResult(stringResult));
			        resultObject = XML.toJSONObject(stringResult.toString()).optJSONObject(tagName);
			        System.out.println("resultObject==="+resultObject.toString());
			    }
			}
			return resultObject;
		}
			
		public static JSONObject getFullData(String tagName, SOAPMessage message) throws Exception {
			NodeList nodeList = message.getSOAPBody().getChildNodes();
			JSONObject resultObject = extractData(nodeList, tagName);
			return resultObject;
		}
		
		
	public static Document getDocumentBuilder(File fileXml) throws Exception {	
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder;
        Document doc = null;
     
		try {
			builder = factory.newDocumentBuilder();
			
			doc = builder.parse(fileXml);
	
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return doc;
		
	}	 
	 
}
