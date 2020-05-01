package pe.com.claro.transversal.dinamico.canonical.procedimiento.configuraciones;

import java.util.List;

import pe.com.claro.transversal.dinamico.canonical.comun.ws.bean.AnotaCampo;
import pe.com.claro.transversal.dinamico.canonical.comun.ws.bean.AnotaProcedure;
import pe.com.claro.transversal.dinamico.canonical.comun.ws.bean.TipoDato;
import pe.com.claro.transversal.dinamico.canonical.comun.ws.bean.TipoInOut;
import pe.com.claro.transversal.dinamico.canonical.procedimiento.configuraciones.bean.AtributosTransaccionType;



@AnotaProcedure(nomProcedimiento = "COBSSS_OBTIENE_CONFIG") 
public class ConfiguracionProcedimiento {
	
	
	@AnotaCampo(orden = 1, tipoDato = TipoDato.NUMERIC)
	private int idProducto;
	@AnotaCampo(orden = 2,  tipoDato = TipoDato.NUMERIC)
	private int idTransaccion;
	@AnotaCampo( orden = 3,  tipoDato =  TipoDato.REF_CURSOR_ORACLE ,  tipoInOut = TipoInOut.OUT )
	private List<AtributosTransaccionType> lstAtributos;
	@AnotaCampo( orden = 4,  tipoDato =  TipoDato.NUMERIC ,  tipoInOut = TipoInOut.OUT )
	private int codigo;
	@AnotaCampo( orden = 5,  tipoDato =  TipoDato.VARCHAR ,  tipoInOut = TipoInOut.OUT )
	private String respuesta;
	
	
	public ConfiguracionProcedimiento() {
		
	}
	
	public ConfiguracionProcedimiento(int idProducto, int idTransaccion) {
		this.idProducto=idProducto;
		this.idTransaccion=idTransaccion;
	}
	
	
	public int getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	public int getIdTransaccion() {
		return idTransaccion;
	}
	public void setIdTransaccion(int idTransaccion) {
		this.idTransaccion = idTransaccion;
	}
	public List<AtributosTransaccionType> getLstAtributos() {
		return lstAtributos;
	}
	public void setLstAtributos(List<AtributosTransaccionType> lstAtributos) {
		this.lstAtributos = lstAtributos;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getRespuesta() {
		return respuesta;
	}
	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}


		
}
