package testcases;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import dataProviderFactory.DataProviderFactory;
import helper.BaseClass;
import pages.Login;
import pages.UserManagement;

public class UserManagementTest extends BaseClass {
	
	Login login;
	UserManagement user;
	
	@Test (dataProvider = "Sheet2", description = "Testing the Add User Button", priority=0)
	public void UMTest(String role, String name, String username, String status, String pass){
		  
		login = PageFactory.initElements(driver, Login.class);
		user = PageFactory.initElements(driver, UserManagement.class);
		
		logger = report.createTest("User Management Test");
		
		login.enterUserName("admin");
		logger.info("User entered username");
		
		login.enterPassword("admin123");
		logger.info("User entered password");
		
		login.clickLoginButton();
		logger.info("User clicked Login button");
		
		user.ValidatePage();
		logger.pass("Validated site");
		
		user.clickUserTab();
		logger.info("User hovered and clicked User tab");
		
		user.clickAddButton();
		logger.info("user clicked Add button");
		
		user.selectRole(role);
		logger.info("User selected a role");
		
		user.enterEmpName(name);
		logger.info("User entered employee name");
		
		user.enterUsername(username);
		logger.info("User entered username");
		
		user.selectStatus(status);
		logger.info("User selected the status");
		
		user.enterPassword(pass);
		logger.info("User entered the password");
		
		user.clickSave();
		logger.info("User clicked save");
	}
	
	 @DataProvider(name = "Sheet2")
	  public Object[][] getDataFormSource() throws FileNotFoundException, IOException{
		  System.out.println("Log Info: Running Data Provider first to generate data");
		  
		  int rows = DataProviderFactory.getExcel().getRows("Sheet2");
		  int columns = DataProviderFactory.getExcel().getColumns("Sheet2");
		  
		  System.out.println("Total number of rows: " + rows);
		  System.out.println("Total number of rows: " + columns);
		  
		  Object[][] arr = new Object[rows-1][columns];
		  
		  for(int i=0; i<rows-1; i++){
			  for(int j=0; j<columns; j++){
				  arr[i][j] = DataProviderFactory.getExcel().getCellData("Sheet2", i+1,j);
			  }
		  }
		  
		  System.out.println("Log Info: Data Provider is ready to use");
		  return arr;
	  }
	
}
