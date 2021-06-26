package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import helper.utility;

public class Login {

	WebDriver driver;
	
	public Login(WebDriver d){
		this.driver = d;
	}
	
	@FindBy(id = "txtUsername") WebElement username;
	@FindBy(id = "txtPassword") WebElement password;
	@FindBy(xpath = "//input[@value='LOGIN']") WebElement loginButton;
	
	public void ValidateHomePage(){
		utility.validateTitle(driver, "OrangeHRM");
	}
	
	public void enterUserName(String s){
		System.out.println("Log Info: Username entered");
		utility.waitForWebElement(driver, username).sendKeys(s);
	}
	
	public void enterPassword(String p){
		System.out.println("Log Info: Password entered");
		utility.waitForWebElement(driver, password).sendKeys(p);
	}
	
	public void clickLoginButton(){
		utility.waitForWebElement(driver, loginButton).click();
		System.out.println("Log Info: Clicked on Login button");
	}
	
}
