
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
import pe.com.sisabas.be.Certificadopresupuestal;
import pe.com.sisabas.business.CertificadopresupuestalBusiness;
import pe.com.sisabas.be.Pacconsolidado;



@Component(value ="certificadopresupuestal")
@Scope(value = "session")
public class CertificadopresupuestalController extends BaseController {

	private static final long serialVersionUID = 1L;
	private StreamedContent file;
	private Certificadopresupuestal certificadopresupuestalB;
	private Certificadopresupuestal certificadopresupuestal;
	private Certificadopresupuestal selectedCertificadopresupuestal;
	private List<Certificadopresupuestal> listaCertificadopresupuestal;

	private String accion;
	private String titulo;
	
	private String tituloBase; //titulo de la opcion
	private String tituloParam;//titulo que llega como parametro (derivada padre)
	
	private String esDerivada="0";
	
	@Autowired
	public pe.com.sisabas.resources.business.UtilsBusiness utilsBusiness;

	@Autowired
	public CertificadopresupuestalBusiness business;



	//Nota: idOpcion, sicuopcion estan en BaseController
	private String idOpcionText = "OPC_CERTIFICADOPRESU";
	public CertificadopresupuestalController(){
			certificadopresupuestal = new Certificadopresupuestal();
			certificadopresupuestal.setPacconsolidadoIdpacconsolidado(new Pacconsolidado());

	}


