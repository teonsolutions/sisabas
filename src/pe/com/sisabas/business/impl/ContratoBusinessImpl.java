package pe.com.sisabas.business.impl;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.sisabas.be.Contrato;
import pe.com.sisabas.be.ContratoRequest;
import pe.com.sisabas.be.ContratoResponse;
import pe.com.sisabas.be.Entregable;
import pe.com.sisabas.be.Estadosporetapapordocumento;
import pe.com.sisabas.be.Estadosportipodocumento;
import pe.com.sisabas.be.Evaluaciondocumento;
import pe.com.sisabas.be.Orden;
import pe.com.sisabas.business.ContratoBusiness;
import pe.com.sisabas.dto.ContratoDto;
import pe.com.sisabas.dto.EntregableDto;
import pe.com.sisabas.dto.OrdenDto;
import pe.com.sisabas.dto.OrdenListaDto;
import pe.com.sisabas.dto.SegRequest;
import pe.com.sisabas.dto.SegResponse;
import pe.com.sisabas.persistence.ContratoMapper;
import pe.com.sisabas.persistence.EntregableMapper;
import pe.com.sisabas.persistence.EstadosporetapapordocumentoMapper;
import pe.com.sisabas.persistence.EstadosportipodocumentoMapper;
import pe.com.sisabas.persistence.EvaluaciondocumentoMapper;
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
	public void insertBasic(Contrato record) throws Exception {
		record.setIdcontrato((int)utilsBusiness.getNextSeq(Sequence.SEQ_SISABAS).longValue());
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
		
		//System.out.println("el valor del idContrato es " +record.getIdcontrato());
		Estadosportipodocumento param = new Estadosportipodocumento();
		param.setIdtipodocumento(Constantes.tipoDocumento.PROCESO);
		param.setIdestadosporetapa(Constantes.estadosPorEtapa.EN_COMITE_ESPECIAL); //sincronizar
		Estadosportipodocumento estado = estadosportipodocumentoMapper.selectByEtapaTipoDocumento(param);
		
		if (estado != null) {
			java.util.Date date = new java.util.Date();
			Estadosporetapapordocumento estadoNuevo = new Estadosporetapapordocumento();
			estadoNuevo.setNrodocumento(record.getIdcontrato()); //Process number
			estadoNuevo.setIdestadosportipodocumento(estado.getIdestadosportipodocumento());
			estadoNuevo.setIdtipodocumento(Constantes.tipoDocumento.PROCESO);
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
		

		
		if(request.getListaOrden()!=null){
			System.out.println(request.getListaOrden().size());
			for(int i=0; i<request.getListaOrden().size();i++){
				Orden orden = new Orden();
				
				System.out.println("El id contrato(3A) es == "+request.getIdContrato());
				System.out.println("El id contrato(3B) es == "+contrato.getIdcontrato());
				
				orden.setIdcontrato(request.getIdContrato());
				
				orden.setIdorden(((int)utilsBusiness.getNextSeq(Sequence.SEQ_ORDEN).longValue()));
				orden.setIdgrupodocumento(request.getIdGrupoDocumento());
				orden.setNroorden(request.getListaOrden().get(i).getNroOrden());
				System.out.println("El nro de orden es:"+request.getListaOrden().get(i).getNroOrden());
				orden.setFechaorden(request.getListaOrden().get(i).getFechaOrden());
				orden.setMoneda(request.getListaOrden().get(i).getMoneda());
				orden.setAnioorden(request.getListaOrden().get(i).getAnioOrden());
				
				

				if(request.getListaOrden().get(i).getTotalFactSoles()!=null){
				Double temporal =request.getListaOrden().get(i).getTotalFactSoles();
				orden.setMontoorden(new BigDecimal(temporal));
				}
				
                orden.setNroexpedientesiaf(String.valueOf(request.getListaOrden().get(i).getNroExpedienteSiaf()));
                
				orden.setEstadoorden(request.getListaOrden().get(i).getEstadoOrden());
				
				orden.setNroproceso(String.valueOf(request.getNroProceso()));
				orden.setNrocontrato(String.valueOf(request.getNroContrato()));
				orden.setFechainicioprestacion(request.getListaOrden().get(i).getFechainicioprestacion());
				orden.setIdcatalogotipobien(request.getListaOrden().get(i).getIdCatalogoTipoBien());
				orden.setFechafinprestacion(request.getListaOrden().get(i).getFechaFinPrestacion());
				orden.setPlazoejecucion(request.getPlazoEjecucion());
				orden.setAnio(request.getListaOrden().get(i).getAnio());
				orden.setFechacreacionauditoria(new Date());
				orden.setUsuariocreacionauditoria(request.getListaOrden().get(i).getUsuarioAuditoria());
				orden.setIdunidadejecutora(request.getListaOrden().get(i).getIdUnidadEjecutora());
				orden.setEquipoauditoria(request.getListaOrden().get(i).getEquipoAuditoria());
				
				System.out.println("orden 4 = "+orden.getIdcontrato());
				ordenMapper.insert(orden);
				
				if(request.getListaOrden().get(i).getEntregables()!=null){
					System.out.println("tamanio de orden:" +request.getListaOrden().size());
					System.out.println("tamanio de entregable:" +request.getListaOrden().get(i).getEntregables().size());
					for (int j = 0; j<request.getListaOrden().get(i).getEntregables().size(); j++) {
						
						Entregable entregable = new Entregable();
						List<EntregableDto> listaEntregableDto = new ArrayList<>();
						listaEntregableDto = request.getListaOrden().get(i).getEntregables();

						entregable.setIdentregable(((int)utilsBusiness.getNextSeq(Sequence.SEQ_ENTREGABLE).longValue()));
						entregable.setIdgrupodocumento(request.getIdGrupoDocumento());
						
						System.out.println("el valo de idgrupo ducmento es : "+request.getIdGrupoDocumento());
						
						entregable.setIdorden(listaEntregableDto.get(j).getIdOrden());
						entregable.setNroproveido(listaEntregableDto.get(j).getNroProveido());
						entregable.setNroentregable(listaEntregableDto.get(j).getDescripcion());
						
						System.out.println("Descripcion es :"+listaEntregableDto.get(j).getDescripcion());
						
						entregable.setPlazoentregable(listaEntregableDto.get(j).getPlazo());
						entregable.setMontoentregable(listaEntregableDto.get(j).getImporte());
						entregable.setMontopenalidadentregable(listaEntregableDto.get(j).getMontoPenalidad());
						entregable.setFechapresentacionentregable(listaEntregableDto.get(j).getFecha());
						entregable.setObservacionesentregable(listaEntregableDto.get(j).getObservacion());
                        entregable.setIdcatalogoestadoentregable(listaEntregableDto.get(j).getEstado()); 
						entregable.setAnio(listaEntregableDto.get(j).getAnio());
						
						
						
						//auditoria
						entregable.setFechacreacionauditoria(new Date());
						entregable.setEstadoauditoria(Constantes.estadoAuditoria.ACTIVO);
						entregable.setUsuariocreacionauditoria(listaEntregableDto.get(j).getUsuarioAuditoria());
						entregable.setIdorden(orden.getIdorden());
						
						entregableMapper.insert(entregable);	
					}
				}
			
				
					
				}
				
				
				
			}
	

		}


		
	}
	

