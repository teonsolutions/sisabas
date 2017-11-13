package pe.com.sisabas.business;
import java.util.List;
import pe.com.sisabas.be.Detallecertificadopresupuestal;

public interface DetallecertificadopresupuestalBusiness{

	public void deleteByPrimaryKeyBasic(Detallecertificadopresupuestal par_record) throws Exception;

	public void insertBasic(Detallecertificadopresupuestal record) throws Exception;

	public void insertFull(Detallecertificadopresupuestal record) throws Exception;

	public void insertSelectiveBasic(Detallecertificadopresupuestal record) throws Exception;

	public Detallecertificadopresupuestal selectByPrimaryKeyBasic(java.lang.Integer par_iddetallecertificadopresupuestal) throws Exception;

	public Detallecertificadopresupuestal selectByPrimaryKeyBasicFromList(java.lang.Integer par_iddetallecertificadopresupuestal,List<Detallecertificadopresupuestal> list) throws Exception;

	public Detallecertificadopresupuestal selectByPrimaryKeyBasicActive(java.lang.Integer par_iddetallecertificadopresupuestal) throws Exception;

	public Detallecertificadopresupuestal selectByPrimaryKeyFull(java.lang.Integer par_iddetallecertificadopresupuestal) throws Exception;

	public Detallecertificadopresupuestal selectByPrimaryKeyFullActive(java.lang.Integer par_iddetallecertificadopresupuestal) throws Exception;

	public List<Detallecertificadopresupuestal> selectDynamicBasic(Detallecertificadopresupuestal record) throws Exception;

	public List<Detallecertificadopresupuestal> selectDynamicBasicActives(Detallecertificadopresupuestal record) throws Exception;

	public List<Detallecertificadopresupuestal> selectDynamicFull(Detallecertificadopresupuestal record) throws Exception;

	public List<Detallecertificadopresupuestal> selectDynamicFullActives(Detallecertificadopresupuestal record) throws Exception;

	public List<Detallecertificadopresupuestal> selectDynamicExtended(Detallecertificadopresupuestal record) throws Exception;

	public List<Detallecertificadopresupuestal> selectDynamicExtendedActives(Detallecertificadopresupuestal record) throws Exception;

	public void updateByPrimaryKeySelectiveBasic(Detallecertificadopresupuestal record) throws Exception;

	public void updateByPrimaryKeySelectiveFull(Detallecertificadopresupuestal record) throws Exception;

	public void updateByPrimaryKeyBasic(Detallecertificadopresupuestal record) throws Exception;

	public void updateByPrimaryKeyFull(Detallecertificadopresupuestal record) throws Exception;


}
