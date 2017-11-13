
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
import pe.com.sisabas.be.Previsionpresupuestal;
import pe.com.sisabas.persistence.PrevisionpresupuestalMapper;
import pe.com.sisabas.business.PrevisionpresupuestalBusiness;
import pe.com.sisabas.exception.BusinessException;
import pe.com.sisabas.exception.ValidateException;
import pe.com.sisabas.resources.Constantes;
import pe.com.sisabas.resources.Messages;
import pe.com.sisabas.resources.Sequence;
import pe.com.sisabas.resources.Utils;
import pe.com.sisabas.resources.business.UtilsBusiness;


@Service
public class PrevisionpresupuestalBusinessImpl implements PrevisionpresupuestalBusiness, Serializable{

	private static Logger logger=Logger.getLogger(PrevisionpresupuestalBusinessImpl.class);

	private static final long serialVersionUID = 1L;

	@Autowired
	public PrevisionpresupuestalMapper previsionpresupuestalMapper;

	@Autowired
	public UtilsBusiness utilsBusiness;

	@Override
	public void deleteByPrimaryKeyBasic(Previsionpresupuestal par_record) throws Exception {
		validateDelete(par_record.getIdprevisionpresupuestal());
		previsionpresupuestalMapper.deleteByPrimaryKey(par_record.getIdprevisionpresupuestal());
	}

