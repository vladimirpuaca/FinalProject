package Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.Duration;

public class BaseFile {
    public static WebDriver driver;
    public FluentWait waiter;
    public ExcelReader excelReader;
    public JavascriptExecutor js;

    @BeforeClass
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        waiter = new FluentWait(driver);
        waiter.withTimeout(Duration.ofSeconds(10));
        waiter.pollingEvery(Duration.ofSeconds(1));
        excelReader = new ExcelReader("src/test/java/TestData.xlsx");
        js = (JavascriptExecutor) driver;
    }
}
