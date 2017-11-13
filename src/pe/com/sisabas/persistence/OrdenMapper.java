
package pe.com.sisabas.persistence;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import pe.com.sisabas.be.Orden;

public interface OrdenMapper{

	int deleteByPrimaryKey(@Param("idorden") java.lang.Integer idorden) throws Exception;

	Orden selectByPrimaryKeyBasic(@Param("idorden") java.lang.Integer idorden) throws Exception;

	Orden selectByPrimaryKeyBasicActive(@Param("idorden") java.lang.Integer idorden) throws Exception;

	Orden selectByPrimaryKeyFull(@Param("idorden") java.lang.Integer idorden) throws Exception;

	Orden selectByPrimaryKeyFullActive(@Param("idorden") java.lang.Integer idorden) throws Exception;

	int updateByPrimaryKeySelective(Orden record) throws Exception;

	int updateByPrimaryKey(Orden record) throws Exception;

	int insert(Orden record) throws Exception;

	int insertSelective(Orden record) throws Exception;

	List<Orden> selectDynamicBasic(Orden record) throws Exception;

	List<Orden> selectDynamicFull(Orden record) throws Exception;

	List<Orden> selectDynamicExtended(Orden record) throws Exception;


}
