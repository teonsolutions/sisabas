
package pe.com.sisabas.persistence;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import pe.com.sisabas.be.Cuadrocomparativofuente;

public interface CuadrocomparativofuenteMapper{

	int deleteByPrimaryKey(@Param("idcuadrocomparativofuente") java.lang.Integer idcuadrocomparativofuente) throws Exception;

	Cuadrocomparativofuente selectByPrimaryKeyBasic(@Param("idcuadrocomparativofuente") java.lang.Integer idcuadrocomparativofuente) throws Exception;

	Cuadrocomparativofuente selectByPrimaryKeyBasicActive(@Param("idcuadrocomparativofuente") java.lang.Integer idcuadrocomparativofuente) throws Exception;

	Cuadrocomparativofuente selectByPrimaryKeyFull(@Param("idcuadrocomparativofuente") java.lang.Integer idcuadrocomparativofuente) throws Exception;

	Cuadrocomparativofuente selectByPrimaryKeyFullActive(@Param("idcuadrocomparativofuente") java.lang.Integer idcuadrocomparativofuente) throws Exception;

	int updateByPrimaryKeySelective(Cuadrocomparativofuente record) throws Exception;

	int updateByPrimaryKey(Cuadrocomparativofuente record) throws Exception;

	int insert(Cuadrocomparativofuente record) throws Exception;

	int insertSelective(Cuadrocomparativofuente record) throws Exception;

	List<Cuadrocomparativofuente> selectDynamicBasic(Cuadrocomparativofuente record) throws Exception;

	List<Cuadrocomparativofuente> selectDynamicFull(Cuadrocomparativofuente record) throws Exception;

	List<Cuadrocomparativofuente> selectDynamicExtended(Cuadrocomparativofuente record) throws Exception;


}
