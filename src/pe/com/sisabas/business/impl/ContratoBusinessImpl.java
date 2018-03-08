package pe.com.sisabas.business.impl;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.com.sisabas.be.Adenda;
import pe.com.sisabas.be.Contrato;
import pe.com.sisabas.be.ContratoRequest;
import pe.com.sisabas.be.ContratoResponse;
import pe.com.sisabas.be.Entregable;
import pe.com.sisabas.be.Estadosporetapapordocumento;
import pe.com.sisabas.be.Estadosportipodocumento;
import pe.com.sisabas.be.Evaluaciondocumento;
import pe.com.sisabas.be.Grupodocumento;
import pe.com.sisabas.be.Orden;
import pe.com.sisabas.business.ContratoBusiness;
import pe.com.sisabas.dto.AdendaDto;
import pe.com.sisabas.dto.ContratoDto;
import pe.com.sisabas.dto.ContratoExport;
import pe.com.sisabas.dto.EntregableDto;
import pe.com.sisabas.dto.OrdenDto;
import pe.com.sisabas.dto.OrdenListaDto;
import pe.com.sisabas.dto.SegRequest;
import pe.com.sisabas.dto.SegResponse;
import pe.com.sisabas.persistence.AdendaMapper;
import pe.com.sisabas.persistence.ContratoMapper;
import pe.com.sisabas.persistence.EntregableMapper;
import pe.com.sisabas.persistence.EstadosporetapapordocumentoMapper;
import pe.com.sisabas.persistence.EstadosportipodocumentoMapper;
import pe.com.sisabas.persistence.EvaluaciondocumentoMapper;
import pe.com.sisabas.persistence.GrupodocumentoMapper;
import pe.com.sisabas.persistence.OrdenMapper;
import pe.com.sisabas.resources.business.UtilsBusiness;
import pe.com.sisabas.resources.Sequence;
import pe.com.sisabas.resources.Utils;
import pe.com.sisabas.resources.Constantes;
import pe.com.sisabas.resources.Messages;
import pe.com.sisabas.exception.ValidateException;


@Service
public class ContratoBusinessImpl implements ContratoBusiness, Serializable{

	@Autowired
	public AdendaMapper adendaMapper;
	
	@Autowired
	public ContratoMapper contratoMapper;
	
	@Autowired
	public OrdenMapper ordenMapper;
	
	@Autowired 
	public EntregableMapper entregableMapper;
	
	@Autowired
	public EvaluaciondocumentoMapper evaluaciondocumentoMapper;
	
	@Autowired
	public EstadosportipodocumentoMapper estadosportipodocumentoMapper;
	
	@Autowired
	public EstadosporetapapordocumentoMapper estadosporetapapordocumentoMapper;
	
	@Autowired
	public GrupodocumentoMapper grupodocumentoMapper;	
	
	@Autowired
	public UtilsBusiness utilsBusiness;

	private static final long serialVersionUID = 1L;

	@Override
	public List<ContratoResponse> selectDynamicFull(ContratoRequest request) throws Exception {
		
		List<ContratoResponse> lista = contratoMapper.selectDynamicFull(request); 
		int numero = 1;
        
		for (ContratoResponse row : lista) {
			
			row.formatoFecha();
			row.setNumero(numero++);
		}
		
		return lista;
	}
	
	@Override
	public List<ContratoExport> selectDynamicExport(ContratoRequest request) throws Exception {
		List<ContratoExport> lista = contratoMapper.selectDynamicExport(request); 
		int numero = 1;
        
		for (ContratoExport row : lista) {
			
			row.formatoFecha();
			row.setNumero(numero++);
			row.setEjercicio(request.getEjercicio());
		}
		
		return lista;
	}


