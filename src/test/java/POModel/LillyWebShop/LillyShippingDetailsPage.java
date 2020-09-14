package POModel.LillyWebShop;

import POModel.TestData.LillyOrderData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LillyShippingDetailsPage {

    private Actions action;

    // "//input[@class=\"select2-search__field\"]]" 142
    @FindBy(xpath = "//input[@name=\"firstname\"]")
    WebElement firstName;

    @FindBy(xpath = "//input[@name=\"lastname\"]")
    WebElement lastName;

    @FindBy(xpath = "//input[@name=\"telephone\"]")
    WebElement phone;

    @FindBy(xpath = "//span[@data-select2-id=\"2\"]")
    WebElement cityDropDown;

    @FindBy(className = "select2-search__field")
    WebElement enterCity;

    @FindBy(className = "select2-results")
    WebElement resultOfCitySearch;

    @FindBy(xpath = "//span[@data-select2-id=\"4\"]")
    WebElement deliveryOffice;
    @FindBy(xpath = "//li[@data-select2-id=\"11\"]")
    WebElement clickFirstEntryOfResult;
    @FindBy(className = "select2-search__field")
    WebElement enterOffice;
    @FindBy(xpath = "//li[@data-select2-id=\"23\"]")
    WebElement selectFirstEntryForReturnedResult;

    @FindBy(name = "custom_attributes[stenik_addrcarrier_other]")
    WebElement enterAddress;

    @FindBy(xpath = "//input[@id=\"sadc_5f5e40a9670681\"]")
    WebElement whereToDeliverOffice;

    @FindBy(xpath = "//input[@id=\"sadc_5f5e40a9670682\"]")
    WebElement whereToDeliverHome;

    @FindBy(xpath = "//input[@id=\"customer_invoice-customer_invoice\"]")
    WebElement invoice;
    @FindBy(xpath = "//button[@class=\"button action continue primary\"]")
    WebElement buttonForward;
    @FindBy(xpath = "//*[text()=\"Начин на плащане\"]")
    WebElement pageTitle;

    public LillyShippingDetailsPage(WebDriver driver) {
        action = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    public void enterFirsName(String name) {
        firstName.sendKeys(name);
    }

    public void enterLastName(String lName) {
        lastName.sendKeys(lName);
    }

    public void enterPhone(String phoneNumber) {
        phone.click();
        phone.sendKeys(phoneNumber);
    }

    public void cityClick() {
        cityDropDown.click();
        enterCity.click();

    }

    public void enterCity(String city) {
        enterCity.sendKeys(city);


    }

    public void clickResultOfCity() {
        clickFirstEntryOfResult.click();
    }

    public void deliveryAddressClick() {
        deliveryOffice.click();
        enterOffice.click();

    }

    public void enterDeliveryAddress(String addressOfDelivery) {
        enterOffice.sendKeys(addressOfDelivery);
    }

    public void clickFirstEntryForResult() {
        selectFirstEntryForReturnedResult.click();
    }

    public void presForward() {
        buttonForward.click();
    }
    public String getPageOrderTitle(){
       return pageTitle.getText();
    }

    public void fillingFromJson(LillyOrderData data) {
        try {
//        enterFirsName(data.getName());
//        enterLastName(data.getLastName());
            enterPhone(data.getPhone());
            cityClick();
            enterCity(data.getCity());
            Thread.sleep(2000);
            clickResultOfCity();
            deliveryAddressClick();
            enterDeliveryAddress(data.getOffice());
            Thread.sleep(2000);
            clickFirstEntryForResult();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
