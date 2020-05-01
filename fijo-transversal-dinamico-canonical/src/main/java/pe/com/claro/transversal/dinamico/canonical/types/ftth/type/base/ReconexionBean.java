package pe.com.claro.transversal.dinamico.canonical.types.ftth.type.base;

import java.io.Serializable;

public class ReconexionBean implements Serializable {
	private static final long serialVersionUID = 1028223771401837949L;
private String serviceId;
  private String tipoRecurso;
  
  public ReconexionBean(String s, String t) {
	  serviceId = s;
	  tipoRecurso = t;
  }
  
public String getServiceId() {
	return serviceId;
}
public void setServiceId(String serviceId) {
	this.serviceId = serviceId;
}
public String getTipoRecurso() {
	return tipoRecurso;
}
public void setTipoRecurso(String tipoRecurso) {
	this.tipoRecurso = tipoRecurso;
}
  
  
}
