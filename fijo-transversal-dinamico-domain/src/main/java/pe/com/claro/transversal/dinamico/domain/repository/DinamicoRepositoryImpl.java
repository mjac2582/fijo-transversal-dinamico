package pe.com.claro.transversal.dinamico.domain.repository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.ws.rs.core.Configuration;
import javax.ws.rs.core.Context;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.jdbc.Work;

import com.google.gson.Gson;

import pe.com.claro.transversal.dinamico.canonical.comun.bean.ReqResTransporte;
import pe.com.claro.transversal.dinamico.canonical.comun.exception.WSException;
import pe.com.claro.transversal.dinamico.canonical.comun.property.Constantes;
import pe.com.claro.transversal.dinamico.canonical.comun.repository.AbstractRepository;
import pe.com.claro.transversal.dinamico.canonical.comun.util.ClaroUtiles;
import pe.com.claro.transversal.dinamico.canonical.comun.util.CodigoTecnico;
import pe.com.claro.transversal.dinamico.canonical.comun.ws.UtilProcedimiento;
import pe.com.claro.transversal.dinamico.client.repository.DinamicoRepository;
import pe.com.claro.transversal.dinamico.property.ConstanteJPA;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;


@Stateless
public class DinamicoRepositoryImpl extends AbstractRepository<Object>  implements DinamicoRepository{

	private static final Logger logger = Logger.getLogger(DinamicoRepositoryImpl.class);   
	
	@Context
	private Configuration configuration;
	
	 //protected EntityManager entityManager;
	

	@PersistenceContext(unitName = ConstanteJPA.PERSISTENCE_CONTEXT)
	public void setPersistenceUnit00(final EntityManager em) {
		this.entityManager = em;
	}
	
	@Override
	public <T> T  ejecutaProcedimiento(T o) throws WSException {
		logger.info("ejecutaProcedimiento - repositorio "); 
		logger.info("Conexion="+this.getConexion());
		UtilProcedimiento.conex = this.getConexion();
		return UtilProcedimiento.execProcedimiento(o);
	}
	
	
	
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ReqResTransporte consumeRest(String path, String metodo,ReqResTransporte objReqResp) throws WSException {
		Object resp=null;
		Gson gson = new Gson();
		HttpURLConnection conn = null;
		try {

			URL url = new URL(path);
			conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setUseCaches(false);
			conn.setDoInput(true);
			conn.setAllowUserInteraction(true);
			conn.setRequestMethod(metodo.toUpperCase());
			conn.setRequestProperty(Constantes.CONTENT_TYPE,  Constantes.MEDIA_JSON);
			conn.setRequestProperty(Constantes.ACCEPT, Constantes.MEDIA_JSON);
			conn.setConnectTimeout(Constantes.TIMEOUT_CONNECTION);
			conn.setReadTimeout(Constantes.TIMEOUT_READ); 
			
			conn = ClaroUtiles.agregaPropiedades(conn, objReqResp.getHeaderRequest() );
			String input = gson.toJson(objReqResp.getBodyRequest());
			
			logger.info("REQ="+input);

			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes());
			os.flush();
			
			Integer codigoSalida = conn.getResponseCode();
				String code = codigoSalida.toString();
			String description = ClaroUtiles.getDescripcionxCodigo(code, CodigoTecnico.class);
			
			
			
			logger.info("codigoSalida="+codigoSalida);
			
			if(codigoSalida>=Constantes.LIMITE_200 && codigoSalida<=Constantes.LIMITE_205) {
				resp = ClaroUtiles.recuperaData(conn, objReqResp.getClzResponse(), true);
				logger.info("resp="+gson.toJson(resp));
				
				objReqResp.setCodigoRespuesta(""+codigoSalida);
				objReqResp.setMensajeRespuesta(description);
				
				if(resp!=null && resp.toString().length()>0) {
					objReqResp.setBodyResponse(resp);
				}else {
					objReqResp.setCodigoRespuesta(Constantes.OK);
					objReqResp.setMensajeRespuesta(Constantes.OK_MSG);
				}
				
			}else if(codigoSalida.equals(Constantes.LIMITE_417)  || codigoSalida.equals(Constantes.LIMITE_501)){
				Object beanError =  objReqResp.getClzError().newInstance();
				beanError = ClaroUtiles.recuperaData(conn,objReqResp.getClzError(), false);
				
				logger.info("errorBean ="+gson.toJson(beanError));
				
				if(beanError!=null) {
					objReqResp.setCodigoRespuesta(""+Constantes.MENOS_UNO);
					objReqResp.setMensajeRespuesta(null);
					objReqResp.setErrorResponse(beanError);
					logger.info("Salida 1------------------------");
				}else {
					objReqResp.setCodigoRespuesta(Constantes.ERROR);
					objReqResp.setMensajeRespuesta(Constantes.DESCONOCIDO);
					logger.info("Salida 2------------------------");
				}
			}else {
				objReqResp.setCodigoRespuesta(""+codigoSalida);
				objReqResp.setMensajeRespuesta(description);
				logger.info("Salida 3------------------------");
			}
			
		  } catch (Exception e) {
			  logger.error("Error="+e);
			  objReqResp.setCodigoRespuesta(Constantes.ERROR);
			  objReqResp.setMensajeRespuesta(e.getCause().toString());
			  throw new WSException(Constantes.ERROR, e.getMessage());
		  }finally {
			  logger.info("Salida 4------------------------");
			  if(conn!=null) {  conn.disconnect();}
		  }
		logger.info("Salida 5------------------------");
		return objReqResp;
		 
	}


	@Override
	protected Predicate[] getSearchPredicates(Root<Object> root, Object example) {
		return new Predicate[0];
	}




	private static class MyWork implements Work {
		 
	    Connection conn;
	    public void execute(Connection conn) throws SQLException {
	      this.conn = conn;
	    }
	    Connection getConnection() {
	      return conn; 
	    }
	  } 
	
	 public Connection getConexion() {
		 Session session = entityManager.unwrap(Session.class);
		
		    MyWork myWork = new MyWork();
		    
		    session.doWork(myWork);
		    return myWork.getConnection();
   }

}

