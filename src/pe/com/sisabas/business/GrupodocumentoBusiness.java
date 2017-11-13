package pe.com.sisabas.business;
import java.util.List;
import pe.com.sisabas.be.Grupodocumento;

public interface GrupodocumentoBusiness{

	public void deleteByPrimaryKeyBasic(Grupodocumento par_record) throws Exception;

	public void insertBasic(Grupodocumento record) throws Exception;

	public void insertFull(Grupodocumento record) throws Exception;

	public void insertSelectiveBasic(Grupodocumento record) throws Exception;

	public Grupodocumento selectByPrimaryKeyBasic(java.lang.Integer par_idgrupodocumento) throws Exception;

	public Grupodocumento selectByPrimaryKeyBasicFromList(java.lang.Integer par_idgrupodocumento,List<Grupodocumento> list) throws Exception;

	public Grupodocumento selectByPrimaryKeyBasicActive(java.lang.Integer par_idgrupodocumento) throws Exception;

	public Grupodocumento selectByPrimaryKeyFull(java.lang.Integer par_idgrupodocumento) throws Exception;

	public Grupodocumento selectByPrimaryKeyFullActive(java.lang.Integer par_idgrupodocumento) throws Exception;

	public List<Grupodocumento> selectDynamicBasic(Grupodocumento record) throws Exception;

	public List<Grupodocumento> selectDynamicBasicActives(Grupodocumento record) throws Exception;

	public List<Grupodocumento> selectDynamicFull(Grupodocumento record) throws Exception;

	public List<Grupodocumento> selectDynamicFullActives(Grupodocumento record) throws Exception;

	public List<Grupodocumento> selectDynamicExtended(Grupodocumento record) throws Exception;

	public List<Grupodocumento> selectDynamicExtendedActives(Grupodocumento record) throws Exception;

	public void updateByPrimaryKeySelectiveBasic(Grupodocumento record) throws Exception;

	public void updateByPrimaryKeySelectiveFull(Grupodocumento record) throws Exception;

	public void updateByPrimaryKeyBasic(Grupodocumento record) throws Exception;

	public void updateByPrimaryKeyFull(Grupodocumento record) throws Exception;


}
