package pe.com.sisabas.business.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.sisabas.be.Contrato;
import pe.com.sisabas.be.ContratoRequest;
import pe.com.sisabas.be.ContratoResponse;
import pe.com.sisabas.business.ContratoBusiness;
import pe.com.sisabas.persistence.ContratoMapper;
import pe.com.sisabas.resources.business.UtilsBusiness;
import pe.com.sisabas.resources.Sequence;
import pe.com.sisabas.resources.Utils;
import pe.com.sisabas.resources.Messages;
import pe.com.sisabas.exception.ValidateException;


@Service
public class ContratoBusinessImpl implements ContratoBusiness, Serializable{

	@Autowired
	public ContratoMapper contratoMapper;
	
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
		contratoMapper.insert(record);
		
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
}
