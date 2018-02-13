package pe.com.sisabas.business;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import pe.com.sisabas.be.Gentabla;
import pe.com.sisabas.dto.EstadoRequerimientoResponse;
import pe.com.sisabas.dto.GentablaItemResponse;
import pe.com.sisabas.dto.TipoProcesoResponse;

public interface GentablaBusiness{

	public void deleteByPrimaryKeyBasic(Gentabla par_record) throws Exception;

	public void insertBasic(Gentabla record) throws Exception;

	public void insertFull(Gentabla record) throws Exception;

	public void insertSelectiveBasic(Gentabla record) throws Exception;

	public Gentabla selectByPrimaryKeyBasic(java.lang.String par_vchregcodigo) throws Exception;

	public Gentabla selectByPrimaryKeyBasicFromList(java.lang.String par_vchregcodigo,List<Gentabla> list) throws Exception;

	public Gentabla selectByPrimaryKeyBasicActive(java.lang.String par_vchregcodigo) throws Exception;

	public Gentabla selectByPrimaryKeyFull(java.lang.String par_vchregcodigo) throws Exception;

	public Gentabla selectByPrimaryKeyFullActive(java.lang.String par_vchregcodigo) throws Exception;

	public List<Gentabla> selectDynamicBasic(Gentabla record) throws Exception;

	public List<Gentabla> selectDynamicBasicActives(Gentabla record) throws Exception;

	public List<Gentabla> selectDynamicFull(Gentabla record) throws Exception;

	public List<Gentabla> selectDynamicFullActives(Gentabla record) throws Exception;

	public List<Gentabla> selectDynamicExtended(Gentabla record) throws Exception;

	public List<Gentabla> selectDynamicExtendedActives(Gentabla record) throws Exception;

	public void updateByPrimaryKeySelectiveBasic(Gentabla record) throws Exception;

	public void updateByPrimaryKeySelectiveFull(Gentabla record) throws Exception;

	public void updateByPrimaryKeyBasic(Gentabla record) throws Exception;

	public void updateByPrimaryKeyFull(Gentabla record) throws Exception;

	//CUSTOM
	public List<TipoProcesoResponse> getTipoProceso(@Param("anio") Integer anio) throws Exception;
	
	public List<EstadoRequerimientoResponse> getEstadoRequerimiento(@Param("idEtapaAdministrativa") Integer idEtapaAdministrativa) throws Exception;
	
	public List<GentablaItemResponse> getItems(String tipo) throws Exception;	
	
	public String getDescripcion(String key) throws Exception;
}
