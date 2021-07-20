

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ecommerce_tc_2 extends base{

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
		driver.findElementsByAndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().textMatches(\"Converse All Star\").instance(0))");
		
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
		driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();
		Thread.sleep(2000);
		String lastPageText = driver.findElementById("com.androidsample.generalstore:id/productName").getText();
		
	    Assert.assertEquals(lastPageText, "Converse All Star");
		
		

	}

}
