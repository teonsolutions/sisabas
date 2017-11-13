
package pe.com.sisabas.persistence;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import pe.com.sisabas.be.Plazopagodocumentotecnico;

public interface PlazopagodocumentotecnicoMapper{

	int deleteByPrimaryKey(@Param("idplazopagodocumentotecnico") java.lang.Integer idplazopagodocumentotecnico) throws Exception;

	Plazopagodocumentotecnico selectByPrimaryKeyBasic(@Param("idplazopagodocumentotecnico") java.lang.Integer idplazopagodocumentotecnico) throws Exception;

	Plazopagodocumentotecnico selectByPrimaryKeyBasicActive(@Param("idplazopagodocumentotecnico") java.lang.Integer idplazopagodocumentotecnico) throws Exception;

	Plazopagodocumentotecnico selectByPrimaryKeyFull(@Param("idplazopagodocumentotecnico") java.lang.Integer idplazopagodocumentotecnico) throws Exception;

	Plazopagodocumentotecnico selectByPrimaryKeyFullActive(@Param("idplazopagodocumentotecnico") java.lang.Integer idplazopagodocumentotecnico) throws Exception;

	int updateByPrimaryKeySelective(Plazopagodocumentotecnico record) throws Exception;

	int updateByPrimaryKey(Plazopagodocumentotecnico record) throws Exception;

	int insert(Plazopagodocumentotecnico record) throws Exception;

	int insertSelective(Plazopagodocumentotecnico record) throws Exception;

	List<Plazopagodocumentotecnico> selectDynamicBasic(Plazopagodocumentotecnico record) throws Exception;

	List<Plazopagodocumentotecnico> selectDynamicFull(Plazopagodocumentotecnico record) throws Exception;

	List<Plazopagodocumentotecnico> selectDynamicExtended(Plazopagodocumentotecnico record) throws Exception;


}
