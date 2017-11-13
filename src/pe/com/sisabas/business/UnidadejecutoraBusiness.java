package pe.com.sisabas.business;
import java.util.List;
import pe.com.sisabas.be.Unidadejecutora;

public interface UnidadejecutoraBusiness{

	public void deleteByPrimaryKeyBasic(Unidadejecutora par_record) throws Exception;

	public void insertBasic(Unidadejecutora record) throws Exception;

	public void insertFull(Unidadejecutora record) throws Exception;

	public void insertSelectiveBasic(Unidadejecutora record) throws Exception;

	public Unidadejecutora selectByPrimaryKeyBasic(java.lang.Integer par_idunidadejecutora) throws Exception;

	public Unidadejecutora selectByPrimaryKeyBasicFromList(java.lang.Integer par_idunidadejecutora,List<Unidadejecutora> list) throws Exception;

	public Unidadejecutora selectByPrimaryKeyBasicActive(java.lang.Integer par_idunidadejecutora) throws Exception;

	public Unidadejecutora selectByPrimaryKeyFull(java.lang.Integer par_idunidadejecutora) throws Exception;

	public Unidadejecutora selectByPrimaryKeyFullActive(java.lang.Integer par_idunidadejecutora) throws Exception;

	public List<Unidadejecutora> selectDynamicBasic(Unidadejecutora record) throws Exception;

	public List<Unidadejecutora> selectDynamicBasicActives(Unidadejecutora record) throws Exception;

	public List<Unidadejecutora> selectDynamicFull(Unidadejecutora record) throws Exception;

	public List<Unidadejecutora> selectDynamicFullActives(Unidadejecutora record) throws Exception;

	public List<Unidadejecutora> selectDynamicExtended(Unidadejecutora record) throws Exception;

	public List<Unidadejecutora> selectDynamicExtendedActives(Unidadejecutora record) throws Exception;

	public void updateByPrimaryKeySelectiveBasic(Unidadejecutora record) throws Exception;

	public void updateByPrimaryKeySelectiveFull(Unidadejecutora record) throws Exception;

	public void updateByPrimaryKeyBasic(Unidadejecutora record) throws Exception;

	public void updateByPrimaryKeyFull(Unidadejecutora record) throws Exception;


}
