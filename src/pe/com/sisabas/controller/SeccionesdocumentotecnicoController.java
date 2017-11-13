
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
import pe.com.sisabas.be.Seccionesdocumentotecnico;
import pe.com.sisabas.business.SeccionesdocumentotecnicoBusiness;
import pe.com.sisabas.business.GentablaBusiness;
import pe.com.sisabas.be.Gentabla;
import pe.com.sisabas.business.GentablaBusiness;
import pe.com.sisabas.be.Gentabla;



@Component(value ="seccionesdocumentotecnico")
@Scope(value = "session")
public class SeccionesdocumentotecnicoController extends BaseController {

	private static final long serialVersionUID = 1L;
	private StreamedContent file;
	private Seccionesdocumentotecnico seccionesdocumentotecnicoB;
	private Seccionesdocumentotecnico seccionesdocumentotecnico;
	private Seccionesdocumentotecnico selectedSeccionesdocumentotecnico;
	private List<Seccionesdocumentotecnico> listaSeccionesdocumentotecnico;
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
	public SeccionesdocumentotecnicoBusiness business;

	@Autowired
	public GentablaBusiness gentablaBusiness;



	//Nota: idOpcion, sicuopcion estan en BaseController
	private String idOpcionText = "OPC_SECCIONESDOCUMEN";
	public SeccionesdocumentotecnicoController(){
			seccionesdocumentotecnico = new Seccionesdocumentotecnico();

	}


	@PostConstruct
	public void init(){
		try {
			seccionesdocumentotecnicoB = new Seccionesdocumentotecnico();
			tituloBase = "SeccionesDocumentoTecnico » ";
			if(SICU_SECURITY_ENABLE){
				idOpcion   = SicuCallService.obtenerIdOpcion(idOpcionText).toString();
				sicuopcion = SicuCallService.obtenercontroles(idOpcion);
			}

			listaIdcatalogotipodocumentotecnicoKeys= new ArrayList<String>();
			listaIdcatalogotipotdrKeys= new ArrayList<String>();

			listaGentablaIdcatalogotipodocumentotecnico = gentablaBusiness.selectDynamicBasic(new Gentabla());
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
			List<String> ordenListaCampos = Arrays.asList("A1.idcatalogotipodocumentotecnico");
			seccionesdocumentotecnicoB.setOrdenListaCampos(ordenListaCampos);
			seccionesdocumentotecnicoB.setOrdenTipo("DESC");

			//Add conditions IN clause
			seccionesdocumentotecnicoB.addConditionInIdcatalogotipodocumentotecnico(listaIdcatalogotipodocumentotecnicoKeys);
			seccionesdocumentotecnicoB.addConditionInIdcatalogotipotdr(listaIdcatalogotipotdrKeys);

			pe.com.sisabas.resources.Utils.convertPropertiesStringToUppercase(seccionesdocumentotecnicoB); //pasa a mayusculas los datos para la busqueda
			listaSeccionesdocumentotecnico = business.selectDynamicFull(seccionesdocumentotecnicoB);
			setEsSeleccionado(false);
			setSelectedSeccionesdocumentotecnico(null);
			if (listaSeccionesdocumentotecnico.size() == 0)
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
			titulo = "SeccionesDocumentoTecnico » " + REGISTRAR;
			seccionesdocumentotecnico = new Seccionesdocumentotecnico();


			seccionesdocumentotecnico.setIdseccionesdocumentotecnico(new java.lang.Integer(0));
			seccionesdocumentotecnico.setIdseccionesdocumentotecnico((int)utilsBusiness.getNextSeqTemporal(pe.com.sisabas.resources.Sequence.SEQ_SECCIONESDOCUMENTOTECNICO).longValue());


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
			updateCharToBoolean(seccionesdocumentotecnico);
			seccionesdocumentotecnico.roundBigDecimals();
			accion = EDITAR;
			titulo = "SeccionesDocumentoTecnico » " + EDITAR;


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
			seccionesdocumentotecnico.roundBigDecimals();
			accion = DETALLE;
			titulo = "SeccionesDocumentoTecnico » " + DETALLE;

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
			titulo = "SeccionesDocumentoTecnico » " + IMPRIMIR;

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
			if(seccionesdocumentotecnico.getEstadoauditoria().equals("1")){
				accion = ANULAR;
			}else{
				accion = ACTIVAR;
			}
			titulo = "SeccionesDocumentoTecnico » " + accion;

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
			Seccionesdocumentotecnico record= new Seccionesdocumentotecnico();
			if(seccionesdocumentotecnico.getEstadoauditoria().equals("1")){
				record.setEstadoauditoria("0");
			}else{
				record.setEstadoauditoria("1");
			}
			record.setIdseccionesdocumentotecnico(seccionesdocumentotecnico.getIdseccionesdocumentotecnico());
			business.updateByPrimaryKeySelectiveBasic(record);

			showGrowlMessageSuccessfullyCompletedAction();
			buscar();

			REGISTER_SUCCESS();
		} catch (ValidateException e) {
			REGISTER_ERROR();
			addMessageKey("msgsSeccionesdocumentotecnicoA", e.getMessage(),
			FacesMessage.SEVERITY_ERROR);
		} catch (BusinessException e) {
			REGISTER_ERROR();
			addMessageKey("msgsSeccionesdocumentotecnicoA", e.getMessage(),
			FacesMessage.SEVERITY_ERROR);
		} catch (Exception e) {
			REGISTER_ERROR();
			addErrorMessageKey("msgsSeccionesdocumentotecnicoA", e);
		}
	}

