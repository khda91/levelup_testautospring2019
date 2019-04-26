package ru.levelup.selenide;

import com.codeborne.selenide.Browser;
import com.codeborne.selenide.Browsers;
import static com.codeborne.selenide.Condition.text;
import com.codeborne.selenide.Configuration;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import org.junit.Before;
import org.junit.Test;

public class Example {

    @Before
    public void init() {
        Configuration.browser = Browsers.FIREFOX;
        Configuration.timeout = 5000;
        Configuration.pollingInterval = 600;
    }
    @Test
    public void loginMantisTest() {
        open("mantisbt/");
        $("#username").sendKeys("admin");
        $(".btn-success").click();
        $("#password").sendKeys("admin");
        $(".btn-success").click();
        $(".breadcrumb").shouldHave(text("admin ( admin ) administrator"));
    }

    @Test
    public void loginPageObjectMantisTest() {
        LoginPage loginPage = open("http://khda91.fvds.ru/mantisbt/", LoginPage.class);
        loginPage.login("admin", "admin");
        $(".breadcrumb").shouldHave(text("admin ( admin ) administrator"));
    }

    @Test
    public void loginPageObjectWithoutPageFactoryMantisTest() {
        open("http://khda91.fvds.ru/mantisbt/");
        LoginPageWOPF loginPage = new LoginPageWOPF();
        loginPage.login("admin", "admin");
        $(".breadcrumb").shouldHave(text("admin ( admin ) administrator"));
    }
}
