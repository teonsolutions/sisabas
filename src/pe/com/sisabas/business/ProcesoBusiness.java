package pe.com.sisabas.business;

import pe.com.sisabas.dto.ProcesoRequest;
import pe.com.sisabas.dto.ProcesoResultadoItemDesiertoDto;
import pe.com.sisabas.dto.ProcesoResultadoItemDto;
import pe.com.sisabas.dto.Resultado;
import pe.com.sisabas.dto.TransactionRequest;
import pe.com.sisabas.dto.TransactionResponse;
import pe.com.sisabas.persistence.PacconsolidadoMapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import pe.com.sisabas.be.Miembrocomiteporproceso;
import pe.com.sisabas.be.Procesoseleccion;
import pe.com.sisabas.dto.ContratoSigaRequest;
import pe.com.sisabas.dto.ConvocatoriaDto;
import pe.com.sisabas.dto.PacConsolidadoDto;
import pe.com.sisabas.dto.PersonaDto;
import pe.com.sisabas.dto.ProcesoDto;
import pe.com.sisabas.dto.ProcesoExportDto;
import pe.com.sisabas.dto.ProcesoExportRequest;

public interface ProcesoBusiness {
	public List<ProcesoDto> searchProceso(ProcesoRequest request) throws Exception;
	public Resultado recibirProceso(TransactionRequest<ProcesoDto> request) throws Exception;
	public TransactionResponse<Miembrocomiteporproceso> grabarMiembrosComite(TransactionRequest<ProcesoDto> request, Miembrocomiteporproceso miembrocomiteporproceso) throws Exception;
	public Resultado NotificarMiembros(TransactionRequest<List<Miembrocomiteporproceso>> request) throws Exception;
	public List<ProcesoDto> searchProcesoSeguimiento(ProcesoRequest request) throws Exception;
	public Resultado saveProceso(TransactionRequest<Procesoseleccion> request) throws Exception;
	public List<ConvocatoriaDto> searchConvocatoriaProceso(Integer idProcesoSeleccion) throws Exception;
	public List<ProcesoResultadoItemDto> selectResultadoByIdConvocatoria(Integer idconvocatoriaproceso) throws Exception;
	public Resultado sendProceso(TransactionRequest<List<ProcesoResultadoItemDto>> request, Integer idProcesoSeleccion) throws Exception;
	public Resultado saveCalendario(TransactionRequest<Procesoseleccion> request) throws Exception;
	public List<ProcesoDto> searchProcesoDesierto(ProcesoRequest request) throws Exception;
	public Resultado asignarResultadoProceso(TransactionRequest<List<ProcesoResultadoItemDesiertoDto>> request, PersonaDto persona) throws Exception;
	public boolean validarExisteContrato(ContratoSigaRequest request) throws Exception;
	public List<ProcesoExportDto> searchProcesoData(ProcesoExportRequest request) throws Exception;
}
