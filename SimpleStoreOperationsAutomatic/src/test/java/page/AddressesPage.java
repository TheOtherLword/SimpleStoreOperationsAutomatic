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

    @FindBy(xpath = "/html/body/main/section/div/div/section/section/div[2]/article/div[2]/a[2]/span")
    private WebElement deleteBtn;

    @FindBy(xpath = "/html/body/main/section/div/div/section/section/div[2]/article/div[1]/address")
    private WebElement address;


    public AddressesPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public AddAddressPage createNewAddress(){
        creatingNewAddressBtn.click();
        return new AddAddressPage(driver);
    }
    public boolean messageAlert(){
        return successAlert.isDisplayed();
    }

    public String alertMsg(){
        return successAlert.getText();
    }
    public void deletingNewAddedAddress(){
        deleteBtn.click();
       // return new AddressesPage(driver);
    }
    public WebElement getAddress() {
        return address;
    }

}
