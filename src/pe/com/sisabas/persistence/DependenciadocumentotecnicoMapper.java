
package pe.com.sisabas.persistence;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import pe.com.sisabas.be.Dependenciadocumentotecnico;

public interface DependenciadocumentotecnicoMapper{

	int deleteByPrimaryKey(@Param("iddependenciadocumentotecnico") java.lang.Integer iddependenciadocumentotecnico) throws Exception;

	Dependenciadocumentotecnico selectByPrimaryKeyBasic(@Param("iddependenciadocumentotecnico") java.lang.Integer iddependenciadocumentotecnico) throws Exception;

	Dependenciadocumentotecnico selectByPrimaryKeyBasicActive(@Param("iddependenciadocumentotecnico") java.lang.Integer iddependenciadocumentotecnico) throws Exception;

	Dependenciadocumentotecnico selectByPrimaryKeyFull(@Param("iddependenciadocumentotecnico") java.lang.Integer iddependenciadocumentotecnico) throws Exception;

	Dependenciadocumentotecnico selectByPrimaryKeyFullActive(@Param("iddependenciadocumentotecnico") java.lang.Integer iddependenciadocumentotecnico) throws Exception;

	int updateByPrimaryKeySelective(Dependenciadocumentotecnico record) throws Exception;

	int updateByPrimaryKey(Dependenciadocumentotecnico record) throws Exception;

	int insert(Dependenciadocumentotecnico record) throws Exception;

	int insertSelective(Dependenciadocumentotecnico record) throws Exception;

	List<Dependenciadocumentotecnico> selectDynamicBasic(Dependenciadocumentotecnico record) throws Exception;

	List<Dependenciadocumentotecnico> selectDynamicFull(Dependenciadocumentotecnico record) throws Exception;

	List<Dependenciadocumentotecnico> selectDynamicExtended(Dependenciadocumentotecnico record) throws Exception;


}
