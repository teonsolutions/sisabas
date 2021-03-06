package pe.com.sisabas.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.taglibs.standard.lang.jstl.Evaluator;
import org.omg.CORBA.TRANSACTION_MODE;
import org.postgresql.core.SetupQueryRunner;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;
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
import pe.com.sisabas.service.Sicuusuario;

import java.rmi.RemoteException;
import pe.com.sisabas.exception.SecurityRestrictedControlException;
import pe.com.sisabas.exception.SecuritySessionExpiredException;
import pe.com.sisabas.exception.SecurityValidateException;
import pe.com.sisabas.be.Documentotecnico;
import pe.com.sisabas.business.DocumentotecnicoBusiness;
import pe.com.sisabas.business.GentablaBusiness;
import pe.com.sisabas.business.ObservacionesdocumentotecnicoBusiness;
import pe.com.sisabas.business.ProgramacionBusiness;
import pe.com.sisabas.business.SeccionesdocumentotecnicoBusiness;
import pe.com.sisabas.dto.EstadoRequerimientoResponse;
import pe.com.sisabas.dto.EvaluacionDocumentoRequest;
import pe.com.sisabas.dto.EvaluacionDocumentoResponse;
import pe.com.sisabas.dto.ObservacionDocumentoTecnicoDto;
import pe.com.sisabas.dto.OrdenDto;
import pe.com.sisabas.dto.TransactionRequest;
import pe.com.sisabas.be.Gentabla;
import pe.com.sisabas.be.Observacionesdocumentotecnico;
import pe.com.sisabas.be.Seccionesdocumentotecnico;
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
	private int selectAprobacion = 1;
	public List<EstadoRequerimientoResponse> listaEstadoRequerimiento;
	private List<ObservacionDocumentoTecnicoDto> listaObservaciones;
	private List<Seccionesdocumentotecnico> listaSecciones;

	public int getSelectAprobacion() {
		return selectAprobacion;
	}

	public void setSelectAprobacion(int selectAprobacion) {
		this.selectAprobacion = selectAprobacion;
	}

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

		// para activar button recibir
		boolean disabled = false;
		boolean disabledApprove = false;
		if (this.selectedPedido == null) {
			disabled = false;
		} else {
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

	public List<ObservacionDocumentoTecnicoDto> getListaObservaciones() {
		return listaObservaciones;
	}

	public void setListaObservaciones(List<ObservacionDocumentoTecnicoDto> listaObservaciones) {
		this.listaObservaciones = listaObservaciones;
	}

	public List<Seccionesdocumentotecnico> getListaSecciones() {
		return listaSecciones;
	}

	public void setListaSecciones(List<Seccionesdocumentotecnico> listaSecciones) {
		this.listaSecciones = listaSecciones;
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

	@Autowired
	public GentablaBusiness gentablaBusiness;

	@Autowired
	public SeccionesdocumentotecnicoBusiness seccionesdocumentotecnicoBusiness;

	@Autowired
	public ObservacionesdocumentotecnicoBusiness observacionesdocumentotecnicoBusiness;

	public EvaluacionDocumentoController() {
		listaDocumentotecnico = new ArrayList<Documentotecnico>();
	}

	@PostConstruct
	public void init() {
		try {
			documentotecnicoB = new Documentotecnico();
			searchParam = new EvaluacionDocumentoRequest(); // search parameters

			tituloBase = "Evaluaci�n de documento � ";
			if (SICU_SECURITY_ENABLE) {
				idOpcion = SicuCallService.obtenerIdOpcion(idOpcionText).toString();
				sicuopcion = SicuCallService.obtenercontroles(idOpcion);
			}

			listaEstadoRequerimiento = gentablaBusiness
					.getEstadoRequerimiento(Constantes.etapaAdministrativa.PROGRAMACION_Y_COSTOS);
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

	public List<EstadoRequerimientoResponse> getListaEstadoRequerimiento() {
		return listaEstadoRequerimiento;
	}

	public void setListaEstadoRequerimiento(List<EstadoRequerimientoResponse> listaEstadoRequerimiento) {
		this.listaEstadoRequerimiento = listaEstadoRequerimiento;
	}

	// METHOD PROGRMACION & COSTOS
	// ***********************************************************
	public void buscarPedidos() {
		listaDocumentotecnico = new ArrayList<Documentotecnico>();
		setEsSeleccionado(false);
		setSelectedDocumentotecnico(null);

		try {
			Sicuusuario usuario = (Sicuusuario) getHttpSession().getAttribute("sicuusuarioSESSION");

			// Todos
			// getPedidosEvaluacion
			searchParam.setIdUnidadEjecutora(Constantes.unidadEjecutora.ID_UNIDAD_EJECUTORA_ABAS);
			searchParam.setAnio(usuario.getPeriodo().getAnio());
			searchParam.setPageNumber(1);
			searchParam.setPageSize(10);

			listaPedidos = business.getPedidosEvaluacion(searchParam);
			setEsSeleccionado(false);
			setSelectedDocumentotecnico(null);
			if (listaPedidos.size() == 0)
				addMessageKey("msgsForm", Messages.getString("no.records.found"), FacesMessage.SEVERITY_INFO);

		} catch (SecuritySessionExpiredException e) {
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

	public void resetRegisterForm() {
		reset("frmDocumentotecnicoRegistrar:panelC");
	}

	public void validateSelectedRow() throws UnselectedRowException, CloneNotSupportedException {
		if (selectedPedido == null)
			throw new UnselectedRowException(Messages.getString("no.record.selected"));
		else
			pedido = (EvaluacionDocumentoResponse) selectedPedido.clone();
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
			addMessageKey("msgsForm", Messages.getString("no.access"), e.getMessage(), FacesMessage.SEVERITY_ERROR);
		} catch (SecurityValidateException e) {
			STATUS_ERROR();
			addMessageKey("msgsForm", e.getMessage(), FacesMessage.SEVERITY_ERROR);
		} catch (RemoteException e) {
			STATUS_ERROR();
			addMessageKey("msgsForm", Messages.getString("sicu.remote.exeption"), e.getMessage(),
					FacesMessage.SEVERITY_ERROR);
		} catch (UnselectedRowException e) {
			STATUS_ERROR();
			addMessageKey("msgsForm", e.getMessage(), FacesMessage.SEVERITY_ERROR);
		} catch (Exception e) {
			STATUS_ERROR();
			addErrorMessageKey("msgsForm", e);
		}
	}

	/*
	 * Recibir documento t�cnico
	 */
	public void recibir() {
		REGISTER_INIT();
		try {
			securityControlValidate("btnRecibir");
			validateSelectedRow();

			TransactionRequest<Integer> request = new TransactionRequest<Integer>();
			request.setUsuarioAuditoria(getUserLogin());
			request.setEquipoAuditoria(getRemoteAddr());
			businessProgramacion.recibirDocumentoTecnico(pedido, request);

			showGrowlMessageSuccessfullyCompletedAction();
			buscarPedidos();
			this.setEsSeleccionadoPorRecibir(false);
			this.setEsSeleccionadoPorAprobar(false);
			
			REGISTER_SUCCESS();
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
	 * Aprobaci�n o observar documento t�cnico
	 */
	public void irAprobar() {
		STATUS_INIT();
		try {
			securityControlValidate("btnAprobar");
			resetRegisterForm();

			/*
			Seccionesdocumentotecnico param = new Seccionesdocumentotecnico();
			param.setIdcatalogotipodocumentotecnico(this.selectedPedido.getIdCatalogoTipoDocumentoTecnico() == null
					? this.selectedPedido.getTipoBienDesc().equals("BIEN")
							? Constantes.tipoDocumentoTecnico.ESPECIFICACION_TECNICA
							: Constantes.tipoDocumentoTecnico.TERMINO_REFERENCIA
					: this.selectedPedido.getIdCatalogoTipoDocumentoTecnico());
			*/
			
			listaSecciones = seccionesdocumentotecnicoBusiness
					.selectByTipoDocumentoTecnico(this.selectedPedido.getIdCatalogoTipoDocumentoTecnico() == null
							? this.selectedPedido.getTipoBienDesc().equals("BIEN")
									? Constantes.tipoDocumentoTecnico.ESPECIFICACION_TECNICA
									: Constantes.tipoDocumentoTecnico.TERMINO_REFERENCIA
							: this.selectedPedido.getIdCatalogoTipoDocumentoTecnico());						

			listaObservaciones = new ArrayList<ObservacionDocumentoTecnicoDto>();			
			setSelectAprobacion(1);

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

	public void aprobar() {
		REGISTER_INIT();
		try {
			securityControlValidate("btnAprobar");
			validateSelectedRow();

			TransactionRequest<EvaluacionDocumentoResponse> request = new TransactionRequest<EvaluacionDocumentoResponse>();
			request.setUsuarioAuditoria(getUserLogin());
			request.setEquipoAuditoria(getRemoteAddr());
			pedido.setObservaciones(listaObservaciones);
			request.setEntityTransaction(pedido);			

			if (this.selectAprobacion == 1) { //APROBADO
				businessProgramacion.aprobarDocumentoTecnico(pedido, request);
			} else {
				businessProgramacion.observarDocumentoTecnico(request);
			}

			showGrowlMessageSuccessfullyCompletedAction();
			buscarPedidos();
			this.setEsSeleccionadoPorRecibir(false);
			this.setEsSeleccionadoPorAprobar(false);
			
			REGISTER_SUCCESS();
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

	public void irImprimir() {
		STATUS_INIT();
		try {
			securityControlValidate("btnImprimir");
			// resetRegisterForm();
			// accion = IMPRIMIR;
			tituloBase = "Evaluaci�n de documento � " + IMPRIMIR;

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

	public void aceptar() {
		REGISTER_INIT();
		try {

			showGrowlMessageSuccessfullyCompletedAction();

			buscarPedidos();
			REGISTER_SUCCESS();
			/*
			 * } catch (ValidateException e) { REGISTER_ERROR();
			 * addMessageKey("msgsDocumentotecnicoR", e.getMessage(),
			 * FacesMessage.SEVERITY_ERROR); } catch (BusinessException e) {
			 * REGISTER_ERROR(); addMessageKey("msgsDocumentotecnicoR",
			 * e.getMessage(), FacesMessage.SEVERITY_ERROR);
			 */
		} catch (DataIntegrityViolationException e) {
			addMessageKey("msgsForm", Messages.getString("exception.dataintegrity.message.title"),
					Messages.getString("exception.dataintegrity.message.detail"), FacesMessage.SEVERITY_ERROR);
		} catch (Exception e) {
			REGISTER_ERROR();
			addErrorMessageKey("msgsDocumentotecnicoR", e);
		}
	}

	// METHOD PROGRMACION & COSTOS
	// ***********************************************************
	// DATATABLE EDITABLE
	public void onRowEdit(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Se edit� correctamente", "Observaci�n: "
				+ ((ObservacionDocumentoTecnicoDto) event.getObject()).getIdobservacionesdocumentotecnico());
		
		try {
		Integer key = ((ObservacionDocumentoTecnicoDto) event.getObject()).getIdseccionesdocumentotecnico();
		Seccionesdocumentotecnico seccion = seccionesdocumentotecnicoBusiness.selectByPrimaryKeyBasic(key);
		((ObservacionDocumentoTecnicoDto) event.getObject()).setDescripcionseccion(seccion != null? seccion.getDescripcionseccion(): "");
		
		} catch (DataIntegrityViolationException e) {
			addMessageKey("msgsForm", Messages.getString("exception.dataintegrity.message.title"),
					Messages.getString("exception.dataintegrity.message.detail"), FacesMessage.SEVERITY_ERROR);
		} catch (Exception e) {
			REGISTER_ERROR();
			addErrorMessageKey("msgsDocumentotecnicoR", e);
		}
		
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onRowCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Se cancel� la edici�n", "Observaci�n: "
				+ ((ObservacionDocumentoTecnicoDto) event.getObject()).getIdobservacionesdocumentotecnico());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void irRegistrarObservacion() {
		STATUS_INIT();
		try {
			securityControlValidate("btnNuevaObservacion");
			// validateSelectedRow();

			ObservacionDocumentoTecnicoDto e = new ObservacionDocumentoTecnicoDto();
			if (listaObservaciones.size() == 0)
				e.setIdobservacionesdocumentotecnico(1);
			else
				e.setIdobservacionesdocumentotecnico(listaObservaciones.size() + 1);
			listaObservaciones.add(e);

			STATUS_SUCCESS();
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
		} catch (UnselectedRowException e) {
			STATUS_ERROR();
			addMessageKey("msgsForm", e.getMessage(), FacesMessage.SEVERITY_ERROR);
		} catch (Exception e) {
			STATUS_ERROR();
			addErrorMessageKey("msgsForm", e);
		}
	}
	
	public void onCellEdit(CellEditEvent event) {
		Object oldValue = event.getOldValue();
		Object newValue = event.getNewValue();

		if (newValue != null && !newValue.equals(oldValue)) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed",
					"Old: " + oldValue + ", New:" + newValue);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}
}
