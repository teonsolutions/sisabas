
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
import pe.com.sisabas.be.Siafexpedientesecuencia;
import pe.com.sisabas.business.SiafexpedientesecuenciaBusiness;
import pe.com.sisabas.be.Vcertificacion;



@Component(value ="siafexpedientesecuencia")
@Scope(value = "session")
public class SiafexpedientesecuenciaController extends BaseController {

	private static final long serialVersionUID = 1L;
	private StreamedContent file;
	private Siafexpedientesecuencia siafexpedientesecuenciaB;
	private Siafexpedientesecuencia siafexpedientesecuencia;
	private Siafexpedientesecuencia selectedSiafexpedientesecuencia;
	private List<Siafexpedientesecuencia> listaSiafexpedientesecuencia;

	private String accion;
	private String titulo;
	
	private String tituloBase; //titulo de la opcion
	private String tituloParam;//titulo que llega como parametro (derivada padre)
	
	private String esDerivada="0";
	
	@Autowired
	public pe.com.sisabas.resources.business.UtilsBusiness utilsBusiness;

	@Autowired
	public SiafexpedientesecuenciaBusiness business;



	//Nota: idOpcion, sicuopcion estan en BaseController
	private String idOpcionText = "OPC_SIAFEXPEDIENTESE";
	public SiafexpedientesecuenciaController(){
			siafexpedientesecuencia = new Siafexpedientesecuencia();
			siafexpedientesecuencia.setVcertificacionIdvcertificacion(new Vcertificacion());

	}


