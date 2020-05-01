package pe.com.claro.transversal.dinamico.canonical.comun.ws;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanMap;
import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.dialect.OracleTypesHelper;

import com.google.gson.Gson;

import pe.com.claro.transversal.dinamico.canonical.comun.ws.bean.AnotaCampo;
import pe.com.claro.transversal.dinamico.canonical.comun.ws.bean.AnotaEntidad;
import pe.com.claro.transversal.dinamico.canonical.comun.ws.bean.AnotaProcedure;
import pe.com.claro.transversal.dinamico.canonical.comun.ws.bean.Campo;
import pe.com.claro.transversal.dinamico.canonical.comun.ws.bean.HeadProcedimiento;
import pe.com.claro.transversal.dinamico.canonical.comun.ws.bean.Parametros;
import pe.com.claro.transversal.dinamico.canonical.comun.ws.bean.TipoDato;




public class UtilProcedimiento {
	
	public static Connection conex;
	
	public static final synchronized <T> T  execProcedimiento(T l) {
		//T lx0 = null;
		try {
			//lx0 = (T) l.newInstance();
		} catch (Exception e) {
			//System.out.println("Error 0="+e);
			//e.printStackTrace();
		}
		return consumeProcedimiento(l);
	}

	
	public static final synchronized <T> T  consumeProcedimiento(T lx0) {
			HeadProcedimiento lx000 = ejecutaProcedimiento(lx0);
			
			if(lx000.getNombre()!=null && !lx000.getNombre().isEmpty()) {
				
				String lx000x0 = null;
				
				if(lx000.getLstParametros()!=null && !lx000.getLstParametros().isEmpty()) {
					//Conteo de parametros
					int numParam = lx000.getLstParametros().size();
					String mask = maskParam(numParam);
					
					lx000x0 = "call " + lx000.getNombre() + " "+mask;
					
					////System.out.println("SP=="+lx000x0);
					
					lx0 = consumoSPGeneral(lx000x0,10000, lx000.getLstParametros(),lx0);
				}
				
			}
			return lx0;
	}
	
	public static final synchronized  HeadProcedimiento ejecutaProcedimiento(Object lx0) {
		Class<?> lx0x2 = lx0.getClass();
		
		HeadProcedimiento proced = null;
		boolean lx00vh = validaAnotaciones( lx0x2);
		if(lx00vh) {
			 proced = new HeadProcedimiento();
			String nomProc = obtenerNomProcedimiento(lx0x2);
			 List<Parametros> lst =  obtenerParamProcedimiento(lx0);
			 proced.setNombre(nomProc);
			 proced.setLstParametros(lst);
		}
		return proced;
	} 
	
	public static final synchronized String maskParam(int lx0) {
		String lxm=null;
		List<String> lx00 = new ArrayList<String>();
		
		for(int i=0; i<lx0; i++) {
			lx00.add("?");
		}
		lxm = lx00.toString();
		lxm=lxm.substring(1,lxm.length()-1);
		lxm="("+lxm+")";
		
		return lxm;
	}
	
