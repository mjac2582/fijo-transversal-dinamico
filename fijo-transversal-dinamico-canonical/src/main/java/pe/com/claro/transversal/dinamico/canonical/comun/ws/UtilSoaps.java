package pe.com.claro.transversal.dinamico.canonical.comun.ws;



import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPFault;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import pe.com.claro.transversal.dinamico.canonical.comun.ws.bean.BaseSoap;
import pe.com.claro.transversal.dinamico.canonical.comun.ws.bean.ObjNameSpace;
import pe.com.claro.transversal.dinamico.canonical.comun.ws.bean.ObjetoNode;
import pe.com.claro.transversal.dinamico.canonical.comun.ws.bean.ObjetoNodeString;
import pe.com.claro.transversal.dinamico.canonical.comun.ws.bean.RequestSOAP;



public class UtilSoaps {
	
	public static final String CONNECT_TIMEOUT="sun.net.client.defaultConnectTimeout";
	public static final String READ_TIMEOUT="sun.net.client.defaultReadTimeout";
	public static final Integer TIMEOUT = 20000;
	

	public static final synchronized String soapRespToXML(SOAPMessage objSOAPMessageResponse) {
		
		String vCadenaResponseXML=null;
		
		try {
		
		
		boolean vExisteErrorSoap       = objSOAPMessageResponse.getSOAPBody().hasFault();
         
		 
		 SOAPBody objSOAPBody = null;
		 SOAPPart objSOAPPart = null;
		 SOAPEnvelope objSOAPEnvelope=null;
         //Control Error:
         if( vExisteErrorSoap == true ){ 
        	 objSOAPBody  = objSOAPMessageResponse.getSOAPBody();
        	 SOAPFault objSOAPFault = objSOAPBody.getFault();            	
 	    	
            // System.out.println( vCadenaTranzabilidad + "objSOAPFault: [" + objSOAPFault + "]" );
         } 
         else{
        	 
        	 
         	 objSOAPBody     = objSOAPMessageResponse.getSOAPBody();            	
              objSOAPPart     = objSOAPMessageResponse.getSOAPPart();              
 	    	 objSOAPEnvelope = objSOAPPart.getEnvelope();      	    
	            
             // Document objDocument = UtilTransformacion.convertirSOAPMessageToDocument( objSOAPMessageResponse );
              //NodeList nodeList = objDocument.getChildNodes();
              //JSONObject job = extractData(nodeList, "mensajeRespuesta");
//              System.out.println("Json Doc:"+job.toString());
//              for( int i=0; i<nodeList.getLength(); i++ ){
//                  String nombreDato = nodeList.item(i).getNodeValue();			
//                  // nombreNodo = (Node)nodeList.item(i);
//                  System.out.println("_____________________"+nombreDato);
//             }
 	    	 
 	    	Document objDocument = UtilTransformacion.convertirSOAPMessageToDocument( objSOAPMessageResponse );
         	vCadenaResponseXML = UtilTransformacion.convertirDocumentToStringXml( objDocument );
            
         	vCadenaResponseXML = UtilTransformacion.format(vCadenaResponseXML) ;
 	    	 
        	 
              
         }
         
         
         }catch(Exception e) {
    		 vCadenaResponseXML=null;
    	 }
    	 
    	 return vCadenaResponseXML;
         
         
	}
	
