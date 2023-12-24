package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertBoxPage extends BasePage{

    @FindBy(xpath="//*[@id=\"post-2611\"]/div[2]/div/div/div[1]/p[2]/button")
    private WebElement btnTryIt;
    public AlertBoxPage(WebDriver driver){
        super(driver);
    }

    public void clickOnBtnTryIt()
    {
        this.btnTryIt.click();
    }
}
