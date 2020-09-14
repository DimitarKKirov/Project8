package POModel.LillyWebShop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LillyHomePage {
WebDriver driver;
    @FindBy(linkText = "Продукти за дома")
    WebElement menuButtonHomeProducts;




    public LillyHomePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public void clickButtonHomeProducts() {
        menuButtonHomeProducts.click();
    }
}