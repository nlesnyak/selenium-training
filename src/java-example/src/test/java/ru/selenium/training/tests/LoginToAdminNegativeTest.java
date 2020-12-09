package ru.selenium.training.tests;

import org.junit.Test;
import org.openqa.selenium.By;
import ru.selenium.training.ApplicationManager;
import ru.selenium.training.TestBase;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LoginToAdminNegativeTest extends TestBase {

    // TBD
    @Test
    public void loginWithIncorrectPassword(){
        app.loginToAdmin("admin", "wrongPassword");

        assertTrue(ApplicationManager.driver.findElement(By.id("notices")).isDisplayed());
    }
}
