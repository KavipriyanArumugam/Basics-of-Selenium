package ExcelFunctions;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class ConvertCSVfileToXLSXfile {

	public static void main(String[] args) throws CsvValidationException, IOException {
		// TODO Auto-generated method stubtr
		String filereaderpath="E:\\selenium work\\pratice.csv";
		String filewriterpath="E:\\selenium work\\practice";
		 FileReader filereader = new FileReader(filereaderpath);
		 CSVReader csvReader = new CSVReader(filereader);
		String[] columns;
		
		 XSSFWorkbook workbook=new XSSFWorkbook();
	      XSSFSheet sheet=workbook.createSheet("sheet1");
	      int rowcount=0;
	        
		while ((columns = csvReader.readNext()) != null) 
		{
		XSSFRow row=sheet.createRow(rowcount++);
		int totalcsvcolumn=columns.length;
		for(int i=0;i<totalcsvcolumn;i++) 
		{
			XSSFCell cell=row.createCell(i);
			cell.setCellValue(columns[i]);
		}
	}
		csvReader.close();
		 FileOutputStream fileOutputStream=new FileOutputStream(filewriterpath+".xlsx");
	      workbook.write(fileOutputStream);
	      workbook.close();
	      fileOutputStream.close();
	      System.out.println("Done!");
}
}