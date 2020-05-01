package pe.com.claro.transversal.dinamico.canonical.comun.bean;

import java.io.Serializable;
import java.util.List;

public class ReqResTransporteBase<T>  implements Serializable{
	private static final long serialVersionUID = -5163987736303765569L;
	protected String codigoRespuesta;
	protected String mensajeRespuesta;
	
	private List<T> detalle;
	
	public ReqResTransporteBase(String codigo, String mensaje, List<T> det) {
		codigoRespuesta = codigo;
		mensajeRespuesta = mensaje;
		detalle = det;
	}
	public ReqResTransporteBase() {}
	public String getCodigoRespuesta() {
		return codigoRespuesta;
	}
	public void setCodigoRespuesta(String codigoRespuesta) {
		this.codigoRespuesta = codigoRespuesta;
	}
	public String getMensajeRespuesta() {
		return mensajeRespuesta;
	}
	public void setMensajeRespuesta(String mensajeRespuesta) {
		this.mensajeRespuesta = mensajeRespuesta;
	}
	public List<T> getDetalle() {
		return detalle;
	}
	public void setDetalle(List<T> detalle) {
		this.detalle = detalle;
	}
	
	
}
