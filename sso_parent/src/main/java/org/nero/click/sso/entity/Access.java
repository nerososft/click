package org.nero.click.sso.entity;

import java.io.Serializable;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2016/12/20
 * Time   下午3:34
 */
public class Access implements Serializable {


    private Long   id;
    private String appkey;
    private String appsecretkey;
    private String token;
    private String accesstoken;
    private String feedbackurl;
    private String appname;
    private String appavatar;
    private String isactive;
    private String expir;
    private String ctime;

    public Long getId() {
        return id;
    }

    public String getAppkey() {
        return appkey;
    }

    public String getAppsecretkey() {
        return appsecretkey;
    }

    public String getToken() {
        return token;
    }

    public String getAccesstoken() {
        return accesstoken;
    }

    public String getAppname() {
        return appname;
    }

    public String getAppavatar() {
        return appavatar;
    }

    public String getIsactive() {
        return isactive;
    }

    public String getExpir() {
        return expir;
    }

    public String getCtime() {
        return ctime;
    }

    public Access() {
    }

    public Access(Long id, String appkey, String appsecretkey, String token, String accesstoken, String feedbackurl, String appname, String appavatar, String isactive, String expir, String ctime) {
        this.id = id;
        this.appkey = appkey;
        this.appsecretkey = appsecretkey;
        this.token = token;
        this.accesstoken = accesstoken;
        this.feedbackurl = feedbackurl;
        this.appname = appname;
        this.appavatar = appavatar;
        this.isactive = isactive;
        this.expir = expir;
        this.ctime = ctime;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAppkey(String appkey) {
        this.appkey = appkey;
    }

    public void setAppsecretkey(String appsecretkey) {
        this.appsecretkey = appsecretkey;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setAccesstoken(String accesstoken) {
        this.accesstoken = accesstoken;
    }

    public void setAppname(String appname) {
        this.appname = appname;
    }

    public void setAppavatar(String appavatar) {
        this.appavatar = appavatar;
    }

    public void setIsactive(String isactive) {
        this.isactive = isactive;
    }

    public void setExpir(String expir) {
        this.expir = expir;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }

    public String getFeedbackurl() {
        return feedbackurl;
    }

    public void setFeedbackurl(String feedbackurl) {
        this.feedbackurl = feedbackurl;
    }

    @Override
    public String toString() {
        return "Access{" +
                "id=" + id +
                ", appkey='" + appkey + '\'' +
                ", appsecretkey='" + appsecretkey + '\'' +
                ", token='" + token + '\'' +
                ", accesstoken='" + accesstoken + '\'' +
                ", feedbackurl='" + feedbackurl + '\'' +
                ", appname='" + appname + '\'' +
                ", appavatar='" + appavatar + '\'' +
                ", isactive='" + isactive + '\'' +
                ", expir='" + expir + '\'' +
                ", ctime='" + ctime + '\'' +
                '}';
    }
}
