package test.day03_cssSelector_xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P5_BasicAuthenticationZeroBank {
    public static void main(String[] args) {

        // TC #5: Basic authentication Zero Bank
        // 1.Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        // 2.Go to http://zero.webappsecurity.com/login.html
        driver.get("http://zero.webappsecurity.com/login.html");

        // 3.Enter username: username
        driver.findElement(By.id("user_login")).sendKeys("username");

        // 4.Enter password: password
        driver.findElement(By.id("user_password")).sendKeys("password");

        // 5.Click sign in button
        driver.findElement(By.name("submit")).click();
        // 6.Verify username is displayed on the page
        String actualUserName = driver.findElement(By.className("container")).getText();
        String expectedUserName="username";
        if (actualUserName.contains(expectedUserName)){
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
        // 7.Verify the title Zero –Account Summary
        String actualTitle =driver.getTitle();
        String expectedTitle = "Zero - Account Summary";
        if (actualTitle.contains(expectedTitle)){
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
        // 8.Verify the link Account Summary’s href value contains: “account-summary”
        String actualLink = driver.findElement(By.linkText("Account Summary")).getAttribute("href");
        String expectedLink = "account-summary";
        if (actualLink.contains(expectedLink)){
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
        // Print out results in validation formats

    }
}
