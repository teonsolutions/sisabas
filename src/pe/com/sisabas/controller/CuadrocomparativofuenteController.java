
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
import pe.com.sisabas.be.Cuadrocomparativofuente;
import pe.com.sisabas.business.CuadrocomparativofuenteBusiness;
import pe.com.sisabas.be.Pacconsolidado;
import pe.com.sisabas.business.GentablaBusiness;
import pe.com.sisabas.be.Gentabla;
import pe.com.sisabas.business.GentablaBusiness;
import pe.com.sisabas.be.Gentabla;
import pe.com.sisabas.business.GentablaBusiness;
import pe.com.sisabas.be.Gentabla;



@Component(value ="cuadrocomparativofuente")
@Scope(value = "session")
public class CuadrocomparativofuenteController extends BaseController {

	private static final long serialVersionUID = 1L;
	private StreamedContent file;
	private Cuadrocomparativofuente cuadrocomparativofuenteB;
	private Cuadrocomparativofuente cuadrocomparativofuente;
	private Cuadrocomparativofuente selectedCuadrocomparativofuente;
	private List<Cuadrocomparativofuente> listaCuadrocomparativofuente;
	public List<Gentabla> listaGentablaIdcatalogotipofuente;
	public List<Gentabla> listaGentablaIdcatalogotipobien;
	public List<Gentabla> listaGentablaIdcatalogomonedafuente;

	private String accion;
	private String titulo;
	
	private String tituloBase; //titulo de la opcion
	private String tituloParam;//titulo que llega como parametro (derivada padre)
	
	private String esDerivada="0";
	
	@Autowired
	public pe.com.sisabas.resources.business.UtilsBusiness utilsBusiness;

	@Autowired
	public CuadrocomparativofuenteBusiness business;

	@Autowired
	public GentablaBusiness gentablaBusiness;



	//Nota: idOpcion, sicuopcion estan en BaseController
	private String idOpcionText = "OPC_CUADROCOMPARATIV";
	public CuadrocomparativofuenteController(){
			cuadrocomparativofuente = new Cuadrocomparativofuente();
			cuadrocomparativofuente.setPacconsolidadoIdpacconsolidado(new Pacconsolidado());

	}


