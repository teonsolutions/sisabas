
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
import pe.com.sisabas.be.Previsionpresupuestal;
import pe.com.sisabas.business.PrevisionpresupuestalBusiness;
import pe.com.sisabas.be.Pacconsolidado;



@Component(value ="previsionpresupuestal")
@Scope(value = "session")
public class PrevisionpresupuestalController extends BaseController {

	private static final long serialVersionUID = 1L;
	private StreamedContent file;
	private Previsionpresupuestal previsionpresupuestalB;
	private Previsionpresupuestal previsionpresupuestal;
	private Previsionpresupuestal selectedPrevisionpresupuestal;
	private List<Previsionpresupuestal> listaPrevisionpresupuestal;

	private String accion;
	private String titulo;
	
	private String tituloBase; //titulo de la opcion
	private String tituloParam;//titulo que llega como parametro (derivada padre)
	
	private String esDerivada="0";
	
	@Autowired
	public pe.com.sisabas.resources.business.UtilsBusiness utilsBusiness;

	@Autowired
	public PrevisionpresupuestalBusiness business;



	//Nota: idOpcion, sicuopcion estan en BaseController
	private String idOpcionText = "OPC_PREVISIONPRESUPU";
	public PrevisionpresupuestalController(){
			previsionpresupuestal = new Previsionpresupuestal();
			previsionpresupuestal.setPacconsolidadoIdpacconsolidado(new Pacconsolidado());

	}


