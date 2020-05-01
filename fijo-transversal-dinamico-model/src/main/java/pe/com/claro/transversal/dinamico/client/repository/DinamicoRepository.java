package pe.com.claro.transversal.dinamico.client.repository;


import javax.ejb.Remote;

import pe.com.claro.transversal.dinamico.canonical.comun.bean.ReqResTransporte;
import pe.com.claro.transversal.dinamico.canonical.comun.exception.WSException;



@Remote
public interface DinamicoRepository {
	@SuppressWarnings("rawtypes")
	public   ReqResTransporte consumeRest(String path, String metodo,ReqResTransporte objReqResp)
			throws WSException;
	
	public <T> T  ejecutaProcedimiento(T o) throws WSException;
}
