
package pe.com.sisabas.persistence;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import pe.com.sisabas.be.Siaflog;

public interface SiaflogMapper{

	int deleteByPrimaryKey(@Param("idlog") java.lang.Integer idlog) throws Exception;

	Siaflog selectByPrimaryKeyBasic(@Param("idlog") java.lang.Integer idlog) throws Exception;

	Siaflog selectByPrimaryKeyBasicActive(@Param("idlog") java.lang.Integer idlog) throws Exception;

	Siaflog selectByPrimaryKeyFull(@Param("idlog") java.lang.Integer idlog) throws Exception;

	Siaflog selectByPrimaryKeyFullActive(@Param("idlog") java.lang.Integer idlog) throws Exception;

	int updateByPrimaryKeySelective(Siaflog record) throws Exception;

	int updateByPrimaryKey(Siaflog record) throws Exception;

	int insert(Siaflog record) throws Exception;

	int insertSelective(Siaflog record) throws Exception;

	List<Siaflog> selectDynamicBasic(Siaflog record) throws Exception;

	List<Siaflog> selectDynamicFull(Siaflog record) throws Exception;

	List<Siaflog> selectDynamicExtended(Siaflog record) throws Exception;


}
