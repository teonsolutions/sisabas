package pe.com.sisabas.business;
import java.util.List;
import pe.com.sisabas.be.Estadospordocumentosiga;

public interface EstadospordocumentosigaBusiness{

	public void deleteByPrimaryKeyBasic(Estadospordocumentosiga par_record) throws Exception;

	public void insertBasic(Estadospordocumentosiga record) throws Exception;

	public void insertFull(Estadospordocumentosiga record) throws Exception;

	public void insertSelectiveBasic(Estadospordocumentosiga record) throws Exception;

	public Estadospordocumentosiga selectByPrimaryKeyBasic(java.lang.Integer par_idestadospordocumentosiga) throws Exception;

	public Estadospordocumentosiga selectByPrimaryKeyBasicFromList(java.lang.Integer par_idestadospordocumentosiga,List<Estadospordocumentosiga> list) throws Exception;

	public Estadospordocumentosiga selectByPrimaryKeyBasicActive(java.lang.Integer par_idestadospordocumentosiga) throws Exception;

	public Estadospordocumentosiga selectByPrimaryKeyFull(java.lang.Integer par_idestadospordocumentosiga) throws Exception;

	public Estadospordocumentosiga selectByPrimaryKeyFullActive(java.lang.Integer par_idestadospordocumentosiga) throws Exception;

	public List<Estadospordocumentosiga> selectDynamicBasic(Estadospordocumentosiga record) throws Exception;

	public List<Estadospordocumentosiga> selectDynamicBasicActives(Estadospordocumentosiga record) throws Exception;

	public List<Estadospordocumentosiga> selectDynamicFull(Estadospordocumentosiga record) throws Exception;

	public List<Estadospordocumentosiga> selectDynamicFullActives(Estadospordocumentosiga record) throws Exception;

	public List<Estadospordocumentosiga> selectDynamicExtended(Estadospordocumentosiga record) throws Exception;

	public List<Estadospordocumentosiga> selectDynamicExtendedActives(Estadospordocumentosiga record) throws Exception;

	public void updateByPrimaryKeySelectiveBasic(Estadospordocumentosiga record) throws Exception;

	public void updateByPrimaryKeySelectiveFull(Estadospordocumentosiga record) throws Exception;

	public void updateByPrimaryKeyBasic(Estadospordocumentosiga record) throws Exception;

	public void updateByPrimaryKeyFull(Estadospordocumentosiga record) throws Exception;


}
