
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
import pe.com.sisabas.be.Unidadejecutora;
import pe.com.sisabas.business.UnidadejecutoraBusiness;



@Component(value ="cc_unidadejecutora")
@Scope(value = "session")
public class CC_UnidadejecutoraBuscar extends BaseController {

	private static final long serialVersionUID = 1L;
	private Unidadejecutora unidadejecutoraB;
	private Unidadejecutora selectedUnidadejecutora;
	private List<Unidadejecutora> listaUnidadejecutora;


	@Autowired
	UnidadejecutoraBusiness business;



	public CC_UnidadejecutoraBuscar(){
			unidadejecutoraB = new Unidadejecutora();
			listaUnidadejecutora= new ArrayList<Unidadejecutora>();
	}


	@PostConstruct
	public void init(){
		try {
			unidadejecutoraB = new Unidadejecutora();
			listaUnidadejecutora= new ArrayList<Unidadejecutora>();

		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}

	public void init(String pk){
		try {
			unidadejecutoraB = new Unidadejecutora();
			pk=pk.substring(6);
			if(pk.length()>0){
				logger.debug("Init cc_unidadejecutora:"+ pk);
				buscar();
			}
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}

	public void buscar() {
		try {
			logger.debug("cc.unidadejecutora.buscar...");
			pe.com.sisabas.resources.Utils.convertPropertiesStringToUppercase(unidadejecutoraB); //pasa a mayusculas los datos para la busqueda
			listaUnidadejecutora = business.selectDynamicFullActives(unidadejecutoraB);
			if (listaUnidadejecutora.size() == 0)
			addMessageKey("msgsCC_Unidadejecutora",
				Messages.getString("no.records.found"),
				FacesMessage.SEVERITY_INFO);
		} catch (Exception e) {
			addErrorMessageKey("msgsCC_Unidadejecutora", e);
		}
	}

	public void setUnidadejecutoraB(Unidadejecutora unidadejecutoraB){
		this.unidadejecutoraB = unidadejecutoraB;
	}

	public Unidadejecutora getUnidadejecutoraB(){
		return unidadejecutoraB;
	}

	public void setSelectedUnidadejecutora(Unidadejecutora selectedUnidadejecutora){
		this.selectedUnidadejecutora = selectedUnidadejecutora;
	}

	public Unidadejecutora getSelectedUnidadejecutora(){
		return selectedUnidadejecutora;
	}

	public void setListaUnidadejecutora(List<Unidadejecutora> listaUnidadejecutora){
		this.listaUnidadejecutora=listaUnidadejecutora;
	}

	public List<Unidadejecutora> getListaUnidadejecutora(){
		return listaUnidadejecutora;
	}



}

