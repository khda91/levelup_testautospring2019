package ru.levelup.selenium.report;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.apache.commons.lang3.RandomStringUtils;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.levelup.selenium.po.voids.enums.MenuItem;

@Feature("Тест на войд объекты страниц с Allure")
public class SeleniumVoidPageObjectTest extends BaseTest {

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

    @BeforeMethod(alwaysRun = true)
    @Override
    protected void setUpTest() {
        super.setUpTest();
        login("admin", "admin");
    }

    @Test
    @Story("Создание тега")
    @Description("Тест проверяет создание тега в мантис")
    @Issue("id=2") @TmsLink("id=1")
    public void addTagsTest() {
        actionStep.openMenu(MenuItem.MANAGE);
        actionStep.createTagWithNameAndDescription();

        String tagName = RandomStringUtils.randomAlphabetic(10);
        String tagDescription = RandomStringUtils.randomAlphabetic(20);
        actionStep.createTagWithNameAndDescription(tagName, tagDescription);

        assertionsStep.assertThatTagWithNameAdded(tagName);

        modelStep.logout();
    }
}
