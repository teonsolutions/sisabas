
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
import pe.com.sisabas.be.Observacionesdocumentotecnico;
import pe.com.sisabas.persistence.ObservacionesdocumentotecnicoMapper;
import pe.com.sisabas.business.ObservacionesdocumentotecnicoBusiness;
import pe.com.sisabas.exception.BusinessException;
import pe.com.sisabas.exception.ValidateException;
import pe.com.sisabas.resources.Constantes;
import pe.com.sisabas.resources.Messages;
import pe.com.sisabas.resources.Sequence;
import pe.com.sisabas.resources.Utils;
import pe.com.sisabas.resources.business.UtilsBusiness;


@Service
public class ObservacionesdocumentotecnicoBusinessImpl implements ObservacionesdocumentotecnicoBusiness, Serializable{

	private static Logger logger=Logger.getLogger(ObservacionesdocumentotecnicoBusinessImpl.class);

	private static final long serialVersionUID = 1L;

	@Autowired
	public ObservacionesdocumentotecnicoMapper observacionesdocumentotecnicoMapper;

	@Autowired
	public UtilsBusiness utilsBusiness;

	@Override
	public void deleteByPrimaryKeyBasic(Observacionesdocumentotecnico par_record) throws Exception {
		validateDelete(par_record.getIdobservacionesdocumentotecnico());
		observacionesdocumentotecnicoMapper.deleteByPrimaryKey(par_record.getIdobservacionesdocumentotecnico());
	}

