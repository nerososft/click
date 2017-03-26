package org.nero.click.data.dto.manhattan;

import java.io.Serializable;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/3/3
 * Time   下午2:21
 */
public class ManhattanPoint implements Serializable {
    private Integer geneId;
    private double x;
    private double y;
    private String sampleID;


    public ManhattanPoint() {
    }

    public Integer getGeneId() {
        return geneId;
    }

    public void setGeneId(Integer geneId) {
        this.geneId = geneId;
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

    public String getSampleID() {
        return sampleID;
    }

    public void setSampleID(String sampleID) {
        this.sampleID = sampleID;
    }

    @Override
    public String toString() {
        return "ManhattanPoint{" +
                "geneid='" + geneId + '\'' +
                ", x=" + x +
                ", y=" + y +
                ", sampleID='" + sampleID + '\'' +
                '}';
    }
}
