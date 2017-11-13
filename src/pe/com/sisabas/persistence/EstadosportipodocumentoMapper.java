
package pe.com.sisabas.persistence;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import pe.com.sisabas.be.Estadosportipodocumento;

public interface EstadosportipodocumentoMapper{

	int deleteByPrimaryKey(@Param("idestadosportipodocumento") java.lang.Integer idestadosportipodocumento) throws Exception;

	Estadosportipodocumento selectByPrimaryKeyBasic(@Param("idestadosportipodocumento") java.lang.Integer idestadosportipodocumento) throws Exception;

	Estadosportipodocumento selectByPrimaryKeyBasicActive(@Param("idestadosportipodocumento") java.lang.Integer idestadosportipodocumento) throws Exception;

	Estadosportipodocumento selectByPrimaryKeyFull(@Param("idestadosportipodocumento") java.lang.Integer idestadosportipodocumento) throws Exception;

	Estadosportipodocumento selectByPrimaryKeyFullActive(@Param("idestadosportipodocumento") java.lang.Integer idestadosportipodocumento) throws Exception;

	int updateByPrimaryKeySelective(Estadosportipodocumento record) throws Exception;

	int updateByPrimaryKey(Estadosportipodocumento record) throws Exception;

	int insert(Estadosportipodocumento record) throws Exception;

	int insertSelective(Estadosportipodocumento record) throws Exception;

	List<Estadosportipodocumento> selectDynamicBasic(Estadosportipodocumento record) throws Exception;

	List<Estadosportipodocumento> selectDynamicFull(Estadosportipodocumento record) throws Exception;

	List<Estadosportipodocumento> selectDynamicExtended(Estadosportipodocumento record) throws Exception;


	Estadosportipodocumento selectByEtapaTipoDocumento(Estadosportipodocumento record) throws Exception;
	
}
