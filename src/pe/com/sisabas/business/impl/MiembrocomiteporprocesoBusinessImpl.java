
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
import pe.com.sisabas.be.Miembrocomiteporproceso;
import pe.com.sisabas.persistence.MiembrocomiteporprocesoMapper;
import pe.com.sisabas.business.MiembrocomiteporprocesoBusiness;
import pe.com.sisabas.exception.BusinessException;
import pe.com.sisabas.exception.ValidateException;
import pe.com.sisabas.resources.Constantes;
import pe.com.sisabas.resources.Messages;
import pe.com.sisabas.resources.Sequence;
import pe.com.sisabas.resources.Utils;
import pe.com.sisabas.resources.business.UtilsBusiness;


@Service
public class MiembrocomiteporprocesoBusinessImpl implements MiembrocomiteporprocesoBusiness, Serializable{

	private static Logger logger=Logger.getLogger(MiembrocomiteporprocesoBusinessImpl.class);

	private static final long serialVersionUID = 1L;

	@Autowired
	public MiembrocomiteporprocesoMapper miembrocomiteporprocesoMapper;

	@Autowired
	public UtilsBusiness utilsBusiness;

	@Override
	public void deleteByPrimaryKeyBasic(Miembrocomiteporproceso par_record) throws Exception {
		validateDelete(par_record.getIdmiembrocomiteproceso());
		miembrocomiteporprocesoMapper.deleteByPrimaryKey(par_record.getIdmiembrocomiteproceso());
	}

