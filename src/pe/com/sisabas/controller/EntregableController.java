
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
import pe.com.sisabas.be.Entregable;
import pe.com.sisabas.business.EntregableBusiness;
import pe.com.sisabas.business.GentablaBusiness;
import pe.com.sisabas.be.Gentabla;
import pe.com.sisabas.be.Grupodocumento;



@Component(value ="entregable")
@Scope(value = "session")
public class EntregableController extends BaseController {

	private static final long serialVersionUID = 1L;
	private StreamedContent file;
	private Entregable entregableB;
	private Entregable entregable;
	private Entregable selectedEntregable;
	private List<Entregable> listaEntregable;
	public List<Gentabla> listaGentablaIdcatalogoestadoentregable;

	private String accion;
	private String titulo;
	
	private String tituloBase; //titulo de la opcion
	private String tituloParam;//titulo que llega como parametro (derivada padre)
	
	private String esDerivada="0";
	
	@Autowired
	public pe.com.sisabas.resources.business.UtilsBusiness utilsBusiness;

	@Autowired
	public EntregableBusiness business;

	@Autowired
	public GentablaBusiness gentablaBusiness;



	//Nota: idOpcion, sicuopcion estan en BaseController
	private String idOpcionText = "OPC_ENTREGABLE";
	public EntregableController(){
			entregable = new Entregable();
			entregable.setGrupodocumentoIdgrupodocumento(new Grupodocumento());

	}


