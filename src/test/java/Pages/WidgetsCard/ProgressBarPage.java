package Pages.WidgetsCard;

import Base.BaseFile;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProgressBarPage extends BaseFile {
    public ProgressBarPage() {
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = ".progress-bar.bg-info")
    public WebElement regularprogressBar;

    @FindBy(css =".progress-bar.bg-success")
    public WebElement fullprogressBar;



    @FindBy(id = "startStopButton")
    public WebElement startStopButton;

    @FindBy(id = "resetButton")
    public WebElement resetButton;
}
