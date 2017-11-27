
package pe.com.sisabas.persistence;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import pe.com.sisabas.be.Cuadrocomparativovr;

public interface CuadrocomparativovrMapper{

	int deleteByPrimaryKey(@Param("idcuadrocomparativovr") java.lang.Integer idcuadrocomparativovr) throws Exception;

	Cuadrocomparativovr selectByPrimaryKeyBasic(@Param("idcuadrocomparativovr") java.lang.Integer idcuadrocomparativovr) throws Exception;

	Cuadrocomparativovr selectByPrimaryKeyBasicActive(@Param("idcuadrocomparativovr") java.lang.Integer idcuadrocomparativovr) throws Exception;

	Cuadrocomparativovr selectByPrimaryKeyFull(@Param("idcuadrocomparativovr") java.lang.Integer idcuadrocomparativovr) throws Exception;

	Cuadrocomparativovr selectByPrimaryKeyFullActive(@Param("idcuadrocomparativovr") java.lang.Integer idcuadrocomparativovr) throws Exception;

	int updateByPrimaryKeySelective(Cuadrocomparativovr record) throws Exception;

	int updateByPrimaryKey(Cuadrocomparativovr record) throws Exception;

	int insert(Cuadrocomparativovr record) throws Exception;

	int insertSelective(Cuadrocomparativovr record) throws Exception;

	List<Cuadrocomparativovr> selectDynamicBasic(Cuadrocomparativovr record) throws Exception;

	List<Cuadrocomparativovr> selectDynamicFull(Cuadrocomparativovr record) throws Exception;

	List<Cuadrocomparativovr> selectDynamicExtended(Cuadrocomparativovr record) throws Exception;

	int deleteByIdPacConsolidado(@Param("idPacConsolidado") java.lang.Integer idPacConsolidado) throws Exception;
}
