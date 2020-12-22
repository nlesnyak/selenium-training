package ru.selenium.training.tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.selenium.training.ApplicationManager;
import ru.selenium.training.TestBase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class CheckCountriesAndGeoonesSortingTest extends TestBase {

    @Test
    public void openCountriesPageTest() {

        List<String> countriesNamesListText = new ArrayList<>();
        List<String> sortedCountriesNamesList = new ArrayList<>();

        final By countriesListLocator = By.xpath("//form[@name='countries_form']//tr[@class]/td[5]");
       // final By zonesNumberListLocator = By.xpath("//form[@name='countries_form']//tr[@class]/td[6]");

        app.loginToAdmin("admin", "admin");

        WebElement menuCountriesItem = ApplicationManager.wait.until(elementToBeClickable(By.cssSelector("li[data-code='countries']")));
        menuCountriesItem.click();

        List<WebElement> countriesListElements = ApplicationManager.driver.findElements(countriesListLocator);

        Iterator<WebElement> itrCountriesElements = countriesListElements.iterator();
        while (itrCountriesElements.hasNext()) {
           countriesNamesListText.add(itrCountriesElements.next().getAttribute("innerText"));
        }

        Iterator<String> itrCountriesNames = countriesNamesListText.iterator();
        while (itrCountriesNames.hasNext()) {
            sortedCountriesNamesList.add(itrCountriesNames.next());
        }
        Collections.sort(sortedCountriesNamesList);
        Assert.assertEquals(sortedCountriesNamesList, countriesNamesListText);

        for (int i = 0; i < countriesNamesListText.size(); i++) {
            if(countriesNamesListText.get(i).equals(sortedCountriesNamesList.get(i))) {
                System.out.println("compare: " + countriesNamesListText.get(i) + " with: " + sortedCountriesNamesList.get(i) + " = ok");
            } else {
                System.out.println("compare: " + countriesNamesListText.get(i) + " with: " + sortedCountriesNamesList.get(i) + " = nok");
            }

        }

//        List<WebElement> zonesNumberListElements = ApplicationManager.driver.findElements(zonesNumberListLocator);
//        Iterator<WebElement> itr3 = zonesNumberListElements.iterator();
//        while (itr3.hasNext()) {
//            if (!itr3.next().getAttribute("innerText").equals("0")) {
//
//            }

//        }

    }

}