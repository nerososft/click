package org.nero.click.data.dto.volcano;

import java.io.Serializable;

/**
 * Created by Whishou on 2017/4/9.
 * Email: whishoutan@gmail.com
 */
public class VolcanoPoint implements Serializable {
    private String geneName;
    private double x;
    private double y;
    private String pvalue;

    public String getGeneName() {
        return geneName;
    }

    public void setGeneName(String geneName) {
        this.geneName = geneName;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public String getPvalue() {
        return pvalue;
    }

    public void setPvalue(String pvalue) {
        this.pvalue = pvalue;
    }

    public VolcanoPoint() {
    }

    public VolcanoPoint(String geneName, double x, double y) {
        this.geneName = geneName;
        this.x = x;
        this.y = y;
    }

    public VolcanoPoint(String geneName, double x, double y, String pvalue) {
        this.geneName = geneName;
        this.x = x;
        this.y = y;
        this.pvalue = pvalue;
    }

    @Override
    public String toString() {
        return "VolcanoPoint{" +
                "geneName='" + geneName + '\'' +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}