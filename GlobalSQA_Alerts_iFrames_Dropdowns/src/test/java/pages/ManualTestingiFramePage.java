package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ManualTestingiFramePage extends BasePage {

    @FindBy(xpath="//div[@class='page_heading']/h1[contains(text(),'Manual Testing')]")
    private WebElement titleIFrame;


    public ManualTestingiFramePage(WebDriver driver){
        super(driver);
    }

    public String getTitleIFrame()
    {
        isElementDisplayed(this.titleIFrame);
        return this.titleIFrame.getText();
    }

    public Boolean isTrainingPageCorrectlyDisplayed()
    {
        isElementDisplayed(this.titleIFrame);
        return this.titleIFrame.isDisplayed();
    }

}
