package pe.com.sisabas.controller;

import java.rmi.RemoteException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import pe.com.sisabas.be.Gentabla;
import pe.com.sisabas.be.Miembrocomiteporproceso;
import pe.com.sisabas.business.GentablaBusiness;
import pe.com.sisabas.business.MiembrocomiteporprocesoBusiness;
import pe.com.sisabas.business.ProcesoBusiness;
import pe.com.sisabas.business.VcentrocostoBusiness;
import pe.com.sisabas.dto.CentroCostoRequest;
import pe.com.sisabas.dto.CentroCostoResponse;
import pe.com.sisabas.dto.EstadoRequerimientoResponse;
import pe.com.sisabas.dto.ProcesoDto;
import pe.com.sisabas.dto.ProcesoRequest;
import pe.com.sisabas.dto.TipoProcesoResponse;
import pe.com.sisabas.exception.SecurityRestrictedControlException;
import pe.com.sisabas.exception.SecuritySessionExpiredException;
import pe.com.sisabas.exception.SecurityValidateException;
import pe.com.sisabas.exception.UnselectedRowException;
import pe.com.sisabas.resources.Constantes;
import pe.com.sisabas.resources.Messages;
import pe.com.sisabas.resources.controller.BaseController;
import pe.com.sisabas.service.SicuCallService;
import pe.com.sisabas.service.Sicuusuario;

@Component(value = "proceso")
@Scope(value = "session")
public class ProcesoController extends BaseController {
	private static final long serialVersionUID = 1L;
	
	private List<ProcesoDto> dataList;
	private ProcesoDto selectedRow;
	private ProcesoRequest searchParam;
	private ProcesoDto currentRow;
	
	// Title
	private String tituloBase;
	private String tituloParam;
	private String accion;
	
	// DropDownList
	public List<Gentabla> listaGentablaIdcatalogotipobien;
	public List<TipoProcesoResponse> listaTipoProceso;
	public List<CentroCostoResponse> listaCentroCosto;
	public List<EstadoRequerimientoResponse> listaEstadoRequerimiento;
	private List<Miembrocomiteporproceso> listaMiembrocomiteporproceso;
	
	private String idOpcionText = "OPC_PROCESO";
	
	// Business layer section
	@Autowired
	public pe.com.sisabas.resources.business.UtilsBusiness utilsBusiness;
	@Autowired
	public GentablaBusiness gentablaBusiness;
	@Autowired
	public ProcesoBusiness procesoBusiness;
	@Autowired
	public VcentrocostoBusiness vcentrocostoBusiness;
	@Autowired
	public MiembrocomiteporprocesoBusiness miembrocomiteporprocesoBusiness;
	
	public ProcesoController(){
		
	}
	
	public String load() {
		return "/pages/proceso/procesoBuscar.xhtml?faces-redirect=true";
	}
	
	@PostConstruct
	public void init(){
		searchParam = new ProcesoRequest();
		tituloBase = "Proceso » ";
		
		try {
			if (SICU_SECURITY_ENABLE) {
				idOpcion = SicuCallService.obtenerIdOpcion(idOpcionText).toString();
				sicuopcion = SicuCallService.obtenercontroles(idOpcion);
			}
			Sicuusuario usuario = (Sicuusuario) getHttpSession().getAttribute("sicuusuarioSESSION");
			listaGentablaIdcatalogotipobien = gentablaBusiness
					.selectDynamicBasic(new Gentabla().getObjBusqueda(Constantes.tabla.TIBI));
			listaTipoProceso = gentablaBusiness.getTipoProceso(usuario.getPeriodo().getAnio());

			CentroCostoRequest param = new CentroCostoRequest();
			param.setCodigoUnidadEjecuta(Constantes.unidadEjecutora.PRONIED);
			param.setIdPeriodo(usuario.getPeriodo().getIdPeriodo());
			listaCentroCosto = vcentrocostoBusiness.getCentroCosto(param);

			listaEstadoRequerimiento = gentablaBusiness
					.getEstadoRequerimiento(Constantes.etapaAdministrativa.PROCESOS_DE_SELECCION);

		} catch (SecuritySessionExpiredException e) {
			redirectSessionExpiredPage();
		} catch (SecurityRestrictedControlException e) {
			STATUS_ERROR();
			addMessageKey("msgsForm", Messages.getString("no.access"), e.getMessage(), FacesMessage.SEVERITY_ERROR);
		} catch (SecurityValidateException e) {
			STATUS_ERROR();
			addMessageKey("msgsForm", e.getMessage(), FacesMessage.SEVERITY_ERROR);
		} catch (RemoteException e) {
			STATUS_ERROR();
			addMessageKey("msgsForm", Messages.getString("sicu.remote.exeption"), e.getMessage(),
					FacesMessage.SEVERITY_ERROR);
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}		
	}
	
