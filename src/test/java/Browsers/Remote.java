package Browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

//import static Browsers.BrowserDrivers.startBrowser;

public class Remote {
    ChromeOptions chromeOptions= new ChromeOptions();
    WebDriver driver;

    public void test() {
        {
            try {
                chromeOptions.setCapability("browserVersion", "67");
                chromeOptions.setCapability("platformName", "Windows 10");
                driver = new RemoteWebDriver(new URL("gcity.zapto.org"), chromeOptions);
                driver.get("excite.com");
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
//
//        Remote remote= new Remote(startBrowser("excite.com","chrome"));
//        remote.test();
    }
    public  Remote(WebDriver driver){
        this.driver=driver;
    }
}

