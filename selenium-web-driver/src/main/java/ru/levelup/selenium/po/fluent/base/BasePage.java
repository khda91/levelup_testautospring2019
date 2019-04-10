package ru.levelup.selenium.po.fluent.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.levelup.selenium.po.fluent.enums.MenuItem;

import java.util.List;

public abstract class BasePage extends BaseWebComponent {

    @FindBy(xpath = "//div[@id='sidebar']//a")
    private List<WebElement> leftSideMenu;

    protected BasePage(WebDriver driver) {
        super(driver);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public void logout() {
        driver.findElement(By.className("user-info")).click();
        driver.findElement(By.partialLinkText("Logout")).click();
    }

    public void selectMenu(String menuName) {
        for (WebElement menuItem : leftSideMenu) {
            if (menuItem.getText().trim().equals(menuName)) {
                menuItem.click();
                break;
            }
        }
    }

    public void selectMenu(MenuItem menuName) {
        for (WebElement menuItem : leftSideMenu) {
            if (menuItem.getText().trim().equals(menuName.getValue())) {
                menuItem.click();
                break;
            }
        }
    }
}