	public static final synchronized SOAPMessage ejecucionSoap(BaseSoap base, 
			RequestSOAP requestSoap) {
	        QName vServiceNameQName = new QName( base.getvTargetNameSpace(), base.getvServiceName() );  //Obtenido de: [<wsdl:service name="XXX"...]
	        QName vPortNameQName    = new QName( base.getvTargetNameSpace(), base.getvPortName() );  //Obtenido de: [<wsdl:port name="XXX"...]
	        String       vTimeOut               = ""+TIMEOUT;  //Milesegundos
	        	      
	       if(base.getTimeout()!=null && base.getTimeout()>0) {
	    	   vTimeOut = base.getTimeout().toString();
	       }

            System.setProperty( CONNECT_TIMEOUT, vTimeOut );
            System.setProperty( READ_TIMEOUT,    vTimeOut );
            
            Service               objService      = null;
            Dispatch<SOAPMessage> objDispatch     = null;
            MessageFactory objMessageFactory      = null;
            SOAPMessage    objSOAPMessageRequest  = null;
            SOAPMessage    objSOAPMessageResponse = null;  
  	      	SOAPPart       objSOAPPart            = null;
	  	    StreamSource objStreamSource = null;
	    	InputStream  objInputStream  = null;
            
           try {
        	  objService = Service.create( vServiceNameQName );
 	    	  objService.addPort( vPortNameQName, SOAPBinding.SOAP11HTTP_BINDING, base.getvUrlEndpoint() );
 	    	  
 	    	  objDispatch = objService.createDispatch( vPortNameQName, SOAPMessage.class, Service.Mode.MESSAGE ); 
 	    	  objDispatch.getRequestContext().put( Dispatch.SOAPACTION_URI_PROPERTY, base.getvSoapAction() );
 	    	  
 	    	  
 	    	 objMessageFactory = MessageFactory.newInstance(); 
	    	  
	    	  //Request: 
	    	  objSOAPMessageRequest  = objMessageFactory.createMessage();	    	        
	    	  objSOAPPart            = objSOAPMessageRequest.getSOAPPart();  
	    	  	    		    	  
	    	  String vCadenaRequestXML = requestSoap.getXmlBody();
	    	  
	    	  objInputStream  = UtilTransformacion.convertirStringToFileInputStream(vCadenaRequestXML );	    	       	  
	    	  objStreamSource = new StreamSource( objInputStream ); 	
	    	  
	    	  SOAPEnvelope env = objSOAPPart.getEnvelope();
	    	  
	    	  if(requestSoap.getLstNames()!=null && !requestSoap.getLstNames().isEmpty()) {
	    		  for(ObjNameSpace obj :requestSoap.getLstNames()) {
	    			  env.addNamespaceDeclaration(obj.getPrefijo(), obj.getNamespace());
	    		  }
	    	  }
	    	 
				SOAPHeader header = env.getHeader();
				SOAPBody body = env.getBody();
	    	  
				objSOAPPart.setContent( objStreamSource );
	    	  
	    	  objSOAPMessageResponse = (SOAPMessage)objDispatch.invoke( objSOAPMessageRequest );
        	   
           }catch(Exception e) {
        	   objSOAPMessageResponse=null;
           }
           
           return objSOAPMessageResponse;
	}
	
	
	public static List<ObjetoNode<String,String>> getObjetoUnValor(Document doc,String xpathPredicado) {
	 	XPathFactory xpathFactory = XPathFactory.newInstance();
	  	XPath xpath = xpathFactory.newXPath();
	 	String name = null;
        Node nodoUnico = null;
        ArrayList<ObjetoNode<String,String>>   list = new ArrayList<ObjetoNode<String,String>>();
        ObjetoNode<String,String> node = new ObjetoNode<String,String>();
        try {
            XPathExpression expr =
        		xpath.compile(xpathPredicado);
            name = (String) expr.evaluate(doc, XPathConstants.STRING);
            nodoUnico = (Node)expr.evaluate(doc, XPathConstants.NODE);
            node.add(name, nodoUnico.getParentNode().getNodeName());
            list.add(node);
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }

        return list;
}


public static ObjetoNodeString<String> getObjetoCompleto(Document doc, String xpathPredicado) {
       
	XPathFactory xpathFactory = XPathFactory.newInstance();
  	XPath xpath = xpathFactory.newXPath();
	List<String> lista = new ArrayList<String>(Arrays.asList(xpathPredicado.split("/")));
	String xPathTemporal = "";
	for (String string : lista) {
		if(!string.equals("")){
			xPathTemporal += "/*[local-name()='".concat(string).concat("']");
		}
	}
	xPathTemporal += "/text()";
	
	ObjetoNodeString<String> node = new ObjetoNodeString<String>();
        try {
            XPathExpression expr =
            	xpath.compile(xPathTemporal);
            NodeList nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
            
            for (int i = 0; i < nodes.getLength(); i++) {
            	node.add(nodes.item(i).getNodeValue());
            }	
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        return node;
  }

  public static List<ObjetoNode<String,String>>  getListaVariosObjeto(Document doc, String xpathPredicado) {
	  	
	  	XPathFactory xpathFactory = XPathFactory.newInstance();
	  	XPath xpath = xpathFactory.newXPath();
	  	doc.getDocumentElement().normalize();
    	String name = null;
    	ArrayList<ObjetoNode<String,String>>   lstnode = new ArrayList<ObjetoNode<String,String>>();
        try {
        	XPathExpression expr = xpath.compile(xpathPredicado);
        	
            NodeList listOfBooks = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
        	
     	    int totalBooks = listOfBooks.getLength();
     	    System.out.println("Total no Empleado : " + totalBooks);

     	    for(int i=0; i<listOfBooks.getLength() ; i++) {
     	    	ObjetoNode<String,String> node = new ObjetoNode<String,String>();
     	        Node firstBookNode = listOfBooks.item(i);
     	        if(firstBookNode.getNodeType() == Node.ELEMENT_NODE) {

     	            Element firstElement = (Element)firstBookNode;  
     	          NodeList etiquetasElemento =  firstElement.getChildNodes();
     	         for(int j=0; j<etiquetasElemento.getLength() ; j++) {
     	        	 NodeList firstNameList = firstElement.getElementsByTagName(etiquetasElemento.item(j).getNodeName());
	     	         Element firstNameElement = (Element)firstNameList.item(0);
	     	         if(firstNameElement!=null) {
		     	           NodeList textFNList = firstNameElement.getChildNodes();
		     	           node.add(etiquetasElemento.item(j).getNodeName(), ((Node)textFNList.item(0)).getNodeValue().trim());
	     	         }
     	         }
     	           	            
     	        }
     	       lstnode.add(node);
     	    }
        	
       } catch (Exception e) {
            e.printStackTrace();
        }

        return lstnode;
    }
}
