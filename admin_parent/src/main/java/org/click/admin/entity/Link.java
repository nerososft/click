package org.click.admin.entity;

import java.io.Serializable;

/**
 * Created by root on 16-11-5.
 */
public class Link implements Serializable{
    private Long id;
    private String name;
    private String hrefUrl;

    public Link() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHrefUrl() {
        return hrefUrl;
    }

    public void setHrefUrl(String hrefUrl) {
        this.hrefUrl = hrefUrl;
    }

    @Override
    public String toString() {
        return "Link{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hrefUrl='" + hrefUrl + '\'' +
                '}';
    }
}
