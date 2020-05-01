package pe.com.claro.transversal.dinamico.canonical.procedimiento.configuraciones.bean;

import java.io.Serializable;

import pe.com.claro.transversal.dinamico.canonical.comun.ws.bean.AnotaEntidad;







public class AtributosTransaccionType implements Serializable{

	private static final long serialVersionUID = 1L;

	@AnotaEntidad(orden = 1) 
	private String producto;
	@AnotaEntidad(orden = 2) 
	private String transaccion;
	@AnotaEntidad(orden = 4) 
	private String tipoAtributo;
	@AnotaEntidad(orden = 5) 
	private String tipoDato;
	@AnotaEntidad(orden = 3) 
	private String descripcionAtributo;
	@AnotaEntidad(orden = 6) 
	private String nombreAtributo;
	private String identificadorAtributo;
	@AnotaEntidad(orden = 7) 
	private String valorAtributo;
	@AnotaEntidad(orden = 8) 
	private String nivel;
	@AnotaEntidad(orden = 9) 
	private String clase;
	@AnotaEntidad(orden = 10) 
	private String clasePadre;
	@AnotaEntidad(orden = 11) 
	private String ordenTipoAtributo;
	@AnotaEntidad(orden = 12) 
	private String ordenValorAtributo;
	
	

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public String getTransaccion() {
		return transaccion;
	}

	public void setTransaccion(String transaccion) {
		this.transaccion = transaccion;
	}

	public String getTipoAtributo() {
		return tipoAtributo;
	}

	public void setTipoAtributo(String tipoAtributo) {
		this.tipoAtributo = tipoAtributo;
	}

	public String getTipoDato() {
		return tipoDato;
	}

	public void setTipoDato(String tipoDato) {
		this.tipoDato = tipoDato;
	}

	public String getDescripcionAtributo() {
		return descripcionAtributo;
	}

	public void setDescripcionAtributo(String descripcionAtributo) {
		this.descripcionAtributo = descripcionAtributo;
	}

	public String getNombreAtributo() {
		return nombreAtributo;
	}

	public void setNombreAtributo(String nombreAtributo) {
		this.nombreAtributo = nombreAtributo;
	}

	public String getIdentificadorAtributo() {
		return identificadorAtributo;
	}

	public void setIdentificadorAtributo(String identificadorAtributo) {
		this.identificadorAtributo = identificadorAtributo;
	}

	public String getValorAtributo() {
		return valorAtributo;
	}

	public void setValorAtributo(String valorAtributo) {
		this.valorAtributo = valorAtributo;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public String getClase() {
		return clase;
	}

	public void setClase(String clase) {
		this.clase = clase;
	}

	public String getClasePadre() {
		return clasePadre;
	}

	public void setClasePadre(String clasePadre) {
		this.clasePadre = clasePadre;
	}

	public String getOrdenTipoAtributo() {
		return ordenTipoAtributo;
	}

	public void setOrdenTipoAtributo(String ordenTipoAtributo) {
		this.ordenTipoAtributo = ordenTipoAtributo;
	}

	public String getOrdenValorAtributo() {
		return ordenValorAtributo;
	}

	public void setOrdenValorAtributo(String ordenValorAtributo) {
		this.ordenValorAtributo = ordenValorAtributo;
	}

}
