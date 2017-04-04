package org.nero.click.data.dto.deflection;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/4/4
 * Time   下午10:25
 */
public class DPoint {
    private String geneId;
    private double y;

    public DPoint() {
    }

    public String getGeneId() {
        return geneId;
    }

    public void setGeneId(String geneId) {
        this.geneId = geneId;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "DPoint{" +
                "geneId='" + geneId + '\'' +
                ", y=" + y +
                '}';
    }
}
