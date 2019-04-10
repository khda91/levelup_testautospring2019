package ru.levelup.selenium.po.fluent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.levelup.selenium.po.fluent.base.BasePage;

public class LoginPage extends BasePage {

    private WebElement username;

    private WebElement password;

    @FindBy(xpath = "//input[@value='Login']")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public HomePage login(final String username, final String password) {
        this.username.sendKeys(username);
        loginButton.click();
        this.password.sendKeys(password);
        loginButton.click();
        return new HomePage(driver);
    }
}
