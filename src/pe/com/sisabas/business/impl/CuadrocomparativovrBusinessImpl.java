
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
import pe.com.sisabas.be.Cuadrocomparativovr;
import pe.com.sisabas.persistence.CuadrocomparativovrMapper;
import pe.com.sisabas.business.CuadrocomparativovrBusiness;
import pe.com.sisabas.exception.BusinessException;
import pe.com.sisabas.exception.ValidateException;
import pe.com.sisabas.resources.Constantes;
import pe.com.sisabas.resources.Messages;
import pe.com.sisabas.resources.Sequence;
import pe.com.sisabas.resources.Utils;
import pe.com.sisabas.resources.business.UtilsBusiness;


@Service
public class CuadrocomparativovrBusinessImpl implements CuadrocomparativovrBusiness, Serializable{

	private static Logger logger=Logger.getLogger(CuadrocomparativovrBusinessImpl.class);

	private static final long serialVersionUID = 1L;

	@Autowired
	public CuadrocomparativovrMapper cuadrocomparativovrMapper;

	@Autowired
	public UtilsBusiness utilsBusiness;

	@Override
	public void deleteByPrimaryKeyBasic(Cuadrocomparativovr par_record) throws Exception {
		validateDelete(par_record.getIdcuadrocomparativovr());
		cuadrocomparativovrMapper.deleteByPrimaryKey(par_record.getIdcuadrocomparativovr());
	}

