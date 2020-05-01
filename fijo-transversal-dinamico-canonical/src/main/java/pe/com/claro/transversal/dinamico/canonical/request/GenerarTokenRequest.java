package pe.com.claro.transversal.dinamico.canonical.request;

import pe.com.claro.transversal.dinamico.canonical.comun.util.MappingClass;
import pe.com.claro.transversal.dinamico.canonical.comun.util.ValidadorNuloVacio;

public class GenerarTokenRequest extends MappingClass {
	
	@ValidadorNuloVacio( nulo=true, vacio=true )
	private String username;
	
	@ValidadorNuloVacio()
	private String password;
	
	@ValidadorNuloVacio()
	private String serviceProvider;
	
	@ValidadorNuloVacio()
	private String language;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getServiceProvider() {
		return serviceProvider;
	}

	public void setServiceProvider(String serviceProvider) {
		this.serviceProvider = serviceProvider;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
	
	public GenerarTokenRequest(GenerarTokenRequest httpBody) {
		super();
		this.username = httpBody.getUsername() != null ? httpBody.getUsername(): null;
		this.password = httpBody.getPassword() != null ? httpBody.getPassword(): null;
		this.serviceProvider = httpBody.getServiceProvider() != null ? httpBody.getServiceProvider(): null;
		this.language = httpBody.getLanguage() != null ? httpBody.getLanguage(): null;
	}

	public GenerarTokenRequest(){
		super();
	}

	@Override
	public String toString() {
		return "GenerarTokenRequest [username=" + username + ", password=" + password + ", serviceProvider="
				+ serviceProvider + ", language=" + language + "]";
	}

	
	
}
