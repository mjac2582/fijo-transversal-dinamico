package pe.com.claro.transversal.dinamico.canonical.comun.ws.bean;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;



@Retention(RetentionPolicy.RUNTIME)
public @interface AnotaProcedure {
	
	 public String nomProcedimiento() ;
}