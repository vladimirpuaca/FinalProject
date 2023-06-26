package Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
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
    public Actions act;

    @BeforeClass
    public void setUp() throws IOException, InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("load-extension=" + System.getProperty("user.dir") + "\\src\\test\\resources\\1.50.0_0");
        Thread.sleep(2000);
        driver = new ChromeDriver(options);
        act = new Actions(driver);
        js = (JavascriptExecutor) driver;
        excelReader = new ExcelReader("src/test/resources/TestData.xlsx");
        driver.manage().window().maximize();
        waiter = new FluentWait(driver);
        waiter.withTimeout(Duration.ofSeconds(10));
        waiter.pollingEvery(Duration.ofSeconds(1));


    }

    public void scrollintoView(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void ifBottomBannerDisplayedShutIt() {
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].parentNode.removeChild(arguments[0])", driver.findElement(By.id("fixedban")));
        } catch (Exception ignored) {
        }
    }


}
