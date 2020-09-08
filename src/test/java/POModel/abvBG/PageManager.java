package POModel.abvBG;

import org.openqa.selenium.WebDriver;

public class PageManager {
    WebDriver driver;
    private LoginPage loginPage;
    private RegistrationPage registrationPage;



    public LoginPage loginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage(driver);
        }
        return loginPage;
    }

    public RegistrationPage registrationPage() {
        if (registrationPage == null) {
            registrationPage = new RegistrationPage(driver);
        }
        return registrationPage;
    }
}
