package test.day12_synchronization;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ForgotPasswordPage;
import pages.LoginPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class ForgotPasswordTests {
    /*
1. Go to https://qa3.vytrack.com
2. Click to "Forgot your password?" link
3. Verify title changed to expected
    Expected: "Forgot Password"
4. Verify url is as expected:
    Expected: "https://qa3.vytrack.com/user/reset-request"
   Note: Follow Page Object Model design pattern
    */

    @Test
    public void tc35_title_url_verification(){
        Driver.getDriver().get(ConfigurationReader.getProperty("vytrack_url"));

        LoginPage loginPage = new LoginPage();

        loginPage.forgotPasswordLink.click();

        //Verify title changed to expected
        String expectedTitle = "Forgot Password";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(actualTitle,expectedTitle);

        //Verify url is as expected:
        String expectedUrl = "https://qa2.vytrack.com/user/reset-request";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertEquals(actualUrl, expectedUrl);
    }

    /*
    TC#36 : Vytrack forgot password page verification->ERROR MESSAGE
        1. Go to https://qa3.vytrack.com/user/reset-request
        2. Enter random username
        3. Click to request button
        4. Verify error message is displayed
        5. Verify error message text is as expected.
        Expected: There is no active user with username or email address "given text".
        Note: Follow Page Object Model design pattern
     */

    @Test
    public void tc36_error_message_verirification(){
        Driver.getDriver().get(ConfigurationReader.getProperty("forgotpassword_url"));

        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();

        String randomString = "asdfaa";

        //clicking to request button
        forgotPasswordPage.inputBox.sendKeys(randomString);

        forgotPasswordPage.requestButton.click();

        //verifying error message is displayed
        Assert.assertTrue(forgotPasswordPage.errorMessage.isDisplayed());

        //Verify error message text is as expected.
        String expectedMessage = "There is no active user with username or email address \"" + randomString + "\".";
        String actualMessage = forgotPasswordPage.errorMessage.getText();

        Assert.assertEquals(actualMessage, expectedMessage);

    }


}
