package org.nero.click.data.entity.beeswarm;

/**
 * Author nero
 * Date   2016/10/16 0016
 * Time   19:29
 * Email  nerosoft@outlook.com
 */
public class Genep {
    private long geneid;
    private String genename;

    public Genep(long geneid, String genename) {
        this.geneid = geneid;
        this.genename = genename;
    }

    public long getGeneid() {
        return geneid;
    }

    public void setGeneid(long geneid) {
        this.geneid = geneid;
    }

    public String getGenename() {
        return genename;
    }

    public void setGenename(String genename) {
        this.genename = genename;
    }

    @Override
    public String toString() {
        return "Genep{" +
                "geneid=" + geneid +
                ", genename='" + genename + '\'' +
                '}';
    }
}