	@PostConstruct
	public void init(){
		try {
			cuadrocomparativofuenteB = new Cuadrocomparativofuente();
			tituloBase = "CuadroComparativoFuente » ";
			if(SICU_SECURITY_ENABLE){
				idOpcion   = SicuCallService.obtenerIdOpcion(idOpcionText).toString();
				sicuopcion = SicuCallService.obtenercontroles(idOpcion);
			}
			cuadrocomparativofuenteB.setPacconsolidadoIdpacconsolidado(new Pacconsolidado());

			listaIdcatalogotipofuenteKeys= new ArrayList<String>();
			listaIdcatalogotipobienKeys= new ArrayList<String>();
			listaIdcatalogomonedafuenteKeys= new ArrayList<String>();

			listaGentablaIdcatalogotipofuente = gentablaBusiness.selectDynamicBasic(new Gentabla().getObjBusqueda(Constantes.tabla.TIFU));
			listaGentablaIdcatalogotipobien = gentablaBusiness.selectDynamicBasic(new Gentabla().getObjBusqueda(Constantes.tabla.TIBI));
			listaGentablaIdcatalogomonedafuente = gentablaBusiness.selectDynamicBasic(new Gentabla().getObjBusqueda(Constantes.tabla.MOFU));

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
			ordenListaCampos.add("A1.IDCUADROCOMPARATIVOFUENTE");
			cuadrocomparativofuenteB.setOrdenListaCampos(ordenListaCampos);
			cuadrocomparativofuenteB.setOrdenTipo("DESC");

			//Add conditions IN clause
			cuadrocomparativofuenteB.addConditionInIdcatalogotipofuente(listaIdcatalogotipofuenteKeys);
			cuadrocomparativofuenteB.addConditionInIdcatalogotipobien(listaIdcatalogotipobienKeys);
			cuadrocomparativofuenteB.addConditionInIdcatalogomonedafuente(listaIdcatalogomonedafuenteKeys);

			pe.com.sisabas.resources.Utils.convertPropertiesStringToUppercase(cuadrocomparativofuenteB); //pasa a mayusculas los datos para la busqueda
			listaCuadrocomparativofuente = business.selectDynamicFull(cuadrocomparativofuenteB);
			setEsSeleccionado(false);
			setSelectedCuadrocomparativofuente(null);
			if (listaCuadrocomparativofuente.size() == 0)
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
			titulo = "CuadroComparativoFuente » " + REGISTRAR;
			cuadrocomparativofuente = new Cuadrocomparativofuente();

			cuadrocomparativofuente.setBooleanproveedordedicacontratacion(false);
			cuadrocomparativofuente.setBooleanusuarioparticiportm(false);
			cuadrocomparativofuente.setBooleancumplertm(false);
			cuadrocomparativofuente.setBooleansetomoencuenta(false);
			cuadrocomparativofuente.setIdcuadrocomparativofuente(new java.lang.Integer(0));
			cuadrocomparativofuente.setIdcuadrocomparativofuente((int)utilsBusiness.getNextSeq(pe.com.sisabas.resources.Sequence.SEQ_CUADROCOMPARATIVOFUENTE).longValue());
			cuadrocomparativofuente.setPacconsolidadoIdpacconsolidado(new Pacconsolidado());			
			cuadrocomparativofuente.setIdpacconsolidado(cuadrocomparativofuenteB.getIdpacconsolidado());

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
	CuadrocomparativoitemController cuadrocomparativoitemController;
	public String irCuadrocomparativoitem() {
		boolean validado=false;
		try {
			securityControlValidate("btnCuadrocomparativoitem");
			validateSelectedRow();
			String paramTitulo = new String((tituloParam!=null?tituloParam:"")+" "+tituloBase);
			cuadrocomparativoitemController.setTituloParam(paramTitulo);
			cuadrocomparativoitemController.init(cuadrocomparativofuente);

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
		if(validado) return "/pages/cuadrocomparativoitem/cuadrocomparativoitemBuscar.xhtml?faces-redirect=true";
		else return null;
	}

	public String load() {
		return"/pages/cuadrocomparativofuente/cuadrocomparativofuenteBuscar.xhtml?faces-redirect=true";
	}

	public void init(pe.com.sisabas.be.Pacconsolidado pacconsolidado) throws Exception{
		init();
		cuadrocomparativofuenteB.setIdpacconsolidado(pacconsolidado.getIdpacconsolidado());
		cuadrocomparativofuenteB.setPacconsolidadoIdpacconsolidado(pacconsolidado);
		esDerivada = "1";
		buscar();
	}

	public void initDerivedTable(pe.com.sisabas.be.Pacconsolidado pacconsolidado) throws Exception{
		init();
		cuadrocomparativofuenteB.setIdpacconsolidado(pacconsolidado.getIdpacconsolidado());
		cuadrocomparativofuenteB.setPacconsolidadoIdpacconsolidado(pacconsolidado);
		esDerivada = "1";
		buscar();
	}

	public void irEditar() {
		STATUS_INIT();
		try {
			securityControlValidate("btnEditar");
			resetRegisterForm();
			validateSelectedRow();
			updateCharToBoolean(cuadrocomparativofuente);
			cuadrocomparativofuente.roundBigDecimals();
			accion = EDITAR;
			titulo = "CuadroComparativoFuente » " + EDITAR;


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
			cuadrocomparativofuente.roundBigDecimals();
			accion = DETALLE;
			titulo = "CuadroComparativoFuente » " + DETALLE;

			String paramTitulo = new String((tituloParam!=null?tituloParam:"")+" "+tituloBase);
			cuadrocomparativoitemController.setTituloParam(paramTitulo);
			cuadrocomparativoitemController.initDerivedTable(cuadrocomparativofuente);

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
			titulo = "CuadroComparativoFuente » " + IMPRIMIR;

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
			if(cuadrocomparativofuente.getEstadoauditoria().equals("1")){
				accion = ANULAR;
			}else{
				accion = ACTIVAR;
			}
			titulo = "CuadroComparativoFuente » " + accion;

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
			Cuadrocomparativofuente record= new Cuadrocomparativofuente();
			if(cuadrocomparativofuente.getEstadoauditoria().equals("1")){
				record.setEstadoauditoria("0");
			}else{
				record.setEstadoauditoria("1");
			}
			record.setIdcuadrocomparativofuente(cuadrocomparativofuente.getIdcuadrocomparativofuente());
			record.setUsuariomodificacionauditoria(getUserLogin());
			business.updateByPrimaryKeySelectiveBasic(record);

			showGrowlMessageSuccessfullyCompletedAction();
			buscar();

			REGISTER_SUCCESS();
		} catch (ValidateException e) {
			REGISTER_ERROR();
			addMessageKey("msgsCuadrocomparativofuenteA", e.getMessage(),
			FacesMessage.SEVERITY_ERROR);
		} catch (BusinessException e) {
			REGISTER_ERROR();
			addMessageKey("msgsCuadrocomparativofuenteA", e.getMessage(),
			FacesMessage.SEVERITY_ERROR);
		} catch (Exception e) {
			REGISTER_ERROR();
			addErrorMessageKey("msgsCuadrocomparativofuenteA", e);
		}
	}

	public void setTemporalVars() throws Exception{
			cuadrocomparativofuente.setGentablaIdcatalogotipofuente(gentablaBusiness.selectByPrimaryKeyBasicFromList(cuadrocomparativofuente.getIdcatalogotipofuente(),listaGentablaIdcatalogotipofuente));
			cuadrocomparativofuente.setGentablaIdcatalogotipobien(gentablaBusiness.selectByPrimaryKeyBasicFromList(cuadrocomparativofuente.getIdcatalogotipobien(),listaGentablaIdcatalogotipobien));
			cuadrocomparativofuente.setGentablaIdcatalogomonedafuente(gentablaBusiness.selectByPrimaryKeyBasicFromList(cuadrocomparativofuente.getIdcatalogomonedafuente(),listaGentablaIdcatalogomonedafuente));

	}
	public void aceptar() {
			REGISTER_INIT();
		try {
			if (accion.equals(REGISTRAR)){
				cuadrocomparativofuente.setUsuariocreacionauditoria(getUserLogin());
				cuadrocomparativofuente.setEquipoauditoria(getRemoteAddr());
				cuadrocomparativofuente.setProgramaauditoria(pe.com.sisabas.resources.Utils.obtenerPrograma(this.getClass()));
				business.insertBasic(cuadrocomparativofuente);
			}else{
				cuadrocomparativofuente.setUsuariomodificacionauditoria(getUserLogin());
				cuadrocomparativofuente.setEquipoauditoria(getRemoteAddr());
				cuadrocomparativofuente.setProgramaauditoria(pe.com.sisabas.resources.Utils.obtenerPrograma(this.getClass()));
				business.updateByPrimaryKeyBasic(cuadrocomparativofuente);
			}

			showGrowlMessageSuccessfullyCompletedAction();
			buscar();

			REGISTER_SUCCESS();
		} catch (ValidateException e) {
			REGISTER_ERROR();
			addMessageKey("msgsCuadrocomparativofuenteR", e.getMessage(),
			FacesMessage.SEVERITY_ERROR);
		} catch (BusinessException e) {
			REGISTER_ERROR();
			addMessageKey("msgsCuadrocomparativofuenteR", e.getMessage(),
			FacesMessage.SEVERITY_ERROR);
		} catch(DataIntegrityViolationException e) {
			addMessageKey("msgsForm", Messages.getString("exception.dataintegrity.message.title"),Messages.getString("exception.dataintegrity.message.detail"),
			FacesMessage.SEVERITY_ERROR);
		} catch (Exception e) {
			REGISTER_ERROR();
			addErrorMessageKey("msgsCuadrocomparativofuenteR", e);
		}
	}

	public void eliminar() {
		try {
			validateSelectedRow();
			cuadrocomparativofuente.setUsuariomodificacionauditoria(getUserLogin());
			business.deleteByPrimaryKeyBasic(cuadrocomparativofuente);
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
		if (selectedCuadrocomparativofuente == null)
			throw new UnselectedRowException(Messages.getString("no.record.selected"));
		else
			cuadrocomparativofuente = (Cuadrocomparativofuente)selectedCuadrocomparativofuente.clone();
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
			logger.debug("loadcuadrocomparativofuente.event...:"+item.getIdpacconsolidado());
			cuadrocomparativofuenteB.setIdpacconsolidado(item.getIdpacconsolidado());
			cuadrocomparativofuenteB.setPacconsolidadoIdpacconsolidado(item);
			logger.debug("loadPacconsolidado.event...ok");
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}

	public void loadRegIdpacconsolidado(org.primefaces.event.SelectEvent event) {
		try {
			logger.debug("loadRegPacconsolidado.event...");
			pe.com.sisabas.be.Pacconsolidado item= (pe.com.sisabas.be.Pacconsolidado) event.getObject();
			logger.debug("loadcuadrocomparativofuente.event...:"+item.getIdpacconsolidado());
			cuadrocomparativofuente.setIdpacconsolidado(item.getIdpacconsolidado());
			cuadrocomparativofuente.setPacconsolidadoIdpacconsolidado(item);
			logger.debug("loadPacconsolidado.event...ok");
			resetRegisterForm();
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}

	public void resetMainIdpacconsolidado() {
		try {
			cuadrocomparativofuenteB.setIdpacconsolidado(null);
			cuadrocomparativofuenteB.setPacconsolidadoIdpacconsolidado(new Pacconsolidado());
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}
	public void resetRegIdpacconsolidado() {
		try {
			cuadrocomparativofuente.setIdpacconsolidado(null);
			cuadrocomparativofuente.setPacconsolidadoIdpacconsolidado(new Pacconsolidado());
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}



	public String loadPage(){
		buscar();
		return "/pages/cuadrocomparativofuente/cuadrocomparativofuenteBuscar.xhtml?faces-redirect=true";
	}

	public void resetRegisterForm(){
		reset("frmCuadrocomparativofuenteRegistrar:panelC");
	}
	public void resetAnulacionForm(){
		reset("frmCuadrocomparativofuenteAnular:panelDetailC");
	}


	public void updateCharToBoolean(Cuadrocomparativofuente record) throws Exception {
		if( cuadrocomparativofuente.getProveedordedicacontratacion()!=null  && cuadrocomparativofuente.getProveedordedicacontratacion().equalsIgnoreCase("1")){
			cuadrocomparativofuente.setBooleanproveedordedicacontratacion(true);
		}else {
			cuadrocomparativofuente.setBooleanproveedordedicacontratacion(false);
		}

		if( cuadrocomparativofuente.getUsuarioparticiportm()!=null  && cuadrocomparativofuente.getUsuarioparticiportm().equalsIgnoreCase("1")){
			cuadrocomparativofuente.setBooleanusuarioparticiportm(true);
		}else {
			cuadrocomparativofuente.setBooleanusuarioparticiportm(false);
		}

		if( cuadrocomparativofuente.getCumplertm()!=null  && cuadrocomparativofuente.getCumplertm().equalsIgnoreCase("1")){
			cuadrocomparativofuente.setBooleancumplertm(true);
		}else {
			cuadrocomparativofuente.setBooleancumplertm(false);
		}

		if( cuadrocomparativofuente.getSetomoencuenta()!=null  && cuadrocomparativofuente.getSetomoencuenta().equalsIgnoreCase("1")){
			cuadrocomparativofuente.setBooleansetomoencuenta(true);
		}else {
			cuadrocomparativofuente.setBooleansetomoencuenta(false);
		}

	}

	public void setCuadrocomparativofuente(Cuadrocomparativofuente cuadrocomparativofuente){
		this.cuadrocomparativofuente=cuadrocomparativofuente;
	}

	public Cuadrocomparativofuente getCuadrocomparativofuente(){
		return cuadrocomparativofuente;
	}

	public void setCuadrocomparativofuenteB(Cuadrocomparativofuente cuadrocomparativofuenteB){
		this.cuadrocomparativofuenteB = cuadrocomparativofuenteB;
	}

	public Cuadrocomparativofuente getCuadrocomparativofuenteB(){
		return cuadrocomparativofuenteB;
	}

	public void setSelectedCuadrocomparativofuente(Cuadrocomparativofuente selectedCuadrocomparativofuente){
		this.selectedCuadrocomparativofuente = selectedCuadrocomparativofuente;
	}

	public Cuadrocomparativofuente getSelectedCuadrocomparativofuente(){
		return selectedCuadrocomparativofuente;
	}

	public void setListaCuadrocomparativofuente(List<Cuadrocomparativofuente> listaCuadrocomparativofuente){
		this.listaCuadrocomparativofuente=listaCuadrocomparativofuente;
	}

	public List<Cuadrocomparativofuente> getListaCuadrocomparativofuente(){
		return listaCuadrocomparativofuente;
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

	public void setListaGentablaIdcatalogotipofuente(List<Gentabla> listaGentablaIdcatalogotipofuente){
		this.listaGentablaIdcatalogotipofuente=listaGentablaIdcatalogotipofuente;
	}

	public List<Gentabla> getListaGentablaIdcatalogotipofuente(){
		return listaGentablaIdcatalogotipofuente;
	}

	public void setListaGentablaIdcatalogotipobien(List<Gentabla> listaGentablaIdcatalogotipobien){
		this.listaGentablaIdcatalogotipobien=listaGentablaIdcatalogotipobien;
	}

	public List<Gentabla> getListaGentablaIdcatalogotipobien(){
		return listaGentablaIdcatalogotipobien;
	}

	public void setListaGentablaIdcatalogomonedafuente(List<Gentabla> listaGentablaIdcatalogomonedafuente){
		this.listaGentablaIdcatalogomonedafuente=listaGentablaIdcatalogomonedafuente;
	}

	public List<Gentabla> getListaGentablaIdcatalogomonedafuente(){
		return listaGentablaIdcatalogomonedafuente;
	}


	private List<String> listaIdcatalogotipofuenteKeys;
	private String valuesIdcatalogotipofuente;
	public void handleChangeIdcatalogotipofuente(ToggleSelectEvent toggle){
		if(toggle.isSelected()){
			addAllItemsIdcatalogotipofuente();
		}else{
			listaIdcatalogotipofuenteKeys=new ArrayList<String>();
			valuesIdcatalogotipofuente=Messages.getString("selectmanycheckbox.noitems");
		}
	}
	private void addAllItemsIdcatalogotipofuente(){
		StringBuilder sbTmp=new StringBuilder("");
		listaIdcatalogotipofuenteKeys=new ArrayList<String>();
		for (Gentabla s : listaGentablaIdcatalogotipofuente) {
			listaIdcatalogotipofuenteKeys.add(String.valueOf(s.getVchregcodigo()));
			sbTmp.append(s.getVchregdescri()+", ");
		}
		valuesIdcatalogotipofuente=Utils.borrarComitaFinal(sbTmp.toString());
	}
	public void getValuesListenerIdcatalogotipofuente(){
		StringBuilder sbTmp=new StringBuilder("");
		for (String key : listaIdcatalogotipofuenteKeys) {
			sbTmp.append(getValueIdcatalogotipofuente(key)+", ");
		}
		valuesIdcatalogotipofuente=Utils.borrarComitaFinal(sbTmp.toString());
		if(listaIdcatalogotipofuenteKeys.size()==0)
			valuesIdcatalogotipofuente=Messages.getString("selectmanycheckbox.noitems");
	}
	private String getValueIdcatalogotipofuente(String key){
		for (Gentabla s : listaGentablaIdcatalogotipofuente) {
			if(String.valueOf(s.getVchregcodigo()).equalsIgnoreCase(key))
				return s.getVchregdescri().toString();
			}
		return "";
	}
	 public List<String> getListaIdcatalogotipofuenteKeys() {
		return listaIdcatalogotipofuenteKeys;
	}

	public void setListaIdcatalogotipofuenteKeys(List<String> listaIdcatalogotipofuenteKeys) {
		this.listaIdcatalogotipofuenteKeys = listaIdcatalogotipofuenteKeys;
	}

	 public String getValuesIdcatalogotipofuente() {
		return valuesIdcatalogotipofuente;
	}

	public void setValuesIdcatalogotipofuente(String valuesIdcatalogotipofuente) {
		this.valuesIdcatalogotipofuente = valuesIdcatalogotipofuente;
	}

///////////////////////////////

	private List<String> listaIdcatalogotipobienKeys;
	private String valuesIdcatalogotipobien;
	public void handleChangeIdcatalogotipobien(ToggleSelectEvent toggle){
		if(toggle.isSelected()){
			addAllItemsIdcatalogotipobien();
		}else{
			listaIdcatalogotipobienKeys=new ArrayList<String>();
			valuesIdcatalogotipobien=Messages.getString("selectmanycheckbox.noitems");
		}
	}
	private void addAllItemsIdcatalogotipobien(){
		StringBuilder sbTmp=new StringBuilder("");
		listaIdcatalogotipobienKeys=new ArrayList<String>();
		for (Gentabla s : listaGentablaIdcatalogotipobien) {
			listaIdcatalogotipobienKeys.add(String.valueOf(s.getVchregcodigo()));
			sbTmp.append(s.getVchregdescri()+", ");
		}
		valuesIdcatalogotipobien=Utils.borrarComitaFinal(sbTmp.toString());
	}
	public void getValuesListenerIdcatalogotipobien(){
		StringBuilder sbTmp=new StringBuilder("");
		for (String key : listaIdcatalogotipobienKeys) {
			sbTmp.append(getValueIdcatalogotipobien(key)+", ");
		}
		valuesIdcatalogotipobien=Utils.borrarComitaFinal(sbTmp.toString());
		if(listaIdcatalogotipobienKeys.size()==0)
			valuesIdcatalogotipobien=Messages.getString("selectmanycheckbox.noitems");
	}
	private String getValueIdcatalogotipobien(String key){
		for (Gentabla s : listaGentablaIdcatalogotipobien) {
			if(String.valueOf(s.getVchregcodigo()).equalsIgnoreCase(key))
				return s.getVchregdescri().toString();
			}
		return "";
	}
	 public List<String> getListaIdcatalogotipobienKeys() {
		return listaIdcatalogotipobienKeys;
	}

	public void setListaIdcatalogotipobienKeys(List<String> listaIdcatalogotipobienKeys) {
		this.listaIdcatalogotipobienKeys = listaIdcatalogotipobienKeys;
	}

	 public String getValuesIdcatalogotipobien() {
		return valuesIdcatalogotipobien;
	}

	public void setValuesIdcatalogotipobien(String valuesIdcatalogotipobien) {
		this.valuesIdcatalogotipobien = valuesIdcatalogotipobien;
	}

///////////////////////////////

	private List<String> listaIdcatalogomonedafuenteKeys;
	private String valuesIdcatalogomonedafuente;
	public void handleChangeIdcatalogomonedafuente(ToggleSelectEvent toggle){
		if(toggle.isSelected()){
			addAllItemsIdcatalogomonedafuente();
		}else{
			listaIdcatalogomonedafuenteKeys=new ArrayList<String>();
			valuesIdcatalogomonedafuente=Messages.getString("selectmanycheckbox.noitems");
		}
	}
	private void addAllItemsIdcatalogomonedafuente(){
		StringBuilder sbTmp=new StringBuilder("");
		listaIdcatalogomonedafuenteKeys=new ArrayList<String>();
		for (Gentabla s : listaGentablaIdcatalogomonedafuente) {
			listaIdcatalogomonedafuenteKeys.add(String.valueOf(s.getVchregcodigo()));
			sbTmp.append(s.getVchregdescri()+", ");
		}
		valuesIdcatalogomonedafuente=Utils.borrarComitaFinal(sbTmp.toString());
	}
	public void getValuesListenerIdcatalogomonedafuente(){
		StringBuilder sbTmp=new StringBuilder("");
		for (String key : listaIdcatalogomonedafuenteKeys) {
			sbTmp.append(getValueIdcatalogomonedafuente(key)+", ");
		}
		valuesIdcatalogomonedafuente=Utils.borrarComitaFinal(sbTmp.toString());
		if(listaIdcatalogomonedafuenteKeys.size()==0)
			valuesIdcatalogomonedafuente=Messages.getString("selectmanycheckbox.noitems");
	}
	private String getValueIdcatalogomonedafuente(String key){
		for (Gentabla s : listaGentablaIdcatalogomonedafuente) {
			if(String.valueOf(s.getVchregcodigo()).equalsIgnoreCase(key))
				return s.getVchregdescri().toString();
			}
		return "";
	}
	 public List<String> getListaIdcatalogomonedafuenteKeys() {
		return listaIdcatalogomonedafuenteKeys;
	}

	public void setListaIdcatalogomonedafuenteKeys(List<String> listaIdcatalogomonedafuenteKeys) {
		this.listaIdcatalogomonedafuenteKeys = listaIdcatalogomonedafuenteKeys;
	}

	 public String getValuesIdcatalogomonedafuente() {
		return valuesIdcatalogomonedafuente;
	}

	public void setValuesIdcatalogomonedafuente(String valuesIdcatalogomonedafuente) {
		this.valuesIdcatalogomonedafuente = valuesIdcatalogomonedafuente;
	}

///////////////////////////////



}

