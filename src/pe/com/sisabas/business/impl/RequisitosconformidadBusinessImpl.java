
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
import pe.com.sisabas.be.Requisitosconformidad;
import pe.com.sisabas.persistence.RequisitosconformidadMapper;
import pe.com.sisabas.business.RequisitosconformidadBusiness;
import pe.com.sisabas.exception.BusinessException;
import pe.com.sisabas.exception.ValidateException;
import pe.com.sisabas.resources.Constantes;
import pe.com.sisabas.resources.Messages;
import pe.com.sisabas.resources.Sequence;
import pe.com.sisabas.resources.Utils;
import pe.com.sisabas.resources.business.UtilsBusiness;


@Service
public class RequisitosconformidadBusinessImpl implements RequisitosconformidadBusiness, Serializable{

	private static Logger logger=Logger.getLogger(RequisitosconformidadBusinessImpl.class);

	private static final long serialVersionUID = 1L;

	@Autowired
	public RequisitosconformidadMapper requisitosconformidadMapper;

	@Autowired
	public UtilsBusiness utilsBusiness;

	@Override
	public void deleteByPrimaryKeyBasic(Requisitosconformidad par_record) throws Exception {
		validateDelete(par_record.getIdrequisitoconformidad());
		requisitosconformidadMapper.deleteByPrimaryKey(par_record.getIdrequisitoconformidad());
	}

