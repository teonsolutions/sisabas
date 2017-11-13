
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
import pe.com.sisabas.be.Estadospordocumentosiga;
import pe.com.sisabas.business.EstadospordocumentosigaBusiness;
import pe.com.sisabas.business.GentablaBusiness;
import pe.com.sisabas.be.Gentabla;



@Component(value ="estadospordocumentosiga")
@Scope(value = "session")
public class EstadospordocumentosigaController extends BaseController {

	private static final long serialVersionUID = 1L;
	private StreamedContent file;
	private Estadospordocumentosiga estadospordocumentosigaB;
	private Estadospordocumentosiga estadospordocumentosiga;
	private Estadospordocumentosiga selectedEstadospordocumentosiga;
	private List<Estadospordocumentosiga> listaEstadospordocumentosiga;
	public List<Gentabla> listaGentablaIdcatalogotipodocumentosiga;

	private String accion;
	private String titulo;
	
	private String tituloBase; //titulo de la opcion
	private String tituloParam;//titulo que llega como parametro (derivada padre)
	
	private String esDerivada="0";
	
	@Autowired
	public pe.com.sisabas.resources.business.UtilsBusiness utilsBusiness;

	@Autowired
	public EstadospordocumentosigaBusiness business;

	@Autowired
	public GentablaBusiness gentablaBusiness;



	//Nota: idOpcion, sicuopcion estan en BaseController
	private String idOpcionText = "OPC_ESTADOSPORDOCUME";
	public EstadospordocumentosigaController(){
			estadospordocumentosiga = new Estadospordocumentosiga();

	}


	@PostConstruct
	public void init(){
		try {
			estadospordocumentosigaB = new Estadospordocumentosiga();
			tituloBase = "Estados por documento Siga » ";
			if(SICU_SECURITY_ENABLE){
				idOpcion   = SicuCallService.obtenerIdOpcion(idOpcionText).toString();
				sicuopcion = SicuCallService.obtenercontroles(idOpcion);
			}

			listaIdcatalogotipodocumentosigaKeys= new ArrayList<String>();

			listaGentablaIdcatalogotipodocumentosiga = gentablaBusiness.selectDynamicBasic(new Gentabla());

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
			ordenListaCampos.add("A1.IDESTADOSPORDOCUMENTOSIGA");
			estadospordocumentosigaB.setOrdenListaCampos(ordenListaCampos);
			estadospordocumentosigaB.setOrdenTipo("DESC");

			//Add conditions IN clause
			estadospordocumentosigaB.addConditionInIdcatalogotipodocumentosiga(listaIdcatalogotipodocumentosigaKeys);

			pe.com.sisabas.resources.Utils.convertPropertiesStringToUppercase(estadospordocumentosigaB); //pasa a mayusculas los datos para la busqueda
			listaEstadospordocumentosiga = business.selectDynamicFull(estadospordocumentosigaB);
			setEsSeleccionado(false);
			setSelectedEstadospordocumentosiga(null);
			if (listaEstadospordocumentosiga.size() == 0)
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
			titulo = "Estados por documento Siga » " + REGISTRAR;
			estadospordocumentosiga = new Estadospordocumentosiga();


			estadospordocumentosiga.setIdestadospordocumentosiga(new java.lang.Integer(0));
			estadospordocumentosiga.setIdestadospordocumentosiga((int)utilsBusiness.getNextSeqTemporal(pe.com.sisabas.resources.Sequence.SEQ_ESTADOSPORDOCUMENTOSIGA).longValue());


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
			updateCharToBoolean(estadospordocumentosiga);
			estadospordocumentosiga.roundBigDecimals();
			accion = EDITAR;
			titulo = "Estados por documento Siga » " + EDITAR;


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
			estadospordocumentosiga.roundBigDecimals();
			accion = DETALLE;
			titulo = "Estados por documento Siga » " + DETALLE;

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
			titulo = "Estados por documento Siga » " + IMPRIMIR;

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
			if(estadospordocumentosiga.getEstadoauditoria().equals("1")){
				accion = ANULAR;
			}else{
				accion = ACTIVAR;
			}
			titulo = "Estados por documento Siga » " + accion;

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
			Estadospordocumentosiga record= new Estadospordocumentosiga();
			if(estadospordocumentosiga.getEstadoauditoria().equals("1")){
				record.setEstadoauditoria("0");
			}else{
				record.setEstadoauditoria("1");
			}
			record.setIdestadospordocumentosiga(estadospordocumentosiga.getIdestadospordocumentosiga());
			record.setUsuariomodificacionauditoria(getUserLogin());
			business.updateByPrimaryKeySelectiveBasic(record);

			showGrowlMessageSuccessfullyCompletedAction();
			buscar();

			REGISTER_SUCCESS();
		} catch (ValidateException e) {
			REGISTER_ERROR();
			addMessageKey("msgsEstadospordocumentosigaA", e.getMessage(),
			FacesMessage.SEVERITY_ERROR);
		} catch (BusinessException e) {
			REGISTER_ERROR();
			addMessageKey("msgsEstadospordocumentosigaA", e.getMessage(),
			FacesMessage.SEVERITY_ERROR);
		} catch (Exception e) {
			REGISTER_ERROR();
			addErrorMessageKey("msgsEstadospordocumentosigaA", e);
		}
	}

