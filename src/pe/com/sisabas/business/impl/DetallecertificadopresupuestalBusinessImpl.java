
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
import pe.com.sisabas.be.Detallecertificadopresupuestal;
import pe.com.sisabas.persistence.DetallecertificadopresupuestalMapper;
import pe.com.sisabas.business.DetallecertificadopresupuestalBusiness;
import pe.com.sisabas.exception.BusinessException;
import pe.com.sisabas.exception.ValidateException;
import pe.com.sisabas.resources.Constantes;
import pe.com.sisabas.resources.Messages;
import pe.com.sisabas.resources.Sequence;
import pe.com.sisabas.resources.Utils;
import pe.com.sisabas.resources.business.UtilsBusiness;


@Service
public class DetallecertificadopresupuestalBusinessImpl implements DetallecertificadopresupuestalBusiness, Serializable{

	private static Logger logger=Logger.getLogger(DetallecertificadopresupuestalBusinessImpl.class);

	private static final long serialVersionUID = 1L;

	@Autowired
	public DetallecertificadopresupuestalMapper detallecertificadopresupuestalMapper;

	@Autowired
	public UtilsBusiness utilsBusiness;

	@Override
	public void deleteByPrimaryKeyBasic(Detallecertificadopresupuestal par_record) throws Exception {
		validateDelete(par_record.getIddetallecertificadopresupuestal());
		detallecertificadopresupuestalMapper.deleteByPrimaryKey(par_record.getIddetallecertificadopresupuestal());
	}

