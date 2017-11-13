
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
import pe.com.sisabas.be.Comiteproceso;
import pe.com.sisabas.business.ComiteprocesoBusiness;



@Component(value ="cc_comiteproceso")
@Scope(value = "session")
public class CC_ComiteprocesoBuscar extends BaseController {

	private static final long serialVersionUID = 1L;
	private Comiteproceso comiteprocesoB;
	private Comiteproceso selectedComiteproceso;
	private List<Comiteproceso> listaComiteproceso;


	@Autowired
	ComiteprocesoBusiness business;



	public CC_ComiteprocesoBuscar(){
			comiteprocesoB = new Comiteproceso();
			listaComiteproceso= new ArrayList<Comiteproceso>();
	}


	@PostConstruct
	public void init(){
		try {
			comiteprocesoB = new Comiteproceso();
			listaComiteproceso= new ArrayList<Comiteproceso>();

		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}

	public void init(String pk){
		try {
			comiteprocesoB = new Comiteproceso();
			pk=pk.substring(6);
			if(pk.length()>0){
				logger.debug("Init cc_comiteproceso:"+ pk);
				buscar();
			}
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}

	public void buscar() {
		try {
			logger.debug("cc.comiteproceso.buscar...");
			pe.com.sisabas.resources.Utils.convertPropertiesStringToUppercase(comiteprocesoB); //pasa a mayusculas los datos para la busqueda
			listaComiteproceso = business.selectDynamicFullActives(comiteprocesoB);
			if (listaComiteproceso.size() == 0)
			addMessageKey("msgsCC_Comiteproceso",
				Messages.getString("no.records.found"),
				FacesMessage.SEVERITY_INFO);
		} catch (Exception e) {
			addErrorMessageKey("msgsCC_Comiteproceso", e);
		}
	}

	public void setComiteprocesoB(Comiteproceso comiteprocesoB){
		this.comiteprocesoB = comiteprocesoB;
	}

	public Comiteproceso getComiteprocesoB(){
		return comiteprocesoB;
	}

	public void setSelectedComiteproceso(Comiteproceso selectedComiteproceso){
		this.selectedComiteproceso = selectedComiteproceso;
	}

	public Comiteproceso getSelectedComiteproceso(){
		return selectedComiteproceso;
	}

	public void setListaComiteproceso(List<Comiteproceso> listaComiteproceso){
		this.listaComiteproceso=listaComiteproceso;
	}

	public List<Comiteproceso> getListaComiteproceso(){
		return listaComiteproceso;
	}



}

