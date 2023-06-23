package Pages;

import Base.BaseFile;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


public class HomePage extends BaseFile {

    public String homepageURL;

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div/div[1]")
    public WebElement elementscard;

//    @FindBy(xpath = )







}
