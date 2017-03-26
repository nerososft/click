package org.nero.click.sso.entity;

import java.io.Serializable;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2016/12/19
 * Time   上午1:08
 */
public class AccessRequest implements Serializable {

    private String appKey;
    private String SecretKey;
    private String time;
    private String hash;

    public AccessRequest() {
    }

    public AccessRequest(String appKey, String secretKey, String time, String hash) {
        this.appKey = appKey;
        SecretKey = secretKey;
        this.time = time;
        this.hash = hash;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getSecretKey() {
        return SecretKey;
    }

    public void setSecretKey(String secretKey) {
        SecretKey = secretKey;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    @Override
    public String toString() {
        return "AccessRequest{" +
                "appKey='" + appKey + '\'' +
                ", SecretKey='" + SecretKey + '\'' +
                ", time='" + time + '\'' +
                ", hash='" + hash + '\'' +
                '}';
    }
}
