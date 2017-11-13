
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
import pe.com.sisabas.be.Vdetallepedido;
import pe.com.sisabas.persistence.VdetallepedidoMapper;
import pe.com.sisabas.business.VdetallepedidoBusiness;
import pe.com.sisabas.exception.BusinessException;
import pe.com.sisabas.exception.ValidateException;
import pe.com.sisabas.resources.Constantes;
import pe.com.sisabas.resources.Messages;
import pe.com.sisabas.resources.Sequence;
import pe.com.sisabas.resources.Utils;
import pe.com.sisabas.resources.business.UtilsBusiness;


@Service
public class VdetallepedidoBusinessImpl implements VdetallepedidoBusiness, Serializable{

	private static Logger logger=Logger.getLogger(VdetallepedidoBusinessImpl.class);

	private static final long serialVersionUID = 1L;

	@Autowired
	public VdetallepedidoMapper vdetallepedidoMapper;

	@Autowired
	public UtilsBusiness utilsBusiness;

	@Override
	public void deleteByPrimaryKeyBasic(Vdetallepedido par_record) throws Exception {
		validateDelete(par_record.getIdvdetallepedido());
		vdetallepedidoMapper.deleteByPrimaryKey(par_record.getIdvdetallepedido());
	}

	@Override
	public void insertBasic(Vdetallepedido record) throws Exception {
		record.setIdvdetallepedido((int)utilsBusiness.getNextSeq(Sequence.SEQ_VDETALLEPEDIDO).longValue());
		record.setFechacreacionauditoria(Utils.currentTimeStamp());
		record.setEstadoauditoria("1");
		updateBooleanToChar(record);
		validateInsert(record);
		Utils.convertPropertiesStringToUppercase(record);
		vdetallepedidoMapper.insert(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void insertFull(Vdetallepedido record) throws Exception {
		//Business Logic
		insertBasic(record);
	}

	@Override
	public void insertSelectiveBasic(Vdetallepedido record) throws Exception {
		record.setIdvdetallepedido((int)utilsBusiness.getNextSeq(Sequence.SEQ_VDETALLEPEDIDO).longValue());
		record.setFechacreacionauditoria(Utils.currentTimeStamp());
		record.setEstadoauditoria("1");
		updateBooleanToChar(record);
		Utils.convertPropertiesStringToUppercase(record);
		vdetallepedidoMapper.insertSelective(record);
	}

	@Override
	public Vdetallepedido selectByPrimaryKeyBasic(java.lang.Integer par_idvdetallepedido) throws Exception {
		return vdetallepedidoMapper.selectByPrimaryKeyBasic(par_idvdetallepedido);
	}

	@Override
	public Vdetallepedido selectByPrimaryKeyBasicFromList(java.lang.Integer par_idvdetallepedido, List<Vdetallepedido> list) throws Exception {
		Vdetallepedido record=null;
		for (Vdetallepedido row : list) {
			if(row.equals(new Vdetallepedido( par_idvdetallepedido))){
				record=row;
				break;
			}
		}
		if(record==null)
			record=selectByPrimaryKeyBasic( par_idvdetallepedido);

		return record;
	}

	@Override
	public Vdetallepedido selectByPrimaryKeyBasicActive(java.lang.Integer par_idvdetallepedido) throws Exception {
		return vdetallepedidoMapper.selectByPrimaryKeyBasicActive(par_idvdetallepedido);
	}

	@Override
	public Vdetallepedido selectByPrimaryKeyFull(java.lang.Integer par_idvdetallepedido) throws Exception {
		return vdetallepedidoMapper.selectByPrimaryKeyFull(par_idvdetallepedido);
	}

	@Override
	public Vdetallepedido selectByPrimaryKeyFullActive(java.lang.Integer par_idvdetallepedido) throws Exception {
		return vdetallepedidoMapper.selectByPrimaryKeyFullActive(par_idvdetallepedido);
	}

	@Override
	public List<Vdetallepedido> selectDynamicBasic(Vdetallepedido record) throws Exception {
		return vdetallepedidoMapper.selectDynamicBasic(record);
	}

	@Override
	public List<Vdetallepedido> selectDynamicBasicActives(Vdetallepedido record) throws Exception {
		record.setEstadoauditoria("1");
		return vdetallepedidoMapper.selectDynamicBasic(record);
	}

	@Override
	public List<Vdetallepedido> selectDynamicFull(Vdetallepedido record) throws Exception {
		List<Vdetallepedido> list=vdetallepedidoMapper.selectDynamicFull(record);
		if(Vdetallepedido.HAVE_BIGDECIMALS)
		for (Vdetallepedido row : list) {
			row.roundBigDecimals();
		}

		return list;
	}

	@Override
	public List<Vdetallepedido> selectDynamicFullActives(Vdetallepedido record) throws Exception {
		record.setEstadoauditoria("1");
		return vdetallepedidoMapper.selectDynamicFull(record);
	}

	@Override
	public List<Vdetallepedido> selectDynamicExtended(Vdetallepedido record) throws Exception {
		return vdetallepedidoMapper.selectDynamicExtended(record);
	}

	@Override
	public List<Vdetallepedido> selectDynamicExtendedActives(Vdetallepedido record) throws Exception {
		record.setEstadoauditoria("1");
		return vdetallepedidoMapper.selectDynamicExtended(record);
	}

	@Override
	public void updateByPrimaryKeySelectiveBasic(Vdetallepedido record) throws Exception {
		record.setFechamodificacionauditoria(Utils.currentTimeStamp());
		updateBooleanToChar(record);
		Utils.convertPropertiesStringToUppercase(record);
		vdetallepedidoMapper.updateByPrimaryKeySelective(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void updateByPrimaryKeySelectiveFull(Vdetallepedido record) throws Exception {
		//Business Logic
		updateByPrimaryKeySelectiveBasic(record);
	}

	@Override
	public void updateByPrimaryKeyBasic(Vdetallepedido record) throws Exception {
		record.setFechamodificacionauditoria(Utils.currentTimeStamp());
		updateBooleanToChar(record);
		validateUpdate(record);
		Utils.convertPropertiesStringToUppercase(record);
		vdetallepedidoMapper.updateByPrimaryKey(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void updateByPrimaryKeyFull(Vdetallepedido record) throws Exception {
		//Business Logic
		updateByPrimaryKeyBasic(record);
	}

	public void updateBooleanToChar(Vdetallepedido record) throws Exception {
	}

	public void validateInsert(Vdetallepedido record)throws Exception{
		if(record.getIdvdetallepedido()==null)
			throw new ValidateException(Messages.getString("vdetallepedido.idvdetallepedido.required"));
		if(record.getCodigounidadejecutora()==null)
			throw new ValidateException(Messages.getString("vdetallepedido.codigounidadejecutora.required"));
		if(record.getCodigotipobien()==null)
			throw new ValidateException(Messages.getString("vdetallepedido.codigotipobien.required"));

		if(record.getCodigounidadejecutora()!=null &&  record.getCodigounidadejecutora().length() > 3)
			throw new ValidateException(Messages.getString("vdetallepedido.codigounidadejecutora.length.error",record.getCodigounidadejecutora().length()));
		if(record.getCentrocosto()!=null &&  record.getCentrocosto().length() > 15)
			throw new ValidateException(Messages.getString("vdetallepedido.centrocosto.length.error",record.getCentrocosto().length()));
		if(record.getTipobien()!=null &&  record.getTipobien().length() > 1)
			throw new ValidateException(Messages.getString("vdetallepedido.tipobien.length.error",record.getTipobien().length()));
		if(record.getNropedido()!=null &&  record.getNropedido().length() > 5)
			throw new ValidateException(Messages.getString("vdetallepedido.nropedido.length.error",record.getNropedido().length()));
		if(record.getGrupobien()!=null &&  record.getGrupobien().length() > 2)
			throw new ValidateException(Messages.getString("vdetallepedido.grupobien.length.error",record.getGrupobien().length()));
		if(record.getClasebien()!=null &&  record.getClasebien().length() > 2)
			throw new ValidateException(Messages.getString("vdetallepedido.clasebien.length.error",record.getClasebien().length()));
		if(record.getFamiliabien()!=null &&  record.getFamiliabien().length() > 4)
			throw new ValidateException(Messages.getString("vdetallepedido.familiabien.length.error",record.getFamiliabien().length()));
		if(record.getItembien()!=null &&  record.getItembien().length() > 4)
			throw new ValidateException(Messages.getString("vdetallepedido.itembien.length.error",record.getItembien().length()));
		if(record.getNombreitem()!=null &&  record.getNombreitem().length() > 150)
			throw new ValidateException(Messages.getString("vdetallepedido.nombreitem.length.error",record.getNombreitem().length()));
		if(record.getTipotarea()!=null &&  record.getTipotarea().length() > 1)
			throw new ValidateException(Messages.getString("vdetallepedido.tipotarea.length.error",record.getTipotarea().length()));
		if(record.getNiveltarea()!=null &&  record.getNiveltarea().length() > 1)
			throw new ValidateException(Messages.getString("vdetallepedido.niveltarea.length.error",record.getNiveltarea().length()));
		if(record.getEstadopendiente()!=null &&  record.getEstadopendiente().length() > 1)
			throw new ValidateException(Messages.getString("vdetallepedido.estadopendiente.length.error",record.getEstadopendiente().length()));
		if(record.getIdclasificador()!=null &&  record.getIdclasificador().length() > 7)
			throw new ValidateException(Messages.getString("vdetallepedido.idclasificador.length.error",record.getIdclasificador().length()));
		if(record.getClasificador()!=null &&  record.getClasificador().length() > 20)
			throw new ValidateException(Messages.getString("vdetallepedido.clasificador.length.error",record.getClasificador().length()));
		if(record.getUsuariocreacionauditoria()!=null &&  record.getUsuariocreacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("vdetallepedido.usuariocreacionauditoria.length.error",record.getUsuariocreacionauditoria().length()));
		if(record.getUsuariomodificacionauditoria()!=null &&  record.getUsuariomodificacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("vdetallepedido.usuariomodificacionauditoria.length.error",record.getUsuariomodificacionauditoria().length()));
		if(record.getEquipoauditoria()!=null &&  record.getEquipoauditoria().length() > 45)
			throw new ValidateException(Messages.getString("vdetallepedido.equipoauditoria.length.error",record.getEquipoauditoria().length()));
		if(record.getProgramaauditoria()!=null &&  record.getProgramaauditoria().length() > 200)
			throw new ValidateException(Messages.getString("vdetallepedido.programaauditoria.length.error",record.getProgramaauditoria().length()));
		if(record.getEstadoauditoria()!=null &&  record.getEstadoauditoria().length() > 1)
			throw new ValidateException(Messages.getString("vdetallepedido.estadoauditoria.length.error",record.getEstadoauditoria().length()));

		//Here Bussines Validations.
	}

	public void validateUpdate(Vdetallepedido record)throws Exception{
		if(record.getIdvdetallepedido()==null)
			throw new ValidateException(Messages.getString("vdetallepedido.idvdetallepedido.required"));
		if(record.getCodigounidadejecutora()==null)
			throw new ValidateException(Messages.getString("vdetallepedido.codigounidadejecutora.required"));
		if(record.getCodigotipobien()==null)
			throw new ValidateException(Messages.getString("vdetallepedido.codigotipobien.required"));

		if(record.getCodigounidadejecutora()!=null &&  record.getCodigounidadejecutora().length() > 3)
			throw new ValidateException(Messages.getString("vdetallepedido.codigounidadejecutora.length.error",record.getCodigounidadejecutora().length()));
		if(record.getCentrocosto()!=null &&  record.getCentrocosto().length() > 15)
			throw new ValidateException(Messages.getString("vdetallepedido.centrocosto.length.error",record.getCentrocosto().length()));
		if(record.getTipobien()!=null &&  record.getTipobien().length() > 1)
			throw new ValidateException(Messages.getString("vdetallepedido.tipobien.length.error",record.getTipobien().length()));
		if(record.getNropedido()!=null &&  record.getNropedido().length() > 5)
			throw new ValidateException(Messages.getString("vdetallepedido.nropedido.length.error",record.getNropedido().length()));
		if(record.getGrupobien()!=null &&  record.getGrupobien().length() > 2)
			throw new ValidateException(Messages.getString("vdetallepedido.grupobien.length.error",record.getGrupobien().length()));
		if(record.getClasebien()!=null &&  record.getClasebien().length() > 2)
			throw new ValidateException(Messages.getString("vdetallepedido.clasebien.length.error",record.getClasebien().length()));
		if(record.getFamiliabien()!=null &&  record.getFamiliabien().length() > 4)
			throw new ValidateException(Messages.getString("vdetallepedido.familiabien.length.error",record.getFamiliabien().length()));
		if(record.getItembien()!=null &&  record.getItembien().length() > 4)
			throw new ValidateException(Messages.getString("vdetallepedido.itembien.length.error",record.getItembien().length()));
		if(record.getNombreitem()!=null &&  record.getNombreitem().length() > 150)
			throw new ValidateException(Messages.getString("vdetallepedido.nombreitem.length.error",record.getNombreitem().length()));
		if(record.getTipotarea()!=null &&  record.getTipotarea().length() > 1)
			throw new ValidateException(Messages.getString("vdetallepedido.tipotarea.length.error",record.getTipotarea().length()));
		if(record.getNiveltarea()!=null &&  record.getNiveltarea().length() > 1)
			throw new ValidateException(Messages.getString("vdetallepedido.niveltarea.length.error",record.getNiveltarea().length()));
		if(record.getEstadopendiente()!=null &&  record.getEstadopendiente().length() > 1)
			throw new ValidateException(Messages.getString("vdetallepedido.estadopendiente.length.error",record.getEstadopendiente().length()));
		if(record.getIdclasificador()!=null &&  record.getIdclasificador().length() > 7)
			throw new ValidateException(Messages.getString("vdetallepedido.idclasificador.length.error",record.getIdclasificador().length()));
		if(record.getClasificador()!=null &&  record.getClasificador().length() > 20)
			throw new ValidateException(Messages.getString("vdetallepedido.clasificador.length.error",record.getClasificador().length()));
		if(record.getUsuariocreacionauditoria()!=null &&  record.getUsuariocreacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("vdetallepedido.usuariocreacionauditoria.length.error",record.getUsuariocreacionauditoria().length()));
		if(record.getUsuariomodificacionauditoria()!=null &&  record.getUsuariomodificacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("vdetallepedido.usuariomodificacionauditoria.length.error",record.getUsuariomodificacionauditoria().length()));
		if(record.getEquipoauditoria()!=null &&  record.getEquipoauditoria().length() > 45)
			throw new ValidateException(Messages.getString("vdetallepedido.equipoauditoria.length.error",record.getEquipoauditoria().length()));
		if(record.getProgramaauditoria()!=null &&  record.getProgramaauditoria().length() > 200)
			throw new ValidateException(Messages.getString("vdetallepedido.programaauditoria.length.error",record.getProgramaauditoria().length()));
		if(record.getEstadoauditoria()!=null &&  record.getEstadoauditoria().length() > 1)
			throw new ValidateException(Messages.getString("vdetallepedido.estadoauditoria.length.error",record.getEstadoauditoria().length()));

		//Here Bussines Validations.
	}

	public void validateDelete(java.lang.Integer par_idvdetallepedido)throws Exception{
		if(par_idvdetallepedido==null)
			throw new ValidateException(Messages.getString("vdetallepedido.idvdetallepedido.required"));

		//Here Bussines Validations.
	}


}

