package SQLProject.PropertiReader;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class PropertiesReader {

    public void readerConnector(String s) {
        Connection con = null;
        PreparedStatement prep = null;
        ResultSet set = null;
        try {
            Properties tempProp = new Properties();
            //enter full path
            tempProp.load(new FileInputStream(s));
            String user = tempProp.getProperty("username");
            String pass = tempProp.getProperty("password");
            String url = tempProp.getProperty("dburl");

            con = DriverManager.getConnection(url, user, pass);

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }

    }

    public void changeBrowser(String s) {

        try {
            Properties tempProp = new Properties();
            //enter full path
            tempProp.load(new FileInputStream(s));
            String user = tempProp.getProperty("browserName");
            String pass = tempProp.getProperty("browserDriver");
            String url = tempProp.getProperty("browserProps");


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
