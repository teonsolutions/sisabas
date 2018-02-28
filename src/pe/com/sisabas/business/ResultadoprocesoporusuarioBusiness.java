package pe.com.sisabas.business;
import java.util.List;
import pe.com.sisabas.be.Resultadoprocesoporusuario;

public interface ResultadoprocesoporusuarioBusiness{

	public void deleteByPrimaryKeyBasic(Resultadoprocesoporusuario par_record) throws Exception;

	public void insertBasic(Resultadoprocesoporusuario record) throws Exception;

	public void insertFull(Resultadoprocesoporusuario record) throws Exception;

	public void insertSelectiveBasic(Resultadoprocesoporusuario record) throws Exception;

	public Resultadoprocesoporusuario selectByPrimaryKeyBasic(java.lang.Integer par_idresultadoprocesousuario) throws Exception;

	public Resultadoprocesoporusuario selectByPrimaryKeyBasicFromList(java.lang.Integer par_idresultadoprocesousuario,List<Resultadoprocesoporusuario> list) throws Exception;

	public Resultadoprocesoporusuario selectByPrimaryKeyBasicActive(java.lang.Integer par_idresultadoprocesousuario) throws Exception;

	public Resultadoprocesoporusuario selectByPrimaryKeyFull(java.lang.Integer par_idresultadoprocesousuario) throws Exception;

	public Resultadoprocesoporusuario selectByPrimaryKeyFullActive(java.lang.Integer par_idresultadoprocesousuario) throws Exception;

	public List<Resultadoprocesoporusuario> selectDynamicBasic(Resultadoprocesoporusuario record) throws Exception;

	public List<Resultadoprocesoporusuario> selectDynamicBasicActives(Resultadoprocesoporusuario record) throws Exception;

	public List<Resultadoprocesoporusuario> selectDynamicFull(Resultadoprocesoporusuario record) throws Exception;

	public List<Resultadoprocesoporusuario> selectDynamicFullActives(Resultadoprocesoporusuario record) throws Exception;

	public List<Resultadoprocesoporusuario> selectDynamicExtended(Resultadoprocesoporusuario record) throws Exception;

	public List<Resultadoprocesoporusuario> selectDynamicExtendedActives(Resultadoprocesoporusuario record) throws Exception;

	public void updateByPrimaryKeySelectiveBasic(Resultadoprocesoporusuario record) throws Exception;

	public void updateByPrimaryKeySelectiveFull(Resultadoprocesoporusuario record) throws Exception;

	public void updateByPrimaryKeyBasic(Resultadoprocesoporusuario record) throws Exception;

	public void updateByPrimaryKeyFull(Resultadoprocesoporusuario record) throws Exception;


}
