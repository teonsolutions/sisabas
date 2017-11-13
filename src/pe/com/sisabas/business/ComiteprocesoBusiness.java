package pe.com.sisabas.business;
import java.util.List;
import pe.com.sisabas.be.Comiteproceso;

public interface ComiteprocesoBusiness{

	public void deleteByPrimaryKeyBasic(Comiteproceso par_record) throws Exception;

	public void insertBasic(Comiteproceso record) throws Exception;

	public void insertFull(Comiteproceso record) throws Exception;

	public void insertSelectiveBasic(Comiteproceso record) throws Exception;

	public Comiteproceso selectByPrimaryKeyBasic(java.lang.Integer par_idcomiteproceso) throws Exception;

	public Comiteproceso selectByPrimaryKeyBasicFromList(java.lang.Integer par_idcomiteproceso,List<Comiteproceso> list) throws Exception;

	public Comiteproceso selectByPrimaryKeyBasicActive(java.lang.Integer par_idcomiteproceso) throws Exception;

	public Comiteproceso selectByPrimaryKeyFull(java.lang.Integer par_idcomiteproceso) throws Exception;

	public Comiteproceso selectByPrimaryKeyFullActive(java.lang.Integer par_idcomiteproceso) throws Exception;

	public List<Comiteproceso> selectDynamicBasic(Comiteproceso record) throws Exception;

	public List<Comiteproceso> selectDynamicBasicActives(Comiteproceso record) throws Exception;

	public List<Comiteproceso> selectDynamicFull(Comiteproceso record) throws Exception;

	public List<Comiteproceso> selectDynamicFullActives(Comiteproceso record) throws Exception;

	public List<Comiteproceso> selectDynamicExtended(Comiteproceso record) throws Exception;

	public List<Comiteproceso> selectDynamicExtendedActives(Comiteproceso record) throws Exception;

	public void updateByPrimaryKeySelectiveBasic(Comiteproceso record) throws Exception;

	public void updateByPrimaryKeySelectiveFull(Comiteproceso record) throws Exception;

	public void updateByPrimaryKeyBasic(Comiteproceso record) throws Exception;

	public void updateByPrimaryKeyFull(Comiteproceso record) throws Exception;


}
