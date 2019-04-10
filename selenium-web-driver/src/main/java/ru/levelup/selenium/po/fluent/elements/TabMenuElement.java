package ru.levelup.selenium.po.fluent.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.levelup.selenium.po.fluent.base.BaseWebComponent;

import java.util.List;

public class TabMenuElement extends BaseWebComponent {

    @FindBy(xpath = "//ul[contains(@class, 'nav-tabs')]//a")
    private List<WebElement> tabItems;

    public TabMenuElement(WebDriver driver) {
        super(driver);
    }

    public void clickTabByName(String tabName) {
        for (WebElement tabItem : tabItems) {
            if (tabItem.getText().trim().equals(tabName)) {
                tabItem.click();
                break;
            }
        }
    }
}
