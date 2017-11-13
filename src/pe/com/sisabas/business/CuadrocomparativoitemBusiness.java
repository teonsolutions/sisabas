package pe.com.sisabas.business;
import java.util.List;
import pe.com.sisabas.be.Cuadrocomparativoitem;

public interface CuadrocomparativoitemBusiness{

	public void deleteByPrimaryKeyBasic(Cuadrocomparativoitem par_record) throws Exception;

	public void insertBasic(Cuadrocomparativoitem record) throws Exception;

	public void insertFull(Cuadrocomparativoitem record) throws Exception;

	public void insertSelectiveBasic(Cuadrocomparativoitem record) throws Exception;

	public Cuadrocomparativoitem selectByPrimaryKeyBasic(java.lang.Integer par_idcuadrocomparativoitem) throws Exception;

	public Cuadrocomparativoitem selectByPrimaryKeyBasicFromList(java.lang.Integer par_idcuadrocomparativoitem,List<Cuadrocomparativoitem> list) throws Exception;

	public Cuadrocomparativoitem selectByPrimaryKeyBasicActive(java.lang.Integer par_idcuadrocomparativoitem) throws Exception;

	public Cuadrocomparativoitem selectByPrimaryKeyFull(java.lang.Integer par_idcuadrocomparativoitem) throws Exception;

	public Cuadrocomparativoitem selectByPrimaryKeyFullActive(java.lang.Integer par_idcuadrocomparativoitem) throws Exception;

	public List<Cuadrocomparativoitem> selectDynamicBasic(Cuadrocomparativoitem record) throws Exception;

	public List<Cuadrocomparativoitem> selectDynamicBasicActives(Cuadrocomparativoitem record) throws Exception;

	public List<Cuadrocomparativoitem> selectDynamicFull(Cuadrocomparativoitem record) throws Exception;

	public List<Cuadrocomparativoitem> selectDynamicFullActives(Cuadrocomparativoitem record) throws Exception;

	public List<Cuadrocomparativoitem> selectDynamicExtended(Cuadrocomparativoitem record) throws Exception;

	public List<Cuadrocomparativoitem> selectDynamicExtendedActives(Cuadrocomparativoitem record) throws Exception;

	public void updateByPrimaryKeySelectiveBasic(Cuadrocomparativoitem record) throws Exception;

	public void updateByPrimaryKeySelectiveFull(Cuadrocomparativoitem record) throws Exception;

	public void updateByPrimaryKeyBasic(Cuadrocomparativoitem record) throws Exception;

	public void updateByPrimaryKeyFull(Cuadrocomparativoitem record) throws Exception;


}
