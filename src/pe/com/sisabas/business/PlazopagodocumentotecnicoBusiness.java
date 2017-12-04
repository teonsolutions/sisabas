package pe.com.sisabas.business;
import java.util.List;
import pe.com.sisabas.be.Plazopagodocumentotecnico;

public interface PlazopagodocumentotecnicoBusiness{

	public void deleteByPrimaryKeyBasic(Plazopagodocumentotecnico par_record) throws Exception;

	public void insertBasic(Plazopagodocumentotecnico record) throws Exception;

	public void insertFull(Plazopagodocumentotecnico record) throws Exception;

	public void insertSelectiveBasic(Plazopagodocumentotecnico record) throws Exception;

	public Plazopagodocumentotecnico selectByPrimaryKeyBasic(java.lang.Integer par_idplazopagodocumentotecnico) throws Exception;

	public Plazopagodocumentotecnico selectByPrimaryKeyBasicFromList(java.lang.Integer par_idplazopagodocumentotecnico,List<Plazopagodocumentotecnico> list) throws Exception;

	public Plazopagodocumentotecnico selectByPrimaryKeyBasicActive(java.lang.Integer par_idplazopagodocumentotecnico) throws Exception;

	public Plazopagodocumentotecnico selectByPrimaryKeyFull(java.lang.Integer par_idplazopagodocumentotecnico) throws Exception;

	public Plazopagodocumentotecnico selectByPrimaryKeyFullActive(java.lang.Integer par_idplazopagodocumentotecnico) throws Exception;

	public List<Plazopagodocumentotecnico> selectDynamicBasic(Plazopagodocumentotecnico record) throws Exception;

	public List<Plazopagodocumentotecnico> selectDynamicBasicActives(Plazopagodocumentotecnico record) throws Exception;

	public List<Plazopagodocumentotecnico> selectDynamicFull(Plazopagodocumentotecnico record) throws Exception;

	public List<Plazopagodocumentotecnico> selectDynamicFullActives(Plazopagodocumentotecnico record) throws Exception;

	public List<Plazopagodocumentotecnico> selectDynamicExtended(Plazopagodocumentotecnico record) throws Exception;

	public List<Plazopagodocumentotecnico> selectDynamicExtendedActives(Plazopagodocumentotecnico record) throws Exception;

	public void updateByPrimaryKeySelectiveBasic(Plazopagodocumentotecnico record) throws Exception;

	public void updateByPrimaryKeySelectiveFull(Plazopagodocumentotecnico record) throws Exception;

	public void updateByPrimaryKeyBasic(Plazopagodocumentotecnico record) throws Exception;

	public void updateByPrimaryKeyFull(Plazopagodocumentotecnico record) throws Exception;

	public List<Plazopagodocumentotecnico> getPlazosByDocumentoTecnico(Integer idDocumentoTecnico) throws Exception;

}
