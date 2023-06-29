package Pages;

import Base.BaseFile;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage extends BaseFile {

    public String homepageURL;

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div/div[1]")
    public WebElement elementsCard;

    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div/div[3]")
    public WebElement alertsCard;

    @FindBy(xpath = "/html/body/div[2]/header/a/img")
    public WebElement headerImage;

    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div/div[4]")
    public WebElement widgetsCard;

    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div/div[5]")
    public WebElement interactionsCard;

    public void goToHomePage () {
        driver.get("https://demoqa.com");
    }







}
