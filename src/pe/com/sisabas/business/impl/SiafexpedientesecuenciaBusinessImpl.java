
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
import pe.com.sisabas.be.Siafexpedientesecuencia;
import pe.com.sisabas.persistence.SiafexpedientesecuenciaMapper;
import pe.com.sisabas.business.SiafexpedientesecuenciaBusiness;
import pe.com.sisabas.exception.BusinessException;
import pe.com.sisabas.exception.ValidateException;
import pe.com.sisabas.resources.Constantes;
import pe.com.sisabas.resources.Messages;
import pe.com.sisabas.resources.Sequence;
import pe.com.sisabas.resources.Utils;
import pe.com.sisabas.resources.business.UtilsBusiness;


@Service
public class SiafexpedientesecuenciaBusinessImpl implements SiafexpedientesecuenciaBusiness, Serializable{

	private static Logger logger=Logger.getLogger(SiafexpedientesecuenciaBusinessImpl.class);

	private static final long serialVersionUID = 1L;

	@Autowired
	public SiafexpedientesecuenciaMapper siafexpedientesecuenciaMapper;

	@Autowired
	public UtilsBusiness utilsBusiness;

	@Override
	public void deleteByPrimaryKeyBasic(Siafexpedientesecuencia par_record) throws Exception {
		validateDelete(par_record.getIdsiafexpedientesecuencia());
		siafexpedientesecuenciaMapper.deleteByPrimaryKey(par_record.getIdsiafexpedientesecuencia());
	}