	@Transactional
	@Override
	public void insertBasic(Contrato record) throws Exception {
		record.setIdcontrato((int)utilsBusiness.getNextSeq(Sequence.SEQ_CONTRATO).longValue());
		record.setFechacreacionauditoria(Utils.currentTimeStamp());
		record.setEstadoauditoria("1");

		updateBooleanToChar(record);
		validateInsert(record);
		Utils.convertPropertiesStringToUppercase(record);
		contratoMapper.insertBasic(record);
		
		//insertando EvaluacionDocumento y EstadosPorEtapaPorDocumento
		Evaluaciondocumento evaDocumento = new Evaluaciondocumento();
		evaDocumento.setIdevaluaciondocumento(((int)utilsBusiness.getNextSeq(Sequence.SEQ_EVALUACIONDOCUMENTO).longValue()));
		evaDocumento.setIdcontrato(record.getIdcontrato());
		evaDocumento.setIdcatalogoestadodocumentacion(record.getIdcatalogoestadodocumentacion());
		evaDocumento.setFechacreacionauditoriafin(new Date());
		evaDocumento.setUsuariocreacionauditoria(record.getUsuariocreacionauditoria());
		evaDocumento.setEquipoauditoria(record.getEquipoauditoria());
		
		
		evaluaciondocumentoMapper.insert(evaDocumento);
		
		

			java.util.Date date = new java.util.Date();
			Estadosporetapapordocumento estadoNuevo = new Estadosporetapapordocumento();
			estadoNuevo.setNrodocumento(record.getIdcontrato()); //Process number
			estadoNuevo.setIdestadosportipodocumento(Constantes.estadosPorTipoDocumento.EN_SUSCRIPCION_DE_CONTRATO);
			estadoNuevo.setIdtipodocumento(Constantes.tipoDocumento.CONTRATO);
			estadoNuevo.setFechaingreso(date);
			estadoNuevo.setFechacreacionauditoria(date);
			estadoNuevo.setUsuariocreacionauditoria(record.getUsuariocreacionauditoria());
			estadoNuevo.setEquipoauditoria(record.getEquipoauditoria());
			estadoNuevo.setProgramaauditoria(record.getProgramaauditoria());

			// record.setIdestadosporetapapordocumento((int)utilsBusiness.getNextSeqTemporal(pe.com.sisabas.resources.Sequence.SEQ_ESTADOSPORETAPAPORDOCUMENTO).longValue());

			estadoNuevo.setIdestadosporetapapordocumento(
					(int) utilsBusiness.getNextSeq(Sequence.SEQ_ESTADOSPORETAPAPORDOCUMENTO).longValue());

			estadoNuevo.setEstadoauditoria(Constantes.estadoAuditoria.ACTIVO);
			estadosporetapapordocumentoMapper.insert(estadoNuevo);
	
	}
	
	public void updateBooleanToChar(Contrato record) throws Exception {
	}

