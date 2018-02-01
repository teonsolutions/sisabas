package pe.com.sisabas.business;
import java.util.List;
import pe.com.sisabas.be.Adenda;

public interface AdendaBusiness{

	public void deleteByPrimaryKeyBasic(Adenda par_record) throws Exception;

	public void insertBasic(Adenda record) throws Exception;

	public void insertFull(Adenda record) throws Exception;

	public void insertSelectiveBasic(Adenda record) throws Exception;

	public Adenda selectByPrimaryKeyBasic(java.lang.Integer par_idadenda) throws Exception;

	public Adenda selectByPrimaryKeyBasicFromList(java.lang.Integer par_idadenda,List<Adenda> list) throws Exception;

	public Adenda selectByPrimaryKeyBasicActive(java.lang.Integer par_idadenda) throws Exception;

	public Adenda selectByPrimaryKeyFull(java.lang.Integer par_idadenda) throws Exception;

	public Adenda selectByPrimaryKeyFullActive(java.lang.Integer par_idadenda) throws Exception;

	public List<Adenda> selectDynamicBasic(Adenda record) throws Exception;

	public List<Adenda> selectDynamicBasicActives(Adenda record) throws Exception;

	public List<Adenda> selectDynamicFull(Adenda record) throws Exception;

	public List<Adenda> selectDynamicFullActives(Adenda record) throws Exception;

	public List<Adenda> selectDynamicExtended(Adenda record) throws Exception;

	public List<Adenda> selectDynamicExtendedActives(Adenda record) throws Exception;

	public void updateByPrimaryKeySelectiveBasic(Adenda record) throws Exception;

	public void updateByPrimaryKeySelectiveFull(Adenda record) throws Exception;

	public void updateByPrimaryKeyBasic(Adenda record) throws Exception;

	public void updateByPrimaryKeyFull(Adenda record) throws Exception;


}
