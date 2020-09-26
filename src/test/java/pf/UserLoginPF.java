package pf;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class UserLoginPF extends LoadableComponent<UserLoginPF> {
    private WebDriver driver;
    private WebDriverWait wait;
    Context context;

    private static final String URLMYACCOUNT = "http://automationpractice.com/index.php?controller=my-account";
    private static final String URLAUTHENTICATION = "http://automationpractice.com/index.php?controller=authentication&back=my-account";

    //already registered

    @FindBy(how = How.ID, using = "email")
    private WebElement emailLogin;

    @FindBy(how = How.ID, using = "passwd")
    private WebElement passLogin;

    @FindBy(how = How.ID, using = "SubmitLogin")
    private WebElement signInButton;


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

    public UserLoginPF(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 10);
    }

    public void verifyIsRedirectedToMyAccount() {
        wait.until(ExpectedConditions.urlContains(URLMYACCOUNT));
        Assert.assertEquals("My account page is not loaded.",
                URLMYACCOUNT, driver.getCurrentUrl());
    }


    public void quit() {
        driver.quit();
    }

    public void enterPassword() {
        passLogin.sendKeys("test1234");
        wait.until(ExpectedConditions.elementToBeClickable(signInButton));
    }

    public void clickSignInButton() {
        signInButton.click();
    }

    public void enterRegisteredEmail() {
        emailLogin.sendKeys( "progressqa@abv.bg");
    }

}