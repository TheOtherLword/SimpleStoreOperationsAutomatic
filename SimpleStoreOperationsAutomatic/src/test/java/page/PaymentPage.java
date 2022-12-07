package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {
    private WebDriver driver;

    @FindBy(id = "payment-option-1")
    private WebElement payByCheckBtn;
    @FindBy(id = "payment-option-2")
    private WebElement payByBankWireBtn;
    @FindBy(id = "conditions_to_approve[terms-and-conditions]")
    private WebElement agreeToTermsBtn;
    @FindBy(css = "div.ps-shown-by-js > button:nth-child(1)")
    private WebElement placeOrderBtn;

    public PaymentPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void choosingPaymentOption(){
        //payByBankWireBtn.click();
        payByCheckBtn.click();
    }

    public void agreeingToTerms(){
        agreeToTermsBtn.click();

    }
    public void placingOrder(){
        placeOrderBtn.click();

    }
}
