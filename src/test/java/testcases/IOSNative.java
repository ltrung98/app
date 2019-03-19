package testcases;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;


public class IOSNative {

	/**
	 * @param args
	 */
	
	public static AppiumDriver wd;
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		

		File appDir = new File(System.getProperty("user.dir"), "/apps/");
	    File app = new File(appDir, "UICatalog.app");
	    
	    
	    DesiredCapabilities capabilities = new DesiredCapabilities();
	    capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "");
	    capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1");
	    capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
	    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone Simulator");
	    capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
	    
	    
	    capabilities.setCapability("automationName", "Appium");
	    capabilities.setCapability("udid","c84c5fd8fb6cd5e842473a1888c511b7cf8d9bef");

	    wd = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	    
	    wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]")).click();
		wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[1]")).click();
		wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[2]/UIAStaticText[1]")).click();
		wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[1]")).click();
	    
		//TouchAction action = new TouchAction(wd);
//		wd.swipe(200, 30, 50, 55, 400);
		
	    wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[3]/UIAStaticText[1]")).click();
		wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[4]/UIAStaticText[1]")).click();
		
		Alert alert = wd.switchTo().alert();
		alert.sendKeys("Hi Alert");
		System.out.println(alert.getText());
		
		alert.accept();
		
		
		
	}
	 
}
