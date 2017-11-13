package pe.com.sisabas.business;
import java.util.List;
import pe.com.sisabas.be.Requisitosconformidad;

public interface RequisitosconformidadBusiness{

	public void deleteByPrimaryKeyBasic(Requisitosconformidad par_record) throws Exception;

	public void insertBasic(Requisitosconformidad record) throws Exception;

	public void insertFull(Requisitosconformidad record) throws Exception;

	public void insertSelectiveBasic(Requisitosconformidad record) throws Exception;

	public Requisitosconformidad selectByPrimaryKeyBasic(java.lang.Integer par_idrequisitoconformidad) throws Exception;

	public Requisitosconformidad selectByPrimaryKeyBasicFromList(java.lang.Integer par_idrequisitoconformidad,List<Requisitosconformidad> list) throws Exception;

	public Requisitosconformidad selectByPrimaryKeyBasicActive(java.lang.Integer par_idrequisitoconformidad) throws Exception;

	public Requisitosconformidad selectByPrimaryKeyFull(java.lang.Integer par_idrequisitoconformidad) throws Exception;

	public Requisitosconformidad selectByPrimaryKeyFullActive(java.lang.Integer par_idrequisitoconformidad) throws Exception;

	public List<Requisitosconformidad> selectDynamicBasic(Requisitosconformidad record) throws Exception;

	public List<Requisitosconformidad> selectDynamicBasicActives(Requisitosconformidad record) throws Exception;

	public List<Requisitosconformidad> selectDynamicFull(Requisitosconformidad record) throws Exception;

	public List<Requisitosconformidad> selectDynamicFullActives(Requisitosconformidad record) throws Exception;

	public List<Requisitosconformidad> selectDynamicExtended(Requisitosconformidad record) throws Exception;

	public List<Requisitosconformidad> selectDynamicExtendedActives(Requisitosconformidad record) throws Exception;

	public void updateByPrimaryKeySelectiveBasic(Requisitosconformidad record) throws Exception;

	public void updateByPrimaryKeySelectiveFull(Requisitosconformidad record) throws Exception;

	public void updateByPrimaryKeyBasic(Requisitosconformidad record) throws Exception;

	public void updateByPrimaryKeyFull(Requisitosconformidad record) throws Exception;


}
