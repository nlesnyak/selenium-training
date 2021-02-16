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
import java.util.stream.Collectors;

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
        final By wholeList1ResultLocator =  By.xpath("//ul[@id='sortable1']/li");
        final By wholeList2ResultLocator =  By.xpath("//ul[@id='sortable2']/li");
        final By list1Item2Locator = By.xpath("//ul[@id='sortable1']/li[2]");
        final By list1Item4Locator = By.xpath("//ul[@id='sortable1']/li[4]");
        final By list2Item3Locator = By.xpath("//ul[@id='sortable2']/li[3]");
        final By list2Item4Locator = By.xpath("//ul[@id='sortable2']/li[4]");

        driver.navigate().to("https://jqueryui.com/resources/demos/sortable/connect-lists.html");
        Actions action = new Actions(driver);
        WebElement item2 = driver.findElement(list1Item2Locator);
        WebElement item4 = driver.findElement(list1Item4Locator);
        action.dragAndDrop(item2, item4).perform();

        WebElement item22 = driver.findElement(list1Item2Locator);
        WebElement item33 = driver.findElement(list2Item3Locator);
        action.dragAndDrop(item22, item33).perform();

        String newItem2In1stList = driver.findElement(list1Item2Locator).getText();
        String newItem3In2ndList = driver.findElement(list2Item3Locator).getText();
        String newItem4In2ndList = driver.findElement(list2Item4Locator).getText();

        Assert.assertTrue(newItem2In1stList.equals("Item 4"));
        //System.out.println("1st List, 2nd item: " + newItem2In1stList);

        Assert.assertTrue(newItem3In2ndList.equals("Item 3"));
        //System.out.println("2nd list, 3rd item: " + newItem3In2ndList);

        Assert.assertTrue(newItem4In2ndList.equals("Item 3"));
        //System.out.println("2nd list, 4th item: " + newItem4In2ndList);

        List<String> list1 = new ArrayList();
        List<String> list2 = new ArrayList();

        driver.findElements(wholeList1ResultLocator).stream().forEach(listResult1 -> list1.add(listResult1.getText()));
        System.out.println("1st list: ");
        list1.forEach(System.out::println);
        System.out.println("");

        driver.findElements(wholeList2ResultLocator).stream().forEach(listResult2 -> list2.add(listResult2.getText()));
        System.out.println("2nd list: ");
        list2.forEach(System.out::println);
    }

    @After
    public void stop(){
        driver.quit();
        driver = null;
    }

}
