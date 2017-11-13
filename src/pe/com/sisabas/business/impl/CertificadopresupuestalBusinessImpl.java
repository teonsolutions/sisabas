
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
import pe.com.sisabas.be.Certificadopresupuestal;
import pe.com.sisabas.persistence.CertificadopresupuestalMapper;
import pe.com.sisabas.business.CertificadopresupuestalBusiness;
import pe.com.sisabas.exception.BusinessException;
import pe.com.sisabas.exception.ValidateException;
import pe.com.sisabas.resources.Constantes;
import pe.com.sisabas.resources.Messages;
import pe.com.sisabas.resources.Sequence;
import pe.com.sisabas.resources.Utils;
import pe.com.sisabas.resources.business.UtilsBusiness;


@Service
public class CertificadopresupuestalBusinessImpl implements CertificadopresupuestalBusiness, Serializable{

	private static Logger logger=Logger.getLogger(CertificadopresupuestalBusinessImpl.class);

	private static final long serialVersionUID = 1L;

	@Autowired
	public CertificadopresupuestalMapper certificadopresupuestalMapper;

	@Autowired
	public UtilsBusiness utilsBusiness;

	@Override
	public void deleteByPrimaryKeyBasic(Certificadopresupuestal par_record) throws Exception {
		validateDelete(par_record.getIdcertificadopresupuestal());
		certificadopresupuestalMapper.deleteByPrimaryKey(par_record.getIdcertificadopresupuestal());
	}

