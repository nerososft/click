package org.nero.click.sso.dto;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2016/12/19
 * Time   上午2:36
 */
public class UserInfo implements Serializable {
    private long id;
    private String username;
    private String email;
    private String token;
    private String phone;
    private java.sql.Timestamp ctime;

    public UserInfo() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Timestamp getCtime() {
        return ctime;
    }

    public void setCtime(Timestamp ctime) {
        this.ctime = ctime;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", token='" + token + '\'' +
                ", phone='" + phone + '\'' +
                ", ctime=" + ctime +
                '}';
    }
}
