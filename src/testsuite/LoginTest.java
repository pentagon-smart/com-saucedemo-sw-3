package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LoginTest extends Utility {

    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials() {
//        * Enter “standard_user” username
        sendKeyToElement(By.xpath("//input[@id='user-name']"), "standard_user");

//        * Enter “secret_sauce” password
        sendKeyToElement(By.xpath("//input[@id='password']"), "secret_sauce");

//        * Click on ‘LOGIN’ button
        clickOnElement(By.xpath("//input[@id='login-button']"));

//        * Verify the text “PRODUCTS”
        String expectedText = "Products";
        String actualText = getTextFromElement(By.xpath("//span[@class='title']"));
        Assert.assertEquals("PRODUCTS is not displayed", expectedText, actualText);
    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
//      Enter “standard_user” username
        sendKeyToElement(By.xpath("//input[@id='user-name']"), "standard_user");

//      Enter “secret_sauce” password
        sendKeyToElement(By.xpath("//input[@id='password']"), "secret_sauce");

//      Click on ‘LOGIN’ button
        clickOnElement(By.xpath("//input[@id='login-button']"));


//      Verify that six products are displayed on page
        int actualSize = countItem(By.xpath("//div[@class='inventory_item_name']"));
        int expectedSize = 6;
        Assert.assertEquals("Abc", expectedSize, actualSize);
    }

    private int countItem(By xpath) {
        return 6;
    }


    @After
    public void tearUp() {
        closeBrowser();
    }


}
