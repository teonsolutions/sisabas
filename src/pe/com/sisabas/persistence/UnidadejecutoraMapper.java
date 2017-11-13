
package pe.com.sisabas.persistence;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import pe.com.sisabas.be.Unidadejecutora;

public interface UnidadejecutoraMapper{

	int deleteByPrimaryKey(@Param("idunidadejecutora") java.lang.Integer idunidadejecutora) throws Exception;

	Unidadejecutora selectByPrimaryKeyBasic(@Param("idunidadejecutora") java.lang.Integer idunidadejecutora) throws Exception;

	Unidadejecutora selectByPrimaryKeyBasicActive(@Param("idunidadejecutora") java.lang.Integer idunidadejecutora) throws Exception;

	Unidadejecutora selectByPrimaryKeyFull(@Param("idunidadejecutora") java.lang.Integer idunidadejecutora) throws Exception;

	Unidadejecutora selectByPrimaryKeyFullActive(@Param("idunidadejecutora") java.lang.Integer idunidadejecutora) throws Exception;

	int updateByPrimaryKeySelective(Unidadejecutora record) throws Exception;

	int updateByPrimaryKey(Unidadejecutora record) throws Exception;

	int insert(Unidadejecutora record) throws Exception;

	int insertSelective(Unidadejecutora record) throws Exception;

	List<Unidadejecutora> selectDynamicBasic(Unidadejecutora record) throws Exception;

	List<Unidadejecutora> selectDynamicFull(Unidadejecutora record) throws Exception;

	List<Unidadejecutora> selectDynamicExtended(Unidadejecutora record) throws Exception;


}
