
package pe.com.sisabas.persistence;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import pe.com.sisabas.be.Evaluaciondocumento;

public interface EvaluaciondocumentoMapper{

	int deleteByPrimaryKey(@Param("idevaluaciondocumento") java.lang.Integer idevaluaciondocumento) throws Exception;

	Evaluaciondocumento selectByPrimaryKeyBasic(@Param("idevaluaciondocumento") java.lang.Integer idevaluaciondocumento) throws Exception;

	Evaluaciondocumento selectByPrimaryKeyBasicActive(@Param("idevaluaciondocumento") java.lang.Integer idevaluaciondocumento) throws Exception;

	Evaluaciondocumento selectByPrimaryKeyFull(@Param("idevaluaciondocumento") java.lang.Integer idevaluaciondocumento) throws Exception;

	Evaluaciondocumento selectByPrimaryKeyFullActive(@Param("idevaluaciondocumento") java.lang.Integer idevaluaciondocumento) throws Exception;

	int updateByPrimaryKeySelective(Evaluaciondocumento record) throws Exception;

	int updateByPrimaryKey(Evaluaciondocumento record) throws Exception;

	int insert(Evaluaciondocumento record) throws Exception;

	int insertSelective(Evaluaciondocumento record) throws Exception;

	List<Evaluaciondocumento> selectDynamicBasic(Evaluaciondocumento record) throws Exception;

	List<Evaluaciondocumento> selectDynamicFull(Evaluaciondocumento record) throws Exception;

	List<Evaluaciondocumento> selectDynamicExtended(Evaluaciondocumento record) throws Exception;


}
