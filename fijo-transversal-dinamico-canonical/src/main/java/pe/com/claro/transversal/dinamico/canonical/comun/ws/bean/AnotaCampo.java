package pe.com.claro.transversal.dinamico.canonical.comun.ws.bean;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;



@Retention(RUNTIME)
@Target(FIELD)
public @interface AnotaCampo {
	 public int tipoDato() default  TipoDato.NULL;
	 public int tipoInOut() default TipoInOut.IN;
	 public int orden();
}
