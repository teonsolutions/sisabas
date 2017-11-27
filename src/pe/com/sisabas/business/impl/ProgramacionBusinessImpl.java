package pe.com.sisabas.business.impl;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.sisabas.be.Estadosporetapapordocumento;
import pe.com.sisabas.be.Estadosportipodocumento;
import pe.com.sisabas.be.Grupodocumento;
import pe.com.sisabas.be.Pacconsolidado;
import pe.com.sisabas.be.Pacprogramado;
import pe.com.sisabas.be.Pedido;
import pe.com.sisabas.be.Pedidosporpacconsolidado;
import pe.com.sisabas.business.ProgramacionBusiness;
import pe.com.sisabas.controller.PedidoController;
import pe.com.sisabas.dto.CertificacionItemsDto;
import pe.com.sisabas.dto.CertificacionRequest;
import pe.com.sisabas.dto.CompraDirectaDatosGeneralesDto;
import pe.com.sisabas.dto.CuadroComparativoItemsDto;
import pe.com.sisabas.dto.EvaluacionDocumentoResponse;
import pe.com.sisabas.dto.PacItemsDto;
import pe.com.sisabas.dto.PedidosPaoResponse;
import pe.com.sisabas.dto.RecepcionDTResponse;
import pe.com.sisabas.dto.PaoRequest;
import pe.com.sisabas.dto.PaoResponse;
import pe.com.sisabas.dto.Resultado;
import pe.com.sisabas.dto.TransactionRequest;
import pe.com.sisabas.dto.TransactionResponse;
import pe.com.sisabas.persistence.DocumentotecnicoMapper;
import pe.com.sisabas.persistence.EstadosporetapapordocumentoMapper;
import pe.com.sisabas.persistence.EstadosportipodocumentoMapper;
import pe.com.sisabas.persistence.GrupodocumentoMapper;
import pe.com.sisabas.persistence.PacconsolidadoMapper;
import pe.com.sisabas.persistence.PacprogramadoMapper;
import pe.com.sisabas.persistence.PedidoMapper;
import pe.com.sisabas.persistence.PedidosporpacconsolidadoMapper;
import pe.com.sisabas.resources.Constantes;
import pe.com.sisabas.resources.Sequence;
import pe.com.sisabas.resources.business.UtilsBusiness;

@Service
public class ProgramacionBusinessImpl implements ProgramacionBusiness, Serializable {
	private static Logger logger = Logger.getLogger(ProgramacionBusinessImpl.class);

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
	public GrupodocumentoMapper grupodocumentoMapper;

	@Autowired
	public PedidosporpacconsolidadoMapper pedidosporpacconsolidadoMapper;

	@Autowired
	public UtilsBusiness utilsBusiness;

