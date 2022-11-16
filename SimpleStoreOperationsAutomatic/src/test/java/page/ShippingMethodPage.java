package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ShippingMethodPage {
    private WebDriver driver;

    public ShippingMethodPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
}