	public void validateInsert(Contrato record)throws Exception{
		if(record.getIdcontrato()==null)
			throw new ValidateException(Messages.getString("contrato.idcontrato.required"));

		if(record.getIdcatalogosistemaadquisicion()!=null &&  record.getIdcatalogosistemaadquisicion().length() > 10)
			throw new ValidateException(Messages.getString("contrato.idcatalogosistemaadquisicion.length.error",record.getIdcatalogosistemaadquisicion().length()));
		if(record.getIdcatalogotipocontrato()!=null &&  record.getIdcatalogotipocontrato().length() > 10)
			throw new ValidateException(Messages.getString("contrato.idcatalogotipocontrato.length.error",record.getIdcatalogotipocontrato().length()));
		if(record.getNroccp()!=null &&  record.getNroccp().length() > 20)
			throw new ValidateException(Messages.getString("contrato.nroccp.length.error",record.getNroccp().length()));
		if(record.getIdcatalogotipobien()!=null &&  record.getIdcatalogotipobien().length() > 10)
			throw new ValidateException(Messages.getString("contrato.idcatalogotipobien.length.error",record.getIdcatalogotipobien().length()));
		if(record.getMoneda()!=null &&  record.getMoneda().length() > 10)
			throw new ValidateException(Messages.getString("contrato.moneda.length.error",record.getMoneda().length()));
		if(record.getTieneprevision()!=null &&  record.getTieneprevision().length() > 1)
			throw new ValidateException(Messages.getString("contrato.tieneprevision.length.error",record.getTieneprevision().length()));
		if(record.getDniabogado()!=null &&  record.getDniabogado().length() > 8)
			throw new ValidateException(Messages.getString("contrato.dniabogado.length.error",record.getDniabogado().length()));
		if(record.getDniespecialistaejecucion()!=null &&  record.getDniespecialistaejecucion().length() > 8)
			throw new ValidateException(Messages.getString("contrato.dniespecialistaejecucion.length.error",record.getDniespecialistaejecucion().length()));
		if(record.getSinadcontrato()!=null &&  record.getSinadcontrato().length() > 10)
			throw new ValidateException(Messages.getString("contrato.sinadcontrato.length.error",record.getSinadcontrato().length()));
		if(record.getNombreabogado()!=null &&  record.getNombreabogado().length() > 250)
			throw new ValidateException(Messages.getString("contrato.nombreabogado.length.error",record.getNombreabogado().length()));
		if(record.getNombreespecialista()!=null &&  record.getNombreespecialista().length() > 250)
			throw new ValidateException(Messages.getString("contrato.nombreespecialista.length.error",record.getNombreespecialista().length()));
		if(record.getNumeroexpediente()!=null &&  record.getNumeroexpediente().length() > 30)
			throw new ValidateException(Messages.getString("contrato.numeroexpediente.length.error",record.getNumeroexpediente().length()));
		if(record.getRutacontrato()!=null &&  record.getRutacontrato().length() > 300)
			throw new ValidateException(Messages.getString("contrato.rutacontrato.length.error",record.getRutacontrato().length()));
		if(record.getIdcatalogoestadodocumentacion()!=null &&  record.getIdcatalogoestadodocumentacion().length() > 10)
			throw new ValidateException(Messages.getString("contrato.idcatalogoestadodocumentacion.length.error",record.getIdcatalogoestadodocumentacion().length()));
		if(record.getUsuariocreacionauditoria()!=null &&  record.getUsuariocreacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("contrato.usuariocreacionauditoria.length.error",record.getUsuariocreacionauditoria().length()));
		if(record.getUsuariomodificacionauditoria()!=null &&  record.getUsuariomodificacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("contrato.usuariomodificacionauditoria.length.error",record.getUsuariomodificacionauditoria().length()));
		if(record.getEquipoauditoria()!=null &&  record.getEquipoauditoria().length() > 45)
			throw new ValidateException(Messages.getString("contrato.equipoauditoria.length.error",record.getEquipoauditoria().length()));
		if(record.getProgramaauditoria()!=null &&  record.getProgramaauditoria().length() > 200)
			throw new ValidateException(Messages.getString("contrato.programaauditoria.length.error",record.getProgramaauditoria().length()));
		if(record.getEstadoauditoria()!=null &&  record.getEstadoauditoria().length() > 1)
			throw new ValidateException(Messages.getString("contrato.estadoauditoria.length.error",record.getEstadoauditoria().length()));

		//Here Bussines Validations.
		
	}

	@Override
	public List<SegResponse> ObtenerSeguimiento(SegRequest segRequest) throws Exception {

		List<SegResponse> lista = contratoMapper.obtenerSeguimiento(segRequest);
		
		return lista;
	}

	

