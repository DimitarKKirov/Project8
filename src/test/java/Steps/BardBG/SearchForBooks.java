package Steps.BardBG;

import POModel.BardBG.SearchingForBooks;
import POModel.ContextSharing;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class SearchForBooks {
private WebDriver driver;
private SearchingForBooks searchingForBooks;
    @Given("user is on bard.bg")
    public void userIsOnBardBg() {
    driver = ContextSharing.getContext().browserManager().browserDrivers().startBrowser("https://www.bard.bg/","CHrome");
    searchingForBooks=ContextSharing.getContext().pageManager(driver).searchingForBooks();
    searchingForBooks.clickAgree();
    }

    @When("user enter search keyword in the search field")
    public void user_enter_search_keyword_in_the_search_field() {
    searchingForBooks.searchKeyWordsForBooks("Съборът на птиците");
    }

    @When("pres the search button")
    public void pres_the_search_button() {
    searchingForBooks.search();
    }

    @Then("the user is redirected to the result page")
    public void the_user_is_redirected_to_the_result_page() {
        Assert.assertEquals("Съборът на птиците",searchingForBooks.resultForSearch());
    }

    @Then("the user chooses books to add to user basket")
    public void the_user_chooses_books_to_add_to_user_basket() {
        try {
            Thread.sleep(3000);
            searchingForBooks.clickOrder();
            searchingForBooks.clickContinueShoppingButton();
            Thread.sleep(3000);
        }catch (InterruptedException books){
            books.printStackTrace();
        }
    }

    @Then("Clicks on catalogue")
    public void goToCatalogue() throws InterruptedException {
        searchingForBooks.openCatalogue();
        Thread.sleep(2000);
    }

    @Then("chooses a genre")
    public void pickGenre() {
        searchingForBooks.chooseGenres();
        Assert.assertEquals("Фентъзи",searchingForBooks.isGenre());
        searchingForBooks.choosBooksFromGenre("Колелото на Осхайм");
        searchingForBooks.choosBooksFromGenre("Прероденият дракон");
    }

    @Then("user goes to the basket")
    public void openBasket() {
        searchingForBooks.goToBasket();
    }

    @Then("user removes some books from the basket")
    public void user_removes_some_books_from_the_basket() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("the user adds some books to favourites")
    public void the_user_adds_some_books_to_favourites() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
