package ru.levelup.selenium.po.voids;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.levelup.selenium.po.voids.base.BasePage;
import ru.levelup.selenium.po.voids.elements.ButtonsGroup;

public class ManageTabPage extends BasePage {

    @FindBy(id = "tag-name")
    private WebElement tagNameTextField;

    @FindBy(id = "tag-description")
    private WebElement tagDescriptionTextField;

    @FindBy(name = "config_set")
    private WebElement createTagButton;

    private ButtonsGroup buttonsGroup;

    public ManageTabPage(WebDriver driver) {
        super(driver);
        buttonsGroup =  new ButtonsGroup(driver);
    }

    public void setTextTagNameTextField(String tagName) {
        tagNameTextField.sendKeys(tagName);
    }

    public void setTextTagDescriptionTextField(String description) {
        tagDescriptionTextField.sendKeys(description);
    }

    public void createTagButtonClick() {
        createTagButton.click();
    }
}
