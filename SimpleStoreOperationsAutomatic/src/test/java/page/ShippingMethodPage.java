package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShippingMethodPage {
    private WebDriver driver;

    @FindBy(id = "delivery_option_1")
    private WebElement pickUpMethodBtn;

    @FindBy(id = "delivery_option_2")
    private WebElement carrierDeliveryMethodBtn;

    @FindBy(css = "button.continue:nth-child(2)")
    private WebElement continueBtn;
    public ShippingMethodPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void choosingShipmentMethod(){
        carrierDeliveryMethodBtn.click();
        pickUpMethodBtn.click();
    }
    public PaymentPage goToPayment(){
        continueBtn.click();
        return new PaymentPage(driver);
    }


}
