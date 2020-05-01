package test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import pe.com.claro.transversal.dinamico.resource.config.AppConfig;
import pe.com.claro.transversal.dinamico.resource.config.ConstantesExternas;

import org.springframework.context.ApplicationContext;

public class Prueba00 {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		
		ConstantesExternas  propiedadesExternas = ctx.getBean(ConstantesExternas.class);
		
		System.out.println("OK==="+propiedadesExternas.restIncognitoCreaCuentaUrl);

	}

}
