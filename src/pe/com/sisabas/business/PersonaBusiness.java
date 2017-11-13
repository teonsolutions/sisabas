package pe.com.sisabas.business;
import java.util.List;
import pe.com.sisabas.be.Persona;

public interface PersonaBusiness{

	public void deleteByPrimaryKeyBasic(Persona par_record) throws Exception;

	public void insertBasic(Persona record) throws Exception;

	public void insertFull(Persona record) throws Exception;

	public void insertSelectiveBasic(Persona record) throws Exception;

	public Persona selectByPrimaryKeyBasic(java.lang.Integer par_idpersona) throws Exception;

	public Persona selectByPrimaryKeyBasicFromList(java.lang.Integer par_idpersona,List<Persona> list) throws Exception;

	public Persona selectByPrimaryKeyBasicActive(java.lang.Integer par_idpersona) throws Exception;

	public Persona selectByPrimaryKeyFull(java.lang.Integer par_idpersona) throws Exception;

	public Persona selectByPrimaryKeyFullActive(java.lang.Integer par_idpersona) throws Exception;

	public List<Persona> selectDynamicBasic(Persona record) throws Exception;

	public List<Persona> selectDynamicBasicActives(Persona record) throws Exception;

	public List<Persona> selectDynamicFull(Persona record) throws Exception;

	public List<Persona> selectDynamicFullActives(Persona record) throws Exception;

	public List<Persona> selectDynamicExtended(Persona record) throws Exception;

	public List<Persona> selectDynamicExtendedActives(Persona record) throws Exception;

	public void updateByPrimaryKeySelectiveBasic(Persona record) throws Exception;

	public void updateByPrimaryKeySelectiveFull(Persona record) throws Exception;

	public void updateByPrimaryKeyBasic(Persona record) throws Exception;

	public void updateByPrimaryKeyFull(Persona record) throws Exception;


}
