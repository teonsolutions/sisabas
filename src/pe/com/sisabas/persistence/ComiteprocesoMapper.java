
package pe.com.sisabas.persistence;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import pe.com.sisabas.be.Comiteproceso;

public interface ComiteprocesoMapper{

	int deleteByPrimaryKey(@Param("idcomiteproceso") java.lang.Integer idcomiteproceso) throws Exception;

	Comiteproceso selectByPrimaryKeyBasic(@Param("idcomiteproceso") java.lang.Integer idcomiteproceso) throws Exception;

	Comiteproceso selectByPrimaryKeyBasicActive(@Param("idcomiteproceso") java.lang.Integer idcomiteproceso) throws Exception;

	Comiteproceso selectByPrimaryKeyFull(@Param("idcomiteproceso") java.lang.Integer idcomiteproceso) throws Exception;

	Comiteproceso selectByPrimaryKeyFullActive(@Param("idcomiteproceso") java.lang.Integer idcomiteproceso) throws Exception;

	int updateByPrimaryKeySelective(Comiteproceso record) throws Exception;

	int updateByPrimaryKey(Comiteproceso record) throws Exception;

	int insert(Comiteproceso record) throws Exception;

	int insertSelective(Comiteproceso record) throws Exception;

	List<Comiteproceso> selectDynamicBasic(Comiteproceso record) throws Exception;

	List<Comiteproceso> selectDynamicFull(Comiteproceso record) throws Exception;

	List<Comiteproceso> selectDynamicExtended(Comiteproceso record) throws Exception;


}
