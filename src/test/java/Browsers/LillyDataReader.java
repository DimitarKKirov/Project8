package Browsers;

import POModel.ContextSharing;
import POModel.TestData.LillyOrderData;
import io.cucumber.messages.internal.com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;


public class LillyDataReader {

    private final String customerOrderData = ContextSharing.getContext().jsonPathManager().jsonProperties("lillyOrderData");

    private List<LillyOrderData> orderDetails;


    public LillyDataReader() {
        orderDetails = getOrderDetails();
    }


    private List<LillyOrderData> getOrderDetails() {
        Gson gson = new Gson();
        BufferedReader bReader = null;
        try {
            bReader = new BufferedReader(new FileReader(customerOrderData));
            LillyOrderData[] data = gson.fromJson(bReader, LillyOrderData[].class);
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

    public final LillyOrderData getCustomerByName(String customerName) {
        return orderDetails.stream().filter(x -> x.name.equalsIgnoreCase(customerName)).findAny().get();
    }


}

