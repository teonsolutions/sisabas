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

import org.primefaces.component.datatable.DataTable;
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
import pe.com.sisabas.dto.ConvocatoriaDto;
import pe.com.sisabas.dto.CuadroComparativoRequest;
import pe.com.sisabas.dto.EstadoRequerimientoResponse;
import pe.com.sisabas.dto.ItemIntResponse;
import pe.com.sisabas.dto.OrdenDto;
import pe.com.sisabas.dto.PacConsolidadoDto;
import pe.com.sisabas.dto.PaoRequest;
import pe.com.sisabas.dto.PaoResponse;
import pe.com.sisabas.dto.ProcesoDto;
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
import pe.com.sisabas.resources.URLReader;
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

			listaGentablaIdcatalogoestadoresultado = gentablaBusiness
					.selectDynamicBasic(new Gentabla().getObjBusqueda(Constantes.tabla.EPRI));

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

	public void seleccionItemConvocatoria(SelectEvent e) {
		esSeleccionadoConvocatoria = true;
	}
		
	public String goSeguimiento() {
		logger.debug("pacRegistrar....");
		try {

			//URLReader reader = new URLReader(); 
			//reader.ReadPage("");
			
			// Sicuusuario usuario = (Sicuusuario)
			// getHttpSession().getAttribute("sicuusuarioSESSION");
			validateSelectedRow();
			if (this.esSeleccionado) {
			}

			this.processEdit = procesoseleccionBusiness.selectByPrimaryKeyBasic(currentRow.getIdProcesoSeleccion());
			// Get miembros de comite por proceso
			listaMiembrocomiteporproceso = miembrocomiteporprocesoBusiness.selectDynamicFullByIdComiteProceso(
					this.currentRow.getIdComiteProceso() != null ? this.currentRow.getIdComiteProceso() : 0);
			this.listConvocatoria = procesoBusiness.searchConvocatoriaProceso(this.currentRow.getIdProcesoSeleccion());
			// Set current calendar
			if (this.listConvocatoria != null && this.listConvocatoria.size() > 0) {
				if (this.listConvocatoria.get(0).getListaCalendario() != null) {
					this.listCalendario = this.listConvocatoria.get(0).getListaCalendario();
				}
				if (this.listConvocatoria.get(0).getListaResultado() != null) {
					this.listResultado = this.listConvocatoria.get(0).getListaResultado();
				}
			}
		} catch (Exception e) {
			addErrorMessage(e);
			return "/login.xhtml";
		}

		return SUCCESS_SEGUIMIENTO;
	}
	
	public void resetRegisterForm() {
		reset("frmRemitirProceso:panelC");
	}
	
	public void goSendToEjecucion(){
		STATUS_INIT();
		try {

			securityControlValidate("btnSendEjecucion");
			resetRegisterForm();
			validateSelectedRowConvocatoria();
			
			listResultadoSend = procesoBusiness.selectResultadoByIdConvocatoria(this.selectedConvocatoria.getIdconvocatoriaproceso()); 
			for (ProcesoResultadoItemDto resultado : listResultadoSend) {
				List<ItemIntResponse> items = new ArrayList<ItemIntResponse>();
				if (resultado.getIdcatalogoestadoresultado().equals(Constantes.estadoResultadoProceso.BUENA_PRO_CONSENTIDA)){					
					items.add(new ItemIntResponse(Constantes.destinoRemisionProceso.EJECUCION_CONTRACTUAL, "EJECUCIÓN CONTRACTUAL"));					
				}else{
					items.add(new ItemIntResponse(Constantes.destinoRemisionProceso.PROCESO_SELECCION, "COORDINADOR DE PROCESO DE SELECCIÓN"));
					items.add(new ItemIntResponse(Constantes.destinoRemisionProceso.PROGRAMACION_COSTOS, "PROGRAMACIÓN Y COSTOS"));
				}		
				resultado.setDestinos(items);
			}				
			
			//this.listResultadoSend = resul

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
	
	public void sendToEjecucion(){
		
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
	
	public void validateSelectedRowConvocatoria() throws UnselectedRowException, CloneNotSupportedException {
		if (this.selectedConvocatoria == null)
			throw new UnselectedRowException(Messages.getString("no.record.selected"));
		else
			this.setCurrentConvocatoria((ConvocatoriaDto) this.selectedConvocatoria.clone());
	}	

	public void varlidarFecha(){				
		String valor = "";
		//FacesMessage msg = new FacesMessage("Se editó correctamente",null);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Mensaje", null));
		
	}
	
	// Datatable Editable
	public void onRowEdit(RowEditEvent event) {
		DataTable dt = (DataTable)event.getSource();
		
		
		FacesMessage msg = new FacesMessage("Se editó correctamente",
				"Convocatoria: " + ((ConvocatoriaDto) event.getObject()).getNroconvocatoria());
		ConvocatoriaDto convoca = ((ConvocatoriaDto) event.getObject());
		// get description of the status
		try {
			// validate the date
			throw new Exception("Error");
			/*
			if (convoca.getFechainicio().compareTo(convoca.getFechafin()) <= 0) {

				String id = ((ConvocatoriaDto) event.getObject()).getIdcatalogoestadoconvocatoria();
				((ConvocatoriaDto) event.getObject()).setDescripcionestado(gentablaBusiness.getDescripcion(id));
			} else {
				// cancel editing
				onRowCancel(event);				
				
				// throw new ValidatorException(
				// FacesMessageUtil.newBundledFacesMessage(FacesMessage.SEVERITY_ERROR,
				// "", "msg.dateRange", ((Calendar)component).getLabel(),
				// startDate);
			}*/
		} catch (Exception ex) {
			msg = new FacesMessage("Falló");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onRowCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Se canceló la edición",
				"Convocatoria: " + ((ConvocatoriaDto) event.getObject()).getNroconvocatoria());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onRowEditCalendar(RowEditEvent event) {
		//onRowCancelCalendar(event);
		
		
		FacesMessage msg = new FacesMessage("Se editó correctamente",
				"Calendario: " + ((CalendarioDto) event.getObject()).getNombrecalendario());
		try {
			String id = ((CalendarioDto) event.getObject()).getIdcatalogoestadopublicacion();
			((CalendarioDto) event.getObject()).setDescripcionestado(gentablaBusiness.getDescripcion(id));

		} catch (Exception ex) {
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onRowCancelCalendar(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Se canceló la edición",
				"Calendario: " + ((CalendarioDto) event.getObject()).getNombrecalendario());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onRowEditResultado(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Se editó correctamente",
				"Resultado: " + ((ProcesoResultadoItemDto) event.getObject()).getNroitem());
		try {
			String id = ((ProcesoResultadoItemDto) event.getObject()).getIdcatalogoestadoresultado();
			((ProcesoResultadoItemDto) event.getObject()).setDescripcionestado(gentablaBusiness.getDescripcion(id));

		} catch (Exception ex) {
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onRowCancelResultado(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Se canceló la edición",
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

	
	
	// properties

}
