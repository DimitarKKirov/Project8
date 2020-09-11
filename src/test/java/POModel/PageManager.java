package POModel;

import POModel.Excite.ExciteLoginPage;
import POModel.Excite.ExciteRegistrationPage;
import POModel.LillyWebShop.LillyHomePage;
import POModel.LillyWebShop.LillyHomeProductsPage;
import POModel.LillyWebShop.LillyLogInPage;
import POModel.LillyWebShop.LillyShoppingCartPage;
import org.openqa.selenium.WebDriver;

public class PageManager {


    WebDriver driver;
    private ExciteLoginPage loginPage;
    private ExciteRegistrationPage registrationPage;
    private LillyHomePage lillyHomePage;
    private LillyHomeProductsPage lillyHomeProductsPage;
    private LillyLogInPage lillyLogInPage;
    private LillyShoppingCartPage shoppingCartPage;

    public PageManager(WebDriver driver) {
        this.driver = driver;
    }

    public ExciteLoginPage loginPage() {
        if (loginPage == null) {
            loginPage = new ExciteLoginPage(driver);
            return loginPage;
        } else {
            return loginPage;
        }
    }

    public ExciteRegistrationPage registrationPage() {
        if (registrationPage == null) {
            registrationPage = new ExciteRegistrationPage(driver);
            return registrationPage;
        } else {
            return registrationPage;
        }
    }

    public LillyHomePage lillyHomePage() {
        if (lillyHomePage == null) {
            lillyHomePage = new LillyHomePage(driver);
            return lillyHomePage;
        } else {
            return lillyHomePage;
        }
    }

    public LillyHomeProductsPage lillyHomeProductsPage() {
        if (lillyHomeProductsPage == null) {
            lillyHomeProductsPage = new LillyHomeProductsPage(driver);
            return lillyHomeProductsPage;
        } else {
            return lillyHomeProductsPage;
        }
    }

    public LillyLogInPage lillyLogInPage() {
        if (lillyLogInPage == null) {
            lillyLogInPage = new LillyLogInPage(driver);
            return lillyLogInPage;
        }else
        {
            return lillyLogInPage;
        }
    }
    public LillyShoppingCartPage lillyShoppingCartPage() {
        if (shoppingCartPage == null) {
            shoppingCartPage = new LillyShoppingCartPage(driver);
            return shoppingCartPage;
        }else
        {
            return shoppingCartPage;
        }
    }
}
