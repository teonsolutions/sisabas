package pe.com.sisabas.business;
import java.util.List;
import pe.com.sisabas.be.Evaluaciondocumento;

public interface EvaluaciondocumentoBusiness{

	public void deleteByPrimaryKeyBasic(Evaluaciondocumento par_record) throws Exception;

	public void insertBasic(Evaluaciondocumento record) throws Exception;

	public void insertFull(Evaluaciondocumento record) throws Exception;

	public void insertSelectiveBasic(Evaluaciondocumento record) throws Exception;

	public Evaluaciondocumento selectByPrimaryKeyBasic(java.lang.Integer par_idevaluaciondocumento) throws Exception;

	public Evaluaciondocumento selectByPrimaryKeyBasicFromList(java.lang.Integer par_idevaluaciondocumento,List<Evaluaciondocumento> list) throws Exception;

	public Evaluaciondocumento selectByPrimaryKeyBasicActive(java.lang.Integer par_idevaluaciondocumento) throws Exception;

	public Evaluaciondocumento selectByPrimaryKeyFull(java.lang.Integer par_idevaluaciondocumento) throws Exception;

	public Evaluaciondocumento selectByPrimaryKeyFullActive(java.lang.Integer par_idevaluaciondocumento) throws Exception;

	public List<Evaluaciondocumento> selectDynamicBasic(Evaluaciondocumento record) throws Exception;

	public List<Evaluaciondocumento> selectDynamicBasicActives(Evaluaciondocumento record) throws Exception;

	public List<Evaluaciondocumento> selectDynamicFull(Evaluaciondocumento record) throws Exception;

	public List<Evaluaciondocumento> selectDynamicFullActives(Evaluaciondocumento record) throws Exception;

	public List<Evaluaciondocumento> selectDynamicExtended(Evaluaciondocumento record) throws Exception;

	public List<Evaluaciondocumento> selectDynamicExtendedActives(Evaluaciondocumento record) throws Exception;

	public void updateByPrimaryKeySelectiveBasic(Evaluaciondocumento record) throws Exception;

	public void updateByPrimaryKeySelectiveFull(Evaluaciondocumento record) throws Exception;

	public void updateByPrimaryKeyBasic(Evaluaciondocumento record) throws Exception;

	public void updateByPrimaryKeyFull(Evaluaciondocumento record) throws Exception;


}
