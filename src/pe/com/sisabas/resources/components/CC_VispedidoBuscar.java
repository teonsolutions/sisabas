
package pe.com.sisabas.resources.components;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import pe.com.sisabas.resources.controller.BaseController;
import pe.com.sisabas.resources.Messages;
import pe.com.sisabas.resources.Constantes;
import pe.com.sisabas.be.Vispedido;
import pe.com.sisabas.business.VispedidoBusiness;



@Component(value ="cc_vispedido")
@Scope(value = "session")
public class CC_VispedidoBuscar extends BaseController {

	private static final long serialVersionUID = 1L;
	private Vispedido vispedidoB;
	private Vispedido selectedVispedido;
	private List<Vispedido> listaVispedido;


	@Autowired
	VispedidoBusiness business;



	public CC_VispedidoBuscar(){
			vispedidoB = new Vispedido();
			listaVispedido= new ArrayList<Vispedido>();
	}


	@PostConstruct
	public void init(){
		try {
			vispedidoB = new Vispedido();
			listaVispedido= new ArrayList<Vispedido>();

		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}

	public void init(String pk){
		try {
			vispedidoB = new Vispedido();
			pk=pk.substring(6);
			if(pk.length()>0){
				logger.debug("Init cc_vispedido:"+ pk);
				buscar();
			}
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}

	public void buscar() {
		try {
			logger.debug("cc.vispedido.buscar...");
			pe.com.sisabas.resources.Utils.convertPropertiesStringToUppercase(vispedidoB); //pasa a mayusculas los datos para la busqueda
			listaVispedido = business.selectDynamicFullActives(vispedidoB);
			if (listaVispedido.size() == 0)
			addMessageKey("msgsCC_Vispedido",
				Messages.getString("no.records.found"),
				FacesMessage.SEVERITY_INFO);
		} catch (Exception e) {
			addErrorMessageKey("msgsCC_Vispedido", e);
		}
	}

	public void setVispedidoB(Vispedido vispedidoB){
		this.vispedidoB = vispedidoB;
	}

	public Vispedido getVispedidoB(){
		return vispedidoB;
	}

	public void setSelectedVispedido(Vispedido selectedVispedido){
		this.selectedVispedido = selectedVispedido;
	}

	public Vispedido getSelectedVispedido(){
		return selectedVispedido;
	}

	public void setListaVispedido(List<Vispedido> listaVispedido){
		this.listaVispedido=listaVispedido;
	}

	public List<Vispedido> getListaVispedido(){
		return listaVispedido;
	}



}

