package Browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.Set;

public class Browsers implements DriverSwitch {

    private static WebDriver driver;
    private static String nextTab;
    private static String browserName;
    private static String browserDriver;
    private static String browserProperty;
    private ChromeOptions chromeOptions= new ChromeOptions();


    private static void setDriver(WebDriver driver) {
        Browsers.driver = driver;
    }

    private static void changeBrowser(String s) {
        String path = null;

        try {
            if (s.equalsIgnoreCase("Chrome")) {
                path = chrome;
            } else {
                path = fireFox;
            }


            Properties tempProp = new Properties();
            tempProp.load(new FileInputStream(path));
            browserName = tempProp.getProperty("browserName");
            browserDriver = tempProp.getProperty("browserDriver");
            browserProperty = tempProp.getProperty("browserProps");


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void test() {
        {
            try {
                chromeOptions.setCapability("browserVersion", "67");
                chromeOptions.setCapability("platformName", "Windows 10");
                driver = new RemoteWebDriver(new URL("http://localhost:8888/grid/console"), chromeOptions);
                driver.get("excite.com");
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
    }
    public static WebDriver startBrowser(String url, String browserName) {
        changeBrowser(browserName);
        if (browserName.equalsIgnoreCase("Chrome")) {
            System.setProperty(browserProperty, browserDriver);
            driver = new ChromeDriver();

        } else if (browserName.equalsIgnoreCase("FireFox")) {
            System.setProperty(browserProperty, browserDriver);
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.get(url);
        setDriver(driver);
        return driver;

    }

    public static String switchToNextTab(WebDriver driver) {
        //getting all windows
        Set handler = driver.getWindowHandles();

        //getting the current window name
        String currentTab = driver.getWindowHandle();

        //removing the current window from the Set
        handler.remove(currentTab);

        Object secondTab = handler.iterator().next();
        if (currentTab != secondTab) {
            nextTab = (String) secondTab;

        }
        return nextTab;
    }

    public void switchToIframe(String s) {
        driver.switchTo().frame(s);
    }

    public void parentFrame() {
        driver.switchTo().parentFrame();
    }


}