	@Override
	public Resultado recibirDocumentoTecnico(EvaluacionDocumentoResponse item, TransactionRequest request)
			throws Exception {
		// TODO Auto-generated method stub
		Resultado result = new Resultado(true, Constantes.mensajeGenerico.REGISTRO_CORRECTO);
		Date dateUpdate = new Date();

		if (item.getIdcatalogotiponecesidad().equals(Constantes.tipoNecesidad.TIPO_NECESIDAD_PROGRAMADO)) {
			Pacprogramado programado = pacprogramadoMapper.selectByPrimaryKeyBasic(item.getIddocumentotecnico());
			// programado.setGentablaIdcatalogoestado(gentablaIdcatalogoestado);
			programado.setFechamodificacionauditoria(dateUpdate);
			programado.setUsuariomodificacionauditoria(request.getUsuarioAuditoria());
			programado.setEquipoauditoria(request.getEquipoAuditoria());

			pacprogramadoMapper.updateByPrimaryKey(programado);
		} else {
			Pedido pedido = pedidoMapper.selectByPrimaryKeyBasic(item.getIdpedido());
			pedido.setEstadopedido(Constantes.estadosPorEtapa.EN_REVISION_DE_DOCUMENTO_TECNICO);
			pedido.setFechamodificacionauditoria(dateUpdate);
			pedido.setEquipoauditoria(request.getEquipoAuditoria());
			pedido.setUsuariomodificacionauditoria(request.getUsuarioAuditoria());
			pedidoMapper.updateByPrimaryKey(pedido);
		}

		// Insertamos históricos de estados
		Estadosportipodocumento param = new Estadosportipodocumento();
		param.setIdtipodocumento(Constantes.tipoDocumento.DOCUMENTO_TECNICO);
		param.setIdestadosporetapa(Constantes.estadosPorEtapa.EN_REVISION_DE_DOCUMENTO_TECNICO);
		// Estadosportipodocumento estados =
		// estadosportipodocumentoMapper.selectByEtapaTipoDocumento(Constantes.tipoDocumento.DOCUMENTO_TECNICO,
		// Constantes.estadosPorEtapa.EN_REVISION_DE_DOCUMENTO_TECNICO);
		Estadosportipodocumento estado = estadosportipodocumentoMapper.selectByEtapaTipoDocumento(param);
		if (estado != null) {
			java.util.Date date = new java.util.Date();
			Estadosporetapapordocumento record = new Estadosporetapapordocumento();
			record.setNrodocumento(item.getIdpedido());
			record.setIdestadosportipodocumento(estado.getIdestadosportipodocumento());
			record.setFechaingreso(date);
			record.setFechacreacionauditoria(date);
			record.setUsuariocreacionauditoria(request.getUsuarioAuditoria());
			record.setEquipoauditoria(request.getEquipoAuditoria());

			// record.setIdestadosporetapapordocumento((int)utilsBusiness.getNextSeqTemporal(pe.com.sisabas.resources.Sequence.SEQ_ESTADOSPORETAPAPORDOCUMENTO).longValue());

			record.setIdestadosporetapapordocumento(
					(int) utilsBusiness.getNextSeq(Sequence.SEQ_ESTADOSPORETAPAPORDOCUMENTO).longValue());

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

		if (item.getIdcatalogotiponecesidad().equals(Constantes.tipoNecesidad.TIPO_NECESIDAD_PROGRAMADO)) {
			Pacprogramado programado = pacprogramadoMapper.selectByPrimaryKeyBasic(item.getIddocumentotecnico());
			// programado.setGentablaIdcatalogoestado(EN_REVISION_DE_DOCUMENTO_TECNICO);
			programado.setFechamodificacionauditoria(dateUpdate);
			programado.setUsuariomodificacionauditoria(request.getUsuarioAuditoria());
			programado.setEquipoauditoria(request.getEquipoAuditoria());

			pacprogramadoMapper.updateByPrimaryKey(programado);
		} else {
			Pedido pedido = pedidoMapper.selectByPrimaryKeyBasic(item.getIdpedido());
			pedido.setEstadopedido(Constantes.estadosPorEtapa.DOCUMENTO_TECNICO_APROBADO);
			pedido.setFechamodificacionauditoria(dateUpdate);
			pedido.setEquipoauditoria(request.getEquipoAuditoria());
			pedido.setUsuariomodificacionauditoria(request.getUsuarioAuditoria());
			pedidoMapper.updateByPrimaryKey(pedido);
		}

		// Insertamos históricos de estados
		Estadosportipodocumento param = new Estadosportipodocumento();
		param.setIdtipodocumento(Constantes.tipoDocumento.DOCUMENTO_TECNICO);
		param.setIdestadosporetapa(Constantes.estadosPorEtapa.DOCUMENTO_TECNICO_APROBADO);
		// Estadosportipodocumento estados =
		// estadosportipodocumentoMapper.selectByEtapaTipoDocumento(Constantes.tipoDocumento.DOCUMENTO_TECNICO,
		// Constantes.estadosPorEtapa.EN_REVISION_DE_DOCUMENTO_TECNICO);
		Estadosportipodocumento estado = estadosportipodocumentoMapper.selectByEtapaTipoDocumento(param);
		if (estado != null) {
			java.util.Date date = new java.util.Date();
			Estadosporetapapordocumento record = new Estadosporetapapordocumento();
			record.setNrodocumento(item.getIdpedido());
			record.setIdestadosportipodocumento(estado.getIdestadosportipodocumento());
			record.setFechaingreso(date);
			record.setFechacreacionauditoria(date);
			record.setUsuariocreacionauditoria(request.getUsuarioAuditoria());
			record.setEquipoauditoria(request.getEquipoAuditoria());

			// record.setIdestadosporetapapordocumento((int)utilsBusiness.getNextSeqTemporal(pe.com.sisabas.resources.Sequence.SEQ_ESTADOSPORETAPAPORDOCUMENTO).longValue());

			record.setIdestadosporetapapordocumento(
					(int) utilsBusiness.getNextSeq(Sequence.SEQ_ESTADOSPORETAPAPORDOCUMENTO).longValue());

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

		// PAO - PROGRAMADO
		if (item.getIdpedido() == null && item.getIdPacProgramado() != null) {
			Pacprogramado programado = pacprogramadoMapper.selectByPrimaryKeyBasic(item.getIddocumentotecnico());
			// programado.setGentablaIdcatalogoestado(OBSERVADO_POR_DOCUMENTO_TECNICO);
			programado.setFechamodificacionauditoria(dateUpdate);
			programado.setUsuariomodificacionauditoria(request.getUsuarioAuditoria());
			programado.setEquipoauditoria(request.getEquipoAuditoria());

			pacprogramadoMapper.updateByPrimaryKey(programado);

		} else if (item.getIdpedido() != null && item.getIdPacProgramado() == null) {
			// PEDIDO - NO PROGRAMADO
			Pedido pedido = pedidoMapper.selectByPrimaryKeyBasic(item.getIddocumentotecnico());
			pedido.setEstadopedido(Constantes.estadosPorEtapa.OBSERVADO_POR_DOCUMENTO_TECNICO);
			pedido.setFechamodificacionauditoria(dateUpdate);
			pedido.setEquipoauditoria(request.getEquipoAuditoria());
			pedido.setUsuariomodificacionauditoria(request.getUsuarioAuditoria());
			pedidoMapper.updateByPrimaryKey(pedido);
		}

		// Insertamos históricos de estados
		Estadosportipodocumento param = new Estadosportipodocumento();
		param.setIdtipodocumento(Constantes.tipoDocumento.DOCUMENTO_TECNICO);
		param.setIdestadosporetapa(Constantes.estadosPorEtapa.OBSERVADO_POR_DOCUMENTO_TECNICO);
		// Estadosportipodocumento estados =
		// estadosportipodocumentoMapper.selectByEtapaTipoDocumento(Constantes.tipoDocumento.DOCUMENTO_TECNICO,
		// Constantes.estadosPorEtapa.EN_REVISION_DE_DOCUMENTO_TECNICO);
		Estadosportipodocumento estado = estadosportipodocumentoMapper.selectByEtapaTipoDocumento(param);
		if (estado != null) {
			java.util.Date date = new java.util.Date();
			Estadosporetapapordocumento record = new Estadosporetapapordocumento();
			record.setNrodocumento(item.getIdpedido());
			record.setIdestadosportipodocumento(estado.getIdestadosportipodocumento());
			record.setFechaingreso(date);
			record.setFechacreacionauditoria(date);
			record.setUsuariocreacionauditoria(request.getUsuarioAuditoria());
			record.setEquipoauditoria(request.getEquipoAuditoria());

			// record.setIdestadosporetapapordocumento((int)utilsBusiness.getNextSeqTemporal(pe.com.sisabas.resources.Sequence.SEQ_ESTADOSPORETAPAPORDOCUMENTO).longValue());

			record.setIdestadosporetapapordocumento(
					(int) utilsBusiness.getNextSeq(Sequence.SEQ_ESTADOSPORETAPAPORDOCUMENTO).longValue());

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

	@Override
	public List<PedidosPaoResponse> getPedidosPao(PaoRequest record) throws Exception {
		// TODO Auto-generated method stub
		return pacconsolidadoMapper.getPedidosPao(record);
	}

	@Override
	public CompraDirectaDatosGeneralesDto getCompraDirectaDatosGenerales(PaoRequest record) throws Exception {
		// TODO Auto-generated method stub
		CompraDirectaDatosGeneralesDto cd = pacconsolidadoMapper.getCompraDirectaDatosGenerales(record);
		if (cd != null) {
			// FECHA DE RECEPCION
			if (cd.getFechaDocumentoTecnico() == null) {
				RecepcionDTResponse recepcion = pacconsolidadoMapper.getFechaRecepcionDT(record);
				if (recepcion != null)
					cd.setFechaDocumentoTecnico(recepcion.getFechaRecepcion());
			}

			// PEDIDOS
			List<PedidosPaoResponse> pedidos = pacconsolidadoMapper.getPedidosPao(record);

			// ITEMS
			List<PacItemsDto> items = pacconsolidadoMapper.getPacItems(record);
			cd.setPedidos(pedidos);
			cd.setItems(items);

			if (cd.getNroCP() != null) {
				// CERTIFICACION PRESUPUESTAL
				CertificacionRequest cpParam = new CertificacionRequest();
				cpParam.setAnio(record.getAnio());
				cpParam.setIdUnidadEjecutoraSiaf(record.getIdUnidadEjecutoraSiaf());
				cpParam.setNroCP(cd.getNroCP());
				List<CertificacionItemsDto> cert = pacconsolidadoMapper.getCertificacionItems(cpParam);
				cd.setCertificacionItems(cert);

				double montoCP = 0;
				for (int i = 0; i < cert.size(); i++) {
					montoCP += cert.get(i).getValor();
				}

				// MONTO TOTAL DE CERTIFICACION PRESUPUESTAL
				cd.setMontoCP(montoCP);
			}
		}
		return cd;
	}

	@Override
	public List<PacItemsDto> getPacItems(PaoRequest record) throws Exception {
		// TODO Auto-generated method stub
		return pacconsolidadoMapper.getPacItems(record);
	}

	@Override
	public List<CertificacionItemsDto> getCertificacionItems(CertificacionRequest record) throws Exception {
		// TODO Auto-generated method stub
		return pacconsolidadoMapper.getCertificacionItems(record);
	}

	@Override
	public RecepcionDTResponse getFechaRecepcionDT(PaoRequest record) throws Exception {
		// TODO Auto-generated method stub
		return pacconsolidadoMapper.getFechaRecepcionDT(record);
	}

	@Override
	public Resultado grabarCompraDirecta(TransactionRequest<CompraDirectaDatosGeneralesDto> request) throws Exception {
		// TODO Auto-generated method stub
		Resultado result = new Resultado(true, Constantes.mensajeGenerico.REGISTRO_CORRECTO);
		CompraDirectaDatosGeneralesDto compraDirecta = request.getEntityTransaction();
		Pacconsolidado pc;
		Integer idPacConsolidado = 0;
		boolean saveEstado = false;
		if (compraDirecta.getIdPacConsolid() != null) {
			pc = pacconsolidadoMapper.selectByPrimaryKeyBasic(compraDirecta.getIdPacConsolid());
			if (pc != null) {
				// UPDATE PAC CONSOLIDADO

				// pc.setNroproceso(compraDirecta.getNroProceso());
				pc.setCodigotipoproceso("14");
				pc.setNroproceso(compraDirecta.getNroProceso());
				double valorMoneda = compraDirecta.getValorMoneda();
				BigDecimal valorEstimado = new BigDecimal(valorMoneda);
				pc.setValorestimadocontracion(valorEstimado);

				// pc.setEstadoauditoria(); // ITEM UNICO
				// pc.setNroitems(0); // NUMERO DE ITEMS
				// pc.setCantidad(); // CANTIDAD DE ITEMS
				pc.setFlagcd(compraDirecta.getFlagCD());
				// pc.setUnidadmedida(); //UNIDAD DE MEDIDA
				// pc.setNombreespecialistavr(); //NOMBRE ESPECIALISTA VR
				pc.setFechaasignacionespecialista(compraDirecta.getFechaDocumentoTecnico());

				// AUDITORIA
				pc.setUsuariomodificacionauditoria(request.getUsuarioAuditoria());
				pc.setFechamodificacionauditoria(new Date());
				pc.setEquipoauditoria(request.getEquipoAuditoria());
				pc.setProgramaauditoria(request.getProgramaAuditoria());
				// END AUDITORIA

				pacconsolidadoMapper.updateByPrimaryKey(pc);
				idPacConsolidado = pc.getIdpacconsolidado();
			}
		} else {
			saveEstado = true;
			// Inserta grupo documento
			Grupodocumento grupodocumento = new Grupodocumento();
			Integer idgrupodocumento = (int) utilsBusiness.getNextSeq(Sequence.SEQ_GRUPODOCUMENTO).longValue();
			grupodocumento.setIdgrupodocumento(idgrupodocumento);
			grupodocumento.setAnio(compraDirecta.getAnio());
			grupodocumento.setCodigocentrocosto(compraDirecta.getCodigoCentroCosto());
			grupodocumento.setUsuariocreacionauditoria(request.getUsuarioAuditoria());
			grupodocumento.setProgramaauditoria(request.getProgramaAuditoria());
			grupodocumento.setEquipoauditoria(request.getEquipoAuditoria());
			grupodocumento.setEstadoauditoria(Constantes.estadoAuditoria.ACTIVO);
			grupodocumentoMapper.insert(grupodocumento);

			// NEW PAC CONSOLIDADO
			pc = new Pacconsolidado();
			pc.setNroconsolid(compraDirecta.getNroConsolid());
			pc.setAnio(compraDirecta.getAnio());
			pc.setIdunidadejecutora(compraDirecta.getIdUnidadEjecutora());
			pc.setIdgrupodocumento(idgrupodocumento);
			pc.setCodigotipoproceso(compraDirecta.getTipoProceso());
			pc.setFlagcd(compraDirecta.getFlagCD());
			pc.setNroproceso(compraDirecta.getNroProceso());
			double valorMoneda = compraDirecta.getValorMoneda();
			BigDecimal valorEstimado = new BigDecimal(valorMoneda);
			pc.setValorestimadocontracion(valorEstimado);
			pc.setIdcatalogotipocontratacion(compraDirecta.getIdTipoContratacion());
			pc.setIdcatalogoestadopac(null);
			pc.setIdcatalogotipobien(compraDirecta.getIdTipoBien());
			pc.setIdcatalogotiponecesidad(compraDirecta.getIdTipoNecesidad());
			pc.setEstadorequerimiento(compraDirecta.getEstadoRequerimiento());
									
			// pc.setEstadoauditoria(); // ITEM UNICO
			// pc.setNroitems(0); // NUMERO DE ITEMS
			// pc.setCantidad(); // CANTIDAD DE ITEMS			
			// pc.setUnidadmedida(); //UNIDAD DE MEDIDA
			// pc.setNombreespecialistavr(); //NOMBRE ESPECIALISTA VR
			pc.setFechaasignacionespecialista(compraDirecta.getFechaDocumentoTecnico());
			idPacConsolidado = (int) utilsBusiness.getNextSeq(Sequence.SEQ_PACCONSOLIDADO).longValue();
			pc.setIdpacconsolidado(idPacConsolidado);

			// AUDITORIA
			pc.setUsuariocreacionauditoria(request.getUsuarioAuditoria());
			pc.setFechacreacionauditoria(new Date());
			pc.setProgramaauditoria(request.getProgramaAuditoria());
			pc.setEquipoauditoria(request.getEquipoAuditoria());
			pc.setEstadoauditoria(Constantes.estadoAuditoria.ACTIVO);
			// END AUDITORIA

			pacconsolidadoMapper.insert(pc);
		}

		if (compraDirecta.getIdTipoNecesidad().equals(Constantes.tipoNecesidad.TIPO_NECESIDAD_NO_PROGRAMADO)) {
			// PEDIDOS POR PAC CONSOLIDADO
			List<PedidosPaoResponse> pedidos = compraDirecta.getPedidos();
			for (int i = 0; i < pedidos.size(); i++) {
				Pedidosporpacconsolidado pedidoItem = new Pedidosporpacconsolidado();
				pedidoItem.setIdpedidoporpacconsolidado(
						(int) utilsBusiness.getNextSeq(Sequence.SEQ_PEDIDOSPORPACCONSOLIDADO).longValue());
				pedidoItem.setIdpacconsolidado(idPacConsolidado);
				pedidoItem.setIdpedido(pedidos.get(i).getIdPedido());
				pedidoItem.setFechacreacionauditoria(new Date());
				pedidoItem.setEquipoauditoria(request.getEquipoAuditoria());
				pedidoItem.setUsuariocreacionauditoria(request.getUsuarioAuditoria());
				pedidoItem.setProgramaauditoria(request.getProgramaAuditoria());
				pedidoItem.setEstadoauditoria(Constantes.estadoAuditoria.ACTIVO);
				pedidosporpacconsolidadoMapper.insert(pedidoItem);
			}

			// SINAD POR PAC CONSOLIDADO
		}

		// REQUISITOS CONFORMIDAD

		// ESTADOS
		int idTipoDocumento = Constantes.tipoDocumento.PAO;
		if (pc.getEstadorequerimiento().equals(Constantes.estadosPorEtapa.EN_GIRO_DE_ORDEN)) {
			saveEstado = true;
			idTipoDocumento = Constantes.tipoDocumento.ORDEN;
		}

		if (saveEstado) {
			// Insertamos históricos de estados
			Estadosportipodocumento param = new Estadosportipodocumento();
			param.setIdtipodocumento(idTipoDocumento);
			param.setIdestadosporetapa(pc.getEstadorequerimiento());
			// Estadosportipodocumento estados =
			// estadosportipodocumentoMapper.selectByEtapaTipoDocumento(Constantes.tipoDocumento.DOCUMENTO_TECNICO,
			// Constantes.estadosPorEtapa.EN_REVISION_DE_DOCUMENTO_TECNICO);
			Estadosportipodocumento estado = estadosportipodocumentoMapper.selectByEtapaTipoDocumento(param);
			if (estado != null) {
				java.util.Date date = new java.util.Date();
				Estadosporetapapordocumento estadoDoc = new Estadosporetapapordocumento();
				estadoDoc.setNrodocumento(pc.getIdpacconsolidado());
				estadoDoc.setIdestadosportipodocumento(estado.getIdestadosportipodocumento());
				estadoDoc.setFechaingreso(date);

				estadoDoc.setFechacreacionauditoria(date);
				estadoDoc.setUsuariocreacionauditoria(request.getUsuarioAuditoria());
				estadoDoc.setEquipoauditoria(request.getEquipoAuditoria());
				estadoDoc.setProgramaauditoria(request.getProgramaAuditoria());

				// record.setIdestadosporetapapordocumento((int)utilsBusiness.getNextSeqTemporal(pe.com.sisabas.resources.Sequence.SEQ_ESTADOSPORETAPAPORDOCUMENTO).longValue());
				estadoDoc.setIdestadosporetapapordocumento(
						(int) utilsBusiness.getNextSeq(Sequence.SEQ_ESTADOSPORETAPAPORDOCUMENTO).longValue());

				estadoDoc.setEstadoauditoria(Constantes.estadoAuditoria.ACTIVO);
				estadosporetapapordocumentoMapper.insert(estadoDoc);
			}
		}

		return result;
	}

	@Override
	public List<CuadroComparativoItemsDto> getCuadroComparativoItems(Integer idPacConsolidado) throws Exception {
		// TODO Auto-generated method stub
		return pacconsolidadoMapper.getCuadroComparativoItems(idPacConsolidado);
	}

}
