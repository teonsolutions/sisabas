
package pe.com.sisabas.persistence;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import pe.com.sisabas.be.Persona;

public interface PersonaMapper{

	int deleteByPrimaryKey(@Param("idpersona") java.lang.Integer idpersona) throws Exception;

	Persona selectByPrimaryKeyBasic(@Param("idpersona") java.lang.Integer idpersona) throws Exception;

	Persona selectByPrimaryKeyBasicActive(@Param("idpersona") java.lang.Integer idpersona) throws Exception;

	Persona selectByPrimaryKeyFull(@Param("idpersona") java.lang.Integer idpersona) throws Exception;

	Persona selectByPrimaryKeyFullActive(@Param("idpersona") java.lang.Integer idpersona) throws Exception;

	int updateByPrimaryKeySelective(Persona record) throws Exception;

	int updateByPrimaryKey(Persona record) throws Exception;

	int insert(Persona record) throws Exception;

	int insertSelective(Persona record) throws Exception;

	List<Persona> selectDynamicBasic(Persona record) throws Exception;

	List<Persona> selectDynamicFull(Persona record) throws Exception;

	List<Persona> selectDynamicExtended(Persona record) throws Exception;


}
