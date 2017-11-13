
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
import pe.com.sisabas.be.Vispedido;
import pe.com.sisabas.persistence.VispedidoMapper;
import pe.com.sisabas.business.VispedidoBusiness;
import pe.com.sisabas.exception.BusinessException;
import pe.com.sisabas.exception.ValidateException;
import pe.com.sisabas.resources.Constantes;
import pe.com.sisabas.resources.Messages;
import pe.com.sisabas.resources.Sequence;
import pe.com.sisabas.resources.Utils;
import pe.com.sisabas.resources.business.UtilsBusiness;


@Service
public class VispedidoBusinessImpl implements VispedidoBusiness, Serializable{

	private static Logger logger=Logger.getLogger(VispedidoBusinessImpl.class);

	private static final long serialVersionUID = 1L;

	@Autowired
	public VispedidoMapper vispedidoMapper;

	@Autowired
	public UtilsBusiness utilsBusiness;

	@Override
	public void deleteByPrimaryKeyBasic(Vispedido par_record) throws Exception {
		validateDelete(par_record.getIdvpedido());
		vispedidoMapper.deleteByPrimaryKey(par_record.getIdvpedido());
	}

	@Override
	public void insertBasic(Vispedido record) throws Exception {
		record.setIdvpedido((int)utilsBusiness.getNextSeq(Sequence.SEQ_VISPEDIDO).longValue());
		record.setFechacreacionauditoria(Utils.currentTimeStamp());
		record.setEstadoauditoria("1");
		updateBooleanToChar(record);
		validateInsert(record);
		Utils.convertPropertiesStringToUppercase(record);
		vispedidoMapper.insert(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void insertFull(Vispedido record) throws Exception {
		//Business Logic
		insertBasic(record);
	}

	@Override
	public void insertSelectiveBasic(Vispedido record) throws Exception {
		record.setIdvpedido((int)utilsBusiness.getNextSeq(Sequence.SEQ_VISPEDIDO).longValue());
		record.setFechacreacionauditoria(Utils.currentTimeStamp());
		record.setEstadoauditoria("1");
		updateBooleanToChar(record);
		Utils.convertPropertiesStringToUppercase(record);
		vispedidoMapper.insertSelective(record);
	}

	@Override
	public Vispedido selectByPrimaryKeyBasic(java.lang.Integer par_idvpedido) throws Exception {
		return vispedidoMapper.selectByPrimaryKeyBasic(par_idvpedido);
	}

	@Override
	public Vispedido selectByPrimaryKeyBasicFromList(java.lang.Integer par_idvpedido, List<Vispedido> list) throws Exception {
		Vispedido record=null;
		for (Vispedido row : list) {
			if(row.equals(new Vispedido( par_idvpedido))){
				record=row;
				break;
			}
		}
		if(record==null)
			record=selectByPrimaryKeyBasic( par_idvpedido);

		return record;
	}

	@Override
	public Vispedido selectByPrimaryKeyBasicActive(java.lang.Integer par_idvpedido) throws Exception {
		return vispedidoMapper.selectByPrimaryKeyBasicActive(par_idvpedido);
	}

	@Override
	public Vispedido selectByPrimaryKeyFull(java.lang.Integer par_idvpedido) throws Exception {
		return vispedidoMapper.selectByPrimaryKeyFull(par_idvpedido);
	}

	@Override
	public Vispedido selectByPrimaryKeyFullActive(java.lang.Integer par_idvpedido) throws Exception {
		return vispedidoMapper.selectByPrimaryKeyFullActive(par_idvpedido);
	}

	@Override
	public List<Vispedido> selectDynamicBasic(Vispedido record) throws Exception {
		return vispedidoMapper.selectDynamicBasic(record);
	}

	@Override
	public List<Vispedido> selectDynamicBasicActives(Vispedido record) throws Exception {
		record.setEstadoauditoria("1");
		return vispedidoMapper.selectDynamicBasic(record);
	}

	@Override
	public List<Vispedido> selectDynamicFull(Vispedido record) throws Exception {
		List<Vispedido> list=vispedidoMapper.selectDynamicFull(record);
		if(Vispedido.HAVE_BIGDECIMALS)
		for (Vispedido row : list) {
			row.roundBigDecimals();
		}

		return list;
	}

	@Override
	public List<Vispedido> selectDynamicFullActives(Vispedido record) throws Exception {
		record.setEstadoauditoria("1");
		return vispedidoMapper.selectDynamicFull(record);
	}

	@Override
	public List<Vispedido> selectDynamicExtended(Vispedido record) throws Exception {
		return vispedidoMapper.selectDynamicExtended(record);
	}

	@Override
	public List<Vispedido> selectDynamicExtendedActives(Vispedido record) throws Exception {
		record.setEstadoauditoria("1");
		return vispedidoMapper.selectDynamicExtended(record);
	}

	@Override
	public void updateByPrimaryKeySelectiveBasic(Vispedido record) throws Exception {
		record.setFechamodificacionauditoria(Utils.currentTimeStamp());
		updateBooleanToChar(record);
		Utils.convertPropertiesStringToUppercase(record);
		vispedidoMapper.updateByPrimaryKeySelective(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void updateByPrimaryKeySelectiveFull(Vispedido record) throws Exception {
		//Business Logic
		updateByPrimaryKeySelectiveBasic(record);
	}

	@Override
	public void updateByPrimaryKeyBasic(Vispedido record) throws Exception {
		record.setFechamodificacionauditoria(Utils.currentTimeStamp());
		updateBooleanToChar(record);
		validateUpdate(record);
		Utils.convertPropertiesStringToUppercase(record);
		vispedidoMapper.updateByPrimaryKey(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void updateByPrimaryKeyFull(Vispedido record) throws Exception {
		//Business Logic
		updateByPrimaryKeyBasic(record);
	}

	public void updateBooleanToChar(Vispedido record) throws Exception {
		if(record.getBooleantipopedido()!=null && record.getBooleantipopedido()){
			record.setTipopedido("1");
		}else{
			record.setTipopedido("0");
		}

		if(record.getBooleantipotarea()!=null && record.getBooleantipotarea()){
			record.setTipotarea("1");
		}else{
			record.setTipotarea("0");
		}

		if(record.getBooleanniveltarea()!=null && record.getBooleanniveltarea()){
			record.setNiveltarea("1");
		}else{
			record.setNiveltarea("0");
		}

		if(record.getBooleanestado()!=null && record.getBooleanestado()){
			record.setEstado("1");
		}else{
			record.setEstado("0");
		}

	}

	public void validateInsert(Vispedido record)throws Exception{
		if(record.getIdvpedido()==null)
			throw new ValidateException(Messages.getString("vispedido.idvpedido.required"));
		if(record.getCodigounidadejecutora()==null)
			throw new ValidateException(Messages.getString("vispedido.codigounidadejecutora.required"));
		if(record.getAnio()==null)
			throw new ValidateException(Messages.getString("vispedido.anio.required"));
		if(record.getSecejec()==null)
			throw new ValidateException(Messages.getString("vispedido.secejec.required"));
		if(record.getTipobien()==null)
			throw new ValidateException(Messages.getString("vispedido.tipobien.required"));
		if(record.getTipopedido()==null)
			throw new ValidateException(Messages.getString("vispedido.tipopedido.required"));
		if(record.getNropedido()==null)
			throw new ValidateException(Messages.getString("vispedido.nropedido.required"));

		if(record.getCodigounidadejecutora()!=null &&  record.getCodigounidadejecutora().length() > 3)
			throw new ValidateException(Messages.getString("vispedido.codigounidadejecutora.length.error",record.getCodigounidadejecutora().length()));
		if(record.getTipobien()!=null &&  record.getTipobien().length() > 1)
			throw new ValidateException(Messages.getString("vispedido.tipobien.length.error",record.getTipobien().length()));
		if(record.getTipopedido()!=null &&  record.getTipopedido().length() > 1)
			throw new ValidateException(Messages.getString("vispedido.tipopedido.length.error",record.getTipopedido().length()));
		if(record.getNropedido()!=null &&  record.getNropedido().length() > 5)
			throw new ValidateException(Messages.getString("vispedido.nropedido.length.error",record.getNropedido().length()));
		if(record.getCodigocentrocosto()!=null &&  record.getCodigocentrocosto().length() > 15)
			throw new ValidateException(Messages.getString("vispedido.codigocentrocosto.length.error",record.getCodigocentrocosto().length()));
		if(record.getNombredependencia()!=null &&  record.getNombredependencia().length() > 100)
			throw new ValidateException(Messages.getString("vispedido.nombredependencia.length.error",record.getNombredependencia().length()));
		if(record.getMotivopedido()!=null &&  record.getMotivopedido().length() > 2147483647)
			throw new ValidateException(Messages.getString("vispedido.motivopedido.length.error",record.getMotivopedido().length()));
		if(record.getTipotarea()!=null &&  record.getTipotarea().length() > 1)
			throw new ValidateException(Messages.getString("vispedido.tipotarea.length.error",record.getTipotarea().length()));
		if(record.getNiveltarea()!=null &&  record.getNiveltarea().length() > 1)
			throw new ValidateException(Messages.getString("vispedido.niveltarea.length.error",record.getNiveltarea().length()));
		if(record.getMespedido()!=null &&  record.getMespedido().length() > 2)
			throw new ValidateException(Messages.getString("vispedido.mespedido.length.error",record.getMespedido().length()));
		if(record.getEstado()!=null &&  record.getEstado().length() > 1)
			throw new ValidateException(Messages.getString("vispedido.estado.length.error",record.getEstado().length()));
		if(record.getUsuariocreacionauditoria()!=null &&  record.getUsuariocreacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("vispedido.usuariocreacionauditoria.length.error",record.getUsuariocreacionauditoria().length()));
		if(record.getUsuariomodificacionauditoria()!=null &&  record.getUsuariomodificacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("vispedido.usuariomodificacionauditoria.length.error",record.getUsuariomodificacionauditoria().length()));
		if(record.getEquipoauditoria()!=null &&  record.getEquipoauditoria().length() > 45)
			throw new ValidateException(Messages.getString("vispedido.equipoauditoria.length.error",record.getEquipoauditoria().length()));
		if(record.getProgramaauditoria()!=null &&  record.getProgramaauditoria().length() > 200)
			throw new ValidateException(Messages.getString("vispedido.programaauditoria.length.error",record.getProgramaauditoria().length()));
		if(record.getEstadoauditoria()!=null &&  record.getEstadoauditoria().length() > 1)
			throw new ValidateException(Messages.getString("vispedido.estadoauditoria.length.error",record.getEstadoauditoria().length()));

		//Here Bussines Validations.
	}

	public void validateUpdate(Vispedido record)throws Exception{
		if(record.getIdvpedido()==null)
			throw new ValidateException(Messages.getString("vispedido.idvpedido.required"));
		if(record.getCodigounidadejecutora()==null)
			throw new ValidateException(Messages.getString("vispedido.codigounidadejecutora.required"));
		if(record.getAnio()==null)
			throw new ValidateException(Messages.getString("vispedido.anio.required"));
		if(record.getSecejec()==null)
			throw new ValidateException(Messages.getString("vispedido.secejec.required"));
		if(record.getTipobien()==null)
			throw new ValidateException(Messages.getString("vispedido.tipobien.required"));
		if(record.getTipopedido()==null)
			throw new ValidateException(Messages.getString("vispedido.tipopedido.required"));
		if(record.getNropedido()==null)
			throw new ValidateException(Messages.getString("vispedido.nropedido.required"));

		if(record.getCodigounidadejecutora()!=null &&  record.getCodigounidadejecutora().length() > 3)
			throw new ValidateException(Messages.getString("vispedido.codigounidadejecutora.length.error",record.getCodigounidadejecutora().length()));
		if(record.getTipobien()!=null &&  record.getTipobien().length() > 1)
			throw new ValidateException(Messages.getString("vispedido.tipobien.length.error",record.getTipobien().length()));
		if(record.getTipopedido()!=null &&  record.getTipopedido().length() > 1)
			throw new ValidateException(Messages.getString("vispedido.tipopedido.length.error",record.getTipopedido().length()));
		if(record.getNropedido()!=null &&  record.getNropedido().length() > 5)
			throw new ValidateException(Messages.getString("vispedido.nropedido.length.error",record.getNropedido().length()));
		if(record.getCodigocentrocosto()!=null &&  record.getCodigocentrocosto().length() > 15)
			throw new ValidateException(Messages.getString("vispedido.codigocentrocosto.length.error",record.getCodigocentrocosto().length()));
		if(record.getNombredependencia()!=null &&  record.getNombredependencia().length() > 100)
			throw new ValidateException(Messages.getString("vispedido.nombredependencia.length.error",record.getNombredependencia().length()));
		if(record.getMotivopedido()!=null &&  record.getMotivopedido().length() > 2147483647)
			throw new ValidateException(Messages.getString("vispedido.motivopedido.length.error",record.getMotivopedido().length()));
		if(record.getTipotarea()!=null &&  record.getTipotarea().length() > 1)
			throw new ValidateException(Messages.getString("vispedido.tipotarea.length.error",record.getTipotarea().length()));
		if(record.getNiveltarea()!=null &&  record.getNiveltarea().length() > 1)
			throw new ValidateException(Messages.getString("vispedido.niveltarea.length.error",record.getNiveltarea().length()));
		if(record.getMespedido()!=null &&  record.getMespedido().length() > 2)
			throw new ValidateException(Messages.getString("vispedido.mespedido.length.error",record.getMespedido().length()));
		if(record.getEstado()!=null &&  record.getEstado().length() > 1)
			throw new ValidateException(Messages.getString("vispedido.estado.length.error",record.getEstado().length()));
		if(record.getUsuariocreacionauditoria()!=null &&  record.getUsuariocreacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("vispedido.usuariocreacionauditoria.length.error",record.getUsuariocreacionauditoria().length()));
		if(record.getUsuariomodificacionauditoria()!=null &&  record.getUsuariomodificacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("vispedido.usuariomodificacionauditoria.length.error",record.getUsuariomodificacionauditoria().length()));
		if(record.getEquipoauditoria()!=null &&  record.getEquipoauditoria().length() > 45)
			throw new ValidateException(Messages.getString("vispedido.equipoauditoria.length.error",record.getEquipoauditoria().length()));
		if(record.getProgramaauditoria()!=null &&  record.getProgramaauditoria().length() > 200)
			throw new ValidateException(Messages.getString("vispedido.programaauditoria.length.error",record.getProgramaauditoria().length()));
		if(record.getEstadoauditoria()!=null &&  record.getEstadoauditoria().length() > 1)
			throw new ValidateException(Messages.getString("vispedido.estadoauditoria.length.error",record.getEstadoauditoria().length()));

		//Here Bussines Validations.
	}

	public void validateDelete(java.lang.Integer par_idvpedido)throws Exception{
		if(par_idvpedido==null)
			throw new ValidateException(Messages.getString("vispedido.idvpedido.required"));

		//Here Bussines Validations.
	}


}