	@PostConstruct
	public void init(){
		try {
			siafexpedientesecuenciaB = new Siafexpedientesecuencia();
			tituloBase = "SiafExpedienteSecuencia » ";
			if(SICU_SECURITY_ENABLE){
				idOpcion   = SicuCallService.obtenerIdOpcion(idOpcionText).toString();
				sicuopcion = SicuCallService.obtenercontroles(idOpcion);
			}
			siafexpedientesecuenciaB.setVcertificacionIdvcertificacion(new Vcertificacion());



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
			ordenListaCampos.add("A1.IDSIAFEXPEDIENTESECUENCIA");
			siafexpedientesecuenciaB.setOrdenListaCampos(ordenListaCampos);
			siafexpedientesecuenciaB.setOrdenTipo("DESC");

			//Add conditions IN clause

			pe.com.sisabas.resources.Utils.convertPropertiesStringToUppercase(siafexpedientesecuenciaB); //pasa a mayusculas los datos para la busqueda
			listaSiafexpedientesecuencia = business.selectDynamicFull(siafexpedientesecuenciaB);
			setEsSeleccionado(false);
			setSelectedSiafexpedientesecuencia(null);
			if (listaSiafexpedientesecuencia.size() == 0)
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
			titulo = "SiafExpedienteSecuencia » " + REGISTRAR;
			siafexpedientesecuencia = new Siafexpedientesecuencia();


			siafexpedientesecuencia.setIdsiafexpedientesecuencia(new java.lang.Integer(0));
			siafexpedientesecuencia.setIdsiafexpedientesecuencia((int)utilsBusiness.getNextSeqTemporal(pe.com.sisabas.resources.Sequence.SEQ_SIAFEXPEDIENTESECUENCIA).longValue());
			siafexpedientesecuencia.setVcertificacionIdvcertificacion(new Vcertificacion());


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

	public void irEditar() {
		STATUS_INIT();
		try {
			securityControlValidate("btnEditar");
			resetRegisterForm();
			validateSelectedRow();
			updateCharToBoolean(siafexpedientesecuencia);
			siafexpedientesecuencia.roundBigDecimals();
			accion = EDITAR;
			titulo = "SiafExpedienteSecuencia » " + EDITAR;


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
			siafexpedientesecuencia.roundBigDecimals();
			accion = DETALLE;
			titulo = "SiafExpedienteSecuencia » " + DETALLE;

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
			titulo = "SiafExpedienteSecuencia » " + IMPRIMIR;

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
			if(siafexpedientesecuencia.getEstadoauditoria().equals("1")){
				accion = ANULAR;
			}else{
				accion = ACTIVAR;
			}
			titulo = "SiafExpedienteSecuencia » " + accion;

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
			Siafexpedientesecuencia record= new Siafexpedientesecuencia();
			if(siafexpedientesecuencia.getEstadoauditoria().equals("1")){
				record.setEstadoauditoria("0");
			}else{
				record.setEstadoauditoria("1");
			}
			record.setIdsiafexpedientesecuencia(siafexpedientesecuencia.getIdsiafexpedientesecuencia());
			record.setUsuariomodificacionauditoria(getUserLogin());
			business.updateByPrimaryKeySelectiveBasic(record);

			showGrowlMessageSuccessfullyCompletedAction();
			buscar();

			REGISTER_SUCCESS();
		} catch (ValidateException e) {
			REGISTER_ERROR();
			addMessageKey("msgsSiafexpedientesecuenciaA", e.getMessage(),
			FacesMessage.SEVERITY_ERROR);
		} catch (BusinessException e) {
			REGISTER_ERROR();
			addMessageKey("msgsSiafexpedientesecuenciaA", e.getMessage(),
			FacesMessage.SEVERITY_ERROR);
		} catch (Exception e) {
			REGISTER_ERROR();
			addErrorMessageKey("msgsSiafexpedientesecuenciaA", e);
		}
	}

	public void setTemporalVars() throws Exception{

	}
	public void aceptar() {
			REGISTER_INIT();
		try {
			if (accion.equals(REGISTRAR)){
				siafexpedientesecuencia.setUsuariocreacionauditoria(getUserLogin());
				siafexpedientesecuencia.setEquipoauditoria(getRemoteAddr());
				siafexpedientesecuencia.setProgramaauditoria(pe.com.sisabas.resources.Utils.obtenerPrograma(this.getClass()));
				business.insertBasic(siafexpedientesecuencia);
			}else{
				siafexpedientesecuencia.setUsuariomodificacionauditoria(getUserLogin());
				siafexpedientesecuencia.setEquipoauditoria(getRemoteAddr());
				siafexpedientesecuencia.setProgramaauditoria(pe.com.sisabas.resources.Utils.obtenerPrograma(this.getClass()));
				business.updateByPrimaryKeyBasic(siafexpedientesecuencia);
			}

			showGrowlMessageSuccessfullyCompletedAction();
			buscar();

			REGISTER_SUCCESS();
		} catch (ValidateException e) {
			REGISTER_ERROR();
			addMessageKey("msgsSiafexpedientesecuenciaR", e.getMessage(),
			FacesMessage.SEVERITY_ERROR);
		} catch (BusinessException e) {
			REGISTER_ERROR();
			addMessageKey("msgsSiafexpedientesecuenciaR", e.getMessage(),
			FacesMessage.SEVERITY_ERROR);
		} catch(DataIntegrityViolationException e) {
			addMessageKey("msgsForm", Messages.getString("exception.dataintegrity.message.title"),Messages.getString("exception.dataintegrity.message.detail"),
			FacesMessage.SEVERITY_ERROR);
		} catch (Exception e) {
			REGISTER_ERROR();
			addErrorMessageKey("msgsSiafexpedientesecuenciaR", e);
		}
	}

	public void eliminar() {
		try {
			validateSelectedRow();
			siafexpedientesecuencia.setUsuariomodificacionauditoria(getUserLogin());
			business.deleteByPrimaryKeyBasic(siafexpedientesecuencia);
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
		if (selectedSiafexpedientesecuencia == null)
			throw new UnselectedRowException(Messages.getString("no.record.selected"));
		else
			siafexpedientesecuencia = (Siafexpedientesecuencia)selectedSiafexpedientesecuencia.clone();
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

	public void loadMainIdvcertificacion(org.primefaces.event.SelectEvent event) {
		try {
			logger.debug("loadMainVcertificacion.event...");
			pe.com.sisabas.be.Vcertificacion item= (pe.com.sisabas.be.Vcertificacion) event.getObject();
			logger.debug("loadsiafexpedientesecuencia.event...:"+item.getVcertificacion());
			siafexpedientesecuenciaB.setIdvcertificacion(item.getVcertificacion());
			siafexpedientesecuenciaB.setVcertificacionIdvcertificacion(item);
			logger.debug("loadVcertificacion.event...ok");
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}

	public void loadRegIdvcertificacion(org.primefaces.event.SelectEvent event) {
		try {
			logger.debug("loadRegVcertificacion.event...");
			pe.com.sisabas.be.Vcertificacion item= (pe.com.sisabas.be.Vcertificacion) event.getObject();
			logger.debug("loadsiafexpedientesecuencia.event...:"+item.getVcertificacion());
			siafexpedientesecuencia.setIdvcertificacion(item.getVcertificacion());
			siafexpedientesecuencia.setVcertificacionIdvcertificacion(item);
			logger.debug("loadVcertificacion.event...ok");
			resetRegisterForm();
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}

	public void resetMainIdvcertificacion() {
		try {
			siafexpedientesecuenciaB.setIdvcertificacion(null);
			siafexpedientesecuenciaB.setVcertificacionIdvcertificacion(new Vcertificacion());
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}
	public void resetRegIdvcertificacion() {
		try {
			siafexpedientesecuencia.setIdvcertificacion(null);
			siafexpedientesecuencia.setVcertificacionIdvcertificacion(new Vcertificacion());
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}



	public String loadPage(){
		buscar();
		return "/pages/siafexpedientesecuencia/siafexpedientesecuenciaBuscar.xhtml?faces-redirect=true";
	}

	public void resetRegisterForm(){
		reset("frmSiafexpedientesecuenciaRegistrar:panelC");
	}
	public void resetAnulacionForm(){
		reset("frmSiafexpedientesecuenciaAnular:panelDetailC");
	}


	public void updateCharToBoolean(Siafexpedientesecuencia record) throws Exception {
	}

	public void setSiafexpedientesecuencia(Siafexpedientesecuencia siafexpedientesecuencia){
		this.siafexpedientesecuencia=siafexpedientesecuencia;
	}

	public Siafexpedientesecuencia getSiafexpedientesecuencia(){
		return siafexpedientesecuencia;
	}

	public void setSiafexpedientesecuenciaB(Siafexpedientesecuencia siafexpedientesecuenciaB){
		this.siafexpedientesecuenciaB = siafexpedientesecuenciaB;
	}

	public Siafexpedientesecuencia getSiafexpedientesecuenciaB(){
		return siafexpedientesecuenciaB;
	}

	public void setSelectedSiafexpedientesecuencia(Siafexpedientesecuencia selectedSiafexpedientesecuencia){
		this.selectedSiafexpedientesecuencia = selectedSiafexpedientesecuencia;
	}

	public Siafexpedientesecuencia getSelectedSiafexpedientesecuencia(){
		return selectedSiafexpedientesecuencia;
	}

	public void setListaSiafexpedientesecuencia(List<Siafexpedientesecuencia> listaSiafexpedientesecuencia){
		this.listaSiafexpedientesecuencia=listaSiafexpedientesecuencia;
	}

	public List<Siafexpedientesecuencia> getListaSiafexpedientesecuencia(){
		return listaSiafexpedientesecuencia;
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

