
package pe.com.sisabas.persistence;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import pe.com.sisabas.be.Vcertificacion;

public interface VcertificacionMapper{

	int deleteByPrimaryKey(@Param("vcertificacion") java.lang.Integer vcertificacion) throws Exception;

	Vcertificacion selectByPrimaryKeyBasic(@Param("vcertificacion") java.lang.Integer vcertificacion) throws Exception;

	Vcertificacion selectByPrimaryKeyBasicActive(@Param("vcertificacion") java.lang.Integer vcertificacion) throws Exception;

	Vcertificacion selectByPrimaryKeyFull(@Param("vcertificacion") java.lang.Integer vcertificacion) throws Exception;

	Vcertificacion selectByPrimaryKeyFullActive(@Param("vcertificacion") java.lang.Integer vcertificacion) throws Exception;

	int updateByPrimaryKeySelective(Vcertificacion record) throws Exception;

	int updateByPrimaryKey(Vcertificacion record) throws Exception;

	int insert(Vcertificacion record) throws Exception;

	int insertSelective(Vcertificacion record) throws Exception;

	List<Vcertificacion> selectDynamicBasic(Vcertificacion record) throws Exception;

	List<Vcertificacion> selectDynamicFull(Vcertificacion record) throws Exception;

	List<Vcertificacion> selectDynamicExtended(Vcertificacion record) throws Exception;


}
