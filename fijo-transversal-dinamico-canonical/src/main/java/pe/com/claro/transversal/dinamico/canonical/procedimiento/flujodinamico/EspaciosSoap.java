package pe.com.claro.transversal.dinamico.canonical.procedimiento.flujodinamico;

import pe.com.claro.transversal.dinamico.canonical.comun.ws.bean.AnotaEntidad;

public class EspaciosSoap {
	
	@AnotaEntidad(orden=1)
	private String codigoespacio;
	
	@AnotaEntidad(orden=2)
	private String descespacio;

	public String getCodigoespacio() {
		return codigoespacio;
	}

	public void setCodigoespacio(String codigoespacio) {
		this.codigoespacio = codigoespacio;
	}

	public String getDescespacio() {
		return descespacio;
	}

	public void setDescespacio(String descespacio) {
		this.descespacio = descespacio;
	}
	
	

}
