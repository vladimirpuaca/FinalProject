package Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.BeforeClass;
import java.io.IOException;
import java.time.Duration;

public class BaseFile {
    public static WebDriver driver;
    public FluentWait waiter;
    public ExcelReader excelReader;
    public JavascriptExecutor js;
    public ChromeOptions options;
    public Actions actions;

    @BeforeClass
    public void setUp() throws IOException, InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("load-extension=" + System.getProperty("user.dir") + "\\src\\test\\resources\\1.50.0_0");
        Thread.sleep(2000);
        driver = new ChromeDriver(options);
        actions = new Actions(driver);
        js = (JavascriptExecutor) driver;
        excelReader = new ExcelReader("src/test/resources/TestData.xlsx");
        driver.manage().window().maximize();

        waiter = new FluentWait(driver);
        waiter.withTimeout(Duration.ofSeconds(10));
        waiter.pollingEvery(Duration.ofMillis(50));


    }

    public void scrollintoView(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
    public void scrollToTheTop() {
        js.executeScript("window.scrollBy(0,-250)", "");
    }


    public void waitForClickability(WebElement element) {
        waiter.until(ExpectedConditions.elementToBeClickable(element));
    }


    public boolean elementIsPresent(WebElement element) {
        boolean nonexistingElement = false;
        try {
            nonexistingElement = element.isDisplayed();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return nonexistingElement;
    }

    public void insertText(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }


}