	public void validateUpdate(Contrato record)throws Exception{
		if(record.getIdcontrato()==null)
			throw new ValidateException(Messages.getString("contrato.idcontrato.required"));

		if(record.getIdcatalogosistemaadquisicion()!=null &&  record.getIdcatalogosistemaadquisicion().length() > 10)
			throw new ValidateException(Messages.getString("contrato.idcatalogosistemaadquisicion.length.error",record.getIdcatalogosistemaadquisicion().length()));
		if(record.getIdcatalogotipocontrato()!=null &&  record.getIdcatalogotipocontrato().length() > 10)
			throw new ValidateException(Messages.getString("contrato.idcatalogotipocontrato.length.error",record.getIdcatalogotipocontrato().length()));
		if(record.getNroccp()!=null &&  record.getNroccp().length() > 20)
			throw new ValidateException(Messages.getString("contrato.nroccp.length.error",record.getNroccp().length()));
		if(record.getIdcatalogotipobien()!=null &&  record.getIdcatalogotipobien().length() > 10)
			throw new ValidateException(Messages.getString("contrato.idcatalogotipobien.length.error",record.getIdcatalogotipobien().length()));
		if(record.getMoneda()!=null &&  record.getMoneda().length() > 10)
			throw new ValidateException(Messages.getString("contrato.moneda.length.error",record.getMoneda().length()));
		if(record.getTieneprevision()!=null &&  record.getTieneprevision().length() > 1)
			throw new ValidateException(Messages.getString("contrato.tieneprevision.length.error",record.getTieneprevision().length()));
		if(record.getDniabogado()!=null &&  record.getDniabogado().length() > 8)
			throw new ValidateException(Messages.getString("contrato.dniabogado.length.error",record.getDniabogado().length()));
		if(record.getDniespecialistaejecucion()!=null &&  record.getDniespecialistaejecucion().length() > 8)
			throw new ValidateException(Messages.getString("contrato.dniespecialistaejecucion.length.error",record.getDniespecialistaejecucion().length()));
		if(record.getSinadcontrato()!=null &&  record.getSinadcontrato().length() > 10)
			throw new ValidateException(Messages.getString("contrato.sinadcontrato.length.error",record.getSinadcontrato().length()));
		if(record.getNombreabogado()!=null &&  record.getNombreabogado().length() > 250)
			throw new ValidateException(Messages.getString("contrato.nombreabogado.length.error",record.getNombreabogado().length()));
		if(record.getNombreespecialista()!=null &&  record.getNombreespecialista().length() > 250)
			throw new ValidateException(Messages.getString("contrato.nombreespecialista.length.error",record.getNombreespecialista().length()));
		if(record.getNumeroexpediente()!=null &&  record.getNumeroexpediente().length() > 30)
			throw new ValidateException(Messages.getString("contrato.numeroexpediente.length.error",record.getNumeroexpediente().length()));
		if(record.getRutacontrato()!=null &&  record.getRutacontrato().length() > 300)
			throw new ValidateException(Messages.getString("contrato.rutacontrato.length.error",record.getRutacontrato().length()));
		if(record.getIdcatalogoestadodocumentacion()!=null &&  record.getIdcatalogoestadodocumentacion().length() > 10)
			throw new ValidateException(Messages.getString("contrato.idcatalogoestadodocumentacion.length.error",record.getIdcatalogoestadodocumentacion().length()));
		if(record.getUsuariocreacionauditoria()!=null &&  record.getUsuariocreacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("contrato.usuariocreacionauditoria.length.error",record.getUsuariocreacionauditoria().length()));
		if(record.getUsuariomodificacionauditoria()!=null &&  record.getUsuariomodificacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("contrato.usuariomodificacionauditoria.length.error",record.getUsuariomodificacionauditoria().length()));
		if(record.getEquipoauditoria()!=null &&  record.getEquipoauditoria().length() > 45)
			throw new ValidateException(Messages.getString("contrato.equipoauditoria.length.error",record.getEquipoauditoria().length()));
		if(record.getProgramaauditoria()!=null &&  record.getProgramaauditoria().length() > 200)
			throw new ValidateException(Messages.getString("contrato.programaauditoria.length.error",record.getProgramaauditoria().length()));
		if(record.getEstadoauditoria()!=null &&  record.getEstadoauditoria().length() > 1)
			throw new ValidateException(Messages.getString("contrato.estadoauditoria.length.error",record.getEstadoauditoria().length()));

		//Here Bussines Validations.
	}

