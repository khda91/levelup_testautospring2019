package ru.levelup.selenium.po.voids;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.levelup.selenium.po.voids.base.BasePage;

public class LoginPage extends BasePage {

//    @FindBy(id = "username")
//    private WebElement usernameTextField;
    private WebElement username;

//    @FindBy(id = "password")
//    private WebElement passwordTextField;
    private WebElement password;

    @FindBy(xpath = "//input[@value='Login']")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(final String username, final String password) {
        // 2. Авторизоваться admin:admin
//        usernameTextField.sendKeys(username);
        this.username.sendKeys(username);
        loginButton.click();
//        passwordTextField.sendKeys(password);
        this.password.sendKeys(password);
        loginButton.click();
    }
}
