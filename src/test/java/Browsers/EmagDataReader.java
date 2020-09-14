package Browsers;

import POModel.ContextSharing;
import POModel.TestData.EmagUserDetails;
import io.cucumber.messages.internal.com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class EmagDataReader {
    private final String emagUserD = ContextSharing.getContext().jsonPathManager().emag("emagUserDetails");
    private List<EmagUserDetails> emagUserDetails;

    public EmagDataReader() {
        emagUserDetails = getEmagUserDetails();
    }

    private List<EmagUserDetails> getEmagUserDetails() {
        Gson gson = new Gson();
        BufferedReader bReader = null;
        try {
            bReader = new BufferedReader(new FileReader(emagUserD));
            EmagUserDetails[] data = gson.fromJson(bReader, EmagUserDetails[].class);
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

    public final EmagUserDetails getCustomerEmail(String email) {
        return emagUserDetails.stream().filter(x -> x.email.equalsIgnoreCase(email)).findAny().get();
    }
    public final EmagUserDetails getCustomerPassword(String pass) {
        return emagUserDetails.stream().filter(x -> x.password.equalsIgnoreCase(pass)).findAny().get();
    }
}
