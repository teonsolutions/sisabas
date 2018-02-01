
package pe.com.sisabas.persistence;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import pe.com.sisabas.be.Contratosporprocesoseleccion;

public interface ContratosporprocesoseleccionMapper{

	int deleteByPrimaryKey(@Param("idcontratoporproceso") java.lang.Integer idcontratoporproceso) throws Exception;

	Contratosporprocesoseleccion selectByPrimaryKeyBasic(@Param("idcontratoporproceso") java.lang.Integer idcontratoporproceso) throws Exception;

	Contratosporprocesoseleccion selectByPrimaryKeyBasicActive(@Param("idcontratoporproceso") java.lang.Integer idcontratoporproceso) throws Exception;

	Contratosporprocesoseleccion selectByPrimaryKeyFull(@Param("idcontratoporproceso") java.lang.Integer idcontratoporproceso) throws Exception;

	Contratosporprocesoseleccion selectByPrimaryKeyFullActive(@Param("idcontratoporproceso") java.lang.Integer idcontratoporproceso) throws Exception;

	int updateByPrimaryKeySelective(Contratosporprocesoseleccion record) throws Exception;

	int updateByPrimaryKey(Contratosporprocesoseleccion record) throws Exception;

	int insert(Contratosporprocesoseleccion record) throws Exception;

	int insertSelective(Contratosporprocesoseleccion record) throws Exception;

	List<Contratosporprocesoseleccion> selectDynamicBasic(Contratosporprocesoseleccion record) throws Exception;

	List<Contratosporprocesoseleccion> selectDynamicFull(Contratosporprocesoseleccion record) throws Exception;

	List<Contratosporprocesoseleccion> selectDynamicExtended(Contratosporprocesoseleccion record) throws Exception;


}
