
package pe.com.sisabas.persistence;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import pe.com.sisabas.be.Vissigapaacconsolidado;

public interface VissigapaacconsolidadoMapper{

	int deleteByPrimaryKey(@Param("visidsigapaacconsolidado") java.lang.Integer visidsigapaacconsolidado) throws Exception;

	Vissigapaacconsolidado selectByPrimaryKeyBasic(@Param("visidsigapaacconsolidado") java.lang.Integer visidsigapaacconsolidado) throws Exception;

	Vissigapaacconsolidado selectByPrimaryKeyBasicActive(@Param("visidsigapaacconsolidado") java.lang.Integer visidsigapaacconsolidado) throws Exception;

	Vissigapaacconsolidado selectByPrimaryKeyFull(@Param("visidsigapaacconsolidado") java.lang.Integer visidsigapaacconsolidado) throws Exception;

	Vissigapaacconsolidado selectByPrimaryKeyFullActive(@Param("visidsigapaacconsolidado") java.lang.Integer visidsigapaacconsolidado) throws Exception;

	int updateByPrimaryKeySelective(Vissigapaacconsolidado record) throws Exception;

	int updateByPrimaryKey(Vissigapaacconsolidado record) throws Exception;

	int insert(Vissigapaacconsolidado record) throws Exception;

	int insertSelective(Vissigapaacconsolidado record) throws Exception;

	List<Vissigapaacconsolidado> selectDynamicBasic(Vissigapaacconsolidado record) throws Exception;

	List<Vissigapaacconsolidado> selectDynamicFull(Vissigapaacconsolidado record) throws Exception;

	List<Vissigapaacconsolidado> selectDynamicExtended(Vissigapaacconsolidado record) throws Exception;


}
