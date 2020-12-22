package ru.selenium.training.tests;

import org.junit.Test;
import org.openqa.selenium.By;
import ru.selenium.training.ApplicationManager;
import ru.selenium.training.TestBase;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class LoginToAdminNegativeTest extends TestBase {

    @Test
    public void loginWithIncorrectPassword(){

        final By wrongPWMessageLocator = By.xpath("//div[@id='notices']//div[@class='alert alert-danger'][contains(.,'Wrong combination of username and password')]");
        //final By wrongPWMessageLocator = By.xpath("//div[@id='notices']//div[@class='alert alert-danger']");
        app.loginToAdmin("admin", "wrongPassword");
        ApplicationManager.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        assertTrue(ApplicationManager.driver.findElement(wrongPWMessageLocator).isDisplayed());
    }
}
