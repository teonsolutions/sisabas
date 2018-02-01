
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
import pe.com.sisabas.be.Convocatoriaprocesoseleccion;
import pe.com.sisabas.persistence.ConvocatoriaprocesoseleccionMapper;
import pe.com.sisabas.business.ConvocatoriaprocesoseleccionBusiness;
import pe.com.sisabas.exception.BusinessException;
import pe.com.sisabas.exception.ValidateException;
import pe.com.sisabas.resources.Constantes;
import pe.com.sisabas.resources.Messages;
import pe.com.sisabas.resources.Sequence;
import pe.com.sisabas.resources.Utils;
import pe.com.sisabas.resources.business.UtilsBusiness;


@Service
public class ConvocatoriaprocesoseleccionBusinessImpl implements ConvocatoriaprocesoseleccionBusiness, Serializable{

	private static Logger logger=Logger.getLogger(ConvocatoriaprocesoseleccionBusinessImpl.class);

	private static final long serialVersionUID = 1L;

	@Autowired
	public ConvocatoriaprocesoseleccionMapper convocatoriaprocesoseleccionMapper;

	@Autowired
	public UtilsBusiness utilsBusiness;

	@Override
	public void deleteByPrimaryKeyBasic(Convocatoriaprocesoseleccion par_record) throws Exception {
		validateDelete(par_record.getIdconvocatoriaproceso());
		convocatoriaprocesoseleccionMapper.deleteByPrimaryKey(par_record.getIdconvocatoriaproceso());
	}

