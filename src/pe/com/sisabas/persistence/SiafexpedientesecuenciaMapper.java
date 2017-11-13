
package pe.com.sisabas.persistence;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import pe.com.sisabas.be.Siafexpedientesecuencia;

public interface SiafexpedientesecuenciaMapper{

	int deleteByPrimaryKey(@Param("idsiafexpedientesecuencia") java.lang.Integer idsiafexpedientesecuencia) throws Exception;

	Siafexpedientesecuencia selectByPrimaryKeyBasic(@Param("idsiafexpedientesecuencia") java.lang.Integer idsiafexpedientesecuencia) throws Exception;

	Siafexpedientesecuencia selectByPrimaryKeyBasicActive(@Param("idsiafexpedientesecuencia") java.lang.Integer idsiafexpedientesecuencia) throws Exception;

	Siafexpedientesecuencia selectByPrimaryKeyFull(@Param("idsiafexpedientesecuencia") java.lang.Integer idsiafexpedientesecuencia) throws Exception;

	Siafexpedientesecuencia selectByPrimaryKeyFullActive(@Param("idsiafexpedientesecuencia") java.lang.Integer idsiafexpedientesecuencia) throws Exception;

	int updateByPrimaryKeySelective(Siafexpedientesecuencia record) throws Exception;

	int updateByPrimaryKey(Siafexpedientesecuencia record) throws Exception;

	int insert(Siafexpedientesecuencia record) throws Exception;

	int insertSelective(Siafexpedientesecuencia record) throws Exception;

	List<Siafexpedientesecuencia> selectDynamicBasic(Siafexpedientesecuencia record) throws Exception;

	List<Siafexpedientesecuencia> selectDynamicFull(Siafexpedientesecuencia record) throws Exception;

	List<Siafexpedientesecuencia> selectDynamicExtended(Siafexpedientesecuencia record) throws Exception;


}
