package org.click.admin.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Author :  root
 * Email  :  nerosoft@outlook.com
 * Date   :  16-11-13
 * Time   :  下午5:31
 */
public class Resource implements Serializable {
    private long resourceId;
    private String filename;
    private String filepath;
    private String hashCode;
    private String fileSize;
    private String fileFormat;
    private long uploaderId;
    private Date uploadTime;

    public Resource() {
    }

    public Resource(String filename, String filepath, String hashCode, String fileSize, String fileFormat, long uploaderId, Date uploadTime, long resourceId) {
        this.filename = filename;
        this.filepath = filepath;
        this.hashCode = hashCode;
        this.fileSize = fileSize;
        this.fileFormat = fileFormat;
        this.uploaderId = uploaderId;
        this.uploadTime = uploadTime;
        this.resourceId = resourceId;
    }

    public long getResourceId() {
        return resourceId;
    }

    public void setResourceId(long resourceId) {
        this.resourceId = resourceId;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public String getHashCode() {
        return hashCode;
    }

    public void setHashCode(String hashCode) {
        this.hashCode = hashCode;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileFormat() {
        return fileFormat;
    }

    public void setFileFormat(String fileFormat) {
        this.fileFormat = fileFormat;
    }

    public long getUploaderId() {
        return uploaderId;
    }

    public void setUploaderId(long uploaderId) {
        this.uploaderId = uploaderId;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "resourceId=" + resourceId +
                ", filename='" + filename + '\'' +
                ", filepath='" + filepath + '\'' +
                ", hashCode='" + hashCode + '\'' +
                ", fileSize='" + fileSize + '\'' +
                ", fileFormat='" + fileFormat + '\'' +
                ", uploaderId=" + uploaderId +
                ", uploadTime=" + uploadTime +
                '}';
    }
}
