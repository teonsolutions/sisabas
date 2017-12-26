package pe.com.sisabas.business;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import pe.com.sisabas.be.Seccionesdocumentotecnico;

public interface SeccionesdocumentotecnicoBusiness{

	public void deleteByPrimaryKeyBasic(Seccionesdocumentotecnico par_record) throws Exception;

	public void insertBasic(Seccionesdocumentotecnico record) throws Exception;

	public void insertFull(Seccionesdocumentotecnico record) throws Exception;

	public void insertSelectiveBasic(Seccionesdocumentotecnico record) throws Exception;

	public Seccionesdocumentotecnico selectByPrimaryKeyBasic(java.lang.Integer par_idseccionesdocumentotecnico) throws Exception;

	public Seccionesdocumentotecnico selectByPrimaryKeyBasicFromList(java.lang.Integer par_idseccionesdocumentotecnico,List<Seccionesdocumentotecnico> list) throws Exception;

	public Seccionesdocumentotecnico selectByPrimaryKeyBasicActive(java.lang.Integer par_idseccionesdocumentotecnico) throws Exception;

	public Seccionesdocumentotecnico selectByPrimaryKeyFull(java.lang.Integer par_idseccionesdocumentotecnico) throws Exception;

	public Seccionesdocumentotecnico selectByPrimaryKeyFullActive(java.lang.Integer par_idseccionesdocumentotecnico) throws Exception;

	public List<Seccionesdocumentotecnico> selectDynamicBasic(Seccionesdocumentotecnico record) throws Exception;

	public List<Seccionesdocumentotecnico> selectDynamicBasicActives(Seccionesdocumentotecnico record) throws Exception;

	public List<Seccionesdocumentotecnico> selectDynamicFull(Seccionesdocumentotecnico record) throws Exception;

	public List<Seccionesdocumentotecnico> selectDynamicFullActives(Seccionesdocumentotecnico record) throws Exception;

	public List<Seccionesdocumentotecnico> selectDynamicExtended(Seccionesdocumentotecnico record) throws Exception;

	public List<Seccionesdocumentotecnico> selectDynamicExtendedActives(Seccionesdocumentotecnico record) throws Exception;

	public void updateByPrimaryKeySelectiveBasic(Seccionesdocumentotecnico record) throws Exception;

	public void updateByPrimaryKeySelectiveFull(Seccionesdocumentotecnico record) throws Exception;

	public void updateByPrimaryKeyBasic(Seccionesdocumentotecnico record) throws Exception;

	public void updateByPrimaryKeyFull(Seccionesdocumentotecnico record) throws Exception;

	public List<Seccionesdocumentotecnico> selectByTipoDocumentoTecnico(@Param("idCatalogoTipoDocumentoTecnico") java.lang.String idCatalogoTipoDocumentoTecnico) throws Exception;
	
}
