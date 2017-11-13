
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
import pe.com.sisabas.be.Vcertificacion;
import pe.com.sisabas.persistence.VcertificacionMapper;
import pe.com.sisabas.business.VcertificacionBusiness;
import pe.com.sisabas.exception.BusinessException;
import pe.com.sisabas.exception.ValidateException;
import pe.com.sisabas.resources.Constantes;
import pe.com.sisabas.resources.Messages;
import pe.com.sisabas.resources.Sequence;
import pe.com.sisabas.resources.Utils;
import pe.com.sisabas.resources.business.UtilsBusiness;


@Service
public class VcertificacionBusinessImpl implements VcertificacionBusiness, Serializable{

	private static Logger logger=Logger.getLogger(VcertificacionBusinessImpl.class);

	private static final long serialVersionUID = 1L;

	@Autowired
	public VcertificacionMapper vcertificacionMapper;

	@Autowired
	public UtilsBusiness utilsBusiness;

	@Override
	public void deleteByPrimaryKeyBasic(Vcertificacion par_record) throws Exception {
		validateDelete(par_record.getVcertificacion());
		vcertificacionMapper.deleteByPrimaryKey(par_record.getVcertificacion());
	}

	@Override
	public void insertBasic(Vcertificacion record) throws Exception {
		record.setVcertificacion((int)utilsBusiness.getNextSeq(Sequence.SEQ_VCERTIFICACION).longValue());
		record.setFechacreacionauditoria(Utils.currentTimeStamp());
		record.setEstadoauditoria("1");
		updateBooleanToChar(record);
		validateInsert(record);
		Utils.convertPropertiesStringToUppercase(record);
		vcertificacionMapper.insert(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void insertFull(Vcertificacion record) throws Exception {
		//Business Logic
		insertBasic(record);
	}

	@Override
	public void insertSelectiveBasic(Vcertificacion record) throws Exception {
		record.setVcertificacion((int)utilsBusiness.getNextSeq(Sequence.SEQ_VCERTIFICACION).longValue());
		record.setFechacreacionauditoria(Utils.currentTimeStamp());
		record.setEstadoauditoria("1");
		updateBooleanToChar(record);
		Utils.convertPropertiesStringToUppercase(record);
		vcertificacionMapper.insertSelective(record);
	}

	@Override
	public Vcertificacion selectByPrimaryKeyBasic(java.lang.Integer par_vcertificacion) throws Exception {
		return vcertificacionMapper.selectByPrimaryKeyBasic(par_vcertificacion);
	}

	@Override
	public Vcertificacion selectByPrimaryKeyBasicFromList(java.lang.Integer par_vcertificacion, List<Vcertificacion> list) throws Exception {
		Vcertificacion record=null;
		for (Vcertificacion row : list) {
			if(row.equals(new Vcertificacion( par_vcertificacion))){
				record=row;
				break;
			}
		}
		if(record==null)
			record=selectByPrimaryKeyBasic( par_vcertificacion);

		return record;
	}

	@Override
	public Vcertificacion selectByPrimaryKeyBasicActive(java.lang.Integer par_vcertificacion) throws Exception {
		return vcertificacionMapper.selectByPrimaryKeyBasicActive(par_vcertificacion);
	}

	@Override
	public Vcertificacion selectByPrimaryKeyFull(java.lang.Integer par_vcertificacion) throws Exception {
		return vcertificacionMapper.selectByPrimaryKeyFull(par_vcertificacion);
	}

	@Override
	public Vcertificacion selectByPrimaryKeyFullActive(java.lang.Integer par_vcertificacion) throws Exception {
		return vcertificacionMapper.selectByPrimaryKeyFullActive(par_vcertificacion);
	}

	@Override
	public List<Vcertificacion> selectDynamicBasic(Vcertificacion record) throws Exception {
		return vcertificacionMapper.selectDynamicBasic(record);
	}

	@Override
	public List<Vcertificacion> selectDynamicBasicActives(Vcertificacion record) throws Exception {
		record.setEstadoauditoria("1");
		return vcertificacionMapper.selectDynamicBasic(record);
	}

	@Override
	public List<Vcertificacion> selectDynamicFull(Vcertificacion record) throws Exception {
		List<Vcertificacion> list=vcertificacionMapper.selectDynamicFull(record);
		if(Vcertificacion.HAVE_BIGDECIMALS)
		for (Vcertificacion row : list) {
			row.roundBigDecimals();
		}

		return list;
	}

	@Override
	public List<Vcertificacion> selectDynamicFullActives(Vcertificacion record) throws Exception {
		record.setEstadoauditoria("1");
		return vcertificacionMapper.selectDynamicFull(record);
	}

	@Override
	public List<Vcertificacion> selectDynamicExtended(Vcertificacion record) throws Exception {
		return vcertificacionMapper.selectDynamicExtended(record);
	}

	@Override
	public List<Vcertificacion> selectDynamicExtendedActives(Vcertificacion record) throws Exception {
		record.setEstadoauditoria("1");
		return vcertificacionMapper.selectDynamicExtended(record);
	}

	@Override
	public void updateByPrimaryKeySelectiveBasic(Vcertificacion record) throws Exception {
		record.setFechamodificacionauditoria(Utils.currentTimeStamp());
		updateBooleanToChar(record);
		Utils.convertPropertiesStringToUppercase(record);
		vcertificacionMapper.updateByPrimaryKeySelective(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void updateByPrimaryKeySelectiveFull(Vcertificacion record) throws Exception {
		//Business Logic
		updateByPrimaryKeySelectiveBasic(record);
	}

	@Override
	public void updateByPrimaryKeyBasic(Vcertificacion record) throws Exception {
		record.setFechamodificacionauditoria(Utils.currentTimeStamp());
		updateBooleanToChar(record);
		validateUpdate(record);
		Utils.convertPropertiesStringToUppercase(record);
		vcertificacionMapper.updateByPrimaryKey(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void updateByPrimaryKeyFull(Vcertificacion record) throws Exception {
		//Business Logic
		updateByPrimaryKeyBasic(record);
	}

	public void updateBooleanToChar(Vcertificacion record) throws Exception {
	}

	public void validateInsert(Vcertificacion record)throws Exception{
		if(record.getVcertificacion()==null)
			throw new ValidateException(Messages.getString("vcertificacion.vcertificacion.required"));
		if(record.getCodigounidadejecutora()==null)
			throw new ValidateException(Messages.getString("vcertificacion.codigounidadejecutora.required"));
		if(record.getAnio()==null)
			throw new ValidateException(Messages.getString("vcertificacion.anio.required"));
		if(record.getSecejec()==null)
			throw new ValidateException(Messages.getString("vcertificacion.secejec.required"));
		if(record.getNrocertifica()==null)
			throw new ValidateException(Messages.getString("vcertificacion.nrocertifica.required"));

		if(record.getCodigounidadejecutora()!=null &&  record.getCodigounidadejecutora().length() > 3)
			throw new ValidateException(Messages.getString("vcertificacion.codigounidadejecutora.length.error",record.getCodigounidadejecutora().length()));
		if(record.getCaso()!=null &&  record.getCaso().length() > 1)
			throw new ValidateException(Messages.getString("vcertificacion.caso.length.error",record.getCaso().length()));
		if(record.getUsuariocreacionauditoria()!=null &&  record.getUsuariocreacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("vcertificacion.usuariocreacionauditoria.length.error",record.getUsuariocreacionauditoria().length()));
		if(record.getUsuariomodificacionauditoria()!=null &&  record.getUsuariomodificacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("vcertificacion.usuariomodificacionauditoria.length.error",record.getUsuariomodificacionauditoria().length()));
		if(record.getEquipoauditoria()!=null &&  record.getEquipoauditoria().length() > 45)
			throw new ValidateException(Messages.getString("vcertificacion.equipoauditoria.length.error",record.getEquipoauditoria().length()));
		if(record.getProgramaauditoria()!=null &&  record.getProgramaauditoria().length() > 200)
			throw new ValidateException(Messages.getString("vcertificacion.programaauditoria.length.error",record.getProgramaauditoria().length()));
		if(record.getEstadoauditoria()!=null &&  record.getEstadoauditoria().length() > 1)
			throw new ValidateException(Messages.getString("vcertificacion.estadoauditoria.length.error",record.getEstadoauditoria().length()));

		//Here Bussines Validations.
	}

	public void validateUpdate(Vcertificacion record)throws Exception{
		if(record.getVcertificacion()==null)
			throw new ValidateException(Messages.getString("vcertificacion.vcertificacion.required"));
		if(record.getCodigounidadejecutora()==null)
			throw new ValidateException(Messages.getString("vcertificacion.codigounidadejecutora.required"));
		if(record.getAnio()==null)
			throw new ValidateException(Messages.getString("vcertificacion.anio.required"));
		if(record.getSecejec()==null)
			throw new ValidateException(Messages.getString("vcertificacion.secejec.required"));
		if(record.getNrocertifica()==null)
			throw new ValidateException(Messages.getString("vcertificacion.nrocertifica.required"));

		if(record.getCodigounidadejecutora()!=null &&  record.getCodigounidadejecutora().length() > 3)
			throw new ValidateException(Messages.getString("vcertificacion.codigounidadejecutora.length.error",record.getCodigounidadejecutora().length()));
		if(record.getCaso()!=null &&  record.getCaso().length() > 1)
			throw new ValidateException(Messages.getString("vcertificacion.caso.length.error",record.getCaso().length()));
		if(record.getUsuariocreacionauditoria()!=null &&  record.getUsuariocreacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("vcertificacion.usuariocreacionauditoria.length.error",record.getUsuariocreacionauditoria().length()));
		if(record.getUsuariomodificacionauditoria()!=null &&  record.getUsuariomodificacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("vcertificacion.usuariomodificacionauditoria.length.error",record.getUsuariomodificacionauditoria().length()));
		if(record.getEquipoauditoria()!=null &&  record.getEquipoauditoria().length() > 45)
			throw new ValidateException(Messages.getString("vcertificacion.equipoauditoria.length.error",record.getEquipoauditoria().length()));
		if(record.getProgramaauditoria()!=null &&  record.getProgramaauditoria().length() > 200)
			throw new ValidateException(Messages.getString("vcertificacion.programaauditoria.length.error",record.getProgramaauditoria().length()));
		if(record.getEstadoauditoria()!=null &&  record.getEstadoauditoria().length() > 1)
			throw new ValidateException(Messages.getString("vcertificacion.estadoauditoria.length.error",record.getEstadoauditoria().length()));

		//Here Bussines Validations.
	}

	public void validateDelete(java.lang.Integer par_vcertificacion)throws Exception{
		if(par_vcertificacion==null)
			throw new ValidateException(Messages.getString("vcertificacion.vcertificacion.required"));

		//Here Bussines Validations.
	}


}

