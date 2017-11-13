
package pe.com.sisabas.persistence;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import pe.com.sisabas.be.Vispedido;

public interface VispedidoMapper{

	int deleteByPrimaryKey(@Param("idvpedido") java.lang.Integer idvpedido) throws Exception;

	Vispedido selectByPrimaryKeyBasic(@Param("idvpedido") java.lang.Integer idvpedido) throws Exception;

	Vispedido selectByPrimaryKeyBasicActive(@Param("idvpedido") java.lang.Integer idvpedido) throws Exception;

	Vispedido selectByPrimaryKeyFull(@Param("idvpedido") java.lang.Integer idvpedido) throws Exception;

	Vispedido selectByPrimaryKeyFullActive(@Param("idvpedido") java.lang.Integer idvpedido) throws Exception;

	int updateByPrimaryKeySelective(Vispedido record) throws Exception;

	int updateByPrimaryKey(Vispedido record) throws Exception;

	int insert(Vispedido record) throws Exception;

	int insertSelective(Vispedido record) throws Exception;

	List<Vispedido> selectDynamicBasic(Vispedido record) throws Exception;

	List<Vispedido> selectDynamicFull(Vispedido record) throws Exception;

	List<Vispedido> selectDynamicExtended(Vispedido record) throws Exception;


}
