
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
import pe.com.sisabas.be.Evaluaciondocumento;
import pe.com.sisabas.persistence.EvaluaciondocumentoMapper;
import pe.com.sisabas.business.EvaluaciondocumentoBusiness;
import pe.com.sisabas.exception.BusinessException;
import pe.com.sisabas.exception.ValidateException;
import pe.com.sisabas.resources.Constantes;
import pe.com.sisabas.resources.Messages;
import pe.com.sisabas.resources.Sequence;
import pe.com.sisabas.resources.Utils;
import pe.com.sisabas.resources.business.UtilsBusiness;


@Service
public class EvaluaciondocumentoBusinessImpl implements EvaluaciondocumentoBusiness, Serializable{

	private static Logger logger=Logger.getLogger(EvaluaciondocumentoBusinessImpl.class);

	private static final long serialVersionUID = 1L;

	@Autowired
	public EvaluaciondocumentoMapper evaluaciondocumentoMapper;

	@Autowired
	public UtilsBusiness utilsBusiness;

	@Override
	public void deleteByPrimaryKeyBasic(Evaluaciondocumento par_record) throws Exception {
		validateDelete(par_record.getIdevaluaciondocumento());
		evaluaciondocumentoMapper.deleteByPrimaryKey(par_record.getIdevaluaciondocumento());
	}

