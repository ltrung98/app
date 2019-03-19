package testcases;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.MobileCapabilityType;

public class TestWebBrowser {
	public static AndroidDriver driver;
	public WebDriver MobInstance;

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
		driver.get("https://www.lazada.vn");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement topupCenter = driver.findElement(By.cssSelector(".page-card > ul > li:nth-child(3)"));
		topupCenter.click();
		WebElement mobileTopup = driver.findElement(By.xpath("//*[@id=\"J_5527032660\"]/div/ul/li[1]/a"));
		mobileTopup.click();
		WebElement phoneInput = driver.findElement(By.id(WebElementIds.PHONE_FIELD));
		phoneInput.clear();
		phoneInput.sendKeys("0935519517");
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (Exception ex) {
		}
		WebElement operatorButton = driver.findElement(By.id(WebElementIds.OPERATOR_BTN));
		operatorButton.click();

		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (Exception ex) {
		}
		WebElement selectOperator = driver.findElement(By.xpath(WebElementIds.SELECT_OPERATOR));
		selectOperator.click();

		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (Exception ex) {
		}
		WebElement topupNow = driver.findElement(By.id(WebElementIds.TOPUP_NOW));
		topupNow.click();

		WebElement emailAcc = driver.findElement(By.cssSelector(WebElementIds.ACCOUNT_NAME));
		emailAcc.clear();
		emailAcc.sendKeys("testdgvn@gmail.com");

		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (Exception ex) {
		}
		WebElement passWord = driver.findElement(By.cssSelector(WebElementIds.PASSWORD_FIELD));
		passWord.clear();
		passWord.sendKeys("Lazada1234");

		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (Exception ex) {
		}
		WebElement loginBtn = driver.findElement(By.cssSelector(WebElementIds.LOGIN_BTN));
		loginBtn.click();

		WebElement topupNow1 = driver.findElement(By.id(WebElementIds.TOPUP_NOW));
		topupNow1.click();
		System.out.println("Test finished");
//		driver.pressKey(new KeyEvent(AndroidKey.HOME));
//		Thread.sleep(3000);
//		driver.toggleWifi();
//		try {
//			driver.toggleAirplaneMode();
//		} catch (Throwable t) {
//			System.out.println("Airplane mode active");
//		}
//		Thread.sleep(3000);
//		System.out.println("Test Finished");

		driver.quit();

	}

}
