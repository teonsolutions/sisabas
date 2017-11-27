
package pe.com.sisabas.controller;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;

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
import pe.com.sisabas.be.Pedido;
import pe.com.sisabas.be.Pacprogramado;
import pe.com.sisabas.be.Comiteproceso;
import pe.com.sisabas.business.GentablaBusiness;
import pe.com.sisabas.be.Gentabla;
import pe.com.sisabas.business.GentablaBusiness;
import pe.com.sisabas.be.Gentabla;



@Component(value ="documentotecnico")
@Scope(value = "session")
public class DocumentotecnicoController extends BaseController {

	private static final long serialVersionUID = 1L;
	private StreamedContent file;
	private Documentotecnico documentotecnicoB;
	private Documentotecnico documentotecnico;
	private Documentotecnico selectedDocumentotecnico;
	private List<Documentotecnico> listaDocumentotecnico;
	public List<Gentabla> listaGentablaIdcatalogotipodocumentotecnico;
	public List<Gentabla> listaGentablaIdcatalogotipotdr;

	private String accion;
	private String titulo;
	
	private String tituloBase; //titulo de la opcion
	private String tituloParam;//titulo que llega como parametro (derivada padre)
	
	private String esDerivada="0";
	
	@Autowired
	public pe.com.sisabas.resources.business.UtilsBusiness utilsBusiness;

	@Autowired
	public DocumentotecnicoBusiness business;

	@Autowired
	public GentablaBusiness gentablaBusiness;



	//Nota: idOpcion, sicuopcion estan en BaseController
	private String idOpcionText = "OPC_DOCUMENTOTECNICO";
	public DocumentotecnicoController(){
			documentotecnico = new Documentotecnico();
			documentotecnico.setPedidoIdpedido(new Pedido());
			documentotecnico.setPacprogramadoIdpacprogramado(new Pacprogramado());
			documentotecnico.setComiteprocesoIdcomiteproceso(new Comiteproceso());

	}


