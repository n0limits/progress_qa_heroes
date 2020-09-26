package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import pf.BaseTest;
import pf.UserLoginPF;

public class LoginPositiveWithAlreadyRegisteredEmail {
    private UserLoginPF userLoginPF;
    WebDriver driver = BaseTest.getDriver();

    public LoginPositiveWithAlreadyRegisteredEmail (BaseTest baseTest){
        userLoginPF = new UserLoginPF(driver);
    }

    @Given("Customer is on Authentication page")
    public void customerIsOnAuthenticationPage() {
        userLoginPF.load();
        userLoginPF.isLoaded();
    }

    @And("enters a valid email address and password in Login section")
    public void entersAValidEmailAddressAndPasswordInLoginSection() {
        userLoginPF.enterRegisteredEmail();
        userLoginPF.enterPassword();
    }

    @When("presses Login button")
    public void pressesLoginButton() {
        userLoginPF.clickSignInButton();
    }

    @Then("user is successfully logged in")
    public void userIsSuccessfullyLoggedIn() {
        userLoginPF.verifyIsRedirectedToMyAccount();
        userLoginPF.quit();
    }
}
