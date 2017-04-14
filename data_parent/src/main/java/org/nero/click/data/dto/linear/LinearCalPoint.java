package org.nero.click.data.dto.linear;

import java.io.Serializable;

/**
 * Created by Whishou on 2017/4/4.
 * Email: whishoutan@gmail.com
 */
public class LinearCalPoint implements Serializable {
    private float y1;
    private float y2;
    private String sampleid;

    public float getY1() {
        return y1;
    }

    public void setY1(float y1) {
        this.y1 = y1;
    }

    public float getY2() {
        return y2;
    }

    public void setY2(float y2) {
        this.y2 = y2;
    }

    public String getSampleid() {
        return sampleid;
    }

    public void setSampleid(String sampleid) {
        this.sampleid = sampleid;
    }

    public LinearCalPoint(){

    }

    public LinearCalPoint(String sampleid) {
        this.sampleid = sampleid;
    }

    public LinearCalPoint(float y1, float y2, String sampleid) {
        this.y1 = y1;
        this.y2 = y2;
        this.sampleid= sampleid;
    }

    @Override
    public String toString() {
        return "LinearCalPoint{" +
                "y1=" + y1 +
                ", y2=" + y2 +
                ", sampleid='" + sampleid + '\'' +
                '}';
    }
}