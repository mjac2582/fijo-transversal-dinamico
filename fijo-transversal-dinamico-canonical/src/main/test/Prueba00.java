package test;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import pe.com.claro.transversal.dinamico.domain.ftth.type.ChildType;
import pe.com.claro.transversal.dinamico.domain.ftth.type.DeviceType;
import pe.com.claro.transversal.dinamico.domain.ftth.type.FtthServiceInternetType;
import pe.com.claro.transversal.dinamico.domain.ftth.type.TvSSDeviceAttributesType;
import pe.com.claro.transversal.dinamico.domain.ftth.type.base.FtthServiceType;

@SuppressWarnings("unchecked")
public class Prueba00 {
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		Gson gson = new Gson();
		
			FtthServiceInternetType atrib = new FtthServiceInternetType();
			atrib.setGEMPORTID("320");
			atrib.setVLANID("3200");
			atrib.setUSERVLANID("3200");
			List<FtthServiceInternetType> lst = new ArrayList<FtthServiceInternetType>();
			lst.add(atrib);
			
			FtthServiceType serv = new FtthServiceType(lst);
			serv.setIdentifier("SGA00000000000");
			serv.setSubscriberIdentifier("40862684");
			serv.setServiceType("Internet_FTTH_200M_40M");
			
			DeviceType child = new DeviceType(null);
			child.setIdentifier("1559230423870522");
			child.setType("HG8245Q2");
			serv.setDevice(child);
			System.out.println("INTERNET  FTTH "+gson.toJson(serv));
		
		System.out.println("----------------------------------------------------------------");
		
		FtthServiceInternetType atrib2 = new FtthServiceInternetType();
		//FtthServiceTelefoniaType atrib2 = new FtthServiceInternetType();
		atrib2.setCALLFEATURES("S");
		atrib2.setTELEPHONYPHONENUMBER("6985457");
		atrib2.setPASSWORD("PWD123");
		atrib2.setMTAPORT("1");
		atrib2.setVOICENODE("LIM");
		atrib2.setISCENTREXENABLED("NO");
		atrib2.setCALLBARRINGTYPE("NCOS3");
		atrib2.setOCSI("CBIO_TEST_2");
		List<FtthServiceInternetType> lst2 = new ArrayList<FtthServiceInternetType>();
		lst2.add(atrib2);
		
		FtthServiceType serv2 = new FtthServiceType(lst2);
		serv2.setIdentifier("SGA00000000000");
		serv2.setSubscriberIdentifier("40862684");
		serv2.setServiceType("Internet_FTTH_200M_40M");
		DeviceType child2 = new DeviceType(null);
		child2.setIdentifier("1559230423870522");
		child2.setType("HG8245Q2");
		serv2.setDevice(child2);
		
		System.out.println("TELEFONIA  FTTH "+gson.toJson(serv2));
		
		System.out.println("----------------------------------------------------------------");
		
		FtthServiceInternetType atrib3 = new FtthServiceInternetType();
		//HfcInternetAttributesType atrib3 = new HfcInternetAttributesType();
		atrib3.setHFCNODE("LAMO004");
		atrib3.setHUB("Hub Camacho");
		atrib3.setCPEPOOL("cpe");
		atrib3.setMAXCPE("2");
		atrib3.setSTATICIPCOUNT("1");
		List<FtthServiceInternetType> lst3 = new ArrayList<FtthServiceInternetType>();
		lst3.add(atrib3);
		
		FtthServiceType serv3 = new FtthServiceType(lst3);
		serv3.setIdentifier("SGA00000000000");
		serv3.setSubscriberIdentifier("14682115");
		serv3.setServiceType("Infinitum_12M_2M");
		DeviceType child3 = new DeviceType(null);
		child3.setIdentifier("99999999999");
		child3.setType("FAST3686v2 CM");
		serv3.setDevice(child3);
		
		System.out.println("INTERNET  HFC  "+gson.toJson(serv3));
		
		System.out.println("----------------------------------------------------------------");
		
		
		FtthServiceInternetType atrib4 = new FtthServiceInternetType();
		//FtthServiceTelefoniaType atrib4 = new FtthServiceTelefoniaType();
		atrib4.setCALLFEATURES("S");
		atrib4.setTELEPHONYPHONENUMBER("4628816");
		atrib4.setMTAPORT("1");
		atrib4.setVOICENODE("LIM");
		atrib4.setISCENTREXENABLED("NO");
		atrib4.setCALLBARRINGTYPE("NCOS3");
		List<FtthServiceInternetType> lst4 = new ArrayList<FtthServiceInternetType>();
		lst4.add(atrib4);
		
		FtthServiceType serv4 = new FtthServiceType(lst4);
		serv4.setIdentifier("SGA00000000000");
		serv4.setSubscriberIdentifier("14682115");
		serv4.setServiceType("Telefonia_Suplemento");
		DeviceType child4 = new DeviceType(null);
		child4.setIdentifier("50:39:55:14:3A:78:98");
		child4.setType("HG8245Q2DPC2425R2 MTA");
		ChildType chl = new ChildType();
		chl.setIdentifier("50:39:55:14:3A:99");
		chl.setType("DPC2425R2 CM");
		child4.setChild(chl);
		serv4.setDevice(child4);
		
		System.out.println("TELEFONIA  HFC  "+gson.toJson(serv4));
		
		System.out.println("----------------------------------------------------------------");
		

		FtthServiceInternetType atrib5 = new FtthServiceInternetType();
		//TvSSAttributesType atrib5 = new TvSSAttributesType();
		atrib5.setDTVNODE("PAPROV_DSP");
		atrib5.setDTVCHANNELMAP("DTA");
		atrib5.setDTVHEADEND("VES_DSP");
		
		List<FtthServiceInternetType> lst5 = new ArrayList<FtthServiceInternetType>();
		lst5.add(atrib5);
		
		FtthServiceType serv5 = new FtthServiceType(lst5);
		serv5.setIdentifier("TV00001");
		serv5.setSubscriberIdentifier("14682115");
		serv5.setServiceType("Migra2");
		TvSSDeviceAttributesType devTV = new TvSSDeviceAttributesType();
		devTV.setHOSTUNITADDRESS("0000028215937074");
		List<TvSSDeviceAttributesType> lstdevTV = new ArrayList<TvSSDeviceAttributesType>();
		lstdevTV.add(devTV);
		DeviceType child5 = new DeviceType(lstdevTV);
		child5.setIdentifier("A91505EQA970");
		child5.setType("DCX3400");
		
		serv5.setDevice(child5);
		
		System.out.println("TV  HFC  "+gson.toJson(serv5));
		
		System.out.println("----------------------------------------------------------------");
		

		
	}

}
