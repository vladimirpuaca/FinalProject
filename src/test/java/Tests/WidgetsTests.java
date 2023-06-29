package Tests;

import Base.BaseFile;
import Pages.HomePage;
import Pages.SidebarPage;
import Pages.WidgetsCard.ProgressBarPage;
import Pages.WidgetsCard.SliderPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WidgetsTests extends BaseFile {
    public HomePage homePage;
    public SidebarPage sidebarPage;
    public SliderPage sliderPage;
    public ProgressBarPage progressBarPage;

    @BeforeClass
    public void setTests() throws InterruptedException {
        homePage = new HomePage();
        sidebarPage = new SidebarPage();
        sliderPage = new SliderPage();
        progressBarPage = new ProgressBarPage();
    }

    public void moveSliderToValue(int desiredValue) {
        int currentValue = Integer.parseInt(sliderPage.slider.getAttribute("value"));
        while (currentValue != desiredValue) {
            if (currentValue < desiredValue) {
                actions.dragAndDropBy(sliderPage.slider, 1, 0).perform();
                currentValue = Integer.parseInt(sliderPage.slider.getAttribute("value"));
            } else {
                actions.dragAndDropBy(sliderPage.slider, -1, 0).perform();
                currentValue = Integer.parseInt(sliderPage.slider.getAttribute("value"));

            }
        }
    }

    @BeforeMethod
    public void preparation() {
        homePage.goToHomePage();
        scrollintoView(homePage.widgetsCard);
        homePage.widgetsCard.click();
    }

    @Test(priority = 10)
    public void sliderCanGoTo0and100() {
        scrollintoView(sidebarPage.smallCardsSelector("Slider"));
        sidebarPage.smallCardsSelector("Slider").click();

        Assert.assertNotEquals("100",sliderPage.slider.getAttribute("value"));
        actions.clickAndHold(sliderPage.slider).moveByOffset(300, 0).perform();
        Assert.assertEquals("100", sliderPage.slider.getAttribute("value"));


        actions.clickAndHold(sliderPage.slider).moveByOffset(-300, 0).perform();
        Assert.assertEquals("0",sliderPage.slider.getAttribute("value"));
    }
    @Test
    public void sliderCannotGoMoreExtreme() {
        scrollintoView(sidebarPage.smallCardsSelector("Slider"));
        sidebarPage.smallCardsSelector("Slider").click();

        Assert.assertNotEquals("100",sliderPage.slider.getAttribute("value"));
        actions.clickAndHold(sliderPage.slider).moveByOffset(300, 0).perform();
        Assert.assertEquals("100",sliderPage.slider.getAttribute("value"));
        int maxFirstValue=Integer.parseInt(sliderPage.slider.getAttribute("value"));

        actions.clickAndHold(sliderPage.slider).moveByOffset(500, 0).perform();
        int maxSecondValue=Integer.parseInt(sliderPage.slider.getAttribute("value"));
        Assert.assertEquals(maxFirstValue,maxSecondValue);

        Assert.assertNotEquals("0",sliderPage.slider.getAttribute("value"));
        actions.clickAndHold(sliderPage.slider).moveByOffset(-300, 0).perform();
        Assert.assertEquals("0",sliderPage.slider.getAttribute("value"));
        int minFirstValue=Integer.parseInt(sliderPage.slider.getAttribute("value"));
        actions.clickAndHold(sliderPage.slider).moveByOffset(-600, 0).perform();
        int minSecondValue=Integer.parseInt(sliderPage.slider.getAttribute("value"));
        Assert.assertEquals(minFirstValue,minSecondValue);
    }

    @Test(priority = 20)
    public void progressBarTest() throws InterruptedException {
        scrollintoView(sidebarPage.smallCardsSelector("Progress Bar"));
        sidebarPage.smallCardsSelector("Progress Bar").click();
        scrollintoView(progressBarPage.regularprogressBar);
        setProgressBarValue("78");

    }
    @Test(priority = 30)
    public void progressBarTest2() throws InterruptedException {
        scrollintoView(sidebarPage.smallCardsSelector("Progress Bar"));
        sidebarPage.smallCardsSelector("Progress Bar").click();

        scrollintoView(progressBarPage.regularprogressBar);
        setProgressBarValue("78");

        scrollintoView(progressBarPage.regularprogressBar);
        setProgressBarValue("95");
    }


    public void setProgressBarValue(String number) throws InterruptedException {
        String currentValue = progressBarPage.regularprogressBar.getAttribute("aria-valuenow");
        while (Integer.parseInt(currentValue) != Integer.parseInt(number)) {
            if (Integer.parseInt(currentValue) < Integer.parseInt(number)) {
                progressBarPage.startStopButton.click();
                waiter.until(ExpectedConditions.attributeContains(progressBarPage.regularprogressBar, "aria-valuenow", number));
                progressBarPage.startStopButton.click();
                currentValue = progressBarPage.regularprogressBar.getAttribute("aria-valuenow");
            } else {
                progressBarPage.startStopButton.click();
                waiter.until(ExpectedConditions.attributeContains(progressBarPage.fullprogressBar, "aria-valuenow", "100"));
                progressBarPage.resetButton.click();
                currentValue = progressBarPage.regularprogressBar.getAttribute("aria-valuenow");
            }
        }
    }
//    public void resetProgressBar() {
//        if ()
//    }

}

