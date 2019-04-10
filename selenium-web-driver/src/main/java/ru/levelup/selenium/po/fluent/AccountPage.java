package ru.levelup.selenium.po.fluent;

import org.openqa.selenium.WebDriver;
import ru.levelup.selenium.po.fluent.base.BasePage;
import ru.levelup.selenium.po.fluent.elements.TabMenuElement;
import static ru.levelup.selenium.po.voids.AccountPage.TabMenuItem.API_TOKENS;

public class AccountPage extends BasePage {

    private TabMenuElement tabMenu;

    public AccountPage(WebDriver driver) {
        super(driver);
        tabMenu = new TabMenuElement(driver);
    }

    public void apiTokenTabClick() {
        tabMenu.clickTabByName(API_TOKENS.getValue());
    }

    public static enum TabMenuItem {
        MY_ACCOUNT("My Account"),
        PREFERENCES("Preferences"),
        API_TOKENS("API Tokens");

        private String value;

        TabMenuItem(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

}
