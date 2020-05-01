package test;

import java.util.ArrayList;
import java.util.List;

import javax.xml.soap.SOAPMessage;

import pe.com.claro.transversal.dinamico.canonical.comun.ws.UtilProcedimiento;
import pe.com.claro.transversal.dinamico.canonical.comun.ws.UtilSoaps;
import pe.com.claro.transversal.dinamico.canonical.comun.ws.bean.BaseSoap;
import pe.com.claro.transversal.dinamico.canonical.comun.ws.bean.ObjNameSpace;
import pe.com.claro.transversal.dinamico.canonical.comun.ws.bean.RequestSOAP;
import pe.com.claro.transversal.dinamico.canonical.procedimiento.flujodinamico.CabeceraSoap;
import pe.com.claro.transversal.dinamico.canonical.procedimiento.flujodinamico.EspaciosSoap;
import pe.com.claro.transversal.dinamico.canonical.procedimiento.flujodinamico.SoapProcedimiento;

public class Prueba004 {
	public static void main(String[] args) {
		  	
		 SoapProcedimiento obj = new SoapProcedimiento();
		 obj.setIdFlujo(202);
		 obj.setIpProceso(361);
		 UtilProcedimiento.conex = UtilConexion.getCon();
		 obj =UtilProcedimiento.execProcedimiento(obj);
		
		  String vUrlEndpoint     	= "http://localhost:7001/CaramelitoWS/consultaPortPort?wsdl";  
	      String vTargetNameSpace = "http://claro.com.pe/consulta/servicio";  
	         
	        String vSoapAction      = "consulta"; 
	        String vServiceNamen 	= "consultaService";
	        String vPortName 		="consultaPortPort";
	        
	     List<ObjNameSpace> lstNames = new  ArrayList<ObjNameSpace>();
	     for (EspaciosSoap espacio : obj.getLstEspacioNombres()) {
	    	 ObjNameSpace objnameSpaces = new   ObjNameSpace(espacio.getCodigoespacio(), espacio.getDescespacio());
	    	 lstNames.add(objnameSpaces);
		}   
	    
	   /* ObjNameSpace obj1 = new   ObjNameSpace("type2", "http://claro.com.pe/consulta/type");
	    List<ObjNameSpace> lstNames = new  ArrayList<ObjNameSpace>();
	    lstNames.add(obj1);
	    obj1 = new   ObjNameSpace("esq", "http://claro.com.pe/consulta/esquema");
	    lstNames.add(obj1);*/
	    
	    
	    String xml= "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
	              + "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" \n" + 
	              "xmlns:type=\"http://claro.com.pe/consulta/type\" \n" + 
	              "xmlns:esq=\"http://claro.com.pe/consulta/esquema\">\n" + 
	              "   <soapenv:Header/>\n" + 
	              "   <soapenv:Body>\n" + 
	              "      <type:consultaRequest>\n" + 
	              "      	 <type:nombre>David</type:nombre>\n" + 
	              "\n" + 
	              "         <type:input>\n" + 
	              "            <esq:idTransaccion>1</esq:idTransaccion>\n" + 
	              "            <esq:nombreAplicacion>Yo</esq:nombreAplicacion>\n" + 
	              "         </type:input>\n" + 
	              "        \n" + 
	              "      </type:consultaRequest>\n" + 
	              "   </soapenv:Body>\n" + 
	              "</soapenv:Envelope>";
	    
	    
	    RequestSOAP req = new RequestSOAP(xml,"",lstNames);
		BaseSoap base = new BaseSoap(vUrlEndpoint, vTargetNameSpace, vSoapAction, vServiceNamen, vPortName, true);
		
		SOAPMessage resp = UtilSoaps.ejecucionSoap(base, req);
		
		String cadena = UtilSoaps.soapRespToXML(resp);
		
		System.out.println("cadena="+cadena);
		
	}
}
