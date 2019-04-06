package ru.levelup.selenium.po.voids;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private WebDriver driver;

    private WebElement usernameTextField;
    private WebElement passwordTextField;
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        usernameTextField = driver.findElement(By.id("username"));
        loginButton = driver.findElement(By.cssSelector(".btn-success"));
    }

    public void login(final String username, final String password) {
        // 2. Авторизоваться admin:admin
        usernameTextField.sendKeys(username);
        loginButton.click();
        passwordTextField = driver.findElement(By.id("password"));
        passwordTextField.sendKeys(password);
        loginButton = driver.findElement(By.cssSelector(".btn-success"));
        loginButton.click();
    }
}
