package ru.levelup.selenium.page.objects;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public abstract class BaseTest {

    protected WebDriver driver;
    private ChromeOptions options;

    @BeforeSuite(alwaysRun = true)
    protected void setUpSuite() {
        WebDriverManager.chromedriver().setup();
        Properties properties = new Properties();
        try {
            // Прямой пусть до файла относительно исходного кода
//            properties.load(new FileInputStream(new File("src/test/resources/test/sample.properties")));

            // Через перемнные среды окружения
            properties.load(new FileInputStream(new File(System.getProperty(""))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(properties.getProperty("admin.username"));
        Long.parseLong(properties.getProperty("browser.implicitly.timeout.ms"));
    }

    @BeforeClass(alwaysRun = true)
    @Step("Init")
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
    }

    @AfterMethod(alwaysRun = true)
    protected void closeBrowser() {
        //  9. Закрыть браузер
        driver.close();
    }
}
