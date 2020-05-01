package pe.com.claro.transversal.dinamico.canonical.procedimiento.configuraciones.bean;



public class ObtenerConfiguracionesRequest {
	private Integer idProducto;
	private Integer idTransaccion;

	public Integer getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

	public Integer getIdTransaccion() {
		return idTransaccion;
	}

	public void setIdTransaccion(Integer idTransaccion) {
		this.idTransaccion = idTransaccion;
	}
}
