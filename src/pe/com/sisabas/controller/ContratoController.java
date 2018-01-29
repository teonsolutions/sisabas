package pe.com.sisabas.controller;



import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import pe.com.sisabas.be.ContratoRequest;
import pe.com.sisabas.be.ContratoResponse;
import pe.com.sisabas.business.ContratoBusiness;
import pe.com.sisabas.business.GentablaBusiness;
import pe.com.sisabas.dto.EstadoRequerimientoResponse;
import pe.com.sisabas.exception.SecurityRestrictedControlException;
import pe.com.sisabas.exception.SecuritySessionExpiredException;
import pe.com.sisabas.exception.SecurityValidateException;
import pe.com.sisabas.resources.Constantes;
import pe.com.sisabas.resources.Messages;
import pe.com.sisabas.resources.controller.BaseController;
import pe.com.sisabas.service.Sicuusuario;



@Component(value = "contrato")
@Scope(value = "session")
public class ContratoController extends BaseController {

	private static final long serialVersionUID = 1L;

	private boolean avanzado = false;
	
	private ContratoBusiness contratoBusiness;
	
	private ContratoRequest contratoRequest;
	
	private ContratoResponse contratoResponse;
	
	private List<ContratoResponse> listaContratos = new ArrayList<ContratoResponse>();
	
	public List<EstadoRequerimientoResponse> listaEstadoRequerimiento;
	
	@Autowired
	public GentablaBusiness gentablaBusiness;
	
	@PostConstruct
	public void init() {
		
		try {
		contratoRequest = new ContratoRequest();
		contratoResponse= new ContratoResponse();
		
		listaEstadoRequerimiento = gentablaBusiness.getEstadoRequerimiento(Constantes.etapaAdministrativa.EJECUCION_CONTRACTUAL);
		
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
		
	}

	public boolean isAvanzado() {
		return avanzado;
	}

	public void setAvanzado(boolean avanzado) {
		this.avanzado = avanzado;
	}

	public void mostrar(){
		this.avanzado=true;
		
	}
	
	public void ocultar(){
		this.avanzado=false;
		
	}
	
	public void buscarContratos(){
		try{
		// Todos
	    Sicuusuario usuario = (Sicuusuario) getHttpSession().getAttribute("sicuusuarioSESSION");
	    
	    contratoRequest.setEjercicio(2015);
	    contratoRequest.setCodUnidEjecutora(26);
	    contratoRequest.setCentroCosto(usuario.getPeriodo().getCodigoCentroCosto());
	  //contratoRequest
	    setListaContratos(contratoBusiness.selectDynamicFull(contratoRequest));
	    
	    
		}catch (SecuritySessionExpiredException e) {
			redirectSessionExpiredPage();
		} catch (SecurityRestrictedControlException e) {
			addMessageKey("msgsForm", Messages.getString("no.access"), e.getMessage(), FacesMessage.SEVERITY_ERROR);
		} catch (SecurityValidateException e) {
			addMessageKey("msgsForm", e.getMessage(), FacesMessage.SEVERITY_ERROR);
		} catch (RemoteException e) {
			addMessageKey("msgsForm", Messages.getString("sicu.remote.exeption"), e.getMessage(),
					FacesMessage.SEVERITY_ERROR);
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
		
	}

	public ContratoRequest getContratoRequest() {
		return contratoRequest;
	}

	public void setContratoRequest(ContratoRequest contratoRequest) {
		this.contratoRequest = contratoRequest;
	}

	public List<ContratoResponse> getListaContratos() {
		return listaContratos;
	}

	public void setListaContratos(List<ContratoResponse> listaContratos) {
		this.listaContratos = listaContratos;
	}

	public ContratoResponse getContratoResponse() {
		return contratoResponse;
	}

	public void setContratoResponse(ContratoResponse contratoResponse) {
		this.contratoResponse = contratoResponse;
	}

	public List<EstadoRequerimientoResponse> getListaEstadoRequerimiento() {
		return listaEstadoRequerimiento;
	}

	public void setListaEstadoRequerimiento(List<EstadoRequerimientoResponse> listaEstadoRequerimiento) {
		this.listaEstadoRequerimiento = listaEstadoRequerimiento;
	}
	
	
	
}
