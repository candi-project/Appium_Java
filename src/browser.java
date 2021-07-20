import java.net.MalformedURLException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class browser extends baseChrome{

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
   
		AndroidDriver<AndroidElement> driver = capabilities();	
		driver.get("https://courses.rahulshettyacademy.com/");
		driver.findElementByCssSelector("body > header > div.header-upper > div > div > div.nav-outer.clearfix > nav > div.navbar-header > button").click();
		Thread.sleep(2000);
		driver.findElementByLinkText("Courses").click();
		
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
		Thread.sleep(1000);
		String courseTitle = driver.findElementByXPath("//div[@title='Robotic Process Automation(RPA) using UIPATH + Live Projects']").getText();
		Assert.assertEquals(courseTitle, "Robotic Process Automation(RPA) using UIPATH + Live Projects");
		
		
		
		
		
		
	}

}