	@Override
	public void insertBasic(Observacionesdocumentotecnico record) throws Exception {
		record.setIdobservacionesdocumentotecnico((int)utilsBusiness.getNextSeq(Sequence.SEQ_OBSERVACIONESDOCUMENTOTECNICO).longValue());
		record.setEstadoauditoria("1");
		updateBooleanToChar(record);
		validateInsert(record);
		Utils.convertPropertiesStringToUppercase(record);
		observacionesdocumentotecnicoMapper.insert(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void insertFull(Observacionesdocumentotecnico record) throws Exception {
		//Business Logic
		insertBasic(record);
	}

	@Override
	public void insertSelectiveBasic(Observacionesdocumentotecnico record) throws Exception {
		record.setIdobservacionesdocumentotecnico((int)utilsBusiness.getNextSeq(Sequence.SEQ_OBSERVACIONESDOCUMENTOTECNICO).longValue());
		record.setEstadoauditoria("1");
		updateBooleanToChar(record);
		Utils.convertPropertiesStringToUppercase(record);
		observacionesdocumentotecnicoMapper.insertSelective(record);
	}

	@Override
	public Observacionesdocumentotecnico selectByPrimaryKeyBasic(java.lang.Integer par_idobservacionesdocumentotecnico) throws Exception {
		return observacionesdocumentotecnicoMapper.selectByPrimaryKeyBasic(par_idobservacionesdocumentotecnico);
	}

	@Override
	public Observacionesdocumentotecnico selectByPrimaryKeyBasicFromList(java.lang.Integer par_idobservacionesdocumentotecnico, List<Observacionesdocumentotecnico> list) throws Exception {
		Observacionesdocumentotecnico record=null;
		for (Observacionesdocumentotecnico row : list) {
			if(row.equals(new Observacionesdocumentotecnico( par_idobservacionesdocumentotecnico))){
				record=row;
				break;
			}
		}
		if(record==null)
			record=selectByPrimaryKeyBasic( par_idobservacionesdocumentotecnico);

		return record;
	}

	@Override
	public Observacionesdocumentotecnico selectByPrimaryKeyBasicActive(java.lang.Integer par_idobservacionesdocumentotecnico) throws Exception {
		return observacionesdocumentotecnicoMapper.selectByPrimaryKeyBasicActive(par_idobservacionesdocumentotecnico);
	}

	@Override
	public Observacionesdocumentotecnico selectByPrimaryKeyFull(java.lang.Integer par_idobservacionesdocumentotecnico) throws Exception {
		return observacionesdocumentotecnicoMapper.selectByPrimaryKeyFull(par_idobservacionesdocumentotecnico);
	}

	@Override
	public Observacionesdocumentotecnico selectByPrimaryKeyFullActive(java.lang.Integer par_idobservacionesdocumentotecnico) throws Exception {
		return observacionesdocumentotecnicoMapper.selectByPrimaryKeyFullActive(par_idobservacionesdocumentotecnico);
	}

	@Override
	public List<Observacionesdocumentotecnico> selectDynamicBasic(Observacionesdocumentotecnico record) throws Exception {
		return observacionesdocumentotecnicoMapper.selectDynamicBasic(record);
	}

	@Override
	public List<Observacionesdocumentotecnico> selectDynamicBasicActives(Observacionesdocumentotecnico record) throws Exception {
		record.setEstadoauditoria("1");
		return observacionesdocumentotecnicoMapper.selectDynamicBasic(record);
	}

	@Override
	public List<Observacionesdocumentotecnico> selectDynamicFull(Observacionesdocumentotecnico record) throws Exception {
		List<Observacionesdocumentotecnico> list=observacionesdocumentotecnicoMapper.selectDynamicFull(record);
		if(Observacionesdocumentotecnico.HAVE_BIGDECIMALS)
		for (Observacionesdocumentotecnico row : list) {
			row.roundBigDecimals();
		}

		return list;
	}

	@Override
	public List<Observacionesdocumentotecnico> selectDynamicFullActives(Observacionesdocumentotecnico record) throws Exception {
		record.setEstadoauditoria("1");
		return observacionesdocumentotecnicoMapper.selectDynamicFull(record);
	}

	@Override
	public List<Observacionesdocumentotecnico> selectDynamicExtended(Observacionesdocumentotecnico record) throws Exception {
		return observacionesdocumentotecnicoMapper.selectDynamicExtended(record);
	}

	@Override
	public List<Observacionesdocumentotecnico> selectDynamicExtendedActives(Observacionesdocumentotecnico record) throws Exception {
		record.setEstadoauditoria("1");
		return observacionesdocumentotecnicoMapper.selectDynamicExtended(record);
	}

	@Override
	public void updateByPrimaryKeySelectiveBasic(Observacionesdocumentotecnico record) throws Exception {
		record.setFechamodificacionauditoria(Utils.currentTimeStamp());
		updateBooleanToChar(record);
		Utils.convertPropertiesStringToUppercase(record);
		observacionesdocumentotecnicoMapper.updateByPrimaryKeySelective(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void updateByPrimaryKeySelectiveFull(Observacionesdocumentotecnico record) throws Exception {
		//Business Logic
		updateByPrimaryKeySelectiveBasic(record);
	}

	@Override
	public void updateByPrimaryKeyBasic(Observacionesdocumentotecnico record) throws Exception {
		record.setFechamodificacionauditoria(Utils.currentTimeStamp());
		updateBooleanToChar(record);
		validateUpdate(record);
		Utils.convertPropertiesStringToUppercase(record);
		observacionesdocumentotecnicoMapper.updateByPrimaryKey(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void updateByPrimaryKeyFull(Observacionesdocumentotecnico record) throws Exception {
		//Business Logic
		updateByPrimaryKeyBasic(record);
	}

	public void updateBooleanToChar(Observacionesdocumentotecnico record) throws Exception {
	}

	public void validateInsert(Observacionesdocumentotecnico record)throws Exception{
		if(record.getIdobservacionesdocumentotecnico()==null)
			throw new ValidateException(Messages.getString("observacionesdocumentotecnico.idobservacionesdocumentotecnico.required"));

		if(record.getObservacion()!=null &&  record.getObservacion().length() > 500)
			throw new ValidateException(Messages.getString("observacionesdocumentotecnico.observacion.length.error",record.getObservacion().length()));
		if(record.getUsuariocreacionauditoria()!=null &&  record.getUsuariocreacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("observacionesdocumentotecnico.usuariocreacionauditoria.length.error",record.getUsuariocreacionauditoria().length()));
		if(record.getUsuariomodificacionauditoria()!=null &&  record.getUsuariomodificacionauditoria().length() > 20)
			throw new ValidateException(Messages.getString("observacionesdocumentotecnico.usuariomodificacionauditoria.length.error",record.getUsuariomodificacionauditoria().length()));
		if(record.getEquipoauditoria()!=null &&  record.getEquipoauditoria().length() > 45)
			throw new ValidateException(Messages.getString("observacionesdocumentotecnico.equipoauditoria.length.error",record.getEquipoauditoria().length()));
		if(record.getProgramaauditoria()!=null &&  record.getProgramaauditoria().length() > 200)
			throw new ValidateException(Messages.getString("observacionesdocumentotecnico.programaauditoria.length.error",record.getProgramaauditoria().length()));
		if(record.getEstadoauditoria()!=null &&  record.getEstadoauditoria().length() > 1)
			throw new ValidateException(Messages.getString("observacionesdocumentotecnico.estadoauditoria.length.error",record.getEstadoauditoria().length()));

		//Here Bussines Validations.
	}

	public void validateUpdate(Observacionesdocumentotecnico record)throws Exception{
		if(record.getIdobservacionesdocumentotecnico()==null)
			throw new ValidateException(Messages.getString("observacionesdocumentotecnico.idobservacionesdocumentotecnico.required"));

		if(record.getObservacion()!=null &&  record.getObservacion().length() > 500)
			throw new ValidateException(Messages.getString("observacionesdocumentotecnico.observacion.length.error",record.getObservacion().length()));
		if(record.getUsuariocreacionauditoria()!=null &&  record.getUsuariocreacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("observacionesdocumentotecnico.usuariocreacionauditoria.length.error",record.getUsuariocreacionauditoria().length()));
		if(record.getUsuariomodificacionauditoria()!=null &&  record.getUsuariomodificacionauditoria().length() > 20)
			throw new ValidateException(Messages.getString("observacionesdocumentotecnico.usuariomodificacionauditoria.length.error",record.getUsuariomodificacionauditoria().length()));
		if(record.getEquipoauditoria()!=null &&  record.getEquipoauditoria().length() > 45)
			throw new ValidateException(Messages.getString("observacionesdocumentotecnico.equipoauditoria.length.error",record.getEquipoauditoria().length()));
		if(record.getProgramaauditoria()!=null &&  record.getProgramaauditoria().length() > 200)
			throw new ValidateException(Messages.getString("observacionesdocumentotecnico.programaauditoria.length.error",record.getProgramaauditoria().length()));
		if(record.getEstadoauditoria()!=null &&  record.getEstadoauditoria().length() > 1)
			throw new ValidateException(Messages.getString("observacionesdocumentotecnico.estadoauditoria.length.error",record.getEstadoauditoria().length()));

		//Here Bussines Validations.
	}

	public void validateDelete(java.lang.Integer par_idobservacionesdocumentotecnico)throws Exception{
		if(par_idobservacionesdocumentotecnico==null)
			throw new ValidateException(Messages.getString("observacionesdocumentotecnico.idobservacionesdocumentotecnico.required"));

		//Here Bussines Validations.
	}


}