	// methods
	public void search() {
		try {
			Sicuusuario usuario = (Sicuusuario) getHttpSession().getAttribute("sicuusuarioSESSION");
			this.searchParam.setAnio(usuario.getPeriodo().getAnio());
			this.searchParam.setIdUnidadEjecutoraSiaf(Constantes.unidadEjecutora.PRONIED_SIAF);
			this.setEsSeleccionado(false);
			this.dataList = procesoBusiness.searchProceso(this.searchParam);

			if (this.dataList.size() == 0)
				addMessageKey("msgsForm", Messages.getString("no.records.found"), FacesMessage.SEVERITY_INFO);
			;

		} catch (SecuritySessionExpiredException e) {
			redirectSessionExpiredPage();
		} catch (SecurityRestrictedControlException e) {
			addMessageKey("msgsForm", Messages.getString("no.access"), e.getMessage(), FacesMessage.SEVERITY_ERROR);
		} catch (SecurityValidateException e) {
			addMessageKey("msgsForm", e.getMessage(), FacesMessage.SEVERITY_ERROR);
		} catch (RemoteException e) {
			addMessageKey("msgsForm", Messages.getString("sicu.remote.exeption"), e.getMessage(),
					FacesMessage.SEVERITY_ERROR);
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}
	
	public void validateSelectedRow() throws UnselectedRowException, CloneNotSupportedException {
		if (selectedRow == null)
			throw new UnselectedRowException(Messages.getString("no.record.selected"));
		else
			currentRow = (ProcesoDto) selectedRow.clone();
	}

	public List<ProcesoDto> getDataList() {
		return dataList;
	}

	public void setDataList(List<ProcesoDto> dataList) {
		this.dataList = dataList;
	}

	public ProcesoDto getSelectedRow() {
		return selectedRow;
	}

	public void setSelectedRow(ProcesoDto selectedRow) {
		this.selectedRow = selectedRow;
	}

	public ProcesoRequest getSearchParam() {
		return searchParam;
	}

	public void setSearchParam(ProcesoRequest searchParam) {
		this.searchParam = searchParam;
	}

	public ProcesoDto getCurrentRow() {
		return currentRow;
	}

	public void setCurrentRow(ProcesoDto currentRow) {
		this.currentRow = currentRow;
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

	public String getAccion() {
		return accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

	public List<Gentabla> getListaGentablaIdcatalogotipobien() {
		return listaGentablaIdcatalogotipobien;
	}

	public void setListaGentablaIdcatalogotipobien(List<Gentabla> listaGentablaIdcatalogotipobien) {
		this.listaGentablaIdcatalogotipobien = listaGentablaIdcatalogotipobien;
	}

	public List<TipoProcesoResponse> getListaTipoProceso() {
		return listaTipoProceso;
	}

	public void setListaTipoProceso(List<TipoProcesoResponse> listaTipoProceso) {
		this.listaTipoProceso = listaTipoProceso;
	}

	public List<CentroCostoResponse> getListaCentroCosto() {
		return listaCentroCosto;
	}

	public void setListaCentroCosto(List<CentroCostoResponse> listaCentroCosto) {
		this.listaCentroCosto = listaCentroCosto;
	}

	public List<EstadoRequerimientoResponse> getListaEstadoRequerimiento() {
		return listaEstadoRequerimiento;
	}

	public void setListaEstadoRequerimiento(List<EstadoRequerimientoResponse> listaEstadoRequerimiento) {
		this.listaEstadoRequerimiento = listaEstadoRequerimiento;
	}

	public List<Miembrocomiteporproceso> getListaMiembrocomiteporproceso() {
		return listaMiembrocomiteporproceso;
	}

	public void setListaMiembrocomiteporproceso(List<Miembrocomiteporproceso> listaMiembrocomiteporproceso) {
		this.listaMiembrocomiteporproceso = listaMiembrocomiteporproceso;
	}	
	
	//properties
	
	
	
	
}
