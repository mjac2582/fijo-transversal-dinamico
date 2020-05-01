package test;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.beanutils.BeanUtils;

import com.google.gson.Gson;

import pe.com.claro.transversal.dinamico.canonical.comun.ws.UtilProcedimiento;
import pe.com.claro.transversal.dinamico.canonical.procedimiento.contenido.ContenidoProcedimiento;
import pe.com.claro.transversal.dinamico.canonical.procedimiento.contenido.ContenidoSoap;


public class Prueba001 {

	public static void main(String[] args) {
		
		 
		 Gson gson = new Gson();
		 ContenidoProcedimiento con = new ContenidoProcedimiento();
		 con.setClase(1);
			
			UtilProcedimiento.conex = UtilConexion.getCon();
			 con =UtilProcedimiento.execProcedimiento(con);
			 
			 List<ContenidoSoap> lstCont =  con.getLstContenido();
			 List<ContenidoSoap> lstSalida = new ArrayList<ContenidoSoap>();
			 ContenidoSoap contTempo1 = new ContenidoSoap();
			 Map<String, List<ContenidoSoap>> collectConfig = new HashMap<String, List<ContenidoSoap>>();
				collectConfig = lstCont.stream()
						.collect(Collectors.groupingBy(ContenidoSoap::getPrefijo));

				collectConfig.entrySet().forEach(entry -> {
					
					//System.out.println("entry.getKey()="+entry.getKey()+", entry.getValue()="+entry.getValue());
					
					System.out.println("entry.getKey()="+entry.getKey());
					
					
					//transaccionProducto.setProducto(entry.getKey());
					entry.getValue().forEach(contSoap -> {
						 System.out.println("JSON==="+gson.toJson(contSoap));
						 
						 if(contSoap.getPadre()==0) {
							 try {
								BeanUtils.copyProperties(contTempo1, contSoap);
							} catch (Exception e) {
								e.printStackTrace();
							}
						 }else {
							 contTempo1.getHijo().add(contSoap);
						 }
						 
						 
						 
					});
					
				});

	}
	

}
