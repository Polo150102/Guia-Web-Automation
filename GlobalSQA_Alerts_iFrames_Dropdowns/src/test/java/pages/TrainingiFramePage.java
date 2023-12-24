package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.swing.plaf.TableHeaderUI;

public class TrainingiFramePage extends BasePage {


    @FindBy(css="#post-2632 > div.twelve.columns > div > div > div.single_tab_div.resp-tab-content.resp-tab-content-active > p > iframe")
    private WebElement iFrameWindow;

    //Select myDropdown = new Select(driver.findElement(by.id(element));
    @FindBy(css="#current_filter")
    private WebElement dropDownTrainings;

    @FindBy(css="#filter_list [data-option-value='.softwaretesting']")
    private WebElement optionSoftwareTesting;

    @FindBy(css="#portfolio_items > div:nth-child(4) > a > div > div > div.pic_holder > img")
    private WebElement manualTestingImg;

    public TrainingiFramePage(WebDriver driver){
        super(driver);
    }

    public void enterInTheiFrame()
    {
        switchiFrame(iFrameWindow);
    }

    public void selectSoftwareTestingDropdown()
    {
        isElementClickable(this.dropDownTrainings);
        //Select selectDropDownTraining = initaliazeSelectDropdown(this.dropDownTrainings);
        this.dropDownTrainings.click();
        isElementDisplayed(this.optionSoftwareTesting);
        this.optionSoftwareTesting.click();
    }

    public ManualTestingiFramePage clickOnManualTestingImg(){
        isElementDisplayed(this.manualTestingImg);
        this.manualTestingImg.click();

        return new ManualTestingiFramePage(this.driver);
    }

}
