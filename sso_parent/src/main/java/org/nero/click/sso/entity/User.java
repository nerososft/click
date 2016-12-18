package org.nero.click.sso.entity;

import java.io.Serializable;

/**
 * author： nero
 * email: nerosoft@outlook.com
 * data: 16-10-1
 * time: 下午2:14.
 */
public class User  implements Serializable{

    private long id;
    private String username;
    private String email;
    private String token;
    private String phone;
    private java.sql.Timestamp ctime;
    private int isactive;
    private String password;

    public User(String password, String phone, String token, String email, String username) {
        this.password = password;
        this.phone = phone;
        this.token = token;
        this.email = email;
        this.username = username;
    }

    @Override
    public String toString() {
        return String.format("User{id=%d, username='%s', email='%s', token='%s', phone='%s', password='%s', ctime=%s, isactive=%d}", new Object[]{id, username, email, token, phone, password, ctime, isactive});
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public User() {
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

    public java.sql.Timestamp getCtime() {
        return ctime;
    }

    public void setCtime(java.sql.Timestamp ctime) {
        this.ctime = ctime;
    }

    public int getIsactive() {
        return isactive;
    }

    public void setIsactive(int isactive) {
        this.isactive = isactive;
    }

}
