package POModel.LillyWebShop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LillyHomeProductsPage {
    private WebDriver driver;


    @FindBy(xpath = "//div[@class=\"product details product-item-details\"]//button[@type=\"submit\"]")
    WebElement buyClick;
    @FindBy(xpath = "//li[@class=\"item product product-item\"]//div[@class=\"actions-primary\"]" +
            "//form[contains(@action,\"https://shop.lillydrogerie.bg/checkout/cart/add/uenc/" +
            "aHR0cHM6Ly9zaG9wLmxpbGx5ZHJvZ2VyaWUuYmcvcHJvZHVrdGktemEtZG9tYQ%2C%2C/product/77926/\")]")
    WebElement hoverOverBuy;

    @FindBy(xpath = "//span[@class=\"showcart-price\"]//span[@class=\"price\"]")
    WebElement cartPrice;
    @FindBy(xpath = "//span[@class=\"base\"]")
    WebElement pageTitle;



    public LillyHomeProductsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickBuy(WebDriver driver) {
        Actions action = new Actions(driver);
        action.moveToElement(buyClick).build().perform();
        buyClick.click();

    }
    public void clickItem(WebDriver driver){
        Actions action = new Actions(driver);
        action.moveToElement(hoverOverBuy).build().perform();
        hoverOverBuy.click();
    }
    public String getCartPrice(){
      return   cartPrice.getText();
    }
    public void goToCart(){
        cartPrice.click();
    }
    public String findTitle(){
        return pageTitle.getText();
    }


}
