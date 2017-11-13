
package pe.com.sisabas.persistence;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import pe.com.sisabas.be.Cuadrocomparativoitem;

public interface CuadrocomparativoitemMapper{

	int deleteByPrimaryKey(@Param("idcuadrocomparativoitem") java.lang.Integer idcuadrocomparativoitem) throws Exception;

	Cuadrocomparativoitem selectByPrimaryKeyBasic(@Param("idcuadrocomparativoitem") java.lang.Integer idcuadrocomparativoitem) throws Exception;

	Cuadrocomparativoitem selectByPrimaryKeyBasicActive(@Param("idcuadrocomparativoitem") java.lang.Integer idcuadrocomparativoitem) throws Exception;

	Cuadrocomparativoitem selectByPrimaryKeyFull(@Param("idcuadrocomparativoitem") java.lang.Integer idcuadrocomparativoitem) throws Exception;

	Cuadrocomparativoitem selectByPrimaryKeyFullActive(@Param("idcuadrocomparativoitem") java.lang.Integer idcuadrocomparativoitem) throws Exception;

	int updateByPrimaryKeySelective(Cuadrocomparativoitem record) throws Exception;

	int updateByPrimaryKey(Cuadrocomparativoitem record) throws Exception;

	int insert(Cuadrocomparativoitem record) throws Exception;

	int insertSelective(Cuadrocomparativoitem record) throws Exception;

	List<Cuadrocomparativoitem> selectDynamicBasic(Cuadrocomparativoitem record) throws Exception;

	List<Cuadrocomparativoitem> selectDynamicFull(Cuadrocomparativoitem record) throws Exception;

	List<Cuadrocomparativoitem> selectDynamicExtended(Cuadrocomparativoitem record) throws Exception;


}
