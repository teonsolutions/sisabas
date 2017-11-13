package pe.com.sisabas.business;
import java.util.List;
import pe.com.sisabas.be.Certificadopresupuestal;

public interface CertificadopresupuestalBusiness{

	public void deleteByPrimaryKeyBasic(Certificadopresupuestal par_record) throws Exception;

	public void insertBasic(Certificadopresupuestal record) throws Exception;

	public void insertFull(Certificadopresupuestal record) throws Exception;

	public void insertSelectiveBasic(Certificadopresupuestal record) throws Exception;

	public Certificadopresupuestal selectByPrimaryKeyBasic(java.lang.Integer par_idcertificadopresupuestal) throws Exception;

	public Certificadopresupuestal selectByPrimaryKeyBasicFromList(java.lang.Integer par_idcertificadopresupuestal,List<Certificadopresupuestal> list) throws Exception;

	public Certificadopresupuestal selectByPrimaryKeyBasicActive(java.lang.Integer par_idcertificadopresupuestal) throws Exception;

	public Certificadopresupuestal selectByPrimaryKeyFull(java.lang.Integer par_idcertificadopresupuestal) throws Exception;

	public Certificadopresupuestal selectByPrimaryKeyFullActive(java.lang.Integer par_idcertificadopresupuestal) throws Exception;

	public List<Certificadopresupuestal> selectDynamicBasic(Certificadopresupuestal record) throws Exception;

	public List<Certificadopresupuestal> selectDynamicBasicActives(Certificadopresupuestal record) throws Exception;

	public List<Certificadopresupuestal> selectDynamicFull(Certificadopresupuestal record) throws Exception;

	public List<Certificadopresupuestal> selectDynamicFullActives(Certificadopresupuestal record) throws Exception;

	public List<Certificadopresupuestal> selectDynamicExtended(Certificadopresupuestal record) throws Exception;

	public List<Certificadopresupuestal> selectDynamicExtendedActives(Certificadopresupuestal record) throws Exception;

	public void updateByPrimaryKeySelectiveBasic(Certificadopresupuestal record) throws Exception;

	public void updateByPrimaryKeySelectiveFull(Certificadopresupuestal record) throws Exception;

	public void updateByPrimaryKeyBasic(Certificadopresupuestal record) throws Exception;

	public void updateByPrimaryKeyFull(Certificadopresupuestal record) throws Exception;


}
