package ru.levelup.test.auto.sample;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class SampleTest {

    @Test
    public void loginTest() {
        // Init driver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // Open page
        driver.get("https://epam.github.io/JDI/index.html");

        // check title
        assertEquals("Home Page", driver.getTitle());

        // click user icon
        driver.findElement(By.id("user-icon")).click();

        // login
        WebElement userNameTextField = driver.findElement(By.cssSelector("#name"));
        userNameTextField.sendKeys("epam");
        WebElement passwordTextField = driver.findElement(By.xpath("//input[@id='password']"));
        passwordTextField.sendKeys("1234");
        WebElement enterButton = driver.findElement(By.id("login-button"));
        enterButton.click();

        // Check user name
        assertEquals("Piter Chailovskii".toUpperCase(), driver.findElement(By.id("user-name")).getText());

        // close browser
        driver.close();
    }


    //*[@id="wd-_stream_now"]//span[@class='streamnow__item-title']
    //*[@id="wd-_stream_now"]//ul[contains(@class,'streamnow__items')]//span[@class='streamnow__item-title']

}
