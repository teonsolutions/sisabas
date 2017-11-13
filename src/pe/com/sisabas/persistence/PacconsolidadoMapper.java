
package pe.com.sisabas.persistence;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import pe.com.sisabas.be.Pacconsolidado;

public interface PacconsolidadoMapper{

	int deleteByPrimaryKey(@Param("idpacconsolidado") java.lang.Integer idpacconsolidado) throws Exception;

	Pacconsolidado selectByPrimaryKeyBasic(@Param("idpacconsolidado") java.lang.Integer idpacconsolidado) throws Exception;

	Pacconsolidado selectByPrimaryKeyBasicActive(@Param("idpacconsolidado") java.lang.Integer idpacconsolidado) throws Exception;

	Pacconsolidado selectByPrimaryKeyFull(@Param("idpacconsolidado") java.lang.Integer idpacconsolidado) throws Exception;

	Pacconsolidado selectByPrimaryKeyFullActive(@Param("idpacconsolidado") java.lang.Integer idpacconsolidado) throws Exception;

	int updateByPrimaryKeySelective(Pacconsolidado record) throws Exception;

	int updateByPrimaryKey(Pacconsolidado record) throws Exception;

	int insert(Pacconsolidado record) throws Exception;

	int insertSelective(Pacconsolidado record) throws Exception;

	List<Pacconsolidado> selectDynamicBasic(Pacconsolidado record) throws Exception;

	List<Pacconsolidado> selectDynamicFull(Pacconsolidado record) throws Exception;

	List<Pacconsolidado> selectDynamicExtended(Pacconsolidado record) throws Exception;


}
