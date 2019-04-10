package ru.levelup.selenium.po.fluent.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.levelup.selenium.po.fluent.base.BaseWebComponent;

import java.util.List;

public class ButtonsGroup extends BaseWebComponent {

    @FindBy(xpath = "//div[@class='btn-group']/a")
    private List<WebElement> buttons;

    public ButtonsGroup(WebDriver driver) {
        super(driver);
    }
}
