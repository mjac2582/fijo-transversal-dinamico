package pe.com.claro.transversal.dinamico.domain.service;

import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import pe.com.claro.transversal.dinamico.canonical.comun.bean.ReqResTransporte;
import pe.com.claro.transversal.dinamico.canonical.comun.exception.WSException;
import pe.com.claro.transversal.dinamico.canonical.comun.property.Constantes;
import pe.com.claro.transversal.dinamico.canonical.comun.util.ClaroUtiles;
import pe.com.claro.transversal.dinamico.canonical.comun.util.CodigoFuncional;
import pe.com.claro.transversal.dinamico.canonical.procedimiento.configuraciones.ConfiguracionProcedimiento;
import pe.com.claro.transversal.dinamico.canonical.procedimiento.configuraciones.bean.AtributosTransaccionType;
import pe.com.claro.transversal.dinamico.canonical.procedimiento.configuraciones.bean.ObtieneConfiguracionesResponse;
import pe.com.claro.transversal.dinamico.canonical.procedimiento.configuraciones.util.UtilConfiguracion;
import pe.com.claro.transversal.dinamico.canonical.types.ftth.type.base.ErrorResponse;
import pe.com.claro.transversal.dinamico.canonical.types.ftth.type.base.ReconexionBean;
import pe.com.claro.transversal.dinamico.client.repository.DinamicoRepository;
import pe.com.claro.transversal.dinamico.client.service.DinamicoService;

import pe.com.claro.transversal.dinamico.domain.repository.DinamicoRepositoryImpl;


import java.util.List;

import javax.ejb.EJB;


@Stateless
public class DinamicoServiceImpl implements DinamicoService {
	
	private static final Logger logger = Logger.getLogger(DinamicoServiceImpl.class); 

	@EJB
	private DinamicoRepository clienteRest;
	
	public <T> T  ejecutaProcedimientoSesion(T o) throws WSException {
		logger.info("-------Sesion---------");
		
		return clienteRest.ejecutaProcedimiento(o);
	}
	
	@Override
	public ObtieneConfiguracionesResponse obtieneConfiguraciones(ConfiguracionProcedimiento config)
			throws WSException {
		
		ConfiguracionProcedimiento rpta =  clienteRest.ejecutaProcedimiento(config);
		
		List<AtributosTransaccionType>  configuraciones = rpta.getLstAtributos();
		
		ObtieneConfiguracionesResponse obt = UtilConfiguracion.procesa(configuraciones);
		
		obt.setCodigoRespuesta(rpta.getCodigo());
		obt.setMensajeRespuesta(rpta.getRespuesta());
		
		return obt;
		
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public ReqResTransporte consumeRest(String path, String metodo, ReqResTransporte objReqResp)
			throws WSException {
		ReqResTransporte resp=null;
		logger.info("-------consumeRest---------1");
		
		if(clienteRest == null) { clienteRest = new DinamicoRepositoryImpl();}
			
		    try {
		    	logger.info("-------consumeRest---------2");
		    	resp = clienteRest.consumeRest(path, metodo, objReqResp);
		    	logger.info("-------consumeRest---------3");
		    	ErrorResponse objError = null;
		    	
		    	if(resp.getErrorResponse()!=null) {
		    		logger.info("-------consumeRest---------4");
		    		objError  = (ErrorResponse) resp.getErrorResponse();
		    		String descripFuncional = ClaroUtiles.getDescripcionxCodigo(objError.getError().getCode(), CodigoFuncional.class);
		    		logger.info("-------consumeRest---------5");
		    		logger.info("-------objError.getError().getCode()="+objError.getError().getCode());
		    		logger.info("-------descripFuncional="+descripFuncional);
		    		resp.setCodigoRespuesta(objError.getError().getCode());
		    		if(objError!=null && objError.getError()!=null && objError.getError().getDescription()!=null) {
		    			resp.setMensajeRespuesta(objError.getError().getDescription());
		    		}else {
		    			resp.setMensajeRespuesta(descripFuncional);
		    		}
		    		resp.setErrorResponse(null);
		    	}
		    	//logger.info("-------consumeRest---------6");
		    	//logger.info("-------SALIDA RESP="+gson.toJson(resp));
		    return resp;
		    }catch(Exception e) {
		    	logger.error("Error="+e);
		    	 throw new WSException(Constantes.ERROR, e.getMessage());
		    }
	}

	@Override
	public ReqResTransporte consumeReconexion(String path, String metodo, ReqResTransporte objReqResp)
			throws WSException {
		
	
		ReqResTransporte resp=null;
		if(clienteRest == null) { clienteRest = new DinamicoRepositoryImpl();}
			
		    try {
		    	ReconexionBean req = (ReconexionBean) objReqResp.getBodyRequest();
		    	
		    	path = path.replace("@serviceId", req.getServiceId());
		    	path = path.replace("@tipoRecurso", req.getTipoRecurso());
		    	
		    	logger.info("-------RUTA---------"+path);
		    	
		    	resp = clienteRest.consumeRest(path, metodo, objReqResp);
		    	logger.info("-------consumeReconexion---------3");
		    	ErrorResponse objError = null;
		    	
		    	if(resp.getErrorResponse()!=null) {
		    		logger.info("-------consumeReconexion---------4");
		    		objError  = (ErrorResponse) resp.getErrorResponse();
		    		
		    		String descripFuncional = ClaroUtiles.getDescripcionxCodigo(objError.getError().getCode(), CodigoFuncional.class);
		    		logger.info("-------consumeReconexion---------5");
		    		logger.info("-------objError.getError().getCode()="+objError.getError().getCode());
		    		logger.info("-------descripFuncional="+descripFuncional);
		    		resp.setCodigoRespuesta(objError.getError().getCode());
		    		
		    		if(objError!=null && objError.getError()!=null && objError.getError().getDescription()!=null) {
		    			resp.setMensajeRespuesta(objError.getError().getDescription());
		    		}else {
		    			resp.setMensajeRespuesta(descripFuncional);
		    		}
		    		resp.setErrorResponse(null);
		    	}
		    	
		    return resp;
		    	
		    }catch(Exception e) {
		    	logger.error("Error="+e);
		    	 throw new WSException(Constantes.ERROR, e.getMessage());
		    }
	}

	

  
  

}
