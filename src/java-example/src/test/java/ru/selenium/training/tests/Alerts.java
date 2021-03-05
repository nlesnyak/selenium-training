package ru.selenium.training.tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent;

public class Alerts {
    private WebDriver driver = null;
    private WebDriverWait wait;

    @Before
    public void start() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void clickButtonToSeeAlertTest() {
        driver.navigate().to("https://demoqa.com/alerts");

        driver.findElement(By.id("alertButton")).click();
        driver.switchTo().alert().accept();
        System.out.println("1st alert checked");

        driver.findElement(By.id("timerAlertButton")).click();
        wait.until(alertIsPresent()).accept();
        System.out.println("2nd alert checked");

        driver.findElement(By.id("confirmButton")).click();
        driver.switchTo().alert().dismiss();
        String textFor3rdAlert = driver.findElement(By.id("confirmResult")).getText();
        Assert.assertTrue(textFor3rdAlert.contains("Cancel"));
        System.out.println("3rd alert checked: " + textFor3rdAlert);

        driver.findElement(By.id("promtButton")).click();
        Alert promtAlert = driver.switchTo().alert();
        promtAlert.sendKeys("baraban!");
        promtAlert.accept();
        String textFor4thAlert = driver.findElement(By.id("promptResult")).getText();
        Assert.assertTrue(textFor4thAlert.contains("baraban!"));
        System.out.println("4th alert checked: " + textFor4thAlert);
    }

    @After
    public void stop(){
        driver.quit();
        driver = null;
    }

}
