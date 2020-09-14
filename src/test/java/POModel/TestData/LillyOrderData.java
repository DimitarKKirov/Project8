package POModel.TestData;

public class LillyOrderData {


    public String name;
    public String lastName;
    public String phone;
    public String city;
//    public String country;
    public String office;


    public LillyOrderData(String name, String lastName,
                          String city, String office, String phone) {
        this.city = city;
//        this.country = country;
        this.name = name;
        this.lastName = lastName;
        this.office = office;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getCity() {
        return city;
    }

//    public String getCountry() {
//        return country;
//    }

    public String getOffice() {
        return office;
    }
}
