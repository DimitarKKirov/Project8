package Steps.ExciteStepDefinitions;

import Browsers.BrowsersType;
import POModel.Excite.ExciteLoginPage;
import POModel.ContextSharing;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class ExciteEmailPage {
    WebDriver driver;

    @Given("^user is on excite.com/email page$")
    public void userOpensLoginPage() throws InterruptedException {
        BrowsersType name = BrowsersType.FIREFOX;
        driver = ContextSharing.getContext().browserManager().browserDrivers().startBrowser("https://www.excite.com/", name.name());

    }

    @When("^user click on \"Click here to access your email\" link button$")
    public void clickOnRegisterButton() throws InterruptedException {
        ExciteLoginPage login = PageFactory.initElements(driver, ExciteLoginPage.class);
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
