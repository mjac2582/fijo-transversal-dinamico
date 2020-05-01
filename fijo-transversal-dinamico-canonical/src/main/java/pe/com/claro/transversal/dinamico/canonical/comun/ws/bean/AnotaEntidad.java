package pe.com.claro.transversal.dinamico.canonical.comun.ws.bean;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;



@Retention(RUNTIME)
@Target(FIELD)
public @interface AnotaEntidad {
	 public String campoBD()  default "";
	 public int orden()  default  -1;
}
