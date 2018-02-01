package pe.com.sisabas.business;
import java.util.List;
import pe.com.sisabas.be.Contratosporprocesoseleccion;

public interface ContratosporprocesoseleccionBusiness{

	public void deleteByPrimaryKeyBasic(Contratosporprocesoseleccion par_record) throws Exception;

	public void insertBasic(Contratosporprocesoseleccion record) throws Exception;

	public void insertFull(Contratosporprocesoseleccion record) throws Exception;

	public void insertSelectiveBasic(Contratosporprocesoseleccion record) throws Exception;

	public Contratosporprocesoseleccion selectByPrimaryKeyBasic(java.lang.Integer par_idcontratoporproceso) throws Exception;

	public Contratosporprocesoseleccion selectByPrimaryKeyBasicFromList(java.lang.Integer par_idcontratoporproceso,List<Contratosporprocesoseleccion> list) throws Exception;

	public Contratosporprocesoseleccion selectByPrimaryKeyBasicActive(java.lang.Integer par_idcontratoporproceso) throws Exception;

	public Contratosporprocesoseleccion selectByPrimaryKeyFull(java.lang.Integer par_idcontratoporproceso) throws Exception;

	public Contratosporprocesoseleccion selectByPrimaryKeyFullActive(java.lang.Integer par_idcontratoporproceso) throws Exception;

	public List<Contratosporprocesoseleccion> selectDynamicBasic(Contratosporprocesoseleccion record) throws Exception;

	public List<Contratosporprocesoseleccion> selectDynamicBasicActives(Contratosporprocesoseleccion record) throws Exception;

	public List<Contratosporprocesoseleccion> selectDynamicFull(Contratosporprocesoseleccion record) throws Exception;

	public List<Contratosporprocesoseleccion> selectDynamicFullActives(Contratosporprocesoseleccion record) throws Exception;

	public List<Contratosporprocesoseleccion> selectDynamicExtended(Contratosporprocesoseleccion record) throws Exception;

	public List<Contratosporprocesoseleccion> selectDynamicExtendedActives(Contratosporprocesoseleccion record) throws Exception;

	public void updateByPrimaryKeySelectiveBasic(Contratosporprocesoseleccion record) throws Exception;

	public void updateByPrimaryKeySelectiveFull(Contratosporprocesoseleccion record) throws Exception;

	public void updateByPrimaryKeyBasic(Contratosporprocesoseleccion record) throws Exception;

	public void updateByPrimaryKeyFull(Contratosporprocesoseleccion record) throws Exception;


}
