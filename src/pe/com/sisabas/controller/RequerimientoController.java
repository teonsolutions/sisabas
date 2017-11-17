package pe.com.sisabas.controller;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;

import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import pe.com.sisabas.be.Gentipo;
import pe.com.sisabas.be.RequerimientoItemRequest;
import pe.com.sisabas.be.RequerimientoItemResponse;
import pe.com.sisabas.be.RequerimientoRequest;
import pe.com.sisabas.be.RequerimientoResponse;
import pe.com.sisabas.business.PersonaBusiness;
import pe.com.sisabas.business.RequerimientoBusiness;
import pe.com.sisabas.exception.SecurityRestrictedControlException;
import pe.com.sisabas.exception.SecuritySessionExpiredException;
import pe.com.sisabas.exception.SecurityValidateException;
import pe.com.sisabas.resources.Messages;
import pe.com.sisabas.resources.controller.BaseController;
import pe.com.sisabas.service.SicuCallService;

@Component(value ="requerimiento")
@Scope(value = "session")
public class RequerimientoController extends BaseController{

	private static final long serialVersionUID = 1L;
	
	@Autowired
	public RequerimientoBusiness business;
	
	private int tam;
	
	private RequerimientoRequest requerimientoRequest;
	private RequerimientoResponse requerimientoResponse;
	
	private RequerimientoItemRequest requerimientoItemRequest;
	private RequerimientoItemResponse requerimientoItemResponse;
	
	private List<RequerimientoResponse> listaRequerimientos = new ArrayList<RequerimientoResponse>();
	private List<RequerimientoItemResponse> listaItemRequerimientos = new ArrayList<RequerimientoItemResponse>();
	                           
	private String tituloBase; //titulo de la opcion
	private String tituloParam;//titulo que llega como parametro (derivada padre)
	
	private String idOpcionText = "OPC_REQUERIMIENTO";
	
	public RequerimientoController() {
		System.out.println("********** constructor Fer1************");
		
		
	}
	
