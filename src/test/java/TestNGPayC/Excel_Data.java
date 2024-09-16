package TestNGPayC;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Data {

	public static void main(String[] args) throws IOException
	{
       // FileInputStream file= new FileInputStream(System.getProperty("user.dir")+"\\Testdata\\Export_EXPO01061.xlsx");
		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\Testdata\\Checklist for Diam Wallet .xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		
		XSSFSheet sheet=workbook.getSheet("contacts");
		int totalRows=sheet.getLastRowNum();
		int totalCells=sheet.getRow(1).getLastCellNum();
		System.err.println("number of rows"+ totalRows);
		System.err.println("number of cells"+ totalCells);
		
		
		
	}

}