	@Override
	public void insertBasic(Cuadrocomparativovr record) throws Exception {
		record.setIdcuadrocomparativovr((int)utilsBusiness.getNextSeq(Sequence.SEQ_CUADROCOMPARATIVOVR).longValue());
		record.setFechacreacionauditoria(Utils.currentTimeStamp());
		record.setEstadoauditoria("1");
		updateBooleanToChar(record);
		validateInsert(record);
		Utils.convertPropertiesStringToUppercase(record);
		cuadrocomparativovrMapper.insert(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void insertFull(Cuadrocomparativovr record) throws Exception {
		//Business Logic
		insertBasic(record);
	}

	@Override
	public void insertSelectiveBasic(Cuadrocomparativovr record) throws Exception {
		record.setIdcuadrocomparativovr((int)utilsBusiness.getNextSeq(Sequence.SEQ_CUADROCOMPARATIVOVR).longValue());
		record.setFechacreacionauditoria(Utils.currentTimeStamp());
		record.setEstadoauditoria("1");
		updateBooleanToChar(record);
		Utils.convertPropertiesStringToUppercase(record);
		cuadrocomparativovrMapper.insertSelective(record);
	}

	@Override
	public Cuadrocomparativovr selectByPrimaryKeyBasic(java.lang.Integer par_idcuadrocomparativovr) throws Exception {
		return cuadrocomparativovrMapper.selectByPrimaryKeyBasic(par_idcuadrocomparativovr);
	}

	@Override
	public Cuadrocomparativovr selectByPrimaryKeyBasicFromList(java.lang.Integer par_idcuadrocomparativovr, List<Cuadrocomparativovr> list) throws Exception {
		Cuadrocomparativovr record=null;
		for (Cuadrocomparativovr row : list) {
			if(row.equals(new Cuadrocomparativovr( par_idcuadrocomparativovr))){
				record=row;
				break;
			}
		}
		if(record==null)
			record=selectByPrimaryKeyBasic( par_idcuadrocomparativovr);

		return record;
	}

	@Override
	public Cuadrocomparativovr selectByPrimaryKeyBasicActive(java.lang.Integer par_idcuadrocomparativovr) throws Exception {
		return cuadrocomparativovrMapper.selectByPrimaryKeyBasicActive(par_idcuadrocomparativovr);
	}

	@Override
	public Cuadrocomparativovr selectByPrimaryKeyFull(java.lang.Integer par_idcuadrocomparativovr) throws Exception {
		return cuadrocomparativovrMapper.selectByPrimaryKeyFull(par_idcuadrocomparativovr);
	}

	@Override
	public Cuadrocomparativovr selectByPrimaryKeyFullActive(java.lang.Integer par_idcuadrocomparativovr) throws Exception {
		return cuadrocomparativovrMapper.selectByPrimaryKeyFullActive(par_idcuadrocomparativovr);
	}

	@Override
	public List<Cuadrocomparativovr> selectDynamicBasic(Cuadrocomparativovr record) throws Exception {
		return cuadrocomparativovrMapper.selectDynamicBasic(record);
	}

	@Override
	public List<Cuadrocomparativovr> selectDynamicBasicActives(Cuadrocomparativovr record) throws Exception {
		record.setEstadoauditoria("1");
		return cuadrocomparativovrMapper.selectDynamicBasic(record);
	}

	@Override
	public List<Cuadrocomparativovr> selectDynamicFull(Cuadrocomparativovr record) throws Exception {
		List<Cuadrocomparativovr> list=cuadrocomparativovrMapper.selectDynamicFull(record);
		if(Cuadrocomparativovr.HAVE_BIGDECIMALS)
		for (Cuadrocomparativovr row : list) {
			row.roundBigDecimals();
		}

		return list;
	}

	@Override
	public List<Cuadrocomparativovr> selectDynamicFullActives(Cuadrocomparativovr record) throws Exception {
		record.setEstadoauditoria("1");
		return cuadrocomparativovrMapper.selectDynamicFull(record);
	}

	@Override
	public List<Cuadrocomparativovr> selectDynamicExtended(Cuadrocomparativovr record) throws Exception {
		return cuadrocomparativovrMapper.selectDynamicExtended(record);
	}

	@Override
	public List<Cuadrocomparativovr> selectDynamicExtendedActives(Cuadrocomparativovr record) throws Exception {
		record.setEstadoauditoria("1");
		return cuadrocomparativovrMapper.selectDynamicExtended(record);
	}

	@Override
	public void updateByPrimaryKeySelectiveBasic(Cuadrocomparativovr record) throws Exception {
		record.setFechamodificacionauditoria(Utils.currentTimeStamp());
		updateBooleanToChar(record);
		Utils.convertPropertiesStringToUppercase(record);
		cuadrocomparativovrMapper.updateByPrimaryKeySelective(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void updateByPrimaryKeySelectiveFull(Cuadrocomparativovr record) throws Exception {
		//Business Logic
		updateByPrimaryKeySelectiveBasic(record);
	}

	@Override
	public void updateByPrimaryKeyBasic(Cuadrocomparativovr record) throws Exception {
		record.setFechamodificacionauditoria(Utils.currentTimeStamp());
		updateBooleanToChar(record);
		validateUpdate(record);
		Utils.convertPropertiesStringToUppercase(record);
		cuadrocomparativovrMapper.updateByPrimaryKey(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void updateByPrimaryKeyFull(Cuadrocomparativovr record) throws Exception {
		//Business Logic
		updateByPrimaryKeyBasic(record);
	}

	public void updateBooleanToChar(Cuadrocomparativovr record) throws Exception {
	}

	public void validateInsert(Cuadrocomparativovr record)throws Exception{
		if(record.getIdcuadrocomparativovr()==null)
			throw new ValidateException(Messages.getString("cuadrocomparativovr.idcuadrocomparativovr.required"));

		if(record.getIdcatalogoprocedimientovr()!=null &&  record.getIdcatalogoprocedimientovr().length() > 10)
			throw new ValidateException(Messages.getString("cuadrocomparativovr.idcatalogoprocedimientovr.length.error",record.getIdcatalogoprocedimientovr().length()));
		if(record.getUsuariocreacionauditoria()!=null &&  record.getUsuariocreacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("cuadrocomparativovr.usuariocreacionauditoria.length.error",record.getUsuariocreacionauditoria().length()));
		if(record.getUsuariomodificacionauditoria()!=null &&  record.getUsuariomodificacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("cuadrocomparativovr.usuariomodificacionauditoria.length.error",record.getUsuariomodificacionauditoria().length()));
		if(record.getEquipoauditoria()!=null &&  record.getEquipoauditoria().length() > 45)
			throw new ValidateException(Messages.getString("cuadrocomparativovr.equipoauditoria.length.error",record.getEquipoauditoria().length()));
		if(record.getProgramaauditoria()!=null &&  record.getProgramaauditoria().length() > 200)
			throw new ValidateException(Messages.getString("cuadrocomparativovr.programaauditoria.length.error",record.getProgramaauditoria().length()));
		if(record.getEstadoauditoria()!=null &&  record.getEstadoauditoria().length() > 1)
			throw new ValidateException(Messages.getString("cuadrocomparativovr.estadoauditoria.length.error",record.getEstadoauditoria().length()));

		//Here Bussines Validations.
	}

	public void validateUpdate(Cuadrocomparativovr record)throws Exception{
		if(record.getIdcuadrocomparativovr()==null)
			throw new ValidateException(Messages.getString("cuadrocomparativovr.idcuadrocomparativovr.required"));

		if(record.getIdcatalogoprocedimientovr()!=null &&  record.getIdcatalogoprocedimientovr().length() > 10)
			throw new ValidateException(Messages.getString("cuadrocomparativovr.idcatalogoprocedimientovr.length.error",record.getIdcatalogoprocedimientovr().length()));
		if(record.getUsuariocreacionauditoria()!=null &&  record.getUsuariocreacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("cuadrocomparativovr.usuariocreacionauditoria.length.error",record.getUsuariocreacionauditoria().length()));
		if(record.getUsuariomodificacionauditoria()!=null &&  record.getUsuariomodificacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("cuadrocomparativovr.usuariomodificacionauditoria.length.error",record.getUsuariomodificacionauditoria().length()));
		if(record.getEquipoauditoria()!=null &&  record.getEquipoauditoria().length() > 45)
			throw new ValidateException(Messages.getString("cuadrocomparativovr.equipoauditoria.length.error",record.getEquipoauditoria().length()));
		if(record.getProgramaauditoria()!=null &&  record.getProgramaauditoria().length() > 200)
			throw new ValidateException(Messages.getString("cuadrocomparativovr.programaauditoria.length.error",record.getProgramaauditoria().length()));
		if(record.getEstadoauditoria()!=null &&  record.getEstadoauditoria().length() > 1)
			throw new ValidateException(Messages.getString("cuadrocomparativovr.estadoauditoria.length.error",record.getEstadoauditoria().length()));

		//Here Bussines Validations.
	}

	public void validateDelete(java.lang.Integer par_idcuadrocomparativovr)throws Exception{
		if(par_idcuadrocomparativovr==null)
			throw new ValidateException(Messages.getString("cuadrocomparativovr.idcuadrocomparativovr.required"));

		//Here Bussines Validations.
	}


}

