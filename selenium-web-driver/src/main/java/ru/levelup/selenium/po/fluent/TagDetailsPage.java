package ru.levelup.selenium.po.fluent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.levelup.selenium.po.fluent.base.BasePage;

public class TagDetailsPage extends BasePage {

    @FindBy(xpath = "//input[@value='Update Tag']")
    private WebElement updateTagButton;

    @FindBy(xpath = "//div[@class='table-responsive']//td[contains(text(), 'Name')]/following-sibling::td")
    private WebElement tagNameLabel;

    public TagDetailsPage(WebDriver driver) {
        super(driver);
    }

    public TagUpdatePage clickUpdateTagButton() {
        updateTagButton.click();
        return new TagUpdatePage(driver);
    }

    public String getTagNameLabelText() {
        return tagNameLabel.getText().trim();
    }
}
