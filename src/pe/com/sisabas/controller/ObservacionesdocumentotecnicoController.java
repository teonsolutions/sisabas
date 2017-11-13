
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
import pe.com.sisabas.be.Observacionesdocumentotecnico;
import pe.com.sisabas.business.ObservacionesdocumentotecnicoBusiness;
import pe.com.sisabas.be.Seccionesdocumentotecnico;



@Component(value ="observacionesdocumentotecnico")
@Scope(value = "session")
public class ObservacionesdocumentotecnicoController extends BaseController {

	private static final long serialVersionUID = 1L;
	private StreamedContent file;
	private Observacionesdocumentotecnico observacionesdocumentotecnicoB;
	private Observacionesdocumentotecnico observacionesdocumentotecnico;
	private Observacionesdocumentotecnico selectedObservacionesdocumentotecnico;
	private List<Observacionesdocumentotecnico> listaObservacionesdocumentotecnico;

	private String accion;
	private String titulo;
	
	private String tituloBase; //titulo de la opcion
	private String tituloParam;//titulo que llega como parametro (derivada padre)
	
	private String esDerivada="0";
	
	@Autowired
	public pe.com.sisabas.resources.business.UtilsBusiness utilsBusiness;

	@Autowired
	public ObservacionesdocumentotecnicoBusiness business;



	//Nota: idOpcion, sicuopcion estan en BaseController
	private String idOpcionText = "OPC_OBSERVACIONESDOC";
	public ObservacionesdocumentotecnicoController(){
			observacionesdocumentotecnico = new Observacionesdocumentotecnico();
			observacionesdocumentotecnico.setSeccionesdocumentotecnicoIdseccionesdocumentotecnico(new Seccionesdocumentotecnico());

	}