	@PostConstruct
	public void init(){
		try {
			documentotecnicoB = new Documentotecnico();
			tituloBase = "Documento tecnico » ";
			if(SICU_SECURITY_ENABLE){
				idOpcion   = SicuCallService.obtenerIdOpcion(idOpcionText).toString();
				sicuopcion = SicuCallService.obtenercontroles(idOpcion);
			}
			documentotecnicoB.setPedidoIdpedido(new Pedido());
			documentotecnicoB.setPacprogramadoIdpacprogramado(new Pacprogramado());
			documentotecnicoB.setComiteprocesoIdcomiteproceso(new Comiteproceso());

			listaIdcatalogotipodocumentotecnicoKeys= new ArrayList<String>();
			listaIdcatalogotipotdrKeys= new ArrayList<String>();

			listaGentablaIdcatalogotipodocumentotecnico = gentablaBusiness.selectDynamicBasic(new Gentabla().getObjBusqueda(Constantes.tabla.TSDP));
			listaGentablaIdcatalogotipotdr = gentablaBusiness.selectDynamicBasic(new Gentabla().getObjBusqueda(Constantes.tabla.TITD));

		} catch (SecuritySessionExpiredException e) {
			redirectSessionExpiredPage();
		} catch (SecurityRestrictedControlException e) {
			STATUS_ERROR();
			addMessageKey("msgsForm", Messages.getString("no.access"),e.getMessage(),FacesMessage.SEVERITY_ERROR);
		} catch (SecurityValidateException e) {
			STATUS_ERROR();
			addMessageKey("msgsForm",e.getMessage(),FacesMessage.SEVERITY_ERROR);
		} catch (RemoteException e) {
			STATUS_ERROR();
			addMessageKey("msgsForm", Messages.getString("sicu.remote.exeption"),e.getMessage(),FacesMessage.SEVERITY_ERROR);
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}

	public void buscar() {
		try {
			List<String> ordenListaCampos=new ArrayList<String>();
			ordenListaCampos.add("A1.IDDOCUMENTOTECNICO");
			documentotecnicoB.setOrdenListaCampos(ordenListaCampos);
			documentotecnicoB.setOrdenTipo("DESC");

			//Add conditions IN clause
			documentotecnicoB.addConditionInIdcatalogotipodocumentotecnico(listaIdcatalogotipodocumentotecnicoKeys);
			documentotecnicoB.addConditionInIdcatalogotipotdr(listaIdcatalogotipotdrKeys);

			pe.com.sisabas.resources.Utils.convertPropertiesStringToUppercase(documentotecnicoB); //pasa a mayusculas los datos para la busqueda
			listaDocumentotecnico = business.selectDynamicFull(documentotecnicoB);
			setEsSeleccionado(false);
			setSelectedDocumentotecnico(null);
			if (listaDocumentotecnico.size() == 0)
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

	public void irRegistrar() {
		STATUS_INIT();
		try {
			securityControlValidate("btnNuevo");
			//resetRegisterForm();
			accion = REGISTRAR;
			titulo = "Documento tecnico » " + REGISTRAR;
			documentotecnico = new Documentotecnico();

			documentotecnico.setBooleantienecomite(false);
			documentotecnico.setBooleanitinerarioorigenregistrado(false);

			documentotecnico.setIddocumentotecnico(new java.lang.Integer(0));
			documentotecnico.setIddocumentotecnico((int)utilsBusiness.getNextSeqTemporal(pe.com.sisabas.resources.Sequence.SEQ_DOCUMENTOTECNICO).longValue());
			documentotecnico.setPedidoIdpedido(new Pedido());
			documentotecnico.setPacprogramadoIdpacprogramado(new Pacprogramado());
			documentotecnico.setComiteprocesoIdcomiteproceso(new Comiteproceso());

			documentotecnico.setIdpedido(documentotecnicoB.getIdpedido());

			STATUS_SUCCESS();
			REGISTER_INIT();
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
		} catch (Exception e) {
			STATUS_ERROR();
			addErrorMessageKey("msgsForm", e);
		}
	}

	@Autowired
	PlazopagodocumentotecnicoController plazopagodocumentotecnicoController;
	public String irPlazopagodocumentotecnico() {
		boolean validado=false;
		try {
			securityControlValidate("btnPlazopagodocumentotecnico");
			validateSelectedRow();
			String paramTitulo = new String((tituloParam!=null?tituloParam:"")+" "+tituloBase);
			plazopagodocumentotecnicoController.setTituloParam(paramTitulo);
			plazopagodocumentotecnicoController.init(documentotecnico);

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
		if(validado) return "/pages/plazopagodocumentotecnico/plazopagodocumentotecnicoBuscar.xhtml?faces-redirect=true";
		else return null;
	}

	@Autowired
	DependenciadocumentotecnicoController dependenciadocumentotecnicoController;
	public String irDependenciadocumentotecnico() {
		boolean validado=false;
		try {
			securityControlValidate("btnDependenciadocumentotecnico");
			validateSelectedRow();
			String paramTitulo = new String((tituloParam!=null?tituloParam:"")+" "+tituloBase);
			dependenciadocumentotecnicoController.setTituloParam(paramTitulo);
			dependenciadocumentotecnicoController.init(documentotecnico);

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
		if(validado) return "/pages/dependenciadocumentotecnico/dependenciadocumentotecnicoBuscar.xhtml?faces-redirect=true";
		else return null;
	}

	@Autowired
	ItinerarioconveniomarcoController itinerarioconveniomarcoController;
	public String irItinerarioconveniomarco() {
		boolean validado=false;
		try {
			securityControlValidate("btnItinerarioconveniomarco");
			validateSelectedRow();
			String paramTitulo = new String((tituloParam!=null?tituloParam:"")+" "+tituloBase);
			itinerarioconveniomarcoController.setTituloParam(paramTitulo);
			itinerarioconveniomarcoController.init(documentotecnico);

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
		if(validado) return "/pages/itinerarioconveniomarco/itinerarioconveniomarcoBuscar.xhtml?faces-redirect=true";
		else return null;
	}

	@Autowired
	ObservacionesdocumentotecnicoController observacionesdocumentotecnicoController;
	public String irObservacionesdocumentotecnico() {
		boolean validado=false;
		try {
			securityControlValidate("btnObservacionesdocumentotecnico");
			validateSelectedRow();
			String paramTitulo = new String((tituloParam!=null?tituloParam:"")+" "+tituloBase);
			observacionesdocumentotecnicoController.setTituloParam(paramTitulo);
			observacionesdocumentotecnicoController.init(documentotecnico);

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
		if(validado) return "/pages/observacionesdocumentotecnico/observacionesdocumentotecnicoBuscar.xhtml?faces-redirect=true";
		else return null;
	}

	public String load() {
		return"/pages/documentotecnico/documentotecnicoBuscar.xhtml?faces-redirect=true";
	}

	public void init(pe.com.sisabas.be.Pedido pedido) throws Exception{
		init();
		documentotecnicoB.setIdpedido(pedido.getIdpedido());
		documentotecnicoB.setPedidoIdpedido(pedido);
		esDerivada = "1";
		buscar();
	}

	public void initDerivedTable(pe.com.sisabas.be.Pedido pedido) throws Exception{
		init();
		documentotecnicoB.setIdpedido(pedido.getIdpedido());
		documentotecnicoB.setPedidoIdpedido(pedido);
		esDerivada = "1";
		buscar();
	}

	public void irEditar() {
		STATUS_INIT();
		try {
			securityControlValidate("btnEditar");
			resetRegisterForm();
			validateSelectedRow();
			updateCharToBoolean(documentotecnico);
			documentotecnico.roundBigDecimals();
			accion = EDITAR;
			titulo = "Documento tecnico » " + EDITAR;


			STATUS_SUCCESS();
			REGISTER_INIT();
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

	public void irEliminar() {
		STATUS_INIT();
		try {
			securityControlValidate("btnEliminar");
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

	public void irDetalle() {
		STATUS_INIT();
		
		try {
			securityControlValidate("btnDetalle");
			validateSelectedRow();
			documentotecnico.roundBigDecimals();
			accion = DETALLE;
			titulo = "Documento tecnico » " + DETALLE;

			String paramTitulo = new String((tituloParam!=null?tituloParam:"")+" "+tituloBase);
			plazopagodocumentotecnicoController.setTituloParam(paramTitulo);
			plazopagodocumentotecnicoController.initDerivedTable(documentotecnico);

			dependenciadocumentotecnicoController.setTituloParam(paramTitulo);
			dependenciadocumentotecnicoController.initDerivedTable(documentotecnico);

			itinerarioconveniomarcoController.setTituloParam(paramTitulo);
			itinerarioconveniomarcoController.initDerivedTable(documentotecnico);

			observacionesdocumentotecnicoController.setTituloParam(paramTitulo);
			observacionesdocumentotecnicoController.initDerivedTable(documentotecnico);

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

	public void irImprimir() {
		STATUS_INIT();
		try {
			securityControlValidate("btnImprimir");
			//resetRegisterForm();
			accion = IMPRIMIR;
			titulo = "Documento tecnico » " + IMPRIMIR;

			STATUS_SUCCESS();
			REGISTER_INIT();
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
		} catch (Exception e) {
			STATUS_ERROR();
			addErrorMessageKey("msgsForm", e);
		}
	}

	public void irAnular() {
		STATUS_INIT();
		try {
			securityControlValidate("btnAnularActivar");
			//resetRegisterForm();
			resetAnulacionForm();
			validateSelectedRow();
			if(documentotecnico.getEstadoauditoria().equals("1")){
				accion = ANULAR;
			}else{
				accion = ACTIVAR;
			}
			titulo = "Documento tecnico » " + accion;

			STATUS_SUCCESS();
			REGISTER_INIT();
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

	public void anular() {
		try {
			Documentotecnico record= new Documentotecnico();
			if(documentotecnico.getEstadoauditoria().equals("1")){
				record.setEstadoauditoria("0");
			}else{
				record.setEstadoauditoria("1");
			}
			record.setIddocumentotecnico(documentotecnico.getIddocumentotecnico());
			record.setUsuariomodificacionauditoria(getUserLogin());
			business.updateByPrimaryKeySelectiveBasic(record);

			showGrowlMessageSuccessfullyCompletedAction();
			buscar();

			REGISTER_SUCCESS();
		} catch (ValidateException e) {
			REGISTER_ERROR();
			addMessageKey("msgsDocumentotecnicoA", e.getMessage(),
			FacesMessage.SEVERITY_ERROR);
		} catch (BusinessException e) {
			REGISTER_ERROR();
			addMessageKey("msgsDocumentotecnicoA", e.getMessage(),
			FacesMessage.SEVERITY_ERROR);
		} catch (Exception e) {
			REGISTER_ERROR();
			addErrorMessageKey("msgsDocumentotecnicoA", e);
		}
	}

	public void setTemporalVars() throws Exception{
			documentotecnico.setGentablaIdcatalogotipodocumentotecnico(gentablaBusiness.selectByPrimaryKeyBasicFromList(documentotecnico.getIdcatalogotipodocumentotecnico(),listaGentablaIdcatalogotipodocumentotecnico));
			documentotecnico.setGentablaIdcatalogotipotdr(gentablaBusiness.selectByPrimaryKeyBasicFromList(documentotecnico.getIdcatalogotipotdr(),listaGentablaIdcatalogotipotdr));

	}
	public void aceptar() {
			REGISTER_INIT();
		try {
			if (accion.equals(REGISTRAR)){
				documentotecnico.setUsuariocreacionauditoria(getUserLogin());
				documentotecnico.setEquipoauditoria(getRemoteAddr());
				documentotecnico.setProgramaauditoria(pe.com.sisabas.resources.Utils.obtenerPrograma(this.getClass()));
				business.insertBasic(documentotecnico);
			}else{
				documentotecnico.setUsuariomodificacionauditoria(getUserLogin());
				documentotecnico.setEquipoauditoria(getRemoteAddr());
				documentotecnico.setProgramaauditoria(pe.com.sisabas.resources.Utils.obtenerPrograma(this.getClass()));
				business.updateByPrimaryKeyBasic(documentotecnico);
			}

			showGrowlMessageSuccessfullyCompletedAction();
			buscar();

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

	public void eliminar() {
		try {
			validateSelectedRow();
			documentotecnico.setUsuariomodificacionauditoria(getUserLogin());
			business.deleteByPrimaryKeyBasic(documentotecnico);
			showGrowlMessageSuccessfullyCompletedAction();
			buscar();
		} catch (ValidateException e) {
			addMessageKey("msgsForm", e.getMessage(),
			FacesMessage.SEVERITY_ERROR);
		} catch (UnselectedRowException e) {
			addMessageKey("msgsForm", e.getMessage(),
			FacesMessage.SEVERITY_ERROR);
		} catch(DataIntegrityViolationException e) {
			addMessageKey("msgsForm", Messages.getString("exception.dataintegrity.message.title"),Messages.getString("exception.dataintegrity.message.detail"),
			FacesMessage.SEVERITY_ERROR);
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}

	public void validateSelectedRow() throws UnselectedRowException, CloneNotSupportedException {
		if (selectedDocumentotecnico == null)
			throw new UnselectedRowException(Messages.getString("no.record.selected"));
		else
			documentotecnico = (Documentotecnico)selectedDocumentotecnico.clone();
	}

	public void makeFile() {
		try {
			File fileTMP = new File("D://temp/reporte.txt");
			InputStream stream = new FileInputStream(fileTMP);
			this.file = new DefaultStreamedContent(stream, "application/text",
			"reporte.txt");
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}

	public void loadMainIdpedido(org.primefaces.event.SelectEvent event) {
		try {
			logger.debug("loadMainPedido.event...");
			pe.com.sisabas.be.Pedido item= (pe.com.sisabas.be.Pedido) event.getObject();
			logger.debug("loaddocumentotecnico.event...:"+item.getIdpedido());
			documentotecnicoB.setIdpedido(item.getIdpedido());
			documentotecnicoB.setPedidoIdpedido(item);
			logger.debug("loadPedido.event...ok");
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}

	public void loadRegIdpedido(org.primefaces.event.SelectEvent event) {
		try {
			logger.debug("loadRegPedido.event...");
			pe.com.sisabas.be.Pedido item= (pe.com.sisabas.be.Pedido) event.getObject();
			logger.debug("loaddocumentotecnico.event...:"+item.getIdpedido());
			documentotecnico.setIdpedido(item.getIdpedido());
			documentotecnico.setPedidoIdpedido(item);
			logger.debug("loadPedido.event...ok");
			resetRegisterForm();
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}

	public void resetMainIdpedido() {
		try {
			documentotecnicoB.setIdpedido(null);
			documentotecnicoB.setPedidoIdpedido(new Pedido());
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}
	public void resetRegIdpedido() {
		try {
			documentotecnico.setIdpedido(null);
			documentotecnico.setPedidoIdpedido(new Pedido());
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}
	public void loadMainIdpacprogramado(org.primefaces.event.SelectEvent event) {
		try {
			logger.debug("loadMainPacprogramado.event...");
			pe.com.sisabas.be.Pacprogramado item= (pe.com.sisabas.be.Pacprogramado) event.getObject();
			logger.debug("loaddocumentotecnico.event...:"+item.getIdpacprogramado());
			documentotecnicoB.setIdpacprogramado(item.getIdpacprogramado());
			documentotecnicoB.setPacprogramadoIdpacprogramado(item);
			logger.debug("loadPacprogramado.event...ok");
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}

	public void loadRegIdpacprogramado(org.primefaces.event.SelectEvent event) {
		try {
			logger.debug("loadRegPacprogramado.event...");
			pe.com.sisabas.be.Pacprogramado item= (pe.com.sisabas.be.Pacprogramado) event.getObject();
			logger.debug("loaddocumentotecnico.event...:"+item.getIdpacprogramado());
			documentotecnico.setIdpacprogramado(item.getIdpacprogramado());
			documentotecnico.setPacprogramadoIdpacprogramado(item);
			logger.debug("loadPacprogramado.event...ok");
			resetRegisterForm();
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}

	public void resetMainIdpacprogramado() {
		try {
			documentotecnicoB.setIdpacprogramado(null);
			documentotecnicoB.setPacprogramadoIdpacprogramado(new Pacprogramado());
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}
	public void resetRegIdpacprogramado() {
		try {
			documentotecnico.setIdpacprogramado(null);
			documentotecnico.setPacprogramadoIdpacprogramado(new Pacprogramado());
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}
	public void loadMainIdcomiteproceso(org.primefaces.event.SelectEvent event) {
		try {
			logger.debug("loadMainComiteproceso.event...");
			pe.com.sisabas.be.Comiteproceso item= (pe.com.sisabas.be.Comiteproceso) event.getObject();
			logger.debug("loaddocumentotecnico.event...:"+item.getIdcomiteproceso());
			documentotecnicoB.setIdcomiteproceso(item.getIdcomiteproceso());
			documentotecnicoB.setComiteprocesoIdcomiteproceso(item);
			logger.debug("loadComiteproceso.event...ok");
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}

	public void loadRegIdcomiteproceso(org.primefaces.event.SelectEvent event) {
		try {
			logger.debug("loadRegComiteproceso.event...");
			pe.com.sisabas.be.Comiteproceso item= (pe.com.sisabas.be.Comiteproceso) event.getObject();
			logger.debug("loaddocumentotecnico.event...:"+item.getIdcomiteproceso());
			documentotecnico.setIdcomiteproceso(item.getIdcomiteproceso());
			documentotecnico.setComiteprocesoIdcomiteproceso(item);
			logger.debug("loadComiteproceso.event...ok");
			resetRegisterForm();
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}

	public void resetMainIdcomiteproceso() {
		try {
			documentotecnicoB.setIdcomiteproceso(null);
			documentotecnicoB.setComiteprocesoIdcomiteproceso(new Comiteproceso());
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}
	public void resetRegIdcomiteproceso() {
		try {
			documentotecnico.setIdcomiteproceso(null);
			documentotecnico.setComiteprocesoIdcomiteproceso(new Comiteproceso());
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}



	public String loadPage(){
		buscar();
		return "/pages/documentotecnico/documentotecnicoBuscar.xhtml?faces-redirect=true";
	}

	public void resetRegisterForm(){
		reset("frmDocumentotecnicoRegistrar:panelC");
	}
	public void resetAnulacionForm(){
		reset("frmDocumentotecnicoAnular:panelDetailC");
	}


	public void updateCharToBoolean(Documentotecnico record) throws Exception {
		if( documentotecnico.getTienecomite()!=null  && documentotecnico.getTienecomite().equalsIgnoreCase("1")){
			documentotecnico.setBooleantienecomite(true);
		}else {
			documentotecnico.setBooleantienecomite(false);
		}

		if( documentotecnico.getItinerarioorigenregistrado()!=null  && documentotecnico.getItinerarioorigenregistrado().equalsIgnoreCase("1")){
			documentotecnico.setBooleanitinerarioorigenregistrado(true);
		}else {
			documentotecnico.setBooleanitinerarioorigenregistrado(false);
		}

	}

	public void setDocumentotecnico(Documentotecnico documentotecnico){
		this.documentotecnico=documentotecnico;
	}

	public Documentotecnico getDocumentotecnico(){
		return documentotecnico;
	}

	public void setDocumentotecnicoB(Documentotecnico documentotecnicoB){
		this.documentotecnicoB = documentotecnicoB;
	}

	public Documentotecnico getDocumentotecnicoB(){
		return documentotecnicoB;
	}

	public void setSelectedDocumentotecnico(Documentotecnico selectedDocumentotecnico){
		this.selectedDocumentotecnico = selectedDocumentotecnico;
	}

	public Documentotecnico getSelectedDocumentotecnico(){
		return selectedDocumentotecnico;
	}

	public void setListaDocumentotecnico(List<Documentotecnico> listaDocumentotecnico){
		this.listaDocumentotecnico=listaDocumentotecnico;
	}

	public List<Documentotecnico> getListaDocumentotecnico(){
		return listaDocumentotecnico;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

	public String getAccion() {
		return accion;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setFile(StreamedContent file) {
		this.file = file;
	}

	public StreamedContent getFile() {
		return file;
	}

	public String getEsDerivada() {
		return esDerivada;
	}

	public void setEsDerivada(String esDerivada) {
		this.esDerivada = esDerivada;
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

	public void setListaGentablaIdcatalogotipodocumentotecnico(List<Gentabla> listaGentablaIdcatalogotipodocumentotecnico){
		this.listaGentablaIdcatalogotipodocumentotecnico=listaGentablaIdcatalogotipodocumentotecnico;
	}

	public List<Gentabla> getListaGentablaIdcatalogotipodocumentotecnico(){
		return listaGentablaIdcatalogotipodocumentotecnico;
	}

	public void setListaGentablaIdcatalogotipotdr(List<Gentabla> listaGentablaIdcatalogotipotdr){
		this.listaGentablaIdcatalogotipotdr=listaGentablaIdcatalogotipotdr;
	}

	public List<Gentabla> getListaGentablaIdcatalogotipotdr(){
		return listaGentablaIdcatalogotipotdr;
	}


	private List<String> listaIdcatalogotipodocumentotecnicoKeys;
	private String valuesIdcatalogotipodocumentotecnico;
	public void handleChangeIdcatalogotipodocumentotecnico(ToggleSelectEvent toggle){
		if(toggle.isSelected()){
			addAllItemsIdcatalogotipodocumentotecnico();
		}else{
			listaIdcatalogotipodocumentotecnicoKeys=new ArrayList<String>();
			valuesIdcatalogotipodocumentotecnico=Messages.getString("selectmanycheckbox.noitems");
		}
	}
	private void addAllItemsIdcatalogotipodocumentotecnico(){
		StringBuilder sbTmp=new StringBuilder("");
		listaIdcatalogotipodocumentotecnicoKeys=new ArrayList<String>();
		for (Gentabla s : listaGentablaIdcatalogotipodocumentotecnico) {
			listaIdcatalogotipodocumentotecnicoKeys.add(String.valueOf(s.getVchregcodigo()));
			sbTmp.append(s.getVchregdescri()+", ");
		}
		valuesIdcatalogotipodocumentotecnico=Utils.borrarComitaFinal(sbTmp.toString());
	}
	public void getValuesListenerIdcatalogotipodocumentotecnico(){
		StringBuilder sbTmp=new StringBuilder("");
		for (String key : listaIdcatalogotipodocumentotecnicoKeys) {
			sbTmp.append(getValueIdcatalogotipodocumentotecnico(key)+", ");
		}
		valuesIdcatalogotipodocumentotecnico=Utils.borrarComitaFinal(sbTmp.toString());
		if(listaIdcatalogotipodocumentotecnicoKeys.size()==0)
			valuesIdcatalogotipodocumentotecnico=Messages.getString("selectmanycheckbox.noitems");
	}
	private String getValueIdcatalogotipodocumentotecnico(String key){
		for (Gentabla s : listaGentablaIdcatalogotipodocumentotecnico) {
			if(String.valueOf(s.getVchregcodigo()).equalsIgnoreCase(key))
				return s.getVchregdescri().toString();
			}
		return "";
	}
	 public List<String> getListaIdcatalogotipodocumentotecnicoKeys() {
		return listaIdcatalogotipodocumentotecnicoKeys;
	}

	public void setListaIdcatalogotipodocumentotecnicoKeys(List<String> listaIdcatalogotipodocumentotecnicoKeys) {
		this.listaIdcatalogotipodocumentotecnicoKeys = listaIdcatalogotipodocumentotecnicoKeys;
	}

	 public String getValuesIdcatalogotipodocumentotecnico() {
		return valuesIdcatalogotipodocumentotecnico;
	}

	public void setValuesIdcatalogotipodocumentotecnico(String valuesIdcatalogotipodocumentotecnico) {
		this.valuesIdcatalogotipodocumentotecnico = valuesIdcatalogotipodocumentotecnico;
	}

///////////////////////////////

	private List<String> listaIdcatalogotipotdrKeys;
	private String valuesIdcatalogotipotdr;
	public void handleChangeIdcatalogotipotdr(ToggleSelectEvent toggle){
		if(toggle.isSelected()){
			addAllItemsIdcatalogotipotdr();
		}else{
			listaIdcatalogotipotdrKeys=new ArrayList<String>();
			valuesIdcatalogotipotdr=Messages.getString("selectmanycheckbox.noitems");
		}
	}
	private void addAllItemsIdcatalogotipotdr(){
		StringBuilder sbTmp=new StringBuilder("");
		listaIdcatalogotipotdrKeys=new ArrayList<String>();
		for (Gentabla s : listaGentablaIdcatalogotipotdr) {
			listaIdcatalogotipotdrKeys.add(String.valueOf(s.getVchregcodigo()));
			sbTmp.append(s.getVchregdescri()+", ");
		}
		valuesIdcatalogotipotdr=Utils.borrarComitaFinal(sbTmp.toString());
	}
	public void getValuesListenerIdcatalogotipotdr(){
		StringBuilder sbTmp=new StringBuilder("");
		for (String key : listaIdcatalogotipotdrKeys) {
			sbTmp.append(getValueIdcatalogotipotdr(key)+", ");
		}
		valuesIdcatalogotipotdr=Utils.borrarComitaFinal(sbTmp.toString());
		if(listaIdcatalogotipotdrKeys.size()==0)
			valuesIdcatalogotipotdr=Messages.getString("selectmanycheckbox.noitems");
	}
	private String getValueIdcatalogotipotdr(String key){
		for (Gentabla s : listaGentablaIdcatalogotipotdr) {
			if(String.valueOf(s.getVchregcodigo()).equalsIgnoreCase(key))
				return s.getVchregdescri().toString();
			}
		return "";
	}
	 public List<String> getListaIdcatalogotipotdrKeys() {
		return listaIdcatalogotipotdrKeys;
	}

	public void setListaIdcatalogotipotdrKeys(List<String> listaIdcatalogotipotdrKeys) {
		this.listaIdcatalogotipotdrKeys = listaIdcatalogotipotdrKeys;
	}

	 public String getValuesIdcatalogotipotdr() {
		return valuesIdcatalogotipotdr;
	}

	public void setValuesIdcatalogotipotdr(String valuesIdcatalogotipotdr) {
		this.valuesIdcatalogotipotdr = valuesIdcatalogotipotdr;
	}

///////////////////////////////



}

