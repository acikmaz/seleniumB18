package test.day03_cssSelector_xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC4_selfPractice {
    public static void main(String[] args) throws Exception{

        // TC #4: Zero Bank URL verification
        // 1.Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // 2.Go to http://zero.webappsecurity.com/login.html
        driver.get("http://zero.webappsecurity.com/login.html");

        // 3.Get attribute value of href from the “forgot your password”link
        String actual = driver.findElement(By.linkText("Forgot your password ?")).getAttribute("href");

        // 4.Verify attribute value containsExpected: “/forgot-password.html”
        String expected = "/forgot-password.html";
        if (actual.equals(expected)){
            System.out.println("PASSED!");
        } else {
            System.out.println("FAILED");
        }

    //Hint: Locate the “Forgot your password ?” link,
    // and use getAttribute value method to get the link behind the attribute within.
    }
}
