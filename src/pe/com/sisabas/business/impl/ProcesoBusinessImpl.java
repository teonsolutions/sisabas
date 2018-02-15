package pe.com.sisabas.business.impl;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.com.sisabas.be.Calendarioprocesoseleccion;
import pe.com.sisabas.be.Comiteproceso;
import pe.com.sisabas.be.Convocatoriaprocesoseleccion;
import pe.com.sisabas.be.Entregable;
import pe.com.sisabas.be.Estadosporetapapordocumento;
import pe.com.sisabas.be.Estadosportipodocumento;
import pe.com.sisabas.be.Miembrocomiteporproceso;
import pe.com.sisabas.be.Pacconsolidado;
import pe.com.sisabas.be.Procesoseleccion;
import pe.com.sisabas.be.Resultadoprocesoseleccion;
import pe.com.sisabas.business.ProcesoBusiness;
import pe.com.sisabas.dto.CalendarioDto;
import pe.com.sisabas.dto.ComiteDto;
import pe.com.sisabas.dto.ConvocatoriaDto;
import pe.com.sisabas.dto.PacConsolidadoDto;
import pe.com.sisabas.dto.ProcesoDto;
import pe.com.sisabas.dto.ProcesoRequest;
import pe.com.sisabas.dto.ProcesoResultadoItemDto;
import pe.com.sisabas.dto.Resultado;
import pe.com.sisabas.dto.TransactionRequest;
import pe.com.sisabas.dto.TransactionResponse;
import pe.com.sisabas.persistence.CalendarioprocesoseleccionMapper;
import pe.com.sisabas.persistence.ComiteprocesoMapper;
import pe.com.sisabas.persistence.ConvocatoriaprocesoseleccionMapper;
import pe.com.sisabas.persistence.EstadosporetapapordocumentoMapper;
import pe.com.sisabas.persistence.EstadosportipodocumentoMapper;
import pe.com.sisabas.persistence.MiembrocomiteporprocesoMapper;
import pe.com.sisabas.persistence.PacconsolidadoMapper;
import pe.com.sisabas.persistence.ProcesoseleccionMapper;
import pe.com.sisabas.persistence.ResultadoprocesoporusuarioMapper;
import pe.com.sisabas.persistence.ResultadoprocesoseleccionMapper;
import pe.com.sisabas.resources.Constantes;
import pe.com.sisabas.resources.Sequence;
import pe.com.sisabas.resources.business.UtilsBusiness;

