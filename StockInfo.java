
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Sample {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(40))
                .pollingEvery(Duration.ofSeconds(3))
                .ignoring(TimeoutException.class);

        try {
            driver.get("https://finance.yahoo.com");

            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            //String titleWebPage = driver.getTitle();

            //System.out.println(titleWebPage);
            driver.manage().window().maximize();
            WebElement searchTextBox = driver.findElement(By.xpath("//input[@id='ybar-sbq']"));
            searchTextBox.click();
            searchTextBox.sendKeys("TSLA");
            //assertion needs to be added that the data shows Tesla
            WebElement searchResultBox=driver.findElement(By.xpath("//div[@class='modules-module_quoteSymbol__BGsyF'][normalize-space()='TSLA']"));
            searchResultBox.click();

            WebElement closingStockPrice=driver.findElement(By.xpath("//span[contains(@class,'yf-ipw1h0') and @data-testid='qsp-price']"));
            float closingPrice=Float.parseFloat(closingStockPrice.getText());

            if (closingPrice > 200) {


                WebElement element = driver.findElement(By.xpath("//span[@title='Previous Close']/..//fin-streamer"));
                System.out.println("Previous Close " + element.getText());

                element = driver.findElement(By.xpath("//span[@title='Open']/..//fin-streamer"));
                System.out.println("Open " + element.getText());

                element = driver.findElement(By.xpath("//span[@title='Bid']/../span[@class='value yf-gn3zu3']"));
                System.out.println("Bid  " + element.getText());

                element = driver.findElement(By.xpath("//span[@title='Ask']/../span[@class='value yf-gn3zu3']"));
                System.out.println("Ask  " + element.getText());

                element = driver.findElement(By.xpath("//span[contains(text(),'Day')]/../span[@class='value yf-gn3zu3']"));
                System.out.println("Day s Range  " + element.getText());

                element = driver.findElement(By.xpath("//span[contains(text(),'52 Week')]/../span[@class='value yf-gn3zu3']"));
                System.out.println("Day s Range  " + element.getText());

                element = driver.findElement(By.xpath("//span[contains(text(),'Volume')]/../span[@class='value yf-gn3zu3']//fin-streamer[@data-field='regularMarketVolume']"));
                System.out.println("Volume  " + element.getText());

                element = driver.findElement(By.xpath("//span[contains(text(),'Avg. Volume')]/../span[@class='value yf-gn3zu3']"));
                System.out.println("Average Volume  " + element.getText());

                element = driver.findElement(By.xpath("//span[contains(text(),'Market Cap')]/../span[@class='value yf-gn3zu3']"));
                System.out.println("Market Cap  " + element.getText());

                element = driver.findElement(By.xpath("//span[contains(text(),'Beta')]/../span[@class='value yf-gn3zu3']"));
                System.out.println("Beta (5Y Monthly) " + element.getText());

                element = driver.findElement(By.xpath("//span[contains(text(),'PE')]/../span[@class='value yf-gn3zu3']"));
                System.out.println("PE Ratio (TTM) " + element.getText());

                element = driver.findElement(By.xpath("//span[contains(text(),'EPS')]/../span[@class='value yf-gn3zu3']"));
                System.out.println("EPS (TTM) " + element.getText());

                element = driver.findElement(By.xpath("//span[contains(text(),'Earnings Date')]/../span[@class='value yf-gn3zu3']"));
                System.out.println("Earnings Date " + element.getText());

                element = driver.findElement(By.xpath("//span[contains(text(),'Forward')]/../span[@class='value yf-gn3zu3']"));
                System.out.println("Forward Dividend & Yield " + element.getText());

                element = driver.findElement(By.xpath("//span[contains(text(),'Ex')]/../span[@class='value yf-gn3zu3']"));
                System.out.println("Ex-Dividend Date " + element.getText());

                element = driver.findElement(By.xpath("//span[contains(text(),'1y Target')]/../span[@class='value yf-gn3zu3']"));
                System.out.println("1y Target Est " + element.getText());

            } else {
                System.out.println("The stock price is less than 200 USD");
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        finally {
            driver.quit();
        }

    }


}
