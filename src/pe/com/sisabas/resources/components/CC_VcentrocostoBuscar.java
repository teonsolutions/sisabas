
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
import pe.com.sisabas.be.Vcentrocosto;
import pe.com.sisabas.business.VcentrocostoBusiness;



@Component(value ="cc_vcentrocosto")
@Scope(value = "session")
public class CC_VcentrocostoBuscar extends BaseController {

	private static final long serialVersionUID = 1L;
	private Vcentrocosto vcentrocostoB;
	private Vcentrocosto selectedVcentrocosto;
	private List<Vcentrocosto> listaVcentrocosto;


	@Autowired
	VcentrocostoBusiness business;



	public CC_VcentrocostoBuscar(){
			vcentrocostoB = new Vcentrocosto();
			listaVcentrocosto= new ArrayList<Vcentrocosto>();
	}


	@PostConstruct
	public void init(){
		try {
			vcentrocostoB = new Vcentrocosto();
			listaVcentrocosto= new ArrayList<Vcentrocosto>();

		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}

	public void init(String pk){
		try {
			vcentrocostoB = new Vcentrocosto();
			pk=pk.substring(6);
			if(pk.length()>0){
				logger.debug("Init cc_vcentrocosto:"+ pk);
				buscar();
			}
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}

	public void buscar() {
		try {
			logger.debug("cc.vcentrocosto.buscar...");
			pe.com.sisabas.resources.Utils.convertPropertiesStringToUppercase(vcentrocostoB); //pasa a mayusculas los datos para la busqueda
			listaVcentrocosto = business.selectDynamicFullActives(vcentrocostoB);
			if (listaVcentrocosto.size() == 0)
			addMessageKey("msgsCC_Vcentrocosto",
				Messages.getString("no.records.found"),
				FacesMessage.SEVERITY_INFO);
		} catch (Exception e) {
			addErrorMessageKey("msgsCC_Vcentrocosto", e);
		}
	}

	public void setVcentrocostoB(Vcentrocosto vcentrocostoB){
		this.vcentrocostoB = vcentrocostoB;
	}

	public Vcentrocosto getVcentrocostoB(){
		return vcentrocostoB;
	}

	public void setSelectedVcentrocosto(Vcentrocosto selectedVcentrocosto){
		this.selectedVcentrocosto = selectedVcentrocosto;
	}

	public Vcentrocosto getSelectedVcentrocosto(){
		return selectedVcentrocosto;
	}

	public void setListaVcentrocosto(List<Vcentrocosto> listaVcentrocosto){
		this.listaVcentrocosto=listaVcentrocosto;
	}

	public List<Vcentrocosto> getListaVcentrocosto(){
		return listaVcentrocosto;
	}



}

