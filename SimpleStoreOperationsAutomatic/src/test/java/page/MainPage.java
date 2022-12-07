package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    private WebDriver driver;

    @FindBy(css = ".user-info > a:nth-child(1) > span:nth-child(2)")
    private WebElement signInBtn;

    @FindBy(css = "div.js-product:nth-child(2) > article:nth-child(1) > div:nth-child(1) > div:nth-child(1) > a:nth-child(1) > img:nth-child(1)")
    private WebElement Item;

    public MainPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public LoginPage goToSignInPage(){
        signInBtn.click();
        return new LoginPage(driver);
    }

    public ItemPage goToItemPage(){
        Item.click();
        return new ItemPage(driver);
    }

}
