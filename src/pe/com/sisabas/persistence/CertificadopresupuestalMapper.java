
package pe.com.sisabas.persistence;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import pe.com.sisabas.be.Certificadopresupuestal;

public interface CertificadopresupuestalMapper{

	int deleteByPrimaryKey(@Param("idcertificadopresupuestal") java.lang.Integer idcertificadopresupuestal) throws Exception;

	Certificadopresupuestal selectByPrimaryKeyBasic(@Param("idcertificadopresupuestal") java.lang.Integer idcertificadopresupuestal) throws Exception;

	Certificadopresupuestal selectByPrimaryKeyBasicActive(@Param("idcertificadopresupuestal") java.lang.Integer idcertificadopresupuestal) throws Exception;

	Certificadopresupuestal selectByPrimaryKeyFull(@Param("idcertificadopresupuestal") java.lang.Integer idcertificadopresupuestal) throws Exception;

	Certificadopresupuestal selectByPrimaryKeyFullActive(@Param("idcertificadopresupuestal") java.lang.Integer idcertificadopresupuestal) throws Exception;

	int updateByPrimaryKeySelective(Certificadopresupuestal record) throws Exception;

	int updateByPrimaryKey(Certificadopresupuestal record) throws Exception;

	int insert(Certificadopresupuestal record) throws Exception;

	int insertSelective(Certificadopresupuestal record) throws Exception;

	List<Certificadopresupuestal> selectDynamicBasic(Certificadopresupuestal record) throws Exception;

	List<Certificadopresupuestal> selectDynamicFull(Certificadopresupuestal record) throws Exception;

	List<Certificadopresupuestal> selectDynamicExtended(Certificadopresupuestal record) throws Exception;


}
