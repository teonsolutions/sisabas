package pe.com.sisabas.business;
import java.util.List;
import pe.com.sisabas.be.Previsionporcontrato;

public interface PrevisionporcontratoBusiness{

	public void deleteByPrimaryKeyBasic(Previsionporcontrato par_record) throws Exception;

	public void insertBasic(Previsionporcontrato record) throws Exception;

	public void insertFull(Previsionporcontrato record) throws Exception;

	public void insertSelectiveBasic(Previsionporcontrato record) throws Exception;

	public Previsionporcontrato selectByPrimaryKeyBasic(java.lang.Integer par_idprevisionporcontrato) throws Exception;

	public Previsionporcontrato selectByPrimaryKeyBasicFromList(java.lang.Integer par_idprevisionporcontrato,List<Previsionporcontrato> list) throws Exception;

	public Previsionporcontrato selectByPrimaryKeyBasicActive(java.lang.Integer par_idprevisionporcontrato) throws Exception;

	public Previsionporcontrato selectByPrimaryKeyFull(java.lang.Integer par_idprevisionporcontrato) throws Exception;

	public Previsionporcontrato selectByPrimaryKeyFullActive(java.lang.Integer par_idprevisionporcontrato) throws Exception;

	public List<Previsionporcontrato> selectDynamicBasic(Previsionporcontrato record) throws Exception;

	public List<Previsionporcontrato> selectDynamicBasicActives(Previsionporcontrato record) throws Exception;

	public List<Previsionporcontrato> selectDynamicFull(Previsionporcontrato record) throws Exception;

	public List<Previsionporcontrato> selectDynamicFullActives(Previsionporcontrato record) throws Exception;

	public List<Previsionporcontrato> selectDynamicExtended(Previsionporcontrato record) throws Exception;

	public List<Previsionporcontrato> selectDynamicExtendedActives(Previsionporcontrato record) throws Exception;

	public void updateByPrimaryKeySelectiveBasic(Previsionporcontrato record) throws Exception;

	public void updateByPrimaryKeySelectiveFull(Previsionporcontrato record) throws Exception;

	public void updateByPrimaryKeyBasic(Previsionporcontrato record) throws Exception;

	public void updateByPrimaryKeyFull(Previsionporcontrato record) throws Exception;


}
