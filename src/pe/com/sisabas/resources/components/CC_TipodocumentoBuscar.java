
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
import pe.com.sisabas.be.Tipodocumento;
import pe.com.sisabas.business.TipodocumentoBusiness;



@Component(value ="cc_tipodocumento")
@Scope(value = "session")
public class CC_TipodocumentoBuscar extends BaseController {

	private static final long serialVersionUID = 1L;
	private Tipodocumento tipodocumentoB;
	private Tipodocumento selectedTipodocumento;
	private List<Tipodocumento> listaTipodocumento;


	@Autowired
	TipodocumentoBusiness business;



	public CC_TipodocumentoBuscar(){
			tipodocumentoB = new Tipodocumento();
			listaTipodocumento= new ArrayList<Tipodocumento>();
	}


	@PostConstruct
	public void init(){
		try {
			tipodocumentoB = new Tipodocumento();
			listaTipodocumento= new ArrayList<Tipodocumento>();

		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}

	public void init(String pk){
		try {
			tipodocumentoB = new Tipodocumento();
			pk=pk.substring(6);
			if(pk.length()>0){
				logger.debug("Init cc_tipodocumento:"+ pk);
				buscar();
			}
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}

	public void buscar() {
		try {
			logger.debug("cc.tipodocumento.buscar...");
			pe.com.sisabas.resources.Utils.convertPropertiesStringToUppercase(tipodocumentoB); //pasa a mayusculas los datos para la busqueda
			listaTipodocumento = business.selectDynamicFullActives(tipodocumentoB);
			if (listaTipodocumento.size() == 0)
			addMessageKey("msgsCC_Tipodocumento",
				Messages.getString("no.records.found"),
				FacesMessage.SEVERITY_INFO);
		} catch (Exception e) {
			addErrorMessageKey("msgsCC_Tipodocumento", e);
		}
	}

	public void setTipodocumentoB(Tipodocumento tipodocumentoB){
		this.tipodocumentoB = tipodocumentoB;
	}

	public Tipodocumento getTipodocumentoB(){
		return tipodocumentoB;
	}

	public void setSelectedTipodocumento(Tipodocumento selectedTipodocumento){
		this.selectedTipodocumento = selectedTipodocumento;
	}

	public Tipodocumento getSelectedTipodocumento(){
		return selectedTipodocumento;
	}

	public void setListaTipodocumento(List<Tipodocumento> listaTipodocumento){
		this.listaTipodocumento=listaTipodocumento;
	}

	public List<Tipodocumento> getListaTipodocumento(){
		return listaTipodocumento;
	}



}

