package Addresses;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/cucumber/features/ManagingAddressesInExistingAccount.feature", plugin = {"pretty","html:out.html"})
public class AddressesTest {
}
