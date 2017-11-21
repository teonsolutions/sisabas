package pe.com.sisabas.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;

import org.apache.taglibs.standard.lang.jstl.Evaluator;
import org.omg.CORBA.TRANSACTION_MODE;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.ToggleSelectEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.dao.DataIntegrityViolationException;

import pe.com.sisabas.exception.BusinessException;
import pe.com.sisabas.exception.UnselectedRowException;
import pe.com.sisabas.exception.ValidateException;

import pe.com.sisabas.resources.controller.BaseController;
import pe.com.sisabas.resources.Messages;
import pe.com.sisabas.resources.Constantes;
import pe.com.sisabas.resources.Utils;
import pe.com.sisabas.resources.UtilsSecurity;
import pe.com.sisabas.service.SicuCallService;
import java.rmi.RemoteException;
import pe.com.sisabas.exception.SecurityRestrictedControlException;
import pe.com.sisabas.exception.SecuritySessionExpiredException;
import pe.com.sisabas.exception.SecurityValidateException;
import pe.com.sisabas.be.Documentotecnico;
import pe.com.sisabas.business.DocumentotecnicoBusiness;
import pe.com.sisabas.business.GentablaBusiness;
import pe.com.sisabas.business.ProgramacionBusiness;
import pe.com.sisabas.dto.CompraDirectaDatosGeneralesDto;
import pe.com.sisabas.dto.EvaluacionDocumentoRequest;
import pe.com.sisabas.dto.EvaluacionDocumentoResponse;
import pe.com.sisabas.dto.PacItemsDto;
import pe.com.sisabas.dto.PedidosPaoResponse;
import pe.com.sisabas.dto.Resultado;
import pe.com.sisabas.dto.PaoRequest;
import pe.com.sisabas.dto.PaoResponse;
import pe.com.sisabas.dto.TransactionRequest;
import pe.com.sisabas.be.Gentabla;
import pe.com.sisabas.business.GentablaBusiness;
import pe.com.sisabas.be.Gentabla;

import pe.com.sisabas.resources.controller.BaseController;

@Component(value = "programacion")
@Scope(value = "session")
public class ProgramacionController extends BaseController{
	private static final long serialVersionUID = 1L;

	//PROPERTIES
	private List<PaoResponse> listaPao;
	private PaoResponse selectedPao;
	private PaoRequest searchParam;
	private PaoResponse currentPao;
	private String tituloBase; // titulo de la opcion
	private String tituloParam;// titulo que llega como parametro (derivada
								// padre)	
	//To functionality
	private boolean disabledTabEstudioMercado;
	private boolean disabledTabOrden;

	private String idOpcionText = "OPC_PAO";
	public List<Gentabla> listaGentablaIdcatalogoestadopac;
	public List<Gentabla> listaGentablaIdcatalogotipobien;
	public List<Gentabla> listaGentablaIdcatalogotiponecesidad;
	public List<Gentabla> listaGentablaIdcatalogotipocontratacion;
	
	//Direct
	public static String SUCCESS_ORDEN="/pages/pao/ordenRegistrar.xhtml?faces-redirect=true;";
	
	//BUSINESS SECTION
	@Autowired
	public pe.com.sisabas.resources.business.UtilsBusiness utilsBusiness;
	
	@Autowired
	public GentablaBusiness gentablaBusiness;
	
	@Autowired
	public ProgramacionBusiness programacionBusiness;
	
	public ProgramacionController(){
		
	}
	