	@Override
	public Contrato selectByPrimaryKeyBasic(java.lang.Integer par_idcontrato) throws Exception {
		return contratoMapper.selectByPrimaryKeyBasic(par_idcontrato);
	}

	@Override
	public List<Integer> listEjercicio() throws Exception {
		return contratoMapper.listaEjercicio();
	}

	
	@Override
	public void updateByPrimaryKeyBasic(Contrato request) throws Exception {
		request.setFechamodificacionauditoria(Utils.currentTimeStamp());
		updateBooleanToChar(request);
		validateUpdate(request);
		Utils.convertPropertiesStringToUppercase(request);
		contratoMapper.updateByPrimaryKey(request);
		
	}
	
	
	
	@Override
	@Transactional
	public void actualizarContrato(ContratoDto request) throws Exception {
		
		Contrato contrato = new Contrato();
		request.setFechamodificacionauditoria(Utils.currentTimeStamp());
		Utils.convertPropertiesStringToUppercase(request);
		
		
		System.out.println("El id contrato(2) es == "+request.getIdContrato());
		
		contrato.setIdcontrato(request.getIdContrato());
		contrato.setIdunidadejecutora(request.getIdUnidadEjecutora());
		contrato.setNroitems(request.getNroItems());
		contrato.setIdgrupodocumento(request.getIdGrupoDocumento());
		
		System.out.println("id grupoducmento ="+request.getIdGrupoDocumento());
		
		contrato.setIdcatalogotipocontrato(request.getIdCatalogoTipoContrato());
		contrato.setNrocontrato(request.getNroContrato());
		
		System.out.println("nro contrato ="+request.getNroContrato());
		
		contrato.setSecuenciacontrato(request.getSecuenciaContrato());
		contrato.setNroccp(request.getNroCcp());
		contrato.setIdcatalogotipobien(request.getIdCatalogoTipoBien());
		contrato.setIdproveedor(request.getIdProveedor());
		contrato.setEstadocontrato(request.getEstadoContrato());
		contrato.setIdproveedor(request.getIdProveedor());
		contrato.setEstadocontrato(request.getEstadoContrato());
		contrato.setFechainicial(request.getFechaInicial());
		contrato.setFechafin(request.getFechaFin());
		contrato.setMoneda(request.getMoneda());
		contrato.setMontocontrato(request.getMontoContrato());
		contrato.setMontocertificacion(request.getMontoCertificacion());
		contrato.setFechacontrato(request.getFechaContrato());
		contrato.setTieneprevision(request.getTienePrevision());
		contrato.setCantidadarmadas(request.getCantidadArmadas());
		contrato.setFecharecepcionexpediente(request.getFechaRecepcionExpediente());
		contrato.setDniespecialistaejecucion(request.getDniEspecialistaEjecucion());
		contrato.setSinadcontrato(request.getSinadContrato());
		contrato.setAniosinadcontrato(request.getAnioSinadcContrato());
		contrato.setNombreespecialista(request.getNombreEspecialista());
		contrato.setNumeroexpediente(request.getNumeroExpediente());
		contrato.setAnio(request.getAnio());
		contrato.setNroconsolid(request.getNroConsolid());
		contrato.setIdcatalogoestadodocumentacion(request.getIdCatalogoEstadoDocumentacion());
		contrato.setFechacreacionauditoria(request.getFechaCreacionAuditoria());
		contrato.setUsuariocreacionauditoria(request.getUsuarioCreacionAuditoria());
		contrato.setFechamodificacionauditoria(request.getFechamodificacionauditoria());
		contrato.setUsuariomodificacionauditoria(request.getUsuarioModificacionAuditoria());
		contrato.setEquipoauditoria(request.getEquipoAuditoria());
		contrato.setProgramaauditoria(request.getProgramaAuditoria());
		contrato.setEstadoauditoria(request.getEstadoAudtoria());
		
		contrato.setIdcatalogosistemaadquisicion(request.getIdCatalogoSistemaAdquisicion());
		contrato.setPlazoejecucion(request.getPlazoEjecucion());
		contrato.setDniabogado(request.getDniAbogado());
		contrato.setNombreabogado(request.getNombreAbogado());
		contrato.setRutacontrato(request.getRutaContrato());
		contrato.setIdcatalogotipobien(request.getIdCatalogoTipoBien());
		
		contratoMapper.updateByPrimaryKey(contrato);
	
		List<OrdenDto> ordenes = request.getListaOrden();
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
				ordenEdit.setEstadoexpedientesiaf(Integer.parseInt(ordenDto.getIdEstadoSiaf()));
				ordenEdit.setEstadoorden(ordenDto.getEstadoOrden());
				ordenEdit.setMoneda(ordenDto.getMoneda());
				ordenEdit.setPlazoejecucion(ordenDto.getPlazo());
				ordenEdit.setFechainicioprestacion(ordenDto.getFechaInicioPrestacion());
				// ordenEdit.setEstadoorden(estadoorden); TODO: CHECK

				// Audit
				ordenEdit.setFechamodificacionauditoria(new Date());
				//ordenEdit.setUsuariomodificacionauditoria(request.getUsuarioAuditoria());
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
				//grupodocumento.setUsuariocreacionauditoria(request.getUsuarioAuditoria());
				grupodocumento.setProgramaauditoria(request.getProgramaAuditoria());
				grupodocumento.setEquipoauditoria(request.getEquipoAuditoria());
				grupodocumento.setEstadoauditoria(Constantes.estadoAuditoria.ACTIVO);
				grupodocumentoMapper.insert(grupodocumento);

				// Insert

				Orden ordenNew = new Orden();
				ordenNew.setIdgrupodocumento(idgrupodocumento);
				ordenNew.setFechainicioprestacion(ordenDto.getFechaInicioPrestacion());
				ordenNew.setFechafinprestacion(ordenDto.getFechaFinPrestacion());
				ordenNew.setAnio(ordenDto.getAnio());
				ordenNew.setEstadoexpedientesiaf(Integer.parseInt(ordenDto.getIdEstadoSiaf()));
				ordenNew.setEstadoorden(ordenDto.getEstadoOrden());
				ordenNew.setMoneda(ordenDto.getMoneda());
				ordenNew.setPlazoejecucion(ordenDto.getPlazo());
				ordenNew.setIdpacconsolidado(ordenDto.getIdPacConsolidado());

				// Orden data
				ordenNew.setNroorden(ordenDto.getNroOrden().toString()); // verificar
																			// nro
																			// type
				ordenNew.setFechaorden(ordenDto.getFechaOrden());
				ordenNew.setAnioorden(ordenDto.getAnio());
				ordenNew.setNroexpedientesiaf(ordenDto.getNroExpedienteSiaf().toString());
				ordenNew.setMoneda(ordenDto.getMoneda());
				
				double monto = ordenDto.getTotalFactSoles();
				BigDecimal bigmontonew = new BigDecimal(monto);
				ordenNew.setMontoorden(Utils.round(bigmontonew));
				
				ordenNew.setIdcatalogotipobien(ordenDto.getIdTipoBien());
				ordenNew.setIdunidadejecutora(ordenDto.getIdUnidadEjecutora());

				// Audit
				ordenNew.setFechacreacionauditoria(new Date());
				//ordenNew.setUsuariocreacionauditoria(request.getUsuarioAuditoria());
				ordenNew.setProgramaauditoria(request.getProgramaAuditoria());
				ordenNew.setEquipoauditoria(request.getEquipoAuditoria());
				ordenNew.setEstadoauditoria(Constantes.estadoAuditoria.ACTIVO);
				ordenNew.setUsuariocreacionauditoria(ordenDto.getUsuarioCreacionAuditoria());
			
				
				//NUEVOS CAMPOS
				ordenNew.setIdcontrato(contrato.getIdcontrato());
				ordenNew.setNrocontrato(contrato.getNrocontrato().toString());
				
				idOrden = (int) utilsBusiness.getNextSeq(pe.com.sisabas.resources.Sequence.SEQ_CUADROCOMPARATIVOVR)
						.longValue();
				ordenNew.setIdorden(idOrden);
				ordenMapper.insert(ordenNew);
				
				
				// estad  x etapa
				
				
				
				
			}

