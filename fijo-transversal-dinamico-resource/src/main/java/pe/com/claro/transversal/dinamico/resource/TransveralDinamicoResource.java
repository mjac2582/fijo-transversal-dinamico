package pe.com.claro.transversal.dinamico.resource;


import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.ejb.EJB;
import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.wordnik.swagger.annotations.ApiParam;

import pe.com.claro.transversal.dinamico.canonical.comun.bean.ReqResTransporte;
import pe.com.claro.transversal.dinamico.canonical.comun.bean.ReqResTransporteBase;
import pe.com.claro.transversal.dinamico.canonical.comun.exception.WSException;
import pe.com.claro.transversal.dinamico.canonical.comun.property.Constantes;
import pe.com.claro.transversal.dinamico.canonical.header.HeaderRest;
import pe.com.claro.transversal.dinamico.canonical.procedimiento.configuraciones.ConfiguracionProcedimiento;
import pe.com.claro.transversal.dinamico.canonical.procedimiento.configuraciones.bean.ObtenerConfiguracionesRequest;
import pe.com.claro.transversal.dinamico.canonical.procedimiento.configuraciones.bean.ObtieneConfiguracionesResponse;
import pe.com.claro.transversal.dinamico.canonical.procedimiento.contenido.ContenidoProcedimiento;
import pe.com.claro.transversal.dinamico.canonical.procedimiento.contenido.ContenidoSoap;
import pe.com.claro.transversal.dinamico.canonical.procedimiento.empleados.Empleado;
import pe.com.claro.transversal.dinamico.canonical.procedimiento.empleados.EmpleadoProcedimento;
import pe.com.claro.transversal.dinamico.canonical.types.ftth.type.base.AccountResponseType;
import pe.com.claro.transversal.dinamico.canonical.types.ftth.type.base.AccountType;
import pe.com.claro.transversal.dinamico.canonical.types.ftth.type.base.ErrorResponse;
import pe.com.claro.transversal.dinamico.client.service.DinamicoService;
import pe.com.claro.transversal.dinamico.domain.service.DinamicoServiceImpl;
import pe.com.claro.transversal.dinamico.resource.config.BaseServicio;
import pe.com.claro.transversal.dinamico.resource.config.ConstantesExternas;
import pe.com.claro.transversal.dinamico.resource.util.ConstanteLocal;

import net.sf.json.JSON;
import net.sf.json.JSONSerializer;

//Stateless
@Path(ConstanteLocal.PATHSERVICIO_VENTA)
@Consumes(value= MediaType.APPLICATION_JSON)
@Produces(value = MediaType.APPLICATION_JSON)
public class TransveralDinamicoResource extends BaseServicio {
	
	private static final Logger logger = Logger.getLogger(TransveralDinamicoResource.class);
	
	@EJB
	private DinamicoService clienteRest;
	
	private static ConstantesExternas  propiedadesExternas;
	
	public TransveralDinamicoResource() {
		logger.info("Carga las propiedades Externas.");
		propiedadesExternas = cargaProperties(ConstantesExternas.class);
		
		logger.info("restIncognitoCreaCuentaUrl="+propiedadesExternas.restIncognitoCreaCuentaUrl);
		logger.info("restIncognitoReconexionUrl="+propiedadesExternas.restIncognitoReconexionUrl);
	}
	
	
	@GET
	 public Response obtenerProp() {
		logger.info("obtenerProp.");
		AccountType cuenta = new AccountType();
		
		logger.info("OK==="+propiedadesExternas.restIncognitoCreaCuentaUrl);
		
		String ruta = new File ("").getAbsolutePath ();
		ruta=ruta+"/tmp";
		logger.info("ruta="+ruta);
		
		String Recurso = TransveralDinamicoResource.class.getSimpleName() + ".class";
	    URL url = TransveralDinamicoResource.class.getResource(Recurso);
	    System.out.println("getPath=====>"+url.getPath());
	    ruta=url.getPath();
		
		
		try {
		
			String source = "package test; public class Test { static { System.out.println(\"hello\"); } public Test() { System.out.println(\"world\"); } }";
	
			// Save source in .java file.
			File root = new File(ruta); // On Windows running on C:\, this is C:\java.
			File sourceFile = new File(root, "test/Test.java");
			sourceFile.getParentFile().mkdirs();
			Files.write(sourceFile.toPath(), source.getBytes(StandardCharsets.UTF_8));
	
			// Compile source file.
			JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
			compiler.run(null, null, null, sourceFile.getPath());
	
			// Load and instantiate compiled class.
			URLClassLoader classLoader = URLClassLoader.newInstance(new URL[] { root.toURI().toURL() });
			Class<?> cls = Class.forName("test.Test", true, classLoader); // Should print "hello".
			Object instance = cls.newInstance(); // Should print "world".
			logger.info(instance); // Should print "test.Test@hashcode".
		}catch(Exception e) {
			logger.error(e);
		}
		
		
		
		try {
			logger.info("Servicio GET----97- ");
			
			cuenta.setIdentifier(propiedadesExternas.restIncognitoCreaCuentaUrl);
			logger.info("Servicio GET----- 3");
			cuenta.getSubscribers();
	        
	        logger.info("Servicio GET----97- Fin");
		}catch(Exception e) {
			logger.error("Error="+e);
		}
		
	 return Response.ok(cuenta).build();
	 }
	

