
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
import pe.com.sisabas.be.Pacconsolidado;
import pe.com.sisabas.business.PacconsolidadoBusiness;
import pe.com.sisabas.be.Comiteproceso;
import pe.com.sisabas.be.Grupodocumento;
import pe.com.sisabas.business.GentablaBusiness;
import pe.com.sisabas.be.Gentabla;
import pe.com.sisabas.business.GentablaBusiness;
import pe.com.sisabas.be.Gentabla;
import pe.com.sisabas.business.GentablaBusiness;
import pe.com.sisabas.be.Gentabla;
import pe.com.sisabas.business.GentablaBusiness;
import pe.com.sisabas.be.Gentabla;
import pe.com.sisabas.be.Unidadejecutora;
import pe.com.sisabas.be.Vcertificacion;
import pe.com.sisabas.be.Vissigapaacconsolidado;



@Component(value ="cc_pacconsolidado")
@Scope(value = "session")
public class CC_PacconsolidadoBuscar extends BaseController {

	private static final long serialVersionUID = 1L;
	private Pacconsolidado pacconsolidadoB;
	private Pacconsolidado selectedPacconsolidado;
	private List<Pacconsolidado> listaPacconsolidado;
	public List<Gentabla> listaGentablaIdcatalogoestadopac;
	public List<Gentabla> listaGentablaIdcatalogotipobien;
	public List<Gentabla> listaGentablaIdcatalogotiponecesidad;
	public List<Gentabla> listaGentablaIdcatalogotipocontratacion;


	@Autowired
	PacconsolidadoBusiness business;

	@Autowired
	public GentablaBusiness gentablaBusiness;



	public CC_PacconsolidadoBuscar(){
			pacconsolidadoB = new Pacconsolidado();
			listaPacconsolidado= new ArrayList<Pacconsolidado>();
	}


	@PostConstruct
	public void init(){
		try {
			pacconsolidadoB = new Pacconsolidado();
			listaPacconsolidado= new ArrayList<Pacconsolidado>();
			listaGentablaIdcatalogoestadopac = gentablaBusiness.selectDynamicBasic(new Gentabla().getObjBusqueda(Constantes.tabla.EPAC));
			listaGentablaIdcatalogotipobien = gentablaBusiness.selectDynamicBasic(new Gentabla().getObjBusqueda(Constantes.tabla.TIBI));
			listaGentablaIdcatalogotiponecesidad = gentablaBusiness.selectDynamicBasic(new Gentabla().getObjBusqueda(Constantes.tabla.TINE));
			listaGentablaIdcatalogotipocontratacion = gentablaBusiness.selectDynamicBasic(new Gentabla().getObjBusqueda(Constantes.tabla.TCON));

		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}

	public void init(String pk){
		try {
			pacconsolidadoB = new Pacconsolidado();
			pk=pk.substring(6);
			if(pk.length()>0){
				logger.debug("Init cc_pacconsolidado:"+ pk);
				buscar();
			}
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}

	public void buscar() {
		try {
			logger.debug("cc.pacconsolidado.buscar...");
			pe.com.sisabas.resources.Utils.convertPropertiesStringToUppercase(pacconsolidadoB); //pasa a mayusculas los datos para la busqueda
			listaPacconsolidado = business.selectDynamicFullActives(pacconsolidadoB);
			if (listaPacconsolidado.size() == 0)
			addMessageKey("msgsCC_Pacconsolidado",
				Messages.getString("no.records.found"),
				FacesMessage.SEVERITY_INFO);
		} catch (Exception e) {
			addErrorMessageKey("msgsCC_Pacconsolidado", e);
		}
	}

	public void setPacconsolidadoB(Pacconsolidado pacconsolidadoB){
		this.pacconsolidadoB = pacconsolidadoB;
	}

	public Pacconsolidado getPacconsolidadoB(){
		return pacconsolidadoB;
	}

	public void setSelectedPacconsolidado(Pacconsolidado selectedPacconsolidado){
		this.selectedPacconsolidado = selectedPacconsolidado;
	}

	public Pacconsolidado getSelectedPacconsolidado(){
		return selectedPacconsolidado;
	}

	public void setListaPacconsolidado(List<Pacconsolidado> listaPacconsolidado){
		this.listaPacconsolidado=listaPacconsolidado;
	}

	public List<Pacconsolidado> getListaPacconsolidado(){
		return listaPacconsolidado;
	}

	public void setListaGentablaIdcatalogoestadopac(List<Gentabla> listaGentablaIdcatalogoestadopac){
		this.listaGentablaIdcatalogoestadopac=listaGentablaIdcatalogoestadopac;
	}

	public List<Gentabla> getListaGentablaIdcatalogoestadopac(){
		return listaGentablaIdcatalogoestadopac;
	}

	public void setListaGentablaIdcatalogotipobien(List<Gentabla> listaGentablaIdcatalogotipobien){
		this.listaGentablaIdcatalogotipobien=listaGentablaIdcatalogotipobien;
	}

	public List<Gentabla> getListaGentablaIdcatalogotipobien(){
		return listaGentablaIdcatalogotipobien;
	}

	public void setListaGentablaIdcatalogotiponecesidad(List<Gentabla> listaGentablaIdcatalogotiponecesidad){
		this.listaGentablaIdcatalogotiponecesidad=listaGentablaIdcatalogotiponecesidad;
	}

	public List<Gentabla> getListaGentablaIdcatalogotiponecesidad(){
		return listaGentablaIdcatalogotiponecesidad;
	}

	public void setListaGentablaIdcatalogotipocontratacion(List<Gentabla> listaGentablaIdcatalogotipocontratacion){
		this.listaGentablaIdcatalogotipocontratacion=listaGentablaIdcatalogotipocontratacion;
	}

	public List<Gentabla> getListaGentablaIdcatalogotipocontratacion(){
		return listaGentablaIdcatalogotipocontratacion;
	}



}

