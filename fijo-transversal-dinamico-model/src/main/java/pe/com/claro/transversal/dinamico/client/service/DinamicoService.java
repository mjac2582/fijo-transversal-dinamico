package pe.com.claro.transversal.dinamico.client.service;

import javax.ejb.Remote;

import pe.com.claro.transversal.dinamico.canonical.comun.bean.ReqResTransporte;
import pe.com.claro.transversal.dinamico.canonical.comun.exception.WSException;
import pe.com.claro.transversal.dinamico.canonical.procedimiento.configuraciones.ConfiguracionProcedimiento;
import pe.com.claro.transversal.dinamico.canonical.procedimiento.configuraciones.bean.ObtieneConfiguracionesResponse;


@Remote
public interface DinamicoService {
	
	@SuppressWarnings("rawtypes")
	public   ReqResTransporte consumeRest(String path, String metodo,ReqResTransporte objReqResp) throws WSException;
	
	public ReqResTransporte consumeReconexion(String path, String metodo, ReqResTransporte objReqResp) throws WSException;
	public <T> T  ejecutaProcedimientoSesion(T o) throws WSException;
	
	public ObtieneConfiguracionesResponse  obtieneConfiguraciones(ConfiguracionProcedimiento config) throws WSException;

}
