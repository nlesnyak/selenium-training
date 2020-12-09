package ru.selenium.training;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase {

    public ApplicationManager app = new ApplicationManager();
    public static WebDriver driver;
    public static WebDriverWait wait;

    @Before
    public void start() {
        app.init();
    }

    @After
    public void stop(){
        app.stopDriver();
    }

}
