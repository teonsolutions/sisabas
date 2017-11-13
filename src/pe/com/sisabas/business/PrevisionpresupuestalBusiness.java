package pe.com.sisabas.business;
import java.util.List;
import pe.com.sisabas.be.Previsionpresupuestal;

public interface PrevisionpresupuestalBusiness{

	public void deleteByPrimaryKeyBasic(Previsionpresupuestal par_record) throws Exception;

	public void insertBasic(Previsionpresupuestal record) throws Exception;

	public void insertFull(Previsionpresupuestal record) throws Exception;

	public void insertSelectiveBasic(Previsionpresupuestal record) throws Exception;

	public Previsionpresupuestal selectByPrimaryKeyBasic(java.lang.Integer par_idprevisionpresupuestal) throws Exception;

	public Previsionpresupuestal selectByPrimaryKeyBasicFromList(java.lang.Integer par_idprevisionpresupuestal,List<Previsionpresupuestal> list) throws Exception;

	public Previsionpresupuestal selectByPrimaryKeyBasicActive(java.lang.Integer par_idprevisionpresupuestal) throws Exception;

	public Previsionpresupuestal selectByPrimaryKeyFull(java.lang.Integer par_idprevisionpresupuestal) throws Exception;

	public Previsionpresupuestal selectByPrimaryKeyFullActive(java.lang.Integer par_idprevisionpresupuestal) throws Exception;

	public List<Previsionpresupuestal> selectDynamicBasic(Previsionpresupuestal record) throws Exception;

	public List<Previsionpresupuestal> selectDynamicBasicActives(Previsionpresupuestal record) throws Exception;

	public List<Previsionpresupuestal> selectDynamicFull(Previsionpresupuestal record) throws Exception;

	public List<Previsionpresupuestal> selectDynamicFullActives(Previsionpresupuestal record) throws Exception;

	public List<Previsionpresupuestal> selectDynamicExtended(Previsionpresupuestal record) throws Exception;

	public List<Previsionpresupuestal> selectDynamicExtendedActives(Previsionpresupuestal record) throws Exception;

	public void updateByPrimaryKeySelectiveBasic(Previsionpresupuestal record) throws Exception;

	public void updateByPrimaryKeySelectiveFull(Previsionpresupuestal record) throws Exception;

	public void updateByPrimaryKeyBasic(Previsionpresupuestal record) throws Exception;

	public void updateByPrimaryKeyFull(Previsionpresupuestal record) throws Exception;


}
