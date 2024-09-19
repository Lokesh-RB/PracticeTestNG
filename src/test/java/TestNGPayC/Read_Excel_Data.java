package TestNGPayC;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Read_Excel_Data {

	public static void main(String[] args) throws IOException
	{
	FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\Testdata\\Calls.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		XSSFSheet sheet=workbook.getSheet("calls");
		
		int totalrows=sheet.getLastRowNum();
		int totalcells=sheet.getRow(0).getLastCellNum();
		System.out.println("No.of Rows= "+totalrows );
		System.out.println("No.of Cells= "+totalcells );
		
		for(int r=0;r<=totalrows;r++) 
		{
			XSSFRow rows=sheet.getRow(r);
			for(int c=0; c<totalcells; c++)
			{
			XSSFCell cell=rows.getCell(c);
			System.out.print(cell.toString()+"\t");
				
			}
			System.out.println();
		}

		workbook.close();
		file.close();
		
}
}