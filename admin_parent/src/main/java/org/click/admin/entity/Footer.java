package org.click.admin.entity;

import java.io.Serializable;

/**
 * Created by root on 16-11-5.
 */
public class Footer implements Serializable {
    private  String label;

    public Footer() {
    }

    public Footer(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "Footer{" +
                "label='" + label + '\'' +
                '}';
    }
}
