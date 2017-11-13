
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
import pe.com.sisabas.be.Pedido;
import pe.com.sisabas.persistence.PedidoMapper;
import pe.com.sisabas.business.PedidoBusiness;
import pe.com.sisabas.exception.BusinessException;
import pe.com.sisabas.exception.ValidateException;
import pe.com.sisabas.resources.Constantes;
import pe.com.sisabas.resources.Messages;
import pe.com.sisabas.resources.Sequence;
import pe.com.sisabas.resources.Utils;
import pe.com.sisabas.resources.business.UtilsBusiness;


@Service
public class PedidoBusinessImpl implements PedidoBusiness, Serializable{

	private static Logger logger=Logger.getLogger(PedidoBusinessImpl.class);

	private static final long serialVersionUID = 1L;

	@Autowired
	public PedidoMapper pedidoMapper;

	@Autowired
	public UtilsBusiness utilsBusiness;

	@Override
	public void deleteByPrimaryKeyBasic(Pedido par_record) throws Exception {
		validateDelete(par_record.getIdpedido());
		pedidoMapper.deleteByPrimaryKey(par_record.getIdpedido());
	}

	@Override
	public void insertBasic(Pedido record) throws Exception {
		record.setIdpedido((int)utilsBusiness.getNextSeq(Sequence.SEQ_PEDIDO).longValue());
		record.setFechacreacionauditoria(Utils.currentTimeStamp());
		record.setEstadoauditoria("1");
		updateBooleanToChar(record);
		validateInsert(record);
		Utils.convertPropertiesStringToUppercase(record);
		pedidoMapper.insert(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void insertFull(Pedido record) throws Exception {
		//Business Logic
		insertBasic(record);
	}

	@Override
	public void insertSelectiveBasic(Pedido record) throws Exception {
		record.setIdpedido((int)utilsBusiness.getNextSeq(Sequence.SEQ_PEDIDO).longValue());
		record.setFechacreacionauditoria(Utils.currentTimeStamp());
		record.setEstadoauditoria("1");
		updateBooleanToChar(record);
		Utils.convertPropertiesStringToUppercase(record);
		pedidoMapper.insertSelective(record);
	}

	@Override
	public Pedido selectByPrimaryKeyBasic(java.lang.Integer par_idpedido) throws Exception {
		return pedidoMapper.selectByPrimaryKeyBasic(par_idpedido);
	}

	@Override
	public Pedido selectByPrimaryKeyBasicFromList(java.lang.Integer par_idpedido, List<Pedido> list) throws Exception {
		Pedido record=null;
		for (Pedido row : list) {
			if(row.equals(new Pedido( par_idpedido))){
				record=row;
				break;
			}
		}
		if(record==null)
			record=selectByPrimaryKeyBasic( par_idpedido);

		return record;
	}

	@Override
	public Pedido selectByPrimaryKeyBasicActive(java.lang.Integer par_idpedido) throws Exception {
		return pedidoMapper.selectByPrimaryKeyBasicActive(par_idpedido);
	}

	@Override
	public Pedido selectByPrimaryKeyFull(java.lang.Integer par_idpedido) throws Exception {
		return pedidoMapper.selectByPrimaryKeyFull(par_idpedido);
	}

	@Override
	public Pedido selectByPrimaryKeyFullActive(java.lang.Integer par_idpedido) throws Exception {
		return pedidoMapper.selectByPrimaryKeyFullActive(par_idpedido);
	}

	@Override
	public List<Pedido> selectDynamicBasic(Pedido record) throws Exception {
		return pedidoMapper.selectDynamicBasic(record);
	}

	@Override
	public List<Pedido> selectDynamicBasicActives(Pedido record) throws Exception {
		record.setEstadoauditoria("1");
		return pedidoMapper.selectDynamicBasic(record);
	}

	@Override
	public List<Pedido> selectDynamicFull(Pedido record) throws Exception {
		List<Pedido> list=pedidoMapper.selectDynamicFull(record);
		if(Pedido.HAVE_BIGDECIMALS)
		for (Pedido row : list) {
			row.roundBigDecimals();
		}

		return list;
	}

	@Override
	public List<Pedido> selectDynamicFullActives(Pedido record) throws Exception {
		record.setEstadoauditoria("1");
		return pedidoMapper.selectDynamicFull(record);
	}

	@Override
	public List<Pedido> selectDynamicExtended(Pedido record) throws Exception {
		return pedidoMapper.selectDynamicExtended(record);
	}

	@Override
	public List<Pedido> selectDynamicExtendedActives(Pedido record) throws Exception {
		record.setEstadoauditoria("1");
		return pedidoMapper.selectDynamicExtended(record);
	}

	@Override
	public void updateByPrimaryKeySelectiveBasic(Pedido record) throws Exception {
		record.setFechamodificacionauditoria(Utils.currentTimeStamp());
		updateBooleanToChar(record);
		Utils.convertPropertiesStringToUppercase(record);
		pedidoMapper.updateByPrimaryKeySelective(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void updateByPrimaryKeySelectiveFull(Pedido record) throws Exception {
		//Business Logic
		updateByPrimaryKeySelectiveBasic(record);
	}

	@Override
	public void updateByPrimaryKeyBasic(Pedido record) throws Exception {
		record.setFechamodificacionauditoria(Utils.currentTimeStamp());
		updateBooleanToChar(record);
		validateUpdate(record);
		Utils.convertPropertiesStringToUppercase(record);
		pedidoMapper.updateByPrimaryKey(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void updateByPrimaryKeyFull(Pedido record) throws Exception {
		//Business Logic
		updateByPrimaryKeyBasic(record);
	}

	public void updateBooleanToChar(Pedido record) throws Exception {
		if(record.getBooleantiposinad()!=null && record.getBooleantiposinad()){
			record.setTiposinad("1");
		}else{
			record.setTiposinad("0");
		}

	}

	public void validateInsert(Pedido record)throws Exception{
		if(record.getIdpedido()==null)
			throw new ValidateException(Messages.getString("pedido.idpedido.required"));
		if(record.getNropedido()==null)
			throw new ValidateException(Messages.getString("pedido.nropedido.required"));

		if(record.getNropedido()!=null &&  record.getNropedido().length() > 5)
			throw new ValidateException(Messages.getString("pedido.nropedido.length.error",record.getNropedido().length()));
		if(record.getIdcatalogotipobien()!=null &&  record.getIdcatalogotipobien().length() > 10)
			throw new ValidateException(Messages.getString("pedido.idcatalogotipobien.length.error",record.getIdcatalogotipobien().length()));
		if(record.getCodigocentrocosto()!=null &&  record.getCodigocentrocosto().length() > 15)
			throw new ValidateException(Messages.getString("pedido.codigocentrocosto.length.error",record.getCodigocentrocosto().length()));
		if(record.getNombredependencia()!=null &&  record.getNombredependencia().length() > 100)
			throw new ValidateException(Messages.getString("pedido.nombredependencia.length.error",record.getNombredependencia().length()));
		if(record.getDescripcionpedidosiga()!=null &&  record.getDescripcionpedidosiga().length() > 2000)
			throw new ValidateException(Messages.getString("pedido.descripcionpedidosiga.length.error",record.getDescripcionpedidosiga().length()));
		if(record.getNumeroexpedientesinad()!=null &&  record.getNumeroexpedientesinad().length() > 30)
			throw new ValidateException(Messages.getString("pedido.numeroexpedientesinad.length.error",record.getNumeroexpedientesinad().length()));
		if(record.getUsuariocreacionauditoria()!=null &&  record.getUsuariocreacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("pedido.usuariocreacionauditoria.length.error",record.getUsuariocreacionauditoria().length()));
		if(record.getUsuariomodificacionauditoria()!=null &&  record.getUsuariomodificacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("pedido.usuariomodificacionauditoria.length.error",record.getUsuariomodificacionauditoria().length()));
		if(record.getIdcatalogotiponecesidad()!=null &&  record.getIdcatalogotiponecesidad().length() > 10)
			throw new ValidateException(Messages.getString("pedido.idcatalogotiponecesidad.length.error",record.getIdcatalogotiponecesidad().length()));
		if(record.getTipodocumentosinad()!=null &&  record.getTipodocumentosinad().length() > 50)
			throw new ValidateException(Messages.getString("pedido.tipodocumentosinad.length.error",record.getTipodocumentosinad().length()));
		if(record.getNumerodocumentosinad()!=null &&  record.getNumerodocumentosinad().length() > 100)
			throw new ValidateException(Messages.getString("pedido.numerodocumentosinad.length.error",record.getNumerodocumentosinad().length()));
		if(record.getTiposinad()!=null &&  record.getTiposinad().length() > 1)
			throw new ValidateException(Messages.getString("pedido.tiposinad.length.error",record.getTiposinad().length()));
		if(record.getEquipoauditoria()!=null &&  record.getEquipoauditoria().length() > 45)
			throw new ValidateException(Messages.getString("pedido.equipoauditoria.length.error",record.getEquipoauditoria().length()));
		if(record.getProgramaauditoria()!=null &&  record.getProgramaauditoria().length() > 200)
			throw new ValidateException(Messages.getString("pedido.programaauditoria.length.error",record.getProgramaauditoria().length()));
		if(record.getEstadoauditoria()!=null &&  record.getEstadoauditoria().length() > 1)
			throw new ValidateException(Messages.getString("pedido.estadoauditoria.length.error",record.getEstadoauditoria().length()));

		//Here Bussines Validations.
	}

	public void validateUpdate(Pedido record)throws Exception{
		if(record.getIdpedido()==null)
			throw new ValidateException(Messages.getString("pedido.idpedido.required"));
		if(record.getNropedido()==null)
			throw new ValidateException(Messages.getString("pedido.nropedido.required"));

		if(record.getNropedido()!=null &&  record.getNropedido().length() > 5)
			throw new ValidateException(Messages.getString("pedido.nropedido.length.error",record.getNropedido().length()));
		if(record.getIdcatalogotipobien()!=null &&  record.getIdcatalogotipobien().length() > 10)
			throw new ValidateException(Messages.getString("pedido.idcatalogotipobien.length.error",record.getIdcatalogotipobien().length()));
		if(record.getCodigocentrocosto()!=null &&  record.getCodigocentrocosto().length() > 15)
			throw new ValidateException(Messages.getString("pedido.codigocentrocosto.length.error",record.getCodigocentrocosto().length()));
		if(record.getNombredependencia()!=null &&  record.getNombredependencia().length() > 100)
			throw new ValidateException(Messages.getString("pedido.nombredependencia.length.error",record.getNombredependencia().length()));
		if(record.getDescripcionpedidosiga()!=null &&  record.getDescripcionpedidosiga().length() > 2000)
			throw new ValidateException(Messages.getString("pedido.descripcionpedidosiga.length.error",record.getDescripcionpedidosiga().length()));
		if(record.getNumeroexpedientesinad()!=null &&  record.getNumeroexpedientesinad().length() > 30)
			throw new ValidateException(Messages.getString("pedido.numeroexpedientesinad.length.error",record.getNumeroexpedientesinad().length()));
		if(record.getUsuariocreacionauditoria()!=null &&  record.getUsuariocreacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("pedido.usuariocreacionauditoria.length.error",record.getUsuariocreacionauditoria().length()));
		if(record.getUsuariomodificacionauditoria()!=null &&  record.getUsuariomodificacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("pedido.usuariomodificacionauditoria.length.error",record.getUsuariomodificacionauditoria().length()));
		if(record.getIdcatalogotiponecesidad()!=null &&  record.getIdcatalogotiponecesidad().length() > 10)
			throw new ValidateException(Messages.getString("pedido.idcatalogotiponecesidad.length.error",record.getIdcatalogotiponecesidad().length()));
		if(record.getTipodocumentosinad()!=null &&  record.getTipodocumentosinad().length() > 50)
			throw new ValidateException(Messages.getString("pedido.tipodocumentosinad.length.error",record.getTipodocumentosinad().length()));
		if(record.getNumerodocumentosinad()!=null &&  record.getNumerodocumentosinad().length() > 100)
			throw new ValidateException(Messages.getString("pedido.numerodocumentosinad.length.error",record.getNumerodocumentosinad().length()));
		if(record.getTiposinad()!=null &&  record.getTiposinad().length() > 1)
			throw new ValidateException(Messages.getString("pedido.tiposinad.length.error",record.getTiposinad().length()));
		if(record.getEquipoauditoria()!=null &&  record.getEquipoauditoria().length() > 45)
			throw new ValidateException(Messages.getString("pedido.equipoauditoria.length.error",record.getEquipoauditoria().length()));
		if(record.getProgramaauditoria()!=null &&  record.getProgramaauditoria().length() > 200)
			throw new ValidateException(Messages.getString("pedido.programaauditoria.length.error",record.getProgramaauditoria().length()));
		if(record.getEstadoauditoria()!=null &&  record.getEstadoauditoria().length() > 1)
			throw new ValidateException(Messages.getString("pedido.estadoauditoria.length.error",record.getEstadoauditoria().length()));

		//Here Bussines Validations.
	}

	public void validateDelete(java.lang.Integer par_idpedido)throws Exception{
		if(par_idpedido==null)
			throw new ValidateException(Messages.getString("pedido.idpedido.required"));

		//Here Bussines Validations.
	}


}

