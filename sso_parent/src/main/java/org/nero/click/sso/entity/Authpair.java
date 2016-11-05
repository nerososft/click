package org.nero.click.sso.entity;

import java.io.Serializable;

/**
 * author： nero
 * email: nerosoft@outlook.com
 * data: 16-10-1
 * time: 下午2:34.
 */
public final class Authpair implements Serializable {
    private String email;
    private String password;

    public Authpair(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Authpair() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Authpair{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
