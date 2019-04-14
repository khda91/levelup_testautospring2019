package ru.levelup.selenium.report.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class ModelStep extends BaseStep {

    public ModelStep(WebDriver driver) {
        super(driver);
    }

    @Step("Выход пользователя")
    public void logout() {
        manageTabPage.logout();
    }
}
