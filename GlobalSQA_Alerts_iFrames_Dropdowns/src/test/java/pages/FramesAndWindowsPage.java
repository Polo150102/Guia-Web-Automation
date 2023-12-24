package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class FramesAndWindowsPage extends BasePage{

    @FindBy(css="#Open\\ New\\ Window")
    private WebElement itemNewTab;

    @FindBy(css="#post-2632 > div.twelve.columns > div > div > div.single_tab_div.resp-tab-content.resp-tab-content-active > a")
    private WebElement clickHere;

    @FindBy(css="#iFrame")
    private WebElement iFramebtn;

    @FindBy(css="#nav_menu-6 > h4 > span")
    private WebElement interactionText;

    @FindBy(css="#menu-item-2803 > a > span.link_span")
    private WebElement dropDownOption;

    @FindBy(xpath="//*[@id=\"menu-item-2816\"]/a/span[2]")
    private WebElement alertBoxItem;

    public FramesAndWindowsPage(WebDriver driver, String url){
        super(driver);
        this.driver.get(url);
    }

    public void clickOnItemNewTab()
    {
        isElementClickable(this.clickHere);
        this.itemNewTab.click();
    }

    public void clickOnClickHere(){
        isElementClickable(this.clickHere);
        this.clickHere.click();
    }

    public void changeToNewTabOrWindow()
    {
        changeWindowTab();
    }

    public void returnToDefaultPage()
    {
        switchBackToNormalPage();
    }

    public TrainingiFramePage clickOnIframeTab()
    {
        isElementClickable(this.iFramebtn);
        this.iFramebtn.click();

        return new TrainingiFramePage(this.driver);
    }

    public String getInteractionText()
    {
        isElementDisplayed(this.interactionText);
        return this.interactionText.getText();
    }

    public DropDownMenuPage clickOnDropDownMenu()
    {
        isElementDisplayed(this.dropDownOption);
        this.dropDownOption.click();

        return new DropDownMenuPage(this.driver);
    }

    public AlertBoxPage clickOnAlertBox()
    {
        isElementDisplayed(this.alertBoxItem);
        this.alertBoxItem.click();

        return new AlertBoxPage(this.driver);
    }

}
