package pe.com.claro.transversal.dinamico.canonical.procedimiento.flujodinamico;

import java.util.List;

import pe.com.claro.transversal.dinamico.canonical.comun.ws.bean.AnotaCampo;
import pe.com.claro.transversal.dinamico.canonical.comun.ws.bean.AnotaProcedure;
import pe.com.claro.transversal.dinamico.canonical.comun.ws.bean.TipoDato;
import pe.com.claro.transversal.dinamico.canonical.comun.ws.bean.TipoInOut;



@AnotaProcedure(nomProcedimiento = "OPERACION.PKG_FLUJO_AUTOMATICO_FDSV.SGASS_DETALLE_FLUJO4") 
public class SoapProcedimiento {

	@AnotaCampo(orden = 1, tipoDato = TipoDato.NUMERIC)
	private int ipProceso;
	@AnotaCampo(orden = 2, tipoDato = TipoDato.NUMERIC)
	private int idFlujo;
	@AnotaCampo(orden = 3,  tipoDato = TipoDato.REF_CURSOR_ORACLE , tipoInOut = TipoInOut.OUT)
	private List<ObjetoSoap> lstprocesos;
	@AnotaCampo(orden = 4,  tipoDato = TipoDato.REF_CURSOR_ORACLE , tipoInOut = TipoInOut.OUT)
	private List<CabeceraSoap> lstCabeceraSoap;
	@AnotaCampo(orden = 5,  tipoDato = TipoDato.REF_CURSOR_ORACLE , tipoInOut = TipoInOut.OUT)
	private List<EspaciosSoap> lstEspacioNombres;
	@AnotaCampo(orden = 6,  tipoDato = TipoDato.NUMERIC , tipoInOut = TipoInOut.OUT)
	private int codigo;
	@AnotaCampo(orden = 7,  tipoDato = TipoDato.VARCHAR , tipoInOut = TipoInOut.OUT)
	private String mensaje;
	public int getIpProceso() {
		return ipProceso;
	}
	public void setIpProceso(int ipProceso) {
		this.ipProceso = ipProceso;
	}
	public int getIdFlujo() {
		return idFlujo;
	}
	public void setIdFlujo(int idFlujo) {
		this.idFlujo = idFlujo;
	}
	public List<ObjetoSoap> getLstprocesos() {
		return lstprocesos;
	}
	public void setLstprocesos(List<ObjetoSoap> lstprocesos) {
		this.lstprocesos = lstprocesos;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public List<CabeceraSoap> getLstCabeceraSoap() {
		return lstCabeceraSoap;
	}
	public void setLstCabeceraSoap(List<CabeceraSoap> lstCabeceraSoap) {
		this.lstCabeceraSoap = lstCabeceraSoap;
	}
	public List<EspaciosSoap> getLstEspacioNombres() {
		return lstEspacioNombres;
	}
	public void setLstEspacioNombres(List<EspaciosSoap> lstEspacioNombres) {
		this.lstEspacioNombres = lstEspacioNombres;
	}
	
	
	
}
