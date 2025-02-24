public class Stockinfo {


import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

    public class StockInfo extends FunctionLibrary {
        public static void main(String[] args) {
            FunctionLibrary.setUpWebDriver();
            FunctionLibrary.identifyElement();
            FunctionLibrary.clickElement();
            driver.quit();
        }
    }
}
