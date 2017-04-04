package org.nero.click.data.entity;


import java.io.Serializable;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/1/21
 * Time   上午12:21
 */
public class MoutainData implements Serializable {

    private Long geneid;
    private String cancertype;
    private Double mid;
    private Double mean;


    public MoutainData() {
    }

    public Long getGeneid() {
        return geneid;
    }

    public void setGeneid(Long geneid) {
        this.geneid = geneid;
    }

    public String getCancertype() {
        return cancertype;
    }

    public void setCancertype(String cancertype) {
        this.cancertype = cancertype;
    }

    public Double getMid() {
        return mid;
    }

    public void setMid(Double mid) {
        this.mid = mid;
    }

    public Double getMean() {
        return mean;
    }

    public void setMean(Double mean) {
        this.mean = mean;
    }

    @Override
    public String toString() {
        return "MoutainData{" +
                "geneid=" + geneid +
                ", cancertype='" + cancertype + '\'' +
                ", mid=" + mid +
                ", mean=" + mean +
                '}';
    }
}
