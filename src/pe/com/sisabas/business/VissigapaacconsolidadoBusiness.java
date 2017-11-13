package pe.com.sisabas.business;
import java.util.List;
import pe.com.sisabas.be.Vissigapaacconsolidado;

public interface VissigapaacconsolidadoBusiness{

	public void deleteByPrimaryKeyBasic(Vissigapaacconsolidado par_record) throws Exception;

	public void insertBasic(Vissigapaacconsolidado record) throws Exception;

	public void insertFull(Vissigapaacconsolidado record) throws Exception;

	public void insertSelectiveBasic(Vissigapaacconsolidado record) throws Exception;

	public Vissigapaacconsolidado selectByPrimaryKeyBasic(java.lang.Integer par_visidsigapaacconsolidado) throws Exception;

	public Vissigapaacconsolidado selectByPrimaryKeyBasicFromList(java.lang.Integer par_visidsigapaacconsolidado,List<Vissigapaacconsolidado> list) throws Exception;

	public Vissigapaacconsolidado selectByPrimaryKeyBasicActive(java.lang.Integer par_visidsigapaacconsolidado) throws Exception;

	public Vissigapaacconsolidado selectByPrimaryKeyFull(java.lang.Integer par_visidsigapaacconsolidado) throws Exception;

	public Vissigapaacconsolidado selectByPrimaryKeyFullActive(java.lang.Integer par_visidsigapaacconsolidado) throws Exception;

	public List<Vissigapaacconsolidado> selectDynamicBasic(Vissigapaacconsolidado record) throws Exception;

	public List<Vissigapaacconsolidado> selectDynamicBasicActives(Vissigapaacconsolidado record) throws Exception;

	public List<Vissigapaacconsolidado> selectDynamicFull(Vissigapaacconsolidado record) throws Exception;

	public List<Vissigapaacconsolidado> selectDynamicFullActives(Vissigapaacconsolidado record) throws Exception;

	public List<Vissigapaacconsolidado> selectDynamicExtended(Vissigapaacconsolidado record) throws Exception;

	public List<Vissigapaacconsolidado> selectDynamicExtendedActives(Vissigapaacconsolidado record) throws Exception;

	public void updateByPrimaryKeySelectiveBasic(Vissigapaacconsolidado record) throws Exception;

	public void updateByPrimaryKeySelectiveFull(Vissigapaacconsolidado record) throws Exception;

	public void updateByPrimaryKeyBasic(Vissigapaacconsolidado record) throws Exception;

	public void updateByPrimaryKeyFull(Vissigapaacconsolidado record) throws Exception;


}
