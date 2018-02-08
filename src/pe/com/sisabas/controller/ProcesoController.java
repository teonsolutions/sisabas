package pe.com.sisabas.controller;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import pe.com.sisabas.be.Calendarioprocesoseleccion;
import pe.com.sisabas.be.Convocatoriaprocesoseleccion;
import pe.com.sisabas.be.Gentabla;
import pe.com.sisabas.be.Miembrocomiteporproceso;
import pe.com.sisabas.be.Procesoseleccion;
import pe.com.sisabas.business.ConvocatoriaprocesoseleccionBusiness;
import pe.com.sisabas.business.GentablaBusiness;
import pe.com.sisabas.business.MiembrocomiteporprocesoBusiness;
import pe.com.sisabas.business.ProcesoBusiness;
import pe.com.sisabas.business.ProcesoseleccionBusiness;
import pe.com.sisabas.business.VcentrocostoBusiness;
import pe.com.sisabas.dto.CalendarioDto;
import pe.com.sisabas.dto.CentroCostoRequest;
import pe.com.sisabas.dto.CentroCostoResponse;
import pe.com.sisabas.dto.ConvocatoriaDto;
import pe.com.sisabas.dto.EstadoRequerimientoResponse;
import pe.com.sisabas.dto.OrdenDto;
import pe.com.sisabas.dto.PacConsolidadoDto;
import pe.com.sisabas.dto.PaoRequest;
import pe.com.sisabas.dto.PaoResponse;
import pe.com.sisabas.dto.ProcesoDto;
import pe.com.sisabas.dto.ProcesoRequest;
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

	private List<ConvocatoriaDto> listConvocatoria;
	private List<CalendarioDto> listCalendario;

	private String idOpcionText = "OPC_PROCESO";
	public static String SUCCESS_SEGUIMIENTO = "/pages/proceso/procesoSeguimiento.xhtml?faces-redirect=true;";
	private boolean disabledButtons;

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

	public ProcesoController() {

	}

	public String load() {
		return "/pages/proceso/procesoBuscar.xhtml?faces-redirect=true";
	}

	@PostConstruct
	public void init() {
		searchParam = new ProcesoRequest();
		tituloBase = "Proceso » ";

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

			listaGentablaIdcatalogoestadoconvocatoria = gentablaBusiness
					.selectDynamicBasic(new Gentabla().getObjBusqueda(Constantes.tabla.ECPR));
			
			listaGentablaIdcatalogoestadopublicacion = gentablaBusiness
					.selectDynamicBasic(new Gentabla().getObjBusqueda(Constantes.tabla.EEPR));

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

	public String goSeguimiento() {
		logger.debug("pacRegistrar....");
		try {

			// Sicuusuario usuario = (Sicuusuario)
			// getHttpSession().getAttribute("sicuusuarioSESSION");
			validateSelectedRow();
			if (this.esSeleccionado) {
			}

			this.processEdit = procesoseleccionBusiness.selectByPrimaryKeyBasic(currentRow.getIdProcesoSeleccion());
			// Get miembros de comite por proceso
			listaMiembrocomiteporproceso = miembrocomiteporprocesoBusiness.selectDynamicFullByIdComiteProceso(
					this.currentRow.getIdComiteProceso() != null ? this.currentRow.getIdComiteProceso() : 0);
			this.listConvocatoria = procesoBusiness
					.searchConvocatoriaProceso(this.currentRow.getIdProcesoSeleccion());
			//Set current calendar
			if (this.listConvocatoria != null && this.listConvocatoria.size() > 0){
				if (this.listConvocatoria.get(0).getListaCalendario() != null){
					this.listCalendario = this.listConvocatoria.get(0).getListaCalendario(); 
				}				
			}
		} catch (Exception e) {
			addErrorMessage(e);
			return "/login.xhtml";
		}

		return SUCCESS_SEGUIMIENTO;
	}

	public void saveProceso() {
		REGISTER_INIT();
		try {

			Sicuusuario usuario = (Sicuusuario) getHttpSession().getAttribute("sicuusuarioSESSION");
			if (usuario == null) {
				REGISTER_ERROR();
				addMessageKey("msgsDocumentotecnicoR", "Teminó la sesión", FacesMessage.SEVERITY_ERROR);
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
				
				List<Calendarioprocesoseleccion> lstCalendario = new ArrayList<Calendarioprocesoseleccion>();
				if (item.getListaCalendario() != null){
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
				listconvoca.add(newItem);
			}
			
			request.setUsuarioAuditoria(getUserLogin());
			request.setEquipoAuditoria(getRemoteAddr());
			request.setEntityTransaction(processEdit);
			Resultado result = procesoBusiness.saveProceso(request);

			REGISTER_SUCCESS();
			showGrowlMessageSuccessfullyCompletedAction();

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

	public void irImprimir() {
		STATUS_INIT();
		try {
			securityControlValidate("btnImprimir");
			// resetRegisterForm();
			// accion = IMPRIMIR;
			tituloBase = "Proceso » " + IMPRIMIR;

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

	// Datatable Editable
	public void onRowEdit(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Se editó correctamente",
				"Convocatoria: " + ((ConvocatoriaDto) event.getObject()).getNroconvocatoria());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onRowCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Se canceló la edición",
				"Convocatoria: " + ((ConvocatoriaDto) event.getObject()).getNroconvocatoria());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public void onRowEditCalendar(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Se editó correctamente",
				"Calendario: " + ((CalendarioDto) event.getObject()).getNombrecalendario());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onRowCancelCalendar(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Se canceló la edición",
				"Calendario: " + ((CalendarioDto) event.getObject()).getNombrecalendario());
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
	
	
	// properties

}
