
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
import pe.com.sisabas.be.Pedidosporpacconsolidado;
import pe.com.sisabas.business.PedidosporpacconsolidadoBusiness;
import pe.com.sisabas.be.Pacconsolidado;
import pe.com.sisabas.be.Pedido;



@Component(value ="pedidosporpacconsolidado")
@Scope(value = "session")
public class PedidosporpacconsolidadoController extends BaseController {

	private static final long serialVersionUID = 1L;
	private StreamedContent file;
	private Pedidosporpacconsolidado pedidosporpacconsolidadoB;
	private Pedidosporpacconsolidado pedidosporpacconsolidado;
	private Pedidosporpacconsolidado selectedPedidosporpacconsolidado;
	private List<Pedidosporpacconsolidado> listaPedidosporpacconsolidado;

	private String accion;
	private String titulo;
	
	private String tituloBase; //titulo de la opcion
	private String tituloParam;//titulo que llega como parametro (derivada padre)
	
	private String esDerivada="0";
	
	@Autowired
	public pe.com.sisabas.resources.business.UtilsBusiness utilsBusiness;

	@Autowired
	public PedidosporpacconsolidadoBusiness business;



	//Nota: idOpcion, sicuopcion estan en BaseController
	private String idOpcionText = "OPC_PEDIDOSPORPACCON";
	public PedidosporpacconsolidadoController(){
			pedidosporpacconsolidado = new Pedidosporpacconsolidado();
			pedidosporpacconsolidado.setPacconsolidadoIdpacconsolidado(new Pacconsolidado());
			pedidosporpacconsolidado.setPedidoIdpedido(new Pedido());

	}


	@PostConstruct
	public void init(){
		try {
			pedidosporpacconsolidadoB = new Pedidosporpacconsolidado();
			tituloBase = "PedidosPorPacConsolidado » ";
			if(SICU_SECURITY_ENABLE){
				idOpcion   = SicuCallService.obtenerIdOpcion(idOpcionText).toString();
				sicuopcion = SicuCallService.obtenercontroles(idOpcion);
			}
			pedidosporpacconsolidadoB.setPacconsolidadoIdpacconsolidado(new Pacconsolidado());
			pedidosporpacconsolidadoB.setPedidoIdpedido(new Pedido());



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
			ordenListaCampos.add("A1.IDPEDIDOPORPACCONSOLIDADO");
			pedidosporpacconsolidadoB.setOrdenListaCampos(ordenListaCampos);
			pedidosporpacconsolidadoB.setOrdenTipo("DESC");

			//Add conditions IN clause

			pe.com.sisabas.resources.Utils.convertPropertiesStringToUppercase(pedidosporpacconsolidadoB); //pasa a mayusculas los datos para la busqueda
			listaPedidosporpacconsolidado = business.selectDynamicFull(pedidosporpacconsolidadoB);
			setEsSeleccionado(false);
			setSelectedPedidosporpacconsolidado(null);
			if (listaPedidosporpacconsolidado.size() == 0)
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
			titulo = "PedidosPorPacConsolidado » " + REGISTRAR;
			pedidosporpacconsolidado = new Pedidosporpacconsolidado();


			pedidosporpacconsolidado.setIdpedidoporpacconsolidado(new java.lang.Integer(0));
			pedidosporpacconsolidado.setIdpedidoporpacconsolidado((int)utilsBusiness.getNextSeqTemporal(pe.com.sisabas.resources.Sequence.SEQ_PEDIDOSPORPACCONSOLIDADO).longValue());
			pedidosporpacconsolidado.setPacconsolidadoIdpacconsolidado(new Pacconsolidado());
			pedidosporpacconsolidado.setPedidoIdpedido(new Pedido());


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
			updateCharToBoolean(pedidosporpacconsolidado);
			pedidosporpacconsolidado.roundBigDecimals();
			accion = EDITAR;
			titulo = "PedidosPorPacConsolidado » " + EDITAR;


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
			pedidosporpacconsolidado.roundBigDecimals();
			accion = DETALLE;
			titulo = "PedidosPorPacConsolidado » " + DETALLE;

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
			titulo = "PedidosPorPacConsolidado » " + IMPRIMIR;

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
			if(pedidosporpacconsolidado.getEstadoauditoria().equals("1")){
				accion = ANULAR;
			}else{
				accion = ACTIVAR;
			}
			titulo = "PedidosPorPacConsolidado » " + accion;

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
			Pedidosporpacconsolidado record= new Pedidosporpacconsolidado();
			if(pedidosporpacconsolidado.getEstadoauditoria().equals("1")){
				record.setEstadoauditoria("0");
			}else{
				record.setEstadoauditoria("1");
			}
			record.setIdpedidoporpacconsolidado(pedidosporpacconsolidado.getIdpedidoporpacconsolidado());
			business.updateByPrimaryKeySelectiveBasic(record);

			showGrowlMessageSuccessfullyCompletedAction();
			buscar();

			REGISTER_SUCCESS();
		} catch (ValidateException e) {
			REGISTER_ERROR();
			addMessageKey("msgsPedidosporpacconsolidadoA", e.getMessage(),
			FacesMessage.SEVERITY_ERROR);
		} catch (BusinessException e) {
			REGISTER_ERROR();
			addMessageKey("msgsPedidosporpacconsolidadoA", e.getMessage(),
			FacesMessage.SEVERITY_ERROR);
		} catch (Exception e) {
			REGISTER_ERROR();
			addErrorMessageKey("msgsPedidosporpacconsolidadoA", e);
		}
	}

