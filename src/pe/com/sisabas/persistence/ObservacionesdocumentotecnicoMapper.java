
package pe.com.sisabas.persistence;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import pe.com.sisabas.be.Observacionesdocumentotecnico;

public interface ObservacionesdocumentotecnicoMapper{

	int deleteByPrimaryKey(@Param("idobservacionesdocumentotecnico") java.lang.Integer idobservacionesdocumentotecnico) throws Exception;

	Observacionesdocumentotecnico selectByPrimaryKeyBasic(@Param("idobservacionesdocumentotecnico") java.lang.Integer idobservacionesdocumentotecnico) throws Exception;

	Observacionesdocumentotecnico selectByPrimaryKeyBasicActive(@Param("idobservacionesdocumentotecnico") java.lang.Integer idobservacionesdocumentotecnico) throws Exception;

	Observacionesdocumentotecnico selectByPrimaryKeyFull(@Param("idobservacionesdocumentotecnico") java.lang.Integer idobservacionesdocumentotecnico) throws Exception;

	Observacionesdocumentotecnico selectByPrimaryKeyFullActive(@Param("idobservacionesdocumentotecnico") java.lang.Integer idobservacionesdocumentotecnico) throws Exception;

	int updateByPrimaryKeySelective(Observacionesdocumentotecnico record) throws Exception;

	int updateByPrimaryKey(Observacionesdocumentotecnico record) throws Exception;

	int insert(Observacionesdocumentotecnico record) throws Exception;

	int insertSelective(Observacionesdocumentotecnico record) throws Exception;

	List<Observacionesdocumentotecnico> selectDynamicBasic(Observacionesdocumentotecnico record) throws Exception;

	List<Observacionesdocumentotecnico> selectDynamicFull(Observacionesdocumentotecnico record) throws Exception;

	List<Observacionesdocumentotecnico> selectDynamicExtended(Observacionesdocumentotecnico record) throws Exception;


}
