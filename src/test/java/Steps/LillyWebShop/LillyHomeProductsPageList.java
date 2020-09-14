package Steps.LillyWebShop;

import POModel.ContextSharing;
import POModel.PageManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class LillyHomeProductsPageList {
    private WebDriver driver;
    private PageManager manager;

    @Given("user is in Home products shopping list")
    public void userIsInHomeProductsShoppingList() {
        driver = ContextSharing.getContext().browserManager().browserDrivers().startBrowser("https://shop.lillydrogerie.bg/customer/account/login/referer/aHR0cHM6Ly9zaG9wLmxpbGx5ZHJvZ2VyaWUuYmcv/", "chrome");
        manager = new PageManager(driver);
        manager.lillyLogInPage().enterEmail("Lycifer@gmail.com");
        manager.lillyLogInPage().enterPass("3r0gr33dy");
        manager.lillyLogInPage().presLogIn();
        manager.lillyHomePage().clickButtonHomeProducts();
    }

    @Given("add items to the basket")
    public void addItemsToTheBasket() throws InterruptedException {
        manager = new PageManager(driver);
        manager.lillyHomeProductsPage().clickBuyItem(driver);
        manager.lillyHomeProductsPage().FindItemAndBuy(driver);
        Thread.sleep(5000);

    }

    @Given("the total price is calculated correctly for the items in the basket")
    public void checkBasketTotalPrice() {
        String cartPrice = manager.lillyHomeProductsPage().getCartPrice();
        Assert.assertEquals("7,58 лв.", cartPrice);
    }

    @When("the user clicks the basket")
    public void basketClick() {
        manager.lillyHomeProductsPage().goToCart();
    }

    @Then("the user is redirected to the shopping cart")
    public void redirectToShoppingCartPage() throws InterruptedException {
        Thread.sleep(10000);
        Assert.assertEquals("Вашата количка",manager.lillyHomeProductsPage().findTitle());
        manager.lillyShoppingCartPage().deleteItemFromBasket();
        driver.quit();
    }

}
