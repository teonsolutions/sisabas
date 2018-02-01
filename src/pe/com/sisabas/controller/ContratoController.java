package pe.com.sisabas.controller;



import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import pe.com.sisabas.be.Contrato;
import pe.com.sisabas.be.ContratoRequest;
import pe.com.sisabas.be.ContratoResponse;
import pe.com.sisabas.be.Gentabla;
import pe.com.sisabas.be.Grupodocumento;
import pe.com.sisabas.be.Unidadejecutora;
import pe.com.sisabas.business.ContratoBusiness;
import pe.com.sisabas.business.GentablaBusiness;
import pe.com.sisabas.business.VcentrocostoBusiness;
import pe.com.sisabas.dto.CentroCostoRequest;
import pe.com.sisabas.dto.CentroCostoResponse;
import pe.com.sisabas.dto.EstadoRequerimientoResponse;
import pe.com.sisabas.exception.SecurityRestrictedControlException;
import pe.com.sisabas.exception.SecuritySessionExpiredException;
import pe.com.sisabas.exception.SecurityValidateException;
import pe.com.sisabas.exception.UnselectedRowException;
import pe.com.sisabas.resources.Constantes;
import pe.com.sisabas.resources.Messages;
import pe.com.sisabas.resources.controller.BaseController;
import pe.com.sisabas.service.Sicuusuario;



@Component(value = "contrato")
@Scope(value = "session")
public class ContratoController extends BaseController {

	private static final long serialVersionUID = 1L;

	private boolean avanzado = false;
	
	private List<String> listaIdcatalogosistemaadquisicionKeys;
	
	private Contrato contratoB;
	
	@Autowired
	private ContratoBusiness contratoBusiness;
	
	private ContratoRequest contratoRequest;
	
	private ContratoResponse contratoResponse;
	
	private Contrato contrato;
	private Contrato selectedContrato;
	
	private List<ContratoResponse> listaContratos = new ArrayList<ContratoResponse>();
	
	public List<EstadoRequerimientoResponse> listaEstadoRequerimiento;
	public List<CentroCostoResponse> listaCentroCosto;
	
	public List<Gentabla> listaEstadoFaseI;
	public List<Gentabla> listaEstadoFaseII;
	public List<Gentabla> listaGentablaIdcatalogosistemaadquisicion;
	
	private String tituloBase;
	private String tituloParam;
	
	@Autowired
	public GentablaBusiness gentablaBusiness;
	
