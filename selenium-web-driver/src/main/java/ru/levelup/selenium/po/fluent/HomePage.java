package ru.levelup.selenium.po.fluent;

import org.openqa.selenium.WebDriver;
import ru.levelup.selenium.po.fluent.base.BasePage;

public class HomePage extends BasePage {

    public static final String PAGE_TITLE = "My View - MantisBT";

    public HomePage(WebDriver driver) {
        super(driver);
    }
}