	@Override
	public void insertBasic(Convocatoriaprocesoseleccion record) throws Exception {
		record.setIdconvocatoriaproceso((int)utilsBusiness.getNextSeq(Sequence.SEQ_CONVOCATORIAPROCESOSELECCION).longValue());
		record.setFechacreacionauditoria(Utils.currentTimeStamp());
		record.setEstadoauditoria("1");
		updateBooleanToChar(record);
		validateInsert(record);
		Utils.convertPropertiesStringToUppercase(record);
		convocatoriaprocesoseleccionMapper.insert(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void insertFull(Convocatoriaprocesoseleccion record) throws Exception {
		//Business Logic
		insertBasic(record);
	}

	@Override
	public void insertSelectiveBasic(Convocatoriaprocesoseleccion record) throws Exception {
		record.setIdconvocatoriaproceso((int)utilsBusiness.getNextSeq(Sequence.SEQ_CONVOCATORIAPROCESOSELECCION).longValue());
		record.setFechacreacionauditoria(Utils.currentTimeStamp());
		record.setEstadoauditoria("1");
		updateBooleanToChar(record);
		Utils.convertPropertiesStringToUppercase(record);
		convocatoriaprocesoseleccionMapper.insertSelective(record);
	}

	@Override
	public Convocatoriaprocesoseleccion selectByPrimaryKeyBasic(java.lang.Integer par_idconvocatoriaproceso) throws Exception {
		return convocatoriaprocesoseleccionMapper.selectByPrimaryKeyBasic(par_idconvocatoriaproceso);
	}

	@Override
	public Convocatoriaprocesoseleccion selectByPrimaryKeyBasicFromList(java.lang.Integer par_idconvocatoriaproceso, List<Convocatoriaprocesoseleccion> list) throws Exception {
		Convocatoriaprocesoseleccion record=null;
		for (Convocatoriaprocesoseleccion row : list) {
			if(row.equals(new Convocatoriaprocesoseleccion( par_idconvocatoriaproceso))){
				record=row;
				break;
			}
		}
		if(record==null)
			record=selectByPrimaryKeyBasic( par_idconvocatoriaproceso);

		return record;
	}

	@Override
	public Convocatoriaprocesoseleccion selectByPrimaryKeyBasicActive(java.lang.Integer par_idconvocatoriaproceso) throws Exception {
		return convocatoriaprocesoseleccionMapper.selectByPrimaryKeyBasicActive(par_idconvocatoriaproceso);
	}

	@Override
	public Convocatoriaprocesoseleccion selectByPrimaryKeyFull(java.lang.Integer par_idconvocatoriaproceso) throws Exception {
		return convocatoriaprocesoseleccionMapper.selectByPrimaryKeyFull(par_idconvocatoriaproceso);
	}

	@Override
	public Convocatoriaprocesoseleccion selectByPrimaryKeyFullActive(java.lang.Integer par_idconvocatoriaproceso) throws Exception {
		return convocatoriaprocesoseleccionMapper.selectByPrimaryKeyFullActive(par_idconvocatoriaproceso);
	}

	@Override
	public List<Convocatoriaprocesoseleccion> selectDynamicBasic(Convocatoriaprocesoseleccion record) throws Exception {
		return convocatoriaprocesoseleccionMapper.selectDynamicBasic(record);
	}

	@Override
	public List<Convocatoriaprocesoseleccion> selectDynamicBasicActives(Convocatoriaprocesoseleccion record) throws Exception {
		record.setEstadoauditoria("1");
		return convocatoriaprocesoseleccionMapper.selectDynamicBasic(record);
	}

	@Override
	public List<Convocatoriaprocesoseleccion> selectDynamicFull(Convocatoriaprocesoseleccion record) throws Exception {
		List<Convocatoriaprocesoseleccion> list=convocatoriaprocesoseleccionMapper.selectDynamicFull(record);
		if(Convocatoriaprocesoseleccion.HAVE_BIGDECIMALS)
		for (Convocatoriaprocesoseleccion row : list) {
			row.roundBigDecimals();
		}

		return list;
	}

	@Override
	public List<Convocatoriaprocesoseleccion> selectDynamicFullActives(Convocatoriaprocesoseleccion record) throws Exception {
		record.setEstadoauditoria("1");
		return convocatoriaprocesoseleccionMapper.selectDynamicFull(record);
	}

	@Override
	public List<Convocatoriaprocesoseleccion> selectDynamicExtended(Convocatoriaprocesoseleccion record) throws Exception {
		return convocatoriaprocesoseleccionMapper.selectDynamicExtended(record);
	}

	@Override
	public List<Convocatoriaprocesoseleccion> selectDynamicExtendedActives(Convocatoriaprocesoseleccion record) throws Exception {
		record.setEstadoauditoria("1");
		return convocatoriaprocesoseleccionMapper.selectDynamicExtended(record);
	}

	@Override
	public void updateByPrimaryKeySelectiveBasic(Convocatoriaprocesoseleccion record) throws Exception {
		record.setFechamodificacionauditoria(Utils.currentTimeStamp());
		updateBooleanToChar(record);
		Utils.convertPropertiesStringToUppercase(record);
		convocatoriaprocesoseleccionMapper.updateByPrimaryKeySelective(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void updateByPrimaryKeySelectiveFull(Convocatoriaprocesoseleccion record) throws Exception {
		//Business Logic
		updateByPrimaryKeySelectiveBasic(record);
	}

	@Override
	public void updateByPrimaryKeyBasic(Convocatoriaprocesoseleccion record) throws Exception {
		record.setFechamodificacionauditoria(Utils.currentTimeStamp());
		updateBooleanToChar(record);
		validateUpdate(record);
		Utils.convertPropertiesStringToUppercase(record);
		convocatoriaprocesoseleccionMapper.updateByPrimaryKey(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void updateByPrimaryKeyFull(Convocatoriaprocesoseleccion record) throws Exception {
		//Business Logic
		updateByPrimaryKeyBasic(record);
	}

	public void updateBooleanToChar(Convocatoriaprocesoseleccion record) throws Exception {
	}

	public void validateInsert(Convocatoriaprocesoseleccion record)throws Exception{
		if(record.getIdconvocatoriaproceso()==null)
			throw new ValidateException(Messages.getString("convocatoriaprocesoseleccion.idconvocatoriaproceso.required"));

		if(record.getIdcatalogoestadoconvocatoria()!=null &&  record.getIdcatalogoestadoconvocatoria().length() > 10)
			throw new ValidateException(Messages.getString("convocatoriaprocesoseleccion.idcatalogoestadoconvocatoria.length.error",record.getIdcatalogoestadoconvocatoria().length()));
		if(record.getPrincipal()!=null &&  record.getPrincipal().length() > 1)
			throw new ValidateException(Messages.getString("convocatoriaprocesoseleccion.principal.length.error",record.getPrincipal().length()));
		if(record.getUsuariocreacionauditoria()!=null &&  record.getUsuariocreacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("convocatoriaprocesoseleccion.usuariocreacionauditoria.length.error",record.getUsuariocreacionauditoria().length()));
		if(record.getUsuariomodificacionauditoria()!=null &&  record.getUsuariomodificacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("convocatoriaprocesoseleccion.usuariomodificacionauditoria.length.error",record.getUsuariomodificacionauditoria().length()));
		if(record.getEquipoauditoria()!=null &&  record.getEquipoauditoria().length() > 45)
			throw new ValidateException(Messages.getString("convocatoriaprocesoseleccion.equipoauditoria.length.error",record.getEquipoauditoria().length()));
		if(record.getProgramaauditoria()!=null &&  record.getProgramaauditoria().length() > 200)
			throw new ValidateException(Messages.getString("convocatoriaprocesoseleccion.programaauditoria.length.error",record.getProgramaauditoria().length()));
		if(record.getEstadoauditoria()!=null &&  record.getEstadoauditoria().length() > 1)
			throw new ValidateException(Messages.getString("convocatoriaprocesoseleccion.estadoauditoria.length.error",record.getEstadoauditoria().length()));

		//Here Bussines Validations.
	}

	public void validateUpdate(Convocatoriaprocesoseleccion record)throws Exception{
		if(record.getIdconvocatoriaproceso()==null)
			throw new ValidateException(Messages.getString("convocatoriaprocesoseleccion.idconvocatoriaproceso.required"));

		if(record.getIdcatalogoestadoconvocatoria()!=null &&  record.getIdcatalogoestadoconvocatoria().length() > 10)
			throw new ValidateException(Messages.getString("convocatoriaprocesoseleccion.idcatalogoestadoconvocatoria.length.error",record.getIdcatalogoestadoconvocatoria().length()));
		if(record.getPrincipal()!=null &&  record.getPrincipal().length() > 1)
			throw new ValidateException(Messages.getString("convocatoriaprocesoseleccion.principal.length.error",record.getPrincipal().length()));
		if(record.getUsuariocreacionauditoria()!=null &&  record.getUsuariocreacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("convocatoriaprocesoseleccion.usuariocreacionauditoria.length.error",record.getUsuariocreacionauditoria().length()));
		if(record.getUsuariomodificacionauditoria()!=null &&  record.getUsuariomodificacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("convocatoriaprocesoseleccion.usuariomodificacionauditoria.length.error",record.getUsuariomodificacionauditoria().length()));
		if(record.getEquipoauditoria()!=null &&  record.getEquipoauditoria().length() > 45)
			throw new ValidateException(Messages.getString("convocatoriaprocesoseleccion.equipoauditoria.length.error",record.getEquipoauditoria().length()));
		if(record.getProgramaauditoria()!=null &&  record.getProgramaauditoria().length() > 200)
			throw new ValidateException(Messages.getString("convocatoriaprocesoseleccion.programaauditoria.length.error",record.getProgramaauditoria().length()));
		if(record.getEstadoauditoria()!=null &&  record.getEstadoauditoria().length() > 1)
			throw new ValidateException(Messages.getString("convocatoriaprocesoseleccion.estadoauditoria.length.error",record.getEstadoauditoria().length()));

		//Here Bussines Validations.
	}

	public void validateDelete(java.lang.Integer par_idconvocatoriaproceso)throws Exception{
		if(par_idconvocatoriaproceso==null)
			throw new ValidateException(Messages.getString("convocatoriaprocesoseleccion.idconvocatoriaproceso.required"));

		//Here Bussines Validations.
	}


}

