package ru.selenium.training;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class HomeWork02 {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void openSeveralDifferentPages(){
        driver.get("http://www.google.com/");
        //driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.get("http://yandex.ru/");
        //driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.get("http://ozon.com");
        }

    @After
    public void stop(){
        driver.quit();
        driver = null;
        }

}
