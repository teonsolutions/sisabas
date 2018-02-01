
package pe.com.sisabas.persistence;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import pe.com.sisabas.be.Procesoseleccion;

public interface ProcesoseleccionMapper{

	int deleteByPrimaryKey(@Param("idprocesoseleccion") java.lang.Integer idprocesoseleccion) throws Exception;

	Procesoseleccion selectByPrimaryKeyBasic(@Param("idprocesoseleccion") java.lang.Integer idprocesoseleccion) throws Exception;

	Procesoseleccion selectByPrimaryKeyBasicActive(@Param("idprocesoseleccion") java.lang.Integer idprocesoseleccion) throws Exception;

	Procesoseleccion selectByPrimaryKeyFull(@Param("idprocesoseleccion") java.lang.Integer idprocesoseleccion) throws Exception;

	Procesoseleccion selectByPrimaryKeyFullActive(@Param("idprocesoseleccion") java.lang.Integer idprocesoseleccion) throws Exception;

	int updateByPrimaryKeySelective(Procesoseleccion record) throws Exception;

	int updateByPrimaryKey(Procesoseleccion record) throws Exception;

	int insert(Procesoseleccion record) throws Exception;

	int insertSelective(Procesoseleccion record) throws Exception;

	List<Procesoseleccion> selectDynamicBasic(Procesoseleccion record) throws Exception;

	List<Procesoseleccion> selectDynamicFull(Procesoseleccion record) throws Exception;

	List<Procesoseleccion> selectDynamicExtended(Procesoseleccion record) throws Exception;


}
