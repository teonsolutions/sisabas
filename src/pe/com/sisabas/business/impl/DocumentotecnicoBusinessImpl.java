
package pe.com.sisabas.business.impl;
import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.sisabas.be.Documentotecnico;
import pe.com.sisabas.persistence.DocumentotecnicoMapper;
import pe.com.sisabas.business.DocumentotecnicoBusiness;
import pe.com.sisabas.dto.EvaluacionDocumentoRequest;
import pe.com.sisabas.dto.EvaluacionDocumentoResponse;
import pe.com.sisabas.dto.Resultado;
import pe.com.sisabas.dto.TransactionRequest;
import pe.com.sisabas.exception.BusinessException;
import pe.com.sisabas.exception.ValidateException;
import pe.com.sisabas.resources.Constantes;
import pe.com.sisabas.resources.Messages;
import pe.com.sisabas.resources.Sequence;
import pe.com.sisabas.resources.Utils;
import pe.com.sisabas.resources.business.UtilsBusiness;


@Service
public class DocumentotecnicoBusinessImpl implements DocumentotecnicoBusiness, Serializable{

	private static Logger logger=Logger.getLogger(DocumentotecnicoBusinessImpl.class);

	private static final long serialVersionUID = 1L;

	@Autowired
	public DocumentotecnicoMapper documentotecnicoMapper;

	@Autowired
	public UtilsBusiness utilsBusiness;

	@Override
	public void deleteByPrimaryKeyBasic(Documentotecnico par_record) throws Exception {
		validateDelete(par_record.getIddocumentotecnico());
		documentotecnicoMapper.deleteByPrimaryKey(par_record.getIddocumentotecnico());
	}

