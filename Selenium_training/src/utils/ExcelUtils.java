package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtils {

	private static Workbook wb= null;;
	private static Sheet sh = null;;
	private static Row row = null;
	private static Cell cell = null;
	private static File file = null;
	private static FileInputStream fis = null;
	
	public static Workbook getWorkBook()
	{
		try
		{
			file = new File(FileReaderUtils.getPropertyValue("datafile"));
			fis = new FileInputStream(file);
			wb = WorkbookFactory.create(fis);
		}
		catch(Exception ex )
		{
			System.out.println("Exception while reading excel file!!!");
		}
		return wb;
		
	}
	
	public static Sheet getMySheet(String sheetName)
	{
		wb = getWorkBook();
		sh = wb.getSheet(sheetName);
		return sh;
	}
	
	public static int getRowCount(String sheetName)
	{
		sh = getMySheet(sheetName);
		return sh.getLastRowNum()+1;
	}
	
	public static String getCellData(String sheetName, int rowNum , int columnNum)
	{
		String cellValue = null;
		sh = getMySheet(sheetName);
		row = sh.getRow(rowNum);
		cell = row.getCell(columnNum);
		cellValue = cell.getStringCellValue();
		
		return cellValue;
		
	}

public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		File file = new File("data//actitime-testdata.xls");
		
		FileInputStream fis = new FileInputStream(file);
		
		Workbook wb = WorkbookFactory.create(fis);
		
		int sheetCount =  wb.getNumberOfSheets();
		
		System.out.println("Total number of sheets " +sheetCount);
		
		for (int i = 0; i < sheetCount; i++)
		{
			System.out.println("Sheet at index " + i + " is " + wb.getSheetName(i));
		}
		
		Sheet sh = wb.getSheet("customerdata");
		
		System.out.println("Row Count " + (sh.getLastRowNum()+1));
		Row row ;
		Cell cell1, cell2;
		for (int i = 0; i < sh.getLastRowNum()+1; i++) 
		{
			row = sh.getRow(i);
			cell1 = row.getCell(0);
			cell2 = row.getCell(1);
			System.out.println(" | " + cell1 + " | " + cell2 + " | ");
		}	
		wb.close();
		fis.close();
}
}
