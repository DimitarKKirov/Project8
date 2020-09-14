package Steps.LillyWebShop;

import POModel.ContextSharing;
import POModel.TestData.LillyOrderData;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class LillyShippingDetailsPage {
    WebDriver driver;

    @Given("user have items in the basket")
    public void user_have_items_in_the_basket() {
        try {
            driver = ContextSharing.getContext().browserManager().browserDrivers().startBrowser("https://shop.lillydrogerie.bg/customer/account/login/referer/aHR0cHM6Ly9zaG9wLmxpbGx5ZHJvZ2VyaWUuYmcv/", "chrome");
            ContextSharing.getContext().pageManager(driver).lillyLogInPage().enterEmail("Lycifer@gmail.com");
            ContextSharing.getContext().pageManager(driver).lillyLogInPage().enterPass("3r0gr33dy");
            ContextSharing.getContext().pageManager(driver).lillyLogInPage().presLogIn();
            ContextSharing.getContext().pageManager(driver).lillyHomePage().clickButtonHomeProducts();
            Thread.sleep(5000);
            ContextSharing.getContext().pageManager(driver).lillyHomeProductsPage().FindItemAndBuy(driver);
            Thread.sleep(6000);
            ContextSharing.getContext().pageManager(driver).lillyHomeProductsPage().clickBuyItem(driver);
            ContextSharing.getContext().pageManager(driver).lillyHomeProductsPage().goToCart();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Given("user is in the basket")
    public void user_is_in_the_basket() {
        String title = ContextSharing.getContext().pageManager(driver).lillyHomeProductsPage().findTitle();
        Assert.assertEquals("Вашата количка", title);
    }

    @Given("and clicks buy")
    public void clickBuy() {
        try {
            Thread.sleep(3000);
            ContextSharing.getContext().pageManager(driver).lillyShoppingCartPage().pressCheckout();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @When("user fill the necessary Data")
    public void user_fill_the_necessary_data() throws InterruptedException {
        Thread.sleep(3000);
        LillyOrderData orderData = ContextSharing.getContext().dataManager().jsonDataReader().getCustomerByName("Димитър");
        ContextSharing.getContext().pageManager(driver).lillyShippingDetailsPage().fillingFromJson(orderData);

    }

    @When("pres submit button")
    public void pres_submit_button() {
        try {
            Thread.sleep(3000);
            ContextSharing.getContext().pageManager(driver).lillyShippingDetailsPage().presForward();
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Then("the user is redirected to the payment page")
    public void the_user_is_redirected_to_the_payment_page() {

        Assert.assertEquals("Начин на плащане",
                ContextSharing.getContext().pageManager(driver).lillyShippingDetailsPage().getPageOrderTitle());
    }

}
