package pe.com.sisabas.resources;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.print.Doc;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.Attribute;
import javax.print.attribute.AttributeSet;
import javax.print.attribute.HashAttributeSet;
import javax.print.attribute.PrintServiceAttributeSet;
import javax.print.attribute.standard.Destination;
import javax.print.attribute.standard.PrinterInfo;
import javax.print.attribute.standard.PrinterIsAcceptingJobs;
import javax.print.attribute.standard.PrinterLocation;
import javax.print.attribute.standard.PrinterMakeAndModel;
import javax.print.attribute.standard.PrinterName;
import javax.print.attribute.standard.PrinterState;

import org.apache.log4j.Logger;

import pe.com.sisabas.be.Genparametro;


public class UtilPrinter {
	public static Logger logger=Logger.getLogger(UtilPrinter.class);

	private static int MAX_ADVANCE_9PIN = 216; //for 24/48 pin esc/p2 printers this should be 180
    private static int MAX_ADVANCE_24PIN = 180;
    private static int MAX_UNITS = 127; //for vertical positioning range is between 0 - 255 (0 <= n <= 255) according to epson ref. but 255 gives weird errors at 1.5f, 127 as max (0 - 128) seems to be working
    private static final float CM_PER_INCH = 2.54f;
    /* decimal ascii values for epson ESC/P commands */
    private static final char ESC = 27; //escape
    private static final char AT = 64; //@
    private static final char LINE_FEED = 10; //line feed/new line
    private static final char PARENTHESIS_LEFT = 40;
    private static final char BACKSLASH = 92;
    private static final char CR = 13; //carriage return
    private static final char TAB = 9; //horizontal tab
    private static final char FF = 12; //form feed
    private static final char g = 103; //15cpi pitch
    private static final char p = 112; //used for choosing proportional mode or fixed-pitch
    private static final char t = 116; //used for character set assignment/selection
    private static final char l = 108; //used for setting left margin
    private static final char x = 120; //used for setting draft or letter quality (LQ) printing
    private static final char E = 69; //bold font on
    private static final char F = 70; //bold font off
    private static final char J = 74; //used for advancing paper vertically
    private static final char P = 80; //10cpi pitch
    private static final char Q = 81; //used for setting right margin
    private static final char $ = 36; //used for absolute horizontal positioning
    private static final char ARGUMENT_0 = 0;
    private static final char ARGUMENT_1 = 1;
    private static final char ARGUMENT_2 = 2;
    private static final char ARGUMENT_3 = 3;
    private static final char ARGUMENT_4 = 4;
    private static final char ARGUMENT_5 = 5;
    private static final char ARGUMENT_6 = 6;
    private static final char ARGUMENT_7 = 7;
    private static final char ARGUMENT_12 = 12;
    private static final char ARGUMENT_25 = 25;
    /* character sets */
    public static final char USA = ARGUMENT_1;
    public static final char BRAZIL = ARGUMENT_25;
    public static final char LATINO = ARGUMENT_12;

    
    
	
	public static void main(String []a)throws Exception{
		//getPrintAvailableNames();
		//printAvailable();
		/*
	    printDefault();
	    printByName("Nitro PDF Creator");		
		
	    imprimir("http://localhost:8080/SARG/repFactura.txt", "");
	    */
	    
		//imprimir("http://localhost:8080/SARG/borra1.txt", "\\\\172.16.2.28\\Epson LX-300+");
		
	}

    public static void imprimir(String rep_texto, String impresora)
    {
        //PrintService defaultPrintService = PrintServiceLookup.lookupDefaultPrintService();
    	
        PrintService defaultPrintService = null;
    	if (impresora==null || impresora.trim().length()==0) //si no paso parametro de impresora, se usa predeterminada
    	defaultPrintService = PrintServiceLookup.lookupDefaultPrintService();
    	
        
        /**/
        
    	//!!! PrintService[] services = PrintServiceLookup.lookupPrintServices(null, null);
        
    	PrintService[] services = null;
    	if (impresora!=null && impresora.trim().length()>0){
    		PrintServiceLookup.lookupPrintServices(null, null);
    		
            // buscar por el nombre de la impresora (nombre que le diste en tu S.O.)
            // en "aset" puedes agregar mas atributos de busqueda
            AttributeSet aset = new HashAttributeSet();
            aset.add(new PrinterName(impresora, null));
            //aset.add(ColorSupported.SUPPORTED); // si quisieras buscar ademas las que soporten color
     
            services = PrintServiceLookup.lookupPrintServices(null, aset);
            if(services.length == 0){
            	logger.debug("No se encontro impresora con nombre " + impresora);
            }
            for (PrintService printService : services) {
            	logger.debug(printService.getName());
            	defaultPrintService = printService;
            	if (defaultPrintService!=null){
            		break;
            	}
    		}
    	}
    	
        /**/
        
        DocPrintJob printerJob = defaultPrintService.createPrintJob();
        URL url = null;
        try
        {
            url = new URL(rep_texto);
        }
        catch(MalformedURLException e)
        {
        	logger.debug((new StringBuilder()).append("Malformed URL= ").append(e).toString());
        }
        SimpleDoc simpleDoc = null;
        simpleDoc = new SimpleDoc(url, javax.print.DocFlavor.URL.AUTOSENSE, null);
        
        try
        {
            printerJob.print(simpleDoc, null);
        }
        catch(PrintException ex)
        {
            ex.printStackTrace();
        }
    	
    }
    
    
    
