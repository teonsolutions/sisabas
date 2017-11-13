package pe.com.sisabas.controller;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import pe.com.sisabas.be.Gentipo;
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
	
	private RequerimientoRequest requerimientoRequest;
	private RequerimientoResponse requerimientoResponse;
	private List<RequerimientoResponse> listaRequerimientos;
	                           
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
			//getPedidosEvaluacion
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
	
	

}
