
package pe.com.sisabas.persistence;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import pe.com.sisabas.be.Miembrocomiteporproceso;

public interface MiembrocomiteporprocesoMapper{

	int deleteByPrimaryKey(@Param("idmiembrocomiteproceso") java.lang.Integer idmiembrocomiteproceso) throws Exception;

	Miembrocomiteporproceso selectByPrimaryKeyBasic(@Param("idmiembrocomiteproceso") java.lang.Integer idmiembrocomiteproceso) throws Exception;

	Miembrocomiteporproceso selectByPrimaryKeyBasicActive(@Param("idmiembrocomiteproceso") java.lang.Integer idmiembrocomiteproceso) throws Exception;

	Miembrocomiteporproceso selectByPrimaryKeyFull(@Param("idmiembrocomiteproceso") java.lang.Integer idmiembrocomiteproceso) throws Exception;

	Miembrocomiteporproceso selectByPrimaryKeyFullActive(@Param("idmiembrocomiteproceso") java.lang.Integer idmiembrocomiteproceso) throws Exception;

	int updateByPrimaryKeySelective(Miembrocomiteporproceso record) throws Exception;

	int updateByPrimaryKey(Miembrocomiteporproceso record) throws Exception;

	int insert(Miembrocomiteporproceso record) throws Exception;

	int insertSelective(Miembrocomiteporproceso record) throws Exception;

	List<Miembrocomiteporproceso> selectDynamicBasic(Miembrocomiteporproceso record) throws Exception;

	List<Miembrocomiteporproceso> selectDynamicFull(Miembrocomiteporproceso record) throws Exception;

	List<Miembrocomiteporproceso> selectDynamicExtended(Miembrocomiteporproceso record) throws Exception;


}
