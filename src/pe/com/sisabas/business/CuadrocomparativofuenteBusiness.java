package pe.com.sisabas.business;
import java.util.List;
import pe.com.sisabas.be.Cuadrocomparativofuente;

public interface CuadrocomparativofuenteBusiness{

	public void deleteByPrimaryKeyBasic(Cuadrocomparativofuente par_record) throws Exception;

	public void insertBasic(Cuadrocomparativofuente record) throws Exception;

	public void insertFull(Cuadrocomparativofuente record) throws Exception;

	public void insertSelectiveBasic(Cuadrocomparativofuente record) throws Exception;

	public Cuadrocomparativofuente selectByPrimaryKeyBasic(java.lang.Integer par_idcuadrocomparativofuente) throws Exception;

	public Cuadrocomparativofuente selectByPrimaryKeyBasicFromList(java.lang.Integer par_idcuadrocomparativofuente,List<Cuadrocomparativofuente> list) throws Exception;

	public Cuadrocomparativofuente selectByPrimaryKeyBasicActive(java.lang.Integer par_idcuadrocomparativofuente) throws Exception;

	public Cuadrocomparativofuente selectByPrimaryKeyFull(java.lang.Integer par_idcuadrocomparativofuente) throws Exception;

	public Cuadrocomparativofuente selectByPrimaryKeyFullActive(java.lang.Integer par_idcuadrocomparativofuente) throws Exception;

	public List<Cuadrocomparativofuente> selectDynamicBasic(Cuadrocomparativofuente record) throws Exception;

	public List<Cuadrocomparativofuente> selectDynamicBasicActives(Cuadrocomparativofuente record) throws Exception;

	public List<Cuadrocomparativofuente> selectDynamicFull(Cuadrocomparativofuente record) throws Exception;

	public List<Cuadrocomparativofuente> selectDynamicFullActives(Cuadrocomparativofuente record) throws Exception;

	public List<Cuadrocomparativofuente> selectDynamicExtended(Cuadrocomparativofuente record) throws Exception;

	public List<Cuadrocomparativofuente> selectDynamicExtendedActives(Cuadrocomparativofuente record) throws Exception;

	public void updateByPrimaryKeySelectiveBasic(Cuadrocomparativofuente record) throws Exception;

	public void updateByPrimaryKeySelectiveFull(Cuadrocomparativofuente record) throws Exception;

	public void updateByPrimaryKeyBasic(Cuadrocomparativofuente record) throws Exception;

	public void updateByPrimaryKeyFull(Cuadrocomparativofuente record) throws Exception;


}
