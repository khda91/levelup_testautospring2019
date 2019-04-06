package ru.levelup.selenium.base;

import org.apache.commons.lang3.RandomStringUtils;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class SeleniumTest extends BaseTest {

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

    @Test
    public void addTagsTest() {
//      4. Открыть пункт меню "Manage"
        driver.findElement(By.partialLinkText("Manage")).click();

//      5. Выбрать вклатку "Manage Tags"
        driver.findElement(By.linkText("Manage Tags")).click();

//      6. Создать произвольный тег
        String tagName = RandomStringUtils.randomAlphabetic(10);
        driver.findElement(By.id("tag-name")).sendKeys(tagName);
        driver.findElement(By.name("config_set")).click();

        // 7. Проверить, что тег добавлен
        List<WebElement> tagTableNameColumnValues = driver.findElements(By.xpath("//div[@class='table-responsive']//tr//a"));
        List<String> actualNameValues = new ArrayList<>();
        for (WebElement tagTableNameColumnValue : tagTableNameColumnValues) {
            actualNameValues.add(tagTableNameColumnValue.getText());
        }
        assertThat("Tag was not created", actualNameValues, hasItem(tagName));

//     8. Выйти из учётной записи
        driver.findElement(By.className("user-info")).click();
        driver.findElement(By.partialLinkText("Logout")).click();
    }

}
