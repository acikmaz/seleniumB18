package test.day03_cssSelector_xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class P4_ZeroBankURLVerification {
    public static void main(String[] args) throws Exception{

        // TC #4: Zero Bank URL verification
        // 1.Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // 2.Go to http://zero.webappsecurity.com/login.html
        driver.get("http://zero.webappsecurity.com/login.html");

        // 3.Get attribute value of href from the “forgot your password”link
        //String actual = driver.findElement(By.linkText("Forgot your password ?")).getAttribute("href");
        WebElement forgotPasswordLink = driver.findElement(By.partialLinkText("Forgot"));
        //WebElement forgotPasswordLink = driver.findElement(By.partialLinkText("Forgot"));
        //WebElement forgotPasswordLink = driver.findElement(By.partialLinkText("your"));
        //WebElement forgotPasswordLink = driver.findElement(By.partialLinkText("password"));
        //WebElement forgotPasswordLink = driver.findElement(By.partialLinkText("?"));

        // 4.Verify attribute value containsExpected: “/forgot-password.html”
        String actualHrefValue = forgotPasswordLink.getAttribute("href");
        String expectedHrefValue = "/forgot-password.html";

        System.out.println("actualHrefValue = " + actualHrefValue);

        if (actualHrefValue.contains(expectedHrefValue)){
            System.out.println("Href value verification PASSED!");
        } else {
            System.out.println("Href value verification FAILED");
        }

        System.out.println("Is forgot password displayed? " + forgotPasswordLink.isDisplayed());

        //Hint: Locate the “Forgot your password ?” link,
        // and use getAttribute value method to get the link behind the attribute within.
    }
}
