package Browsers;

import POModel.ContextSharing;
import POModel.TestData.EmagGmailUserData;
import POModel.TestData.EmagUserDetails;
import io.cucumber.messages.internal.com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class EmagGmailDataReader {
    private final String emagGUserD = ContextSharing.getContext().jsonPathManager().emag("emagGUserDetails");
    private List<EmagGmailUserData> emagUserDetails;

    public EmagGmailDataReader() {
        emagUserDetails = getEmagGmailDataReader();
    }

    private List<EmagGmailUserData> getEmagGmailDataReader() {
        Gson gson = new Gson();
        BufferedReader bReader = null;
        try {
            bReader = new BufferedReader(new FileReader(emagGUserD));
            EmagGmailUserData[] data = gson.fromJson(bReader, EmagGmailUserData[].class);
            return Arrays.asList(data);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                assert bReader != null;
                bReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public final EmagGmailUserData getGEmail(String email) {
        return emagUserDetails.stream().filter(x -> x.email.equalsIgnoreCase(email)).findAny().get();
    }
    public final EmagGmailUserData getGPassword(String pass) {
        return emagUserDetails.stream().filter(x -> x.password.equalsIgnoreCase(pass)).findAny().get();
    }
}
