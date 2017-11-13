
package pe.com.sisabas.persistence;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import pe.com.sisabas.be.Entregable;

public interface EntregableMapper{

	int deleteByPrimaryKey(@Param("identregable") java.lang.Integer identregable) throws Exception;

	Entregable selectByPrimaryKeyBasic(@Param("identregable") java.lang.Integer identregable) throws Exception;

	Entregable selectByPrimaryKeyBasicActive(@Param("identregable") java.lang.Integer identregable) throws Exception;

	Entregable selectByPrimaryKeyFull(@Param("identregable") java.lang.Integer identregable) throws Exception;

	Entregable selectByPrimaryKeyFullActive(@Param("identregable") java.lang.Integer identregable) throws Exception;

	int updateByPrimaryKeySelective(Entregable record) throws Exception;

	int updateByPrimaryKey(Entregable record) throws Exception;

	int insert(Entregable record) throws Exception;

	int insertSelective(Entregable record) throws Exception;

	List<Entregable> selectDynamicBasic(Entregable record) throws Exception;

	List<Entregable> selectDynamicFull(Entregable record) throws Exception;

	List<Entregable> selectDynamicExtended(Entregable record) throws Exception;


}
