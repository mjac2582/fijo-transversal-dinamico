package pe.com.claro.transversal.dinamico.canonical.procedimiento.configuraciones.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.google.gson.Gson;

import pe.com.claro.transversal.dinamico.canonical.procedimiento.configuraciones.bean.AtributosConfiguracionesType;
import pe.com.claro.transversal.dinamico.canonical.procedimiento.configuraciones.bean.AtributosTransaccionType;
import pe.com.claro.transversal.dinamico.canonical.procedimiento.configuraciones.bean.ObtieneConfiguracionesResponse;
import pe.com.claro.transversal.dinamico.canonical.procedimiento.configuraciones.bean.TransaccionProductoType;



public class UtilConfiguracion {

	
	
	public static synchronized ObtieneConfiguracionesResponse procesa(List<AtributosTransaccionType> configuraciones) {
		Gson gson = new Gson();
		String tipoObjeto="OBJETO";
		
		ObtieneConfiguracionesResponse responseRES = new ObtieneConfiguracionesResponse();

		TransaccionProductoType transaccionProducto = new TransaccionProductoType();

		Map<String, List<AtributosTransaccionType>> collectConfig = new HashMap<String, List<AtributosTransaccionType>>();
		collectConfig = configuraciones.stream()
				.collect(Collectors.groupingBy(AtributosTransaccionType::getProducto));

		collectConfig.entrySet().forEach(entry -> {
			transaccionProducto.setProducto(entry.getKey());
			entry.getValue().forEach(configuracionesType -> {

				AtributosConfiguracionesType atributosConfiguracionesType = new AtributosConfiguracionesType();
				
				int nivel = Integer.parseInt(configuracionesType.getNivel());
				boolean tObj = tipoObjeto.equals(configuracionesType.getTipoDato());
				
				if( nivel == 1  && tObj) {
					List<AtributosConfiguracionesType> listaConfiguracionesHijo = new ArrayList<AtributosConfiguracionesType>();
					listaConfiguracionesHijo = obtieneArbolHijo(
						configuraciones, configuracionesType.getClasePadre(),
						configuracionesType.getClase(), configuracionesType.getNivel(), tipoObjeto);
					atributosConfiguracionesType.setListaAtributosConfiguracion(listaConfiguracionesHijo);
				}
				
				if( (nivel == 1  && tObj) || (!tObj && nivel == 0)) {
					
					atributosConfiguracionesType = llenaObjeto(atributosConfiguracionesType,  configuracionesType);
					
					transaccionProducto.setTransaccion(configuracionesType.getTransaccion());
					transaccionProducto.getAtributosConfiguracion().add(atributosConfiguracionesType);
				}
				
	
				

			});
		});

		responseRES.setTransaccionProducto(transaccionProducto);
		
		
		return responseRES;

	}
	
	private static AtributosConfiguracionesType llenaObjeto(AtributosConfiguracionesType atributosConfiguracionesType,
			AtributosTransaccionType  configuracionesType) {
		atributosConfiguracionesType.setTipoAtributo(configuracionesType.getTipoAtributo());
		atributosConfiguracionesType.setTipoDato(configuracionesType.getTipoDato());
		atributosConfiguracionesType.setDescripcionAtributo(configuracionesType.getDescripcionAtributo());
		atributosConfiguracionesType.setNombreAtributo(configuracionesType.getNombreAtributo());
		atributosConfiguracionesType.setValorAtributo(configuracionesType.getValorAtributo());
		atributosConfiguracionesType.setOrdenTipoAtributo(configuracionesType.getOrdenTipoAtributo());
		atributosConfiguracionesType.setOrdenValorAtributo(configuracionesType.getOrdenValorAtributo());
		
		return atributosConfiguracionesType;
	}
	
	
	private static List<AtributosConfiguracionesType> obtieneArbolHijo(
			List<AtributosTransaccionType> listAtributosTransaccionType, String clasePadre, String clase,
			String nivel, String tipoObjeto) {

		List<AtributosConfiguracionesType> listaConfiguraciones = new ArrayList<AtributosConfiguracionesType>();
		String sigNivel = String.valueOf(Integer.parseInt(nivel) + 1);
		

		for (AtributosTransaccionType ObjetoAtributos : listAtributosTransaccionType) {
			
			

			if (clasePadre.equals(ObjetoAtributos.getClasePadre()) && nivel.equals(ObjetoAtributos.getNivel())
					&& clase.equals(ObjetoAtributos.getClase()) && !tipoObjeto.equals(ObjetoAtributos.getTipoDato())) {

				AtributosConfiguracionesType atributosConfiguracionesType = new AtributosConfiguracionesType();

				atributosConfiguracionesType = llenaObjeto(atributosConfiguracionesType,  ObjetoAtributos);
				
					
				listaConfiguraciones.add(atributosConfiguracionesType);

			} else if (tipoObjeto.equals(ObjetoAtributos.getTipoDato()) && sigNivel.equals(ObjetoAtributos.getNivel())
					&& clase.equals(ObjetoAtributos.getClasePadre())) {

				List<AtributosConfiguracionesType> listaConfiguracionesHijo = new ArrayList<AtributosConfiguracionesType>();

				listaConfiguracionesHijo = obtieneArbolHijo(listAtributosTransaccionType,
						ObjetoAtributos.getClasePadre(), ObjetoAtributos.getClase(), ObjetoAtributos.getNivel(),
						tipoObjeto);

				AtributosConfiguracionesType atributosConfiguracionesType = new AtributosConfiguracionesType();

				atributosConfiguracionesType = llenaObjeto(atributosConfiguracionesType,  ObjetoAtributos);
				
				atributosConfiguracionesType.setListaAtributosConfiguracion(listaConfiguracionesHijo);
				listaConfiguraciones.add(atributosConfiguracionesType);
				
				
			}

		}
		return listaConfiguraciones;
	}
	
	
}
