package test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.*;

import java.util.concurrent.TimeUnit;

public class AppTest extends BaseTest {

    @Test
    public void testAlerts_iFrames_Popups_Dropdowns() throws InterruptedException {
        FramesAndWindowsPage framesAndWindowsPage = getFramesAndWindowsPage();
        // 1. Click on the “Open new tab” tab.
        framesAndWindowsPage.clickOnItemNewTab();
        // 2. Click the blue “Click Here” button to open the new tab.
        framesAndWindowsPage.clickOnClickHere();
        //3. Switch to the just opened new tab and click on the Iframe tab.
        framesAndWindowsPage.changeToNewTabOrWindow();
        TrainingiFramePage trainingiFramePage = framesAndWindowsPage.clickOnIframeTab();
        // 4. On the “Trainings” dropdown, inside the iframe, select software testing.
        trainingiFramePage.enterInTheiFrame();
        Thread.sleep(4000);
        trainingiFramePage.selectSoftwareTestingDropdown();
        // 5. Click on the “Manual testing” training.
        ManualTestingiFramePage manualTestingiFramePage = trainingiFramePage.clickOnManualTestingImg();
        // 6. Check with the required assertions, the manual testing
        // training page is correctly displayed.
        softAssert.assertEquals(manualTestingiFramePage.getTitleIFrame(),"Manual Testing Training","El titulo no concuerda con 'Manual Testing Training.");
        softAssert.assertTrue(manualTestingiFramePage.isTrainingPageCorrectlyDisplayed(),"The manual testing training is not correctly displayed.");
        framesAndWindowsPage.returnToDefaultPage();
        //softAssert.assertEquals(framesAndWindowsPage.getInteractionText(),"INTERACTION","It´s not the 'Miscellaneous' section.");
        /*DropDownMenuPage dropDownMenuPage = framesAndWindowsPage.clickOnDropDownMenu();

        dropDownMenuPage.chooseCountryVisibleText("Argentina");
        Thread.sleep(2000);
        dropDownMenuPage.chooseCountryByValue("PER");
        Thread.sleep(2000);
        dropDownMenuPage.chooseCountryByIndex(20);*/
        // 7. On the right sidebar, on the “Miscellaneous” Section,
        // click on the “AlertBox” link.

        //AlertBoxPage alertBoxPage = dropDownMenuPage.clickOnAlertBox();
        AlertBoxPage alertBoxPage = framesAndWindowsPage.clickOnAlertBox();

        //alertBoxPage.clickOnBtnTryIt();
        // 8. Close the current tab and switch to the initial tab on the browser
        closeAndSwitchToInitialTab();

        // 9. Navigate to https://demo.automationtesting.in/Alerts.html webpage.
        AutomationDemoSitePage automationDemoSitePage = getAutomationDemoSitePage();
        // 10. Click the “Alert with OK & Cancel” tab.
        automationDemoSitePage.clickOnAlertBox();

        automationDemoSitePage.clickOnBtnConfirmBox();
        // 11. Click on the button to display the confirm box.
        Alert alerta = changeToAlert();

        /*confirmAlert(alerta);
        switchBackToNormalPage();

        automationDemoSitePage.clickOnBtnConfirmBox();
        */
        // 12. Click on the Cancel button on the Alert box.
        //Alert alerta2 = changeToAlert();

        dismissAlert(alerta);

        switchBackToNormalPage();

        // 13. Assert the “You Pressed Cancel” Text is displayed below the button.
        softAssert.assertEquals(automationDemoSitePage.getCancelAlertText(),"You Pressed Cancel","You have not pressed the cancel button.");

    }
}
