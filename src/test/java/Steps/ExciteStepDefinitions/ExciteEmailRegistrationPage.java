package Steps.ExciteStepDefinitions;

import POModel.Excite.PageManagerExcite;
import POModel.Excite.RegistrationPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import static Browsers.Browsers.startBrowser;


enum BrowsersName {
    FIREFOX, CHROME
}

public class ExciteEmailRegistrationPage {
    WebDriver driver;
    RegistrationPage registration;

    @Given("user is on registration page")
    public void registrationPage() {
        BrowsersName name = BrowsersName.CHROME;
        driver = startBrowser("https://registration.excite.com/", name.name());

    }

    @When("user enters the necessary data in all fields")
    public void fillingTheFields() {
        PageManagerExcite regPage = new PageManagerExcite(driver);
        registration = regPage.registrationPage();
        registration.fieldsInput("Dimitar", "Kirov", "1/11/2000", "08956564321", "my@email.com", "Mladost 1", "none",
                "Sofia", "Sofia", "1000", "Bulgaria", "Dkk", "12345Ww", "12345Ww");

    }

    @When("user clicks complete registration")
    public void completeRegistration() {
        registration.completeRegButtonClick();
    }

    @Then("the user is redirected to the login page")
    public void loginPageLading() {
        String s = String.valueOf(driver.findElement(By.id("signup_button")).isEnabled());
        Assert.assertEquals("false", s);
        driver.quit();
    }
}
