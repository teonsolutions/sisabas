
package pe.com.sisabas.persistence;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import pe.com.sisabas.be.Periodo;

public interface PeriodoMapper{

	int deleteByPrimaryKey(@Param("idperiodo") java.lang.Integer idperiodo) throws Exception;

	Periodo selectByPrimaryKeyBasic(@Param("idperiodo") java.lang.Integer idperiodo) throws Exception;

	Periodo selectByPrimaryKeyBasicActive(@Param("idperiodo") java.lang.Integer idperiodo) throws Exception;

	Periodo selectByPrimaryKeyFull(@Param("idperiodo") java.lang.Integer idperiodo) throws Exception;

	Periodo selectByPrimaryKeyFullActive(@Param("idperiodo") java.lang.Integer idperiodo) throws Exception;

	int updateByPrimaryKeySelective(Periodo record) throws Exception;

	int updateByPrimaryKey(Periodo record) throws Exception;

	int insert(Periodo record) throws Exception;

	int insertSelective(Periodo record) throws Exception;

	List<Periodo> selectDynamicBasic(Periodo record) throws Exception;

	List<Periodo> selectDynamicFull(Periodo record) throws Exception;

	List<Periodo> selectDynamicExtended(Periodo record) throws Exception;


}
