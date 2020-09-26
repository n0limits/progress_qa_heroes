package pf;

//import helper.Context;
//import helper.Utils;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Map;

public class AuthenticationPagePF extends LoadableComponent<AuthenticationPagePF> {

    private WebDriver driver;
    private WebDriverWait wait;
    Context context;

    private static final String URLAUTHENTICATION = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
    private static final String URLACCOUNTCREATION = "http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation";


    @FindBy(how = How.ID, using = "email_create")
    private WebElement inputEmail;

    @FindBy(how = How.ID, using = "SubmitCreate")
    private WebElement submitButton;


    @Override
    public void load() {
        driver.get(URLAUTHENTICATION);
    }

    @Override
    public void isLoaded() throws Error {
        Assert.assertEquals("Page is not loaded",
                URLAUTHENTICATION,
                driver.getCurrentUrl());
    }

    public AuthenticationPagePF(WebDriver driver, Context context) {
        this.context = context;
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 10);
    }

    public void enterValidRegistrationEmail(Map<String, String> userData) {
        context.username = userData.get("email");
        inputEmail.sendKeys(context.username);
        wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        System.out.println(context.username);
    }

    public void submitEmail() {
        submitButton.click();
    }

    public void verifyRedirectedToCreationPage() {
        wait.until(ExpectedConditions.urlContains(URLACCOUNTCREATION));
        Assert.assertEquals("Account creation page is not loaded.",
                URLACCOUNTCREATION, driver.getCurrentUrl());
    }

    public void quit() {
        driver.quit();
    }

}