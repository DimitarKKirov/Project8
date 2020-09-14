package Steps.Emag;

import Browsers.BrowsersType;
import POModel.ContextSharing;
import POModel.Emag.EmagHomePage;
import POModel.Emag.EmagNewUserLogin;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class CreatingAccount {

    private WebDriver driver;
    private EmagNewUserLogin newUserLogin;
    private String userEmail;
    @Given("user is in emag web page")
    public void user_is_in_emag_web_page() {
        BrowsersType type = BrowsersType.CHROME;
        driver=ContextSharing.getContext().browserManager().browserDrivers().startBrowser("https://www.emag.bg/",type.name());
        driver.manage().deleteAllCookies();
    }

    @Given("user hovers over My Account at the top")
    public void user_hovers_over_my_account_at_the_top() {
       ContextSharing.getContext().pageManager(driver).emagHomePage().locateMyAccount();

    }

    @When("user clicks on new account")
    public void user_clicks_on_new_account() {
    ContextSharing.getContext().pageManager(driver).emagHomePage().clickNewAccount();
    }

    @When("the user is redirected to the login page and prompted to enter {string} address")
    public void the_user_is_redirected_to_the_login_page_and_prompted_to_enter_address(String email) {
        try {
            Thread.sleep(3000);
            userEmail = email;
            newUserLogin = ContextSharing.getContext().pageManager(driver).emagNewUserLogin();
            Assert.assertEquals("Моля въведи имейл адрес", newUserLogin.pageVerification());
            newUserLogin.enterEmail(email);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    @When("after hitting continue the user is asked to enter more details")
    public void after_hitting_continue_the_user_is_asked_to_enter_more_details() {
        newUserLogin.clickContinue();
        Assert.assertEquals("Изглежда, че нямаш eMAG акаун.",newUserLogin.pageVerification2());
        ContextSharing.getContext().dataManager().emagDataReader().getCustomerEmail(userEmail);


    }

    @When("that he is agree with the Terms and Conditions and the Privacy Policy")
    public void that_he_is_agree_with_the_terms_and_conditions_and_the_privacy_policy() {
        newUserLogin.agreeToTerms();
    }

    @Then("the user can continue")
    public void the_user_can_continue() {
        newUserLogin.register();
    }
}
