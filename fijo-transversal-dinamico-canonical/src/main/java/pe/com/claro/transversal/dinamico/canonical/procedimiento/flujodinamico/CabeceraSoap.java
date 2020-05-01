package pe.com.claro.transversal.dinamico.canonical.procedimiento.flujodinamico;

import pe.com.claro.transversal.dinamico.canonical.comun.ws.bean.AnotaEntidad;

public class CabeceraSoap {
	@AnotaEntidad(orden=1)
	private int procesoorden;
	
	@AnotaEntidad(orden=2)
	private String registratransaccion;
	
	@AnotaEntidad(orden=3)
	private String abreviatura;
	
	@AnotaEntidad(orden=4)
	private int reintentos;
	
	@AnotaEntidad(orden=5)
	private int idprocesoerror;
	
	@AnotaEntidad(orden=6)
	private String ruta;
	
	@AnotaEntidad(orden=7)
	private String metodo;
	
	@AnotaEntidad(orden=8)
	private String timeout;
	
	@AnotaEntidad(orden=9)
	private String portname;
	
	@AnotaEntidad(orden=10)
	private String servicename;
	
	@AnotaEntidad(orden=11)
	private String targetnamespace;
	
	@AnotaEntidad(orden=12)
	private String binding;

	public int getProcesoorden() {
		return procesoorden;
	}

	public void setProcesoorden(int procesoorden) {
		this.procesoorden = procesoorden;
	}

	public String getRegistratransaccion() {
		return registratransaccion;
	}

	public void setRegistratransaccion(String registratransaccion) {
		this.registratransaccion = registratransaccion;
	}

	public String getAbreviatura() {
		return abreviatura;
	}

	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}

	public int getReintentos() {
		return reintentos;
	}

	public void setReintentos(int reintentos) {
		this.reintentos = reintentos;
	}

	public int getIdprocesoerror() {
		return idprocesoerror;
	}

	public void setIdprocesoerror(int idprocesoerror) {
		this.idprocesoerror = idprocesoerror;
	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public String getMetodo() {
		return metodo;
	}

	public void setMetodo(String metodo) {
		this.metodo = metodo;
	}

	public String getTimeout() {
		return timeout;
	}

	public void setTimeout(String timeout) {
		this.timeout = timeout;
	}

	public String getPortname() {
		return portname;
	}

	public void setPortname(String portname) {
		this.portname = portname;
	}

	public String getServicename() {
		return servicename;
	}

	public void setServicename(String servicename) {
		this.servicename = servicename;
	}

	public String getTargetnamespace() {
		return targetnamespace;
	}

	public void setTargetnamespace(String targetnamespace) {
		this.targetnamespace = targetnamespace;
	}

	public String getBinding() {
		return binding;
	}

	public void setBinding(String binding) {
		this.binding = binding;
	}
	
	
	
}
