package Steps.ExciteStepDefinitions;

import Browsers.BrowsersType;
import POModel.Excite.ExciteLoginPage;
import POModel.ContextSharing;
import POModel.PageManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


import static Browsers.BrowserDrivers.switchToNextTab;

public class ExciteEmailLoginPage {

    private ExciteLoginPage loginPage;
    private WebDriver driver;

    @Given("^user is on login\\.excite\\.com$")
    public void pageLoginExciteCom() {
        BrowsersType browser = BrowsersType.CHROME;
    driver = ContextSharing.getContext().browserManager().browserDrivers().startBrowser("https://login.excite.com/",browser.name());
    }

    @When("^user clicks on \"need an account\\?\" button$")
    public void userClicksOnButton() {
        ExciteLoginPage login= PageFactory.initElements(driver, ExciteLoginPage.class);
        login.goToRegistration();
    }

    @Then("^user is redirected to the registration page in new tab$")
    public void openRegistrationPage() throws InterruptedException {
        String tab = switchToNextTab(driver);
        driver.switchTo().window(tab);
        Thread.sleep(3000);
        Assert.assertEquals("Email Registration | Excite", driver.getTitle());
        driver.quit();
    }

    @When("the user enters invalid username and Password")
    public void invalidUsernameAndPass() {
        PageManager createLoginPage = new PageManager(driver);
        loginPage = createLoginPage.loginPage();
        loginPage.enterUsernameLogin("DKK");
        loginPage.enterPasswordLogin("12345W");
    }

    @When("clicks login button")
    public void invalidPassword() {
        loginPage.clickLoginButton();
    }

    @Then("the user is notified for invalid username and password")
    public void notificationForInvalidUserAndPass() {

        String msg = loginPage.findInvalidCredentialsMSG();
        Assert.assertEquals("Incorrect username or password.\n" +
                "Please try again.", msg);
        driver.quit();
    }
}
