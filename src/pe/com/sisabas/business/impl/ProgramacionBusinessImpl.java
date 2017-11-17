package pe.com.sisabas.business.impl;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.sisabas.be.Estadosporetapapordocumento;
import pe.com.sisabas.be.Estadosportipodocumento;
import pe.com.sisabas.be.Pacprogramado;
import pe.com.sisabas.be.Pedido;
import pe.com.sisabas.business.ProgramacionBusiness;
import pe.com.sisabas.controller.PedidoController;
import pe.com.sisabas.dto.EvaluacionDocumentoResponse;
import pe.com.sisabas.dto.PaoRequest;
import pe.com.sisabas.dto.PaoResponse;
import pe.com.sisabas.dto.Resultado;
import pe.com.sisabas.dto.TransactionRequest;
import pe.com.sisabas.persistence.DocumentotecnicoMapper;
import pe.com.sisabas.persistence.EstadosporetapapordocumentoMapper;
import pe.com.sisabas.persistence.EstadosportipodocumentoMapper;
import pe.com.sisabas.persistence.PacconsolidadoMapper;
import pe.com.sisabas.persistence.PacprogramadoMapper;
import pe.com.sisabas.persistence.PedidoMapper;
import pe.com.sisabas.resources.Constantes;
import pe.com.sisabas.resources.Sequence;
import pe.com.sisabas.resources.business.UtilsBusiness;

@Service
public class ProgramacionBusinessImpl implements ProgramacionBusiness, Serializable {
	private static Logger logger=Logger.getLogger(ProgramacionBusinessImpl.class);

	private static final long serialVersionUID = 1L;
	
	@Autowired
	public PacprogramadoMapper pacprogramadoMapper;
	
	@Autowired
	public PedidoMapper pedidoMapper;
	
	@Autowired
	public EstadosportipodocumentoMapper estadosportipodocumentoMapper;	

	@Autowired
	public EstadosporetapapordocumentoMapper estadosporetapapordocumentoMapper;	

	@Autowired
	public PacconsolidadoMapper pacconsolidadoMapper;
	
	@Autowired
	public UtilsBusiness utilsBusiness;
	
	@Override
	public Resultado recibirDocumentoTecnico(EvaluacionDocumentoResponse item, TransactionRequest request)
			throws Exception {
		// TODO Auto-generated method stub		
		Resultado result = new Resultado(true, Constantes.mensajeGenerico.REGISTRO_CORRECTO);
		Date dateUpdate = new Date();
		
		if (item.getIdcatalogotiponecesidad().equals(Constantes.tipoNecesidad.TIPO_NECESIDAD_PROGRAMADO)){
			Pacprogramado programado = pacprogramadoMapper.selectByPrimaryKeyBasic(item.getIddocumentotecnico());
			//programado.setGentablaIdcatalogoestado(gentablaIdcatalogoestado);			
			programado.setFechamodificacionauditoria(dateUpdate);
			programado.setUsuariomodificacionauditoria(request.getUsuarioAuditoria());
			programado.setEquipoauditoria(request.getEquipoAuditoria());
			
			pacprogramadoMapper.updateByPrimaryKey(programado);
		}else{
			Pedido pedido = pedidoMapper.selectByPrimaryKeyBasic(item.getIddocumentotecnico());
			pedido.setEstadopedido(Constantes.estadosPorEtapa.EN_REVISION_DE_DOCUMENTO_TECNICO);
			pedido.setFechamodificacionauditoria(dateUpdate);
			pedido.setEquipoauditoria(request.getEquipoAuditoria());
			pedido.setUsuariomodificacionauditoria(request.getUsuarioAuditoria());			
			pedidoMapper.updateByPrimaryKey(pedido);			
		}
		
		//Insertamos históricos de estados
		Estadosportipodocumento param = new Estadosportipodocumento();
		param.setIdtipodocumento(Constantes.tipoDocumento.DOCUMENTO_TECNICO);
		param.setIdestadosporetapa(Constantes.estadosPorEtapa.EN_REVISION_DE_DOCUMENTO_TECNICO);
		//Estadosportipodocumento estados = estadosportipodocumentoMapper.selectByEtapaTipoDocumento(Constantes.tipoDocumento.DOCUMENTO_TECNICO, Constantes.estadosPorEtapa.EN_REVISION_DE_DOCUMENTO_TECNICO);
		Estadosportipodocumento estado = estadosportipodocumentoMapper.selectByEtapaTipoDocumento(param);
		if (estado != null){
			java.util.Date date = new java.util.Date();
			Estadosporetapapordocumento record = new Estadosporetapapordocumento();
			record.setNrodocumento(item.getIdpedido());
			record.setIdestadosportipodocumento(estado.getIdestadosportipodocumento());
			record.setFechaingreso(date);
			record.setFechacreacionauditoria(date);
			record.setUsuariocreacionauditoria(request.getUsuarioAuditoria());
			record.setEquipoauditoria(request.getEquipoAuditoria());
			
			//record.setIdestadosporetapapordocumento((int)utilsBusiness.getNextSeqTemporal(pe.com.sisabas.resources.Sequence.SEQ_ESTADOSPORETAPAPORDOCUMENTO).longValue());
			
			record.setIdestadosporetapapordocumento((int)utilsBusiness.getNextSeq(Sequence.SEQ_ESTADOSPORETAPAPORDOCUMENTO).longValue());

			record.setEstadoauditoria(Constantes.estadoAuditoria.ACTIVO);
			estadosporetapapordocumentoMapper.insert(record);
		}		
		
		return result;
	}

