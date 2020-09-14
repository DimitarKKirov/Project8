package Steps.LillyWebShop;

import POModel.ContextSharing;
import POModel.PageManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class LillyLoginPage {
    private WebDriver driver;
    private PageManager manager;

    @Given("the user is on user Login page")
    public void the_user_is_on_user_login_page() {
        driver = ContextSharing.getContext().browserManager().browserDrivers().startBrowser("https://shop.lillydrogerie.bg/customer/account/login/referer/aHR0cHM6Ly9zaG9wLmxpbGx5ZHJvZ2VyaWUuYmcv/", "chrome");

    }

    @When("user enters the correct username and password")
    public void user_enters_the_correct_username_and_password() {
        manager = new PageManager(driver);
        manager.lillyLogInPage().enterEmail("Lycifer@gmail.com");
        manager.lillyLogInPage().enterPass("3r0gr33dy");
    }

    @When("clicks on button Вход")
    public void userClicksEnterButton() {
        manager.lillyLogInPage().presLogIn();
    }

    @Then("user is successfully logged in")
    public void user_is_successfully_logged_in() throws InterruptedException {
        Thread.sleep(4000);
        Assert.assertEquals("Лили Дрогерие онлайн магазин | Лили Дрогерие", driver.getTitle());
        driver.quit();
    }

}
