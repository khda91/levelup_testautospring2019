package ru.levelup.selenium.po.fluent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.levelup.selenium.po.fluent.base.BasePage;
import ru.levelup.selenium.po.fluent.elements.ButtonsGroup;

import java.util.ArrayList;
import java.util.List;

public class ManageTabPage extends BasePage {

    @FindBy(id = "tag-name")
    private WebElement tagNameTextField;

    @FindBy(id = "tag-description")
    private WebElement tagDescriptionTextField;

    @FindBy(name = "config_set")
    private WebElement createTagButton;

    @FindBy(xpath = "//div[@class='table-responsive']//tr//a")
    private List<WebElement> tagNamesColumn;

    private ButtonsGroup buttonsGroup;

    public ManageTabPage(WebDriver driver) {
        super(driver);
        buttonsGroup =  new ButtonsGroup(driver);
    }

    public ManageTabPage setTextTagNameTextField(String tagName) {
        tagNameTextField.sendKeys(tagName);
        return this;
    }

    public ManageTabPage setTextTagDescriptionTextField(String description) {
        tagDescriptionTextField.sendKeys(description);
        return this;
    }

    public ManageTabPage createTagButtonClick() {
        createTagButton.click();
        return this;
    }

    public TagDetailsPage clickTagLinkByName(String tagName) {
        for (WebElement webElement : tagNamesColumn) {
            if (webElement.getText().trim().equals(tagName)) {
                webElement.click();
                return new TagDetailsPage(driver);
            }
        }
        throw new IllegalStateException("Unable to find tag with name " + tagName);
    }

    public List<String> getTagNames() {
        List<String> tagNames = new ArrayList<>();
        for (WebElement tagName : tagNamesColumn) {
            tagNames.add(tagName.getText().trim());
        }
        return tagNames;
    }
}
