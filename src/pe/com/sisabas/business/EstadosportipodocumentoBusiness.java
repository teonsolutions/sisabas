package pe.com.sisabas.business;
import java.util.List;
import pe.com.sisabas.be.Estadosportipodocumento;

public interface EstadosportipodocumentoBusiness{

	public void deleteByPrimaryKeyBasic(Estadosportipodocumento par_record) throws Exception;

	public void insertBasic(Estadosportipodocumento record) throws Exception;

	public void insertFull(Estadosportipodocumento record) throws Exception;

	public void insertSelectiveBasic(Estadosportipodocumento record) throws Exception;

	public Estadosportipodocumento selectByPrimaryKeyBasic(java.lang.Integer par_idestadosportipodocumento) throws Exception;

	public Estadosportipodocumento selectByPrimaryKeyBasicFromList(java.lang.Integer par_idestadosportipodocumento,List<Estadosportipodocumento> list) throws Exception;

	public Estadosportipodocumento selectByPrimaryKeyBasicActive(java.lang.Integer par_idestadosportipodocumento) throws Exception;

	public Estadosportipodocumento selectByPrimaryKeyFull(java.lang.Integer par_idestadosportipodocumento) throws Exception;

	public Estadosportipodocumento selectByPrimaryKeyFullActive(java.lang.Integer par_idestadosportipodocumento) throws Exception;

	public List<Estadosportipodocumento> selectDynamicBasic(Estadosportipodocumento record) throws Exception;

	public List<Estadosportipodocumento> selectDynamicBasicActives(Estadosportipodocumento record) throws Exception;

	public List<Estadosportipodocumento> selectDynamicFull(Estadosportipodocumento record) throws Exception;

	public List<Estadosportipodocumento> selectDynamicFullActives(Estadosportipodocumento record) throws Exception;

	public List<Estadosportipodocumento> selectDynamicExtended(Estadosportipodocumento record) throws Exception;

	public List<Estadosportipodocumento> selectDynamicExtendedActives(Estadosportipodocumento record) throws Exception;

	public void updateByPrimaryKeySelectiveBasic(Estadosportipodocumento record) throws Exception;

	public void updateByPrimaryKeySelectiveFull(Estadosportipodocumento record) throws Exception;

	public void updateByPrimaryKeyBasic(Estadosportipodocumento record) throws Exception;

	public void updateByPrimaryKeyFull(Estadosportipodocumento record) throws Exception;


}
