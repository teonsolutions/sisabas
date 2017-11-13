package pe.com.sisabas.business;
import java.util.List;
import pe.com.sisabas.be.Gentipo;

public interface GentipoBusiness{

	public void deleteByPrimaryKeyBasic(Gentipo par_record) throws Exception;

	public void insertBasic(Gentipo record) throws Exception;

	public void insertFull(Gentipo record) throws Exception;

	public void insertSelectiveBasic(Gentipo record) throws Exception;

	public Gentipo selectByPrimaryKeyBasic(java.lang.String par_vchtipcodigo) throws Exception;

	public Gentipo selectByPrimaryKeyBasicFromList(java.lang.String par_vchtipcodigo,List<Gentipo> list) throws Exception;

	public Gentipo selectByPrimaryKeyBasicActive(java.lang.String par_vchtipcodigo) throws Exception;

	public Gentipo selectByPrimaryKeyFull(java.lang.String par_vchtipcodigo) throws Exception;

	public Gentipo selectByPrimaryKeyFullActive(java.lang.String par_vchtipcodigo) throws Exception;

	public List<Gentipo> selectDynamicBasic(Gentipo record) throws Exception;

	public List<Gentipo> selectDynamicBasicActives(Gentipo record) throws Exception;

	public List<Gentipo> selectDynamicFull(Gentipo record) throws Exception;

	public List<Gentipo> selectDynamicFullActives(Gentipo record) throws Exception;

	public List<Gentipo> selectDynamicExtended(Gentipo record) throws Exception;

	public List<Gentipo> selectDynamicExtendedActives(Gentipo record) throws Exception;

	public void updateByPrimaryKeySelectiveBasic(Gentipo record) throws Exception;

	public void updateByPrimaryKeySelectiveFull(Gentipo record) throws Exception;

	public void updateByPrimaryKeyBasic(Gentipo record) throws Exception;

	public void updateByPrimaryKeyFull(Gentipo record) throws Exception;


}
