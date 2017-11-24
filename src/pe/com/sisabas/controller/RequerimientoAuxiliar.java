package pe.com.sisabas.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import pe.com.sisabas.dto.Lugar;
import pe.com.sisabas.dto.Pago;
import pe.com.sisabas.resources.controller.BaseController;
import pe.com.sisabas.service.SicuCallService;

@Component(value ="requerimientoAux")
@Scope(value = "request")
public class RequerimientoAuxiliar extends BaseController{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Lugar lugar; 
	private Pago pago;
	
	private static List<Lugar> lugares=new ArrayList<>();
	
	private String idOpcionText = "OPC_REQUERIMIENTO";
	
	@PostConstruct
	public void init(){
		
		try {
			
			
			
			lugar=new Lugar();
			if(SICU_SECURITY_ENABLE){
				idOpcion   = SicuCallService.obtenerIdOpcion(idOpcionText).toString();
				sicuopcion = SicuCallService.obtenercontroles(idOpcion);
			}
		
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}
	
	
	
	public List<Lugar> getLugares() {
		return lugares;
	}


	public void setLugares(List<Lugar> lugares) {
		RequerimientoAuxiliar.lugares = lugares;
	}


	public Lugar getLugar() {
		return lugar;
	}

	public void setLugar(Lugar lugar) {
		this.lugar = lugar;
	}
	

	public Pago getPago() {
		return pago;
	}

	public void setPago(Pago pago) {
		this.pago = pago;
	}

	public void limpiar() {
		RequerimientoAuxiliar.lugares.clear();
	}
	
	public void agregarLugar(){ //adding new nationality and set its index
		System.out.println("*************************** El tamanio de listaLugar1 es: "+lugares.size()+" ***************************");
		RequerimientoAuxiliar.lugares.add(this.lugar);
		System.out.println("*************************** El tamanio de listaLugar2 es: "+lugares.size()+" ***************************");
		FacesContext context = FacesContext.getCurrentInstance();
	     context.addMessage(null, new FacesMessage("Mensaje", "Se agregó lugar de prestación correctamente"));
		
	}
	
	public void eliminarLugar(Lugar lugar){ //adding new nationality and set its index
		System.out.println("*************************** El tamanio de listaLugar3 es: "+lugares.size()+" ***************************");
		RequerimientoAuxiliar.lugares.remove(lugar);
		System.out.println("*************************** El tamanio de listaLugar4 es: "+lugares.size()+" ***************************");
		
		 FacesContext context = FacesContext.getCurrentInstance();
	     context.addMessage(null, new FacesMessage("Mensaje", "Se eliminó lugar de prestación correctamente"));
		
	}
	
	public void onRowEdit(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Se editó correctamente","Dependencia: "+((Lugar) event.getObject()).getDependencia());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Se canceló la edición","Dependencia: "+((Lugar) event.getObject()).getDependencia());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
   
}
