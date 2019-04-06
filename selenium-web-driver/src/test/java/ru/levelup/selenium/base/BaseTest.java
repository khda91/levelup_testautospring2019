package ru.levelup.selenium.base;

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

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {

    protected WebDriver driver;
    private ChromeOptions options;

    @BeforeSuite
    protected void setUpSuite() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeClass
    public void setUpClassTest() {
        options = new ChromeOptions();
//        options.addArguments("--lang=ru");
//        options.addArguments("--headless");
    }

    @BeforeMethod
    protected void setUpTest() {
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);
        driver.manage().timeouts().setScriptTimeout(15000, TimeUnit.MILLISECONDS);
        // 1. Открыть MantisBT: http://khda91.fvds.ru/mantisbt/
        driver.get("http://khda91.fvds.ru/mantisbt/");
        login("admin", "admin");
    }

    @AfterMethod
    protected void closeBrowser() {
        //  9. Закрыть браузер
        driver.close();
    }

    protected void login(final String username, final String password) {
        // 2. Авторизоваться admin:admin
        driver.findElement(By.id("username")).sendKeys(username);
        WebElement loginBtn = driver.findElement(By.cssSelector(".btn-success"));
        loginBtn.click();

        WebElement passwordTextField = driver.findElement(By.id("password"));
        passwordTextField.sendKeys(password);
        driver.findElement(By.cssSelector(".btn-success")).click();

        // 3. Проверить, что пользователь авторизован
        assertThat(driver.getTitle(), equalTo("My View - MantisBT"));
    }
}
