
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
import pe.com.sisabas.be.Pedidosporpacconsolidado;
import pe.com.sisabas.persistence.PedidosporpacconsolidadoMapper;
import pe.com.sisabas.business.PedidosporpacconsolidadoBusiness;
import pe.com.sisabas.exception.BusinessException;
import pe.com.sisabas.exception.ValidateException;
import pe.com.sisabas.resources.Constantes;
import pe.com.sisabas.resources.Messages;
import pe.com.sisabas.resources.Sequence;
import pe.com.sisabas.resources.Utils;
import pe.com.sisabas.resources.business.UtilsBusiness;


@Service
public class PedidosporpacconsolidadoBusinessImpl implements PedidosporpacconsolidadoBusiness, Serializable{

	private static Logger logger=Logger.getLogger(PedidosporpacconsolidadoBusinessImpl.class);

	private static final long serialVersionUID = 1L;

	@Autowired
	public PedidosporpacconsolidadoMapper pedidosporpacconsolidadoMapper;

	@Autowired
	public UtilsBusiness utilsBusiness;

	@Override
	public void deleteByPrimaryKeyBasic(Pedidosporpacconsolidado par_record) throws Exception {
		validateDelete(par_record.getIdpedidoporpacconsolidado());
		pedidosporpacconsolidadoMapper.deleteByPrimaryKey(par_record.getIdpedidoporpacconsolidado());
	}

