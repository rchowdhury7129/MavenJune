package testcases;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import dataProviderFactory.DataProviderFactory;
import helper.BaseClass;
import pages.Login;
import pages.Logout;


public class LoginTest extends BaseClass {
	
	Login login;
	
	Logout lout;
	
  @Test(description = "Log in to OrangeHRM", priority=0)
  public void loginHRM() {
	  
	  login = PageFactory.initElements(driver, Login.class);
	  
	  lout = PageFactory.initElements(driver, Logout.class);
	  
	  logger = report.createTest("Login Test for OrangeHRM");
	  
	  login.ValidateHomePage();
	  
	  logger.pass("Home Page Validation");
	  
	  login.enterUserName("Admin");
	  
	  logger.info("Username entered");
	  
	  login.enterPassword("admin123");
	  
	  logger.info("Password Entered");
	  
	  login.clickLoginButton();
	  
	  logger.info("Clicked on Login button");
	  
	  lout.clickLogout();
	  
	  logger.info("Clicked on the Logout button");  
	  
  }
  
  @Test(dataProvider = "Sheet1", description = "Log into OrangeHRM using Excel", priority = 1)
  public void LoginHRMExcel(String uname, String pass){
	  
	  login = PageFactory.initElements(driver, Login.class);
	  
	  lout = PageFactory.initElements(driver, Logout.class);
	  
	  logger = report.createTest("Login Test for OrangeHRM");
	  
	  login.ValidateHomePage();
	  
	  logger.pass("Home Page Validation");
	  
	  login.enterUserName(uname);
	  
	  logger.info("Username entered");
	  
	  login.enterPassword(pass);
	  
	  logger.info("Password Entered");
	  
	  login.clickLoginButton();
	  
	  logger.info("Clicked on Login button");
	  
	  lout.clickLogout();
	  
	  logger.info("Clicked on the Logout button");  
	  
  }
  
  @DataProvider(name = "Sheet1")
  public Object[][] getDataFormSource() throws FileNotFoundException, IOException{
	  System.out.println("Log Info: Running Data Provider first to generate data");
	  
	  int rows = DataProviderFactory.getExcel().getRows("Sheet1");
	  int columns = DataProviderFactory.getExcel().getColumns("Sheet1");
	  
	  System.out.println("Total number of rows: " + rows);
	  System.out.println("Total number of rows: " + columns);
	  
	  Object[][] arr = new Object[rows-1][columns];
	  
	  for(int i=0; i<rows-1; i++){
		  for(int j=0; j<columns; j++){
			  arr[i][j] = DataProviderFactory.getExcel().getCellData("Sheet1", i+1,j);
		  }
	  }
	  
	  System.out.println("Log Info: Data Provider is ready to use");
	  return arr;
  }
  
}
