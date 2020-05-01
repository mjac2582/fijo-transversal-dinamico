package pe.com.claro.transversal.dinamico.canonical.header;

import java.io.Serializable;

import pe.com.claro.transversal.dinamico.canonical.comun.util.MappingClass;
import pe.com.claro.transversal.dinamico.canonical.comun.util.ValidadorNuloVacio;




public class HeaderRest extends MappingClass implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@ValidadorNuloVacio(nulo = true, vacio = true)
	protected String authorization;
	@ValidadorNuloVacio()
    protected String timestamp;
	@ValidadorNuloVacio()
    protected String msgid;
	@ValidadorNuloVacio()
    protected String userId;
	@ValidadorNuloVacio()
    protected String accept;
	public String getAuthorization() {
		return authorization;
	}
	public void setAuthorization(String authorization) {
		this.authorization = authorization;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getMsgid() {
		return msgid;
	}
	public void setMsgid(String msgid) {
		this.msgid = msgid;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getAccept() {
		return accept;
	}
	public void setAccept(String accept) {
		this.accept = accept;
	}
}
