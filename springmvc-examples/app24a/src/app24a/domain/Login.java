package app24a.domain;

import java.io.Serializable;

public class Login  implements Serializable {
    private static final long serialVersionUID = -38L;

    private String userName;
    private String password;
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
