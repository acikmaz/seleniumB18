package test.day06_testNG_dropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.List;

public class Dropdowns {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
    }

    @Test
    public void test1_getFirstSelectedOption(){


        WebElement simpleDropdown = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select select = new Select(simpleDropdown);
        System.out.println(select.getFirstSelectedOption().getText());

        String actualSelected = select.getFirstSelectedOption().getText();
        String expectedSelected = "Please select an option";

        Assert.assertTrue(actualSelected.equals(expectedSelected));

        driver.close();

    }

    @Test
    public void test2_state_dropdown() throws InterruptedException{

        Select select = new Select(driver.findElement(By.xpath("//select[@id='state']")));

        Thread.sleep(1000);
        select.selectByVisibleText("Illinois");

        Thread.sleep(1000);
        select.selectByValue("VA");

        Thread.sleep(1000);
        select.selectByIndex(5);

        String expectedSelectedOption = "California";
        String actualSelectedOption = select.getFirstSelectedOption().getText();

        Assert.assertEquals(actualSelectedOption, expectedSelectedOption);

        driver.close();
    }

    @Test
    public void test3_selecting_date_test(){
        //Select “December 31st, 1921” and verify it is selected.
        Select yearDropdown = new Select(driver.findElement(By.xpath("//select[@id='year']")));
        Select monthDropdown = new Select(driver.findElement(By.xpath("//select[@id='month']")));
        Select dayDropdown = new Select(driver.findElement(By.xpath("//select[@id='day']")));

        //Selecting year by visible text
        yearDropdown.selectByVisibleText("1921");

        //Selecting month by value
        monthDropdown.selectByValue("11");

        //Selecting day by index  number
        dayDropdown.selectByIndex(0);


        //Creating expected values
        String expectedYear = "1921";
        String expectedMonth = "December";
        String expectedDay = "1";


        //Getting actual values
        String actualYear = yearDropdown.getFirstSelectedOption().getText();
        String actualMonth = monthDropdown.getFirstSelectedOption().getText();
        String actualDay = dayDropdown.getFirstSelectedOption().getText();


        //Assertions of actual vs expected
        Assert.assertEquals(expectedYear, actualYear);
        Assert.assertEquals(actualMonth, expectedMonth);
        Assert.assertEquals(actualDay, expectedDay);

        //driver.close();
        //Use all Select options.
    }


    /*
    TC #4: Selecting value from multiple select dropdown
        1. Open Chrome browser
        2. Go to http://practice.cybertekschool.com/dropdown
        3. Select all the options from multiple select dropdown.
        4. Print out all selected values.
        5. Deselect all values.
     */

    @Test
    public void test4_multiple_select_dropdown() throws InterruptedException{

        //Locating select dropdown
        Select languagesDropdown = new Select(driver.findElement(By.xpath("//select[@name='Languages']")));


        //Getting all of the options from dropdown and storing them into list of web elements
        List<WebElement> allOptions = languagesDropdown.getOptions();


        //Looping through the options and selecting them
        for(WebElement option : allOptions){
            option.click();
            System.out.println("Selected: " + option.getText());

            //Doing the assertion after selecting
            Assert.assertTrue(option.isSelected());

        }

        languagesDropdown.deselectAll();

        //Asserting they are de-selected
        for (WebElement option1 : allOptions) {
            Assert.assertFalse(option1.isSelected());
        }


        //driver.close();
        //Use all Select options.
    }

    @Test
    public void test5_non_select_dropdown(){

        //Locating the non-select dropdown
        WebElement webSiteDropdown = driver.findElement(By.xpath("//div[@class='dropdown']/a"));


        //Clicking to open the dropdown
        webSiteDropdown.click();

        //Locating Facebook link from the non-select dropdown
        WebElement facebookLink = driver.findElement(By.xpath("//a[.='Facebook']"));

        //Clicking to the Facebook link
        facebookLink.click();

        //Creating expected title
        String expectedFacebookTitle = "Facebook - Log In or Sign Up";

        //String getting the actual title
        String  actualTitle = driver.getTitle();


        //Asserting actual vs expected
        Assert.assertEquals(actualTitle, expectedFacebookTitle);

    }
}