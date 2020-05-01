package pe.com.claro.transversal.dinamico.canonical.procedimiento.configuraciones.bean;

import java.io.Serializable;

public class ObtieneConfiguracionesResponse extends BodyResponse   {

	
	private TransaccionProductoType transaccionProducto;

	public ObtieneConfiguracionesResponse() {
		super();
	}

	public ObtieneConfiguracionesResponse(BodyResponse obj) {
		super(obj);
	}

	public TransaccionProductoType getTransaccionProducto() {
		return transaccionProducto;
	}

	public void setTransaccionProducto(TransaccionProductoType transaccionProducto) {
		this.transaccionProducto = transaccionProducto;
	}

}
