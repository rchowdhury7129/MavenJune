package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import helper.utility;

public class Purchase {
	
	WebDriver driver;
	
	public Purchase(WebDriver d){
		this.driver = d;
	}
	
	@FindBy(xpath = "//a[@class='sf-with-ul']") WebElement womenTab;
	@FindBy(xpath = "//a[@title='Casual Dresses']") WebElement casualDressesTab;
	@FindBy(xpath = "//a[@title='Add to cart']") WebElement addToCartButton;
	@FindBy(xpath = "//a[@class='btn btn-default button button-medium']") WebElement checkoutButton;
	@FindBy(xpath = "//a[@class='button btn btn-default standard-checkout button-medium']") WebElement checkoutButton2;
	@FindBy(xpath = "//button[@name='processAddress']") WebElement checkoutButton3;
	@FindBy(xpath = "//button[@name='processCarrier']") WebElement checkoutButton4;
	@FindBy(xpath = "//div[@id='uniform-cgv']") WebElement termsOfService;
	@FindBy(xpath = "//a[@class='bankwire']") WebElement payByBankWire;
	@FindBy(xpath = "//button[@class='button btn btn-default button-medium']") WebElement orderConfirm;
	
	public void clickWomenTab(){
		Actions action = new Actions(driver);
		action.moveToElement(womenTab).build().perform();
		utility.waitForWebElement(driver, casualDressesTab).click();
		System.out.println("Log Info: Clicked on Casual Dress Tab");
	}
	
	public void clickAddToCartButton(){
		utility.waitForWebElement(driver, addToCartButton).click();
		System.out.println("Log Info: Clicked on add to cart button");
	}
	
	public void clickCheckoutButton(){
		utility.waitForWebElement(driver, checkoutButton).click();
		System.out.println("Log Info: Clicked on checkout button");
	}
	
	public void clickCheckoutButton2(){
		utility.waitForWebElement(driver, checkoutButton2).click();
		System.out.println("Log Info: Clicked on checkout button");
	}
	
	public void clickCheckoutButton3(){
		utility.waitForWebElement(driver, checkoutButton3).click();
		System.out.println("Log Info: Click on checkout button");
	}
	
	public void clickTermsOfService(){
		utility.waitForWebElement(driver, termsOfService).click();
		System.out.println("Log Info: Click on checkout button");
	}
	
	public void clickCheckoutButton4(){
		utility.waitForWebElement(driver, checkoutButton4).click();
		System.out.println("Log Info: Click on checkout button");
	}
	
	public void clickPayByBankWire(){
		utility.waitForWebElement(driver, payByBankWire).click();
		System.out.println("Log Info: Clicked on pay by bank wire");
	}
	
	public void clickOrderConfirm(){
		utility.waitForWebElement(driver, orderConfirm).click();
		System.out.println("Log Info: Clicked I confirm my order");
	}
	
}
