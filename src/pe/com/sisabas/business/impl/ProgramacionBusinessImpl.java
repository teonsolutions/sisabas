package pe.com.sisabas.business.impl;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.sisabas.be.Comiteproceso;
import pe.com.sisabas.be.Cuadrocomparativofuente;
import pe.com.sisabas.be.Cuadrocomparativoitem;
import pe.com.sisabas.be.Cuadrocomparativovr;
import pe.com.sisabas.be.Entregable;
import pe.com.sisabas.be.Estadosporetapapordocumento;
import pe.com.sisabas.be.Estadosportipodocumento;
import pe.com.sisabas.be.Grupodocumento;
import pe.com.sisabas.be.Miembrocomiteporproceso;
import pe.com.sisabas.be.Observacionesdocumentotecnico;
import pe.com.sisabas.be.Orden;
import pe.com.sisabas.be.Pacconsolidado;
import pe.com.sisabas.be.Pacprogramado;
import pe.com.sisabas.be.Pedido;
import pe.com.sisabas.be.Pedidosporpacconsolidado;
import pe.com.sisabas.be.Requisitosconformidad;
import pe.com.sisabas.business.ProgramacionBusiness;
import pe.com.sisabas.business.RequisitosconformidadBusiness;
import pe.com.sisabas.controller.PedidoController;
import pe.com.sisabas.dto.CertificacionItemsDto;
import pe.com.sisabas.dto.CertificacionRequest;
import pe.com.sisabas.dto.CompraDirectaDatosGeneralesDto;
import pe.com.sisabas.dto.CuadroComparativoItemsDto;
import pe.com.sisabas.dto.CuadroComparativoRequest;
import pe.com.sisabas.dto.CuadroComparativoVrDto;
import pe.com.sisabas.dto.EvaluacionDocumentoResponse;
import pe.com.sisabas.dto.ObservacionDocumentoTecnicoDto;
import pe.com.sisabas.dto.OrdenDto;
import pe.com.sisabas.dto.PacConsolidadoDto;
import pe.com.sisabas.dto.PacItemsDto;
import pe.com.sisabas.dto.PedidosPaoResponse;
import pe.com.sisabas.dto.RecepcionDTResponse;
import pe.com.sisabas.dto.RequisitoConformidadDto;
import pe.com.sisabas.dto.PaoRequest;
import pe.com.sisabas.dto.PaoResponse;
import pe.com.sisabas.dto.Resultado;
import pe.com.sisabas.dto.SeguimientoPagosResponse;
import pe.com.sisabas.dto.TipoProcesoResponse;
import pe.com.sisabas.dto.TransactionRequest;
import pe.com.sisabas.dto.TransactionResponse;
import pe.com.sisabas.persistence.ComiteprocesoMapper;
import pe.com.sisabas.persistence.CuadrocomparativofuenteMapper;
import pe.com.sisabas.persistence.CuadrocomparativoitemMapper;
import pe.com.sisabas.persistence.CuadrocomparativovrMapper;
import pe.com.sisabas.persistence.DocumentotecnicoMapper;
import pe.com.sisabas.persistence.EntregableMapper;
import pe.com.sisabas.persistence.EstadosporetapapordocumentoMapper;
import pe.com.sisabas.persistence.EstadosportipodocumentoMapper;
import pe.com.sisabas.persistence.GrupodocumentoMapper;
import pe.com.sisabas.persistence.MiembrocomiteporprocesoMapper;
import pe.com.sisabas.persistence.ObservacionesdocumentotecnicoMapper;
import pe.com.sisabas.persistence.OrdenMapper;
import pe.com.sisabas.persistence.PacconsolidadoMapper;
import pe.com.sisabas.persistence.PacprogramadoMapper;
import pe.com.sisabas.persistence.PedidoMapper;
import pe.com.sisabas.persistence.PedidosporpacconsolidadoMapper;
import pe.com.sisabas.persistence.RequisitosconformidadMapper;
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
	public CuadrocomparativofuenteMapper cuadrocomparativofuenteMapper;

	@Autowired
	public CuadrocomparativoitemMapper cuadrocomparativoitemMapper;

	@Autowired
	public CuadrocomparativovrMapper cuadrocomparativovrMapper;

	@Autowired
	public OrdenMapper ordenMapper;

	@Autowired
	public EntregableMapper entregableMapper;

	@Autowired
	public RequisitosconformidadMapper requisitosconformidadMapper;

	@Autowired
	public ComiteprocesoMapper comiteprocesoMapper;

	@Autowired
	public MiembrocomiteporprocesoMapper miembrocomiteporprocesoMapper;

	@Autowired
	public ObservacionesdocumentotecnicoMapper observacionesdocumentotecnicoMapper;
	
	@Autowired
	public UtilsBusiness utilsBusiness;

	@Override
	public Resultado recibirDocumentoTecnico(EvaluacionDocumentoResponse item, TransactionRequest request)
			throws Exception {
		// TODO Auto-generated method stub
		Resultado result = new Resultado(true, Constantes.mensajeGenerico.REGISTRO_CORRECTO);
		Date dateUpdate = new Date();

		Integer idDocumento;
		/*
		 * if
		 * (item.getIdcatalogotiponecesidad().equals(Constantes.tipoNecesidad.
		 * TIPO_NECESIDAD_PROGRAMADO)) { Pacprogramado programado =
		 * pacprogramadoMapper.selectByPrimaryKeyBasic(item.getIdPacProgramado()
		 * ); programado.setEstado(Constantes.estadosPorEtapa.
		 * EN_REVISION_DE_DOCUMENTO_TECNICO);
		 * programado.setFechamodificacionauditoria(dateUpdate);
		 * programado.setUsuariomodificacionauditoria(request.
		 * getUsuarioAuditoria());
		 * programado.setEquipoauditoria(request.getEquipoAuditoria());
		 * 
		 * idDocumento = item.getIdPacProgramado();
		 * pacprogramadoMapper.updateByPrimaryKey(programado); } else { Pedido
		 * pedido = pedidoMapper.selectByPrimaryKeyBasic(item.getIdpedido());
		 * pedido.setEstadopedido(Constantes.estadosPorEtapa.
		 * EN_REVISION_DE_DOCUMENTO_TECNICO);
		 * pedido.setFechamodificacionauditoria(dateUpdate);
		 * pedido.setEquipoauditoria(request.getEquipoAuditoria());
		 * pedido.setUsuariomodificacionauditoria(request.getUsuarioAuditoria())
		 * ;
		 * 
		 * idDocumento = pedido.getIdpedido();
		 * pedidoMapper.updateByPrimaryKey(pedido); }
		 */

		// PARA PROGRAMADOS Y NO PROGRAMADOS, se utiliza la misma tabla de
		// pedidos
		Pedido pedido = pedidoMapper.selectByPrimaryKeyBasic(item.getIdpedido());
		pedido.setEstadopedido(Constantes.estadosPorEtapa.EN_REVISION_DE_DOCUMENTO_TECNICO);
		pedido.setFechamodificacionauditoria(dateUpdate);
		pedido.setEquipoauditoria(request.getEquipoAuditoria());
		pedido.setUsuariomodificacionauditoria(request.getUsuarioAuditoria());

		idDocumento = pedido.getIdpedido();
		pedidoMapper.updateByPrimaryKey(pedido);

		// Insertamos históricos de estados
		Estadosportipodocumento param = new Estadosportipodocumento();
		param.setIdtipodocumento(Constantes.tipoDocumento.DOCUMENTO_TECNICO);
		param.setIdestadosporetapa(Constantes.estadosPorEtapa.EN_REVISION_DE_DOCUMENTO_TECNICO);
		// Estadosportipodocumento estados =
		// @.selectByEtapaTipoDocumento(Constantes.tipoDocumento.DOCUMENTO_TECNICO,
		// Constantes.estadosPorEtapa.EN_REVISION_DE_DOCUMENTO_TECNICO);
		Estadosportipodocumento estado = estadosportipodocumentoMapper.selectByEtapaTipoDocumento(param);
		if (estado != null) {
			java.util.Date date = new java.util.Date();
			Estadosporetapapordocumento record = new Estadosporetapapordocumento();
			record.setNrodocumento(idDocumento); // item.getIdpedido()
			record.setIdestadosportipodocumento(estado.getIdestadosportipodocumento());
			record.setIdtipodocumento(Constantes.tipoDocumento.DOCUMENTO_TECNICO);
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
		Integer idDocumento;
		/*
		 * if
		 * (item.getIdcatalogotiponecesidad().equals(Constantes.tipoNecesidad.
		 * TIPO_NECESIDAD_PROGRAMADO)) { Pacprogramado programado =
		 * pacprogramadoMapper.selectByPrimaryKeyBasic(item.getIdPacProgramado()
		 * ); programado.setEstado(Constantes.estadosPorEtapa.
		 * DOCUMENTO_TECNICO_APROBADO);
		 * programado.setFechamodificacionauditoria(dateUpdate);
		 * programado.setUsuariomodificacionauditoria(request.
		 * getUsuarioAuditoria());
		 * programado.setEquipoauditoria(request.getEquipoAuditoria());
		 * 
		 * idDocumento = programado.getIdpacprogramado();
		 * pacprogramadoMapper.updateByPrimaryKey(programado); } else { Pedido
		 * pedido = pedidoMapper.selectByPrimaryKeyBasic(item.getIdpedido());
		 * pedido.setEstadopedido(Constantes.estadosPorEtapa.
		 * DOCUMENTO_TECNICO_APROBADO);
		 * pedido.setFechamodificacionauditoria(dateUpdate);
		 * pedido.setEquipoauditoria(request.getEquipoAuditoria());
		 * pedido.setUsuariomodificacionauditoria(request.getUsuarioAuditoria())
		 * ;
		 * 
		 * idDocumento = pedido.getIdpedido();
		 * pedidoMapper.updateByPrimaryKey(pedido); }
		 */
		// SE UTILIZA LA MISMA TABLA PARA PROGRAMADOS Y NO PROGRAMDOS, tabla de
		// pedido
		Pedido pedido = pedidoMapper.selectByPrimaryKeyBasic(item.getIdpedido());
		pedido.setEstadopedido(Constantes.estadosPorEtapa.DOCUMENTO_TECNICO_APROBADO);
		pedido.setFechamodificacionauditoria(dateUpdate);
		pedido.setEquipoauditoria(request.getEquipoAuditoria());
		pedido.setUsuariomodificacionauditoria(request.getUsuarioAuditoria());

		idDocumento = pedido.getIdpedido();
		pedidoMapper.updateByPrimaryKey(pedido);

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
			record.setNrodocumento(idDocumento); // item.getIdpedido()
			record.setIdestadosportipodocumento(estado.getIdestadosportipodocumento());
			record.setIdtipodocumento(Constantes.tipoDocumento.DOCUMENTO_TECNICO);
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
	public Resultado observarDocumentoTecnico(TransactionRequest<EvaluacionDocumentoResponse> request)
			throws Exception {
		// TODO Auto-generated method stub
		Resultado result = new Resultado(true, Constantes.mensajeGenerico.REGISTRO_CORRECTO);
		Date dateUpdate = new Date();
		EvaluacionDocumentoResponse item = request.getEntityTransaction();

		// PAO - PROGRAMADO
		/*
		 * if (item.getIdpedido() == null && item.getIdPacProgramado() != null)
		 * { Pacprogramado programado =
		 * pacprogramadoMapper.selectByPrimaryKeyBasic(item.
		 * getIddocumentotecnico()); // programado.setGentablaIdcatalogoestado(
		 * OBSERVADO_POR_DOCUMENTO_TECNICO);
		 * programado.setFechamodificacionauditoria(dateUpdate);
		 * programado.setUsuariomodificacionauditoria(request.
		 * getUsuarioAuditoria());
		 * programado.setEquipoauditoria(request.getEquipoAuditoria());
		 * 
		 * pacprogramadoMapper.updateByPrimaryKey(programado);
		 * 
		 * } else if (item.getIdpedido() != null && item.getIdPacProgramado() ==
		 * null) { // PEDIDO - NO PROGRAMADO Pedido pedido =
		 * pedidoMapper.selectByPrimaryKeyBasic(item.getIddocumentotecnico());
		 * pedido.setEstadopedido(Constantes.estadosPorEtapa.
		 * OBSERVADO_POR_DOCUMENTO_TECNICO);
		 * pedido.setFechamodificacionauditoria(dateUpdate);
		 * pedido.setEquipoauditoria(request.getEquipoAuditoria());
		 * pedido.setUsuariomodificacionauditoria(request.getUsuarioAuditoria())
		 * ; pedidoMapper.updateByPrimaryKey(pedido); }
		 */
		// SE UTILIZA LA MISMA TABLA PARA PROGRAMADOS Y NO PROGRAMDOS, tabla de
		// pedido
		Pedido pedido = pedidoMapper.selectByPrimaryKeyBasic(item.getIdpedido());
		pedido.setEstadopedido(Constantes.estadosPorEtapa.OBSERVADO_POR_DOCUMENTO_TECNICO);
		pedido.setFechamodificacionauditoria(dateUpdate);
		pedido.setEquipoauditoria(request.getEquipoAuditoria());
		pedido.setUsuariomodificacionauditoria(request.getUsuarioAuditoria());
		pedidoMapper.updateByPrimaryKey(pedido);

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
			record.setIdtipodocumento(Constantes.tipoDocumento.DOCUMENTO_TECNICO);
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

		for (ObservacionDocumentoTecnicoDto obs : item.getObservaciones()) {
			Observacionesdocumentotecnico obsNew = new Observacionesdocumentotecnico();
			obsNew.setIdobservacionesdocumentotecnico(
					(int) utilsBusiness.getNextSeq(Sequence.SEQ_OBSERVACIONESDOCUMENTOTECNICO).longValue());
			obsNew.setIddocumentotecnico(item.getIddocumentotecnico());
			obsNew.setIdseccionesdocumentotecnico(obs.getIdseccionesdocumentotecnico());
			obsNew.setObservacion(obs.getObservacion());
			
			//AUDIT
			obsNew.setUsuariocreacionauditoria(request.getUsuarioAuditoria());
			obsNew.setFechamodificacionauditoria(new Date());
			obsNew.setEquipoauditoria(request.getEquipoAuditoria());
			obsNew.setProgramaauditoria(request.getProgramaAuditoria());
			obsNew.setEstadoauditoria(Constantes.estadoAuditoria.ACTIVO);
			observacionesdocumentotecnicoMapper.insert(obsNew);
			
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

			// REQUISITOS
			List<RequisitoConformidadDto> requisitos = requisitosconformidadMapper
					.getGetRequisitosByConsolidado(record.getIdPacConsolidado());
			cd.setListaRequisitosConformidad(requisitos);
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

		}
		result.setResultInt(idPacConsolidado);

		// REQUISITOS CONFORMIDAD
		List<RequisitoConformidadDto> listaRequisitos = compraDirecta.getListaRequisitosConformidad();
		for (RequisitoConformidadDto requisitoConformidadDto : listaRequisitos) {
			if (requisitoConformidadDto.getIdrequisitoconformidad() != null
					&& requisitoConformidadDto.getIdrequisitoconformidad() != 0) {
				Requisitosconformidad requisitoEdit = requisitosconformidadMapper
						.selectByPrimaryKeyBasic(requisitoConformidadDto.getIdrequisitoconformidad());
				if (requisitoEdit != null) {
					requisitoEdit.setIdcatalogotipodocumento(requisitoConformidadDto.getIdcatalogotipodocumento());

					// AUDIT
					requisitoEdit.setUsuariomodificacionauditoria(request.getUsuarioAuditoria());
					requisitoEdit.setFechamodificacionauditoria(new Date());
					requisitoEdit.setEquipoauditoria(request.getEquipoAuditoria());
					requisitoEdit.setProgramaauditoria(request.getProgramaAuditoria());
					requisitosconformidadMapper.updateByPrimaryKey(requisitoEdit);
				}
			} else {
				Requisitosconformidad requisitoNew = new Requisitosconformidad();
				requisitoNew.setIdcatalogotipodocumento(requisitoConformidadDto.getIdcatalogotipodocumento());
				requisitoNew.setIdpacconsolidado(compraDirecta.getIdPacConsolid());

				// AUDIT
				requisitoNew.setFechacreacionauditoria(new Date());
				requisitoNew.setUsuariocreacionauditoria(request.getUsuarioAuditoria());
				requisitoNew.setProgramaauditoria(request.getProgramaAuditoria());
				requisitoNew.setEquipoauditoria(request.getEquipoAuditoria());
				requisitoNew.setEstadoauditoria(Constantes.estadoAuditoria.ACTIVO);
				requisitoNew.setIdrequisitoconformidad(
						(int) utilsBusiness.getNextSeq(Sequence.SEQ_REQUISITOSCONFORMIDAD).longValue());
				requisitosconformidadMapper.insert(requisitoNew);
			}
		}

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
				estadoDoc.setIdtipodocumento(Constantes.tipoDocumento.PAO);

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
	public List<CuadroComparativoItemsDto> getCuadroComparativoItems(CuadroComparativoRequest request)
			throws Exception {
		// TODO Auto-generated method stub
		return pacconsolidadoMapper.getCuadroComparativoItems(request);
	}

	@Override
	public Resultado grabarCuadroComparativo(TransactionRequest<Cuadrocomparativofuente> request,
			List<CuadroComparativoItemsDto> items) throws Exception {
		// TODO Auto-generated method stub
		Resultado result = new Resultado(true, Constantes.mensajeGenerico.REGISTRO_CORRECTO);
		Cuadrocomparativofuente cuadrocomparativofuente = request.getEntityTransaction();
		Integer idCuadroComparativoFuente;
		if (cuadrocomparativofuente.getIdcuadrocomparativofuente() == null
				|| cuadrocomparativofuente.getIdcuadrocomparativofuente() == 0) {
			cuadrocomparativofuente
					.setProgramaauditoria(pe.com.sisabas.resources.Utils.obtenerPrograma(this.getClass()));
			/*
			 * cuadrocomparativofuente.setIdcuadrocomparativofuente((int)
			 * utilsBusiness .getNextSeq(pe.com.sisabas.resources.Sequence.
			 * SEQ_CUADROCOMPARATIVOFUENTE).longValue());
			 */
			// Audit
			cuadrocomparativofuente.setFechacreacionauditoria(new Date());
			cuadrocomparativofuente.setUsuariocreacionauditoria(request.getUsuarioAuditoria());
			cuadrocomparativofuente.setEstadoauditoria(Constantes.estadoAuditoria.ACTIVO);
			cuadrocomparativofuente.setEquipoauditoria(request.getEquipoAuditoria());
			cuadrocomparativofuente.setProgramaauditoria(request.getProgramaAuditoria());
			// End audit

			idCuadroComparativoFuente = (int) utilsBusiness
					.getNextSeq(pe.com.sisabas.resources.Sequence.SEQ_CUADROCOMPARATIVOFUENTE).longValue();
			cuadrocomparativofuente.setIdcuadrocomparativofuente(idCuadroComparativoFuente);
			cuadrocomparativofuenteMapper.insert(cuadrocomparativofuente);

			// Insert items del cuadro comparativo
			Cuadrocomparativoitem cuadrocomparativoitem;
			Double precio;
			for (int i = 0; i < items.size(); i++) {
				cuadrocomparativoitem = new Cuadrocomparativoitem();
				cuadrocomparativoitem.setIdcuadrocomparativofuente(idCuadroComparativoFuente);
				cuadrocomparativoitem.setIddetallepedido(items.get(i).getIdDetallePedido());
				precio = items.get(i).getPrecioReferencial();
				BigDecimal precioReferencial = new BigDecimal(precio);
				cuadrocomparativoitem.setPrecioreferencial(precioReferencial);

				// Audit
				cuadrocomparativoitem.setEquipoauditoria(request.getEquipoAuditoria());
				cuadrocomparativoitem.setUsuariomodificacionauditoria(request.getUsuarioAuditoria());
				cuadrocomparativoitem.setFechacreacionauditoria(new Date());
				cuadrocomparativoitem.setEstadoauditoria(Constantes.estadoAuditoria.ACTIVO);
				cuadrocomparativofuente.setProgramaauditoria(request.getProgramaAuditoria());
				// End audit

				cuadrocomparativoitem.setIdcuadrocomparativoitem((int) utilsBusiness
						.getNextSeq(pe.com.sisabas.resources.Sequence.SEQ_CUADROCOMPARATIVOITEM).longValue());
				cuadrocomparativoitemMapper.insert(cuadrocomparativoitem);
			}

		} else {
			cuadrocomparativofuente
					.setProgramaauditoria(pe.com.sisabas.resources.Utils.obtenerPrograma(this.getClass()));
			cuadrocomparativofuente.setFechamodificacionauditoria(new Date());
			cuadrocomparativofuente.setUsuariomodificacionauditoria(request.getUsuarioAuditoria());
			cuadrocomparativofuente.setEstadoauditoria(Constantes.estadoAuditoria.ACTIVO);
			cuadrocomparativofuente.setEquipoauditoria(request.getEquipoAuditoria());
			cuadrocomparativofuenteMapper.updateByPrimaryKey(cuadrocomparativofuente);
			idCuadroComparativoFuente = cuadrocomparativofuente.getIdcuadrocomparativofuente();

			// Actualiza items del cuadro comparativo
			Cuadrocomparativoitem cuadrocomparativoitemEdit;
			Double precio;
			for (int i = 0; i < items.size(); i++) {
				cuadrocomparativoitemEdit = cuadrocomparativoitemMapper
						.selectByPrimaryKeyBasicActive(items.get(i).getIdCuadroComparativoItem());
				if (cuadrocomparativoitemEdit != null) {
					precio = items.get(i).getPrecioReferencial();
					BigDecimal precioReferencial = new BigDecimal(precio);
					cuadrocomparativoitemEdit.setPrecioreferencial(precioReferencial);
					cuadrocomparativoitemEdit.setEquipoauditoria(request.getEquipoAuditoria());
					cuadrocomparativoitemEdit.setFechamodificacionauditoria(new Date());
					cuadrocomparativoitemEdit.setUsuariocreacionauditoria(request.getUsuarioAuditoria());
					cuadrocomparativoitemMapper.updateByPrimaryKey(cuadrocomparativoitemEdit);
				}
			}
		}

		// Delete cuadro comparativo valor referencia
		cuadrocomparativovrMapper.deleteByIdPacConsolidado(cuadrocomparativofuente.getIdpacconsolidado());
		// Determina el mínimo monto de valor referencial
		List<CuadroComparativoItemsDto> vr = pacconsolidadoMapper
				.getCuadroComparativoVR(cuadrocomparativofuente.getIdpacconsolidado());

		if (vr != null) {
			// Inserta valor referencial
			for (int i = 0; i < vr.size(); i++) {
				Double precioReferencial = vr.get(i).getPrecioReferencial();
				Cuadrocomparativovr cuadrocomparativovr = new Cuadrocomparativovr();
				cuadrocomparativovr.setIddetallepedido(vr.get(i).getIdDetallePedido());
				cuadrocomparativovr.setIdpacconsolidado(cuadrocomparativofuente.getIdpacconsolidado());
				cuadrocomparativovr.setValorreferencialitem(new BigDecimal(precioReferencial));
				cuadrocomparativovr
						.setIdcatalogoprocedimientovr(Constantes.procedimientoVR.COTIZACION_MENOR_PRECIO_OBTENIDA);
				cuadrocomparativovr.setFechacreacionauditoria(new Date());
				cuadrocomparativovr.setUsuariocreacionauditoria(request.getUsuarioAuditoria());
				cuadrocomparativovr.setEquipoauditoria(request.getEquipoAuditoria());
				cuadrocomparativovr.setEstadoauditoria(Constantes.estadoAuditoria.ACTIVO);
				cuadrocomparativovr.setIdcuadrocomparativovr((int) utilsBusiness
						.getNextSeq(pe.com.sisabas.resources.Sequence.SEQ_CUADROCOMPARATIVOVR).longValue());
				cuadrocomparativovrMapper.insert(cuadrocomparativovr);
			}
		}

		return result;
	}

	@Override
	public List<CuadroComparativoItemsDto> getCuadroComparativoItemsByConsolid(CuadroComparativoRequest request)
			throws Exception {
		// TODO Auto-generated method stub
		return pacconsolidadoMapper.getCuadroComparativoItemsByConsolid(request);
	}

	@Override
	public List<CuadroComparativoVrDto> getCuadroComparativoVrFinal(Integer idPacConsolidado) throws Exception {
		// TODO Auto-generated method stub
		return pacconsolidadoMapper.getCuadroComparativoVrFinal(idPacConsolidado);
	}

	@Override
	public Resultado eliminarCuadroComparativo(TransactionRequest<Cuadrocomparativofuente> request) throws Exception {
		// TODO Auto-generated method stub
		Resultado result = new Resultado(true, Constantes.mensajeGenerico.REGISTRO_CORRECTO);

		// delete cuadro comparativo
		Cuadrocomparativofuente cp = request.getEntityTransaction();
		cuadrocomparativovrMapper.deleteByIdPacConsolidado(cp.getIdpacconsolidado());
		cuadrocomparativoitemMapper.deleteAllByCuadroComparativoFuente(cp.getIdcuadrocomparativofuente());
		cuadrocomparativofuenteMapper.deleteByPrimaryKey(cp.getIdcuadrocomparativofuente());

		/* vuelve determinar el valor referencial */
		// Determina el mínimo monto de valor referencial
		List<CuadroComparativoItemsDto> vr = pacconsolidadoMapper.getCuadroComparativoVR(cp.getIdpacconsolidado());

		if (vr != null) {
			// Inserta valor referencial
			for (int i = 0; i < vr.size(); i++) {
				Double precioReferencial = vr.get(i).getPrecioReferencial();
				Cuadrocomparativovr cuadrocomparativovr = new Cuadrocomparativovr();
				cuadrocomparativovr.setIddetallepedido(vr.get(i).getIdDetallePedido());
				cuadrocomparativovr.setIdpacconsolidado(cp.getIdpacconsolidado());
				cuadrocomparativovr.setValorreferencialitem(new BigDecimal(precioReferencial));
				cuadrocomparativovr
						.setIdcatalogoprocedimientovr(Constantes.procedimientoVR.COTIZACION_MENOR_PRECIO_OBTENIDA);
				cuadrocomparativovr.setFechacreacionauditoria(new Date());
				cuadrocomparativovr.setUsuariocreacionauditoria(request.getUsuarioAuditoria());
				cuadrocomparativovr.setEquipoauditoria(request.getEquipoAuditoria());
				cuadrocomparativovr.setEstadoauditoria(Constantes.estadoAuditoria.ACTIVO);
				cuadrocomparativovr.setIdcuadrocomparativovr((int) utilsBusiness
						.getNextSeq(pe.com.sisabas.resources.Sequence.SEQ_CUADROCOMPARATIVOVR).longValue());
				cuadrocomparativovrMapper.insert(cuadrocomparativovr);
			}
		}

		return result;
	}

	@Override
	public List<OrdenDto> getCompraDirectaOrden(PaoRequest request) throws Exception {
		// TODO Auto-generated method stub
		return ordenMapper.getCompraDirectaOrden(request);
	}

	@Override
	public List<SeguimientoPagosResponse> getSeguimientoPagosSiaf(PaoRequest request) throws Exception {
		// TODO Auto-generated method stub
		return pacconsolidadoMapper.getSeguimientoPagosSiaf(request);
	}

	@Override
	public List<Entregable> getEntegablesByOrden(Integer idOrden) throws Exception {
		// TODO Auto-generated method stub
		return entregableMapper.getEntegablesByOrden(idOrden);
	}

	@Override
	public Resultado grabarOrden(TransactionRequest<List<OrdenDto>> request) throws Exception {
		// TODO Auto-generated method stub
		Resultado result = new Resultado(true, Constantes.mensajeGenerico.REGISTRO_CORRECTO);
		List<OrdenDto> ordenes = request.getEntityTransaction();
		OrdenDto ordenDto = null;
		Integer idOrden;
		Integer idgrupodocumento;
		for (int i = 0; i < ordenes.size(); i++) {
			ordenDto = ordenes.get(i);
			if (ordenDto.getIdOrden() != null) {
				// Update
				Orden ordenEdit = ordenMapper.selectByPrimaryKeyBasic(ordenDto.getIdOrden());
				idgrupodocumento = ordenEdit.getIdgrupodocumento();
				ordenEdit.setFechainicioprestacion(ordenDto.getFechaInicioPrestacion());
				ordenEdit.setFechafinprestacion(ordenDto.getFechaFinPrestacion());
				ordenEdit.setAnio(ordenDto.getAnio());
				ordenEdit.setEstadoexpedientesiaf(ordenDto.getNroExpedienteSiaf());
				ordenEdit.setEstadoorden(ordenDto.getEstadoOrden());
				ordenEdit.setMoneda(ordenDto.getMoneda());
				ordenEdit.setPlazoejecucion(ordenDto.getPlazo());
				// ordenEdit.setEstadoorden(estadoorden); TODO: CHECK

				// Audit
				ordenEdit.setFechamodificacionauditoria(new Date());
				ordenEdit.setUsuariomodificacionauditoria(request.getUsuarioAuditoria());
				ordenEdit.setProgramaauditoria(request.getProgramaAuditoria());
				ordenEdit.setEquipoauditoria(request.getEquipoAuditoria());
				ordenMapper.updateByPrimaryKey(ordenEdit);
				idOrden = ordenEdit.getIdorden();
			} else {
				// Insert grupo
				// Inserta grupo documento
				Grupodocumento grupodocumento = new Grupodocumento();
				idgrupodocumento = (int) utilsBusiness.getNextSeq(Sequence.SEQ_GRUPODOCUMENTO).longValue();
				grupodocumento.setIdgrupodocumento(idgrupodocumento);
				grupodocumento.setAnio(ordenDto.getAnio());
				grupodocumento.setCodigocentrocosto(ordenDto.getCodigoCentroCosto());
				grupodocumento.setUsuariocreacionauditoria(request.getUsuarioAuditoria());
				grupodocumento.setProgramaauditoria(request.getProgramaAuditoria());
				grupodocumento.setEquipoauditoria(request.getEquipoAuditoria());
				grupodocumento.setEstadoauditoria(Constantes.estadoAuditoria.ACTIVO);
				grupodocumentoMapper.insert(grupodocumento);

				// Insert
				Orden ordenNew = new Orden();
				ordenNew.setIdgrupodocumento(idgrupodocumento);
				ordenNew.setFechainicioprestacion(ordenDto.getFechaFinPrestacion());
				ordenNew.setFechafinprestacion(ordenDto.getFechaFinPrestacion());
				ordenNew.setAnio(ordenDto.getAnio());
				ordenNew.setEstadoexpedientesiaf(ordenDto.getNroExpedienteSiaf());
				ordenNew.setEstadoorden(ordenDto.getEstadoOrden());
				ordenNew.setMoneda(ordenDto.getMoneda());
				ordenNew.setPlazoejecucion(ordenDto.getPlazo());
				ordenNew.setIdpacconsolidado(ordenDto.getIdPacConsolidado());

				// Orden data
				ordenNew.setNroorden(ordenDto.getNroOrden().toString()); // verificar
																			// nro
																			// type
				ordenNew.setFechaorden(ordenDto.getFechaOrden());
				ordenNew.setAnio(ordenDto.getAnio());
				ordenNew.setAnioorden(ordenDto.getAnio());
				ordenNew.setNroexpedientesiaf(ordenDto.getNroExpedienteSiaf().toString());
				ordenNew.setMoneda(ordenDto.getMoneda());
				double monto = ordenDto.getTotalFactSoles();
				ordenNew.setMontoorden(new BigDecimal(monto));
				ordenNew.setEstadoexpedientesiaf(ordenDto.getEstadoOrden());
				ordenNew.setIdcatalogotipobien(ordenDto.getIdTipoBien());
				ordenNew.setIdunidadejecutora(ordenDto.getIdUnidadEjecutora());

				// Audit
				ordenNew.setFechacreacionauditoria(new Date());
				ordenNew.setUsuariocreacionauditoria(request.getUsuarioAuditoria());
				ordenNew.setProgramaauditoria(request.getProgramaAuditoria());
				ordenNew.setEquipoauditoria(request.getEquipoAuditoria());
				ordenNew.setEstadoauditoria(Constantes.estadoAuditoria.ACTIVO);
				idOrden = (int) utilsBusiness.getNextSeq(pe.com.sisabas.resources.Sequence.SEQ_CUADROCOMPARATIVOVR)
						.longValue();
				ordenNew.setIdorden(idOrden);
				ordenMapper.insert(ordenNew);
			}

			// delete details
			List<Entregable> entregablesDelete = entregableMapper.getEntegablesByOrden(ordenDto.getIdOrden());
			for (Entregable item : ordenDto.getEntegables()) {
				for (Entregable delete : entregablesDelete) {
					if (item.getIdentregable() == delete.getIdentregable()) {
						delete.setEstadoauditoria("Keep");
					}
				}
			}
			// Elimino aquelos no estas
			for (Entregable entregable : entregablesDelete) {
				if (!entregable.getEstadoauditoria().equals("Keep")) {
					entregableMapper.deleteByPrimaryKey(entregable.getIdentregable());
				}
			}

			// save details
			for (int j = 0; j < ordenDto.getEntegables().size(); j++) {
				Entregable entregable = ordenDto.getEntegables().get(j);
				if (entregable.getIdentregable() != null) {
					// Update
					Entregable entregableEdit = entregableMapper.selectByPrimaryKeyBasic(entregable.getIdentregable());
					if (entregableEdit != null) {
						entregableEdit.setNroentregable(entregable.getNroentregable());
						entregableEdit.setPlazoentregable(entregable.getPlazoentregable());
						entregableEdit.setMontoentregable(entregable.getMontoentregable());
						entregableEdit.setMontopenalidadentregable(entregable.getMontopenalidadentregable());
						entregableEdit.setFechapresentacionentregable(entregable.getFechapresentacionentregable());
						entregableEdit.setObservacionesentregable(entregable.getObservacionesentregable());
						entregableEdit.setIdcatalogoestadoentregable(entregable.getIdcatalogoestadoentregable());

						// Audit
						entregableEdit.setUsuariomodificacionauditoria(request.getUsuarioAuditoria());
						entregableEdit.setFechamodificacionauditoria(new Date());
						entregableMapper.updateByPrimaryKey(entregableEdit);
					}
				} else {
					// Insert
					entregable.setIdorden(idOrden);
					entregable.setIdgrupodocumento(idgrupodocumento);
					entregable.setAnio(ordenDto.getAnio());

					// Audit
					entregable.setUsuariocreacionauditoria(request.getUsuarioAuditoria());
					entregable.setFechacreacionauditoria(new Date());
					entregable.setEquipoauditoria(request.getEquipoAuditoria());
					entregable.setProgramaauditoria(request.getProgramaAuditoria());
					entregable.setEstadoauditoria(Constantes.estadoAuditoria.ACTIVO);
					entregable.setIdentregable((int) utilsBusiness
							.getNextSeq(pe.com.sisabas.resources.Sequence.SEQ_ENTREGABLE).longValue());
					entregableMapper.insert(entregable);
				}
			}
		}
		return result;
	}

	@Override
	public List<Orden> getOrdenByPacConsolid(Integer idPacConsolidado) throws Exception {
		// TODO Auto-generated method stub
		return ordenMapper.getOrdenByPacConsolid(idPacConsolidado);
	}

	@Override
	public PacConsolidadoDto getPacConsolidado(PaoRequest request) throws Exception {
		// TODO Auto-generated method stub
		PacConsolidadoDto pac = pacconsolidadoMapper.getPacConsolidado(request);
		if (pac != null) {

			// FECHA DE RECEPCION
			if (pac.getFechaRecepcionDocumentoTecnico() == null) {
				RecepcionDTResponse recepcion = pacconsolidadoMapper.getFechaRecepcionDT(request);
				if (recepcion != null)
					pac.setFechaRecepcionDocumentoTecnico(recepcion.getFechaRecepcion());
			}

			// PEDIDOS
			List<PedidosPaoResponse> pedidos = pacconsolidadoMapper.getPedidosPao(request);

			// ITEMS
			List<PacItemsDto> items = pacconsolidadoMapper.getPacItems(request);
			pac.setPedidos(pedidos);
			pac.setItems(items);

			if (pac.getNroCP() != null) {
				// CERTIFICACION PRESUPUESTAL
				CertificacionRequest cpParam = new CertificacionRequest();
				cpParam.setAnio(request.getAnio());
				cpParam.setIdUnidadEjecutoraSiaf(request.getIdUnidadEjecutoraSiaf());
				cpParam.setNroCP(pac.getNroCP());
				List<CertificacionItemsDto> cert = pacconsolidadoMapper.getCertificacionItems(cpParam);
				pac.setCertificacionItems(cert);

				double montoCP = 0;
				for (int i = 0; i < cert.size(); i++) {
					montoCP += cert.get(i).getValor();
				}

				// MONTO TOTAL DE CERTIFICACION PRESUPUESTAL
				pac.setMontoCP(montoCP);
			}
		}
		return pac;
	}

	@Override
	public Resultado grabarPacConsolidado(TransactionRequest<PacConsolidadoDto> request) throws Exception {
		// TODO Auto-generated method stub
		Resultado result = new Resultado(true, Constantes.mensajeGenerico.REGISTRO_CORRECTO);
		PacConsolidadoDto pac = request.getEntityTransaction();
		Pacconsolidado pc;
		Integer idPacConsolidado = 0;
		boolean saveEstado = false;
		if (pac.getIdPacConsolidado() != null) {
			pc = pacconsolidadoMapper.selectByPrimaryKeyBasic(pac.getIdPacConsolidado());
			if (pc != null) {
				// UPDATE PAC CONSOLIDADO

				// pc.setNroproceso(compraDirecta.getNroProceso());
				pc.setCodigotipoproceso("14");
				double valorMoneda = pac.getValorEstimadoContratacion();
				BigDecimal valorEstimado = new BigDecimal(valorMoneda);
				pc.setValorestimadocontracion(valorEstimado);

				// PAC
				pc.setNroitems(pac.getNroItems());
				pc.setEsitemunico(pac.getEsItemUnico());
				pc.setCantidad(pac.getCantidad());
				pc.setFlagcd("0");
				pc.setUnidadmedida(pac.getUnidadMedida());
				pc.setNombreespecialistavr(pac.getNombreEspecialistaVR());
				pc.setFechaasignacionespecialista(pac.getFechaRecepcionDocumentoTecnico());
				pc.setNropac(pac.getNroPac());
				pc.setIdcatalogotiponecesidad(pac.getIdCatalogoTipoNecesidad());
				pc.setIdcatalogotipocontratacion(pac.getIdCatalogoTipoContratacion());
				pc.setEstadorequerimiento(pac.getEstadoRequerimiento());
				pc.setIdcatalogoestadopac(pac.getIdCatalogoEstadoPac());
				pc.setUnidadmedida(pac.getUnidadMedida());
				pc.setDescpac(pac.getDescripcionPac());
				pc.setCantidad(pac.getCantidad());
				pc.setMesprevistoconvocatoria(pac.getMesPrevistoConvocatoria());
				pc.setIdcatalogotipobien(pac.getIdTipoBien());

				// AUDITORIA
				pc.setUsuariomodificacionauditoria(request.getUsuarioAuditoria());
				pc.setFechamodificacionauditoria(new Date());
				pc.setEquipoauditoria(request.getEquipoAuditoria());
				pc.setProgramaauditoria(request.getProgramaAuditoria());
				// END AUDITORIA

				pacconsolidadoMapper.updateByPrimaryKey(pc);
				idPacConsolidado = pc.getIdpacconsolidado();
				result.setResultInt(idPacConsolidado);
			}
		} else {
			saveEstado = true;
			// Inserta grupo documento
			Grupodocumento grupodocumento = new Grupodocumento();
			Integer idgrupodocumento = (int) utilsBusiness.getNextSeq(Sequence.SEQ_GRUPODOCUMENTO).longValue();
			grupodocumento.setIdgrupodocumento(idgrupodocumento);
			grupodocumento.setAnio(pac.getAnio());
			grupodocumento.setCodigocentrocosto(pac.getCodigoCentroCosto());
			grupodocumento.setUsuariocreacionauditoria(request.getUsuarioAuditoria());
			grupodocumento.setProgramaauditoria(request.getProgramaAuditoria());
			grupodocumento.setEquipoauditoria(request.getEquipoAuditoria());
			grupodocumento.setEstadoauditoria(Constantes.estadoAuditoria.ACTIVO);
			grupodocumentoMapper.insert(grupodocumento);

			// NEW PAC CONSOLIDADO
			pc = new Pacconsolidado();
			pc.setNroconsolid(pac.getNroConsolid().toString());
			pc.setAnio(pac.getAnio());
			pc.setIdunidadejecutora(pac.getIdUnidadEjecutora());
			pc.setIdgrupodocumento(idgrupodocumento);
			// pc.setCodigotipoproceso(pac.getTipoProceso());
			pc.setFlagcd("0");
			double valorMoneda = pac.getValorEstimadoContratacion();
			BigDecimal valorEstimado = new BigDecimal(valorMoneda);
			pc.setValorestimadocontracion(valorEstimado);
			pc.setIdcatalogotipocontratacion(pac.getIdTipoContratacion());
			pc.setIdcatalogoestadopac(pac.getIdCatalogoEstadoPac());
			pc.setIdcatalogotipobien(pac.getIdTipoBien());
			pc.setIdcatalogotiponecesidad(pac.getIdTipoNecesidad());
			pc.setEstadorequerimiento(pac.getEstadoRequerimiento());

			// PAC
			pc.setNroitems(pac.getNroItems());
			pc.setEsitemunico(pac.getEsItemUnico());
			pc.setCantidad(pac.getCantidad());
			pc.setFlagcd("0");
			pc.setUnidadmedida(pac.getUnidadMedida());
			pc.setNombreespecialistavr(pac.getNombreEspecialistaVR());
			pc.setFechaasignacionespecialista(pac.getFechaRecepcionDocumentoTecnico());
			pc.setNropac(pac.getNroPac());
			pc.setIdcatalogotiponecesidad(pac.getIdCatalogoTipoNecesidad());
			pc.setIdcatalogotipocontratacion(pac.getIdCatalogoTipoContratacion());
			pc.setEstadorequerimiento(pac.getEstadoRequerimiento());
			pc.setIdcatalogoestadopac(pac.getIdCatalogoEstadoPac());
			pc.setUnidadmedida(pac.getUnidadMedida());
			pc.setDescpac(pac.getDescripcionPac());
			pc.setCantidad(pac.getCantidad());
			pc.setMesprevistoconvocatoria(pac.getMesPrevistoConvocatoria());
			pc.setIdcatalogotipobien(pac.getIdTipoBien());

			pc.setFechaasignacionespecialista(pac.getFechaRecepcionDocumentoTecnico());
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

			// SOLO CUANDO ES NUEVO INSERTA PEDIDOS
			if (pac.getIdTipoNecesidad().equals(Constantes.tipoNecesidad.TIPO_NECESIDAD_NO_PROGRAMADO)) {
				// PEDIDOS POR PAC CONSOLIDADO
				List<PedidosPaoResponse> pedidos = pac.getPedidos();
				for (int i = 0; i < pedidos.size(); i++) {
					// pedidos.get(i).getEstadoPedido()
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

			result.setResultInt(idPacConsolidado);
		}

		// ESTADO: EN ESTUDIO DEL MERCADO
		int idTipoDocumento = Constantes.tipoDocumento.PAO;
		if (pc.getEstadorequerimiento().equals(Constantes.estadosPorEtapa.EN_ESTUDIO_DE_MERCADO)) {
			saveEstado = true;
			idTipoDocumento = Constantes.tipoDocumento.PAO;
		}

		if (saveEstado) {
			// Insertamos históricos de estados
			Estadosportipodocumento param = new Estadosportipodocumento();
			param.setIdtipodocumento(idTipoDocumento);
			param.setIdestadosporetapa(pc.getEstadorequerimiento());
			Estadosportipodocumento estado = estadosportipodocumentoMapper.selectByEtapaTipoDocumento(param);
			if (estado != null) {
				java.util.Date date = new java.util.Date();
				Estadosporetapapordocumento estadoDoc = new Estadosporetapapordocumento();
				estadoDoc.setNrodocumento(pc.getIdpacconsolidado());
				estadoDoc.setIdestadosportipodocumento(estado.getIdestadosportipodocumento());
				estadoDoc.setFechaingreso(date);
				estadoDoc.setIdtipodocumento(Constantes.tipoDocumento.PAO);

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
	public TransactionResponse<Miembrocomiteporproceso> grabarMiembrosComite(
			TransactionRequest<PacConsolidadoDto> request, Miembrocomiteporproceso miembrocomiteporproceso)
			throws Exception {
		// TODO Auto-generated method stub
		TransactionResponse<Miembrocomiteporproceso> result = new TransactionResponse<Miembrocomiteporproceso>();
		result.setEstado(true);
		result.setMensaje(Constantes.mensajeGenerico.REGISTRO_CORRECTO);

		PacConsolidadoDto pac = request.getEntityTransaction();
		if (miembrocomiteporproceso.getIdmiembrocomiteproceso() == null
				|| miembrocomiteporproceso.getIdmiembrocomiteproceso() == 0) {
			// INSERT
			Integer idComiteProceso;
			Pacconsolidado pacUpdate = pacconsolidadoMapper.selectByPrimaryKeyBasic(pac.getIdPacConsolidado());
			if (pacUpdate != null) {
				if (pacUpdate.getIdcomiteproceso() == null) {
					Comiteproceso comiteMiembro = new Comiteproceso();
					comiteMiembro.setFechacreacionauditoria(new Date());
					comiteMiembro.setUsuariocreacionauditoria(request.getUsuarioAuditoria());
					comiteMiembro.setEquipoauditoria(request.getEquipoAuditoria());
					comiteMiembro.setProgramaauditoria(request.getProgramaAuditoria());
					comiteMiembro.setEstadoauditoria(Constantes.estadoAuditoria.ACTIVO);
					idComiteProceso = (int) utilsBusiness.getNextSeq(Sequence.SEQ_COMITEPROCESO).longValue();
					comiteMiembro.setIdcomiteproceso(idComiteProceso);
					comiteprocesoMapper.insert(comiteMiembro);
				} else {
					idComiteProceso = pacUpdate.getIdcomiteproceso();
				}
				// Insert miembros de comite proceso
				miembrocomiteporproceso.setIdcomiteproceso(idComiteProceso);
				miembrocomiteporproceso.setFechacreacionauditoria(new Date());
				miembrocomiteporproceso.setUsuariocreacionauditoria(request.getUsuarioAuditoria());
				miembrocomiteporproceso.setEquipoauditoria(request.getEquipoAuditoria());
				miembrocomiteporproceso.setProgramaauditoria(request.getProgramaAuditoria());
				miembrocomiteporproceso.setEstadoauditoria(Constantes.estadoAuditoria.ACTIVO);
				miembrocomiteporproceso.setIdmiembrocomiteproceso(
						(int) utilsBusiness.getNextSeq(Sequence.SEQ_MIEMBROCOMITEPORPROCESO).longValue());
				miembrocomiteporprocesoMapper.insert(miembrocomiteporproceso);
				pacUpdate.setIdcomiteproceso(idComiteProceso);
				pacconsolidadoMapper.updateByPrimaryKey(pacUpdate);
			}
		} else {
			// UPDATE
			miembrocomiteporproceso.setFechamodificacionauditoria(new Date());
			miembrocomiteporproceso.setUsuariomodificacionauditoria(request.getUsuarioAuditoria());
			miembrocomiteporprocesoMapper.updateByPrimaryKey(miembrocomiteporproceso);
		}
		result.setEntityTransaction(miembrocomiteporproceso);
		return result;
	}

	@Override
	public Resultado grabarAprobacionPacConsolidado(TransactionRequest<PacConsolidadoDto> request) throws Exception {
		// TODO Auto-generated method stub
		Resultado result = new Resultado(true, Constantes.mensajeGenerico.REGISTRO_CORRECTO);
		PacConsolidadoDto pac = request.getEntityTransaction();
		Pacconsolidado pacEdit = pacconsolidadoMapper.selectByPrimaryKeyBasic(pac.getIdPacConsolidado());
		if (pacEdit != null) {
			pacEdit.setCodigotipoproceso(pac.getCodigoTipoProceso());
			BigDecimal nroproceso = new BigDecimal(pac.getNroProceso());
			pacEdit.setNroproceso(nroproceso);
			pacEdit.setNroconvocatoria(pac.getNroConvocatoria());
			pacEdit.setTiemposervicio(pac.getTiempoServicio());
			pacEdit.setFechasolicitudaprobacionexpediente(pac.getFechaSolicitudAprobacionExpediente());
			if (pac.isAprobado() && pacEdit.getFechaaprobacionexpediente() == null) {
				pacEdit.setFechaaprobacionexpediente(new Date());
			}
			pacconsolidadoMapper.updateByPrimaryKey(pacEdit);

			Estadosportipodocumento param = new Estadosportipodocumento();
			param.setIdtipodocumento(Constantes.tipoDocumento.PAO);
			param.setIdestadosporetapa(Constantes.estadosPorEtapa.REMITIDO_A_PROCESOS);
			Estadosportipodocumento estado = estadosportipodocumentoMapper.selectByEtapaTipoDocumento(param);
			if (estado != null) {
				java.util.Date date = new java.util.Date();
				Estadosporetapapordocumento estadoDoc = new Estadosporetapapordocumento();
				estadoDoc.setNrodocumento(pacEdit.getIdpacconsolidado());
				estadoDoc.setIdestadosportipodocumento(estado.getIdestadosportipodocumento());
				estadoDoc.setFechaingreso(date);
				estadoDoc.setIdtipodocumento(Constantes.tipoDocumento.PAO);

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
	public Resultado derivarExpediente(TransactionRequest<PacConsolidadoDto> request) throws Exception {
		// TODO Auto-generated method stub
		Resultado result = new Resultado(true, Constantes.mensajeGenerico.REGISTRO_CORRECTO);
		PacConsolidadoDto pac = request.getEntityTransaction();
		Pacconsolidado pacEdit = pacconsolidadoMapper.selectByPrimaryKeyBasic(pac.getIdPacConsolidado());
		if (pacEdit != null) {
			pacEdit.setFechaaprobacionexpediente(new Date());
			pacEdit.setEstadorequerimiento(Constantes.estadosPorEtapa.REMITIDO_A_PROCESOS);
			pacconsolidadoMapper.updateByPrimaryKey(pacEdit);

			// STATUS: REMITIDO_A_PROCESOS
			Estadosportipodocumento param = new Estadosportipodocumento();
			param.setIdtipodocumento(Constantes.tipoDocumento.PROCESO);
			param.setIdestadosporetapa(Constantes.estadosPorEtapa.REMITIDO_A_PROCESOS);

			Estadosportipodocumento estado = estadosportipodocumentoMapper.selectByEtapaTipoDocumento(param);
			if (estado != null) {
				java.util.Date date = new java.util.Date();
				Estadosporetapapordocumento record = new Estadosporetapapordocumento();
				record.setNrodocumento(pac.getIdPacConsolidado());
				record.setIdestadosportipodocumento(estado.getIdestadosportipodocumento());
				record.setFechaingreso(date);
				record.setFechacreacionauditoria(date);
				record.setUsuariocreacionauditoria(request.getUsuarioAuditoria());
				record.setEquipoauditoria(request.getEquipoAuditoria());
				record.setIdestadosporetapapordocumento(
						(int) utilsBusiness.getNextSeq(Sequence.SEQ_ESTADOSPORETAPAPORDOCUMENTO).longValue());

				record.setEstadoauditoria(Constantes.estadoAuditoria.ACTIVO);
				estadosporetapapordocumentoMapper.insert(record);
			}
		}

		return result;
	}

}
