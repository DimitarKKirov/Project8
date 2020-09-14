package POModel.Emag;

import POModel.TestData.EmagUserDetails;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmagNewUserLogin {



    @FindBy(xpath = "//label[@for=\"user_login_email\"]")
    WebElement textPageVerification;
    @FindBy(xpath = "//input[@id=\"user_login_email\"]")
    WebElement userLoginEmailTextField;
    @FindBy(xpath = "class=\"h2\"")
    WebElement textPage2Verification;
    @FindBy(xpath = "//input[@id=\"user_register_full_name\"]")
    WebElement userFullNameField;
    @FindBy(xpath = "//input[@id=\"user_register_password_first\"]")
    WebElement enterPasswordFirstField;
    @FindBy(id = "user_register_password_second")
    WebElement confirmPassword;
    @FindBy(id = "user_register_agree_terms")
    WebElement registerAgreeTerms;
    @FindBy(id = "user_register_subscribe_newsletter")
    WebElement newsLetter;
    @FindBy(name = "user_login[continue]")
    WebElement continueButton;
    @FindBy(name = "user_register[continue]")
    WebElement registerButton;


    public EmagNewUserLogin(WebDriver driver){
        PageFactory.initElements(driver,this);

    }

    public String pageVerification(){
       return textPageVerification.getText();
    }
    public String pageVerification2(){
        return textPage2Verification.getText();
    }
    public void enterEmail(String email){
        userLoginEmailTextField.sendKeys(email);
    }
    public void enterFullName(String fullName){
        userFullNameField.sendKeys(fullName);
    }
    public void enterPassword(String pass){
        enterPasswordFirstField.sendKeys(pass);
    }
    public void confirmPassword(String pass){
        confirmPassword.sendKeys(pass);
    }
    public void agreeToTerms(){
        registerAgreeTerms.click();
    }
    public void clickNewsLetter(){
        newsLetter.click();
    }
    public void clickContinue(){
        continueButton.click();
    }
    public void register(){
        registerButton.click();
    }

    public void fillEmail(EmagUserDetails details){
        enterEmail(details.getEmail());
        clickContinue();

    }
    public void fillNewUserRegFields(EmagUserDetails details){
        enterEmail(details.getEmail());
        enterFullName(details.getFullName());
        enterPassword(details.getPassword1());
        confirmPassword(details.getPassword1());
    }
}
