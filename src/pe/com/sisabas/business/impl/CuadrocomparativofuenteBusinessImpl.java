
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
import pe.com.sisabas.be.Cuadrocomparativofuente;
import pe.com.sisabas.persistence.CuadrocomparativofuenteMapper;
import pe.com.sisabas.business.CuadrocomparativofuenteBusiness;
import pe.com.sisabas.exception.BusinessException;
import pe.com.sisabas.exception.ValidateException;
import pe.com.sisabas.resources.Constantes;
import pe.com.sisabas.resources.Messages;
import pe.com.sisabas.resources.Sequence;
import pe.com.sisabas.resources.Utils;
import pe.com.sisabas.resources.business.UtilsBusiness;


@Service
public class CuadrocomparativofuenteBusinessImpl implements CuadrocomparativofuenteBusiness, Serializable{

	private static Logger logger=Logger.getLogger(CuadrocomparativofuenteBusinessImpl.class);

	private static final long serialVersionUID = 1L;

	@Autowired
	public CuadrocomparativofuenteMapper cuadrocomparativofuenteMapper;

	@Autowired
	public UtilsBusiness utilsBusiness;

	@Override
	public void deleteByPrimaryKeyBasic(Cuadrocomparativofuente par_record) throws Exception {
		validateDelete(par_record.getIdcuadrocomparativofuente());
		cuadrocomparativofuenteMapper.deleteByPrimaryKey(par_record.getIdcuadrocomparativofuente());
	}

