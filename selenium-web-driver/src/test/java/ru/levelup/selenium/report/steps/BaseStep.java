package ru.levelup.selenium.report.steps;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import ru.levelup.selenium.po.voids.HomePage;
import ru.levelup.selenium.po.voids.ManagePage;
import ru.levelup.selenium.po.voids.ManageTabPage;

public abstract class BaseStep {

    protected WebDriver driver;

    protected HomePage homePage;
    protected ManagePage managePage;
    protected ManageTabPage manageTabPage;

    protected BaseStep(WebDriver driver) {
        this.driver = driver;
        homePage = new HomePage(driver);
        managePage = new ManagePage(driver);
        manageTabPage = new ManageTabPage(driver);
    }

    @Attachment(value = "screenshot", type = "image/png", fileExtension = ".png")
    public byte[] attachScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "{0}", type = "text/html", fileExtension = ".html")
    public String attachSourceCode(String name) {
        return driver.getPageSource();
    }
}
