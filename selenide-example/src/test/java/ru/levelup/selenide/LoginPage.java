package ru.levelup.selenide;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    @FindBy(id = "username")
    private SelenideElement usernameTextField;

    @FindBy(id = "password")
    private SelenideElement passwordTextField;

    @FindBy(css = ".btn-success")
    private SelenideElement loginButton;

    public void login(final String username, final String password) {
        usernameTextField.sendKeys("admin");
        loginButton.click();
        passwordTextField.sendKeys("admin");
        loginButton.click();
    }
}