    public static void printAvailable() {
    	 
        // busca los servicios de impresion...
        PrintService[] services = PrintServiceLookup.lookupPrintServices(null, null);
 
        // -- ver los atributos de las impresoras...
        for (PrintService printService : services) {
 
        	logger.debug("IMPRESORA:" + printService.getName());
 
            PrintServiceAttributeSet printServiceAttributeSet = printService.getAttributes();
 
            logger.debug("ATRIBUTOS");
 
            // todos los atributos de la impresora
            Attribute[] a = printServiceAttributeSet.toArray();
            for (Attribute unAtribute : a) {
            	 logger.debug("\t ATRIBUTO: " + unAtribute.getName());
            }
 
            logger.debug("Viendo valores especificos de los atributos");
            // valor especifico de un determinado atributo de la impresora
            logger.debug("PrinterLocation: " + printServiceAttributeSet.get(PrinterLocation.class));
            logger.debug("PrinterInfo: " + printServiceAttributeSet.get(PrinterInfo.class));
            logger.debug("PrinterState: " + printServiceAttributeSet.get(PrinterState.class));
            logger.debug("Destination: " + printServiceAttributeSet.get(Destination.class));
            logger.debug("PrinterMakeAndModel: " + printServiceAttributeSet.get(PrinterMakeAndModel.class));
            logger.debug("PrinterIsAcceptingJobs: " + printServiceAttributeSet.get(PrinterIsAcceptingJobs.class)); 
        }
 
    }
 
    public static void printDefault() {
 
        // tu impresora por default
        PrintService service = PrintServiceLookup.lookupDefaultPrintService();
        logger.debug("Tu impresora por default es: " + service.getName());
 
    }

    public static void printByName(String printName) {
 
    	PrintService[] services = PrintServiceLookup.lookupPrintServices(null, null);
 
        // buscar por el nombre de la impresora (nombre que le diste en tu S.O.)
        // en "aset" puedes agregar mas atributos de busqueda
        AttributeSet aset = new HashAttributeSet();
        aset.add(new PrinterName(printName, null));
        //aset.add(ColorSupported.SUPPORTED); // si quisieras buscar ademas las que soporten color
 
        services = PrintServiceLookup.lookupPrintServices(null, aset);
        if(services.length == 0){
        	 logger.debug("No se encontro impresora con nombre " + printName);
        }
        for (PrintService printService : services) {
        	 logger.debug(printService.getName());
		}
    }    
    

    public static List<Genparametro> getPrintAvailableNames() {
    	List <Genparametro> listaImpresoras=new ArrayList<Genparametro>();
        // busca los servicios de impresion...
        PrintService[] services = PrintServiceLookup.lookupPrintServices(null, null);
        for (PrintService printService : services) {
            //System.out.println(" ---- IMPRESORA: " + printService.getName());
            
            Genparametro genparametro  = new Genparametro();
            genparametro.setVchparamcodigo(printService.getName());
            genparametro.setVchparamvalor(printService.getName());
            
            listaImpresoras.add(genparametro);
        }
        return listaImpresoras;
    }
    
