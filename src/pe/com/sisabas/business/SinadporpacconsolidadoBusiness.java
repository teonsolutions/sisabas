package pe.com.sisabas.business;
import java.util.List;
import pe.com.sisabas.be.Sinadporpacconsolidado;

public interface SinadporpacconsolidadoBusiness{

	public void deleteByPrimaryKeyBasic(Sinadporpacconsolidado par_record) throws Exception;

	public void insertBasic(Sinadporpacconsolidado record) throws Exception;

	public void insertFull(Sinadporpacconsolidado record) throws Exception;

	public void insertSelectiveBasic(Sinadporpacconsolidado record) throws Exception;

	public Sinadporpacconsolidado selectByPrimaryKeyBasic(java.lang.Integer par_idsinad) throws Exception;

	public Sinadporpacconsolidado selectByPrimaryKeyBasicFromList(java.lang.Integer par_idsinad,List<Sinadporpacconsolidado> list) throws Exception;

	public Sinadporpacconsolidado selectByPrimaryKeyBasicActive(java.lang.Integer par_idsinad) throws Exception;

	public Sinadporpacconsolidado selectByPrimaryKeyFull(java.lang.Integer par_idsinad) throws Exception;

	public Sinadporpacconsolidado selectByPrimaryKeyFullActive(java.lang.Integer par_idsinad) throws Exception;

	public List<Sinadporpacconsolidado> selectDynamicBasic(Sinadporpacconsolidado record) throws Exception;

	public List<Sinadporpacconsolidado> selectDynamicBasicActives(Sinadporpacconsolidado record) throws Exception;

	public List<Sinadporpacconsolidado> selectDynamicFull(Sinadporpacconsolidado record) throws Exception;

	public List<Sinadporpacconsolidado> selectDynamicFullActives(Sinadporpacconsolidado record) throws Exception;

	public List<Sinadporpacconsolidado> selectDynamicExtended(Sinadporpacconsolidado record) throws Exception;

	public List<Sinadporpacconsolidado> selectDynamicExtendedActives(Sinadporpacconsolidado record) throws Exception;

	public void updateByPrimaryKeySelectiveBasic(Sinadporpacconsolidado record) throws Exception;

	public void updateByPrimaryKeySelectiveFull(Sinadporpacconsolidado record) throws Exception;

	public void updateByPrimaryKeyBasic(Sinadporpacconsolidado record) throws Exception;

	public void updateByPrimaryKeyFull(Sinadporpacconsolidado record) throws Exception;


}
