package pe.com.claro.transversal.dinamico.canonical.comun.ws.bean;

import java.util.List;

public class HeadProcedimiento {
	private String nombre;
	private  List<Parametros> lstParametros;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public List<Parametros> getLstParametros() {
		return lstParametros;
	}
	public void setLstParametros(List<Parametros> lstParametros) {
		this.lstParametros = lstParametros;
	}
}
