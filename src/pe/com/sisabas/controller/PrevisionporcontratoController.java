
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
import pe.com.sisabas.be.Previsionporcontrato;
import pe.com.sisabas.business.PrevisionporcontratoBusiness;
import pe.com.sisabas.be.Contrato;



@Component(value ="previsionporcontrato")
@Scope(value = "session")
public class PrevisionporcontratoController extends BaseController {

	private static final long serialVersionUID = 1L;
	private StreamedContent file;
	private Previsionporcontrato previsionporcontratoB;
	private Previsionporcontrato previsionporcontrato;
	private Previsionporcontrato selectedPrevisionporcontrato;
	private List<Previsionporcontrato> listaPrevisionporcontrato;

	private String accion;
	private String titulo;
	
	private String tituloBase; //titulo de la opcion
	private String tituloParam;//titulo que llega como parametro (derivada padre)
	
	private String esDerivada="0";
	
	@Autowired
	public pe.com.sisabas.resources.business.UtilsBusiness utilsBusiness;

	@Autowired
	public PrevisionporcontratoBusiness business;



	//Nota: idOpcion, sicuopcion estan en BaseController
	private String idOpcionText = "OPC_PREVISIONPORCONT";
	public PrevisionporcontratoController(){
			previsionporcontrato = new Previsionporcontrato();
			previsionporcontrato.setContratoIdcontrato(new Contrato());

	}


