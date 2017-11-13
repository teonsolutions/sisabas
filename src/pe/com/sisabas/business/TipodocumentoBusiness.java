package pe.com.sisabas.business;
import java.util.List;
import pe.com.sisabas.be.Tipodocumento;

public interface TipodocumentoBusiness{

	public void deleteByPrimaryKeyBasic(Tipodocumento par_record) throws Exception;

	public void insertBasic(Tipodocumento record) throws Exception;

	public void insertFull(Tipodocumento record) throws Exception;

	public void insertSelectiveBasic(Tipodocumento record) throws Exception;

	public Tipodocumento selectByPrimaryKeyBasic(java.lang.Integer par_idtipodocumento) throws Exception;

	public Tipodocumento selectByPrimaryKeyBasicFromList(java.lang.Integer par_idtipodocumento,List<Tipodocumento> list) throws Exception;

	public Tipodocumento selectByPrimaryKeyBasicActive(java.lang.Integer par_idtipodocumento) throws Exception;

	public Tipodocumento selectByPrimaryKeyFull(java.lang.Integer par_idtipodocumento) throws Exception;

	public Tipodocumento selectByPrimaryKeyFullActive(java.lang.Integer par_idtipodocumento) throws Exception;

	public List<Tipodocumento> selectDynamicBasic(Tipodocumento record) throws Exception;

	public List<Tipodocumento> selectDynamicBasicActives(Tipodocumento record) throws Exception;

	public List<Tipodocumento> selectDynamicFull(Tipodocumento record) throws Exception;

	public List<Tipodocumento> selectDynamicFullActives(Tipodocumento record) throws Exception;

	public List<Tipodocumento> selectDynamicExtended(Tipodocumento record) throws Exception;

	public List<Tipodocumento> selectDynamicExtendedActives(Tipodocumento record) throws Exception;

	public void updateByPrimaryKeySelectiveBasic(Tipodocumento record) throws Exception;

	public void updateByPrimaryKeySelectiveFull(Tipodocumento record) throws Exception;

	public void updateByPrimaryKeyBasic(Tipodocumento record) throws Exception;

	public void updateByPrimaryKeyFull(Tipodocumento record) throws Exception;


}