	@Override
	public void insertBasic(Detallecertificadopresupuestal record) throws Exception {
		record.setIddetallecertificadopresupuestal((int)utilsBusiness.getNextSeq(Sequence.SEQ_DETALLECERTIFICADOPRESUPUESTAL).longValue());
		record.setFechacreacionauditoria(Utils.currentTimeStamp());
		record.setEstadoauditoria("1");
		updateBooleanToChar(record);
		validateInsert(record);
		Utils.convertPropertiesStringToUppercase(record);
		detallecertificadopresupuestalMapper.insert(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void insertFull(Detallecertificadopresupuestal record) throws Exception {
		//Business Logic
		insertBasic(record);
	}

	@Override
	public void insertSelectiveBasic(Detallecertificadopresupuestal record) throws Exception {
		record.setIddetallecertificadopresupuestal((int)utilsBusiness.getNextSeq(Sequence.SEQ_DETALLECERTIFICADOPRESUPUESTAL).longValue());
		record.setFechacreacionauditoria(Utils.currentTimeStamp());
		record.setEstadoauditoria("1");
		updateBooleanToChar(record);
		Utils.convertPropertiesStringToUppercase(record);
		detallecertificadopresupuestalMapper.insertSelective(record);
	}

	@Override
	public Detallecertificadopresupuestal selectByPrimaryKeyBasic(java.lang.Integer par_iddetallecertificadopresupuestal) throws Exception {
		return detallecertificadopresupuestalMapper.selectByPrimaryKeyBasic(par_iddetallecertificadopresupuestal);
	}

	@Override
	public Detallecertificadopresupuestal selectByPrimaryKeyBasicFromList(java.lang.Integer par_iddetallecertificadopresupuestal, List<Detallecertificadopresupuestal> list) throws Exception {
		Detallecertificadopresupuestal record=null;
		for (Detallecertificadopresupuestal row : list) {
			if(row.equals(new Detallecertificadopresupuestal( par_iddetallecertificadopresupuestal))){
				record=row;
				break;
			}
		}
		if(record==null)
			record=selectByPrimaryKeyBasic( par_iddetallecertificadopresupuestal);

		return record;
	}

	@Override
	public Detallecertificadopresupuestal selectByPrimaryKeyBasicActive(java.lang.Integer par_iddetallecertificadopresupuestal) throws Exception {
		return detallecertificadopresupuestalMapper.selectByPrimaryKeyBasicActive(par_iddetallecertificadopresupuestal);
	}

	@Override
	public Detallecertificadopresupuestal selectByPrimaryKeyFull(java.lang.Integer par_iddetallecertificadopresupuestal) throws Exception {
		return detallecertificadopresupuestalMapper.selectByPrimaryKeyFull(par_iddetallecertificadopresupuestal);
	}

	@Override
	public Detallecertificadopresupuestal selectByPrimaryKeyFullActive(java.lang.Integer par_iddetallecertificadopresupuestal) throws Exception {
		return detallecertificadopresupuestalMapper.selectByPrimaryKeyFullActive(par_iddetallecertificadopresupuestal);
	}

	@Override
	public List<Detallecertificadopresupuestal> selectDynamicBasic(Detallecertificadopresupuestal record) throws Exception {
		return detallecertificadopresupuestalMapper.selectDynamicBasic(record);
	}

	@Override
	public List<Detallecertificadopresupuestal> selectDynamicBasicActives(Detallecertificadopresupuestal record) throws Exception {
		record.setEstadoauditoria("1");
		return detallecertificadopresupuestalMapper.selectDynamicBasic(record);
	}

	@Override
	public List<Detallecertificadopresupuestal> selectDynamicFull(Detallecertificadopresupuestal record) throws Exception {
		List<Detallecertificadopresupuestal> list=detallecertificadopresupuestalMapper.selectDynamicFull(record);
		if(Detallecertificadopresupuestal.HAVE_BIGDECIMALS)
		for (Detallecertificadopresupuestal row : list) {
			row.roundBigDecimals();
		}

		return list;
	}

	@Override
	public List<Detallecertificadopresupuestal> selectDynamicFullActives(Detallecertificadopresupuestal record) throws Exception {
		record.setEstadoauditoria("1");
		return detallecertificadopresupuestalMapper.selectDynamicFull(record);
	}

	@Override
	public List<Detallecertificadopresupuestal> selectDynamicExtended(Detallecertificadopresupuestal record) throws Exception {
		return detallecertificadopresupuestalMapper.selectDynamicExtended(record);
	}

	@Override
	public List<Detallecertificadopresupuestal> selectDynamicExtendedActives(Detallecertificadopresupuestal record) throws Exception {
		record.setEstadoauditoria("1");
		return detallecertificadopresupuestalMapper.selectDynamicExtended(record);
	}

	@Override
	public void updateByPrimaryKeySelectiveBasic(Detallecertificadopresupuestal record) throws Exception {
		record.setFechamodificacionauditoria(Utils.currentTimeStamp());
		updateBooleanToChar(record);
		Utils.convertPropertiesStringToUppercase(record);
		detallecertificadopresupuestalMapper.updateByPrimaryKeySelective(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void updateByPrimaryKeySelectiveFull(Detallecertificadopresupuestal record) throws Exception {
		//Business Logic
		updateByPrimaryKeySelectiveBasic(record);
	}

	@Override
	public void updateByPrimaryKeyBasic(Detallecertificadopresupuestal record) throws Exception {
		record.setFechamodificacionauditoria(Utils.currentTimeStamp());
		updateBooleanToChar(record);
		validateUpdate(record);
		Utils.convertPropertiesStringToUppercase(record);
		detallecertificadopresupuestalMapper.updateByPrimaryKey(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void updateByPrimaryKeyFull(Detallecertificadopresupuestal record) throws Exception {
		//Business Logic
		updateByPrimaryKeyBasic(record);
	}

	public void updateBooleanToChar(Detallecertificadopresupuestal record) throws Exception {
	}

	public void validateInsert(Detallecertificadopresupuestal record)throws Exception{
		if(record.getIddetallecertificadopresupuestal()==null)
			throw new ValidateException(Messages.getString("detallecertificadopresupuestal.iddetallecertificadopresupuestal.required"));
		if(record.getAnio()==null)
			throw new ValidateException(Messages.getString("detallecertificadopresupuestal.anio.required"));
		if(record.getSecejec()==null)
			throw new ValidateException(Messages.getString("detallecertificadopresupuestal.secejec.required"));
		if(record.getNrocertifica()==null)
			throw new ValidateException(Messages.getString("detallecertificadopresupuestal.nrocertifica.required"));

		if(record.getFuentefinancimiento()!=null &&  record.getFuentefinancimiento().length() > 2)
			throw new ValidateException(Messages.getString("detallecertificadopresupuestal.fuentefinancimiento.length.error",record.getFuentefinancimiento().length()));
		if(record.getSecuencia()!=null &&  record.getSecuencia().length() > 5)
			throw new ValidateException(Messages.getString("detallecertificadopresupuestal.secuencia.length.error",record.getSecuencia().length()));
		if(record.getClasificador()!=null &&  record.getClasificador().length() > 20)
			throw new ValidateException(Messages.getString("detallecertificadopresupuestal.clasificador.length.error",record.getClasificador().length()));
		if(record.getCodigocentrocosto()!=null &&  record.getCodigocentrocosto().length() > 15)
			throw new ValidateException(Messages.getString("detallecertificadopresupuestal.codigocentrocosto.length.error",record.getCodigocentrocosto().length()));
		if(record.getUsuariocreacionauditoria()!=null &&  record.getUsuariocreacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("detallecertificadopresupuestal.usuariocreacionauditoria.length.error",record.getUsuariocreacionauditoria().length()));
		if(record.getUsuariomodificacionauditoria()!=null &&  record.getUsuariomodificacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("detallecertificadopresupuestal.usuariomodificacionauditoria.length.error",record.getUsuariomodificacionauditoria().length()));
		if(record.getEquipoauditoria()!=null &&  record.getEquipoauditoria().length() > 45)
			throw new ValidateException(Messages.getString("detallecertificadopresupuestal.equipoauditoria.length.error",record.getEquipoauditoria().length()));
		if(record.getProgramaauditoria()!=null &&  record.getProgramaauditoria().length() > 200)
			throw new ValidateException(Messages.getString("detallecertificadopresupuestal.programaauditoria.length.error",record.getProgramaauditoria().length()));
		if(record.getEstadoauditoria()!=null &&  record.getEstadoauditoria().length() > 1)
			throw new ValidateException(Messages.getString("detallecertificadopresupuestal.estadoauditoria.length.error",record.getEstadoauditoria().length()));

		//Here Bussines Validations.
	}

	public void validateUpdate(Detallecertificadopresupuestal record)throws Exception{
		if(record.getIddetallecertificadopresupuestal()==null)
			throw new ValidateException(Messages.getString("detallecertificadopresupuestal.iddetallecertificadopresupuestal.required"));
		if(record.getAnio()==null)
			throw new ValidateException(Messages.getString("detallecertificadopresupuestal.anio.required"));
		if(record.getSecejec()==null)
			throw new ValidateException(Messages.getString("detallecertificadopresupuestal.secejec.required"));
		if(record.getNrocertifica()==null)
			throw new ValidateException(Messages.getString("detallecertificadopresupuestal.nrocertifica.required"));

		if(record.getFuentefinancimiento()!=null &&  record.getFuentefinancimiento().length() > 2)
			throw new ValidateException(Messages.getString("detallecertificadopresupuestal.fuentefinancimiento.length.error",record.getFuentefinancimiento().length()));
		if(record.getSecuencia()!=null &&  record.getSecuencia().length() > 5)
			throw new ValidateException(Messages.getString("detallecertificadopresupuestal.secuencia.length.error",record.getSecuencia().length()));
		if(record.getClasificador()!=null &&  record.getClasificador().length() > 20)
			throw new ValidateException(Messages.getString("detallecertificadopresupuestal.clasificador.length.error",record.getClasificador().length()));
		if(record.getCodigocentrocosto()!=null &&  record.getCodigocentrocosto().length() > 15)
			throw new ValidateException(Messages.getString("detallecertificadopresupuestal.codigocentrocosto.length.error",record.getCodigocentrocosto().length()));
		if(record.getUsuariocreacionauditoria()!=null &&  record.getUsuariocreacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("detallecertificadopresupuestal.usuariocreacionauditoria.length.error",record.getUsuariocreacionauditoria().length()));
		if(record.getUsuariomodificacionauditoria()!=null &&  record.getUsuariomodificacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("detallecertificadopresupuestal.usuariomodificacionauditoria.length.error",record.getUsuariomodificacionauditoria().length()));
		if(record.getEquipoauditoria()!=null &&  record.getEquipoauditoria().length() > 45)
			throw new ValidateException(Messages.getString("detallecertificadopresupuestal.equipoauditoria.length.error",record.getEquipoauditoria().length()));
		if(record.getProgramaauditoria()!=null &&  record.getProgramaauditoria().length() > 200)
			throw new ValidateException(Messages.getString("detallecertificadopresupuestal.programaauditoria.length.error",record.getProgramaauditoria().length()));
		if(record.getEstadoauditoria()!=null &&  record.getEstadoauditoria().length() > 1)
			throw new ValidateException(Messages.getString("detallecertificadopresupuestal.estadoauditoria.length.error",record.getEstadoauditoria().length()));

		//Here Bussines Validations.
	}

	public void validateDelete(java.lang.Integer par_iddetallecertificadopresupuestal)throws Exception{
		if(par_iddetallecertificadopresupuestal==null)
			throw new ValidateException(Messages.getString("detallecertificadopresupuestal.iddetallecertificadopresupuestal.required"));

		//Here Bussines Validations.
	}


}

