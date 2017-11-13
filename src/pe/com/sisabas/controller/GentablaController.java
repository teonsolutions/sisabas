
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
import pe.com.sisabas.be.Gentabla;
import pe.com.sisabas.business.GentablaBusiness;
import pe.com.sisabas.business.GentipoBusiness;
import pe.com.sisabas.be.Gentipo;



@Component(value ="gentabla")
@Scope(value = "session")
public class GentablaController extends BaseController {

	private static final long serialVersionUID = 1L;
	private StreamedContent file;
	private Gentabla gentablaB;
	private Gentabla gentabla;
	private Gentabla selectedGentabla;
	private List<Gentabla> listaGentabla;
	public List<Gentipo> listaGentipoVchtipcodigo;

	private String accion;
	private String titulo;
	
	private String tituloBase; //titulo de la opcion
	private String tituloParam;//titulo que llega como parametro (derivada padre)
	
	private String esDerivada="0";
	
	@Autowired
	public pe.com.sisabas.resources.business.UtilsBusiness utilsBusiness;

	@Autowired
	public GentablaBusiness business;

	@Autowired
	public GentipoBusiness gentipoBusiness;



	//Nota: idOpcion, sicuopcion estan en BaseController
	private String idOpcionText = "OPC_GENTABLA";
	public GentablaController(){
			gentabla = new Gentabla();

	}