	@PostConstruct
	public void init(){
		try {
			searchParam = new PaoRequest(); // search parameters
			tituloBase = "PAO » ";
			if (SICU_SECURITY_ENABLE) {
				idOpcion = SicuCallService.obtenerIdOpcion(idOpcionText).toString();
				sicuopcion = SicuCallService.obtenercontroles(idOpcion);
			}

			//´Fill combo filters
			
			/*
			 * listaIdcatalogotipodocumentotecnicoKeys= new ArrayList<String>();
			 * listaIdcatalogotipotdrKeys= new ArrayList<String>();
			 * 
			 * listaGentablaIdcatalogotipodocumentotecnico =
			 * gentablaBusiness.selectDynamicBasic(new Gentabla());
			 * listaGentablaIdcatalogotipotdr =
			 * gentablaBusiness.selectDynamicBasic(new
			 * Gentabla().getObjBusqueda(Constantes.tabla.TITD));
			 */

			listaGentablaIdcatalogoestadopac = gentablaBusiness.selectDynamicBasic(new Gentabla().getObjBusqueda(Constantes.tabla.EPAC));
			listaGentablaIdcatalogotipobien = gentablaBusiness.selectDynamicBasic(new Gentabla().getObjBusqueda(Constantes.tabla.TIBI));
			listaGentablaIdcatalogotiponecesidad = gentablaBusiness.selectDynamicBasic(new Gentabla().getObjBusqueda(Constantes.tabla.TINE));
			listaGentablaIdcatalogotipocontratacion = gentablaBusiness.selectDynamicBasic(new Gentabla().getObjBusqueda(Constantes.tabla.TCON));
			
		} catch (SecuritySessionExpiredException e) {
			redirectSessionExpiredPage();
		} catch (SecurityRestrictedControlException e) {
			STATUS_ERROR();
			addMessageKey("msgsForm", Messages.getString("no.access"), e.getMessage(), FacesMessage.SEVERITY_ERROR);
		} catch (SecurityValidateException e) {
			STATUS_ERROR();
			addMessageKey("msgsForm", e.getMessage(), FacesMessage.SEVERITY_ERROR);
		} catch (RemoteException e) {
			STATUS_ERROR();
			addMessageKey("msgsForm", Messages.getString("sicu.remote.exeption"), e.getMessage(),
					FacesMessage.SEVERITY_ERROR);
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}		
	}
	
