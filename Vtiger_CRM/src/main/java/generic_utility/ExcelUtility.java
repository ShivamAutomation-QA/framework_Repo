package generic_utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	
	FileInputStream fis;
	FileOutputStream fos;
	public String readDataFromExcel(String sheetName,int rowNum,int cellNum) throws Exception
	{
		fis = new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		return wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).toString();
	}
	
	public void writeDataInExistingCell(String sheetName,int rowNum,int cellNum,String value) throws Exception
	{
		fis = new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).setCellValue(value);
		fos = new FileOutputStream("./src/test/resources/TestData.xlsx");
		wb.write(fos);
		wb.close();
	}
	public void writeDataInNewCell(String sheetName,int rowNum,int cellNum,String value) throws Exception
	{
		fis = new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheetName).getRow(rowNum).createCell(cellNum).setCellValue(value);
		fos = new FileOutputStream("./src/test/resources/TestData.xlsx");
		wb.write(fos);
		wb.close();
	}

}
