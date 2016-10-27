package org.nero.click.entity;

/**
 * author： nero
 * email: nerosoft@outlook.com
 * data: 16-10-6
 * time: 下午4:58.
 */
public class Propgbmn {
    private String propertyID;
    private String x;
    private String y;
    private String yLog;
    private String sampleID;
    private String value;
    private String valueLog;


    public String getPropertyID() {
        return propertyID;
    }

    public void setPropertyID(String propertyID) {
        this.propertyID = propertyID;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    public String getyLog() {
        return yLog;
    }

    public void setyLog(String yLog) {
        this.yLog = yLog;
    }

    public String getSampleID() {
        return sampleID;
    }

    public void setSampleID(String sampleID) {
        this.sampleID = sampleID;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValueLog() {
        return valueLog;
    }

    public void setValueLog(String valueLog) {
        this.valueLog = valueLog;
    }


    public Propgbmn() {
    }

    public Propgbmn(String propertyID, String x, String y, String yLog, String sampleID, String value, String valueLog) {
        this.propertyID = propertyID;
        this.x = x;
        this.y = y;
        this.yLog = yLog;
        this.sampleID = sampleID;
        this.value = value;
        this.valueLog = valueLog;
    }


    @Override
    public String toString() {
        return "Propgbmn{" +
                "propertyID='" + propertyID + '\'' +
                ", x='" + x + '\'' +
                ", y='" + y + '\'' +
                ", yLog='" + yLog + '\'' +
                ", sampleID='" + sampleID + '\'' +
                ", value='" + value + '\'' +
                ", valueLog='" + valueLog + '\'' +
                '}';
    }
}
