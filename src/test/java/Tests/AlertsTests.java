package Tests;

import Base.BaseFile;

import Pages.AlertsCard.AlertsPage;
import Pages.HomePage;
import Pages.SidebarPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertsTests extends BaseFile {
    public HomePage homePage;
    public SidebarPage sidebarPage;
    public AlertsPage alertsPage;

    @BeforeClass
    public void setTests() throws InterruptedException {
        homePage = new HomePage();
        sidebarPage = new SidebarPage();
        alertsPage = new AlertsPage();
    }

    @BeforeMethod
    public void preparation() {
        homePage.goToHomePage();
        homePage.alertsCard.click();
        scrollintoView(sidebarPage.smallCardsSelector("Alerts"));
        sidebarPage.smallCardsSelector("Alerts").click();
    }

    @Test(priority = 10)
    public void alerts1_regularButton() {

        String regularAlertText = "You clicked a button";

        Assert.assertFalse(alertsPage.isAlertPresent());

        alertsPage.regularAlertButton.click();

        Assert.assertTrue(alertsPage.isAlertPresent());
        Assert.assertEquals(driver.switchTo().alert().getText(), regularAlertText);
        driver.switchTo().alert().accept();

        Assert.assertFalse(alertsPage.isAlertPresent());
    }

    @Test(priority = 20)
    public void alerts2_delayedAlert() {
        String textOfDelayedAlert = "This alert appeared after 5 seconds";
        scrollintoView(alertsPage.delayedAlertButton);
        waitForClickability(alertsPage.delayedAlertButton);
        alertsPage.delayedAlertButton.click();
        scrollToTheTop();

        waiter.until(ExpectedConditions.alertIsPresent());
        System.out.println(driver.switchTo().alert().getText());
        Assert.assertTrue(alertsPage.isAlertPresent());
        Assert.assertEquals(driver.switchTo().alert().getText(), textOfDelayedAlert);
        driver.switchTo().alert().accept();
    }

    @Test(priority = 30)
    public void alerts3_confirmAlert() throws InterruptedException {
        String textOfConfirmAlert = "Do you confirm action?";

        scrollintoView(alertsPage.confirmAlertButton);
        waitForClickability(alertsPage.confirmAlertButton);
        alertsPage.confirmAlertButton.click();

        waiter.until(ExpectedConditions.alertIsPresent());
        Assert.assertTrue(alertsPage.isAlertPresent());
        Assert.assertEquals(driver.switchTo().alert().getText(), textOfConfirmAlert);
        driver.switchTo().alert().accept();

        String textafterOKButton = "You selected Ok";
        Assert.assertEquals(alertsPage.outputBoxOfConfirmButton.getText(), textafterOKButton);


        /* Test Case 2 */
        Thread.sleep(2000);
        scrollintoView(alertsPage.confirmAlertButton);
        waitForClickability(alertsPage.confirmAlertButton);
        alertsPage.confirmAlertButton.click();


        waiter.until(ExpectedConditions.alertIsPresent());
        System.out.println(driver.switchTo().alert().getText());
        Assert.assertTrue(alertsPage.isAlertPresent());
        Assert.assertEquals(driver.switchTo().alert().getText(), textOfConfirmAlert);
        driver.switchTo().alert().dismiss();

        String textAfterCancelButton = "You selected Cancel";
        Assert.assertEquals(alertsPage.outputBoxOfConfirmButton.getText(), textAfterCancelButton);
    }

    @Test(priority = 50)
    public void alerts4_promptBox() throws InterruptedException {
        String textOfPrompt = "Please enter your name";
        String inputOfPrompt="Vladimir";

        Assert.assertFalse(alertsPage.isAlertPresent());

        scrollintoView(alertsPage.promptButton);
        waitForClickability(alertsPage.promptButton);
        alertsPage.promptButton.click();


        Assert.assertTrue(alertsPage.isAlertPresent());
        Assert.assertEquals(driver.switchTo().alert().getText(),textOfPrompt);

        driver.switchTo().alert().sendKeys(inputOfPrompt);
        driver.switchTo().alert().accept();

        Assert.assertTrue(alertsPage.outputBoxPrompt.getText().contains(inputOfPrompt));

        /* Test case 2 */
        Assert.assertFalse(alertsPage.isAlertPresent());

        scrollintoView(alertsPage.promptButton);
        alertsPage.promptButton.click();

        Assert.assertTrue(alertsPage.isAlertPresent());
        Assert.assertEquals(driver.switchTo().alert().getText(),textOfPrompt);

        driver.switchTo().alert().sendKeys(inputOfPrompt);
        driver.switchTo().alert().dismiss();

        Assert.assertFalse(elementIsPresent(alertsPage.outputBoxPrompt));

    }


}
