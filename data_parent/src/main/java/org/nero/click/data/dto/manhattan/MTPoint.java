package org.nero.click.data.dto.manhattan;

import java.io.Serializable;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/3/7
 * Time   下午6:19
 */
public class MTPoint implements Serializable {
    private String x;
    private Double y;
    private String geneId;

    public MTPoint() {
    }

    public MTPoint(String x, Double y, String geneId) {
        this.x = x;
        this.y = y;
        this.geneId = geneId;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public String getGeneId() {
        return geneId;
    }

    public void setGeneId(String geneId) {
        this.geneId = geneId;
    }

    @Override
    public String toString() {
        return "MTPoint{" +
                "x='" + x + '\'' +
                ", y=" + y +
                ", geneId='" + geneId + '\'' +
                '}';
    }
}
