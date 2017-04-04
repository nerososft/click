package org.nero.click.data.dto.moutain;

import java.io.Serializable;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/1/19
 * Time   下午11:41
 */
public class MPoint implements Serializable {

    private String geneName;
    private Long x;
    private Double value;


    public MPoint() {
    }


    public String getGeneName() {
        return geneName;
    }

    public void setGeneName(String geneName) {
        this.geneName = geneName;
    }

    public Long getX() {
        return x;
    }

    public void setX(Long x) {
        this.x = x;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }


    @Override
    public String toString() {
        return "MPoint{" +
                "geneName='" + geneName + '\'' +
                ", x=" + x +
                ", value=" + value +
                '}';
    }

    public MPoint(String geneName, Long x, Double value) {
        this.geneName = geneName;
        this.x = x;
        this.value = value;
    }
}
