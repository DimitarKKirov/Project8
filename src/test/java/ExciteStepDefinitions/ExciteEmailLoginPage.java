package ExciteStepDefinitions;

import POModel.abvBG.LoginPage;
import POModel.abvBG.PageManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


import static Browsers.Browsers.startBrowser;
import static Browsers.Browsers.switchToNextTab;

public class ExciteEmailLoginPage {
    private WebDriver driver;


    @Given("^user is on login\\.excite\\.com$")
    public void pageLoginExciteCom() {
        driver = startBrowser("https://login.excite.com/");

    }

    @When("^user clicks on \"need an account\\?\" button$")
    public void userClicksOnButton() {
        LoginPage goToRegistration = PageFactory.initElements(driver, LoginPage.class);
        goToRegistration.goToRegistration();
    }

    @Then("^user is redirected to the registration page in new tab$")
    public void openRegistrationPage() throws InterruptedException {
        String tab = switchToNextTab(driver);
        driver.switchTo().window(tab);
        Thread.sleep(3000);
        Assert.assertEquals("Email Registration | Excite", driver.getTitle());
        driver.quit();
    }
}
