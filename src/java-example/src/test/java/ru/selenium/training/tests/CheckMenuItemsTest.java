package ru.selenium.training.tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.selenium.training.ApplicationManager;
import ru.selenium.training.TestBase;

import java.util.List;

import static junit.framework.Assert.assertNotNull;

public class CheckMenuItemsTest extends TestBase {

    @Test
    public void checkMenuItemsTest() {

        final By menuItemsList = By.xpath("//ul[@id='box-apps-menu']/li/a");
        final By subMenuItemsList = By.cssSelector(".app.selected li");
        //final By subMenuItemsList = By.xpath("//li[@class='app selected']//li");
        final By headerContainer = By.xpath("//div[@class='panel-heading']");

        app.loginToAdmin("admin", "admin");

        List<WebElement> menuItems = ApplicationManager.wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(menuItemsList));
        for (int i = 0; i < menuItems.size(); i++) {
            menuItems = ApplicationManager.driver.findElements(menuItemsList);
            menuItems.get(i).click();
            assertNotNull(ApplicationManager.driver.findElement(headerContainer).getText());

            List<WebElement> subMenuItems = ApplicationManager.driver.findElements(subMenuItemsList);
            for (int j = 0; j < subMenuItems.size(); j++) {
                subMenuItems = ApplicationManager.driver.findElements(subMenuItemsList);
                subMenuItems.get(j).click();
                assertNotNull(ApplicationManager.driver.findElement(headerContainer).getText());
            }
        }
    }

}
