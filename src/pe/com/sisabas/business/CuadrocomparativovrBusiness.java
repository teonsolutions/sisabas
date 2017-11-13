package pe.com.sisabas.business;
import java.util.List;
import pe.com.sisabas.be.Cuadrocomparativovr;

public interface CuadrocomparativovrBusiness{

	public void deleteByPrimaryKeyBasic(Cuadrocomparativovr par_record) throws Exception;

	public void insertBasic(Cuadrocomparativovr record) throws Exception;

	public void insertFull(Cuadrocomparativovr record) throws Exception;

	public void insertSelectiveBasic(Cuadrocomparativovr record) throws Exception;

	public Cuadrocomparativovr selectByPrimaryKeyBasic(java.lang.Integer par_idcuadrocomparativovr) throws Exception;

	public Cuadrocomparativovr selectByPrimaryKeyBasicFromList(java.lang.Integer par_idcuadrocomparativovr,List<Cuadrocomparativovr> list) throws Exception;

	public Cuadrocomparativovr selectByPrimaryKeyBasicActive(java.lang.Integer par_idcuadrocomparativovr) throws Exception;

	public Cuadrocomparativovr selectByPrimaryKeyFull(java.lang.Integer par_idcuadrocomparativovr) throws Exception;

	public Cuadrocomparativovr selectByPrimaryKeyFullActive(java.lang.Integer par_idcuadrocomparativovr) throws Exception;

	public List<Cuadrocomparativovr> selectDynamicBasic(Cuadrocomparativovr record) throws Exception;

	public List<Cuadrocomparativovr> selectDynamicBasicActives(Cuadrocomparativovr record) throws Exception;

	public List<Cuadrocomparativovr> selectDynamicFull(Cuadrocomparativovr record) throws Exception;

	public List<Cuadrocomparativovr> selectDynamicFullActives(Cuadrocomparativovr record) throws Exception;

	public List<Cuadrocomparativovr> selectDynamicExtended(Cuadrocomparativovr record) throws Exception;

	public List<Cuadrocomparativovr> selectDynamicExtendedActives(Cuadrocomparativovr record) throws Exception;

	public void updateByPrimaryKeySelectiveBasic(Cuadrocomparativovr record) throws Exception;

	public void updateByPrimaryKeySelectiveFull(Cuadrocomparativovr record) throws Exception;

	public void updateByPrimaryKeyBasic(Cuadrocomparativovr record) throws Exception;

	public void updateByPrimaryKeyFull(Cuadrocomparativovr record) throws Exception;


}
