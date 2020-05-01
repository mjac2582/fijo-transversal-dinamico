package pe.com.claro.transversal.dinamico.canonical.procedimiento.configuraciones.bean;

import java.io.Serializable;

public class BodyResponse    {
	

	
	private String idTransaccion;
	private int codigoRespuesta;
	private String mensajeRespuesta;
	
	public BodyResponse() {
		super();
	}
	
	public BodyResponse(BodyResponse obj) {
		super();
		this.idTransaccion = obj.getIdTransaccion();
		this.codigoRespuesta = obj.getCodigoRespuesta();
		this.mensajeRespuesta = obj.getMensajeRespuesta();
	}
	
	public BodyResponse(String idTransaccion, int codigoRespuesta, String mensajeRespuesta) {
		super();
		this.idTransaccion = idTransaccion;
		this.codigoRespuesta = codigoRespuesta;
		this.mensajeRespuesta = mensajeRespuesta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((String.valueOf(codigoRespuesta) == null) ? 0 : String.valueOf(codigoRespuesta).hashCode());
		result = prime * result + ((mensajeRespuesta == null) ? 0 : mensajeRespuesta.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj){
			return true;
		}
		if (obj == null){
			return false;
		}
		if (getClass() != obj.getClass()){
			return false;
		}
		BodyResponse other = (BodyResponse) obj;
		if (String.valueOf(codigoRespuesta) == null) {
			if (String.valueOf(other.codigoRespuesta) != null){
				return false;
			}
		} else if (!String.valueOf(codigoRespuesta).equals(other.codigoRespuesta)){
			return false;
		}
		if (mensajeRespuesta == null) {
			if (other.mensajeRespuesta != null){
				return false;
			}
		} else if (!mensajeRespuesta.equals(other.mensajeRespuesta)){
			return false;
		}
		return true;
	}

	public String getIdTransaccion() {
		return idTransaccion;
	}

	public void setIdTransaccion(String idTransaccion) {
		this.idTransaccion = idTransaccion;
	}

	public int getCodigoRespuesta() {
		return codigoRespuesta;
	}

	public void setCodigoRespuesta(int codigoRespuesta) {
		this.codigoRespuesta = codigoRespuesta;
	}

	public String getMensajeRespuesta() {
		return mensajeRespuesta;
	}

	public void setMensajeRespuesta(String mensajeRespuesta) {
		this.mensajeRespuesta = mensajeRespuesta;
	}

	@Override
	public String toString() {
		return "BodyResponse [codigoRespuesta=" + codigoRespuesta
				+ ", mensajeRespuesta=" + mensajeRespuesta + "]";
	}

	
}