	@Override
	public void insertBasic(Requisitosconformidad record) throws Exception {
		record.setIdrequisitoconformidad((int)utilsBusiness.getNextSeq(Sequence.SEQ_REQUISITOSCONFORMIDAD).longValue());
		record.setFechacreacionauditoria(Utils.currentTimeStamp());
		record.setEstadoauditoria("1");
		updateBooleanToChar(record);
		validateInsert(record);
		Utils.convertPropertiesStringToUppercase(record);
		requisitosconformidadMapper.insert(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void insertFull(Requisitosconformidad record) throws Exception {
		//Business Logic
		insertBasic(record);
	}

	@Override
	public void insertSelectiveBasic(Requisitosconformidad record) throws Exception {
		record.setIdrequisitoconformidad((int)utilsBusiness.getNextSeq(Sequence.SEQ_REQUISITOSCONFORMIDAD).longValue());
		record.setFechacreacionauditoria(Utils.currentTimeStamp());
		record.setEstadoauditoria("1");
		updateBooleanToChar(record);
		Utils.convertPropertiesStringToUppercase(record);
		requisitosconformidadMapper.insertSelective(record);
	}

	@Override
	public Requisitosconformidad selectByPrimaryKeyBasic(java.lang.Integer par_idrequisitoconformidad) throws Exception {
		return requisitosconformidadMapper.selectByPrimaryKeyBasic(par_idrequisitoconformidad);
	}

	@Override
	public Requisitosconformidad selectByPrimaryKeyBasicFromList(java.lang.Integer par_idrequisitoconformidad, List<Requisitosconformidad> list) throws Exception {
		Requisitosconformidad record=null;
		for (Requisitosconformidad row : list) {
			if(row.equals(new Requisitosconformidad( par_idrequisitoconformidad))){
				record=row;
				break;
			}
		}
		if(record==null)
			record=selectByPrimaryKeyBasic( par_idrequisitoconformidad);

		return record;
	}

	@Override
	public Requisitosconformidad selectByPrimaryKeyBasicActive(java.lang.Integer par_idrequisitoconformidad) throws Exception {
		return requisitosconformidadMapper.selectByPrimaryKeyBasicActive(par_idrequisitoconformidad);
	}

	@Override
	public Requisitosconformidad selectByPrimaryKeyFull(java.lang.Integer par_idrequisitoconformidad) throws Exception {
		return requisitosconformidadMapper.selectByPrimaryKeyFull(par_idrequisitoconformidad);
	}

	@Override
	public Requisitosconformidad selectByPrimaryKeyFullActive(java.lang.Integer par_idrequisitoconformidad) throws Exception {
		return requisitosconformidadMapper.selectByPrimaryKeyFullActive(par_idrequisitoconformidad);
	}

	@Override
	public List<Requisitosconformidad> selectDynamicBasic(Requisitosconformidad record) throws Exception {
		return requisitosconformidadMapper.selectDynamicBasic(record);
	}

	@Override
	public List<Requisitosconformidad> selectDynamicBasicActives(Requisitosconformidad record) throws Exception {
		record.setEstadoauditoria("1");
		return requisitosconformidadMapper.selectDynamicBasic(record);
	}

	@Override
	public List<Requisitosconformidad> selectDynamicFull(Requisitosconformidad record) throws Exception {
		List<Requisitosconformidad> list=requisitosconformidadMapper.selectDynamicFull(record);
		if(Requisitosconformidad.HAVE_BIGDECIMALS)
		for (Requisitosconformidad row : list) {
			row.roundBigDecimals();
		}

		return list;
	}

	@Override
	public List<Requisitosconformidad> selectDynamicFullActives(Requisitosconformidad record) throws Exception {
		record.setEstadoauditoria("1");
		return requisitosconformidadMapper.selectDynamicFull(record);
	}

	@Override
	public List<Requisitosconformidad> selectDynamicExtended(Requisitosconformidad record) throws Exception {
		return requisitosconformidadMapper.selectDynamicExtended(record);
	}

	@Override
	public List<Requisitosconformidad> selectDynamicExtendedActives(Requisitosconformidad record) throws Exception {
		record.setEstadoauditoria("1");
		return requisitosconformidadMapper.selectDynamicExtended(record);
	}

	@Override
	public void updateByPrimaryKeySelectiveBasic(Requisitosconformidad record) throws Exception {
		record.setFechamodificacionauditoria(Utils.currentTimeStamp());
		updateBooleanToChar(record);
		Utils.convertPropertiesStringToUppercase(record);
		requisitosconformidadMapper.updateByPrimaryKeySelective(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void updateByPrimaryKeySelectiveFull(Requisitosconformidad record) throws Exception {
		//Business Logic
		updateByPrimaryKeySelectiveBasic(record);
	}

	@Override
	public void updateByPrimaryKeyBasic(Requisitosconformidad record) throws Exception {
		record.setFechamodificacionauditoria(Utils.currentTimeStamp());
		updateBooleanToChar(record);
		validateUpdate(record);
		Utils.convertPropertiesStringToUppercase(record);
		requisitosconformidadMapper.updateByPrimaryKey(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void updateByPrimaryKeyFull(Requisitosconformidad record) throws Exception {
		//Business Logic
		updateByPrimaryKeyBasic(record);
	}

	public void updateBooleanToChar(Requisitosconformidad record) throws Exception {
	}

	public void validateInsert(Requisitosconformidad record)throws Exception{
		if(record.getIdrequisitoconformidad()==null)
			throw new ValidateException(Messages.getString("requisitosconformidad.idrequisitoconformidad.required"));
		if(record.getEquipoauditoria()==null)
			throw new ValidateException(Messages.getString("requisitosconformidad.equipoauditoria.required"));

		if(record.getRutaarchivo()!=null &&  record.getRutaarchivo().length() > 300)
			throw new ValidateException(Messages.getString("requisitosconformidad.rutaarchivo.length.error",record.getRutaarchivo().length()));
		if(record.getUsuariocreacionauditoria()!=null &&  record.getUsuariocreacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("requisitosconformidad.usuariocreacionauditoria.length.error",record.getUsuariocreacionauditoria().length()));
		if(record.getUsuariomodificacionauditoria()!=null &&  record.getUsuariomodificacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("requisitosconformidad.usuariomodificacionauditoria.length.error",record.getUsuariomodificacionauditoria().length()));
		if(record.getEquipoauditoria()!=null &&  record.getEquipoauditoria().length() > 45)
			throw new ValidateException(Messages.getString("requisitosconformidad.equipoauditoria.length.error",record.getEquipoauditoria().length()));
		if(record.getProgramaauditoria()!=null &&  record.getProgramaauditoria().length() > 200)
			throw new ValidateException(Messages.getString("requisitosconformidad.programaauditoria.length.error",record.getProgramaauditoria().length()));
		if(record.getEstadoauditoria()!=null &&  record.getEstadoauditoria().length() > 1)
			throw new ValidateException(Messages.getString("requisitosconformidad.estadoauditoria.length.error",record.getEstadoauditoria().length()));

		//Here Bussines Validations.
	}

	public void validateUpdate(Requisitosconformidad record)throws Exception{
		if(record.getIdrequisitoconformidad()==null)
			throw new ValidateException(Messages.getString("requisitosconformidad.idrequisitoconformidad.required"));
		if(record.getEquipoauditoria()==null)
			throw new ValidateException(Messages.getString("requisitosconformidad.equipoauditoria.required"));

		if(record.getRutaarchivo()!=null &&  record.getRutaarchivo().length() > 300)
			throw new ValidateException(Messages.getString("requisitosconformidad.rutaarchivo.length.error",record.getRutaarchivo().length()));
		if(record.getUsuariocreacionauditoria()!=null &&  record.getUsuariocreacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("requisitosconformidad.usuariocreacionauditoria.length.error",record.getUsuariocreacionauditoria().length()));
		if(record.getUsuariomodificacionauditoria()!=null &&  record.getUsuariomodificacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("requisitosconformidad.usuariomodificacionauditoria.length.error",record.getUsuariomodificacionauditoria().length()));
		if(record.getEquipoauditoria()!=null &&  record.getEquipoauditoria().length() > 45)
			throw new ValidateException(Messages.getString("requisitosconformidad.equipoauditoria.length.error",record.getEquipoauditoria().length()));
		if(record.getProgramaauditoria()!=null &&  record.getProgramaauditoria().length() > 200)
			throw new ValidateException(Messages.getString("requisitosconformidad.programaauditoria.length.error",record.getProgramaauditoria().length()));
		if(record.getEstadoauditoria()!=null &&  record.getEstadoauditoria().length() > 1)
			throw new ValidateException(Messages.getString("requisitosconformidad.estadoauditoria.length.error",record.getEstadoauditoria().length()));

		//Here Bussines Validations.
	}

	public void validateDelete(java.lang.Integer par_idrequisitoconformidad)throws Exception{
		if(par_idrequisitoconformidad==null)
			throw new ValidateException(Messages.getString("requisitosconformidad.idrequisitoconformidad.required"));

		//Here Bussines Validations.
	}


}