	public static final synchronized <T> T consumoSPGeneral(String lx0, int timeout, List<Parametros> lxParam, T lx000) {
		boolean ejecuto=false;
		Gson gson =new Gson();
		Connection conexion  = conex ;
		List<T> lstDet = null;	
		try {
			CallableStatement call = conexion.prepareCall(lx0);
			call.setQueryTimeout(timeout);
			for(Parametros pm : lxParam) {
				////System.out.println("P__M="+gson.toJson(pm));
				if(pm.getTipoInOut()==1) {
					if(pm.getValor()!=null && !pm.getValor().equals("null") ) {
						//System.out.println("VALOR 1="+pm.getValor());
						switch(pm.getTipoDato()) {
							case TipoDato.VARCHAR: case TipoDato.CHAR: 	call.setString(pm.getOrden(), pm.getValor());	break;
							case TipoDato.FLOAT: 	call.setFloat(pm.getOrden(), new Float(pm.getValor()));	break;
							case TipoDato.NUMERIC: 	call.setInt(pm.getOrden(), new Integer(pm.getValor()));	break;
							case TipoDato.DATE: 	call.setDate(pm.getOrden(), new Date(new Long(pm.getValor())));	break;
							case TipoDato.TIME:		call.setTime(pm.getOrden(), new Time(new Long(pm.getValor()))); break;
							case TipoDato.TIMESTAMP:	call.setTimestamp(pm.getOrden(), new Timestamp(new Long(pm.getValor())) ); break;
							default: call.setString(pm.getOrden(), pm.getValor());	
						}
						
					}else {
						////System.out.println("VALOR 2="+pm.getOrden());
						call.setNull(pm.getOrden(), TipoDato.NULL);
					}
				}
				
				if(pm.getTipoInOut()==2) {
					////System.out.println("pm.getOrden()="+pm.getOrden()+", pm.getTipoDato()");
					
					if(pm.getTipoDato()==TipoDato.REF_CURSOR_ORACLE) {
						call.registerOutParameter(pm.getOrden(), OracleTypesHelper.INSTANCE.getOracleCursorTypeSqlType());
					}else {
						call.registerOutParameter(pm.getOrden(), pm.getTipoDato()); 
					}
					
					
				}
			}
			
			ejecuto = call.execute();
			
			if(lxParam!=null && !lxParam.isEmpty()) {
				for(Parametros pmx : lxParam) {
					
					//System.out.println("PXM="+gson.toJson(pmx));
					
					if(pmx.getTipoInOut()==2) {
						//System.out.println("pmx.getTipoObj()="+pmx.getTipoObj());
						if(pmx.getTipoObj()==null || pmx.getTipoObj().equals("O")) {
							try {
								String dato = call.getString(pmx.getOrden());
								BeanUtils.setProperty(lx000, pmx.getNombre(), dato);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}else { 
							if(pmx.getTipoObj().equals("L")){
								ResultSet rs = (ResultSet) call.getObject(pmx.getOrden());
								
								////System.out.println(pmx.getOrden()+"  RS="+rs);
								
								Class<?> objClas = null;
								try {
									objClas =  Class.forName(pmx.getClase());
								} catch (ClassNotFoundException e) {
									e.printStackTrace();
								}
								
								//System.out.println(" objClas---="+objClas);
								
								lstDet = new ArrayList<T>();
								while (rs.next()) {
										
									//System.out.println("pmx.getLstCampos()pmx.getLstCampos()="+gson.toJson(pmx.getLstCampos()));
									
										try {
											Object oo = objClas.newInstance();
												for(Campo cmp :pmx.getLstCampos()) {
													if( cmp.getClase()!=null &&  !cmp.getClase().equals("serialVersionUID")) {
														
														//System.out.println("cmp.getClase()-->"+cmp.getClase());
														String dt = "";
														if(cmp.getOrden()>0) {
															dt = rs.getString(cmp.getOrden());
														}else if(cmp.getTabla().trim().length()>0) {
															dt = rs.getString(cmp.getTabla());
															
														}else {
															dt = rs.getString(cmp.getClase());
														}
														
														//System.out.println("cmp.getClase()="+cmp.getClase()+", DTTTT="+dt);
														
														BeanUtils.setProperty(oo, cmp.getClase(), dt);
													}
												}
											lstDet.add((T) oo);
										} catch (Exception e) {
											//System.out.println("Error 10="+e);
											//e.printStackTrace();
										}
								}
								
								//System.out.println("pmx.getNombre()="+pmx.getNombre()+", LLLSSSTT="+gson.toJson(lstDet));
								
								try {
									BeanUtils.setProperty(lx000, pmx.getNombre(), lstDet);
								} catch (Exception e) {
									//System.out.println("Error 20="+e);
									//e.printStackTrace();
								}
							}
							
							
						}
						
					}
				}
			}
			
		} catch (SQLException e) {
			
			//System.out.println("Error 30="+e);
			e.printStackTrace();
		}
		
		return lx000;
		
	}

	
	public static final synchronized String obtenerNomProcedimiento(Class<?> lx00) {
		String lx00NH = null;
		AnotaProcedure lx000AH = lx00.getAnnotation(AnotaProcedure.class);
		if (lx000AH != null) {
			try {
				lx00NH = lx000AH.nomProcedimiento();
			} catch (Exception mtex) {
				//System.out.println("Error 2="+mtex);
				mtex.printStackTrace();
			}
		}
		return lx00NH;
	}
	
	public static final synchronized <T>  List<T> obtenerParamProcedimiento(Object lx000){
		Gson gson = new Gson();
		
		////System.out.println("Json="+gson.toJson(lx000));
		
		Map<Object, Object> beanMap = new BeanMap(lx000);
		Class<?> clas = lx000.getClass();
		
		final Field[] lx0VH = clas.getDeclaredFields();
		List<Parametros> lxtP00 = new ArrayList<Parametros>();
		
		for (final Field variable : lx0VH) {
			Parametros lpx00m = new Parametros();
			
			//System.out.println("variable="+variable);
			
			if(!variable.getName().equals("serialVersionUID")) {
			
				lpx00m.setNombre(variable.getName());
				String val = String.valueOf(beanMap.get(variable.getName()));
				lpx00m.setValor(val);
				
				final Annotation anotacionObtenida = variable.getAnnotation(AnotaCampo.class);
	
				if (anotacionObtenida != null && anotacionObtenida instanceof AnotaCampo) {
					final AnotaCampo anotacionProc1 = (AnotaCampo) anotacionObtenida;
					int tipodato =  anotacionProc1.tipoDato();
					int tipoInOut = anotacionProc1.tipoInOut();
					int orden = anotacionProc1.orden();
					
					lpx00m.setTipoDato(tipodato);
					lpx00m.setTipoInOut(tipoInOut);
					lpx00m.setOrden(orden);
					
					if(tipodato==TipoDato.REF_CURSOR_JDBC ||  tipodato==TipoDato.REF_CURSOR_ORACLE ) {
						String lxpx0 = variable.getGenericType().toString();
						
						if(lxpx0.indexOf("List")!= -1) {
							lxpx0= lxpx0.substring(lxpx0.lastIndexOf("<")+1, lxpx0.length()-1).trim();
							lpx00m.setTipoObj("L");
						}else {
							
							lxpx0= lxpx0.substring(lxpx0.lastIndexOf(" "), lxpx0.length()).trim();
							lpx00m.setTipoObj("O");
						}
						
						List<Campo> lstCmp = obtieneCampos(lxpx0);
						lpx00m.setLstCampos(lstCmp);
						lpx00m.setClase(lxpx0);
					}
					
					//System.out.println("PARAM FINAL="+gson.toJson(lpx00m));
					
					lxtP00.add(lpx00m);
				}
				
			
			}
			
		}
		
		return (List<T>) lxtP00;
	}
	
	public static final synchronized List<Campo> obtieneCampos(String lx00) {
		
		List<Campo> lstCampos = new ArrayList<Campo>();
		try {
			Object c =  Class.forName(lx00).newInstance();
			 
			final Field[] lx0VH = c.getClass().getDeclaredFields();
			for (final Field lx0v0 : lx0VH) {
				Campo campo = new Campo();
				int orden=0;
				String cp = lx0v0.getName();
				
				
				final Annotation anotacionObtenida = lx0v0.getAnnotation(AnotaEntidad.class);
				
				//System.out.println("anotacionObtenida="+anotacionObtenida);
				
				if (anotacionObtenida != null && anotacionObtenida instanceof AnotaEntidad) {
					campo.setClase(cp);
					
					final AnotaEntidad anotaField = (AnotaEntidad) anotacionObtenida;
					String dt = anotaField.campoBD();
					cp = dt;
					orden = anotaField.orden();
					
					campo.setTabla(cp);
					campo.setOrden(orden);
					lstCampos.add(campo);
				}
				
			}
		}catch(Exception e) {
			//System.out.println("Error 3.0="+e);
			//e.printStackTrace();
		}
		return lstCampos;
	}

	private static boolean validaAnotaciones(Class<?> lx00) {
		boolean lx0VH = lx00.isAnnotationPresent(AnotaProcedure.class);
		return lx0VH;
	}
	
	public static Connection getConex() {
		return conex;
	}


	public static void setConex(Connection conex) {
		UtilProcedimiento.conex = conex;
	}
	
	
}
