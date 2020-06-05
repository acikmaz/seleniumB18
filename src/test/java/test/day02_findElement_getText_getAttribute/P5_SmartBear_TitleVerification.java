package test.day02_findElement_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P5_SmartBear_TitleVerification {
    public static void main(String[] args) throws Exception {

        // TC#5:	Basic	login	authentication
        // 1-Open	a	chrome	browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // 2-Go	to:
            // http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        // 3-Verify	title	equals:Expected:	Web	Orders	Login
        String actualTitle = driver.getTitle();
        String expectedTitle = "Web Orders Login";

        if (actualTitle.equals(expectedTitle)){
            System.out.println("SmartBear Homepage title verification PASSED!");
        } else {
            System.out.println("SmartBear Homepage title verification FAILED!!!");
        }

        // 4-Enter	username:	Tester
        driver.findElement(By.name("ctl00$MainContent$username")).sendKeys("Tester");
        // 5-Enter	password:	test
        driver.findElement(By.name("ctl00$MainContent$password")).sendKeys("test");
        // 6-Click	“Sign	In”	button
        driver.findElement(By.name("ctl00$MainContent$login_button")).click();
        // 7-Verify	title equals:Expected:	Web	Orders
        String actualTitle2 = driver.getTitle();
        String expectedTitle2 = "Web Orders";
//        if(driver.getTitle().equals("Web Orders")){} //gives the same result as below
        if (actualTitle2.equals(expectedTitle2)){
            System.out.println("SmartBear web orders page title verification PASSED!");
        } else {
            System.out.println("SmartBear web orders page title verification FAILED!!!");
        }



        Thread.sleep(15000);
        driver.quit();

    }
}
