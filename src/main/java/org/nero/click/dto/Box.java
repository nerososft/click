package org.nero.click.dto;

/**
 * Created by nero on 2016/10/25 0025.
 */
public class Box {
    private float q1;
    private float d3;
    private float avg;
    private float mid;
    private float up;
    private float down;

    public Box() {
    }

    public float getQ1() {
        return q1;
    }

    public void setQ1(float q1) {
        this.q1 = q1;
    }

    public float getD3() {
        return d3;
    }

    public void setD3(float d3) {
        this.d3 = d3;
    }

    public float getAvg() {
        return avg;
    }

    public void setAvg(float avg) {
        this.avg = avg;
    }

    public float getMid() {
        return mid;
    }

    public void setMid(float mid) {
        this.mid = mid;
    }

    public float getUp() {
        return up;
    }

    public void setUp(float up) {
        this.up = up;
    }

    public float getDown() {
        return down;
    }

    public void setDown(float down) {
        this.down = down;
    }

    @Override
    public String toString() {
        return "Box{" +
                "q1=" + q1 +
                ", d3=" + d3 +
                ", avg=" + avg +
                ", mid=" + mid +
                ", up=" + up +
                ", down=" + down +
                '}';
    }
}
