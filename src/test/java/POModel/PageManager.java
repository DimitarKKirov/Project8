package POModel;

import POModel.BardBG.SearchingForBooks;
import POModel.Emag.EmagHomePage;
import POModel.Emag.EmagLogIn;
import POModel.Emag.EmagNewUserLogin;
import POModel.Emag.EmagSearch;
import POModel.Excite.ExciteLoginPage;
import POModel.Excite.ExciteRegistrationPage;
import POModel.LillyWebShop.*;
import org.openqa.selenium.WebDriver;

public class PageManager {


    private WebDriver driver;
    private ExciteLoginPage loginPage;
    private ExciteRegistrationPage registrationPage;
    private LillyHomePage lillyHomePage;
    private LillyHomeProductsPage lillyHomeProductsPage;
    private LillyLogInPage lillyLogInPage;
    private LillyShoppingCartPage shoppingCartPage;
    private LillyShippingDetailsPage lillyShippingDetailsPage;
    private EmagHomePage emagHomePage;
    private EmagNewUserLogin emagNewUserLogin;
    private EmagLogIn emagLogIn;
    private EmagSearch emagSearch;
    private SearchingForBooks searchingForBooks;

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
        } else {
            return lillyLogInPage;
        }
    }

    public LillyShoppingCartPage lillyShoppingCartPage() {
        if (shoppingCartPage == null) {
            shoppingCartPage = new LillyShoppingCartPage(driver);
            return shoppingCartPage;
        } else {
            return shoppingCartPage;
        }
    }

    public LillyShippingDetailsPage lillyShippingDetailsPage() {
        if (lillyShippingDetailsPage == null) {
            lillyShippingDetailsPage = new LillyShippingDetailsPage(driver);
            return lillyShippingDetailsPage;
        } else {
            return lillyShippingDetailsPage;
        }
    }

    public EmagHomePage emagHomePage() {
        if (emagHomePage == null) {
            emagHomePage = new EmagHomePage(driver);
            return emagHomePage;
        } else {
            return emagHomePage;
        }
    }

    public EmagNewUserLogin emagNewUserLogin() {
        if (emagNewUserLogin == null) {
            emagNewUserLogin = new EmagNewUserLogin(driver);
            return emagNewUserLogin;
        } else {
            return emagNewUserLogin;
        }
    }
    public EmagLogIn emagLogIn() {
        if (emagLogIn == null) {
            emagLogIn = new EmagLogIn(driver);
            return emagLogIn;
        } else {
            return emagLogIn;
        }
    }
    public EmagSearch emagSearch() {
        if (emagSearch == null) {
            emagSearch = new EmagSearch(driver);
            return emagSearch;
        } else {
            return emagSearch;
        }
    }
    public SearchingForBooks searchingForBooks() {
        if (searchingForBooks == null) {
            searchingForBooks = new SearchingForBooks(driver);
            return searchingForBooks;
        } else {
            return searchingForBooks;
        }
    }
}
