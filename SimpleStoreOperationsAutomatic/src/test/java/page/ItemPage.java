package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ItemPage {
    private WebDriver driver;

    @FindBy(css = "#group_1")
    private WebElement sizeBox;

    @FindBy(className = "add-to-cart")
    private WebElement addToCartBtn;
    @FindBy(className = "discount")
    private WebElement discount;

    @FindBy(css = "a.btn")
    private WebElement goingToCheckOutBtn;

    @FindBy(className = "touchspin-up")
    private WebElement quantityIncreaseBtn;
    public ItemPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public void selectingItemSize(String size){
        sizeBox.click();
        sizeBox.sendKeys(size);
     //   return new ItemPage(driver);
    }
    public void itemNumber(String number){
        int quantity = Integer.parseInt(number);
        for(int i=1;i<quantity;i++){
            quantityIncreaseBtn.click();
        }
      //  return new ItemPage(driver);
    }

    public ItemPage addToCart(){
        addToCartBtn.click();
        return new ItemPage(driver);
    }
    public WebElement getDiscount(){
        return discount;
    }

    public ItemPage checkingOut(){
        goingToCheckOutBtn.click();
        return new ItemPage(driver);
    }
}
