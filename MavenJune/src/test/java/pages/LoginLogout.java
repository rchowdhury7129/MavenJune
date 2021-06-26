package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import helper.utility;

public class LoginLogout {

	WebDriver driver;
	
	public LoginLogout(WebDriver d){
		this.driver = d;
	}
	
	@FindBy(id = "email") WebElement username;
	@FindBy(id = "passwd") WebElement password;
	@FindBy(xpath = "//a[@class='login']") WebElement signInButton;
	@FindBy(xpath = "//button[@id='SubmitLogin']") WebElement logInButton;
	@FindBy(xpath = "//a[@class='logout']") WebElement logOutButton;
	
	public void ValidateHomePage(){
		utility.validateTitle(driver, "automationpractice");
	}
	
	public void enterUserName(String s){
		System.out.println("Log Info: Username entered");
		utility.waitForWebElement(driver, username).sendKeys(s);
	}
	
	public void enterPassword(String p){
		System.out.println("Log Info: Password entered");
		utility.waitForWebElement(driver, password).sendKeys(p);
	}
	
	public void clickSignInButton(){
		utility.waitForWebElement(driver, signInButton).click();
		System.out.println("Log Info: Clicked on sign in button");
	}
	
	public void clickLogInButton(){
		utility.waitForWebElement(driver, logInButton).click();
		System.out.println("Log Info: Clicked on Login button");
	}
	
	public void clickLogOutButton(){
		utility.waitForWebElement(driver, logOutButton).click();
		System.out.println("Log Info: Clicked on Logout button");
	}
	
}
