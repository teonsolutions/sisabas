
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
import pe.com.sisabas.be.Unidadejecutora;
import pe.com.sisabas.persistence.UnidadejecutoraMapper;
import pe.com.sisabas.business.UnidadejecutoraBusiness;
import pe.com.sisabas.exception.BusinessException;
import pe.com.sisabas.exception.ValidateException;
import pe.com.sisabas.resources.Constantes;
import pe.com.sisabas.resources.Messages;
import pe.com.sisabas.resources.Sequence;
import pe.com.sisabas.resources.Utils;
import pe.com.sisabas.resources.business.UtilsBusiness;


@Service
public class UnidadejecutoraBusinessImpl implements UnidadejecutoraBusiness, Serializable{

	private static Logger logger=Logger.getLogger(UnidadejecutoraBusinessImpl.class);

	private static final long serialVersionUID = 1L;

	@Autowired
	public UnidadejecutoraMapper unidadejecutoraMapper;

	@Autowired
	public UtilsBusiness utilsBusiness;

	@Override
	public void deleteByPrimaryKeyBasic(Unidadejecutora par_record) throws Exception {
		validateDelete(par_record.getIdunidadejecutora());
		unidadejecutoraMapper.deleteByPrimaryKey(par_record.getIdunidadejecutora());
	}

