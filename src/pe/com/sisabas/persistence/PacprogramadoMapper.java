
package pe.com.sisabas.persistence;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import pe.com.sisabas.be.Pacprogramado;

public interface PacprogramadoMapper{

	int deleteByPrimaryKey(@Param("idpacprogramado") java.lang.Integer idpacprogramado) throws Exception;

	Pacprogramado selectByPrimaryKeyBasic(@Param("idpacprogramado") java.lang.Integer idpacprogramado) throws Exception;

	Pacprogramado selectByPrimaryKeyBasicActive(@Param("idpacprogramado") java.lang.Integer idpacprogramado) throws Exception;

	Pacprogramado selectByPrimaryKeyFull(@Param("idpacprogramado") java.lang.Integer idpacprogramado) throws Exception;

	Pacprogramado selectByPrimaryKeyFullActive(@Param("idpacprogramado") java.lang.Integer idpacprogramado) throws Exception;

	int updateByPrimaryKeySelective(Pacprogramado record) throws Exception;

	int updateByPrimaryKey(Pacprogramado record) throws Exception;

	int insert(Pacprogramado record) throws Exception;

	int insertSelective(Pacprogramado record) throws Exception;

	List<Pacprogramado> selectDynamicBasic(Pacprogramado record) throws Exception;

	List<Pacprogramado> selectDynamicFull(Pacprogramado record) throws Exception;

	List<Pacprogramado> selectDynamicExtended(Pacprogramado record) throws Exception;


}
