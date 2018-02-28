
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
import pe.com.sisabas.be.Entregable;
import pe.com.sisabas.persistence.EntregableMapper;
import pe.com.sisabas.business.EntregableBusiness;
import pe.com.sisabas.exception.BusinessException;
import pe.com.sisabas.exception.ValidateException;
import pe.com.sisabas.resources.Constantes;
import pe.com.sisabas.resources.Messages;
import pe.com.sisabas.resources.Sequence;
import pe.com.sisabas.resources.Utils;
import pe.com.sisabas.resources.business.UtilsBusiness;


@Service
public class EntregableBusinessImpl implements EntregableBusiness, Serializable{

	private static Logger logger=Logger.getLogger(EntregableBusinessImpl.class);

	private static final long serialVersionUID = 1L;

	@Autowired
	public EntregableMapper entregableMapper;

	@Autowired
	public UtilsBusiness utilsBusiness;

	@Override
	public void deleteByPrimaryKeyBasic(Entregable par_record) throws Exception {
		validateDelete(par_record.getIdentregable());
		entregableMapper.deleteByPrimaryKey(par_record.getIdentregable());
	}

	@Override
	public void insertBasic(Entregable record) throws Exception {
		record.setIdentregable((int)utilsBusiness.getNextSeq(Sequence.SEQ_ENTREGABLE).longValue());
		record.setFechacreacionauditoria(Utils.currentTimeStamp());
		record.setEstadoauditoria("1");
		updateBooleanToChar(record);
		validateInsert(record);
		Utils.convertPropertiesStringToUppercase(record);
		entregableMapper.insert(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void insertFull(Entregable record) throws Exception {
		//Business Logic
		insertBasic(record);
	}

	@Override
	public void insertSelectiveBasic(Entregable record) throws Exception {
		record.setIdentregable((int)utilsBusiness.getNextSeq(Sequence.SEQ_ENTREGABLE).longValue());
		record.setFechacreacionauditoria(Utils.currentTimeStamp());
		record.setEstadoauditoria("1");
		updateBooleanToChar(record);
		Utils.convertPropertiesStringToUppercase(record);
		entregableMapper.insertSelective(record);
	}

	@Override
	public Entregable selectByPrimaryKeyBasic(java.lang.Integer par_identregable) throws Exception {
		return entregableMapper.selectByPrimaryKeyBasic(par_identregable);
	}

	@Override
	public Entregable selectByPrimaryKeyBasicFromList(java.lang.Integer par_identregable, List<Entregable> list) throws Exception {
		Entregable record=null;
		for (Entregable row : list) {
			if(row.equals(new Entregable( par_identregable))){
				record=row;
				break;
			}
		}
		if(record==null)
			record=selectByPrimaryKeyBasic( par_identregable);

		return record;
	}

	@Override
	public Entregable selectByPrimaryKeyBasicActive(java.lang.Integer par_identregable) throws Exception {
		return entregableMapper.selectByPrimaryKeyBasicActive(par_identregable);
	}

	@Override
	public Entregable selectByPrimaryKeyFull(java.lang.Integer par_identregable) throws Exception {
		return entregableMapper.selectByPrimaryKeyFull(par_identregable);
	}

	@Override
	public Entregable selectByPrimaryKeyFullActive(java.lang.Integer par_identregable) throws Exception {
		return entregableMapper.selectByPrimaryKeyFullActive(par_identregable);
	}

	@Override
	public List<Entregable> selectDynamicBasic(Entregable record) throws Exception {
		return entregableMapper.selectDynamicBasic(record);
	}

	@Override
	public List<Entregable> selectDynamicBasicActives(Entregable record) throws Exception {
		record.setEstadoauditoria("1");
		return entregableMapper.selectDynamicBasic(record);
	}

	@Override
	public List<Entregable> selectDynamicFull(Entregable record) throws Exception {
		List<Entregable> list=entregableMapper.selectDynamicFull(record);
		if(Entregable.HAVE_BIGDECIMALS)
		for (Entregable row : list) {
			row.roundBigDecimals();
		}

		return list;
	}

	@Override
	public List<Entregable> selectDynamicFullActives(Entregable record) throws Exception {
		record.setEstadoauditoria("1");
		return entregableMapper.selectDynamicFull(record);
	}

	@Override
	public List<Entregable> selectDynamicExtended(Entregable record) throws Exception {
		return entregableMapper.selectDynamicExtended(record);
	}

	@Override
	public List<Entregable> selectDynamicExtendedActives(Entregable record) throws Exception {
		record.setEstadoauditoria("1");
		return entregableMapper.selectDynamicExtended(record);
	}

	@Override
	public void updateByPrimaryKeySelectiveBasic(Entregable record) throws Exception {
		record.setFechamodificacionauditoria(Utils.currentTimeStamp());
		updateBooleanToChar(record);
		Utils.convertPropertiesStringToUppercase(record);
		entregableMapper.updateByPrimaryKeySelective(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void updateByPrimaryKeySelectiveFull(Entregable record) throws Exception {
		//Business Logic
		updateByPrimaryKeySelectiveBasic(record);
	}

	@Override
	public void updateByPrimaryKeyBasic(Entregable record) throws Exception {
		record.setFechamodificacionauditoria(Utils.currentTimeStamp());
		updateBooleanToChar(record);
		validateUpdate(record);
		Utils.convertPropertiesStringToUppercase(record);
		entregableMapper.updateByPrimaryKey(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void updateByPrimaryKeyFull(Entregable record) throws Exception {
		//Business Logic
		updateByPrimaryKeyBasic(record);
	}

	public void updateBooleanToChar(Entregable record) throws Exception {
	}

	public void validateInsert(Entregable record)throws Exception{
		if(record.getIdentregable()==null)
			throw new ValidateException(Messages.getString("entregable.identregable.required"));
		if(record.getIdgrupodocumento()==null)
			throw new ValidateException(Messages.getString("entregable.idgrupodocumento.required"));

		if(record.getNroproveido()!=null &&  record.getNroproveido().length() > 10)
			throw new ValidateException(Messages.getString("entregable.nroproveido.length.error",record.getNroproveido().length()));
		if(record.getNroentregable()!=null &&  record.getNroentregable().length() > 15)
			throw new ValidateException(Messages.getString("entregable.nroentregable.length.error",record.getNroentregable().length()));
		if(record.getPlazoentregable()!=null &&  record.getPlazoentregable().length() > 4)
			throw new ValidateException(Messages.getString("entregable.plazoentregable.length.error",record.getPlazoentregable().length()));
		if(record.getObservacionesentregable()!=null &&  record.getObservacionesentregable().length() > 500)
			throw new ValidateException(Messages.getString("entregable.observacionesentregable.length.error",record.getObservacionesentregable().length()));
		if(record.getIdcatalogoestadoentregable()!=null &&  record.getIdcatalogoestadoentregable().length() > 10)
			throw new ValidateException(Messages.getString("entregable.idcatalogoestadoentregable.length.error",record.getIdcatalogoestadoentregable().length()));
		if(record.getUsuariocreacionauditoria()!=null &&  record.getUsuariocreacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("entregable.usuariocreacionauditoria.length.error",record.getUsuariocreacionauditoria().length()));
		if(record.getUsuariomodificacionauditoria()!=null &&  record.getUsuariomodificacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("entregable.usuariomodificacionauditoria.length.error",record.getUsuariomodificacionauditoria().length()));
		if(record.getEquipoauditoria()!=null &&  record.getEquipoauditoria().length() > 45)
			throw new ValidateException(Messages.getString("entregable.equipoauditoria.length.error",record.getEquipoauditoria().length()));
		if(record.getProgramaauditoria()!=null &&  record.getProgramaauditoria().length() > 200)
			throw new ValidateException(Messages.getString("entregable.programaauditoria.length.error",record.getProgramaauditoria().length()));
		if(record.getEstadoauditoria()!=null &&  record.getEstadoauditoria().length() > 1)
			throw new ValidateException(Messages.getString("entregable.estadoauditoria.length.error",record.getEstadoauditoria().length()));

		//Here Bussines Validations.
	}

	public void validateUpdate(Entregable record)throws Exception{
		if(record.getIdentregable()==null)
			throw new ValidateException(Messages.getString("entregable.identregable.required"));
		if(record.getIdgrupodocumento()==null)
			throw new ValidateException(Messages.getString("entregable.idgrupodocumento.required"));

		if(record.getNroproveido()!=null &&  record.getNroproveido().length() > 10)
			throw new ValidateException(Messages.getString("entregable.nroproveido.length.error",record.getNroproveido().length()));
		if(record.getNroentregable()!=null &&  record.getNroentregable().length() > 15)
			throw new ValidateException(Messages.getString("entregable.nroentregable.length.error",record.getNroentregable().length()));
		if(record.getPlazoentregable()!=null &&  record.getPlazoentregable().length() > 4)
			throw new ValidateException(Messages.getString("entregable.plazoentregable.length.error",record.getPlazoentregable().length()));
		if(record.getObservacionesentregable()!=null &&  record.getObservacionesentregable().length() > 500)
			throw new ValidateException(Messages.getString("entregable.observacionesentregable.length.error",record.getObservacionesentregable().length()));
		if(record.getIdcatalogoestadoentregable()!=null &&  record.getIdcatalogoestadoentregable().length() > 10)
			throw new ValidateException(Messages.getString("entregable.idcatalogoestadoentregable.length.error",record.getIdcatalogoestadoentregable().length()));
		if(record.getUsuariocreacionauditoria()!=null &&  record.getUsuariocreacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("entregable.usuariocreacionauditoria.length.error",record.getUsuariocreacionauditoria().length()));
		if(record.getUsuariomodificacionauditoria()!=null &&  record.getUsuariomodificacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("entregable.usuariomodificacionauditoria.length.error",record.getUsuariomodificacionauditoria().length()));
		if(record.getEquipoauditoria()!=null &&  record.getEquipoauditoria().length() > 45)
			throw new ValidateException(Messages.getString("entregable.equipoauditoria.length.error",record.getEquipoauditoria().length()));
		if(record.getProgramaauditoria()!=null &&  record.getProgramaauditoria().length() > 200)
			throw new ValidateException(Messages.getString("entregable.programaauditoria.length.error",record.getProgramaauditoria().length()));
		if(record.getEstadoauditoria()!=null &&  record.getEstadoauditoria().length() > 1)
			throw new ValidateException(Messages.getString("entregable.estadoauditoria.length.error",record.getEstadoauditoria().length()));

		//Here Bussines Validations.
	}

	public void validateDelete(java.lang.Integer par_identregable)throws Exception{
		if(par_identregable==null)
			throw new ValidateException(Messages.getString("entregable.identregable.required"));

		//Here Bussines Validations.
	}

	@Override
	public List<Entregable> getEntegablesByOrden(Integer par_idorden) throws Exception {
		return entregableMapper.getEntegablesByOrden(par_idorden);
		
	}


}

