package testcases;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class LazadaTopup {
    public static AndroidDriver<WebElement> driver;
    public static AppiumDriver<WebElement> _driver;
    public static DesiredCapabilities cap = new DesiredCapabilities();


    @BeforeTest
    public void startAppium() throws MalformedURLException, InterruptedException {
        String ANDROID_APP_PACKAGE = "com.lazada.android";
        String ANDROID_DEVICE_SOCKET = ANDROID_APP_PACKAGE + "_devtools_remote";
        System.out.println("setUP() :: driver.AndroidDriver() executed");
        System.setProperty("webdriver.chrome.driver", "/Users/user/Downloads/chromedriver");
        File app = new File("/Users/user/eclipse-workspace/AppiumTesting/app/lazada_online_shopping.apk");
        cap.setCapability("androidDeviceSocket", ANDROID_DEVICE_SOCKET);
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
        cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, ANDROID_APP_PACKAGE);
        cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.lazada.activities.EnterActivity");
        cap.setCapability("chromedriverExecutable", "/Users/user/Downloads/chromedriver");
        cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());

        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), cap);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void OpenApp() throws InterruptedException {

        WebElement intro_skip_btn = driver.findElement(By.id("intro_skip_btn"));
        intro_skip_btn.click();


        List<WebElement> dgPage = driver.findElementsById("lazada_content");
        for (int index = 0; index < dgPage.size(); index++) {
            System.out.println("index" + index);
        }

        WebElement laz_hpc_channel_top_text = driver.findElement(By.id("laz_hp_channels_recycle"));
        List<WebElement> digitalGoods = laz_hpc_channel_top_text.findElements(By.id("laz_hpc_channel_top_text"));
        digitalGoods.get(2).click();

        By webView = By.id("lazada_content");
        By title = By.id("lazada_windvane_webview");
        WebDriverWait wait = new WebDriverWait(driver,300);
        driver.findElement(title).getText();
        Set<String> availableContexts1 = driver.getContextHandles();
        System.out.println("Total No of Context Found Before reaching WebView = "+ availableContexts1.size());
        System.out.println("Context Name is "+ availableContexts1);

        wait.until(ExpectedConditions.visibilityOfElementLocated(webView));
        Set<String> availableContexts = driver.getContextHandles();
        System.out.println("Total No of Context Found After we reach to WebView = "+ availableContexts.size());
        for(String context : availableContexts) {
            if (context.contains("WEBVIEW")) {
                System.out.println("Context Name is " + context);
                driver.context(context);
                break;
            }
        }
        Thread.sleep(30000);
        WebElement phoneTopup1 = driver.findElement(By.cssSelector(".lzd-act-icon-navigation > ul > li"));
        phoneTopup1.click();


    }

    @AfterTest(alwaysRun = true)
    public void tearDown() {
        driver.quit();
        System.out.println("tearDown() :: driver.quit() executed");
    }
} // end of class
