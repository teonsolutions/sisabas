package pe.com.sisabas.business;

import java.util.List;

import pe.com.sisabas.be.Cuadrocomparativofuente;
import pe.com.sisabas.dto.CertificacionItemsDto;
import pe.com.sisabas.dto.CertificacionRequest;
import pe.com.sisabas.dto.CompraDirectaDatosGeneralesDto;
import pe.com.sisabas.dto.CuadroComparativoItemsDto;
import pe.com.sisabas.dto.CuadroComparativoRequest;
import pe.com.sisabas.dto.CuadroComparativoVrDto;
import pe.com.sisabas.dto.EvaluacionDocumentoResponse;
import pe.com.sisabas.dto.PacItemsDto;
import pe.com.sisabas.dto.PedidosPaoResponse;
import pe.com.sisabas.dto.RecepcionDTResponse;
import pe.com.sisabas.dto.PaoRequest;
import pe.com.sisabas.dto.PaoResponse;
import pe.com.sisabas.dto.Resultado;
import pe.com.sisabas.dto.TransactionRequest;

public interface ProgramacionBusiness {
	public Resultado recibirDocumentoTecnico(EvaluacionDocumentoResponse item, TransactionRequest request) throws Exception;
	public Resultado aprobarDocumentoTecnico(EvaluacionDocumentoResponse item, TransactionRequest request) throws Exception;
	public Resultado observarDocumentoTecnico(EvaluacionDocumentoResponse item, TransactionRequest request) throws Exception;	
	public List<PaoResponse> getPaoListado(PaoRequest record) throws Exception;
	public List<PedidosPaoResponse> getPedidosPao(PaoRequest record) throws Exception;
	public CompraDirectaDatosGeneralesDto getCompraDirectaDatosGenerales(PaoRequest record) throws Exception;
	public List<PacItemsDto> getPacItems(PaoRequest record) throws Exception;
	public List<CertificacionItemsDto> getCertificacionItems(CertificacionRequest record) throws Exception;
	public RecepcionDTResponse getFechaRecepcionDT(PaoRequest record) throws Exception;
	public Resultado grabarCompraDirecta(TransactionRequest<CompraDirectaDatosGeneralesDto> request) throws Exception;
	public List<CuadroComparativoItemsDto> getCuadroComparativoItems(CuadroComparativoRequest request) throws Exception;
	public Resultado grabarCuadroComparativo(TransactionRequest<Cuadrocomparativofuente> request, List<CuadroComparativoItemsDto> items) throws Exception;
	public List<CuadroComparativoItemsDto> getCuadroComparativoItemsByConsolid(CuadroComparativoRequest request) throws Exception;
	public List<CuadroComparativoVrDto> getCuadroComparativoVrFinal(Integer idPacConsolidado) throws Exception;	
	public Resultado eliminarCuadroComparativo(TransactionRequest<Cuadrocomparativofuente> request) throws Exception;
}
