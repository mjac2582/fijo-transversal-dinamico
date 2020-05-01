package pe.com.claro.transversal.dinamico.canonical.procedimiento.contenido;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import pe.com.claro.transversal.dinamico.canonical.comun.ws.bean.AnotaEntidad;





public class ContenidoSoap implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@AnotaEntidad
	  private int identificador;
	@AnotaEntidad
	  private int clase;
	@AnotaEntidad
	  private int padre;
	@AnotaEntidad
	  private String nombre;
	@AnotaEntidad
	  private String prefijo;
	@AnotaEntidad
      private String valor;
	@AnotaEntidad
      private String namespace;
      private List<ContenidoSoap> hijo;
 	
      public ContenidoSoap() {
    	  hijo = new ArrayList<ContenidoSoap>();
      }
      
      public ContenidoSoap( String nombre, String prefijo, String valor,String namespace) {
    	  this.nombre = nombre;
    	  this.prefijo = prefijo;
    	  this.valor = valor;
    	  this.namespace = namespace;
    	  hijo = new ArrayList<ContenidoSoap>();
      }
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPrefijo() {
		return prefijo;
	}
	public void setPrefijo(String prefijo) {
		this.prefijo = prefijo;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public List<ContenidoSoap> getHijo() {
		
		return hijo;
	}
	public void setHijo(List<ContenidoSoap> hijo) {
		this.hijo = hijo;
	}

	public String getNamespace() {
		return namespace;
	}

	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}

	public int getIdentificador() {
		return identificador;
	}

	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}

	public int getClase() {
		return clase;
	}

	public void setClase(int clase) {
		this.clase = clase;
	}

	public int getPadre() {
		return padre;
	}

	public void setPadre(int padre) {
		this.padre = padre;
	}
	
	
}
