package ru.levelup.selenium.page.objects;

import org.apache.commons.lang3.RandomStringUtils;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.levelup.selenium.po.voids.HomePage;
import ru.levelup.selenium.po.voids.LoginPage;
import ru.levelup.selenium.po.voids.ManagePage;
import ru.levelup.selenium.po.voids.ManageTabPage;
import ru.levelup.selenium.po.voids.enums.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class    SeleniumVoidPageObjectTest extends BaseTest {

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
//        System.out.println("PATH_TO_TEST_DATA: " + System.getenv());
        super.setUpTest();
        new LoginPage(driver).login("admin", "admin");
        homePage = new HomePage(driver);
        managePage = new ManagePage(driver);
        manageTabPage = new ManageTabPage(driver);
    }

    @Test
    public void addTagsTest() {
        assertThat(homePage.getPageTitle(), equalTo(HomePage.PAGE_TITLE));

        homePage.selectMenu(MenuItem.MANAGE);
        managePage.manageTagsTabClick();
//        manageTabPage.selectMenu("My View");

        String tagName = RandomStringUtils.randomAlphabetic(10);
        String tagDescription = RandomStringUtils.randomAlphabetic(20);
        manageTabPage.setTextTagNameTextField(tagName);
        manageTabPage.setTextTagDescriptionTextField(tagDescription);
        manageTabPage.createTagButtonClick();

        List<WebElement> tagTableNameColumnValues = driver.findElements(By.xpath("//div[@class='table-responsive']//tr//a"));
        List<String> actualNameValues = new ArrayList<>();
        for (WebElement tagTableNameColumnValue : tagTableNameColumnValues) {
            actualNameValues.add(tagTableNameColumnValue.getText());
        }
        assertThat("Tag was not created", actualNameValues, hasItem(tagName));

        manageTabPage.logout();
    }

}
