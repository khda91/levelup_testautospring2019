package ru.levelup.selenium.po.voids;

import org.openqa.selenium.WebDriver;
import ru.levelup.selenium.po.voids.base.BasePage;
import ru.levelup.selenium.po.voids.elements.TabMenuElement;

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
