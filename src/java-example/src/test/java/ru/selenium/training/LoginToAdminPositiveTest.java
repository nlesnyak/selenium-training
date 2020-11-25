package ru.selenium.training;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.file.Paths;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class LoginToAdminPositiveTest {
    private WebDriver driver = null;
    private WebDriverWait wait;

    @Before
    public void start() {

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 2);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void loginToAdminPositiveTest(){
        driver.get("http://localhost:8080/litecart/admin/login.php");
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

        //WebElement loginField = driver.findElement(By.xpath("//input[@name='username']"));
        WebElement loginField = driver.findElement(By.name("username"));
        loginField.clear();
        loginField.sendKeys("admin");

        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.clear();
        passwordField.sendKeys("admin");

        WebElement loginButton = driver.findElement(By.cssSelector("button"));
        loginButton.click();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

        WebElement logoutButton = driver.findElement(By.cssSelector("a[title='Logout']"));
        logoutButton.click();
    }

    @After
    public void stop(){
        driver.quit();
        driver = null;
    }
}
