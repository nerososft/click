package org.nero.click.data.dto.moutain;

import org.nero.click.data.dto.Point;

import java.io.Serializable;
import java.util.List;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/1/20
 * Time   上午12:18
 */
public class Moutain implements Serializable {
    private List<List<MPoint>> point;
    private List<Cyto> cyto;
    private Arm arm;

    public Moutain(List<List<MPoint>> point, List<Cyto> cyto, Arm arm) {
        this.point = point;
        this.cyto = cyto;
        this.arm = arm;
    }

    public List<List<MPoint>> getPoint() {
        return point;
    }

    public void setPoint(List<List<MPoint>> point) {
        this.point = point;
    }

    public List<Cyto> getCyto() {
        return cyto;
    }

    public void setCyto(List<Cyto> cyto) {
        this.cyto = cyto;
    }

    public Arm getArm() {
        return arm;
    }

    public void setArm(Arm arm) {
        this.arm = arm;
    }

    @Override
    public String toString() {
        return "Moutain{" +
                "point=" + point +
                ", cyto=" + cyto +
                ", arm=" + arm +
                '}';
    }
}