	@PostConstruct
	public void init(){
		try {
			entregableB = new Entregable();
			tituloBase = "Entregable » ";
			if(SICU_SECURITY_ENABLE){
				idOpcion   = SicuCallService.obtenerIdOpcion(idOpcionText).toString();
				sicuopcion = SicuCallService.obtenercontroles(idOpcion);
			}
			entregableB.setGrupodocumentoIdgrupodocumento(new Grupodocumento());

			listaIdcatalogoestadoentregableKeys= new ArrayList<String>();

			listaGentablaIdcatalogoestadoentregable = gentablaBusiness.selectDynamicBasic(new Gentabla().getObjBusqueda(Constantes.tabla.EENT));

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
			ordenListaCampos.add("A1.IDENTREGABLE");
			entregableB.setOrdenListaCampos(ordenListaCampos);
			entregableB.setOrdenTipo("DESC");

			//Add conditions IN clause
			entregableB.addConditionInIdcatalogoestadoentregable(listaIdcatalogoestadoentregableKeys);

			pe.com.sisabas.resources.Utils.convertPropertiesStringToUppercase(entregableB); //pasa a mayusculas los datos para la busqueda
			listaEntregable = business.selectDynamicFull(entregableB);
			setEsSeleccionado(false);
			setSelectedEntregable(null);
			if (listaEntregable.size() == 0)
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
			titulo = "Entregable » " + REGISTRAR;
			entregable = new Entregable();


			entregable.setIdentregable(new java.lang.Integer(0));
			entregable.setIdentregable((int)utilsBusiness.getNextSeqTemporal(pe.com.sisabas.resources.Sequence.SEQ_ENTREGABLE).longValue());
			entregable.setGrupodocumentoIdgrupodocumento(new Grupodocumento());

			entregable.setIdorden(entregableB.getIdorden());

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

	public void init(pe.com.sisabas.be.Orden orden) throws Exception{
		init();
		entregableB.setIdorden(orden.getIdorden());
		entregableB.setOrdenIdorden(orden);
		esDerivada = "1";
		buscar();
	}

	public void initDerivedTable(pe.com.sisabas.be.Orden orden) throws Exception{
		init();
		entregableB.setIdorden(orden.getIdorden());
		entregableB.setOrdenIdorden(orden);
		esDerivada = "1";
		buscar();
	}

	public void irEditar() {
		STATUS_INIT();
		try {
			securityControlValidate("btnEditar");
			resetRegisterForm();
			validateSelectedRow();
			updateCharToBoolean(entregable);
			entregable.roundBigDecimals();
			accion = EDITAR;
			titulo = "Entregable » " + EDITAR;


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
			entregable.roundBigDecimals();
			accion = DETALLE;
			titulo = "Entregable » " + DETALLE;

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
			titulo = "Entregable » " + IMPRIMIR;

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
			if(entregable.getEstadoauditoria().equals("1")){
				accion = ANULAR;
			}else{
				accion = ACTIVAR;
			}
			titulo = "Entregable » " + accion;

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
			Entregable record= new Entregable();
			if(entregable.getEstadoauditoria().equals("1")){
				record.setEstadoauditoria("0");
			}else{
				record.setEstadoauditoria("1");
			}
			record.setIdentregable(entregable.getIdentregable());
			record.setUsuariomodificacionauditoria(getUserLogin());
			business.updateByPrimaryKeySelectiveBasic(record);

			showGrowlMessageSuccessfullyCompletedAction();
			buscar();

			REGISTER_SUCCESS();
		} catch (ValidateException e) {
			REGISTER_ERROR();
			addMessageKey("msgsEntregableA", e.getMessage(),
			FacesMessage.SEVERITY_ERROR);
		} catch (BusinessException e) {
			REGISTER_ERROR();
			addMessageKey("msgsEntregableA", e.getMessage(),
			FacesMessage.SEVERITY_ERROR);
		} catch (Exception e) {
			REGISTER_ERROR();
			addErrorMessageKey("msgsEntregableA", e);
		}
	}

	public void setTemporalVars() throws Exception{
			entregable.setGentablaIdcatalogoestadoentregable(gentablaBusiness.selectByPrimaryKeyBasicFromList(entregable.getIdcatalogoestadoentregable(),listaGentablaIdcatalogoestadoentregable));

	}
	public void aceptar() {
			REGISTER_INIT();
		try {
			if (accion.equals(REGISTRAR)){
				entregable.setUsuariocreacionauditoria(getUserLogin());
				entregable.setEquipoauditoria(getRemoteAddr());
				entregable.setProgramaauditoria(pe.com.sisabas.resources.Utils.obtenerPrograma(this.getClass()));
				business.insertBasic(entregable);
			}else{
				entregable.setUsuariomodificacionauditoria(getUserLogin());
				entregable.setEquipoauditoria(getRemoteAddr());
				entregable.setProgramaauditoria(pe.com.sisabas.resources.Utils.obtenerPrograma(this.getClass()));
				business.updateByPrimaryKeyBasic(entregable);
			}

			showGrowlMessageSuccessfullyCompletedAction();
			buscar();

			REGISTER_SUCCESS();
		} catch (ValidateException e) {
			REGISTER_ERROR();
			addMessageKey("msgsEntregableR", e.getMessage(),
			FacesMessage.SEVERITY_ERROR);
		} catch (BusinessException e) {
			REGISTER_ERROR();
			addMessageKey("msgsEntregableR", e.getMessage(),
			FacesMessage.SEVERITY_ERROR);
		} catch(DataIntegrityViolationException e) {
			addMessageKey("msgsForm", Messages.getString("exception.dataintegrity.message.title"),Messages.getString("exception.dataintegrity.message.detail"),
			FacesMessage.SEVERITY_ERROR);
		} catch (Exception e) {
			REGISTER_ERROR();
			addErrorMessageKey("msgsEntregableR", e);
		}
	}

	public void eliminar() {
		try {
			validateSelectedRow();
			entregable.setUsuariomodificacionauditoria(getUserLogin());
			business.deleteByPrimaryKeyBasic(entregable);
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
		if (selectedEntregable == null)
			throw new UnselectedRowException(Messages.getString("no.record.selected"));
		else
			entregable = (Entregable)selectedEntregable.clone();
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

	public void loadMainIdgrupodocumento(org.primefaces.event.SelectEvent event) {
		try {
			logger.debug("loadMainGrupodocumento.event...");
			pe.com.sisabas.be.Grupodocumento item= (pe.com.sisabas.be.Grupodocumento) event.getObject();
			logger.debug("loadentregable.event...:"+item.getIdgrupodocumento());
			entregableB.setIdgrupodocumento(item.getIdgrupodocumento());
			entregableB.setGrupodocumentoIdgrupodocumento(item);
			logger.debug("loadGrupodocumento.event...ok");
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}

	public void loadRegIdgrupodocumento(org.primefaces.event.SelectEvent event) {
		try {
			logger.debug("loadRegGrupodocumento.event...");
			pe.com.sisabas.be.Grupodocumento item= (pe.com.sisabas.be.Grupodocumento) event.getObject();
			logger.debug("loadentregable.event...:"+item.getIdgrupodocumento());
			entregable.setIdgrupodocumento(item.getIdgrupodocumento());
			entregable.setGrupodocumentoIdgrupodocumento(item);
			logger.debug("loadGrupodocumento.event...ok");
			resetRegisterForm();
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}

	public void resetMainIdgrupodocumento() {
		try {
			entregableB.setIdgrupodocumento(null);
			entregableB.setGrupodocumentoIdgrupodocumento(new Grupodocumento());
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}
	public void resetRegIdgrupodocumento() {
		try {
			entregable.setIdgrupodocumento(null);
			entregable.setGrupodocumentoIdgrupodocumento(new Grupodocumento());
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}



	public String loadPage(){
		buscar();
		return "/pages/entregable/entregableBuscar.xhtml?faces-redirect=true";
	}

	public void resetRegisterForm(){
		reset("frmEntregableRegistrar:panelC");
	}
	public void resetAnulacionForm(){
		reset("frmEntregableAnular:panelDetailC");
	}


	public void updateCharToBoolean(Entregable record) throws Exception {
	}

	public void setEntregable(Entregable entregable){
		this.entregable=entregable;
	}

	public Entregable getEntregable(){
		return entregable;
	}

	public void setEntregableB(Entregable entregableB){
		this.entregableB = entregableB;
	}

	public Entregable getEntregableB(){
		return entregableB;
	}

	public void setSelectedEntregable(Entregable selectedEntregable){
		this.selectedEntregable = selectedEntregable;
	}

	public Entregable getSelectedEntregable(){
		return selectedEntregable;
	}

	public void setListaEntregable(List<Entregable> listaEntregable){
		this.listaEntregable=listaEntregable;
	}

	public List<Entregable> getListaEntregable(){
		return listaEntregable;
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

	public void setListaGentablaIdcatalogoestadoentregable(List<Gentabla> listaGentablaIdcatalogoestadoentregable){
		this.listaGentablaIdcatalogoestadoentregable=listaGentablaIdcatalogoestadoentregable;
	}

	public List<Gentabla> getListaGentablaIdcatalogoestadoentregable(){
		return listaGentablaIdcatalogoestadoentregable;
	}


	private List<String> listaIdcatalogoestadoentregableKeys;
	private String valuesIdcatalogoestadoentregable;
	public void handleChangeIdcatalogoestadoentregable(ToggleSelectEvent toggle){
		if(toggle.isSelected()){
			addAllItemsIdcatalogoestadoentregable();
		}else{
			listaIdcatalogoestadoentregableKeys=new ArrayList<String>();
			valuesIdcatalogoestadoentregable=Messages.getString("selectmanycheckbox.noitems");
		}
	}
	private void addAllItemsIdcatalogoestadoentregable(){
		StringBuilder sbTmp=new StringBuilder("");
		listaIdcatalogoestadoentregableKeys=new ArrayList<String>();
		for (Gentabla s : listaGentablaIdcatalogoestadoentregable) {
			listaIdcatalogoestadoentregableKeys.add(String.valueOf(s.getVchregcodigo()));
			sbTmp.append(s.getVchregdescri()+", ");
		}
		valuesIdcatalogoestadoentregable=Utils.borrarComitaFinal(sbTmp.toString());
	}
	public void getValuesListenerIdcatalogoestadoentregable(){
		StringBuilder sbTmp=new StringBuilder("");
		for (String key : listaIdcatalogoestadoentregableKeys) {
			sbTmp.append(getValueIdcatalogoestadoentregable(key)+", ");
		}
		valuesIdcatalogoestadoentregable=Utils.borrarComitaFinal(sbTmp.toString());
		if(listaIdcatalogoestadoentregableKeys.size()==0)
			valuesIdcatalogoestadoentregable=Messages.getString("selectmanycheckbox.noitems");
	}
	private String getValueIdcatalogoestadoentregable(String key){
		for (Gentabla s : listaGentablaIdcatalogoestadoentregable) {
			if(String.valueOf(s.getVchregcodigo()).equalsIgnoreCase(key))
				return s.getVchregdescri().toString();
			}
		return "";
	}
	 public List<String> getListaIdcatalogoestadoentregableKeys() {
		return listaIdcatalogoestadoentregableKeys;
	}

	public void setListaIdcatalogoestadoentregableKeys(List<String> listaIdcatalogoestadoentregableKeys) {
		this.listaIdcatalogoestadoentregableKeys = listaIdcatalogoestadoentregableKeys;
	}

	 public String getValuesIdcatalogoestadoentregable() {
		return valuesIdcatalogoestadoentregable;
	}

	public void setValuesIdcatalogoestadoentregable(String valuesIdcatalogoestadoentregable) {
		this.valuesIdcatalogoestadoentregable = valuesIdcatalogoestadoentregable;
	}

///////////////////////////////



}

