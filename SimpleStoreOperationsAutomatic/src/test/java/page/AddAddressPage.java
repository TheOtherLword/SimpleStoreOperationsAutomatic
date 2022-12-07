package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddAddressPage {
    private WebDriver driver;

    @FindBy(id = "field-alias")
    private WebElement aliasInput;

    @FindBy(id = "field-address1")
    private WebElement addressInput;

    @FindBy(id = "field-city")
    private WebElement cityInput;

    @FindBy(id = "field-postcode")
    private WebElement postalCodeInput;

    @FindBy(id = "field-phone")
    private WebElement phoneInput;


    @FindBy(css = "button.btn")
    private WebElement saveBtn;


    public AddAddressPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void creatingAddress(String alias,String address,String city,String postcode,String phone){
        aliasInput.clear();
        aliasInput.sendKeys(alias);
        addressInput.clear();
        addressInput.sendKeys(address);
        cityInput.clear();
        cityInput.sendKeys(city);
        postalCodeInput.clear();
        postalCodeInput.sendKeys(postcode);
        phoneInput.clear();
        phoneInput.sendKeys(phone);

       // return new  AddAddressPage(driver);
    }
    public AddressesPage acceptingCreation(){
        saveBtn.click();
        return new AddressesPage(driver);
    }

}
