package ExcelFunctions;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteFormulaInCell {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		XSSFWorkbook workbook=new XSSFWorkbook();
		XSSFSheet sheet=workbook.createSheet("formula");
		XSSFRow row=sheet.createRow(0);
		row.createCell(0).setCellValue(10);
		row.createCell(1).setCellValue(20);
		row.createCell(2).setCellValue(30);
		row.createCell(3).setCellValue(40);
		row.createCell(5).setCellFormula("A1+B1+C1+D1");
		
		FileOutputStream outputStream=new FileOutputStream("E:\\selenium work\\excel\\formula.xlsx");
		workbook.write(outputStream);
		outputStream.close();
		System.out.println("Done!");
		

	}

}
