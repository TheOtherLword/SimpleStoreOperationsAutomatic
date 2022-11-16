package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ItemPage {
    private WebDriver driver;

    public ItemPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

}
