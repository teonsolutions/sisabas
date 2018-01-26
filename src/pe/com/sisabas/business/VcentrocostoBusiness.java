package pe.com.sisabas.business;
import java.util.List;
import pe.com.sisabas.be.Vcentrocosto;
import pe.com.sisabas.be.VisSigaCentroCosto;
import pe.com.sisabas.dto.CentroCostoRequest;
import pe.com.sisabas.dto.CentroCostoResponse;

public interface VcentrocostoBusiness{

	public void deleteByPrimaryKeyBasic(Vcentrocosto par_record) throws Exception;

	public void insertBasic(Vcentrocosto record) throws Exception;

	public void insertFull(Vcentrocosto record) throws Exception;

	public void insertSelectiveBasic(Vcentrocosto record) throws Exception;

	public Vcentrocosto selectByPrimaryKeyBasic(java.lang.String par_codigocentrocosto) throws Exception;

	public Vcentrocosto selectByPrimaryKeyBasicFromList(java.lang.String par_codigocentrocosto,List<Vcentrocosto> list) throws Exception;

	public Vcentrocosto selectByPrimaryKeyBasicActive(java.lang.String par_codigocentrocosto) throws Exception;

	public Vcentrocosto selectByPrimaryKeyFull(java.lang.String par_codigocentrocosto) throws Exception;

	public Vcentrocosto selectByPrimaryKeyFullActive(java.lang.String par_codigocentrocosto) throws Exception;

	public List<Vcentrocosto> selectDynamicBasic(Vcentrocosto record) throws Exception;

	public List<Vcentrocosto> selectDynamicBasicActives(Vcentrocosto record) throws Exception;

	public List<Vcentrocosto> selectDynamicFull(Vcentrocosto record) throws Exception;

	public List<Vcentrocosto> selectDynamicFullActives(Vcentrocosto record) throws Exception;

	public List<Vcentrocosto> selectDynamicExtended(Vcentrocosto record) throws Exception;

	public List<Vcentrocosto> selectDynamicExtendedActives(Vcentrocosto record) throws Exception;

	public void updateByPrimaryKeySelectiveBasic(Vcentrocosto record) throws Exception;

	public void updateByPrimaryKeySelectiveFull(Vcentrocosto record) throws Exception;

	public void updateByPrimaryKeyBasic(Vcentrocosto record) throws Exception;

	public void updateByPrimaryKeyFull(Vcentrocosto record) throws Exception;

	public List<VisSigaCentroCosto> selectDynamicFullVis(VisSigaCentroCosto record);
	
	public List<CentroCostoResponse> getCentroCosto(CentroCostoRequest record) throws Exception;


}
