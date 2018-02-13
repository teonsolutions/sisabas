package pe.com.sisabas.business.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.sisabas.be.Contrato;
import pe.com.sisabas.be.ContratoRequest;
import pe.com.sisabas.be.ContratoResponse;
import pe.com.sisabas.be.Estadosporetapapordocumento;
import pe.com.sisabas.be.Estadosportipodocumento;
import pe.com.sisabas.be.Evaluaciondocumento;
import pe.com.sisabas.business.ContratoBusiness;
import pe.com.sisabas.dto.SegRequest;
import pe.com.sisabas.dto.SegResponse;
import pe.com.sisabas.persistence.ContratoMapper;
import pe.com.sisabas.persistence.EstadosporetapapordocumentoMapper;
import pe.com.sisabas.persistence.EstadosportipodocumentoMapper;
import pe.com.sisabas.persistence.EvaluaciondocumentoMapper;
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

	@Override
	public void updateByPrimaryKeyBasic(Contrato record) throws Exception {
		record.setFechamodificacionauditoria(Utils.currentTimeStamp());
		updateBooleanToChar(record);
		validateUpdate(record);
		Utils.convertPropertiesStringToUppercase(record);
		contratoMapper.updateByPrimaryKey(record);
		
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
	
}
