package org.click.admin.entity;

/**
 * Author :  root
 * Email  :  nerosoft@outlook.com
 * Date   :  16-11-14
 * Time   :  下午8:48
 */
public class Module {
    private long   moudleId;
    private String moduleName;
    private String moduleDesc;
    private String moduleUrl;
    private String moduleImgUrl;

    public Module() {
    }

    public long getMoudleId() {
        return moudleId;
    }

    public void setMoudleId(long moudleId) {
        this.moudleId = moudleId;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getModuleDesc() {
        return moduleDesc;
    }

    public void setModuleDesc(String moduleDesc) {
        this.moduleDesc = moduleDesc;
    }

    public String getModuleUrl() {
        return moduleUrl;
    }

    public void setModuleUrl(String moduleUrl) {
        this.moduleUrl = moduleUrl;
    }

    public String getModuleImgUrl() {
        return moduleImgUrl;
    }

    public void setModuleImgUrl(String moduleImgUrl) {
        this.moduleImgUrl = moduleImgUrl;
    }

    @Override
    public String toString() {
        return "Module{" +
                "moudleId=" + moudleId +
                ", moduleName='" + moduleName + '\'' +
                ", moduleDesc='" + moduleDesc + '\'' +
                ", moduleUrl='" + moduleUrl + '\'' +
                ", moduleImgUrl='" + moduleImgUrl + '\'' +
                '}';
    }
}
