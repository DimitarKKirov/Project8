package POModel.LillyWebShop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LillyShoppingCartPage {

    @FindBy(xpath = "//*[@class=\"action action-delete\"]")
    WebElement deleteItem;
    @FindBy(xpath = "//li[@class=\"item\"]")
    WebElement checkOut;


public LillyShoppingCartPage(WebDriver driver){
    PageFactory.initElements(driver,this);
}


    public void deleteItemFromBasket(){
        List<WebElement> xMarkTheSpot= deleteItem.findElements(By.xpath("//*[@class=\"action action-delete\"]"));

        for (int i = 0; i <xMarkTheSpot.size() ; i++) {
            deleteItem.click();
        }


    }
    public void pressCheckout(){
    checkOut.click();
    }
}
