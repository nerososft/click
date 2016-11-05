package org.click.admin.entity;

import java.io.Serializable;

/**
 * Created by root on 16-11-5.
 */
public class Header implements Serializable {

    private String title;
    private String label;

    public Header() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "Header{" +
                "title='" + title + '\'' +
                ", label='" + label + '\'' +
                '}';
    }
}
