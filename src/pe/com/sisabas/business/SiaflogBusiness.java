package pe.com.sisabas.business;
import java.util.List;
import pe.com.sisabas.be.Siaflog;

public interface SiaflogBusiness{

	public void deleteByPrimaryKeyBasic(Siaflog par_record) throws Exception;

	public void insertBasic(Siaflog record) throws Exception;

	public void insertFull(Siaflog record) throws Exception;

	public void insertSelectiveBasic(Siaflog record) throws Exception;

	public Siaflog selectByPrimaryKeyBasic(java.lang.Integer par_idlog) throws Exception;

	public Siaflog selectByPrimaryKeyBasicFromList(java.lang.Integer par_idlog,List<Siaflog> list) throws Exception;

	public Siaflog selectByPrimaryKeyBasicActive(java.lang.Integer par_idlog) throws Exception;

	public Siaflog selectByPrimaryKeyFull(java.lang.Integer par_idlog) throws Exception;

	public Siaflog selectByPrimaryKeyFullActive(java.lang.Integer par_idlog) throws Exception;

	public List<Siaflog> selectDynamicBasic(Siaflog record) throws Exception;

	public List<Siaflog> selectDynamicBasicActives(Siaflog record) throws Exception;

	public List<Siaflog> selectDynamicFull(Siaflog record) throws Exception;

	public List<Siaflog> selectDynamicFullActives(Siaflog record) throws Exception;

	public List<Siaflog> selectDynamicExtended(Siaflog record) throws Exception;

	public List<Siaflog> selectDynamicExtendedActives(Siaflog record) throws Exception;

	public void updateByPrimaryKeySelectiveBasic(Siaflog record) throws Exception;

	public void updateByPrimaryKeySelectiveFull(Siaflog record) throws Exception;

	public void updateByPrimaryKeyBasic(Siaflog record) throws Exception;

	public void updateByPrimaryKeyFull(Siaflog record) throws Exception;


}