	//METHODS
	public void buscarPao(){

		try{
			this.searchParam.setCodigoUnidadEjecutora(Constantes.unidadEjecutora.PRONIED);
			this.searchParam.setAnio(2017);
			this.searchParam.setPageNumber(1);
			this.searchParam.setPageSize(10);
			
			this.listaPao = programacionBusiness.getPaoListado(searchParam);
			this.setEsSeleccionado(false);
			if (listaPao.size() == 0)
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
	
	public void resetRegisterForm() {
		reset("frmDocumentotecnicoRegistrar:panelC");
	}
	
	public void validateSelectedRow() throws UnselectedRowException, CloneNotSupportedException {
		if (this.selectedPao == null)
			throw new UnselectedRowException(Messages.getString("no.record.selected"));
		else
			this.setCurrentPao((PaoResponse)this.selectedPao.clone());
	}	
	
	public String ordenRegistrar()
	{
		logger.debug("paoRegistrar....");	
		try {
			
			validateSelectedRow();
			if (this.esSeleccionado){
				
			}
			if (this.currentPao == null){
				this.currentPao = new PaoResponse();
			}
			
			this.setDisabledTabEstudioMercado(this.currentPao.getIdPacConsolid() == null || this.currentPao.getIdPacConsolid() == 0);			
			this.setDisabledTabOrden(this.currentPao.getIdPacConsolid() == null || this.currentPao.getIdPacConsolid() == 0);
			
			PaoRequest record = new PaoRequest();
			record.setIdUnidadEjecutora(1);
			record.setAnio(2017);
			record.setNroConsolid(this.currentPao.getNroConsolid());
			record.setIdUnidadEjecutoraSiaf(Constantes.unidadEjecutora.PRONIED_SIAF);			
			CompraDirectaDatosGeneralesDto cd = programacionBusiness.getCompraDirectaDatosGenerales(record);
			this.currentPao.setCompraDirecta(cd);		
					
			/*
		} catch (RemoteException e) {
			STATUS_ERROR();				
			addMessageKey("msgsForm", Messages.getString("sicu.remote.exeption"),e.getMessage(),
					FacesMessage.SEVERITY_ERROR);
			return "/login.xhtml";
		} catch (ValidateException e) {			
			addMessage(e.getMessage(),
			FacesMessage.SEVERITY_ERROR);
			return "/login.xhtml";
			*/
		} catch (Exception e) {
			addErrorMessage(e);
			return "/login.xhtml";
		}		
			
		return SUCCESS_ORDEN;
	}
	
	public void guardarDatosGenerales() {
		REGISTER_INIT();
	try {

		TransactionRequest<CompraDirectaDatosGeneralesDto> transactionRequest = new TransactionRequest<CompraDirectaDatosGeneralesDto>();
		transactionRequest.setUsuarioAuditoria("PRUEBA");
		transactionRequest.setEquipoAuditoria("MI PC");
		transactionRequest.setEntityTransaction(this.currentPao.getCompraDirecta());		
		Resultado result = programacionBusiness.grabarCompraDirecta(transactionRequest);
		
		showGrowlMessageSuccessfullyCompletedAction();
		buscarPao();

		REGISTER_SUCCESS();
	} catch (ValidateException e) {
		REGISTER_ERROR();
		addMessageKey("msgsDocumentotecnicoR", e.getMessage(),
		FacesMessage.SEVERITY_ERROR);
	} catch (BusinessException e) {
		REGISTER_ERROR();
		addMessageKey("msgsDocumentotecnicoR", e.getMessage(),
		FacesMessage.SEVERITY_ERROR);
	} catch(DataIntegrityViolationException e) {
		addMessageKey("msgsForm", Messages.getString("exception.dataintegrity.message.title"),Messages.getString("exception.dataintegrity.message.detail"),
		FacesMessage.SEVERITY_ERROR);
	} catch (Exception e) {
		REGISTER_ERROR();
		addErrorMessageKey("msgsDocumentotecnicoR", e);
	}
}
	
	//PROPERTIES	
	public List<PaoResponse> getListaPao() {
		return listaPao;
	}

	public void setListaPao(List<PaoResponse> listaPao) {
		this.listaPao = listaPao;
	}

	public PaoResponse getSelectedPao() {
		return selectedPao;
	}

	public void setSelectedPao(PaoResponse selectedPao) {
		this.selectedPao = selectedPao;
	}

	public PaoRequest getSearchParam() {
		return searchParam;
	}

	public void setSearchParam(PaoRequest searchParam) {
		this.searchParam = searchParam;
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

	public PaoResponse getCurrentPao() {
		return currentPao;
	}

	public void setCurrentPao(PaoResponse currentPao) {
		this.currentPao = currentPao;
	}

	public List<Gentabla> getListaGentablaIdcatalogoestadopac() {
		return listaGentablaIdcatalogoestadopac;
	}

	public void setListaGentablaIdcatalogoestadopac(List<Gentabla> listaGentablaIdcatalogoestadopac) {
		this.listaGentablaIdcatalogoestadopac = listaGentablaIdcatalogoestadopac;
	}

	public List<Gentabla> getListaGentablaIdcatalogotipobien() {
		return listaGentablaIdcatalogotipobien;
	}

	public void setListaGentablaIdcatalogotipobien(List<Gentabla> listaGentablaIdcatalogotipobien) {
		this.listaGentablaIdcatalogotipobien = listaGentablaIdcatalogotipobien;
	}

	public List<Gentabla> getListaGentablaIdcatalogotiponecesidad() {
		return listaGentablaIdcatalogotiponecesidad;
	}

	public void setListaGentablaIdcatalogotiponecesidad(List<Gentabla> listaGentablaIdcatalogotiponecesidad) {
		this.listaGentablaIdcatalogotiponecesidad = listaGentablaIdcatalogotiponecesidad;
	}

	public List<Gentabla> getListaGentablaIdcatalogotipocontratacion() {
		return listaGentablaIdcatalogotipocontratacion;
	}

	public void setListaGentablaIdcatalogotipocontratacion(List<Gentabla> listaGentablaIdcatalogotipocontratacion) {
		this.listaGentablaIdcatalogotipocontratacion = listaGentablaIdcatalogotipocontratacion;
	}
	
	public boolean isDisabledTabEstudioMercado() {
		return disabledTabEstudioMercado;
	}

	public void setDisabledTabEstudioMercado(boolean disabledTabEstudioMercado) {
		this.disabledTabEstudioMercado = disabledTabEstudioMercado;
	}

	public boolean isDisabledTabOrden() {
		return disabledTabOrden;
	}

	public void setDisabledTabOrden(boolean disabledTabOrden) {
		this.disabledTabOrden = disabledTabOrden;
	}
	
	
}
