
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
import pe.com.sisabas.be.Cuadrocomparativoitem;
import pe.com.sisabas.persistence.CuadrocomparativoitemMapper;
import pe.com.sisabas.business.CuadrocomparativoitemBusiness;
import pe.com.sisabas.exception.BusinessException;
import pe.com.sisabas.exception.ValidateException;
import pe.com.sisabas.resources.Constantes;
import pe.com.sisabas.resources.Messages;
import pe.com.sisabas.resources.Sequence;
import pe.com.sisabas.resources.Utils;
import pe.com.sisabas.resources.business.UtilsBusiness;


@Service
public class CuadrocomparativoitemBusinessImpl implements CuadrocomparativoitemBusiness, Serializable{

	private static Logger logger=Logger.getLogger(CuadrocomparativoitemBusinessImpl.class);

	private static final long serialVersionUID = 1L;

	@Autowired
	public CuadrocomparativoitemMapper cuadrocomparativoitemMapper;

	@Autowired
	public UtilsBusiness utilsBusiness;

	@Override
	public void deleteByPrimaryKeyBasic(Cuadrocomparativoitem par_record) throws Exception {
		validateDelete(par_record.getIdcuadrocomparativoitem());
		cuadrocomparativoitemMapper.deleteByPrimaryKey(par_record.getIdcuadrocomparativoitem());
	}

