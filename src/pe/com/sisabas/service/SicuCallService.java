package pe.com.sisabas.service;

import java.rmi.RemoteException;

import org.apache.log4j.Logger;

import javax.jws.WebMethod;
import javax.jws.WebParam;

import pe.com.sisabas.exception.SecuritySessionExpiredException;
import pe.com.sisabas.exception.SecurityValidateException;
import pe.com.sisabas.exception.ValidateException;

import pe.com.sisabas.resources.Constantes;
import pe.com.sisabas.resources.Utils;

import pe.com.sisabas.resources.Utils;
import pe.com.sisabas.resources.Constantes;


public class SicuCallService {
  
  private static Logger logger=Logger.getLogger(SicuCallService.class);
  
  private static String       seguridad_ip = Constantes.getString("seguridad.ip");	
  private static final String endpoint     = "http://"+seguridad_ip+":8888/services/SicuSecurityService";
  
  private static pe.com.sisabas.service.Sicuusuario sicuusuario = null;
  private static pe.com.sisabas.service.SicuSecurityServiceProxy sampleSicuSecurityServiceProxyid = new pe.com.sisabas.service.SicuSecurityServiceProxy();
  private static pe.com.sisabas.service.Sicurespuesta sicurespuesta = null;
  
  public SicuCallService()
  {
  }
  
  
  public static Sicuusuario login(String usuario, String clave, String sistema, String ipuser) throws Exception{
	   sampleSicuSecurityServiceProxyid.setEndpoint(endpoint);	  
		try {
			  sicuusuario = sampleSicuSecurityServiceProxyid.login(usuario, clave ,sistema , ipuser);
			  logger.debug("login: Usuario:"+usuario+" Clave:"+clave+" Sistema:"+sistema+" IP:"+ipuser);
			  logger.debug(sicuusuario);
		      
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			//logger.error(Utils.getStackTrace(e));
			throw e;
		}
	  
	  return sicuusuario;
  }

  
  
  public static Sicurespuesta logout()throws Exception{
	   sampleSicuSecurityServiceProxyid.setEndpoint(endpoint);
	  
		try {
			  System.out.println("logout...");
			  Sicuusuario sicuusuario  = (Sicuusuario)Utils.getHttpSession().getAttribute("sicuusuarioSESSION");
			  if(sicuusuario!=null){
				  sicurespuesta = sampleSicuSecurityServiceProxyid.logout(sicuusuario.getVchsessionid());
				  logger.debug("logout: Session ID:"+sicuusuario.getVchsessionid());
				  logger.debug(sicurespuesta);
			  }else
				  throw new SecurityValidateException("No se encontró session activa, en el equipo local.");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			//logger.error(Utils.getStackTrace(e));
			throw e;
		}
	  
	  return sicurespuesta;
  }
  
  

  public static Sicurespuesta solicitarCambioDeClave(String usuario)throws Exception{
	   sampleSicuSecurityServiceProxyid.setEndpoint(endpoint);
	  
		try {
			  sicurespuesta = sampleSicuSecurityServiceProxyid.solicitarCambioDeClave(usuario);
			  logger.debug("solicitarCambioDeClave: Usuario:"+usuario);
			  logger.debug(sicurespuesta);		
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			//logger.error(Utils.getStackTrace(e));
			throw e;
		}
	  
	  return sicurespuesta;
  }
  
  
  
  public static Sicurespuesta realizarCambioDeClave(String usuario, String codigocambio, String nuevaclave, String ipuser)throws Exception{
	   sampleSicuSecurityServiceProxyid.setEndpoint(endpoint);
	  
		try {
			  sicurespuesta = sampleSicuSecurityServiceProxyid.realizarCambioDeClave(usuario, codigocambio, nuevaclave, ipuser);
			  logger.debug("realizarCambioDeClave: Usuario:"+usuario+" Código de cambio:"+codigocambio+" Nueva Clave:"+codigocambio);
			  logger.debug(sicurespuesta);	
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			throw e;
		}
	  
	  return sicurespuesta;
  }  

