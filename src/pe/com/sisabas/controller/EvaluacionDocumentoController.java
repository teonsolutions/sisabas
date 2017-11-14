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
import pe.com.sisabas.service.SicuCallService;
import java.rmi.RemoteException;
import pe.com.sisabas.exception.SecurityRestrictedControlException;
import pe.com.sisabas.exception.SecuritySessionExpiredException;
import pe.com.sisabas.exception.SecurityValidateException;
import pe.com.sisabas.be.Documentotecnico;
import pe.com.sisabas.business.DocumentotecnicoBusiness;
import pe.com.sisabas.business.GentablaBusiness;
import pe.com.sisabas.business.ProgramacionBusiness;
import pe.com.sisabas.dto.EvaluacionDocumentoRequest;
import pe.com.sisabas.dto.EvaluacionDocumentoResponse;
import pe.com.sisabas.dto.TransactionRequest;
import pe.com.sisabas.be.Gentabla;
import pe.com.sisabas.business.GentablaBusiness;
import pe.com.sisabas.be.Gentabla;

@Component(value = "evaluacionDocumento")
@Scope(value = "session")
public class EvaluacionDocumentoController extends BaseController {
	private static final long serialVersionUID = 1L;
	
	private List<Documentotecnico> listaDocumentotecnico;
	private List<EvaluacionDocumentoResponse> listaPedidos;
	private EvaluacionDocumentoResponse selectedPedido;
	private EvaluacionDocumentoResponse pedido;
	private boolean esSeleccionadoPorRecibir = false;
	private boolean esSeleccionadoPorAprobar = false;
			
	public boolean isEsSeleccionadoPorAprobar() {
		return esSeleccionadoPorAprobar;
	}

	public void setEsSeleccionadoPorAprobar(boolean esSeleccionadoPorAprobar) {
		this.esSeleccionadoPorAprobar = esSeleccionadoPorAprobar;
	}

	public Boolean getEsSeleccionadoPorRecibir() {
		return esSeleccionadoPorRecibir;
	}

	public void setEsSeleccionadoPorRecibir(Boolean esSeleccionadoPorRecibir) {
		this.esSeleccionadoPorRecibir = esSeleccionadoPorRecibir;
	}

	public EvaluacionDocumentoResponse getSelectedPedido() {
		return selectedPedido;
	}

	public void setSelectedPedido(EvaluacionDocumentoResponse selectedPedido) {
		this.selectedPedido = selectedPedido;
		
		//para activar button recibir
		boolean disabled = false;
		boolean disabledApprove = false;
		if (this.selectedPedido == null)
		{
			disabled = false;			
		}
		else{
			disabled = this.selectedPedido.getEstadoPedidoIn().equalsIgnoreCase("3");
			disabledApprove = this.selectedPedido.getEstadoPedidoIn().equalsIgnoreCase("4");
		}		
		this.setEsSeleccionadoPorRecibir(disabled);
		this.setEsSeleccionadoPorAprobar(disabledApprove);		
	}

		
	public List<EvaluacionDocumentoResponse> getListaPedidos() {
		return listaPedidos;
	}

	public void setListaPedidos(List<EvaluacionDocumentoResponse> listaPedidos) {
		this.listaPedidos = listaPedidos;
	}

	private Documentotecnico selectedDocumentotecnico;
	private Documentotecnico documentotecnicoB;
	private EvaluacionDocumentoRequest searchParam;

	public EvaluacionDocumentoRequest getSearchParam() {
		return searchParam;
	}

	public void setSearchParam(EvaluacionDocumentoRequest searchParam) {
		this.searchParam = searchParam;
	}

	private String tituloBase; // titulo de la opcion
	private String tituloParam;// titulo que llega como parametro (derivada
								// padre)

	private String idOpcionText = "OPC_DOCUMENTOTECNICO";

	@Autowired
	public pe.com.sisabas.resources.business.UtilsBusiness utilsBusiness;

	@Autowired
	public DocumentotecnicoBusiness business;

	
	@Autowired
	public ProgramacionBusiness businessProgramacion;
	
	
	public EvaluacionDocumentoController() {
		listaDocumentotecnico = new ArrayList<Documentotecnico>();
	}

