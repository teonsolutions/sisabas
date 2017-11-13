package pe.com.sisabas.business;
import java.util.List;
import pe.com.sisabas.be.Dependenciadocumentotecnico;

public interface DependenciadocumentotecnicoBusiness{

	public void deleteByPrimaryKeyBasic(Dependenciadocumentotecnico par_record) throws Exception;

	public void insertBasic(Dependenciadocumentotecnico record) throws Exception;

	public void insertFull(Dependenciadocumentotecnico record) throws Exception;

	public void insertSelectiveBasic(Dependenciadocumentotecnico record) throws Exception;

	public Dependenciadocumentotecnico selectByPrimaryKeyBasic(java.lang.Integer par_iddependenciadocumentotecnico) throws Exception;

	public Dependenciadocumentotecnico selectByPrimaryKeyBasicFromList(java.lang.Integer par_iddependenciadocumentotecnico,List<Dependenciadocumentotecnico> list) throws Exception;

	public Dependenciadocumentotecnico selectByPrimaryKeyBasicActive(java.lang.Integer par_iddependenciadocumentotecnico) throws Exception;

	public Dependenciadocumentotecnico selectByPrimaryKeyFull(java.lang.Integer par_iddependenciadocumentotecnico) throws Exception;

	public Dependenciadocumentotecnico selectByPrimaryKeyFullActive(java.lang.Integer par_iddependenciadocumentotecnico) throws Exception;

	public List<Dependenciadocumentotecnico> selectDynamicBasic(Dependenciadocumentotecnico record) throws Exception;

	public List<Dependenciadocumentotecnico> selectDynamicBasicActives(Dependenciadocumentotecnico record) throws Exception;

	public List<Dependenciadocumentotecnico> selectDynamicFull(Dependenciadocumentotecnico record) throws Exception;

	public List<Dependenciadocumentotecnico> selectDynamicFullActives(Dependenciadocumentotecnico record) throws Exception;

	public List<Dependenciadocumentotecnico> selectDynamicExtended(Dependenciadocumentotecnico record) throws Exception;

	public List<Dependenciadocumentotecnico> selectDynamicExtendedActives(Dependenciadocumentotecnico record) throws Exception;

	public void updateByPrimaryKeySelectiveBasic(Dependenciadocumentotecnico record) throws Exception;

	public void updateByPrimaryKeySelectiveFull(Dependenciadocumentotecnico record) throws Exception;

	public void updateByPrimaryKeyBasic(Dependenciadocumentotecnico record) throws Exception;

	public void updateByPrimaryKeyFull(Dependenciadocumentotecnico record) throws Exception;


}
