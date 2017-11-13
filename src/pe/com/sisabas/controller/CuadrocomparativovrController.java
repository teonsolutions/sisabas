
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
import pe.com.sisabas.be.Cuadrocomparativovr;
import pe.com.sisabas.business.CuadrocomparativovrBusiness;
import pe.com.sisabas.business.GentablaBusiness;
import pe.com.sisabas.be.Gentabla;



@Component(value ="cuadrocomparativovr")
@Scope(value = "session")
public class CuadrocomparativovrController extends BaseController {

	private static final long serialVersionUID = 1L;
	private StreamedContent file;
	private Cuadrocomparativovr cuadrocomparativovrB;
	private Cuadrocomparativovr cuadrocomparativovr;
	private Cuadrocomparativovr selectedCuadrocomparativovr;
	private List<Cuadrocomparativovr> listaCuadrocomparativovr;
	public List<Gentabla> listaGentablaIdcatalogoprocedimientovr;

	private String accion;
	private String titulo;
	
	private String tituloBase; //titulo de la opcion
	private String tituloParam;//titulo que llega como parametro (derivada padre)
	
	private String esDerivada="0";
	
	@Autowired
	public pe.com.sisabas.resources.business.UtilsBusiness utilsBusiness;

	@Autowired
	public CuadrocomparativovrBusiness business;

	@Autowired
	public GentablaBusiness gentablaBusiness;



	//Nota: idOpcion, sicuopcion estan en BaseController
	private String idOpcionText = "OPC_CUADROCOMPARATIV";
	public CuadrocomparativovrController(){
			cuadrocomparativovr = new Cuadrocomparativovr();

	}


