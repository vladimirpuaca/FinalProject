package Tests;

import Base.BaseFile;
import Pages.HomePage;
import Pages.SidebarPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Testing extends BaseFile {

    public HomePage homePage;
    public SidebarPage sidebarPage;
    public String homepageURL = "https://demoqa.com/";


    @BeforeClass
    public void setTests() {
        homePage = new HomePage();
        sidebarPage = new SidebarPage();
    }
    @Test (priority = 10)
    public void test1 () {
        driver.get(homepageURL);
        waiter.until(ExpectedConditions.urlToBe(homepageURL));
        Assert.assertEquals(driver.getCurrentUrl(),homepageURL);
        waiter.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div/div[1]"))));
    }

    @Test (priority = 20)
    public void elementstest () {
       //driver.findElement(By.cssSelector("#app > div > div > div.home-body > div > div:nth-child(1)")).click();
        homePage.elementscard.click();
        sidebarPage.elementsButton.click();
        sidebarPage.textBoxButton.click();





    }
}
