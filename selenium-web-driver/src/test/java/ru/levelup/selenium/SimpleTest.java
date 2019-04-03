package ru.levelup.selenium;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;

public class SimpleTest {


    @Test
    public void handleTest() {
        System.setProperty("webdriver.chrome.driver",
                "src/test/resources/webdriver.chrome/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://khda91.fvds.ru/mantisbt/");
        System.out.println("driver handle -> " + driver.getWindowHandle());

        WebDriver driver1 = new ChromeDriver();
        driver1.get("http://khda91.fvds.ru/mantisbt/");
        System.out.println("driver1 handle -> " + driver1.getWindowHandle());

        driver1.navigate().to("http://khda91.fvds.ru/");

        System.out.println(driver.getWindowHandles());

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.close();
        driver1.close();
    }

    @Test
    public void loginTest() {
        System.setProperty("webdriver.chrome.driver",
                "src/test/resources/webdriver.chrome/chromedriver");
        WebDriver driver = new ChromeDriver();
        // неявные ожидания
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);
        driver.manage().timeouts().setScriptTimeout(15000, TimeUnit.MILLISECONDS);

        driver.get("http://khda91.fvds.ru/mantisbt/");


//        driver.findElement(By.className("block input-icon input-icon-right"))
//                .sendKeys("admin");

        driver.findElement(By.id("username")).sendKeys("admin");

        // явные
//        driver.findElement(By.cssSelector(".btn-success"));
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
        WebElement loginBtn = new WebDriverWait(driver, 10, 1000)
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn-success")));
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        loginBtn.click();

        List<WebElement> listSpaces = driver.findElements(By.cssSelector(".space-10"));
        System.out.println("Amount of 'space-10' elements -> " + listSpaces.size());

//        driver.findElement(By.cssSelector("#password"));
//        driver.findElement(By.xpath("//*[@id=\"password\"]"));

        // собственное явное ожидание
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
        WebElement passwordTextField = new WebDriverWait(driver, 5, 1000)
                .until(new ExpectedCondition<WebElement>() {
                    @NullableDecl
                    @Override
                    public WebElement apply(@NullableDecl WebDriver webDriver) {
                        System.out.println("Working Explicit wait");
                        WebElement element = webDriver.findElement(By.id("password1"));
                        return element.isDisplayed() ? element : null;
                    }
                });
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

//        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("admin");
        passwordTextField.sendKeys("admin");
        driver.findElement(By.xpath("//input[@value='Login']")).click();

        assertThat(driver.getTitle(), equalTo("MantisBT"));

        List<String> expectedTabNames = Arrays.asList(new String[]{"Manage Users",
                "Manage Configuration", "Manage Custom Fields", "Manage Projects",
                "Manage Tags", "Manage Plugins", "Manage Global Profiles"});

        List<WebElement> navigationTabs = driver.findElements(By.xpath("//ul[contains(@class, 'nav-tabs')]//a"));
        List<String> actualTabNames = new ArrayList<>();
        for (WebElement navigationTab : navigationTabs) {
            if (!"".equals(navigationTab.getText())) {
                actualTabNames.add(navigationTab.getText());
            }
        }

        assertThat(actualTabNames, containsInAnyOrder(expectedTabNames.toArray(new String[expectedTabNames.size()])));

        driver.findElement(By.className("user-info")).click();
        driver.findElement(By.xpath("//a[contains(text(), 'Logout')]")).click();
        driver.close();
    }
}
