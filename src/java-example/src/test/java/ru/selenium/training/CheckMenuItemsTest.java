package ru.selenium.training;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static junit.framework.Assert.assertTrue;

public class CheckMenuItemsTest {
    private WebDriver driver;
    //= null;
    private WebDriverWait wait;

    @Before
    public void start() {
//        driver = new ChromeDriver();
//        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        driver.manage().timeouts();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 2);
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void checkMenuItemsTest() {

        final String menuItemLocator = "//ul[@id='box-apps-menu']/li/a";
        final String subMenuItemLocator = "//ul[@id='box-apps-menu']/li/ul/li";
        final String headerXpathValue = "//main[@id='main']/div[@id='content']//div[@class='panel-heading']";

        driver.get("http://localhost:8080/litecart/admin/login.php");
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

        WebElement loginField = driver.findElement(By.name("username"));
        loginField.clear();
        loginField.sendKeys("admin");

        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.clear();
        passwordField.sendKeys("admin");

        WebElement loginButton = driver.findElement(By.cssSelector("button"));
        loginButton.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        List<WebElement> menuItems = driver.findElements(By.xpath(menuItemLocator));

        for (int i = 0; i < menuItems.size(); i++) {
            menuItems = driver.findElements(By.xpath(menuItemLocator));
            menuItems.get(i).click();
            assertTrue(driver.findElement(By.xpath(headerXpathValue)).isDisplayed());

            List<WebElement> subMenuItems = driver.findElements(By.xpath(subMenuItemLocator));
            for (int j = 0; j < subMenuItems.size() ; j++) {
                subMenuItems = driver.findElements(By.xpath(subMenuItemLocator));
                subMenuItems.get(j).click();
                assertTrue(driver.findElement(By.xpath(headerXpathValue)).isDisplayed());
            }
        }
    }

    @After
    public void stop(){
        driver.quit();
        driver = null;
    }

}
