package Pages.WidgetsCard;

import Base.BaseFile;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.security.PublicKey;

public class SliderPage extends BaseFile {
    public SliderPage() {
        PageFactory.initElements(driver,this);
    }

    @FindBy (xpath = "/html/body/div[2]/div/div/div[2]/div[2]/form/div/div[1]/span/input")
    public WebElement slider;

    @FindBy(className = "range-slider__tooltip__arrow")
    public WebElement sliderarrow;

    @FindBy(id = "sliderValue")
    public WebElement sliderBox;


    /* ----------------------Methods------------*/





}
