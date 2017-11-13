
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
import pe.com.sisabas.be.Detallepedido;
import pe.com.sisabas.persistence.DetallepedidoMapper;
import pe.com.sisabas.business.DetallepedidoBusiness;
import pe.com.sisabas.exception.BusinessException;
import pe.com.sisabas.exception.ValidateException;
import pe.com.sisabas.resources.Constantes;
import pe.com.sisabas.resources.Messages;
import pe.com.sisabas.resources.Sequence;
import pe.com.sisabas.resources.Utils;
import pe.com.sisabas.resources.business.UtilsBusiness;


@Service
public class DetallepedidoBusinessImpl implements DetallepedidoBusiness, Serializable{

	private static Logger logger=Logger.getLogger(DetallepedidoBusinessImpl.class);

	private static final long serialVersionUID = 1L;

	@Autowired
	public DetallepedidoMapper detallepedidoMapper;

	@Autowired
	public UtilsBusiness utilsBusiness;

	@Override
	public void deleteByPrimaryKeyBasic(Detallepedido par_record) throws Exception {
		validateDelete(par_record.getIddetallepedido());
		detallepedidoMapper.deleteByPrimaryKey(par_record.getIddetallepedido());
	}

	@Override
	public void insertBasic(Detallepedido record) throws Exception {
		record.setIddetallepedido((int)utilsBusiness.getNextSeq(Sequence.SEQ_DETALLEPEDIDO).longValue());
		record.setFechacreacionauditoria(Utils.currentTimeStamp());
		record.setEstadoauditoria("1");
		updateBooleanToChar(record);
		validateInsert(record);
		Utils.convertPropertiesStringToUppercase(record);
		detallepedidoMapper.insert(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void insertFull(Detallepedido record) throws Exception {
		//Business Logic
		insertBasic(record);
	}

	@Override
	public void insertSelectiveBasic(Detallepedido record) throws Exception {
		record.setIddetallepedido((int)utilsBusiness.getNextSeq(Sequence.SEQ_DETALLEPEDIDO).longValue());
		record.setFechacreacionauditoria(Utils.currentTimeStamp());
		record.setEstadoauditoria("1");
		updateBooleanToChar(record);
		Utils.convertPropertiesStringToUppercase(record);
		detallepedidoMapper.insertSelective(record);
	}

	@Override
	public Detallepedido selectByPrimaryKeyBasic(java.lang.Integer par_iddetallepedido) throws Exception {
		return detallepedidoMapper.selectByPrimaryKeyBasic(par_iddetallepedido);
	}

	@Override
	public Detallepedido selectByPrimaryKeyBasicFromList(java.lang.Integer par_iddetallepedido, List<Detallepedido> list) throws Exception {
		Detallepedido record=null;
		for (Detallepedido row : list) {
			if(row.equals(new Detallepedido( par_iddetallepedido))){
				record=row;
				break;
			}
		}
		if(record==null)
			record=selectByPrimaryKeyBasic( par_iddetallepedido);

		return record;
	}

	@Override
	public Detallepedido selectByPrimaryKeyBasicActive(java.lang.Integer par_iddetallepedido) throws Exception {
		return detallepedidoMapper.selectByPrimaryKeyBasicActive(par_iddetallepedido);
	}

	@Override
	public Detallepedido selectByPrimaryKeyFull(java.lang.Integer par_iddetallepedido) throws Exception {
		return detallepedidoMapper.selectByPrimaryKeyFull(par_iddetallepedido);
	}

	@Override
	public Detallepedido selectByPrimaryKeyFullActive(java.lang.Integer par_iddetallepedido) throws Exception {
		return detallepedidoMapper.selectByPrimaryKeyFullActive(par_iddetallepedido);
	}

	@Override
	public List<Detallepedido> selectDynamicBasic(Detallepedido record) throws Exception {
		return detallepedidoMapper.selectDynamicBasic(record);
	}

	@Override
	public List<Detallepedido> selectDynamicBasicActives(Detallepedido record) throws Exception {
		record.setEstadoauditoria("1");
		return detallepedidoMapper.selectDynamicBasic(record);
	}

	@Override
	public List<Detallepedido> selectDynamicFull(Detallepedido record) throws Exception {
		List<Detallepedido> list=detallepedidoMapper.selectDynamicFull(record);
		if(Detallepedido.HAVE_BIGDECIMALS)
		for (Detallepedido row : list) {
			row.roundBigDecimals();
		}

		return list;
	}

	@Override
	public List<Detallepedido> selectDynamicFullActives(Detallepedido record) throws Exception {
		record.setEstadoauditoria("1");
		return detallepedidoMapper.selectDynamicFull(record);
	}

	@Override
	public List<Detallepedido> selectDynamicExtended(Detallepedido record) throws Exception {
		return detallepedidoMapper.selectDynamicExtended(record);
	}

	@Override
	public List<Detallepedido> selectDynamicExtendedActives(Detallepedido record) throws Exception {
		record.setEstadoauditoria("1");
		return detallepedidoMapper.selectDynamicExtended(record);
	}

	@Override
	public void updateByPrimaryKeySelectiveBasic(Detallepedido record) throws Exception {
		updateBooleanToChar(record);
		Utils.convertPropertiesStringToUppercase(record);
		detallepedidoMapper.updateByPrimaryKeySelective(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void updateByPrimaryKeySelectiveFull(Detallepedido record) throws Exception {
		//Business Logic
		updateByPrimaryKeySelectiveBasic(record);
	}

	@Override
	public void updateByPrimaryKeyBasic(Detallepedido record) throws Exception {
		updateBooleanToChar(record);
		validateUpdate(record);
		Utils.convertPropertiesStringToUppercase(record);
		detallepedidoMapper.updateByPrimaryKey(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void updateByPrimaryKeyFull(Detallepedido record) throws Exception {
		//Business Logic
		updateByPrimaryKeyBasic(record);
	}

	public void updateBooleanToChar(Detallepedido record) throws Exception {
	}

	public void validateInsert(Detallepedido record)throws Exception{
		if(record.getIddetallepedido()==null)
			throw new ValidateException(Messages.getString("detallepedido.iddetallepedido.required"));
		if(record.getIdpedido()==null)
			throw new ValidateException(Messages.getString("detallepedido.idpedido.required"));

		if(record.getGrupobien()!=null &&  record.getGrupobien().length() > 2)
			throw new ValidateException(Messages.getString("detallepedido.grupobien.length.error",record.getGrupobien().length()));
		if(record.getClasebien()!=null &&  record.getClasebien().length() > 2)
			throw new ValidateException(Messages.getString("detallepedido.clasebien.length.error",record.getClasebien().length()));
		if(record.getFamiliabien()!=null &&  record.getFamiliabien().length() > 4)
			throw new ValidateException(Messages.getString("detallepedido.familiabien.length.error",record.getFamiliabien().length()));
		if(record.getItembien()!=null &&  record.getItembien().length() > 250)
			throw new ValidateException(Messages.getString("detallepedido.itembien.length.error",record.getItembien().length()));
		if(record.getNombreitem()!=null &&  record.getNombreitem().length() > 300)
			throw new ValidateException(Messages.getString("detallepedido.nombreitem.length.error",record.getNombreitem().length()));
		if(record.getCodigoclasificador()!=null &&  record.getCodigoclasificador().length() > 8)
			throw new ValidateException(Messages.getString("detallepedido.codigoclasificador.length.error",record.getCodigoclasificador().length()));
		if(record.getCodigotareasiga()!=null &&  record.getCodigotareasiga().length() > 10)
			throw new ValidateException(Messages.getString("detallepedido.codigotareasiga.length.error",record.getCodigotareasiga().length()));
		if(record.getCodigotareaplanin()!=null &&  record.getCodigotareaplanin().length() > 10)
			throw new ValidateException(Messages.getString("detallepedido.codigotareaplanin.length.error",record.getCodigotareaplanin().length()));
		if(record.getUsuariocreacionauditoria()!=null &&  record.getUsuariocreacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("detallepedido.usuariocreacionauditoria.length.error",record.getUsuariocreacionauditoria().length()));
		if(record.getClasificador()!=null &&  record.getClasificador().length() > 20)
			throw new ValidateException(Messages.getString("detallepedido.clasificador.length.error",record.getClasificador().length()));
		if(record.getEquipoauditoria()!=null &&  record.getEquipoauditoria().length() > 45)
			throw new ValidateException(Messages.getString("detallepedido.equipoauditoria.length.error",record.getEquipoauditoria().length()));
		if(record.getProgramaauditoria()!=null &&  record.getProgramaauditoria().length() > 200)
			throw new ValidateException(Messages.getString("detallepedido.programaauditoria.length.error",record.getProgramaauditoria().length()));
		if(record.getEstadoauditoria()!=null &&  record.getEstadoauditoria().length() > 1)
			throw new ValidateException(Messages.getString("detallepedido.estadoauditoria.length.error",record.getEstadoauditoria().length()));

		//Here Bussines Validations.
	}

	public void validateUpdate(Detallepedido record)throws Exception{
		if(record.getIddetallepedido()==null)
			throw new ValidateException(Messages.getString("detallepedido.iddetallepedido.required"));
		if(record.getIdpedido()==null)
			throw new ValidateException(Messages.getString("detallepedido.idpedido.required"));

		if(record.getGrupobien()!=null &&  record.getGrupobien().length() > 2)
			throw new ValidateException(Messages.getString("detallepedido.grupobien.length.error",record.getGrupobien().length()));
		if(record.getClasebien()!=null &&  record.getClasebien().length() > 2)
			throw new ValidateException(Messages.getString("detallepedido.clasebien.length.error",record.getClasebien().length()));
		if(record.getFamiliabien()!=null &&  record.getFamiliabien().length() > 4)
			throw new ValidateException(Messages.getString("detallepedido.familiabien.length.error",record.getFamiliabien().length()));
		if(record.getItembien()!=null &&  record.getItembien().length() > 250)
			throw new ValidateException(Messages.getString("detallepedido.itembien.length.error",record.getItembien().length()));
		if(record.getNombreitem()!=null &&  record.getNombreitem().length() > 300)
			throw new ValidateException(Messages.getString("detallepedido.nombreitem.length.error",record.getNombreitem().length()));
		if(record.getCodigoclasificador()!=null &&  record.getCodigoclasificador().length() > 8)
			throw new ValidateException(Messages.getString("detallepedido.codigoclasificador.length.error",record.getCodigoclasificador().length()));
		if(record.getCodigotareasiga()!=null &&  record.getCodigotareasiga().length() > 10)
			throw new ValidateException(Messages.getString("detallepedido.codigotareasiga.length.error",record.getCodigotareasiga().length()));
		if(record.getCodigotareaplanin()!=null &&  record.getCodigotareaplanin().length() > 10)
			throw new ValidateException(Messages.getString("detallepedido.codigotareaplanin.length.error",record.getCodigotareaplanin().length()));
		if(record.getUsuariocreacionauditoria()!=null &&  record.getUsuariocreacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("detallepedido.usuariocreacionauditoria.length.error",record.getUsuariocreacionauditoria().length()));
		if(record.getClasificador()!=null &&  record.getClasificador().length() > 20)
			throw new ValidateException(Messages.getString("detallepedido.clasificador.length.error",record.getClasificador().length()));
		if(record.getEquipoauditoria()!=null &&  record.getEquipoauditoria().length() > 45)
			throw new ValidateException(Messages.getString("detallepedido.equipoauditoria.length.error",record.getEquipoauditoria().length()));
		if(record.getProgramaauditoria()!=null &&  record.getProgramaauditoria().length() > 200)
			throw new ValidateException(Messages.getString("detallepedido.programaauditoria.length.error",record.getProgramaauditoria().length()));
		if(record.getEstadoauditoria()!=null &&  record.getEstadoauditoria().length() > 1)
			throw new ValidateException(Messages.getString("detallepedido.estadoauditoria.length.error",record.getEstadoauditoria().length()));

		//Here Bussines Validations.
	}

	public void validateDelete(java.lang.Integer par_iddetallepedido)throws Exception{
		if(par_iddetallepedido==null)
			throw new ValidateException(Messages.getString("detallepedido.iddetallepedido.required"));

		//Here Bussines Validations.
	}


}

