package ru.levelup.selenide;

import static com.codeborne.selenide.Selenide.$;
import com.codeborne.selenide.SelenideElement;

// Without page factory
public class LoginPageWOPF {

    private SelenideElement usernameTextField;
    private SelenideElement passwordTextField;
    private SelenideElement loginButton;

    public LoginPageWOPF() {
        usernameTextField = $("#username");
        passwordTextField = $("#password");
        loginButton = $(".btn-success");
    }

    public void login(final String username, final String password) {
        usernameTextField.sendKeys("admin");
        loginButton.click();
        passwordTextField.sendKeys("admin");
        loginButton.click();
    }
}
