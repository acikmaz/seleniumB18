package test.day06_testNG_dropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class Dropdowns_Intro {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        // 1.Open Chrome browser
        // 2.Go to http://practice.cybertekschool.com/dropdown
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }

    @Test
    public void test1_default_value_verification(){
       // TC#1: Verifying “Simple dropdown” and “State selection” dropdown default values
        // 3.Verify “Simple dropdown” default selected value is correct
        // Expected: “Please select an option”
        Select simpleDropdown = new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));

        String actualDefaultOfSimpleDropdown = simpleDropdown.getFirstSelectedOption().getText();
        String expectedDefaultOfSimpleDropdown = "Please select an option";

        Assert.assertEquals(actualDefaultOfSimpleDropdown, expectedDefaultOfSimpleDropdown);

        // 4.Verify“State selection” default selected value is correct
        // Expected: “Select a State”
        Select stateDropdown = new Select(driver.findElement(By.xpath("//select[@id='state']")));

        String actualDefaultOfStateDropdown = stateDropdown.getFirstSelectedOption().getText();
        String expectedDefaultOfStateDropdown = "Select a State";

        Assert.assertEquals(actualDefaultOfStateDropdown, expectedDefaultOfStateDropdown);
    }

    @Test
    public void test2_state_dropdown_verification() throws InterruptedException{
//        TC #2: Selecting state from State dropdown and verifying result 1. Open Chrome browser
//        2. Go to http://practice.cybertekschool.com/dropdown
//        locating state dropdown
        Select stateDropdown = new Select(driver.findElement(By.xpath("//select[@id='state']")));
//        3. Select Illinois
        Thread.sleep(1000);
        stateDropdown.selectByValue("IL");

//        4. Select Virginia
        Thread.sleep(1000);
        stateDropdown.selectByVisibleText("Virginia");
//        5. Select California
        Thread.sleep(1000);
        stateDropdown.selectByIndex(5);
//        6. Verify final selected option is California.

        String expectedOption = "California";
        String actualSelectedOption = stateDropdown.getFirstSelectedOption().getText();

        Assert.assertEquals(expectedOption, actualSelectedOption);

        Assert.assertTrue(actualSelectedOption.equalsIgnoreCase(expectedOption));
//        Use all Select options. (visible text, value, index)
    }


}
