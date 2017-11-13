package pe.com.sisabas.business;
import java.util.List;
import pe.com.sisabas.be.Periodo;

public interface PeriodoBusiness{

	public void deleteByPrimaryKeyBasic(Periodo par_record) throws Exception;

	public void insertBasic(Periodo record) throws Exception;

	public void insertFull(Periodo record) throws Exception;

	public void insertSelectiveBasic(Periodo record) throws Exception;

	public Periodo selectByPrimaryKeyBasic(java.lang.Integer par_idperiodo) throws Exception;

	public Periodo selectByPrimaryKeyBasicFromList(java.lang.Integer par_idperiodo,List<Periodo> list) throws Exception;

	public Periodo selectByPrimaryKeyBasicActive(java.lang.Integer par_idperiodo) throws Exception;

	public Periodo selectByPrimaryKeyFull(java.lang.Integer par_idperiodo) throws Exception;

	public Periodo selectByPrimaryKeyFullActive(java.lang.Integer par_idperiodo) throws Exception;

	public List<Periodo> selectDynamicBasic(Periodo record) throws Exception;

	public List<Periodo> selectDynamicBasicActives(Periodo record) throws Exception;

	public List<Periodo> selectDynamicFull(Periodo record) throws Exception;

	public List<Periodo> selectDynamicFullActives(Periodo record) throws Exception;

	public List<Periodo> selectDynamicExtended(Periodo record) throws Exception;

	public List<Periodo> selectDynamicExtendedActives(Periodo record) throws Exception;

	public void updateByPrimaryKeySelectiveBasic(Periodo record) throws Exception;

	public void updateByPrimaryKeySelectiveFull(Periodo record) throws Exception;

	public void updateByPrimaryKeyBasic(Periodo record) throws Exception;

	public void updateByPrimaryKeyFull(Periodo record) throws Exception;


}
