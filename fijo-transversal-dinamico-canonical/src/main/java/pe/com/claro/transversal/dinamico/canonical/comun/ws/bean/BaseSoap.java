package pe.com.claro.transversal.dinamico.canonical.comun.ws.bean;



public class BaseSoap {

	 private String vUrlEndpoint;
	 private String vTargetNameSpace;
     private String vSoapAction;
     private String vServiceName;
     private String vPortName;
     private Integer timeout;
     private boolean vExisteErrorSoap;
     
     public BaseSoap() {
    	 
     }
      
     public BaseSoap(String vUrlEndpoint, String vTargetNameSpace, String vSoapActio, String vServiceNamen,
    		 String vPortName, boolean vExisteErrorSoap) {
    	 this.vUrlEndpoint=vUrlEndpoint;
    	 this.vTargetNameSpace=vTargetNameSpace;
    	 this.vSoapAction=vSoapActio;
    	 this.vServiceName=vServiceNamen;
    	 this.vPortName=vPortName;
    	 this.vExisteErrorSoap=vExisteErrorSoap;
    	 
     }
     
	public String getvUrlEndpoint() {
		return vUrlEndpoint;
	}
	public void setvUrlEndpoint(String vUrlEndpoint) {
		this.vUrlEndpoint = vUrlEndpoint;
	}
	public String getvTargetNameSpace() {
		return vTargetNameSpace;
	}
	public void setvTargetNameSpace(String vTargetNameSpace) {
		this.vTargetNameSpace = vTargetNameSpace;
	}
	public String getvSoapAction() {
		return vSoapAction;
	}
	public void setvSoapAction(String vSoapAction) {
		this.vSoapAction = vSoapAction;
	}
	public boolean isvExisteErrorSoap() {
		return vExisteErrorSoap;
	}
	public void setvExisteErrorSoap(boolean vExisteErrorSoap) {
		this.vExisteErrorSoap = vExisteErrorSoap;
	}
	public String getvServiceName() {
		return vServiceName;
	}
	public void setvServiceName(String vServiceName) {
		this.vServiceName = vServiceName;
	}
	public String getvPortName() {
		return vPortName;
	}
	public void setvPortName(String vPortName) {
		this.vPortName = vPortName;
	}
	public Integer getTimeout() {
		return timeout;
	}
	public void setTimeout(Integer timeout) {
		this.timeout = timeout;
	}
	
     
}
