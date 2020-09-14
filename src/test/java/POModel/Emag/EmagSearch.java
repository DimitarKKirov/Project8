package POModel.Emag;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmagSearch {

    @FindBy(id = "searchboxTrigger")
    WebElement searchField;
    @FindBy(xpath = "//i[@class=\"em em-search\"]")
    WebElement searchButton;


    public EmagSearch(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public void enterSearchCriteria(String item){
        searchField.sendKeys(item);

    }
    public void search(){
        searchButton.click();
    }
}
