package pe.com.claro.transversal.dinamico.canonical.comun.ws.bean;

import java.util.List;

public class Parametros {
	private String nombre;
	private int tipoDato;
	private int tipoInOut;
	private String tipoObj;
	private int orden;
	private String valor;
	private String clase;
	private List<Campo> lstCampos;
	
	
	public int getTipoDato() {
		return tipoDato;
	}
	public void setTipoDato(int tipoDato) {
		this.tipoDato = tipoDato;
	}
	public int getTipoInOut() {
		return tipoInOut;
	}
	public void setTipoInOut(int tipoInOut) {
		this.tipoInOut = tipoInOut;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getClase() {
		return clase;
	}
	public void setClase(String clase) {
		this.clase = clase;
	}
	public String getTipoObj() {
		return tipoObj;
	}
	public void setTipoObj(String tipoObj) {
		this.tipoObj = tipoObj;
	}
	public int getOrden() {
		return orden;
	}
	public void setOrden(int orden) {
		this.orden = orden;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public List<Campo> getLstCampos() {
		return lstCampos;
	}
	public void setLstCampos(List<Campo> lstCampos) {
		this.lstCampos = lstCampos;
	}
}
