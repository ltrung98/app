package testcases;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.aspectj.lang.annotation.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class AndroidNativeApp {
    public static AppiumDriver driver;

    public static void main (String[] args) throws MalformedURLException, InterruptedException {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        String ANDROID_APP_PACKAGE = "com.lazada.android";
        String ANDROID_DEVICE_SOCKET = ANDROID_APP_PACKAGE + "_devtools_remote";
        System.setProperty("webdriver.chrome.driver", "/Users/user/Downloads/chromedriver");
        File app = new File("/Users/user/eclipse-workspace/AppiumTesting/app/lazada_online_shopping.apk");
        capabilities.setCapability("androidDeviceSocket", ANDROID_DEVICE_SOCKET);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, ANDROID_APP_PACKAGE);
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.lazada.activities.EnterActivity");
        capabilities.setCapability("chromedriverExecutable", "/Users/user/Downloads/chromedriver");
        capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());

        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement intro_skip_btn = driver.findElement(By.id("intro_skip_btn"));
        intro_skip_btn.click();

        // get Voucher topup link
        WebElement laz_hpc_channel_top_text = driver.findElement(By.id("laz_hp_channels_recycle"));
        List<WebElement> digitalGoods = laz_hpc_channel_top_text.findElements(By.id("laz_hpc_channel_top_text"));
        digitalGoods.get(2).click();

//        List<WebElement> dgPage = driver.findElementsById("lazada_content");
//        for (int index=0; index<dgPage.size(); index++) {
//            System.out.println("index" + index);
//        }
        Thread.sleep(30000);
        Set<String> contextNames = driver.getContextHandles();
        for (String contextName : contextNames) {
            System.out.println(contextName);
            if (contextName.contains("WEBVIEW")) {
                driver.context(contextName);
            }
        }
        WebElement phoneTopup = driver.findElement(By.xpath("//div[@id='J_5527032660']/div/ul/li/a/img"));
//        List<WebElement> phoneTopup = driver.findElementById("lazada_windvane_webview").findElement(By.xpath("//div[@id='J_5527032660']/div/ul/li/a/img"));
        phoneTopup.click();



    }

}