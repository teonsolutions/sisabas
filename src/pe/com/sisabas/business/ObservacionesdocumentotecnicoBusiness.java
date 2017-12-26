package pe.com.sisabas.business;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import pe.com.sisabas.be.Observacionesdocumentotecnico;

public interface ObservacionesdocumentotecnicoBusiness{

	public void deleteByPrimaryKeyBasic(Observacionesdocumentotecnico par_record) throws Exception;

	public void insertBasic(Observacionesdocumentotecnico record) throws Exception;

	public void insertFull(Observacionesdocumentotecnico record) throws Exception;

	public void insertSelectiveBasic(Observacionesdocumentotecnico record) throws Exception;

	public Observacionesdocumentotecnico selectByPrimaryKeyBasic(java.lang.Integer par_idobservacionesdocumentotecnico) throws Exception;

	public Observacionesdocumentotecnico selectByPrimaryKeyBasicFromList(java.lang.Integer par_idobservacionesdocumentotecnico,List<Observacionesdocumentotecnico> list) throws Exception;

	public Observacionesdocumentotecnico selectByPrimaryKeyBasicActive(java.lang.Integer par_idobservacionesdocumentotecnico) throws Exception;

	public Observacionesdocumentotecnico selectByPrimaryKeyFull(java.lang.Integer par_idobservacionesdocumentotecnico) throws Exception;

	public Observacionesdocumentotecnico selectByPrimaryKeyFullActive(java.lang.Integer par_idobservacionesdocumentotecnico) throws Exception;

	public List<Observacionesdocumentotecnico> selectDynamicBasic(Observacionesdocumentotecnico record) throws Exception;

	public List<Observacionesdocumentotecnico> selectDynamicBasicActives(Observacionesdocumentotecnico record) throws Exception;

	public List<Observacionesdocumentotecnico> selectDynamicFull(Observacionesdocumentotecnico record) throws Exception;

	public List<Observacionesdocumentotecnico> selectDynamicFullActives(Observacionesdocumentotecnico record) throws Exception;

	public List<Observacionesdocumentotecnico> selectDynamicExtended(Observacionesdocumentotecnico record) throws Exception;

	public List<Observacionesdocumentotecnico> selectDynamicExtendedActives(Observacionesdocumentotecnico record) throws Exception;

	public void updateByPrimaryKeySelectiveBasic(Observacionesdocumentotecnico record) throws Exception;

	public void updateByPrimaryKeySelectiveFull(Observacionesdocumentotecnico record) throws Exception;

	public void updateByPrimaryKeyBasic(Observacionesdocumentotecnico record) throws Exception;

	public void updateByPrimaryKeyFull(Observacionesdocumentotecnico record) throws Exception;

	public List<Observacionesdocumentotecnico> selectByDocumentoTecnico(@Param("idDocumentoTecnico") java.lang.Integer idDocumentoTecnico) throws Exception;

}
