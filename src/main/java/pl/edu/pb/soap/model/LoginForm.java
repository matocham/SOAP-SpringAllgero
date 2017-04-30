package pl.edu.pb.soap.model;

import javax.validation.constraints.Size;

/**
 * Created by Mateusz on 29.04.2017.
 */
public class LoginForm {
    @Size(min = 5, max = 32)
    private String username;
    @Size(min = 5, max = 32)
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
