package pe.com.sisabas.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import pe.com.sisabas.be.Periodo;
import pe.com.sisabas.be.VisSigaCentroCosto;
import pe.com.sisabas.business.PeriodoBusiness;
import pe.com.sisabas.business.VcentrocostoBusiness;
import pe.com.sisabas.exception.ValidateException;
import pe.com.sisabas.resources.Utils;
import pe.com.sisabas.resources.controller.BaseController;
import pe.com.sisabas.service.Sicuopcion;
import pe.com.sisabas.service.Sicuperiodo;
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
	
	private List<Periodo> listaPeriodo;
	
	private boolean booleanConfig;


	
	
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
	    
	   buscarPeriodo();
	    
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
	
	
	
	
	
	
	//jasaro19122017
	private String selectedPeriodo;
	private String selectedCentroCosto;
	private List<VisSigaCentroCosto> listaVisSigaCentroCosto;
	@Autowired
	public PeriodoBusiness periodoBusiness;
	
	@Autowired
	public VcentrocostoBusiness business;
	
	private Periodo periodoB=new Periodo();
	
	
	public void changePeriodo(ValueChangeEvent event){
		
		String valor=(String) event.getNewValue();
	
		if(valor!=null && !valor.isEmpty()){
			Sicuusuario sicuusuario  = (Sicuusuario)Utils.getHttpSession().getAttribute("sicuusuarioSESSION");	
			sicuusuario.getPeriodo().setIdPeriodo(Integer.parseInt(valor.split("-")[0].toString()));
			sicuusuario.getPeriodo().setAnio(Integer.parseInt(valor.split("-")[1].toString()));
			getHttpSession().setAttribute("sicuusuarioSESSION", (Sicuusuario)sicuusuario);
			
			VisSigaCentroCosto record=new VisSigaCentroCosto();
			record.setAnio(valor.split("-")[1].toString());
			
			listaVisSigaCentroCosto=business.selectDynamicFullVis(record);
			
			setSelectedPeriodo(valor.split("-")[0].toString()+"-"+valor.split("-")[1].toString());
			
		
			
		}
		
		FacesContext.getCurrentInstance().renderResponse();
	}
	
	
	public void changeCentroCosto(ValueChangeEvent event){
		
		String valor=(String) event.getNewValue();
		
		if(valor!=null && !valor.isEmpty()){
			Sicuusuario sicuusuario  = (Sicuusuario)Utils.getHttpSession().getAttribute("sicuusuarioSESSION");		
			sicuusuario.getPeriodo().setCodigoCentroCosto(valor.split("-")[0].toString());
			sicuusuario.getPeriodo().setNombreCentroCosto(valor.split("-")[1].toString());
			getHttpSession().setAttribute("sicuusuarioSESSION", (Sicuusuario) sicuusuario);
		
			
			
			
			
			
			System.out.println("**********jasaro   sicuusuarioSESSION ");
			Sicuusuario sicuusuariox  = (Sicuusuario)Utils.getHttpSession().getAttribute("sicuusuarioSESSION");	
			System.out.println(sicuusuariox.getPeriodo().getIdPeriodo());
			System.out.println(sicuusuariox.getPeriodo().getAnio());
			System.out.println(sicuusuariox.getPeriodo().getCodigoCentroCosto());
			System.out.println(sicuusuariox.getPeriodo().getNombreCentroCosto());
			
		}
	
	}
	
	private void buscarPeriodo() {
		List<String> ordenListaCampos = Arrays.asList("A1.nombreperiodo");
		periodoB.setOrdenListaCampos(ordenListaCampos);
		periodoB.setOrdenTipo("DESC");

		
		pe.com.sisabas.resources.Utils.convertPropertiesStringToUppercase(periodoB);
		
		try {
			listaPeriodo = periodoBusiness.selectDynamicFull(periodoB);
			
			if(listaPeriodo!=null && !listaPeriodo.isEmpty()){
			
				VisSigaCentroCosto record=new VisSigaCentroCosto();
				record.setAnio(listaPeriodo.get(0).getAnio().toString());
				
				listaVisSigaCentroCosto=business.selectDynamicFullVis(record);
				
				
				
				//Actualiza Sesion	
				Sicuusuario sicuusuario  = (Sicuusuario)Utils.getHttpSession().getAttribute("sicuusuarioSESSION");	
			
				sicuusuario.getPeriodo().setIdPeriodo(listaPeriodo.get(0).getIdperiodo());
				sicuusuario.getPeriodo().setAnio(listaPeriodo.get(0).getAnio());
				sicuusuario.getPeriodo().setCodigoCentroCosto(listaVisSigaCentroCosto.get(0).getCodigocentrocosto());
				sicuusuario.getPeriodo().setNombreCentroCosto(listaVisSigaCentroCosto.get(0).getNombredependencia());
				
				
				setSelectedPeriodo(listaPeriodo.get(0).getIdperiodo()+"-"+listaPeriodo.get(0).getAnio());
				
				getHttpSession().setAttribute("sicuusuarioSESSION", (Sicuusuario) sicuusuario);
				
				
				System.out.println("**********jasaro   sicuusuarioSESSION ");
				Sicuusuario sicuusuariox  = (Sicuusuario)Utils.getHttpSession().getAttribute("sicuusuarioSESSION");	
				System.out.println(sicuusuariox.getPeriodo().getIdPeriodo());
				System.out.println(sicuusuariox.getPeriodo().getAnio());
				System.out.println(sicuusuariox.getPeriodo().getCodigoCentroCosto());
				System.out.println(sicuusuariox.getPeriodo().getNombreCentroCosto());
				
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	public List<VisSigaCentroCosto> getListaVisSigaCentroCosto() {
		return listaVisSigaCentroCosto;
	}

	public String getSelectedPeriodo() {
		return selectedPeriodo;
	}

	public void setSelectedPeriodo(String selectedPeriodo) {
		this.selectedPeriodo = selectedPeriodo;
	}

	public String getSelectedCentroCosto() {
		return selectedCentroCosto;
	}

	public void setSelectedCentroCosto(String selectedCentroCosto) {
		this.selectedCentroCosto = selectedCentroCosto;
	}



	public List<Periodo> getListaPeriodo() {
		return listaPeriodo;
	}



	public void setListaPeriodo(List<Periodo> listaPeriodo) {
		this.listaPeriodo = listaPeriodo;
	}



	public boolean isBooleanConfig() {
		return booleanConfig;
	}


	public void setBooleanConfig(boolean booleanConfig) {
		this.booleanConfig = booleanConfig;
	}


}
