package pe.com.sisabas.resources.persistence;


public interface UtilsMapper {
   Long getNextSeq(String secuence);	
   Long getNextSeqTemporal(String secuence);	       
}