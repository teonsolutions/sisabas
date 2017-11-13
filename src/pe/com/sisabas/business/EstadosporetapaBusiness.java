package pe.com.sisabas.business;
import java.util.List;
import pe.com.sisabas.be.Estadosporetapa;

public interface EstadosporetapaBusiness{

	public void deleteByPrimaryKeyBasic(Estadosporetapa par_record) throws Exception;

	public void insertBasic(Estadosporetapa record) throws Exception;

	public void insertFull(Estadosporetapa record) throws Exception;

	public void insertSelectiveBasic(Estadosporetapa record) throws Exception;

	public Estadosporetapa selectByPrimaryKeyBasic(java.lang.Integer par_idestadoporetapa) throws Exception;

	public Estadosporetapa selectByPrimaryKeyBasicFromList(java.lang.Integer par_idestadoporetapa,List<Estadosporetapa> list) throws Exception;

	public Estadosporetapa selectByPrimaryKeyBasicActive(java.lang.Integer par_idestadoporetapa) throws Exception;

	public Estadosporetapa selectByPrimaryKeyFull(java.lang.Integer par_idestadoporetapa) throws Exception;

	public Estadosporetapa selectByPrimaryKeyFullActive(java.lang.Integer par_idestadoporetapa) throws Exception;

	public List<Estadosporetapa> selectDynamicBasic(Estadosporetapa record) throws Exception;

	public List<Estadosporetapa> selectDynamicBasicActives(Estadosporetapa record) throws Exception;

	public List<Estadosporetapa> selectDynamicFull(Estadosporetapa record) throws Exception;

	public List<Estadosporetapa> selectDynamicFullActives(Estadosporetapa record) throws Exception;

	public List<Estadosporetapa> selectDynamicExtended(Estadosporetapa record) throws Exception;

	public List<Estadosporetapa> selectDynamicExtendedActives(Estadosporetapa record) throws Exception;

	public void updateByPrimaryKeySelectiveBasic(Estadosporetapa record) throws Exception;

	public void updateByPrimaryKeySelectiveFull(Estadosporetapa record) throws Exception;

	public void updateByPrimaryKeyBasic(Estadosporetapa record) throws Exception;

	public void updateByPrimaryKeyFull(Estadosporetapa record) throws Exception;


}