  public static Sicurespuesta realizarCambioDeClaveApp(String usuario, String claveAnterior, String nuevaclave, String ipuser)throws Exception{
	   sampleSicuSecurityServiceProxyid.setEndpoint(endpoint);
	  
		try {
			  sicurespuesta = sampleSicuSecurityServiceProxyid.realizarCambioDeClaveApp(usuario, claveAnterior, nuevaclave, ipuser);
			  logger.debug("realizarCambioDeClaveApp: Usuario:"+usuario+" Clave anterior:"+claveAnterior+" Nueva Clave:");
			  logger.debug(sicurespuesta);	
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			throw e;
		}
	  
	  return sicurespuesta;
 }  
  
  
  public static Integer obtenerIdOpcion(String idOpcionText)throws Exception{
	  sampleSicuSecurityServiceProxyid.setEndpoint(endpoint);	  
	  Integer idOpcionNumerico = null;
		try {
			idOpcionNumerico = sampleSicuSecurityServiceProxyid.obtenerIdOpcion(idOpcionText);			
			logger.debug("obtenerIdOpcion: Opción:"+idOpcionText);
			logger.debug(idOpcionNumerico);			  
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			//logger.error(Utils.getStackTrace(e));
			throw e;
		}
		if(idOpcionNumerico==null)
			throw new SecurityValidateException("No se ubicó código de opción:"+idOpcionText);
		
	  return idOpcionNumerico;
  }
 

  public static Sicuopcion obtenercontroles(String opcion)throws Exception{
      pe.com.sisabas.service.Sicuopcion sicuopcion = null;
	  sampleSicuSecurityServiceProxyid.setEndpoint(endpoint);
	  
		try {
			  Sicuusuario sicuusuario  = (Sicuusuario)Utils.getHttpSession().getAttribute("sicuusuarioSESSION");
			  sicuopcion = sampleSicuSecurityServiceProxyid.obtenercontroles(sicuusuario.getVchsessionid(), opcion);
			  logger.debug("obtenercontroles: Opción:"+opcion);
			  logger.debug(sicuopcion);
			  
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			//logger.error(Utils.getStackTrace(e));
			throw e;
		}
	  
	  return sicuopcion;
  }    
  
  
  public static Sicurespuesta validarControl(String opcion, String control) throws Exception{
	   	sampleSicuSecurityServiceProxyid.setEndpoint(endpoint);
	  
		try {
			  Sicuusuario sicuusuario  = (Sicuusuario)Utils.getHttpSession().getAttribute("sicuusuarioSESSION");
			  sicurespuesta = sampleSicuSecurityServiceProxyid.validarControl(sicuusuario.getVchsessionid(), opcion, control);			  
			  logger.debug("validarControl: Opción:"+opcion+" Control:"+control);
			  logger.debug(sicurespuesta);
			  validarCodigoDeRespuesta(sicurespuesta);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			//logger.error(Utils.getStackTrace(e));
			throw e;
		}
	  
	  return sicurespuesta;
  }    
  
  
  public static void validarCodigoDeRespuesta(Sicurespuesta sicurespuesta)throws SecuritySessionExpiredException{
	  if(sicurespuesta.getVchmensaje()!=null){
			String sicuErrorCode=Utils.getSecurityErrorCode(sicurespuesta.getVchmensaje());
			if(!sicuErrorCode.equalsIgnoreCase("FORMATO_INCORRECTO")){
				if(sicuErrorCode.equalsIgnoreCase("201")){//sessionid delogeado
					//Ejecutar el delogeo
					logger.debug("SICU LOGOUT...");
					throw new SecuritySessionExpiredException(sicurespuesta.getVchmensaje());
				}
			}else{
				
			}
		}
  }
 

  public static Sicurespuesta actualizarfecacceso(String par_vchsessionid)throws Exception{
	   sampleSicuSecurityServiceProxyid.setEndpoint(endpoint);
	  
		try {
			  
			  sicurespuesta = sampleSicuSecurityServiceProxyid.actualizarfecacceso(par_vchsessionid);
			  logger.debug("actualizarfecacceso: par_vchsessionid:"+par_vchsessionid);
			  logger.debug(sicurespuesta);
			  validarCodigoDeRespuesta(sicurespuesta);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			//logger.error(Utils.getStackTrace(e));
			throw e;
		}
	  
	  return sicurespuesta;
  }
  
  public static Sicurespuesta registraractividad(String sessionid, String opcion, String control, String result, String param, String tipoexcepion, String message, String stacktrace) throws Exception{
	  sampleSicuSecurityServiceProxyid.setEndpoint(endpoint);
	  
		try {
			  
			  sicurespuesta = sampleSicuSecurityServiceProxyid.registraractividad(sessionid, opcion, control, result, param, tipoexcepion, message, stacktrace);
			  logger.debug("registraractividad: par_vchsessionid:"+sessionid);
			  logger.debug(sicurespuesta);
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			logger.error(Utils.getStackTrace(e));
			throw e;
		}
	  
	  return sicurespuesta;
  }
  
}