package test.day01_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {

    public static void main(String[] args) throws InterruptedException {
        // 1- set up the web driver
        WebDriverManager.chromedriver().setup();
        //2- create the instance of the Chrome driver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.manage().window().fullscreen();

        //3- test if driver is working
        driver.get("https://www.google.com");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        // Browser Navigation
        // this line will take user to the previous page
        Thread.sleep(2000);
        driver.navigate().back();

        Thread.sleep(2000);
        driver.navigate().refresh();

        Thread.sleep(2000);
        driver.navigate().to("https://www.haberturk.com");

        System.out.println(driver.getTitle());

        System.out.println(driver.getCurrentUrl());

        System.out.println(driver.getPageSource());

        driver.close();









    }


}
