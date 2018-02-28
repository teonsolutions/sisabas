package pe.com.sisabas.business;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import pe.com.sisabas.be.Orden;
import pe.com.sisabas.dto.OrdenDto;
import pe.com.sisabas.dto.OrdenListaDto;

public interface OrdenBusiness{

	public void deleteByPrimaryKeyBasic(Orden par_record) throws Exception;

	public void insertBasic(Orden record) throws Exception;

	public void insertFull(Orden record) throws Exception;

	public void insertSelectiveBasic(Orden record) throws Exception;

	public Orden selectByPrimaryKeyBasic(java.lang.Integer par_idorden) throws Exception;

	public Orden selectByPrimaryKeyBasicFromList(java.lang.Integer par_idorden,List<Orden> list) throws Exception;

	public Orden selectByPrimaryKeyBasicActive(java.lang.Integer par_idorden) throws Exception;

	public Orden selectByPrimaryKeyFull(java.lang.Integer par_idorden) throws Exception;

	public Orden selectByPrimaryKeyFullActive(java.lang.Integer par_idorden) throws Exception;

	public List<Orden> selectDynamicBasic(Orden record) throws Exception;

	public List<Orden> selectDynamicBasicActives(Orden record) throws Exception;

	public List<Orden> selectDynamicFull(Orden record) throws Exception;

	public List<Orden> selectDynamicFullActives(Orden record) throws Exception;

	public List<Orden> selectDynamicExtended(Orden record) throws Exception;

	public List<Orden> selectDynamicExtendedActives(Orden record) throws Exception;

	public void updateByPrimaryKeySelectiveBasic(Orden record) throws Exception;

	public void updateByPrimaryKeySelectiveFull(Orden record) throws Exception;

	public void updateByPrimaryKeyBasic(Orden record) throws Exception;

	public void updateByPrimaryKeyFull(Orden record) throws Exception;
	
	public List<OrdenDto> getListaOrden(OrdenListaDto request) throws Exception;

	List<Orden> getOrdenByIdContrato(@Param("idContrato") java.lang.Integer idContrato) throws Exception;
	
}
