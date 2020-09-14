package POModel.Emag;

import Browsers.EmagGmailDataReader;
import POModel.TestData.EmagGmailUserData;
import POModel.TestData.EmagUserDetails;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmagLogIn {


    @FindBy(xpath = "//a[text()=\"влез в акаунт\"]")
    WebElement loginButton;
    @FindBy(linkText = "Google")
    WebElement loginWithGoogle;
@FindBy(xpath = "//input[@id=\"identifierId\"]")
WebElement enterGmail;
@FindBy(name = "password")
WebElement enterGPassword;
@FindBy(id = "identifierNext")
WebElement gmailContinue;
@FindBy(id = "passwordNext")
WebElement gmailPassContinue;

    public EmagLogIn(WebDriver driver){
        PageFactory.initElements(driver,this);

    }

    public void clickLogin(){
        loginButton.click();
    }

    public void clickGoogle(){
        loginWithGoogle.click();
    }
    public void enterGmailInGoogleLogin(String email){
        enterGmail.sendKeys(email);
    }
    public void enterGPass(String pass){
        enterGPassword.sendKeys(pass);
    }
    public void gMailContinue(){
        gmailContinue.click();
    }
    public void gMailPassContinue(){
        gmailPassContinue.click();
    }






    public void fillGmail(EmagGmailUserData details){
        enterGmailInGoogleLogin(details.getEmail());
        gMailContinue();
    }
    public void fillGmailPassword(EmagGmailUserData details){
            enterGPass(details.getEmail());
            gMailPassContinue();
    }
}
