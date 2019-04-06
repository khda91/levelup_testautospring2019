package ru.levelup.selenium.page.objects;

import io.github.bonigarcia.wdm.WebDriverManager;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.levelup.selenium.po.voids.LoginPage;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {

    protected WebDriver driver;
    private ChromeOptions options;

    @BeforeSuite(alwaysRun = true)
    protected void setUpSuite() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeClass(alwaysRun = true)
    public void setUpClassTest() {
        options = new ChromeOptions();
//        options.addArguments("--lang=ru");
//        options.addArguments("--headless");
    }

    @BeforeMethod(alwaysRun = true)
    protected void setUpTest() {
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);
        driver.manage().timeouts().setScriptTimeout(15000, TimeUnit.MILLISECONDS);
        // 1. Открыть MantisBT: http://khda91.fvds.ru/mantisbt/
        driver.get("http://khda91.fvds.ru/mantisbt/");
//        new LoginPage(driver).login("admin", "admin");
    }

    @AfterMethod(alwaysRun = true)
    protected void closeBrowser() {
        //  9. Закрыть браузер
        driver.close();
    }
}