	@Override
	public void insertBasic(Cuadrocomparativofuente record) throws Exception {
		record.setIdcuadrocomparativofuente((int)utilsBusiness.getNextSeq(Sequence.SEQ_CUADROCOMPARATIVOFUENTE).longValue());
		record.setFechacreacionauditoria(Utils.currentTimeStamp());
		record.setEstadoauditoria("1");
		updateBooleanToChar(record);
		validateInsert(record);
		Utils.convertPropertiesStringToUppercase(record);
		cuadrocomparativofuenteMapper.insert(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void insertFull(Cuadrocomparativofuente record) throws Exception {
		//Business Logic
		insertBasic(record);
	}

	@Override
	public void insertSelectiveBasic(Cuadrocomparativofuente record) throws Exception {
		record.setIdcuadrocomparativofuente((int)utilsBusiness.getNextSeq(Sequence.SEQ_CUADROCOMPARATIVOFUENTE).longValue());
		record.setFechacreacionauditoria(Utils.currentTimeStamp());
		record.setEstadoauditoria("1");
		updateBooleanToChar(record);
		Utils.convertPropertiesStringToUppercase(record);
		cuadrocomparativofuenteMapper.insertSelective(record);
	}

	@Override
	public Cuadrocomparativofuente selectByPrimaryKeyBasic(java.lang.Integer par_idcuadrocomparativofuente) throws Exception {
		return cuadrocomparativofuenteMapper.selectByPrimaryKeyBasic(par_idcuadrocomparativofuente);
	}

	@Override
	public Cuadrocomparativofuente selectByPrimaryKeyBasicFromList(java.lang.Integer par_idcuadrocomparativofuente, List<Cuadrocomparativofuente> list) throws Exception {
		Cuadrocomparativofuente record=null;
		for (Cuadrocomparativofuente row : list) {
			if(row.equals(new Cuadrocomparativofuente( par_idcuadrocomparativofuente))){
				record=row;
				break;
			}
		}
		if(record==null)
			record=selectByPrimaryKeyBasic( par_idcuadrocomparativofuente);

		return record;
	}

	@Override
	public Cuadrocomparativofuente selectByPrimaryKeyBasicActive(java.lang.Integer par_idcuadrocomparativofuente) throws Exception {
		return cuadrocomparativofuenteMapper.selectByPrimaryKeyBasicActive(par_idcuadrocomparativofuente);
	}

	@Override
	public Cuadrocomparativofuente selectByPrimaryKeyFull(java.lang.Integer par_idcuadrocomparativofuente) throws Exception {
		return cuadrocomparativofuenteMapper.selectByPrimaryKeyFull(par_idcuadrocomparativofuente);
	}

	@Override
	public Cuadrocomparativofuente selectByPrimaryKeyFullActive(java.lang.Integer par_idcuadrocomparativofuente) throws Exception {
		return cuadrocomparativofuenteMapper.selectByPrimaryKeyFullActive(par_idcuadrocomparativofuente);
	}

	@Override
	public List<Cuadrocomparativofuente> selectDynamicBasic(Cuadrocomparativofuente record) throws Exception {
		return cuadrocomparativofuenteMapper.selectDynamicBasic(record);
	}

	@Override
	public List<Cuadrocomparativofuente> selectDynamicBasicActives(Cuadrocomparativofuente record) throws Exception {
		record.setEstadoauditoria("1");
		return cuadrocomparativofuenteMapper.selectDynamicBasic(record);
	}

	@Override
	public List<Cuadrocomparativofuente> selectDynamicFull(Cuadrocomparativofuente record) throws Exception {
		List<Cuadrocomparativofuente> list=cuadrocomparativofuenteMapper.selectDynamicFull(record);
		if(Cuadrocomparativofuente.HAVE_BIGDECIMALS)
		for (Cuadrocomparativofuente row : list) {
			row.roundBigDecimals();
		}

		return list;
	}

	@Override
	public List<Cuadrocomparativofuente> selectDynamicFullActives(Cuadrocomparativofuente record) throws Exception {
		record.setEstadoauditoria("1");
		return cuadrocomparativofuenteMapper.selectDynamicFull(record);
	}

	@Override
	public List<Cuadrocomparativofuente> selectDynamicExtended(Cuadrocomparativofuente record) throws Exception {
		return cuadrocomparativofuenteMapper.selectDynamicExtended(record);
	}

	@Override
	public List<Cuadrocomparativofuente> selectDynamicExtendedActives(Cuadrocomparativofuente record) throws Exception {
		record.setEstadoauditoria("1");
		return cuadrocomparativofuenteMapper.selectDynamicExtended(record);
	}

	@Override
	public void updateByPrimaryKeySelectiveBasic(Cuadrocomparativofuente record) throws Exception {
		record.setFechamodificacionauditoria(Utils.currentTimeStamp());
		updateBooleanToChar(record);
		Utils.convertPropertiesStringToUppercase(record);
		cuadrocomparativofuenteMapper.updateByPrimaryKeySelective(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void updateByPrimaryKeySelectiveFull(Cuadrocomparativofuente record) throws Exception {
		//Business Logic
		updateByPrimaryKeySelectiveBasic(record);
	}

	@Override
	public void updateByPrimaryKeyBasic(Cuadrocomparativofuente record) throws Exception {
		record.setFechamodificacionauditoria(Utils.currentTimeStamp());
		updateBooleanToChar(record);
		validateUpdate(record);
		Utils.convertPropertiesStringToUppercase(record);
		cuadrocomparativofuenteMapper.updateByPrimaryKey(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void updateByPrimaryKeyFull(Cuadrocomparativofuente record) throws Exception {
		//Business Logic
		updateByPrimaryKeyBasic(record);
	}

	public void updateBooleanToChar(Cuadrocomparativofuente record) throws Exception {
		if(record.getBooleanproveedordedicacontratacion()!=null && record.getBooleanproveedordedicacontratacion()){
			record.setProveedordedicacontratacion("1");
		}else{
			record.setProveedordedicacontratacion("0");
		}

		if(record.getBooleanusuarioparticiportm()!=null && record.getBooleanusuarioparticiportm()){
			record.setUsuarioparticiportm("1");
		}else{
			record.setUsuarioparticiportm("0");
		}

		if(record.getBooleancumplertm()!=null && record.getBooleancumplertm()){
			record.setCumplertm("1");
		}else{
			record.setCumplertm("0");
		}

		if(record.getBooleansetomoencuenta()!=null && record.getBooleansetomoencuenta()){
			record.setSetomoencuenta("1");
		}else{
			record.setSetomoencuenta("0");
		}

	}

	public void validateInsert(Cuadrocomparativofuente record)throws Exception{
		if(record.getIdcuadrocomparativofuente()==null)
			throw new ValidateException(Messages.getString("cuadrocomparativofuente.idcuadrocomparativofuente.required"));
		if(record.getIdpacconsolidado()==null)
			throw new ValidateException(Messages.getString("cuadrocomparativofuente.idpacconsolidado.required"));
		if(record.getIdcatalogotipofuente()==null)
			throw new ValidateException(Messages.getString("cuadrocomparativofuente.idcatalogotipofuente.required"));
		if(record.getIdcatalogotipobien()==null)
			throw new ValidateException(Messages.getString("cuadrocomparativofuente.idcatalogotipobien.required"));

		if(record.getIdcatalogotipofuente()!=null &&  record.getIdcatalogotipofuente().length() > 10)
			throw new ValidateException(Messages.getString("cuadrocomparativofuente.idcatalogotipofuente.length.error",record.getIdcatalogotipofuente().length()));
		if(record.getIdcatalogotipobien()!=null &&  record.getIdcatalogotipobien().length() > 10)
			throw new ValidateException(Messages.getString("cuadrocomparativofuente.idcatalogotipobien.length.error",record.getIdcatalogotipobien().length()));
		if(record.getRucproveedor()!=null &&  record.getRucproveedor().length() > 11)
			throw new ValidateException(Messages.getString("cuadrocomparativofuente.rucproveedor.length.error",record.getRucproveedor().length()));
		if(record.getNombreproveedor()!=null &&  record.getNombreproveedor().length() > 150)
			throw new ValidateException(Messages.getString("cuadrocomparativofuente.nombreproveedor.length.error",record.getNombreproveedor().length()));
		if(record.getNombrecontacto()!=null &&  record.getNombrecontacto().length() > 50)
			throw new ValidateException(Messages.getString("cuadrocomparativofuente.nombrecontacto.length.error",record.getNombrecontacto().length()));
		if(record.getTelefonoproveedor()!=null &&  record.getTelefonoproveedor().length() > 20)
			throw new ValidateException(Messages.getString("cuadrocomparativofuente.telefonoproveedor.length.error",record.getTelefonoproveedor().length()));
		if(record.getCorreoproveedor()!=null &&  record.getCorreoproveedor().length() > 60)
			throw new ValidateException(Messages.getString("cuadrocomparativofuente.correoproveedor.length.error",record.getCorreoproveedor().length()));
		if(record.getEntidadconvocante()!=null &&  record.getEntidadconvocante().length() > 150)
			throw new ValidateException(Messages.getString("cuadrocomparativofuente.entidadconvocante.length.error",record.getEntidadconvocante().length()));
		if(record.getTiponumeroproceso()!=null &&  record.getTiponumeroproceso().length() > 50)
			throw new ValidateException(Messages.getString("cuadrocomparativofuente.tiponumeroproceso.length.error",record.getTiponumeroproceso().length()));
		if(record.getMarca()!=null &&  record.getMarca().length() > 100)
			throw new ValidateException(Messages.getString("cuadrocomparativofuente.marca.length.error",record.getMarca().length()));
		if(record.getModelo()!=null &&  record.getModelo().length() > 100)
			throw new ValidateException(Messages.getString("cuadrocomparativofuente.modelo.length.error",record.getModelo().length()));
		if(record.getProcedencia()!=null &&  record.getProcedencia().length() > 100)
			throw new ValidateException(Messages.getString("cuadrocomparativofuente.procedencia.length.error",record.getProcedencia().length()));
		if(record.getAniofabricacion()!=null &&  record.getAniofabricacion().length() > 4)
			throw new ValidateException(Messages.getString("cuadrocomparativofuente.aniofabricacion.length.error",record.getAniofabricacion().length()));
		if(record.getGarantiacomercial()!=null &&  record.getGarantiacomercial().length() > 100)
			throw new ValidateException(Messages.getString("cuadrocomparativofuente.garantiacomercial.length.error",record.getGarantiacomercial().length()));
		if(record.getFormapago()!=null &&  record.getFormapago().length() > 100)
			throw new ValidateException(Messages.getString("cuadrocomparativofuente.formapago.length.error",record.getFormapago().length()));
		if(record.getIdcatalogomonedafuente()!=null &&  record.getIdcatalogomonedafuente().length() > 10)
			throw new ValidateException(Messages.getString("cuadrocomparativofuente.idcatalogomonedafuente.length.error",record.getIdcatalogomonedafuente().length()));
		if(record.getPreciounitariomonedaconsignada()!=null &&  record.getPreciounitariomonedaconsignada().length() > 100)
			throw new ValidateException(Messages.getString("cuadrocomparativofuente.preciounitariomonedaconsignada.length.error",record.getPreciounitariomonedaconsignada().length()));
		if(record.getProveedordedicacontratacion()!=null &&  record.getProveedordedicacontratacion().length() > 1)
			throw new ValidateException(Messages.getString("cuadrocomparativofuente.proveedordedicacontratacion.length.error",record.getProveedordedicacontratacion().length()));
		if(record.getUsuarioparticiportm()!=null &&  record.getUsuarioparticiportm().length() > 1)
			throw new ValidateException(Messages.getString("cuadrocomparativofuente.usuarioparticiportm.length.error",record.getUsuarioparticiportm().length()));
		if(record.getCumplertm()!=null &&  record.getCumplertm().length() > 1)
			throw new ValidateException(Messages.getString("cuadrocomparativofuente.cumplertm.length.error",record.getCumplertm().length()));
		if(record.getSetomoencuenta()!=null &&  record.getSetomoencuenta().length() > 1)
			throw new ValidateException(Messages.getString("cuadrocomparativofuente.setomoencuenta.length.error",record.getSetomoencuenta().length()));
		if(record.getUsuariocreacionauditoria()!=null &&  record.getUsuariocreacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("cuadrocomparativofuente.usuariocreacionauditoria.length.error",record.getUsuariocreacionauditoria().length()));
		if(record.getUsuariomodificacionauditoria()!=null &&  record.getUsuariomodificacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("cuadrocomparativofuente.usuariomodificacionauditoria.length.error",record.getUsuariomodificacionauditoria().length()));
		if(record.getEquipoauditoria()!=null &&  record.getEquipoauditoria().length() > 45)
			throw new ValidateException(Messages.getString("cuadrocomparativofuente.equipoauditoria.length.error",record.getEquipoauditoria().length()));
		if(record.getProgramaauditoria()!=null &&  record.getProgramaauditoria().length() > 200)
			throw new ValidateException(Messages.getString("cuadrocomparativofuente.programaauditoria.length.error",record.getProgramaauditoria().length()));
		if(record.getEstadoauditoria()!=null &&  record.getEstadoauditoria().length() > 1)
			throw new ValidateException(Messages.getString("cuadrocomparativofuente.estadoauditoria.length.error",record.getEstadoauditoria().length()));

		//Here Bussines Validations.
	}

	public void validateUpdate(Cuadrocomparativofuente record)throws Exception{
		if(record.getIdcuadrocomparativofuente()==null)
			throw new ValidateException(Messages.getString("cuadrocomparativofuente.idcuadrocomparativofuente.required"));
		if(record.getIdpacconsolidado()==null)
			throw new ValidateException(Messages.getString("cuadrocomparativofuente.idpacconsolidado.required"));
		if(record.getIdcatalogotipofuente()==null)
			throw new ValidateException(Messages.getString("cuadrocomparativofuente.idcatalogotipofuente.required"));
		if(record.getIdcatalogotipobien()==null)
			throw new ValidateException(Messages.getString("cuadrocomparativofuente.idcatalogotipobien.required"));

		if(record.getIdcatalogotipofuente()!=null &&  record.getIdcatalogotipofuente().length() > 10)
			throw new ValidateException(Messages.getString("cuadrocomparativofuente.idcatalogotipofuente.length.error",record.getIdcatalogotipofuente().length()));
		if(record.getIdcatalogotipobien()!=null &&  record.getIdcatalogotipobien().length() > 10)
			throw new ValidateException(Messages.getString("cuadrocomparativofuente.idcatalogotipobien.length.error",record.getIdcatalogotipobien().length()));
		if(record.getRucproveedor()!=null &&  record.getRucproveedor().length() > 11)
			throw new ValidateException(Messages.getString("cuadrocomparativofuente.rucproveedor.length.error",record.getRucproveedor().length()));
		if(record.getNombreproveedor()!=null &&  record.getNombreproveedor().length() > 150)
			throw new ValidateException(Messages.getString("cuadrocomparativofuente.nombreproveedor.length.error",record.getNombreproveedor().length()));
		if(record.getNombrecontacto()!=null &&  record.getNombrecontacto().length() > 50)
			throw new ValidateException(Messages.getString("cuadrocomparativofuente.nombrecontacto.length.error",record.getNombrecontacto().length()));
		if(record.getTelefonoproveedor()!=null &&  record.getTelefonoproveedor().length() > 20)
			throw new ValidateException(Messages.getString("cuadrocomparativofuente.telefonoproveedor.length.error",record.getTelefonoproveedor().length()));
		if(record.getCorreoproveedor()!=null &&  record.getCorreoproveedor().length() > 60)
			throw new ValidateException(Messages.getString("cuadrocomparativofuente.correoproveedor.length.error",record.getCorreoproveedor().length()));
		if(record.getEntidadconvocante()!=null &&  record.getEntidadconvocante().length() > 150)
			throw new ValidateException(Messages.getString("cuadrocomparativofuente.entidadconvocante.length.error",record.getEntidadconvocante().length()));
		if(record.getTiponumeroproceso()!=null &&  record.getTiponumeroproceso().length() > 50)
			throw new ValidateException(Messages.getString("cuadrocomparativofuente.tiponumeroproceso.length.error",record.getTiponumeroproceso().length()));
		if(record.getMarca()!=null &&  record.getMarca().length() > 100)
			throw new ValidateException(Messages.getString("cuadrocomparativofuente.marca.length.error",record.getMarca().length()));
		if(record.getModelo()!=null &&  record.getModelo().length() > 100)
			throw new ValidateException(Messages.getString("cuadrocomparativofuente.modelo.length.error",record.getModelo().length()));
		if(record.getProcedencia()!=null &&  record.getProcedencia().length() > 100)
			throw new ValidateException(Messages.getString("cuadrocomparativofuente.procedencia.length.error",record.getProcedencia().length()));
		if(record.getAniofabricacion()!=null &&  record.getAniofabricacion().length() > 4)
			throw new ValidateException(Messages.getString("cuadrocomparativofuente.aniofabricacion.length.error",record.getAniofabricacion().length()));
		if(record.getGarantiacomercial()!=null &&  record.getGarantiacomercial().length() > 100)
			throw new ValidateException(Messages.getString("cuadrocomparativofuente.garantiacomercial.length.error",record.getGarantiacomercial().length()));
		if(record.getFormapago()!=null &&  record.getFormapago().length() > 100)
			throw new ValidateException(Messages.getString("cuadrocomparativofuente.formapago.length.error",record.getFormapago().length()));
		if(record.getIdcatalogomonedafuente()!=null &&  record.getIdcatalogomonedafuente().length() > 10)
			throw new ValidateException(Messages.getString("cuadrocomparativofuente.idcatalogomonedafuente.length.error",record.getIdcatalogomonedafuente().length()));
		if(record.getPreciounitariomonedaconsignada()!=null &&  record.getPreciounitariomonedaconsignada().length() > 100)
			throw new ValidateException(Messages.getString("cuadrocomparativofuente.preciounitariomonedaconsignada.length.error",record.getPreciounitariomonedaconsignada().length()));
		if(record.getProveedordedicacontratacion()!=null &&  record.getProveedordedicacontratacion().length() > 1)
			throw new ValidateException(Messages.getString("cuadrocomparativofuente.proveedordedicacontratacion.length.error",record.getProveedordedicacontratacion().length()));
		if(record.getUsuarioparticiportm()!=null &&  record.getUsuarioparticiportm().length() > 1)
			throw new ValidateException(Messages.getString("cuadrocomparativofuente.usuarioparticiportm.length.error",record.getUsuarioparticiportm().length()));
		if(record.getCumplertm()!=null &&  record.getCumplertm().length() > 1)
			throw new ValidateException(Messages.getString("cuadrocomparativofuente.cumplertm.length.error",record.getCumplertm().length()));
		if(record.getSetomoencuenta()!=null &&  record.getSetomoencuenta().length() > 1)
			throw new ValidateException(Messages.getString("cuadrocomparativofuente.setomoencuenta.length.error",record.getSetomoencuenta().length()));
		if(record.getUsuariocreacionauditoria()!=null &&  record.getUsuariocreacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("cuadrocomparativofuente.usuariocreacionauditoria.length.error",record.getUsuariocreacionauditoria().length()));
		if(record.getUsuariomodificacionauditoria()!=null &&  record.getUsuariomodificacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("cuadrocomparativofuente.usuariomodificacionauditoria.length.error",record.getUsuariomodificacionauditoria().length()));
		if(record.getEquipoauditoria()!=null &&  record.getEquipoauditoria().length() > 45)
			throw new ValidateException(Messages.getString("cuadrocomparativofuente.equipoauditoria.length.error",record.getEquipoauditoria().length()));
		if(record.getProgramaauditoria()!=null &&  record.getProgramaauditoria().length() > 200)
			throw new ValidateException(Messages.getString("cuadrocomparativofuente.programaauditoria.length.error",record.getProgramaauditoria().length()));
		if(record.getEstadoauditoria()!=null &&  record.getEstadoauditoria().length() > 1)
			throw new ValidateException(Messages.getString("cuadrocomparativofuente.estadoauditoria.length.error",record.getEstadoauditoria().length()));

		//Here Bussines Validations.
	}

	public void validateDelete(java.lang.Integer par_idcuadrocomparativofuente)throws Exception{
		if(par_idcuadrocomparativofuente==null)
			throw new ValidateException(Messages.getString("cuadrocomparativofuente.idcuadrocomparativofuente.required"));

		//Here Bussines Validations.
	}


}

