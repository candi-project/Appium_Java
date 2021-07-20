

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.appium.java_client.TouchAction;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;


public class ecommerce_tc_5 extends base{

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		AndroidDriver<AndroidElement> driver = capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElementById("com.androidsample.generalstore:id/spinnerCountry").click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Belgium\"));").click();
 //   driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + containedText + "\").instance(0))"));     
		
		driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Candi");
		driver.hideKeyboard();
		driver.findElementByXPath("//*[@text='Female']").click();
		driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
		
        //System.out.println(driver.findElementsById("com.androidsample.generalstore:id/productName").size());
		driver.findElementsByAndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().textMatches(\"Air Jordan 9 Retro\").instance(0))");
		
		int productNumber = driver.findElementsById("com.androidsample.generalstore:id/productName").size();
		
		for(int i=0;i<productNumber;i++)
		{
			String text = driver.findElementsById("com.androidsample.generalstore:id/productName").get(i).getText();
			
			if (text.equalsIgnoreCase("Converse All Star"))
			{
				driver.findElementsById("com.androidsample.generalstore:id/productAddCart").get(i).click();
				break;
			}
		  	
		}
		
		Thread.sleep(2000);
		driver.findElementsByAndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().textMatches(\"Nike SFB Jungle\").instance(0))");
		int productNumber2 = driver.findElementsById("com.androidsample.generalstore:id/productName").size();
		
		for(int i=0;i<productNumber2;i++)
		{
			String text = driver.findElementsById("com.androidsample.generalstore:id/productName").get(i).getText();
			
			if (text.equalsIgnoreCase("PG 3"))
			{
				driver.findElementsById("com.androidsample.generalstore:id/productAddCart").get(i).click();
				break;
			}
		  	
		}
		
		
		
		
		driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();
		
	    Thread.sleep(4000);
		
	    int count = driver.findElementsById("com.androidsample.generalstore:id/productPrice").size();
	    
	    double sum = 0;
	    
	    for(int j=0;j<count;j++)
	    {
	    	String amount = driver.findElementsById("com.androidsample.generalstore:id/productPrice").get(j).getText(); 
	    	double amountValue = getAmount(amount);
	    	sum =sum+amountValue;
	    }
	    
//		String amount1 = driver.findElementsById("com.androidsample.generalstore:id/productPrice").get(0).getText(); 
//		//$55.0
//		String amount2 = driver.findElementsById("com.androidsample.generalstore:id/productPrice").get(1).getText();
//		//$110.0
		
//		//remove dollar sign
//		amount1 = amount1.substring(1);
//		amount2 = amount2.substring(1);
//		
//		//Convert type to Double 
//		double amount1Value = Double.parseDouble(amount1);
//		double amount2Value = Double.parseDouble(amount2);
		
//		double amount1Value = getAmount(amount1);
//		double amount2Value = getAmount(amount2);
//		
//		double sumofValue = amount1Value + amount2Value ;
		System.out.println("Sum of Value: "+ sum);
		
		
		String totalAmount = driver.findElementById("com.androidsample.generalstore:id/totalAmountLbl").getText();
		//$ 165.0
		
		double totalValue = getAmount(totalAmount);
		System.out.println("total Value: "+ totalValue);
		
		Assert.assertEquals(totalValue, sum);
		
		
		//Mobile Gesture
		TouchAction t = new TouchAction(driver);
		
		WebElement checkbox = driver.findElementByXPath("//*[@text='Send me e-mails on discounts related to selected products in future']");
		WebElement link = driver.findElementById("com.androidsample.generalstore:id/termsButton");
		//tap
		t.tap(tapOptions().withElement(element(checkbox))).perform();
		//long-press
		t.longPress(longPressOptions().withElement(element(link)).withDuration(ofSeconds(2))).release().perform();
		driver.findElementById("android:id/button1").click();
		driver.findElementByClassName("android.widget.Button").click();
		
		Thread.sleep(5000);
		
		Set<String> contextNames = driver.getContextHandles();
		for(String contextName: contextNames)
		{
			System.out.println(contextName);
		}
		
		driver.context("WEBVIEW_com.androidsample.generalstore");
		
		WebElement element = driver.findElementById("L2AGLb");
			JavascriptExecutor je = (JavascriptExecutor) driver;
			je.executeScript("arguments[0].scrollIntoView(true);",element);
		Thread.sleep(3000);

		driver.findElementById("L2AGLb").click();
		driver.findElementByXPath("//*[@id=\"input\"]").sendKeys("XPATH");
		//driver.findElementByName("q").sendKeys("Fun Day!");
		//driver.findElementByName("q").sendKeys(Keys.ENTER);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		driver.context("NATIVE_APP");		
		
		
		
	}
	
	public static double getAmount(String value) {
		
		value = value.substring(1);
		double amountValue = Double.parseDouble(value);
		return amountValue;
				
	}

}
