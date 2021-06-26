package helper;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.io.FileHandler;

public class utility {
	
	public static WebElement waitForWebElement(WebDriver driver, WebElement element){
		WebDriverWait wait = new WebDriverWait((WebDriver) driver, 10);
		
		wait.until(ExpectedConditions.visibilityOf(element)); //wait until element is visible
		wait.until(ExpectedConditions.elementToBeClickable(element)); //wait until the element is clickable 
		
		return element;
	}
	
	public static void validateMessage(WebElement element, String msg){
		Assert.assertEquals(element.getText(), msg);
	}
	
	//wait 10 seconds, then validate the driver has correct website  title
	public static void validateTitle(WebDriver driver, String title){
		boolean status = new WebDriverWait(driver, 10).until(ExpectedConditions.titleContains(title));
		Assert.assertTrue(status);
	}
	
	//wait 10 seconds for the alert to pop-up and if its present, accept the alert
	public static void acceptAlert(WebDriver driver){
		new WebDriverWait(driver, 10).until(ExpectedConditions.alertIsPresent()).accept();
	}
	
	//wait 10 seconds for the alert to pop-up and if its present, dismiss the alert
	public static void dismissAlert(WebDriver driver){
		new WebDriverWait(driver, 10).until(ExpectedConditions.alertIsPresent()).dismiss();
	}	
	
	public static String captureScreenshot(WebDriver driver){
		String time = getTime();
		String destination = System.getProperty("user.dir") + "/screenshots/MVN" + time + ".png";
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try{
			FileHandler.copy(src, new File(destination));
		}catch(IOException e){
			System.out.println("Screenshot Failed: " + e.getMessage());
		}
		return destination;
	}
	
	public static String getTime(){
		DateFormat dateFormat = new SimpleDateFormat("HH_mm_ss_dd_MM_yyyy");
		return dateFormat.format(new Date());
	}
	

}
