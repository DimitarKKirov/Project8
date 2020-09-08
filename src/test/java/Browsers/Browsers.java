package Browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class Browsers {

    private static WebDriver driver;
    private static String nextTab;
    private static String browserName;
    private static String browserDriver;
    private static String browserProperty;
    private static final String path="C:\\Users\\Admin\\IdeaProjects\\Git Project8\\Project8\\src\\test\\props\\Browsers.properties";


    private static void setDriver(WebDriver driver) {
        Browsers.driver = driver;
    }

    private static void changeBrowser(String s){

        try {
            Properties tempProp= new Properties();
            tempProp.load(new FileInputStream(s));
            browserName=tempProp.getProperty("browserName");
            browserDriver=tempProp.getProperty("browserDriver");
            browserProperty=tempProp.getProperty("browserProps");


        }catch ( IOException e){
            e.printStackTrace();
        }

    }

    public static WebDriver startBrowser(String url) {
        changeBrowser(path);
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
