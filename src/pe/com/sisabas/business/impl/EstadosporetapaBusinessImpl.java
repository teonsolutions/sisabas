
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
import pe.com.sisabas.be.Estadosporetapa;
import pe.com.sisabas.persistence.EstadosporetapaMapper;
import pe.com.sisabas.business.EstadosporetapaBusiness;
import pe.com.sisabas.exception.BusinessException;
import pe.com.sisabas.exception.ValidateException;
import pe.com.sisabas.resources.Constantes;
import pe.com.sisabas.resources.Messages;
import pe.com.sisabas.resources.Sequence;
import pe.com.sisabas.resources.Utils;
import pe.com.sisabas.resources.business.UtilsBusiness;


@Service
public class EstadosporetapaBusinessImpl implements EstadosporetapaBusiness, Serializable{

	private static Logger logger=Logger.getLogger(EstadosporetapaBusinessImpl.class);

	private static final long serialVersionUID = 1L;

	@Autowired
	public EstadosporetapaMapper estadosporetapaMapper;

	@Autowired
	public UtilsBusiness utilsBusiness;

	@Override
	public void deleteByPrimaryKeyBasic(Estadosporetapa par_record) throws Exception {
		validateDelete(par_record.getIdestadoporetapa());
		estadosporetapaMapper.deleteByPrimaryKey(par_record.getIdestadoporetapa());
	}

