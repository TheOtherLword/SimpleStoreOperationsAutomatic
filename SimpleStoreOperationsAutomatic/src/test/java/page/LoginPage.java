package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    @FindBy(id = "field-email")
    private WebElement emailInput;
    @FindBy(id = "field-password")
    private WebElement passwordInput;
    @FindBy(id = "submit-login")
    private WebElement signInBtn;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public UserPage loggingIn(String email,String password){
        emailInput.clear();
        emailInput.sendKeys(email);
        passwordInput.clear();
        passwordInput.sendKeys(password);
        signInBtn.click();
        return new UserPage(driver);
    }
}
