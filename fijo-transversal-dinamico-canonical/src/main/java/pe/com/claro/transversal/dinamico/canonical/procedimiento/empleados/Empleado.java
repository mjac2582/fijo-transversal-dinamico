package pe.com.claro.transversal.dinamico.canonical.procedimiento.empleados;

import java.io.Serializable;

import pe.com.claro.transversal.dinamico.canonical.comun.ws.bean.AnotaEntidad;





public class Empleado implements Serializable {

	private static final long serialVersionUID = 1L;

	// campo 1
	@AnotaEntidad(campoBD = "IDEMPLEADO") //campo de Tabla
	private int idemp;
	
	// campo 2
	@AnotaEntidad
	private String nombre;    //campo de Tabla
	
	// campo 3
	@AnotaEntidad(campoBD = "APELLIDOS")   //campo de Tabla
	private String ape;
	
	// campo 4
	@AnotaEntidad
	private int edad;   //campo de Tabla
	
	//---------------------------------------------------------
	
	public int getIdemp() {
		return idemp;
	}
	public void setIdemp(int idemp) {
		this.idemp = idemp;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApe() {
		return ape;
	}
	public void setApe(String ape) {
		this.ape = ape;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	
	
}
