package Browsers;

public class BrowserManager {
   private static final BrowserManager bManager = new BrowserManager();
   private static BrowserDrivers browserDrivers;

    private BrowserManager() {
    }
    public static BrowserManager getBManager(){
        return bManager;
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