	public void setTemporalVars() throws Exception{
			estadospordocumentosiga.setGentablaIdcatalogotipodocumentosiga(gentablaBusiness.selectByPrimaryKeyBasicFromList(estadospordocumentosiga.getIdcatalogotipodocumentosiga(),listaGentablaIdcatalogotipodocumentosiga));

	}
	public void aceptar() {
			REGISTER_INIT();
		try {
			if (accion.equals(REGISTRAR)){
				estadospordocumentosiga.setUsuariocreacionauditoria(getUserLogin());
				estadospordocumentosiga.setEquipoauditoria(getRemoteAddr());
				estadospordocumentosiga.setProgramaauditoria(pe.com.sisabas.resources.Utils.obtenerPrograma(this.getClass()));
				business.insertBasic(estadospordocumentosiga);
			}else{
				estadospordocumentosiga.setUsuariomodificacionauditoria(getUserLogin());
				estadospordocumentosiga.setEquipoauditoria(getRemoteAddr());
				estadospordocumentosiga.setProgramaauditoria(pe.com.sisabas.resources.Utils.obtenerPrograma(this.getClass()));
				business.updateByPrimaryKeyBasic(estadospordocumentosiga);
			}

			showGrowlMessageSuccessfullyCompletedAction();
			buscar();

			REGISTER_SUCCESS();
		} catch (ValidateException e) {
			REGISTER_ERROR();
			addMessageKey("msgsEstadospordocumentosigaR", e.getMessage(),
			FacesMessage.SEVERITY_ERROR);
		} catch (BusinessException e) {
			REGISTER_ERROR();
			addMessageKey("msgsEstadospordocumentosigaR", e.getMessage(),
			FacesMessage.SEVERITY_ERROR);
		} catch(DataIntegrityViolationException e) {
			addMessageKey("msgsForm", Messages.getString("exception.dataintegrity.message.title"),Messages.getString("exception.dataintegrity.message.detail"),
			FacesMessage.SEVERITY_ERROR);
		} catch (Exception e) {
			REGISTER_ERROR();
			addErrorMessageKey("msgsEstadospordocumentosigaR", e);
		}
	}

