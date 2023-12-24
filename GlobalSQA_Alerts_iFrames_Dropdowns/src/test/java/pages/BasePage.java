package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class BasePage {
    WebDriver driver;
    WebDriverWait explicitWait;

    public BasePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    //Using a change of Pop-ups
    protected void changeWindowTab()
    {
        Set<String> window_handles = driver.getWindowHandles();
        // Switch to the new tab
        for(String element_window : window_handles)
        {
            driver.switchTo().window(element_window);
        }
    }

    protected void isElementDisplayed(WebElement element)
    {
        explicitWait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void isElementClickable(WebElement element)
    {
        explicitWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void switchiFrame(WebElement element)
    {
        driver.switchTo().frame(element);
    }

    protected void switchBackToNormalPage()
    {
        driver.switchTo().defaultContent();
    }

    protected Select initaliazeSelectDropdown(WebElement element)
    {
        return new Select(element);
    }



}
