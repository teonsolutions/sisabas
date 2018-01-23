package pe.com.sisabas.controller;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;

import pe.com.sisabas.exception.ValidateException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.math.BigDecimal;

import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

public class DocumentoExcel {

    public static void main(String[] args) throws Exception {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet();
        workbook.setSheetName(0, "Hoja excel");

        String[] headers = new String[]{
            "Producto",
            "Precio",
            "Enlace"
        };

        Object[][] data = new Object[][] {
            new Object[] { "PlayStation 4 (PS4) - Consola 500GB", new BigDecimal("340.95"), "https://www.amazon.es/PlayStation-4-PS4-Consola-500GB/dp/B013U9CW8A/ref=sr_1_1?ie=UTF8&qid=1464521925&sr=8-1&keywords=playstation" },
            new Object[] { "Raspberry Pi 3 Modelo B (1,2 GHz Quad-core ARM Cortex-A53, 1GB RAM, USB 2.0)", new BigDecimal("41.95"), "https://www.amazon.es/Raspberry-Modelo-GHz-Quad-core-Cortex-A53/dp/B01CD5VC92/ref=sr_1_1?ie=UTF8&qid=1464521956&sr=8-1&keywords=raspberry+pi" },
            new Object[] { "Gigabyte Brix - Bareb�n (Intel, Core i5, 2,6 GHz, 6, 35 cm (2.5\"), Serial ATA III, SO-DIMM) Negro ", new BigDecimal("421.36"), "https://www.amazon.es/Gigabyte-Brix-Bareb%C3%B3n-Serial-SO-DIMM/dp/B00HFCTUPM/ref=sr_1_5?ie=UTF8&qid=1464522011&sr=8-5&keywords=brix" }
        };

        CellStyle headerStyle = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setBoldweight(Font.BOLDWEIGHT_BOLD);
        headerStyle.setFont(font);

        CellStyle style = workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);

        HSSFRow headerRow = sheet.createRow(0);
        for (int i = 0; i < headers.length; ++i) {
            String header = headers[i];
            HSSFCell cell = headerRow.createCell(i);
            cell.setCellStyle(headerStyle);
            cell.setCellValue(header);
        }

        for (int i = 0; i < data.length; ++i) {
            HSSFRow dataRow = sheet.createRow(i + 1);

            Object[] d = data[i];
            String product = (String) d[0];
            BigDecimal price = (BigDecimal) d[1];
            String link = (String) d[2];

            dataRow.createCell(0).setCellValue(product);
            dataRow.createCell(1).setCellValue(price.doubleValue());
            dataRow.createCell(2).setCellValue(link);
        }

        HSSFRow dataRow = sheet.createRow(1 + data.length);
        HSSFCell total = dataRow.createCell(1);
        total.setCellType(Cell.CELL_TYPE_FORMULA);
        total.setCellStyle(style);
        total.setCellFormula(String.format("SUM(B2:B%d)", 1 + data.length));

        FileOutputStream file = new FileOutputStream("workbook.xls");
        workbook.write(file);
        file.close();
        downloadFile("");
    }
    
	public static void downloadFile(String nombrearchivodestino){
		
	try{	  	
		nombrearchivodestino=nombrearchivodestino+"/"+nombrearchivodestino;
	    	
	    	File fileToDown = new File(nombrearchivodestino);
	    	
	    	if(!fileToDown.exists()){
	    		throw new ValidateException("El archivo a descargar no existe o no tiene persmisos de lectura: "+nombrearchivodestino);
	    	}
			
		    FileInputStream archivo = new FileInputStream(nombrearchivodestino);
			int longitud = archivo.available();
			byte[] datos = new byte[longitud];
			archivo.read(datos);
			archivo.close();
			
			HttpServletResponse response=(HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
			response.setContentType("application/octet-stream");
			response.setHeader("Content-Disposition", "attachment;filename=" + nombrearchivodestino);
			
			ServletOutputStream ouputStream = response.getOutputStream();
			ouputStream.write(datos);
			ouputStream.flush();
			ouputStream.close();
			fileToDown.delete();
			
	    } catch (Exception e) {  
	       e.printStackTrace();
	    
	    }  

}
}