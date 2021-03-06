package pe.com.sisabas.controller;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

import org.primefaces.component.datatable.DataTable;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import pe.com.sisabas.be.Calendarioprocesoseleccion;
import pe.com.sisabas.be.Convocatoriaprocesoseleccion;
import pe.com.sisabas.be.Cuadrocomparativofuente;
import pe.com.sisabas.be.Gentabla;
import pe.com.sisabas.be.Miembrocomiteporproceso;
import pe.com.sisabas.be.Procesoseleccion;
import pe.com.sisabas.be.Resultadoprocesoseleccion;
import pe.com.sisabas.business.ConvocatoriaprocesoseleccionBusiness;
import pe.com.sisabas.business.GentablaBusiness;
import pe.com.sisabas.business.MiembrocomiteporprocesoBusiness;
import pe.com.sisabas.business.ProcesoBusiness;
import pe.com.sisabas.business.ProcesoseleccionBusiness;
import pe.com.sisabas.business.ResultadoprocesoporusuarioBusiness;
import pe.com.sisabas.business.VcentrocostoBusiness;
import pe.com.sisabas.dto.CalendarioDto;
import pe.com.sisabas.dto.CentroCostoRequest;
import pe.com.sisabas.dto.CentroCostoResponse;
import pe.com.sisabas.dto.ContratoSigaRequest;
import pe.com.sisabas.dto.ConvocatoriaDto;
import pe.com.sisabas.dto.CuadroComparativoRequest;
import pe.com.sisabas.dto.EstadoRequerimientoResponse;
import pe.com.sisabas.dto.ItemIntResponse;
import pe.com.sisabas.dto.OrdenDto;
import pe.com.sisabas.dto.PacConsolidadoDto;
import pe.com.sisabas.dto.PaoRequest;
import pe.com.sisabas.dto.PaoResponse;
import pe.com.sisabas.dto.ProcesoDto;
import pe.com.sisabas.dto.ProcesoExportDto;
import pe.com.sisabas.dto.ProcesoExportRequest;
import pe.com.sisabas.dto.ProcesoRequest;
import pe.com.sisabas.dto.ProcesoResultadoItemDto;
import pe.com.sisabas.dto.Resultado;
import pe.com.sisabas.dto.TipoProcesoResponse;
import pe.com.sisabas.dto.TransactionRequest;
import pe.com.sisabas.exception.BusinessException;
import pe.com.sisabas.exception.SecurityRestrictedControlException;
import pe.com.sisabas.exception.SecuritySessionExpiredException;
import pe.com.sisabas.exception.SecurityValidateException;
import pe.com.sisabas.exception.UnselectedRowException;
import pe.com.sisabas.exception.ValidateException;
import pe.com.sisabas.persistence.ConvocatoriaprocesoseleccionMapper;
import pe.com.sisabas.persistence.ProcesoseleccionMapper;
import pe.com.sisabas.resources.Constantes;
import pe.com.sisabas.resources.Messages;
import pe.com.sisabas.resources.Utils;
import pe.com.sisabas.resources.controller.BaseController;
import pe.com.sisabas.service.SicuCallService;
import pe.com.sisabas.service.Sicuusuario;

@Component(value = "proceso")
@Scope(value = "session")
public class ProcesoController extends BaseController {
	private static final long serialVersionUID = 1L;

	private List<ProcesoDto> dataList;
	private ProcesoDto selectedRow;
	private ProcesoRequest searchParam;
	private ProcesoDto currentRow;
	private Procesoseleccion processEdit;

	// Title
	private String tituloBase;
	private String tituloParam;
	private String accion;

	// DropDownList
	public List<Gentabla> listaGentablaIdcatalogotipobien;
	public List<TipoProcesoResponse> listaTipoProceso;
	public List<CentroCostoResponse> listaCentroCosto;
	public List<EstadoRequerimientoResponse> listaEstadoRequerimiento;
	private List<Miembrocomiteporproceso> listaMiembrocomiteporproceso;
	private List<Gentabla> listaSistemaContratacion;
	private List<Gentabla> listaGentablaIdcatalogoestadoconvocatoria;
	private List<Gentabla> listaGentablaIdcatalogoestadopublicacion;
	private List<Gentabla> listaGentablaIdcatalogoestadoresultado;

	private List<ConvocatoriaDto> listConvocatoria;
	private List<CalendarioDto> listCalendario;
	private List<ProcesoResultadoItemDto> listResultado;
	private List<ProcesoResultadoItemDto> listResultadoSend;

	private String idOpcionText = "OPC_PROCESO";
	public static String SUCCESS_SEGUIMIENTO = "/pages/proceso/procesoSeguimiento.xhtml?faces-redirect=true;";
	private boolean disabledButtons;

	// selected
	private ConvocatoriaDto currentConvocatoria;
	private ConvocatoriaDto selectedConvocatoria;
	private CalendarioDto selectedCalendadio;
	private ProcesoResultadoItemDto selectedResultado;
	private boolean esSeleccionadoConvocatoria;
	private boolean isCalendarEditing = false;
	private boolean disabledTabCalendar;
	
	//To export
	private List<ProcesoExportDto> dataListToExport;

