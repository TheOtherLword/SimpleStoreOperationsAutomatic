package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    private WebDriver driver;

    @FindBy(className = "hidden-sm-down")
    private WebElement signInBtn;

    public MainPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public MainPage goToSignInPage(){
        signInBtn.click();
        return new MainPage(driver);
    }
}
