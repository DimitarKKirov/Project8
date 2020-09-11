package POModel.LillyWebShop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LillyLogInPage {
    WebDriver driver;


    @FindBy(how = How.LINK_TEXT, using = "Вход")
    WebElement enterLoginPage;
    @FindBy(id = "email")
    WebElement enterEmail;
    @FindBy(id = "pass")
    WebElement enterPass;
    @FindBy(id = "send2")
    WebElement buttonLogIn;



    public LillyLogInPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }


    public void clickLogin() {
        enterLoginPage.click();
    }

    public void enterEmail(String userEmail) {
        enterEmail.sendKeys(userEmail);
    }

    public void enterPass(String userPass) {
        enterPass.sendKeys(userPass);
    }

    public void presLogIn() {
        buttonLogIn.click();
    }

}
