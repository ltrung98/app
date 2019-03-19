package testcases;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForElementPresent {
    public static AndroidDriver driver;
    public static void waitForElementPresent(final By by, int timeOutInSeconds){

        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);

        Boolean until = wait.until(new ExpectedCondition<Boolean>() {

            @Override
            public Boolean apply(WebDriver d) {
                return d.findElement(by).isDisplayed();
            }

        });

    }

    public static void waitForElementPresent(By cssSelector) {

    }
}
