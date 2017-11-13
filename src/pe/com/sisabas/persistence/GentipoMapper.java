
package pe.com.sisabas.persistence;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import pe.com.sisabas.be.Gentipo;

public interface GentipoMapper{

	int deleteByPrimaryKey(@Param("vchtipcodigo") java.lang.String vchtipcodigo) throws Exception;

	Gentipo selectByPrimaryKeyBasic(@Param("vchtipcodigo") java.lang.String vchtipcodigo) throws Exception;

	Gentipo selectByPrimaryKeyBasicActive(@Param("vchtipcodigo") java.lang.String vchtipcodigo) throws Exception;

	Gentipo selectByPrimaryKeyFull(@Param("vchtipcodigo") java.lang.String vchtipcodigo) throws Exception;

	Gentipo selectByPrimaryKeyFullActive(@Param("vchtipcodigo") java.lang.String vchtipcodigo) throws Exception;

	int updateByPrimaryKeySelective(Gentipo record) throws Exception;

	int updateByPrimaryKey(Gentipo record) throws Exception;

	int insert(Gentipo record) throws Exception;

	int insertSelective(Gentipo record) throws Exception;

	List<Gentipo> selectDynamicBasic(Gentipo record) throws Exception;

	List<Gentipo> selectDynamicFull(Gentipo record) throws Exception;

	List<Gentipo> selectDynamicExtended(Gentipo record) throws Exception;


}