	@Override
	public void insertBasic(Documentotecnico record) throws Exception {
		record.setIddocumentotecnico((int)utilsBusiness.getNextSeq(Sequence.SEQ_DOCUMENTOTECNICO).longValue());
		record.setFechacreacionauditoria(Utils.currentTimeStamp());
		record.setEstadoauditoria("1");
		updateBooleanToChar(record);
		validateInsert(record);
		Utils.convertPropertiesStringToUppercase(record);
		documentotecnicoMapper.insert(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void insertFull(Documentotecnico record) throws Exception {
		//Business Logic
		insertBasic(record);
	}

	@Override
	public void insertSelectiveBasic(Documentotecnico record) throws Exception {
		record.setIddocumentotecnico((int)utilsBusiness.getNextSeq(Sequence.SEQ_DOCUMENTOTECNICO).longValue());
		record.setFechacreacionauditoria(Utils.currentTimeStamp());
		record.setEstadoauditoria("1");
		updateBooleanToChar(record);
		Utils.convertPropertiesStringToUppercase(record);
		documentotecnicoMapper.insertSelective(record);
	}

	@Override
	public Documentotecnico selectByPrimaryKeyBasic(java.lang.Integer par_iddocumentotecnico) throws Exception {
		return documentotecnicoMapper.selectByPrimaryKeyBasic(par_iddocumentotecnico);
	}

	@Override
	public Documentotecnico selectByPrimaryKeyBasicFromList(java.lang.Integer par_iddocumentotecnico, List<Documentotecnico> list) throws Exception {
		Documentotecnico record=null;
		for (Documentotecnico row : list) {
			if(row.equals(new Documentotecnico( par_iddocumentotecnico))){
				record=row;
				break;
			}
		}
		if(record==null)
			record=selectByPrimaryKeyBasic( par_iddocumentotecnico);

		return record;
	}

	@Override
	public Documentotecnico selectByPrimaryKeyBasicActive(java.lang.Integer par_iddocumentotecnico) throws Exception {
		return documentotecnicoMapper.selectByPrimaryKeyBasicActive(par_iddocumentotecnico);
	}

	@Override
	public Documentotecnico selectByPrimaryKeyFull(java.lang.Integer par_iddocumentotecnico) throws Exception {
		return documentotecnicoMapper.selectByPrimaryKeyFull(par_iddocumentotecnico);
	}

	@Override
	public Documentotecnico selectByPrimaryKeyFullActive(java.lang.Integer par_iddocumentotecnico) throws Exception {
		return documentotecnicoMapper.selectByPrimaryKeyFullActive(par_iddocumentotecnico);
	}

	@Override
	public List<Documentotecnico> selectDynamicBasic(Documentotecnico record) throws Exception {
		return documentotecnicoMapper.selectDynamicBasic(record);
	}

	@Override
	public List<Documentotecnico> selectDynamicBasicActives(Documentotecnico record) throws Exception {
		record.setEstadoauditoria("1");
		return documentotecnicoMapper.selectDynamicBasic(record);
	}

	@Override
	public List<Documentotecnico> selectDynamicFull(Documentotecnico record) throws Exception {
		List<Documentotecnico> list=documentotecnicoMapper.selectDynamicFull(record);
		if(Documentotecnico.HAVE_BIGDECIMALS)
		for (Documentotecnico row : list) {
			row.roundBigDecimals();
		}

		return list;
	}

	@Override
	public List<Documentotecnico> selectDynamicFullActives(Documentotecnico record) throws Exception {
		record.setEstadoauditoria("1");
		return documentotecnicoMapper.selectDynamicFull(record);
	}

	@Override
	public List<Documentotecnico> selectDynamicExtended(Documentotecnico record) throws Exception {
		return documentotecnicoMapper.selectDynamicExtended(record);
	}

	@Override
	public List<Documentotecnico> selectDynamicExtendedActives(Documentotecnico record) throws Exception {
		record.setEstadoauditoria("1");
		return documentotecnicoMapper.selectDynamicExtended(record);
	}

	@Override
	public void updateByPrimaryKeySelectiveBasic(Documentotecnico record) throws Exception {
		record.setFechamodificacionauditoria(Utils.currentTimeStamp());
		updateBooleanToChar(record);
		Utils.convertPropertiesStringToUppercase(record);
		documentotecnicoMapper.updateByPrimaryKeySelective(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void updateByPrimaryKeySelectiveFull(Documentotecnico record) throws Exception {
		//Business Logic
		updateByPrimaryKeySelectiveBasic(record);
	}

	@Override
	public void updateByPrimaryKeyBasic(Documentotecnico record) throws Exception {
		record.setFechamodificacionauditoria(Utils.currentTimeStamp());
		updateBooleanToChar(record);
		validateUpdate(record);
		Utils.convertPropertiesStringToUppercase(record);
		documentotecnicoMapper.updateByPrimaryKey(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void updateByPrimaryKeyFull(Documentotecnico record) throws Exception {
		//Business Logic
		updateByPrimaryKeyBasic(record);
	}

	public void updateBooleanToChar(Documentotecnico record) throws Exception {
		if(record.getBooleantienecomite()!=null && record.getBooleantienecomite()){
			record.setTienecomite("1");
		}else{
			record.setTienecomite("0");
		}

		if(record.getBooleanitinerarioorigenregistrado()!=null && record.getBooleanitinerarioorigenregistrado()){
			record.setItinerarioorigenregistrado("1");
		}else{
			record.setItinerarioorigenregistrado("0");
		}

	}

	public void validateInsert(Documentotecnico record)throws Exception{
		if(record.getIddocumentotecnico()==null)
			throw new ValidateException(Messages.getString("documentotecnico.iddocumentotecnico.required"));

		if(record.getDenominacioncontratacion()!=null &&  record.getDenominacioncontratacion().length() > 500)
			throw new ValidateException(Messages.getString("documentotecnico.denominacioncontratacion.length.error",record.getDenominacioncontratacion().length()));
		if(record.getFinalidadpublica()!=null &&  record.getFinalidadpublica().length() > 500)
			throw new ValidateException(Messages.getString("documentotecnico.finalidadpublica.length.error",record.getFinalidadpublica().length()));
		if(record.getObjetocontratacion()!=null &&  record.getObjetocontratacion().length() > 500)
			throw new ValidateException(Messages.getString("documentotecnico.objetocontratacion.length.error",record.getObjetocontratacion().length()));
		if(record.getCentrocosto()!=null &&  record.getCentrocosto().length() > 20)
			throw new ValidateException(Messages.getString("documentotecnico.centrocosto.length.error",record.getCentrocosto().length()));
		if(record.getAntecedentes()!=null &&  record.getAntecedentes().length() > 500)
			throw new ValidateException(Messages.getString("documentotecnico.antecedentes.length.error",record.getAntecedentes().length()));
		if(record.getDniresponsable()!=null &&  record.getDniresponsable().length() > 8)
			throw new ValidateException(Messages.getString("documentotecnico.dniresponsable.length.error",record.getDniresponsable().length()));
		if(record.getNombreresponsable()!=null &&  record.getNombreresponsable().length() > 500)
			throw new ValidateException(Messages.getString("documentotecnico.nombreresponsable.length.error",record.getNombreresponsable().length()));
		if(record.getNroanexoresponsable()!=null &&  record.getNroanexoresponsable().length() > 10)
			throw new ValidateException(Messages.getString("documentotecnico.nroanexoresponsable.length.error",record.getNroanexoresponsable().length()));
		if(record.getCorreoresponsable()!=null &&  record.getCorreoresponsable().length() > 50)
			throw new ValidateException(Messages.getString("documentotecnico.correoresponsable.length.error",record.getCorreoresponsable().length()));
		if(record.getIdcatalogotipodocumentotecnico()!=null &&  record.getIdcatalogotipodocumentotecnico().length() > 10)
			throw new ValidateException(Messages.getString("documentotecnico.idcatalogotipodocumentotecnico.length.error",record.getIdcatalogotipodocumentotecnico().length()));
		if(record.getIdcatalogotipotdr()!=null &&  record.getIdcatalogotipotdr().length() > 10)
			throw new ValidateException(Messages.getString("documentotecnico.idcatalogotipotdr.length.error",record.getIdcatalogotipotdr().length()));
		if(record.getRutaanexo()!=null &&  record.getRutaanexo().length() > 300)
			throw new ValidateException(Messages.getString("documentotecnico.rutaanexo.length.error",record.getRutaanexo().length()));
		if(record.getUsuariocreacionauditoria()!=null &&  record.getUsuariocreacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("documentotecnico.usuariocreacionauditoria.length.error",record.getUsuariocreacionauditoria().length()));
		if(record.getUsuariomodificacionauditoria()!=null &&  record.getUsuariomodificacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("documentotecnico.usuariomodificacionauditoria.length.error",record.getUsuariomodificacionauditoria().length()));
		if(record.getUbigeo()!=null &&  record.getUbigeo().length() > 6)
			throw new ValidateException(Messages.getString("documentotecnico.ubigeo.length.error",record.getUbigeo().length()));
		if(record.getDireccion()!=null &&  record.getDireccion().length() > 100)
			throw new ValidateException(Messages.getString("documentotecnico.direccion.length.error",record.getDireccion().length()));
		if(record.getNumeroexpediente()!=null &&  record.getNumeroexpediente().length() > 30)
			throw new ValidateException(Messages.getString("documentotecnico.numeroexpediente.length.error",record.getNumeroexpediente().length()));
		if(record.getTienecomite()!=null &&  record.getTienecomite().length() > 1)
			throw new ValidateException(Messages.getString("documentotecnico.tienecomite.length.error",record.getTienecomite().length()));
		if(record.getTipoitinerario()!=null &&  record.getTipoitinerario().length() > 3)
			throw new ValidateException(Messages.getString("documentotecnico.tipoitinerario.length.error",record.getTipoitinerario().length()));
		if(record.getNropedidoitinerario()!=null &&  record.getNropedidoitinerario().length() > 5)
			throw new ValidateException(Messages.getString("documentotecnico.nropedidoitinerario.length.error",record.getNropedidoitinerario().length()));
		if(record.getUepedidoitinerario()!=null &&  record.getUepedidoitinerario().length() > 4)
			throw new ValidateException(Messages.getString("documentotecnico.uepedidoitinerario.length.error",record.getUepedidoitinerario().length()));
		if(record.getJustificacionpedidoitinerario()!=null &&  record.getJustificacionpedidoitinerario().length() > 500)
			throw new ValidateException(Messages.getString("documentotecnico.justificacionpedidoitinerario.length.error",record.getJustificacionpedidoitinerario().length()));
		if(record.getItinerarioorigenregistrado()!=null &&  record.getItinerarioorigenregistrado().length() > 1)
			throw new ValidateException(Messages.getString("documentotecnico.itinerarioorigenregistrado.length.error",record.getItinerarioorigenregistrado().length()));
		if(record.getEquipoauditoria()!=null &&  record.getEquipoauditoria().length() > 45)
			throw new ValidateException(Messages.getString("documentotecnico.equipoauditoria.length.error",record.getEquipoauditoria().length()));
		if(record.getProgramaauditoria()!=null &&  record.getProgramaauditoria().length() > 200)
			throw new ValidateException(Messages.getString("documentotecnico.programaauditoria.length.error",record.getProgramaauditoria().length()));
		if(record.getEstadoauditoria()!=null &&  record.getEstadoauditoria().length() > 1)
			throw new ValidateException(Messages.getString("documentotecnico.estadoauditoria.length.error",record.getEstadoauditoria().length()));

		//Here Bussines Validations.
	}

	public void validateUpdate(Documentotecnico record)throws Exception{
		if(record.getIddocumentotecnico()==null)
			throw new ValidateException(Messages.getString("documentotecnico.iddocumentotecnico.required"));

		if(record.getDenominacioncontratacion()!=null &&  record.getDenominacioncontratacion().length() > 500)
			throw new ValidateException(Messages.getString("documentotecnico.denominacioncontratacion.length.error",record.getDenominacioncontratacion().length()));
		if(record.getFinalidadpublica()!=null &&  record.getFinalidadpublica().length() > 500)
			throw new ValidateException(Messages.getString("documentotecnico.finalidadpublica.length.error",record.getFinalidadpublica().length()));
		if(record.getObjetocontratacion()!=null &&  record.getObjetocontratacion().length() > 500)
			throw new ValidateException(Messages.getString("documentotecnico.objetocontratacion.length.error",record.getObjetocontratacion().length()));
		if(record.getCentrocosto()!=null &&  record.getCentrocosto().length() > 20)
			throw new ValidateException(Messages.getString("documentotecnico.centrocosto.length.error",record.getCentrocosto().length()));
		if(record.getAntecedentes()!=null &&  record.getAntecedentes().length() > 500)
			throw new ValidateException(Messages.getString("documentotecnico.antecedentes.length.error",record.getAntecedentes().length()));
		if(record.getDniresponsable()!=null &&  record.getDniresponsable().length() > 8)
			throw new ValidateException(Messages.getString("documentotecnico.dniresponsable.length.error",record.getDniresponsable().length()));
		if(record.getNombreresponsable()!=null &&  record.getNombreresponsable().length() > 500)
			throw new ValidateException(Messages.getString("documentotecnico.nombreresponsable.length.error",record.getNombreresponsable().length()));
		if(record.getNroanexoresponsable()!=null &&  record.getNroanexoresponsable().length() > 10)
			throw new ValidateException(Messages.getString("documentotecnico.nroanexoresponsable.length.error",record.getNroanexoresponsable().length()));
		if(record.getCorreoresponsable()!=null &&  record.getCorreoresponsable().length() > 50)
			throw new ValidateException(Messages.getString("documentotecnico.correoresponsable.length.error",record.getCorreoresponsable().length()));
		if(record.getIdcatalogotipodocumentotecnico()!=null &&  record.getIdcatalogotipodocumentotecnico().length() > 10)
			throw new ValidateException(Messages.getString("documentotecnico.idcatalogotipodocumentotecnico.length.error",record.getIdcatalogotipodocumentotecnico().length()));
		if(record.getIdcatalogotipotdr()!=null &&  record.getIdcatalogotipotdr().length() > 10)
			throw new ValidateException(Messages.getString("documentotecnico.idcatalogotipotdr.length.error",record.getIdcatalogotipotdr().length()));
		if(record.getRutaanexo()!=null &&  record.getRutaanexo().length() > 300)
			throw new ValidateException(Messages.getString("documentotecnico.rutaanexo.length.error",record.getRutaanexo().length()));
		if(record.getUsuariocreacionauditoria()!=null &&  record.getUsuariocreacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("documentotecnico.usuariocreacionauditoria.length.error",record.getUsuariocreacionauditoria().length()));
		if(record.getUsuariomodificacionauditoria()!=null &&  record.getUsuariomodificacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("documentotecnico.usuariomodificacionauditoria.length.error",record.getUsuariomodificacionauditoria().length()));
		if(record.getUbigeo()!=null &&  record.getUbigeo().length() > 6)
			throw new ValidateException(Messages.getString("documentotecnico.ubigeo.length.error",record.getUbigeo().length()));
		if(record.getDireccion()!=null &&  record.getDireccion().length() > 100)
			throw new ValidateException(Messages.getString("documentotecnico.direccion.length.error",record.getDireccion().length()));
		if(record.getNumeroexpediente()!=null &&  record.getNumeroexpediente().length() > 30)
			throw new ValidateException(Messages.getString("documentotecnico.numeroexpediente.length.error",record.getNumeroexpediente().length()));
		if(record.getTienecomite()!=null &&  record.getTienecomite().length() > 1)
			throw new ValidateException(Messages.getString("documentotecnico.tienecomite.length.error",record.getTienecomite().length()));
		if(record.getTipoitinerario()!=null &&  record.getTipoitinerario().length() > 3)
			throw new ValidateException(Messages.getString("documentotecnico.tipoitinerario.length.error",record.getTipoitinerario().length()));
		if(record.getNropedidoitinerario()!=null &&  record.getNropedidoitinerario().length() > 5)
			throw new ValidateException(Messages.getString("documentotecnico.nropedidoitinerario.length.error",record.getNropedidoitinerario().length()));
		if(record.getUepedidoitinerario()!=null &&  record.getUepedidoitinerario().length() > 4)
			throw new ValidateException(Messages.getString("documentotecnico.uepedidoitinerario.length.error",record.getUepedidoitinerario().length()));
		if(record.getJustificacionpedidoitinerario()!=null &&  record.getJustificacionpedidoitinerario().length() > 500)
			throw new ValidateException(Messages.getString("documentotecnico.justificacionpedidoitinerario.length.error",record.getJustificacionpedidoitinerario().length()));
		if(record.getItinerarioorigenregistrado()!=null &&  record.getItinerarioorigenregistrado().length() > 1)
			throw new ValidateException(Messages.getString("documentotecnico.itinerarioorigenregistrado.length.error",record.getItinerarioorigenregistrado().length()));
		if(record.getEquipoauditoria()!=null &&  record.getEquipoauditoria().length() > 45)
			throw new ValidateException(Messages.getString("documentotecnico.equipoauditoria.length.error",record.getEquipoauditoria().length()));
		if(record.getProgramaauditoria()!=null &&  record.getProgramaauditoria().length() > 200)
			throw new ValidateException(Messages.getString("documentotecnico.programaauditoria.length.error",record.getProgramaauditoria().length()));
		if(record.getEstadoauditoria()!=null &&  record.getEstadoauditoria().length() > 1)
			throw new ValidateException(Messages.getString("documentotecnico.estadoauditoria.length.error",record.getEstadoauditoria().length()));

		//Here Bussines Validations.
	}

	public void validateDelete(java.lang.Integer par_iddocumentotecnico)throws Exception{
		if(par_iddocumentotecnico==null)
			throw new ValidateException(Messages.getString("documentotecnico.iddocumentotecnico.required"));

		//Here Bussines Validations.
	}

	@Override
	public List<EvaluacionDocumentoResponse> getPedidosEvaluacion(EvaluacionDocumentoRequest record) throws Exception {
		// TODO Auto-generated method stub
		return documentotecnicoMapper.getPedidosEvaluacion(record);		
	}


}

