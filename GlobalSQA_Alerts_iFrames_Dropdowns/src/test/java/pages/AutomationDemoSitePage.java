package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AutomationDemoSitePage extends BasePage{

    @FindBy(css="body > div.container.center > div > div > div > div.tabpane.pullleft > ul > li:nth-child(2) > a")
    private WebElement optionAlertOkAndCancel;

    @FindBy(css="#CancelTab > button")
    private WebElement btnConfirmBox;

    @FindBy(css="#demo")
    private WebElement cancelAlertText;
    public AutomationDemoSitePage(WebDriver driver, String url){
        super(driver);
        this.driver.get(url);
    }

    public void clickOnAlertBox(){
        isElementClickable(this.optionAlertOkAndCancel);
        this.optionAlertOkAndCancel.click();
    }

    public void clickOnBtnConfirmBox()
    {
        isElementClickable(this.btnConfirmBox);
        this.btnConfirmBox.click();
    }

    public String getCancelAlertText()
    {
        isElementDisplayed(this.cancelAlertText);
        return this.cancelAlertText.getText();
    }

}