@Service
public class ProcesoBusinessImpl implements ProcesoBusiness, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	public PacconsolidadoMapper pacconsolidadoMapper;

	@Autowired
	public EstadosporetapapordocumentoMapper estadosporetapapordocumentoMapper;

	@Autowired
	public UtilsBusiness utilsBusiness;

	@Autowired
	public EstadosportipodocumentoMapper estadosportipodocumentoMapper;

	@Autowired
	public MiembrocomiteporprocesoMapper miembrocomiteporprocesoMapper;

	@Autowired
	public ComiteprocesoMapper comiteprocesoMapper;

	@Autowired
	public ProcesoseleccionMapper procesoseleccionMapper;

	@Autowired
	public ConvocatoriaprocesoseleccionMapper convocatoriaprocesoseleccionMapper;

	@Autowired
	public CalendarioprocesoseleccionMapper calendarioprocesoseleccionMapper;

	@Autowired
	public ResultadoprocesoseleccionMapper resultadoprocesoseleccionMapper;

	@Override
	public List<ProcesoDto> searchProceso(ProcesoRequest request) throws Exception {
		// TODO Auto-generated method stub
		return procesoseleccionMapper.searchProceso(request);
	}

	@Override
	@Transactional
	public Resultado recibirProceso(TransactionRequest<ProcesoDto> request) throws Exception {
		// TODO Auto-generated method stub
		Resultado result = new Resultado(true, Constantes.mensajeGenerico.REGISTRO_CORRECTO);
		ProcesoDto procesoDto = request.getEntityTransaction();
		Pacconsolidado pac = pacconsolidadoMapper.selectByPrimaryKeyBasic(procesoDto.getIdPacConsolidado());

		// status
		Estadosportipodocumento param = new Estadosportipodocumento();
		param.setIdtipodocumento(Constantes.tipoDocumento.PROCESO);
		param.setIdestadosporetapa(Constantes.estadosPorEtapa.EN_COMITE_ESPECIAL);
		Estadosportipodocumento estado = estadosportipodocumentoMapper.selectByEtapaTipoDocumento(param);

		// Process
		Integer idProcesoSeleccion = 0;

		// Get miembros de comité de selección
		List<String> ordenListaCampos = new ArrayList<String>();
		ordenListaCampos.add("A1.IDMIEMBROCOMITEPROCESO");
		Miembrocomiteporproceso miembrocomiteporproceso = new Miembrocomiteporproceso();
		miembrocomiteporproceso.setOrdenListaCampos(ordenListaCampos);
		miembrocomiteporproceso.setOrdenTipo("DESC");

		// Add conditions IN clause
		miembrocomiteporproceso.addConditionInIdcatalogotipomiembro(null);
		miembrocomiteporproceso.addConditionInIdcatalogoestadomiembrocomite(null);
		miembrocomiteporproceso.setIdmiembrocomiteproceso(pac.getIdcomiteproceso());
		List<Miembrocomiteporproceso> listaMiembrocomiteporproceso = miembrocomiteporprocesoMapper
				.selectDynamicFull(miembrocomiteporproceso);

		Integer idComiteProceso = 0;
		if (listaMiembrocomiteporproceso != null && listaMiembrocomiteporproceso.size() > 0) {
			boolean cmSaved = false;
			for (Miembrocomiteporproceso member : listaMiembrocomiteporproceso) {
				if (!cmSaved) {
					// create new miembro comite
					Comiteproceso comiteMiembro = new Comiteproceso();
					comiteMiembro.setFechacreacionauditoria(new Date());
					comiteMiembro.setUsuariocreacionauditoria(request.getUsuarioAuditoria());
					comiteMiembro.setEquipoauditoria(request.getEquipoAuditoria());
					comiteMiembro.setProgramaauditoria(request.getProgramaAuditoria());
					comiteMiembro.setEstadoauditoria(Constantes.estadoAuditoria.ACTIVO);
					idComiteProceso = (int) utilsBusiness.getNextSeq(Sequence.SEQ_COMITEPROCESO).longValue();
					comiteMiembro.setIdcomiteproceso(idComiteProceso);
					comiteprocesoMapper.insert(comiteMiembro);
					cmSaved = true;
				}

				// members
				Miembrocomiteporproceso miembrocomiteporprocesoNew = (Miembrocomiteporproceso) member.clone();
				miembrocomiteporprocesoNew.setIdcomiteproceso(idComiteProceso);
				miembrocomiteporprocesoNew.setFechacreacionauditoria(new Date());
				miembrocomiteporprocesoNew.setUsuariocreacionauditoria(request.getUsuarioAuditoria());
				miembrocomiteporprocesoNew.setEquipoauditoria(request.getEquipoAuditoria());
				miembrocomiteporprocesoNew.setProgramaauditoria(request.getProgramaAuditoria());
				miembrocomiteporprocesoNew.setEstadoauditoria(Constantes.estadoAuditoria.ACTIVO);
				miembrocomiteporprocesoNew.setIdmiembrocomiteproceso(
						(int) utilsBusiness.getNextSeq(Sequence.SEQ_MIEMBROCOMITEPORPROCESO).longValue());
				miembrocomiteporprocesoMapper.insert(miembrocomiteporprocesoNew);
			}
		}

		// insert process
		Procesoseleccion processNew = new Procesoseleccion();
		processNew.setIdpacconsolidado(procesoDto.getIdPacConsolidado());
		processNew.setCodigotipoproceso(procesoDto.getCodigoTipoProceso());
		processNew.setNroproceso(procesoDto.getNroProceso());
		processNew.setNroconsolid(procesoDto.getNroConsolid());
		processNew.setDescripcionprocesoseleccion(procesoDto.getGlosa());
		processNew.setIdgrupodocumento(pac.getIdgrupodocumento());
		processNew.setDniespecialidadproceso(procesoDto.getDniEspecialistaProceso());
		processNew.setNombreexpecialistaproceso(procesoDto.getNombreEspecialistaProceso());
		processNew.setFecharecepcionexpediente(new Date());
		processNew.setEstadoproceso(estado.getIdestadosportipodocumento());
		processNew.setIdcatalogotipomodalidad(
				procesoDto.getTipoModalidad() != null && procesoDto.getTipoModalidad() == "1"
						? Constantes.tipoModalidad.ITEM : Constantes.tipoModalidad.PAQUETE);
		processNew.setAnio(procesoDto.getAnio());
		processNew.setIdcomiteproceso(idComiteProceso);
		processNew.setComitenotificado("0"); // bay default 0 = false
		// log
		processNew.setFechacreacionauditoria(new Date());
		processNew.setUsuariocreacionauditoria(request.getUsuarioAuditoria());
		processNew.setEquipoauditoria(request.getEquipoAuditoria());
		processNew.setProgramaauditoria(request.getProgramaAuditoria());
		processNew.setEstadoauditoria(Constantes.estadoAuditoria.ACTIVO);
		idProcesoSeleccion = (int) utilsBusiness.getNextSeq(Sequence.SEQ_PROCESOSELECCION).longValue();
		processNew.setIdprocesoseleccion(idProcesoSeleccion);
		procesoseleccionMapper.insert(processNew);

		// create convocatoria by default
		Convocatoriaprocesoseleccion convocatoriaNew = new Convocatoriaprocesoseleccion();
		convocatoriaNew.setIdprocesoseleccion(idProcesoSeleccion);
		convocatoriaNew.setNroconvocatoria(1); // default 1
		convocatoriaNew.setSecuencia(1); // default 1
		BigDecimal valorReferencial = new BigDecimal(procesoDto.getValorEstimadoContratacion());
		convocatoriaNew.setValorreferencia(valorReferencial);
		convocatoriaNew.setEstadoconvocatoriaitem(Constantes.estadoConvocatoriaItem.REGISTRADO);
		convocatoriaNew.setPrincipal("1"); // default "1" = true
		convocatoriaNew.setFechacreacionauditoria(new Date());
		convocatoriaNew.setUsuariocreacionauditoria(request.getUsuarioAuditoria());
		convocatoriaNew.setEquipoauditoria(request.getEquipoAuditoria());
		convocatoriaNew.setProgramaauditoria(request.getProgramaAuditoria());
		convocatoriaNew.setEstadoauditoria(Constantes.estadoAuditoria.ACTIVO);
		convocatoriaNew.setIdconvocatoriaproceso(
				(int) utilsBusiness.getNextSeq(Sequence.SEQ_CONVOCATORIAPROCESOSELECCION).longValue());
		convocatoriaprocesoseleccionMapper.insert(convocatoriaNew);

		if (estado != null) {
			java.util.Date date = new java.util.Date();
			Estadosporetapapordocumento record = new Estadosporetapapordocumento();
			record.setNrodocumento(idProcesoSeleccion); // Process number
			record.setIdestadosportipodocumento(estado.getIdestadosportipodocumento());
			record.setIdtipodocumento(Constantes.tipoDocumento.PROCESO);
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

		// Miembros de comite de selección hace una copia de PAO

		return result;
	}

	@Override
	@Transactional
	public TransactionResponse<Miembrocomiteporproceso> grabarMiembrosComite(TransactionRequest<ProcesoDto> request,
			Miembrocomiteporproceso miembrocomiteporproceso) throws Exception {
		// TODO Auto-generated method stub
		TransactionResponse<Miembrocomiteporproceso> result = new TransactionResponse<Miembrocomiteporproceso>();
		result.setEstado(true);
		result.setMensaje(Constantes.mensajeGenerico.REGISTRO_CORRECTO);

		ProcesoDto proc = request.getEntityTransaction();
		if (miembrocomiteporproceso.getIdmiembrocomiteproceso() == null
				|| miembrocomiteporproceso.getIdmiembrocomiteproceso() == 0) {
			// INSERT
			Integer idComiteProceso;
			Procesoseleccion procUpdate = procesoseleccionMapper.selectByPrimaryKeyBasic(proc.getIdProcesoSeleccion());
			if (procUpdate != null) {
				if (procUpdate.getIdcomiteproceso() == null) {
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
					idComiteProceso = procUpdate.getIdcomiteproceso();
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
				procUpdate.setIdcomiteproceso(idComiteProceso);
				procesoseleccionMapper.updateByPrimaryKey(procUpdate);
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
	@Transactional
	public Resultado NotificarMiembros(TransactionRequest<List<Miembrocomiteporproceso>> request) throws Exception {
		// TODO Auto-generated method stub
		Resultado result = new Resultado(true, Constantes.mensajeGenerico.REGISTRO_CORRECTO);
		List<Miembrocomiteporproceso> members = request.getEntityTransaction();
		for (Miembrocomiteporproceso member : members) {
			Miembrocomiteporproceso miembrocomiteporproceso = miembrocomiteporprocesoMapper
					.selectByPrimaryKeyBasic(member.getIdmiembrocomiteproceso());
			miembrocomiteporproceso.setEsnotificado("1");
			miembrocomiteporproceso.setUsuariomodificacionauditoria(request.getUsuarioAuditoria());
			miembrocomiteporproceso.setFechamodificacionauditoria(new Date());
			miembrocomiteporproceso.setEquipoauditoria(request.getEquipoAuditoria());
			miembrocomiteporproceso.setProgramaauditoria(request.getProgramaAuditoria());
			miembrocomiteporprocesoMapper.updateByPrimaryKey(miembrocomiteporproceso);
		}
		return result;
	}

	@Override
	public List<ProcesoDto> searchProcesoSeguimiento(ProcesoRequest request) throws Exception {
		// TODO Auto-generated method stub
		return procesoseleccionMapper.searchProcesoSeguimiento(request);
	}

	@Override
	@Transactional
	public Resultado saveProceso(TransactionRequest<Procesoseleccion> request) throws Exception {
		// TODO Auto-generated method stub
		Resultado result = new Resultado(true, Constantes.mensajeGenerico.REGISTRO_CORRECTO);
		Procesoseleccion procesoRequest = request.getEntityTransaction();
		Procesoseleccion procesoEdit = procesoseleccionMapper
				.selectByPrimaryKeyBasic(procesoRequest.getIdprocesoseleccion());
		boolean derivadaEjecucion = false;

		// editing process...
		
		//Elevado a OSCE
		procesoEdit.setFechaelevacionobservacion(procesoRequest.getFechaelevacionobservacion());
		procesoEdit.setFechapronunciamiento(procesoRequest.getFechapronunciamiento());
		
		//Apelacion
		procesoEdit.setFechaapelacion(procesoRequest.getFechaapelacion());
		procesoEdit.setFecharesolucionapelacion(procesoRequest.getFecharesolucionapelacion());
		
		//Fecha consentimiento de buena PRO
		procesoEdit.setFechapublicacionconsentimiento(procesoRequest.getFechapublicacionconsentimiento());
		
		procesoEdit.setFechaactaproyectobase(procesoRequest.getFechaactaproyectobase());
		procesoEdit.setNroactaproyectobase(procesoRequest.getNroactaproyectobase());
		procesoEdit.setFechaobservacionbase(procesoRequest.getFechaobservacionbase());
		procesoEdit.setObservaciones(procesoRequest.getObservaciones());
		procesoEdit.setFechasubsanacionbase(procesoRequest.getFechasubsanacionbase());
		procesoEdit.setIdcatalogosistemacontratacion(procesoRequest.getIdcatalogosistemacontratacion());
		procesoEdit.setModalidadejecucion(procesoRequest.getModalidadejecucion());
		
		procesoEdit.setUsuariomodificacionauditoria(request.getUsuarioAuditoria());
		procesoEdit.setFechamodificacionauditoria(new Date());
		procesoEdit.setEquipoauditoria(request.getEquipoAuditoria());
		procesoEdit.setProgramaauditoria(request.getProgramaAuditoria());
		procesoseleccionMapper.updateByPrimaryKey(procesoEdit);

		// ******************************SAVE************************************************************
		// CONVOCATORIA**********************************************************************************
		Convocatoriaprocesoseleccion convocatoriaEdit;
		Integer idConvocatoria;
		for (Convocatoriaprocesoseleccion convocatoria : procesoRequest.getListaConvocatoriaprocesoseleccion()) {
			if (convocatoria.getIdconvocatoriaproceso() == null) {
				// add
				convocatoria.setUsuariocreacionauditoria(request.getUsuarioAuditoria());
				convocatoria.setFechacreacionauditoria(new Date());
				convocatoria.setProgramaauditoria(request.getProgramaAuditoria());
				convocatoria.setEquipoauditoria(request.getEquipoAuditoria());
				convocatoria.setEstadoauditoria(Constantes.estadoAuditoria.ACTIVO);
				idConvocatoria = 
						(int) utilsBusiness.getNextSeq(Sequence.SEQ_CONVOCATORIAPROCESOSELECCION).longValue();
				convocatoria.setIdconvocatoriaproceso(idConvocatoria);
				convocatoriaprocesoseleccionMapper.insert(convocatoria);
			} else {
				// update
				convocatoriaEdit = convocatoriaprocesoseleccionMapper
						.selectByPrimaryKeyBasic(convocatoria.getIdconvocatoriaproceso());
				convocatoriaEdit.setValorreferencia(convocatoria.getValorreferencia());
				convocatoriaEdit.setIdcatalogoestadoconvocatoria(convocatoria.getIdcatalogoestadoconvocatoria());
				convocatoriaEdit.setFechainicio(convocatoria.getFechainicio());
				convocatoriaEdit.setFechafin(convocatoria.getFechafin());
				convocatoriaEdit.setUsuariomodificacionauditoria(request.getUsuarioAuditoria());
				convocatoriaEdit.setFechamodificacionauditoria(new Date());
				convocatoriaEdit.setProgramaauditoria(request.getProgramaAuditoria());
				convocatoriaEdit.setEquipoauditoria(request.getEquipoAuditoria());
				convocatoriaprocesoseleccionMapper.updateByPrimaryKey(convocatoriaEdit);
				idConvocatoria = convocatoriaEdit.getIdconvocatoriaproceso();
			}

			// save calendar
			if (convocatoria.getListaCalendarioprocesoseleccion() != null) {
				for (Calendarioprocesoseleccion calendar : convocatoria.getListaCalendarioprocesoseleccion()) {
					if (calendar.getIdcalendarioproceso() == null) {
						// add
						calendar.setIdconvocatoriaproceso(idConvocatoria);
						calendar.setUsuariocreacionauditoria(request.getUsuarioAuditoria());
						calendar.setFechacreacionauditoria(new Date());
						calendar.setProgramaauditoria(request.getProgramaAuditoria());
						calendar.setEquipoauditoria(request.getEquipoAuditoria());
						calendar.setEstadoauditoria(Constantes.estadoAuditoria.ACTIVO);
						calendar.setIdcalendarioproceso(
								(int) utilsBusiness.getNextSeq(Sequence.SEQ_CALENDARIOPROCESOSELECCION).longValue());
						calendarioprocesoseleccionMapper.insert(calendar);
					} else {
						// update
						Calendarioprocesoseleccion calendarEdit = calendarioprocesoseleccionMapper
								.selectByPrimaryKeyBasic(calendar.getIdcalendarioproceso());
						calendarEdit.setFechainicio(calendar.getFechainicio());
						calendarEdit.setFechafin(calendar.getFechafin());
						calendarEdit.setIdcatalogoestadopublicacion(calendar.getIdcatalogoestadopublicacion());
						calendarEdit.setUsuariomodificacionauditoria(request.getUsuarioAuditoria());
						calendarEdit.setFechamodificacionauditoria(new Date());
						calendarEdit.setProgramaauditoria(request.getProgramaAuditoria());
						calendarEdit.setEquipoauditoria(request.getEquipoAuditoria());
						calendarioprocesoseleccionMapper.updateByPrimaryKey(calendarEdit);
					}
				}
			}

			// save results
			if (convocatoria.getListaResultadoprocesoseleccion() != null) {
				for (Resultadoprocesoseleccion resultado : convocatoria.getListaResultadoprocesoseleccion()) {
					if (resultado.getIdresultadoproceso() == null) {
						// add
						resultado.setIdconvocatoriaproceso(idConvocatoria);
						resultado.setUsuariocreacionauditoria(request.getUsuarioAuditoria());
						resultado.setFechacreacionauditoria(new Date());
						resultado.setProgramaauditoria(request.getProgramaAuditoria());
						resultado.setEquipoauditoria(request.getEquipoAuditoria());
						resultado.setEstadoauditoria(Constantes.estadoAuditoria.ACTIVO);
						resultado.setIdresultadoproceso(
								(int) utilsBusiness.getNextSeq(Sequence.SEQ_RESULTADOPROCESOSELECCION).longValue());
						resultadoprocesoseleccionMapper.insert(resultado);
					} else {
						// update
						Resultadoprocesoseleccion resultadoEdit = resultadoprocesoseleccionMapper
								.selectByPrimaryKeyBasic(resultado.getIdresultadoproceso());
						resultadoEdit.setNroruc(resultado.getNroruc());
						resultadoEdit.setNombreproveedor(resultado.getNombreproveedor());
						resultadoEdit.setIdcatalogoestadoresultado(resultado.getIdcatalogoestadoresultado());
						resultadoEdit.setMontoadjudicado(resultado.getMontoadjudicado());
						resultadoEdit.setUsuariomodificacionauditoria(request.getUsuarioAuditoria());
						resultadoEdit.setFechamodificacionauditoria(new Date());
						resultadoEdit.setEquipoauditoria(request.getEquipoAuditoria());
						resultadoEdit.setProgramaauditoria(request.getProgramaAuditoria());
						resultadoprocesoseleccionMapper.updateByPrimaryKey(resultadoEdit);
					}
				}
			}
		}

		// insert status
		if (derivadaEjecucion) {
			Estadosportipodocumento param = new Estadosportipodocumento();
			param.setIdtipodocumento(Constantes.tipoDocumento.PROCESO);
			param.setIdestadosporetapa(Constantes.estadosPorEtapa.REMITIDO_A_EJECUCION);
			Estadosportipodocumento estado = estadosportipodocumentoMapper.selectByEtapaTipoDocumento(param);
			if (estado != null) {
				java.util.Date date = new java.util.Date();
				Estadosporetapapordocumento record = new Estadosporetapapordocumento();
				record.setNrodocumento(procesoRequest.getIdprocesoseleccion()); // Process
																				// number
				record.setIdestadosportipodocumento(estado.getIdestadosportipodocumento());
				record.setIdtipodocumento(Constantes.tipoDocumento.PROCESO);
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

	@Override
	public List<ConvocatoriaDto> searchConvocatoriaProceso(Integer idProcesoSeleccion) throws Exception {
		// TODO Auto-generated method stub
		Procesoseleccion proc = procesoseleccionMapper.selectByPrimaryKeyBasic(idProcesoSeleccion);
		ProcesoRequest request = new ProcesoRequest();
		if (proc != null) {
			request.setNroConsolid(proc.getNroconsolid());
			request.setAnio(proc.getAnio());
			request.setIdUnidadEjecutoraSiaf(Constantes.unidadEjecutora.PRONIED_SIAF);
		}

		List<ConvocatoriaDto> listConvoca = convocatoriaprocesoseleccionMapper
				.selectConvocatoriaByIdProceso(idProcesoSeleccion);
		for (int i = 0; i < listConvoca.size(); i++) {
			// calendarios
			List<CalendarioDto> calendars = calendarioprocesoseleccionMapper
					.selectCalendarioByIdConvocatoria(listConvoca.get(i).getIdconvocatoriaproceso());
			listConvoca.get(i).setListaCalendario(calendars);

			// items
			List<ProcesoResultadoItemDto> items = resultadoprocesoseleccionMapper
					.selectResultadoByIdConvocatoria(listConvoca.get(i).getIdconvocatoriaproceso());
			if (items == null || items.size() == 0) {
				items = resultadoprocesoseleccionMapper.selectResultadoSiga(request);
			}
			listConvoca.get(i).setListaResultado(items);
		}

		return listConvoca;
	}

}
