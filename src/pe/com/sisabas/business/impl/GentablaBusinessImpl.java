
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
import pe.com.sisabas.be.Gentabla;
import pe.com.sisabas.persistence.GentablaMapper;
import pe.com.sisabas.business.GentablaBusiness;
import pe.com.sisabas.dto.ConvocatoriaDto;
import pe.com.sisabas.dto.EstadoRequerimientoResponse;
import pe.com.sisabas.dto.GentablaItemResponse;
import pe.com.sisabas.dto.TipoProcesoResponse;
import pe.com.sisabas.exception.BusinessException;
import pe.com.sisabas.exception.ValidateException;
import pe.com.sisabas.resources.Constantes;
import pe.com.sisabas.resources.Messages;
import pe.com.sisabas.resources.Sequence;
import pe.com.sisabas.resources.Utils;
import pe.com.sisabas.resources.business.UtilsBusiness;


@Service
public class GentablaBusinessImpl implements GentablaBusiness, Serializable{

	private static Logger logger=Logger.getLogger(GentablaBusinessImpl.class);

	private static final long serialVersionUID = 1L;

	@Autowired
	public GentablaMapper gentablaMapper;

	@Autowired
	public UtilsBusiness utilsBusiness;

	@Override
	public void deleteByPrimaryKeyBasic(Gentabla par_record) throws Exception {
		validateDelete(par_record.getVchregcodigo());
		gentablaMapper.deleteByPrimaryKey(par_record.getVchregcodigo());
	}

