package Steps.LillyWebShop;

import Browsers.BrowserManager;
import Browsers.BrowsersType;
import POModel.PageManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class LillyHomePage {
    private WebDriver driver;
    private PageManager manager;


    @Given("^user is on https:\\/\\/shop.lillydrogerie.bg\\/$")
    public void homePage() {
        BrowsersType browsersType = BrowsersType.CHROME;
        driver = BrowserManager.getBManager().browserDrivers().startBrowser("https://shop.lillydrogerie.bg/", browsersType.name());

    }

    @When("user click on Вход button")
    public void clickOnEnter() {
        manager = new PageManager(driver);
        manager.lillyLogInPage().clickLogin();
    }

    @Then("the user is redirected to the login page of Lilly website")
    public void redirectedToLoginPage() {

        Assert.assertEquals("Вход | Лили Дрогерие", driver.getTitle());
        driver.quit();

    }

    @Given("the user is logged in")
    public void logIn() {
        BrowsersType browser= BrowsersType.CHROME;
       driver =BrowserManager.getBManager().browserDrivers().startBrowser("https://shop.lillydrogerie.bg/customer/account/login/referer/aHR0cHM6Ly9zaG9wLmxpbGx5ZHJvZ2VyaWUuYmcv/",browser.name());
        manager = new PageManager(driver);
        manager.lillyLogInPage().enterEmail("Lycifer@gmail.com");
        manager.lillyLogInPage().enterPass("3r0gr33dy");
        manager.lillyLogInPage().presLogIn();
    }

    @Given("on the home page")
    public void redirectedToHomePage() {
        Assert.assertEquals("Лили Дрогерие онлайн магазин | Лили Дрогерие", driver.getTitle());
    }

    @When("the user clicks Home products from the left had menu")
    public void clickHomeProducts() {
        manager.lillyHomePage().clickButtonHomeProducts();
    }

    @Then("the user is redirected to the shop list with the corresponding items")
    public void userRedirectedToShopListWithCorrespondingItems() {
        Assert.assertEquals("Продукти за дома | Лили Дрогерие", driver.getTitle());
        driver.quit();
    }
}
