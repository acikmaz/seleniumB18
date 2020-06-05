package test.day02_findElement_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P1_EtsyTitleVerification {

    public static void main(String[] args) throws Exception {


        // TC #1: EtsyTitle Verification
        // 1.Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // 2.Go to https://www.etsy.com
        driver.get("https://www.etsy.com");
        // 3.Search for “wooden spoon”
        // driver.findElement(By.id("global-enhancements-search-query")).sendKeys("wooden spoon" + Keys.ENTER);
        driver.findElement(By.id("global-enhancements-search-query")).sendKeys("wooden spoon");
        driver.findElement(By.className("wt-input-btn-group__btn")).click();
        // 4.Verify title: Expected: “Wooden spoon | Etsy”
        String ExpectedTitle= "Wooden spoon | Etsy";
        String actualTitle = driver.getTitle();

        if (actualTitle.equals(ExpectedTitle)){
            System.out.println("PASSED!");
        } else {
            System.out.println("FAILED!!!");
        }


        Thread.sleep(10000);
        driver.quit();
        //
        // TC #2: Zero Bankheader verification
        // 1.Open Chrome browser
        // 2.Go to http://zero.webappsecurity.com/login.html
        // 3.Verify header textExpected: “Log in to ZeroBank”
    }
}
