
package pe.com.sisabas.persistence;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import pe.com.sisabas.be.Estadosporetapa;

public interface EstadosporetapaMapper{

	int deleteByPrimaryKey(@Param("idestadoporetapa") java.lang.Integer idestadoporetapa) throws Exception;

	Estadosporetapa selectByPrimaryKeyBasic(@Param("idestadoporetapa") java.lang.Integer idestadoporetapa) throws Exception;

	Estadosporetapa selectByPrimaryKeyBasicActive(@Param("idestadoporetapa") java.lang.Integer idestadoporetapa) throws Exception;

	Estadosporetapa selectByPrimaryKeyFull(@Param("idestadoporetapa") java.lang.Integer idestadoporetapa) throws Exception;

	Estadosporetapa selectByPrimaryKeyFullActive(@Param("idestadoporetapa") java.lang.Integer idestadoporetapa) throws Exception;

	int updateByPrimaryKeySelective(Estadosporetapa record) throws Exception;

	int updateByPrimaryKey(Estadosporetapa record) throws Exception;

	int insert(Estadosporetapa record) throws Exception;

	int insertSelective(Estadosporetapa record) throws Exception;

	List<Estadosporetapa> selectDynamicBasic(Estadosporetapa record) throws Exception;

	List<Estadosporetapa> selectDynamicFull(Estadosporetapa record) throws Exception;

	List<Estadosporetapa> selectDynamicExtended(Estadosporetapa record) throws Exception;


}