	@Override
	public void insertBasic(Previsionpresupuestal record) throws Exception {
		record.setIdprevisionpresupuestal((int)utilsBusiness.getNextSeq(Sequence.SEQ_PREVISIONPRESUPUESTAL).longValue());
		record.setFechacreacionauditoria(Utils.currentTimeStamp());
		record.setEstadoauditoria("1");
		updateBooleanToChar(record);
		validateInsert(record);
		Utils.convertPropertiesStringToUppercase(record);
		previsionpresupuestalMapper.insert(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void insertFull(Previsionpresupuestal record) throws Exception {
		//Business Logic
		insertBasic(record);
	}

	@Override
	public void insertSelectiveBasic(Previsionpresupuestal record) throws Exception {
		record.setIdprevisionpresupuestal((int)utilsBusiness.getNextSeq(Sequence.SEQ_PREVISIONPRESUPUESTAL).longValue());
		record.setFechacreacionauditoria(Utils.currentTimeStamp());
		record.setEstadoauditoria("1");
		updateBooleanToChar(record);
		Utils.convertPropertiesStringToUppercase(record);
		previsionpresupuestalMapper.insertSelective(record);
	}

	@Override
	public Previsionpresupuestal selectByPrimaryKeyBasic(java.lang.Integer par_idprevisionpresupuestal) throws Exception {
		return previsionpresupuestalMapper.selectByPrimaryKeyBasic(par_idprevisionpresupuestal);
	}

	@Override
	public Previsionpresupuestal selectByPrimaryKeyBasicFromList(java.lang.Integer par_idprevisionpresupuestal, List<Previsionpresupuestal> list) throws Exception {
		Previsionpresupuestal record=null;
		for (Previsionpresupuestal row : list) {
			if(row.equals(new Previsionpresupuestal( par_idprevisionpresupuestal))){
				record=row;
				break;
			}
		}
		if(record==null)
			record=selectByPrimaryKeyBasic( par_idprevisionpresupuestal);

		return record;
	}

	@Override
	public Previsionpresupuestal selectByPrimaryKeyBasicActive(java.lang.Integer par_idprevisionpresupuestal) throws Exception {
		return previsionpresupuestalMapper.selectByPrimaryKeyBasicActive(par_idprevisionpresupuestal);
	}

	@Override
	public Previsionpresupuestal selectByPrimaryKeyFull(java.lang.Integer par_idprevisionpresupuestal) throws Exception {
		return previsionpresupuestalMapper.selectByPrimaryKeyFull(par_idprevisionpresupuestal);
	}

	@Override
	public Previsionpresupuestal selectByPrimaryKeyFullActive(java.lang.Integer par_idprevisionpresupuestal) throws Exception {
		return previsionpresupuestalMapper.selectByPrimaryKeyFullActive(par_idprevisionpresupuestal);
	}

	@Override
	public List<Previsionpresupuestal> selectDynamicBasic(Previsionpresupuestal record) throws Exception {
		return previsionpresupuestalMapper.selectDynamicBasic(record);
	}

	@Override
	public List<Previsionpresupuestal> selectDynamicBasicActives(Previsionpresupuestal record) throws Exception {
		record.setEstadoauditoria("1");
		return previsionpresupuestalMapper.selectDynamicBasic(record);
	}

	@Override
	public List<Previsionpresupuestal> selectDynamicFull(Previsionpresupuestal record) throws Exception {
		List<Previsionpresupuestal> list=previsionpresupuestalMapper.selectDynamicFull(record);
		if(Previsionpresupuestal.HAVE_BIGDECIMALS)
		for (Previsionpresupuestal row : list) {
			row.roundBigDecimals();
		}

		return list;
	}

	@Override
	public List<Previsionpresupuestal> selectDynamicFullActives(Previsionpresupuestal record) throws Exception {
		record.setEstadoauditoria("1");
		return previsionpresupuestalMapper.selectDynamicFull(record);
	}

	@Override
	public List<Previsionpresupuestal> selectDynamicExtended(Previsionpresupuestal record) throws Exception {
		return previsionpresupuestalMapper.selectDynamicExtended(record);
	}

	@Override
	public List<Previsionpresupuestal> selectDynamicExtendedActives(Previsionpresupuestal record) throws Exception {
		record.setEstadoauditoria("1");
		return previsionpresupuestalMapper.selectDynamicExtended(record);
	}

	@Override
	public void updateByPrimaryKeySelectiveBasic(Previsionpresupuestal record) throws Exception {
		record.setFechamodificacionauditoria(Utils.currentTimeStamp());
		updateBooleanToChar(record);
		Utils.convertPropertiesStringToUppercase(record);
		previsionpresupuestalMapper.updateByPrimaryKeySelective(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void updateByPrimaryKeySelectiveFull(Previsionpresupuestal record) throws Exception {
		//Business Logic
		updateByPrimaryKeySelectiveBasic(record);
	}

	@Override
	public void updateByPrimaryKeyBasic(Previsionpresupuestal record) throws Exception {
		record.setFechamodificacionauditoria(Utils.currentTimeStamp());
		updateBooleanToChar(record);
		validateUpdate(record);
		Utils.convertPropertiesStringToUppercase(record);
		previsionpresupuestalMapper.updateByPrimaryKey(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void updateByPrimaryKeyFull(Previsionpresupuestal record) throws Exception {
		//Business Logic
		updateByPrimaryKeyBasic(record);
	}

	public void updateBooleanToChar(Previsionpresupuestal record) throws Exception {
	}

	public void validateInsert(Previsionpresupuestal record)throws Exception{
		if(record.getIdprevisionpresupuestal()==null)
			throw new ValidateException(Messages.getString("previsionpresupuestal.idprevisionpresupuestal.required"));

		if(record.getNroprevision()!=null &&  record.getNroprevision().length() > 15)
			throw new ValidateException(Messages.getString("previsionpresupuestal.nroprevision.length.error",record.getNroprevision().length()));
		if(record.getNrodocumentoppto()!=null &&  record.getNrodocumentoppto().length() > 50)
			throw new ValidateException(Messages.getString("previsionpresupuestal.nrodocumentoppto.length.error",record.getNrodocumentoppto().length()));
		if(record.getNrodocumentooga()!=null &&  record.getNrodocumentooga().length() > 50)
			throw new ValidateException(Messages.getString("previsionpresupuestal.nrodocumentooga.length.error",record.getNrodocumentooga().length()));
		if(record.getAnio()!=null &&  record.getAnio().length() > 4)
			throw new ValidateException(Messages.getString("previsionpresupuestal.anio.length.error",record.getAnio().length()));
		if(record.getUsuariocreacionauditoria()!=null &&  record.getUsuariocreacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("previsionpresupuestal.usuariocreacionauditoria.length.error",record.getUsuariocreacionauditoria().length()));
		if(record.getUsuariomodificacionauditoria()!=null &&  record.getUsuariomodificacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("previsionpresupuestal.usuariomodificacionauditoria.length.error",record.getUsuariomodificacionauditoria().length()));
		if(record.getEquipoauditoria()!=null &&  record.getEquipoauditoria().length() > 45)
			throw new ValidateException(Messages.getString("previsionpresupuestal.equipoauditoria.length.error",record.getEquipoauditoria().length()));
		if(record.getProgramaauditoria()!=null &&  record.getProgramaauditoria().length() > 200)
			throw new ValidateException(Messages.getString("previsionpresupuestal.programaauditoria.length.error",record.getProgramaauditoria().length()));
		if(record.getEstadoauditoria()!=null &&  record.getEstadoauditoria().length() > 1)
			throw new ValidateException(Messages.getString("previsionpresupuestal.estadoauditoria.length.error",record.getEstadoauditoria().length()));

		//Here Bussines Validations.
	}

	public void validateUpdate(Previsionpresupuestal record)throws Exception{
		if(record.getIdprevisionpresupuestal()==null)
			throw new ValidateException(Messages.getString("previsionpresupuestal.idprevisionpresupuestal.required"));

		if(record.getNroprevision()!=null &&  record.getNroprevision().length() > 15)
			throw new ValidateException(Messages.getString("previsionpresupuestal.nroprevision.length.error",record.getNroprevision().length()));
		if(record.getNrodocumentoppto()!=null &&  record.getNrodocumentoppto().length() > 50)
			throw new ValidateException(Messages.getString("previsionpresupuestal.nrodocumentoppto.length.error",record.getNrodocumentoppto().length()));
		if(record.getNrodocumentooga()!=null &&  record.getNrodocumentooga().length() > 50)
			throw new ValidateException(Messages.getString("previsionpresupuestal.nrodocumentooga.length.error",record.getNrodocumentooga().length()));
		if(record.getAnio()!=null &&  record.getAnio().length() > 4)
			throw new ValidateException(Messages.getString("previsionpresupuestal.anio.length.error",record.getAnio().length()));
		if(record.getUsuariocreacionauditoria()!=null &&  record.getUsuariocreacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("previsionpresupuestal.usuariocreacionauditoria.length.error",record.getUsuariocreacionauditoria().length()));
		if(record.getUsuariomodificacionauditoria()!=null &&  record.getUsuariomodificacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("previsionpresupuestal.usuariomodificacionauditoria.length.error",record.getUsuariomodificacionauditoria().length()));
		if(record.getEquipoauditoria()!=null &&  record.getEquipoauditoria().length() > 45)
			throw new ValidateException(Messages.getString("previsionpresupuestal.equipoauditoria.length.error",record.getEquipoauditoria().length()));
		if(record.getProgramaauditoria()!=null &&  record.getProgramaauditoria().length() > 200)
			throw new ValidateException(Messages.getString("previsionpresupuestal.programaauditoria.length.error",record.getProgramaauditoria().length()));
		if(record.getEstadoauditoria()!=null &&  record.getEstadoauditoria().length() > 1)
			throw new ValidateException(Messages.getString("previsionpresupuestal.estadoauditoria.length.error",record.getEstadoauditoria().length()));

		//Here Bussines Validations.
	}

	public void validateDelete(java.lang.Integer par_idprevisionpresupuestal)throws Exception{
		if(par_idprevisionpresupuestal==null)
			throw new ValidateException(Messages.getString("previsionpresupuestal.idprevisionpresupuestal.required"));

		//Here Bussines Validations.
	}


}