	public void setTemporalVars() throws Exception{
			seccionesdocumentotecnico.setGentablaIdcatalogotipodocumentotecnico(gentablaBusiness.selectByPrimaryKeyBasicFromList(seccionesdocumentotecnico.getIdcatalogotipodocumentotecnico(),listaGentablaIdcatalogotipodocumentotecnico));
			seccionesdocumentotecnico.setGentablaIdcatalogotipotdr(gentablaBusiness.selectByPrimaryKeyBasicFromList(seccionesdocumentotecnico.getIdcatalogotipotdr(),listaGentablaIdcatalogotipotdr));

	}
	public void aceptar() {
			REGISTER_INIT();
		try {
			if (accion.equals(REGISTRAR)){
				seccionesdocumentotecnico.setEquipoauditoria(getRemoteAddr());
				seccionesdocumentotecnico.setProgramaauditoria(pe.com.sisabas.resources.Utils.obtenerPrograma(this.getClass()));
				business.insertBasic(seccionesdocumentotecnico);
			}else{
				seccionesdocumentotecnico.setEquipoauditoria(getRemoteAddr());
				seccionesdocumentotecnico.setProgramaauditoria(pe.com.sisabas.resources.Utils.obtenerPrograma(this.getClass()));
				business.updateByPrimaryKeyBasic(seccionesdocumentotecnico);
			}

			showGrowlMessageSuccessfullyCompletedAction();
			buscar();

			REGISTER_SUCCESS();
		} catch (ValidateException e) {
			REGISTER_ERROR();
			addMessageKey("msgsSeccionesdocumentotecnicoR", e.getMessage(),
			FacesMessage.SEVERITY_ERROR);
		} catch (BusinessException e) {
			REGISTER_ERROR();
			addMessageKey("msgsSeccionesdocumentotecnicoR", e.getMessage(),
			FacesMessage.SEVERITY_ERROR);
		} catch(DataIntegrityViolationException e) {
			addMessageKey("msgsForm", Messages.getString("exception.dataintegrity.message.title"),Messages.getString("exception.dataintegrity.message.detail"),
			FacesMessage.SEVERITY_ERROR);
		} catch (Exception e) {
			REGISTER_ERROR();
			addErrorMessageKey("msgsSeccionesdocumentotecnicoR", e);
		}
	}

	public void eliminar() {
		try {
			validateSelectedRow();
			business.deleteByPrimaryKeyBasic(seccionesdocumentotecnico);
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
		if (selectedSeccionesdocumentotecnico == null)
			throw new UnselectedRowException(Messages.getString("no.record.selected"));
		else
			seccionesdocumentotecnico = (Seccionesdocumentotecnico)selectedSeccionesdocumentotecnico.clone();
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




	public String loadPage(){
		buscar();
		return "/pages/seccionesdocumentotecnico/seccionesdocumentotecnicoBuscar.xhtml?faces-redirect=true";
	}

	public void resetRegisterForm(){
		reset("frmSeccionesdocumentotecnicoRegistrar:panelC");
	}
	public void resetAnulacionForm(){
		reset("frmSeccionesdocumentotecnicoAnular:panelDetailC");
	}


	public void updateCharToBoolean(Seccionesdocumentotecnico record) throws Exception {
	}

	public void setSeccionesdocumentotecnico(Seccionesdocumentotecnico seccionesdocumentotecnico){
		this.seccionesdocumentotecnico=seccionesdocumentotecnico;
	}

	public Seccionesdocumentotecnico getSeccionesdocumentotecnico(){
		return seccionesdocumentotecnico;
	}

	public void setSeccionesdocumentotecnicoB(Seccionesdocumentotecnico seccionesdocumentotecnicoB){
		this.seccionesdocumentotecnicoB = seccionesdocumentotecnicoB;
	}

	public Seccionesdocumentotecnico getSeccionesdocumentotecnicoB(){
		return seccionesdocumentotecnicoB;
	}

	public void setSelectedSeccionesdocumentotecnico(Seccionesdocumentotecnico selectedSeccionesdocumentotecnico){
		this.selectedSeccionesdocumentotecnico = selectedSeccionesdocumentotecnico;
	}

	public Seccionesdocumentotecnico getSelectedSeccionesdocumentotecnico(){
		return selectedSeccionesdocumentotecnico;
	}

	public void setListaSeccionesdocumentotecnico(List<Seccionesdocumentotecnico> listaSeccionesdocumentotecnico){
		this.listaSeccionesdocumentotecnico=listaSeccionesdocumentotecnico;
	}

	public List<Seccionesdocumentotecnico> getListaSeccionesdocumentotecnico(){
		return listaSeccionesdocumentotecnico;
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