	// Business layer section
	@Autowired
	public pe.com.sisabas.resources.business.UtilsBusiness utilsBusiness;
	@Autowired
	public GentablaBusiness gentablaBusiness;
	@Autowired
	public ProcesoBusiness procesoBusiness;
	@Autowired
	public VcentrocostoBusiness vcentrocostoBusiness;
	@Autowired
	public MiembrocomiteporprocesoBusiness miembrocomiteporprocesoBusiness;
	@Autowired
	public ProcesoseleccionBusiness procesoseleccionBusiness;
	@Autowired
	public ConvocatoriaprocesoseleccionBusiness convocatoriaprocesoseleccionBusiness;

	private boolean value1;
	private boolean value2;
	private boolean value3;
	private boolean value4;
	private boolean value5;
	private boolean value6;
	private boolean value7;
	private boolean value8;
	private boolean value9;
	private boolean value10;
	private boolean value11;
	private boolean value12;
	
	public ProcesoController() {

	}

	public String load() {
		return "/pages/proceso/procesoBuscar.xhtml?faces-redirect=true";
	}

	@PostConstruct
	public void init() {
		searchParam = new ProcesoRequest();
		tituloBase = "Proceso � ";

		try {
			if (SICU_SECURITY_ENABLE) {
				idOpcion = SicuCallService.obtenerIdOpcion(idOpcionText).toString();
				sicuopcion = SicuCallService.obtenercontroles(idOpcion);
			}
			Sicuusuario usuario = (Sicuusuario) getHttpSession().getAttribute("sicuusuarioSESSION");
			listaGentablaIdcatalogotipobien = gentablaBusiness
					.selectDynamicBasic(new Gentabla().getObjBusqueda(Constantes.tabla.TIBI));
			listaTipoProceso = gentablaBusiness.getTipoProceso(usuario.getPeriodo().getAnio());

			CentroCostoRequest param = new CentroCostoRequest();
			param.setCodigoUnidadEjecuta(Constantes.unidadEjecutora.PRONIED);
			param.setIdPeriodo(usuario.getPeriodo().getIdPeriodo());
			listaCentroCosto = vcentrocostoBusiness.getCentroCosto(param);

			listaEstadoRequerimiento = gentablaBusiness
					.getEstadoRequerimiento(Constantes.etapaAdministrativa.PROCESOS_DE_SELECCION);
			EstadoRequerimientoResponse newEstado = new EstadoRequerimientoResponse(
					Constantes.estadosPorEtapa.REMITIDO_A_EJECUCION,
					Constantes.estadosPorTipoDocumentoDesc.REMITIDO_A_EJECUCION,
					Constantes.estadosPorTipoDocumento.REMITIDO_A_EJECUCION);
			listaEstadoRequerimiento.add(0, newEstado);

			listaSistemaContratacion = gentablaBusiness
					.selectDynamicBasic(new Gentabla().getObjBusqueda(Constantes.tabla.SICP));
			/*
			 * listaGentablaIdcatalogoestadoconvocatoria = gentablaBusiness
			 * .selectDynamicBasic(new
			 * Gentabla().getObjBusqueda(Constantes.tabla.ECPR));
			 */
			listaGentablaIdcatalogoestadoconvocatoria = gentablaBusiness.selectByTypeCustom(Constantes.tabla.ECPR,
					Constantes.estadoAuditoriaFilter.INACTIVO);

			listaGentablaIdcatalogoestadopublicacion = gentablaBusiness
					.selectDynamicBasic(new Gentabla().getObjBusqueda(Constantes.tabla.EEPR));

			listaGentablaIdcatalogoestadoresultado = gentablaBusiness.selectByTypeCustom(Constantes.tabla.EPRI,
					Constantes.estadoAuditoriaFilter.INACTIVO);

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

	public void onCellEdit(CellEditEvent event) {
		Object oldValue = event.getOldValue();
		Object newValue = event.getNewValue();

		String descripcion = "";
		int rowIndex = event.getRowIndex();

		ProcesoResultadoItemDto item = this.listResultadoSend.get(rowIndex);
		if (item.getDestino().equals(Constantes.destinoRemisionProceso.EJECUCION_CONTRACTUAL)) {
			descripcion = "EJECUCI�N CONTRACTUAL";
		} else if (item.getDestino().equals(Constantes.destinoRemisionProceso.PROCESO_SELECCION)) {
			descripcion = "COORDINADOR DE PROCESO DE SELECCI�N";
		} else if (item.getDestino().equals(Constantes.destinoRemisionProceso.PROGRAMACION_COSTOS)) {
			descripcion = "PROGRAMACI�N Y COSTOS";
		}

		this.listResultadoSend.get(rowIndex).setDestinodescripcion(descripcion);

		if (newValue != null && !newValue.equals(oldValue)) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed",
					"Old: " + oldValue + ", New:" + newValue);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}

	public void seleccionItemConvocatoria(SelectEvent e) {
		ConvocatoriaDto c = (ConvocatoriaDto) e.getObject();
		if (c.getEstadoconvocatoriaitem().equals(Constantes.estadoConvocatoriaItem.REGISTRADO)) {
			esSeleccionadoConvocatoria = true;
		} else {
			esSeleccionadoConvocatoria = false;
		}
	}

	public String goSeguimiento() {
		logger.debug("pacRegistrar....");
		try {

			// URLReader reader = new URLReader();
			// reader.ReadPage("");

			// Sicuusuario usuario = (Sicuusuario)
			// getHttpSession().getAttribute("sicuusuarioSESSION");
			validateSelectedRow();
			if (this.esSeleccionado) {
			}

			this.processEdit = procesoseleccionBusiness.selectByPrimaryKeyBasic(currentRow.getIdProcesoSeleccion());
			// Get miembros de comite por proceso
			listaMiembrocomiteporproceso = miembrocomiteporprocesoBusiness.selectDynamicFullByIdComiteProceso(
					this.currentRow.getIdComiteProceso() != null ? this.currentRow.getIdComiteProceso() : 0);

			// list convocatorias
			searchConvocatoria();
			activeTabs();
		} catch (Exception e) {
			addErrorMessage(e);
			return "/login.xhtml";
		}

		return SUCCESS_SEGUIMIENTO;
	}

	public void searchConvocatoria() {
		STATUS_INIT();
		try {
			this.listConvocatoria = procesoBusiness.searchConvocatoriaProceso(this.currentRow.getIdProcesoSeleccion());
			this.esSeleccionadoConvocatoria = false;
			// Set current calendar
			if (this.listConvocatoria != null && this.listConvocatoria.size() > 0) {
				if (this.listConvocatoria.get(0).getListaCalendario() != null) {
					this.listCalendario = this.listConvocatoria.get(0).getListaCalendario();
				}
				if (this.listConvocatoria.get(0).getListaResultado() != null) {
					this.listResultado = this.listConvocatoria.get(0).getListaResultado();
				}
			}
			// En caso no hay convocatorias registrados, se crea por defecto una
			// convocatoria
			// Obtiene el valor referencial del PAO, con el IdPacConsolidado
			
			

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

	public void resetRegisterForm() {
		reset("frmRemitirProceso:panelC");
	}

	public void goSendToEjecucion() {
		// validate before
		if (this.isCalendarEditing) {
			showGrowlMessageSuccessfullyCompletedAction("Validaci�n",
					"Para remitir expediente primero de guardar los cambios.", FacesMessage.SEVERITY_WARN);
			return;
		}

		STATUS_INIT();
		try {

			securityControlValidate("btnSendEjecucion");
			resetRegisterForm();
			validateSelectedRowConvocatoria();

			listResultadoSend = procesoBusiness
					.selectResultadoByIdConvocatoria(this.selectedConvocatoria.getIdconvocatoriaproceso());
			for (ProcesoResultadoItemDto resultado : listResultadoSend) {
				List<ItemIntResponse> items = new ArrayList<ItemIntResponse>();
				if (resultado.getIdcatalogoestadoresultado()
						.equals(Constantes.estadoResultadoProceso.BUENA_PRO_CONSENTIDA)) {

					items.add(new ItemIntResponse(Constantes.destinoRemisionProceso.EJECUCION_CONTRACTUAL,
							Constantes.destinoRemisionProcesoDescripcion.EJECUCION_CONTRACTUAL));

					resultado.setDestino(Constantes.destinoRemisionProceso.EJECUCION_CONTRACTUAL);
					resultado.setDestinodescripcion(Constantes.destinoRemisionProcesoDescripcion.EJECUCION_CONTRACTUAL);

				} else {
					items.add(new ItemIntResponse(Constantes.destinoRemisionProceso.PROCESO_SELECCION,
							Constantes.destinoRemisionProcesoDescripcion.PROCESO_SELECCION));
					items.add(new ItemIntResponse(Constantes.destinoRemisionProceso.PROGRAMACION_COSTOS,
							Constantes.destinoRemisionProcesoDescripcion.PROGRAMACION_COSTOS));
					resultado.setDestino(null);
					resultado.setDestinodescripcion(null);
				}

				resultado.setDestinos(items);
			}

			// this.listResultadoSend = resul

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

	public void sendToEjecucion() {
		REGISTER_INIT();
		try {

			Sicuusuario usuario = (Sicuusuario) getHttpSession().getAttribute("sicuusuarioSESSION");
			if (usuario == null) {
				REGISTER_ERROR();
				addMessageKey("msgsDocumentotecnicoR", "Temin� la sesi�n", FacesMessage.SEVERITY_ERROR);
				return;
			}

			// validate
			for (ProcesoResultadoItemDto resultado : this.listResultadoSend) {
				if (resultado.getDestino() == null) {
					showGrowlMessageSuccessfullyCompletedAction("Validaci�n",
							"No ha seleccionado el destino para enviar el expediente.", FacesMessage.SEVERITY_WARN);
					return;
				}
				if (resultado.getDestino().equals(Constantes.destinoRemisionProceso.EJECUCION_CONTRACTUAL)) {
					// validate here
					ContratoSigaRequest request = new ContratoSigaRequest();
					request.setAnnio(usuario.getPeriodo().getAnio());
					request.setNroConsolid(this.currentRow.getNroConsolid());
					request.setNroRuc(resultado.getNroruc());
					request.setIdUnidadEjecutoraSiaf(Constantes.unidadEjecutora.PRONIED_SIAF);
					boolean existsContrato = procesoBusiness.validarExisteContrato(request);
					if (!existsContrato){
						showGrowlMessageSuccessfullyCompletedAction("Validaci�n",
								"Proveedor " + resultado.getNroruc() + " no tiene contrato registrado en el sistema SIGA.", FacesMessage.SEVERITY_WARN);
						return;						
					}
				}
			}

			for (int i = 0; i < this.listResultado.size(); i++) {
				if (this.listResultadoSend.get(i).getDestino()
						.equals(Constantes.destinoRemisionProceso.EJECUCION_CONTRACTUAL)) {
					this.listResultadoSend.get(i)
							.setEstadoprocesoitem(Constantes.estadoResultadoProcesoItem.EN_EJECUCION_CONTRACTUAL);
				} else if (this.listResultadoSend.get(i).getDestino()
						.equals(Constantes.destinoRemisionProceso.PROCESO_SELECCION)) {
					this.listResultadoSend.get(i)
							.setEstadoprocesoitem(Constantes.estadoResultadoProcesoItem.EN_PROCESO_DESIERTO);
				} else if (this.listResultadoSend.get(i).getDestino()
						.equals(Constantes.destinoRemisionProceso.PROGRAMACION_COSTOS)) {
					this.listResultadoSend.get(i)
							.setEstadoprocesoitem(Constantes.estadoResultadoProcesoItem.EN_PROGRAMACION_COSTOS);
				}
			}

			TransactionRequest<List<ProcesoResultadoItemDto>> request = new TransactionRequest<List<ProcesoResultadoItemDto>>();
			request.setEntityTransaction(this.listResultadoSend);
			request.setUsuarioAuditoria(getUserLogin());
			request.setEquipoAuditoria(getRemoteAddr());
			procesoBusiness.sendProceso(request, this.currentRow.getIdProcesoSeleccion());

			// list convocatoria again
			searchConvocatoria();

			REGISTER_SUCCESS();
			showGrowlMessageSuccessfullyCompletedAction();

		} catch (ValidateException e) {
			REGISTER_ERROR();
			addMessageKey("msgsDocumentotecnicoR", e.getMessage(), FacesMessage.SEVERITY_ERROR);
		} catch (BusinessException e) {
			REGISTER_ERROR();
			addMessageKey("msgsDocumentotecnicoR", e.getMessage(), FacesMessage.SEVERITY_ERROR);
		} catch (DataIntegrityViolationException e) {
			addMessageKey("msgsForm", Messages.getString("exception.dataintegrity.message.title"),
					Messages.getString("exception.dataintegrity.message.detail"), FacesMessage.SEVERITY_ERROR);
		} catch (Exception e) {
			REGISTER_ERROR();
			addErrorMessageKey("msgsDocumentotecnicoR", e);
		}
	}

	private void activeTabs(){
		boolean disabledCalendario = false;
		if (this.processEdit != null && this.processEdit.getEstadoproceso() <= Constantes.estadosPorTipoDocumento.EN_COMITE_ESPECIAL){
			disabledCalendario = true;
		}
		setDisabledTabCalendar(disabledCalendario);
	}
	
	public void saveProceso() {
		REGISTER_INIT();
		try {

			Sicuusuario usuario = (Sicuusuario) getHttpSession().getAttribute("sicuusuarioSESSION");
			if (usuario == null) {
				REGISTER_ERROR();
				addMessageKey("msgsDocumentotecnicoR", "Temin� la sesi�n", FacesMessage.SEVERITY_ERROR);
				return;
			}

			TransactionRequest<Procesoseleccion> request = new TransactionRequest<Procesoseleccion>();
			
			//In this section I don�t save convocatoria
			/*
			List<Convocatoriaprocesoseleccion> listconvoca = new ArrayList<Convocatoriaprocesoseleccion>();
			for (ConvocatoriaDto item : listConvocatoria) {
				Convocatoriaprocesoseleccion newItem = new Convocatoriaprocesoseleccion();
				newItem.setIdconvocatoriaproceso(item.getIdconvocatoriaproceso());
				newItem.setNroconvocatoria(item.getNroconvocatoria());
				BigDecimal valorreferencia = new BigDecimal(item.getValorreferencia());
				newItem.setValorreferencia(Utils.round(valorreferencia));
				newItem.setIdcatalogoestadoconvocatoria(item.getIdcatalogoestadoconvocatoria());
				newItem.setFechainicio(item.getFechainicio());
				newItem.setFechafin(item.getFechafin());

				// calendarios
				List<Calendarioprocesoseleccion> lstCalendario = new ArrayList<Calendarioprocesoseleccion>();
				if (item.getListaCalendario() != null) {
					for (CalendarioDto calendar : listCalendario) {
						Calendarioprocesoseleccion newCalendar = new Calendarioprocesoseleccion();
						newCalendar.setIdcalendarioproceso(calendar.getIdcalendarioproceso());
						newCalendar.setIdconvocatoriaproceso(calendar.getIdcalendarioproceso());
						newCalendar.setIdcatalogocodigocalendario(calendar.getIdcatalogocodigocalendario());
						newCalendar.setNombrecalendario(calendar.getNombrecalendario());
						newCalendar.setFechainicio(calendar.getFechainicio());
						newCalendar.setFechafin(calendar.getFechafin());
						newCalendar.setIdcatalogoestadopublicacion(calendar.getIdcatalogoestadopublicacion());
						lstCalendario.add(newCalendar);
					}
					newItem.setListaCalendarioprocesoseleccion(lstCalendario);
				}

				// resultado de procesos
				List<Resultadoprocesoseleccion> lstResultado = new ArrayList<Resultadoprocesoseleccion>();
				if (item.getListaResultado() != null) {
					for (ProcesoResultadoItemDto resultado : listResultado) {
						Resultadoprocesoseleccion newResultado = new Resultadoprocesoseleccion();
						newResultado.setIdresultadoproceso(resultado.getIdresultadoproceso());
						newResultado.setIdconvocatoriaproceso(resultado.getIdconvocatoriaproceso());
						newResultado.setNroitem(resultado.getNroitem());
						newResultado.setNombreitem(resultado.getNombreitem());
						newResultado.setNroruc(resultado.getNroruc());
						newResultado.setNombreproveedor(resultado.getNombreproveedor());
						newResultado.setIdcatalogoestadoresultado(resultado.getIdcatalogoestadoresultado());
						BigDecimal valorreferencial = new BigDecimal(resultado.getValorreferencial());
						newResultado.setValorreferencial(Utils.round(valorreferencial));

						BigDecimal montoadjudicado = new BigDecimal(resultado.getMontoadjudicado());
						newResultado.setMontoadjudicado(Utils.round(montoadjudicado));
						lstResultado.add(newResultado);
					}
					newItem.setListaResultadoprocesoseleccion(lstResultado);
				}

				listconvoca.add(newItem);
			}
			processEdit.setListaConvocatoriaprocesoseleccion(listconvoca);
			*/						
			request.setUsuarioAuditoria(getUserLogin());
			request.setEquipoAuditoria(getRemoteAddr());
			request.setEntityTransaction(processEdit);
			Resultado result = procesoBusiness.saveProceso(request);
			
			//get proceso againt
			//search();
			Procesoseleccion proceso = procesoseleccionBusiness.selectByPrimaryKeyBasic(currentRow.getIdProcesoSeleccion());
			if (proceso != null){
				//update info
				this.processEdit.setEstadoproceso(proceso.getEstadoproceso());
				this.currentRow.setIdEstadoProceso(proceso.getEstadoproceso());
				//update status
				EstadoRequerimientoResponse estado = gentablaBusiness.getEstadoRequerimientoByIdEstadosTipoDocumento(proceso.getEstadoproceso());
				if (estado != null) this.currentRow.setEstadoproceso(estado.getDescripcion());
			}
						
			activeTabs();	
			search();
			REGISTER_SUCCESS();
			showGrowlMessageSuccessfullyCompletedAction();			
			
		} catch (ValidateException e) {
			REGISTER_ERROR();
			addMessageKey("msgsDocumentotecnicoR", e.getMessage(), FacesMessage.SEVERITY_ERROR);
		} catch (BusinessException e) {
			REGISTER_ERROR();
			addMessageKey("msgsDocumentotecnicoR", e.getMessage(), FacesMessage.SEVERITY_ERROR);

		} catch (DataIntegrityViolationException e) {
			addMessageKey("msgsForm", Messages.getString("exception.dataintegrity.message.title"),
					Messages.getString("exception.dataintegrity.message.detail"), FacesMessage.SEVERITY_ERROR);
		} catch (Exception e) {
			REGISTER_ERROR();
			addErrorMessageKey("msgsDocumentotecnicoR", e);
		}
	}

	public void saveCalendario() {
		REGISTER_INIT();
		try {

			Sicuusuario usuario = (Sicuusuario) getHttpSession().getAttribute("sicuusuarioSESSION");
			if (usuario == null) {
				REGISTER_ERROR();
				addMessageKey("msgsDocumentotecnicoR", "Temin� la sesi�n", FacesMessage.SEVERITY_ERROR);
				return;
			}

			TransactionRequest<Procesoseleccion> request = new TransactionRequest<Procesoseleccion>();
			List<Convocatoriaprocesoseleccion> listconvoca = new ArrayList<Convocatoriaprocesoseleccion>();
			for (ConvocatoriaDto item : listConvocatoria) {
				Convocatoriaprocesoseleccion newItem = new Convocatoriaprocesoseleccion();
				newItem.setIdconvocatoriaproceso(item.getIdconvocatoriaproceso());
				newItem.setNroconvocatoria(item.getNroconvocatoria());
				BigDecimal valorreferencia = new BigDecimal(item.getValorreferencia());
				newItem.setValorreferencia(Utils.round(valorreferencia));
				newItem.setIdcatalogoestadoconvocatoria(item.getIdcatalogoestadoconvocatoria());
				newItem.setFechainicio(item.getFechainicio());
				newItem.setFechafin(item.getFechafin());

				// calendarios
				List<Calendarioprocesoseleccion> lstCalendario = new ArrayList<Calendarioprocesoseleccion>();
				if (item.getListaCalendario() != null) {
					for (CalendarioDto calendar : listCalendario) {
						Calendarioprocesoseleccion newCalendar = new Calendarioprocesoseleccion();
						newCalendar.setIdcalendarioproceso(calendar.getIdcalendarioproceso());
						newCalendar.setIdconvocatoriaproceso(calendar.getIdcalendarioproceso());
						newCalendar.setIdcatalogocodigocalendario(calendar.getIdcatalogocodigocalendario());
						newCalendar.setNombrecalendario(calendar.getNombrecalendario());
						newCalendar.setFechainicio(calendar.getFechainicio());
						newCalendar.setFechafin(calendar.getFechafin());
						newCalendar.setIdcatalogoestadopublicacion(calendar.getIdcatalogoestadopublicacion());
						lstCalendario.add(newCalendar);
					}
					newItem.setListaCalendarioprocesoseleccion(lstCalendario);
				}

				// resultado de procesos
				List<Resultadoprocesoseleccion> lstResultado = new ArrayList<Resultadoprocesoseleccion>();
				if (item.getListaResultado() != null) {
					for (ProcesoResultadoItemDto resultado : listResultado) {
						Resultadoprocesoseleccion newResultado = new Resultadoprocesoseleccion();
						newResultado.setIdresultadoproceso(resultado.getIdresultadoproceso());
						newResultado.setIdconvocatoriaproceso(resultado.getIdconvocatoriaproceso());
						newResultado.setNroitem(resultado.getNroitem());
						newResultado.setNombreitem(resultado.getNombreitem());
						newResultado.setNroruc(resultado.getNroruc());
						newResultado.setNombreproveedor(resultado.getNombreproveedor());
						newResultado.setIdcatalogoestadoresultado(resultado.getIdcatalogoestadoresultado());						
						BigDecimal valorreferencial = new BigDecimal(resultado.getValorreferencial());
						newResultado.setValorreferencial(Utils.round(valorreferencial));

						BigDecimal montoadjudicado = new BigDecimal(resultado.getMontoadjudicado());
						newResultado.setMontoadjudicado(Utils.round(montoadjudicado));
						lstResultado.add(newResultado);
					}
					newItem.setListaResultadoprocesoseleccion(lstResultado);
				}

				listconvoca.add(newItem);
			}
			processEdit.setListaConvocatoriaprocesoseleccion(listconvoca);
			request.setUsuarioAuditoria(getUserLogin());
			request.setEquipoAuditoria(getRemoteAddr());
			request.setEntityTransaction(processEdit);
			Resultado result = procesoBusiness.saveCalendario(request);
			this.isCalendarEditing = false;

			REGISTER_SUCCESS();
			showGrowlMessageSuccessfullyCompletedAction();

		} catch (ValidateException e) {
			REGISTER_ERROR();
			addMessageKey("msgsDocumentotecnicoR", e.getMessage(), FacesMessage.SEVERITY_ERROR);
		} catch (BusinessException e) {
			REGISTER_ERROR();
			addMessageKey("msgsDocumentotecnicoR", e.getMessage(), FacesMessage.SEVERITY_ERROR);

		} catch (DataIntegrityViolationException e) {
			addMessageKey("msgsForm", Messages.getString("exception.dataintegrity.message.title"),
					Messages.getString("exception.dataintegrity.message.detail"), FacesMessage.SEVERITY_ERROR);
		} catch (Exception e) {
			REGISTER_ERROR();
			addErrorMessageKey("msgsDocumentotecnicoR", e);
		}
	}

	public void irImprimir() {
		STATUS_INIT();
		try {
			securityControlValidate("btnImprimir");
			// resetRegisterForm();
			// accion = IMPRIMIR;
			tituloBase = "Proceso � " + IMPRIMIR;

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

	public void goExport() {
		STATUS_INIT();
		try {
			securityControlValidate("btnExport");
			
			Sicuusuario usuario = (Sicuusuario) getHttpSession().getAttribute("sicuusuarioSESSION");
			if (usuario == null) {
				REGISTER_ERROR();
				addMessageKey("msgsDocumentotecnicoR", "Temin� la sesi�n", FacesMessage.SEVERITY_ERROR);
				return;
			}

			
			// resetRegisterForm();
			// accion = IMPRIMIR;
			tituloBase = "Proceso � " + IMPRIMIR;
			ProcesoExportRequest request = new ProcesoExportRequest();
			request.setIdperiodo(usuario.getPeriodo().getIdPeriodo());
			request.setSinad(null);
			request.setNroproceso(this.searchParam.getNroProceso());
			request.setNroconsolid(this.searchParam.getNroConsolid());
			request.setTipoproceso(this.searchParam.getIdTipoProceso());
			request.setTipobien(this.searchParam.getIdTipoBien());
			request.setEstadoproceso(null);
			request.setCodigocentrocosto(this.searchParam.getCodigoCentroCosto());
			this.dataListToExport = procesoBusiness.searchProcesoData(request);

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
	
	// methods
	public void search() {
		try {
			Sicuusuario usuario = (Sicuusuario) getHttpSession().getAttribute("sicuusuarioSESSION");
			this.searchParam.setAnio(usuario.getPeriodo().getAnio());
			this.searchParam.setIdUnidadEjecutoraSiaf(Constantes.unidadEjecutora.PRONIED_SIAF);
			this.setEsSeleccionado(false);
			this.dataList = procesoBusiness.searchProcesoSeguimiento(this.searchParam);

			if (this.dataList.size() == 0)
				addMessageKey("msgsForm", Messages.getString("no.records.found"), FacesMessage.SEVERITY_INFO);
			;

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

	public void validateSelectedRow() throws UnselectedRowException, CloneNotSupportedException {
		if (selectedRow == null)
			throw new UnselectedRowException(Messages.getString("no.record.selected"));
		else
			currentRow = (ProcesoDto) selectedRow.clone();
	}

	public void validateSelectedRowConvocatoria() throws UnselectedRowException, CloneNotSupportedException {
		if (this.selectedConvocatoria == null)
			throw new UnselectedRowException(Messages.getString("no.record.selected"));
		else
			this.setCurrentConvocatoria((ConvocatoriaDto) this.selectedConvocatoria.clone());
	}

	public void varlidarFecha() {
		String valor = "";
		// FacesMessage msg = new FacesMessage("Se edit� correctamente",null);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje", null));

	}

	// Datatable Editable
	public void onRowEdit(RowEditEvent event) {
		DataTable dt = (DataTable) event.getSource();

		FacesMessage msg = new FacesMessage("Se edit� correctamente",
				"Convocatoria: " + ((ConvocatoriaDto) event.getObject()).getNroconvocatoria());
		ConvocatoriaDto convoca = ((ConvocatoriaDto) event.getObject());
		// get description of the status
		try {
			// validate the date
			// throw new Exception("Error");
			/*
			 * if (convoca.getFechainicio().compareTo(convoca.getFechafin()) <=
			 * 0) {
			 * 
			 * String id = ((ConvocatoriaDto)
			 * event.getObject()).getIdcatalogoestadoconvocatoria();
			 * ((ConvocatoriaDto)
			 * event.getObject()).setDescripcionestado(gentablaBusiness.
			 * getDescripcion(id)); } else { // cancel editing
			 * onRowCancel(event);
			 * 
			 * // throw new ValidatorException( //
			 * FacesMessageUtil.newBundledFacesMessage(FacesMessage.
			 * SEVERITY_ERROR, // "", "msg.dateRange",
			 * ((Calendar)component).getLabel(), // startDate); }
			 */
			this.isCalendarEditing = true;
		} catch (Exception ex) {
			msg = new FacesMessage("Fall�");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onRowCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Se cancel� la edici�n",
				"Convocatoria: " + ((ConvocatoriaDto) event.getObject()).getNroconvocatoria());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onRowEditCalendar(RowEditEvent event) {
		// onRowCancelCalendar(event);

		FacesMessage msg = new FacesMessage("Se edit� correctamente",
				"Calendario: " + ((CalendarioDto) event.getObject()).getNombrecalendario());
		try {
			String id = ((CalendarioDto) event.getObject()).getIdcatalogoestadopublicacion();
			((CalendarioDto) event.getObject()).setDescripcionestado(gentablaBusiness.getDescripcion(id));

		} catch (Exception ex) {
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
		this.isCalendarEditing = true;
	}

	public void onRowCancelCalendar(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Se cancel� la edici�n",
				"Calendario: " + ((CalendarioDto) event.getObject()).getNombrecalendario());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onRowEditResultado(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Se edit� correctamente",
				"Resultado: " + ((ProcesoResultadoItemDto) event.getObject()).getNroitem());
		try {
			String id = ((ProcesoResultadoItemDto) event.getObject()).getIdcatalogoestadoresultado();
			((ProcesoResultadoItemDto) event.getObject()).setDescripcionestado(gentablaBusiness.getDescripcion(id));
			this.isCalendarEditing = true;
		} catch (Exception ex) {
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onRowCancelResultado(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Se cancel� la edici�n",
				"Resultado: " + ((ProcesoResultadoItemDto) event.getObject()).getNroitem());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public List<ProcesoDto> getDataList() {
		return dataList;
	}

	public void setDataList(List<ProcesoDto> dataList) {
		this.dataList = dataList;
	}

	public ProcesoDto getSelectedRow() {
		return selectedRow;
	}

	public void setSelectedRow(ProcesoDto selectedRow) {
		this.selectedRow = selectedRow;
	}

	public ProcesoRequest getSearchParam() {
		return searchParam;
	}

	public void setSearchParam(ProcesoRequest searchParam) {
		this.searchParam = searchParam;
	}

	public ProcesoDto getCurrentRow() {
		return currentRow;
	}

	public void setCurrentRow(ProcesoDto currentRow) {
		this.currentRow = currentRow;
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

	public String getAccion() {
		return accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

	public List<Gentabla> getListaGentablaIdcatalogotipobien() {
		return listaGentablaIdcatalogotipobien;
	}

	public void setListaGentablaIdcatalogotipobien(List<Gentabla> listaGentablaIdcatalogotipobien) {
		this.listaGentablaIdcatalogotipobien = listaGentablaIdcatalogotipobien;
	}

	public List<TipoProcesoResponse> getListaTipoProceso() {
		return listaTipoProceso;
	}

	public void setListaTipoProceso(List<TipoProcesoResponse> listaTipoProceso) {
		this.listaTipoProceso = listaTipoProceso;
	}

	public List<CentroCostoResponse> getListaCentroCosto() {
		return listaCentroCosto;
	}

	public void setListaCentroCosto(List<CentroCostoResponse> listaCentroCosto) {
		this.listaCentroCosto = listaCentroCosto;
	}

	public List<EstadoRequerimientoResponse> getListaEstadoRequerimiento() {
		return listaEstadoRequerimiento;
	}

	public void setListaEstadoRequerimiento(List<EstadoRequerimientoResponse> listaEstadoRequerimiento) {
		this.listaEstadoRequerimiento = listaEstadoRequerimiento;
	}

	public List<Miembrocomiteporproceso> getListaMiembrocomiteporproceso() {
		return listaMiembrocomiteporproceso;
	}

	public void setListaMiembrocomiteporproceso(List<Miembrocomiteporproceso> listaMiembrocomiteporproceso) {
		this.listaMiembrocomiteporproceso = listaMiembrocomiteporproceso;
	}

	public List<Gentabla> getListaSistemaContratacion() {
		return listaSistemaContratacion;
	}

	public void setListaSistemaContratacion(List<Gentabla> listaSistemaContratacion) {
		this.listaSistemaContratacion = listaSistemaContratacion;
	}

	public Procesoseleccion getProcessEdit() {
		return processEdit;
	}

	public void setProcessEdit(Procesoseleccion processEdit) {
		this.processEdit = processEdit;
	}

	public boolean isDisabledButtons() {
		return disabledButtons;
	}

	public void setDisabledButtons(boolean disabledButtons) {
		this.disabledButtons = disabledButtons;
	}

	public List<ConvocatoriaDto> getListConvocatoria() {
		return listConvocatoria;
	}

	public void setListConvocatoria(List<ConvocatoriaDto> listConvocatoria) {
		this.listConvocatoria = listConvocatoria;
	}

	public List<Gentabla> getListaGentablaIdcatalogoestadoconvocatoria() {
		return listaGentablaIdcatalogoestadoconvocatoria;
	}

	public void setListaGentablaIdcatalogoestadoconvocatoria(List<Gentabla> listaGentablaIdcatalogoestadoconvocatoria) {
		this.listaGentablaIdcatalogoestadoconvocatoria = listaGentablaIdcatalogoestadoconvocatoria;
	}

	public List<CalendarioDto> getListCalendario() {
		return listCalendario;
	}

	public void setListCalendario(List<CalendarioDto> listCalendario) {
		this.listCalendario = listCalendario;
	}

	public List<Gentabla> getListaGentablaIdcatalogoestadopublicacion() {
		return listaGentablaIdcatalogoestadopublicacion;
	}

	public void setListaGentablaIdcatalogoestadopublicacion(List<Gentabla> listaGentablaIdcatalogoestadopublicacion) {
		this.listaGentablaIdcatalogoestadopublicacion = listaGentablaIdcatalogoestadopublicacion;
	}

	public List<ProcesoResultadoItemDto> getListResultado() {
		return listResultado;
	}

	public void setListResultado(List<ProcesoResultadoItemDto> listResultado) {
		this.listResultado = listResultado;
	}

	public List<Gentabla> getListaGentablaIdcatalogoestadoresultado() {
		return listaGentablaIdcatalogoestadoresultado;
	}

	public void setListaGentablaIdcatalogoestadoresultado(List<Gentabla> listaGentablaIdcatalogoestadoresultado) {
		this.listaGentablaIdcatalogoestadoresultado = listaGentablaIdcatalogoestadoresultado;
	}

	public ConvocatoriaDto getSelectedConvocatoria() {
		return selectedConvocatoria;
	}

	public void setSelectedConvocatoria(ConvocatoriaDto selectedConvocatoria) {
		this.selectedConvocatoria = selectedConvocatoria;
	}

	public CalendarioDto getSelectedCalendadio() {
		return selectedCalendadio;
	}

	public void setSelectedCalendadio(CalendarioDto selectedCalendadio) {
		this.selectedCalendadio = selectedCalendadio;
	}

	public ProcesoResultadoItemDto getSelectedResultado() {
		return selectedResultado;
	}

	public void setSelectedResultado(ProcesoResultadoItemDto selectedResultado) {
		this.selectedResultado = selectedResultado;
	}

	public boolean isEsSeleccionadoConvocatoria() {
		return esSeleccionadoConvocatoria;
	}

	public void setEsSeleccionadoConvocatoria(boolean esSeleccionadoConvocatoria) {
		this.esSeleccionadoConvocatoria = esSeleccionadoConvocatoria;
	}

	public ConvocatoriaDto getCurrentConvocatoria() {
		return currentConvocatoria;
	}

	public void setCurrentConvocatoria(ConvocatoriaDto currentConvocatoria) {
		this.currentConvocatoria = currentConvocatoria;
	}

	public List<ProcesoResultadoItemDto> getListResultadoSend() {
		return listResultadoSend;
	}

	public void setListResultadoSend(List<ProcesoResultadoItemDto> listResultadoSend) {
		this.listResultadoSend = listResultadoSend;
	}

	public boolean isCalendarEditing() {
		return isCalendarEditing;
	}

	public void setCalendarEditing(boolean isCalendarEditing) {
		this.isCalendarEditing = isCalendarEditing;
	}

	public boolean isDisabledTabCalendar() {
		return disabledTabCalendar;
	}

	public void setDisabledTabCalendar(boolean disabledTabCalendar) {
		this.disabledTabCalendar = disabledTabCalendar;
	}

	public List<ProcesoExportDto> getDataListToExport() {
		return dataListToExport;
	}

	public void setDataListToExport(List<ProcesoExportDto> dataListToExport) {
		this.dataListToExport = dataListToExport;
	}

	public boolean isValue1() {
		return value1;
	}

	public void setValue1(boolean value1) {
		this.value1 = value1;
	}

	public boolean isValue2() {
		return value2;
	}

	public void setValue2(boolean value2) {
		this.value2 = value2;
	}

	public boolean isValue3() {
		return value3;
	}

	public void setValue3(boolean value3) {
		this.value3 = value3;
	}

	public boolean isValue4() {
		return value4;
	}

	public void setValue4(boolean value4) {
		this.value4 = value4;
	}

	public boolean isValue5() {
		return value5;
	}

	public void setValue5(boolean value5) {
		this.value5 = value5;
	}

	public boolean isValue6() {
		return value6;
	}

	public void setValue6(boolean value6) {
		this.value6 = value6;
	}

	public boolean isValue7() {
		return value7;
	}

	public void setValue7(boolean value7) {
		this.value7 = value7;
	}

	public boolean isValue8() {
		return value8;
	}

	public void setValue8(boolean value8) {
		this.value8 = value8;
	}

	public boolean isValue9() {
		return value9;
	}

	public void setValue9(boolean value9) {
		this.value9 = value9;
	}

	public boolean isValue10() {
		return value10;
	}

	public void setValue10(boolean value10) {
		this.value10 = value10;
	}

	public boolean isValue11() {
		return value11;
	}

	public void setValue11(boolean value11) {
		this.value11 = value11;
	}

	public boolean isValue12() {
		return value12;
	}

	public void setValue12(boolean value12) {
		this.value12 = value12;
	}

	
	// properties to export data
	

}
