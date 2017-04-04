package org.nero.click.sso.dto;

import java.sql.Date;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2016/12/19
 * Time   上午1:18
 */
public class Application {

    private String appName;

    private String appOrganization;

    private String appPrevilige;

    private String appLogoUrl;

    private Date appCreateTime;

    public Application() {
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppOrganization() {
        return appOrganization;
    }

    public void setAppOrganization(String appOrganization) {
        this.appOrganization = appOrganization;
    }

    public String getAppPrevilige() {
        return appPrevilige;
    }

    public void setAppPrevilige(String appPrevilige) {
        this.appPrevilige = appPrevilige;
    }

    public String getAppLogoUrl() {
        return appLogoUrl;
    }

    public void setAppLogoUrl(String appLogoUrl) {
        this.appLogoUrl = appLogoUrl;
    }

    public Date getAppCreateTime() {
        return appCreateTime;
    }

    public void setAppCreateTime(Date appCreateTime) {
        this.appCreateTime = appCreateTime;
    }

    @Override
    public String toString() {
        return "Application{" +
                "appName='" + appName + '\'' +
                ", appOrganization='" + appOrganization + '\'' +
                ", appPrevilige='" + appPrevilige + '\'' +
                ", appLogoUrl='" + appLogoUrl + '\'' +
                ", appCreateTime=" + appCreateTime +
                '}';
    }
}