	@POST
	@Path(ConstanteLocal.PATHSERVICIO_CONFIGURACIONES)
   public Response ejecutaWsSoap(@Context HttpHeaders httpHeaders, 
		   @ApiParam(value = "El objeto request", required = true) ObtenerConfiguracionesRequest request)  {
		
		HeaderRest header = obtenerHeader(httpHeaders, HeaderRest.class);
		List<String> lsVal = header.validaClase();
		
		if(lsVal!=null && !lsVal.isEmpty()) {
			ReqResTransporteBase base= new ReqResTransporteBase(String.valueOf(Constantes.MENOS_UNO),
					Constantes.ERROR_VALIDACION, lsVal);
			
			return Response.status(Response.Status.BAD_REQUEST).entity(base).build();
		}
		
		ConfiguracionProcedimiento config = new  ConfiguracionProcedimiento(request.getIdProducto(), request.getIdTransaccion());
		
		try {
			ObtieneConfiguracionesResponse cfgResponse =clienteRest.obtieneConfiguraciones(config);
			
			return Response.ok().entity(cfgResponse).build();
		} catch (WSException e) {
			logger.error("ERROR="+e.getMessage());
			return Response.ok(Response.Status.SERVICE_UNAVAILABLE).entity(e).build();
		}
	}
	
	//ContenidoProcedimiento
	@POST
	@Path(ConstanteLocal.PATHSP_CONTENIDO)
   public Response obtenerContenido(@Context HttpHeaders httpHeaders, 
		   @ApiParam(value = "Obligatorio", required = true) ContenidoSoap request)  { 
		
		JSON jsemp = JSONSerializer.toJSON(request);
		logger.info("-------Contenido--------"+jsemp.toString());
		
		//HeaderType header = obtenerHeader(httpHeaders, HeaderType.class);
		HeaderRest header = obtenerHeader(httpHeaders, HeaderRest.class);
		List<String> lsVal = header.validaClase();
		JSON lstMsg = JSONSerializer.toJSON(lsVal);
		logger.info("-------Validado--------"+lstMsg.toString());
		JSON hd = JSONSerializer.toJSON(header);
		logger.info("-------Head--------"+hd.toString());
		
		try {
			ContenidoProcedimiento con = new ContenidoProcedimiento();
			con.setClase(request.getClase());
			 con =clienteRest.ejecutaProcedimientoSesion(con);
			
			return Response.ok("0").entity(con).build();
		} catch (WSException e) {
			logger.error("ERROR="+e.getMessage());
			return Response.ok("-1").entity(e).build();
		}
	}
	
	@POST
	@Path(ConstanteLocal.PATHSP_EMPLEADOS)
   public Response consultarSPEmpleado(@Context HttpHeaders httpHeaders, 
		   @ApiParam(value = "El objeto request", required = true) Empleado request)  { 
		
		if(clienteRest==null) { 
			logger.info("clienteRest  Era NULO.");
			  clienteRest = new DinamicoServiceImpl();
			}
		
		JSON jsemp = JSONSerializer.toJSON(request);
		logger.info("-------Empelado--------"+jsemp.toString());
		
		//HeaderType header = obtenerHeader(httpHeaders, HeaderType.class);
		HeaderRest header = obtenerHeader(httpHeaders, HeaderRest.class);
		List<String> lsVal = header.validaClase();
		JSON lstMsg = JSONSerializer.toJSON(lsVal);
		logger.info("-------Validado--------"+lstMsg.toString());
		JSON hd = JSONSerializer.toJSON(header);
		logger.info("-------Head--------"+hd.toString());
		
		try {
			EmpleadoProcedimento emp = new EmpleadoProcedimento();
			 emp =clienteRest.ejecutaProcedimientoSesion(emp);
			
			return Response.ok("0").entity(emp).build();
		} catch (WSException e) {
			logger.error("ERROR="+e.getMessage());
			return Response.ok("-1").entity(e).build();
		}
	}
	
	
	@POST
	@Path(ConstanteLocal.PATHSERVICIO_CREARCUENTA)
   public Response crearCuenta(@Context HttpHeaders httpHeaders, 
		   @ApiParam(value = "El objeto request", required = true) AccountType request)  { 
		
		logger.info("-------crearCuenta--------1");
		JSON salida = null;
		if(clienteRest==null) { 
		  clienteRest = new DinamicoServiceImpl();
		}
		
		
		
		//HeaderType header = obtenerHeader(httpHeaders, HeaderType.class);
		HeaderRest header = obtenerHeader(httpHeaders, HeaderRest.class);
		
		List<String> lsVal = header.validaClase();
		JSON lstMsg = JSONSerializer.toJSON(lsVal);
		logger.info("-------Validado--------"+lstMsg.toString());
		
		JSON hd = JSONSerializer.toJSON(header);
		logger.info("-------Head--------"+hd.toString());
		
		
		@SuppressWarnings({ "rawtypes", "unchecked" })
		ReqResTransporte objReqResp = new ReqResTransporte(header, request,
				AccountResponseType.class, ErrorResponse.class);
		
		try {
			objReqResp = clienteRest.consumeRest(propiedadesExternas.restIncognitoCreaCuentaUrl,
					Constantes.POST, objReqResp);
			logger.info("-------crearCuenta--------2");
			
			 salida =  JSONSerializer.toJSON(objReqResp);
			
			logger.info("response1="+salida.toString());
			logger.info("-------crearCuenta--------3");	
			
			ReqResTransporteBase rpta;
			if(objReqResp.getBodyResponse()!=null)
				salida = JSONSerializer.toJSON(objReqResp.getBodyResponse());
			else {
				//rpta = new ReqResTransporteBase(objReqResp.getCodigoRespuesta(), objReqResp.getMensajeRespuesta());
				//salida = JSONSerializer.toJSON(rpta);
			}
			logger.info("response2="+salida);
			logger.info("-------crearCuenta--------4");	
			return Response.ok(objReqResp.getCodigoRespuesta()).entity(salida.toString()).build();
			
		} catch (WSException e) {
			logger.error("ERROR="+e.getMessage());
			return Response.ok().entity(e).build();
		}
		
	}
	

	

}
