package ru.levelup.selenium.po.fluent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.levelup.selenium.po.fluent.base.BasePage;

public class TagUpdatePage extends BasePage {

    @FindBy(id = "tag-name")
    private WebElement tagNameTextField;

    @FindBy(xpath = "//input[@value='Update Tag']")
    private WebElement updateTagButton;

    public TagUpdatePage(WebDriver driver) {
        super(driver);
    }

    public TagUpdatePage setTextTagNameTextField(String tagName) {
        tagNameTextField.clear();
        tagNameTextField.sendKeys(tagName);
        return this;
    }

    public TagDetailsPage clickUpdateTagButton() {
        updateTagButton.click();
        return new TagDetailsPage(driver);
    }
}
