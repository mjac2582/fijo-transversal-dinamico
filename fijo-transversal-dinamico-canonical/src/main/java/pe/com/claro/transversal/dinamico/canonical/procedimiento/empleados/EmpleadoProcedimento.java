package pe.com.claro.transversal.dinamico.canonical.procedimiento.empleados;

import java.io.Serializable;
import java.util.List;

import pe.com.claro.transversal.dinamico.canonical.comun.ws.bean.AnotaCampo;
import pe.com.claro.transversal.dinamico.canonical.comun.ws.bean.AnotaProcedure;
import pe.com.claro.transversal.dinamico.canonical.comun.ws.bean.TipoDato;
import pe.com.claro.transversal.dinamico.canonical.comun.ws.bean.TipoInOut;





@AnotaProcedure(nomProcedimiento = "datos_empleados") //package.procedimento
public class EmpleadoProcedimento implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@AnotaCampo(orden = 1, tipoDato = TipoDato.VARCHAR)	//entrada 1
	private String nom;
	
	@AnotaCampo(orden = 2, tipoDato = TipoDato.VARCHAR)	//entrada 2
	private String ape;
	
	//salida 3
	@AnotaCampo( orden = 3, 
				 tipoDato =  TipoDato.REF_CURSOR_ORACLE , 
				 tipoInOut = TipoInOut.OUT
				)
	private List<Empleado> lstEmpleados;
	
	
	
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getApe() {
		return ape;
	}
	public void setApe(String ape) {
		this.ape = ape;
	}
	public List<Empleado> getLstEmpleados() {
		return lstEmpleados;
	}
	public void setLstEmpleados(List<Empleado> lstEmpleados) {
		this.lstEmpleados = lstEmpleados;
	}
	
	
}
 