	@Override
	public Resultado aprobarDocumentoTecnico(EvaluacionDocumentoResponse item, TransactionRequest request)
			throws Exception {
		// TODO Auto-generated method stub
		Resultado result = new Resultado(true, Constantes.mensajeGenerico.REGISTRO_CORRECTO);
		Date dateUpdate = new Date();
		
		if (item.getIdcatalogotiponecesidad().equals(Constantes.tipoNecesidad.TIPO_NECESIDAD_PROGRAMADO)){
			Pacprogramado programado = pacprogramadoMapper.selectByPrimaryKeyBasic(item.getIddocumentotecnico());
			//programado.setGentablaIdcatalogoestado(EN_REVISION_DE_DOCUMENTO_TECNICO);			
			programado.setFechamodificacionauditoria(dateUpdate);
			programado.setUsuariomodificacionauditoria(request.getUsuarioAuditoria());
			programado.setEquipoauditoria(request.getEquipoAuditoria());
			
			pacprogramadoMapper.updateByPrimaryKey(programado);
		}else{
			Pedido pedido = pedidoMapper.selectByPrimaryKeyBasic(item.getIddocumentotecnico());
			pedido.setEstadopedido(Constantes.estadosPorEtapa.DOCUMENTO_TECNICO_APROBADO);
			pedido.setFechamodificacionauditoria(dateUpdate);
			pedido.setEquipoauditoria(request.getEquipoAuditoria());
			pedido.setUsuariomodificacionauditoria(request.getUsuarioAuditoria());			
			pedidoMapper.updateByPrimaryKey(pedido);			
		}
		
		//Insertamos históricos de estados
		Estadosportipodocumento param = new Estadosportipodocumento();
		param.setIdtipodocumento(Constantes.tipoDocumento.DOCUMENTO_TECNICO);
		param.setIdestadosporetapa(Constantes.estadosPorEtapa.DOCUMENTO_TECNICO_APROBADO);
		//Estadosportipodocumento estados = estadosportipodocumentoMapper.selectByEtapaTipoDocumento(Constantes.tipoDocumento.DOCUMENTO_TECNICO, Constantes.estadosPorEtapa.EN_REVISION_DE_DOCUMENTO_TECNICO);
		Estadosportipodocumento estado = estadosportipodocumentoMapper.selectByEtapaTipoDocumento(param);
		if (estado != null){
			java.util.Date date = new java.util.Date();
			Estadosporetapapordocumento record = new Estadosporetapapordocumento();
			record.setNrodocumento(item.getIdpedido());
			record.setIdestadosportipodocumento(estado.getIdestadosportipodocumento());
			record.setFechaingreso(date);
			record.setFechacreacionauditoria(date);
			record.setUsuariocreacionauditoria(request.getUsuarioAuditoria());
			record.setEquipoauditoria(request.getEquipoAuditoria());
			
			//record.setIdestadosporetapapordocumento((int)utilsBusiness.getNextSeqTemporal(pe.com.sisabas.resources.Sequence.SEQ_ESTADOSPORETAPAPORDOCUMENTO).longValue());
			
			record.setIdestadosporetapapordocumento((int)utilsBusiness.getNextSeq(Sequence.SEQ_ESTADOSPORETAPAPORDOCUMENTO).longValue());

			record.setEstadoauditoria(Constantes.estadoAuditoria.ACTIVO);
			estadosporetapapordocumentoMapper.insert(record);
		}		
		
		return result;
	}

