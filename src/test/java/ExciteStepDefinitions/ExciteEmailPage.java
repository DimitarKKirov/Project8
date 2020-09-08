package ExciteStepDefinitions;

import POModel.abvBG.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static Browsers.Browsers.startBrowser;

public class ExciteEmailPage {
    WebDriver driver;

    @Given("^user is on excite.com/email page$")
    public void userOpensLoginPage() throws InterruptedException {
        driver = startBrowser( "https://www.excite.com/");

    }

    @When("^user click on \"Click here to access your email\" link button$")
    public void clickOnRegisterButton() throws InterruptedException {
        LoginPage login = PageFactory.initElements(driver, LoginPage.class);
        Thread.sleep(10000);
        login.goToEmailPage();

    }

    @Then("^user is redirected to the login page$")
    public void openRegistrationPage() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertEquals("Email Login | Excite", driver.getTitle());
        driver.quit();
    }


}
