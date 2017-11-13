package pe.com.sisabas.business;
import java.util.List;
import pe.com.sisabas.be.Gentabla;

public interface GentablaBusiness{

	public void deleteByPrimaryKeyBasic(Gentabla par_record) throws Exception;

	public void insertBasic(Gentabla record) throws Exception;

	public void insertFull(Gentabla record) throws Exception;

	public void insertSelectiveBasic(Gentabla record) throws Exception;

	public Gentabla selectByPrimaryKeyBasic(java.lang.String par_vchregcodigo) throws Exception;

	public Gentabla selectByPrimaryKeyBasicFromList(java.lang.String par_vchregcodigo,List<Gentabla> list) throws Exception;

	public Gentabla selectByPrimaryKeyBasicActive(java.lang.String par_vchregcodigo) throws Exception;

	public Gentabla selectByPrimaryKeyFull(java.lang.String par_vchregcodigo) throws Exception;

	public Gentabla selectByPrimaryKeyFullActive(java.lang.String par_vchregcodigo) throws Exception;

	public List<Gentabla> selectDynamicBasic(Gentabla record) throws Exception;

	public List<Gentabla> selectDynamicBasicActives(Gentabla record) throws Exception;

	public List<Gentabla> selectDynamicFull(Gentabla record) throws Exception;

	public List<Gentabla> selectDynamicFullActives(Gentabla record) throws Exception;

	public List<Gentabla> selectDynamicExtended(Gentabla record) throws Exception;

	public List<Gentabla> selectDynamicExtendedActives(Gentabla record) throws Exception;

	public void updateByPrimaryKeySelectiveBasic(Gentabla record) throws Exception;

	public void updateByPrimaryKeySelectiveFull(Gentabla record) throws Exception;

	public void updateByPrimaryKeyBasic(Gentabla record) throws Exception;

	public void updateByPrimaryKeyFull(Gentabla record) throws Exception;


}
