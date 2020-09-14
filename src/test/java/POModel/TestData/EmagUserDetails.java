package POModel.TestData;

public class EmagUserDetails {
    private String fullName;
    private String password1;
    public String password;
    public String email;
    public EmagUserDetails(String fullName, String password1,String email,String password) {
        this.fullName = fullName;
        this.password1 = password1;
        this.email=email;
        this.password=password;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPassword1() {
        return password1;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
