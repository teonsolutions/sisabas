package pe.com.sisabas.business;
import java.util.List;
import pe.com.sisabas.be.Genparametro;

public interface GenparametroBusiness{

	public void deleteByPrimaryKeyBasic(Genparametro par_record) throws Exception;

	public void insertBasic(Genparametro record) throws Exception;

	public void insertFull(Genparametro record) throws Exception;

	public void insertSelectiveBasic(Genparametro record) throws Exception;

	public Genparametro selectByPrimaryKeyBasic(java.lang.String par_vchparamcodigo) throws Exception;

	public Genparametro selectByPrimaryKeyBasicFromList(java.lang.String par_vchparamcodigo,List<Genparametro> list) throws Exception;

	public Genparametro selectByPrimaryKeyBasicActive(java.lang.String par_vchparamcodigo) throws Exception;

	public Genparametro selectByPrimaryKeyFull(java.lang.String par_vchparamcodigo) throws Exception;

	public Genparametro selectByPrimaryKeyFullActive(java.lang.String par_vchparamcodigo) throws Exception;

	public List<Genparametro> selectDynamicBasic(Genparametro record) throws Exception;

	public List<Genparametro> selectDynamicBasicActives(Genparametro record) throws Exception;

	public List<Genparametro> selectDynamicFull(Genparametro record) throws Exception;

	public List<Genparametro> selectDynamicFullActives(Genparametro record) throws Exception;

	public List<Genparametro> selectDynamicExtended(Genparametro record) throws Exception;

	public List<Genparametro> selectDynamicExtendedActives(Genparametro record) throws Exception;

	public void updateByPrimaryKeySelectiveBasic(Genparametro record) throws Exception;

	public void updateByPrimaryKeySelectiveFull(Genparametro record) throws Exception;

	public void updateByPrimaryKeyBasic(Genparametro record) throws Exception;

	public void updateByPrimaryKeyFull(Genparametro record) throws Exception;


}