	@PostConstruct
	public void init(){
		System.out.println("*************init Fer2 **************");
		try {
			requerimientoRequest = new RequerimientoRequest();
			requerimientoResponse = new RequerimientoResponse();
			requerimientoItemRequest = new RequerimientoItemRequest();
			requerimientoItemResponse = new RequerimientoItemResponse();
			
			
			tituloBase = "Requerimientos » ";
			if(SICU_SECURITY_ENABLE){
				idOpcion   = SicuCallService.obtenerIdOpcion(idOpcionText).toString();
				sicuopcion = SicuCallService.obtenercontroles(idOpcion);
			}
		
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}
	

	
	
	public void buscarRequerimientos() {
		try {
			System.out.println("Fer3");
			//Todos		
			requerimientoRequest.setCodigoUnidadEjecutora("108");
			//requerimientoRequest.setPedido("08761");
			requerimientoRequest.setAnoEje(2017); 
			requerimientoRequest.setPagenumber(1);  
			requerimientoRequest.setPageSize(10);
			
			
			listaRequerimientos = business.selectDynamicFull(requerimientoRequest);
			
			System.out.println("***********el tamanio es *********"+listaRequerimientos.size());
			System.out.println("***********Valor de tipo de bien *********"+requerimientoRequest.getTipoBien());
			
			if (listaRequerimientos.size() == 0)
				addMessageKey("msgsForm",
					Messages.getString("no.records.found"),
					FacesMessage.SEVERITY_INFO);	
		} catch (SecuritySessionExpiredException e) {
			redirectSessionExpiredPage();
		} catch (SecurityRestrictedControlException e) {
			addMessageKey("msgsForm", Messages.getString("no.access"),e.getMessage(),FacesMessage.SEVERITY_ERROR);
		} catch (SecurityValidateException e) {
			addMessageKey("msgsForm",e.getMessage(), FacesMessage.SEVERITY_ERROR);
		} catch (RemoteException e) {
			addMessageKey("msgsForm", Messages.getString("sicu.remote.exeption"),e.getMessage(),FacesMessage.SEVERITY_ERROR);
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
		
	}
	
	
	public void buscarItemRequerimientos() {
		try {
			System.out.println("***************Fer4**************"+requerimientoResponse.getEstadoSiga());
			//Todos		
			//getPedidosEvaluacion
			requerimientoItemRequest.setCodUnidadEjecutora("108");
			requerimientoItemRequest.setEjercicio(2017); 
			
			requerimientoItemRequest.setNroPedido(requerimientoResponse.getNroPedido());
			
			if(requerimientoResponse.getTipobien().equalsIgnoreCase("Servicio"))
				requerimientoItemRequest.setTipoBien("S");
			else if (requerimientoResponse.getTipobien().equalsIgnoreCase("Bien"))
				requerimientoItemRequest.setTipoBien("B");

			listaItemRequerimientos = business.selectDynamicBasic(requerimientoItemRequest);
			
			System.out.println("***********el tamanioB es *********"+listaItemRequerimientos.size());
			System.out.println("***********el valor de nropedido es *********"+requerimientoResponse.getNroPedido());
			
			if(listaItemRequerimientos.size()==1)
				tam=100;
			else tam = 200;
			
			if (listaItemRequerimientos.size() == 0)
				addMessageKey("msgsForm",
					Messages.getString("no.records.found"),
					FacesMessage.SEVERITY_INFO);	
		} catch (SecuritySessionExpiredException e) {
			redirectSessionExpiredPage();
		} catch (SecurityRestrictedControlException e) {
			addMessageKey("msgsForm", Messages.getString("no.access"),e.getMessage(),FacesMessage.SEVERITY_ERROR);
		} catch (SecurityValidateException e) {
			addMessageKey("msgsForm",e.getMessage(), FacesMessage.SEVERITY_ERROR);
		} catch (RemoteException e) {
			addMessageKey("msgsForm", Messages.getString("sicu.remote.exeption"),e.getMessage(),FacesMessage.SEVERITY_ERROR);
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
		
	}
	
	public List<RequerimientoItemResponse> getListaItemRequerimientos() {
		return listaItemRequerimientos;
	}

	public void setListaItemRequerimientos(List<RequerimientoItemResponse> listaItemRequerimientos) {
		this.listaItemRequerimientos = listaItemRequerimientos;
	}

	public List<RequerimientoResponse> getListaRequerimientos() {
		return listaRequerimientos;
	}

	public void setListaRequerimientos(List<RequerimientoResponse> listaRequerimientos) {
		this.listaRequerimientos = listaRequerimientos;
	}

	public RequerimientoRequest getRequerimientoRequest() {
		return requerimientoRequest;
	}
	public void setRequerimientoRequest(RequerimientoRequest requerimientoRequest) {
		this.requerimientoRequest = requerimientoRequest;
	}
	public RequerimientoResponse getRequerimientoResponse() {
		return requerimientoResponse;
	}
	public void setRequerimientoResponse(RequerimientoResponse requerimientoResponse) {
		this.requerimientoResponse = requerimientoResponse;
	}

	public String getTituloBase() {
		return tituloBase;
	}

	public void setTituloBase(String tituloBase) {
		this.tituloBase = tituloBase;
	}

	public String getTituloParam() {
		return tituloParam;
	}

	public void setTituloParam(String tituloParam) {
		this.tituloParam = tituloParam;
	}

	public RequerimientoItemRequest getRequerimientoItemRequest() {
		return requerimientoItemRequest;
	}

	public void setRequerimientoItemRequest(RequerimientoItemRequest requerimientoItemRequest) {
		this.requerimientoItemRequest = requerimientoItemRequest;
	}

	public RequerimientoItemResponse getRequerimientoItemResponse() {
		return requerimientoItemResponse;
	}

	public void setRequerimientoItemResponse(RequerimientoItemResponse requerimientoItemResponse) {
		this.requerimientoItemResponse = requerimientoItemResponse;
	}

	public int getTam() {
		return tam;
	}

	public void setTam(int tam) {
		this.tam = tam;
	}
	
	

}