	@Override
	public void insertBasic(Certificadopresupuestal record) throws Exception {
		record.setIdcertificadopresupuestal((int)utilsBusiness.getNextSeq(Sequence.SEQ_CERTIFICADOPRESUPUESTAL).longValue());
		record.setFechacreacionauditoria(Utils.currentTimeStamp());
		record.setEstadoauditoria("1");
		updateBooleanToChar(record);
		validateInsert(record);
		Utils.convertPropertiesStringToUppercase(record);
		certificadopresupuestalMapper.insert(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void insertFull(Certificadopresupuestal record) throws Exception {
		//Business Logic
		insertBasic(record);
	}

	@Override
	public void insertSelectiveBasic(Certificadopresupuestal record) throws Exception {
		record.setIdcertificadopresupuestal((int)utilsBusiness.getNextSeq(Sequence.SEQ_CERTIFICADOPRESUPUESTAL).longValue());
		record.setFechacreacionauditoria(Utils.currentTimeStamp());
		record.setEstadoauditoria("1");
		updateBooleanToChar(record);
		Utils.convertPropertiesStringToUppercase(record);
		certificadopresupuestalMapper.insertSelective(record);
	}

	@Override
	public Certificadopresupuestal selectByPrimaryKeyBasic(java.lang.Integer par_idcertificadopresupuestal) throws Exception {
		return certificadopresupuestalMapper.selectByPrimaryKeyBasic(par_idcertificadopresupuestal);
	}

	@Override
	public Certificadopresupuestal selectByPrimaryKeyBasicFromList(java.lang.Integer par_idcertificadopresupuestal, List<Certificadopresupuestal> list) throws Exception {
		Certificadopresupuestal record=null;
		for (Certificadopresupuestal row : list) {
			if(row.equals(new Certificadopresupuestal( par_idcertificadopresupuestal))){
				record=row;
				break;
			}
		}
		if(record==null)
			record=selectByPrimaryKeyBasic( par_idcertificadopresupuestal);

		return record;
	}

	@Override
	public Certificadopresupuestal selectByPrimaryKeyBasicActive(java.lang.Integer par_idcertificadopresupuestal) throws Exception {
		return certificadopresupuestalMapper.selectByPrimaryKeyBasicActive(par_idcertificadopresupuestal);
	}

	@Override
	public Certificadopresupuestal selectByPrimaryKeyFull(java.lang.Integer par_idcertificadopresupuestal) throws Exception {
		return certificadopresupuestalMapper.selectByPrimaryKeyFull(par_idcertificadopresupuestal);
	}

	@Override
	public Certificadopresupuestal selectByPrimaryKeyFullActive(java.lang.Integer par_idcertificadopresupuestal) throws Exception {
		return certificadopresupuestalMapper.selectByPrimaryKeyFullActive(par_idcertificadopresupuestal);
	}

	@Override
	public List<Certificadopresupuestal> selectDynamicBasic(Certificadopresupuestal record) throws Exception {
		return certificadopresupuestalMapper.selectDynamicBasic(record);
	}

	@Override
	public List<Certificadopresupuestal> selectDynamicBasicActives(Certificadopresupuestal record) throws Exception {
		record.setEstadoauditoria("1");
		return certificadopresupuestalMapper.selectDynamicBasic(record);
	}

	@Override
	public List<Certificadopresupuestal> selectDynamicFull(Certificadopresupuestal record) throws Exception {
		List<Certificadopresupuestal> list=certificadopresupuestalMapper.selectDynamicFull(record);
		if(Certificadopresupuestal.HAVE_BIGDECIMALS)
		for (Certificadopresupuestal row : list) {
			row.roundBigDecimals();
		}

		return list;
	}

	@Override
	public List<Certificadopresupuestal> selectDynamicFullActives(Certificadopresupuestal record) throws Exception {
		record.setEstadoauditoria("1");
		return certificadopresupuestalMapper.selectDynamicFull(record);
	}

	@Override
	public List<Certificadopresupuestal> selectDynamicExtended(Certificadopresupuestal record) throws Exception {
		return certificadopresupuestalMapper.selectDynamicExtended(record);
	}

	@Override
	public List<Certificadopresupuestal> selectDynamicExtendedActives(Certificadopresupuestal record) throws Exception {
		record.setEstadoauditoria("1");
		return certificadopresupuestalMapper.selectDynamicExtended(record);
	}

	@Override
	public void updateByPrimaryKeySelectiveBasic(Certificadopresupuestal record) throws Exception {
		record.setFechamodificacionauditoria(Utils.currentTimeStamp());
		updateBooleanToChar(record);
		Utils.convertPropertiesStringToUppercase(record);
		certificadopresupuestalMapper.updateByPrimaryKeySelective(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void updateByPrimaryKeySelectiveFull(Certificadopresupuestal record) throws Exception {
		//Business Logic
		updateByPrimaryKeySelectiveBasic(record);
	}

	@Override
	public void updateByPrimaryKeyBasic(Certificadopresupuestal record) throws Exception {
		record.setFechamodificacionauditoria(Utils.currentTimeStamp());
		updateBooleanToChar(record);
		validateUpdate(record);
		Utils.convertPropertiesStringToUppercase(record);
		certificadopresupuestalMapper.updateByPrimaryKey(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void updateByPrimaryKeyFull(Certificadopresupuestal record) throws Exception {
		//Business Logic
		updateByPrimaryKeyBasic(record);
	}

	public void updateBooleanToChar(Certificadopresupuestal record) throws Exception {
	}

	public void validateInsert(Certificadopresupuestal record)throws Exception{
		if(record.getIdcertificadopresupuestal()==null)
			throw new ValidateException(Messages.getString("certificadopresupuestal.idcertificadopresupuestal.required"));
		if(record.getAnio()==null)
			throw new ValidateException(Messages.getString("certificadopresupuestal.anio.required"));
		if(record.getSecejec()==null)
			throw new ValidateException(Messages.getString("certificadopresupuestal.secejec.required"));
		if(record.getNrocertifica()==null)
			throw new ValidateException(Messages.getString("certificadopresupuestal.nrocertifica.required"));

		if(record.getMesproceso()!=null &&  record.getMesproceso().length() > 2)
			throw new ValidateException(Messages.getString("certificadopresupuestal.mesproceso.length.error",record.getMesproceso().length()));
		if(record.getEstadocertifica()!=null &&  record.getEstadocertifica().length() > 30)
			throw new ValidateException(Messages.getString("certificadopresupuestal.estadocertifica.length.error",record.getEstadocertifica().length()));
		if(record.getUsuariocreacionauditoria()!=null &&  record.getUsuariocreacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("certificadopresupuestal.usuariocreacionauditoria.length.error",record.getUsuariocreacionauditoria().length()));
		if(record.getUsuariomodificacionauditoria()!=null &&  record.getUsuariomodificacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("certificadopresupuestal.usuariomodificacionauditoria.length.error",record.getUsuariomodificacionauditoria().length()));
		if(record.getEquipoauditoria()!=null &&  record.getEquipoauditoria().length() > 45)
			throw new ValidateException(Messages.getString("certificadopresupuestal.equipoauditoria.length.error",record.getEquipoauditoria().length()));
		if(record.getProgramaauditoria()!=null &&  record.getProgramaauditoria().length() > 200)
			throw new ValidateException(Messages.getString("certificadopresupuestal.programaauditoria.length.error",record.getProgramaauditoria().length()));
		if(record.getEstadoauditoria()!=null &&  record.getEstadoauditoria().length() > 1)
			throw new ValidateException(Messages.getString("certificadopresupuestal.estadoauditoria.length.error",record.getEstadoauditoria().length()));

		//Here Bussines Validations.
	}

	public void validateUpdate(Certificadopresupuestal record)throws Exception{
		if(record.getIdcertificadopresupuestal()==null)
			throw new ValidateException(Messages.getString("certificadopresupuestal.idcertificadopresupuestal.required"));
		if(record.getAnio()==null)
			throw new ValidateException(Messages.getString("certificadopresupuestal.anio.required"));
		if(record.getSecejec()==null)
			throw new ValidateException(Messages.getString("certificadopresupuestal.secejec.required"));
		if(record.getNrocertifica()==null)
			throw new ValidateException(Messages.getString("certificadopresupuestal.nrocertifica.required"));

		if(record.getMesproceso()!=null &&  record.getMesproceso().length() > 2)
			throw new ValidateException(Messages.getString("certificadopresupuestal.mesproceso.length.error",record.getMesproceso().length()));
		if(record.getEstadocertifica()!=null &&  record.getEstadocertifica().length() > 30)
			throw new ValidateException(Messages.getString("certificadopresupuestal.estadocertifica.length.error",record.getEstadocertifica().length()));
		if(record.getUsuariocreacionauditoria()!=null &&  record.getUsuariocreacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("certificadopresupuestal.usuariocreacionauditoria.length.error",record.getUsuariocreacionauditoria().length()));
		if(record.getUsuariomodificacionauditoria()!=null &&  record.getUsuariomodificacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("certificadopresupuestal.usuariomodificacionauditoria.length.error",record.getUsuariomodificacionauditoria().length()));
		if(record.getEquipoauditoria()!=null &&  record.getEquipoauditoria().length() > 45)
			throw new ValidateException(Messages.getString("certificadopresupuestal.equipoauditoria.length.error",record.getEquipoauditoria().length()));
		if(record.getProgramaauditoria()!=null &&  record.getProgramaauditoria().length() > 200)
			throw new ValidateException(Messages.getString("certificadopresupuestal.programaauditoria.length.error",record.getProgramaauditoria().length()));
		if(record.getEstadoauditoria()!=null &&  record.getEstadoauditoria().length() > 1)
			throw new ValidateException(Messages.getString("certificadopresupuestal.estadoauditoria.length.error",record.getEstadoauditoria().length()));

		//Here Bussines Validations.
	}

	public void validateDelete(java.lang.Integer par_idcertificadopresupuestal)throws Exception{
		if(par_idcertificadopresupuestal==null)
			throw new ValidateException(Messages.getString("certificadopresupuestal.idcertificadopresupuestal.required"));

		//Here Bussines Validations.
	}


}

