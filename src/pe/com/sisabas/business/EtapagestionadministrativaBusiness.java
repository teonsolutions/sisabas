package pe.com.sisabas.business;
import java.util.List;
import pe.com.sisabas.be.Etapagestionadministrativa;

public interface EtapagestionadministrativaBusiness{

	public void deleteByPrimaryKeyBasic(Etapagestionadministrativa par_record) throws Exception;

	public void insertBasic(Etapagestionadministrativa record) throws Exception;

	public void insertFull(Etapagestionadministrativa record) throws Exception;

	public void insertSelectiveBasic(Etapagestionadministrativa record) throws Exception;

	public Etapagestionadministrativa selectByPrimaryKeyBasic(java.lang.Integer par_idetapaadministrativa) throws Exception;

	public Etapagestionadministrativa selectByPrimaryKeyBasicFromList(java.lang.Integer par_idetapaadministrativa,List<Etapagestionadministrativa> list) throws Exception;

	public Etapagestionadministrativa selectByPrimaryKeyBasicActive(java.lang.Integer par_idetapaadministrativa) throws Exception;

	public Etapagestionadministrativa selectByPrimaryKeyFull(java.lang.Integer par_idetapaadministrativa) throws Exception;

	public Etapagestionadministrativa selectByPrimaryKeyFullActive(java.lang.Integer par_idetapaadministrativa) throws Exception;

	public List<Etapagestionadministrativa> selectDynamicBasic(Etapagestionadministrativa record) throws Exception;

	public List<Etapagestionadministrativa> selectDynamicBasicActives(Etapagestionadministrativa record) throws Exception;

	public List<Etapagestionadministrativa> selectDynamicFull(Etapagestionadministrativa record) throws Exception;

	public List<Etapagestionadministrativa> selectDynamicFullActives(Etapagestionadministrativa record) throws Exception;

	public List<Etapagestionadministrativa> selectDynamicExtended(Etapagestionadministrativa record) throws Exception;

	public List<Etapagestionadministrativa> selectDynamicExtendedActives(Etapagestionadministrativa record) throws Exception;

	public void updateByPrimaryKeySelectiveBasic(Etapagestionadministrativa record) throws Exception;

	public void updateByPrimaryKeySelectiveFull(Etapagestionadministrativa record) throws Exception;

	public void updateByPrimaryKeyBasic(Etapagestionadministrativa record) throws Exception;

	public void updateByPrimaryKeyFull(Etapagestionadministrativa record) throws Exception;


}