	@Override
	public Resultado observarDocumentoTecnico(EvaluacionDocumentoResponse item, TransactionRequest request)
			throws Exception {
		// TODO Auto-generated method stub
		Resultado result = new Resultado(true, Constantes.mensajeGenerico.REGISTRO_CORRECTO);
		Date dateUpdate = new Date();
		
		//PAO - PROGRAMADO
		if (item.getIdpedido() == null && item.getIdPacProgramado() != null){
			Pacprogramado programado = pacprogramadoMapper.selectByPrimaryKeyBasic(item.getIddocumentotecnico());
			//programado.setGentablaIdcatalogoestado(OBSERVADO_POR_DOCUMENTO_TECNICO);			
			programado.setFechamodificacionauditoria(dateUpdate);
			programado.setUsuariomodificacionauditoria(request.getUsuarioAuditoria());
			programado.setEquipoauditoria(request.getEquipoAuditoria());
			
			pacprogramadoMapper.updateByPrimaryKey(programado);
			
		}else if(item.getIdpedido() != null &&  item.getIdPacProgramado() == null){
			//PEDIDO - NO PROGRAMADO
			Pedido pedido = pedidoMapper.selectByPrimaryKeyBasic(item.getIddocumentotecnico());
			pedido.setEstadopedido(Constantes.estadosPorEtapa.OBSERVADO_POR_DOCUMENTO_TECNICO);
			pedido.setFechamodificacionauditoria(dateUpdate);
			pedido.setEquipoauditoria(request.getEquipoAuditoria());
			pedido.setUsuariomodificacionauditoria(request.getUsuarioAuditoria());			
			pedidoMapper.updateByPrimaryKey(pedido);			
		}
		
		//Insertamos históricos de estados
		Estadosportipodocumento param = new Estadosportipodocumento();
		param.setIdtipodocumento(Constantes.tipoDocumento.DOCUMENTO_TECNICO);
		param.setIdestadosporetapa(Constantes.estadosPorEtapa.OBSERVADO_POR_DOCUMENTO_TECNICO);
		//Estadosportipodocumento estados = estadosportipodocumentoMapper.selectByEtapaTipoDocumento(Constantes.tipoDocumento.DOCUMENTO_TECNICO, Constantes.estadosPorEtapa.EN_REVISION_DE_DOCUMENTO_TECNICO);
		Estadosportipodocumento estado = estadosportipodocumentoMapper.selectByEtapaTipoDocumento(param);
		if (estado != null){
			java.util.Date date = new java.util.Date();
			Estadosporetapapordocumento record = new Estadosporetapapordocumento();
			record.setNrodocumento(item.getIdpedido());
			record.setIdestadosportipodocumento(estado.getIdestadosportipodocumento());
			record.setFechaingreso(date);
			record.setFechacreacionauditoria(date);
			record.setUsuariocreacionauditoria(request.getUsuarioAuditoria());
			record.setEquipoauditoria(request.getEquipoAuditoria());
			
			//record.setIdestadosporetapapordocumento((int)utilsBusiness.getNextSeqTemporal(pe.com.sisabas.resources.Sequence.SEQ_ESTADOSPORETAPAPORDOCUMENTO).longValue());
			
			record.setIdestadosporetapapordocumento((int)utilsBusiness.getNextSeq(Sequence.SEQ_ESTADOSPORETAPAPORDOCUMENTO).longValue());

			record.setEstadoauditoria(Constantes.estadoAuditoria.ACTIVO);
			estadosporetapapordocumentoMapper.insert(record);
		}		
		
		return result;
	}

	@Override
	public List<PaoResponse> getPaoListado(PaoRequest record) throws Exception {
		// TODO Auto-generated method stub
		return pacconsolidadoMapper.getPaoListado(record);
	}

		
}
