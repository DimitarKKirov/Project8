package Steps.Emag;

import Browsers.BrowserDrivers;
import Browsers.BrowserManager;
import Browsers.BrowsersType;
import Browsers.EmagGmailDataReader;
import POModel.ContextSharing;
import POModel.Emag.EmagLogIn;
import POModel.Emag.EmagNewUserLogin;
import POModel.TestData.EmagGmailUserData;
import POModel.TestData.EmagUserDetails;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class EmagLogin {
    WebDriver driver;
    EmagLogIn emagLogIn;
    EmagNewUserLogin newUserLogin;

    @Given("user clicks on enter in account")
    public void enterInAccount() {
        driver= BrowserDrivers.getDriver();
        newUserLogin=ContextSharing.getContext().pageManager(driver).emagNewUserLogin();
        emagLogIn = ContextSharing.getContext().contextSharing().pageManager(driver).emagLogIn();
        emagLogIn.clickLogin();
    }
    @When("the user is redirected to the login page of emag")
    public void checkPage() {
        try {
            Thread.sleep(5000);
            Assert.assertEquals("Моля въведи имейл адрес", newUserLogin.pageVerification());
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    @When("user clicks on login with Google")
    public void clickGoogle() {
        emagLogIn.clickGoogle();

    }

    @When("user enters {string} address and click continue")
    public void enterGoogleEmail(String email) {
        EmagGmailUserData details = ContextSharing.getContext().dataManager().emagGmailDataReader().getGEmail(email);
        emagLogIn.fillGmail(details);


    }

    @When("enter a password and click continue")
    public void enterPass() {
        try {
            Thread.sleep(3000);

        EmagGmailUserData details = ContextSharing.getContext().dataManager().emagGmailDataReader().getGPassword("#r0gr33dY9807");
        emagLogIn.fillGmailPassword(details);
        }catch (InterruptedException eGPass){
            eGPass.printStackTrace();
        }
    }

    @Then("the user is successfully logged in")
    public void successfullyLoggedIn() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
