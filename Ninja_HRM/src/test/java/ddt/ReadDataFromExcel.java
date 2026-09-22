package ddt;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {

		FileInputStream fis = new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		
		Sheet sh = wb.getSheet("Project");
		
		System.out.println("getLastRowNum value"+sh.getLastRowNum());
		System.out.println("getPhysicalNumberOfRows value"+sh.getPhysicalNumberOfRows());
		
		Row row = sh.getRow(0);
		
		System.out.println("getLastRowNum value"+row.getLastCellNum());
		System.out.println("getPhysicalNumberOfCells value"+row.getPhysicalNumberOfCells());
		
		Cell cell = row.getCell(2);
		System.out.println("Value: "+cell.toString());
		
		
	}

}
