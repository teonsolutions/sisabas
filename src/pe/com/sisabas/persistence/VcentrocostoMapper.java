
package pe.com.sisabas.persistence;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import pe.com.sisabas.be.Vcentrocosto;
import pe.com.sisabas.be.VisSigaCentroCosto;
import pe.com.sisabas.dto.CentroCostoRequest;
import pe.com.sisabas.dto.CentroCostoResponse;

public interface VcentrocostoMapper{

	int deleteByPrimaryKey(@Param("codigocentrocosto") java.lang.String codigocentrocosto) throws Exception;

	Vcentrocosto selectByPrimaryKeyBasic(@Param("codigocentrocosto") java.lang.String codigocentrocosto) throws Exception;

	Vcentrocosto selectByPrimaryKeyBasicActive(@Param("codigocentrocosto") java.lang.String codigocentrocosto) throws Exception;

	Vcentrocosto selectByPrimaryKeyFull(@Param("codigocentrocosto") java.lang.String codigocentrocosto) throws Exception;

	Vcentrocosto selectByPrimaryKeyFullActive(@Param("codigocentrocosto") java.lang.String codigocentrocosto) throws Exception;

	int updateByPrimaryKeySelective(Vcentrocosto record) throws Exception;

	int updateByPrimaryKey(Vcentrocosto record) throws Exception;

	int insert(Vcentrocosto record) throws Exception;

	int insertSelective(Vcentrocosto record) throws Exception;

	List<Vcentrocosto> selectDynamicBasic(Vcentrocosto record) throws Exception;

	List<Vcentrocosto> selectDynamicFull(Vcentrocosto record) throws Exception;

	List<Vcentrocosto> selectDynamicExtended(Vcentrocosto record) throws Exception;

	List<VisSigaCentroCosto> selectDynamicFullVis(VisSigaCentroCosto record);

	List<CentroCostoResponse> getCentroCosto(CentroCostoRequest record);
	
}
