package pe.com.claro.transversal.dinamico.canonical.procedimiento.contenido;

import java.util.List;

import pe.com.claro.transversal.dinamico.canonical.comun.ws.bean.AnotaCampo;
import pe.com.claro.transversal.dinamico.canonical.comun.ws.bean.AnotaProcedure;
import pe.com.claro.transversal.dinamico.canonical.comun.ws.bean.TipoDato;
import pe.com.claro.transversal.dinamico.canonical.comun.ws.bean.TipoInOut;




@AnotaProcedure(nomProcedimiento = "DATOS_OBJETOS") 
public class ContenidoProcedimiento {
	
	@AnotaCampo(orden = 1, tipoDato = TipoDato.NUMERIC)
	private int clase;
	@AnotaCampo( orden = 2, 
			 tipoDato =  TipoDato.REF_CURSOR_ORACLE , 
			 tipoInOut = TipoInOut.OUT
			)
	private List<ContenidoSoap> lstContenido;
	public int getClase() {
		return clase;
	}
	public void setClase(int clase) {
		this.clase = clase;
	}
	public List<ContenidoSoap> getLstContenido() {
		return lstContenido;
	}
	public void setLstContenido(List<ContenidoSoap> lstContenido) {
		this.lstContenido = lstContenido;
	}
    
}
