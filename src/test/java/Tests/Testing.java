package Tests;

import Base.BaseFile;
import Pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Testing extends BaseFile {

    public HomePage homePage;
    String homePageURL;

    @BeforeClass
    public void setTests() {
        homePage = new HomePage();
        homePageURL = excelReader.getStringData("Sheet1",0,1);
    }
    @Test (priority = 10)
    public void test1 () {
        driver.get(homePageURL);
        waiter.until(ExpectedConditions.urlToBe(homePageURL));
        Assert.assertEquals(driver.getCurrentUrl(),homePageURL);
        waiter.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div/div[1]"))));
    }

    @Test (priority = 20)
    public void elementstest () {
       //driver.findElement(By.cssSelector("#app > div > div > div.home-body > div > div:nth-child(1)")).click();
        Assert.assertTrue(homePage.elementscard.isDisplayed());

    }
}
