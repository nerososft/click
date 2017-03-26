package org.nero.click.sso.dto;

import java.io.Serializable;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/3/10
 * Time   上午10:20
 */
public class AccessInfo implements Serializable {



    private Long   id;
    private String appkey;
    private String appsecretkey;
    private String feedbackurl;
    private String appname;
    private String appavatar;
    private String expir;
    private String ctime;

    public AccessInfo() {
    }

    public AccessInfo(Long id, String appkey, String appsecretkey, String feedbackurl, String appname, String appavatar, String expir, String ctime) {
        this.id = id;
        this.appkey = appkey;
        this.appsecretkey = appsecretkey;
        this.feedbackurl = feedbackurl;
        this.appname = appname;
        this.appavatar = appavatar;
        this.expir = expir;
        this.ctime = ctime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAppkey() {
        return appkey;
    }

    public void setAppkey(String appkey) {
        this.appkey = appkey;
    }

    public String getAppsecretkey() {
        return appsecretkey;
    }

    public void setAppsecretkey(String appsecretkey) {
        this.appsecretkey = appsecretkey;
    }

    public String getFeedbackurl() {
        return feedbackurl;
    }

    public void setFeedbackurl(String feedbackurl) {
        this.feedbackurl = feedbackurl;
    }

    public String getAppname() {
        return appname;
    }

    public void setAppname(String appname) {
        this.appname = appname;
    }

    public String getAppavatar() {
        return appavatar;
    }

    public void setAppavatar(String appavatar) {
        this.appavatar = appavatar;
    }

    public String getExpir() {
        return expir;
    }

    public void setExpir(String expir) {
        this.expir = expir;
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }

    @Override
    public String toString() {
        return "AccessInfo{" +
                "id=" + id +
                ", appkey='" + appkey + '\'' +
                ", appsecretkey='" + appsecretkey + '\'' +
                ", feedbackurl='" + feedbackurl + '\'' +
                ", appname='" + appname + '\'' +
                ", appavatar='" + appavatar + '\'' +
                ", expir='" + expir + '\'' +
                ", ctime='" + ctime + '\'' +
                '}';
    }
}
