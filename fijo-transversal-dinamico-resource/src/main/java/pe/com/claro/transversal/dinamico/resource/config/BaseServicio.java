package pe.com.claro.transversal.dinamico.resource.config;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PreDestroy;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MultivaluedMap;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.google.gson.Gson;


public class BaseServicio {
	
	private static ApplicationContext ctx;
	private static final Logger logger = Logger.getLogger(BaseServicio.class);
	
	protected static <T> T cargaProperties( Class<T> clz) {
		logger.info("Carga el Contexto ");
		ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		 
		return ctx.getBean(clz);
	}
	
	@PreDestroy
	protected void destruye() {
		logger.info("Destruye el Contexto ");
		((AnnotationConfigApplicationContext)ctx).close();
	}
	
	protected <T> T obtenerHeader(HttpHeaders httpHeaders, Class<T> clz) {
		logger.info("obtenerHeader ");
		Gson gson = new Gson();
		MultivaluedMap<String, String> headRequest =httpHeaders.getRequestHeaders();
		 Map<String,String> parameters = new HashMap<String,String>();
		    for (Map.Entry<String,List<String>> e : headRequest.entrySet()) {
		        parameters.put(e.getKey(), e.getValue().get(0));
		    } 
		String jsonHeader = gson.toJson(parameters);
		
		logger.info("----------jsonHeader----"+jsonHeader);
		
		return gson.fromJson(jsonHeader, clz);
	}
	

}
