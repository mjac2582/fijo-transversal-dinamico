package pe.com.claro.transversal.dinamico.canonical.comun.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import org.apache.commons.beanutils.BeanMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import pe.com.claro.transversal.dinamico.canonical.comun.property.Constantes;






public class ClaroUtiles {

	private static final Logger logger = LoggerFactory.getLogger(ClaroUtiles.class);

	public static synchronized String getDescripcionxCodigo(String prefijo, String codigo, Class<?> claz) {
		try {
			Map<Object, Object> beanMap = new BeanMap(claz.newInstance());
			String datoPre = (String) beanMap.get(prefijo);
			return (String) beanMap.get(datoPre+""+codigo);
		}catch(Exception e) {
			logger.error( "Error=",e);
			return null;
		}
	}
	
	public static synchronized String getDescripcionxCodigo(String codigo, Class<?> claz) {
		String pre = Constantes.PREFIJO;
		String out = getDescripcionxCodigo(pre, codigo, claz);
    if(out==null){ 
      out = Constantes.DESCONOCIDO;
    }
		return out;
	}
	
	public static synchronized <T> HttpURLConnection agregaPropiedades(HttpURLConnection conn, T objetoOrigen) {
    Map<Object, Object> beanMap = new BeanMap(objetoOrigen);
		Field [] field = objetoOrigen.getClass().getDeclaredFields();
		
		for(int h =0;h<field.length;h++){
			if(field[h].getName()!=null && beanMap.get(field[h].getName())!=null) {
				conn.setRequestProperty((String)field[h].getName(),(String)beanMap.get(field[h].getName()));
			}
		}
		return conn;
	}
	
	@SuppressWarnings("unchecked")
	public static synchronized <T> T recuperaData(HttpURLConnection conn, Class<?> clz, boolean ok) {
		try {
			StringBuilder sb = new StringBuilder();
			String output = Constantes.VACIO;	
			BufferedReader br = null;
			if(ok) {
				br = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8));
			}else {
				br = new BufferedReader(new InputStreamReader(conn.getErrorStream(), StandardCharsets.UTF_8));
			}
			while ((output = br.readLine()) != null) {
				sb.append(output);
			}
			Gson gson2 = new GsonBuilder().setDateFormat(Constantes.FORMATO_FECHA_DD_MM_YYYY).create();
			logger.info("sb.toString()="+sb.toString());
			logger.info("clz="+clz);
			return (T) gson2.fromJson(sb.toString(),clz);
		}catch(Exception e) {
			logger.error("Error=",e);
			return null;
		}
		
	}


}