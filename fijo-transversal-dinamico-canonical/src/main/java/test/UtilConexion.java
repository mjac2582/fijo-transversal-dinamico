package test;

import java.sql.Connection;
import java.sql.DriverManager;

public class UtilConexion {
	public static final synchronized Connection getCon() {
		try {
			 //Se carga el driver JDBC
	        DriverManager.registerDriver( new oracle.jdbc.driver.OracleDriver() );
	         
	        //nombre del servidor
	        String nombre_servidor = "172.19.74.104";
	        //numero del puerto
	        String numero_puerto = "1521";
	        //SID
	        String sid = "SGADBUAT";
	        //URL "jdbc:oracle:thin:@nombreServidor:numeroPuerto:SID"
	        String url = "jdbc:oracle:thin:@" + nombre_servidor + ":" + numero_puerto + ":" + sid;
	
	        //Nombre usuario y password
//	        String usuario = "proceso";
//	        String password = "123456";
	        String usuario = "it_consulta";
	        String password = "it_consulta2011";
	
	        //Obtiene la conexion
	        Connection conexion = DriverManager.getConnection( url, usuario, password );
	        return conexion;
		}catch(Exception e) {
			return null;
		}
	}
}
