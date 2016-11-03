package org.nero.click.admin.dto;


/**
 * Author nero
 * Date   2016/10/20 0020
 * Time   23:15
 * Email  nerosoft@outlook.com
 */
public class MoutainPoint {
    private float x;
    private Float avgGBMn;
    private String geneName;


    @Override
    public String toString() {
        return "["+ avgGBMn + "," + geneName + "," + x +']';
    }

    public MoutainPoint() {
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public Float getAvgGBMn() {
        return avgGBMn;
    }

    public void setAvgGBMn(Float avgGBMn) {
        this.avgGBMn = avgGBMn;
    }

    public String getGeneName() {
        return geneName;
    }

    public void setGeneName(String geneName) {
        this.geneName = geneName;
    }

}
