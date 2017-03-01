package org.nero.click.data.entity;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/1/19
 * Time   下午1:03
 */
public class Gene {
    private Long ID;
    private String geneName;
    private String ucChrom;
    private Long ucStart;
    private Long ucStop;
    private String ucCyto;
    private String unArm;


    public Gene() {
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getGeneName() {
        return geneName;
    }

    public void setGeneName(String geneName) {
        this.geneName = geneName;
    }

    public String getUcChrom() {
        return ucChrom;
    }

    public void setUcChrom(String ucChrom) {
        this.ucChrom = ucChrom;
    }

    public Long getUcStart() {
        return ucStart;
    }

    public void setUcStart(Long ucStart) {
        this.ucStart = ucStart;
    }

    public Long getUcStop() {
        return ucStop;
    }

    public void setUcStop(Long ucStop) {
        this.ucStop = ucStop;
    }

    public String getUcCyto() {
        return ucCyto;
    }

    public void setUcCyto(String ucCyto) {
        this.ucCyto = ucCyto;
    }

    public String getUnArm() {
        return unArm;
    }

    public void setUnArm(String unArm) {
        this.unArm = unArm;
    }


    @Override
    public String toString() {
        return "Gene{" +
                "ID=" + ID +
                ", geneName='" + geneName + '\'' +
                ", ucChrom='" + ucChrom + '\'' +
                ", ucStart=" + ucStart +
                ", ucStop=" + ucStop +
                ", ucCyto='" + ucCyto + '\'' +
                ", unArm='" + unArm + '\'' +
                '}';
    }
}