	@Autowired
	public VcentrocostoBusiness vcentrocostoBusiness;
	
	
	public ContratoController(){
		contrato = new Contrato();
		contrato.setUnidadejecutoraIdunidadejecutora(new Unidadejecutora());
		contrato.setGrupodocumentoIdgrupodocumento(new Grupodocumento());

}

	
	@PostConstruct
	public void init() {
		
		try {
			
		contratoB = new Contrato();	
		tituloBase = "Contrato » ";	
			
		contratoB.setUnidadejecutoraIdunidadejecutora(new Unidadejecutora());
		contratoB.setGrupodocumentoIdgrupodocumento(new Grupodocumento());
			
		Sicuusuario usuario = (Sicuusuario) getHttpSession().getAttribute("sicuusuarioSESSION");	
		listaIdcatalogosistemaadquisicionKeys= new ArrayList<String>();
		
		
		
		listaGentablaIdcatalogosistemaadquisicion = gentablaBusiness.selectDynamicBasic(new Gentabla().getObjBusqueda(Constantes.tabla.SIAD));
		listaEstadoFaseI  = gentablaBusiness.selectDynamicBasic(new Gentabla().getObjBusqueda(Constantes.tabla.EEFI));
		listaEstadoFaseII = gentablaBusiness.selectDynamicBasic(new Gentabla().getObjBusqueda(Constantes.tabla.EFII));
			
		contratoRequest = new ContratoRequest();
		contratoResponse= new ContratoResponse();
		
		CentroCostoRequest param = new CentroCostoRequest();
		param.setCodigoUnidadEjecuta(Constantes.unidadEjecutora.PRONIED);
		param.setIdPeriodo(usuario.getPeriodo().getIdPeriodo());
		listaCentroCosto = vcentrocostoBusiness.getCentroCosto(param);
		
		listaEstadoRequerimiento = gentablaBusiness.getEstadoRequerimiento(Constantes.etapaAdministrativa.EJECUCION_CONTRACTUAL);
		
		
		} catch (SecuritySessionExpiredException e) {
			redirectSessionExpiredPage();
		} catch (SecurityRestrictedControlException e) {
			STATUS_ERROR();
			addMessageKey("msgsForm", Messages.getString("no.access"), e.getMessage(), FacesMessage.SEVERITY_ERROR);
		}  catch (SecurityValidateException e) {
			STATUS_ERROR();
			addMessageKey("msgsForm", e.getMessage(), FacesMessage.SEVERITY_ERROR);
		}  catch (RemoteException e) {
			STATUS_ERROR();
			addMessageKey("msgsForm", Messages.getString("sicu.remote.exeption"), e.getMessage(),
					FacesMessage.SEVERITY_ERROR);
		}  catch (Exception e) {
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

	    
	    contratoRequest.setEjercicio(2017);
	    contratoRequest.setCodUnidEjecutora(26);
	    //contratoRequest.setCentroCosto(usuario.getPeriodo().getCodigoCentroCosto());
	    contratoRequest.setEstado("0");
	    contratoRequest.setPageNumber(1);
	    contratoRequest.setPageSize(10);
	    
	   //contratoRequest
	    listaContratos=contratoBusiness.selectDynamicFull(contratoRequest);
	    System.out.println("El tamanio es "+listaContratos.size());	    
	    
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
	
	public void insertarContratos(){
		
		System.out.println("***************Fer5**************" + contratoResponse.getIdProcesoSeleccion());
		
		
		
	}
	
	
	@Autowired
	AdendaController adendaController;
	public String irAdenda() {
		boolean validado=false;
		try {
			securityControlValidate("btnAdenda");
			validateSelectedRow();
			String paramTitulo = new String((tituloParam!=null?tituloParam:"")+" "+tituloBase);
			adendaController.setTituloParam(paramTitulo);
			adendaController.init(contrato);

			validado=true;
		} catch (SecuritySessionExpiredException e) {
			redirectSessionExpiredPage();
		} catch (SecurityRestrictedControlException e) {
			STATUS_ERROR();
			addMessageKey("msgsForm", Messages.getString("no.access"),e.getMessage(),FacesMessage.SEVERITY_ERROR);
		} catch (SecurityValidateException e) {
			STATUS_ERROR();
			addMessageKey("msgsForm",e.getMessage(), FacesMessage.SEVERITY_ERROR);
		} catch (RemoteException e) {
			STATUS_ERROR();
			addMessageKey("msgsForm", Messages.getString("sicu.remote.exeption"),e.getMessage(),FacesMessage.SEVERITY_ERROR);
		} catch (UnselectedRowException e) {
			addMessageKey("msgsForm", e.getMessage(),
			FacesMessage.SEVERITY_ERROR);
			return null;
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
			return null;
		}
		if(validado) return "/pages/adenda/adendaBuscar.xhtml?faces-redirect=true";
		else return null;
	}
	
	public void validateSelectedRow() throws UnselectedRowException, CloneNotSupportedException {
		if (selectedContrato == null)
			throw new UnselectedRowException(Messages.getString("no.record.selected"));
		else
			contrato = (Contrato)selectedContrato.clone();
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

	public List<CentroCostoResponse> getListaCentroCosto() {
		return listaCentroCosto;
	}

	public void setListaCentroCosto(List<CentroCostoResponse> listaCentroCosto) {
		this.listaCentroCosto = listaCentroCosto;
	}

	public List<Gentabla> getListaEstadoFaseI() {
		return listaEstadoFaseI;
	}

	public void setListaEstadoFaseI(List<Gentabla> listaEstadoFaseI) {
		this.listaEstadoFaseI = listaEstadoFaseI;
	}

	public List<Gentabla> getListaEstadoFaseII() {
		return listaEstadoFaseII;
	}

	public void setListaEstadoFaseII(List<Gentabla> listaEstadoFaseII) {
		this.listaEstadoFaseII = listaEstadoFaseII;
	}


	public String getTituloParam() {
		return tituloParam;
	}


	public void setTituloParam(String tituloParam) {
		this.tituloParam = tituloParam;
	}


	public String getTituloBase() {
		return tituloBase;
	}


	public void setTituloBase(String tituloBase) {
		this.tituloBase = tituloBase;
	}


	public Contrato getContratoB() {
		return contratoB;
	}


	public void setContratoB(Contrato contratoB) {
		this.contratoB = contratoB;
	}


	public List<Gentabla> getListaGentablaIdcatalogosistemaadquisicion() {
		return listaGentablaIdcatalogosistemaadquisicion;
	}


	public void setListaGentablaIdcatalogosistemaadquisicion(List<Gentabla> listaGentablaIdcatalogosistemaadquisicion) {
		this.listaGentablaIdcatalogosistemaadquisicion = listaGentablaIdcatalogosistemaadquisicion;
	}


	public List<String> getListaIdcatalogosistemaadquisicionKeys() {
		return listaIdcatalogosistemaadquisicionKeys;
	}


	public void setListaIdcatalogosistemaadquisicionKeys(List<String> listaIdcatalogosistemaadquisicionKeys) {
		this.listaIdcatalogosistemaadquisicionKeys = listaIdcatalogosistemaadquisicionKeys;
	}
	
	
	
}
