
package pe.com.sisabas.persistence;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import pe.com.sisabas.be.Documentotecnico;
import pe.com.sisabas.dto.EvaluacionDocumentoRequest;
import pe.com.sisabas.dto.EvaluacionDocumentoResponse;
import pe.com.sisabas.dto.Lugar;

public interface DocumentotecnicoMapper{

	int deleteByPrimaryKey(@Param("iddocumentotecnico") java.lang.Integer iddocumentotecnico) throws Exception;

	Documentotecnico selectByPrimaryKeyBasic(@Param("iddocumentotecnico") java.lang.Integer iddocumentotecnico) throws Exception;

	Documentotecnico selectByPrimaryKeyBasicActive(@Param("iddocumentotecnico") java.lang.Integer iddocumentotecnico) throws Exception;

	Documentotecnico selectByPrimaryKeyFull(@Param("iddocumentotecnico") java.lang.Integer iddocumentotecnico) throws Exception;

	Documentotecnico selectByPrimaryKeyFullActive(@Param("iddocumentotecnico") java.lang.Integer iddocumentotecnico) throws Exception;

	int updateByPrimaryKeySelective(Documentotecnico record) throws Exception;

	int updateByPrimaryKey(Documentotecnico record) throws Exception;

	int insert(Documentotecnico record) throws Exception;

	int insertSelective(Documentotecnico record) throws Exception;

	List<Documentotecnico> selectDynamicBasic(Documentotecnico record) throws Exception;

	List<Documentotecnico> selectDynamicFull(Documentotecnico record) throws Exception;

	List<Documentotecnico> selectDynamicExtended(Documentotecnico record) throws Exception;

	List<EvaluacionDocumentoResponse> getPedidosEvaluacion(EvaluacionDocumentoRequest record)throws Exception;
	
	List<Lugar> getLugaresPrestacion(Integer idDocumentoTecnico) throws Exception;

}