	public void eliminar() {
		try {
			validateSelectedRow();
			estadospordocumentosiga.setUsuariomodificacionauditoria(getUserLogin());
			business.deleteByPrimaryKeyBasic(estadospordocumentosiga);
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
		if (selectedEstadospordocumentosiga == null)
			throw new UnselectedRowException(Messages.getString("no.record.selected"));
		else
			estadospordocumentosiga = (Estadospordocumentosiga)selectedEstadospordocumentosiga.clone();
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
		return "/pages/estadospordocumentosiga/estadospordocumentosigaBuscar.xhtml?faces-redirect=true";
	}

	public void resetRegisterForm(){
		reset("frmEstadospordocumentosigaRegistrar:panelC");
	}
	public void resetAnulacionForm(){
		reset("frmEstadospordocumentosigaAnular:panelDetailC");
	}


	public void updateCharToBoolean(Estadospordocumentosiga record) throws Exception {
	}

	public void setEstadospordocumentosiga(Estadospordocumentosiga estadospordocumentosiga){
		this.estadospordocumentosiga=estadospordocumentosiga;
	}

	public Estadospordocumentosiga getEstadospordocumentosiga(){
		return estadospordocumentosiga;
	}

	public void setEstadospordocumentosigaB(Estadospordocumentosiga estadospordocumentosigaB){
		this.estadospordocumentosigaB = estadospordocumentosigaB;
	}

	public Estadospordocumentosiga getEstadospordocumentosigaB(){
		return estadospordocumentosigaB;
	}

	public void setSelectedEstadospordocumentosiga(Estadospordocumentosiga selectedEstadospordocumentosiga){
		this.selectedEstadospordocumentosiga = selectedEstadospordocumentosiga;
	}

	public Estadospordocumentosiga getSelectedEstadospordocumentosiga(){
		return selectedEstadospordocumentosiga;
	}

	public void setListaEstadospordocumentosiga(List<Estadospordocumentosiga> listaEstadospordocumentosiga){
		this.listaEstadospordocumentosiga=listaEstadospordocumentosiga;
	}

	public List<Estadospordocumentosiga> getListaEstadospordocumentosiga(){
		return listaEstadospordocumentosiga;
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

	public void setListaGentablaIdcatalogotipodocumentosiga(List<Gentabla> listaGentablaIdcatalogotipodocumentosiga){
		this.listaGentablaIdcatalogotipodocumentosiga=listaGentablaIdcatalogotipodocumentosiga;
	}

	public List<Gentabla> getListaGentablaIdcatalogotipodocumentosiga(){
		return listaGentablaIdcatalogotipodocumentosiga;
	}


	private List<String> listaIdcatalogotipodocumentosigaKeys;
	private String valuesIdcatalogotipodocumentosiga;
	public void handleChangeIdcatalogotipodocumentosiga(ToggleSelectEvent toggle){
		if(toggle.isSelected()){
			addAllItemsIdcatalogotipodocumentosiga();
		}else{
			listaIdcatalogotipodocumentosigaKeys=new ArrayList<String>();
			valuesIdcatalogotipodocumentosiga=Messages.getString("selectmanycheckbox.noitems");
		}
	}
	private void addAllItemsIdcatalogotipodocumentosiga(){
		StringBuilder sbTmp=new StringBuilder("");
		listaIdcatalogotipodocumentosigaKeys=new ArrayList<String>();
		for (Gentabla s : listaGentablaIdcatalogotipodocumentosiga) {
			listaIdcatalogotipodocumentosigaKeys.add(String.valueOf(s.getVchregcodigo()));
			sbTmp.append(s.getVchregdescri()+", ");
		}
		valuesIdcatalogotipodocumentosiga=Utils.borrarComitaFinal(sbTmp.toString());
	}
	public void getValuesListenerIdcatalogotipodocumentosiga(){
		StringBuilder sbTmp=new StringBuilder("");
		for (String key : listaIdcatalogotipodocumentosigaKeys) {
			sbTmp.append(getValueIdcatalogotipodocumentosiga(key)+", ");
		}
		valuesIdcatalogotipodocumentosiga=Utils.borrarComitaFinal(sbTmp.toString());
		if(listaIdcatalogotipodocumentosigaKeys.size()==0)
			valuesIdcatalogotipodocumentosiga=Messages.getString("selectmanycheckbox.noitems");
	}
	private String getValueIdcatalogotipodocumentosiga(String key){
		for (Gentabla s : listaGentablaIdcatalogotipodocumentosiga) {
			if(String.valueOf(s.getVchregcodigo()).equalsIgnoreCase(key))
				return s.getVchregdescri().toString();
			}
		return "";
	}
	 public List<String> getListaIdcatalogotipodocumentosigaKeys() {
		return listaIdcatalogotipodocumentosigaKeys;
	}

	public void setListaIdcatalogotipodocumentosigaKeys(List<String> listaIdcatalogotipodocumentosigaKeys) {
		this.listaIdcatalogotipodocumentosigaKeys = listaIdcatalogotipodocumentosigaKeys;
	}

	 public String getValuesIdcatalogotipodocumentosiga() {
		return valuesIdcatalogotipodocumentosiga;
	}

	public void setValuesIdcatalogotipodocumentosiga(String valuesIdcatalogotipodocumentosiga) {
		this.valuesIdcatalogotipodocumentosiga = valuesIdcatalogotipodocumentosiga;
	}

///////////////////////////////



}

