package org.nero.click.data.entity;

import java.io.Serializable;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/3/26
 * Time   下午3:24
 */
public class PGene implements Serializable {
    private Long id;
    private String ucStart;
    private String pvalue;

    public PGene() {
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


    @Override
    public String toString() {
        return "PGene{" +
                "id=" + id +
                ", ucStart='" + ucStart + '\'' +
                ", pvalue='" + pvalue + '\'' +
                '}';
    }
}
