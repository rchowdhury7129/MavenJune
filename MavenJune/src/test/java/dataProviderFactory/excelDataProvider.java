package dataProviderFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelDataProvider {

	//if you are using .xls file, use HSSF
	//if you are using .xlsx file, use XSSF
	
	XSSFWorkbook wb;
	
	public excelDataProvider() throws FileNotFoundException, IOException{
		wb = new XSSFWorkbook(new FileInputStream(new File(System.getProperty("user.dir") + "/testdata/Book1.xlsx")));
	}
	
	public String getCellData(String sheetName, int row, int col){
		XSSFCell cell = wb.getSheet(sheetName).getRow(row).getCell(col);
		String data = null;
		if(cell.getCellType() == CellType.STRING){
			data = cell.getStringCellValue();
		}
		else if (cell.getCellType() == CellType.NUMERIC){
			data = String.valueOf((double)cell.getNumericCellValue());
		}
		else if (cell.getCellType() == CellType.BLANK){
			data = "";
		}
		return data;
	}
	
	public int getRows(String sheetName){
		return wb.getSheet(sheetName).getPhysicalNumberOfRows();
	}
	
	public int getColumns(String sheetName){
		return wb.getSheet(sheetName).getRow(0).getPhysicalNumberOfCells();
	}
	
}