			if(ordenDto.getEntregables()!=null){
				// save details
				for (int j = 0; j < ordenDto.getEntregables().size(); j++) {
					EntregableDto entregable = ordenDto.getEntregables().get(j);
					if (entregable.getIdEntregable() != null) {
						// Update
						Entregable entregableEdit = entregableMapper.selectByPrimaryKeyBasic(entregable.getIdEntregable());
						if (entregableEdit != null) {
							
							entregableEdit.setNroentregable(entregable.getDescripcion());
							entregableEdit.setPlazoentregable(entregable.getPlazo());
							entregableEdit.setMontoentregable(entregable.getImporte());
							entregableEdit.setMontopenalidadentregable(entregable.getMontoPenalidad());
							entregableEdit.setFechapresentacionentregable(entregable.getFecha());
							entregableEdit.setObservacionesentregable(entregable.getObservacion());

							if(entregable.getEstado().equals("PAGADO"))
								entregableEdit.setIdcatalogoestadoentregable("EENT3");
							if(entregable.getEstado().equals("REMITIDO CONTABILIDAD"))
								entregableEdit.setIdcatalogoestadoentregable("EENT2");
							if(entregable.getEstado().equals("ADQUISICIÓN CONFORME"))
								entregableEdit.setIdcatalogoestadoentregable("EENT1");
							
							entregableEdit.setNroproveido(entregable.getNroProveido());
			
							entregableEdit.setIdcatalogoestadoentregable(entregable.getEstado());
						
							// Audit
							//entregableEdit.setUsuariomodificacionauditoria(request.getUsuarioAuditoria());
							entregableEdit.setFechamodificacionauditoria(new Date());
							entregableMapper.updateByPrimaryKey(entregableEdit);
						}
					} else {
						// Insert

						Entregable entregableNew = new Entregable();
						entregableNew.setNroentregable(entregable.getDescripcion());
						entregableNew.setPlazoentregable(entregable.getPlazo());
						entregableNew.setMontoentregable(entregable.getImporte());
						entregableNew.setMontopenalidadentregable(entregable.getMontoPenalidad());
						entregableNew.setFechapresentacionentregable(entregable.getFecha());
						entregableNew.setObservacionesentregable(entregable.getObservacion());
						entregableNew.setIdcatalogoestadoentregable(entregable.getIdcatalogoestadoentregable());					
						
						entregableNew.setIdorden(idOrden);
						entregableNew.setIdgrupodocumento(idgrupodocumento);
						entregableNew.setAnio(ordenDto.getAnio());
	
						entregableNew.setNroproveido(entregable.getNroProveido());
						

						if(entregable.getEstado().equals("PAGADO"))
							entregableNew.setIdcatalogoestadoentregable("EENT3");
						if(entregable.getEstado().equals("REMITIDO CONTABILIDAD"))
							entregableNew.setIdcatalogoestadoentregable("EENT2");
						if(entregable.getEstado().equals("ADQUISICIÓN CONFORME"))
							entregableNew.setIdcatalogoestadoentregable("EENT1");

	
						// Audit
						//entregable.setUsuariocreacionauditoria(request.getUsuarioAuditoria());
						entregableNew.setFechacreacionauditoria(new Date());
						entregableNew.setEquipoauditoria(request.getEquipoAuditoria());
						entregableNew.setProgramaauditoria(request.getProgramaAuditoria());
						entregableNew.setEstadoauditoria(Constantes.estadoAuditoria.ACTIVO);
						entregableNew.setIdentregable((int) utilsBusiness
								.getNextSeq(pe.com.sisabas.resources.Sequence.SEQ_ENTREGABLE).longValue());
						entregableMapper.insert(entregableNew);
					}
				}
			
			 }
			
			
				
			}
			
		   List<OrdenDto> listaEliminar = request.getOrdenesEliminar();
		   
		   if(listaEliminar != null){
			
			  for(int i = 0; i < listaEliminar.size(); i++){
				if(listaEliminar.get(i).getIdContrato()!=null){
					
					if(listaEliminar.get(i).getEntegables()!=null){
						for(int j = 0; j < listaEliminar.get(i).getEntegables().size(); j++){
							Entregable entregable1 = entregableMapper.selectByPrimaryKeyBasic(listaEliminar.get(i).getEntegables().get(j).getIdentregable());
							if(entregable1!=null){
								entregableMapper.deleteByPrimaryKey(entregable1.getIdentregable());
							}
						}
						
					}

					Orden orden1=ordenMapper.selectByPrimaryKeyBasic(listaEliminar.get(i).getIdOrden());
					if(orden1!=null){
						ordenMapper.deleteByPrimaryKey(orden1.getIdorden());
					}
					
				}
				
				
			 }
			
				
	   	  }

		   
		   //adendas
		   List<AdendaDto> adendas = request.getListaAdendas();
		   AdendaDto adendaDto = null;
		   Integer idAdenda;
		   for(int i = 0; i < adendas.size(); i++){
			   adendaDto = adendas.get(i);
			   if(adendaDto.getIdAdenda()!=null){
				   Adenda adendaEdit = adendaMapper.selectByPrimaryKeyBasic(adendaDto.getIdAdenda()); 
				   adendaEdit.setNroadenda(adendaDto.getNroAdenda());
				   adendaEdit.setMotivoadenda(adendaDto.getMotivo());
				   adendaEdit.setMontoadenda(adendaDto.getMonto());
				   adendaEdit.setFechainicioadenda(adendaDto.getFechaInicio());
				   adendaEdit.setFechafinadenda(adendaDto.getFechaFin());
				   adendaEdit.setRutaadenda(adendaDto.getRuta());
				   adendaEdit.setFechacreacionauditoria(new Date());
				   
				   adendaEdit.setUsuariocreacionauditoria(adendaDto.getUsuarioCreacionAuditoria());
				   adendaEdit.setEquipoauditoria(adendaDto.getEquipoAuditoria());
				   
				   adendaMapper.updateByPrimaryKey(adendaEdit);
				   idAdenda =  adendaEdit.getIdadenda();
				   
			   }else{
				   Adenda adendaNew = new Adenda();
				   idAdenda = (utilsBusiness.getNextSeq(pe.com.sisabas.resources.Sequence.SEQ_ADENDA)).intValue();
				   adendaNew.setIdadenda(idAdenda);
				   adendaNew.setIdcontrato(request.getIdContrato());
				   adendaNew.setNroadenda(adendaDto.getNroAdenda());
				   adendaNew.setMotivoadenda(adendaDto.getMotivo());
				   adendaNew.setMontoadenda(adendaDto.getMonto());
				   adendaNew.setFechainicioadenda(adendaDto.getFechaInicio());
				   adendaNew.setFechafinadenda(adendaDto.getFechaFin());
				   adendaNew.setRutaadenda(adendaDto.getRuta());
				   adendaNew.setFechacreacionauditoria(new Date());
				   
				   adendaNew.setUsuariocreacionauditoria(adendaDto.getUsuarioCreacionAuditoria());
				   adendaNew.setEquipoauditoria(adendaDto.getEquipoAuditoria());
				   
				   adendaMapper.insert(adendaNew);
			   }
			   
			   
		   }
		   
		   

		}

	

		
	}
	

