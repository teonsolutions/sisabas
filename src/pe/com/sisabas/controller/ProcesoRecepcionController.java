package pe.com.sisabas.controller;

import java.io.File;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.primefaces.event.SelectEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;

import pe.com.sisabas.be.Comiteproceso;
import pe.com.sisabas.be.Gentabla;
import pe.com.sisabas.be.Miembrocomiteporproceso;
import pe.com.sisabas.be.Persona;
import pe.com.sisabas.business.GentablaBusiness;
import pe.com.sisabas.business.MiembrocomiteporprocesoBusiness;
import pe.com.sisabas.business.ProcesoBusiness;
import pe.com.sisabas.business.VcentrocostoBusiness;
import pe.com.sisabas.dto.CentroCostoRequest;
import pe.com.sisabas.dto.CentroCostoResponse;
import pe.com.sisabas.dto.EstadoRequerimientoResponse;
import pe.com.sisabas.dto.ObservacionDocumentoTecnicoDto;
import pe.com.sisabas.dto.PacConsolidadoDto;
import pe.com.sisabas.dto.ProcesoDto;
import pe.com.sisabas.dto.ProcesoRequest;
import pe.com.sisabas.dto.TipoProcesoResponse;
import pe.com.sisabas.dto.TransactionRequest;
import pe.com.sisabas.dto.TransactionResponse;
import pe.com.sisabas.exception.BusinessException;
import pe.com.sisabas.exception.SecurityRestrictedControlException;
import pe.com.sisabas.exception.SecuritySessionExpiredException;
import pe.com.sisabas.exception.SecurityValidateException;
import pe.com.sisabas.exception.UnselectedRowException;
import pe.com.sisabas.exception.ValidateException;
import pe.com.sisabas.resources.Constantes;
import pe.com.sisabas.resources.Email;
import pe.com.sisabas.resources.Messages;
import pe.com.sisabas.resources.controller.BaseController;
import pe.com.sisabas.service.SicuCallService;
import pe.com.sisabas.service.Sicuusuario;

@Component(value = "procesoRecepcion")
@Scope(value = "session")
public class ProcesoRecepcionController extends BaseController {
	private static final long serialVersionUID = 1L;

	private List<ProcesoDto> dataList;
	private ProcesoDto selectedRow;
	private ProcesoRequest searchParam;
	private ProcesoDto currentRow;

	// Title
	private String tituloBase;
	private String tituloParam;
	private String accion;
	private String tituloMiembroComite;

	// DropDownList
	public List<Gentabla> listaGentablaIdcatalogotipobien;
	public List<TipoProcesoResponse> listaTipoProceso;
	public List<CentroCostoResponse> listaCentroCosto;
	public List<EstadoRequerimientoResponse> listaEstadoRequerimiento;

	// Redirect
	public static String SUCCESS_MIEMBROS = "/pages/procesorecepcion/ordenRegistrar.xhtml?faces-redirect=true;";
	private String idOpcionText = "OPC_PROCESO";

	// To Funcionality
	private boolean selectedToReceive = false;
	private boolean selectedToComite = false;

	// members
	private Miembrocomiteporproceso miembrocomiteporproceso;
	private Miembrocomiteporproceso selectedMiembrocomiteporproceso;
	private List<Miembrocomiteporproceso> listaMiembrocomiteporproceso;
	private boolean esSeleccionadoMiembroComite;
	public List<Gentabla> listaGentablaIdcatalogotipomiembro;

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

	public void ProcesoRecepcionController() {

	}

	public void seleccionItem(SelectEvent e) {
		esSeleccionado = true;
	}

	public String load() {
		return "/pages/procesorecepcion/procesoRecepcionBuscar.xhtml?faces-redirect=true";
	}

