package pe.com.claro.transversal.dinamico.canonical.comun.util;

public class CodigoFuncional {
	
  public static final String PREFIJO="HTTP";
	
	 /**
     * HTTP Codigo 100014: [user]Username {0} does not exist or is not valid for the selected service provider.
     */ 
  public static final String HTTP100014=" {0} no existe o no es valido.";
    
    /**
     * HTTP Codigo -1: Service Provider Incognito not known.
     */ 
  public static final String HTTPNOT1="Error Desconocido.";
   
    /**
     * HTTP Codigo 1113: User {0} has entered incorrect password.
     */ 
  public static final String HTTP1113="El Usuario {0} ha ingreso un password incorrecto.";
    
    /**
     * HTTP Codigo 100003: One or more Validation errors were detected.
     */ 
  public static final String HTTP100003="Se detectaron uno o más errores de validación";
    
    /**
     * HTTP Codigo 100008: Subscriber last name  must be populated / Account Number was not supplied.
     */ 
  public static final String HTTP100008="El apellido debe ser ingresado / Número de cuenta no ingresado";
    
    /**
     * HTTP Codigo 2520: Subscriber '{0}' already exists, can't create.
     */ 
  public static final String HTTP2520="'{0}' ya existe, no se puede crear o asociar.";
        
    /**
     * HTTP Codigo 100013: [Account]FTTH0006 already exists.
     */ 
  public static final String HTTP100013="Cuenta '{0}' ya existe";
    
    /**
     * HTTP Codigo 7: Exc Id: NO_RESPONSE_FROM_SERVER. Desc: The server SAC did not respond
     */ 
  public static final String HTTP7="El Servidor no responde.";

	public String getHTTP100014() {
		return HTTP100014;
	}

	public String getHTTPNOT1() {
		return HTTPNOT1;
	}

	public String getHTTP1113() {
		return HTTP1113;
	}

	public String getHTTP100003() {
		return HTTP100003;
	}

	public String getHTTP100008() {
		return HTTP100008;
	}

	public String getHTTP2520() {
		return HTTP2520;
	}

	public String getHTTP100013() {
		return HTTP100013;
	}

	public String getHTTP7() {
		return HTTP7;
	}

	public String getPREFIJO() {
		return PREFIJO;
	}

    
    
}
