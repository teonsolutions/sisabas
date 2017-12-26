
package pe.com.sisabas.persistence;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import pe.com.sisabas.be.Seccionesdocumentotecnico;

public interface SeccionesdocumentotecnicoMapper{

	int deleteByPrimaryKey(@Param("idseccionesdocumentotecnico") java.lang.Integer idseccionesdocumentotecnico) throws Exception;

	Seccionesdocumentotecnico selectByPrimaryKeyBasic(@Param("idseccionesdocumentotecnico") java.lang.Integer idseccionesdocumentotecnico) throws Exception;

	Seccionesdocumentotecnico selectByPrimaryKeyBasicActive(@Param("idseccionesdocumentotecnico") java.lang.Integer idseccionesdocumentotecnico) throws Exception;

	Seccionesdocumentotecnico selectByPrimaryKeyFull(@Param("idseccionesdocumentotecnico") java.lang.Integer idseccionesdocumentotecnico) throws Exception;

	Seccionesdocumentotecnico selectByPrimaryKeyFullActive(@Param("idseccionesdocumentotecnico") java.lang.Integer idseccionesdocumentotecnico) throws Exception;

	int updateByPrimaryKeySelective(Seccionesdocumentotecnico record) throws Exception;

	int updateByPrimaryKey(Seccionesdocumentotecnico record) throws Exception;

	int insert(Seccionesdocumentotecnico record) throws Exception;

	int insertSelective(Seccionesdocumentotecnico record) throws Exception;

	List<Seccionesdocumentotecnico> selectDynamicBasic(Seccionesdocumentotecnico record) throws Exception;

	List<Seccionesdocumentotecnico> selectDynamicFull(Seccionesdocumentotecnico record) throws Exception;

	List<Seccionesdocumentotecnico> selectDynamicExtended(Seccionesdocumentotecnico record) throws Exception;

	List<Seccionesdocumentotecnico> selectByTipoDocumentoTecnico(@Param("idCatalogoTipoDocumentoTecnico") java.lang.String idCatalogoTipoDocumentoTecnico) throws Exception;
}
