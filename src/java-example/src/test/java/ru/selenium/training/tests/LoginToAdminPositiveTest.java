package ru.selenium.training.tests;

import org.junit.Test;
import ru.selenium.training.TestBase;

public class LoginToAdminPositiveTest extends TestBase {

    @Test
    public void loginToAdminPositiveTest(){
        app.loginToAdmin("admin", "admin");
    }
}
