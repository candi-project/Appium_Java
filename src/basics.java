import java.net.MalformedURLException;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class basics extends HybridBase{

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		AndroidDriver<AndroidElement> driver = capabilities("real");
		
		/*
		 * xpath syntax:   //Tagname[@attribute='value']
		 */
		
		driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
		driver.findElementById("android:id/checkbox").click();
		driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
		driver.findElementById("android:id/edit").sendKeys("Hello World!");
		driver.findElementsByClassName("android.widget.Button").get(1).click();
		
		//AndroidUIAutomator syntax:  driver.findElementByAndroidUIAutomator("attribute(\"value\")")
		
		//driver.findElementByAndroidUIAutomator("text(\"Views\")").click();;

	}

}