	@Override
	public void insertBasic(Gentabla record) throws Exception {
		record.setFechacreacionauditoria(Utils.currentTimeStamp());
		record.setEstadoauditoria("1");
		updateBooleanToChar(record);
		validateInsert(record);
		Utils.convertPropertiesStringToUppercase(record);
		gentablaMapper.insert(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void insertFull(Gentabla record) throws Exception {
		//Business Logic
		insertBasic(record);
	}

	@Override
	public void insertSelectiveBasic(Gentabla record) throws Exception {
		record.setFechacreacionauditoria(Utils.currentTimeStamp());
		record.setEstadoauditoria("1");
		updateBooleanToChar(record);
		Utils.convertPropertiesStringToUppercase(record);
		gentablaMapper.insertSelective(record);
	}

	@Override
	public Gentabla selectByPrimaryKeyBasic(java.lang.String par_vchregcodigo) throws Exception {
		return gentablaMapper.selectByPrimaryKeyBasic(par_vchregcodigo);
	}

	@Override
	public Gentabla selectByPrimaryKeyBasicFromList(java.lang.String par_vchregcodigo, List<Gentabla> list) throws Exception {
		System.out.println("--ww1--");
		Gentabla record=null;
		for (Gentabla row : list) {
			System.out.println("Vchregcodigo" +row.getVchregcodigo());
			
			
			if(row.equals(new Gentabla( par_vchregcodigo))){
				record=row;
				System.out.println("encontro!! "+record.getVchregcodigo());
				break;
			}
		}
		if(record==null)
			System.out.println("--ww0--");
			record=selectByPrimaryKeyBasic( par_vchregcodigo);

		return record;
	}

	@Override
	public Gentabla selectByPrimaryKeyBasicActive(java.lang.String par_vchregcodigo) throws Exception {
		return gentablaMapper.selectByPrimaryKeyBasicActive(par_vchregcodigo);
	}

	@Override
	public Gentabla selectByPrimaryKeyFull(java.lang.String par_vchregcodigo) throws Exception {
		return gentablaMapper.selectByPrimaryKeyFull(par_vchregcodigo);
	}

	@Override
	public Gentabla selectByPrimaryKeyFullActive(java.lang.String par_vchregcodigo) throws Exception {
		return gentablaMapper.selectByPrimaryKeyFullActive(par_vchregcodigo);
	}

	@Override
	public List<Gentabla> selectDynamicBasic(Gentabla record) throws Exception {
		List<Gentabla> arreglo = gentablaMapper.selectDynamicBasic(record);
		List<Gentabla> lista = new ArrayList<Gentabla>();
		
		
		for (int i = 0; i < arreglo.size(); i++) {
			Gentabla genTabla = new Gentabla();
			genTabla.setBooleanestadoauditoria(arreglo.get(i).getBooleanestadoauditoria());
			genTabla.setCantidadRegistros(arreglo.get(i).getCantidadRegistros());
			genTabla.setEquipoauditoria(arreglo.get(i).getEquipoauditoria());
			genTabla.setEstadoauditoria(arreglo.get(i).getEquipoauditoria());
			genTabla.setFechacreacionauditoria(arreglo.get(i).getFechacreacionauditoria());
			genTabla.setFechacreacionauditoriafin(arreglo.get(i).getFechamodificacionauditoriafin());
			genTabla.setFechacreacionauditoriaini(arreglo.get(i).getFechamodificacionauditoriaini());
			genTabla.setFechamodificacionauditoria(arreglo.get(i).getFechamodificacionauditoria());
			genTabla.setFechamodificacionauditoriafin(arreglo.get(i).getFechamodificacionauditoriafin());
			genTabla.setFechamodificacionauditoriaini(arreglo.get(i).getFechamodificacionauditoriaini());
			genTabla.setGentipoVchtipcodigo(arreglo.get(i).getGentipoVchtipcodigo());
			genTabla.setIntganempid(arreglo.get(i).getIntganempid());
			genTabla.setIntregorden(arreglo.get(i).getIntregorden());
			genTabla.setOrdenListaCampos(arreglo.get(i).getOrdenListaCampos());
			genTabla.setOrdenTipo(arreglo.get(i).getOrdenTipo());
			genTabla.setParams(arreglo.get(i).getParams());
			genTabla.setProgramaauditoria(arreglo.get(i).getProgramaauditoria());
			genTabla.setUsuariocreacionauditoria(arreglo.get(i).getUsuariocreacionauditoria());
			genTabla.setUsuariomodificacionauditoria(arreglo.get(i).getUsuariomodificacionauditoria());
			genTabla.setVchregabreviado(arreglo.get(i).getVchregabreviado());
			genTabla.setVchregcodigo(arreglo.get(i).getVchregcodigo());
			genTabla.setVchregdescri(arreglo.get(i).getVchregdescri());
			genTabla.setVchtabotro1(arreglo.get(i).getVchtabotro1());
			genTabla.setVchtabotro2(arreglo.get(i).getVchtabotro2());
			genTabla.setVchtabotro3(arreglo.get(i).getVchtabotro3());
			genTabla.setVchtabotro4(arreglo.get(i).getVchtabotro4());
			genTabla.setVchtipcodigo(arreglo.get(i).getVchtipcodigo());
			
			if(arreglo.get(i).getVchregdescri().equals("BIEN")){
				genTabla.setOrden("B");
				
			}if(arreglo.get(i).getVchregdescri().equals("SERVICIO")){
				genTabla.setOrden("S");
					
			}	
			
			lista.add(genTabla);
			
		}
		
		
		return lista;
	}

	@Override
	public List<Gentabla> selectDynamicBasicActives(Gentabla record) throws Exception {
		record.setEstadoauditoria("1");
		return gentablaMapper.selectDynamicBasic(record);
	}

	@Override
	public List<Gentabla> selectDynamicFull(Gentabla record) throws Exception {
		List<Gentabla> list=gentablaMapper.selectDynamicFull(record);
		if(Gentabla.HAVE_BIGDECIMALS)
		for (Gentabla row : list) {
			row.roundBigDecimals();
		}

		return list;
	}

	@Override
	public List<Gentabla> selectDynamicFullActives(Gentabla record) throws Exception {
		record.setEstadoauditoria("1");
		return gentablaMapper.selectDynamicFull(record);
	}

	@Override
	public List<Gentabla> selectDynamicExtended(Gentabla record) throws Exception {
		return gentablaMapper.selectDynamicExtended(record);
	}

	@Override
	public List<Gentabla> selectDynamicExtendedActives(Gentabla record) throws Exception {
		record.setEstadoauditoria("1");
		return gentablaMapper.selectDynamicExtended(record);
	}

	@Override
	public void updateByPrimaryKeySelectiveBasic(Gentabla record) throws Exception {
		record.setFechamodificacionauditoria(Utils.currentTimeStamp());
		updateBooleanToChar(record);
		Utils.convertPropertiesStringToUppercase(record);
		gentablaMapper.updateByPrimaryKeySelective(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void updateByPrimaryKeySelectiveFull(Gentabla record) throws Exception {
		//Business Logic
		updateByPrimaryKeySelectiveBasic(record);
	}

	@Override
	public void updateByPrimaryKeyBasic(Gentabla record) throws Exception {
		record.setFechamodificacionauditoria(Utils.currentTimeStamp());
		updateBooleanToChar(record);
		validateUpdate(record);
		Utils.convertPropertiesStringToUppercase(record);
		gentablaMapper.updateByPrimaryKey(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void updateByPrimaryKeyFull(Gentabla record) throws Exception {
		//Business Logic
		updateByPrimaryKeyBasic(record);
	}

	public void updateBooleanToChar(Gentabla record) throws Exception {
		if(record.getBooleanestadoauditoria()!=null && record.getBooleanestadoauditoria()){
			record.setEstadoauditoria("1");
		}else{
			record.setEstadoauditoria("0");
		}

	}

	public void validateInsert(Gentabla record)throws Exception{
		if(record.getVchregcodigo()==null)
			throw new ValidateException(Messages.getString("gentabla.vchregcodigo.required"));
		if(record.getVchregdescri()==null)
			throw new ValidateException(Messages.getString("gentabla.vchregdescri.required"));
		if(record.getVchtipcodigo()==null)
			throw new ValidateException(Messages.getString("gentabla.vchtipcodigo.required"));
		if(record.getEstadoauditoria()==null)
			throw new ValidateException(Messages.getString("gentabla.estadoauditoria.required"));
		if(record.getUsuariocreacionauditoria()==null)
			throw new ValidateException(Messages.getString("gentabla.usuariocreacionauditoria.required"));
		if(record.getFechacreacionauditoria()==null)
			throw new ValidateException(Messages.getString("gentabla.fechacreacionauditoria.required"));
		if(record.getEquipoauditoria()==null)
			throw new ValidateException(Messages.getString("gentabla.equipoauditoria.required"));
		if(record.getProgramaauditoria()==null)
			throw new ValidateException(Messages.getString("gentabla.programaauditoria.required"));

		if(record.getVchregcodigo()!=null &&  record.getVchregcodigo().length() > 10)
			throw new ValidateException(Messages.getString("gentabla.vchregcodigo.length.error",record.getVchregcodigo().length()));
		if(record.getVchregdescri()!=null &&  record.getVchregdescri().length() > 100)
			throw new ValidateException(Messages.getString("gentabla.vchregdescri.length.error",record.getVchregdescri().length()));
		if(record.getVchregabreviado()!=null &&  record.getVchregabreviado().length() > 45)
			throw new ValidateException(Messages.getString("gentabla.vchregabreviado.length.error",record.getVchregabreviado().length()));
		if(record.getVchtipcodigo()!=null &&  record.getVchtipcodigo().length() > 10)
			throw new ValidateException(Messages.getString("gentabla.vchtipcodigo.length.error",record.getVchtipcodigo().length()));
		if(record.getVchtabotro1()!=null &&  record.getVchtabotro1().length() > 40)
			throw new ValidateException(Messages.getString("gentabla.vchtabotro1.length.error",record.getVchtabotro1().length()));
		if(record.getVchtabotro2()!=null &&  record.getVchtabotro2().length() > 40)
			throw new ValidateException(Messages.getString("gentabla.vchtabotro2.length.error",record.getVchtabotro2().length()));
		if(record.getVchtabotro3()!=null &&  record.getVchtabotro3().length() > 40)
			throw new ValidateException(Messages.getString("gentabla.vchtabotro3.length.error",record.getVchtabotro3().length()));
		if(record.getVchtabotro4()!=null &&  record.getVchtabotro4().length() > 40)
			throw new ValidateException(Messages.getString("gentabla.vchtabotro4.length.error",record.getVchtabotro4().length()));
		if(record.getEstadoauditoria()!=null &&  record.getEstadoauditoria().length() > 1)
			throw new ValidateException(Messages.getString("gentabla.estadoauditoria.length.error",record.getEstadoauditoria().length()));
		if(record.getUsuariocreacionauditoria()!=null &&  record.getUsuariocreacionauditoria().length() > 10)
			throw new ValidateException(Messages.getString("gentabla.usuariocreacionauditoria.length.error",record.getUsuariocreacionauditoria().length()));
		if(record.getUsuariomodificacionauditoria()!=null &&  record.getUsuariomodificacionauditoria().length() > 10)
			throw new ValidateException(Messages.getString("gentabla.usuariomodificacionauditoria.length.error",record.getUsuariomodificacionauditoria().length()));
		if(record.getEquipoauditoria()!=null &&  record.getEquipoauditoria().length() > 45)
			throw new ValidateException(Messages.getString("gentabla.equipoauditoria.length.error",record.getEquipoauditoria().length()));
		if(record.getProgramaauditoria()!=null &&  record.getProgramaauditoria().length() > 200)
			throw new ValidateException(Messages.getString("gentabla.programaauditoria.length.error",record.getProgramaauditoria().length()));

		//Here Bussines Validations.
	}

	public void validateUpdate(Gentabla record)throws Exception{
		if(record.getVchregcodigo()==null)
			throw new ValidateException(Messages.getString("gentabla.vchregcodigo.required"));
		if(record.getVchregdescri()==null)
			throw new ValidateException(Messages.getString("gentabla.vchregdescri.required"));
		if(record.getVchtipcodigo()==null)
			throw new ValidateException(Messages.getString("gentabla.vchtipcodigo.required"));
		if(record.getEstadoauditoria()==null)
			throw new ValidateException(Messages.getString("gentabla.estadoauditoria.required"));
		if(record.getUsuariocreacionauditoria()==null)
			throw new ValidateException(Messages.getString("gentabla.usuariocreacionauditoria.required"));
		if(record.getFechacreacionauditoria()==null)
			throw new ValidateException(Messages.getString("gentabla.fechacreacionauditoria.required"));
		if(record.getEquipoauditoria()==null)
			throw new ValidateException(Messages.getString("gentabla.equipoauditoria.required"));
		if(record.getProgramaauditoria()==null)
			throw new ValidateException(Messages.getString("gentabla.programaauditoria.required"));

		if(record.getVchregcodigo()!=null &&  record.getVchregcodigo().length() > 10)
			throw new ValidateException(Messages.getString("gentabla.vchregcodigo.length.error",record.getVchregcodigo().length()));
		if(record.getVchregdescri()!=null &&  record.getVchregdescri().length() > 100)
			throw new ValidateException(Messages.getString("gentabla.vchregdescri.length.error",record.getVchregdescri().length()));
		if(record.getVchregabreviado()!=null &&  record.getVchregabreviado().length() > 45)
			throw new ValidateException(Messages.getString("gentabla.vchregabreviado.length.error",record.getVchregabreviado().length()));
		if(record.getVchtipcodigo()!=null &&  record.getVchtipcodigo().length() > 10)
			throw new ValidateException(Messages.getString("gentabla.vchtipcodigo.length.error",record.getVchtipcodigo().length()));
		if(record.getVchtabotro1()!=null &&  record.getVchtabotro1().length() > 40)
			throw new ValidateException(Messages.getString("gentabla.vchtabotro1.length.error",record.getVchtabotro1().length()));
		if(record.getVchtabotro2()!=null &&  record.getVchtabotro2().length() > 40)
			throw new ValidateException(Messages.getString("gentabla.vchtabotro2.length.error",record.getVchtabotro2().length()));
		if(record.getVchtabotro3()!=null &&  record.getVchtabotro3().length() > 40)
			throw new ValidateException(Messages.getString("gentabla.vchtabotro3.length.error",record.getVchtabotro3().length()));
		if(record.getVchtabotro4()!=null &&  record.getVchtabotro4().length() > 40)
			throw new ValidateException(Messages.getString("gentabla.vchtabotro4.length.error",record.getVchtabotro4().length()));
		if(record.getEstadoauditoria()!=null &&  record.getEstadoauditoria().length() > 1)
			throw new ValidateException(Messages.getString("gentabla.estadoauditoria.length.error",record.getEstadoauditoria().length()));
		if(record.getUsuariocreacionauditoria()!=null &&  record.getUsuariocreacionauditoria().length() > 10)
			throw new ValidateException(Messages.getString("gentabla.usuariocreacionauditoria.length.error",record.getUsuariocreacionauditoria().length()));
		if(record.getUsuariomodificacionauditoria()!=null &&  record.getUsuariomodificacionauditoria().length() > 10)
			throw new ValidateException(Messages.getString("gentabla.usuariomodificacionauditoria.length.error",record.getUsuariomodificacionauditoria().length()));
		if(record.getEquipoauditoria()!=null &&  record.getEquipoauditoria().length() > 45)
			throw new ValidateException(Messages.getString("gentabla.equipoauditoria.length.error",record.getEquipoauditoria().length()));
		if(record.getProgramaauditoria()!=null &&  record.getProgramaauditoria().length() > 200)
			throw new ValidateException(Messages.getString("gentabla.programaauditoria.length.error",record.getProgramaauditoria().length()));

		//Here Bussines Validations.
	}

	public void validateDelete(java.lang.String par_vchregcodigo)throws Exception{
		if(par_vchregcodigo==null)
			throw new ValidateException(Messages.getString("gentabla.vchregcodigo.required"));

		//Here Bussines Validations.
	}

	@Override
	public List<TipoProcesoResponse> getTipoProceso(Integer anio) throws Exception {
		// TODO Auto-generated method stub
		return gentablaMapper.getTipoProceso(anio);
	}

	@Override
	public List<EstadoRequerimientoResponse> getEstadoRequerimiento(Integer idEtapaAdministrativa) throws Exception {
		// TODO Auto-generated method stub
		return gentablaMapper.getEstadoRequerimiento(idEtapaAdministrativa);
	}

	@Override
	public List<GentablaItemResponse> getItems(String tipo) throws Exception {
		// TODO Auto-generated method stub
		return gentablaMapper.getItems(tipo);
	}

	@Override
	public String getDescripcion(String key) throws Exception {
		// TODO Auto-generated method stub
		Gentabla genTabla = gentablaMapper.selectByPrimaryKeyBasic(key);
		String descripcion = genTabla != null ? genTabla.getVchregdescri() : "";
		return descripcion;
	}

	@Override
	public List<Gentabla> selectByTypeCustom(String type, String status) throws Exception {
		// TODO Auto-generated method stub		
		List<String> ordenListaCampos = new ArrayList<String>();
		ordenListaCampos.add("A1.INTREGORDEN");
		Gentabla gt = new Gentabla();
		gt.setOrdenListaCampos(ordenListaCampos);
		if (status.length() > 0){
			gt.setEstadoauditoria(Constantes.estadoAuditoria.ACTIVO);	
		}		
		gt.setVchtipcodigo(type);
		
		List<Gentabla> arreglo = gentablaMapper.selectDynamicBasic(gt);
		List<Gentabla> lista = new ArrayList<Gentabla>();
		
		
		for (int i = 0; i < arreglo.size(); i++) {
			Gentabla genTabla = new Gentabla();
			genTabla.setBooleanestadoauditoria(arreglo.get(i).getBooleanestadoauditoria());
			genTabla.setCantidadRegistros(arreglo.get(i).getCantidadRegistros());
			genTabla.setEquipoauditoria(arreglo.get(i).getEquipoauditoria());
			genTabla.setEstadoauditoria(arreglo.get(i).getEquipoauditoria());
			genTabla.setFechacreacionauditoria(arreglo.get(i).getFechacreacionauditoria());
			genTabla.setFechacreacionauditoriafin(arreglo.get(i).getFechamodificacionauditoriafin());
			genTabla.setFechacreacionauditoriaini(arreglo.get(i).getFechamodificacionauditoriaini());
			genTabla.setFechamodificacionauditoria(arreglo.get(i).getFechamodificacionauditoria());
			genTabla.setFechamodificacionauditoriafin(arreglo.get(i).getFechamodificacionauditoriafin());
			genTabla.setFechamodificacionauditoriaini(arreglo.get(i).getFechamodificacionauditoriaini());
			genTabla.setGentipoVchtipcodigo(arreglo.get(i).getGentipoVchtipcodigo());
			genTabla.setIntganempid(arreglo.get(i).getIntganempid());
			genTabla.setIntregorden(arreglo.get(i).getIntregorden());
			genTabla.setOrdenListaCampos(arreglo.get(i).getOrdenListaCampos());
			genTabla.setOrdenTipo(arreglo.get(i).getOrdenTipo());
			genTabla.setParams(arreglo.get(i).getParams());
			genTabla.setProgramaauditoria(arreglo.get(i).getProgramaauditoria());
			genTabla.setUsuariocreacionauditoria(arreglo.get(i).getUsuariocreacionauditoria());
			genTabla.setUsuariomodificacionauditoria(arreglo.get(i).getUsuariomodificacionauditoria());
			genTabla.setVchregabreviado(arreglo.get(i).getVchregabreviado());
			genTabla.setVchregcodigo(arreglo.get(i).getVchregcodigo());
			genTabla.setVchregdescri(arreglo.get(i).getVchregdescri());
			genTabla.setVchtabotro1(arreglo.get(i).getVchtabotro1());
			genTabla.setVchtabotro2(arreglo.get(i).getVchtabotro2());
			genTabla.setVchtabotro3(arreglo.get(i).getVchtabotro3());
			genTabla.setVchtabotro4(arreglo.get(i).getVchtabotro4());
			genTabla.setVchtipcodigo(arreglo.get(i).getVchtipcodigo());
			
			if(arreglo.get(i).getVchregdescri().equals("BIEN")){
				genTabla.setOrden("B");
				
			}if(arreglo.get(i).getVchregdescri().equals("SERVICIO")){
				genTabla.setOrden("S");
					
			}	
			
			lista.add(genTabla);
			
		}
		
		
		return lista;
	}

	@Override
	public EstadoRequerimientoResponse getEstadoRequerimientoByIdEstadosTipoDocumento(Integer idestadosportipodocumento)
			throws Exception {
		// TODO Auto-generated method stub
		return gentablaMapper.getEstadoRequerimientoByIdEstadosTipoDocumento(idestadosportipodocumento);
	}


}

