package pe.com.sisabas.business;
import java.util.List;
import pe.com.sisabas.be.Itinerarioconveniomarco;

public interface ItinerarioconveniomarcoBusiness{

	public void deleteByPrimaryKeyBasic(Itinerarioconveniomarco par_record) throws Exception;

	public void insertBasic(Itinerarioconveniomarco record) throws Exception;

	public void insertFull(Itinerarioconveniomarco record) throws Exception;

	public void insertSelectiveBasic(Itinerarioconveniomarco record) throws Exception;

	public Itinerarioconveniomarco selectByPrimaryKeyBasic(java.lang.Integer par_iditinerarioconveniomarco) throws Exception;

	public Itinerarioconveniomarco selectByPrimaryKeyBasicFromList(java.lang.Integer par_iditinerarioconveniomarco,List<Itinerarioconveniomarco> list) throws Exception;

	public Itinerarioconveniomarco selectByPrimaryKeyBasicActive(java.lang.Integer par_iditinerarioconveniomarco) throws Exception;

	public Itinerarioconveniomarco selectByPrimaryKeyFull(java.lang.Integer par_iditinerarioconveniomarco) throws Exception;

	public Itinerarioconveniomarco selectByPrimaryKeyFullActive(java.lang.Integer par_iditinerarioconveniomarco) throws Exception;

	public List<Itinerarioconveniomarco> selectDynamicBasic(Itinerarioconveniomarco record) throws Exception;

	public List<Itinerarioconveniomarco> selectDynamicBasicActives(Itinerarioconveniomarco record) throws Exception;

	public List<Itinerarioconveniomarco> selectDynamicFull(Itinerarioconveniomarco record) throws Exception;

	public List<Itinerarioconveniomarco> selectDynamicFullActives(Itinerarioconveniomarco record) throws Exception;

	public List<Itinerarioconveniomarco> selectDynamicExtended(Itinerarioconveniomarco record) throws Exception;

	public List<Itinerarioconveniomarco> selectDynamicExtendedActives(Itinerarioconveniomarco record) throws Exception;

	public void updateByPrimaryKeySelectiveBasic(Itinerarioconveniomarco record) throws Exception;

	public void updateByPrimaryKeySelectiveFull(Itinerarioconveniomarco record) throws Exception;

	public void updateByPrimaryKeyBasic(Itinerarioconveniomarco record) throws Exception;

	public void updateByPrimaryKeyFull(Itinerarioconveniomarco record) throws Exception;


}
