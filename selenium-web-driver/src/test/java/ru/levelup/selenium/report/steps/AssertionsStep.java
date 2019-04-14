package ru.levelup.selenium.report.steps;

import io.qameta.allure.Step;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class AssertionsStep extends BaseStep {

    public AssertionsStep(WebDriver driver) {
        super(driver);
    }

    @Step("Проверить, что тег с именем {0} добавлен")
    public void assertThatTagWithNameAdded(final String name) {
        List<WebElement> tagTableNameColumnValues = driver.findElements(By.xpath("//div[@class='table-responsive']//tr//a"));
        List<String> actualNameValues = new ArrayList<>();
        for (WebElement tagTableNameColumnValue : tagTableNameColumnValues) {
            actualNameValues.add(tagTableNameColumnValue.getText());
        }
        attachScreenshot();
        assertThat("Tag was not created", actualNameValues, hasItem(name));
    }
}
