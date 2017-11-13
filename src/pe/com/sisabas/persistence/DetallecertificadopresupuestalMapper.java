
package pe.com.sisabas.persistence;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import pe.com.sisabas.be.Detallecertificadopresupuestal;

public interface DetallecertificadopresupuestalMapper{

	int deleteByPrimaryKey(@Param("iddetallecertificadopresupuestal") java.lang.Integer iddetallecertificadopresupuestal) throws Exception;

	Detallecertificadopresupuestal selectByPrimaryKeyBasic(@Param("iddetallecertificadopresupuestal") java.lang.Integer iddetallecertificadopresupuestal) throws Exception;

	Detallecertificadopresupuestal selectByPrimaryKeyBasicActive(@Param("iddetallecertificadopresupuestal") java.lang.Integer iddetallecertificadopresupuestal) throws Exception;

	Detallecertificadopresupuestal selectByPrimaryKeyFull(@Param("iddetallecertificadopresupuestal") java.lang.Integer iddetallecertificadopresupuestal) throws Exception;

	Detallecertificadopresupuestal selectByPrimaryKeyFullActive(@Param("iddetallecertificadopresupuestal") java.lang.Integer iddetallecertificadopresupuestal) throws Exception;

	int updateByPrimaryKeySelective(Detallecertificadopresupuestal record) throws Exception;

	int updateByPrimaryKey(Detallecertificadopresupuestal record) throws Exception;

	int insert(Detallecertificadopresupuestal record) throws Exception;

	int insertSelective(Detallecertificadopresupuestal record) throws Exception;

	List<Detallecertificadopresupuestal> selectDynamicBasic(Detallecertificadopresupuestal record) throws Exception;

	List<Detallecertificadopresupuestal> selectDynamicFull(Detallecertificadopresupuestal record) throws Exception;

	List<Detallecertificadopresupuestal> selectDynamicExtended(Detallecertificadopresupuestal record) throws Exception;


}
