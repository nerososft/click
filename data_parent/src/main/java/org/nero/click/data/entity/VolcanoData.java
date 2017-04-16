package org.nero.click.data.entity;

import java.io.Serializable;

/**
 * Created by Whishou on 2017/4/9.
 * Email: whishoutan@gmail.com
 */
public class VolcanoData implements Serializable {
    private String geneName;
    private String met;
    private String men;
    private String pvalue;

    public String getGeneName() {
        return geneName;
    }

    public void setGeneName(String geneName) {
        this.geneName = geneName;
    }

    public String getMet() {
        return met;
    }

    public void setMet(String met) {
        this.met = met;
    }

    public String getMen() {
        return men;
    }

    public void setMen(String men) {
        this.men = men;
    }

    public String getPvalue() {
        return pvalue;
    }

    public void setPvalue(String pvalue) {
        this.pvalue = pvalue;
    }

    public VolcanoData() {
    }

    @Override
    public String toString() {
        return "VolcanoData{" +
                "geneName='" + geneName + '\'' +
                ", met='" + met + '\'' +
                ", men='" + men + '\'' +
                ", pvalue='" + pvalue + '\'' +
                '}';
    }
}
