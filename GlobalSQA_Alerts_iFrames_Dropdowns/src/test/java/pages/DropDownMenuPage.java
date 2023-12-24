package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class DropDownMenuPage extends BasePage {

    @FindBy(css="#post-2646 > div.twelve.columns > div > div > div > p > select")
    private WebElement dropDownCountry;

    @FindBy(css="#menu-item-2816 > a > span.link_span")
    private WebElement alertBoxItem;

    public DropDownMenuPage(WebDriver driver){
        super(driver);
    }

    public void chooseCountryVisibleText(String nameCountry){
        Select selectCountry = initaliazeSelectDropdown(this.dropDownCountry);
        selectCountry.selectByVisibleText(nameCountry);
    }

    public void chooseCountryByValue(String valueCountry){
        Select selectCountry = initaliazeSelectDropdown(this.dropDownCountry);
        selectCountry.selectByValue(valueCountry);
    }
    public void chooseCountryByIndex(int numberCountry){
        Select selectCountry = initaliazeSelectDropdown(this.dropDownCountry);
        selectCountry.selectByIndex(numberCountry);
    }

    public AlertBoxPage clickOnAlertBox()
    {
        isElementClickable(this.alertBoxItem);
        this.alertBoxItem.click();

        return new AlertBoxPage(this.driver);
    }
}
