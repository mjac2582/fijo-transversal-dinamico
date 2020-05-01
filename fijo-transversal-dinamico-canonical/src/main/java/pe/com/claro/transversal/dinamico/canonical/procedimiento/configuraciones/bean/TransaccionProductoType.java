package pe.com.claro.transversal.dinamico.canonical.procedimiento.configuraciones.bean;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TransaccionProductoType  {

	
	private String producto;
	private String transaccion;
	private List<AtributosConfiguracionesType> atributosConfiguracion;
	
	public TransaccionProductoType() {
		producto="";
		transaccion="";
		  atributosConfiguracion = new ArrayList<AtributosConfiguracionesType>();
	}

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

	public List<AtributosConfiguracionesType> getAtributosConfiguracion() {
		//atributosConfiguracion = new ArrayList<AtributosConfiguracionesType>();
		return atributosConfiguracion;
	}

	public void setAtributosConfiguracion(List<AtributosConfiguracionesType> atributosConfiguracion) {
		this.atributosConfiguracion = atributosConfiguracion;
	}

}