	@Override
	public void insertBasic(Evaluaciondocumento record) throws Exception {
		record.setIdevaluaciondocumento((int)utilsBusiness.getNextSeq(Sequence.SEQ_SISABAS).longValue());
		record.setFechacreacionauditoria(Utils.currentTimeStamp());
		record.setEstadoauditoria("1");
		updateBooleanToChar(record);
		validateInsert(record);
		Utils.convertPropertiesStringToUppercase(record);
		evaluaciondocumentoMapper.insert(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void insertFull(Evaluaciondocumento record) throws Exception {
		//Business Logic
		insertBasic(record);
	}

	@Override
	public void insertSelectiveBasic(Evaluaciondocumento record) throws Exception {
		record.setIdevaluaciondocumento((int)utilsBusiness.getNextSeq(Sequence.SEQ_SISABAS).longValue());
		record.setFechacreacionauditoria(Utils.currentTimeStamp());
		record.setEstadoauditoria("1");
		updateBooleanToChar(record);
		Utils.convertPropertiesStringToUppercase(record);
		evaluaciondocumentoMapper.insertSelective(record);
	}

	@Override
	public Evaluaciondocumento selectByPrimaryKeyBasic(java.lang.Integer par_idevaluaciondocumento) throws Exception {
		return evaluaciondocumentoMapper.selectByPrimaryKeyBasic(par_idevaluaciondocumento);
	}

	@Override
	public Evaluaciondocumento selectByPrimaryKeyBasicFromList(java.lang.Integer par_idevaluaciondocumento, List<Evaluaciondocumento> list) throws Exception {
		Evaluaciondocumento record=null;
		for (Evaluaciondocumento row : list) {
			if(row.equals(new Evaluaciondocumento( par_idevaluaciondocumento))){
				record=row;
				break;
			}
		}
		if(record==null)
			record=selectByPrimaryKeyBasic( par_idevaluaciondocumento);

		return record;
	}

	@Override
	public Evaluaciondocumento selectByPrimaryKeyBasicActive(java.lang.Integer par_idevaluaciondocumento) throws Exception {
		return evaluaciondocumentoMapper.selectByPrimaryKeyBasicActive(par_idevaluaciondocumento);
	}

	@Override
	public Evaluaciondocumento selectByPrimaryKeyFull(java.lang.Integer par_idevaluaciondocumento) throws Exception {
		return evaluaciondocumentoMapper.selectByPrimaryKeyFull(par_idevaluaciondocumento);
	}

	@Override
	public Evaluaciondocumento selectByPrimaryKeyFullActive(java.lang.Integer par_idevaluaciondocumento) throws Exception {
		return evaluaciondocumentoMapper.selectByPrimaryKeyFullActive(par_idevaluaciondocumento);
	}

	@Override
	public List<Evaluaciondocumento> selectDynamicBasic(Evaluaciondocumento record) throws Exception {
		return evaluaciondocumentoMapper.selectDynamicBasic(record);
	}

	@Override
	public List<Evaluaciondocumento> selectDynamicBasicActives(Evaluaciondocumento record) throws Exception {
		record.setEstadoauditoria("1");
		return evaluaciondocumentoMapper.selectDynamicBasic(record);
	}

	@Override
	public List<Evaluaciondocumento> selectDynamicFull(Evaluaciondocumento record) throws Exception {
		List<Evaluaciondocumento> list=evaluaciondocumentoMapper.selectDynamicFull(record);
		if(Evaluaciondocumento.HAVE_BIGDECIMALS)
		for (Evaluaciondocumento row : list) {
			row.roundBigDecimals();
		}

		return list;
	}

	@Override
	public List<Evaluaciondocumento> selectDynamicFullActives(Evaluaciondocumento record) throws Exception {
		record.setEstadoauditoria("1");
		return evaluaciondocumentoMapper.selectDynamicFull(record);
	}

	@Override
	public List<Evaluaciondocumento> selectDynamicExtended(Evaluaciondocumento record) throws Exception {
		return evaluaciondocumentoMapper.selectDynamicExtended(record);
	}

	@Override
	public List<Evaluaciondocumento> selectDynamicExtendedActives(Evaluaciondocumento record) throws Exception {
		record.setEstadoauditoria("1");
		return evaluaciondocumentoMapper.selectDynamicExtended(record);
	}

	@Override
	public void updateByPrimaryKeySelectiveBasic(Evaluaciondocumento record) throws Exception {
		record.setFechamodificacionauditoria(Utils.currentTimeStamp());
		updateBooleanToChar(record);
		Utils.convertPropertiesStringToUppercase(record);
		evaluaciondocumentoMapper.updateByPrimaryKeySelective(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void updateByPrimaryKeySelectiveFull(Evaluaciondocumento record) throws Exception {
		//Business Logic
		updateByPrimaryKeySelectiveBasic(record);
	}

	@Override
	public void updateByPrimaryKeyBasic(Evaluaciondocumento record) throws Exception {
		record.setFechamodificacionauditoria(Utils.currentTimeStamp());
		updateBooleanToChar(record);
		validateUpdate(record);
		Utils.convertPropertiesStringToUppercase(record);
		evaluaciondocumentoMapper.updateByPrimaryKey(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void updateByPrimaryKeyFull(Evaluaciondocumento record) throws Exception {
		//Business Logic
		updateByPrimaryKeyBasic(record);
	}

	public void updateBooleanToChar(Evaluaciondocumento record) throws Exception {
	}

	public void validateInsert(Evaluaciondocumento record)throws Exception{
		if(record.getIdevaluaciondocumento()==null)
			throw new ValidateException(Messages.getString("evaluaciondocumento.idevaluaciondocumento.required"));

		if(record.getIdcatalogoestadodocumentacion()!=null &&  record.getIdcatalogoestadodocumentacion().length() > 10)
			throw new ValidateException(Messages.getString("evaluaciondocumento.idcatalogoestadodocumentacion.length.error",record.getIdcatalogoestadodocumentacion().length()));
		if(record.getUsuariocreacionauditoria()!=null &&  record.getUsuariocreacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("evaluaciondocumento.usuariocreacionauditoria.length.error",record.getUsuariocreacionauditoria().length()));
		if(record.getUsuariomodificacionauditoria()!=null &&  record.getUsuariomodificacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("evaluaciondocumento.usuariomodificacionauditoria.length.error",record.getUsuariomodificacionauditoria().length()));
		if(record.getEquipoauditoria()!=null &&  record.getEquipoauditoria().length() > 45)
			throw new ValidateException(Messages.getString("evaluaciondocumento.equipoauditoria.length.error",record.getEquipoauditoria().length()));
		if(record.getProgramaauditoria()!=null &&  record.getProgramaauditoria().length() > 200)
			throw new ValidateException(Messages.getString("evaluaciondocumento.programaauditoria.length.error",record.getProgramaauditoria().length()));
		if(record.getEstadoauditoria()!=null &&  record.getEstadoauditoria().length() > 1)
			throw new ValidateException(Messages.getString("evaluaciondocumento.estadoauditoria.length.error",record.getEstadoauditoria().length()));

		//Here Bussines Validations.
	}

	public void validateUpdate(Evaluaciondocumento record)throws Exception{
		if(record.getIdevaluaciondocumento()==null)
			throw new ValidateException(Messages.getString("evaluaciondocumento.idevaluaciondocumento.required"));

		if(record.getIdcatalogoestadodocumentacion()!=null &&  record.getIdcatalogoestadodocumentacion().length() > 10)
			throw new ValidateException(Messages.getString("evaluaciondocumento.idcatalogoestadodocumentacion.length.error",record.getIdcatalogoestadodocumentacion().length()));
		if(record.getUsuariocreacionauditoria()!=null &&  record.getUsuariocreacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("evaluaciondocumento.usuariocreacionauditoria.length.error",record.getUsuariocreacionauditoria().length()));
		if(record.getUsuariomodificacionauditoria()!=null &&  record.getUsuariomodificacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("evaluaciondocumento.usuariomodificacionauditoria.length.error",record.getUsuariomodificacionauditoria().length()));
		if(record.getEquipoauditoria()!=null &&  record.getEquipoauditoria().length() > 45)
			throw new ValidateException(Messages.getString("evaluaciondocumento.equipoauditoria.length.error",record.getEquipoauditoria().length()));
		if(record.getProgramaauditoria()!=null &&  record.getProgramaauditoria().length() > 200)
			throw new ValidateException(Messages.getString("evaluaciondocumento.programaauditoria.length.error",record.getProgramaauditoria().length()));
		if(record.getEstadoauditoria()!=null &&  record.getEstadoauditoria().length() > 1)
			throw new ValidateException(Messages.getString("evaluaciondocumento.estadoauditoria.length.error",record.getEstadoauditoria().length()));

		//Here Bussines Validations.
	}

	public void validateDelete(java.lang.Integer par_idevaluaciondocumento)throws Exception{
		if(par_idevaluaciondocumento==null)
			throw new ValidateException(Messages.getString("evaluaciondocumento.idevaluaciondocumento.required"));

		//Here Bussines Validations.
	}


}

