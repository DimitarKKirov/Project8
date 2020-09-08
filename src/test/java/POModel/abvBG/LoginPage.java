package POModel.abvBG;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

    WebDriver driver;


//div/i[@Class='material-icons-outlined doneAll action-icon']  //*[@id="leftSide"]/a[2]/strong

    @FindBy(how = How.LINK_TEXT, using = "Click here to access your email.")
    WebElement accessEmailPage;
    @FindBy(how=How.LINK_TEXT,using="need an account?")
    WebElement accountRegistration;
    public void goToEmailPage() {
        accessEmailPage.click();
    }


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    public void goToRegistration(){
        accountRegistration.click();
    }
}