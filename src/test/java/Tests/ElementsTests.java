package Tests;

import Base.BaseFile;
import Pages.ElementsCard.LinksPage;
import Pages.ElementsCard.RadioButtonPage;
import Pages.HomePage;
import Pages.SidebarPage;
import Pages.ElementsCard.TextBoxPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class ElementsTests extends BaseFile {

    public HomePage homePage;
    public SidebarPage sidebarPage;
    public TextBoxPage textBoxPage;
    public String homepageURL = "https://demoqa.com/";
    public String fullName;
    public String userEmail;
    public String currentAddress;
    public String permanentAddress;
    public RadioButtonPage radioButtonPage;
    public LinksPage linksPage;


    @BeforeClass
    public void setTests() throws InterruptedException {
        Thread.sleep(2000);
        homePage = new HomePage();
        sidebarPage = new SidebarPage();
        textBoxPage = new TextBoxPage();
        fullName = excelReader.getStringData("TextBoxPage", 0, 1);
        userEmail = excelReader.getStringData("TextBoxPage", 1, 1);
        currentAddress = excelReader.getStringData("TextBoxPage", 2, 1);
        permanentAddress = excelReader.getStringData("TextBoxPage", 3, 1);
        radioButtonPage = new RadioButtonPage();
        linksPage = new LinksPage();

    }

    @BeforeMethod()
    public void test1() throws InterruptedException {

        driver.get(homepageURL);
        waiter.until(ExpectedConditions.urlToBe(homepageURL));
        Assert.assertEquals(driver.getCurrentUrl(), homepageURL);
        waiter.until(ExpectedConditions.elementToBeClickable(homePage.elementsCard));
        homePage.elementsCard.click();
    }

    @Test(priority = 20)
    public void elementstest1_textBox() throws InterruptedException {
        sidebarPage.textBoxButton.click();

        insertText(textBoxPage.inputuserFullNameBox, fullName);
        insertText(textBoxPage.inputuserEmailBox, userEmail);
        insertText(textBoxPage.inputuserCurrentAddressBox, currentAddress);
        insertText(textBoxPage.inputuserPermanentAddressBox, permanentAddress);

        scrollintoView(textBoxPage.submitButton);
        textBoxPage.submitButton.click();

        Assert.assertTrue(textBoxPage.outputUserFullNameBox.getText().contains(fullName));
        Assert.assertTrue(textBoxPage.outputUserEmailBox.getText().contains(userEmail));
        Assert.assertTrue(textBoxPage.outputCurrentAddressBox.getText().contains(currentAddress));
        Assert.assertTrue(textBoxPage.outputPermanentAddressBox.getText().contains(permanentAddress));

    }

    @Test(priority = 60)
    public void elementstest2_radioButton() {
        sidebarPage.smallCardsSelector("Radio Button").click();

        Assert.assertFalse(radioButtonPage.yesRadioButton.isSelected());
        Assert.assertEquals(radioButtonPage.numberOfOutputMessages(), 0);

        radioButtonPage.javaSriptClick(radioButtonPage.yesRadioButton);
        Assert.assertTrue(radioButtonPage.yesRadioButton.isSelected());
        Assert.assertEquals(radioButtonPage.outputMessage.getText(), "Yes");

        Assert.assertFalse(radioButtonPage.impressiveRadioButton.isSelected());
        Assert.assertNotEquals(radioButtonPage.outputMessage.getText(), "Impressive");
        radioButtonPage.clickOnRadioButton("Impressive");
        Assert.assertTrue(radioButtonPage.impressiveRadioButton.isSelected());
        Assert.assertEquals(radioButtonPage.outputMessage.getText(), "Impressive");

        Assert.assertFalse(radioButtonPage.noRadioButton.isSelected());
        Assert.assertNotEquals(radioButtonPage.outputMessage.getText(), "No");
        radioButtonPage.clickOnRadioButton("No");
        Assert.assertTrue(radioButtonPage.noRadioButton.isSelected());
        Assert.assertEquals(radioButtonPage.outputMessage.getText(), "No");
    }

    @Test(priority = 40)
    public void elements3_links() throws InterruptedException {
        String createdStatus = "Created";
        String noContentStatus = "No Content";
        String movedStatus = "Moved Permanently";
        String badRequestStatus = "Bad Request";
        String unauthorizedStatus = "Unauthorized";
        String forbiddenStatus = "Forbidden";
        String notFoundStatus = "Not Found";

        scrollintoView(sidebarPage.smallCardsSelector("Links"));
        sidebarPage.smallCardsSelector("Links").click();

        linksPage.createdAPIcalllink.click();
        waiter.until(ExpectedConditions.visibilityOfElementLocated(By.id("linkResponse")));
        waiter.until(ExpectedConditions.textToBePresentInElement(linksPage.linkResponseBox, createdStatus));
        scrollintoView(linksPage.linkResponseBox);
        Assert.assertTrue(linksPage.linkResponseBox.getText().contains(createdStatus));

        linksPage.noContentAPIcalllink.click();
        waiter.until(ExpectedConditions.textToBePresentInElement(linksPage.linkResponseBox, noContentStatus));
        Assert.assertTrue(linksPage.linkResponseBox.getText().contains(noContentStatus));

        linksPage.movedAPIcalllink.click();
        waiter.until(ExpectedConditions.textToBePresentInElement(linksPage.linkResponseBox, movedStatus));
        Assert.assertTrue(linksPage.linkResponseBox.getText().contains(movedStatus));

        linksPage.badRequestAPIcalllink.click();
        waiter.until(ExpectedConditions.textToBePresentInElement(linksPage.linkResponseBox, badRequestStatus));
        Assert.assertTrue(linksPage.linkResponseBox.getText().contains(badRequestStatus));

        linksPage.unauthorizedAPIcall.click();
        waiter.until(ExpectedConditions.textToBePresentInElement(linksPage.linkResponseBox, unauthorizedStatus));
        Assert.assertTrue(linksPage.linkResponseBox.getText().contains(unauthorizedStatus));

        linksPage.forbiddenAPIcall.click();
        waiter.until(ExpectedConditions.textToBePresentInElement(linksPage.linkResponseBox, forbiddenStatus));
        Assert.assertTrue(linksPage.linkResponseBox.getText().contains(forbiddenStatus));

        linksPage.notFoundAPIcall.click();
        waiter.until(ExpectedConditions.textToBePresentInElement(linksPage.linkResponseBox, notFoundStatus));
        Assert.assertTrue(linksPage.linkResponseBox.getText().contains(notFoundStatus));
    }
        @Test(priority = 50)
        public void elements4_links2 () {
            scrollintoView(sidebarPage.smallCardsSelector("Links"));
            sidebarPage.smallCardsSelector("Links").click();

            String firstlinkURL = linksPage.simpleLink.getAttribute("href");
            String secondlinkURL = linksPage.dynamicLink.getAttribute("href");
            linksPage.simpleLink.click();
            linksPage.dynamicLink.click();
            ArrayList<String> listaTabova = new ArrayList<>(driver.getWindowHandles());
//            for (int i = 0; i < listaTabova.size(); i++) {
//                System.out.println(listaTabova.get(i));
//            }

            driver.switchTo().window(listaTabova.get(1));
            Assert.assertEquals(driver.getCurrentUrl(),firstlinkURL);
            Assert.assertTrue(homePage.headerImage.isDisplayed());

            driver.switchTo().window(listaTabova.get(2));
            Assert.assertEquals(driver.getCurrentUrl(),secondlinkURL);
            Assert.assertTrue(homePage.headerImage.isDisplayed());
        }
    }
