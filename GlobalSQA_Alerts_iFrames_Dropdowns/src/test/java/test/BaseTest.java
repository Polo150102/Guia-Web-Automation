package test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;
import pages.AutomationDemoSitePage;
import pages.FramesAndWindowsPage;

import java.util.Iterator;
import java.util.Set;

// You are automating the  https://www.globalsqa.com/demo-site/frames-and-windows/ web application.
//
// Create a new Selenium - Java - TestNG project,
// and configure it to launch and test the required webpage on Chrome browser.
// Implement on your framework the following process, using page objects as needed.
//
// 1. Click on the “Open new tab” tab.
// 2. Click the blue “Click Here” button to open the new tab.
// 3. Switch to the just opened new tab and click on the Iframe tab.
// 4. On the “Trainings” dropdown, inside the iframe, select software testing.
// 5. Click on the “Manual testing” training.
// 6. Check with the required assertions, the manual testing
//    training page is correctly displayed.
// 7. On the right sidebar, on the “Miscellaneous” Section,
//    click on the “AlertBox” link.
// 8. Close the current tab and switch to the initial tab on the browser.
// 9. Navigate to https://demo.automationtesting.in/Alerts.html webpage.
// 10. Click the “Alert with OK & Cancel” tab.
// 11. Click on the button to display the confirm box.
// 12. Click on the Cancel button on the Alert box.
// 13. Assert the “You Pressed Cancel” Text is displayed below the button.
public class BaseTest {

    WebDriver driver = null;

    SoftAssert softAssert = null;

    @BeforeTest
    public void beforeTest()
    {
        String driverPath = "/Users/aleja/OneDrive/Documents/Globant-Curso/Guia_WebAutomation/GlobalSQA_Alerts_iFrames_Dropdowns/src/utils/chromedriver.exe";

        System.setProperty("webdriver.chrome.driver", driverPath);

        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver();
        softAssert = new SoftAssert();
    }

    @AfterTest
    public void afterTest()
    {
        softAssert.assertAll();
        //driver.close();
    }

    public FramesAndWindowsPage getFramesAndWindowsPage()
    {
        return new FramesAndWindowsPage(driver, "https://www.globalsqa.com/demo-site/frames-and-windows/");
    }

    public AutomationDemoSitePage getAutomationDemoSitePage()
    {
        return new AutomationDemoSitePage(driver,"https://demo.automationtesting.in/Alerts.html");
    }

    public void closeAndSwitchToInitialTab() {
        // Get the handles of all open windows/tabs
        Set<String> windowHandles = driver.getWindowHandles();

        // Close the current tab
        driver.close();

        // Switch to the initial tab
        Iterator<String> iterator = windowHandles.iterator();
        String initialTab = iterator.next();
        driver.switchTo().window(initialTab);
    }

    public void switchBackToNormalPage()
    {
        driver.switchTo().defaultContent();
    }

    public Alert changeToAlert()
    {
        Alert alert = driver.switchTo().alert();
        return alert;
    }

    public void confirmAlert(Alert alerta){
        alerta.accept();
    }


    public void dismissAlert(Alert alerta){
        alerta.dismiss();
    }
}
