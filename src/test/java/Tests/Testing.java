package Tests;

import Base.BaseFile;
import Pages.HomePage;
import Pages.SidebarPage;
import Pages.TextBoxPage;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Testing extends BaseFile {

    public HomePage homePage;
    public SidebarPage sidebarPage;
    public TextBoxPage textBoxPage;
    public String homepageURL = "https://demoqa.com/";
    public static ChromeOptions options;
    public String fullName;
    public String userEmail;
    public String currentAddress;
    public String permanentAddress;


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
    }

    @Test(priority = 10)
    public void test1() throws InterruptedException {

        driver.get(homepageURL);
        waiter.until(ExpectedConditions.urlToBe(homepageURL));
        Assert.assertEquals(driver.getCurrentUrl(), homepageURL);
//        waiter.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div/div[1]"))));

    }

    @Test(priority = 20)
    public void elementstest() throws InterruptedException {
        waiter.until(ExpectedConditions.elementToBeClickable(homePage.elementscard));
        //driver.findElement(By.cssSelector("#app > div > div > div.home-body > div > div:nth-child(1)")).click();
        homePage.elementscard.click();
        //sidebarPage.elementsButton.click();
        sidebarPage.textBoxButton.click();
        ifBottomBannerDisplayedShutIt();
        textBoxPage.inputuserFullNameBox.sendKeys(fullName);
        textBoxPage.inputuserEmailBox.sendKeys(userEmail);
        textBoxPage.inputuserCurrentAddressBox.sendKeys(currentAddress);
        textBoxPage.inputuserPermanentAddressBox.sendKeys(permanentAddress);
        scrollintoView(textBoxPage.submitButton);
        textBoxPage.submitButton.click();
        Assert.assertTrue(textBoxPage.outputUserFullNameBox.getText().contains(fullName));
        Assert.assertTrue(textBoxPage.outputUserEmailBox.getText().contains(userEmail));
        System.out.println(textBoxPage.outputUserFullNameBox.getText());
        System.out.println(textBoxPage.outputUserEmailBox.getText());
        System.out.println(textBoxPage.outputfield.getText());
        Assert.assertTrue(textBoxPage.outputfield.getText().contains("Current Address :" + currentAddress));
        Assert.assertTrue(textBoxPage.outputfield.getText().contains("Permananet Address :" + permanentAddress));
    }

    @Test(priority = 30)
    public void elementstest2_radio() {
        driver.get(homepageURL);
        waiter.until(ExpectedConditions.urlToBe(homepageURL));
        Assert.assertEquals(driver.getCurrentUrl(), homepageURL);
        waiter.until(ExpectedConditions.elementToBeClickable(homePage.elementscard));
        //driver.findElement(By.cssSelector("#app > div > div > div.home-body > div > div:nth-child(1)")).click();
        homePage.elementscard.click();
        sidebarPage.smallCardsSelector("Radio Button").click();




    }
}