	@PostConstruct
	public void init(){
		try {
			previsionporcontratoB = new Previsionporcontrato();
			tituloBase = "PrevisionPorContrato » ";
			if(SICU_SECURITY_ENABLE){
				idOpcion   = SicuCallService.obtenerIdOpcion(idOpcionText).toString();
				sicuopcion = SicuCallService.obtenercontroles(idOpcion);
			}
			previsionporcontratoB.setContratoIdcontrato(new Contrato());



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
			ordenListaCampos.add("A1.IDPREVISIONPORCONTRATO");
			previsionporcontratoB.setOrdenListaCampos(ordenListaCampos);
			previsionporcontratoB.setOrdenTipo("DESC");

			//Add conditions IN clause

			pe.com.sisabas.resources.Utils.convertPropertiesStringToUppercase(previsionporcontratoB); //pasa a mayusculas los datos para la busqueda
			listaPrevisionporcontrato = business.selectDynamicFull(previsionporcontratoB);
			setEsSeleccionado(false);
			setSelectedPrevisionporcontrato(null);
			if (listaPrevisionporcontrato.size() == 0)
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
			titulo = "PrevisionPorContrato » " + REGISTRAR;
			previsionporcontrato = new Previsionporcontrato();


			previsionporcontrato.setIdprevisionporcontrato(new java.lang.Integer(0));
			previsionporcontrato.setIdprevisionporcontrato((int)utilsBusiness.getNextSeqTemporal(pe.com.sisabas.resources.Sequence.SEQ_SISABAS).longValue());
			previsionporcontrato.setContratoIdcontrato(new Contrato());

			previsionporcontrato.setIdcontrato(previsionporcontratoB.getIdcontrato());

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

	public void init(pe.com.sisabas.be.Contrato contrato) throws Exception{
		init();
		previsionporcontratoB.setIdcontrato(contrato.getIdcontrato());
		previsionporcontratoB.setContratoIdcontrato(contrato);
		esDerivada = "1";
		buscar();
	}

	public void initDerivedTable(pe.com.sisabas.be.Contrato contrato) throws Exception{
		init();
		previsionporcontratoB.setIdcontrato(contrato.getIdcontrato());
		previsionporcontratoB.setContratoIdcontrato(contrato);
		esDerivada = "1";
		buscar();
	}

	public void irEditar() {
		STATUS_INIT();
		try {
			securityControlValidate("btnEditar");
			resetRegisterForm();
			validateSelectedRow();
			updateCharToBoolean(previsionporcontrato);
			previsionporcontrato.roundBigDecimals();
			accion = EDITAR;
			titulo = "PrevisionPorContrato » " + EDITAR;


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
			previsionporcontrato.roundBigDecimals();
			accion = DETALLE;
			titulo = "PrevisionPorContrato » " + DETALLE;

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
			titulo = "PrevisionPorContrato » " + IMPRIMIR;

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
			if(previsionporcontrato.getEstadoauditoria().equals("1")){
				accion = ANULAR;
			}else{
				accion = ACTIVAR;
			}
			titulo = "PrevisionPorContrato » " + accion;

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
			Previsionporcontrato record= new Previsionporcontrato();
			if(previsionporcontrato.getEstadoauditoria().equals("1")){
				record.setEstadoauditoria("0");
			}else{
				record.setEstadoauditoria("1");
			}
			record.setIdprevisionporcontrato(previsionporcontrato.getIdprevisionporcontrato());
			record.setUsuariomodificacionauditoria(getUserLogin());
			business.updateByPrimaryKeySelectiveBasic(record);

			showGrowlMessageSuccessfullyCompletedAction();
			buscar();

			REGISTER_SUCCESS();
		} catch (ValidateException e) {
			REGISTER_ERROR();
			addMessageKey("msgsPrevisionporcontratoA", e.getMessage(),
			FacesMessage.SEVERITY_ERROR);
		} catch (BusinessException e) {
			REGISTER_ERROR();
			addMessageKey("msgsPrevisionporcontratoA", e.getMessage(),
			FacesMessage.SEVERITY_ERROR);
		} catch (Exception e) {
			REGISTER_ERROR();
			addErrorMessageKey("msgsPrevisionporcontratoA", e);
		}
	}

	public void setTemporalVars() throws Exception{

	}
	public void aceptar() {
			REGISTER_INIT();
		try {
			if (accion.equals(REGISTRAR)){
				previsionporcontrato.setUsuariocreacionauditoria(getUserLogin());
				previsionporcontrato.setEquipoauditoria(getRemoteAddr());
				previsionporcontrato.setProgramaauditoria(pe.com.sisabas.resources.Utils.obtenerPrograma(this.getClass()));
				business.insertBasic(previsionporcontrato);
			}else{
				previsionporcontrato.setUsuariomodificacionauditoria(getUserLogin());
				previsionporcontrato.setEquipoauditoria(getRemoteAddr());
				previsionporcontrato.setProgramaauditoria(pe.com.sisabas.resources.Utils.obtenerPrograma(this.getClass()));
				business.updateByPrimaryKeyBasic(previsionporcontrato);
			}

			showGrowlMessageSuccessfullyCompletedAction();
			buscar();

			REGISTER_SUCCESS();
		} catch (ValidateException e) {
			REGISTER_ERROR();
			addMessageKey("msgsPrevisionporcontratoR", e.getMessage(),
			FacesMessage.SEVERITY_ERROR);
		} catch (BusinessException e) {
			REGISTER_ERROR();
			addMessageKey("msgsPrevisionporcontratoR", e.getMessage(),
			FacesMessage.SEVERITY_ERROR);
		} catch(DataIntegrityViolationException e) {
			addMessageKey("msgsForm", Messages.getString("exception.dataintegrity.message.title"),Messages.getString("exception.dataintegrity.message.detail"),
			FacesMessage.SEVERITY_ERROR);
		} catch (Exception e) {
			REGISTER_ERROR();
			addErrorMessageKey("msgsPrevisionporcontratoR", e);
		}
	}

	public void eliminar() {
		try {
			validateSelectedRow();
			previsionporcontrato.setUsuariomodificacionauditoria(getUserLogin());
			business.deleteByPrimaryKeyBasic(previsionporcontrato);
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
		if (selectedPrevisionporcontrato == null)
			throw new UnselectedRowException(Messages.getString("no.record.selected"));
		else
			previsionporcontrato = (Previsionporcontrato)selectedPrevisionporcontrato.clone();
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

	public void loadMainIdcontrato(org.primefaces.event.SelectEvent event) {
		try {
			logger.debug("loadMainContrato.event...");
			pe.com.sisabas.be.Contrato item= (pe.com.sisabas.be.Contrato) event.getObject();
			logger.debug("loadprevisionporcontrato.event...:"+item.getIdcontrato());
			previsionporcontratoB.setIdcontrato(item.getIdcontrato());
			previsionporcontratoB.setContratoIdcontrato(item);
			logger.debug("loadContrato.event...ok");
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}

	public void loadRegIdcontrato(org.primefaces.event.SelectEvent event) {
		try {
			logger.debug("loadRegContrato.event...");
			pe.com.sisabas.be.Contrato item= (pe.com.sisabas.be.Contrato) event.getObject();
			logger.debug("loadprevisionporcontrato.event...:"+item.getIdcontrato());
			previsionporcontrato.setIdcontrato(item.getIdcontrato());
			previsionporcontrato.setContratoIdcontrato(item);
			logger.debug("loadContrato.event...ok");
			resetRegisterForm();
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}

	public void resetMainIdcontrato() {
		try {
			previsionporcontratoB.setIdcontrato(null);
			previsionporcontratoB.setContratoIdcontrato(new Contrato());
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}
	public void resetRegIdcontrato() {
		try {
			previsionporcontrato.setIdcontrato(null);
			previsionporcontrato.setContratoIdcontrato(new Contrato());
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}



	public String loadPage(){
		buscar();
		return "/pages/previsionporcontrato/previsionporcontratoBuscar.xhtml?faces-redirect=true";
	}

	public void resetRegisterForm(){
		reset("frmPrevisionporcontratoRegistrar:panelC");
	}
	public void resetAnulacionForm(){
		reset("frmPrevisionporcontratoAnular:panelDetailC");
	}


	public void updateCharToBoolean(Previsionporcontrato record) throws Exception {
	}

	public void setPrevisionporcontrato(Previsionporcontrato previsionporcontrato){
		this.previsionporcontrato=previsionporcontrato;
	}

	public Previsionporcontrato getPrevisionporcontrato(){
		return previsionporcontrato;
	}

	public void setPrevisionporcontratoB(Previsionporcontrato previsionporcontratoB){
		this.previsionporcontratoB = previsionporcontratoB;
	}

	public Previsionporcontrato getPrevisionporcontratoB(){
		return previsionporcontratoB;
	}

	public void setSelectedPrevisionporcontrato(Previsionporcontrato selectedPrevisionporcontrato){
		this.selectedPrevisionporcontrato = selectedPrevisionporcontrato;
	}

	public Previsionporcontrato getSelectedPrevisionporcontrato(){
		return selectedPrevisionporcontrato;
	}

	public void setListaPrevisionporcontrato(List<Previsionporcontrato> listaPrevisionporcontrato){
		this.listaPrevisionporcontrato=listaPrevisionporcontrato;
	}

	public List<Previsionporcontrato> getListaPrevisionporcontrato(){
		return listaPrevisionporcontrato;
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

