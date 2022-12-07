package Cart;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.chrome.ChromeDriver;
import page.*;
import java.io.File;
import java.io.IOException;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class CartTestSteps {
    WebDriver driver;
    String TestString = "Test Testing" +"\n"+"Test Street"+"\n" +"Testopolis" +"\n"+"12-123" +"\n"+"United Kingdom"+"\n" +"123456789";
    public void TakeScreenshot(String FileName) throws IOException {
        File File = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(File,new File(FileName + ".jpeg"));
    }

    @Given("Web page MyStore is open in Chrome browser")
    public void openMyStoreInBrowser(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        this.driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        this.driver.get("https://mystore-testlab.coderslab.pl");
    }
    @When("I click Sign in button")
    public void clickSignInBtn(){
        MainPage mainPage = new MainPage(driver);
        mainPage.goToSignInPage();
    }
    @And("I login using {word} and {word}")
    public void loggingInWithGivenLoginAndPassword(String login,String password){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loggingIn(login,password);
    }

    @And("I go back to main page")
    public void goingToMainPage(){
        UserPage userPage = new UserPage(driver);
        userPage.goingBackToMainPage();
    }
    @And("I go to desired item page")
    public void goingToItemPage(){
        MainPage mainPage = new MainPage(driver);
        mainPage.goToItemPage();
    }
    @And("I check if discount is equal {word}")
    public void checkingDiscountAmount(String discount){
        ItemPage itemPage = new ItemPage(driver);
     //  System.out.println(itemPage.getDiscount().getText());
        assertEquals(discount,itemPage.getDiscount().getText());
    }


    @And("I select item size {word}")
    public void selectingItemSizeNow(String size){
        ItemPage itemPage = new ItemPage(driver);
        itemPage.selectingItemSize(size);
    }
    @And("I select number of items {word}")
    public void selectingNumberOfItems(String number){
        ItemPage itemPage = new ItemPage(driver);
        itemPage.itemNumber(number);
    }
    @And("I add items to cart")
    public void goingToCart(){
        ItemPage itemPage = new ItemPage(driver);
        itemPage.addToCart();
        itemPage.checkingOut();
    }
    @And("I go to check out")
    public void goingToCheckOut(){
        CartPage cartPage = new CartPage(driver);
        cartPage.checkingOut();
    }
    @And("I confirm Address")
    public void confirmingAddress(){
        CartPage cartPage = new CartPage(driver);
        Assertions.assertEquals(TestString,cartPage.getAddress().getText());
        cartPage.goingToShipment();
    }

    @And("I choose pick up method")
    public void choosingShippingMethod(){
        ShippingMethodPage shippingMethodPage = new ShippingMethodPage(driver);
        shippingMethodPage.choosingShipmentMethod();
        shippingMethodPage.goToPayment();
    }


    @And("I pick payment method")
    public void choosingPaymentMethod(){
        PaymentPage paymentPage = new PaymentPage(driver);
        paymentPage.choosingPaymentOption();
    }

    @And("I click on order with an obligation to pay")
    public void finishingOrder(){
        PaymentPage paymentPage = new PaymentPage(driver);
        paymentPage.agreeingToTerms();
        paymentPage.placingOrder();
    }

    @Then("I do a screenshot of order")
    public void doingScreenShoot() throws IOException {
        OrderConfirmedPage orderConfirmedPage = new OrderConfirmedPage(driver);
        TakeScreenshot(orderConfirmedPage.getOrderNumber().getText().replace("Order reference: ",""));
    }

}
