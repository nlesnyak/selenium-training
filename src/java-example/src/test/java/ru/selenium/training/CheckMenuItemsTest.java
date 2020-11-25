package ru.selenium.training;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import static junit.framework.Assert.assertNotNull;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class CheckMenuItemsTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 2);
    }

    @Test
    public void checkMenuItemsTest() {

        final String menuItemLocator = "//ul[@id='box-apps-menu']/li/a";
        final String subMenuItemLocator = "//ul[@id='box-apps-menu']/li/ul/li";
        //final String headerXpathValue = "//main[@id='main']/div[@id='content']//div[@class='panel-heading']";
        final String headerXpathValue = "//div[@class='panel-heading']";

        driver.get("http://localhost:8080/litecart/admin/login.php");

        WebElement loginField = wait.until(visibilityOfElementLocated(By.name("username")));
        loginField.clear();
        loginField.sendKeys("admin");

        WebElement passwordField = wait.until(visibilityOfElementLocated(By.name("password")));
        passwordField.clear();
        passwordField.sendKeys("admin");

        WebElement loginButton = wait.until(visibilityOfElementLocated(By.cssSelector("button")));
        loginButton.click();

        List<WebElement> menuItems = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(menuItemLocator)));

        for (int i = 0; i < menuItems.size(); i++) {
           menuItems = driver.findElements(By.xpath(menuItemLocator));
            menuItems.get(i).click();
            assertNotNull(driver.findElement(By.xpath(headerXpathValue)).getText());

            List<WebElement> subMenuItems = driver.findElements(By.xpath(subMenuItemLocator));
            for (int j = 0; j < subMenuItems.size() ; j++) {
                subMenuItems = driver.findElements(By.xpath(subMenuItemLocator));
                subMenuItems.get(j).click();
                assertNotNull(driver.findElement(By.xpath(headerXpathValue)).getText());
            }
        }
    }

    @After
    public void stop(){
        driver.quit();
        driver = null;
    }

}
