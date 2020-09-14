package POModel.BardBG;

import Browsers.DataManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchingForBooks {

    Actions action;
    Actions action2;

    @FindBy(name = "agree")
    WebElement agreeToTerms;
    @FindBy(name = "q")
    WebElement searchBox;
    @FindBy(xpath = "//input[@value=\"Търси\"]")
    WebElement searchButton;
    @FindBy(xpath = "//div[@class=\"heading\"]")
    WebElement genres;
    @FindBy(xpath = "//h1[text()=\"Съборът на птиците\"]")
    WebElement resultCheck;
    @FindBy(xpath = "//a[@class=\"btn-order\"]")
    WebElement orderButtonResultPage;
    @FindBy(className = "shopcart-link")
    WebElement continueShoppingButton;
    @FindBy(xpath = "//a[text()=\"Каталог\"]")
    WebElement catalogueButton;
    @FindBy(xpath = "//h1[text()=\"Книги от жанр: Фентъзи\"]")
    WebElement checkGenreName;
    @FindBy(xpath = "//div[@class=\"main-book-list back-link-container\"]")
    WebElement chooseBooksFromGenre;
    @FindBy(xpath = "//a[@class=\"shopcart-info-title\"]")
    WebElement basket;


    public SearchingForBooks(WebDriver driver) {
        PageFactory.initElements(driver, this);
        action= new Actions(driver);
        action2=new Actions(driver);
    }
    public void clickAgree(){
        agreeToTerms.click();
    }

    public void searchKeyWordsForBooks(String book) {
        searchBox.sendKeys(book);
    }

    public void search() {
        searchButton.click();
    }

    public String resultForSearch() {
        return resultCheck.getText();
    }

    public void clickOrder() {
        orderButtonResultPage.click();
    }

    public void clickContinueShoppingButton() {
        action.moveToElement(continueShoppingButton).build().perform();
        continueShoppingButton.click();
    }

    public void openCatalogue() {
        action.moveToElement(catalogueButton).build().perform();
    }

    public String isGenre() {
        return checkGenreName.getText();
    }

    public void goToBasket() {
        basket.click();
    }


    public void chooseGenres() {

        action2.moveToElement(genres).build();
        genres.click();

    }

    public void choosBooksFromGenre(String name) {
        List<WebElement> genreBooksList = chooseBooksFromGenre.findElements(By.xpath("//div[@class=\"main-book-list back-link-container\"]"));
        for (WebElement webElement : genreBooksList) {
            if (webElement.getText().equals(name)) {
                chooseBooksFromGenre.click();
            } else {
                System.out.println("no such book");
            }

        }
    }
}
