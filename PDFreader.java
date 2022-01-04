package selenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class PDFreader {

	public static void main(String[] args) throws IOException, CsvValidationException {
		// TODO Auto-generated method stub
		
		String path1 = null;
		String filereaderpath="E:\\selenium work\\excel\\ADMPsingleuserdatacsv.csv";
		String filewriterpath="E:\\selenium work\\excel";
		FileInputStream inputStream=new FileInputStream(new File("E:\\selenium work\\New folder\\Output_of_ADMPsingleuser.xlsx"));
		XSSFWorkbook workbook=new XSSFWorkbook(inputStream);
		XSSFSheet sheet=workbook.getSheetAt(0);
		//int rowcount=sheet.getLastRowNum();
		XSSFRow row=sheet.getRow(0);
		int ColumnCount=row.getLastCellNum();
		XSSFCell cellfirstname=row.createCell(ColumnCount++);
		cellfirstname.setCellValue("FirstnamePDF");
		XSSFCell celllogonname=row.createCell(ColumnCount++);
		celllogonname.setCellValue("LogonnamePDF");
		XSSFCell cellcontainer=row.createCell(ColumnCount++);
		cellcontainer.setCellValue("EmailAddressPDF");
		XSSFCell cellfullname=row.createCell(ColumnCount++);
		cellfullname.setCellValue("FullnamePDF");
		
		
		java.io.File file = new java.io.File("C:\\Users\\com\\Downloads\\AuditReport.pdf");
		FileInputStream fileparse = new FileInputStream(file);
		PDDocument document = PDDocument.load(fileparse);
		System.out.println(document.getPages().getCount());
		PDFTextStripper pdfTextStripper = new PDFTextStripper();
	//	pdfTextStripper.setStartPage(2);
		//pdfTextStripper.setEndPage(15);

		//pdfTextStripper.setArticleStart("Action Time : 30-12-2021 06:37");
		//pdfTextStripper.setArticleEnd("Action Time : 30-12-2021 06:35");
		//pdfTextStripper.setPageStart("Action Time : 30-12-2021 06:37");
		//pdfTextStripper.setPageEnd("Action Time : 30-12-2021 06:35");
		String doctext = pdfTextStripper.getText(document);
		//System.out.println(doctext);
		
		//CSV file reader
		FileReader filereader = new FileReader("E:\\\\selenium work\\\\excel\\\\ADMPsingleuserdatacsv1.csv");
		CSVReader csvReader = new CSVReader(filereader);
		String[] columns = csvReader.readNext();

		HashMap<String, Integer> map = new HashMap<>();
		int index=0;
		for(String columnName : columns)
		{
			map.put(columnName, index++);
		}
		int i=1;
		String[] lineInArray;
		while ((lineInArray = csvReader.readNext()) != null) 
		{
			String fname = lineInArray[map.get("First name")];
		//	String initials=lineInArray[map.get("Initials")];
		//	String lname=lineInArray[map.get("Last name")];
			String namelogon=lineInArray[map.get("Logon name")];
		//	String logon2000=lineInArray[map.get("Logonname prewindow")];
			String namefull=lineInArray[map.get("Full name")];
		//  String disname=lineInArray[map.get("Display name")];
		//	String employee=lineInArray[map.get("Employee ID")];
		//	String description=lineInArray[map.get("Description")];
		//	String office=lineInArray[map.get("Office")];
		//	String phonenum=lineInArray[map.get("Telephone number")];
			String mailaddress=lineInArray[map.get("Email")];
		//	String website=lineInArray[map.get("Webpage")];
		//	String container=lineInArray[map.get("Select container")];
		//	String password=lineInArray[map.get("Password")];
		//	String cpassword=lineInArray[map.get("Confirm password")];
		//	String memberof=lineInArray[map.get("MemberOf")];
		//	String[] array=memberof.split("\\\\");
			
			XSSFRow row2=sheet.getRow(i++);
			int TotalColumnCount=row2.getLastCellNum();
			XSSFCell cellfirstname1=row2.createCell(TotalColumnCount++);
			cellfirstname1.setCellValue(doctext.contains(fname));
			XSSFCell celllogonname1=row2.createCell(TotalColumnCount++);
			celllogonname1.setCellValue(doctext.contains(namelogon+"@admanagerplus.com"));
			XSSFCell cellmail=row2.createCell(TotalColumnCount++);
			cellmail.setCellValue(doctext.contains(mailaddress+"@admanagerplus.com"));
			XSSFCell cellfullname1=row2.createCell(TotalColumnCount++);
			cellfullname1.setCellValue(doctext.contains(namefull));
			System.out.println(doctext.contains(fname));
			
		}
		FileOutputStream fileOutputStream=new FileOutputStream("E:\\selenium work\\New folder\\Output_of_ADMPsingleuser.xlsx");
		workbook.write(fileOutputStream);
		workbook.close();
		inputStream.close();
		fileOutputStream.close();
		System.out.println("Done!");

			
			document.close();
			fileparse.close();
			System.out.println("Done!");

		}

	}