	@PostConstruct
	public void init(){
		try {
			gentablaB = new Gentabla();
			tituloBase = "Tabla General » ";
			if(SICU_SECURITY_ENABLE){
				idOpcion   = SicuCallService.obtenerIdOpcion(idOpcionText).toString();
				sicuopcion = SicuCallService.obtenercontroles(idOpcion);
			}

			listaVchtipcodigoKeys= new ArrayList<String>();

			listaGentipoVchtipcodigo = gentipoBusiness.selectDynamicBasic(new Gentipo());

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
			List<String> ordenListaCampos = Arrays.asList("A1.vchregdescri");
			gentablaB.setOrdenListaCampos(ordenListaCampos);
			gentablaB.setOrdenTipo("DESC");

			//Add conditions IN clause
			gentablaB.addConditionInVchtipcodigo(listaVchtipcodigoKeys);

			pe.com.sisabas.resources.Utils.convertPropertiesStringToUppercase(gentablaB); //pasa a mayusculas los datos para la busqueda
			listaGentabla = business.selectDynamicFull(gentablaB);
			setEsSeleccionado(false);
			setSelectedGentabla(null);
			if (listaGentabla.size() == 0)
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
			titulo = "Tabla General » " + REGISTRAR;
			gentabla = new Gentabla();



			gentabla.setVchtipcodigo(gentablaB.getVchtipcodigo());

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

	public void init(pe.com.sisabas.be.Gentipo gentipo) throws Exception{
		init();
		gentablaB.setVchtipcodigo(gentipo.getVchtipcodigo());
		gentablaB.setGentipoVchtipcodigo(gentipo);
		listaVchtipcodigoKeys.add(String.valueOf(gentipo.getVchtipcodigo()));
		getValuesListenerVchtipcodigo();
		esDerivada = "1";
		buscar();
	}

	public void initDerivedTable(pe.com.sisabas.be.Gentipo gentipo) throws Exception{
		init();
		gentablaB.setVchtipcodigo(gentipo.getVchtipcodigo());
		gentablaB.setGentipoVchtipcodigo(gentipo);
		listaVchtipcodigoKeys.add(String.valueOf(gentipo.getVchtipcodigo()));
		getValuesListenerVchtipcodigo();
		esDerivada = "1";
		buscar();
	}

	public void irEditar() {
		STATUS_INIT();
		try {
			securityControlValidate("btnEditar");
			resetRegisterForm();
			validateSelectedRow();
			updateCharToBoolean(gentabla);
			gentabla.roundBigDecimals();
			accion = EDITAR;
			titulo = "Tabla General » " + EDITAR;


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
			gentabla.roundBigDecimals();
			accion = DETALLE;
			titulo = "Tabla General » " + DETALLE;

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
			titulo = "Tabla General » " + IMPRIMIR;

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
			if(gentabla.getEstadoauditoria().equals("1")){
				accion = ANULAR;
			}else{
				accion = ACTIVAR;
			}
			titulo = "Tabla General » " + accion;

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
			Gentabla record= new Gentabla();
			if(gentabla.getEstadoauditoria().equals("1")){
				record.setEstadoauditoria("0");
			}else{
				record.setEstadoauditoria("1");
			}
			record.setVchregcodigo(gentabla.getVchregcodigo());
			record.setUsuariomodificacionauditoria(getUserLogin());
			business.updateByPrimaryKeySelectiveBasic(record);

			showGrowlMessageSuccessfullyCompletedAction();
			buscar();

			REGISTER_SUCCESS();
		} catch (ValidateException e) {
			REGISTER_ERROR();
			addMessageKey("msgsGentablaA", e.getMessage(),
			FacesMessage.SEVERITY_ERROR);
		} catch (BusinessException e) {
			REGISTER_ERROR();
			addMessageKey("msgsGentablaA", e.getMessage(),
			FacesMessage.SEVERITY_ERROR);
		} catch (Exception e) {
			REGISTER_ERROR();
			addErrorMessageKey("msgsGentablaA", e);
		}
	}

	public void setTemporalVars() throws Exception{
			gentabla.setGentipoVchtipcodigo(gentipoBusiness.selectByPrimaryKeyBasicFromList(gentabla.getVchtipcodigo(),listaGentipoVchtipcodigo));

	}
	public void aceptar() {
			REGISTER_INIT();
		try {
			if (accion.equals(REGISTRAR)){
				gentabla.setUsuariocreacionauditoria(getUserLogin());
				gentabla.setEquipoauditoria(getRemoteAddr());
				gentabla.setProgramaauditoria(pe.com.sisabas.resources.Utils.obtenerPrograma(this.getClass()));
				business.insertBasic(gentabla);
			}else{
				gentabla.setUsuariomodificacionauditoria(getUserLogin());
				gentabla.setEquipoauditoria(getRemoteAddr());
				gentabla.setProgramaauditoria(pe.com.sisabas.resources.Utils.obtenerPrograma(this.getClass()));
				business.updateByPrimaryKeyBasic(gentabla);
			}

			showGrowlMessageSuccessfullyCompletedAction();
			buscar();

			REGISTER_SUCCESS();
		} catch (ValidateException e) {
			REGISTER_ERROR();
			addMessageKey("msgsGentablaR", e.getMessage(),
			FacesMessage.SEVERITY_ERROR);
		} catch (BusinessException e) {
			REGISTER_ERROR();
			addMessageKey("msgsGentablaR", e.getMessage(),
			FacesMessage.SEVERITY_ERROR);
		} catch(DataIntegrityViolationException e) {
			addMessageKey("msgsForm", Messages.getString("exception.dataintegrity.message.title"),Messages.getString("exception.dataintegrity.message.detail"),
			FacesMessage.SEVERITY_ERROR);
		} catch (Exception e) {
			REGISTER_ERROR();
			addErrorMessageKey("msgsGentablaR", e);
		}
	}

	public void eliminar() {
		try {
			validateSelectedRow();
			gentabla.setUsuariomodificacionauditoria(getUserLogin());
			business.deleteByPrimaryKeyBasic(gentabla);
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
		if (selectedGentabla == null)
			throw new UnselectedRowException(Messages.getString("no.record.selected"));
		else
			gentabla = (Gentabla)selectedGentabla.clone();
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
		return "/pages/gentabla/gentablaBuscar.xhtml?faces-redirect=true";
	}

	public void resetRegisterForm(){
		reset("frmGentablaRegistrar:panelC");
	}
	public void resetAnulacionForm(){
		reset("frmGentablaAnular:panelDetailC");
	}


	public void updateCharToBoolean(Gentabla record) throws Exception {
		if( gentabla.getEstadoauditoria()!=null  && gentabla.getEstadoauditoria().equalsIgnoreCase("1")){
			gentabla.setBooleanestadoauditoria(true);
		}else {
			gentabla.setBooleanestadoauditoria(false);
		}

	}

	public void setGentabla(Gentabla gentabla){
		this.gentabla=gentabla;
	}

	public Gentabla getGentabla(){
		return gentabla;
	}

	public void setGentablaB(Gentabla gentablaB){
		this.gentablaB = gentablaB;
	}

	public Gentabla getGentablaB(){
		return gentablaB;
	}

	public void setSelectedGentabla(Gentabla selectedGentabla){
		this.selectedGentabla = selectedGentabla;
	}

	public Gentabla getSelectedGentabla(){
		return selectedGentabla;
	}

	public void setListaGentabla(List<Gentabla> listaGentabla){
		this.listaGentabla=listaGentabla;
	}

	public List<Gentabla> getListaGentabla(){
		return listaGentabla;
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

	public void setListaGentipoVchtipcodigo(List<Gentipo> listaGentipoVchtipcodigo){
		this.listaGentipoVchtipcodigo=listaGentipoVchtipcodigo;
	}

	public List<Gentipo> getListaGentipoVchtipcodigo(){
		return listaGentipoVchtipcodigo;
	}


	private List<String> listaVchtipcodigoKeys;
	private String valuesVchtipcodigo;
	public void handleChangeVchtipcodigo(ToggleSelectEvent toggle){
		if(toggle.isSelected()){
			addAllItemsVchtipcodigo();
		}else{
			listaVchtipcodigoKeys=new ArrayList<String>();
			valuesVchtipcodigo=Messages.getString("selectmanycheckbox.noitems");
		}
	}
	private void addAllItemsVchtipcodigo(){
		StringBuilder sbTmp=new StringBuilder("");
		listaVchtipcodigoKeys=new ArrayList<String>();
		for (Gentipo s : listaGentipoVchtipcodigo) {
			listaVchtipcodigoKeys.add(String.valueOf(s.getVchtipcodigo()));
			sbTmp.append(s.getVchtipdescripcion()+", ");
		}
		valuesVchtipcodigo=Utils.borrarComitaFinal(sbTmp.toString());
	}
	public void getValuesListenerVchtipcodigo(){
		StringBuilder sbTmp=new StringBuilder("");
		for (String key : listaVchtipcodigoKeys) {
			sbTmp.append(getValueVchtipcodigo(key)+", ");
		}
		valuesVchtipcodigo=Utils.borrarComitaFinal(sbTmp.toString());
		if(listaVchtipcodigoKeys.size()==0)
			valuesVchtipcodigo=Messages.getString("selectmanycheckbox.noitems");
	}
	private String getValueVchtipcodigo(String key){
		for (Gentipo s : listaGentipoVchtipcodigo) {
			if(String.valueOf(s.getVchtipcodigo()).equalsIgnoreCase(key))
				return s.getVchtipdescripcion().toString();
			}
		return "";
	}
	 public List<String> getListaVchtipcodigoKeys() {
		return listaVchtipcodigoKeys;
	}

	public void setListaVchtipcodigoKeys(List<String> listaVchtipcodigoKeys) {
		this.listaVchtipcodigoKeys = listaVchtipcodigoKeys;
	}

	 public String getValuesVchtipcodigo() {
		return valuesVchtipcodigo;
	}

	public void setValuesVchtipcodigo(String valuesVchtipcodigo) {
		this.valuesVchtipcodigo = valuesVchtipcodigo;
	}

///////////////////////////////



}