	@PostConstruct
	public void init(){
		try {
			certificadopresupuestalB = new Certificadopresupuestal();
			tituloBase = "CertificadoPresupuestal » ";
			if(SICU_SECURITY_ENABLE){
				idOpcion   = SicuCallService.obtenerIdOpcion(idOpcionText).toString();
				sicuopcion = SicuCallService.obtenercontroles(idOpcion);
			}
			certificadopresupuestalB.setPacconsolidadoIdpacconsolidado(new Pacconsolidado());



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
			ordenListaCampos.add("A1.IDCERTIFICADOPRESUPUESTAL");
			certificadopresupuestalB.setOrdenListaCampos(ordenListaCampos);
			certificadopresupuestalB.setOrdenTipo("DESC");

			//Add conditions IN clause

			pe.com.sisabas.resources.Utils.convertPropertiesStringToUppercase(certificadopresupuestalB); //pasa a mayusculas los datos para la busqueda
			listaCertificadopresupuestal = business.selectDynamicFull(certificadopresupuestalB);
			setEsSeleccionado(false);
			setSelectedCertificadopresupuestal(null);
			if (listaCertificadopresupuestal.size() == 0)
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
			titulo = "CertificadoPresupuestal » " + REGISTRAR;
			certificadopresupuestal = new Certificadopresupuestal();


			certificadopresupuestal.setIdcertificadopresupuestal(new java.lang.Integer(0));
			certificadopresupuestal.setIdcertificadopresupuestal((int)utilsBusiness.getNextSeqTemporal(pe.com.sisabas.resources.Sequence.SEQ_CERTIFICADOPRESUPUESTAL).longValue());
			certificadopresupuestal.setPacconsolidadoIdpacconsolidado(new Pacconsolidado());

			certificadopresupuestal.setIdpacconsolidado(certificadopresupuestalB.getIdpacconsolidado());

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
	DetallecertificadopresupuestalController detallecertificadopresupuestalController;
	public String irDetallecertificadopresupuestal() {
		boolean validado=false;
		try {
			securityControlValidate("btnDetallecertificadopresupuestal");
			validateSelectedRow();
			String paramTitulo = new String((tituloParam!=null?tituloParam:"")+" "+tituloBase);
			detallecertificadopresupuestalController.setTituloParam(paramTitulo);
			detallecertificadopresupuestalController.init(certificadopresupuestal);

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
		if(validado) return "/pages/detallecertificadopresupuestal/detallecertificadopresupuestalBuscar.xhtml?faces-redirect=true";
		else return null;
	}

	public String load() {
		return"/pages/certificadopresupuestal/certificadopresupuestalBuscar.xhtml?faces-redirect=true";
	}

	public void init(pe.com.sisabas.be.Pacconsolidado pacconsolidado) throws Exception{
		init();
		certificadopresupuestalB.setIdpacconsolidado(pacconsolidado.getIdpacconsolidado());
		certificadopresupuestalB.setPacconsolidadoIdpacconsolidado(pacconsolidado);
		esDerivada = "1";
		buscar();
	}

	public void initDerivedTable(pe.com.sisabas.be.Pacconsolidado pacconsolidado) throws Exception{
		init();
		certificadopresupuestalB.setIdpacconsolidado(pacconsolidado.getIdpacconsolidado());
		certificadopresupuestalB.setPacconsolidadoIdpacconsolidado(pacconsolidado);
		esDerivada = "1";
		buscar();
	}

	public void irEditar() {
		STATUS_INIT();
		try {
			securityControlValidate("btnEditar");
			resetRegisterForm();
			validateSelectedRow();
			updateCharToBoolean(certificadopresupuestal);
			certificadopresupuestal.roundBigDecimals();
			accion = EDITAR;
			titulo = "CertificadoPresupuestal » " + EDITAR;


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
			certificadopresupuestal.roundBigDecimals();
			accion = DETALLE;
			titulo = "CertificadoPresupuestal » " + DETALLE;

			String paramTitulo = new String((tituloParam!=null?tituloParam:"")+" "+tituloBase);
			detallecertificadopresupuestalController.setTituloParam(paramTitulo);
			detallecertificadopresupuestalController.initDerivedTable(certificadopresupuestal);

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
			titulo = "CertificadoPresupuestal » " + IMPRIMIR;

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
			if(certificadopresupuestal.getEstadoauditoria().equals("1")){
				accion = ANULAR;
			}else{
				accion = ACTIVAR;
			}
			titulo = "CertificadoPresupuestal » " + accion;

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
			Certificadopresupuestal record= new Certificadopresupuestal();
			if(certificadopresupuestal.getEstadoauditoria().equals("1")){
				record.setEstadoauditoria("0");
			}else{
				record.setEstadoauditoria("1");
			}
			record.setIdcertificadopresupuestal(certificadopresupuestal.getIdcertificadopresupuestal());
			record.setUsuariomodificacionauditoria(getUserLogin());
			business.updateByPrimaryKeySelectiveBasic(record);

			showGrowlMessageSuccessfullyCompletedAction();
			buscar();

			REGISTER_SUCCESS();
		} catch (ValidateException e) {
			REGISTER_ERROR();
			addMessageKey("msgsCertificadopresupuestalA", e.getMessage(),
			FacesMessage.SEVERITY_ERROR);
		} catch (BusinessException e) {
			REGISTER_ERROR();
			addMessageKey("msgsCertificadopresupuestalA", e.getMessage(),
			FacesMessage.SEVERITY_ERROR);
		} catch (Exception e) {
			REGISTER_ERROR();
			addErrorMessageKey("msgsCertificadopresupuestalA", e);
		}
	}

	public void setTemporalVars() throws Exception{

	}
	public void aceptar() {
			REGISTER_INIT();
		try {
			if (accion.equals(REGISTRAR)){
				certificadopresupuestal.setUsuariocreacionauditoria(getUserLogin());
				certificadopresupuestal.setEquipoauditoria(getRemoteAddr());
				certificadopresupuestal.setProgramaauditoria(pe.com.sisabas.resources.Utils.obtenerPrograma(this.getClass()));
				business.insertBasic(certificadopresupuestal);
			}else{
				certificadopresupuestal.setUsuariomodificacionauditoria(getUserLogin());
				certificadopresupuestal.setEquipoauditoria(getRemoteAddr());
				certificadopresupuestal.setProgramaauditoria(pe.com.sisabas.resources.Utils.obtenerPrograma(this.getClass()));
				business.updateByPrimaryKeyBasic(certificadopresupuestal);
			}

			showGrowlMessageSuccessfullyCompletedAction();
			buscar();

			REGISTER_SUCCESS();
		} catch (ValidateException e) {
			REGISTER_ERROR();
			addMessageKey("msgsCertificadopresupuestalR", e.getMessage(),
			FacesMessage.SEVERITY_ERROR);
		} catch (BusinessException e) {
			REGISTER_ERROR();
			addMessageKey("msgsCertificadopresupuestalR", e.getMessage(),
			FacesMessage.SEVERITY_ERROR);
		} catch(DataIntegrityViolationException e) {
			addMessageKey("msgsForm", Messages.getString("exception.dataintegrity.message.title"),Messages.getString("exception.dataintegrity.message.detail"),
			FacesMessage.SEVERITY_ERROR);
		} catch (Exception e) {
			REGISTER_ERROR();
			addErrorMessageKey("msgsCertificadopresupuestalR", e);
		}
	}

	public void eliminar() {
		try {
			validateSelectedRow();
			certificadopresupuestal.setUsuariomodificacionauditoria(getUserLogin());
			business.deleteByPrimaryKeyBasic(certificadopresupuestal);
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
		if (selectedCertificadopresupuestal == null)
			throw new UnselectedRowException(Messages.getString("no.record.selected"));
		else
			certificadopresupuestal = (Certificadopresupuestal)selectedCertificadopresupuestal.clone();
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
			logger.debug("loadcertificadopresupuestal.event...:"+item.getIdpacconsolidado());
			certificadopresupuestalB.setIdpacconsolidado(item.getIdpacconsolidado());
			certificadopresupuestalB.setPacconsolidadoIdpacconsolidado(item);
			logger.debug("loadPacconsolidado.event...ok");
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}

	public void loadRegIdpacconsolidado(org.primefaces.event.SelectEvent event) {
		try {
			logger.debug("loadRegPacconsolidado.event...");
			pe.com.sisabas.be.Pacconsolidado item= (pe.com.sisabas.be.Pacconsolidado) event.getObject();
			logger.debug("loadcertificadopresupuestal.event...:"+item.getIdpacconsolidado());
			certificadopresupuestal.setIdpacconsolidado(item.getIdpacconsolidado());
			certificadopresupuestal.setPacconsolidadoIdpacconsolidado(item);
			logger.debug("loadPacconsolidado.event...ok");
			resetRegisterForm();
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}

	public void resetMainIdpacconsolidado() {
		try {
			certificadopresupuestalB.setIdpacconsolidado(null);
			certificadopresupuestalB.setPacconsolidadoIdpacconsolidado(new Pacconsolidado());
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}
	public void resetRegIdpacconsolidado() {
		try {
			certificadopresupuestal.setIdpacconsolidado(null);
			certificadopresupuestal.setPacconsolidadoIdpacconsolidado(new Pacconsolidado());
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}



	public String loadPage(){
		buscar();
		return "/pages/certificadopresupuestal/certificadopresupuestalBuscar.xhtml?faces-redirect=true";
	}

	public void resetRegisterForm(){
		reset("frmCertificadopresupuestalRegistrar:panelC");
	}
	public void resetAnulacionForm(){
		reset("frmCertificadopresupuestalAnular:panelDetailC");
	}


	public void updateCharToBoolean(Certificadopresupuestal record) throws Exception {
	}

	public void setCertificadopresupuestal(Certificadopresupuestal certificadopresupuestal){
		this.certificadopresupuestal=certificadopresupuestal;
	}

	public Certificadopresupuestal getCertificadopresupuestal(){
		return certificadopresupuestal;
	}

	public void setCertificadopresupuestalB(Certificadopresupuestal certificadopresupuestalB){
		this.certificadopresupuestalB = certificadopresupuestalB;
	}

	public Certificadopresupuestal getCertificadopresupuestalB(){
		return certificadopresupuestalB;
	}

	public void setSelectedCertificadopresupuestal(Certificadopresupuestal selectedCertificadopresupuestal){
		this.selectedCertificadopresupuestal = selectedCertificadopresupuestal;
	}

	public Certificadopresupuestal getSelectedCertificadopresupuestal(){
		return selectedCertificadopresupuestal;
	}

	public void setListaCertificadopresupuestal(List<Certificadopresupuestal> listaCertificadopresupuestal){
		this.listaCertificadopresupuestal=listaCertificadopresupuestal;
	}

	public List<Certificadopresupuestal> getListaCertificadopresupuestal(){
		return listaCertificadopresupuestal;
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

