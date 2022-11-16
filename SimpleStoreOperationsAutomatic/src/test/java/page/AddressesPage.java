package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressesPage {
    private WebDriver driver;
    @FindBy(css = ".addresses-footer > a:nth-child(1)")
    private WebElement creatingNewAddressBtn;

    @FindBy(css = ".alert")
    private WebElement successAlert;

    public AddressesPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public AddressesPage createNewAddress(){
        creatingNewAddressBtn.click();
        return new AddressesPage(driver);
    }
    public boolean messageAlert(){
        return successAlert.isDisplayed();
    }

}
