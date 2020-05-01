package pe.com.claro.transversal.dinamico.canonical.comun.bean;

import pe.com.claro.transversal.dinamico.canonical.comun.util.MappingClass;
import pe.com.claro.transversal.dinamico.canonical.comun.util.ValidadorNuloVacio;

public class HeadRequest extends MappingClass{
	private String transactionId;
	private String source;
	
	@ValidadorNuloVacio()
	private String authorization;
	
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getAuthorization() {
		return authorization;
	}
	public void setAuthorization(String authorization) {
		this.authorization = authorization;
	}
	

}
