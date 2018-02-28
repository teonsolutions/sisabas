package pe.com.sisabas.business;
import java.util.List;
import pe.com.sisabas.be.Entregable;

public interface EntregableBusiness{

	public void deleteByPrimaryKeyBasic(Entregable par_record) throws Exception;

	public void insertBasic(Entregable record) throws Exception;

	public void insertFull(Entregable record) throws Exception;

	public void insertSelectiveBasic(Entregable record) throws Exception;

	public Entregable selectByPrimaryKeyBasic(java.lang.Integer par_identregable) throws Exception;

	public Entregable selectByPrimaryKeyBasicFromList(java.lang.Integer par_identregable,List<Entregable> list) throws Exception;

	public Entregable selectByPrimaryKeyBasicActive(java.lang.Integer par_identregable) throws Exception;

	public Entregable selectByPrimaryKeyFull(java.lang.Integer par_identregable) throws Exception;

	public Entregable selectByPrimaryKeyFullActive(java.lang.Integer par_identregable) throws Exception;

	public List<Entregable> selectDynamicBasic(Entregable record) throws Exception;

	public List<Entregable> selectDynamicBasicActives(Entregable record) throws Exception;

	public List<Entregable> selectDynamicFull(Entregable record) throws Exception;

	public List<Entregable> selectDynamicFullActives(Entregable record) throws Exception;

	public List<Entregable> selectDynamicExtended(Entregable record) throws Exception;

	public List<Entregable> selectDynamicExtendedActives(Entregable record) throws Exception;

	public void updateByPrimaryKeySelectiveBasic(Entregable record) throws Exception;

	public void updateByPrimaryKeySelectiveFull(Entregable record) throws Exception;

	public void updateByPrimaryKeyBasic(Entregable record) throws Exception;

	public void updateByPrimaryKeyFull(Entregable record) throws Exception;
	
	public List<Entregable> getEntegablesByOrden(java.lang.Integer par_idorden) throws Exception;


}