    public static String getPrintDefault() {
        // tu impresora por default
        PrintService service = PrintServiceLookup.lookupDefaultPrintService();
        
        if (service!=null){
        	 logger.debug("Tu impresora por default es: " + service.getName());
        	return service.getName();
        }	
        else{
        	 logger.debug("No hay impresora default");
        	return "";
        }	
    }    

    
    public static void imprimirTXT(String rep_texto, String impresora)throws Exception
    {
        //PrintService defaultPrintService = PrintServiceLookup.lookupDefaultPrintService();

    	//printAvailable();
    	
        PrintService defaultPrintService = null;
    	if (impresora==null || impresora.trim().length()==0) //si no paso parametro de impresora, se usa predeterminada
    	defaultPrintService = PrintServiceLookup.lookupDefaultPrintService();
    	
        
        /**/
        
    	//!!! PrintService[] services = PrintServiceLookup.lookupPrintServices(null, null);
        
    	PrintService[] services = null;
    	if (impresora!=null && impresora.trim().length()>0){
    		PrintServiceLookup.lookupPrintServices(null, null);
    		
            // buscar por el nombre de la impresora (nombre que le diste en tu S.O.)
            // en "aset" puedes agregar mas atributos de busqueda
            AttributeSet aset = new HashAttributeSet();
            aset.add(new PrinterName(impresora, null));
            //aset.add(ColorSupported.SUPPORTED); // si quisieras buscar ademas las que soporten color
            
            //javax.print.DocFlavor flavor = javax.print.DocFlavor.INPUT_STREAM.TEXT_PLAIN_UTF_8;

            services = PrintServiceLookup.lookupPrintServices(null, aset); //antes de flavor era null
            if(services.length == 0){            	
            	throw new pe.com.sisabas.exception.PrintException("No se encontró impresora:" + impresora);
            }
            for (PrintService printService : services) {
            	System.out.println(printService.getName());
            	defaultPrintService = printService;
            	if (defaultPrintService!=null){
            		break;
            	}
    		}
    	}
    	
        /**/

        try
        {    	
    	
        DocPrintJob printerJob = defaultPrintService.createPrintJob();

        logger.debug("Flav:"+defaultPrintService.getSupportedDocFlavors());
        
        FileInputStream in;

        String texto = "c:\\temp\\"+rep_texto;
        logger.debug(texto);
		in = new FileInputStream(new File(texto));
		
		System.out.println(in.toString());
		
		javax.print.DocFlavor flavor = javax.print.DocFlavor.INPUT_STREAM.AUTOSENSE;
		
		
		
		//javax.print.DocFlavor docflavor = javax.print.DocFlavor.INPUT_STREAM("application/octet-stream");
		
		
		//javax.print.DocFlavor flavor = javax.print.DocFlavor.INPUT_STREAM.TEXT_PLAIN_UTF_8;
		//javax.print.DocFlavor flavor = javax.print.DocFlavor.INPUT_STREAM.TEXT_PLAIN_UTF_8;
		//javax.print.DocFlavor flavor = javax.print.DocFlavor.BYTE_ARRAY.TEXT_PLAIN_UTF_8;
		
		//javax.print.DocFlavor flavor = new javax.print.DocFlavor("text/plain; charset=utf-8", java.io.InputStream.class.getName());
		
		//javax.print.DocFlavor.UTF-8
		
		//DocFlavor("text/plain; charset=utf-8", InputStream.class); 
		
		//DocFlavor("text/plain; charset=utf-8", InputStream.class);
		
		Doc doc = new SimpleDoc(in, flavor, null);
        printerJob.print(doc, null);
        in.close();
        
        }
	    catch (FileNotFoundException ex){
		    	 ex.printStackTrace();
		    }
	    catch (IOException ex){
		    	 ex.printStackTrace();
		    }        
        catch(PrintException ex){
            ex.printStackTrace();
        }
    }
    
    
    public static String getCharacterSet() {
    	
    	//RMZ.put("bold1", Character.toString ((char) 27) + Character.toString ((char) 69) );
    	
    	String retorno =  Character.toString ((char) ESC) + 
    	                  Character.toString ((char) PARENTHESIS_LEFT) +
    	                  Character.toString ((char) t) +
    					  Character.toString ((char) ARGUMENT_3) + //always 3
    					  Character.toString ((char) ARGUMENT_0) + //always 0
    					  Character.toString ((char) ARGUMENT_1) + //selectable character table 1
    					  Character.toString ((char) LATINO) + //registered character table (arg_25 is brascii)
    					  Character.toString ((char) ARGUMENT_0); //always 0
    	                  //select character table
    					  /*
    					  Character.toString ((char) ESC) +
    					  Character.toString ((char) t) +
    					  Character.toString ((char) ARGUMENT_1); //selectable character table 1
    					  */
    	
    	return retorno;
    }    

    public static void imprimirArchivoPDF(String parArchivo, String parImpresora) {
        //INICIO:: Imprimir archivo
        System.out.println("Imprimiendo ......");
        java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
        //java.io.File fichero = new java.io.File("D://JCaldas/BPM/1ra Etapa/TablasParaDiccionarioDeDatos.txt");
        java.io.File fichero = new java.io.File(parArchivo);
        if (desktop.isSupported(java.awt.Desktop.Action.PRINT)){

        try {//Nombre de impresora::Kyocera CS-4050 (KPDL)
             //INICIO :: SETEANDO IMPRESORA PEREDETERMINADA
              try{
                    System.out.println("Seteando impresora predterminada");
                    //String nombreImpresora = "Kyocera CS-4050 (KPDL)"; //dato a modificar segun la impresora
                    String nombreImpresora = parImpresora; //dato a modificar segun la impresora
                    Process pr = Runtime.getRuntime().exec("Rundll32 printui.dll,PrintUIEntry /y /n \""+nombreImpresora+"\"");
                    System.out.println("Seteando impresora predterminada finished....");
                    desktop.print(fichero);
              }catch(Exception ex){
              System.out.println("Ha ocurrido un error al ejecutar el comando. Error: "+ex);
              }
             //FIN :: SETEANDO IMPRESORA PREDETERMINADA
              

             /* PrintRequestAttributeSet attr_set = new HashPrintRequestAttributeSet();
              attr_set.add(MediaSizeName.ISO_A4); 
              attr_set.add(new Copies(3));
              */
       // desktop.print(fichero);

        } catch (Exception e){
        System.out.print("El sistema no permite imprimir usando la clase Desktop");
        e.printStackTrace();
        }
        }else{
        System.out.print("El sistema no permite imprimir usando la clase Desktop");
        }
        }
    
    
}
