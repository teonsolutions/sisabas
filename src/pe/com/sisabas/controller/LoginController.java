package pe.com.sisabas.controller;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import pe.com.sisabas.exception.ValidateException;
import pe.com.sisabas.resources.Messages;
import pe.com.sisabas.resources.Utils;
import pe.com.sisabas.resources.UtilsSecurity;
import pe.com.sisabas.resources.controller.BaseController;
import pe.com.sisabas.service.SicuCallService;
import pe.com.sisabas.service.Sicurespuesta;
import pe.com.sisabas.service.Sicuusuario;

@Component(value ="loginBean")
@Scope(value = "session")
public class LoginController extends BaseController{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String user;
	private String password;
	private String role;
	private boolean authorized;
	private boolean mobile;
	
	public static String SUCCESS="/pages/home.xhtml?faces-redirect=true;";
	public static String SUCCESS_CHANGEPASSWORD="/cambioClave.xhtml?faces-redirect=true;";
		
	public static String LOGIN="/";
	public static String PAGE_ERROR="/error.xhtml";
	public static String ROLE_USER="user";
	public static String ROLE_MOBILE="userMobile";
	
	private Date   datFechaHoraUltimoAcceso;  //se utiliza en el filtro para los intervalos de 1'

	private Sicuusuario sicuusuario;
	
	@PostConstruct
	public void init(){
		this.mobile=false;
	}
	
	public void initMobile(){
		this.mobile=true;
		try {
			redirect("/mobile/login.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String login(){			
		message=null;
		logger.debug("login....");	
		try {
			
			String ipuser = UtilsSecurity.getRemoteAddr();
			if(SICU_SECURITY_ENABLE){
				/*llamada a webservice*/
	 			sicuusuario = SicuCallService.login(user, password, SICU_SECURITY_APLICATION_ID, ipuser); 
				
				if (sicuusuario!=null && sicuusuario.getVchstatus().equalsIgnoreCase("OK")){
					authorized=true;
					setRole(ROLE_USER);				
				    getHttpSession().setAttribute("sicuusuarioSESSION", sicuusuario);			
				}else{
					String mensaje_return ="Datos Incorrectos";
					if (sicuusuario!=null && sicuusuario.getVchstatus()!=null && !sicuusuario.getVchstatus().equalsIgnoreCase("OK")){
						mensaje_return = sicuusuario.getVchmensaje();
					}
					throw new ValidateException(mensaje_return);
				}
			}else{
				authorized=true;
				setRole(ROLE_USER);				
			    getHttpSession().setAttribute("sicuusuarioSESSION", sicuusuario);		
			}
		} catch (RemoteException e) {
			STATUS_ERROR();				
			addMessageKey("msgsForm", Messages.getString("sicu.remote.exeption"),e.getMessage(),
					FacesMessage.SEVERITY_ERROR);
			return "/login.xhtml";
		} catch (ValidateException e) {			
			addMessage(e.getMessage(),
			FacesMessage.SEVERITY_ERROR);
			return "/login.xhtml";
		} catch (Exception e) {
			addErrorMessage(e);
			return "/login.xhtml";
		}		
		
		if (sicuusuario!=null && sicuusuario.getVchAuxDatoString()!=null && sicuusuario.getVchAuxDatoString().equals("cambioClave"))
			return SUCCESS_CHANGEPASSWORD;			
			
		return SUCCESS;
	}
	
	
	private String message=null;
	/**Cerrar sesion*/
	public void logout() {
		String url=PAGE_ERROR;
		setMessage(null);
		ExternalContext ctx =FacesContext.getCurrentInstance().getExternalContext();		
		String ctxPath =((ServletContext) ctx.getContext()).getContextPath();
		
		try {
			logger.debug("Logout...");
			if(SICU_SECURITY_ENABLE){
				Sicurespuesta sicurespuesta = SicuCallService.logout();
						
				if (sicurespuesta!=null){
					if(sicurespuesta.getVchstatus().equalsIgnoreCase("OK")){
						logger.debug("SICU Logout ok");
						setMessage("SICU Logout ok");
						url=LOGIN;
						((HttpSession) ctx.getSession(false)).invalidate();
					}else{
						logger.debug("SICU Logout ERROR: "+sicurespuesta.getVchmensaje());
						setMessage(message="SICU Logout ERROR: "+sicurespuesta.getVchmensaje());
					}			
				}else{
					logger.debug("SICU Logout ERROR");
					setMessage("SICU Logout ERROR");
				}				
			}else{
				url=LOGIN;
				((HttpSession) ctx.getSession(false)).invalidate();
			}			
		} catch (RemoteException e) {			
			logger.error(Utils.getStackTrace(e));
			setMessage(Messages.getString("sicu.remote.exeption")+e.getMessage());
		} catch (ValidateException e) {
			logger.debug(Utils.getStackTrace(e));
			setMessage(e.getMessage());						
		} catch (Exception e) {
			logger.error(Utils.getStackTrace(e));
			setMessage(e.getMessage());			
		}			
				
		try {
		   ctx.redirect(ctxPath+url);
		} catch (IOException ex) {
		   ex.printStackTrace();
		}	
	}
	
	public String logoutForceLocal(){
		setMessage(null);
		ExternalContext ctx =FacesContext.getCurrentInstance().getExternalContext();
		((HttpSession) ctx.getSession(false)).invalidate();
		return irLogin();
	}
	
	
	public String loginMobile(){
		
		logger.debug("Login Controller....");
		authorized=true;
		
		return SUCCESS;
	}
	
	/**Cerrar sesion*/
	public void logoutMobile() {	
		
		logger.debug("logoutMobile....");
		ExternalContext ctx =FacesContext.getCurrentInstance().getExternalContext();
		String ctxPath =((ServletContext) ctx.getContext()).getContextPath();
		try {		    
		   ((HttpSession) ctx.getSession(false)).invalidate();	
		   
		   ctx.redirect(ctxPath + "/mobile/loginMozo.xhtml?faces-redirect=true;");		 
		} catch (IOException ex) {
		   ex.printStackTrace();
		}		
	}
	
	
	public String irSolicitarCambioClave(){
		return "/solicitaCambioClave.xhtml?faces-redirect=true;";
	}
	
	public String irLogin(){
		return "/login.xhtml?faces-redirect=true;";
	}	

	
	
	public String solicitarCambioDeClave(){				

		try {
			
			/*llamada a webservice*/
 			Sicurespuesta sicurespuesta = SicuCallService.solicitarCambioDeClave(user);
 				
			if (sicurespuesta!=null && sicurespuesta.getVchstatus().equalsIgnoreCase("OK")){
				addMessage("Solicitud de cambio de clave aceptada. Revise su bandeja de correo electronico.", FacesMessage.SEVERITY_INFO);
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
			return "/solicitaCambioClave.xhtml";
		}		
		return "/solicitaCambioClave.xhtml";
	}
		
	
	
	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isAuthorized() {
		return authorized;
	}
	public void setAuthorized(boolean authorized) {
		this.authorized = authorized;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Date getDatFechaHoraUltimoAcceso() {
		return datFechaHoraUltimoAcceso;
	}

	public void setDatFechaHoraUltimoAcceso(Date datFechaHoraUltimoAcceso) {
		this.datFechaHoraUltimoAcceso = datFechaHoraUltimoAcceso;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
		
	public boolean isMobile() {
		return mobile;
	}

	public void setMobile(boolean mobile) {
		this.mobile = mobile;
	}
}
