package org.nero.click.sso.dto;

import java.io.Serializable;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2016/12/19
 * Time   上午1:02
 */
public class AccessToken implements Serializable {

    private Token token;

    private String expirationTime;

    public AccessToken() {
    }

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }

    public String getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(String expirationTime) {
        this.expirationTime = expirationTime;
    }

    @Override
    public String toString() {
        return "AccessToken{" +
                "token='" + token + '\'' +
                ", expirationTime='" + expirationTime + '\'' +
                '}';
    }
}
