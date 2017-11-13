package pe.com.sisabas.business;
import java.util.List;
import pe.com.sisabas.be.Siafexpedientesecuencia;

public interface SiafexpedientesecuenciaBusiness{

	public void deleteByPrimaryKeyBasic(Siafexpedientesecuencia par_record) throws Exception;

	public void insertBasic(Siafexpedientesecuencia record) throws Exception;

	public void insertFull(Siafexpedientesecuencia record) throws Exception;

	public void insertSelectiveBasic(Siafexpedientesecuencia record) throws Exception;

	public Siafexpedientesecuencia selectByPrimaryKeyBasic(java.lang.Integer par_idsiafexpedientesecuencia) throws Exception;

	public Siafexpedientesecuencia selectByPrimaryKeyBasicFromList(java.lang.Integer par_idsiafexpedientesecuencia,List<Siafexpedientesecuencia> list) throws Exception;

	public Siafexpedientesecuencia selectByPrimaryKeyBasicActive(java.lang.Integer par_idsiafexpedientesecuencia) throws Exception;

	public Siafexpedientesecuencia selectByPrimaryKeyFull(java.lang.Integer par_idsiafexpedientesecuencia) throws Exception;

	public Siafexpedientesecuencia selectByPrimaryKeyFullActive(java.lang.Integer par_idsiafexpedientesecuencia) throws Exception;

	public List<Siafexpedientesecuencia> selectDynamicBasic(Siafexpedientesecuencia record) throws Exception;

	public List<Siafexpedientesecuencia> selectDynamicBasicActives(Siafexpedientesecuencia record) throws Exception;

	public List<Siafexpedientesecuencia> selectDynamicFull(Siafexpedientesecuencia record) throws Exception;

	public List<Siafexpedientesecuencia> selectDynamicFullActives(Siafexpedientesecuencia record) throws Exception;

	public List<Siafexpedientesecuencia> selectDynamicExtended(Siafexpedientesecuencia record) throws Exception;

	public List<Siafexpedientesecuencia> selectDynamicExtendedActives(Siafexpedientesecuencia record) throws Exception;

	public void updateByPrimaryKeySelectiveBasic(Siafexpedientesecuencia record) throws Exception;

	public void updateByPrimaryKeySelectiveFull(Siafexpedientesecuencia record) throws Exception;

	public void updateByPrimaryKeyBasic(Siafexpedientesecuencia record) throws Exception;

	public void updateByPrimaryKeyFull(Siafexpedientesecuencia record) throws Exception;


}
