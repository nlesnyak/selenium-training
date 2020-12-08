package ru.selenium.training.tests;

import org.junit.Test;
import ru.selenium.training.ApplicationManager;
import ru.selenium.training.TestBase;

public class HomeWork02 extends TestBase {

    @Test
    public void openSeveralDifferentPages(){
        ApplicationManager.driver.get("http://www.google.com/");
        //driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        ApplicationManager.driver.get("http://yandex.ru/");
        //driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        ApplicationManager.driver.get("http://ozon.com");
        }

}
