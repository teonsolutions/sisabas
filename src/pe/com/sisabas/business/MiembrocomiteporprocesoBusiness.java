package pe.com.sisabas.business;
import java.util.List;
import pe.com.sisabas.be.Miembrocomiteporproceso;

public interface MiembrocomiteporprocesoBusiness{

	public void deleteByPrimaryKeyBasic(Miembrocomiteporproceso par_record) throws Exception;

	public void insertBasic(Miembrocomiteporproceso record) throws Exception;

	public void insertFull(Miembrocomiteporproceso record) throws Exception;

	public void insertSelectiveBasic(Miembrocomiteporproceso record) throws Exception;

	public Miembrocomiteporproceso selectByPrimaryKeyBasic(java.lang.Integer par_idmiembrocomiteproceso) throws Exception;

	public Miembrocomiteporproceso selectByPrimaryKeyBasicFromList(java.lang.Integer par_idmiembrocomiteproceso,List<Miembrocomiteporproceso> list) throws Exception;

	public Miembrocomiteporproceso selectByPrimaryKeyBasicActive(java.lang.Integer par_idmiembrocomiteproceso) throws Exception;

	public Miembrocomiteporproceso selectByPrimaryKeyFull(java.lang.Integer par_idmiembrocomiteproceso) throws Exception;

	public Miembrocomiteporproceso selectByPrimaryKeyFullActive(java.lang.Integer par_idmiembrocomiteproceso) throws Exception;

	public List<Miembrocomiteporproceso> selectDynamicBasic(Miembrocomiteporproceso record) throws Exception;

	public List<Miembrocomiteporproceso> selectDynamicBasicActives(Miembrocomiteporproceso record) throws Exception;

	public List<Miembrocomiteporproceso> selectDynamicFull(Miembrocomiteporproceso record) throws Exception;

	public List<Miembrocomiteporproceso> selectDynamicFullActives(Miembrocomiteporproceso record) throws Exception;

	public List<Miembrocomiteporproceso> selectDynamicExtended(Miembrocomiteporproceso record) throws Exception;

	public List<Miembrocomiteporproceso> selectDynamicExtendedActives(Miembrocomiteporproceso record) throws Exception;

	public void updateByPrimaryKeySelectiveBasic(Miembrocomiteporproceso record) throws Exception;

	public void updateByPrimaryKeySelectiveFull(Miembrocomiteporproceso record) throws Exception;

	public void updateByPrimaryKeyBasic(Miembrocomiteporproceso record) throws Exception;

	public void updateByPrimaryKeyFull(Miembrocomiteporproceso record) throws Exception;


}
