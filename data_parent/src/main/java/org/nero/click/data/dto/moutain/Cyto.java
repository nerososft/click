package org.nero.click.data.dto.moutain;

import java.io.Serializable;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/1/20
 * Time   上午12:13
 */
public class Cyto implements Serializable {

    private Long start;
    private String cyto;

    public Cyto() {
    }

    public Long getStart() {
        return start;
    }

    public void setStart(Long start) {
        this.start = start;
    }

    public String getCyto() {
        return cyto;
    }

    public void setCyto(String cyto) {
        this.cyto = cyto;
    }


    @Override
    public String toString() {
        return "Cyto{" +
                "start=" + start +
                ", cyto='" + cyto + '\'' +
                '}';
    }

    public Cyto(Long start, String cyto) {
        this.start = start;
        this.cyto = cyto;
    }
}
