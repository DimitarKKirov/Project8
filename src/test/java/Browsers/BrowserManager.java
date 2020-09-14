package Browsers;

public class BrowserManager {

   private BrowserDrivers browserDrivers;

    public BrowserManager() {
    }


    public BrowserDrivers browserDrivers() {
        if (browserDrivers == null) {
            browserDrivers = new BrowserDrivers();
            return browserDrivers;
        } else {
            return browserDrivers;
        }
    }

}
