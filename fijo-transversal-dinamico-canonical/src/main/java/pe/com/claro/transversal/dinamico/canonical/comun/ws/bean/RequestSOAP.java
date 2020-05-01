package pe.com.claro.transversal.dinamico.canonical.comun.ws.bean;

import java.util.List;

public class RequestSOAP {
	private String xmlBody;
	private String xmlHeader;
	private List<ObjNameSpace> lstNames;
	
	public RequestSOAP(String xmlBody, String xmlHeader,  List<ObjNameSpace> lstNames) {
		this.xmlBody=xmlBody;
		this.xmlHeader=xmlHeader;
		this.lstNames = lstNames;
	}

	public String getXmlBody() {
		return xmlBody;
	}

	public void setXmlBody(String xmlBody) {
		this.xmlBody = xmlBody;
	}

	public String getXmlHeader() {
		return xmlHeader;
	}

	public void setXmlHeader(String xmlHeader) {
		this.xmlHeader = xmlHeader;
	}

	public List<ObjNameSpace> getLstNames() {
		return lstNames;
	}

	public void setLstNames(List<ObjNameSpace> lstNames) {
		this.lstNames = lstNames;
	}
	
	
	
}
