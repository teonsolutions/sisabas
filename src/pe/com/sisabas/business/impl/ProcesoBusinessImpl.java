package pe.com.sisabas.business.impl;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.com.sisabas.be.Comiteproceso;
import pe.com.sisabas.be.Convocatoriaprocesoseleccion;
import pe.com.sisabas.be.Estadosporetapapordocumento;
import pe.com.sisabas.be.Estadosportipodocumento;
import pe.com.sisabas.be.Miembrocomiteporproceso;
import pe.com.sisabas.be.Pacconsolidado;
import pe.com.sisabas.be.Procesoseleccion;
import pe.com.sisabas.business.ProcesoBusiness;
import pe.com.sisabas.dto.ComiteDto;
import pe.com.sisabas.dto.PacConsolidadoDto;
import pe.com.sisabas.dto.ProcesoDto;
import pe.com.sisabas.dto.ProcesoRequest;
import pe.com.sisabas.dto.Resultado;
import pe.com.sisabas.dto.TransactionRequest;
import pe.com.sisabas.dto.TransactionResponse;
import pe.com.sisabas.persistence.ComiteprocesoMapper;
import pe.com.sisabas.persistence.ConvocatoriaprocesoseleccionMapper;
import pe.com.sisabas.persistence.EstadosporetapapordocumentoMapper;
import pe.com.sisabas.persistence.EstadosportipodocumentoMapper;
import pe.com.sisabas.persistence.MiembrocomiteporprocesoMapper;
import pe.com.sisabas.persistence.PacconsolidadoMapper;
import pe.com.sisabas.persistence.ProcesoseleccionMapper;
import pe.com.sisabas.resources.Constantes;
import pe.com.sisabas.resources.Sequence;
import pe.com.sisabas.resources.business.UtilsBusiness;

@Service
public class ProcesoBusinessImpl implements ProcesoBusiness, Serializable{

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
		
		//status
		Estadosportipodocumento param = new Estadosportipodocumento();
		param.setIdtipodocumento(Constantes.tipoDocumento.PROCESO);
		param.setIdestadosporetapa(Constantes.estadosPorEtapa.EN_COMITE_ESPECIAL);
		Estadosportipodocumento estado = estadosportipodocumentoMapper.selectByEtapaTipoDocumento(param);
		
		//Process
		Integer idProcesoSeleccion = 0;
		
		//Get miembros de comité de selección
		List<String> ordenListaCampos = new ArrayList<String>();
		ordenListaCampos.add("A1.IDMIEMBROCOMITEPROCESO");
		Miembrocomiteporproceso miembrocomiteporproceso = new Miembrocomiteporproceso();
		miembrocomiteporproceso.setOrdenListaCampos(ordenListaCampos);
		miembrocomiteporproceso.setOrdenTipo("DESC");

		// Add conditions IN clause
		miembrocomiteporproceso.addConditionInIdcatalogotipomiembro(null);
		miembrocomiteporproceso.addConditionInIdcatalogoestadomiembrocomite(null);
		miembrocomiteporproceso.setIdmiembrocomiteproceso(pac.getIdcomiteproceso());
		List<Miembrocomiteporproceso> listaMiembrocomiteporproceso = miembrocomiteporprocesoMapper.selectDynamicFull(miembrocomiteporproceso);
		
		Integer idComiteProceso = 0;
		if (listaMiembrocomiteporproceso != null && listaMiembrocomiteporproceso.size() > 0){
			boolean cmSaved = false;
			for (Miembrocomiteporproceso member : listaMiembrocomiteporproceso) {
				if (!cmSaved){
					//create new miembro comite
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
				
				//members
				Miembrocomiteporproceso miembrocomiteporprocesoNew = (Miembrocomiteporproceso)member.clone();
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
		
		//insert process
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
		processNew.setIdcatalogotipomodalidad(procesoDto.getTipoModalidad() != null && procesoDto.getTipoModalidad() == "1"? Constantes.tipoModalidad.ITEM: Constantes.tipoModalidad.PAQUETE);
		processNew.setAnio(procesoDto.getAnio());
		processNew.setIdcomiteproceso(idComiteProceso);
		processNew.setComitenotificado("0"); //bay default 0 = false
		//log
		processNew.setFechacreacionauditoria(new Date());
		processNew.setUsuariocreacionauditoria(request.getUsuarioAuditoria());
		processNew.setEquipoauditoria(request.getEquipoAuditoria());
		processNew.setProgramaauditoria(request.getProgramaAuditoria());
		processNew.setEstadoauditoria(Constantes.estadoAuditoria.ACTIVO);		
		idProcesoSeleccion = (int) utilsBusiness.getNextSeq(Sequence.SEQ_PROCESOSELECCION).longValue();		
		processNew.setIdprocesoseleccion(idProcesoSeleccion);				
		procesoseleccionMapper.insert(processNew);
				
		//create convocatoria by default
		Convocatoriaprocesoseleccion convocatoriaNew = new Convocatoriaprocesoseleccion();
		convocatoriaNew.setIdprocesoseleccion(idProcesoSeleccion);
		convocatoriaNew.setNroconvocatoria(1); //default 1
		convocatoriaNew.setSecuencia(1); //default 1
		BigDecimal valorReferencial = new BigDecimal(procesoDto.getValorEstimadoContratacion());
		convocatoriaNew.setValorreferencia(valorReferencial);
		convocatoriaNew.setEstadoconvocatoriaitem(Constantes.estadoConvocatoriaItem.REGISTRADO);
		convocatoriaNew.setPrincipal("1"); //default "1" = true
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
			record.setNrodocumento(idProcesoSeleccion); //Process number
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
		
		//Miembros de comite de selección hace una copia de PAO
		
		
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
			Miembrocomiteporproceso miembrocomiteporproceso = miembrocomiteporprocesoMapper.selectByPrimaryKeyBasic(member.getIdmiembrocomiteproceso());
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

		
	
}
