package test.day03_cssSelector_xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC3_selfPractice {

    public static void main(String[] args) {

    // TC #3: Practice Cybertek/ForgotPassword URL verification
        // 1.Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // 2.Go to http://practice.cybertekschool.com/forgot_password
        driver.get("http://practice.cybertekschool.com/forgot_password");

        // 3.Enter any email into input box
        driver.findElement(By.name("email")).sendKeys("acikmaz19@gmail.com");

        // 4.Click on Retrieve password
        driver.findElement(By.id("form_submit")).click();

        // 5.Verify URL contains: Expected: “email_sent”
        String actualTitle = driver.getCurrentUrl();
        String expectedTitle = "email_sent";
        if (actualTitle.contains(expectedTitle)){
            System.out.println("PASSED!");
        } else {
            System.out.println("FAILED!!!");
        }

        // 6. Verify text box displayed the content as expected.
        // Expected: “Your e-mail’s been sent!”
        String actualText = driver.findElement(By.name("confirmation_message")).getText();
        String expectedText = "Your e-mail's been sent!";
        if (actualText.equals(expectedText)){
            System.out.println("PASSED!");
        } else {
            System.out.println("FAILED!!!");
        }

        // Hint: You need to use getText method for this practice.

    }
}
