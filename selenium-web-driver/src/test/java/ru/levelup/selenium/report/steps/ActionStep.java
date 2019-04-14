package ru.levelup.selenium.report.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import ru.levelup.selenium.po.voids.enums.MenuItem;

public class ActionStep extends BaseStep {

    public ActionStep(WebDriver driver) {
        super(driver);
    }

    @Step("Открыть пункт меню '{0}'")
    public void openMenu(MenuItem menu) {
        homePage.selectMenu(menu);
    }

    @Step("Выбрать вклатку \"Manage Tags\"")
    public void createTagWithNameAndDescription() {
        managePage.manageTagsTabClick();
    }

    @Step("Создать тег c именем: '{0}' и описанием '{1}'")
    public void createTagWithNameAndDescription(final String name, final String description) {
        manageTabPage.setTextTagNameTextField(name);
        manageTabPage.setTextTagDescriptionTextField(description);
        manageTabPage.createTagButtonClick();
        attachSourceCode("Manage Tab Page Source Code");
    }

}
