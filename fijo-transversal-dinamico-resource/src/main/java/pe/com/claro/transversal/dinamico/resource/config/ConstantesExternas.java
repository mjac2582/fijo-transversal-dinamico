package pe.com.claro.transversal.dinamico.resource.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConstantesExternas {
	    
	@Value("${rest.incognito.creacuenta.url}")
	public  String restIncognitoCreaCuentaUrl;

	@Value("${rest.url.api.internet}")
	public  String restIncognitoReconexionUrl;
	
	

}
