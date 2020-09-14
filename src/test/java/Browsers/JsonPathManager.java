package Browsers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class JsonPathManager implements JsonPath {



    public String jsonProperties(String s) {
        String a = null;
        try {
            Properties tempProp = new Properties();

            tempProp.load(new FileInputStream(JsonPath));
            a = tempProp.getProperty(s);
            return a;
        } catch (
                IOException e) {
            e.printStackTrace();
        }

        return a;
    }

    public String emag(String s) {
        String a = null;
        try {
            Properties tempProp = new Properties();

            tempProp.load(new FileInputStream(EmagUserDetails));
            a = tempProp.getProperty(s);
            return a;
        } catch (
                IOException e) {
            e.printStackTrace();
        }

        return a;
    }


}