	@Override
	public void insertBasic(Cuadrocomparativoitem record) throws Exception {
		record.setIdcuadrocomparativoitem((int)utilsBusiness.getNextSeq(Sequence.SEQ_CUADROCOMPARATIVOITEM).longValue());
		record.setFechacreacionauditoria(Utils.currentTimeStamp());
		record.setEstadoauditoria("1");
		updateBooleanToChar(record);
		validateInsert(record);
		Utils.convertPropertiesStringToUppercase(record);
		cuadrocomparativoitemMapper.insert(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void insertFull(Cuadrocomparativoitem record) throws Exception {
		//Business Logic
		insertBasic(record);
	}

	@Override
	public void insertSelectiveBasic(Cuadrocomparativoitem record) throws Exception {
		record.setIdcuadrocomparativoitem((int)utilsBusiness.getNextSeq(Sequence.SEQ_CUADROCOMPARATIVOITEM).longValue());
		record.setFechacreacionauditoria(Utils.currentTimeStamp());
		record.setEstadoauditoria("1");
		updateBooleanToChar(record);
		Utils.convertPropertiesStringToUppercase(record);
		cuadrocomparativoitemMapper.insertSelective(record);
	}

	@Override
	public Cuadrocomparativoitem selectByPrimaryKeyBasic(java.lang.Integer par_idcuadrocomparativoitem) throws Exception {
		return cuadrocomparativoitemMapper.selectByPrimaryKeyBasic(par_idcuadrocomparativoitem);
	}

	@Override
	public Cuadrocomparativoitem selectByPrimaryKeyBasicFromList(java.lang.Integer par_idcuadrocomparativoitem, List<Cuadrocomparativoitem> list) throws Exception {
		Cuadrocomparativoitem record=null;
		for (Cuadrocomparativoitem row : list) {
			if(row.equals(new Cuadrocomparativoitem( par_idcuadrocomparativoitem))){
				record=row;
				break;
			}
		}
		if(record==null)
			record=selectByPrimaryKeyBasic( par_idcuadrocomparativoitem);

		return record;
	}

	@Override
	public Cuadrocomparativoitem selectByPrimaryKeyBasicActive(java.lang.Integer par_idcuadrocomparativoitem) throws Exception {
		return cuadrocomparativoitemMapper.selectByPrimaryKeyBasicActive(par_idcuadrocomparativoitem);
	}

	@Override
	public Cuadrocomparativoitem selectByPrimaryKeyFull(java.lang.Integer par_idcuadrocomparativoitem) throws Exception {
		return cuadrocomparativoitemMapper.selectByPrimaryKeyFull(par_idcuadrocomparativoitem);
	}

	@Override
	public Cuadrocomparativoitem selectByPrimaryKeyFullActive(java.lang.Integer par_idcuadrocomparativoitem) throws Exception {
		return cuadrocomparativoitemMapper.selectByPrimaryKeyFullActive(par_idcuadrocomparativoitem);
	}

	@Override
	public List<Cuadrocomparativoitem> selectDynamicBasic(Cuadrocomparativoitem record) throws Exception {
		return cuadrocomparativoitemMapper.selectDynamicBasic(record);
	}

	@Override
	public List<Cuadrocomparativoitem> selectDynamicBasicActives(Cuadrocomparativoitem record) throws Exception {
		record.setEstadoauditoria("1");
		return cuadrocomparativoitemMapper.selectDynamicBasic(record);
	}

	@Override
	public List<Cuadrocomparativoitem> selectDynamicFull(Cuadrocomparativoitem record) throws Exception {
		List<Cuadrocomparativoitem> list=cuadrocomparativoitemMapper.selectDynamicFull(record);
		if(Cuadrocomparativoitem.HAVE_BIGDECIMALS)
		for (Cuadrocomparativoitem row : list) {
			row.roundBigDecimals();
		}

		return list;
	}

	@Override
	public List<Cuadrocomparativoitem> selectDynamicFullActives(Cuadrocomparativoitem record) throws Exception {
		record.setEstadoauditoria("1");
		return cuadrocomparativoitemMapper.selectDynamicFull(record);
	}

	@Override
	public List<Cuadrocomparativoitem> selectDynamicExtended(Cuadrocomparativoitem record) throws Exception {
		return cuadrocomparativoitemMapper.selectDynamicExtended(record);
	}

	@Override
	public List<Cuadrocomparativoitem> selectDynamicExtendedActives(Cuadrocomparativoitem record) throws Exception {
		record.setEstadoauditoria("1");
		return cuadrocomparativoitemMapper.selectDynamicExtended(record);
	}

	@Override
	public void updateByPrimaryKeySelectiveBasic(Cuadrocomparativoitem record) throws Exception {
		record.setFechamodificacionauditoria(Utils.currentTimeStamp());
		updateBooleanToChar(record);
		Utils.convertPropertiesStringToUppercase(record);
		cuadrocomparativoitemMapper.updateByPrimaryKeySelective(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void updateByPrimaryKeySelectiveFull(Cuadrocomparativoitem record) throws Exception {
		//Business Logic
		updateByPrimaryKeySelectiveBasic(record);
	}

	@Override
	public void updateByPrimaryKeyBasic(Cuadrocomparativoitem record) throws Exception {
		record.setFechamodificacionauditoria(Utils.currentTimeStamp());
		updateBooleanToChar(record);
		validateUpdate(record);
		Utils.convertPropertiesStringToUppercase(record);
		cuadrocomparativoitemMapper.updateByPrimaryKey(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void updateByPrimaryKeyFull(Cuadrocomparativoitem record) throws Exception {
		//Business Logic
		updateByPrimaryKeyBasic(record);
	}

	public void updateBooleanToChar(Cuadrocomparativoitem record) throws Exception {
	}

	public void validateInsert(Cuadrocomparativoitem record)throws Exception{
		if(record.getIdcuadrocomparativoitem()==null)
			throw new ValidateException(Messages.getString("cuadrocomparativoitem.idcuadrocomparativoitem.required"));

		if(record.getUsuariocreacionauditoria()!=null &&  record.getUsuariocreacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("cuadrocomparativoitem.usuariocreacionauditoria.length.error",record.getUsuariocreacionauditoria().length()));
		if(record.getUsuariomodificacionauditoria()!=null &&  record.getUsuariomodificacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("cuadrocomparativoitem.usuariomodificacionauditoria.length.error",record.getUsuariomodificacionauditoria().length()));
		if(record.getEquipoauditoria()!=null &&  record.getEquipoauditoria().length() > 45)
			throw new ValidateException(Messages.getString("cuadrocomparativoitem.equipoauditoria.length.error",record.getEquipoauditoria().length()));
		if(record.getProgramaauditoria()!=null &&  record.getProgramaauditoria().length() > 200)
			throw new ValidateException(Messages.getString("cuadrocomparativoitem.programaauditoria.length.error",record.getProgramaauditoria().length()));
		if(record.getEstadoauditoria()!=null &&  record.getEstadoauditoria().length() > 1)
			throw new ValidateException(Messages.getString("cuadrocomparativoitem.estadoauditoria.length.error",record.getEstadoauditoria().length()));

		//Here Bussines Validations.
	}

	public void validateUpdate(Cuadrocomparativoitem record)throws Exception{
		if(record.getIdcuadrocomparativoitem()==null)
			throw new ValidateException(Messages.getString("cuadrocomparativoitem.idcuadrocomparativoitem.required"));

		if(record.getUsuariocreacionauditoria()!=null &&  record.getUsuariocreacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("cuadrocomparativoitem.usuariocreacionauditoria.length.error",record.getUsuariocreacionauditoria().length()));
		if(record.getUsuariomodificacionauditoria()!=null &&  record.getUsuariomodificacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("cuadrocomparativoitem.usuariomodificacionauditoria.length.error",record.getUsuariomodificacionauditoria().length()));
		if(record.getEquipoauditoria()!=null &&  record.getEquipoauditoria().length() > 45)
			throw new ValidateException(Messages.getString("cuadrocomparativoitem.equipoauditoria.length.error",record.getEquipoauditoria().length()));
		if(record.getProgramaauditoria()!=null &&  record.getProgramaauditoria().length() > 200)
			throw new ValidateException(Messages.getString("cuadrocomparativoitem.programaauditoria.length.error",record.getProgramaauditoria().length()));
		if(record.getEstadoauditoria()!=null &&  record.getEstadoauditoria().length() > 1)
			throw new ValidateException(Messages.getString("cuadrocomparativoitem.estadoauditoria.length.error",record.getEstadoauditoria().length()));

		//Here Bussines Validations.
	}

	public void validateDelete(java.lang.Integer par_idcuadrocomparativoitem)throws Exception{
		if(par_idcuadrocomparativoitem==null)
			throw new ValidateException(Messages.getString("cuadrocomparativoitem.idcuadrocomparativoitem.required"));

		//Here Bussines Validations.
	}


}

