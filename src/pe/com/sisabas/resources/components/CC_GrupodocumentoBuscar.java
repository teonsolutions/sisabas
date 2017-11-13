
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
import pe.com.sisabas.be.Grupodocumento;
import pe.com.sisabas.business.GrupodocumentoBusiness;



@Component(value ="cc_grupodocumento")
@Scope(value = "session")
public class CC_GrupodocumentoBuscar extends BaseController {

	private static final long serialVersionUID = 1L;
	private Grupodocumento grupodocumentoB;
	private Grupodocumento selectedGrupodocumento;
	private List<Grupodocumento> listaGrupodocumento;


	@Autowired
	GrupodocumentoBusiness business;



	public CC_GrupodocumentoBuscar(){
			grupodocumentoB = new Grupodocumento();
			listaGrupodocumento= new ArrayList<Grupodocumento>();
	}


	@PostConstruct
	public void init(){
		try {
			grupodocumentoB = new Grupodocumento();
			listaGrupodocumento= new ArrayList<Grupodocumento>();

		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}

	public void init(String pk){
		try {
			grupodocumentoB = new Grupodocumento();
			pk=pk.substring(6);
			if(pk.length()>0){
				logger.debug("Init cc_grupodocumento:"+ pk);
				buscar();
			}
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}

	public void buscar() {
		try {
			logger.debug("cc.grupodocumento.buscar...");
			pe.com.sisabas.resources.Utils.convertPropertiesStringToUppercase(grupodocumentoB); //pasa a mayusculas los datos para la busqueda
			listaGrupodocumento = business.selectDynamicFullActives(grupodocumentoB);
			if (listaGrupodocumento.size() == 0)
			addMessageKey("msgsCC_Grupodocumento",
				Messages.getString("no.records.found"),
				FacesMessage.SEVERITY_INFO);
		} catch (Exception e) {
			addErrorMessageKey("msgsCC_Grupodocumento", e);
		}
	}

	public void setGrupodocumentoB(Grupodocumento grupodocumentoB){
		this.grupodocumentoB = grupodocumentoB;
	}

	public Grupodocumento getGrupodocumentoB(){
		return grupodocumentoB;
	}

	public void setSelectedGrupodocumento(Grupodocumento selectedGrupodocumento){
		this.selectedGrupodocumento = selectedGrupodocumento;
	}

	public Grupodocumento getSelectedGrupodocumento(){
		return selectedGrupodocumento;
	}

	public void setListaGrupodocumento(List<Grupodocumento> listaGrupodocumento){
		this.listaGrupodocumento=listaGrupodocumento;
	}

	public List<Grupodocumento> getListaGrupodocumento(){
		return listaGrupodocumento;
	}



}