	@Override
	public void insertBasic(Siafexpedientesecuencia record) throws Exception {
		record.setIdsiafexpedientesecuencia((int)utilsBusiness.getNextSeq(Sequence.SEQ_SIAFEXPEDIENTESECUENCIA).longValue());
		record.setFechacreacionauditoria(Utils.currentTimeStamp());
		record.setEstadoauditoria("1");
		updateBooleanToChar(record);
		validateInsert(record);
		Utils.convertPropertiesStringToUppercase(record);
		siafexpedientesecuenciaMapper.insert(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void insertFull(Siafexpedientesecuencia record) throws Exception {
		//Business Logic
		insertBasic(record);
	}

	@Override
	public void insertSelectiveBasic(Siafexpedientesecuencia record) throws Exception {
		record.setIdsiafexpedientesecuencia((int)utilsBusiness.getNextSeq(Sequence.SEQ_SIAFEXPEDIENTESECUENCIA).longValue());
		record.setFechacreacionauditoria(Utils.currentTimeStamp());
		record.setEstadoauditoria("1");
		updateBooleanToChar(record);
		Utils.convertPropertiesStringToUppercase(record);
		siafexpedientesecuenciaMapper.insertSelective(record);
	}

	@Override
	public Siafexpedientesecuencia selectByPrimaryKeyBasic(java.lang.Integer par_idsiafexpedientesecuencia) throws Exception {
		return siafexpedientesecuenciaMapper.selectByPrimaryKeyBasic(par_idsiafexpedientesecuencia);
	}

	@Override
	public Siafexpedientesecuencia selectByPrimaryKeyBasicFromList(java.lang.Integer par_idsiafexpedientesecuencia, List<Siafexpedientesecuencia> list) throws Exception {
		Siafexpedientesecuencia record=null;
		for (Siafexpedientesecuencia row : list) {
			if(row.equals(new Siafexpedientesecuencia( par_idsiafexpedientesecuencia))){
				record=row;
				break;
			}
		}
		if(record==null)
			record=selectByPrimaryKeyBasic( par_idsiafexpedientesecuencia);

		return record;
	}

	@Override
	public Siafexpedientesecuencia selectByPrimaryKeyBasicActive(java.lang.Integer par_idsiafexpedientesecuencia) throws Exception {
		return siafexpedientesecuenciaMapper.selectByPrimaryKeyBasicActive(par_idsiafexpedientesecuencia);
	}

	@Override
	public Siafexpedientesecuencia selectByPrimaryKeyFull(java.lang.Integer par_idsiafexpedientesecuencia) throws Exception {
		return siafexpedientesecuenciaMapper.selectByPrimaryKeyFull(par_idsiafexpedientesecuencia);
	}

	@Override
	public Siafexpedientesecuencia selectByPrimaryKeyFullActive(java.lang.Integer par_idsiafexpedientesecuencia) throws Exception {
		return siafexpedientesecuenciaMapper.selectByPrimaryKeyFullActive(par_idsiafexpedientesecuencia);
	}

	@Override
	public List<Siafexpedientesecuencia> selectDynamicBasic(Siafexpedientesecuencia record) throws Exception {
		return siafexpedientesecuenciaMapper.selectDynamicBasic(record);
	}

	@Override
	public List<Siafexpedientesecuencia> selectDynamicBasicActives(Siafexpedientesecuencia record) throws Exception {
		record.setEstadoauditoria("1");
		return siafexpedientesecuenciaMapper.selectDynamicBasic(record);
	}

	@Override
	public List<Siafexpedientesecuencia> selectDynamicFull(Siafexpedientesecuencia record) throws Exception {
		List<Siafexpedientesecuencia> list=siafexpedientesecuenciaMapper.selectDynamicFull(record);
		if(Siafexpedientesecuencia.HAVE_BIGDECIMALS)
		for (Siafexpedientesecuencia row : list) {
			row.roundBigDecimals();
		}

		return list;
	}

	@Override
	public List<Siafexpedientesecuencia> selectDynamicFullActives(Siafexpedientesecuencia record) throws Exception {
		record.setEstadoauditoria("1");
		return siafexpedientesecuenciaMapper.selectDynamicFull(record);
	}

	@Override
	public List<Siafexpedientesecuencia> selectDynamicExtended(Siafexpedientesecuencia record) throws Exception {
		return siafexpedientesecuenciaMapper.selectDynamicExtended(record);
	}

	@Override
	public List<Siafexpedientesecuencia> selectDynamicExtendedActives(Siafexpedientesecuencia record) throws Exception {
		record.setEstadoauditoria("1");
		return siafexpedientesecuenciaMapper.selectDynamicExtended(record);
	}

	@Override
	public void updateByPrimaryKeySelectiveBasic(Siafexpedientesecuencia record) throws Exception {
		record.setFechamodificacionauditoria(Utils.currentTimeStamp());
		updateBooleanToChar(record);
		Utils.convertPropertiesStringToUppercase(record);
		siafexpedientesecuenciaMapper.updateByPrimaryKeySelective(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void updateByPrimaryKeySelectiveFull(Siafexpedientesecuencia record) throws Exception {
		//Business Logic
		updateByPrimaryKeySelectiveBasic(record);
	}

	@Override
	public void updateByPrimaryKeyBasic(Siafexpedientesecuencia record) throws Exception {
		record.setFechamodificacionauditoria(Utils.currentTimeStamp());
		updateBooleanToChar(record);
		validateUpdate(record);
		Utils.convertPropertiesStringToUppercase(record);
		siafexpedientesecuenciaMapper.updateByPrimaryKey(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void updateByPrimaryKeyFull(Siafexpedientesecuencia record) throws Exception {
		//Business Logic
		updateByPrimaryKeyBasic(record);
	}

	public void updateBooleanToChar(Siafexpedientesecuencia record) throws Exception {
	}

	public void validateInsert(Siafexpedientesecuencia record)throws Exception{
		if(record.getIdsiafexpedientesecuencia()==null)
			throw new ValidateException(Messages.getString("siafexpedientesecuencia.idsiafexpedientesecuencia.required"));
		if(record.getIdlog()==null)
			throw new ValidateException(Messages.getString("siafexpedientesecuencia.idlog.required"));
		if(record.getAnio()==null)
			throw new ValidateException(Messages.getString("siafexpedientesecuencia.anio.required"));
		if(record.getSecejec()==null)
			throw new ValidateException(Messages.getString("siafexpedientesecuencia.secejec.required"));
		if(record.getExpediente()==null)
			throw new ValidateException(Messages.getString("siafexpedientesecuencia.expediente.required"));
		if(record.getCiclo()==null)
			throw new ValidateException(Messages.getString("siafexpedientesecuencia.ciclo.required"));
		if(record.getFase()==null)
			throw new ValidateException(Messages.getString("siafexpedientesecuencia.fase.required"));

		if(record.getAnio()!=null &&  record.getAnio().length() > 4)
			throw new ValidateException(Messages.getString("siafexpedientesecuencia.anio.length.error",record.getAnio().length()));
		if(record.getSecejec()!=null &&  record.getSecejec().length() > 6)
			throw new ValidateException(Messages.getString("siafexpedientesecuencia.secejec.length.error",record.getSecejec().length()));
		if(record.getExpediente()!=null &&  record.getExpediente().length() > 10)
			throw new ValidateException(Messages.getString("siafexpedientesecuencia.expediente.length.error",record.getExpediente().length()));
		if(record.getAnioproceso()!=null &&  record.getAnioproceso().length() > 4)
			throw new ValidateException(Messages.getString("siafexpedientesecuencia.anioproceso.length.error",record.getAnioproceso().length()));
		if(record.getCodigodocumento()!=null &&  record.getCodigodocumento().length() > 3)
			throw new ValidateException(Messages.getString("siafexpedientesecuencia.codigodocumento.length.error",record.getCodigodocumento().length()));
		if(record.getNumerodocumento()!=null &&  record.getNumerodocumento().length() > 20)
			throw new ValidateException(Messages.getString("siafexpedientesecuencia.numerodocumento.length.error",record.getNumerodocumento().length()));
		if(record.getMesproceso()!=null &&  record.getMesproceso().length() > 2)
			throw new ValidateException(Messages.getString("siafexpedientesecuencia.mesproceso.length.error",record.getMesproceso().length()));
		if(record.getCiclo()!=null &&  record.getCiclo().length() > 1)
			throw new ValidateException(Messages.getString("siafexpedientesecuencia.ciclo.length.error",record.getCiclo().length()));
		if(record.getFase()!=null &&  record.getFase().length() > 1)
			throw new ValidateException(Messages.getString("siafexpedientesecuencia.fase.length.error",record.getFase().length()));
		if(record.getUsuariocreacionauditoria()!=null &&  record.getUsuariocreacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("siafexpedientesecuencia.usuariocreacionauditoria.length.error",record.getUsuariocreacionauditoria().length()));
		if(record.getUsuariomodificacionauditoria()!=null &&  record.getUsuariomodificacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("siafexpedientesecuencia.usuariomodificacionauditoria.length.error",record.getUsuariomodificacionauditoria().length()));
		if(record.getEquipoauditoria()!=null &&  record.getEquipoauditoria().length() > 45)
			throw new ValidateException(Messages.getString("siafexpedientesecuencia.equipoauditoria.length.error",record.getEquipoauditoria().length()));
		if(record.getProgramaauditoria()!=null &&  record.getProgramaauditoria().length() > 200)
			throw new ValidateException(Messages.getString("siafexpedientesecuencia.programaauditoria.length.error",record.getProgramaauditoria().length()));
		if(record.getEstadoauditoria()!=null &&  record.getEstadoauditoria().length() > 1)
			throw new ValidateException(Messages.getString("siafexpedientesecuencia.estadoauditoria.length.error",record.getEstadoauditoria().length()));

		//Here Bussines Validations.
	}

	public void validateUpdate(Siafexpedientesecuencia record)throws Exception{
		if(record.getIdsiafexpedientesecuencia()==null)
			throw new ValidateException(Messages.getString("siafexpedientesecuencia.idsiafexpedientesecuencia.required"));
		if(record.getIdlog()==null)
			throw new ValidateException(Messages.getString("siafexpedientesecuencia.idlog.required"));
		if(record.getAnio()==null)
			throw new ValidateException(Messages.getString("siafexpedientesecuencia.anio.required"));
		if(record.getSecejec()==null)
			throw new ValidateException(Messages.getString("siafexpedientesecuencia.secejec.required"));
		if(record.getExpediente()==null)
			throw new ValidateException(Messages.getString("siafexpedientesecuencia.expediente.required"));
		if(record.getCiclo()==null)
			throw new ValidateException(Messages.getString("siafexpedientesecuencia.ciclo.required"));
		if(record.getFase()==null)
			throw new ValidateException(Messages.getString("siafexpedientesecuencia.fase.required"));

		if(record.getAnio()!=null &&  record.getAnio().length() > 4)
			throw new ValidateException(Messages.getString("siafexpedientesecuencia.anio.length.error",record.getAnio().length()));
		if(record.getSecejec()!=null &&  record.getSecejec().length() > 6)
			throw new ValidateException(Messages.getString("siafexpedientesecuencia.secejec.length.error",record.getSecejec().length()));
		if(record.getExpediente()!=null &&  record.getExpediente().length() > 10)
			throw new ValidateException(Messages.getString("siafexpedientesecuencia.expediente.length.error",record.getExpediente().length()));
		if(record.getAnioproceso()!=null &&  record.getAnioproceso().length() > 4)
			throw new ValidateException(Messages.getString("siafexpedientesecuencia.anioproceso.length.error",record.getAnioproceso().length()));
		if(record.getCodigodocumento()!=null &&  record.getCodigodocumento().length() > 3)
			throw new ValidateException(Messages.getString("siafexpedientesecuencia.codigodocumento.length.error",record.getCodigodocumento().length()));
		if(record.getNumerodocumento()!=null &&  record.getNumerodocumento().length() > 20)
			throw new ValidateException(Messages.getString("siafexpedientesecuencia.numerodocumento.length.error",record.getNumerodocumento().length()));
		if(record.getMesproceso()!=null &&  record.getMesproceso().length() > 2)
			throw new ValidateException(Messages.getString("siafexpedientesecuencia.mesproceso.length.error",record.getMesproceso().length()));
		if(record.getCiclo()!=null &&  record.getCiclo().length() > 1)
			throw new ValidateException(Messages.getString("siafexpedientesecuencia.ciclo.length.error",record.getCiclo().length()));
		if(record.getFase()!=null &&  record.getFase().length() > 1)
			throw new ValidateException(Messages.getString("siafexpedientesecuencia.fase.length.error",record.getFase().length()));
		if(record.getUsuariocreacionauditoria()!=null &&  record.getUsuariocreacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("siafexpedientesecuencia.usuariocreacionauditoria.length.error",record.getUsuariocreacionauditoria().length()));
		if(record.getUsuariomodificacionauditoria()!=null &&  record.getUsuariomodificacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("siafexpedientesecuencia.usuariomodificacionauditoria.length.error",record.getUsuariomodificacionauditoria().length()));
		if(record.getEquipoauditoria()!=null &&  record.getEquipoauditoria().length() > 45)
			throw new ValidateException(Messages.getString("siafexpedientesecuencia.equipoauditoria.length.error",record.getEquipoauditoria().length()));
		if(record.getProgramaauditoria()!=null &&  record.getProgramaauditoria().length() > 200)
			throw new ValidateException(Messages.getString("siafexpedientesecuencia.programaauditoria.length.error",record.getProgramaauditoria().length()));
		if(record.getEstadoauditoria()!=null &&  record.getEstadoauditoria().length() > 1)
			throw new ValidateException(Messages.getString("siafexpedientesecuencia.estadoauditoria.length.error",record.getEstadoauditoria().length()));

		//Here Bussines Validations.
	}

	public void validateDelete(java.lang.Integer par_idsiafexpedientesecuencia)throws Exception{
		if(par_idsiafexpedientesecuencia==null)
			throw new ValidateException(Messages.getString("siafexpedientesecuencia.idsiafexpedientesecuencia.required"));

		//Here Bussines Validations.
	}


}

