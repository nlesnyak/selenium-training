package ru.selenium.training.tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.selenium.training.TestBase;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class ClickLink extends TestBase {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start(){
       // driver = new InternetExplorerDriver();
       // System.setProperty("webdriver.chrome.driver", "C:\\workspace\\chromedriver.exe");
      //  driver = new ChromeDriver();
      //  wait = new WebDriverWait(driver, 2);
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    //org.openqa.selenium.ElementClickInterceptedException: element click intercepted: Element is not clickable at point (174, -9)
    public void clickLinkChromeTest() {
        driver = new ChromeDriver();
        driver.navigate().to("https://output.jsbin.com/zezuyo");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement link = driver.findElement(By.cssSelector("a"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click;", link);

        //driver.close();
//        driver = null;
    }

    @Test
    public void clickLinkFFTest() {
        driver = new FirefoxDriver();
        driver.navigate().to("https://output.jsbin.com/zezuyo");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("a")).click();
    }

    @Test
    public void clickLinkIETest() {

        DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
        capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
        capabilities.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, "https://output.jsbin.com/zezuyo");
        //capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
       // File file = new File("C:\\webdrivers\\IEDriverServer.exe");
        //System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
        //WebDriver
        driver = new InternetExplorerDriver(capabilities);
        driver.get("https://output.jsbin.com/zezuyo");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.findElement(By.cssSelector("a")).click();
        WebElement link = driver.findElement(By.xpath("//a[contains(@href,'http://seleniumhq.org/')]"));
        link.click();
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals("https://www.selenium.dev/", driver.getCurrentUrl());
        //driver.close();

    }

    @After
    public void stop(){
        driver.quit();
        driver = null;
    }


}