	@PostConstruct
	public void init(){
		try {
			cuadrocomparativovrB = new Cuadrocomparativovr();
			tituloBase = "CuadroComparativoVR » ";
			if(SICU_SECURITY_ENABLE){
				idOpcion   = SicuCallService.obtenerIdOpcion(idOpcionText).toString();
				sicuopcion = SicuCallService.obtenercontroles(idOpcion);
			}

			listaIdcatalogoprocedimientovrKeys= new ArrayList<String>();

			listaGentablaIdcatalogoprocedimientovr = gentablaBusiness.selectDynamicBasic(new Gentabla().getObjBusqueda(Constantes.tabla.PRVR));

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
			ordenListaCampos.add("A1.IDCUADROCOMPARATIVOVR");
			cuadrocomparativovrB.setOrdenListaCampos(ordenListaCampos);
			cuadrocomparativovrB.setOrdenTipo("DESC");

			//Add conditions IN clause
			cuadrocomparativovrB.addConditionInIdcatalogoprocedimientovr(listaIdcatalogoprocedimientovrKeys);

			pe.com.sisabas.resources.Utils.convertPropertiesStringToUppercase(cuadrocomparativovrB); //pasa a mayusculas los datos para la busqueda
			listaCuadrocomparativovr = business.selectDynamicFull(cuadrocomparativovrB);
			setEsSeleccionado(false);
			setSelectedCuadrocomparativovr(null);
			if (listaCuadrocomparativovr.size() == 0)
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
			titulo = "CuadroComparativoVR » " + REGISTRAR;
			cuadrocomparativovr = new Cuadrocomparativovr();


			cuadrocomparativovr.setIdcuadrocomparativovr(new java.lang.Integer(0));
			cuadrocomparativovr.setIdcuadrocomparativovr((int)utilsBusiness.getNextSeqTemporal(pe.com.sisabas.resources.Sequence.SEQ_CUADROCOMPARATIVOVR).longValue());

			cuadrocomparativovr.setIdcuadrocomparativoitem(cuadrocomparativovrB.getIdcuadrocomparativoitem());

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

	public void init(pe.com.sisabas.be.Cuadrocomparativoitem cuadrocomparativoitem) throws Exception{
		init();
		cuadrocomparativovrB.setIdcuadrocomparativoitem(cuadrocomparativoitem.getIdcuadrocomparativoitem());
		cuadrocomparativovrB.setCuadrocomparativoitemIdcuadrocomparativoitem(cuadrocomparativoitem);
		esDerivada = "1";
		buscar();
	}

	public void initDerivedTable(pe.com.sisabas.be.Cuadrocomparativoitem cuadrocomparativoitem) throws Exception{
		init();
		cuadrocomparativovrB.setIdcuadrocomparativoitem(cuadrocomparativoitem.getIdcuadrocomparativoitem());
		cuadrocomparativovrB.setCuadrocomparativoitemIdcuadrocomparativoitem(cuadrocomparativoitem);
		esDerivada = "1";
		buscar();
	}

	public void irEditar() {
		STATUS_INIT();
		try {
			securityControlValidate("btnEditar");
			resetRegisterForm();
			validateSelectedRow();
			updateCharToBoolean(cuadrocomparativovr);
			cuadrocomparativovr.roundBigDecimals();
			accion = EDITAR;
			titulo = "CuadroComparativoVR » " + EDITAR;


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
			cuadrocomparativovr.roundBigDecimals();
			accion = DETALLE;
			titulo = "CuadroComparativoVR » " + DETALLE;

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
			titulo = "CuadroComparativoVR » " + IMPRIMIR;

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
			if(cuadrocomparativovr.getEstadoauditoria().equals("1")){
				accion = ANULAR;
			}else{
				accion = ACTIVAR;
			}
			titulo = "CuadroComparativoVR » " + accion;

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
			Cuadrocomparativovr record= new Cuadrocomparativovr();
			if(cuadrocomparativovr.getEstadoauditoria().equals("1")){
				record.setEstadoauditoria("0");
			}else{
				record.setEstadoauditoria("1");
			}
			record.setIdcuadrocomparativovr(cuadrocomparativovr.getIdcuadrocomparativovr());
			record.setUsuariomodificacionauditoria(getUserLogin());
			business.updateByPrimaryKeySelectiveBasic(record);

			showGrowlMessageSuccessfullyCompletedAction();
			buscar();

			REGISTER_SUCCESS();
		} catch (ValidateException e) {
			REGISTER_ERROR();
			addMessageKey("msgsCuadrocomparativovrA", e.getMessage(),
			FacesMessage.SEVERITY_ERROR);
		} catch (BusinessException e) {
			REGISTER_ERROR();
			addMessageKey("msgsCuadrocomparativovrA", e.getMessage(),
			FacesMessage.SEVERITY_ERROR);
		} catch (Exception e) {
			REGISTER_ERROR();
			addErrorMessageKey("msgsCuadrocomparativovrA", e);
		}
	}

	public void setTemporalVars() throws Exception{
			cuadrocomparativovr.setGentablaIdcatalogoprocedimientovr(gentablaBusiness.selectByPrimaryKeyBasicFromList(cuadrocomparativovr.getIdcatalogoprocedimientovr(),listaGentablaIdcatalogoprocedimientovr));

	}
	public void aceptar() {
			REGISTER_INIT();
		try {
			if (accion.equals(REGISTRAR)){
				cuadrocomparativovr.setUsuariocreacionauditoria(getUserLogin());
				cuadrocomparativovr.setEquipoauditoria(getRemoteAddr());
				cuadrocomparativovr.setProgramaauditoria(pe.com.sisabas.resources.Utils.obtenerPrograma(this.getClass()));
				business.insertBasic(cuadrocomparativovr);
			}else{
				cuadrocomparativovr.setUsuariomodificacionauditoria(getUserLogin());
				cuadrocomparativovr.setEquipoauditoria(getRemoteAddr());
				cuadrocomparativovr.setProgramaauditoria(pe.com.sisabas.resources.Utils.obtenerPrograma(this.getClass()));
				business.updateByPrimaryKeyBasic(cuadrocomparativovr);
			}

			showGrowlMessageSuccessfullyCompletedAction();
			buscar();

			REGISTER_SUCCESS();
		} catch (ValidateException e) {
			REGISTER_ERROR();
			addMessageKey("msgsCuadrocomparativovrR", e.getMessage(),
			FacesMessage.SEVERITY_ERROR);
		} catch (BusinessException e) {
			REGISTER_ERROR();
			addMessageKey("msgsCuadrocomparativovrR", e.getMessage(),
			FacesMessage.SEVERITY_ERROR);
		} catch(DataIntegrityViolationException e) {
			addMessageKey("msgsForm", Messages.getString("exception.dataintegrity.message.title"),Messages.getString("exception.dataintegrity.message.detail"),
			FacesMessage.SEVERITY_ERROR);
		} catch (Exception e) {
			REGISTER_ERROR();
			addErrorMessageKey("msgsCuadrocomparativovrR", e);
		}
	}

	public void eliminar() {
		try {
			validateSelectedRow();
			cuadrocomparativovr.setUsuariomodificacionauditoria(getUserLogin());
			business.deleteByPrimaryKeyBasic(cuadrocomparativovr);
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
		if (selectedCuadrocomparativovr == null)
			throw new UnselectedRowException(Messages.getString("no.record.selected"));
		else
			cuadrocomparativovr = (Cuadrocomparativovr)selectedCuadrocomparativovr.clone();
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
		return "/pages/cuadrocomparativovr/cuadrocomparativovrBuscar.xhtml?faces-redirect=true";
	}

	public void resetRegisterForm(){
		reset("frmCuadrocomparativovrRegistrar:panelC");
	}
	public void resetAnulacionForm(){
		reset("frmCuadrocomparativovrAnular:panelDetailC");
	}


	public void updateCharToBoolean(Cuadrocomparativovr record) throws Exception {
	}

	public void setCuadrocomparativovr(Cuadrocomparativovr cuadrocomparativovr){
		this.cuadrocomparativovr=cuadrocomparativovr;
	}

	public Cuadrocomparativovr getCuadrocomparativovr(){
		return cuadrocomparativovr;
	}

	public void setCuadrocomparativovrB(Cuadrocomparativovr cuadrocomparativovrB){
		this.cuadrocomparativovrB = cuadrocomparativovrB;
	}

	public Cuadrocomparativovr getCuadrocomparativovrB(){
		return cuadrocomparativovrB;
	}

	public void setSelectedCuadrocomparativovr(Cuadrocomparativovr selectedCuadrocomparativovr){
		this.selectedCuadrocomparativovr = selectedCuadrocomparativovr;
	}

	public Cuadrocomparativovr getSelectedCuadrocomparativovr(){
		return selectedCuadrocomparativovr;
	}

	public void setListaCuadrocomparativovr(List<Cuadrocomparativovr> listaCuadrocomparativovr){
		this.listaCuadrocomparativovr=listaCuadrocomparativovr;
	}

	public List<Cuadrocomparativovr> getListaCuadrocomparativovr(){
		return listaCuadrocomparativovr;
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

	public void setListaGentablaIdcatalogoprocedimientovr(List<Gentabla> listaGentablaIdcatalogoprocedimientovr){
		this.listaGentablaIdcatalogoprocedimientovr=listaGentablaIdcatalogoprocedimientovr;
	}

	public List<Gentabla> getListaGentablaIdcatalogoprocedimientovr(){
		return listaGentablaIdcatalogoprocedimientovr;
	}


	private List<String> listaIdcatalogoprocedimientovrKeys;
	private String valuesIdcatalogoprocedimientovr;
	public void handleChangeIdcatalogoprocedimientovr(ToggleSelectEvent toggle){
		if(toggle.isSelected()){
			addAllItemsIdcatalogoprocedimientovr();
		}else{
			listaIdcatalogoprocedimientovrKeys=new ArrayList<String>();
			valuesIdcatalogoprocedimientovr=Messages.getString("selectmanycheckbox.noitems");
		}
	}
	private void addAllItemsIdcatalogoprocedimientovr(){
		StringBuilder sbTmp=new StringBuilder("");
		listaIdcatalogoprocedimientovrKeys=new ArrayList<String>();
		for (Gentabla s : listaGentablaIdcatalogoprocedimientovr) {
			listaIdcatalogoprocedimientovrKeys.add(String.valueOf(s.getVchregcodigo()));
			sbTmp.append(s.getVchregdescri()+", ");
		}
		valuesIdcatalogoprocedimientovr=Utils.borrarComitaFinal(sbTmp.toString());
	}
	public void getValuesListenerIdcatalogoprocedimientovr(){
		StringBuilder sbTmp=new StringBuilder("");
		for (String key : listaIdcatalogoprocedimientovrKeys) {
			sbTmp.append(getValueIdcatalogoprocedimientovr(key)+", ");
		}
		valuesIdcatalogoprocedimientovr=Utils.borrarComitaFinal(sbTmp.toString());
		if(listaIdcatalogoprocedimientovrKeys.size()==0)
			valuesIdcatalogoprocedimientovr=Messages.getString("selectmanycheckbox.noitems");
	}
	private String getValueIdcatalogoprocedimientovr(String key){
		for (Gentabla s : listaGentablaIdcatalogoprocedimientovr) {
			if(String.valueOf(s.getVchregcodigo()).equalsIgnoreCase(key))
				return s.getVchregdescri().toString();
			}
		return "";
	}
	 public List<String> getListaIdcatalogoprocedimientovrKeys() {
		return listaIdcatalogoprocedimientovrKeys;
	}

	public void setListaIdcatalogoprocedimientovrKeys(List<String> listaIdcatalogoprocedimientovrKeys) {
		this.listaIdcatalogoprocedimientovrKeys = listaIdcatalogoprocedimientovrKeys;
	}

	 public String getValuesIdcatalogoprocedimientovr() {
		return valuesIdcatalogoprocedimientovr;
	}

	public void setValuesIdcatalogoprocedimientovr(String valuesIdcatalogoprocedimientovr) {
		this.valuesIdcatalogoprocedimientovr = valuesIdcatalogoprocedimientovr;
	}

///////////////////////////////



}

