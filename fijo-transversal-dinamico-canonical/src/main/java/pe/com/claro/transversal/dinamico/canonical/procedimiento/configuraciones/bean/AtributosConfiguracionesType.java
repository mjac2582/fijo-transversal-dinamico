package pe.com.claro.transversal.dinamico.canonical.procedimiento.configuraciones.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class AtributosConfiguracionesType  {

	
	private String descripcionAtributo;
	private String tipoAtributo;
	private String tipoDato;
	private String nombreAtributo;
	private String valorAtributo;
	private String ordenTipoAtributo;
	private String ordenValorAtributo;

	private List<AtributosConfiguracionesType> listaAtributosConfiguracion = new ArrayList<AtributosConfiguracionesType>();

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

	public String getValorAtributo() {
		return valorAtributo;
	}

	public void setValorAtributo(String valorAtributo) {
		this.valorAtributo = valorAtributo;
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

	public List<AtributosConfiguracionesType> getListaAtributosConfiguracion() {
		return listaAtributosConfiguracion;
	}

	public void setListaAtributosConfiguracion(List<AtributosConfiguracionesType> listaAtributosConfiguracion) {
		this.listaAtributosConfiguracion = listaAtributosConfiguracion;
	}



}
