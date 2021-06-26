package dataProviderFactory;

import java.io.FileNotFoundException;
import java.io.IOException;

public class DataProviderFactory {
	
	public static configDataProvider getConfig() throws FileNotFoundException, IOException{
		configDataProvider config = new configDataProvider();
		return config;
	}
	
	public static excelDataProvider getExcel() throws FileNotFoundException, IOException{
		excelDataProvider excel = new excelDataProvider();
		return excel;
	}

}
