package pe.com.sisabas.business;
import java.util.List;
import pe.com.sisabas.be.Documentotecnico;
import pe.com.sisabas.dto.EvaluacionDocumentoRequest;
import pe.com.sisabas.dto.EvaluacionDocumentoResponse;
import pe.com.sisabas.dto.Resultado;
import pe.com.sisabas.dto.TransactionRequest;
import pe.com.sisabas.dto.TransactionResponse;

public interface DocumentotecnicoBusiness{

	public void deleteByPrimaryKeyBasic(Documentotecnico par_record) throws Exception;

	public void insertBasic(Documentotecnico record) throws Exception;

	public void insertFull(Documentotecnico record) throws Exception;

	public void insertSelectiveBasic(Documentotecnico record) throws Exception;

	public Documentotecnico selectByPrimaryKeyBasic(java.lang.Integer par_iddocumentotecnico) throws Exception;

	public Documentotecnico selectByPrimaryKeyBasicFromList(java.lang.Integer par_iddocumentotecnico,List<Documentotecnico> list) throws Exception;

	public Documentotecnico selectByPrimaryKeyBasicActive(java.lang.Integer par_iddocumentotecnico) throws Exception;

	public Documentotecnico selectByPrimaryKeyFull(java.lang.Integer par_iddocumentotecnico) throws Exception;

	public Documentotecnico selectByPrimaryKeyFullActive(java.lang.Integer par_iddocumentotecnico) throws Exception;

	public List<Documentotecnico> selectDynamicBasic(Documentotecnico record) throws Exception;

	public List<Documentotecnico> selectDynamicBasicActives(Documentotecnico record) throws Exception;

	public List<Documentotecnico> selectDynamicFull(Documentotecnico record) throws Exception;

	public List<Documentotecnico> selectDynamicFullActives(Documentotecnico record) throws Exception;

	public List<Documentotecnico> selectDynamicExtended(Documentotecnico record) throws Exception;

	public List<Documentotecnico> selectDynamicExtendedActives(Documentotecnico record) throws Exception;

	public void updateByPrimaryKeySelectiveBasic(Documentotecnico record) throws Exception;

	public void updateByPrimaryKeySelectiveFull(Documentotecnico record) throws Exception;

	public void updateByPrimaryKeyBasic(Documentotecnico record) throws Exception;

	public void updateByPrimaryKeyFull(Documentotecnico record) throws Exception;

	public List<EvaluacionDocumentoResponse> getPedidosEvaluacion(EvaluacionDocumentoRequest record) throws Exception;	
	
}
