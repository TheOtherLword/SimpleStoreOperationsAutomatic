package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmedPage {
    private WebDriver driver;

    public OrderConfirmedPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "order-reference-value")
    private WebElement orderNumber;

    public WebElement getOrderNumber() {
        return orderNumber;
    }


}
