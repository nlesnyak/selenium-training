package ru.selenium.training;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class ApplicationManager {
    public static WebDriver driver;
    public static WebDriverWait wait;

    public void init() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 2);
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void stopDriver() {
        driver.quit();
        driver = null;
    }

    public void loginToAdmin(String username, String password) {
        ApplicationManager.driver.navigate().to("http://localhost:8080/litecart/admin/login.php");

        WebElement loginField = ApplicationManager.wait.until(visibilityOfElementLocated(By.name("username")));
        loginField.clear();
        loginField.sendKeys(username);

        WebElement passwordField = ApplicationManager.wait.until(visibilityOfElementLocated(By.name("password")));
        passwordField.clear();
        passwordField.sendKeys(password);

        WebElement loginButton = ApplicationManager.wait.until(visibilityOfElementLocated(By.cssSelector("button")));
        loginButton.click();
    }
}
