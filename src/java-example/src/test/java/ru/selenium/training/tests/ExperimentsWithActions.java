package ru.selenium.training.tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class ExperimentsWithActions {
    private WebDriver driver = null;
    private WebDriverWait wait;

    @Before
    public void start() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void moveElementsTest() {
        final By list1Locator =  By.xpath("//ul[@id='sortable1']/li");
        final By list2Locator =  By.xpath("//ul[@id='sortable2']/li");

        driver.navigate().to("https://jqueryui.com/resources/demos/sortable/connect-lists.html");

        Actions action = new Actions(driver);
        List<WebElement> elementsList1 = driver.findElements(list1Locator);
        action.dragAndDrop(elementsList1.get(1), elementsList1.get(3)).perform();

        List<WebElement> updElementsList1 = driver.findElements(list1Locator);
        List<WebElement> elementsList2 = driver.findElements(list2Locator);
        action.dragAndDrop(updElementsList1.get(1), elementsList2.get(2)).perform();

        Assert.assertEquals("Item 4", driver.findElements(list1Locator).get(1).getText());
        Assert.assertEquals("Item 3", driver.findElements(list2Locator).get(2).getText());
        Assert.assertEquals("Item 3", driver.findElements(list2Locator).get(3).getText());

        List<String> list1 = new ArrayList();
        List<String> list2 = new ArrayList();

        driver.findElements(list1Locator).forEach(listResult1 -> list1.add(listResult1.getText()));
        System.out.println("1st list: ");
        list1.forEach(System.out::println);
        System.out.println("");

        driver.findElements(list2Locator).forEach(listResult2 -> list2.add(listResult2.getText()));
        System.out.println("2nd list: ");
        list2.forEach(System.out::println);
    }

    @After
    public void stop(){
        driver.quit();
        driver = null;
    }

}
