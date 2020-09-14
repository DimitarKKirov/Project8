package Steps.Emag;


import POModel.ContextSharing;
import POModel.Emag.EmagSearch;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class EmagSearchStep {
    private WebDriver driver;
    private EmagSearch emagSearch;

    @Given("the user is logged in emag")
    public void loggedIn() {
      try {
          driver = ContextSharing.getContext().browserManager().browserDrivers().startBrowser("https://www.emag.bg/","Chrome");
       ContextSharing.getContext().pageManager(driver).emagHomePage().locateMyAccount();
       ContextSharing.getContext().pageManager(driver).emagLogIn().clickLogin();
       Thread.sleep(3000);
       ContextSharing.getContext().pageManager(driver).emagNewUserLogin().enterEmail("ycifer@gmail.com");
       ContextSharing.getContext().pageManager(driver).emagNewUserLogin().clickContinue();
//       emagSearch=ContextSharing.getContext().pageManager(driver).emagSearch();
      }catch (InterruptedException e){
          e.printStackTrace();
      }
    }

    @When("user enters search criteria")
    public void searchCriteria() {
//        emagSearch.enterSearchCriteria("maratonki");
    }

    @Then("the user can see the results")
    public void the_user_can_see_the_results() {
//        emagSearch.search();
    }


}
