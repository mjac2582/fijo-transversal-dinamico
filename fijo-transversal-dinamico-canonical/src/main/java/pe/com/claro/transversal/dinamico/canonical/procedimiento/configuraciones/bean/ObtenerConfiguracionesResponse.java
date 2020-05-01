package pe.com.claro.transversal.dinamico.canonical.procedimiento.configuraciones.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



public class ObtenerConfiguracionesResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<AtributosTransaccionType> configuraciones;
	private int codRespuesta;
	private String msgRespuesta;

	public List<AtributosTransaccionType> getConfiguraciones() {
		configuraciones = new ArrayList<AtributosTransaccionType>();
		return configuraciones;
	}

	public void setConfiguraciones(List<AtributosTransaccionType> configuraciones) {
		this.configuraciones = configuraciones;
	}

	public int getCodRespuesta() {
		return codRespuesta;
	}

	public void setCodRespuesta(int codRespuesta) {
		this.codRespuesta = codRespuesta;
	}

	public String getMsgRespuesta() {
		return msgRespuesta;
	}

	public void setMsgRespuesta(String msgRespuesta) {
		this.msgRespuesta = msgRespuesta;
	}

}
