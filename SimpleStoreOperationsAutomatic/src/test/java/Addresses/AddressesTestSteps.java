package Addresses;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import page.*;


public class AddressesTestSteps {

    WebDriver driver;
    String teststring = "Test Testing" +"\n"+"Test Street"+"\n" +"Testopolis" +"\n"+"12-123" +"\n"+"United Kingdom"+"\n" +"123456789";

    @Given("Web page MyStore is open in Chrome browser")
    public void openMyStoreInBrowser(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        this.driver = new ChromeDriver();
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
    @And("I click Addresses button")
    public void goToAddressesPage(){
        UserPage userPage = new UserPage(driver);
        userPage.showingAddresses();
    }
    @And("I click Create new address")
    public void goToCreatingNewAddressesPage(){
    AddressesPage addressesPage = new AddressesPage(driver);
    addressesPage.createNewAddress();
    }
    @And("I fill in {word}, {string}, {word}, {word}, {word} in input boxes")
    public void creatingNewAddress(String alias,String address,String city,String postalcode,String phone){
        AddAddressPage addAddressPage = new AddAddressPage(driver);
        addAddressPage.creatingAddress(alias,address,city,postalcode,phone);
    }
    @And("I add address by clicking Save button")
    public void finishCreatingNewAddress(){
        AddAddressPage addAddressPage = new AddAddressPage(driver);
        addAddressPage.acceptingCreation();
    }
    @Then("I see Address successfully added! message")
    public void checkingIfMessageIsDisplayed(){
        AddressesPage addressesPage = new AddressesPage(driver);
        Assertions.assertTrue(addressesPage.messageAlert());
        Assertions.assertEquals("Address successfully added!",addressesPage.alertMsg());
    }
      @And("I verify created address")
    public void checkingIcCreatedAddressIsCorrect(){
        AddressesPage addressesPage = new AddressesPage(driver);
        Assertions.assertEquals(teststring,addressesPage.getAddress().getText());
    }

    @And("I remove address by clicking on Delete button")
    public void deletingCreatedAddress(){
        AddressesPage addressesPage = new AddressesPage(driver);
        addressesPage.deletingNewAddedAddress();
    }
    @And("I see Address successfully deleted! message")
    public void checkingIfMessageIsDisplayedAgain(){
        AddressesPage addressesPage = new AddressesPage(driver);
        Assertions.assertTrue(addressesPage.messageAlert());
        Assertions.assertEquals("Address successfully deleted!",addressesPage.alertMsg());

    }
}