	@Override
	public void insertBasic(Estadosporetapa record) throws Exception {
		record.setIdestadoporetapa((int)utilsBusiness.getNextSeq(Sequence.SEQ_ESTADOSPORETAPA).longValue());
		record.setFechacreacionauditoria(Utils.currentTimeStamp());
		record.setEstadoauditoria("1");
		updateBooleanToChar(record);
		validateInsert(record);
		Utils.convertPropertiesStringToUppercase(record);
		estadosporetapaMapper.insert(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void insertFull(Estadosporetapa record) throws Exception {
		//Business Logic
		insertBasic(record);
	}

	@Override
	public void insertSelectiveBasic(Estadosporetapa record) throws Exception {
		record.setIdestadoporetapa((int)utilsBusiness.getNextSeq(Sequence.SEQ_ESTADOSPORETAPA).longValue());
		record.setFechacreacionauditoria(Utils.currentTimeStamp());
		record.setEstadoauditoria("1");
		updateBooleanToChar(record);
		Utils.convertPropertiesStringToUppercase(record);
		estadosporetapaMapper.insertSelective(record);
	}

	@Override
	public Estadosporetapa selectByPrimaryKeyBasic(java.lang.Integer par_idestadoporetapa) throws Exception {
		return estadosporetapaMapper.selectByPrimaryKeyBasic(par_idestadoporetapa);
	}

	@Override
	public Estadosporetapa selectByPrimaryKeyBasicFromList(java.lang.Integer par_idestadoporetapa, List<Estadosporetapa> list) throws Exception {
		Estadosporetapa record=null;
		for (Estadosporetapa row : list) {
			if(row.equals(new Estadosporetapa( par_idestadoporetapa))){
				record=row;
				break;
			}
		}
		if(record==null)
			record=selectByPrimaryKeyBasic( par_idestadoporetapa);

		return record;
	}

	@Override
	public Estadosporetapa selectByPrimaryKeyBasicActive(java.lang.Integer par_idestadoporetapa) throws Exception {
		return estadosporetapaMapper.selectByPrimaryKeyBasicActive(par_idestadoporetapa);
	}

	@Override
	public Estadosporetapa selectByPrimaryKeyFull(java.lang.Integer par_idestadoporetapa) throws Exception {
		return estadosporetapaMapper.selectByPrimaryKeyFull(par_idestadoporetapa);
	}

	@Override
	public Estadosporetapa selectByPrimaryKeyFullActive(java.lang.Integer par_idestadoporetapa) throws Exception {
		return estadosporetapaMapper.selectByPrimaryKeyFullActive(par_idestadoporetapa);
	}

	@Override
	public List<Estadosporetapa> selectDynamicBasic(Estadosporetapa record) throws Exception {
		return estadosporetapaMapper.selectDynamicBasic(record);
	}

	@Override
	public List<Estadosporetapa> selectDynamicBasicActives(Estadosporetapa record) throws Exception {
		record.setEstadoauditoria("1");
		return estadosporetapaMapper.selectDynamicBasic(record);
	}

	@Override
	public List<Estadosporetapa> selectDynamicFull(Estadosporetapa record) throws Exception {
		List<Estadosporetapa> list=estadosporetapaMapper.selectDynamicFull(record);
		if(Estadosporetapa.HAVE_BIGDECIMALS)
		for (Estadosporetapa row : list) {
			row.roundBigDecimals();
		}

		return list;
	}

	@Override
	public List<Estadosporetapa> selectDynamicFullActives(Estadosporetapa record) throws Exception {
		record.setEstadoauditoria("1");
		return estadosporetapaMapper.selectDynamicFull(record);
	}

	@Override
	public List<Estadosporetapa> selectDynamicExtended(Estadosporetapa record) throws Exception {
		return estadosporetapaMapper.selectDynamicExtended(record);
	}

	@Override
	public List<Estadosporetapa> selectDynamicExtendedActives(Estadosporetapa record) throws Exception {
		record.setEstadoauditoria("1");
		return estadosporetapaMapper.selectDynamicExtended(record);
	}

	@Override
	public void updateByPrimaryKeySelectiveBasic(Estadosporetapa record) throws Exception {
		record.setFechamodificacionauditoria(Utils.currentTimeStamp());
		updateBooleanToChar(record);
		Utils.convertPropertiesStringToUppercase(record);
		estadosporetapaMapper.updateByPrimaryKeySelective(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void updateByPrimaryKeySelectiveFull(Estadosporetapa record) throws Exception {
		//Business Logic
		updateByPrimaryKeySelectiveBasic(record);
	}

	@Override
	public void updateByPrimaryKeyBasic(Estadosporetapa record) throws Exception {
		record.setFechamodificacionauditoria(Utils.currentTimeStamp());
		updateBooleanToChar(record);
		validateUpdate(record);
		Utils.convertPropertiesStringToUppercase(record);
		estadosporetapaMapper.updateByPrimaryKey(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void updateByPrimaryKeyFull(Estadosporetapa record) throws Exception {
		//Business Logic
		updateByPrimaryKeyBasic(record);
	}

	public void updateBooleanToChar(Estadosporetapa record) throws Exception {
		if(record.getBooleanestadoauditoria()!=null && record.getBooleanestadoauditoria()){
			record.setEstadoauditoria("1");
		}else{
			record.setEstadoauditoria("0");
		}

	}

	public void validateInsert(Estadosporetapa record)throws Exception{
		if(record.getIdestadoporetapa()==null)
			throw new ValidateException(Messages.getString("estadosporetapa.idestadoporetapa.required"));

		if(record.getDescripcionestadoporetapa()!=null &&  record.getDescripcionestadoporetapa().length() > 150)
			throw new ValidateException(Messages.getString("estadosporetapa.descripcionestadoporetapa.length.error",record.getDescripcionestadoporetapa().length()));
		if(record.getEstadoauditoria()!=null &&  record.getEstadoauditoria().length() > 1)
			throw new ValidateException(Messages.getString("estadosporetapa.estadoauditoria.length.error",record.getEstadoauditoria().length()));
		if(record.getUsuariocreacionauditoria()!=null &&  record.getUsuariocreacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("estadosporetapa.usuariocreacionauditoria.length.error",record.getUsuariocreacionauditoria().length()));
		if(record.getUsuariomodificacionauditoria()!=null &&  record.getUsuariomodificacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("estadosporetapa.usuariomodificacionauditoria.length.error",record.getUsuariomodificacionauditoria().length()));
		if(record.getEquipoauditoria()!=null &&  record.getEquipoauditoria().length() > 45)
			throw new ValidateException(Messages.getString("estadosporetapa.equipoauditoria.length.error",record.getEquipoauditoria().length()));
		if(record.getProgramaauditoria()!=null &&  record.getProgramaauditoria().length() > 200)
			throw new ValidateException(Messages.getString("estadosporetapa.programaauditoria.length.error",record.getProgramaauditoria().length()));

		//Here Bussines Validations.
	}

	public void validateUpdate(Estadosporetapa record)throws Exception{
		if(record.getIdestadoporetapa()==null)
			throw new ValidateException(Messages.getString("estadosporetapa.idestadoporetapa.required"));

		if(record.getDescripcionestadoporetapa()!=null &&  record.getDescripcionestadoporetapa().length() > 150)
			throw new ValidateException(Messages.getString("estadosporetapa.descripcionestadoporetapa.length.error",record.getDescripcionestadoporetapa().length()));
		if(record.getEstadoauditoria()!=null &&  record.getEstadoauditoria().length() > 1)
			throw new ValidateException(Messages.getString("estadosporetapa.estadoauditoria.length.error",record.getEstadoauditoria().length()));
		if(record.getUsuariocreacionauditoria()!=null &&  record.getUsuariocreacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("estadosporetapa.usuariocreacionauditoria.length.error",record.getUsuariocreacionauditoria().length()));
		if(record.getUsuariomodificacionauditoria()!=null &&  record.getUsuariomodificacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("estadosporetapa.usuariomodificacionauditoria.length.error",record.getUsuariomodificacionauditoria().length()));
		if(record.getEquipoauditoria()!=null &&  record.getEquipoauditoria().length() > 45)
			throw new ValidateException(Messages.getString("estadosporetapa.equipoauditoria.length.error",record.getEquipoauditoria().length()));
		if(record.getProgramaauditoria()!=null &&  record.getProgramaauditoria().length() > 200)
			throw new ValidateException(Messages.getString("estadosporetapa.programaauditoria.length.error",record.getProgramaauditoria().length()));

		//Here Bussines Validations.
	}

	public void validateDelete(java.lang.Integer par_idestadoporetapa)throws Exception{
		if(par_idestadoporetapa==null)
			throw new ValidateException(Messages.getString("estadosporetapa.idestadoporetapa.required"));

		//Here Bussines Validations.
	}


}

