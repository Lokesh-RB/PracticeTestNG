package TestNGPayC;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Write_Excel_Data_Dynamic_Data {

	public static void main(String[] args) throws IOException 
	{
     FileOutputStream file=new FileOutputStream(System.getProperty("user.dir")+"\\Testdata\\New_Another_file.xlsx");
     XSSFWorkbook workbook= new XSSFWorkbook();
     XSSFSheet sheet=workbook.createSheet("Dynamic");
     
     Scanner sc=new Scanner(System.in);
     System.out.println("Enter no. of Rows=");
     int noOfRows=sc.nextInt();
     System.out.println("Enter no.of columns=");
	int noOfCells=sc.nextInt();
	
	
	
	for(int r=0;r<=noOfRows;r++)
	{	
		XSSFRow rows=sheet.createRow(r);
		
		for(int c=0;c<noOfCells; c++)
		{
			XSSFCell cell=rows.createCell(c);
			cell.setCellValue(sc.next());
		}
	}
	workbook.write(file);
	workbook.close();
	file.close();
	System.out.println("The program is done");
	
	//jhjhjh
	
	}
}
