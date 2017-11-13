package pe.com.sisabas.business;
import java.util.List;
import pe.com.sisabas.be.Vcertificacion;

public interface VcertificacionBusiness{

	public void deleteByPrimaryKeyBasic(Vcertificacion par_record) throws Exception;

	public void insertBasic(Vcertificacion record) throws Exception;

	public void insertFull(Vcertificacion record) throws Exception;

	public void insertSelectiveBasic(Vcertificacion record) throws Exception;

	public Vcertificacion selectByPrimaryKeyBasic(java.lang.Integer par_vcertificacion) throws Exception;

	public Vcertificacion selectByPrimaryKeyBasicFromList(java.lang.Integer par_vcertificacion,List<Vcertificacion> list) throws Exception;

	public Vcertificacion selectByPrimaryKeyBasicActive(java.lang.Integer par_vcertificacion) throws Exception;

	public Vcertificacion selectByPrimaryKeyFull(java.lang.Integer par_vcertificacion) throws Exception;

	public Vcertificacion selectByPrimaryKeyFullActive(java.lang.Integer par_vcertificacion) throws Exception;

	public List<Vcertificacion> selectDynamicBasic(Vcertificacion record) throws Exception;

	public List<Vcertificacion> selectDynamicBasicActives(Vcertificacion record) throws Exception;

	public List<Vcertificacion> selectDynamicFull(Vcertificacion record) throws Exception;

	public List<Vcertificacion> selectDynamicFullActives(Vcertificacion record) throws Exception;

	public List<Vcertificacion> selectDynamicExtended(Vcertificacion record) throws Exception;

	public List<Vcertificacion> selectDynamicExtendedActives(Vcertificacion record) throws Exception;

	public void updateByPrimaryKeySelectiveBasic(Vcertificacion record) throws Exception;

	public void updateByPrimaryKeySelectiveFull(Vcertificacion record) throws Exception;

	public void updateByPrimaryKeyBasic(Vcertificacion record) throws Exception;

	public void updateByPrimaryKeyFull(Vcertificacion record) throws Exception;


}