	@PostConstruct
	public void init(){
		try {
			observacionesdocumentotecnicoB = new Observacionesdocumentotecnico();
			tituloBase = "ObservacionesDocumentoTecnico » ";
			if(SICU_SECURITY_ENABLE){
				idOpcion   = SicuCallService.obtenerIdOpcion(idOpcionText).toString();
				sicuopcion = SicuCallService.obtenercontroles(idOpcion);
			}
			observacionesdocumentotecnicoB.setSeccionesdocumentotecnicoIdseccionesdocumentotecnico(new Seccionesdocumentotecnico());



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
			ordenListaCampos.add("A1.IDOBSERVACIONESDOCUMENTOTECNICO");
			observacionesdocumentotecnicoB.setOrdenListaCampos(ordenListaCampos);
			observacionesdocumentotecnicoB.setOrdenTipo("DESC");

			//Add conditions IN clause

			pe.com.sisabas.resources.Utils.convertPropertiesStringToUppercase(observacionesdocumentotecnicoB); //pasa a mayusculas los datos para la busqueda
			listaObservacionesdocumentotecnico = business.selectDynamicFull(observacionesdocumentotecnicoB);
			setEsSeleccionado(false);
			setSelectedObservacionesdocumentotecnico(null);
			if (listaObservacionesdocumentotecnico.size() == 0)
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
			resetRegisterForm();
			accion = REGISTRAR;
			titulo = "ObservacionesDocumentoTecnico » " + REGISTRAR;
			observacionesdocumentotecnico = new Observacionesdocumentotecnico();


			observacionesdocumentotecnico.setIdobservacionesdocumentotecnico(new java.lang.Integer(0));
			observacionesdocumentotecnico.setIdobservacionesdocumentotecnico((int)utilsBusiness.getNextSeqTemporal(pe.com.sisabas.resources.Sequence.SEQ_OBSERVACIONESDOCUMENTOTECNICO).longValue());
			observacionesdocumentotecnico.setSeccionesdocumentotecnicoIdseccionesdocumentotecnico(new Seccionesdocumentotecnico());

			observacionesdocumentotecnico.setIddocumentotecnico(observacionesdocumentotecnicoB.getIddocumentotecnico());

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

	public void init(pe.com.sisabas.be.Documentotecnico documentotecnico) throws Exception{
		init();
		observacionesdocumentotecnicoB.setIddocumentotecnico(documentotecnico.getIddocumentotecnico());
		observacionesdocumentotecnicoB.setDocumentotecnicoIddocumentotecnico(documentotecnico);
		esDerivada = "1";
		buscar();
	}

	public void initDerivedTable(pe.com.sisabas.be.Documentotecnico documentotecnico) throws Exception{
		init();
		observacionesdocumentotecnicoB.setIddocumentotecnico(documentotecnico.getIddocumentotecnico());
		observacionesdocumentotecnicoB.setDocumentotecnicoIddocumentotecnico(documentotecnico);
		esDerivada = "1";
		buscar();
	}

	public void irEditar() {
		STATUS_INIT();
		try {
			securityControlValidate("btnEditar");
			resetRegisterForm();
			validateSelectedRow();
			updateCharToBoolean(observacionesdocumentotecnico);
			observacionesdocumentotecnico.roundBigDecimals();
			accion = EDITAR;
			titulo = "ObservacionesDocumentoTecnico » " + EDITAR;


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
			observacionesdocumentotecnico.roundBigDecimals();
			accion = DETALLE;
			titulo = "ObservacionesDocumentoTecnico » " + DETALLE;

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
			titulo = "ObservacionesDocumentoTecnico » " + IMPRIMIR;

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
			if(observacionesdocumentotecnico.getEstadoauditoria().equals("1")){
				accion = ANULAR;
			}else{
				accion = ACTIVAR;
			}
			titulo = "ObservacionesDocumentoTecnico » " + accion;

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
			Observacionesdocumentotecnico record= new Observacionesdocumentotecnico();
			if(observacionesdocumentotecnico.getEstadoauditoria().equals("1")){
				record.setEstadoauditoria("0");
			}else{
				record.setEstadoauditoria("1");
			}
			record.setIdobservacionesdocumentotecnico(observacionesdocumentotecnico.getIdobservacionesdocumentotecnico());
			record.setUsuariomodificacionauditoria(getUserLogin());
			business.updateByPrimaryKeySelectiveBasic(record);

			showGrowlMessageSuccessfullyCompletedAction();
			buscar();

			REGISTER_SUCCESS();
		} catch (ValidateException e) {
			REGISTER_ERROR();
			addMessageKey("msgsObservacionesdocumentotecnicoA", e.getMessage(),
			FacesMessage.SEVERITY_ERROR);
		} catch (BusinessException e) {
			REGISTER_ERROR();
			addMessageKey("msgsObservacionesdocumentotecnicoA", e.getMessage(),
			FacesMessage.SEVERITY_ERROR);
		} catch (Exception e) {
			REGISTER_ERROR();
			addErrorMessageKey("msgsObservacionesdocumentotecnicoA", e);
		}
	}

	public void setTemporalVars() throws Exception{

	}
	public void aceptar() {
			REGISTER_INIT();
		try {
			if (accion.equals(REGISTRAR)){
				observacionesdocumentotecnico.setUsuariocreacionauditoria(getUserLogin());
				observacionesdocumentotecnico.setEquipoauditoria(getRemoteAddr());
				observacionesdocumentotecnico.setProgramaauditoria(pe.com.sisabas.resources.Utils.obtenerPrograma(this.getClass()));
				business.insertBasic(observacionesdocumentotecnico);
			}else{
				observacionesdocumentotecnico.setUsuariomodificacionauditoria(getUserLogin());
				observacionesdocumentotecnico.setEquipoauditoria(getRemoteAddr());
				observacionesdocumentotecnico.setProgramaauditoria(pe.com.sisabas.resources.Utils.obtenerPrograma(this.getClass()));
				business.updateByPrimaryKeyBasic(observacionesdocumentotecnico);
			}

			showGrowlMessageSuccessfullyCompletedAction();
			buscar();

			REGISTER_SUCCESS();
		} catch (ValidateException e) {
			REGISTER_ERROR();
			addMessageKey("msgsObservacionesdocumentotecnicoR", e.getMessage(),
			FacesMessage.SEVERITY_ERROR);
		} catch (BusinessException e) {
			REGISTER_ERROR();
			addMessageKey("msgsObservacionesdocumentotecnicoR", e.getMessage(),
			FacesMessage.SEVERITY_ERROR);
		} catch(DataIntegrityViolationException e) {
			addMessageKey("msgsForm", Messages.getString("exception.dataintegrity.message.title"),Messages.getString("exception.dataintegrity.message.detail"),
			FacesMessage.SEVERITY_ERROR);
		} catch (Exception e) {
			REGISTER_ERROR();
			addErrorMessageKey("msgsObservacionesdocumentotecnicoR", e);
		}
	}

	public void eliminar() {
		try {
			validateSelectedRow();
			observacionesdocumentotecnico.setUsuariomodificacionauditoria(getUserLogin());
			business.deleteByPrimaryKeyBasic(observacionesdocumentotecnico);
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
		if (selectedObservacionesdocumentotecnico == null)
			throw new UnselectedRowException(Messages.getString("no.record.selected"));
		else
			observacionesdocumentotecnico = (Observacionesdocumentotecnico)selectedObservacionesdocumentotecnico.clone();
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

	public void loadMainIdseccionesdocumentotecnico(org.primefaces.event.SelectEvent event) {
		try {
			logger.debug("loadMainSeccionesdocumentotecnico.event...");
			pe.com.sisabas.be.Seccionesdocumentotecnico item= (pe.com.sisabas.be.Seccionesdocumentotecnico) event.getObject();
			logger.debug("loadobservacionesdocumentotecnico.event...:"+item.getIdseccionesdocumentotecnico());
			observacionesdocumentotecnicoB.setIdseccionesdocumentotecnico(item.getIdseccionesdocumentotecnico());
			observacionesdocumentotecnicoB.setSeccionesdocumentotecnicoIdseccionesdocumentotecnico(item);
			logger.debug("loadSeccionesdocumentotecnico.event...ok");
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}

	public void loadRegIdseccionesdocumentotecnico(org.primefaces.event.SelectEvent event) {
		try {
			logger.debug("loadRegSeccionesdocumentotecnico.event...");
			pe.com.sisabas.be.Seccionesdocumentotecnico item= (pe.com.sisabas.be.Seccionesdocumentotecnico) event.getObject();
			logger.debug("loadobservacionesdocumentotecnico.event...:"+item.getIdseccionesdocumentotecnico());
			observacionesdocumentotecnico.setIdseccionesdocumentotecnico(item.getIdseccionesdocumentotecnico());
			observacionesdocumentotecnico.setSeccionesdocumentotecnicoIdseccionesdocumentotecnico(item);
			logger.debug("loadSeccionesdocumentotecnico.event...ok");
			resetRegisterForm();
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}

	public void resetMainIdseccionesdocumentotecnico() {
		try {
			observacionesdocumentotecnicoB.setIdseccionesdocumentotecnico(null);
			observacionesdocumentotecnicoB.setSeccionesdocumentotecnicoIdseccionesdocumentotecnico(new Seccionesdocumentotecnico());
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}
	public void resetRegIdseccionesdocumentotecnico() {
		try {
			observacionesdocumentotecnico.setIdseccionesdocumentotecnico(null);
			observacionesdocumentotecnico.setSeccionesdocumentotecnicoIdseccionesdocumentotecnico(new Seccionesdocumentotecnico());
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}



	public String loadPage(){
		buscar();
		return "/pages/observacionesdocumentotecnico/observacionesdocumentotecnicoBuscar.xhtml?faces-redirect=true";
	}

	public void resetRegisterForm(){
		reset("frmObservacionesdocumentotecnicoRegistrar:panelC");
	}
	public void resetAnulacionForm(){
		reset("frmObservacionesdocumentotecnicoAnular:panelDetailC");
	}


	public void updateCharToBoolean(Observacionesdocumentotecnico record) throws Exception {
	}

	public void setObservacionesdocumentotecnico(Observacionesdocumentotecnico observacionesdocumentotecnico){
		this.observacionesdocumentotecnico=observacionesdocumentotecnico;
	}

	public Observacionesdocumentotecnico getObservacionesdocumentotecnico(){
		return observacionesdocumentotecnico;
	}

	public void setObservacionesdocumentotecnicoB(Observacionesdocumentotecnico observacionesdocumentotecnicoB){
		this.observacionesdocumentotecnicoB = observacionesdocumentotecnicoB;
	}

	public Observacionesdocumentotecnico getObservacionesdocumentotecnicoB(){
		return observacionesdocumentotecnicoB;
	}

	public void setSelectedObservacionesdocumentotecnico(Observacionesdocumentotecnico selectedObservacionesdocumentotecnico){
		this.selectedObservacionesdocumentotecnico = selectedObservacionesdocumentotecnico;
	}

	public Observacionesdocumentotecnico getSelectedObservacionesdocumentotecnico(){
		return selectedObservacionesdocumentotecnico;
	}

	public void setListaObservacionesdocumentotecnico(List<Observacionesdocumentotecnico> listaObservacionesdocumentotecnico){
		this.listaObservacionesdocumentotecnico=listaObservacionesdocumentotecnico;
	}

	public List<Observacionesdocumentotecnico> getListaObservacionesdocumentotecnico(){
		return listaObservacionesdocumentotecnico;
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




}

