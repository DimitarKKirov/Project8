package POModel.Emag;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmagHomePage {
    private Actions action;

    @FindBy(xpath = "//i[@class=\"em em-user2 navbar-icon\"]")
    WebElement userIcon;
    @FindBy(xpath = "//a[@class=\"btn btn-link btn-sm\"]")
    WebElement buttonNewAccount;



    public EmagHomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        action = new Actions(driver);

    }

    public void locateMyAccount() {
        action.moveToElement(userIcon);
    }

    public void clickNewAccount() {
        buttonNewAccount.click();
    }

}
