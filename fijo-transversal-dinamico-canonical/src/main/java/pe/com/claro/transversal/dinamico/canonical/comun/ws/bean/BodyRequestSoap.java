package pe.com.claro.transversal.dinamico.canonical.comun.ws.bean;

import java.util.List;

public class BodyRequestSoap {
	private List<ObjetoNode<String,String>> campoOrigenList;
	private String campoOrigen;
	private String campoDestino;
	private int clase;
	private int clasePadre;
	private String nodoPadre;
	private String parteSoap;
	private String tipoDato;
	private String codEspcNombres;
	private String descEspcNombres;
	
	
	
	
	
	public BodyRequestSoap(List<ObjetoNode<String, String>> campoOrigenList, String campoOrigen, String campoDestino,
			int clase, int clasePadre, String nodoPadre, String parteSoap, String tipoDato, String codEspcNombres,
			String descEspcNombres) {
		super();
		this.campoOrigenList = campoOrigenList;
		this.campoOrigen = campoOrigen;
		this.campoDestino = campoDestino;
		this.clase = clase;
		this.clasePadre = clasePadre;
		this.nodoPadre = nodoPadre;
		this.parteSoap = parteSoap;
		this.tipoDato = tipoDato;
		this.codEspcNombres = codEspcNombres;
		this.descEspcNombres = descEspcNombres;
	}
	public String getCampoDestino() {
		return campoDestino;
	}
	public void setCampoDestino(String campoDestino) {
		this.campoDestino = campoDestino;
	}
	
	public BodyRequestSoap() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getClase() {
		return clase;
	}
	public void setClase(int clase) {
		this.clase = clase;
	}
	public int getClasePadre() {
		return clasePadre;
	}
	public void setClasePadre(int clasePadre) {
		this.clasePadre = clasePadre;
	}
	public String getNodoPadre() {
		return nodoPadre;
	}
	public void setNodoPadre(String nodoPadre) {
		this.nodoPadre = nodoPadre;
	}
	public String getParteSoap() {
		return parteSoap;
	}
	public void setParteSoap(String parteSoap) {
		this.parteSoap = parteSoap;
	}
	public String getTipoDato() {
		return tipoDato;
	}
	public void setTipoDato(String tipoDato) {
		this.tipoDato = tipoDato;
	}
	public String getCodEspcNombres() {
		return codEspcNombres;
	}
	public void setCodEspcNombres(String codEspcNombres) {
		this.codEspcNombres = codEspcNombres;
	}
	public String getDescEspcNombres() {
		return descEspcNombres;
	}
	public void setDescEspcNombres(String descEspcNombres) {
		this.descEspcNombres = descEspcNombres;
	}
	public List<ObjetoNode<String, String>> getCampoOrigenList() {
		return campoOrigenList;
	}
	public void setCampoOrigenList(List<ObjetoNode<String, String>> campoOrigenList) {
		this.campoOrigenList = campoOrigenList;
	}
	public String getCampoOrigen() {
		return campoOrigen;
	}
	public void setCampoOrigen(String campoOrigen) {
		this.campoOrigen = campoOrigen;
	}
	
	
	
	
	
	

}
