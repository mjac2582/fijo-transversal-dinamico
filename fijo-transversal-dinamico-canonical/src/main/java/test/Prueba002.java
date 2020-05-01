package test;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.beanutils.BeanUtils;

import com.google.gson.Gson;

import net.sf.json.JSON;
import net.sf.json.JSONSerializer;
import pe.com.claro.transversal.dinamico.canonical.comun.ws.UtilProcedimiento;
import pe.com.claro.transversal.dinamico.canonical.procedimiento.contenido.ContenidoProcedimiento;
import pe.com.claro.transversal.dinamico.canonical.procedimiento.contenido.ContenidoSoap;

public class Prueba002 {

	public static void main(String[] args) {
		 Gson gson = new Gson();
		 ContenidoProcedimiento con = new ContenidoProcedimiento();
		 con.setClase(1);
			
			UtilProcedimiento.conex = UtilConexion.getCon();
			 con =UtilProcedimiento.execProcedimiento(con);
			 
			 
			 List<ContenidoSoap> lstCont =  con.getLstContenido();
			 
			 List<ContenidoSoap> lstNueva =  new ArrayList<ContenidoSoap>();

			 
			 	Map<String, List<ContenidoSoap>> collectConfig = new HashMap<String, List<ContenidoSoap>>();
			 	collectConfig = lstCont.stream()
			 			.collect(Collectors.groupingBy(ContenidoSoap::getPrefijo));
			 
			 	collectConfig.entrySet().forEach(entry -> {
			 		ContenidoSoap contenidoTypeHijo = new ContenidoSoap();
			 		
			 		System.out.println("entry.getKey()="+entry.getKey());
			 		
			 		 List<ContenidoSoap> lstTemp =  new ArrayList<ContenidoSoap>();
			 		entry.getValue().forEach(contenidoType -> {
			 			
			 			//System.out.println("----->"+JSONSerializer.toJSON(contenidoType));
			 			int nivel = contenidoType.getPadre();
			 			
			 			if(nivel==0) {
			 				try {
								BeanUtils.copyProperties(contenidoTypeHijo,  contenidoType);
							} catch (Exception e) {
								e.printStackTrace();
							}
			 			}else {
			 				ContenidoSoap hijo2 = new ContenidoSoap();
			 				try {
								BeanUtils.copyProperties(hijo2,  contenidoType);
							} catch (Exception e) {
								e.printStackTrace();
							}
			 				
			 				lstTemp.add(hijo2);
			 			}
			 			
			 
//			 			int nivel = contenidoType.getPadre();
//			 			if( nivel >0) {
////			 				List<ContenidoSoap> listaContenidoHijo = new ArrayList<ContenidoSoap>();
////			 				listaContenidoHijo = obtieneArbolHijo(
////			 						lstCont, contenidoType.getIdentificador(),
////			 						contenidoType.getClase(), contenidoType.getPadre());
////			 				contenidoTypeHijo.setHijo(listaContenidoHijo);
//			 			}
//
//			 			if( nivel == 0) {
////			 			try {
////							BeanUtils.copyProperties(contenidoTypeHijo,  contenidoType);
////						} catch (Exception e) {
////							e.printStackTrace();
////						}
//			 			}
			 			
			 
			 		});
			 		contenidoTypeHijo.setHijo(lstTemp);
			 		
			 		lstNueva.add(contenidoTypeHijo);
			 		
			 	});
			 	
			 	
			 	System.out.println(gson.toJson(lstNueva));
			 
			 	//responseRES.setTransaccionProducto(transaccionProducto);
			 
			 
			 
			 
//			 List<ContenidoSoap> lstSalida = listado(0, lstCont);
//			 System.out.println("SALIDA="+lstSalida.size());
				 
	}
	
	
//	private static List<AtributosConfiguracionesType> obtieneArbolHijo(
//			List<AtributosTransaccionType> listAtributosTransaccionType, String clasePadre, String clase,
//			String nivel, String tipoObjeto) {
	
	
//	lstCont, contenidoType.getIdentificador(),
//				contenidoType.getClase(), contenidoType.getPadre());
	
	private static List<ContenidoSoap> obtieneArbolHijo(
			List<ContenidoSoap> listAtributosTransaccionType, int clasePadre, int clase,
			int nivel) {

		List<ContenidoSoap> listaConfiguraciones = new ArrayList<ContenidoSoap>();
		int sigNivel = nivel;// String.valueOf(Integer.parseInt(nivel) + 1);
		

		for (ContenidoSoap ObjetoAtributos : listAtributosTransaccionType) {
			
			

			if (clasePadre == ObjetoAtributos.getPadre() && nivel == ObjetoAtributos.getIdentificador()) {

				ContenidoSoap atributosConfiguracionesType = new ContenidoSoap();

				try {
					BeanUtils.copyProperties(atributosConfiguracionesType,  ObjetoAtributos);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
					
				listaConfiguraciones.add(atributosConfiguracionesType);

			} else if ( sigNivel == ObjetoAtributos.getIdentificador()) {

				List<ContenidoSoap> listaConfiguracionesHijo = new ArrayList<ContenidoSoap>();

				listaConfiguracionesHijo = obtieneArbolHijo(listAtributosTransaccionType,
						ObjetoAtributos.getIdentificador(), ObjetoAtributos.getClase(), ObjetoAtributos.getPadre());

				ContenidoSoap atributosConfiguracionesType = new ContenidoSoap();

				//atributosConfiguracionesType = llenaObjeto(atributosConfiguracionesType,  ObjetoAtributos);
				try {
					BeanUtils.copyProperties(atributosConfiguracionesType,  ObjetoAtributos);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				atributosConfiguracionesType.setHijo(listaConfiguracionesHijo);
				listaConfiguraciones.add(atributosConfiguracionesType);
				
				
			}

		}
		return listaConfiguraciones;
	}
	
	
	
	
	
	
//	private static List<ContenidoSoap> listado(int padre, List<ContenidoSoap> lstCont) {
//		 List<ContenidoSoap> lstOut = new ArrayList<ContenidoSoap>();
//		for(ContenidoSoap c :lstCont) {
//			 
//			 if(c.getPadre()==padre) {
//				 int nuevopadre= c.getIdentificador();
//				 System.out.println("nuevopadre="+nuevopadre);
//				 List<ContenidoSoap> lstTmp = listado(nuevopadre, lstCont);
//				 
//				 JSON jss = JSONSerializer.toJSON(lstTmp);
//				 System.out.println("JS="+jss.toString());
//				 
//				 c.setHijo(lstTmp);
//			 }
//			 
//			 lstOut.add(c);
//		 }
//		
//		return lstOut;
//	}
	
	

}
