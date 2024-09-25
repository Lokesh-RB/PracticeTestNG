package TestNGPayC;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Write_Excel_Data {

	public static void main(String[] args) throws IOException
	{
      FileOutputStream file=new FileOutputStream(System.getProperty("user.dir")+"\\Testdata\\Myfile.xlsx");  
      XSSFWorkbook workbook =new XSSFWorkbook();
      
      XSSFSheet sheet=workbook.createSheet("XL");
      XSSFRow row=sheet.createRow(0);
      row.createCell(0).setCellValue("Charan");
      row.createCell(1).setCellValue("Sr.Tester");
      row.createCell(2).setCellValue("6.5");
      
      XSSFRow row1=sheet.createRow(1);
      row1.createCell(0).setCellValue("Lokesh");
      row1.createCell(1).setCellValue("Jr.Tester");
      row1.createCell(2).setCellValue("4.5");
      
      XSSFRow row2=sheet.createRow(2);
      row2.createCell(0).setCellValue("Jagan");
      row2.createCell(1).setCellValue("Fresher Tester");
      row2.createCell(2).setCellValue("3.65");
      
      workbook.write(file);
      workbook.close();
      file.close();
      
      //yutyu ty
	}

}
