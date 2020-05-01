package pe.com.claro.transversal.dinamico.canonical.comun.ws.bean;

public class ObjNameSpace {
	private String prefijo;
	private String namespace;
	
	public ObjNameSpace(String prefijo, String namespace) {
		this.prefijo = prefijo;
		this.namespace = namespace;
	}
	
	public String getPrefijo() {
		return prefijo;
	}
	public void setPrefijo(String prefijo) {
		this.prefijo = prefijo;
	}
	public String getNamespace() {
		return namespace;
	}
	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}
	
}
