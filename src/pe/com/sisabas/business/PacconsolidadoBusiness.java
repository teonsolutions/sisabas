package pe.com.sisabas.business;
import java.util.List;
import pe.com.sisabas.be.Pacconsolidado;
import pe.com.sisabas.dto.CuadroComparativoItemsDto;
import pe.com.sisabas.dto.CuadroComparativoRequest;

public interface PacconsolidadoBusiness{

	public void deleteByPrimaryKeyBasic(Pacconsolidado par_record) throws Exception;

	public void insertBasic(Pacconsolidado record) throws Exception;

	public void insertFull(Pacconsolidado record) throws Exception;

	public void insertSelectiveBasic(Pacconsolidado record) throws Exception;

	public Pacconsolidado selectByPrimaryKeyBasic(java.lang.Integer par_idpacconsolidado) throws Exception;

	public Pacconsolidado selectByPrimaryKeyBasicFromList(java.lang.Integer par_idpacconsolidado,List<Pacconsolidado> list) throws Exception;

	public Pacconsolidado selectByPrimaryKeyBasicActive(java.lang.Integer par_idpacconsolidado) throws Exception;

	public Pacconsolidado selectByPrimaryKeyFull(java.lang.Integer par_idpacconsolidado) throws Exception;

	public Pacconsolidado selectByPrimaryKeyFullActive(java.lang.Integer par_idpacconsolidado) throws Exception;

	public List<Pacconsolidado> selectDynamicBasic(Pacconsolidado record) throws Exception;

	public List<Pacconsolidado> selectDynamicBasicActives(Pacconsolidado record) throws Exception;

	public List<Pacconsolidado> selectDynamicFull(Pacconsolidado record) throws Exception;

	public List<Pacconsolidado> selectDynamicFullActives(Pacconsolidado record) throws Exception;

	public List<Pacconsolidado> selectDynamicExtended(Pacconsolidado record) throws Exception;

	public List<Pacconsolidado> selectDynamicExtendedActives(Pacconsolidado record) throws Exception;

	public void updateByPrimaryKeySelectiveBasic(Pacconsolidado record) throws Exception;

	public void updateByPrimaryKeySelectiveFull(Pacconsolidado record) throws Exception;

	public void updateByPrimaryKeyBasic(Pacconsolidado record) throws Exception;

	public void updateByPrimaryKeyFull(Pacconsolidado record) throws Exception;

}
