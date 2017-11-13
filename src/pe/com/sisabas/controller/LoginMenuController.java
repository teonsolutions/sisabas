package pe.com.sisabas.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import pe.com.sisabas.exception.ValidateException;
import pe.com.sisabas.resources.Utils;
import pe.com.sisabas.resources.controller.BaseController;
import pe.com.sisabas.service.Sicuopcion;
import pe.com.sisabas.service.Sicuusuario;

@Component(value ="menuBean")
@Scope(value = "session")
public class LoginMenuController extends BaseController{
	private static final long serialVersionUID = 1L;
	

	private MenuModel model;	
	//Config
	FacesContext facesCtx;
	ELContext elCtx;
	ExpressionFactory expFact;
	
	
	@PostConstruct
	public void generateMenu(){
		System.out.println("generateMenu....");
		
		model = new DefaultMenuModel();
		facesCtx = FacesContext.getCurrentInstance();
		elCtx = facesCtx.getELContext();
	    expFact = facesCtx.getApplication().getExpressionFactory();
	    
	    HttpServletRequest request= (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
	    HttpSession session = ((HttpServletRequest)request).getSession(false);
	    LoginController login = (LoginController) session.getAttribute("loginBean");	 
	    
		try {
			
			
			Sicuusuario sicuusuario  = (Sicuusuario)Utils.getHttpSession().getAttribute("sicuusuarioSESSION");			

			
			if (sicuusuario.getListaSicuopcion()==null || sicuusuario.getListaSicuopcion().length==0){
				throw new ValidateException("Usuario sin opciones asignados!. Comuniquese con el Administrador.");
			}
			
		
			Sicuopcion genopciones;
			Sicuopcion genopcionesItem;
			List<Sicuopcion> opcionesBase;
			
			List<Sicuopcion> opcionesItem;
			boolean primer_submenu=false;

			genopciones=new Sicuopcion();
			genopciones.setIntopcnivel(new Integer(0));
			
			opcionesBase=filtraOpciones(sicuusuario.getListaSicuopcion(), genopciones); //IMPLEMENTAR
				
			for (Sicuopcion op : opcionesBase) {								        
		        DefaultSubMenu submenu = new DefaultSubMenu();  
		        submenu.setLabel(op.getVchopcnombre());
		        if(!primer_submenu){//Padding por el logo. Sólo para el primer subitem.
		        	submenu.setStyle("padding-left:50px");
		        	primer_submenu=true;
		        }
		        genopcionesItem=new Sicuopcion();
		        genopcionesItem.setIntopccodigopadre(op.getIntopccodigo());
		        opcionesItem=filtraOpciones(sicuusuario.getListaSicuopcion(), genopcionesItem); //IMPLEMENTAR
			        
		        for (Sicuopcion op2 : opcionesItem) {
		        	DefaultMenuItem item = new DefaultMenuItem();
			        item.setValue(op2.getVchopcnombre());
			        item.setAjax(false);
			        
			        
			        item.setCommand("#{sisabascontrol.validaOpcion('"+op2.getIntopccodigo().toString()+"')}");
			        
			        item.setIcon("ui-icon-arrowreturnthick-1-e");				        
			       submenu.addElement(item);
				}		        
			        
		       model.addElement(submenu);
			}				
				

		} catch (Exception e) {
			addErrorMessage(e);		
		}
	}	

	public MenuModel getModel() {
		return model;
	}

	public void setModel(MenuModel model) {
		this.model = model;
	}


	
	public List<Sicuopcion> filtraOpciones(pe.com.sisabas.service.Sicuopcion[] listaSicuopcion, Sicuopcion filtro){
		List<Sicuopcion> listaRetorno = new ArrayList<Sicuopcion>();
		for(int i=0;i<listaSicuopcion.length;i++){
			Sicuopcion item = (Sicuopcion)listaSicuopcion[i];
			boolean swadd=false;
			
			if (filtro!=null && filtro.getIntopcnivel()!=null && (filtro.getIntopcnivel().compareTo(item.getIntopcnivel())==0))
			swadd=true;
			
			if (filtro!=null && filtro.getIntopccodigopadre()!=null &&
				item!=null   && item.getIntopccodigopadre()!=null   &&
				(filtro.getIntopccodigopadre().compareTo(item.getIntopccodigopadre())==0))
			swadd=true;

			if (swadd)
			listaRetorno.add(item);
			
			
		}
		return listaRetorno;
	}
	
	
	public void validaOpcion(String opcion){
		System.err.println(">>>>>>>>>>>>>>>>>"+opcion);
	}
	
	
}
