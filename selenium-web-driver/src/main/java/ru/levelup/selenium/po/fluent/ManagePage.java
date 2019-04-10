package ru.levelup.selenium.po.fluent;

import org.openqa.selenium.WebDriver;
import ru.levelup.selenium.po.fluent.base.BasePage;
import ru.levelup.selenium.po.fluent.elements.TabMenuElement;

public class ManagePage extends BasePage {

    private TabMenuElement tabMenu;

    public ManagePage(WebDriver driver) {
        super(driver);
        tabMenu = new TabMenuElement(driver);
    }

    public void manageTagsTabClick() {
        tabMenu.clickTabByName("Manage Tags");
    }
}