	@Override
	public void insertBasic(Miembrocomiteporproceso record) throws Exception {
		record.setIdmiembrocomiteproceso((int)utilsBusiness.getNextSeq(Sequence.SEQ_MIEMBROCOMITEPORPROCESO).longValue());
		record.setFechacreacionauditoria(Utils.currentTimeStamp());
		record.setEstadoauditoria("1");
		updateBooleanToChar(record);
		validateInsert(record);
		Utils.convertPropertiesStringToUppercase(record);
		miembrocomiteporprocesoMapper.insert(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void insertFull(Miembrocomiteporproceso record) throws Exception {
		//Business Logic
		insertBasic(record);
	}

	@Override
	public void insertSelectiveBasic(Miembrocomiteporproceso record) throws Exception {
		record.setIdmiembrocomiteproceso((int)utilsBusiness.getNextSeq(Sequence.SEQ_MIEMBROCOMITEPORPROCESO).longValue());
		record.setFechacreacionauditoria(Utils.currentTimeStamp());
		record.setEstadoauditoria("1");
		updateBooleanToChar(record);
		Utils.convertPropertiesStringToUppercase(record);
		miembrocomiteporprocesoMapper.insertSelective(record);
	}

	@Override
	public Miembrocomiteporproceso selectByPrimaryKeyBasic(java.lang.Integer par_idmiembrocomiteproceso) throws Exception {
		return miembrocomiteporprocesoMapper.selectByPrimaryKeyBasic(par_idmiembrocomiteproceso);
	}

	@Override
	public Miembrocomiteporproceso selectByPrimaryKeyBasicFromList(java.lang.Integer par_idmiembrocomiteproceso, List<Miembrocomiteporproceso> list) throws Exception {
		Miembrocomiteporproceso record=null;
		for (Miembrocomiteporproceso row : list) {
			if(row.equals(new Miembrocomiteporproceso( par_idmiembrocomiteproceso))){
				record=row;
				break;
			}
		}
		if(record==null)
			record=selectByPrimaryKeyBasic( par_idmiembrocomiteproceso);

		return record;
	}

	@Override
	public Miembrocomiteporproceso selectByPrimaryKeyBasicActive(java.lang.Integer par_idmiembrocomiteproceso) throws Exception {
		return miembrocomiteporprocesoMapper.selectByPrimaryKeyBasicActive(par_idmiembrocomiteproceso);
	}

	@Override
	public Miembrocomiteporproceso selectByPrimaryKeyFull(java.lang.Integer par_idmiembrocomiteproceso) throws Exception {
		return miembrocomiteporprocesoMapper.selectByPrimaryKeyFull(par_idmiembrocomiteproceso);
	}

	@Override
	public Miembrocomiteporproceso selectByPrimaryKeyFullActive(java.lang.Integer par_idmiembrocomiteproceso) throws Exception {
		return miembrocomiteporprocesoMapper.selectByPrimaryKeyFullActive(par_idmiembrocomiteproceso);
	}

	@Override
	public List<Miembrocomiteporproceso> selectDynamicBasic(Miembrocomiteporproceso record) throws Exception {
		return miembrocomiteporprocesoMapper.selectDynamicBasic(record);
	}

	@Override
	public List<Miembrocomiteporproceso> selectDynamicBasicActives(Miembrocomiteporproceso record) throws Exception {
		record.setEstadoauditoria("1");
		return miembrocomiteporprocesoMapper.selectDynamicBasic(record);
	}

	@Override
	public List<Miembrocomiteporproceso> selectDynamicFull(Miembrocomiteporproceso record) throws Exception {
		List<Miembrocomiteporproceso> list=miembrocomiteporprocesoMapper.selectDynamicFull(record);
		if(Miembrocomiteporproceso.HAVE_BIGDECIMALS)
		for (Miembrocomiteporproceso row : list) {
			row.roundBigDecimals();
		}

		return list;
	}

	@Override
	public List<Miembrocomiteporproceso> selectDynamicFullActives(Miembrocomiteporproceso record) throws Exception {
		record.setEstadoauditoria("1");
		return miembrocomiteporprocesoMapper.selectDynamicFull(record);
	}

	@Override
	public List<Miembrocomiteporproceso> selectDynamicExtended(Miembrocomiteporproceso record) throws Exception {
		return miembrocomiteporprocesoMapper.selectDynamicExtended(record);
	}

	@Override
	public List<Miembrocomiteporproceso> selectDynamicExtendedActives(Miembrocomiteporproceso record) throws Exception {
		record.setEstadoauditoria("1");
		return miembrocomiteporprocesoMapper.selectDynamicExtended(record);
	}

	@Override
	public void updateByPrimaryKeySelectiveBasic(Miembrocomiteporproceso record) throws Exception {
		record.setFechamodificacionauditoria(Utils.currentTimeStamp());
		updateBooleanToChar(record);
		Utils.convertPropertiesStringToUppercase(record);
		miembrocomiteporprocesoMapper.updateByPrimaryKeySelective(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void updateByPrimaryKeySelectiveFull(Miembrocomiteporproceso record) throws Exception {
		//Business Logic
		updateByPrimaryKeySelectiveBasic(record);
	}

	@Override
	public void updateByPrimaryKeyBasic(Miembrocomiteporproceso record) throws Exception {
		record.setFechamodificacionauditoria(Utils.currentTimeStamp());
		updateBooleanToChar(record);
		validateUpdate(record);
		Utils.convertPropertiesStringToUppercase(record);
		miembrocomiteporprocesoMapper.updateByPrimaryKey(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void updateByPrimaryKeyFull(Miembrocomiteporproceso record) throws Exception {
		//Business Logic
		updateByPrimaryKeyBasic(record);
	}

	public void updateBooleanToChar(Miembrocomiteporproceso record) throws Exception {
		if(record.getBooleanesnotificado()!=null && record.getBooleanesnotificado()){
			record.setEsnotificado("1");
		}else{
			record.setEsnotificado("0");
		}

	}

	public void validateInsert(Miembrocomiteporproceso record)throws Exception{
		if(record.getIdmiembrocomiteproceso()==null)
			throw new ValidateException(Messages.getString("miembrocomiteporproceso.idmiembrocomiteproceso.required"));

		if(record.getIdcatalogotipomiembro()!=null &&  record.getIdcatalogotipomiembro().length() > 10)
			throw new ValidateException(Messages.getString("miembrocomiteporproceso.idcatalogotipomiembro.length.error",record.getIdcatalogotipomiembro().length()));
		if(record.getCorreo()!=null &&  record.getCorreo().length() > 50)
			throw new ValidateException(Messages.getString("miembrocomiteporproceso.correo.length.error",record.getCorreo().length()));
		if(record.getTelefono()!=null &&  record.getTelefono().length() > 10)
			throw new ValidateException(Messages.getString("miembrocomiteporproceso.telefono.length.error",record.getTelefono().length()));
		if(record.getAnexo()!=null &&  record.getAnexo().length() > 6)
			throw new ValidateException(Messages.getString("miembrocomiteporproceso.anexo.length.error",record.getAnexo().length()));
		if(record.getCelular()!=null &&  record.getCelular().length() > 9)
			throw new ValidateException(Messages.getString("miembrocomiteporproceso.celular.length.error",record.getCelular().length()));
		if(record.getEsnotificado()!=null &&  record.getEsnotificado().length() > 1)
			throw new ValidateException(Messages.getString("miembrocomiteporproceso.esnotificado.length.error",record.getEsnotificado().length()));
		if(record.getCodigooficinausuaria()!=null &&  record.getCodigooficinausuaria().length() > 15)
			throw new ValidateException(Messages.getString("miembrocomiteporproceso.codigooficinausuaria.length.error",record.getCodigooficinausuaria().length()));
		if(record.getNombreoficinausuaria()!=null &&  record.getNombreoficinausuaria().length() > 150)
			throw new ValidateException(Messages.getString("miembrocomiteporproceso.nombreoficinausuaria.length.error",record.getNombreoficinausuaria().length()));
		if(record.getIdcatalogoestadomiembrocomite()!=null &&  record.getIdcatalogoestadomiembrocomite().length() > 10)
			throw new ValidateException(Messages.getString("miembrocomiteporproceso.idcatalogoestadomiembrocomite.length.error",record.getIdcatalogoestadomiembrocomite().length()));
		if(record.getEsespecialistaasignado()!=null &&  record.getEsespecialistaasignado().length() > 1)
			throw new ValidateException(Messages.getString("miembrocomiteporproceso.esespecialistaasignado.length.error",record.getEsespecialistaasignado().length()));
		if(record.getUsuariocreacionauditoria()!=null &&  record.getUsuariocreacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("miembrocomiteporproceso.usuariocreacionauditoria.length.error",record.getUsuariocreacionauditoria().length()));
		if(record.getUsuariomodificacionauditoria()!=null &&  record.getUsuariomodificacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("miembrocomiteporproceso.usuariomodificacionauditoria.length.error",record.getUsuariomodificacionauditoria().length()));
		if(record.getEquipoauditoria()!=null &&  record.getEquipoauditoria().length() > 45)
			throw new ValidateException(Messages.getString("miembrocomiteporproceso.equipoauditoria.length.error",record.getEquipoauditoria().length()));
		if(record.getProgramaauditoria()!=null &&  record.getProgramaauditoria().length() > 200)
			throw new ValidateException(Messages.getString("miembrocomiteporproceso.programaauditoria.length.error",record.getProgramaauditoria().length()));
		if(record.getEstadoauditoria()!=null &&  record.getEstadoauditoria().length() > 1)
			throw new ValidateException(Messages.getString("miembrocomiteporproceso.estadoauditoria.length.error",record.getEstadoauditoria().length()));

		//Here Bussines Validations.
	}

	public void validateUpdate(Miembrocomiteporproceso record)throws Exception{
		if(record.getIdmiembrocomiteproceso()==null)
			throw new ValidateException(Messages.getString("miembrocomiteporproceso.idmiembrocomiteproceso.required"));

		if(record.getIdcatalogotipomiembro()!=null &&  record.getIdcatalogotipomiembro().length() > 10)
			throw new ValidateException(Messages.getString("miembrocomiteporproceso.idcatalogotipomiembro.length.error",record.getIdcatalogotipomiembro().length()));
		if(record.getCorreo()!=null &&  record.getCorreo().length() > 50)
			throw new ValidateException(Messages.getString("miembrocomiteporproceso.correo.length.error",record.getCorreo().length()));
		if(record.getTelefono()!=null &&  record.getTelefono().length() > 10)
			throw new ValidateException(Messages.getString("miembrocomiteporproceso.telefono.length.error",record.getTelefono().length()));
		if(record.getAnexo()!=null &&  record.getAnexo().length() > 6)
			throw new ValidateException(Messages.getString("miembrocomiteporproceso.anexo.length.error",record.getAnexo().length()));
		if(record.getCelular()!=null &&  record.getCelular().length() > 9)
			throw new ValidateException(Messages.getString("miembrocomiteporproceso.celular.length.error",record.getCelular().length()));
		if(record.getEsnotificado()!=null &&  record.getEsnotificado().length() > 1)
			throw new ValidateException(Messages.getString("miembrocomiteporproceso.esnotificado.length.error",record.getEsnotificado().length()));
		if(record.getCodigooficinausuaria()!=null &&  record.getCodigooficinausuaria().length() > 15)
			throw new ValidateException(Messages.getString("miembrocomiteporproceso.codigooficinausuaria.length.error",record.getCodigooficinausuaria().length()));
		if(record.getNombreoficinausuaria()!=null &&  record.getNombreoficinausuaria().length() > 150)
			throw new ValidateException(Messages.getString("miembrocomiteporproceso.nombreoficinausuaria.length.error",record.getNombreoficinausuaria().length()));
		if(record.getIdcatalogoestadomiembrocomite()!=null &&  record.getIdcatalogoestadomiembrocomite().length() > 10)
			throw new ValidateException(Messages.getString("miembrocomiteporproceso.idcatalogoestadomiembrocomite.length.error",record.getIdcatalogoestadomiembrocomite().length()));
		if(record.getEsespecialistaasignado()!=null &&  record.getEsespecialistaasignado().length() > 1)
			throw new ValidateException(Messages.getString("miembrocomiteporproceso.esespecialistaasignado.length.error",record.getEsespecialistaasignado().length()));
		if(record.getUsuariocreacionauditoria()!=null &&  record.getUsuariocreacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("miembrocomiteporproceso.usuariocreacionauditoria.length.error",record.getUsuariocreacionauditoria().length()));
		if(record.getUsuariomodificacionauditoria()!=null &&  record.getUsuariomodificacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("miembrocomiteporproceso.usuariomodificacionauditoria.length.error",record.getUsuariomodificacionauditoria().length()));
		if(record.getEquipoauditoria()!=null &&  record.getEquipoauditoria().length() > 45)
			throw new ValidateException(Messages.getString("miembrocomiteporproceso.equipoauditoria.length.error",record.getEquipoauditoria().length()));
		if(record.getProgramaauditoria()!=null &&  record.getProgramaauditoria().length() > 200)
			throw new ValidateException(Messages.getString("miembrocomiteporproceso.programaauditoria.length.error",record.getProgramaauditoria().length()));
		if(record.getEstadoauditoria()!=null &&  record.getEstadoauditoria().length() > 1)
			throw new ValidateException(Messages.getString("miembrocomiteporproceso.estadoauditoria.length.error",record.getEstadoauditoria().length()));

		//Here Bussines Validations.
	}

	public void validateDelete(java.lang.Integer par_idmiembrocomiteproceso)throws Exception{
		if(par_idmiembrocomiteproceso==null)
			throw new ValidateException(Messages.getString("miembrocomiteporproceso.idmiembrocomiteproceso.required"));

		//Here Bussines Validations.
	}


}