	@Override
	public void insertBasic(Unidadejecutora record) throws Exception {
		record.setIdunidadejecutora((int)utilsBusiness.getNextSeq(Sequence.SEQ_UNIDADEJECUTORA).longValue());
		record.setFechacreacionauditoria(Utils.currentTimeStamp());
		record.setEstadoauditoria("1");
		updateBooleanToChar(record);
		validateInsert(record);
		Utils.convertPropertiesStringToUppercase(record);
		unidadejecutoraMapper.insert(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void insertFull(Unidadejecutora record) throws Exception {
		//Business Logic
		insertBasic(record);
	}

	@Override
	public void insertSelectiveBasic(Unidadejecutora record) throws Exception {
		record.setIdunidadejecutora((int)utilsBusiness.getNextSeq(Sequence.SEQ_UNIDADEJECUTORA).longValue());
		record.setFechacreacionauditoria(Utils.currentTimeStamp());
		record.setEstadoauditoria("1");
		updateBooleanToChar(record);
		Utils.convertPropertiesStringToUppercase(record);
		unidadejecutoraMapper.insertSelective(record);
	}

	@Override
	public Unidadejecutora selectByPrimaryKeyBasic(java.lang.Integer par_idunidadejecutora) throws Exception {
		return unidadejecutoraMapper.selectByPrimaryKeyBasic(par_idunidadejecutora);
	}

	@Override
	public Unidadejecutora selectByPrimaryKeyBasicFromList(java.lang.Integer par_idunidadejecutora, List<Unidadejecutora> list) throws Exception {
		Unidadejecutora record=null;
		for (Unidadejecutora row : list) {
			if(row.equals(new Unidadejecutora( par_idunidadejecutora))){
				record=row;
				break;
			}
		}
		if(record==null)
			record=selectByPrimaryKeyBasic( par_idunidadejecutora);

		return record;
	}

	@Override
	public Unidadejecutora selectByPrimaryKeyBasicActive(java.lang.Integer par_idunidadejecutora) throws Exception {
		return unidadejecutoraMapper.selectByPrimaryKeyBasicActive(par_idunidadejecutora);
	}

	@Override
	public Unidadejecutora selectByPrimaryKeyFull(java.lang.Integer par_idunidadejecutora) throws Exception {
		return unidadejecutoraMapper.selectByPrimaryKeyFull(par_idunidadejecutora);
	}

	@Override
	public Unidadejecutora selectByPrimaryKeyFullActive(java.lang.Integer par_idunidadejecutora) throws Exception {
		return unidadejecutoraMapper.selectByPrimaryKeyFullActive(par_idunidadejecutora);
	}

	@Override
	public List<Unidadejecutora> selectDynamicBasic(Unidadejecutora record) throws Exception {
		return unidadejecutoraMapper.selectDynamicBasic(record);
	}

	@Override
	public List<Unidadejecutora> selectDynamicBasicActives(Unidadejecutora record) throws Exception {
		record.setEstadoauditoria("1");
		return unidadejecutoraMapper.selectDynamicBasic(record);
	}

	@Override
	public List<Unidadejecutora> selectDynamicFull(Unidadejecutora record) throws Exception {
		List<Unidadejecutora> list=unidadejecutoraMapper.selectDynamicFull(record);
		if(Unidadejecutora.HAVE_BIGDECIMALS)
		for (Unidadejecutora row : list) {
			row.roundBigDecimals();
		}

		return list;
	}

	@Override
	public List<Unidadejecutora> selectDynamicFullActives(Unidadejecutora record) throws Exception {
		record.setEstadoauditoria("1");
		return unidadejecutoraMapper.selectDynamicFull(record);
	}

	@Override
	public List<Unidadejecutora> selectDynamicExtended(Unidadejecutora record) throws Exception {
		return unidadejecutoraMapper.selectDynamicExtended(record);
	}

	@Override
	public List<Unidadejecutora> selectDynamicExtendedActives(Unidadejecutora record) throws Exception {
		record.setEstadoauditoria("1");
		return unidadejecutoraMapper.selectDynamicExtended(record);
	}

	@Override
	public void updateByPrimaryKeySelectiveBasic(Unidadejecutora record) throws Exception {
		record.setFechamodificacionauditoria(Utils.currentTimeStamp());
		updateBooleanToChar(record);
		Utils.convertPropertiesStringToUppercase(record);
		unidadejecutoraMapper.updateByPrimaryKeySelective(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void updateByPrimaryKeySelectiveFull(Unidadejecutora record) throws Exception {
		//Business Logic
		updateByPrimaryKeySelectiveBasic(record);
	}

	@Override
	public void updateByPrimaryKeyBasic(Unidadejecutora record) throws Exception {
		record.setFechamodificacionauditoria(Utils.currentTimeStamp());
		updateBooleanToChar(record);
		validateUpdate(record);
		Utils.convertPropertiesStringToUppercase(record);
		unidadejecutoraMapper.updateByPrimaryKey(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void updateByPrimaryKeyFull(Unidadejecutora record) throws Exception {
		//Business Logic
		updateByPrimaryKeyBasic(record);
	}

	public void updateBooleanToChar(Unidadejecutora record) throws Exception {
	}

	public void validateInsert(Unidadejecutora record)throws Exception{
		if(record.getIdunidadejecutora()==null)
			throw new ValidateException(Messages.getString("unidadejecutora.idunidadejecutora.required"));

		if(record.getCodigounidadejecutora()!=null &&  record.getCodigounidadejecutora().length() > 4)
			throw new ValidateException(Messages.getString("unidadejecutora.codigounidadejecutora.length.error",record.getCodigounidadejecutora().length()));
		if(record.getNombreunidadejecutora()!=null &&  record.getNombreunidadejecutora().length() > 100)
			throw new ValidateException(Messages.getString("unidadejecutora.nombreunidadejecutora.length.error",record.getNombreunidadejecutora().length()));
		if(record.getCodigosiafunidadejecutora()!=null &&  record.getCodigosiafunidadejecutora().length() > 8)
			throw new ValidateException(Messages.getString("unidadejecutora.codigosiafunidadejecutora.length.error",record.getCodigosiafunidadejecutora().length()));
		if(record.getUbicaciondatossiaf()!=null &&  record.getUbicaciondatossiaf().length() > 150)
			throw new ValidateException(Messages.getString("unidadejecutora.ubicaciondatossiaf.length.error",record.getUbicaciondatossiaf().length()));
		if(record.getUsuariocreacionauditoria()!=null &&  record.getUsuariocreacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("unidadejecutora.usuariocreacionauditoria.length.error",record.getUsuariocreacionauditoria().length()));
		if(record.getUsuariomodificacionauditoria()!=null &&  record.getUsuariomodificacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("unidadejecutora.usuariomodificacionauditoria.length.error",record.getUsuariomodificacionauditoria().length()));
		if(record.getEquipoauditoria()!=null &&  record.getEquipoauditoria().length() > 45)
			throw new ValidateException(Messages.getString("unidadejecutora.equipoauditoria.length.error",record.getEquipoauditoria().length()));
		if(record.getProgramaauditoria()!=null &&  record.getProgramaauditoria().length() > 200)
			throw new ValidateException(Messages.getString("unidadejecutora.programaauditoria.length.error",record.getProgramaauditoria().length()));
		if(record.getEstadoauditoria()!=null &&  record.getEstadoauditoria().length() > 1)
			throw new ValidateException(Messages.getString("unidadejecutora.estadoauditoria.length.error",record.getEstadoauditoria().length()));

		//Here Bussines Validations.
	}

	public void validateUpdate(Unidadejecutora record)throws Exception{
		if(record.getIdunidadejecutora()==null)
			throw new ValidateException(Messages.getString("unidadejecutora.idunidadejecutora.required"));

		if(record.getCodigounidadejecutora()!=null &&  record.getCodigounidadejecutora().length() > 4)
			throw new ValidateException(Messages.getString("unidadejecutora.codigounidadejecutora.length.error",record.getCodigounidadejecutora().length()));
		if(record.getNombreunidadejecutora()!=null &&  record.getNombreunidadejecutora().length() > 100)
			throw new ValidateException(Messages.getString("unidadejecutora.nombreunidadejecutora.length.error",record.getNombreunidadejecutora().length()));
		if(record.getCodigosiafunidadejecutora()!=null &&  record.getCodigosiafunidadejecutora().length() > 8)
			throw new ValidateException(Messages.getString("unidadejecutora.codigosiafunidadejecutora.length.error",record.getCodigosiafunidadejecutora().length()));
		if(record.getUbicaciondatossiaf()!=null &&  record.getUbicaciondatossiaf().length() > 150)
			throw new ValidateException(Messages.getString("unidadejecutora.ubicaciondatossiaf.length.error",record.getUbicaciondatossiaf().length()));
		if(record.getUsuariocreacionauditoria()!=null &&  record.getUsuariocreacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("unidadejecutora.usuariocreacionauditoria.length.error",record.getUsuariocreacionauditoria().length()));
		if(record.getUsuariomodificacionauditoria()!=null &&  record.getUsuariomodificacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("unidadejecutora.usuariomodificacionauditoria.length.error",record.getUsuariomodificacionauditoria().length()));
		if(record.getEquipoauditoria()!=null &&  record.getEquipoauditoria().length() > 45)
			throw new ValidateException(Messages.getString("unidadejecutora.equipoauditoria.length.error",record.getEquipoauditoria().length()));
		if(record.getProgramaauditoria()!=null &&  record.getProgramaauditoria().length() > 200)
			throw new ValidateException(Messages.getString("unidadejecutora.programaauditoria.length.error",record.getProgramaauditoria().length()));
		if(record.getEstadoauditoria()!=null &&  record.getEstadoauditoria().length() > 1)
			throw new ValidateException(Messages.getString("unidadejecutora.estadoauditoria.length.error",record.getEstadoauditoria().length()));

		//Here Bussines Validations.
	}

	public void validateDelete(java.lang.Integer par_idunidadejecutora)throws Exception{
		if(par_idunidadejecutora==null)
			throw new ValidateException(Messages.getString("unidadejecutora.idunidadejecutora.required"));

		//Here Bussines Validations.
	}


}

