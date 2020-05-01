package test;

import java.sql.Connection;
import java.sql.DriverManager;

import com.google.gson.Gson;

import pe.com.claro.transversal.dinamico.canonical.comun.ws.UtilProcedimiento;
import pe.com.claro.transversal.dinamico.canonical.procedimiento.flujodinamico.SoapProcedimiento;


public class Prueba000 {

	public static void main(String[] args) {
		Gson gson = new Gson();
		SoapProcedimiento emp = new SoapProcedimiento();
		
		emp.setIdFlujo(202);
		emp.setIpProceso(361);
		
		UtilProcedimiento.conex = UtilConexion.getCon();
		 emp =UtilProcedimiento.execProcedimiento(emp);

		 System.out.println("JSON==="+gson.toJson(emp));
	}
	
	
	

}
