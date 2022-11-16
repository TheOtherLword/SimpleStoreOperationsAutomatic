package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserPage {
    private WebDriver driver;
    @FindBy(id = "addresses-link")
    private WebElement addressesBtn;

    public UserPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public UserPage showingAddresses(){
        addressesBtn.click();
        return new UserPage(driver);
    }
}
