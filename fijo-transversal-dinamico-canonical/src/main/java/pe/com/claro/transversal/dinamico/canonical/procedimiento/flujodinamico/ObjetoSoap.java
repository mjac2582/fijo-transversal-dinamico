package pe.com.claro.transversal.dinamico.canonical.procedimiento.flujodinamico;

import pe.com.claro.transversal.dinamico.canonical.comun.ws.bean.AnotaEntidad;

public class ObjetoSoap {
	@AnotaEntidad(campoBD = "PRODN_IDPROCESOPRE")
	private int procesopre;
	@AnotaEntidad(campoBD = "VALORATRIBUTO")
	private String valor;
	@AnotaEntidad(campoBD = "PRODN_IDPROCESOPOST")
	private int procesopost;
	@AnotaEntidad(campoBD = "NOMBREATRIBNUTO")
	private String nombre;
	@AnotaEntidad(campoBD = "CLASE")
	private int identificador;
	@AnotaEntidad(campoBD = "PARTESOAP")
	private String partesoap;
	@AnotaEntidad(campoBD = "TIPODATO")
	private String tipo;
	@AnotaEntidad(campoBD = "CLASEPADRE")
	private int padre;
	@AnotaEntidad(campoBD = "NODOPADRE")
	private String nodo;
	@AnotaEntidad(campoBD = "CODESPN")
	private String prefijo;
	@AnotaEntidad(campoBD = "DESCESPN")
	private String namespace;
	public int getProcesopre() {
		return procesopre;
	}
	public void setProcesopre(int procesopre) {
		this.procesopre = procesopre;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public int getProcesopost() {
		return procesopost;
	}
	public void setProcesopost(int procesopost) {
		this.procesopost = procesopost;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getIdentificador() {
		return identificador;
	}
	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}
	public String getPartesoap() {
		return partesoap;
	}
	public void setPartesoap(String partesoap) {
		this.partesoap = partesoap;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getPadre() {
		return padre;
	}
	public void setPadre(int padre) {
		this.padre = padre;
	}
	public String getNodo() {
		return nodo;
	}
	public void setNodo(String nodo) {
		this.nodo = nodo;
	}
	public String getPrefijo() {
		return prefijo;
	}
	public void setPrefijo(String prefijo) {
		this.prefijo = prefijo;
	}
	public String getNamespace() {
		return namespace;
	}
	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}
	
	

}
