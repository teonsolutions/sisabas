
package pe.com.sisabas.persistence;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import pe.com.sisabas.be.Genparametro;

public interface GenparametroMapper{

	int deleteByPrimaryKey(@Param("vchparamcodigo") java.lang.String vchparamcodigo) throws Exception;

	Genparametro selectByPrimaryKeyBasic(@Param("vchparamcodigo") java.lang.String vchparamcodigo) throws Exception;

	Genparametro selectByPrimaryKeyBasicActive(@Param("vchparamcodigo") java.lang.String vchparamcodigo) throws Exception;

	Genparametro selectByPrimaryKeyFull(@Param("vchparamcodigo") java.lang.String vchparamcodigo) throws Exception;

	Genparametro selectByPrimaryKeyFullActive(@Param("vchparamcodigo") java.lang.String vchparamcodigo) throws Exception;

	int updateByPrimaryKeySelective(Genparametro record) throws Exception;

	int updateByPrimaryKey(Genparametro record) throws Exception;

	int insert(Genparametro record) throws Exception;

	int insertSelective(Genparametro record) throws Exception;

	List<Genparametro> selectDynamicBasic(Genparametro record) throws Exception;

	List<Genparametro> selectDynamicFull(Genparametro record) throws Exception;

	List<Genparametro> selectDynamicExtended(Genparametro record) throws Exception;


}
