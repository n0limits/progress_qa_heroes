package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebDriver;
import pf.AuthenticationPagePF;
import pf.BaseTest;
import pf.Context;

import java.util.List;
import java.util.Map;

public class RegistrationPositiveAddingValidEmailTestStep {
    private AuthenticationPagePF authenticationPagePF;

    public RegistrationPositiveAddingValidEmailTestStep(Context context) {
        WebDriver driver = BaseTest.getDriver();
        authenticationPagePF = new AuthenticationPagePF(driver, context);
    }

    @Given("Customer navigates to the Authentication page")
    public void customer_navigates_to_the_page() {
        authenticationPagePF.load();
        authenticationPagePF.isLoaded();
    }

    @When("customer enters a valid email to the registration field")
    public void customerEntersAValidEmailToTheRegistrationField(DataTable dataTable) {
        {
            List<Map<String, String>> userData = dataTable.asMaps();
            authenticationPagePF.enterValidRegistrationEmail(userData.get(0));
        }
    }

    @And("Customer presses the Create an account button")
    public void customerPressesTheCreateAnAccountButton() {
        authenticationPagePF.submitEmail();
    }

    @Then("Customer is redirected to Registration form page")
    public void customerIsRedirectedToRegistrationFormPage() {
        authenticationPagePF.verifyRedirectedToCreationPage();
        authenticationPagePF.quit();
    }

}