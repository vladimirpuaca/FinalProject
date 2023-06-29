package Pages.ElementsCard;

import Base.BaseFile;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinksPage extends BaseFile {

    public LinksPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "simpleLink")
    public WebElement simpleLink;

    @FindBy(id = "dynamicLink")
    public WebElement dynamicLink;

    @FindBy(id = "created")
    public WebElement createdAPIcalllink;

    @FindBy(id = "no-content")
    public WebElement noContentAPIcalllink;

    @FindBy(id = "moved")
    public WebElement movedAPIcalllink;

    @FindBy(id = "bad-request")
    public WebElement badRequestAPIcalllink;

    @FindBy(id = "unauthorized")
    public WebElement unauthorizedAPIcall;

    @FindBy(id = "forbidden")
    public WebElement forbiddenAPIcall;

    @FindBy(id = "invalid-url")
    public WebElement notFoundAPIcall;

    @FindBy(id = "linkResponse")
    public WebElement linkResponseBox;
}
