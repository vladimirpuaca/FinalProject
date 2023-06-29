package Pages.AlertsCard;

import Base.BaseFile;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertsPage extends BaseFile {
    public AlertsPage() {
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="alertButton")
    public WebElement regularAlertButton;

    @FindBy(id = "timerAlertButton")
    public WebElement delayedAlertButton;

    @FindBy(id = "confirmButton")
    public WebElement confirmAlertButton;

    @FindBy(id="confirmResult")
    public WebElement outputBoxOfConfirmButton;

    @FindBy(id="promtButton")
    public WebElement promptButton;

    @FindBy(id = "promptResult")
    public WebElement outputBoxPrompt;


    /*--------------------Methods-----------------------*/
    public boolean isAlertPresent() {
        try
        {
            driver.switchTo().alert();
            return true;
        }   // try
        catch (Exception ignored)
        {
            return false;
        }   // catch
    }
}
