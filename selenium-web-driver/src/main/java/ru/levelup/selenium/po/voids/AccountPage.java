package ru.levelup.selenium.po.voids;

import org.openqa.selenium.WebDriver;
import static ru.levelup.selenium.po.voids.AccountPage.TabMenuItem.API_TOKENS;
import ru.levelup.selenium.po.voids.base.BasePage;
import ru.levelup.selenium.po.voids.elements.TabMenuElement;

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
