package Pages.ElementsCard;


import Base.BaseFile;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TextBoxPage extends BaseFile {

    public TextBoxPage() {
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "userName")
    public WebElement inputuserFullNameBox;

    @FindBy(id = "userEmail")
    public WebElement inputuserEmailBox;

    @FindBy (id = "currentAddress")
    public WebElement inputuserCurrentAddressBox;

    @FindBy (id = "permanentAddress")
    public WebElement inputuserPermanentAddressBox;

    @FindBy(id = "submit")
    public WebElement submitButton;

    @FindBy(id="name")
    public WebElement outputUserFullNameBox;

    @FindBy(id="email")
    public WebElement outputUserEmailBox;

    @FindBy (id="output")
    public WebElement outputfield;
}
