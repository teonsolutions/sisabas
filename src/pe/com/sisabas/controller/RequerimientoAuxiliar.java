package pe.com.sisabas.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.RowEditEvent;
import org.primefaces.model.UploadedFile;
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
	private static List<Pago> pagos=new ArrayList<>();
	
	private String idOpcionText = "OPC_REQUERIMIENTO";

	
	
	@PostConstruct
	public void init(){
		
		try {
				
			
			lugar=new Lugar();
			pago=new Pago();
			if(SICU_SECURITY_ENABLE){
				idOpcion   = SicuCallService.obtenerIdOpcion(idOpcionText).toString();
				sicuopcion = SicuCallService.obtenercontroles(idOpcion);
			}
		
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}
	
	public void handleFileUpload(FileUploadEvent event) {
        FacesMessage message = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

	public List<Lugar> getLugares() {
		return lugares;
	}


	public void setLugares(List<Lugar> lugares) {
		RequerimientoAuxiliar.lugares = lugares;
	}

	
	
	
	public List<Pago> getPagos() {
		return pagos;
	}


	public void setPagos(List<Pago> pagos) {
		RequerimientoAuxiliar.pagos = pagos;
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
		RequerimientoAuxiliar.pagos.clear();
	}
	
	public void agregarLugar(){ //adding new nationality and set its index
		System.out.println("*************************** El tamanio de listaLugar1 es: "+lugares.size()+" ***************************");
		RequerimientoAuxiliar.lugares.add(this.lugar);
		System.out.println("*************************** El tamanio de listaLugar2 es: "+lugares.size()+" ***************************");
		FacesContext context = FacesContext.getCurrentInstance();
	     context.addMessage(null, new FacesMessage("Mensaje", "Se agreg� lugar de prestaci�n correctamente"));
		
	}
	
	public void eliminarLugar(Lugar lugar){ //adding new nationality and set its index
		System.out.println("*************************** El tamanio de listaLugar3 es: "+lugares.size()+" ***************************");
		RequerimientoAuxiliar.lugares.remove(lugar);
		System.out.println("*************************** El tamanio de listaLugar4 es: "+lugares.size()+" ***************************");
		
		 FacesContext context = FacesContext.getCurrentInstance();
	     context.addMessage(null, new FacesMessage("Mensaje", "Se elimin� lugar de prestaci�n correctamente"));
		
	}
	
	
	public void agregarPago(){ //adding new nationality and set its index

		RequerimientoAuxiliar.pagos.add(this.pago);
		FacesContext context = FacesContext.getCurrentInstance();
	     context.addMessage(null, new FacesMessage("Mensaje", "Se agreg� forma de pago correctamente"));
		
	}
	
	public void eliminarPago(Pago pago){ //adding new nationality and set its index

		 RequerimientoAuxiliar.pagos.remove(pago);
		
		 FacesContext context = FacesContext.getCurrentInstance();
	     context.addMessage(null, new FacesMessage("Mensaje", "Se elimin� forma de pago correctamente"));
		
	}
		
	public void onRowEdit(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Se edit� correctamente","Dependencia: "+((Lugar) event.getObject()).getDependencia());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
	public void onRowEdit2(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Se edit� correctamente","Numero de armada: "+((Pago) event.getObject()).getNumero());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
	
    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Se cancel� la edici�n","Dependencia: "+((Lugar) event.getObject()).getDependencia());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void onRowCancel2(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Se cancel� la edici�n","Numero de armada: "+((Pago) event.getObject()).getNumero());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
   
}