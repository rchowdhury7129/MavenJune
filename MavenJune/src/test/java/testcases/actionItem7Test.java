package testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import helper.BaseClass;
import pages.LoginLogout;
import pages.Purchase;

public class actionItem7Test extends BaseClass {

	LoginLogout login;
	Purchase user;
	
	@Test (description = "Testing the Add User Button", priority=0)
	public void actionItemTest() throws InterruptedException{
		  
		login = PageFactory.initElements(driver, LoginLogout.class);
		user = PageFactory.initElements(driver, Purchase.class);
		
		logger = report.createTest("ActionItem 7 Test");
		
		login.clickSignInButton();
		logger.info("User clicked the sign in button");
		
		login.enterUserName("rchowdhury7129@gmail.com");
		logger.info("User entered username");
		
		login.enterPassword("admin123");
		logger.info("User entered password");
		
		login.clickLogInButton();
		logger.info("User clicked Login button");
		
		user.clickWomenTab();
		logger.info("User clicked on womens clothes category");
		
		user.clickAddToCartButton();
		logger.info("user clicked add to cart button");
		
		user.clickCheckoutButton();
		logger.info("user clicked proceed to checkout button");
		
		user.clickCheckoutButton2();
		logger.info("user clicked proceed to checkout button");
		
		user.clickCheckoutButton3();
		logger.info("user clicked proceed to checkout button");
		
		user.clickTermsOfService();
		logger.info("user clikced check on terms of service box");
		
		user.clickCheckoutButton4();
		logger.info("user clicked proceed to checkout button");
		
		user.clickPayByBankWire();
		logger.info("user clicked pay by bank wire");
		
		user.clickOrderConfirm();
		logger.info("user clicked confirm my order");
		
		login.clickLogOutButton();
		logger.info("user clicked logout button");
	}
}
