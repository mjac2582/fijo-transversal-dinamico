package pe.com.claro.transversal.dinamico.canonical.comun.util;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.NodeList;

public class XmlDocument {

	public static void main(String[] args) {

		final String xmlStr = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"+
				"<employees>"+
				"<secuencia>ABC456</secuencia>"+
				"    <employee id=\"1\">"+
				"        <firstName>Lokesh</firstName>"+
				"        <lastName>Gupta</lastName>"+
				"        <department>"+
				"            <id>101</id>"+
				"            <name>IT</name>"+
				"        </department>"+
				"    </employee>"+
				"    <employee id=\"2\">"+
				"        <firstName>Brian</firstName>"+
				"        <lastName>Schultz</lastName>"+
				"        <department>"+
				"            <id>102</id>"+
				"            <name>HR</name>"+
				"        </department>"+
				"    </employee>"+
				"</employees>";		
		Document document = convertStringToXMLDocument( xmlStr );		
		
		String patronLista="//employees/child::*/child::firstName";
		
		
		String xpathExpression = "/employees/secuencia/text()";
		try {
			if(checkIfNodeExists(document, xpathExpression)){
				 System.out.println( evaluateXPath(document, xpathExpression) );
			}
			
			//Se obtiene una lista
			System.out.println( evaluateXPath(document, patronLista) );
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println(document.getFirstChild().getNodeName());
	}

	
	/**
	 * Convierte una cadena XML a un Document
	 * @param xmlString
	 * @return
	 */
	private static Document convertStringToXMLDocument(String xmlString) 
    {
        //Parser that produces DOM object trees from XML content
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
         
        //API to obtain DOM Document instance
        DocumentBuilder builder = null;
        try
        {
            //Create DocumentBuilder with default configuration
            builder = factory.newDocumentBuilder();
             
            //Parse the content to Document object
            Document doc = builder.parse(new InputSource(new StringReader(xmlString)));
            return doc;
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        return null;
    }
	
	/**
	 * Valida si existe un nodo en el Document
	 * @param document
	 * @param xpathExpression
	 * @return
	 * @throws Exception
	 */
    private static boolean checkIfNodeExists(Document document, String xpathExpression) throws Exception 
    {
        boolean matches = false;
         
        // Create XPathFactory object
        XPathFactory xpathFactory = XPathFactory.newInstance();
 
        // Create XPath object
        XPath xpath = xpathFactory.newXPath();
 
        try {
            // Create XPathExpression object
            XPathExpression expr = xpath.compile(xpathExpression);
 
            // Evaluate expression result on XML document
            NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
             
            if(nodes != null  && nodes.getLength() > 0) {
                matches = true;
            }
 
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        return matches;
    }
    
    
    private static List<String> evaluateXPath(Document document, String xpathExpression) throws Exception 
    {
        // Create XPathFactory object
        XPathFactory xpathFactory = XPathFactory.newInstance();
         
        // Create XPath object
        XPath xpath = xpathFactory.newXPath();
 
        List<String> values = new ArrayList<>();
        try
        {
            // Create XPathExpression object
            XPathExpression expr = xpath.compile(xpathExpression);
             
            // Evaluate expression result on XML document
            NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
             
            for (int i = 0; i < nodes.getLength(); i++) {
                values.add(nodes.item(i).getNodeValue());
            }
                 
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        return values;
    }
    
}
