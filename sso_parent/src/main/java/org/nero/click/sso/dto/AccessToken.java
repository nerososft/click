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

    private Long expirationTime;

    public AccessToken() {
    }

    public AccessToken(Token token){
        this.token = token;
    }

    public AccessToken(Token token, Long expirationTime) {
        this.token = token;
        this.expirationTime = expirationTime;
    }

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }

    public Long getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(Long expirationTime) {
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