	@PostConstruct
	public void init() {
		try {
			documentotecnicoB = new Documentotecnico();
			searchParam = new EvaluacionDocumentoRequest(); // search parameters

			tituloBase = "Evaluación de documento » ";
			if (SICU_SECURITY_ENABLE) {
				idOpcion = SicuCallService.obtenerIdOpcion(idOpcionText).toString();
				sicuopcion = SicuCallService.obtenercontroles(idOpcion);
			}

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

	// TITLE
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

	public void setSelectedDocumentotecnico(Documentotecnico selectedDocumentotecnico) {
		this.selectedDocumentotecnico = selectedDocumentotecnico;
	}

	public Documentotecnico getSelectedDocumentotecnico() {
		return selectedDocumentotecnico;
	}

	/* seleccionado */
	public void seleccionItem(SelectEvent e) {
		esSeleccionado = true;
	}

	public boolean isEsSeleccionado() {
		return esSeleccionado;
	}

	public void setEsSeleccionado(boolean esSeleccionado) {
		this.esSeleccionado = esSeleccionado;
	}

	// METHODS LISTA
	public void setListaDocumentotecnico(List<Documentotecnico> listaDocumentotecnico) {
		this.listaDocumentotecnico = listaDocumentotecnico;
	}

	public List<Documentotecnico> getListaDocumentotecnico() {
		return listaDocumentotecnico;
	}

	// SEARCH
	public void setDocumentotecnicoB(Documentotecnico documentotecnicoB) {
		this.documentotecnicoB = documentotecnicoB;
	}

	public Documentotecnico getDocumentotecnicoB() {
		return documentotecnicoB;
	}

	// METHOD PROGRMACION & COSTOS
	// ***********************************************************
	public void buscarPedidos() {
		listaDocumentotecnico = new ArrayList<Documentotecnico>();
		setEsSeleccionado(false);
		setSelectedDocumentotecnico(null);
		
		try {
			
			//Todos		
			//getPedidosEvaluacion
			searchParam.setIdUnidadEjecutora(1);
			searchParam.setAnio(2017);
			searchParam.setNroDocumento(null);
			//searchParam.setEstadoPedido(null);
			
			searchParam.setPageNumber(1);
			searchParam.setPageSize(10);
			
			listaPedidos = business.getPedidosEvaluacion(searchParam);
			setEsSeleccionado(false);
			setSelectedDocumentotecnico(null);
			if (listaPedidos.size() == 0)
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
		if (selectedDocumentotecnico == null)
			throw new UnselectedRowException(Messages.getString("no.record.selected"));
		else
			pedido = (EvaluacionDocumentoResponse)selectedPedido.clone();
	}
	

	public void irRecibir() {
		STATUS_INIT();
		try {
			securityControlValidate("btnRecibir");
			validateSelectedRow();

			STATUS_SUCCESS();
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
			STATUS_ERROR();
			addMessageKey("msgsForm", e.getMessage(),
			FacesMessage.SEVERITY_ERROR);
		} catch (Exception e) {
			STATUS_ERROR();
			addErrorMessageKey("msgsForm", e);
		}
	}	
	
	/*
	 * Recibir documento técnico
	 */
	public void recibir() {
		STATUS_INIT();
		try {
			securityControlValidate("btnRecibir");
			resetRegisterForm();
			// accion = REGISTRAR;
			TransactionRequest<Integer> request = new TransactionRequest<Integer>();
			request.setUsuarioAuditoria("PRUEBA");
			businessProgramacion.recibir(selectedPedido , request);				
			

			STATUS_SUCCESS();
			REGISTER_INIT();
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
			STATUS_ERROR();
			addErrorMessageKey("msgsForm", e);
		}
	}

	/*
	 * Aprobación o observar documento técnico
	 */
	public void irAprobar() {
		STATUS_INIT();
		try {
			securityControlValidate("btnAprobar");
			resetRegisterForm();

			STATUS_SUCCESS();
			REGISTER_INIT();

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
			STATUS_ERROR();
			addErrorMessageKey("msgsForm", e);
		}
	}
	
	public void aceptar(){
		REGISTER_INIT();
		try{
			
			showGrowlMessageSuccessfullyCompletedAction();
			
			buscarPedidos();
			REGISTER_SUCCESS();
			
			/*
		} catch (ValidateException e) {
			REGISTER_ERROR();
			addMessageKey("msgsDocumentotecnicoR", e.getMessage(),
			FacesMessage.SEVERITY_ERROR);
		} catch (BusinessException e) {
			REGISTER_ERROR();
			addMessageKey("msgsDocumentotecnicoR", e.getMessage(),
			FacesMessage.SEVERITY_ERROR);
			*/
		} catch(DataIntegrityViolationException e) {
			addMessageKey("msgsForm", Messages.getString("exception.dataintegrity.message.title"),Messages.getString("exception.dataintegrity.message.detail"),
			FacesMessage.SEVERITY_ERROR);
		} catch (Exception e) {
			REGISTER_ERROR();
			addErrorMessageKey("msgsDocumentotecnicoR", e);
		}
	}

	// METHOD PROGRMACION & COSTOS
	// ***********************************************************
}
