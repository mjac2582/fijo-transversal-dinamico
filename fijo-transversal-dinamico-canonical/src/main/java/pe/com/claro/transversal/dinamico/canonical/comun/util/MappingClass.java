package pe.com.claro.transversal.dinamico.canonical.comun.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.HttpHeaders;

import org.apache.commons.beanutils.BeanUtils;

public class MappingClass {
	
	public List<String> mappingFields() {
		List<String> lista = new ArrayList<String>();
		Field[] todasLasVariables =    this.getClass().getDeclaredFields();
		for(Field f : todasLasVariables) lista.add(f.getName());
		return lista;
	}
	
	public void mappingFields(HttpHeaders httpHeaders) {
		List<String>  lst = mappingFields() ;
		for(String campo : lst) {
			List<String> tmp = httpHeaders.getRequestHeader(campo);
			if(tmp!=null && !tmp.isEmpty()) {
				String valor = tmp.get(0);
			try {
					BeanUtils.setProperty(this, campo, valor);
				}catch(Exception e) {}
			}
		}
	}
	
	public List<String> validaClase() {
		List<String> lista = new ArrayList<String>();
		for (Field field : this.getClass().getDeclaredFields()) {
           if(! field.isAnnotationPresent(ValidadorNuloVacio.class))continue; 
            ValidadorNuloVacio validacion = field.getAnnotation(ValidadorNuloVacio.class);
            field.setAccessible(true);

            String valor=null;
            try { valor = (String) field.get(this); }catch(Exception e) {}
            
            boolean nulo = validacion.nulo();
            boolean vacio = validacion.vacio();
            
            if(!nulo || !vacio) {
	            String mensaje = field.getName()+": ";
	            boolean pase=false;
	            if(!nulo && valor==null) { mensaje= mensaje+"No debe ser Nulo. ";  pase=true; }
	            if(valor!=null && (!vacio && valor.isEmpty())) { mensaje= mensaje+"No debe estar Vacio. ";  pase=true; }
	            
	            if(pase)
	               lista.add(mensaje);
            }
			
		}
		return  lista;
	}

}