	public void setTemporalVars() throws Exception{

	}
	public void aceptar() {
			REGISTER_INIT();
		try {
			if (accion.equals(REGISTRAR)){
				pedidosporpacconsolidado.setUsuariocreacionauditoria(getUserLogin());
				pedidosporpacconsolidado.setEquipoauditoria(getRemoteAddr());
				pedidosporpacconsolidado.setProgramaauditoria(pe.com.sisabas.resources.Utils.obtenerPrograma(this.getClass()));
				business.insertBasic(pedidosporpacconsolidado);
			}else{
				pedidosporpacconsolidado.setEquipoauditoria(getRemoteAddr());
				pedidosporpacconsolidado.setProgramaauditoria(pe.com.sisabas.resources.Utils.obtenerPrograma(this.getClass()));
				business.updateByPrimaryKeyBasic(pedidosporpacconsolidado);
			}

			showGrowlMessageSuccessfullyCompletedAction();
			buscar();

			REGISTER_SUCCESS();
		} catch (ValidateException e) {
			REGISTER_ERROR();
			addMessageKey("msgsPedidosporpacconsolidadoR", e.getMessage(),
			FacesMessage.SEVERITY_ERROR);
		} catch (BusinessException e) {
			REGISTER_ERROR();
			addMessageKey("msgsPedidosporpacconsolidadoR", e.getMessage(),
			FacesMessage.SEVERITY_ERROR);
		} catch(DataIntegrityViolationException e) {
			addMessageKey("msgsForm", Messages.getString("exception.dataintegrity.message.title"),Messages.getString("exception.dataintegrity.message.detail"),
			FacesMessage.SEVERITY_ERROR);
		} catch (Exception e) {
			REGISTER_ERROR();
			addErrorMessageKey("msgsPedidosporpacconsolidadoR", e);
		}
	}

