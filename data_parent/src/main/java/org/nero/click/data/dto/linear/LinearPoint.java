package org.nero.click.data.dto.linear;

import java.io.Serializable;

/**
 * Created by Whishou on 2017/4/4.
 * Email: whishoutan@gmail.com
 */
public class LinearPoint implements Serializable {
    private float y;
    private String sampleID;

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public String getSampleID() {
        return sampleID;
    }

    public void setSampleID(String sampleID) {
        this.sampleID = sampleID;
    }

    public LinearPoint(){
    }

    @Override
    public String toString() {
        return "LinearPoint{" +
                "y=" + y +
                ", sampleID='" + sampleID + '\'' +
                '}';
    }
}
