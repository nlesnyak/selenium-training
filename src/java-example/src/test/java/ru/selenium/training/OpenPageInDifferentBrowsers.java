package ru.selenium.training;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class OpenPageInDifferentBrowsers {
    private WebDriver driver = null;
    private WebDriverWait wait;
    String current_browser = "chrome";

//    @Before
//    public void startBrowser() {
//        if (current_browser.equals("chrome")) {
//            driver = new ChromeDriver();
//            //driver.manage().window().maximize();
//            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        } else if (current_browser.equals("firefox")) {
//            driver = new FirefoxDriver();
//            //driver.manage().window().maximize();
//            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        }
//    }



    @Test
    public void openPages() {
        //String current_browser = "firefox";
        driver = new ChromeDriver();
        driver.get("http://www.yandex.ru");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.close();
        //driver = null;

        driver = new FirefoxDriver();
        driver.get("http://www.yandex.ru");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @After
    public void stop(){
        driver.quit();
        driver = null;
    }

}
