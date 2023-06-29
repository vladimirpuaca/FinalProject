package Pages.ElementsCard;

import Base.BaseFile;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class RadioButtonPage extends BaseFile {

    public RadioButtonPage() {
        PageFactory.initElements(driver,this);
    }


    @FindBy(id = "yesRadio")
    public WebElement yesRadioButton;

    @FindBy(id = "impressiveRadio")
    public WebElement impressiveRadioButton;

    @FindBy(id = "noRadio")
    public WebElement noRadioButton;

    @FindBy(className = "text-success")
    public WebElement outputMessage;

    @FindBy(css = ".custom-control.custom-radio.custom-control-inline")
    public List<WebElement> radiobuttons;


    /* ------------Methods --------------*/

    public void javaSriptClick (WebElement radiobutton) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",radiobutton);
    }

    public int numberOfOutputMessages () {
        List<WebElement> textmessages = driver.findElements(By.className("text-success"));
        return textmessages.size();
    }

    public void clickOnRadioButton(String radioButtonName) {
        for (int i = 0; i < radiobuttons.size(); i++) {
            if (radiobuttons.get(i).getText().equals(radioButtonName)) {
                radiobuttons.get(i).click();
                break;
            }
        }
    }




}
