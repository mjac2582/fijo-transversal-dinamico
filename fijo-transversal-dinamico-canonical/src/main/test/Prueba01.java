package test;

import com.google.gson.Gson;

import pe.com.claro.transversal.dinamico.domain.ftth.type.base.FtthServiceResponseType;

public class Prueba01 {

	public static void main(String[] args) {
		
		Gson gson = new Gson();
		String json = "{" + 
				"\"device\":{" + 
				"\"type\":\"HG8245Q2\"," + 
				"\"status\":\"PENDING_ACTIVE\"," + 
				"\"parentId\":0," + 
				"" + 
				"\"id\":18296," + 
				"\"entityId\":4020," + 
				"\"identifier\":\"1559230423870522\"," + 
				"\"description\":\"\"," + 
				"\"lastModifiedBy\":\"restapihfc\"," + 
				"\"creationDate\":\"May 30, 2019 6:05:02 PM\"," + 
				"\"lastModified\":\"May 30, 2019 6:05:02 PM\"" + 
				"}," + 
				"\"serviceType\":\"Internet_FTTH_200M_40M\"," + 
				"\"status\":\"PENDING_ACTIVE\"," + 
				"\"startDate\":\"May 30, 2019 6:05:02 PM\"," + 
				"\"attributes\":[" + 
				"{" + 
				"\"GEM_PORT_ID\":\"320\"," + 
				"\"VLAN_ID\":\"3200\"," + 
				"\"USER_VLAN_ID\":\"3200\"" + 
				"}" + 
				"]," + 
				"\"id\":7854," + 
				"\"entityId\":4020," + 
				"\"identifier\":\"SGA000000029\"," + 
				"\"description\":\"\"," + 
				"\"lastModifiedBy\":\"restapihfc\"," + 
				"\"creationDate\":\"May 30, 2019 6:05:02 PM\"," + 
				"\"lastModified\":\"May 30, 2019 6:05:02 PM\"" + 
				"}";
		
		String json2 = "{" + 
				" \"device\":{" + 
				"\"type\":\"DCX3400\"," + 
				"\"status\":\"ACTIVE\"," + 
				"\"attributes\":[" + 
				" {" + 
				"\"HOST_UNIT_ADDRESS\":\"0000028215937074\"," + 
				"\"PSA_ADDED_TO_CAS\":\"YES\"" + 
				" }" + 
				"]," + 
				"\"parentId\":0," + 
				"\"id\":17903," + 
				"\"entityId\":3947," + 
				"\"identifier\":\"A91505EQA970\"," + 
				"\"description\":\"\"," + 
				"\"lastModifiedBy\":\"c18048\"," + 
				"\"creationDate\":\"May 16, 2019 10:44:24 AM\"," + 
				"\"lastModified\":\"May 16, 2019 10:44:26 AM\"" + 
				" }," + 
				" \"serviceType\":\"Migra2\"," + 
				" \"status\":\"ACTIVE\"," + 
				" \"startDate\":\"May 16, 2019 10:44:24 AM\"," + 
				" \"attributes\":[" + 
				"{" + 
				" \"DTV_NODE\":\"PAPROV_DSP\"," + 
				" \"DTV_CHANNEL_MAP\":\"DTA\"," + 
				" \"DTV_HEADEND\":\"VES_DSP\"" + 
				"}" + 
				" ]," + 
				" \"id\":7620," + 
				" \"entityId\":3947," + 
				" \"identifier\":\"TV00001\"," + 
				" \"description\":\"\"," + 
				" \"lastModifiedBy\":\"c18048\"," + 
				" \"creationDate\":\"May 16, 2019 10:44:24 AM\"," + 
				" \"lastModified\":\"May 16, 2019 10:44:24 AM\"" + 
				"}";
		
		
		// attributes  herencia :FtthInternetAttributesType  FtthServiceTelefoniaType	  HfcInternetAttributesType  TvSSAttributesType
		FtthServiceResponseType obj = gson.fromJson(json, FtthServiceResponseType.class);
		FtthServiceResponseType obj2 = gson.fromJson(json2, FtthServiceResponseType.class);
		
		System.out.println("Salida = "+gson.toJson(obj));
		System.out.println("Salida 2 = "+gson.toJson(obj2));
		

	}

}
