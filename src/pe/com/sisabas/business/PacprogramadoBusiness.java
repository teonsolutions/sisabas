package pe.com.sisabas.business;
import java.util.List;
import pe.com.sisabas.be.Pacprogramado;

public interface PacprogramadoBusiness{

	public void deleteByPrimaryKeyBasic(Pacprogramado par_record) throws Exception;

	public void insertBasic(Pacprogramado record) throws Exception;

	public void insertFull(Pacprogramado record) throws Exception;

	public void insertSelectiveBasic(Pacprogramado record) throws Exception;

	public Pacprogramado selectByPrimaryKeyBasic(java.lang.Integer par_idpacprogramado) throws Exception;

	public Pacprogramado selectByPrimaryKeyBasicFromList(java.lang.Integer par_idpacprogramado,List<Pacprogramado> list) throws Exception;

	public Pacprogramado selectByPrimaryKeyBasicActive(java.lang.Integer par_idpacprogramado) throws Exception;

	public Pacprogramado selectByPrimaryKeyFull(java.lang.Integer par_idpacprogramado) throws Exception;

	public Pacprogramado selectByPrimaryKeyFullActive(java.lang.Integer par_idpacprogramado) throws Exception;

	public List<Pacprogramado> selectDynamicBasic(Pacprogramado record) throws Exception;

	public List<Pacprogramado> selectDynamicBasicActives(Pacprogramado record) throws Exception;

	public List<Pacprogramado> selectDynamicFull(Pacprogramado record) throws Exception;

	public List<Pacprogramado> selectDynamicFullActives(Pacprogramado record) throws Exception;

	public List<Pacprogramado> selectDynamicExtended(Pacprogramado record) throws Exception;

	public List<Pacprogramado> selectDynamicExtendedActives(Pacprogramado record) throws Exception;

	public void updateByPrimaryKeySelectiveBasic(Pacprogramado record) throws Exception;

	public void updateByPrimaryKeySelectiveFull(Pacprogramado record) throws Exception;

	public void updateByPrimaryKeyBasic(Pacprogramado record) throws Exception;

	public void updateByPrimaryKeyFull(Pacprogramado record) throws Exception;


}
