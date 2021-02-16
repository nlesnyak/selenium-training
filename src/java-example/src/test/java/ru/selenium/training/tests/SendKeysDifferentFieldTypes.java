package ru.selenium.training.tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SendKeysDifferentFieldTypes {
    private WebDriver driver = null;
    private WebDriverWait wait;

    @Before
    public void start() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void sendKeysTest() {
   //     driver = new ChromeDriver();
        driver.navigate().to("https://snipp.ru/jquery/masked-input");

        driver.switchTo().frame("sample-6111");
        WebElement phoneField = driver.findElement(By.xpath("//input[@class='mask-phone form-control']"));
        phoneField.sendKeys(Keys.HOME + "9515555555");
        String phoneNumber = phoneField.getAttribute("value");
        Assert.assertEquals("+7 (951) 555-55-55", phoneNumber);
        System.out.println("Phone number entered: " + phoneNumber);
        driver.switchTo().defaultContent();

        driver.switchTo().frame("sample-6114");
        WebElement dateField = driver.findElement(By.xpath("//input[@class='mask-date form-control']"));
        dateField.sendKeys("12111990");
        String dateValue = dateField.getAttribute("value");
       // Assert.assertEquals("12.11.1990", dateValue);
        System.out.println("Date entered: " + dateValue);
        driver.switchTo().defaultContent();

        driver.switchTo().frame("sample-6111");
        //phoneField.sendKeys(Keys.END, Keys.ARROW_LEFT, Keys.ARROW_LEFT, Keys.ARROW_LEFT, Keys.ARROW_LEFT, Keys.ARROW_LEFT, Keys.DELETE, Keys.DELETE, "66");
        phoneField.sendKeys(Keys.END);
        for (int i = 0; i < 5; i++) {
            phoneField.sendKeys(Keys.ARROW_LEFT);
        }
        phoneField.sendKeys(Keys.DELETE, Keys.DELETE, "66");
        String changedPhoneNumber = phoneField.getAttribute("value");
        //System.out.println("Phone number changed: " + changedPhoneNumber);
        //Assert.assertTrue(changedPhoneNumber.contains("+7 (951) 555-66-55"));
       // Assert.assertEquals("+7 (951) 555-66-55", changedPhoneNumber);
        System.out.println("Phone number changed: " + changedPhoneNumber);
        //driver.switchTo().defaultContent();
    }

    @Test
    public void enterLongTextTest() {
        driver.navigate().to("https://translate.google.ru/?hl=ru");
        WebElement inputField = driver.findElement(By.xpath("//div[@class='QFw9Te']"));
        JavascriptExecutor executor = ((JavascriptExecutor) driver);
        executor.executeScript("arguments[0].innerText='Ya k vam pishu, chego zhe bole...'", inputField);
        String text = inputField.getAttribute("innerText");
        Assert.assertEquals("Ya k vam pishu, chego zhe bole...", text);
        System.out.println("Entered text: " + text);
    }

    @Test
    public void copyPastTest() {
        driver.navigate().to("http://gramota.ru/class/istiny/istiny_1_toponimy/");
       // WebElement textForCopyElement = driver.findElement(By.xpath("//div[@class='inside block-content']"));
        //String textForCopy = textForCopyElement.getAttribute("innerText");
      //  textForCopyElement.click();
       // Action builder;
        Actions action = new Actions(driver);
        WebElement textForCopyElement = driver.findElement(By.xpath("//div[@class='inside block-content']"));
        action.click().keyDown(Keys.CONTROL).sendKeys("a").pause(100).sendKeys("c").pause(100).perform();
//        textForCopyElement.sendKeys(Keys.chord(Keys.CONTROL + "a"));
//        textForCopyElement.sendKeys(Keys.chord(Keys.CONTROL, "c"));
        ////action.click().keyDown(Keys.CONTROL).sendKeys("a").sendKeys("c").keyUp(Keys.CONTROL).build().perform();
        //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

//        Actions action2 = new Actions(driver);
//        action2.keyDown(Keys.CONTROL).sendKeys("c").build().perform();

       // Actions action3 = new Actions(driver);

        driver.navigate().to("https://translate.google.ru/?hl=ru");
        WebElement inputField = driver.findElement(By.xpath("//div[@class='QFw9Te']"));
        action.click().keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).pause(10).perform();
        //inputField.sendKeys(Keys.chord(Keys.CONTROL, "v"));
        //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        String text = inputField.getAttribute("innerText");
        System.out.println("Entered text: " + text);

    }


    @After
    public void stop(){
        driver.quit();
        driver = null;
    }
}
