package api.helpers;

public class UserHelper {
    private final String email;
    private final String password;
    private final String name;

    public UserHelper(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }

    // Getters
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }
}

