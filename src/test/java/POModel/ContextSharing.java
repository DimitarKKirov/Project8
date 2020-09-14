package POModel;

import Browsers.BrowserManager;
import Browsers.ContextType;
import Browsers.DataManager;
import Browsers.JsonPathManager;
import org.openqa.selenium.WebDriver;

public class ContextSharing {
    private static final ContextSharing context = new ContextSharing();

    private PageManager pageManager;
    private BrowserManager browserManager;
    private ContextSharing contextSharing;
    private JsonPathManager jsonPathManager;
    private DataManager dataManager;

    public static ContextSharing getContext() {
        return context;
    }

    public PageManager pageManager(WebDriver driver) {
        if (pageManager == null) {
            pageManager = new PageManager(driver);
            return pageManager;
        } else {
            return pageManager;
        }
    }

    public BrowserManager browserManager() {
        if (browserManager == null) {
            browserManager = new BrowserManager();
            return browserManager;
        } else {
            return browserManager;
        }
    }
    public ContextSharing contextSharing() {
        if (contextSharing == null) {
            contextSharing = new ContextSharing();
            return contextSharing;
        } else {
            return contextSharing;
        }
    }
    public JsonPathManager jsonPathManager() {
        if (jsonPathManager == null) {
            jsonPathManager = new JsonPathManager();
            return jsonPathManager;
        } else {
            return jsonPathManager;
        }
    }
    public DataManager dataManager() {
        if (dataManager == null) {
            dataManager = new DataManager();
            return dataManager;
        } else {
            return dataManager;
        }
    }
}
