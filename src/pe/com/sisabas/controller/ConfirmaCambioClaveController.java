package pe.com.sisabas.controller;

import java.io.IOException;
import java.rmi.RemoteException;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import pe.com.sisabas.exception.ValidateException;
import pe.com.sisabas.resources.controller.BaseController;
import pe.com.sisabas.service.SicuCallService;
import pe.com.sisabas.service.Sicurespuesta;
import pe.com.sisabas.resources.Messages;
import pe.com.sisabas.resources.Utils;
import pe.com.sisabas.resources.UtilsSecurity;




@Component(value ="cambioclaveBean")
@Scope(value = "session")
public class ConfirmaCambioClaveController extends BaseController{

	@Autowired LoginController loginBean;
	
	private static final long serialVersionUID = 1L;
	private String user;
	private String codigocambio;
	private String nuevaclave;
	private String confirmaclave;
	
	private String claveAnterior;  //solo para cambio de clave por vigencia o a solicitud del usuario 


	private String modo = "CAM";  //CAM = CAMBIO DE CLAVE     LOG = IR A LOGIN
	
	public static String LOGIN="/";
	public static String ROLE_USER="user";
	public static String ROLE_MOBILE="userMobile";
	

	@PostConstruct
	public void init() {
		/* 2014-08-21 comentado
		user          = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("user");
		codigocambio  = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("aut");
        System.out.println(">>>>>>>>>>>>>>>>"+user);
        System.out.println(">>>>>>>>>>>>>>>>"+codigocambio);
        */
		 modo = "CAM"; 
	}
	

	public void initConfirmarClave() {
		/* 2014-08-21 comentado
		user          = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("user");
		codigocambio  = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("aut");
        System.out.println(">>>>>>>>>>>>>>>>"+user);
        System.out.println(">>>>>>>>>>>>>>>>"+codigocambio);
        */
		modo = "CAM"; 
		try {
			redirect("/confirmarCambioClave.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public void initCambioClave() {
		modo = "CAM"; 
		try {
			redirect("/cambioClave.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
	/*Por solicitud y envio de correo*/
	public String cambiarClave(){				
	
		try {
			if (!(nuevaclave.equals(confirmaclave))){
				throw new ValidateException("Error en confirmacion de clave");
			}
						
			String ipuser = UtilsSecurity.getRemoteAddr();
			
 			Sicurespuesta sicurespuesta = SicuCallService.realizarCambioDeClave(user, codigocambio, nuevaclave, ipuser );
			
			if (sicurespuesta!=null && sicurespuesta.getVchstatus().equalsIgnoreCase("OK")){
				
			}else{
				throw new ValidateException(sicurespuesta.getVchmensaje());
			}
		} catch (RemoteException e) {							
			addMessage(Messages.getString("sicu.remote.exeption"),e.getMessage(),
					FacesMessage.SEVERITY_ERROR);
			return "/solicitaCambioClave.xhtml";
		} catch (ValidateException e) {			
			addMessage(e.getMessage(),FacesMessage.SEVERITY_ERROR);
			return "/solicitaCambioClave.xhtml";		
		} catch (Exception e) {
			addErrorMessage(e);
			return "/confirmarCambioClave.xhtml";
			
		}		
		
		addMessage("Se modifico la clave correctamente.", FacesMessage.SEVERITY_INFO);
		modo = "LOG";  //CAM = CAMBIO DE CLAVE     LOG = IR A LOGIN
		
		return "/confirmarCambioClave.xhtml";
	}
	
	
	/*Por ingreso a opcion de cambio de clave, clave con fecha caducada o por cambio de fecha realizado por el administrador*/
	public String actualizarClave(){				
	
		try {
			if (!(nuevaclave.equals(confirmaclave))){
				throw new ValidateException("Error en confirmacion de clave");
			}
			
			if (loginBean!=null && loginBean.getUser()!=null){
				user = loginBean.getUser();
			}else{
				throw new ValidateException("Error en nombre de usuario...");
			}
			
			String claveAnteriorMD5 = Utils.getMD5(claveAnterior); //.toUpperCase();
			
			String ipuser = UtilsSecurity.getRemoteAddr();
			
 			Sicurespuesta sicurespuesta = SicuCallService.realizarCambioDeClaveApp(user, claveAnteriorMD5, nuevaclave, ipuser);
			
			if (sicurespuesta!=null && sicurespuesta.getVchstatus().equalsIgnoreCase("OK")){
				
			}else{
				throw new ValidateException(sicurespuesta.getVchmensaje());
			}
		} catch (RemoteException e) {							
			addMessage(Messages.getString("sicu.remote.exeption"),e.getMessage(),
					FacesMessage.SEVERITY_ERROR);
			return "/cambioClave.xhtml";
		} catch (ValidateException e) {			
			addMessage(e.getMessage(),FacesMessage.SEVERITY_ERROR);
			return "/cambioClave.xhtml";	
		} catch (Exception e) {
			addErrorMessage(e);
			return "/cambioClave.xhtml";			
		}		
		
		addMessage("Se modifico la clave correctamente.", FacesMessage.SEVERITY_INFO);
		modo = "LOG";  //CAM = CAMBIO DE CLAVE     LOG = IR A LOGIN
		
		return "/cambioClave.xhtml";
	}	
	
	
	public String irLogin(){
		return "/login.xhtml";
	}	
	
	
	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}


	public String getCodigocambio() {
		return codigocambio;
	}


	public void setCodigocambio(String codigocambio) {
		this.codigocambio = codigocambio;
	}


	public String getNuevaclave() {
		return nuevaclave;
	}


	public void setNuevaclave(String nuevaclave) {
		this.nuevaclave = nuevaclave;
	}


	public String getConfirmaclave() {
		return confirmaclave;
	}


	public void setConfirmaclave(String confirmaclave) {
		this.confirmaclave = confirmaclave;
	}


	public String getModo() {
		return modo;
	}


	public void setModo(String modo) {
		this.modo = modo;
	}


	public String getClaveAnterior() {
		return claveAnterior;
	}

	public void setClaveAnterior(String claveAnterior) {
		this.claveAnterior = claveAnterior;
	}	
}