	@PostConstruct
	public void init() {
		searchParam = new ProcesoRequest();
		tituloBase = "Recepción de documentos » ";
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
			listaGentablaIdcatalogotipomiembro = gentablaBusiness
					.selectDynamicBasic(new Gentabla().getObjBusqueda(Constantes.tabla.CAMI));

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

	public void validateSelectedRowMiembro() throws UnselectedRowException, CloneNotSupportedException {
		if (this.selectedMiembrocomiteporproceso == null)
			throw new UnselectedRowException(Messages.getString("no.record.selected"));
		else
			this.setMiembrocomiteporproceso((Miembrocomiteporproceso) this.selectedMiembrocomiteporproceso.clone());
	}

	public void seleccionItemMiembroComite(SelectEvent e) {
		esSeleccionadoMiembroComite = true;
	}

	// methods
	public void search() {
		try {
			Sicuusuario usuario = (Sicuusuario) getHttpSession().getAttribute("sicuusuarioSESSION");
			this.searchParam.setAnio(usuario.getPeriodo().getAnio());
			this.searchParam.setIdUnidadEjecutoraSiaf(Constantes.unidadEjecutora.PRONIED_SIAF);
			this.setEsSeleccionado(false);
			this.dataList = procesoBusiness.searchProceso(this.searchParam);

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

	public void recibir() {
		REGISTER_INIT();
		try {
			securityControlValidate("btnRecibir");
			validateSelectedRow();

			ProcesoDto processSave = (ProcesoDto) this.currentRow.clone();
			TransactionRequest<ProcesoDto> request = new TransactionRequest<ProcesoDto>();
			request.setUsuarioAuditoria(getUserLogin());
			request.setEquipoAuditoria(getRemoteAddr());
			request.setEntityTransaction(processSave);
			processSave.setNombreEspecialistaProceso(getUserName());
			processSave.setDniEspecialistaProceso(getDni());

			procesoBusiness.recibirProceso(request);

			showGrowlMessageSuccessfullyCompletedAction();
			search();
			this.setSelectedToReceive(false);
			this.setSelectedToComite(false);

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

	public void resetRegisterForm() {
		reset("frmComiteSeleccion:panelC");
	}

	public void irComite() {
		STATUS_INIT();
		try {
			securityControlValidate("btnComite");
			resetRegisterForm();
			validateSelectedRow();
			buscarMiembroComite();

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

	public void buscarMiembroComite() {
		try {
			listaMiembrocomiteporproceso = miembrocomiteporprocesoBusiness.selectDynamicFullByIdComiteProceso(this.currentRow.getIdComiteProceso() != null ? this.currentRow.getIdComiteProceso() : 0);
			setEsSeleccionadoMiembroComite(false);
			setSelectedMiembrocomiteporproceso(null);
			if (listaMiembrocomiteporproceso.size() == 0)
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

	public void loadRegIdpersona(org.primefaces.event.SelectEvent event) {
		try {
			logger.debug("loadRegPersona.event...");
			pe.com.sisabas.be.Persona item = (pe.com.sisabas.be.Persona) event.getObject();
			logger.debug("loadmiembrocomiteporproceso.event...:" + item.getIdpersona());
			miembrocomiteporproceso.setIdpersona(item.getIdpersona());
			miembrocomiteporproceso.setPersonaIdpersona(item);
			logger.debug("loadPersona.event...ok");
			resetRegisterForm();
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}

	public void resetRegisterFormMiembroComite() {
		reset("frmMiembrocomiteporprocesoRegistrar:panelC");
	}

	public void irRegistrarMiembroComite() {
		STATUS_INIT();
		try {
			securityControlValidate("btnNuevoMiembroComite");
			resetRegisterFormMiembroComite();
			accion = REGISTRAR;
			tituloBase = "Miembro Comite » " + REGISTRAR;
			miembrocomiteporproceso = new Miembrocomiteporproceso();

			miembrocomiteporproceso.setBooleanesnotificado(false);

			miembrocomiteporproceso.setIdmiembrocomiteproceso(new java.lang.Integer(0));
			// miembrocomiteporproceso.setIdmiembrocomiteproceso((int)utilsBusiness.getNextSeqTemporal(pe.com.sisabas.resources.Sequence.SEQ_MIEMBROCOMITEPORPROCESO).longValue());
			miembrocomiteporproceso.setComiteprocesoIdcomiteproceso(new Comiteproceso());
			miembrocomiteporproceso.setPersonaIdpersona(new Persona());

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

	public void irEditarMiembroComite() {
		STATUS_INIT();
		try {
			securityControlValidate("btnEditarMiembroComite");
			resetRegisterFormMiembroComite();
			validateSelectedRowMiembro();
			// updateCharToBoolean(miembrocomiteporproceso);
			miembrocomiteporproceso.roundBigDecimals();
			accion = EDITAR;
			tituloBase = "Miembro Comite » " + EDITAR;

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
		} catch (UnselectedRowException e) {
			STATUS_ERROR();
			addMessageKey("msgsForm", e.getMessage(), FacesMessage.SEVERITY_ERROR);
		} catch (Exception e) {
			STATUS_ERROR();
			addErrorMessageKey("msgsForm", e);
		}
	}

	public void aceptarMiembroComite() {
		REGISTER_INIT();
		try {

			TransactionRequest<ProcesoDto> request = new TransactionRequest<ProcesoDto>();
			request.setEntityTransaction(this.currentRow);
			request.setUsuarioAuditoria(getUserLogin());
			request.setEquipoAuditoria(getRemoteAddr());
			request.setProgramaAuditoria(pe.com.sisabas.resources.Utils.obtenerPrograma(this.getClass()));
			TransactionResponse<Miembrocomiteporproceso> result = procesoBusiness.grabarMiembrosComite(request,
					miembrocomiteporproceso);

			if (accion.equals(REGISTRAR)) {
				if (this.currentRow.getIdComiteProceso() == null) {
					this.currentRow.setIdComiteProceso(result.getEntityTransaction().getIdcomiteproceso()); // IdComiteProceso
				}
			}

			showGrowlMessageSuccessfullyCompletedAction();
			buscarMiembroComite();
			REGISTER_SUCCESS();

		} catch (ValidateException e) {
			REGISTER_ERROR();
			addMessageKey("msgsMiembrocomiteporprocesoR", e.getMessage(), FacesMessage.SEVERITY_ERROR);
		} catch (BusinessException e) {
			REGISTER_ERROR();
			addMessageKey("msgsMiembrocomiteporprocesoR", e.getMessage(), FacesMessage.SEVERITY_ERROR);
		} catch (DataIntegrityViolationException e) {
			addMessageKey("msgsForm", Messages.getString("exception.dataintegrity.message.title"),
					Messages.getString("exception.dataintegrity.message.detail"), FacesMessage.SEVERITY_ERROR);
		} catch (Exception e) {
			REGISTER_ERROR();
			addErrorMessageKey("msgsMiembrocomiteporprocesoR", e);
		}
	}

	public void goSendMail() {
		STATUS_INIT();
		try {
			securityControlValidate("btnNotifyMiembroComite");
			validateSelectedRowMiembro();

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

	public void sendMailComite() {
		try {			
			List<String> ordenListaCampos = new ArrayList<String>();
			ordenListaCampos.add("A1.IDMIEMBROCOMITEPROCESO");
			Miembrocomiteporproceso miembrocomiteporproceso = new Miembrocomiteporproceso();
			miembrocomiteporproceso.setOrdenListaCampos(ordenListaCampos);
			miembrocomiteporproceso.setOrdenTipo("DESC");

			// Add conditions IN clause
			miembrocomiteporproceso.addConditionInIdcatalogotipomiembro(null);
			miembrocomiteporproceso.addConditionInIdcatalogoestadomiembrocomite(null);
			// miembrocomiteporproceso.setIdcomiteproceso(currentPao.getIdTipoBien());
			miembrocomiteporproceso.setIdcomiteproceso(
					this.currentRow.getIdComiteProceso() != null ? this.currentRow.getIdComiteProceso() : 0);

			listaMiembrocomiteporproceso = miembrocomiteporprocesoBusiness.selectDynamicFull(miembrocomiteporproceso);
			String[] addresses = new String[listaMiembrocomiteporproceso.size()];
			List<Miembrocomiteporproceso> membersNotified = new ArrayList<Miembrocomiteporproceso>();
			
			int pos = 0;
			for (Miembrocomiteporproceso member : listaMiembrocomiteporproceso) {
				if (member.getEsnotificado() == null || member.getEsnotificado().equals("0")) {
					// addresses.add(member.getCorreo());
					addresses[pos] = member.getCorreo();
					membersNotified.add(member);
					pos++;
				}				
			}
			// body
			String body = "Es grato dirigirme a ustedes con la finalidad de notificarles el formato de solicitud, de aprobación de expediente de contratación y designación de miembros de comité; especial de fecha {0}, en conformidad al artículo 27; del Reglamento de la Ley de Contrataciones del Estado, mediante el cual se les designa como integrantes del comité; especial.";
			HttpServletRequest  httpServletRequest  = (HttpServletRequest)  FacesContext.getCurrentInstance().getExternalContext().getRequest();
			String path    = httpServletRequest.getServletContext().getRealPath("/miembrosComiteMessage.xml");
			
			File xmlFile = new File(path);
			DocumentBuilderFactory dbFactory  = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder;
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(xmlFile);
			doc.getDocumentElement().normalize();
			doc.getDocumentElement().getNodeName();
			NodeList nodeList = doc.getElementsByTagName("Asunto");
			Node node = (Node)nodeList.item(0);
			body = node.getNodeName();
						
			// Send mail
			String asunto = String.format(
					"NOTIFICACIÓN DE DESIGNACIÓN DE COMITÉ ESPECIAL - {0} N° {1}-{2}-PRONIED/UE {3}",
					this.currentRow.getNroProceso(), this.currentRow.getNroProceso(), this.currentRow.getNroProceso());
			body = "Es grato dirigirme a ustedes con la finalidad de notificarles el formato de solicitud, de aprobación de expediente de contratación y designación de miembros de comité; especial de fecha {0}, en conformidad al artículo 27; del Reglamento de la Ley de Contrataciones del Estado, mediante el cual se les designa como integrantes del comité; especial.";
					

			//Email mail = new Email();
			//mail.sendEmail(addresses, null, asunto, body, "");
			
			/*
			 * if (listaMiembrocomiteporproceso.size() == 0)
			 * addMessageKey("msgsForm", Messages.getString("no.records.found"),
			 * FacesMessage.SEVERITY_INFO);
			 */
			
			//update member notified
			TransactionRequest<List<Miembrocomiteporproceso>> request = new TransactionRequest<List<Miembrocomiteporproceso>>();
			request.setUsuarioAuditoria(getUserLogin());
			request.setEquipoAuditoria(getRemoteAddr());
			request.setEntityTransaction(membersNotified);
			procesoBusiness.NotificarMiembros(request);
			buscarMiembroComite();
		
			showGrowlMessageSuccessfullyCompletedAction();
			STATUS_SUCCESS();

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

	public void irEliminarMiembroComite() {
		STATUS_INIT();
		try {
			securityControlValidate("btnEliminarMiembroComite");
			validateSelectedRowMiembro();

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

	// Properties
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
		if (this.selectedRow == null) {
			this.setSelectedToReceive(false);
			this.setSelectedToComite(false);
		} else {
			this.setSelectedToReceive(selectedRow.getIdProcesoSeleccion() == null);
			this.setSelectedToComite(selectedRow.getIdProcesoSeleccion() == null ? false : true);
		}
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

	public boolean isSelectedToReceive() {
		return selectedToReceive;
	}

	public void setSelectedToReceive(boolean selectedToReceive) {
		this.selectedToReceive = selectedToReceive;
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

	public boolean isSelectedToComite() {
		return selectedToComite;
	}

	public void setSelectedToComite(boolean selectedToComite) {
		this.selectedToComite = selectedToComite;
	}

	public Miembrocomiteporproceso getMiembrocomiteporproceso() {
		return miembrocomiteporproceso;
	}

	public void setMiembrocomiteporproceso(Miembrocomiteporproceso miembrocomiteporproceso) {
		this.miembrocomiteporproceso = miembrocomiteporproceso;
	}

	public Miembrocomiteporproceso getSelectedMiembrocomiteporproceso() {
		return selectedMiembrocomiteporproceso;
	}

	public void setSelectedMiembrocomiteporproceso(Miembrocomiteporproceso selectedMiembrocomiteporproceso) {
		this.selectedMiembrocomiteporproceso = selectedMiembrocomiteporproceso;
	}

	public List<Miembrocomiteporproceso> getListaMiembrocomiteporproceso() {
		return listaMiembrocomiteporproceso;
	}

	public void setListaMiembrocomiteporproceso(List<Miembrocomiteporproceso> listaMiembrocomiteporproceso) {
		this.listaMiembrocomiteporproceso = listaMiembrocomiteporproceso;
	}

	public boolean isEsSeleccionadoMiembroComite() {
		return esSeleccionadoMiembroComite;
	}

	public void setEsSeleccionadoMiembroComite(boolean esSeleccionadoMiembroComite) {
		this.esSeleccionadoMiembroComite = esSeleccionadoMiembroComite;
	}

	public String getAccion() {
		return accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

	public List<Gentabla> getListaGentablaIdcatalogotipomiembro() {
		return listaGentablaIdcatalogotipomiembro;
	}

	public void setListaGentablaIdcatalogotipomiembro(List<Gentabla> listaGentablaIdcatalogotipomiembro) {
		this.listaGentablaIdcatalogotipomiembro = listaGentablaIdcatalogotipomiembro;
	}

	public String getTituloMiembroComite() {
		return tituloMiembroComite;
	}

	public void setTituloMiembroComite(String tituloMiembroComite) {
		this.tituloMiembroComite = tituloMiembroComite;
	}

}
