package POModel.Excite;

import org.openqa.selenium.WebDriver;

public class PageManagerExcite {
    WebDriver driver;
    private LoginPage loginPage;
    private RegistrationPage registrationPage;

    public PageManagerExcite(WebDriver driver) {
        this.driver = driver;
    }

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
