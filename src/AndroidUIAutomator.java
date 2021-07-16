import java.net.MalformedURLException;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class AndroidUIAutomator extends base{

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		
		AndroidDriver<AndroidElement> driver = capabilities();
		
		//AndroidUIAutomator syntax:  driver.findElementByAndroidUIAutomator("attribute(\"value\")")
		
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
			
		//AndroidUIAutomator syntax:  driver.findElementByAndroidUIAutomator("new UiSelector().property(value)")
			
		System.out.println(driver.findElementsByAndroidUIAutomator("new UiSelector().clickable(false)").size());
			

	}

}
