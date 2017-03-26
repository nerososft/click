package org.nero.click.data.entity;

import java.io.Serializable;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/3/3
 * Time   下午1:31
 */
public class SimpleGene implements Serializable {
    private Long ID;
    private String ucStart;

    public SimpleGene() {
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getucStart() {
        return ucStart;
    }

    public void setucStart(String ucStart) {
        this.ucStart = ucStart;
    }

    @Override
    public String toString() {
        return "SimpleGene{" +
                "ID=" + ID +
                ", ucStart='" + ucStart + '\'' +
                '}';
    }
}
