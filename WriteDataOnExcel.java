package ExcelFunctions;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author com
 *
 */
public class WriteDataOnExcel {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		XSSFWorkbook workbook=new XSSFWorkbook();
		XSSFSheet sheet=workbook.createSheet("Emp Info");
		Object empdata[][]= {{"EmpID","Name","work"},
				             {1001,"John","Engineer"},
				             {1002,"David","Manager"},
				             {1003,"Smith","Analyst"}};
		//using for loop
	/*	int rows=empdata.length;
		int columns=empdata[0].length;
		System.out.println(rows+"\n"+columns);
		for(int r=0;r<rows;r++) {
			XSSFRow row=sheet.createRow(r);
			for(int c=0;c<columns;c++) {
				XSSFCell cell=row.createCell(c);
				Object value=empdata[r][c];*/
		
		//using for .. each loop
		int rowCoun=0;
		for(Object emp[]:empdata) {
			XSSFRow row=sheet.createRow(rowCoun++);
			int columnCount=0;
			for(Object value:emp) {
				XSSFCell cell=row.createCell(columnCount++);
				if(value instanceof String) {
					cell.setCellValue((String)value);
				}
				if(value instanceof Integer) {
					cell.setCellValue((Integer)value);
				}
				if (value instanceof Boolean) {
					cell.setCellValue((boolean)value);
				}
			}
			
		}
		String filepath="E:\\selenium work\\excel\\Employee2.xlsx";
		FileOutputStream outputStream=new FileOutputStream(filepath);
		workbook.write(outputStream);
		outputStream.close();
		System.out.println("Employee.xlsx file written successfully");
		
	}

}