	public void eliminar() {
		try {
			validateSelectedRow();
			business.deleteByPrimaryKeyBasic(pedidosporpacconsolidado);
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
		if (selectedPedidosporpacconsolidado == null)
			throw new UnselectedRowException(Messages.getString("no.record.selected"));
		else
			pedidosporpacconsolidado = (Pedidosporpacconsolidado)selectedPedidosporpacconsolidado.clone();
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
			logger.debug("loadpedidosporpacconsolidado.event...:"+item.getIdpacconsolidado());
			pedidosporpacconsolidadoB.setIdpacconsolidado(item.getIdpacconsolidado());
			pedidosporpacconsolidadoB.setPacconsolidadoIdpacconsolidado(item);
			logger.debug("loadPacconsolidado.event...ok");
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}

	public void loadRegIdpacconsolidado(org.primefaces.event.SelectEvent event) {
		try {
			logger.debug("loadRegPacconsolidado.event...");
			pe.com.sisabas.be.Pacconsolidado item= (pe.com.sisabas.be.Pacconsolidado) event.getObject();
			logger.debug("loadpedidosporpacconsolidado.event...:"+item.getIdpacconsolidado());
			pedidosporpacconsolidado.setIdpacconsolidado(item.getIdpacconsolidado());
			pedidosporpacconsolidado.setPacconsolidadoIdpacconsolidado(item);
			logger.debug("loadPacconsolidado.event...ok");
			resetRegisterForm();
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}

	public void resetMainIdpacconsolidado() {
		try {
			pedidosporpacconsolidadoB.setIdpacconsolidado(null);
			pedidosporpacconsolidadoB.setPacconsolidadoIdpacconsolidado(new Pacconsolidado());
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}
	public void resetRegIdpacconsolidado() {
		try {
			pedidosporpacconsolidado.setIdpacconsolidado(null);
			pedidosporpacconsolidado.setPacconsolidadoIdpacconsolidado(new Pacconsolidado());
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}
	public void loadMainIdpedido(org.primefaces.event.SelectEvent event) {
		try {
			logger.debug("loadMainPedido.event...");
			pe.com.sisabas.be.Pedido item= (pe.com.sisabas.be.Pedido) event.getObject();
			logger.debug("loadpedidosporpacconsolidado.event...:"+item.getIdpedido());
			pedidosporpacconsolidadoB.setIdpedido(item.getIdpedido());
			pedidosporpacconsolidadoB.setPedidoIdpedido(item);
			logger.debug("loadPedido.event...ok");
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}

	public void loadRegIdpedido(org.primefaces.event.SelectEvent event) {
		try {
			logger.debug("loadRegPedido.event...");
			pe.com.sisabas.be.Pedido item= (pe.com.sisabas.be.Pedido) event.getObject();
			logger.debug("loadpedidosporpacconsolidado.event...:"+item.getIdpedido());
			pedidosporpacconsolidado.setIdpedido(item.getIdpedido());
			pedidosporpacconsolidado.setPedidoIdpedido(item);
			logger.debug("loadPedido.event...ok");
			resetRegisterForm();
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}

	public void resetMainIdpedido() {
		try {
			pedidosporpacconsolidadoB.setIdpedido(null);
			pedidosporpacconsolidadoB.setPedidoIdpedido(new Pedido());
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}
	public void resetRegIdpedido() {
		try {
			pedidosporpacconsolidado.setIdpedido(null);
			pedidosporpacconsolidado.setPedidoIdpedido(new Pedido());
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}



	public String loadPage(){
		buscar();
		return "/pages/pedidosporpacconsolidado/pedidosporpacconsolidadoBuscar.xhtml?faces-redirect=true";
	}

	public void resetRegisterForm(){
		reset("frmPedidosporpacconsolidadoRegistrar:panelC");
	}
	public void resetAnulacionForm(){
		reset("frmPedidosporpacconsolidadoAnular:panelDetailC");
	}


	public void updateCharToBoolean(Pedidosporpacconsolidado record) throws Exception {
	}

	public void setPedidosporpacconsolidado(Pedidosporpacconsolidado pedidosporpacconsolidado){
		this.pedidosporpacconsolidado=pedidosporpacconsolidado;
	}

	public Pedidosporpacconsolidado getPedidosporpacconsolidado(){
		return pedidosporpacconsolidado;
	}

	public void setPedidosporpacconsolidadoB(Pedidosporpacconsolidado pedidosporpacconsolidadoB){
		this.pedidosporpacconsolidadoB = pedidosporpacconsolidadoB;
	}

	public Pedidosporpacconsolidado getPedidosporpacconsolidadoB(){
		return pedidosporpacconsolidadoB;
	}

	public void setSelectedPedidosporpacconsolidado(Pedidosporpacconsolidado selectedPedidosporpacconsolidado){
		this.selectedPedidosporpacconsolidado = selectedPedidosporpacconsolidado;
	}

	public Pedidosporpacconsolidado getSelectedPedidosporpacconsolidado(){
		return selectedPedidosporpacconsolidado;
	}

	public void setListaPedidosporpacconsolidado(List<Pedidosporpacconsolidado> listaPedidosporpacconsolidado){
		this.listaPedidosporpacconsolidado=listaPedidosporpacconsolidado;
	}

	public List<Pedidosporpacconsolidado> getListaPedidosporpacconsolidado(){
		return listaPedidosporpacconsolidado;
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

