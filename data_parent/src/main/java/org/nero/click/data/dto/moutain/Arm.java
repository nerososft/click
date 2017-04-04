package org.nero.click.data.dto.moutain;

import java.io.Serializable;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/1/20
 * Time   上午12:16
 */
public class Arm implements Serializable {

    private Long x;


    public Arm(Long x) {
        this.x = x;
    }

    public Long getX() {
        return x;
    }

    public void setX(Long x) {
        this.x = x;
    }


    @Override
    public String toString() {
        return "Arm{" +
                "x=" + x +
                '}';
    }
}
