package Pages;


import Base.BaseFile;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class SidebarPage extends BaseFile {

    public SidebarPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[1]/span/div")
    public WebElement elementsButton;

    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[1]/div/ul/li[1]")
    public WebElement textBoxButton;

    @FindBy(className = "text")
    public List<WebElement> sidebarsmallcards;


    public WebElement smallCardsSelector(String cardName) {
        for (int i = 0; i < sidebarsmallcards.size(); i++) {
            if (sidebarsmallcards.get(i).getText().equals(cardName)) {
                return sidebarsmallcards.get(i);
            }
        }
        return null;
    }
}