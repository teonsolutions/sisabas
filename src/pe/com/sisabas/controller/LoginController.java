package pe.com.sisabas.controller;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import listaPermisos1.listaPermisos1;

import pe.com.sisabas.exception.ValidateException;
import pe.com.sisabas.resources.Messages;
import pe.com.sisabas.resources.Utils;
import pe.com.sisabas.resources.UtilsSecurity;
import pe.com.sisabas.resources.controller.BaseController;
import pe.com.sisabas.service.SicuCallService;
import pe.com.sisabas.service.Sicuperiodo;
import pe.com.sisabas.service.Sicurespuesta;
import pe.com.sisabas.service.Sicuusuario;
import webservices.perfil.TsProcedimiento;



@Component(value ="loginBean")
@Scope(value = "session")
public class LoginController extends BaseController{


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
	private MenuModel model;
	private String Dni;
	private int idUsuario;
	private String nombreUsuario;	
	
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
		
		String sCadGen = "desarrollo$$pronied";
	    int ideModulo = 31;
        int idePadre = 0;
        Gson gson1 = new Gson();
        
        List<TsProcedimiento> listaNivel01= new ArrayList<TsProcedimiento>();
        listaPermisos1 listapermisos= new listaPermisos1();
        
        listaNivel01=listapermisos.ListarPerfilesItem2(user, password, ideModulo, idePadre, sCadGen);
        
        
        if(listaNivel01.size()==0 ){
         	FacesContext context = FacesContext.getCurrentInstance();
             context.addMessage(null, new FacesMessage("Verifique El Usuario o Password",  "Your") );
         	return "/login.xhtml";
             
           
 		}
       
        model=(new DefaultMenuModel());	
   
        String nombreCompleto = "";
	    for(int i=0;i<listaNivel01.size();i++){// cabecera
	    	
	    	   System.out.println(listaNivel01.get(i).getDescripcion());
	    	   DefaultSubMenu firstSubmenu = new DefaultSubMenu(listaNivel01.get(i).getDescripcion());	    	
	    	   if(i==0){
	    		  // firstSubmenu.setStyle("margin-left:50px;"); 
	    		   setDni(listaNivel01.get(i).getPerDocumento());
	    		   idUsuario=listaNivel01.get(i).getIdusuario();
	    		   if(getDni()== null){
	    			   setDni(user);
	    		   }
	    		   
	    		   nombreCompleto = listaNivel01.get(i).getPerNombres() + " " + listaNivel01.get(i).getPerApePaterno() + " " + listaNivel01.get(i).getPerApeMaterno();
	    		   setNombreUsuario(nombreCompleto);
	    	   }
	    	   List<TsProcedimiento> listaNivel02= new ArrayList<TsProcedimiento>();
	    	   listaNivel02=listapermisos.ListarPerfilesItem2(user, password, ideModulo, listaNivel01.get(i).getIdOpcion(), sCadGen);
	    	   
	    	   for(int j =0; j<listaNivel02.size();j++){
	    		      DefaultMenuItem item = new DefaultMenuItem(listaNivel02.get(j).getDescripcion());
		             item.setUrl(listaNivel02.get(j).getEnlace());
		            // item.setIcon("ui-icon-triangle-1-e");
		             firstSubmenu.addElement(item);
		             
		             /***/
		      
		         
		           /*  if(i==0){
			    		if(listaNivel02.size()==j+1){
			    			   DefaultMenuItem item1 = new DefaultMenuItem("plandecontigencia");
					             //item1.setUrl("/pages/ficha/registrarFicha.xhtml");
			    			   item1.setUrl("/pages/plandecontigenciavf/plandecontigenciavfBuscar.xhtml");
					            // item.setIcon("ui-icon-triangle-1-e");
					             firstSubmenu.addElement(item1);
			    		}
			    	   }*/
	    	   }
	    	   //menuList.add(firstSubmenu);
	    	 
	    	   model.addElement(firstSubmenu);
	       }
	    
	   
        
		try {
			
			String ipuser = UtilsSecurity.getRemoteAddr();
			
			
			
			
			if(SICU_SECURITY_ENABLE){
				/*llamada a webservice*/
	 			sicuusuario = SicuCallService.login(user, password, SICU_SECURITY_APLICATION_ID, ipuser); 
				
				if (sicuusuario!=null && sicuusuario.getVchstatus().equalsIgnoreCase("OK")){
					authorized=true;
					setRole(ROLE_USER);				
					
					//set dni and name
					sicuusuario.setNroDocumento(getDni());
					sicuusuario.setNombreUsuario(getNombreUsuario());
					
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

				if (sicuusuario == null) sicuusuario = new Sicuusuario();
				Sicuperiodo periodo = new Sicuperiodo();
				periodo.setCodigoCentroCosto("108.01.09.01");
				periodo.setIdPeriodo(1);
				periodo.setAnio(2017);				
				sicuusuario.setPeriodo(periodo);
				
				//set dni and name
				sicuusuario.setNroDocumento(getDni());
				sicuusuario.setNombreUsuario(getNombreUsuario());
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
	
	public String rutaenlace(String ruta){
		System.out.println("##########################:   "+ruta);
		
		return ruta;
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

	public MenuModel getModel() {
		return model;
	}

	public void setModel(MenuModel model) {
		this.model = model;
	}

	public String getDni() {
		return Dni;
	}

	public void setDni(String dni) {
		Dni = dni;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	

}
