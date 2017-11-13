
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
import pe.com.sisabas.be.Etapagestionadministrativa;
import pe.com.sisabas.business.EtapagestionadministrativaBusiness;



@Component(value ="cc_etapagestionadministrativa")
@Scope(value = "session")
public class CC_EtapagestionadministrativaBuscar extends BaseController {

	private static final long serialVersionUID = 1L;
	private Etapagestionadministrativa etapagestionadministrativaB;
	private Etapagestionadministrativa selectedEtapagestionadministrativa;
	private List<Etapagestionadministrativa> listaEtapagestionadministrativa;


	@Autowired
	EtapagestionadministrativaBusiness business;



	public CC_EtapagestionadministrativaBuscar(){
			etapagestionadministrativaB = new Etapagestionadministrativa();
			listaEtapagestionadministrativa= new ArrayList<Etapagestionadministrativa>();
	}


	@PostConstruct
	public void init(){
		try {
			etapagestionadministrativaB = new Etapagestionadministrativa();
			listaEtapagestionadministrativa= new ArrayList<Etapagestionadministrativa>();

		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}

	public void init(String pk){
		try {
			etapagestionadministrativaB = new Etapagestionadministrativa();
			pk=pk.substring(6);
			if(pk.length()>0){
				logger.debug("Init cc_etapagestionadministrativa:"+ pk);
				buscar();
			}
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}

	public void buscar() {
		try {
			logger.debug("cc.etapagestionadministrativa.buscar...");
			pe.com.sisabas.resources.Utils.convertPropertiesStringToUppercase(etapagestionadministrativaB); //pasa a mayusculas los datos para la busqueda
			listaEtapagestionadministrativa = business.selectDynamicFullActives(etapagestionadministrativaB);
			if (listaEtapagestionadministrativa.size() == 0)
			addMessageKey("msgsCC_Etapagestionadministrativa",
				Messages.getString("no.records.found"),
				FacesMessage.SEVERITY_INFO);
		} catch (Exception e) {
			addErrorMessageKey("msgsCC_Etapagestionadministrativa", e);
		}
	}

	public void setEtapagestionadministrativaB(Etapagestionadministrativa etapagestionadministrativaB){
		this.etapagestionadministrativaB = etapagestionadministrativaB;
	}

	public Etapagestionadministrativa getEtapagestionadministrativaB(){
		return etapagestionadministrativaB;
	}

	public void setSelectedEtapagestionadministrativa(Etapagestionadministrativa selectedEtapagestionadministrativa){
		this.selectedEtapagestionadministrativa = selectedEtapagestionadministrativa;
	}

	public Etapagestionadministrativa getSelectedEtapagestionadministrativa(){
		return selectedEtapagestionadministrativa;
	}

	public void setListaEtapagestionadministrativa(List<Etapagestionadministrativa> listaEtapagestionadministrativa){
		this.listaEtapagestionadministrativa=listaEtapagestionadministrativa;
	}

	public List<Etapagestionadministrativa> getListaEtapagestionadministrativa(){
		return listaEtapagestionadministrativa;
	}



}

