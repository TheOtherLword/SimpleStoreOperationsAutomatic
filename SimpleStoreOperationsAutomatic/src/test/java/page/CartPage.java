package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    private WebDriver driver;
    @FindBy(css = "a.btn")
    private WebElement checkingOutBtn;
    @FindBy(xpath = "//*[@id=\"id-address-delivery-address-29080\"]/header/label/div")
    private WebElement address;

    @FindBy(css = "div.clearfix:nth-child(6) > button:nth-child(1)")
    private WebElement continueBtn;

    public CartPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public CartPage checkingOut(){
        checkingOutBtn.click();
        return new  CartPage(driver);
    }
    public CartPage goingToShipment(){
        continueBtn.click();
        return new CartPage(driver);
    }
    public WebElement getAddress(){
        return address;
    }
}
