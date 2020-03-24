package learn.lhb.pms.commons.dto;

import java.io.Serializable;

/**
 * @author 梁鸿斌
 * @date 2020/3/23.
 * @time 12:43
 */
public class LoginParam implements Serializable {


    private static final long serialVersionUID = -90000107L;

    private String username;
    private String password;

    @Override
    public String toString() {
        return "LoginParam{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

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
