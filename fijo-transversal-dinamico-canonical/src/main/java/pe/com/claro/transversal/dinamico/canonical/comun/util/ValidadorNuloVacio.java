package pe.com.claro.transversal.dinamico.canonical.comun.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ValidadorNuloVacio {

public boolean nulo() default false;

public boolean vacio() default false;

}