	@PostConstruct
	public void init(){
		try {
			previsionpresupuestalB = new Previsionpresupuestal();
			tituloBase = "PrevisionPresupuestal » ";
			if(SICU_SECURITY_ENABLE){
				idOpcion   = SicuCallService.obtenerIdOpcion(idOpcionText).toString();
				sicuopcion = SicuCallService.obtenercontroles(idOpcion);
			}
			previsionpresupuestalB.setPacconsolidadoIdpacconsolidado(new Pacconsolidado());



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
			ordenListaCampos.add("A1.IDPREVISIONPRESUPUESTAL");
			previsionpresupuestalB.setOrdenListaCampos(ordenListaCampos);
			previsionpresupuestalB.setOrdenTipo("DESC");

			//Add conditions IN clause

			pe.com.sisabas.resources.Utils.convertPropertiesStringToUppercase(previsionpresupuestalB); //pasa a mayusculas los datos para la busqueda
			listaPrevisionpresupuestal = business.selectDynamicFull(previsionpresupuestalB);
			setEsSeleccionado(false);
			setSelectedPrevisionpresupuestal(null);
			if (listaPrevisionpresupuestal.size() == 0)
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
			titulo = "PrevisionPresupuestal » " + REGISTRAR;
			previsionpresupuestal = new Previsionpresupuestal();


			previsionpresupuestal.setIdprevisionpresupuestal(new java.lang.Integer(0));
			previsionpresupuestal.setIdprevisionpresupuestal((int)utilsBusiness.getNextSeqTemporal(pe.com.sisabas.resources.Sequence.SEQ_PREVISIONPRESUPUESTAL).longValue());
			previsionpresupuestal.setPacconsolidadoIdpacconsolidado(new Pacconsolidado());

			previsionpresupuestal.setIdpacconsolidado(previsionpresupuestalB.getIdpacconsolidado());

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

	public void init(pe.com.sisabas.be.Pacconsolidado pacconsolidado) throws Exception{
		init();
		previsionpresupuestalB.setIdpacconsolidado(pacconsolidado.getIdpacconsolidado());
		previsionpresupuestalB.setPacconsolidadoIdpacconsolidado(pacconsolidado);
		esDerivada = "1";
		buscar();
	}

	public void initDerivedTable(pe.com.sisabas.be.Pacconsolidado pacconsolidado) throws Exception{
		init();
		previsionpresupuestalB.setIdpacconsolidado(pacconsolidado.getIdpacconsolidado());
		previsionpresupuestalB.setPacconsolidadoIdpacconsolidado(pacconsolidado);
		esDerivada = "1";
		buscar();
	}

	public void irEditar() {
		STATUS_INIT();
		try {
			securityControlValidate("btnEditar");
			resetRegisterForm();
			validateSelectedRow();
			updateCharToBoolean(previsionpresupuestal);
			previsionpresupuestal.roundBigDecimals();
			accion = EDITAR;
			titulo = "PrevisionPresupuestal » " + EDITAR;


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
			previsionpresupuestal.roundBigDecimals();
			accion = DETALLE;
			titulo = "PrevisionPresupuestal » " + DETALLE;

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
			titulo = "PrevisionPresupuestal » " + IMPRIMIR;

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
			if(previsionpresupuestal.getEstadoauditoria().equals("1")){
				accion = ANULAR;
			}else{
				accion = ACTIVAR;
			}
			titulo = "PrevisionPresupuestal » " + accion;

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
			Previsionpresupuestal record= new Previsionpresupuestal();
			if(previsionpresupuestal.getEstadoauditoria().equals("1")){
				record.setEstadoauditoria("0");
			}else{
				record.setEstadoauditoria("1");
			}
			record.setIdprevisionpresupuestal(previsionpresupuestal.getIdprevisionpresupuestal());
			record.setUsuariomodificacionauditoria(getUserLogin());
			business.updateByPrimaryKeySelectiveBasic(record);

			showGrowlMessageSuccessfullyCompletedAction();
			buscar();

			REGISTER_SUCCESS();
		} catch (ValidateException e) {
			REGISTER_ERROR();
			addMessageKey("msgsPrevisionpresupuestalA", e.getMessage(),
			FacesMessage.SEVERITY_ERROR);
		} catch (BusinessException e) {
			REGISTER_ERROR();
			addMessageKey("msgsPrevisionpresupuestalA", e.getMessage(),
			FacesMessage.SEVERITY_ERROR);
		} catch (Exception e) {
			REGISTER_ERROR();
			addErrorMessageKey("msgsPrevisionpresupuestalA", e);
		}
	}

	public void setTemporalVars() throws Exception{

	}
	public void aceptar() {
			REGISTER_INIT();
		try {
			if (accion.equals(REGISTRAR)){
				previsionpresupuestal.setUsuariocreacionauditoria(getUserLogin());
				previsionpresupuestal.setEquipoauditoria(getRemoteAddr());
				previsionpresupuestal.setProgramaauditoria(pe.com.sisabas.resources.Utils.obtenerPrograma(this.getClass()));
				business.insertBasic(previsionpresupuestal);
			}else{
				previsionpresupuestal.setUsuariomodificacionauditoria(getUserLogin());
				previsionpresupuestal.setEquipoauditoria(getRemoteAddr());
				previsionpresupuestal.setProgramaauditoria(pe.com.sisabas.resources.Utils.obtenerPrograma(this.getClass()));
				business.updateByPrimaryKeyBasic(previsionpresupuestal);
			}

			showGrowlMessageSuccessfullyCompletedAction();
			buscar();

			REGISTER_SUCCESS();
		} catch (ValidateException e) {
			REGISTER_ERROR();
			addMessageKey("msgsPrevisionpresupuestalR", e.getMessage(),
			FacesMessage.SEVERITY_ERROR);
		} catch (BusinessException e) {
			REGISTER_ERROR();
			addMessageKey("msgsPrevisionpresupuestalR", e.getMessage(),
			FacesMessage.SEVERITY_ERROR);
		} catch(DataIntegrityViolationException e) {
			addMessageKey("msgsForm", Messages.getString("exception.dataintegrity.message.title"),Messages.getString("exception.dataintegrity.message.detail"),
			FacesMessage.SEVERITY_ERROR);
		} catch (Exception e) {
			REGISTER_ERROR();
			addErrorMessageKey("msgsPrevisionpresupuestalR", e);
		}
	}

	public void eliminar() {
		try {
			validateSelectedRow();
			previsionpresupuestal.setUsuariomodificacionauditoria(getUserLogin());
			business.deleteByPrimaryKeyBasic(previsionpresupuestal);
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
		if (selectedPrevisionpresupuestal == null)
			throw new UnselectedRowException(Messages.getString("no.record.selected"));
		else
			previsionpresupuestal = (Previsionpresupuestal)selectedPrevisionpresupuestal.clone();
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

	public void loadMainIdpacconsolidado(org.primefaces.event.SelectEvent event) {
		try {
			logger.debug("loadMainPacconsolidado.event...");
			pe.com.sisabas.be.Pacconsolidado item= (pe.com.sisabas.be.Pacconsolidado) event.getObject();
			logger.debug("loadprevisionpresupuestal.event...:"+item.getIdpacconsolidado());
			previsionpresupuestalB.setIdpacconsolidado(item.getIdpacconsolidado());
			previsionpresupuestalB.setPacconsolidadoIdpacconsolidado(item);
			logger.debug("loadPacconsolidado.event...ok");
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}

	public void loadRegIdpacconsolidado(org.primefaces.event.SelectEvent event) {
		try {
			logger.debug("loadRegPacconsolidado.event...");
			pe.com.sisabas.be.Pacconsolidado item= (pe.com.sisabas.be.Pacconsolidado) event.getObject();
			logger.debug("loadprevisionpresupuestal.event...:"+item.getIdpacconsolidado());
			previsionpresupuestal.setIdpacconsolidado(item.getIdpacconsolidado());
			previsionpresupuestal.setPacconsolidadoIdpacconsolidado(item);
			logger.debug("loadPacconsolidado.event...ok");
			resetRegisterForm();
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}

	public void resetMainIdpacconsolidado() {
		try {
			previsionpresupuestalB.setIdpacconsolidado(null);
			previsionpresupuestalB.setPacconsolidadoIdpacconsolidado(new Pacconsolidado());
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}
	public void resetRegIdpacconsolidado() {
		try {
			previsionpresupuestal.setIdpacconsolidado(null);
			previsionpresupuestal.setPacconsolidadoIdpacconsolidado(new Pacconsolidado());
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}



	public String loadPage(){
		buscar();
		return "/pages/previsionpresupuestal/previsionpresupuestalBuscar.xhtml?faces-redirect=true";
	}

	public void resetRegisterForm(){
		reset("frmPrevisionpresupuestalRegistrar:panelC");
	}
	public void resetAnulacionForm(){
		reset("frmPrevisionpresupuestalAnular:panelDetailC");
	}


	public void updateCharToBoolean(Previsionpresupuestal record) throws Exception {
	}

	public void setPrevisionpresupuestal(Previsionpresupuestal previsionpresupuestal){
		this.previsionpresupuestal=previsionpresupuestal;
	}

	public Previsionpresupuestal getPrevisionpresupuestal(){
		return previsionpresupuestal;
	}

	public void setPrevisionpresupuestalB(Previsionpresupuestal previsionpresupuestalB){
		this.previsionpresupuestalB = previsionpresupuestalB;
	}

	public Previsionpresupuestal getPrevisionpresupuestalB(){
		return previsionpresupuestalB;
	}

	public void setSelectedPrevisionpresupuestal(Previsionpresupuestal selectedPrevisionpresupuestal){
		this.selectedPrevisionpresupuestal = selectedPrevisionpresupuestal;
	}

	public Previsionpresupuestal getSelectedPrevisionpresupuestal(){
		return selectedPrevisionpresupuestal;
	}

	public void setListaPrevisionpresupuestal(List<Previsionpresupuestal> listaPrevisionpresupuestal){
		this.listaPrevisionpresupuestal=listaPrevisionpresupuestal;
	}

	public List<Previsionpresupuestal> getListaPrevisionpresupuestal(){
		return listaPrevisionpresupuestal;
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

