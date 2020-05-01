package pe.com.claro.transversal.dinamico.resource.config;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import pe.com.claro.transversal.dinamico.resource.util.ConstanteLocal;
 
@Configuration
@PropertySource("file:"+ConstanteLocal.CLARO_PROPERTIES+
		ConstanteLocal.PATHAPP_VENTA+ConstanteLocal.ARCHIVO_PROPERTIES)
public class AppConfig {
	
	private static final Logger logger = Logger.getLogger(AppConfig.class);
 
    @Bean 
    public ConstantesExternas constantesExternas() {
    	logger.info("constantesExternas ");
        return new ConstantesExternas();
    }
 
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
    	logger.info("propertySourcesPlaceholderConfigurer ");
        return new PropertySourcesPlaceholderConfigurer();
    }
}
