package pe.com.sisabas.business;
import java.util.List;
import pe.com.sisabas.be.Estadosporetapapordocumento;

public interface EstadosporetapapordocumentoBusiness{

	public void deleteByPrimaryKeyBasic(Estadosporetapapordocumento par_record) throws Exception;

	public void insertBasic(Estadosporetapapordocumento record) throws Exception;

	public void insertFull(Estadosporetapapordocumento record) throws Exception;

	public void insertSelectiveBasic(Estadosporetapapordocumento record) throws Exception;

	public Estadosporetapapordocumento selectByPrimaryKeyBasic(java.lang.Integer par_idestadosporetapapordocumento) throws Exception;

	public Estadosporetapapordocumento selectByPrimaryKeyBasicFromList(java.lang.Integer par_idestadosporetapapordocumento,List<Estadosporetapapordocumento> list) throws Exception;

	public Estadosporetapapordocumento selectByPrimaryKeyBasicActive(java.lang.Integer par_idestadosporetapapordocumento) throws Exception;

	public Estadosporetapapordocumento selectByPrimaryKeyFull(java.lang.Integer par_idestadosporetapapordocumento) throws Exception;

	public Estadosporetapapordocumento selectByPrimaryKeyFullActive(java.lang.Integer par_idestadosporetapapordocumento) throws Exception;

	public List<Estadosporetapapordocumento> selectDynamicBasic(Estadosporetapapordocumento record) throws Exception;

	public List<Estadosporetapapordocumento> selectDynamicBasicActives(Estadosporetapapordocumento record) throws Exception;

	public List<Estadosporetapapordocumento> selectDynamicFull(Estadosporetapapordocumento record) throws Exception;

	public List<Estadosporetapapordocumento> selectDynamicFullActives(Estadosporetapapordocumento record) throws Exception;

	public List<Estadosporetapapordocumento> selectDynamicExtended(Estadosporetapapordocumento record) throws Exception;

	public List<Estadosporetapapordocumento> selectDynamicExtendedActives(Estadosporetapapordocumento record) throws Exception;

	public void updateByPrimaryKeySelectiveBasic(Estadosporetapapordocumento record) throws Exception;

	public void updateByPrimaryKeySelectiveFull(Estadosporetapapordocumento record) throws Exception;

	public void updateByPrimaryKeyBasic(Estadosporetapapordocumento record) throws Exception;

	public void updateByPrimaryKeyFull(Estadosporetapapordocumento record) throws Exception;


}
