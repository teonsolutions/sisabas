
package pe.com.sisabas.persistence;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import pe.com.sisabas.be.Gentabla;
import pe.com.sisabas.dto.EstadoRequerimientoResponse;
import pe.com.sisabas.dto.GentablaItemResponse;
import pe.com.sisabas.dto.TipoProcesoResponse;

public interface GentablaMapper{

	int deleteByPrimaryKey(@Param("vchregcodigo") java.lang.String vchregcodigo) throws Exception;

	Gentabla selectByPrimaryKeyBasic(@Param("vchregcodigo") java.lang.String vchregcodigo) throws Exception;

	Gentabla selectByPrimaryKeyBasicActive(@Param("vchregcodigo") java.lang.String vchregcodigo) throws Exception;

	Gentabla selectByPrimaryKeyFull(@Param("vchregcodigo") java.lang.String vchregcodigo) throws Exception;

	Gentabla selectByPrimaryKeyFullActive(@Param("vchregcodigo") java.lang.String vchregcodigo) throws Exception;

	int updateByPrimaryKeySelective(Gentabla record) throws Exception;

	int updateByPrimaryKey(Gentabla record) throws Exception;

	int insert(Gentabla record) throws Exception;

	int insertSelective(Gentabla record) throws Exception;

	List<Gentabla> selectDynamicBasic(Gentabla record) throws Exception;
	
	
	
	
	List<Gentabla> listaFiltro(@Param("vchtipCodigo") java.lang.String vchtipCodigo, @Param("estadoAuditoria") java.lang.String estadoAuditoria) throws Exception;
	
	
	
	
	
	
	

	List<Gentabla> selectDynamicFull(Gentabla record) throws Exception;

	List<Gentabla> selectDynamicExtended(Gentabla record) throws Exception;

	//CUSTOM	
	List<TipoProcesoResponse> getTipoProceso(@Param("anio") Integer anio) throws Exception;
	
	List<EstadoRequerimientoResponse> getEstadoRequerimiento(@Param("idEtapaAdministrativa") Integer idEtapaAdministrativa) throws Exception;
	
	List<GentablaItemResponse> getItems(@Param("tipo") String tipo) throws Exception;
	
	EstadoRequerimientoResponse getEstadoRequerimientoByIdEstadosTipoDocumento(@Param("idestadosportipodocumento") Integer idestadosportipodocumento) throws Exception;
	
	

}
