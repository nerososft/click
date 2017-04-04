package org.nero.click.data.entity;

import java.io.Serializable;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/4/4
 * Time   下午11:36
 */
public class DGene implements Serializable {
    private Long id;
    private String ucStart;
    private String pvalue;
    private Double men;
    private Double met;

    public DGene() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUcStart() {
        return ucStart;
    }

    public void setUcStart(String ucStart) {
        this.ucStart = ucStart;
    }

    public String getPvalue() {
        return pvalue;
    }

    public void setPvalue(String pvalue) {
        this.pvalue = pvalue;
    }

    public Double getMen() {
        return men;
    }

    public void setMen(Double men) {
        this.men = men;
    }

    public Double getMet() {
        return met;
    }

    public void setMet(Double met) {
        this.met = met;
    }

    @Override
    public String toString() {
        return "DGene{" +
                "id=" + id +
                ", ucStart='" + ucStart + '\'' +
                ", pvalue='" + pvalue + '\'' +
                ", men=" + men +
                ", met=" + met +
                '}';
    }
}
