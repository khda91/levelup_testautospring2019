package ru.levelup.selenium.page.objects;

import org.apache.commons.lang3.RandomStringUtils;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.levelup.selenium.po.fluent.HomePage;
import ru.levelup.selenium.po.fluent.LoginPage;
import ru.levelup.selenium.po.fluent.ManagePage;
import ru.levelup.selenium.po.fluent.ManageTabPage;
import ru.levelup.selenium.po.fluent.enums.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class SeleniumFluentPageObjectTest extends BaseTest {

    /**
     * 1. Открыть MantisBT: http://khda91.fvds.ru/mantisbt/
     * 2. Авторизоваться admin:admin
     * 3. Проверить, что пользователь авторизован
     * 4. Открыть пункт меню "Manage"
     * 5. Выбрать вклатку "Manage Tags"
     * 6. Создать произвольный тег
     * 7. Проверить, что тег добавлен
     * 8. Выйти из учётной записи
     * 9. Закрыть браузер
     */

    private HomePage homePage;
    private ManagePage managePage;
    private ManageTabPage manageTabPage;

    @BeforeMethod(alwaysRun = true)
    @Override
    protected void setUpTest() {
        super.setUpTest();
        homePage = new LoginPage(driver).login("admin", "admin");
        managePage = new ManagePage(driver);
        manageTabPage = new ManageTabPage(driver);
    }

    @Test
    public void addTagsTest() {
        assertThat(homePage.getPageTitle(), equalTo(HomePage.PAGE_TITLE));

        homePage.selectMenu(MenuItem.MANAGE);
        managePage.manageTagsTabClick();

        String tagName = RandomStringUtils.randomAlphabetic(10);
        String tagDescription = RandomStringUtils.randomAlphabetic(20);
        List<String> actualNameValues = manageTabPage
                .setTextTagNameTextField(tagName)
                .setTextTagDescriptionTextField(tagDescription)
                .createTagButtonClick()
                .getTagNames();

        assertThat("Tag was not created", actualNameValues, hasItem(tagName));

        manageTabPage.logout();
    }

    @Test
    public void updateTagNameTest() {
        assertThat(homePage.getPageTitle(), equalTo(HomePage.PAGE_TITLE));

        homePage.selectMenu(MenuItem.MANAGE);
        managePage.manageTagsTabClick();

        String tagNameNew = RandomStringUtils.randomAlphabetic(10);
        String tagNameUpdate = RandomStringUtils.randomAlphabetic(10);
        String tagDescription = RandomStringUtils.randomAlphabetic(20);

        String actualText = manageTabPage
                .setTextTagNameTextField(tagNameNew)
                .setTextTagDescriptionTextField(tagDescription)
                .createTagButtonClick()
                .clickTagLinkByName(tagNameNew)
                .clickUpdateTagButton()
                .setTextTagNameTextField(tagNameUpdate)
                .clickUpdateTagButton()
                .getTagNameLabelText();

        assertThat(actualText, equalTo(tagNameUpdate));
    }
}
