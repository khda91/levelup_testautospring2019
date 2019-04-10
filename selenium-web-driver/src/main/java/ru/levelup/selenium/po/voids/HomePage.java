package ru.levelup.selenium.po.voids;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.levelup.selenium.po.voids.base.BasePage;

public class HomePage extends BasePage {

    public static final String PAGE_TITLE = "My View - MantisBT";

    public HomePage(WebDriver driver) {
        super(driver);
    }
}
