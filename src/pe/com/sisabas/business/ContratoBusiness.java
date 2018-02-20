package pe.com.sisabas.business;

import java.util.List;

import pe.com.sisabas.be.Contrato;
import pe.com.sisabas.be.ContratoRequest;
import pe.com.sisabas.be.ContratoResponse;
import pe.com.sisabas.dto.ContratoDto;
import pe.com.sisabas.dto.OrdenDto;
import pe.com.sisabas.dto.OrdenListaDto;
import pe.com.sisabas.dto.SegRequest;
import pe.com.sisabas.dto.SegResponse;

public interface ContratoBusiness {
	
	public List<ContratoResponse> selectDynamicFull(ContratoRequest request) throws Exception;
	
	public void insertBasic(Contrato record) throws Exception;
	
	public List<SegResponse> ObtenerSeguimiento(SegRequest segRequest) throws Exception;
	
	public void updateByPrimaryKeyBasic(Contrato record) throws Exception;
	
	public Contrato selectByPrimaryKeyBasic(java.lang.Integer par_idcontrato) throws Exception;

    public List<Integer> listEjercicio() throws Exception;
    
    public void actualizarContrato(ContratoDto request) throws Exception;
    
}