	@Override
	public void insertBasic(Pedidosporpacconsolidado record) throws Exception {
		record.setIdpedidoporpacconsolidado((int)utilsBusiness.getNextSeq(Sequence.SEQ_PEDIDOSPORPACCONSOLIDADO).longValue());
		record.setFechacreacionauditoria(Utils.currentTimeStamp());
		record.setEstadoauditoria("1");
		updateBooleanToChar(record);
		validateInsert(record);
		Utils.convertPropertiesStringToUppercase(record);
		pedidosporpacconsolidadoMapper.insert(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void insertFull(Pedidosporpacconsolidado record) throws Exception {
		//Business Logic
		insertBasic(record);
	}

	@Override
	public void insertSelectiveBasic(Pedidosporpacconsolidado record) throws Exception {
		record.setIdpedidoporpacconsolidado((int)utilsBusiness.getNextSeq(Sequence.SEQ_PEDIDOSPORPACCONSOLIDADO).longValue());
		record.setFechacreacionauditoria(Utils.currentTimeStamp());
		record.setEstadoauditoria("1");
		updateBooleanToChar(record);
		Utils.convertPropertiesStringToUppercase(record);
		pedidosporpacconsolidadoMapper.insertSelective(record);
	}

	@Override
	public Pedidosporpacconsolidado selectByPrimaryKeyBasic(java.lang.Integer par_idpedidoporpacconsolidado) throws Exception {
		return pedidosporpacconsolidadoMapper.selectByPrimaryKeyBasic(par_idpedidoporpacconsolidado);
	}

	@Override
	public Pedidosporpacconsolidado selectByPrimaryKeyBasicFromList(java.lang.Integer par_idpedidoporpacconsolidado, List<Pedidosporpacconsolidado> list) throws Exception {
		Pedidosporpacconsolidado record=null;
		for (Pedidosporpacconsolidado row : list) {
			if(row.equals(new Pedidosporpacconsolidado( par_idpedidoporpacconsolidado))){
				record=row;
				break;
			}
		}
		if(record==null)
			record=selectByPrimaryKeyBasic( par_idpedidoporpacconsolidado);

		return record;
	}

	@Override
	public Pedidosporpacconsolidado selectByPrimaryKeyBasicActive(java.lang.Integer par_idpedidoporpacconsolidado) throws Exception {
		return pedidosporpacconsolidadoMapper.selectByPrimaryKeyBasicActive(par_idpedidoporpacconsolidado);
	}

	@Override
	public Pedidosporpacconsolidado selectByPrimaryKeyFull(java.lang.Integer par_idpedidoporpacconsolidado) throws Exception {
		return pedidosporpacconsolidadoMapper.selectByPrimaryKeyFull(par_idpedidoporpacconsolidado);
	}

	@Override
	public Pedidosporpacconsolidado selectByPrimaryKeyFullActive(java.lang.Integer par_idpedidoporpacconsolidado) throws Exception {
		return pedidosporpacconsolidadoMapper.selectByPrimaryKeyFullActive(par_idpedidoporpacconsolidado);
	}

	@Override
	public List<Pedidosporpacconsolidado> selectDynamicBasic(Pedidosporpacconsolidado record) throws Exception {
		return pedidosporpacconsolidadoMapper.selectDynamicBasic(record);
	}

	@Override
	public List<Pedidosporpacconsolidado> selectDynamicBasicActives(Pedidosporpacconsolidado record) throws Exception {
		record.setEstadoauditoria("1");
		return pedidosporpacconsolidadoMapper.selectDynamicBasic(record);
	}

	@Override
	public List<Pedidosporpacconsolidado> selectDynamicFull(Pedidosporpacconsolidado record) throws Exception {
		List<Pedidosporpacconsolidado> list=pedidosporpacconsolidadoMapper.selectDynamicFull(record);
		if(Pedidosporpacconsolidado.HAVE_BIGDECIMALS)
		for (Pedidosporpacconsolidado row : list) {
			row.roundBigDecimals();
		}

		return list;
	}

	@Override
	public List<Pedidosporpacconsolidado> selectDynamicFullActives(Pedidosporpacconsolidado record) throws Exception {
		record.setEstadoauditoria("1");
		return pedidosporpacconsolidadoMapper.selectDynamicFull(record);
	}

	@Override
	public List<Pedidosporpacconsolidado> selectDynamicExtended(Pedidosporpacconsolidado record) throws Exception {
		return pedidosporpacconsolidadoMapper.selectDynamicExtended(record);
	}

	@Override
	public List<Pedidosporpacconsolidado> selectDynamicExtendedActives(Pedidosporpacconsolidado record) throws Exception {
		record.setEstadoauditoria("1");
		return pedidosporpacconsolidadoMapper.selectDynamicExtended(record);
	}

	@Override
	public void updateByPrimaryKeySelectiveBasic(Pedidosporpacconsolidado record) throws Exception {
		updateBooleanToChar(record);
		Utils.convertPropertiesStringToUppercase(record);
		pedidosporpacconsolidadoMapper.updateByPrimaryKeySelective(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void updateByPrimaryKeySelectiveFull(Pedidosporpacconsolidado record) throws Exception {
		//Business Logic
		updateByPrimaryKeySelectiveBasic(record);
	}

	@Override
	public void updateByPrimaryKeyBasic(Pedidosporpacconsolidado record) throws Exception {
		updateBooleanToChar(record);
		validateUpdate(record);
		Utils.convertPropertiesStringToUppercase(record);
		pedidosporpacconsolidadoMapper.updateByPrimaryKey(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void updateByPrimaryKeyFull(Pedidosporpacconsolidado record) throws Exception {
		//Business Logic
		updateByPrimaryKeyBasic(record);
	}

	public void updateBooleanToChar(Pedidosporpacconsolidado record) throws Exception {
	}

	public void validateInsert(Pedidosporpacconsolidado record)throws Exception{
		if(record.getIdpedidoporpacconsolidado()==null)
			throw new ValidateException(Messages.getString("pedidosporpacconsolidado.idpedidoporpacconsolidado.required"));
		if(record.getIdpacconsolidado()==null)
			throw new ValidateException(Messages.getString("pedidosporpacconsolidado.idpacconsolidado.required"));

		if(record.getUsuariocreacionauditoria()!=null &&  record.getUsuariocreacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("pedidosporpacconsolidado.usuariocreacionauditoria.length.error",record.getUsuariocreacionauditoria().length()));
		if(record.getEquipoauditoria()!=null &&  record.getEquipoauditoria().length() > 45)
			throw new ValidateException(Messages.getString("pedidosporpacconsolidado.equipoauditoria.length.error",record.getEquipoauditoria().length()));
		if(record.getProgramaauditoria()!=null &&  record.getProgramaauditoria().length() > 200)
			throw new ValidateException(Messages.getString("pedidosporpacconsolidado.programaauditoria.length.error",record.getProgramaauditoria().length()));
		if(record.getEstadoauditoria()!=null &&  record.getEstadoauditoria().length() > 1)
			throw new ValidateException(Messages.getString("pedidosporpacconsolidado.estadoauditoria.length.error",record.getEstadoauditoria().length()));

		//Here Bussines Validations.
	}

	public void validateUpdate(Pedidosporpacconsolidado record)throws Exception{
		if(record.getIdpedidoporpacconsolidado()==null)
			throw new ValidateException(Messages.getString("pedidosporpacconsolidado.idpedidoporpacconsolidado.required"));
		if(record.getIdpacconsolidado()==null)
			throw new ValidateException(Messages.getString("pedidosporpacconsolidado.idpacconsolidado.required"));

		if(record.getUsuariocreacionauditoria()!=null &&  record.getUsuariocreacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("pedidosporpacconsolidado.usuariocreacionauditoria.length.error",record.getUsuariocreacionauditoria().length()));
		if(record.getEquipoauditoria()!=null &&  record.getEquipoauditoria().length() > 45)
			throw new ValidateException(Messages.getString("pedidosporpacconsolidado.equipoauditoria.length.error",record.getEquipoauditoria().length()));
		if(record.getProgramaauditoria()!=null &&  record.getProgramaauditoria().length() > 200)
			throw new ValidateException(Messages.getString("pedidosporpacconsolidado.programaauditoria.length.error",record.getProgramaauditoria().length()));
		if(record.getEstadoauditoria()!=null &&  record.getEstadoauditoria().length() > 1)
			throw new ValidateException(Messages.getString("pedidosporpacconsolidado.estadoauditoria.length.error",record.getEstadoauditoria().length()));

		//Here Bussines Validations.
	}

	public void validateDelete(java.lang.Integer par_idpedidoporpacconsolidado)throws Exception{
		if(par_idpedidoporpacconsolidado==null)
			throw new ValidateException(Messages.getString("pedidosporpacconsolidado.idpedidoporpacconsolidado.required"));

		//Here Bussines Validations.
	}


}

